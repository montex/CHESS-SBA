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

import org.polarsys.chess.service.internal.utils.SelectionUtil;
import org.polarsys.chess.verificationService.services.SmvExportService;

import eu.fbk.eclipse.standardtools.commands.AbstractAsyncJobCommand;
import eu.fbk.eclipse.standardtools.nuXmvService.dialogs.NuXmvParametersDialog;
import eu.fbk.eclipse.standardtools.nuXmvService.services.NuXmvService;

/**
 * 
 *
 */
public class ModelCheckingCommand extends AbstractAsyncJobCommand {

	private SelectionUtil selectionUtil = SelectionUtil.getInstance();
	//private OCRADirectoryUtil ocraDirectoryUtil = OCRADirectoryUtil.getInstance();
	private SmvExportService smvExportService = SmvExportService.getInstance();
	private NuXmvService nuXmvService = NuXmvService.getInstance();

	public ModelCheckingCommand() {
		super("Model Checking");
	}

	@Override
	public void execJobCommand(ExecutionEvent event, IProgressMonitor monitor) throws Exception {

		Class umlSelectedComponent = selectionUtil.getUmlComponentFromSelectedObject(event);
		//String smvOutputFilePath = ocraDirectoryUtil.getOSSFilePath();
		boolean showPopups = false;
		
		File smvOutput = smvExportService.exportSmv( umlSelectedComponent,showPopups, monitor);

		if (smvOutput != null) {
			
			final NuXmvParametersDialog dialog = new NuXmvParametersDialog();
			dialog.open();

			if (dialog.goAhead()) {
				String alg_type = dialog.getAlgorithmType();
				String check_type = dialog.getCheckType();
				String property = dialog.getProperty();
				nuXmvService.modelCheckingCommand(smvOutput, property, alg_type, check_type);
			}

		}
	}

}
