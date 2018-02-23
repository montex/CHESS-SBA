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

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.polarsys.chess.service.gui.utils.SelectionUtil;

import eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.ui.services.OCRARuntimeErrorService;
import eu.fbk.eclipse.standardtools.utils.ui.commands.AbstractAsyncJobCommand;

public class RuntimeErrorsOnFileCommand extends AbstractAsyncJobCommand {

	private SelectionUtil chessSelectionUtil = SelectionUtil.getInstance();
	private OCRARuntimeErrorService ocraRuntimeErrorService = OCRARuntimeErrorService.getInstance();

	public RuntimeErrorsOnFileCommand() {
		super("Show Runtime Errors");
	}

	@Override
	public void execJobCommand(ExecutionEvent event, IProgressMonitor monitor) throws Exception {

		boolean showNoErrorPopup = true;

		Resource modelResource = chessSelectionUtil.getSelectedModelResource();
		ocraRuntimeErrorService.showRuntimeErrors(modelResource, showNoErrorPopup, monitor);
	}

}
