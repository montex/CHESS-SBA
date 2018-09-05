package org.polarsys.chess.paramArchConfigurator.ui.wizard;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.wizard.Wizard;
import org.polarsys.chess.paramArchConfigurator.ui.wizard.page.LastPage;
import org.polarsys.chess.paramArchConfigurator.ui.wizard.page.AssignValuesPage;
import org.polarsys.chess.service.core.model.ChessSystemModel;
import org.eclipse.uml2.uml.Package;
import eu.fbk.eclipse.standardtools.ExecOcraCommands.ui.services.OCRAExecService;
import eu.fbk.eclipse.standardtools.utils.ui.utils.DialogUtil;

public class InstantiateArchWizard extends Wizard {

	protected AssignValuesPage one;
	protected LastPage lastPage;

	private OCRAExecService ocraExecService = OCRAExecService.getInstance(ChessSystemModel.getInstance());
	private File ossFile;
	private IProgressMonitor monitor;
	private boolean isDiscrete;
	private EObject selectedElement;
	private Package seletedPackage;
	private boolean createNestedPackage;
	private String nestedPackageName;
	private File finalOssFile;

	private DialogUtil dialogUtil = DialogUtil.getInstance();

	public InstantiateArchWizard(File ossFile, EObject selectedElement, boolean isDiscrete, IProgressMonitor monitor) {
		super();
		this.ossFile = ossFile;
		this.monitor = monitor;
		this.isDiscrete = isDiscrete;
		this.selectedElement = selectedElement;
		setNeedsProgressMonitor(true);
	}

	@Override
	public String getWindowTitle() {
		return "Export My Data";
	}

	@Override
	public void addPages() {

		try {
			Map<String, String> parametersList = ocraExecService.executeGetParameters(ossFile, isDiscrete, monitor);

			if ((parametersList != null) && (!parametersList.isEmpty())) {
				one = new AssignValuesPage(ossFile.getName(), selectedElement, ossFile, parametersList,
						new ArrayList<ArrayList<String>>(), 1, isDiscrete, monitor, this);
				addPage(one);
			}
		} catch (Exception e) {
			e.printStackTrace();
			dialogUtil.showMessage_ExceptionError(e);
		}
		lastPage = new LastPage(selectedElement, null, new ArrayList<ArrayList<String>>());
		addPage(lastPage);
	}

	@Override
	public boolean canFinish() {
		if (getContainer().getCurrentPage() instanceof AssignValuesPage)
			return false;
		else
			return true;
	}

	public Package getSelectedPackage() {
		return seletedPackage;
	}

	public boolean createNestedPackage() {
		return createNestedPackage;
	}

	public String getNestedPackageName() {
		return nestedPackageName;
	}

	public File getOSSFile() {
		return finalOssFile;
	}

	@Override
	public boolean performFinish() {
		seletedPackage = ((LastPage) getContainer().getCurrentPage()).getSelectedPackage();
		createNestedPackage = ((LastPage) getContainer().getCurrentPage()).createNestedPackage();
		nestedPackageName = ((LastPage) getContainer().getCurrentPage()).getNestedPackageName();
		finalOssFile = ((LastPage) getContainer().getCurrentPage()).getOSSFile();

		return true;
	}

}