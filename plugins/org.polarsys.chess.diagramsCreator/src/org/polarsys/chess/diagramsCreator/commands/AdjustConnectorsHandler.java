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

import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Routing;
import org.eclipse.gmf.runtime.notation.RoutingStyle;
import org.eclipse.gmf.runtime.notation.impl.LocationImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSDecorationNodeImpl;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.CustomFlowPortAppliedStereotypeEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.FlowPortAffixedLabelNameEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.ConnectorEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.ConnectorLinkLabelEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.PortAffixedLabelNameEditPart;
import org.eclipse.papyrus.uml.diagram.stereotype.edition.editpart.AppliedStereotypeEmptyEditPart;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Stereotype;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;
import org.polarsys.chess.service.gui.utils.SelectionUtil;

public class AdjustConnectorsHandler extends AbstractHandler {

	/** Boolean flag that indicates whether or not the connectors names should be displayed */
	public static final String SHOW_CONNECTORS = "show_connectors";

	/** Boolean flag that indicates whether or not the FlowPort label should be displayed */
	public static final String SHOW_FLOWPORTS = "show_flowports";

	/** Boolean flag that indicates whether or not the instances stereotypes should be displayed */
	public static final String SHOW_STEREOTYPES = "show_stereotypes";

	/** Routing style for the connectors, values as specified below */
	public static final String ROUTING_STYLE = "routing_style";
	
	/** Rectilinear style for the connectors */
	public static final String RECTILINEAR = "rectilinear";

	/** Oblique style for the connectors */
	public static final String OBLIQUE = "oblique";
		
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
	
		// Parameter reading
		final boolean showFlowPorts = (event.getParameter(SHOW_FLOWPORTS) != null && event.getParameter(SHOW_FLOWPORTS).equals("true")) ? true : false;
		final boolean showConnectors = (event.getParameter(SHOW_CONNECTORS) != null && event.getParameter(SHOW_CONNECTORS).equals("true")) ? true : false;
		final boolean showStereotypes = (event.getParameter(SHOW_STEREOTYPES) != null && event.getParameter(SHOW_STEREOTYPES).equals("true")) ? true : false;
		final String selectedRoutingStyle = event.getParameter(ROUTING_STYLE);
		
		final GraphicalEditPart selectedEP = SelectionUtil.getInstance().getSelectedGraphicalObject(event);
		final GraphicalEditPart mainElementEP = (GraphicalEditPart) selectedEP.getChildren().get(0);
		
		// Get all the EditParts of the diagram
		final Map<?, ?> elements = selectedEP.getViewer().getEditPartRegistry();
		final Object[] editParts = elements.values().toArray();

		final TransactionalEditingDomain domain = 
				TransactionUtil.getEditingDomain(((IGraphicalEditPart) selectedEP).getNotationView());
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {

				// Loop on the edit parts to find interesting elements
				for (int i = 0; i < editParts.length; i++) {
					
//					System.out.println("\neditpart = " + editParts[i]);
//					if (editParts[i] instanceof IGraphicalEditPart) { 
//						System.out.println("\teditpart element = " + ((IGraphicalEditPart) editParts[i]).resolveSemanticElement());
//					}
//					
					if (editParts[i] instanceof AppliedStereotypeEmptyEditPart) {
						if (!showStereotypes) {
							
							final Element element = (Element) ((IGraphicalEditPart) editParts[i]).resolveSemanticElement();
							if (element instanceof Stereotype && !(((Stereotype) element).getName().equals("FlowPort") ||
									((Stereotype) element).getName().equals("DelegationConstraint"))) {

								// Hide stereotype labes <<Block, SubSystem, ComponentInstance, etc.>>, but not part and property
								((IGraphicalEditPart) editParts[i]).getNotationView().setVisible(false);
							}
						}
					} else if (editParts[i] instanceof ConnectorLinkLabelEditPart) {
						if (!showConnectors) {
							
							// Hide the name of the connector
							((IGraphicalEditPart) editParts[i]).getNotationView().setVisible(false);
						}
					} else if (editParts[i] instanceof FlowPortAffixedLabelNameEditPart) {
						
						// Label containing the name of the port
						final FlowPortAffixedLabelNameEditPart editPart = (FlowPortAffixedLabelNameEditPart) editParts[i];
						final CSSDecorationNodeImpl view = (CSSDecorationNodeImpl) editPart.getNotationView();
						final LocationImpl layout = (LocationImpl) view.getLayoutConstraint();
						
						// Get the port owning the label
						final Port port = (Port) ((FlowPortAffixedLabelNameEditPart) editParts[i]).resolveSemanticElement();
						final int textLength = port.getName().length() + port.getType().getName().length();

						// Determine the owner and the direction of port to position the label
						if (EntityUtil.getInstance().isInputPort(port)) {
							if(editPart.getParent().getParent() == mainElementEP) {
								layout.setX(layout.getX() - 55 - 7 * textLength);
							} else {
								layout.setX(layout.getX() + 20);
							}
						} else {
							if(editPart.getParent().getParent() == mainElementEP) {
								layout.setX(layout.getX() + 20);
							} else {
								layout.setX(layout.getX() - 55 - 7 * textLength);
							}
						}
					} else if (editParts[i] instanceof PortAffixedLabelNameEditPart) {
						
						// Label containing the name of the port
						final PortAffixedLabelNameEditPart editPart = (PortAffixedLabelNameEditPart) editParts[i];
						final CSSDecorationNodeImpl view = (CSSDecorationNodeImpl) editPart.getNotationView();
						final LocationImpl layout = (LocationImpl) view.getLayoutConstraint();
						
						// Get the port owning the label
						final Port port = (Port) ((PortAffixedLabelNameEditPart) editParts[i]).resolveSemanticElement();
						final int textLength = port.getName().length() + port.getType().getName().length();

						// Determine the owner and the direction of port to position the label
						if (EntityUtil.getInstance().isInputPort(port)) {
							if(editPart.getParent().getParent() == mainElementEP) {
								layout.setX(layout.getX() - 30 - 7 * textLength);
							} else {
								layout.setX(layout.getX() + 20);
							}
						} else {
							if(editPart.getParent().getParent() == mainElementEP) {
								layout.setX(layout.getX() + 20);
							} else {
								layout.setX(layout.getX() - 30 - 7 * textLength);
							}
						}
					} else if (editParts[i] instanceof CustomFlowPortAppliedStereotypeEditPart) {
						if (showFlowPorts) {
						
							// Adjust the label containing <<flowport>>
							CustomFlowPortAppliedStereotypeEditPart editPart = (CustomFlowPortAppliedStereotypeEditPart) editParts[i];
							CSSDecorationNodeImpl view = (CSSDecorationNodeImpl) editPart.getNotationView();
							org.eclipse.gmf.runtime.notation.impl.LocationImpl layout = (org.eclipse.gmf.runtime.notation.impl.LocationImpl) view.getLayoutConstraint();
							
							// Move up the label
							layout.setY(layout.getY() - 15);
	
							// Get the port owning the label
							Port port = (Port) ((CustomFlowPortAppliedStereotypeEditPart) editParts[i]).resolveSemanticElement();
							
							// Determine the owner and the direction of port to position the label
							if (EntityUtil.getInstance().isInputPort(port)) {
								if(editPart.getParent().getParent() == selectedEP.getChildren().get(0)) {
									layout.setX(layout.getX() - 65);
								} else {
									layout.setX(layout.getX() + 20);
								}
							} else {
								if(editPart.getParent().getParent() == selectedEP.getChildren().get(0)) {
									layout.setX(layout.getX() + 20);
								} else {
									layout.setX(layout.getX() - 65);
								}
							}
						} else {
							
							// Hide the label containing <<FlowPort>>
							((IGraphicalEditPart) editParts[i]).getNotationView().setVisible(false);
						}
					} else if (editParts[i] instanceof ConnectorEditPart) {
						
						// The connector itself, set the Avoid Obstruction flag and the routing style
						ConnectorEditPart connectorEP = (ConnectorEditPart) editParts[i];
						RoutingStyle routingStyle = (RoutingStyle) connectorEP.getNotationView().getStyle(NotationPackage.eINSTANCE.getRoutingStyle());
						if (routingStyle != null) {
							routingStyle.setAvoidObstructions(true);
							if (selectedRoutingStyle != null && selectedRoutingStyle.equals(RECTILINEAR)) {
								routingStyle.setRouting(Routing.RECTILINEAR_LITERAL);
							} else {
								routingStyle.setRouting(Routing.MANUAL_LITERAL);
							}
						}
					}
				}
			}
		});

		return null;
	}
}
