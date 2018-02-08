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
package org.polarsys.chess.verificationService.commands.debug;

import java.io.File;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.IProgressMonitor;


import eu.fbk.eclipse.standardtools.commands.AbstractJobCommand;
import eu.fbk.eclipse.standardtools.nuXmvService.dialogs.NuXmvParametersDialog;
import eu.fbk.eclipse.standardtools.nuXmvService.services.NuXmvService;
import eu.fbk.eclipse.standardtools.nuXmvService.utils.NuXmvDialogUtil;
import eu.fbk.eclipse.standardtools.nuXmvService.utils.NuXmvDirectoryUtil;

/**
 * 
 *
 */
public class ModelCheckingOnFileCommand extends AbstractJobCommand {

	
	private NuXmvService nuXmvService = NuXmvService.getInstance();
	private NuXmvDialogUtil nuXmvDialogUtil = NuXmvDialogUtil.getInstance();
	private NuXmvDirectoryUtil nuXmvDirectoryUtil = NuXmvDirectoryUtil.getInstance();
	
	public ModelCheckingOnFileCommand() {
		super("Model Checking");
	}

	boolean goAhead = false;
	String alg_type;
	String check_type;
	String property;
	
	@Override
	public void execPreJobOperations(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
		
		//boolean isDiscreteTime = MessageTimeModelDialog.openQuestion();

		
			final NuXmvParametersDialog dialog = new NuXmvParametersDialog();
			dialog.open();
			
			goAhead = dialog.goAhead();
			
			if (goAhead) {
				 alg_type = dialog.getAlgorithmType();
				 check_type = dialog.getCheckType();
				 property = dialog.getProperty();
				 
			}
	}

	@Override
	public void execJobCommand(ExecutionEvent event, IProgressMonitor monitor) throws Exception {

		if (goAhead) {
			
			File smvFile = nuXmvDialogUtil.getSmvFileFromFileDialog(nuXmvDirectoryUtil.getSmvFilePath());
			String resultFilePath = nuXmvDirectoryUtil.getCommandModelCheckingResultPath(smvFile.getName());
		nuXmvService.modelCheckingCommand(smvFile, property, alg_type, check_type,resultFilePath);
		}
			

		}
	

}
