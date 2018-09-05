package org.polarsys.chess.paramArchConfigurator.commands;

import java.io.File;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.NotEnabledException;
import org.eclipse.core.commands.NotHandledException;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;
import org.polarsys.chess.paramArchConfigurator.ui.wizard.InstantiateArchWizard;
import org.polarsys.chess.service.core.model.ChessSystemModel;
import org.polarsys.chess.service.gui.utils.SelectionUtil;

import eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.ui.services.OSSTranslatorServiceUI;
import eu.fbk.eclipse.standardtools.utils.ui.commands.AbstractJobCommand;
import eu.fbk.eclipse.standardtools.utils.ui.dialogs.MessageTimeModelDialog;
import eu.fbk.eclipse.standardtools.utils.ui.utils.CommandBuilder;
import eu.fbk.eclipse.standardtools.utils.ui.utils.OCRADirectoryUtil;

public class InstantiateArchitectureViaWizard extends AbstractJobCommand {

	Shell shell;
	private static final Logger logger = Logger.getLogger(InstantiateArchitectureViaWizard.class);
	private SelectionUtil selectionUtil = SelectionUtil.getInstance();
	private OSSTranslatorServiceUI ocraTranslatorService = OSSTranslatorServiceUI
			.getInstance(ChessSystemModel.getInstance());
	private OCRADirectoryUtil ocraDirectoryUtil = OCRADirectoryUtil.getInstance();

	public InstantiateArchitectureViaWizard() {
		super("Instantiate Parameterized Architecture");
	}

	@Override
	public void execPreJobOperations(ExecutionEvent event, IProgressMonitor monitor) throws Exception {

		boolean isDiscreteTime = MessageTimeModelDialog.openQuestion(false);
		Class umlSelectedComponent = selectionUtil.getUmlComponentFromSelectedObject(event);
		File ossFile = exportArchitectureAsOssFile(isDiscreteTime, event, monitor);

		if (ossFile != null) {
			shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			InstantiateArchWizard myWizard = new InstantiateArchWizard(ossFile, umlSelectedComponent, isDiscreteTime, monitor);
			WizardDialog wizardDialog = new WizardDialog(shell, myWizard);
			if (wizardDialog.open() == Window.OK) {
				System.out.println("Ok pressed");
				Package selectedPackage = myWizard.getSelectedPackage();
				boolean createNestedPackage = myWizard.createNestedPackage();
				String nestedPackageName = myWizard.getNestedPackageName();
				File finalOssFile = myWizard.getOSSFile();

				executeOSSimport(selectedPackage, createNestedPackage, nestedPackageName, finalOssFile);
			} else {
				System.out.println("Cancel pressed");
			}
		}
	}

	@Override
	public void execJobCommand(ExecutionEvent event, IProgressMonitor monitor) throws Exception {

	}

	private boolean executeOSSimport(Package selectedPackage, boolean createNestedPackage, String nestedPackageName,
			File ossFile) {

		Resource modelRes = SelectionUtil.getInstance().getSelectedModelResource();
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(modelRes);
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {

				Package updSelectedPackage;
				if (createNestedPackage) {
					// String nestedPackageName = nestedPackageName;
					updSelectedPackage = EntityUtil.getInstance().createPackage(selectedPackage, nestedPackageName);
				} else {
					updSelectedPackage = selectedPackage;
				}

				try {
					executeOSSImportCommand(updSelectedPackage, ossFile);
				} catch (NotDefinedException | ExecutionException | NotEnabledException | NotHandledException e) {
					e.printStackTrace();
				}

			}
		});

		return true;
	}

	private void executeOSSImportCommand(Package selectedPackage, File file)
			throws NotDefinedException, ExecutionException, NotEnabledException, NotHandledException {
		String ID_COMMAND = "org.polarsys.chess.OSSImporter.commands.AddOSSFile";
		String ID_PARAMETER_PACKAGE_URI = "packageURI";
		String ID_PARAMETER_OSS_FILE_PATH = "ossFilePath";

		String packageURIFragment = selectedPackage.eResource().getURIFragment(selectedPackage);

		logger.debug("selectedPackage: " + selectedPackage);
		logger.debug("packageURI: " + packageURIFragment);

		CommandBuilder checkContractImplementation = CommandBuilder.build(ID_COMMAND);
		checkContractImplementation.setParameter(ID_PARAMETER_PACKAGE_URI, packageURIFragment);
		checkContractImplementation.setParameter(ID_PARAMETER_OSS_FILE_PATH, file.getPath());

		checkContractImplementation.execute();

	}

	private File exportArchitectureAsOssFile(boolean isDiscreteTime, ExecutionEvent event, IProgressMonitor monitor)
			throws Exception {

		String ossFilepath = ocraDirectoryUtil.getOSSDirPath();
		boolean showPopups = false;
		boolean usexTextValidation = true;
		Class umlSelectedComponent = selectionUtil.getUmlComponentFromSelectedObject(event);
		Resource umlSelectedResource = umlSelectedComponent.eResource();

		return ocraTranslatorService.exportRootComponentToOssFile(umlSelectedComponent, umlSelectedResource,
				isDiscreteTime, usexTextValidation, showPopups, ossFilepath, monitor);
	}

}
