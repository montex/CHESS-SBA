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
import eu.fbk.eclipse.standardtools.commands.AbstractAsyncJobCommand;
import eu.fbk.eclipse.standardtools.dialogs.MessageTimeModelDialog;


import org.polarsys.chess.service.internal.utils.SelectionUtil;
import org.polarsys.chess.verificationService.model.ChessSystemModel;
import org.polarsys.chess.verificationService.services.SmvExportService;

public class ContractImplementationCommand extends AbstractAsyncJobCommand {

	private OCRAExecService ocraExecService = OCRAExecService.getInstance(ChessSystemModel.getInstance());
	private SelectionUtil selectionUtil = SelectionUtil.getInstance();
	//private OCRADirectoryUtil ocraDirectoryUtil = OCRADirectoryUtil.getInstance();
	private SmvExportService nuXmvService = SmvExportService.getInstance();
	
	
	public ContractImplementationCommand() {
		super("Check Contract Implementation");
	}

	@Override
	public void execJobCommand(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
		
		Class umlSelectedComponent = selectionUtil.getUmlComponentFromSelectedObject(event);
		Resource umlSelectedResource = umlSelectedComponent.eResource();
		boolean isDiscreteTime = MessageTimeModelDialog.openQuestion();
		boolean showPopups = false;
		
		//String smvOutputFilePath = ocraDirectoryUtil.getOSSFilePath();
		File smvOutput = nuXmvService.exportSmv(umlSelectedComponent, showPopups,monitor);
		System.out.println("smvOutput: " + smvOutput);

		ocraExecService.executeCheckContractImplementation(umlSelectedComponent,umlSelectedResource, smvOutput, isDiscreteTime,showPopups,monitor);

	}

}
