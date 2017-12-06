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
package org.polarsys.chess.verificationService.commands;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.uml2.uml.Class;
import eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.services.OCRATranslatorService;
import eu.fbk.eclipse.standardtools.commands.AbstractJobCommand;
import eu.fbk.eclipse.standardtools.dialogs.MessageTimeModelDialog;
import eu.fbk.eclipse.standardtools.utils.OCRADirectoryUtil;
import org.polarsys.chess.service.utils.SelectionUtil;
import org.polarsys.chess.verificationService.model.ChessSystemModel;

/**
 * 
 *
 */
public class ExportModelToFileCommand extends AbstractJobCommand {

	private SelectionUtil selectionUtil = SelectionUtil.getInstance();
	private OCRATranslatorService ocraTranslatorService = OCRATranslatorService.getInstance(ChessSystemModel.getInstance());
	private OCRADirectoryUtil ocraDirectoryUtil = OCRADirectoryUtil.getInstance();
	
	
	
	public ExportModelToFileCommand() {
		super("Export Model To .Oss File");
	}

	
	private Resource umlSelectedResource;
	private boolean isDiscreteTime ;
	private String  ossFilepath;
	private boolean showPopups;
	private Class umlSelectedComponent;
	
	@Override
	public void execGUIOperations(ExecutionEvent event,IProgressMonitor monitor) throws Exception {
		 umlSelectedComponent = selectionUtil.getUmlComponentFromSelectedObject(event);
		 umlSelectedResource = umlSelectedComponent.eResource();
		 isDiscreteTime = MessageTimeModelDialog.openQuestion();
		  ossFilepath = ocraDirectoryUtil.getOSSFilePath();				
		 showPopups = true;
	}



	@Override
	public void execJobCommand(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
	
	ocraTranslatorService.exportModelToOssFile(umlSelectedComponent, umlSelectedResource,
				isDiscreteTime,showPopups,ossFilepath, monitor);
	}

}
