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
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Class;
import org.polarsys.chess.service.internal.utils.SelectionUtil;
import org.polarsys.chess.verificationService.model.ChessSystemModel;

import eu.fbk.eclipse.standardtools.ExecOcraCommands.dialogs.ValidationPropertyParametersDialog;
import eu.fbk.eclipse.standardtools.ExecOcraCommands.services.OCRAExecService;
import eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.services.OCRATranslatorService;
import eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.utils.OCRAModelUtil;
import eu.fbk.eclipse.standardtools.commands.AbstractJobCommand;
import eu.fbk.eclipse.standardtools.dialogs.MessageTimeModelDialog;
import eu.fbk.eclipse.standardtools.utils.OCRADirectoryUtil;
import eu.fbk.tools.editor.oss.oss.OSS;

/**
 * 
 *
 */
public class CheckValidationPropertyCommand extends AbstractJobCommand {

	private ChessSystemModel chessToOCRAModelTranslator = ChessSystemModel.getInstance();
	private OCRAExecService ocraExecService = OCRAExecService.getInstance(chessToOCRAModelTranslator);
	private SelectionUtil selectionUtil = SelectionUtil.getInstance();
	private OCRADirectoryUtil ocraDirectoryUtil = OCRADirectoryUtil.getInstance();
	private OCRATranslatorService ocraTranslatorService = OCRATranslatorService.getInstance(chessToOCRAModelTranslator);
	private OCRAModelUtil ocraModelUtil = OCRAModelUtil.getInstance();
	
	public CheckValidationPropertyCommand() {
		super("Check Validation Property");
	}
	
	Class umlSelectedComponent;
	Resource umlSelectedResource;		
	boolean isDiscreteTime;
	boolean showPopups;
	String ossFilepath;
	String resultFilePath;
	ValidationPropertyParametersDialog dialog;

	
	
	@Override
	public void execGUIOperations(ExecutionEvent event) throws Exception {
		 umlSelectedComponent = selectionUtil.getUmlComponentFromSelectedObject(event);
		 umlSelectedResource = umlSelectedComponent.eResource();		
		 isDiscreteTime = MessageTimeModelDialog.openQuestion();
		 showPopups = false;
		 ossFilepath = ocraDirectoryUtil.getOSSFilePath();
		  resultFilePath = ocraDirectoryUtil.getCommandCheckPropertyResultPath();
	}




	@Override
	public void execJobCommand(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
		
		OSS ossModel = ocraTranslatorService.getOssModel(umlSelectedComponent, isDiscreteTime, monitor);

		//String fileName = ocraTranslatorService.getFileName(umlSelectedComponent);
		File ossFile = ocraTranslatorService.generateOssFileFromOssModel(umlSelectedComponent, umlSelectedResource,
				ossModel, showPopups,ossFilepath,monitor);
		String[] componentTypes = ocraModelUtil.getComponentTypes(ossModel);

		Display defaultDisplay = Display.getDefault();

		defaultDisplay.syncExec(new Runnable() {
			@Override
			public void run() {
		  dialog = new ValidationPropertyParametersDialog(componentTypes,ossModel);
		dialog.open();
			}
		});
		
		
		if (dialog.goAhead()) {
			ocraExecService.executeValidationProperty(ossFile, dialog.getSelectedButton(), dialog.getPropertyType(),
					dialog.getComponent(), dialog.getProperty(), dialog.getExpression(), isDiscreteTime, resultFilePath,monitor);
		}
		
		//ocraExecService.executeValidationProperty(umlSelectedComponent, umlSelectedResource, isDiscreteTime,showPopups,ossFilepath, monitor);
		
	}

}
