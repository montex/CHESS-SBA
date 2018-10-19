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
package org.polarsys.chess.verificationService.ui.commands.debug;

import java.io.File;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.IProgressMonitor;

import eu.fbk.eclipse.standardtools.nuXmvService.ui.dialogs.NuXmvParametersDialog;
import eu.fbk.eclipse.standardtools.nuXmvService.ui.services.NuXmvExecService;
import eu.fbk.eclipse.standardtools.nuXmvService.ui.utils.NuXmvDialogUtil;
import eu.fbk.eclipse.standardtools.nuXmvService.ui.utils.NuXmvDirectoryUtil;
import eu.fbk.eclipse.standardtools.utils.ui.commands.AbstractJobCommand;

/**
 * 
 *
 */
public class ModelCheckingOnFileCommand extends AbstractJobCommand {

	private NuXmvExecService nuXmvService = NuXmvExecService.getInstance();
	private NuXmvDialogUtil nuXmvDialogUtil = NuXmvDialogUtil.getInstance();
	private NuXmvDirectoryUtil nuXmvDirectoryUtil = NuXmvDirectoryUtil.getInstance();

	public ModelCheckingOnFileCommand() {
		super("Model Checking");
	}

	boolean goAhead = false;
	String alg_type;
	String check_type;
	String property;
	boolean isProgrExec;

	@Override
	public void execPreJobOperations(ExecutionEvent event, IProgressMonitor monitor) throws Exception {

		// boolean isDiscreteTime = MessageTimeModelDialog.openQuestion();

		isProgrExec = isProgrammaticallyExecuted(event);
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

			File smvFile = nuXmvDialogUtil.getSmvFileFromFileDialog(nuXmvDirectoryUtil.getSmvFileDirectory());
			String resultFilePath = nuXmvDirectoryUtil.getModelCheckingResultPath(smvFile.getName());
			nuXmvService.modelCheckingCommand(smvFile.getPath(), property, alg_type, check_type, 
					resultFilePath, isProgrExec, false);
		}

	}

}
