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
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.Class;
import org.polarsys.chess.diagramsCreator.actions.ShowIBDElementsAction;
import org.polarsys.chess.diagramsCreator.utils.Utils;
import org.polarsys.chess.service.utils.SelectionUtil;
import eu.fbk.eclipse.standardtools.commands.AbstractJobCommand;

public class CreateIBDSingleCommand extends AbstractJobCommand {
	private static final String DIALOG_TITLE =	"Single IBD creator";
	
	private ShowIBDElementsAction action;
	private Object umlObject;
	
	public CreateIBDSingleCommand() {
		super("Create IBD Single");
	}
		
	@Override
	public void execPreJobOperations(ExecutionEvent event, IProgressMonitor monitor) throws Exception {

		final ISelection selection = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();
		umlObject = SelectionUtil.getInstance().getUmlSelectedObject(selection);

//		System.out.println("\nselectedUmlElement: " + umlObject);
	
		action = new ShowIBDElementsAction();

		if (umlObject instanceof Class) {
//			System.out.println("\nValid element, can create IBD");
						
			final Diagram diagram = action.addIBD((Class) umlObject);
					
			action.populateDiagram(diagram, umlObject);
			
		} else {
			Utils.showMessage(DIALOG_TITLE, "Please select a Block from the <<SystemView>> package");
			umlObject = null;
		}
	}

	@Override
	public void execJobCommand(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
		// TODO Auto-generated method stub
		
		if (umlObject != null) {

			// Doesn't work, due to the thread status?
//			Diagram diagram = action.addIBD((Class) umlObject);
//			action.populateDiagram(diagram);
			
		}
	}
}
