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
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.polarsys.chess.service.gui.utils.SelectionUtil;

import eu.fbk.eclipse.standardtools.utils.ui.commands.AbstractJobCommand;
import eu.fbk.eclipse.standardtools.utils.ui.utils.CommandBuilder;

public class CreateIBDSingleCommand extends AbstractJobCommand {
	private static final String BDD_CREATOR_COMMAND = "org.polarsys.chess.diagramsCreator.commands.createIBDHandler";
	private static final String ARRANGE_COMMAND = "org.polarsys.chess.diagramsCreator.commands.arrangeHandler";
	private static final String ADJUST_COMMAND = "org.polarsys.chess.diagramsCreator.commands.adjustConnectorsHandler";
	private static final String FITZOOM_COMMAND = "org.eclipse.papyrus.uml.diagram.menu.commands.ZoomFitCommand";
	
	public CreateIBDSingleCommand() {
		super("Create IBD Single");
	}
		
	@Override
	public void execPreJobOperations(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
	}

	@Override
	public void execJobCommand(ExecutionEvent event, IProgressMonitor monitor) throws Exception {

		
		final ISelection selection = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();
		
		System.out.println("selection = " + selection);
		final Object umlObject = SelectionUtil.getInstance().getUmlSelectedObject(selection);
System.out.println("umlObject = " + umlObject);
		
		
		
		// Call the command to create the diagram and populate it
		try {
			final CommandBuilder diagramIBDCreator = CommandBuilder.build(BDD_CREATOR_COMMAND);
			diagramIBDCreator.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long start = System.currentTimeMillis();
		
		// Call the command to adjust connectors and labels
		try {
			final CommandBuilder adjustConnectors = CommandBuilder.build(ADJUST_COMMAND);
			System.out.println("Time for creating object = " + (System.currentTimeMillis() - start));
			adjustConnectors.execute();
			System.out.println("Time for running code = " + (System.currentTimeMillis() - start));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Time for adjust = " + (System.currentTimeMillis() - start));
		
		
		//FIXME: non funziona perche' devo selezionare la componente, non il diagramma
		//TODO: come posso passare dei parametri?
		// Call the command to arrange the components
		try {
			final CommandBuilder arrangeElements = CommandBuilder.build(ARRANGE_COMMAND);
			
			// Do not process the diagram but its main element content
			arrangeElements.setParameter(CreateBDDCommand.ARRANGE_PROCESS_DIAGRAM, "false");
			
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
		
//		// Call the command to fit the diagram in the screen
//		try {
//			final CommandBuilder fitDiagram = CommandBuilder.build(FITZOOM_COMMAND);
//
//			ParameterizedCommand parameterizedCommand = fitDiagram.getCommand();
//
//			// Check if there is a handler, in case of wrong package it won't be handled
//			if(parameterizedCommand != null && 
//					(parameterizedCommand.getCommand().getHandler() != null) &&
//					(parameterizedCommand.getCommand().getHandler().isHandled())) {
//
//				fitDiagram.execute();
//			}			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

	}
}
