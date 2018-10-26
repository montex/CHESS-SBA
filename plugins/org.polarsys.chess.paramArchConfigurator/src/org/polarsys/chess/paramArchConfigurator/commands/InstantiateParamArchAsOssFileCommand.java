/*******************************************************************************
 * Copyright (C) 2018 Fondazione Bruno Kessler.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *   Alberto Debiasi - initial API and implementation
 ******************************************************************************/
package org.polarsys.chess.paramArchConfigurator.commands;

import java.util.ArrayList;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Class;
import org.polarsys.chess.paramArchConfigurator.ui.dialog.ConfigParameter;
import org.polarsys.chess.paramArchConfigurator.ui.dialog.ConfigureArchitectureDialog;
import org.polarsys.chess.service.core.model.ChessSystemModel;
import org.polarsys.chess.service.gui.utils.SelectionUtil;

import eu.fbk.eclipse.standardtools.ExecOcraCommands.ui.services.OCRAExecService;
import eu.fbk.eclipse.standardtools.utils.ui.commands.AbstractJobCommand;
import eu.fbk.eclipse.standardtools.utils.ui.dialogs.MessageTimeModelDialog;
import eu.fbk.eclipse.standardtools.utils.ui.utils.OCRADirectoryUtil;
import eu.fbk.tools.editor.contract.expression.validation.ProposalProvider.VariableType;


//command not used.
public class InstantiateParamArchAsOssFileCommand extends AbstractJobCommand {

	private OCRAExecService ocraExecService = OCRAExecService.getInstance(ChessSystemModel.getInstance());
	private SelectionUtil selectionUtil = SelectionUtil.getInstance();
	private OCRADirectoryUtil ocraDirectoryUtil = OCRADirectoryUtil.getInstance();
	
	public InstantiateParamArchAsOssFileCommand() {
		super("Instantiate Parameterized Architecture");
	}

	private Class umlSelectedComponent;
	private Resource umlSelectedResource;
	private boolean isDiscreteTime;
	private boolean showPopups;
	private boolean usexTextValidation;
	private String ossFilepath;
	private String resultFilePath;

	@Override
	public void execPreJobOperations(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
		umlSelectedComponent = selectionUtil.getUmlComponentFromSelectedObject(event);
		umlSelectedResource = umlSelectedComponent.eResource();
		
		final Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		final ConfigureArchitectureDialog parameterDialog = new ConfigureArchitectureDialog(shell,generateParams());
		parameterDialog.open();
		
		
		
		isDiscreteTime = MessageTimeModelDialog.openQuestion(false);
		showPopups = false;
		usexTextValidation=true;
		ossFilepath = ocraDirectoryUtil.getOSSDirPath();
		resultFilePath = ocraDirectoryUtil.getCommandInstantiateParamArchResultPath(umlSelectedComponent.getName(),1);
	}

	@Override
	public void execJobCommand(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
	//	ocraExecService.executeInstantiateParamArch(umlSelectedComponent, umlSelectedResource, isDiscreteTime,
		//		usexTextValidation,showPopups, ossFilepath, resultFilePath, monitor);
	}

	
private ArrayList<ConfigParameter> generateParams(){
	
	ArrayList<ConfigParameter> params = new ArrayList<ConfigParameter>();
	
	params.add(new ConfigParameter("system.param1", VariableType.BOOLEAN));
	params.add(new ConfigParameter("system.param2", VariableType.CONTINUOUS));
	String[] enum1Values = { "a", "b","c" };
	params.add(new ConfigParameter("system.param3", VariableType.ENUM,enum1Values));
	params.add(new ConfigParameter("system.param4", VariableType.INTEGER));
	params.add(new ConfigParameter("system.sub1.param5", VariableType.REAL));
	params.add(new ConfigParameter("system.sub1.param6", VariableType.REAL));
	params.add(new ConfigParameter("system.sub1.param7", VariableType.BOOLEAN));
	String[] enum2Values = { "er", "vf","vf" };
	params.add(new ConfigParameter("system.sub2.param8", VariableType.ENUM,enum2Values));
	params.add(new ConfigParameter("system.sub2.param9", VariableType.BOOLEAN));
	params.add(new ConfigParameter("system.sub2.param10", VariableType.BOOLEAN));
	params.add(new ConfigParameter("system.sub2.param11", VariableType.BOOLEAN));
	
return 	params;
}
}
