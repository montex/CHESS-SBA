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
package org.polarsys.chess.safetyAnalysis.commands;


import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Class;
import org.polarsys.chess.service.internal.utils.SelectionUtil;
import org.polarsys.chess.verificationService.model.ChessSystemModel;

import eu.fbk.eclipse.standardtools.ExecOcraCommands.services.OCRAExecService;
import eu.fbk.eclipse.standardtools.commands.AbstractAsyncJobCommand;
import eu.fbk.eclipse.standardtools.dialogs.MessageTimeModelDialog;

/**
 * 
 *
 */
public class ComputeContractFaultTreeCommand extends AbstractAsyncJobCommand {

	private SelectionUtil selectionUtil = SelectionUtil.getInstance();
	private OCRAExecService ocraExecService = OCRAExecService.getInstance(ChessSystemModel.getInstance());
	
	
	public ComputeContractFaultTreeCommand() {
		super("Contract-based Fault Tree");
	}

	@Override
	public void execJobCommand(ExecutionEvent event, IProgressMonitor monitor) throws Exception {

		Class umlSelectedComponent = selectionUtil.getUmlComponentFromSelectedObject(event);
		Resource umlSelectedResource = umlSelectedComponent.eResource();
		boolean isDiscreteTime = MessageTimeModelDialog.openQuestion();
		boolean showPopups = false;
		
		ocraExecService.executeComputeFaultTree(umlSelectedComponent,umlSelectedResource, isDiscreteTime, showPopups,monitor);
	}

}