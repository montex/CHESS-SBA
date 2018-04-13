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
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.RoutingStyle;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.AssociationEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.AssociationLinkLabelSourceMultiplicityEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.AssociationLinkLabelSourceRoleEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.AssociationLinkLabelTargetMultiplicityEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.AssociationLinkLabelTargetRoleEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.NamedElementLinkLabelNameEditPart;
import org.eclipse.papyrus.uml.diagram.menu.actions.LineStyleAction;
import org.eclipse.papyrus.uml.diagram.stereotype.edition.editpart.AppliedStereotypeEmptyEditPart;
import org.polarsys.chess.service.gui.utils.SelectionUtil;

/**
 * This class handles some options to display labels in the diagram.
 * @author cristofo
 *
 */
public class AdjustAssociationsHandler extends AbstractHandler {
	
	/** Boolean flag that indicates whether or not the associations names should be displayed */
	public static final String SHOW_ASSOCIATIONS_NAMES = "show_associations_names";

	/** Boolean flag that indicates whether or not the stereotypes should be displayed */
	public static final String SHOW_STEREOTYPES = "show_stereotypes";

	/** Boolean flag that indicates whether or not the source role should be displayed */
	public static final String SHOW_SOURCE_ROLE = "show_source_role";

	/** Boolean flag that indicates whether or not the source role should be displayed */
	public static final String SHOW_SOURCE_MULTIPLICITY = "show_source_multiplicity";

	/** Boolean flag that indicates whether or not the source role should be displayed */
	public static final String SHOW_TARGET_ROLE = "show_target_role";

	/** Boolean flag that indicates whether or not the source role should be displayed */
	public static final String SHOW_TARGET_MULTIPLICITY = "show_target_multiplicity";

	/** Routing style for the connectors, values as specified below */
	public static final String ROUTING_STYLE = "routing_style";
	
	/** Rectilinear style for the connectors */
	public static final String RECTILINEAR = "rectilinear";

	/** Oblique style for the connectors */
	public static final String OBLIQUE = "oblique";
		
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
		
		// Parameters reading
		final boolean showAssociationsNames = (event.getParameter(SHOW_ASSOCIATIONS_NAMES) != null && event.getParameter(SHOW_ASSOCIATIONS_NAMES).equals("true")) ? true : false;
		final boolean showStereotypes = (event.getParameter(SHOW_STEREOTYPES) != null && event.getParameter(SHOW_STEREOTYPES).equals("true")) ? true : false;
		final boolean showSourceRole = (event.getParameter(SHOW_SOURCE_ROLE) != null && event.getParameter(SHOW_SOURCE_ROLE).equals("true")) ? true : false;
		final boolean showSourceMultiplicity = (event.getParameter(SHOW_SOURCE_MULTIPLICITY) != null && event.getParameter(SHOW_SOURCE_MULTIPLICITY).equals("true")) ? true : false;
		final boolean showTargetRole = (event.getParameter(SHOW_TARGET_ROLE) != null && event.getParameter(SHOW_TARGET_ROLE).equals("true")) ? true : false;
		final boolean showTargetMultiplicity = (event.getParameter(SHOW_TARGET_MULTIPLICITY) != null && event.getParameter(SHOW_TARGET_MULTIPLICITY).equals("true")) ? true : false;
		final String selectedRoutingStyle = event.getParameter(ROUTING_STYLE);

		final GraphicalEditPart selectedEditPart = SelectionUtil.getInstance().getSelectedGraphicalObject(event);
		
		// List to contain the editparts to adjust
		final List<IGraphicalEditPart> associationEditParts = new ArrayList<IGraphicalEditPart>();
		
		// Get all the EditParts of the diagram
		final Map<?, ?> elements = selectedEditPart.getViewer().getEditPartRegistry();
		Object[] values = elements.values().toArray();

		final TransactionalEditingDomain domain = 
				TransactionUtil.getEditingDomain(((IGraphicalEditPart) selectedEditPart).getNotationView());
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {

				RoutingStyle routingStyle = null;
				
				// Loop on the array to find the associations
				for (int i = 0; i < values.length; i++) {
					if (values[i] instanceof AssociationEditPart) {

						// Add the association Edit Part to the list to be modified
						add(associationEditParts, (AssociationEditPart) values[i]);
						
						// Set the closest distance flag on the association
						routingStyle = (RoutingStyle) ((AssociationEditPart) values[i]).getNotationView().getStyle(NotationPackage.eINSTANCE.getRoutingStyle());
						if (routingStyle != null) {
							routingStyle.setClosestDistance(true);
						}
					} else if (values[i] instanceof AppliedStereotypeEmptyEditPart) {
						if (!showStereotypes) {

							// Hide stereotype labels <<Block, SubSystem, ComponentInstance, etc.>>
							((IGraphicalEditPart) values[i]).getNotationView().setVisible(false);
						}
					} else if (values[i] instanceof NamedElementLinkLabelNameEditPart) {
						if (!showAssociationsNames) {

							// This will hide the name of the association
							((IGraphicalEditPart) values[i]).getNotationView().setVisible(false);
						}
					} else if (values[i] instanceof AssociationLinkLabelSourceRoleEditPart) {
						if (!showSourceRole) {
							
							// This will remove the "+" and name of the component instance on child size
							((IGraphicalEditPart) values[i]).getNotationView().setVisible(false);
						}
					} else if (values[i] instanceof AssociationLinkLabelSourceMultiplicityEditPart) {
						if (!showSourceMultiplicity) {
							
							// This will remove the "1" label on child side
							((IGraphicalEditPart) values[i]).getNotationView().setVisible(false);
						}
					} else if (values[i] instanceof AssociationLinkLabelTargetRoleEditPart) {
						if (!showTargetRole) {

							// This will remove the "+" label on father side
							((IGraphicalEditPart) values[i]).getNotationView().setVisible(false);
						}
					} else if (values[i] instanceof AssociationLinkLabelTargetMultiplicityEditPart) {
						if (!showTargetMultiplicity) {
							
							// This will remove the "1" label on father side
							((IGraphicalEditPart) values[i]).getNotationView().setVisible(false);
						}
					}
				}
			}
		});

		// Get the command to adjust the lines
		LineStyleAction action = null;
		if (selectedRoutingStyle != null && selectedRoutingStyle.equals(RECTILINEAR)) {
			action = new LineStyleAction(LineStyleAction.RECTILINEAR, associationEditParts);
		} else {
			action = new LineStyleAction(LineStyleAction.REMOVE_BENDPOINTS, associationEditParts);			
		}
		
		final Command cmd = action.getCommand();
		
		// Call the command
		if (cmd.canExecute()) {
			cmd.execute();
		}
		return null;
	}
}
