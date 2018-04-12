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

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.Class;
import org.polarsys.chess.diagramsCreator.actions.ShowIBDElementsAction;
import org.polarsys.chess.service.gui.utils.SelectionUtil;

import eu.fbk.eclipse.standardtools.utils.ui.utils.DialogUtil;

/**
 * This class is a command that is invoked by another command.
 * It will start the creation of a single IBD.
 * @author cristofo
 *
 */
public class CreateIBDSingleHandler extends AbstractHandler {
	private static final String DIALOG_TITLE =	"Single IBD creator";
	
	/** Boolean flag that indicates whether or not the ports should be displayed in alphabetical order */
	public static final String SORTED_PORTS = "sortedPorts";

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final ISelection selection = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();
		final Object umlObject = SelectionUtil.getInstance().getUmlSelectedObject(selection);
		final ShowIBDElementsAction action = new ShowIBDElementsAction();

		// Parameter reading
		final boolean sortedPorts = (event.getParameter(SORTED_PORTS) != null && event.getParameter(SORTED_PORTS).equals("true")) ? true : false;

		if (umlObject instanceof Class) {
			try {
				final Diagram diagram = action.addIBD((Class) umlObject);
				action.populateDiagram(diagram, umlObject, sortedPorts);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			DialogUtil.getInstance().showMessage_GenericMessage(DIALOG_TITLE, "Please select a Block from the <<SystemView>> package");
		}
		return null;
	}
}
