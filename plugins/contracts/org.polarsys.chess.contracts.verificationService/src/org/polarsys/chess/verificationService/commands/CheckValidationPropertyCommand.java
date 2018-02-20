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

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Class;
import org.polarsys.chess.service.internal.model.ChessSystemModel;
import org.polarsys.chess.service.utils.SelectionUtil;

import eu.fbk.eclipse.standardtools.ExecOcraCommands.services.OCRAExecService;
import eu.fbk.eclipse.standardtools.commands.AbstractJobCommand;
import eu.fbk.eclipse.standardtools.dialogs.MessageTimeModelDialog;
import eu.fbk.eclipse.standardtools.utils.OCRADirectoryUtil;

/**
 * 
 *
 */
public class CheckValidationPropertyCommand extends AbstractJobCommand {

	private ChessSystemModel chessToOCRAModelTranslator = ChessSystemModel.getInstance();
	private OCRAExecService ocraExecService = OCRAExecService.getInstance(chessToOCRAModelTranslator);
	private SelectionUtil selectionUtil = SelectionUtil.getInstance();
	private OCRADirectoryUtil ocraDirectoryUtil = OCRADirectoryUtil.getInstance();

	public CheckValidationPropertyCommand() {
		super("Check Validation Property");
	}

	private Class umlSelectedComponent;
	private Resource umlSelectedResource;
	private boolean isDiscreteTime;
	private boolean showPopups;
	private String ossFilepath;
	private String resultFilePath;

	@Override
	public void execPreJobOperations(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
		umlSelectedComponent = selectionUtil.getUmlComponentFromSelectedObject(event);
		umlSelectedResource = umlSelectedComponent.eResource();
		isDiscreteTime = MessageTimeModelDialog.openQuestion();
		showPopups = false;
		ossFilepath = ocraDirectoryUtil.getOSSFilePath();
		resultFilePath = ocraDirectoryUtil.getCommandCheckPropertyResultPath(umlSelectedComponent.getName());

	}

	@Override
	public void execJobCommand(ExecutionEvent event, IProgressMonitor monitor) throws Exception {

		ocraExecService.executeValidationProperty(umlSelectedComponent, umlSelectedResource, isDiscreteTime, showPopups,
				ossFilepath, resultFilePath, monitor);

	}

}
