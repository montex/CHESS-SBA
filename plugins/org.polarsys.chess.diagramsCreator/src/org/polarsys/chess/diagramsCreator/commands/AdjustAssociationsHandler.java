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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.AssociationEditPart;
import org.eclipse.papyrus.uml.diagram.menu.actions.LineStyleAction;
import org.polarsys.chess.service.gui.utils.SelectionUtil;

public class AdjustAssociationsHandler extends AbstractHandler {

	/**
	 * Adds the given EditPart to the list.
	 * @param selectedEditParts the list of EditParts
	 * @param nextPart the EditPart to add
	 */
	private void add(List<IGraphicalEditPart> selectedEditParts, IGraphicalEditPart nextPart) {
		if (nextPart.isSelectable()) {
			selectedEditParts.add(nextPart);
		}
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final GraphicalEditPart selectedEditPart = SelectionUtil.getInstance().getSelectedGraphicalObject(event);
		
		// List to contain the editparts to adjust
		final List<IGraphicalEditPart> associationEditParts = new ArrayList<IGraphicalEditPart>();
		
		// Get all the EditParts 
		final Map<?, ?> elements = selectedEditPart.getViewer().getEditPartRegistry();
		
		Object[] values = elements.values().toArray();

		// Loop on the array to find the associations
		for (int i = 0; i < values.length; i++) {
			if (values[i] instanceof AssociationEditPart) {
				add(associationEditParts, (AssociationEditPart) values[i]);
			}
		}

		// Get the command to adjust the lines
//		final LineStyleAction action = new LineStyleAction(LineStyleAction.RECTILINEAR, associationEditParts);
		final LineStyleAction action = new LineStyleAction(LineStyleAction.REMOVE_BENDPOINTS, associationEditParts);
		final Command cmd = action.getCommand();
		
		// Call the command
		if (cmd.canExecute()) {
			cmd.execute();
		}
		return null;
	}
}
