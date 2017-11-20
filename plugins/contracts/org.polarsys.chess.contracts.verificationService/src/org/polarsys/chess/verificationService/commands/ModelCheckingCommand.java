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
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Class;

import org.polarsys.chess.service.internal.utils.SelectionUtil;
import org.polarsys.chess.verificationService.services.SmvExportService;
import eu.fbk.eclipse.standardtools.commands.AbstractJobCommand;
import eu.fbk.eclipse.standardtools.nuXmvService.dialogs.NuXmvParametersDialog;
import eu.fbk.eclipse.standardtools.nuXmvService.services.NuXmvService;
import eu.fbk.eclipse.standardtools.nuXmvService.utils.NuXmvDirectoryUtil;

/**
 * 
 *
 */
public class ModelCheckingCommand extends AbstractJobCommand {

	private SelectionUtil selectionUtil = SelectionUtil.getInstance();
	//private OCRADirectoryUtil ocraDirectoryUtil = OCRADirectoryUtil.getInstance();
	private SmvExportService smvExportService = SmvExportService.getInstance();
	private NuXmvService nuXmvService = NuXmvService.getInstance();
	private static NuXmvDirectoryUtil nuXmvDirectoryUtil = NuXmvDirectoryUtil.getInstance();
	
	public ModelCheckingCommand() {
		super("Model Checking");
	}

	Class umlSelectedComponent;
	boolean showPopups;
	String smvFilePath;
	NuXmvParametersDialog dialog;
	
	@Override
	public void execGUIOperations(ExecutionEvent event) throws Exception {
		 umlSelectedComponent = selectionUtil.getUmlComponentFromSelectedObject(event);
		 showPopups = false;
		 smvFilePath = nuXmvDirectoryUtil.getSmvFilePath();
	}



	@Override
	public void execJobCommand(ExecutionEvent event, IProgressMonitor monitor) throws Exception {

		
		//String smvOutputFilePath = ocraDirectoryUtil.getOSSFilePath();
		
		
		File smvOutput = smvExportService.exportSmv( umlSelectedComponent,showPopups,smvFilePath, monitor);

		if (smvOutput != null) {
			
			Display defaultDisplay = Display.getDefault();
			defaultDisplay.syncExec(new Runnable() {
				@Override
				public void run() {
			dialog = new NuXmvParametersDialog();
			dialog.open();
				}
			});

			if (dialog.goAhead()) {
				String alg_type = dialog.getAlgorithmType();
				String check_type = dialog.getCheckType();
				String property = dialog.getProperty();
				nuXmvService.modelCheckingCommand(smvOutput, property, alg_type, check_type);
			}

		}
	}

}
