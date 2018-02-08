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
import org.eclipse.uml2.uml.Class;

import org.polarsys.chess.service.utils.SelectionUtil;
import org.polarsys.chess.smvExport.services.SmvExportService;

//import org.polarsys.chess.verificationService.services.SmvExportService;
import eu.fbk.eclipse.standardtools.commands.AbstractJobCommand;
import eu.fbk.eclipse.standardtools.nuXmvService.services.NuXmvService;
import eu.fbk.eclipse.standardtools.nuXmvService.utils.NuXmvDirectoryUtil;

/**
 * 
 *
 */
public class ModelCheckingCommand extends AbstractJobCommand {

	private SelectionUtil selectionUtil = SelectionUtil.getInstance();
	private SmvExportService smvExportService = SmvExportService.getInstance();
	private NuXmvService nuXmvService = NuXmvService.getInstance();
	private static NuXmvDirectoryUtil nuXmvDirectoryUtil = NuXmvDirectoryUtil.getInstance();
	
	public ModelCheckingCommand() {
		super("Model Checking");
	}

	private Class umlSelectedComponent;
	private boolean showPopups;
	private String smvFilePath;
	private String resultFilePath;
	
	@Override
	public void execPreJobOperations(ExecutionEvent event,IProgressMonitor monitor) throws Exception {
		 umlSelectedComponent = selectionUtil.getUmlComponentFromSelectedObject(event);
		 showPopups = true;
		 smvFilePath = nuXmvDirectoryUtil.getSmvFilePath();
		  resultFilePath = nuXmvDirectoryUtil.getCommandModelCheckingResultPath(umlSelectedComponent.getName());
	}



	@Override
	public void execJobCommand(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
	
		File smvOutput = smvExportService.exportSingleSmv( umlSelectedComponent,showPopups,smvFilePath, monitor);
		nuXmvService.executeModelChecking(smvOutput,resultFilePath);
		
	}

}
