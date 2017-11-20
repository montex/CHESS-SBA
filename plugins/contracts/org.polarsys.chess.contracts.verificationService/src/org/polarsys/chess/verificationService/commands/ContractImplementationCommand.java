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

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Class;

import eu.fbk.eclipse.standardtools.ExecOcraCommands.services.OCRAExecService;
import eu.fbk.eclipse.standardtools.commands.AbstractJobCommand;
import eu.fbk.eclipse.standardtools.dialogs.MessageTimeModelDialog;
import eu.fbk.eclipse.standardtools.nuXmvService.utils.NuXmvDirectoryUtil;
import eu.fbk.eclipse.standardtools.utils.OCRADirectoryUtil;

import org.polarsys.chess.service.internal.utils.SelectionUtil;
import org.polarsys.chess.verificationService.model.ChessSystemModel;
import org.polarsys.chess.verificationService.services.SmvExportService;

public class ContractImplementationCommand extends AbstractJobCommand {

	private OCRAExecService ocraExecService = OCRAExecService.getInstance(ChessSystemModel.getInstance());
	private SelectionUtil selectionUtil = SelectionUtil.getInstance();
	//private OCRADirectoryUtil ocraDirectoryUtil = OCRADirectoryUtil.getInstance();
	private SmvExportService nuXmvService = SmvExportService.getInstance();
	private OCRADirectoryUtil ocraDirectoryUtil = OCRADirectoryUtil.getInstance();
	private static NuXmvDirectoryUtil nuXmvDirectoryUtil = NuXmvDirectoryUtil.getInstance();
	
	public ContractImplementationCommand() {
		super("Check Contract Implementation");
	}

	Class umlSelectedComponent;
	Resource umlSelectedResource;
	boolean isDiscreteTime;
	boolean showPopups;
	String ossFilepath;
	String smvFilePath;
	String resultFilePath;
	
	@Override
	public void execGUIOperations(ExecutionEvent event) throws Exception {
		 umlSelectedComponent = selectionUtil.getUmlComponentFromSelectedObject(event);
		 umlSelectedResource = umlSelectedComponent.eResource();
		 isDiscreteTime = MessageTimeModelDialog.openQuestion();
		 showPopups = false;
		 ossFilepath = ocraDirectoryUtil.getOSSFilePath();
		 smvFilePath = nuXmvDirectoryUtil.getSmvFilePath();
		 resultFilePath = ocraDirectoryUtil.getCommandCheckImplementationResultPath();
			
	}



	@Override
	public void execJobCommand(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
		
		//String smvOutputFilePath = ocraDirectoryUtil.getOSSFilePath();
		File smvOutput = nuXmvService.exportSmv(umlSelectedComponent, showPopups,smvFilePath,monitor);
		System.out.println("smvOutput: " + smvOutput);

		ocraExecService.executeCheckContractImplementation(umlSelectedComponent,umlSelectedResource, smvOutput, isDiscreteTime,showPopups,ossFilepath,resultFilePath,monitor);

	}

}
