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
import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.core.runtime.IProgressMonitor;
import eu.fbk.eclipse.standardtools.utils.ui.commands.AbstractJobCommand;
import eu.fbk.eclipse.standardtools.utils.ui.utils.CommandBuilder;

public class CreateBDDCommand extends AbstractJobCommand {
	final String BDD_CREATOR_COMMAND = "org.polarsys.chess.diagramsCreator.commands.createBDDHandler";
	final String ARRANGE_COMMAND = "org.eclipse.papyrus.uml.diagram.menu.commands.ArrangeAllCommand";
	final String ADJUST_COMMAND = "org.polarsys.chess.diagramsCreator.commands.adjustAssociationsHandler";
	
	public CreateBDDCommand() {
		super("Create BDD");
	}

	@Override
	public void execPreJobOperations(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
	}

	@Override
	public void execJobCommand(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
		
		// Call the command to create the diagram and populate it
		try {
			final CommandBuilder diagramBDDCreator = CommandBuilder.build(BDD_CREATOR_COMMAND);
			diagramBDDCreator.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Call the command to arrange the components
		try {
			final CommandBuilder arrangeElements = CommandBuilder.build(ARRANGE_COMMAND);
			
			ParameterizedCommand parameterizedCommand = arrangeElements.getCommand();

			// Check if there is a handler, in case of wrong package it won't be handled
			if(parameterizedCommand != null && 
					(parameterizedCommand.getCommand().getHandler() != null) &&
					(parameterizedCommand.getCommand().getHandler().isHandled())) {

				arrangeElements.execute();
				
				// Call it twice again, it may improve the layout
				arrangeElements.execute();
				arrangeElements.execute();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Call the command to adjust the associations
		try {
			final CommandBuilder adjustAssociations = CommandBuilder.build(ADJUST_COMMAND);
			adjustAssociations.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
