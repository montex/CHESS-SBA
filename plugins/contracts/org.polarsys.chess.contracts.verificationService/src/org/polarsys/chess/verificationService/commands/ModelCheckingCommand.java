/*******************************************************************************
 * Copyright (C) 2017 Fondazione Bruno Kessler.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Alberto Debiasi - initial API and implementation
 ******************************************************************************/
package org.polarsys.chess.verificationService.commands;

import java.io.File;
import java.util.HashMap;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Class;
import org.polarsys.chess.service.internal.model.ChessSystemModel;
import org.polarsys.chess.service.utils.SelectionUtil;
import org.polarsys.chess.smvExport.services.SmvExportService;

import eu.fbk.eclipse.standardtools.ExecOcraCommands.services.OCRAExecService;
//import org.polarsys.chess.verificationService.services.SmvExportService;
import eu.fbk.eclipse.standardtools.commands.AbstractJobCommand;
import eu.fbk.eclipse.standardtools.dialogs.MessageTimeModelDialog;
import eu.fbk.eclipse.standardtools.nuXmvService.services.NuXmvExecService;
import eu.fbk.eclipse.standardtools.nuXmvService.utils.NuXmvDirectoryUtil;
import eu.fbk.eclipse.standardtools.utils.OCRADirectoryUtil;

/**
 * 
 *
 */
public class ModelCheckingCommand extends AbstractJobCommand {

	private SelectionUtil selectionUtil = SelectionUtil.getInstance();
	private SmvExportService smvExportService = SmvExportService.getInstance();
	private NuXmvExecService nuXmvExecService = NuXmvExecService.getInstance();
	private static NuXmvDirectoryUtil nuXmvDirectoryUtil = NuXmvDirectoryUtil.getInstance();
	private OCRADirectoryUtil ocraDirectoryUtil = OCRADirectoryUtil.getInstance();
	private OCRAExecService ocraExecService = OCRAExecService.getInstance(ChessSystemModel.getInstance());
	
	
	public ModelCheckingCommand() {
		super("Model Checking");
	}

	private Class umlSelectedComponent;
	private boolean showPopups;
	private String smvFilePath;
	private boolean isDiscreteTime;
	private String monolithicSMVFilePath;
	private String resultFilePath;
	private String smvMapFilepath;
	private Resource umlSelectedResource;
	
	@Override
	public void execPreJobOperations(ExecutionEvent event,IProgressMonitor monitor) throws Exception {
		 umlSelectedComponent = selectionUtil.getUmlComponentFromSelectedObject(event);
		 umlSelectedResource = umlSelectedComponent.eResource();
		 showPopups = true;
		 isDiscreteTime = MessageTimeModelDialog.openQuestion();
		 smvFilePath = nuXmvDirectoryUtil.getSmvFileDirectory();
		 monolithicSMVFilePath = nuXmvDirectoryUtil.getMonolithicSMVFilePath(umlSelectedComponent.getName());
		 resultFilePath = nuXmvDirectoryUtil.getModelCheckingResultPath(umlSelectedComponent.getName());
		  smvMapFilepath = ocraDirectoryUtil.getSmvMapFilePath();
	}



	@Override
	public void execJobCommand(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
	
		//File smvOutput = smvExportService.exportSingleSmv( umlSelectedComponent,showPopups,smvFilePath, monitor);
		//nuXmvExecService.executeModelChecking(smvOutput,resultFilePath);
		
		HashMap<String,String> smvPathComponentNameMap = smvExportService.exportSmv( umlSelectedComponent,showPopups,smvFilePath, monitor);		
		ocraExecService.createMonolithicSMV(umlSelectedComponent, umlSelectedResource, smvPathComponentNameMap, isDiscreteTime, showPopups, smvMapFilepath, monolithicSMVFilePath, monitor);
		nuXmvExecService.executeModelChecking(new File(monolithicSMVFilePath),resultFilePath);
		}

}
