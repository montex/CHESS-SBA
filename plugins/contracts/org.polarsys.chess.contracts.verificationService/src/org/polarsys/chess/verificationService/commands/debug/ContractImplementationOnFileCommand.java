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

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.IProgressMonitor;
import org.polarsys.chess.verificationService.model.ChessSystemModel;

import eu.fbk.eclipse.standardtools.ExecOcraCommands.services.OCRAExecService;
import eu.fbk.eclipse.standardtools.commands.AbstractAsyncJobCommand;

public class ContractImplementationOnFileCommand extends AbstractAsyncJobCommand {

	private OCRAExecService ocraExecService = OCRAExecService.getInstance(ChessSystemModel.getInstance());
	
	
	public ContractImplementationOnFileCommand() {
		super("Check Implementation on oss file");
	}

	@Override
	public void execJobCommand(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
		ocraExecService.executeCheckContractImplementation(monitor);
	}

}
