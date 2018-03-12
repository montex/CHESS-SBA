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
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.AssociationEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.AssociationLinkLabelSourceMultiplicityEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.AssociationLinkLabelSourceRoleEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.AssociationLinkLabelTargetMultiplicityEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.AssociationLinkLabelTargetRoleEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.NamedElementLinkLabelNameEditPart;
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

		final TransactionalEditingDomain domain = 
				TransactionUtil.getEditingDomain(((IGraphicalEditPart) selectedEditPart).getNotationView());
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {

				// Loop on the array to find the associations
				for (int i = 0; i < values.length; i++) {
					if (values[i] instanceof AssociationEditPart) {

						// Add the association Edit Part to the list to be modified
						add(associationEditParts, (AssociationEditPart) values[i]);
					} else if (values[i] instanceof NamedElementLinkLabelNameEditPart) {

						// This will hide the name of the association
						((IGraphicalEditPart)values[i]).getNotationView().setVisible(false);
					} else if (values[i] instanceof AssociationLinkLabelSourceRoleEditPart) {

						// This will remove the "+" and name of the component instance on child size
//						((IGraphicalEditPart)values[i]).getNotationView().setVisible(false);
					} else if (values[i] instanceof AssociationLinkLabelSourceMultiplicityEditPart) {

						// This will remove the "1" label on child side
						((IGraphicalEditPart)values[i]).getNotationView().setVisible(false);
					} else if (values[i] instanceof AssociationLinkLabelTargetRoleEditPart) {

						// This will remove the "+" label on father side
						((IGraphicalEditPart)values[i]).getNotationView().setVisible(false);
					} else if (values[i] instanceof AssociationLinkLabelTargetMultiplicityEditPart) {

						// This will remove the "1" label on father side
						((IGraphicalEditPart)values[i]).getNotationView().setVisible(false);
					}
				}
			}
		});

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
