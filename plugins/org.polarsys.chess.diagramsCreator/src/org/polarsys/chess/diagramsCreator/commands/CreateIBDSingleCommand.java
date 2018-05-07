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
<<<<<<< HEAD
//import org.eclipse.swt.widgets.Shell;
//import org.eclipse.ui.PlatformUI;
//import org.polarsys.chess.diagramsCreator.dialogs.IBDCreatorDialog;
=======
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.polarsys.chess.diagramsCreator.dialogs.IBDCreatorDialog;
>>>>>>> branch 'neon' of https://git.polarsys.org/r/chess/chess

import eu.fbk.eclipse.standardtools.utils.ui.commands.AbstractJobCommand;
import eu.fbk.eclipse.standardtools.utils.ui.utils.CommandBuilder;

/**
 * Class that creates a single IBD by calling different handlers. 
 * It is triggered by the contextual menu item on a single element.
 * @author cristofo
 *
 */
public class CreateIBDSingleCommand extends AbstractJobCommand {
	private static final String IBD_CREATOR_COMMAND = "org.polarsys.chess.diagramsCreator.commands.createIBDHandler";
	private static final String ARRANGE_COMMAND = "org.polarsys.chess.diagramsCreator.commands.arrangeHandler";
	private static final String ADJUST_COMMAND = "org.polarsys.chess.diagramsCreator.commands.adjustConnectorsHandler";

<<<<<<< HEAD
//	private IBDCreatorDialog dialog;
=======
	private IBDCreatorDialog dialog;
>>>>>>> branch 'neon' of https://git.polarsys.org/r/chess/chess

	public CreateIBDSingleCommand() {
		super("Create IBD Single");
	}

	@Override
	public void execPreJobOperations(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
		
<<<<<<< HEAD
//		// Display a dialog to set diagram parameters
//		final Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
//		dialog = new IBDCreatorDialog(shell, true);
//		dialog.open();
=======
		// Display a dialog to set diagram parameters
		final Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		dialog = new IBDCreatorDialog(shell, true);
		dialog.open();
>>>>>>> branch 'neon' of https://git.polarsys.org/r/chess/chess
	}

	@Override
	public void execJobCommand(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
		
<<<<<<< HEAD
//		if (dialog.goAhead()) {
			
			// Call the command to create the diagram and populate it
			try {
				final CommandBuilder diagramIBDCreator = CommandBuilder.build(IBD_CREATOR_COMMAND);

				diagramIBDCreator.setParameter(CreateIBDSingleHandler.SORTED_PORTS, "true");	

//				// Parameter settings
//				if (dialog.getPortLexicographicallyOrder()) {
//					diagramIBDCreator.setParameter(CreateIBDSingleHandler.SORTED_PORTS, "true");	
//				}
				
				diagramIBDCreator.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			// Call the command to adjust connectors and labels
			try {
				final CommandBuilder adjustConnectors = CommandBuilder.build(ADJUST_COMMAND);
				
//				// Parameter settings
//				if (dialog.getShowConnectors()) {
//					adjustConnectors.setParameter(AdjustConnectorsHandler.SHOW_CONNECTORS, "true");	
//				} else {
//					adjustConnectors.setParameter(AdjustConnectorsHandler.SHOW_CONNECTORS, "false");
//				}
//				if (dialog.getShowFlowPorts()) {
//					adjustConnectors.setParameter(AdjustConnectorsHandler.SHOW_FLOWPORTS, "true");	
//				} else {
//					adjustConnectors.setParameter(AdjustConnectorsHandler.SHOW_FLOWPORTS, "false");
//				}
//				if (dialog.getShowStereotypes()) {
//					adjustConnectors.setParameter(AdjustConnectorsHandler.SHOW_STEREOTYPES, "true");
//				} else {
//					adjustConnectors.setParameter(AdjustConnectorsHandler.SHOW_STEREOTYPES, "false");
//				}
//				if (dialog.getRectilinearRouting()) {
//					adjustConnectors.setParameter(AdjustConnectorsHandler.ROUTING_STYLE, AdjustConnectorsHandler.RECTILINEAR);
//				} else {
//					adjustConnectors.setParameter(AdjustConnectorsHandler.ROUTING_STYLE, AdjustConnectorsHandler.OBLIQUE);
//				}
				
				adjustConnectors.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			Thread.sleep(1000); //FIXME: da investigare se conviene
			
			// Call the command to arrange the components
			try {
				final CommandBuilder arrangeElements = CommandBuilder.build(ARRANGE_COMMAND);
				
				// Do not process the diagram but its main element content
				arrangeElements.setParameter(ArrangeHandler.PROCESS_DIAGRAM, "false");
				
				// Call the command only one time
				arrangeElements.setParameter(ArrangeHandler.LOOP_TIMES, "1");
	
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
//		}
=======
		if (dialog.goAhead()) {
			
			// Call the command to create the diagram and populate it
			try {
				final CommandBuilder diagramIBDCreator = CommandBuilder.build(IBD_CREATOR_COMMAND);
				
				// Parameter settings
				if (dialog.getPortLexicographicallyOrder()) {
					diagramIBDCreator.setParameter(CreateIBDSingleHandler.SORTED_PORTS, "true");	
				}
				
				diagramIBDCreator.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			// Call the command to adjust connectors and labels
			try {
				final CommandBuilder adjustConnectors = CommandBuilder.build(ADJUST_COMMAND);
				
				// Parameter settings
				if (dialog.getShowConnectors()) {
					adjustConnectors.setParameter(AdjustConnectorsHandler.SHOW_CONNECTORS, "true");	
				} else {
					adjustConnectors.setParameter(AdjustConnectorsHandler.SHOW_CONNECTORS, "false");
				}
				if (dialog.getShowFlowPorts()) {
					adjustConnectors.setParameter(AdjustConnectorsHandler.SHOW_FLOWPORTS, "true");	
				} else {
					adjustConnectors.setParameter(AdjustConnectorsHandler.SHOW_FLOWPORTS, "false");
				}
				if (dialog.getShowStereotypes()) {
					adjustConnectors.setParameter(AdjustConnectorsHandler.SHOW_STEREOTYPES, "true");
				} else {
					adjustConnectors.setParameter(AdjustConnectorsHandler.SHOW_STEREOTYPES, "false");
				}
				if (dialog.getRectilinearRouting()) {
					adjustConnectors.setParameter(AdjustConnectorsHandler.ROUTING_STYLE, AdjustConnectorsHandler.RECTILINEAR);
				} else {
					adjustConnectors.setParameter(AdjustConnectorsHandler.ROUTING_STYLE, AdjustConnectorsHandler.OBLIQUE);
				}
				
				adjustConnectors.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			Thread.sleep(1000); //FIXME: da investigare se conviene
			
			// Call the command to arrange the components
			try {
				final CommandBuilder arrangeElements = CommandBuilder.build(ARRANGE_COMMAND);
				
				// Do not process the diagram but its main element content
				arrangeElements.setParameter(ArrangeHandler.PROCESS_DIAGRAM, "false");
				
				// Call the command only one time
				arrangeElements.setParameter(ArrangeHandler.LOOP_TIMES, "1");
	
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
		}

>>>>>>> branch 'neon' of https://git.polarsys.org/r/chess/chess
	}
}
