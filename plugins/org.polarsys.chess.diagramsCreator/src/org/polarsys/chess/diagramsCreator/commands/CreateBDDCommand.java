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
import eu.fbk.eclipse.standardtools.utils.ui.commands.AbstractJobCommand;
import eu.fbk.eclipse.standardtools.utils.ui.utils.CommandBuilder;

public class CreateBDDCommand extends AbstractJobCommand {

	public CreateBDDCommand() {
		super("Create BDD");
	}

	@Override
	public void execPreJobOperations(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
	}

	@Override
	public void execJobCommand(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
		
		// Call the command to create the diagram and populate it
		final String BDD_CREATOR_COMMAND = "org.polarsys.chess.diagramsCreator.commands.createBDDHandler";
		try {
			final CommandBuilder diagramBDDCreator = CommandBuilder.build(BDD_CREATOR_COMMAND);
			diagramBDDCreator.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Call the command to arrange the components
		//FIXME: I should be sure that the command was executed in a correct way
		final String ARRANGE_COMMAND = "org.eclipse.papyrus.uml.diagram.menu.commands.ArrangeAllCommand";
		try {
			CommandBuilder arrangeElements = CommandBuilder.build(ARRANGE_COMMAND);
			arrangeElements.execute();
			arrangeElements.execute(); // Call it twice, the second run is better than the first
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
