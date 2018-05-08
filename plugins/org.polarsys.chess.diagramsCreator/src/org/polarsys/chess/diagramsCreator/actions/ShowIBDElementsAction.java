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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.BasicEList;
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
import org.eclipse.gmf.runtime.notation.impl.LocationImpl;
import org.eclipse.papyrus.commands.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResource;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSDecorationNodeImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSShapeImpl;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.BlockPropertyCompositeEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.FlowPortAffixedLabelNameEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.FlowPortAffixedNodeEditPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.InternalBlockDiagramCreateCommand;
import org.eclipse.papyrus.uml.diagram.common.actions.ShowHideContentsAction;
import org.eclipse.papyrus.uml.diagram.common.commands.ShowHideElementsRequest;
import org.eclipse.papyrus.uml.diagram.common.edit.part.ConnectorEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.PortAffixedLabelNameEditPart;
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

/**
 * This class creates an Internal Block Diagram and populates it with elements
 * @author cristofo
 *
 */
public class ShowIBDElementsAction extends ShowHideContentsAction {
	
	// Constant values for the size of IBD elements
	private static final int MAIN_WIDTH = 1000;
	private static final int MIN_MAIN_HEIGHT = 600;
	private static final int MAX_MAIN_HEIGHT = 6000;
	private static final int MIN_SUB_WIDTH = 150;
	private static final int MAX_SUB_WIDTH = 1000;
	private static final int MIN_SUB_HEIGHT = 150;
	private static final int MAX_SUB_HEIGHT = 2000;

	/** INCREMENT for the location of the elements to show (ports and properties) */
	private static final int INCREMENT = 40;
	
	/** the main EditPart */
	private EditPart host;

	/** Selection of all the possible elements */
	private List<Object> selection;

	/** Logger for messages */
	private static final Logger logger = Logger.getLogger(ShowIBDElementsAction.class);
	
	final EntityUtil entityUtil = EntityUtil.getInstance();
	final ContractEntityUtil contractEntityUtil = ContractEntityUtil.getInstance();

	private boolean sortedPorts; // Sort the ports in alphabetical order

	/** The instance of this class */
	private static ShowIBDElementsAction classInstance;
	
	/**
	 * Gets an instance of the class if already present, or a new one if not.
	 * @return the instance of this class
	 */
	public static ShowIBDElementsAction getInstance() {
		if (classInstance == null) {
			classInstance = new ShowIBDElementsAction();
		}
		return classInstance;
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
		
		viewsToCreate = new ArrayList<EditPartRepresentation>();
		viewsToDestroy = new ArrayList<EditPartRepresentation>();

		List<Object> result = new ArrayList<>();
		for (int i = 0; i < results.length; i++) {
			
			final EditPartRepresentation editPartRepresentation = (EditPartRepresentation) results[i];

			logger.debug("\n\n\nWorking on results[" + i + "] = " + editPartRepresentation);
			
			final Element semanticElement = (Element) editPartRepresentation.getSemanticElement();
			
			logger.debug("Semantic Element = " + semanticElement);
			logger.debug("Label = " + editPartRepresentation.getLabel());
			
			// If the element is interesting, add it
			if(entityUtil.isPort(semanticElement) || 
					entityUtil.isComponentInstance(semanticElement) || 
					entityUtil.isDelegationConstraints(semanticElement)) {
				result.add(editPartRepresentation);
			}
		}
		
		// Add the result to the views to create, but only if not already displayed
		for (Object element : result) {
			if (initialSelection.contains(element)) {
				
				// we do nothing
				continue;
			} else if (element instanceof EditPartRepresentation) {
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
		
		logger.debug("\n\nrepresentation = " + representation);
		logger.debug("\tlistToComplete.size = " + listToComplete.size());
		
		listToComplete.addAll(representation.getPossibleElement());

		logger.debug("\tlistToComplete.size = " + listToComplete.size());
		
		final List<EditPartRepresentation> children = representation.getPossibleElement();
		
		logger.debug("\tChildren di representation size = " + children.size());
		
		if (children != null) {
			for (EditPartRepresentation child : children) {
				logger.debug("Working on child " + child);
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
		final CompoundCommand completeCmd = new CompoundCommand("Show/Hide Inherited Elements Command");
		ShowHideElementsRequest request = null;

		// Initial position of the elements
//		final Point propertyLocation = new Point(500, 20);	
		final Point propertyLocation = new Point(20, 20);	
		final Point portLocationLeft = new Point(-10, 20);
		final Point portLocationRight = new Point(-10, 20);
		
		// Get the ports of the main component
		final Class mainElement = (Class) ((IGraphicalEditPart) getHost()).resolveSemanticElement();
		final EList<Port> ports = mainElement.getOwnedPorts();
		final ArrayList<Port> inputPorts = getPorts(ports, true, sortedPorts);
		final ArrayList<Port> outputPorts = getPorts(ports, false, sortedPorts);
		
		for (EditPartRepresentation rep : this.viewsToCreate) {
			if (!(rep instanceof OptionalEditPartRepresentation)) {
				continue;
			}
			final EditPart editPart = ((OptionalEditPartRepresentation) rep).getParentRepresentation().getParentRepresentation().getRepresentedEditPart();
			final View compartmentView = ((OptionalEditPartRepresentation) rep).getParentRepresentation().getRepresentedEditPart().getNotationView();

			logger.debug("\n\nep = " + editPart);
			logger.debug("compView = " + compartmentView);

			// Get the width of the component to set the position of output ports
//			final CSSShapeImpl viewShape = (CSSShapeImpl) ((IGraphicalEditPart) editPart).getNotationView();
//			final Bounds layout = (Bounds) viewShape.getLayoutConstraint();
//			portLocationRight.x = layout.getWidth() + 20;
			portLocationRight.x = 10000;	// Huge value to avoid ports being not put on the border
			
			if (compartmentView != null) {
				request = new ShowHideElementsRequest(compartmentView, ((OptionalEditPartRepresentation) rep).getSemanticElement());
				if (isXYLayout(compartmentView, editPart)) {
					propertyLocation.x += INCREMENT;
					propertyLocation.y += INCREMENT;
					request.setLocation(new Point(propertyLocation));
				} else if (isAffixedChildNode(editPart, ((OptionalEditPartRepresentation) rep).getSemanticElement())) {				
					Element element = (Element) ((OptionalEditPartRepresentation) rep).getSemanticElement();
					if (element instanceof Port) {
						if (inputPorts.indexOf(element) != -1) {
							portLocationLeft.y = 20 + INCREMENT * (inputPorts.indexOf(element) + 1);
							request.setLocation(new Point(portLocationLeft));
						} else if (outputPorts.indexOf(element) != -1){
							portLocationRight.y = 20 + INCREMENT * (outputPorts.indexOf(element) + 1);
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
	 * Returns a list of ports, with direction and sorting as specified.
	 * @param ports the list of Ports to process
	 * @param inputType true to get input direction, false for the rest
	 * @param sorted true to get an alphabetically ordered list
	 * @return the list of requested ports
	 */
	private ArrayList<Port> getPorts(EList<Port> ports, boolean inputType, boolean sorted) {
		ArrayList<Port> listPorts = new ArrayList<Port>();

		// Fill the list with the requested type
		for (Port port : ports) {
			if (inputType) {
				if (entityUtil.isInputPort(port)) {
					listPorts.add(port);
				}
			} else {
				if (!entityUtil.isInputPort(port)) {
					listPorts.add(port);
				}
			}
		}

		// Sort list in alphabetical order if requested
		if (sorted) {		
			Comparator<Port> comparator = new Comparator<Port>() {
			    @Override
			    public int compare(Port left, Port right) {
			        return left.getName().compareToIgnoreCase(right.getName());
			    }
			};
			Collections.sort(listPorts, comparator);
		}		
		return listPorts;
	}
	
	private void drawAllComponentInstancesPorts(IGraphicalEditPart elementEP) {
		final CompoundCommand command = new CompoundCommand("Draw Component Instances Ports Commands");
		
		// Get the compartment edit part
		final IGraphicalEditPart compartmentEP = (IGraphicalEditPart) elementEP.getChildren().get(1);

		final List<?>compartmentChildren = compartmentEP.getChildren();
		for (Object childEP : compartmentChildren) {
			
			// Get the UML element associated to the EP
			final EObject semanticElement = ((IGraphicalEditPart) childEP).resolveSemanticElement();
									
			if (semanticElement instanceof Property) {
				command.add(drawComponentInstancePorts((IGraphicalEditPart) childEP));
			}
		}
		
		// Execute the command
		final TransactionalEditingDomain domain  = elementEP.getEditingDomain();
		domain.getCommandStack().execute(new GEFtoEMFCommandWrapper(command));
	}
	
	
//	/**
//	 * Draws the ports on the inner instances.
//	 * @param diagramEP the EditPart of the diagram
//	 */
//	private void drawComponentInstancesPorts(IGraphicalEditPart diagramEP) {
//		final CompoundCommand command = new CompoundCommand("Draw Component Instances Ports Commands");
//		Property prop = null;
//		Class propertyType = null;
//		View compartmentView = null;
//		Point portLocationLeft = null;
//		Point portLocationRight = null;
//
//		// Get the edit part of the main element, from the diagram edit part
//		final IGraphicalEditPart elementEP = (IGraphicalEditPart) diagramEP.getChildren().get(0);
//		
//		// Get the compartment edit part
//		final IGraphicalEditPart compartmentEP = (IGraphicalEditPart) elementEP.getChildren().get(1);
//		
//		logger.debug("\nCompartment edit part = " + compartmentEP);
//
//		final List<?>compartmentChildren = compartmentEP.getChildren();
//		for (Object childEP : compartmentChildren) {
//			
//			// Get the UML element associated to the EP
//			final EObject semanticElement = ((IGraphicalEditPart) childEP).resolveSemanticElement();
//			logger.debug("SemanticElement of compartment = " + semanticElement);
//									
//			if (semanticElement instanceof Property) {			
//			
//				// Get the element type
//				prop = (Property) semanticElement;
//				propertyType = (Class) prop.getType(); 
//
//				// Get the compartment view of the property
//				compartmentView = ((IGraphicalEditPart) childEP).getNotationView();
//
//				// Set the initial position of the ports
//				portLocationLeft = new Point(-10, 20);
//				portLocationRight = new Point(-10, 20);
//				
//				// Get the width of the component to set the position of output ports
//				final CSSShapeImpl viewShape = (CSSShapeImpl) ((IGraphicalEditPart) childEP).getNotationView();
//				final Bounds layout = (Bounds) viewShape.getLayoutConstraint();
//				portLocationRight.x += layout.getWidth() + 20;
//
//				// Get the ports of the property
//				final EList<Port> ports = propertyType.getOwnedPorts();
//				final ArrayList<Port> inputPorts = getPorts(ports, true, sortedPorts);
//				final ArrayList<Port> outputPorts = getPorts(ports, false, sortedPorts);
//
//				// Display the ports
//				for (Port port : ports) {
//					if (compartmentView != null) {
//						final ShowHideElementsRequest request = new ShowHideElementsRequest(compartmentView, port);
//						if (inputPorts.indexOf(port) != -1) {
//							portLocationLeft.y = 20 + INCREMENT * (inputPorts.indexOf(port) + 1);
//							request.setLocation(new Point(portLocationLeft));
//						} else if (outputPorts.indexOf(port) != -1){
//							portLocationRight.y = 20 + INCREMENT * (outputPorts.indexOf(port) + 1);
//							request.setLocation(new Point(portLocationRight));
//						}
//
//						final Command cmd = ((IGraphicalEditPart) childEP).getCommand(request);
//						if (cmd != null && cmd.canExecute()) {
//							((CompoundCommand) command).add(cmd);
//						}
//					}
//				}
//			}
//		}
//
//		// Execute the commands
//		final TransactionalEditingDomain domain  = elementEP.getEditingDomain();
//		domain.getCommandStack().execute(new GEFtoEMFCommandWrapper(command));
//	}

	/**
	 * Draws the ports on the given component instance.
	 * @param diagramEP the EditPart of the component instance
	 * @return the command to be executed
	 */
	private CompoundCommand drawComponentInstancePorts(IGraphicalEditPart componentInstanceEP) {
		final CompoundCommand command = new CompoundCommand("Draw Component Instances Ports Commands");
		Point portLocationLeft = null;
		Point portLocationRight = null;

		final EObject semanticElement = componentInstanceEP.resolveSemanticElement();
		
		// Get the component element type
		final Class component = (Class) ((Property) semanticElement).getType(); 

		// Get the compartment view of the property
		final View compartmentView = componentInstanceEP.getNotationView();

		// Set the initial position of the ports
		portLocationLeft = new Point(-10, 20);
		portLocationRight = new Point(-10, 20);
		
		// Get the width of the component to set the position of output ports
		final CSSShapeImpl viewShape = (CSSShapeImpl) componentInstanceEP.getNotationView();
		final Bounds layout = (Bounds) viewShape.getLayoutConstraint();
		portLocationRight.x += layout.getWidth() + 20;

		// Get the ports of the property
		final EList<Port> ports = component.getOwnedPorts();
		final ArrayList<Port> inputPorts = getPorts(ports, true, sortedPorts);
		final ArrayList<Port> outputPorts = getPorts(ports, false, sortedPorts);

		// Display the ports
		for (Port port : ports) {
			if (compartmentView != null) {
				final ShowHideElementsRequest request = new ShowHideElementsRequest(compartmentView, port);
				if (inputPorts.indexOf(port) != -1) {
					portLocationLeft.y = 20 + INCREMENT * (inputPorts.indexOf(port) + 1);
					request.setLocation(new Point(portLocationLeft));
				} else if (outputPorts.indexOf(port) != -1){
					portLocationRight.y = 20 + INCREMENT * (outputPorts.indexOf(port) + 1);
					request.setLocation(new Point(portLocationRight));
				}

				final Command cmd = componentInstanceEP.getCommand(request);
				if (cmd != null && cmd.canExecute()) {
					((CompoundCommand) command).add(cmd);
				}
			}
		}

		return command;
//		// Execute the commands
//		final TransactionalEditingDomain domain  = componentInstanceEP.getEditingDomain();
//		domain.getCommandStack().execute(new GEFtoEMFCommandWrapper(command));
	}
		
	/**
	 * Computes the ideal size for the element, depending on its features.
	 * @param element the Element to analyze
	 * @return an array with ideal dimensions
	 */
	private int[] getSize(Element element) {
		int width = 0;
		int height = 60;
		final int[] size = new int[2];
		int inputPorts = 0;
		int outputPorts = 0;
		EList<Port> ports;
		int maxLengthInput = 0;
		int maxLengthOutput = 0;
		boolean isMain = false;
		
		if (element instanceof Property) {
			
			// Subcomponent, get the length of its name
			Property property = (Property) element;
//			maxLengthInput = property.getName().length();
//			maxLengthInput += property.getType().getName().length();
			
			// Get the ports of the component
			ports = ((Class) property.getType()).getOwnedPorts();
		} else {
			
			// Main component
			isMain = true;

			// Get the ports of the component
			ports = ((Class) element).getOwnedPorts();
		}
		
		// Count the number of input and output ports and their length
		for (Port port : ports) {
			if (entityUtil.isInputPort(port)) {
				inputPorts++;
				
				// Get the text size for enlarging the box
				int textLength = port.getName().length();
				textLength += port.getType().getName().length();
				if (textLength > maxLengthInput) {
					maxLengthInput = textLength;
				}
			} else {
				outputPorts++;
				
				// Get the text size for enlarging the box
				int textLength = port.getName().length();
				textLength += port.getType().getName().length();
				if (textLength > maxLengthOutput) {
					maxLengthOutput = textLength;
				}
			}
		}
		
		// Empirical value for the width of the element
		width = (int) Math.round(100 + 7.5 * (maxLengthInput + maxLengthOutput));
		
		// Compute the height of the element based on number of ports
		if (inputPorts > outputPorts) {
			height += INCREMENT * inputPorts;
		} else {
			height += INCREMENT * outputPorts;
		}
		
		logger.debug("Element width = " + width);
		logger.debug("Element height = " + height);
		
		// Check box limits
		if (isMain) {
			size[0] = MAIN_WIDTH;
			
			if (height < MIN_MAIN_HEIGHT) {
				size[1] = MIN_MAIN_HEIGHT;
			} else if (height > MAX_MAIN_HEIGHT) {
				size[1] = MAX_MAIN_HEIGHT;
			} else {
				size[1] = height;
			}
		} else {
			if (width < MIN_SUB_WIDTH) {
				size[0] = MIN_SUB_WIDTH;
			} else if (width > MAX_SUB_WIDTH) {
				size[0] = MAX_SUB_WIDTH;
			} else {
				size[0] = width;
			}
			
			if (height < MIN_SUB_HEIGHT) {
				size[1] = MIN_SUB_HEIGHT;
			} else if (height > MAX_SUB_HEIGHT) {
				size[1] = MAX_SUB_HEIGHT;
			} else {
				size[1] = height;
			}
		}
		return size;
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

		final TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(elementView);
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {

				// Enlarge the main component
				if (elementView instanceof CSSShapeImpl) {
					final CSSShapeImpl viewShape = (CSSShapeImpl) elementView;
					final Bounds layout = (Bounds) viewShape.getLayoutConstraint();

					final int[] size = getSize((Element) elementView.getElement());
					layout.setWidth(size[0]);
					layout.setHeight(size[1]);
				}

				// Now I should resize also the inner components
				final EList<?> compartmentChildren = ((View) elementView.getChildren().get(1)).getChildren();
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
														
							final int[] size = getSize((Property) semanticElement);
							layout.setWidth(size[0]);
							layout.setHeight(size[1]);
							layout.setX(offset);
							layout.setY(200);
							offset += 250;

							viewShape.setLayoutConstraint(layout);
						}
					}
				}
			}
		});
	}

	/**
	 * Resizes the missing component instances.
	 * @param mainElementEP the editpart of the main element
	 * @param missingComponentInstances the list of component instances to resize
	 */
	private void resizeMissingComponentInstances(IGraphicalEditPart mainElementEP, EList<Property> missingComponentInstances) {

		// Get the view of the main element
		final View elementView = mainElementEP.getNotationView();
		
		final TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(elementView);
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {

				final EList<?> compartmentChildren = ((View) elementView.getChildren().get(1)).getChildren();
				EObject semanticElement = null;
				int offset = INCREMENT;

				// Loop on the children on the compartment view
				for (Object child : compartmentChildren) {

					// Get the UML element associated to the EP
					semanticElement = ((View) child).getElement();

					if (semanticElement instanceof Property && missingComponentInstances.contains(semanticElement) ) {			
						if (child instanceof CSSShapeImpl) {
							final CSSShapeImpl viewShape = (CSSShapeImpl) child;
							final Bounds layout = NotationFactory.eINSTANCE.createBounds();

							final int[] size = getSize((Property) semanticElement);
							layout.setWidth(size[0]);
							layout.setHeight(size[1]);
							layout.setX(INCREMENT);
							layout.setY(offset);
							offset += INCREMENT;

							viewShape.setLayoutConstraint(layout);
						}
					}
				}
			}
		});
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

		logger.debug("\n\nLooking for port " + role.getQualifiedName());

		// If the port is inside a component instance, go inside the element
		if (property != null) {
			
			logger.debug("Containing property: " + property.getQualifiedName());

			// Get the comparment view of the element 
			final View compartmentView = (View) elementView.getChildren().get(1);

			// Loop on the contained elements
			for (Object child : compartmentView.getChildren()) {
				if (child instanceof CSSShapeImpl) {
					final CSSShapeImpl shape = (CSSShapeImpl) child;
					
					// Check if the element is a property
					if (shape.getElement() instanceof Property) {
						final Property propertyImpl = (Property) shape.getElement();
						if (propertyImpl != null) {
							if (property.getQualifiedName().equals(propertyImpl.getQualifiedName())) {

								// Found the property containing the port, look inside the children
								final EList<?> shapeChildren = shape.getChildren();
								
								for (Object childView : shapeChildren) {
									final IGraphicalEditPart ep = (IGraphicalEditPart) getEditPartFromView((View) childView);
									if (ep instanceof FlowPortAffixedNodeEditPart || ep instanceof PortAffixedNodeEditPart) {
										if (role == ep.resolveSemanticElement()) {
											logger.debug("\nPort found in part, view = "  + ep);
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
						logger.debug("\nPort found in main elemement, view = "  + ep);
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
	 * @param connectors the list of connectors to draw
	 */
	private void drawConnectors(IGraphicalEditPart elementEP, EList<Connector> connectors) {
		final View elementView = elementEP.getNotationView();
		final CompoundCommand compoundCommand = new CompoundCommand("Restore A Related Link");

		// Loop on all the connectors
		for (Connector connector : connectors) {
			EditPart sourceEP = null;
			EditPart targetEP = null;
			
			// Retrieve the EP for the source port
			final ConnectorEnd sourceEnd = connector.getEnds().get(0);
			if (sourceEnd != null) {
				sourceEP = getPortEditPart((Port) sourceEnd.getRole(), sourceEnd.getPartWithPort(), elementView);
			}

			// Retrieve the EP for the target port
			final ConnectorEnd targetEnd = connector.getEnds().get(1);
			if (targetEnd != null) {
				targetEP = getPortEditPart((Port) targetEnd.getRole(), targetEnd.getPartWithPort(), elementView);
			}

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
	public void populateDiagram(Diagram diagram, boolean sortedPorts) {
		
		final Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		
		// The EditPart associated to the diagram
		final IGraphicalEditPart diagramEP = OffscreenEditPartFactory.getInstance().createDiagramEditPart(diagram, shell);
		
		// Store the EditPart
		host = diagramEP;

		this.sortedPorts = sortedPorts;
		
		// The main EditPart 
		final IGraphicalEditPart selectedElementEP = (IGraphicalEditPart) diagramEP.getChildren().get(0);
		logger.debug("\n\nselectedElement EditPart = " + selectedElementEP + "\n\n");
		
		// Add the selected element to the list, there could be more than one...
		selectedElements = new ArrayList<IGraphicalEditPart>();
		selectedElements.add(selectedElementEP);
				
		// Call superclass methods to setup the action
		initAction();
		buildInitialSelection();
		
		// Get a selection with all the possible elements
		buildSelection();
				
		logger.debug("Selection size = " + selection.size());
		
		if (selection.size() > 0) {
			
			// Filter the list to extract only the elements I'm interested in
			buildShowHideElementsList(selection.toArray());
	
			// Create the list of commands to display the elements
			final Command command = getActionCommand();		
			
			// Execute the commands
			final TransactionalEditingDomain domain = selectedElements.get(0).getEditingDomain();
			domain.getCommandStack().execute(new GEFtoEMFCommandWrapper(command));
			
			// Resize the graphical elements
			resizeElements(diagramEP);
			
			// Draw the ports on the inner components
			// NB: labels are put in the wrong place, but if done in another command they are fine!
			drawAllComponentInstancesPorts(selectedElementEP);
			
			// Draw all the connectors
			drawConnectors(selectedElementEP, ((Class) selectedElementEP.resolveSemanticElement()).getOwnedConnectors());
		}
	}
	
	/**
	 * Draws the missing ports of the given element, on the lower border.
	 * @param elementEP the EditPart of the element
	 * @param missingPorts the Ports to be drawn
	 */
	private CompoundCommand drawMissingPorts(IGraphicalEditPart elementEP, EList<Port> missingPorts) {
		final CompoundCommand command = new CompoundCommand("Draw Missing Ports Commands");
		
		// Get the compartment view
		final View compartmentView = elementEP.getNotationView();

		// Loop on the missing ports and draw them, on the lower border
		for (Port port : missingPorts) {
			final ShowHideElementsRequest request = new ShowHideElementsRequest(compartmentView, port);
				request.setLocation(new Point(missingPorts.indexOf(port) * INCREMENT, 10000));

			final Command cmd = elementEP.getCommand(request);
			if (cmd != null && cmd.canExecute()) {
				((CompoundCommand) command).add(cmd);
			}
		}
		return command;
//		
//		// Execute the commands
//		final TransactionalEditingDomain domain  = elementEP.getEditingDomain();
//		domain.getCommandStack().execute(new GEFtoEMFCommandWrapper(command));
	}
	
	/**
	 * Returns the edit part associated to the given component instance
	 * @param owner the editpart of the owner element
	 * @param componentInstance the component instance to process
	 * @return the edit part of the given component istance
	 */
	private IGraphicalEditPart getComponentInstanceEditPart(IGraphicalEditPart owner, Property componentInstance) {
		
		// The list of children edit parts, from the container of the owning element
		final List<?> compartmentChildrenEP = ((EditPart) owner.getChildren().get(1)).getChildren();

		// Loop on the edit parts to find the right one
		for (Object childEP : compartmentChildrenEP) {
			if (childEP instanceof IGraphicalEditPart) {
				final EObject semanticElement = ((IGraphicalEditPart) childEP).resolveSemanticElement();
				if (semanticElement == componentInstance) {
					return (IGraphicalEditPart) childEP;
				}
			}
		}
		return null;
	}	
	
	/**
	 * Draws the ports on the newly added component instances
	 * @param mainElementEP the editpart of the main element
	 * @param missingComponentInstances the list of component instances to enrich
	 */
	private void drawMissingComponentsPorts(IGraphicalEditPart mainElementEP, EList<Property> missingComponentInstances) {
		final CompoundCommand command = new CompoundCommand("Draw Component Instances Ports Commands");
		
		for (Property componentInstance : missingComponentInstances) {
			command.add(drawComponentInstancePorts(getComponentInstanceEditPart(mainElementEP, componentInstance)));
		}
		
		// Execute the command
		final TransactionalEditingDomain domain  = mainElementEP.getEditingDomain();
		domain.getCommandStack().execute(new GEFtoEMFCommandWrapper(command));
	}
	
	/**
	 * Moves up the position of the newly added ports. 
	 * @param elementEP the editpart of the element
	 * @param missingPorts the list of ports to adjust
	 */
	private void adjustMissingPortsLabels(IGraphicalEditPart elementEP, EList<Port> missingPorts) {
		
		// Get all the EditParts of the element
		final Map<?, ?> elements = elementEP.getViewer().getEditPartRegistry();
		final Object[] editParts = elements.values().toArray();
		
		final TransactionalEditingDomain domain = 
				TransactionUtil.getEditingDomain(((IGraphicalEditPart) elementEP).getNotationView());
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
		
				for (int i = 0; i < editParts.length; i++) {				
					if (editParts[i] instanceof FlowPortAffixedLabelNameEditPart) {

						// Label containing the name of the port
						final FlowPortAffixedLabelNameEditPart labelEditPart = (FlowPortAffixedLabelNameEditPart) editParts[i];
						final CSSDecorationNodeImpl view = (CSSDecorationNodeImpl) labelEditPart.getNotationView();
						final LocationImpl layout = (LocationImpl) view.getLayoutConstraint();

						// Get the port owning the label
						final Port port = (Port) ((FlowPortAffixedLabelNameEditPart) editParts[i]).resolveSemanticElement();

						if (missingPorts.contains(port)) {
							layout.setY(layout.getY() - 20);
						}
					} else if (editParts[i] instanceof PortAffixedLabelNameEditPart) {
						
						// Label containing the name of the port
						final PortAffixedLabelNameEditPart editPart = (PortAffixedLabelNameEditPart) editParts[i];
						final CSSDecorationNodeImpl view = (CSSDecorationNodeImpl) editPart.getNotationView();
						final LocationImpl layout = (LocationImpl) view.getLayoutConstraint();

						// Get the port owning the label
						final Port port = (Port) ((PortAffixedLabelNameEditPart) editParts[i]).resolveSemanticElement();

						if (missingPorts.contains(port)) {
							layout.setY(layout.getY() - 20);
						}
					}
				}
			}
		});
	}
		
	/**
	 * Draws the ports that are missing for the given component instances.
	 * @param mainElementEP the editpart of the main element
	 * @param displayedComponentInstances the list of component instances to enrich
	 * @param displayedPorts the list of ports that are already present on the diagram
	 */
	private void drawUpdatedComponentInstancesPorts(IGraphicalEditPart mainElementEP, EList<Property> displayedComponentInstances, EList<Port> displayedPorts) {
		final CompoundCommand command = new CompoundCommand("Draw Component Instances Ports Commands");
		final EList<Port> totalMissingComponentPorts = new BasicEList<Port>();
		
		for (Property componentInstance : displayedComponentInstances) {
			
			// All the existing ports, from the component instance type (block)
			Class component = (Class) componentInstance.getType();
			
			final EList<Port> existingComponentPorts = component.getOwnedPorts();

			// Loop on the ports to find those not displayed and draw them
			final EList<Port> missingComponentPorts = new BasicEList<Port>();
			for (Port port : existingComponentPorts) {
				if (displayedPorts.contains(port)) {
					logger.debug("port already present in diagram");
				} else {
					logger.debug("port is not present in diagram: " + port);
					missingComponentPorts.add(port);
					totalMissingComponentPorts.add(port);
				}
			}
			if (missingComponentPorts.size() > 0) {
				command.add(drawMissingPorts(getComponentInstanceEditPart(mainElementEP, componentInstance), missingComponentPorts));
			}
		}
		
		// Execute the command
		final TransactionalEditingDomain domain  = mainElementEP.getEditingDomain();
		domain.getCommandStack().execute(new GEFtoEMFCommandWrapper(command));
		
		// Ajust the labels of the newly created ports
		adjustMissingPortsLabels(mainElementEP, totalMissingComponentPorts);
	}
	
	/**
	 * Draws the ports that are missing for the given main component.
	 * @param mainElementEP the editpart of the element
	 * @param existingMainComponentPorts the list ports already present
	 * @param displayedPorts the list of ports that are already present on the diagram
	 */
	private void drawUpdatedMainComponentPorts(IGraphicalEditPart mainElementEP, EList<Port> displayedPorts) {
		final CompoundCommand command = new CompoundCommand("Draw Component Instances Ports Commands");
		
		// All the existing ports of the main element
		final EList<Port> existingMainComponentPorts = ((Class) mainElementEP.resolveSemanticElement()).getOwnedPorts();

		// Loop on the ports to find those not displayed and draw them
		final EList<Port> missingMainComponentPorts = new BasicEList<Port>();
		for (Port port : existingMainComponentPorts) {
			if (displayedPorts.contains(port)) {
				logger.debug("port already present in diagram");
			} else {
				logger.debug("port is not present in diagram: " + port);
				missingMainComponentPorts.add(port);
			}
		}
		command.add(drawMissingPorts(mainElementEP, missingMainComponentPorts));
		
		// Execute the command
		final TransactionalEditingDomain domain  = mainElementEP.getEditingDomain();
		domain.getCommandStack().execute(new GEFtoEMFCommandWrapper(command));
		
		// Ajust the labels of the newly created ports
		adjustMissingPortsLabels(mainElementEP, missingMainComponentPorts);
	}

	/**
	 * Displays missing elements in the given diagram.
	 * @param diagramEditPart the diagram editpart
	 */
	public void refreshDiagram(IGraphicalEditPart diagramEditPart) {
		
		// The main element EditPart 
		final IGraphicalEditPart mainElementEP = (IGraphicalEditPart) diagramEditPart.getChildren().get(0);

		// The main element of the diagram
		final Class mainElement = (Class) mainElementEP.resolveSemanticElement();

		// Get all the EditParts of the diagram
		final Map<?, ?> elements = diagramEditPart.getViewer().getEditPartRegistry();
		final Object[] editParts = elements.values().toArray();

		// Lists of displayes elements
		final EList<Property> displayedComponentInstances = new BasicEList<Property>();
		final EList<Connector> displayedConnectors = new BasicEList<Connector>();
		final EList<Port> displayedPorts = new BasicEList<Port>();
		
		// Loop on all the editparts to collect the displayed elements
		for (int i = 0; i < editParts.length; i++) {
			if (editParts[i] instanceof BlockPropertyCompositeEditPart) {
				displayedComponentInstances.add((Property) ((BlockPropertyCompositeEditPart) editParts[i]).resolveSemanticElement());
			} else if (editParts[i] instanceof ConnectorEditPart) {
				displayedConnectors.add((Connector) ((ConnectorEditPart) editParts[i]).resolveSemanticElement());
			} else if (editParts[i] instanceof FlowPortAffixedNodeEditPart) {
				displayedPorts.add((Port) ((FlowPortAffixedNodeEditPart) editParts[i]).resolveSemanticElement());
			}
		}

		// Sort ports by default
		this.sortedPorts = true;
		
		// Draw the missing ports on the main component
		drawUpdatedMainComponentPorts(mainElementEP, displayedPorts);
		
		// Draw the missing ports on displayed component instances
		drawUpdatedComponentInstancesPorts(mainElementEP, displayedComponentInstances, displayedPorts);
				
		// All the existing component instances of the main element
		EList<Property> existingComponentInstances = new BasicEList<Property>(entityUtil.getSubComponentsInstances(mainElement));
		
		// Loop on the component instances to find those not displayed
		final EList<Property> missingComponentInstances = new BasicEList<Property>();
		for (Property property : existingComponentInstances) {
			if (displayedComponentInstances.contains(property)) {
				logger.debug("component instance already present in diagram");
			} else {
				logger.debug("component instance is not present in diagram: "  + property);
				missingComponentInstances.add(property);
			}
		}
		
		// Setup the variables to draw the component instances
		selectedElements = new ArrayList<IGraphicalEditPart>();
		selectedElements.add(mainElementEP);

		host = diagramEditPart;
		
		// Call superclass methods to setup the action
		initAction();
		buildInitialSelection();
		
		// Get a selection with all the possible elements
		buildSelection();

		// Draw the missing component instances
		if (selection.size() > 0) {

			// Filter the list to extract only the elements I'm interested in
			buildShowHideElementsList(selection.toArray());

			// Create the list of commands to display the component instances
			final Command command = getActionCommand();		

			// Execute the commands
			final TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(diagramEditPart.getNotationView());
			domain.getCommandStack().execute(new GEFtoEMFCommandWrapper(command));
		}

		// Resize the missing component instances
		resizeMissingComponentInstances(mainElementEP, missingComponentInstances);
		
		// Draw the ports for the new component instances
		drawMissingComponentsPorts(mainElementEP, missingComponentInstances);
		
//		adjustPortLabels(mainElementEP);
		


		// All the existing connectors of the main element
		final EList<Connector>existingConnectors = mainElement.getOwnedConnectors();
		
		// Loop on the connectors to find those not displayed
		final EList<Connector> missingConnectors = new BasicEList<Connector>();
		for (Connector connector : existingConnectors) {
			if (displayedConnectors.contains(connector)) {
				logger.debug("connector already present in diagram");
			} else {
				logger.debug("connector is not present in diagram: " + connector);
				missingConnectors.add(connector);
			}
		}
		
		// Draw the missing connectors
		drawConnectors(mainElementEP, missingConnectors);
	}
}

//TODO: devo sistemare la posizione delle porte, label, ecc.