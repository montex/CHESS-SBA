package org.polarsys.chess.verificationService.commands;

import java.util.HashMap;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Class;
import org.polarsys.chess.service.internal.model.ChessSystemModel;
import org.polarsys.chess.service.utils.SelectionUtil;
import org.polarsys.chess.smvExport.services.SmvExportService;
import eu.fbk.eclipse.standardtools.ExecOcraCommands.services.OCRAExecService;
import eu.fbk.eclipse.standardtools.commands.AbstractJobCommand;
import eu.fbk.eclipse.standardtools.dialogs.MessageTimeModelDialog;
import eu.fbk.eclipse.standardtools.nuXmvService.utils.NuXmvDirectoryUtil;
import eu.fbk.eclipse.standardtools.utils.OCRADirectoryUtil;

public class CompositeContractImplementationCommand extends AbstractJobCommand {

	private OCRAExecService ocraExecService = OCRAExecService.getInstance(ChessSystemModel.getInstance());
	private SelectionUtil selectionUtil = SelectionUtil.getInstance();
	private SmvExportService smvExportService = SmvExportService.getInstance();
	private OCRADirectoryUtil ocraDirectoryUtil = OCRADirectoryUtil.getInstance();
	private NuXmvDirectoryUtil nuXmvDirectoryUtil = NuXmvDirectoryUtil.getInstance();
	
	public CompositeContractImplementationCommand() {
		super("Check Compositional Contract Implementation");
	}

	private Class umlSelectedComponent;
	private Resource umlSelectedResource;
	private boolean isDiscreteTime;
	private boolean showPopups;
	private String smvMapFilepath;
	private String smvFilePath;
	private String resultFilePath;
	
	@Override
	public void execPreJobOperations(ExecutionEvent event,IProgressMonitor monitor) throws Exception {
		 umlSelectedComponent = selectionUtil.getUmlComponentFromSelectedObject(event);
		 umlSelectedResource = umlSelectedComponent.eResource();
		 isDiscreteTime = MessageTimeModelDialog.openQuestion();
		 showPopups = true;
		 smvMapFilepath = ocraDirectoryUtil.getSmvMapFilePath();
		 smvFilePath = nuXmvDirectoryUtil.getSmvFileDirectory();
		 resultFilePath = ocraDirectoryUtil.getCommandCheckImplementationResultPath(umlSelectedComponent.getName());			
	}



	@Override
	public void execJobCommand(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
		
		HashMap<String,String> smvPathComponentNameMap = smvExportService.exportSmv( umlSelectedComponent,showPopups,smvFilePath, monitor);		
		ocraExecService.executeCheckCompositeContractImplementation(umlSelectedComponent,umlSelectedResource, smvPathComponentNameMap, isDiscreteTime,showPopups,smvMapFilepath,resultFilePath,monitor);

	}

}
