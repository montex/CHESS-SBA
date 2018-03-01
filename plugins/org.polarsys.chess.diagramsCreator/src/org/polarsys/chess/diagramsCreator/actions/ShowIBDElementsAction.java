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
package org.polarsys.chess.diagramsCreator.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.OffscreenEditPartFactory;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResource;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSShapeImpl;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.FlowPortAffixedNodeEditPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.InternalBlockDiagramCreateCommand;
import org.eclipse.papyrus.uml.diagram.common.actions.ShowHideContentsAction;
import org.eclipse.papyrus.uml.diagram.common.commands.ShowHideElementsRequest;
import org.eclipse.papyrus.uml.diagram.common.edit.part.PortAffixedNodeEditPart;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.polarsys.chess.contracts.profile.chesscontract.util.ContractEntityUtil;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;

public class ShowIBDElementsAction extends ShowHideContentsAction {

	/** INCREMENT for the location of the elements to show (ports and properties) */
	private static final int INCREMENT = 40;
	
	/** the main EditPart */
	private EditPart host;

	/** Selection of all the possible elements */
	private List<Object> selection;

	/**
	 * Prints a message on the console.
	 * @param message the message to print
	 */
	private void printMessageOnOut(String message) {
//		System.out.println(message);	// Comment to avoid printing
	}
	
	/**
	 * Adds a IBD diagram to the given block.
	 * @param owner the selected block
	 * @throws Exception
	 */
	public Diagram addIBD(Class owner) throws Exception {
	
		// Get the services registry
		final ServicesRegistry servicesRegistry = ServiceUtilsForResource.getInstance().getServiceRegistry(owner.eResource());
		
		// Also this should work
//		ServicesRegistry serviceRegistry = ServiceUtilsForActionHandlers.getInstance().getServiceRegistry();
		
		// Get the modelSet
		final ModelSet modelSet = ServiceUtils.getInstance().getModelSet(servicesRegistry);
		
		// Equivalent way to get modelSet
//		ModelSet modelSet = ServiceUtilsForResource.getInstance().getModelSet(owner.eResource());
		
		// Create a IBD diagram for the selected owner
		final InternalBlockDiagramCreateCommand command = new InternalBlockDiagramCreateCommand();
		return command.createDiagram(modelSet, owner, owner.getName() + "_IBD");
	}

	/**
	 * Builds a list of elements I'm interested to display.
	 * @param results the list of all the possible EditPartRepresentation elements
	 */
	@Override
	protected void buildShowHideElementsList(Object[] results) {	
		final EntityUtil entityUtil = EntityUtil.getInstance();
		final ContractEntityUtil contractEntityUtil = ContractEntityUtil.getInstance();
		
		viewsToCreate = new ArrayList<EditPartRepresentation>();
		viewsToDestroy = new ArrayList<EditPartRepresentation>();

		List<Object> result = new ArrayList<>();
		for (int i = 0; i < results.length; i++) {
			
			final EditPartRepresentation editPartRepresentation = (EditPartRepresentation) results[i];

			printMessageOnOut("\n\n\nWorking on results[" + i + "] = " + editPartRepresentation);
			
			final Element semanticElement = (Element) editPartRepresentation.getSemanticElement();
			
			printMessageOnOut("Semantic Element = " + semanticElement);
			printMessageOnOut("Label = " + editPartRepresentation.getLabel());
			
			// If the element is interesting, add it
			if(entityUtil.isPort(semanticElement) || 
					entityUtil.isComponentInstance(semanticElement) || 
					semanticElement instanceof Connector ||
					contractEntityUtil.isDelegationConstraints(semanticElement)) {
				result.add(editPartRepresentation);
			}
		}
		
		// Add the result to the views to create
		for (Object element : result) {
			if (element instanceof EditPartRepresentation) {
				viewsToCreate.add((EditPartRepresentation) element);
			}
		}
	}

	/**
	 * Completes the list of selection for the given representation and its potential children.
	 * @param listToComplete the list of selected elements to complete
	 * @param representation the edit part representation that completes the list
	 */
	private void contributeToSelection(List<Object> listToComplete, EditPartRepresentation representation) {
		
		printMessageOnOut("\n\nrepresentation = " + representation);
		printMessageOnOut("\tlistToComplete.size = " + listToComplete.size());
		
		listToComplete.addAll(representation.getPossibleElement());

		printMessageOnOut("\tlistToComplete.size = " + listToComplete.size());
		
		final List<EditPartRepresentation> children = representation.getPossibleElement();
		
		printMessageOnOut("\tChildren di representation size = " + children.size());
		
		if (children != null) {
			for (EditPartRepresentation child : children) {
				printMessageOnOut("Working on child " + child);
				contributeToSelection(listToComplete, child);
			}
		}
	}

	/**
	 * Builds the selection with all the possible elements.
	 */
	private void buildSelection() {
		selection = new ArrayList<Object>();
		for (EditPartRepresentation current : representations) {
			contributeToSelection(selection, current);
		}
	}

	/**
	 * Creates the list of commands to show the various elements.
	 */
	@Override
	protected Command getActionCommand() {
		final CompoundCommand completeCmd = new CompoundCommand("Show/Hide Inherited Elements Command"); //$NON-NLS-1$
		ShowHideElementsRequest request = null;

		// Initial position of the elements
		final Point propertyLocation = new Point(500, 20);	
		final Point portLocationLeft = new Point(-10, 20);
		final Point portLocationRight = new Point(-10, 20);
		
		for (EditPartRepresentation rep : this.viewsToCreate) {
			if (!(rep instanceof OptionalEditPartRepresentation)) {
				continue;
			}
			final EditPart editPart = ((OptionalEditPartRepresentation) rep).getParentRepresentation().getParentRepresentation().getRepresentedEditPart();
			final View compartmentView = ((OptionalEditPartRepresentation) rep).getParentRepresentation().getRepresentedEditPart().getNotationView();

			printMessageOnOut("\n\nep = " + editPart);
			printMessageOnOut("compView = " + compartmentView);

			// Get the width of the component to set the position of output ports
			final CSSShapeImpl viewShape = (CSSShapeImpl) ((IGraphicalEditPart) editPart).getNotationView();
			final Bounds layout = (Bounds) viewShape.getLayoutConstraint();
			portLocationRight.x += layout.getWidth() + 20;
			
			if (compartmentView != null) {
				request = new ShowHideElementsRequest(compartmentView, ((OptionalEditPartRepresentation) rep).getSemanticElement());
				if (isXYLayout(compartmentView, editPart)) {
					propertyLocation.x += INCREMENT;
					propertyLocation.y += INCREMENT;
					request.setLocation(new Point(propertyLocation));

				} else if (isAffixedChildNode(editPart, ((OptionalEditPartRepresentation) rep).getSemanticElement())) {				
					Element element = (Element) ((OptionalEditPartRepresentation) rep).getSemanticElement();
					if (element instanceof Port) {
						if (EntityUtil.getInstance().isInputPort(element)) {
							portLocationLeft.y += INCREMENT;
							request.setLocation(new Point(portLocationLeft));
						} else {
							portLocationRight.y += INCREMENT;
							request.setLocation(new Point(portLocationRight));
						}
					}
				}
				Command cmd = editPart.getCommand(request);
				if (cmd != null && cmd.canExecute()) {
					completeCmd.add(cmd);
				}
			}
		}
		return completeCmd;
	}

	/**
	 * Draws the ports on the inner instances.
	 * @param diagramEP the EditPart of the diagram
	 * @param umlObject the selected UML object
	 */
	private void drawComponentInstancesPorts(IGraphicalEditPart diagramEP, Object umlObject) {
		final CompoundCommand command = new CompoundCommand("Draw Component Instances Ports Commands"); //$NON-NLS-1$
		Property prop = null;
		Class propertyType = null;
		View compartmentView = null;
		Point portLocationLeft = null;
		Point portLocationRight = null;

		// Get the edit part of the main element, from the diagram edit part
		IGraphicalEditPart elementEP = (IGraphicalEditPart) diagramEP.getChildren().get(0);
		
		// Get the compartment edit part
		IGraphicalEditPart compartmentEP = (IGraphicalEditPart) elementEP.getChildren().get(1);
		
		printMessageOnOut("\nCompartment edit part = " + compartmentEP);

		List<?>compartmentChildren = compartmentEP.getChildren();
		for (Object childEP : compartmentChildren) {
			printMessageOnOut("child of compartment = " + childEP);
			
			// Get the UML element associated to the EP
			EObject semanticElement = ((IGraphicalEditPart) childEP).resolveSemanticElement();
			printMessageOnOut("SemanticElement del compartment = " + semanticElement);
									
			if (semanticElement instanceof Property) {			
			
				// Get the element type
				prop = (Property) semanticElement;
				propertyType = (Class) prop.getType(); 

				// Get the compartment view of the property
				compartmentView = ((IGraphicalEditPart) childEP).getNotationView();

				// Set the initial position of the ports
				portLocationLeft = new Point(-10, 40);
				portLocationRight = new Point(-10, 40);
				
				// Get the width of the component to set the position of output ports
				final CSSShapeImpl viewShape = (CSSShapeImpl) ((IGraphicalEditPart) childEP).getNotationView();
				final Bounds layout = (Bounds) viewShape.getLayoutConstraint();
				portLocationRight.x += layout.getWidth() + 20;

				EList<Port> ports = propertyType.getOwnedPorts();
				for (Port port : ports) {
					if (compartmentView != null) {
						
						ShowHideElementsRequest request = new ShowHideElementsRequest(compartmentView, port);
						
						printMessageOnOut("req = " + request);
						
						if (EntityUtil.getInstance().isInputPort(port)) {
							portLocationLeft.y += INCREMENT;
							request.setLocation(new Point(portLocationLeft));
						} else {
							portLocationRight.y += INCREMENT;
							request.setLocation(new Point(portLocationRight));
						}

						Command cmd = ((IGraphicalEditPart) childEP).getCommand(request);	// Cannot be the diagram EditPart
						printMessageOnOut("cmd = " + cmd);
						printMessageOnOut("cmd label = " + cmd.getLabel());
						if (cmd != null && cmd.canExecute()) {
							((CompoundCommand) command).add(cmd);
						}
					}
				}
			}
		}

		// Execute the commands
		final TransactionalEditingDomain domain  = elementEP.getEditingDomain();
		domain.getCommandStack().execute(new GEFtoEMFCommandWrapper(command));
	}

	/**
	 * Resizes the component blocks.
	 * @param diagramEP the diagram EditPart
	 */
	private void resizeElements(IGraphicalEditPart diagramEP) {

		// Get the edit part of the main element, from the diagram edit part
		final IGraphicalEditPart elementEP = (IGraphicalEditPart) diagramEP.getChildren().get(0);

		// Get the view of the main element
		final View elementView = elementEP.getNotationView();
		
		// Enlarge the main component
		if (elementView instanceof CSSShapeImpl) {
			final CSSShapeImpl viewShape = (CSSShapeImpl) elementView;
			final Bounds layout = (Bounds) viewShape.getLayoutConstraint();

			final TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(elementView);
			domain.getCommandStack().execute(new RecordingCommand(domain) {

				@Override
				protected void doExecute() {
					layout.setWidth(1000);
					layout.setHeight(600);
				}
			});
		}
		
		// Now I should resize also the inner components
		final EList<?>compartmentChildren = ((View) elementView.getChildren().get(1)).getChildren();
		EObject semanticElement = null;
		int offset = 100;

		// Loop on the children on the compartment view
		for (Object child : compartmentChildren) {
			
			// Get the UML element associated to the EP
			semanticElement = ((View) child).getElement();
			if (semanticElement instanceof Property) {			
				if (child instanceof CSSShapeImpl) {
					final CSSShapeImpl viewShape = (CSSShapeImpl) child;
					final Bounds layout = NotationFactory.eINSTANCE.createBounds();
					layout.setWidth(200);
					layout.setHeight(300);
					layout.setX(offset);
					layout.setY(200);
					offset += 250;

					final TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(child);
					domain.getCommandStack().execute(new RecordingCommand(domain) {

						@Override
						protected void doExecute() {
							viewShape.setLayoutConstraint(layout);
						}
					});
				}
			}
		}
	}
	
	/**
	 * Returns the diagram EditPart.
	 * @return
	 */
	private EditPart getHost() {
		return host;
	}
	
	/**
	 * Gets the editpart from view.
	 * @param view the view
	 * @return the EditPart from the view
	 */
	private EditPart getEditPartFromView(View view) {
		if (view != null) {
			return (EditPart) getHost().getViewer().getEditPartRegistry().get(view);
		}
		return null;
	}
	
	/**
	 * Gets the EditPart related to the given port.
	 * @param role the port
	 * @param property the component instance containing the port
	 * @param elementView the view of the element containing the component instance
	 * @return the requested EditPart
	 */
	private EditPart getPortEditPart(Port role, Property property, View elementView) {

		printMessageOnOut("\n\nLooking for port " + role.getQualifiedName());

		// If the port is inside a component instance, go inside the element
		if (property != null) {
			
			printMessageOnOut("Containing property: " + property.getQualifiedName());

			// Get the comparment view of the element 
			View compartmentView = (View) elementView.getChildren().get(1);

			// Loop on the contained elements
			for (Object child : compartmentView.getChildren()) {
				if (child instanceof CSSShapeImpl) {
					CSSShapeImpl shape = (CSSShapeImpl) child;
					
					// Check if the element is a property
					if (shape.getElement() instanceof Property) {
						Property propertyImpl = (Property) shape.getElement();
						if (propertyImpl != null) {
//							printMessageOnOut("\tpropertyImpl qualifiedName = " + propertyImpl.getQualifiedName());

							if (property.getQualifiedName().equals(propertyImpl.getQualifiedName())) {

								// Found the property containing the port, look inside the children
								EList<?> shapeChildren = shape.getChildren();
								
								for (Object childView : shapeChildren) {
									IGraphicalEditPart ep = (IGraphicalEditPart) getEditPartFromView((View) childView);
									if (ep instanceof FlowPortAffixedNodeEditPart || ep instanceof PortAffixedNodeEditPart) {
										if (role == ep.resolveSemanticElement()) {
											printMessageOnOut("\nPort found in part, view = "  + ep);
											return ep;
										}
									}
								}
							}
						}
					}
				}
			}
		} else {
			
			// The port is of the main element
			EList<?> elementChildren = elementView.getChildren();
			for (Object childView : elementChildren) {
				IGraphicalEditPart ep = (IGraphicalEditPart) getEditPartFromView((View) childView);
				if (ep instanceof FlowPortAffixedNodeEditPart || ep instanceof PortAffixedNodeEditPart) {
					if (role == ep.resolveSemanticElement()) {
						printMessageOnOut("\nPort found in main elemement, view = "  + ep);
						return ep;
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * Returns the command to show the connection line between the given edit parts.
	 * @param sourceEP the EditPart of the source port
	 * @param targetEP the EditPart of the target port
	 * @param connector the Connector between the ports
	 * @return the Command to display the link
	 */
	private Command getShowLinkCommand(EditPart sourceEP, EditPart targetEP, Connector connector) {
		
		String semanticHint = "link_uml_connector";

		IAdaptable mySemanticAdapter = new EObjectAdapter(connector) {

			public Object getAdapter(@SuppressWarnings("rawtypes") java.lang.Class adapter) {
				if (IElementType.class.equals(adapter)) {
					return org.eclipse.papyrus.uml.diagram.composite.providers.UMLElementTypes.Connector_Edge;
				}
				return super.getAdapter(adapter);
			}
		};
		
		CreateConnectionViewRequest.ConnectionViewDescriptor viewDescriptor = 
				new CreateConnectionViewRequest.ConnectionViewDescriptor(mySemanticAdapter, semanticHint, 
						ViewUtil.APPEND, false, ((GraphicalEditPart) getHost()).getDiagramPreferencesHint());
		
		CreateConnectionViewRequest ccr = new CreateConnectionViewRequest(viewDescriptor);
		ccr.setType(org.eclipse.gef.RequestConstants.REQ_CONNECTION_START);
		ccr.setSourceEditPart(sourceEP);
		sourceEP.getCommand(ccr);
		ccr.setTargetEditPart(targetEP);
		ccr.setType(org.eclipse.gef.RequestConstants.REQ_CONNECTION_END);
		return targetEP.getCommand(ccr);
	}

	/**
	 * Draws the connector lines inside the given element.
	 * @param elementEP the EditPart of the element to browse
	 */
	private void drawConnectors(IGraphicalEditPart elementEP) {
		
		Class elementClass = (Class) elementEP.resolveSemanticElement();
		View elementView = elementEP.getNotationView();
		EList<Connector> connectors = elementClass.getOwnedConnectors();
		CompoundCommand compoundCommand = new CompoundCommand("Restore A Related Link");

		// Loop on all the connectors
		for (Connector connector : connectors) {
			EditPart sourceEP = null;
			EditPart targetEP = null;
			
			// Retrieve the EP for the source port
			ConnectorEnd sourceEnd = connector.getEnds().get(0);
			if (sourceEnd != null) {
				sourceEP = getPortEditPart((Port) sourceEnd.getRole(), sourceEnd.getPartWithPort(), elementView);
			}

			// Retrieve the EP for the target port
			ConnectorEnd targetEnd = connector.getEnds().get(1);
			if (targetEnd != null) {
				targetEP = getPortEditPart((Port) targetEnd.getRole(), targetEnd.getPartWithPort(), elementView);
			}

			printMessageOnOut("\n\nFound sourceEP = " + sourceEP);
			printMessageOnOut("\nFound targetEP = " + targetEP);

			if (sourceEP != null && targetEP != null) {
				Command cmd = getShowLinkCommand(sourceEP, targetEP, connector);
				if (cmd != null && cmd.canExecute()) {
					compoundCommand.add(cmd);
				}
			}			
		}

		// Execute the commands
		final TransactionalEditingDomain domain = elementEP.getEditingDomain();
		domain.getCommandStack().execute(new GEFtoEMFCommandWrapper(compoundCommand));
	}
	
	/**
	 * Fills the diagram with graphical components.
	 * @param diagram
	 * @throws ServiceException 
	 */
	public void populateDiagram(Diagram diagram, Object umlObject) {
		
		final Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		
		// The EditPart associated to the diagram
		final IGraphicalEditPart diagramEP = OffscreenEditPartFactory.getInstance().createDiagramEditPart(diagram, shell);
		
		// Store the EditPart
		host = diagramEP;

		// The main EditPart 
		final IGraphicalEditPart selectedElementEP = (IGraphicalEditPart) diagramEP.getChildren().get(0);
		printMessageOnOut("\n\nselectedElement EditPart = " + selectedElementEP + "\n\n");
		
		// Add the selected element to the list, there could be more than one...
		selectedElements = new ArrayList<IGraphicalEditPart>();
		selectedElements.add(selectedElementEP);
				
		initAction();
		buildInitialSelection();	// initialSelection should be empty at this moment
		
		// Get a selection with all the possible elements
		buildSelection();
				
		printMessageOnOut("Selection size = " + selection.size());
		
		if (selection.size() > 0) {
			
			// Filter the list to extract only the elements I'm interested in
			buildShowHideElementsList(selection.toArray());
	
			// Create the list of commands to display the elements
			final Command command = getActionCommand();		
			
			// Execute the commands
			final TransactionalEditingDomain domain = this.selectedElements.get(0).getEditingDomain();
			domain.getCommandStack().execute(new GEFtoEMFCommandWrapper(command));
			
			// Resize the graphical elements
			resizeElements(diagramEP);
			
			// Draw the ports on the inner components
			// NB: labels are put in the wrong place, but if done in another command they are fine!
			drawComponentInstancesPorts(diagramEP, umlObject);
			
			// Draw the connectors
			drawConnectors(selectedElementEP);
		}
	}
}
