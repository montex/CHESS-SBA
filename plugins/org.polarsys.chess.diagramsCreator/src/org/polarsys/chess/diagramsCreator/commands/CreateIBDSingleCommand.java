/*******************************************************************************
 * Copyright (C) 2018 Fondazione Bruno Kessler.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *     Luca Cristoforetti - initial API and implementation
 ******************************************************************************/
package org.polarsys.chess.diagramsCreator.commands;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.IProgressMonitor;
import eu.fbk.eclipse.standardtools.commands.AbstractJobCommand;
import eu.fbk.eclipse.standardtools.utils.CommandBuilder;

public class CreateIBDSingleCommand extends AbstractJobCommand {
	public CreateIBDSingleCommand() {
		super("Create IBD Single");
	}
		
	@Override
	public void execPreJobOperations(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
	}

	@Override
	public void execJobCommand(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
		final String BDD_CREATOR_COMMAND = "org.polarsys.chess.diagramsCreator.createIBDHandler";
		try {
			final CommandBuilder diagramBDDCreator = CommandBuilder.build(BDD_CREATOR_COMMAND);
			diagramBDDCreator.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
