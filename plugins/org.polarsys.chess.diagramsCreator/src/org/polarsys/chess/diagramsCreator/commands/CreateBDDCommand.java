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
//import org.eclipse.swt.widgets.Shell;
//import org.eclipse.ui.PlatformUI;
//import org.polarsys.chess.diagramsCreator.dialogs.BDDCreatorDialog;

import eu.fbk.eclipse.standardtools.utils.ui.commands.AbstractJobCommand;
import eu.fbk.eclipse.standardtools.utils.ui.utils.CommandBuilder;

/**
 * Class that creates a BDD by calling different handlers. 
 * It is triggered by the contextual menu item on a package.
 * @author cristofo
 *
 */
public class CreateBDDCommand extends AbstractJobCommand {
	private static final String BDD_CREATOR_COMMAND = "org.polarsys.chess.diagramsCreator.commands.createBDDHandler";
	private static final String ARRANGE_COMMAND = "org.polarsys.chess.diagramsCreator.commands.arrangeHandler";
//	private static final String ADJUST_COMMAND = "org.polarsys.chess.diagramsCreator.commands.adjustAssociationsHandler";
	private static final String FITZOOM_COMMAND = "org.eclipse.papyrus.uml.diagram.menu.commands.ZoomFitCommand";

//	private BDDCreatorDialog dialog;

	public CreateBDDCommand() {
		super("Create BDD");
	}

	@Override
	public void execPreJobOperations(ExecutionEvent event, IProgressMonitor monitor) throws Exception {

		// NO MORE USED, A DIALOG IS NOT NEEDED ANYMORE
//		// Display a dialog to set diagram parameters
//		final Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
//		dialog = new BDDCreatorDialog(shell, true);
//		dialog.open();
	}

	@Override
	public void execJobCommand(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
		
//		if (dialog.goAhead()) {
			
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
				
				// Parameter settings
				arrangeElements.setParameter(ArrangeHandler.LOOP_TIMES, "3");	// Number of times to call the command
				arrangeElements.setParameter(ArrangeHandler.PROCESS_DIAGRAM, "true"); // Process the diagram itself, default
				
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
			
			// THE FOLLOWING COMMAND IS NO MORE USED, A CSS STYLE WILL TAKE CARE OF LABELS, ETC.
//			// Call the command to adjust the associations
//			try {
//				final CommandBuilder adjustAssociations = CommandBuilder.build(ADJUST_COMMAND);
//				
//				// Parameter settings
//				if (dialog.getShowStereotypes()) {
//					adjustAssociations.setParameter(AdjustAssociationsHandler.SHOW_STEREOTYPES, "true");
//				} else {
//					adjustAssociations.setParameter(AdjustAssociationsHandler.SHOW_STEREOTYPES, "false");
//				}
//				if (dialog.getShowAssociationsNames()) {
//					adjustAssociations.setParameter(AdjustAssociationsHandler.SHOW_ASSOCIATIONS_NAMES, "true");
//				} else {
//					adjustAssociations.setParameter(AdjustAssociationsHandler.SHOW_ASSOCIATIONS_NAMES, "false");
//				}
//				if (dialog.getShowSourceRole()) {
//					adjustAssociations.setParameter(AdjustAssociationsHandler.SHOW_SOURCE_ROLE, "true");
//				} else {
//					adjustAssociations.setParameter(AdjustAssociationsHandler.SHOW_SOURCE_ROLE, "false");
//				}
//				if (dialog.getShowSourceMultiplicity()) {
//					adjustAssociations.setParameter(AdjustAssociationsHandler.SHOW_SOURCE_MULTIPLICITY, "true");
//				} else {
//					adjustAssociations.setParameter(AdjustAssociationsHandler.SHOW_SOURCE_MULTIPLICITY, "false");
//				}
//				if (dialog.getShowTargetRole()) {
//					adjustAssociations.setParameter(AdjustAssociationsHandler.SHOW_TARGET_ROLE, "true");
//				} else {
//					adjustAssociations.setParameter(AdjustAssociationsHandler.SHOW_TARGET_ROLE, "false");
//				}
//				if (dialog.getShowTargetMultiplicity()) {
//					adjustAssociations.setParameter(AdjustAssociationsHandler.SHOW_TARGET_MULTIPLICITY, "true");
//				} else {
//					adjustAssociations.setParameter(AdjustAssociationsHandler.SHOW_TARGET_MULTIPLICITY, "false");
//				}
//				if (dialog.getRectilinearRouting()) {
//					adjustAssociations.setParameter(AdjustAssociationsHandler.ROUTING_STYLE, AdjustAssociationsHandler.RECTILINEAR);
//				} else {
//					adjustAssociations.setParameter(AdjustAssociationsHandler.ROUTING_STYLE, AdjustAssociationsHandler.OBLIQUE);
//				}
//				
//				ParameterizedCommand parameterizedCommand = adjustAssociations.getCommand();
//	
//				// Check if there is a handler, in case of wrong package it won't be handled
//				if(parameterizedCommand != null && 
//						(parameterizedCommand.getCommand().getHandler() != null) &&
//						(parameterizedCommand.getCommand().getHandler().isHandled())) {
//	
//					adjustAssociations.execute();
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
			
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
//		}
	}
}
