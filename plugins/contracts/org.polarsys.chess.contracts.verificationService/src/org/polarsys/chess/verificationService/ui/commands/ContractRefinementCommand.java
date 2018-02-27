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
package org.polarsys.chess.verificationService.ui.commands;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Class;

import eu.fbk.eclipse.standardtools.ExecOcraCommands.ui.services.OCRAExecService;
import eu.fbk.eclipse.standardtools.utils.ui.commands.AbstractJobCommand;
import eu.fbk.eclipse.standardtools.utils.ui.dialogs.MessageTimeModelDialog;
import eu.fbk.eclipse.standardtools.utils.ui.utils.OCRADirectoryUtil;

import org.polarsys.chess.service.core.model.ChessSystemModel;
import org.polarsys.chess.service.gui.utils.SelectionUtil;

public class ContractRefinementCommand extends AbstractJobCommand {

	private OCRAExecService ocraExecService = OCRAExecService.getInstance(ChessSystemModel.getInstance());
	private SelectionUtil selectionUtil = SelectionUtil.getInstance();
	private OCRADirectoryUtil ocraDirectoryUtil = OCRADirectoryUtil.getInstance();

	public ContractRefinementCommand() {
		super("Contract Refinement");
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
		isDiscreteTime = MessageTimeModelDialog.openQuestion();
		showPopups = false;
		usexTextValidation=true;
		ossFilepath = ocraDirectoryUtil.getOSSFilePath();
		resultFilePath = ocraDirectoryUtil.getCommandCheckRefinementResultPath(umlSelectedComponent.getName());
	}

	@Override
	public void execJobCommand(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
		ocraExecService.executeCheckContractRefinement(umlSelectedComponent, umlSelectedResource, isDiscreteTime,
				usexTextValidation,showPopups, ossFilepath, resultFilePath, monitor);
	}

}
