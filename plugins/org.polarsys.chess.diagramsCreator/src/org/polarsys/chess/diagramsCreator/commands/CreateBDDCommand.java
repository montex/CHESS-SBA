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
	private static final String BDD_CREATOR_COMMAND = "org.polarsys.chess.diagramsCreator.commands.createBDDHandler";
	private static final String ARRANGE_COMMAND = "org.polarsys.chess.diagramsCreator.commands.arrangeHandler";
	private static final String ADJUST_COMMAND = "org.polarsys.chess.diagramsCreator.commands.adjustAssociationsHandler";
	private static final String FITZOOM_COMMAND = "org.eclipse.papyrus.uml.diagram.menu.commands.ZoomFitCommand";

	public static final String ARRANGE_LOOP_TIMES = "loop_times";
	public static final String ARRANGE_PROCESS_DIAGRAM = "process_diagram";
	
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
			
			arrangeElements.setParameter(ARRANGE_LOOP_TIMES, "3");	// Number of times to call the command
			arrangeElements.setParameter(ARRANGE_PROCESS_DIAGRAM, "true"); // Process the diagram itself, default
			
			ParameterizedCommand parameterizedCommand = arrangeElements.getCommand();

			// Check if there is a handler, in case of wrong package it won't be handled
			if(parameterizedCommand != null && 
					(parameterizedCommand.getCommand().getHandler() != null) &&
					(parameterizedCommand.getCommand().getHandler().isHandled())) {

				arrangeElements.execute();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
						
		// Call the command to adjust the associations
		try {
			final CommandBuilder adjustAssociations = CommandBuilder.build(ADJUST_COMMAND);
			
			ParameterizedCommand parameterizedCommand = adjustAssociations.getCommand();

			// Check if there is a handler, in case of wrong package it won't be handled
			if(parameterizedCommand != null && 
					(parameterizedCommand.getCommand().getHandler() != null) &&
					(parameterizedCommand.getCommand().getHandler().isHandled())) {

				adjustAssociations.execute();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Call the command to fit the diagram in the screen
		try {
			final CommandBuilder fitDiagram = CommandBuilder.build(FITZOOM_COMMAND);

			ParameterizedCommand parameterizedCommand = fitDiagram.getCommand();

			// Check if there is a handler, in case of wrong package it won't be handled
			if(parameterizedCommand != null && 
					(parameterizedCommand.getCommand().getHandler() != null) &&
					(parameterizedCommand.getCommand().getHandler().isHandled())) {

				fitDiagram.execute();
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
