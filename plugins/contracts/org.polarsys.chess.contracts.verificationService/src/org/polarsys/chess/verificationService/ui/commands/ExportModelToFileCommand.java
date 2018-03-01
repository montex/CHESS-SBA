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
/**
 * 
 */
package org.polarsys.chess.verificationService.ui.commands;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.uml2.uml.Class;

import eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.ui.services.OSSTranslatorServiceUI;
import eu.fbk.eclipse.standardtools.utils.ui.commands.AbstractJobCommand;
import eu.fbk.eclipse.standardtools.utils.ui.dialogs.MessageTimeModelDialog;
import eu.fbk.eclipse.standardtools.utils.ui.utils.OCRADirectoryUtil;

import org.polarsys.chess.service.core.model.ChessSystemModel;
import org.polarsys.chess.service.gui.utils.SelectionUtil;

/**
 * 
 *
 */
public class ExportModelToFileCommand extends AbstractJobCommand {

	private SelectionUtil selectionUtil = SelectionUtil.getInstance();
	private OSSTranslatorServiceUI ocraTranslatorService = OSSTranslatorServiceUI
			.getInstance(ChessSystemModel.getInstance());
	private OCRADirectoryUtil ocraDirectoryUtil = OCRADirectoryUtil.getInstance();

	public ExportModelToFileCommand() {
		super("Export Model To .Oss File");
	}

	private Resource umlSelectedResource;
	private boolean isDiscreteTime;
	private String ossFilepath;
	private boolean showPopups;
	private boolean usexTextValidation;
	private Class umlSelectedComponent;

	@Override
	public void execPreJobOperations(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
		umlSelectedComponent = selectionUtil.getUmlComponentFromSelectedObject(event);
		umlSelectedResource = umlSelectedComponent.eResource();
		isDiscreteTime = MessageTimeModelDialog.openQuestion();
		ossFilepath = ocraDirectoryUtil.getOSSFilePath();
		showPopups = true;
		usexTextValidation=true;
	}

	@Override
	public void execJobCommand(ExecutionEvent event, IProgressMonitor monitor) throws Exception {

		ocraTranslatorService.exportRootComponentToOssFile(umlSelectedComponent, umlSelectedResource, isDiscreteTime,
				usexTextValidation,showPopups, ossFilepath, monitor);

	}

}
