package org.polarsys.chess.verificationService.ui.commands;

import java.util.HashMap;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Class;
import org.polarsys.chess.service.core.model.ChessSystemModel;
import org.polarsys.chess.service.gui.utils.SelectionUtil;
import org.polarsys.chess.smvExporter.ui.services.SmvExportServiceUI;

import eu.fbk.eclipse.standardtools.ExecOcraCommands.ui.services.OCRAExecService;
import eu.fbk.eclipse.standardtools.nuXmvService.ui.utils.NuXmvDirectoryUtil;
import eu.fbk.eclipse.standardtools.utils.ui.commands.AbstractJobCommand;
import eu.fbk.eclipse.standardtools.utils.ui.dialogs.MessageTimeModelDialog;
import eu.fbk.eclipse.standardtools.utils.ui.utils.OCRADirectoryUtil;

public class CompositeContractImplementationCommand extends AbstractJobCommand {

	private OCRAExecService ocraExecService = OCRAExecService.getInstance(ChessSystemModel.getInstance());
	private SelectionUtil selectionUtil = SelectionUtil.getInstance();
	private SmvExportServiceUI smvExportService = SmvExportServiceUI.getInstance();
	private OCRADirectoryUtil ocraDirectoryUtil = OCRADirectoryUtil.getInstance();
	private NuXmvDirectoryUtil nuXmvDirectoryUtil = NuXmvDirectoryUtil.getInstance();

	public CompositeContractImplementationCommand() {
		super("Check Compositional Contract Implementation");
	}

	private Class umlSelectedComponent;
	private Resource umlSelectedResource;
	private boolean isDiscreteTime;
	private boolean showPopups;
	private boolean usexTextValidation;
	private String smvMapFilepath;
	private String smvFilePath;
	private String resultFilePath;

	@Override
	public void execPreJobOperations(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
		umlSelectedComponent = selectionUtil.getUmlComponentFromSelectedObject(event);
		umlSelectedResource = umlSelectedComponent.eResource();
		isDiscreteTime = MessageTimeModelDialog.openQuestion();
		showPopups = false;
		usexTextValidation=true;
		smvMapFilepath = ocraDirectoryUtil.getSmvMapFilePath();
		smvFilePath = nuXmvDirectoryUtil.getSmvFileDirectory();
		resultFilePath = ocraDirectoryUtil.getCommandCheckImplementationResultPath(umlSelectedComponent.getName());
	}

	@Override
	public void execJobCommand(ExecutionEvent event, IProgressMonitor monitor) throws Exception {

		HashMap<String, String> smvPathComponentNameMap = smvExportService.exportSmv(umlSelectedComponent, showPopups,
				smvFilePath, monitor);
		ocraExecService.executeCheckCompositeContractImplementation(umlSelectedComponent, umlSelectedResource,
				smvPathComponentNameMap, isDiscreteTime, usexTextValidation,showPopups, smvMapFilepath, resultFilePath, monitor);

	}

}
