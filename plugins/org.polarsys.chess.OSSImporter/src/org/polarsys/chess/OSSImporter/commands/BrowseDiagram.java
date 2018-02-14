package org.polarsys.chess.OSSImporter.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;

import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramEditPartsUtil;
import org.eclipse.papyrus.infra.gmfdiag.common.updater.DiagramUpdater;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.SetPropertyCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.emf.core.util.CrossReferenceAdapter;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.diagram.ui.internal.properties.Properties;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.commands.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.gmfdiag.common.commands.requests.ShowHideRelatedLinkRequest;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.EdgeWithNoSemanticElementRepresentationImpl;
import org.eclipse.papyrus.infra.gmfdiag.common.updater.UpdaterLinkDescriptor;
//import org.eclipse.papyrus.infra.gmfdiag.common.utils.Domain2Notation;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.ServiceUtilsForEditPart;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSConnectorImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSShapeImpl;
import org.eclipse.papyrus.infra.gmfdiag.common.Activator;
import org.eclipse.papyrus.sysml.blocks.NestedConnectorEnd;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.FlowPortAffixedNodeEditPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.part.SysMLDiagramUpdater;
import org.eclipse.papyrus.sysml.diagram.internalblock.part.SysMLVisualIDRegistry;
import org.eclipse.papyrus.sysml.service.types.utils.ConnectorUtils;
import org.eclipse.papyrus.uml.diagram.common.edit.part.PortAffixedNodeEditPart;
import org.eclipse.papyrus.uml.diagram.common.util.CrossReferencerUtil;
import org.eclipse.papyrus.uml.diagram.common.utils.UMLGraphicalTypes;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.uml.diagram.composite.part.UMLLinkDescriptor;
import org.eclipse.papyrus.uml.diagram.composite.providers.UMLElementTypes;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;
import org.polarsys.chess.service.utils.SelectionUtil;
import eu.fbk.eclipse.standardtools.commands.AbstractJobCommand;

public class BrowseDiagram extends AbstractJobCommand {
	private EditPart host;	// The main EditPart

	public BrowseDiagram() {
		super("Browse");
	}
	
	/**
	 * Returns the diagram EditPart.
	 * @return
	 */
	private EditPart getHost() {
		return host;
	}

	/**
	 * Sets the diagram EditPart.
	 * @param host
	 */
	private void setHost(EditPart host) {
		this.host = host;
	}

	/**
	 * Gets the editing domain.
	 *
	 * @return the editing domain
	 *         the editing domain to use
	 */
	protected final TransactionalEditingDomain getEditingDomain() {
		try {
			return ServiceUtilsForEditPart.getInstance().getTransactionalEditingDomain(getHost());
		} catch (ServiceException e) {
			Activator.log.error("Editing Domain not found", e); //$NON-NLS-1$
		}
		return null;
	}

	/**
	 * Removes the invalid link descriptor.
	 *
	 * @param descriptors
	 *            the link descriptor
	 * @return 
	 *         the collection of link descriptors without some invalid descriptor (we get this case when the link doesn't have source AND target, but
	 *         only ends
	 */
	protected Collection<UpdaterLinkDescriptor> removeInvalidLinkDescriptor(final Collection<UpdaterLinkDescriptor> descriptors) {
		final Collection<UpdaterLinkDescriptor> toRemove = new ArrayList<UpdaterLinkDescriptor>();
		final Collection<UpdaterLinkDescriptor> toAdd = new ArrayList<UpdaterLinkDescriptor>();
		for (final UpdaterLinkDescriptor current : descriptors) {
			if (current.getModelElement() == null) {
				final IElementType elementType = current.getSemanticAdapter().getAdapter(IElementType.class);
				final EdgeWithNoSemanticElementRepresentationImpl noSemantic = new EdgeWithNoSemanticElementRepresentationImpl(current.getSource(), current.getDestination(), ((IHintedType) elementType).getSemanticHint());
				final UpdaterLinkDescriptor replacement = new UpdaterLinkDescriptor(current.getSource(), current.getDestination(), noSemantic, elementType, current.getVisualID());
				toRemove.add(current);
				toAdd.add(replacement);
			}
		}

		descriptors.removeAll(toRemove);
		descriptors.addAll(toAdd);
		return descriptors;
	}

	/**
	 * Checks if is owner.
	 *
	 * @param view
	 *            the view
	 * @param descriptor
	 *            the descriptor
	 * @return true, if is owner
	 */
	private boolean isOwner(View view, UpdaterLinkDescriptor descriptor) {
		EObject source = descriptor.getSource();
		EObject dest = descriptor.getDestination();
		if (source != null && source.equals(view.getElement())) {
			return true;
		}
		if (dest != null && dest.equals(view.getElement())) {
			return true;
		}
		return false;
	}

	/**
	 * Detects if similar descriptor already exist in given collection.
	 *
	 * @param collection
	 *            the collection of unique ingoing and outgoing links descriptors
	 * @param umlLinkDescriptor
	 *            the descriptor to search
	 * @return true if already exist
	 */
	private boolean cleanContains(Collection<? extends UpdaterLinkDescriptor> collection, UpdaterLinkDescriptor umlLinkDescriptor) {
		for (UpdaterLinkDescriptor descriptor : collection) {
			if (descriptor.getModelElement() == umlLinkDescriptor.getModelElement() && descriptor.getSource() == umlLinkDescriptor.getSource() && descriptor.getDestination() == umlLinkDescriptor.getDestination()
					&& descriptor.getVisualID() == umlLinkDescriptor.getVisualID()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Gets the top view with same semantic element.
	 *
	 * @param view
	 *            a view
	 * @return the last parent of this view referencing the same semantic
	 *         element
	 */
	protected View getTopViewWithSameSemanticElement(final View view) {
		final EObject semanticElement = view.getElement();
		View parent = view;
		View lastParent = view;
		while (parent.getElement() == semanticElement) {
			lastParent = parent;
			parent = (View) parent.eContainer();
		}
		return lastParent;
	}

	/**
	 * Checks if is correct graphical view.
	 *
	 * @param connectorEnd
	 *            a connector end
	 * @param view
	 *            a view
	 * @return <code>true</code> if the view represents the role of the
	 *         connector AND if the view is encapsulated as required by the
	 *         nested path of the connector end
	 */
	protected boolean isCorrectGraphicalView(final ConnectorEnd connectorEnd, final View view) {
		final NestedConnectorEnd nestedConnectorEnd = org.eclipse.uml2.uml.util.UMLUtil.getStereotypeApplication(connectorEnd, NestedConnectorEnd.class);
		final Property partWithPort = connectorEnd.getPartWithPort();
		// final ConnectableElement role = end.getRole();
		// 1. we get the top view of this view with the same semantic element
		View localView = getTopViewWithSameSemanticElement(view);

		// 2. we verify the part with port
		if (partWithPort != null) {
			View parent = getTopViewWithSameSemanticElement(ViewUtil.getViewContainer(localView));
			if (parent.getElement() != partWithPort) {
				return false;
			}
		}

		// 3. we verify the nested path
		if (nestedConnectorEnd != null && nestedConnectorEnd.getPropertyPath().size() > 0) {
			View parent = view;
			final List<Property> paths = nestedConnectorEnd.getPropertyPath();
			for (int i = paths.size() - 1; i >= 0; i--) {
				final Property currentProperty = paths.get(i);
				parent = getTopViewWithSameSemanticElement(ViewUtil.getViewContainer(parent));
				if (parent.getElement() != currentProperty) {
					return false;
				}
			}
		}
		return true;
	}


	
	
	/**
	 * Can be displayed.
	 *
	 * @param connector
	 *            a connector
	 * @param selectedView
	 *            a view used as source or target for the connector to display
	 * @param domain2NotationMap
	 *            the map to complete if we found source and target View on the
	 *            diagram to diplsay the connector
	 * @return <code>true</code> if the view can be used as source/target for
	 *         the connector according to the nested path AND if we found a
	 *         second view for the 2nd connector end according to the nested
	 *         path
	 */
	protected boolean canBeDisplayed(final Connector connector, final View selectedView, final Domain2Notation domain2NotationMap) {
		// we need to verify the selected view
		final EObject semanticElement = selectedView.getElement();
		ConnectorEnd endForView = null;

		// 1. look for the connector end represented by the selected view
		for (final ConnectorEnd current : connector.getEnds()) {
			if (current.getRole() == semanticElement) {
				endForView = current;
				break;
			}
		}
		Assert.isNotNull(endForView);
		// 2. verify the view of the selected connector end
		if (!isCorrectGraphicalView(endForView, selectedView)) {
			return false;
		}

		// 3. try to find a view for the second connector end
		View secondView = null;
		for (final ConnectorEnd end : connector.getEnds()) {
			final ConnectableElement role = end.getRole();
			if (role == null) {
				return false;
			}
			if (end == endForView) {
				continue;
			}

			final Set<View> views = CrossReferencerUtil.getCrossReferencingViewsInDiagram(role, getCurrentDiagram());
			final Iterator<View> iterOnView = views.iterator();
			while (secondView == null && iterOnView.hasNext()) {
				final View currentView = iterOnView.next();
				if (isCorrectGraphicalView(end, currentView)) {
					domain2NotationMap.putView(endForView, selectedView);
					domain2NotationMap.putView(end, currentView);
					secondView = currentView;
				}
			}
		}
		return secondView != null;
	}

	
	
	/**
	 * Clean add.
	 *
	 * @param result
	 *            the result of the call to this method
	 * @param view
	 *            the current view
	 * @param descriptors
	 *            links descriptors for links related to this view
	 * @param domain2NotationMap
	 *            the map between model element and views
	 */
	//QUESTA E' L'ORIGINALE
	protected void cleanAdd(Collection<UpdaterLinkDescriptor> result, View view, List<? extends UpdaterLinkDescriptor> descriptors, final Domain2Notation domain2NotationMap) {
		for (UpdaterLinkDescriptor updaterLinkDescriptor : descriptors) {
			if (cleanContains(result, updaterLinkDescriptor)) {
				continue;
			}
			
			// check owner
			if (!isOwner(view, updaterLinkDescriptor)) {
				continue;
			}
			result.add(updaterLinkDescriptor);
		}
	}
	
	
	/**
	 * Clean add.
	 *
	 * @param result
	 *            the result
	 * @param view
	 *            the view
	 * @param descriptors
	 *            the descriptors
	 * @param domain2NotationMap
	 *            the domain2 notation map
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.AbstractShowHideRelatedLinkEditPolicy#cleanAdd(java.util.Collection, org.eclipse.gmf.runtime.notation.View, java.util.List, java.util.Map)
	 */
	
//	protected void cleanAdd(final Collection<UpdaterLinkDescriptor> result, final View view, final List<? extends UpdaterLinkDescriptor> descriptors, final Domain2Notation domain2NotationMap) {
//		cleanAddForConnector(result, view, descriptors, domain2NotationMap);
//		cleanAddOrig(result, view, descriptors, domain2NotationMap);
//	}

	/**
	 * This method manages descriptors representing Connector to verify that it
	 * can be displayed according to the nestedPath of the {@link ConnectorEnd} If the connector can be displayed :
	 * <ul>
	 * <li>
	 * the link descriptor is removed from descriptors and added to result</li>
	 * <li>
	 * the view associated to the role of the connector are added to domain2NotationMap (using the ConnectorEnd as key)</li>
	 * </ul>
	 * .
	 *
	 * @param result
	 *            the result of the method
	 * @param view
	 *            a view
	 * @param descriptors
	 *            the link descriptors
	 * @param domain2NotationMap
	 *            the map between model element and views
	 */
	protected void cleanAddForConnector(final Collection<UpdaterLinkDescriptor> result, final View view, final List<?> descriptors, final Domain2Notation domain2NotationMap) {
		final List<UpdaterLinkDescriptor> toRemove = new ArrayList<UpdaterLinkDescriptor>();
		for (final Object current : descriptors) {
			if (current instanceof UpdaterLinkDescriptor) {
				final UpdaterLinkDescriptor descriptor = (UpdaterLinkDescriptor) current;
				final EObject element = descriptor.getModelElement();
				if (element instanceof Connector) {
					if (canBeDisplayed((Connector) element, view, domain2NotationMap)) {
						result.add((UpdaterLinkDescriptor) current);
					}
					toRemove.add((UpdaterLinkDescriptor) current);
				}
			}
		}
		descriptors.removeAll(toRemove);
	}

	
	
	

	/**
	 * Collects all related links for view.
	 *
	 * @param view
	 *            the view
	 * @param domain2NotationMap
	 *            the domain2 notation map
	 * @return linkdescriptors
	 */
	protected Collection<? extends UpdaterLinkDescriptor> collectPartRelatedLinks(final View view, final Domain2Notation domain2NotationMap) {
		Collection<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		DiagramUpdater diagramUpdater = getDiagramUpdater();
		
		// We must prevent duplicate descriptors
		List<? extends UpdaterLinkDescriptor> outgoingDescriptors = diagramUpdater.getOutgoingLinks(view);
		cleanAdd(result, view, outgoingDescriptors, domain2NotationMap);

		List<? extends UpdaterLinkDescriptor> incomingDescriptors = diagramUpdater.getIncomingLinks(view);
		cleanAdd(result, view, incomingDescriptors, domain2NotationMap);

		if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
			domain2NotationMap.putView(view);
		}
		
		return removeInvalidLinkDescriptor(result);
	}

	/**
	 * Gets the command.
	 *
	 * @param req
	 *            the request to show the link
	 * @return the command
	 */
	public Command getCommand(final ShowHideRelatedLinkRequest request) {
		
		// 0. Obtain the required informations
		// --the map between semantic eobjects and existing views
		final Domain2Notation domain2NotationMap = new Domain2Notation();

		// -- the map between selected EditPart and the semantic existing links
		final Map<EditPart, Set<EObject>> availableLinks = new HashMap<EditPart, Set<EObject>>();

		// -- the list of the links which are currently visible on the diagram
		final Set<EObject> visibleLinks = new HashSet<EObject>();

		// -- the link descriptors
		final Set<UpdaterLinkDescriptor> linksDescriptors = new HashSet<UpdaterLinkDescriptor>();

		
		// 1. resolve all to avoid concurrent modification exception during the call of the method collectPartRelatedLinks
		EcoreUtil.resolveAll(getEditingDomain().getResourceSet());

		// 1. bis To register all EditPart in the global visualIDRegistry
		getHost().refresh();

		// 2. we associate each view to a semantic element
		
		System.out.println("\nFaccio il dominio sulla vista = " + getHost().getAdapter(View.class));

		//FIXME: questo va ottimizzato, lo fa tutte le volte!
		domain2NotationMap.mapModel(getHost().getAdapter(View.class));
		
		Set<EObject> keys = domain2NotationMap.keySet();
		for (EObject eObject : keys) {
			System.out.println("\n\tchiave del dominio = " + eObject);
			Set<View> views = domain2NotationMap.get(eObject);
			for (View view : views) {
				System.out.println("\t\tcontenuta = " + view);
				System.out.println("\t\telemento = " + view.getElement());
			}
		}
		
		// 3.we collect the link descriptors
		for (final EditPart currentEp : request.getSelectedEditParts()) {
			final View view = currentEp.getAdapter(View.class);
			
			System.out.println("\ncurrentEP view = " + view);
			
			
			if (view != null) {
				final Collection<? extends UpdaterLinkDescriptor> desc = collectPartRelatedLinks(view, domain2NotationMap);
				linksDescriptors.addAll(desc);
				
				System.out.println("\n\n\nlinkDescriptors size = " + linksDescriptors.size());
				
				final Set<EObject> modelLinks = new HashSet<EObject>();
				final Iterator<? extends UpdaterLinkDescriptor> iter = desc.iterator();

				while (iter.hasNext()) {
					final UpdaterLinkDescriptor current = iter.next();
					
					System.out.println("\n\n\n\ncurrent UpdaterLinkDescriptor = " + current);
					
					final EObject link = current.getModelElement();
					
					
					
					System.out.println("link = " + link);
					
					EObject destination = current.getDestination();
					System.out.println("destination = " + destination);
					
					Set<View> d = domain2NotationMap.get(destination);
					
//					System.out.println("d.size = " + d.size());
					
					final View dest = domain2NotationMap.getFirstView(destination);
					EObject source2 = current.getSource();
					
					System.out.println("source2 = " + source2);
					
					Set<View> d2 = domain2NotationMap.get(source2);
					
//					System.out.println("d2.size = " + d2.size());
					
					final View source = domain2NotationMap.getFirstView(source2);

					
					// CI POSSONO ESSERE DUE VIEWS, PRENDO LA PRIMA!
					
					
					
					System.out.println("\nsource view = " + source);
					System.out.println("dest view = " + dest);
					
					// we add only links for which at least one source and one target are already on the diagram
					if (dest != null && source != null) {
						modelLinks.add(link);
						System.out.println("Aggiungo il link a modelLinks");
					} else {
						// Non serve cancellarlo, ne fa sempre due!
//						linksDescriptors.remove(current);
					}

					// we build the list of the visible links

					View linkView = domain2NotationMap.getFirstView(link);
					if (linkView != null && linkView.isVisible()) {
						System.out.println("Lo aggiungo ai visibili");
						visibleLinks.add(link);
					}
				}
				
				System.out.println("modellink size = " + modelLinks.size());
				availableLinks.put(currentEp, modelLinks);
				System.out.println("lo aggiungo agli available, size = " + availableLinks.size());
			}
		}
		
		System.out.println("\n FUORI linkDescriptors size = " + linksDescriptors.size());

		for (UpdaterLinkDescriptor updaterLinkDescriptor : linksDescriptors) {
			System.out.println("\nlinkdescriptor = " + updaterLinkDescriptor);
			System.out.println("linkdescriptor model = " + updaterLinkDescriptor.getModelElement());
		}
		
//
//		final Collection<EObject> possibleEnds = new HashSet<EObject>();
//		for (final EditPart currentIGraphical : request.getSelectedEditParts()) {
//			possibleEnds.add(currentIGraphical.getAdapter(EObject.class));
//		}
//		final Collection<UpdaterLinkDescriptor> toRemove = new ArrayList<UpdaterLinkDescriptor>();
//		for (final UpdaterLinkDescriptor current : linksDescriptors) {
//			final EObject source = current.getSource();
//			final EObject target = current.getDestination();
//			if (!possibleEnds.contains(source) || !possibleEnds.contains(target)) {
//				toRemove.add(current);
//			}
//		}
//		linksDescriptors.removeAll(toRemove);
//		final Set<EObject> allLinks = new HashSet<EObject>();
//		for (final Collection<EObject> currentColl : availableLinks.values()) {
//			allLinks.addAll(currentColl);
//		}
//
		
		
		
		
		// Questa e' la chiamata che fa tutto!
		
//		final ICommand tmp = getShowLinkCommand(getEditingDomain(), (EObject) current, domain2NotationMap, linkDescriptors);

		final Set<EObject> allLinksT = new HashSet<EObject>();
		for (final Collection<EObject> currentColl : availableLinks.values()) {
			allLinksT.addAll(currentColl);
		}
		
		System.out.println("\n\nallLinksT size = " + allLinksT.size());
		System.out.println("\n\nlinksDescriptors size = " + linksDescriptors.size());

		return new ICommandProxy(getShowHideRelatedLinkCommand(getEditingDomain(), allLinksT, Collections.emptyList(), domain2NotationMap, linksDescriptors));
	}
		


	/**
	 * Have same path.
	 *
	 * @param wantedPath
	 *            the wanted nested path for the end
	 * @param end
	 *            an end
	 * @return true, if successful
	 *         true if the end has as nested path THE wanted path
	 */
	protected boolean haveSamePath(final List<Property> wantedPath, final ConnectorEnd end) {
		
		System.out.println("sono dentro il haveSame");
		
		Stereotype ste = end.getAppliedStereotype("SysML::Blocks::NestedConnectorEnd");//$NON-NLS-1$
		if (ste != null) {
			System.out.println("ho un applied stereotype = " + ste);
			final NestedConnectorEnd nestedConnectorEnd = (NestedConnectorEnd) end.getStereotypeApplication(ste);
			return nestedConnectorEnd.getPropertyPath().equals(wantedPath);
		} else {
			System.out.println("wantedPath is empty!");
			return wantedPath.isEmpty();
		}
	}
	

	/**
	 * Get the path of structure views crossed by the checked end.
	 *
	 * @param checkedEnd
	 *            the checked end view.
	 * @param oppositeEnd
	 *            the opposite end view.
	 * @return the list of crossed structure views.
	 */
	public List<View> getNestedPath(View checkedEnd, View oppositeEnd) {
		List<View> isNestedConnectableElement = new ArrayList<View>();

		View nearestContainer = new ConnectorUtils().getNearestStructureContainer(checkedEnd);
		
		System.out.println("\nnearestContainer = " + nearestContainer);
		
		if (nearestContainer != null) {
			View containerView = new ConnectorUtils().deduceViewContainer(checkedEnd, oppositeEnd);
			
			System.out.println("ContainerView = " + containerView);
			
			List<View> containers = new ConnectorUtils().getStructureContainers(checkedEnd);
			
			System.out.println("containers.size = " + containers.size());

			System.out.println("index1 = " + containers.indexOf(nearestContainer));
			System.out.println("index2 = " + containers.indexOf(containerView));
			
			// orig solo < 
			if (containers.indexOf(nearestContainer) < containers.indexOf(containerView)) {
				System.out.println("dentro l'if");
				
//	orig			isNestedConnectableElement = containers.subList(containers.indexOf(nearestContainer), containers.indexOf(containerView));
				isNestedConnectableElement = containers.subList(0, containers.indexOf(containerView));
			}
		}

		// nested path is taken from the top block to the deepest property ==> collection must be reverted
		Collections.reverse(isNestedConnectableElement);

		return isNestedConnectableElement;
	}


	

	public Property getPartWithPort(View checkedView, View oppositeView) {
		Property result = null;
		EObject targetPort = checkedView.getElement();
		if(targetPort instanceof Port) {
			// Only look for PartWithPort if the role is a Port.

			View parentView = ViewUtil.getContainerView(checkedView);
			EObject semanticParent = parentView.getElement();
			if((semanticParent instanceof Property) && !(semanticParent instanceof Port)) {
				// Only add PartWithPort for assembly (not for delegation)
				if(!EcoreUtil.isAncestor(parentView, oppositeView)) {
					result = (Property)semanticParent;
				}
			}

		}

		return result;
	}


	/**
	 * Get the path of structure views crossed by the checked end.
	 *
	 * @param checkedEnd
	 *            the checked end view.
	 * @param oppositeEnd
	 *            the opposite end view.
	 * @return the list of crossed structure views.
	 */
	List<Property> getNestedPropertyPath(View checkedEnd, View oppositeEnd) {
		List<Property> nestedPropertyPath = new ArrayList<Property>();
		List<View> nestedPath = getNestedPath(checkedEnd, oppositeEnd);

		System.out.println("\nnestedPath size = " + nestedPath.size());
		
		for (View view : nestedPath) {
			if ((view.getElement() != null) && (view.getElement() instanceof Property)) {
				nestedPropertyPath.add((Property) view.getElement());
			}
		}

		// if end is a port, and the list is not empty, add the property from the check view in the list
		if (!nestedPropertyPath.isEmpty() && checkedEnd.getElement() instanceof Port) {
			Property partWithPort = getPartWithPort(checkedEnd, oppositeEnd);
			if (partWithPort != null) {
				nestedPropertyPath.add(partWithPort);
			}
		}

		return nestedPropertyPath;
	}


	
	/**
	 * Can display existing connector between views according to nested paths.
	 *
	 * @param connector
	 *            a connector existing in the model
	 * @param sourceView
	 *            a potential source for this connector
	 * @param targetView
	 *            a potential target for this connector
	 * @return true, if successful <code>true</code> if displaying the existing connector between this source and this target view is correct
	 */
	public boolean canDisplayExistingConnectorBetweenViewsAccordingToNestedPaths(final Connector connector, final View sourceView, final View targetView) {

		System.out.println("Sono dentro il can display");
		
		// QUI TUTTI I PARAMETRI SONO CORRETTI
		
		
		// Provo a farmi la mia versione
		// ho source view e targetview
		
		System.out.println("\n\nView source = " + sourceView);
		System.out.println("\telement dalla view source = " + sourceView.getElement());

		System.out.println("\n\nTarget source = " + targetView);
		System.out.println("\telement dalla view target = " + targetView.getElement());
		
		
		// Il mio connector nel role non sa quale sia la vista, ha solo la porta
		
		
		ConnectorUtils utils = new ConnectorUtils();
		System.out.println("\n calcolo la sourcePath");
		final List<Property> sourcePath = getNestedPropertyPath(sourceView, targetView);
		System.out.println("\n calcolo la targetPath");
		final List<Property> targetPath = getNestedPropertyPath(targetView, sourceView);
		boolean hasWantedPath = true;
		
		// SONO ENTRAMBI VUOTI, E' GIUSTO?
		System.out.println("sourcePath size = " + sourcePath.size());
		System.out.println("targetPath size = " + targetPath.size());
		
		for (final ConnectorEnd end : connector.getEnds()) {
			
			System.out.println("Lavoro sull'end = " + end);
			System.out.println("\tend.role = " + end.getRole());
			System.out.println("\tsourceview.getelem = " + sourceView.getElement());
			System.out.println("\ttargetview.getelem = " + targetView.getElement());
			
			// Se la porta del connector end e' uguale alla porta della source
			if (sourceView != null && end.getRole() == sourceView.getElement()) {
				System.out.println("caso uno");
				hasWantedPath = hasWantedPath && haveSamePath(sourcePath, end);
			} else 
				// Se la porta del connector end e' uguale alla porta del target
				if (targetView != null && end.getRole() == targetView.getElement()) {
					System.out.println("caso due");
					hasWantedPath = hasWantedPath && haveSamePath(targetPath, end);
			}
		}
		System.out.println("has path = " + hasWantedPath);
		return hasWantedPath;
	}

	
	
	/**
	 * Can display existing link between views.
	 *
	 * @param connector
	 *            the connector
	 * @param sourceView
	 *            the source view
	 * @param targetView
	 *            the target view
	 * @return true, if successful
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.AbstractShowHideRelatedLinkEditPolicy#canDisplayExistingLinkBetweenViews(org.eclipse.uml2.uml.Connector, org.eclipse.gmf.runtime.notation.View, org.eclipse.gmf.runtime.notation.View)
	 */
	public boolean canDisplayExistingLinkBetweenViews(final EObject element, final View sourceView, final View targetView) {
		return (element instanceof Connector) && canDisplayExistingConnectorBetweenViewsAccordingToNestedPaths((Connector) element, sourceView, targetView);
	}
	
	/**
	 * Gets the link descriptor.
	 *
	 * @param link
	 *            a link
	 * @param descriptors
	 *            the list of the known descriptors
	 * @return the link descriptor
	 *         the link descriptor for this link or <code>null</code> if not found
	 */
	protected final UpdaterLinkDescriptor getLinkDescriptor(final EObject link, final Collection<? extends UpdaterLinkDescriptor> descriptors) {
		final Iterator<? extends UpdaterLinkDescriptor> iter = descriptors.iterator();
		while (iter.hasNext()) {
			final UpdaterLinkDescriptor current = iter.next();
			if (current.getModelElement() == link) {
				return current;
			}
		}
		return null;
	}

	/**
	 * Gets the editpart from view.
	 *
	 * @param view
	 *            the view
	 * @return the editpart from theview
	 */
	protected EditPart getEditPartFromView(View view) {
		if (view != null) {
			return (EditPart) getHost().getViewer().getEditPartRegistry().get(view);
		}
		return null;
	}

	protected String getSemanticHint(final EObject eobject) {
		return SysMLVisualIDRegistry.getLinkWithClassVisualID(eobject);
	}

	/**
	 * Gets the show link command.
	 *
	 * @param domain
	 *            the editing domain to use for this command
	 * @param linkToShow
	 *            a link to show
	 * @param domain2NotationMap
	 *            the domain2 notation map
	 * @param linkDescriptors
	 *            the link descriptors
	 * @return the show link command
	 *         the command to display the link on the diagram
	 */
	protected ICommand getShowLinkCommand(final TransactionalEditingDomain domain, final EObject linkToShow, 
			final Domain2Notation domain2NotationMap, final Collection<? extends UpdaterLinkDescriptor> linkDescriptors) {
				
		domain2NotationMap.mapModel(getHost().getAdapter(View.class));
		
		final View view = domain2NotationMap.getFirstView(linkToShow);
		if (view != null) {
			
			System.out.println("\n\n\nLa view non e' nulla: " + view);
			
			return new SetPropertyCommand(domain, "Restore related linksCommand show view", new EObjectAdapter(view), Properties.ID_ISVISIBLE, Boolean.TRUE);//$NON-NLS-1$
		} else {// we need to recreate the view

			// we look for the link descriptor
			UpdaterLinkDescriptor descriptor = getLinkDescriptor(linkToShow, linkDescriptors);
			
			System.out.println("Recupero il link descriptor = " + descriptor);
			System.out.println("\tsource = " + descriptor.getSource());
			System.out.println("\ttarget = " + descriptor.getDestination());
			System.out.println("\tgetVisualID = " + descriptor.getVisualID());
			System.out.println("\tgetModelElement = " + descriptor.getModelElement());
			System.out.println("\tgetSemanticAdapter = " + descriptor.getSemanticAdapter());
			System.out.println("\tgetClass = " + descriptor.getClass());

			
			// il link e' giusto, tra due porte specifiche!
			// Ma quale vista? Non si sa...
			
			// Non sono un edgewith
			if (linkToShow instanceof EdgeWithNoSemanticElementRepresentationImpl) {
				// we replace the specific link descriptor by a new one, with no model element (if not the view provider refuse to create the view
				final IElementType elementType = descriptor.getSemanticAdapter().getAdapter(IElementType.class);
				descriptor = new UpdaterLinkDescriptor(descriptor.getSource(), descriptor.getDestination(), elementType, descriptor.getVisualID());
				
				System.out.println("Sono un Edge, creo un updater = " + descriptor);
			}
			
			if (descriptor != null) {
				
				Set<View> sourceViewList = domain2NotationMap.get(descriptor.getSource());
				
				// Qui mi faccio dare le viste della mia porta di partenza

				CompositeCommand compositeCommand = new CompositeCommand("Restor All Related Links");

				// Il mio source ha due viste! Ogni vista ha una destinazione
				
				
				// Il connettore non sa quale sia la vista corretta da collegare!
				
				View sour = domain2NotationMap.getFirstView(descriptor.getSource());
				
				
				for (View sourceView : sourceViewList) {
					
					Set<View> targetViewList = domain2NotationMap.get(descriptor.getDestination());
					System.out.println("loop su sourceView = " + sourceView);
					System.out.println("\telement = " + sourceView.getElement());

					for (View targetView : targetViewList) {

						System.out.println("\ttargetView = " + targetView);
						System.out.println("\telement = " + targetView.getElement());

//						if (canDisplayExistingLinkBetweenViews(linkToShow, sourceView, targetView)) {
						if (sourceView == sour) {

							EditPart sourceEditPart = getEditPartFromView(sourceView);
							EditPart targetEditPart = getEditPartFromView(targetView);
							// If the parts are still null...
							if (sourceEditPart == null || targetEditPart == null) {
								return null;
							}
							
							System.out.println("sourceEditPart = " + sourceEditPart);
							System.out.println("targetEditPart = " + targetEditPart);
							
							
							String semanticHint = getSemanticHint(linkToShow);
							if (semanticHint == null) {
								
								System.out.println("Semantic hint era nullo");
								semanticHint = ((IHintedType) descriptor.getSemanticAdapter().getAdapter(IElementType.class)).getSemanticHint();
							}
							
							System.out.println("Semantic hint = " + semanticHint);
							
							CreateConnectionViewRequest.ConnectionViewDescriptor viewDescriptor = 
									new CreateConnectionViewRequest.ConnectionViewDescriptor(descriptor.getSemanticAdapter(), 
											semanticHint, ViewUtil.APPEND, false,
											((GraphicalEditPart) getHost()).getDiagramPreferencesHint());
							CreateConnectionViewRequest ccr = new CreateConnectionViewRequest(viewDescriptor);
							ccr.setType(org.eclipse.gef.RequestConstants.REQ_CONNECTION_START);
							ccr.setSourceEditPart(sourceEditPart);
							sourceEditPart.getCommand(ccr);
							ccr.setTargetEditPart(targetEditPart);
							ccr.setType(org.eclipse.gef.RequestConstants.REQ_CONNECTION_END);
							CommandProxy commandProxy = new CommandProxy(targetEditPart.getCommand(ccr));
							compositeCommand.add(commandProxy);
							
							System.out.println("Faccio l'add al comando");
						}
					}

				}
				return compositeCommand;
			}
		}
		return null;
	}

	/**
	 * Gets the hide link command.
	 *
	 * @param domain
	 *            the editing domain
	 * @param linkToHide
	 *            the link to hide
	 * @param domain2NotationMap
	 *            the map between eobjects and views
	 * @param linkDescriptors
	 *            the link descriptors
	 * @return the hide link command
	 *         the command to hide the wanted link
	 */
	protected ICommand getHideLinkCommand(final TransactionalEditingDomain domain, final EObject linkToHide, final Domain2Notation domain2NotationMap, final Collection<? extends UpdaterLinkDescriptor> linkDescriptors) {
		final UpdaterLinkDescriptor descriptor = getLinkDescriptor(linkToHide, linkDescriptors);
		if (descriptor != null) {
			final View view = domain2NotationMap.getFirstView(linkToHide);
			final EditPart editPart = DiagramEditPartsUtil.getEditPartFromView(view, getHost());
			return new CommandProxy(editPart.getCommand(new GroupRequest(org.eclipse.gef.RequestConstants.REQ_DELETE)));
		}
		return null;
	}

	/**
	 * Gets the show hide related link command.
	 *
	 * @param domain
	 *            the editing domain
	 * @param toShow
	 *            the list of the link to show
	 * @param toHide
	 *            the list of the link to hide
	 * @param domain2NotationMap
	 *            a map linking the eobject to their view
	 * @param linkDescriptors
	 *            the link descriptor
	 * @return the show hide related link command
	 *         the command to show/hide the links, according to the args of this method
	 */
	protected final ICommand getShowHideRelatedLinkCommand(final TransactionalEditingDomain domain, final Collection<?> toShow, 
			final Collection<?> toHide, final Domain2Notation domain2NotationMap,
			final Collection<? extends UpdaterLinkDescriptor> linkDescriptors) {
		
		final CompositeCommand compositeCommand = new CompositeCommand("Show/Hide Related Link");//$NON-NLS-1$
		
		for (final Object current : toShow) {
			if (current instanceof EObject) {
				final ICommand tmp = getShowLinkCommand(domain, (EObject) current, domain2NotationMap, linkDescriptors);
				if (tmp != null && tmp.canExecute()) {
					compositeCommand.add(tmp);
				}
			}
		}
		
		for (final Object current : toHide) {
			if (current instanceof EObject) {
				final ICommand tmp = getHideLinkCommand(domain, (EObject) current, domain2NotationMap, linkDescriptors);
				if (tmp != null && tmp.canExecute()) {
					compositeCommand.add(tmp);
				}
			}
		}
		
		return compositeCommand;
	}

	/**
	 *
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.IDiagramInformationProviderEditPolicy#getDiagramUpdater()
	 *
	 * @return
	 */
	public DiagramUpdater getDiagramUpdater() {
		return SysMLDiagramUpdater.TYPED_INSTANCE;
	}
	
	private static Collection<? extends UpdaterLinkDescriptor> getIncomingTypeModelFacetsLinks_Connector_link_uml_connector(final ConnectableElement target, CrossReferenceAdapter crossReferencer) {
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferencer.getInverseReferences(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getConnectorEnd_Role() || false == setting.getEObject() instanceof ConnectorEnd) {
				continue;
			}
			final ConnectorEnd connectorEnd = (ConnectorEnd) setting.getEObject();
			if (!UMLGraphicalTypes.LINK_UML_CONNECTOR_ID.equals(SysMLVisualIDRegistry.getLinkWithClassVisualID(connectorEnd.eContainer()))) {
				continue;
			}
			final Connector connector = (Connector) connectorEnd.eContainer();

			// FIXME : verify the path
			for (final ConnectorEnd current : connector.getEnds()) {
				if (current == connectorEnd) {
					continue;
				}
				final ConnectableElement src = current.getRole();
				result.add(new UpdaterLinkDescriptor(src, target, connector, 
						org.eclipse.papyrus.uml.diagram.composite.providers.UMLElementTypes.Connector_Edge, null));
			}
		}
		return result;
	}

	private static List<UpdaterLinkDescriptor> getProperty_IncomingLink(final View view) {
		final Property modelElement = (Property) view.getElement();
		final CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		final LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetsLinks_Connector_link_uml_connector(modelElement, crossReferencer));
		return result;
	}
	
	
	/**
	 * Gets the current diagram.
	 *
	 * @return the current diagram
	 *         the current diagram; hosting this edit policy
	 */
	protected Diagram getCurrentDiagram() {
		return getHost().getAdapter(Diagram.class);
	}


	/**
	 * Gets the EditPart related to the given port.
	 * @param role the port
	 * @param property the component instance containing the port
	 * @param elementView the view of the element containing the component instance
	 * @return the requested EditPart
	 */
	private EditPart getPortEditPart(Port role, Property property, View elementView) {

		System.out.println("\n\nLooking for port " + role.getQualifiedName());

		// If the port is inside a component instance, go inside the element
		if (property != null) {
			
			System.out.println("Containing property: " + property.getQualifiedName());

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
//							System.out.println("\tpropertyImpl qualifiedName = " + propertyImpl.getQualifiedName());

							if (property.getQualifiedName().equals(propertyImpl.getQualifiedName())) {

								// Found the property containing the port, look inside the children
								EList<?> shapeChildren = shape.getChildren();
								
								for (Object childView : shapeChildren) {
									IGraphicalEditPart ep = (IGraphicalEditPart) getEditPartFromView((View) childView);
									if (ep instanceof FlowPortAffixedNodeEditPart || ep instanceof PortAffixedNodeEditPart) {
										if (role == ep.resolveSemanticElement()) {
											System.out.println("\nPort found in part, view = "  + ep);
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
						System.out.println("\nPort found in main elemement, view = "  + ep);
						return ep;
					}
				}
			}
		}
		return null;
	}
	
	private void getShowLinkCommand(EditPart sourceEP, EditPart targetEP, EObject linkElement) throws ExecutionException {
	
//		View sourceView = ((IGraphicalEditPart) sourceEP).getNotationView();
//		
//		System.out.println("\n\n\nLavoro sulla sourceView = " + sourceView);
//		System.out.println("\telement = " + sourceView.getElement());
//		
//		Domain2Notation not = new Domain2Notation();
//		not.mapModel(sourceView);
//		
//		System.out.println("Fatto il modello per la vista in oggetto");
//		
//		final Collection<? extends UpdaterLinkDescriptor> desc = collectPartRelatedLinks(sourceView, not);
//		Collection<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
//		
//		System.out.println("\n\n\ndesc = " + desc.toArray());
//		System.out.println("size of desc = " + desc.size());
//
//		DiagramUpdater diagramUpdater = getDiagramUpdater();
//
//		
//		List<? extends UpdaterLinkDescriptor> mio = getProperty_IncomingLink(sourceView);
//		
//		System.out.println("mio size = " + mio.size());
//		for (UpdaterLinkDescriptor link2 : mio) {
//			System.out.println("link = " + link2);
//			System.out.println("\tsource = " + link2.getSource());
//			System.out.println("\ttarget = " + link2.getDestination());
//			System.out.println("\tgetVisualID = " + link2.getVisualID());
//			System.out.println("\tgetModelElement = " + link2.getModelElement());
//			System.out.println("\tgetSemanticAdapter = " + link2.getSemanticAdapter());
//			System.out.println("\tgetClass = " + link2.getClass());	
//		}
//		
//		
//		
//		
//		
//		// We must prevent duplicate descriptors
//		List<? extends UpdaterLinkDescriptor> outgoingDescriptors = diagramUpdater.getOutgoingLinks(sourceView);
//		
//		System.out.println("outgoingDescriptors size = " + outgoingDescriptors.size());
//		
//		UpdaterLinkDescriptor link = outgoingDescriptors.get(0);
//		
//		System.out.println("semanticAdapter out = " + link.getSemanticAdapter());
//		
//		
//		cleanAdd(result, sourceView, outgoingDescriptors, not);
//
//		List<? extends UpdaterLinkDescriptor> incomingDescriptors = diagramUpdater.getIncomingLinks(sourceView);
//
//		System.out.println("incomingDescriptors size = " + incomingDescriptors.size());
//
//		link = incomingDescriptors.get(0);
//		System.out.println("semanticAdapter in = " + link.getSemanticAdapter());
//
//		
//		cleanAdd(result, sourceView, incomingDescriptors, not);
//
//		System.out.println("result size = " + result.size());
//		
//		if (result.size() != 1)
//			System.out.println("\n\n\nHO PIU' DI UN RISULTATO");
//		
//		// Ho il link descriptor che mi serve
//		System.out.println("\n\nINCOMING");
//		for (UpdaterLinkDescriptor link2 : incomingDescriptors) {
//			System.out.println("link = " + link2);
//			System.out.println("\tsource = " + link2.getSource());
//			System.out.println("\ttarget = " + link2.getDestination());
//			System.out.println("\tgetVisualID = " + link2.getVisualID());
//			System.out.println("\tgetModelElement = " + link2.getModelElement());
//			System.out.println("\tgetSemanticAdapter = " + link2.getSemanticAdapter());
//			System.out.println("\tgetClass = " + link2.getClass());	
//		}
//		
//		System.out.println("\n\nOUTGOING");
//		for (UpdaterLinkDescriptor link2 : outgoingDescriptors) {
//			System.out.println("link = " + link2);
//			System.out.println("\tsource = " + link2.getSource());
//			System.out.println("\ttarget = " + link2.getDestination());
//			System.out.println("\tgetVisualID = " + link2.getVisualID());
//			System.out.println("\tgetModelElement = " + link2.getModelElement());
//			System.out.println("\tgetSemanticAdapter = " + link2.getSemanticAdapter());
//			System.out.println("\tgetClass = " + link2.getClass());
//		}
//		
//		final Iterator<? extends UpdaterLinkDescriptor> iter = desc.iterator();
//
//		System.out.println("\n\nDESC");
//		while (iter.hasNext()) {
//			final UpdaterLinkDescriptor current = iter.next();
//			System.out.println("link = " + current);
//			System.out.println("\tsource = " + current.getSource());
//			System.out.println("\ttarget = " + current.getDestination());
//			System.out.println("\tgetVisualID = " + current.getVisualID());
//			System.out.println("\tgetModelElement = " + current.getModelElement());
//			System.out.println("\tgetSemanticAdapter = " + current.getSemanticAdapter());
//			System.out.println("\tgetClass = " + current.getClass());
//		}
//		
//		// Ci sono dei link verso porte che non esistono!
//		
//		
//		System.out.println("\n\n\n\nlink = " + link);
//		System.out.println("\tsource = " + link.getSource());
//		System.out.println("\ttarget = " + link.getDestination());
//		System.out.println("\tgetVisualID = " + link.getVisualID());
//		System.out.println("\tgetModelElement = " + link.getModelElement());
//		System.out.println("\tgetSemanticAdapter = " + link.getSemanticAdapter());
//		System.out.println("\tgetClass = " + link.getClass());
//		
//		//Il link descriptor sembra corretto
//		
//		// Perche' sono invertite? Funziona lo stesso comunque
//		EditPart sourceEditPart = sourceEP;
//		EditPart targetEditPart = targetEP;
//		
//		if (((IGraphicalEditPart) sourceEditPart).resolveSemanticElement() != link.getSource()) {
//			System.out.println("\n\n\nORDINE INVERTITO");
//		} else
//			System.out.println("\n\n\nORDINE CORRETTO");
//		
//	
//		System.out.println("sourceEditPart = " + sourceEditPart);
//		System.out.println("\telement = " + ((IGraphicalEditPart) sourceEditPart).resolveSemanticElement());
//		System.out.println("targetEditPart = " + targetEditPart);
//		System.out.println("\telement = " + ((IGraphicalEditPart) targetEditPart).resolveSemanticElement());
//		
//		CompositeCommand compositeCommand = new CompositeCommand("Restore A Related Link");
//		
//		UpdaterLinkDescriptor descriptor = link;
		
//		// Perche' sono invertite? Funziona lo stesso comunque
		EditPart sourceEditPart = sourceEP;
		EditPart targetEditPart = targetEP;

		CompositeCommand compositeCommand = new CompositeCommand("Restore A Related Link");
		
		String semanticHint = "link_uml_connector";

		IAdaptable mySemanticAdapter = new EObjectAdapter(linkElement) {

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
		ccr.setSourceEditPart(sourceEditPart);
		sourceEditPart.getCommand(ccr);	//FIXME: a cosa serve?
		ccr.setTargetEditPart(targetEditPart);
		ccr.setType(org.eclipse.gef.RequestConstants.REQ_CONNECTION_END);
		CommandProxy commandProxy = new CommandProxy(targetEditPart.getCommand(ccr));
		if (commandProxy.canExecute()) {
			compositeCommand.add(commandProxy);
			commandProxy.execute(null, null);
		}
		
		
//		System.out.println("Faccio l'add al comando");
//
//		//compositeCommand.execute(null, null);
//		
//		
//		Command c = new ICommandProxy(compositeCommand);
//		final CompoundCommand compoundCommand = new CompoundCommand("Show/Hide Links Command"); //$NON-NLS-1$
//		compoundCommand.add(c);
//		
//		// Execute the commands in a single transaction, it is faster
//		final TransactionalEditingDomain domain = ((IGraphicalEditPart)getHost()).getEditingDomain();
//		domain.getCommandStack().execute(new GEFtoEMFCommandWrapper(compoundCommand));

		
	}
	
	
	@Override
	public void execPreJobOperations(ExecutionEvent event, IProgressMonitor monitor) throws Exception {

		final ISelection selection = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();
		Object umlObject = SelectionUtil.getInstance().getUmlSelectedObject(selection);

		System.out.println("\nselectedUmlElement: " + umlObject);
		
		IGraphicalEditPart diagramEP = (GraphicalEditPart) ((IStructuredSelection) selection).getFirstElement();

		// Store the EditPart of the diagram 
		setHost((DiagramEditPart) diagramEP);

		System.out.println("\n\nEdit Part di diagram = " + diagramEP);
		
		// devo trovare la editpart dell'elemento
		IGraphicalEditPart elementEP = (IGraphicalEditPart) diagramEP.getChildren().get(0);
				
		System.out.println("\nelementEP = " + elementEP);

		// Get the compartment edit part
		IGraphicalEditPart compartmentEP = (IGraphicalEditPart) elementEP.getChildren().get(1);
		System.out.println("\nCompartment edit part = " + compartmentEP);

		Class umlClass = (Class) umlObject;

		final CompoundCommand compoundCommand = new CompoundCommand("Show/Hide Links Command"); //$NON-NLS-1$

		Collection<EditPart> coll = new ArrayList<EditPart>();

		EList<Connector> connectors = umlClass.getOwnedConnectors();

//		for (Connector connector : connectors) {
//			System.out.println("\nHo trovato questo connector = " + connector);

// QUESTA PARTE PASSA GLI ELEMENTI PART
//			List<IGraphicalEditPart>compartmentChildren = compartmentEP.getChildren();
//			for (IGraphicalEditPart childEP : compartmentChildren) {
//				System.out.println("child of compartment = " + childEP);
//
//				if (childEP instanceof BlockPropertyCompositeEditPart) {
//
//					// adesso cerco le sue porte e provo
//
//					List<IGraphicalEditPart> elementChildren = childEP.getChildren();
//					System.out.println("elementEP = " + elementEP);
//					for (IGraphicalEditPart childEditPart : elementChildren) {
//						System.out.println("\tchild = " + childEditPart);
//						System.out.println("\tchild element = " + childEditPart.resolveSemanticElement());
//
//						if (childEditPart instanceof FlowPortAffixedNodeEditPart) {
//							coll.clear();
//							coll.add(childEditPart);
//
//							//								ShowHideRelatedLinkRequest reqLink = new ShowHideRelatedLinkRequest(coll, ShowHideRelatedLinkRequest.ShowHideKind.OPEN_DIALOG);
//							ShowHideRelatedLinkRequest reqLink = new ShowHideRelatedLinkRequest(coll, ShowHideRelatedLinkRequest.ShowHideKind.SHOW_ALL_LINK_BETWEEN_SELECTED_ELEMENT);
//
//							System.out.println("reqLink.getMode = " + reqLink.getMode());
//							System.out.println("reqLink getSelectedEditParts = " + reqLink.getSelectedEditParts());
//
//
//							// Funziona, non su tutte le porte pero'
//							Command cmd = getCommand(reqLink);
//
//							ShowHideRelatedLinkEditPolicy policy = new ShowHideRelatedLinkEditPolicy((DiagramEditPart) getHost());
//
//							// Funziona, non su tutte le porte pero'
//							//								cmd = policy.getCommand(reqLink);
//
//							if(cmd.canExecute()) {
//								System.out.println("cmd can execute");
//								//									cmd.execute();
//
//							} else {
//								System.out.println("cmd cannot execute");
//							}
//
//						}
//					}						
//				}
//			}
//		}
		
		
		
		// elementi del diagramma
		final Domain2Notation domain2NotationMap = new Domain2Notation();
		getHost().refresh();
		domain2NotationMap.mapModel(getHost().getAdapter(View.class));
		
		
		Set<EObject> keys = domain2NotationMap.keySet();

		for (EObject key : keys) {
			System.out.println("Key = " + key);
		}
		
		List<?>compartmentChildren = compartmentEP.getChildren();
		
		for (Object object : compartmentChildren) {
			System.out.println("object = " + object);
		}
		
		
		// Provo a navigare la vista del componente principale
		View elementView = elementEP.getNotationView();
		
		EList<?>childrenViews = elementView.getChildren();
		
		for (Object object : childrenViews) {
			System.out.println("\nchild view = " + object);
			View view = (View) object;
			System.out.println("\telement = " + view.getElement());
			
			if (view.getElement() instanceof Port) {
				System.out.println("Sono una porta, ho figli?");
				
				EList<?>portEdges = view.getSourceEdges();
				
				for (Object ch : portEdges) {
					System.out.println("\tedge di porta = " + ch);
					
					CSSConnectorImpl connView = (CSSConnectorImpl) ch;
					
					org.eclipse.gmf.runtime.notation.Connector connN;
					
					final EObject source = ((org.eclipse.gmf.runtime.notation.Connector) ch).getSource().getElement();
					final EObject target = ((org.eclipse.gmf.runtime.notation.Connector) ch).getTarget().getElement();
					System.out.println("\tCon source = " + source);
					System.out.println("\tCon target = " + target);

					
					
					Connector conn = (Connector) connView.getElement();
					
					System.out.println("Connector element = " + conn);
					
//					System.out.println("connector ends = "  + conn.getEnds().size());
//					
//					final EObject source = connView.getSource().getElement();
//					final EObject target = connView.getTarget().getElement();
//
//					System.out.println("connector source = " + source);
//					System.out.println("connector target = " + target);
					
				}
				
			}
			
		}
				
		// Provo a navigare nelle viste alla ricerca della EP corretta
		// ho il nome dell'istanza e la porta
		//
		
		for (Connector connector : connectors) {
			System.out.println("\nHo trovato questo connector = " + connector);
			EditPart sourceEP = null;
			EditPart targetEP = null;
			
			ConnectorEnd sourceEnd = connector.getEnds().get(0);
			if (sourceEnd != null) {
				sourceEP = getPortEditPart((Port) sourceEnd.getRole(), sourceEnd.getPartWithPort(), elementView);
			}

			ConnectorEnd targetEnd = connector.getEnds().get(1);
			if (targetEnd != null) {
				targetEP = getPortEditPart((Port) targetEnd.getRole(), targetEnd.getPartWithPort(), elementView);
			}

			System.out.println("\n\nFound sourceEP = " + sourceEP);
			System.out.println("\nFound targetEP = " + targetEP);
		
			// L'ordine delle EP e' corretto!
			
			//Posso provare quindi a fare la richiesta grafica
			if (sourceEP != null && targetEP != null) {
				System.out.println("\tsourceEP element = " + ((IGraphicalEditPart) sourceEP).resolveSemanticElement());
				System.out.println("\ttargetEP element = " + ((IGraphicalEditPart) targetEP).resolveSemanticElement());
				getShowLinkCommand(sourceEP, targetEP, connector);
			}			
		}

		
		
		
		
		
		// Provo a navigare il modello e fare le richieste per tutte le porte, ma le disegna doppie...
//		final Domain2Notation domain2NotationMap = new Domain2Notation();
//		getHost().refresh();
//		domain2NotationMap.mapModel(getHost().getAdapter(View.class));
//		
//		
//		Set<EObject> keys = domain2NotationMap.keySet();
//
//		for (EObject key : keys) {
//			if (key instanceof Port) {
//				System.out.println("Working on port " + key);
//			
//				// Faccio la richiesta qui
//				coll.clear();
//				
//				Set<View> views = domain2NotationMap.get(key);
//				for (View view : views) {
//					coll.add(getEditPartFromView(view));
//				}
//
//				ShowHideRelatedLinkRequest reqLink = new ShowHideRelatedLinkRequest(coll, ShowHideRelatedLinkRequest.ShowHideKind.SHOW_ALL_LINK_BETWEEN_SELECTED_ELEMENT);
//				
//				Command cmd2 = getCommand(reqLink);
//				
////				ShowHideRelatedLinkEditPolicy policy = new ShowHideRelatedLinkEditPolicy((DiagramEditPart) getHost());
////				Command cmd2 = policy.getCommand(reqLink);
//				
//				if(cmd2.canExecute()) {
//					System.out.println("cmd2 can execute");
//					compoundCommand.add(cmd2);
//				} else {
//					System.out.println("cmd2 cannot execute, port: " + key + " not connected?");
//				}						
//			}
//		}

		
//		// Provo a fare un singolo comando con tutte le editpart, sembra un po' piu' veloce
//		coll.clear();
//		List<IGraphicalEditPart> elementChildren = elementEP.getChildren();
//		for (IGraphicalEditPart childEditPart : elementChildren) {
//			System.out.println("\nchild = " + childEditPart);
//			System.out.println("\tchild element = " + childEditPart.resolveSemanticElement());
//
//			if (childEditPart instanceof FlowPortAffixedNodeEditPart) {
//				coll.add(childEditPart);
//			}
//		}
//		System.out.println("coll size = " + coll.size());
//		ShowHideRelatedLinkRequest reqLink = new ShowHideRelatedLinkRequest(coll, ShowHideRelatedLinkRequest.ShowHideKind.SHOW_ALL_LINK_BETWEEN_SELECTED_ELEMENT);
//
//		// Funziona, su tutte le porte del componente padre
//		Command cmd2 = getCommand(reqLink);
//
//		// Non funziona! 
//		//			ShowHideRelatedLinkEditPolicy policy = new ShowHideRelatedLinkEditPolicy((DiagramEditPart) getHost());
//		//			Command cmd2 = policy.getCommand(reqLink);
//
//		if(cmd2.canExecute()) {
//			System.out.println("cmd2 can execute");
//			compoundCommand.add(cmd2);
//		} else {
////			System.out.println("cmd2 cannot execute, port: " + childEditPart.resolveSemanticElement() + " not connected?");
//		}						
			
		
		
		// Scorro tutte le EditPart del componente alla ricerca di porte
		List<IGraphicalEditPart> elementChildren = elementEP.getChildren();
		for (IGraphicalEditPart childEditPart : elementChildren) {
			System.out.println("\nchild = " + childEditPart);
			System.out.println("\tchild element = " + childEditPart.resolveSemanticElement());

			if (childEditPart instanceof FlowPortAffixedNodeEditPart) {
				coll.clear();
				coll.add(childEditPart);

				// faccio la richiesta con la EP della porta
				ShowHideRelatedLinkRequest reqLink = new ShowHideRelatedLinkRequest(coll, ShowHideRelatedLinkRequest.ShowHideKind.SHOW_ALL_LINK_BETWEEN_SELECTED_ELEMENT);

				// Funziona, su tutte le porte del componente padre
				Command cmd2 = getCommand(reqLink);

				if(cmd2.canExecute()) {
					System.out.println("cmd2 can execute");
					compoundCommand.add(cmd2);
				} else {
					System.out.println("cmd2 cannot execute, port: " + childEditPart.resolveSemanticElement() + " not connected?");
				}
				break;	// Per farne solo una
			}
		}
		

		System.out.println("Il comando compound e' composto da elementi = " + ((CompoundCommand) compoundCommand).size());

		// Execute the commands in a single transaction, it is faster
//		final TransactionalEditingDomain domain = elementEP.getEditingDomain();
//		domain.getCommandStack().execute(new GEFtoEMFCommandWrapper(compoundCommand));
	}

	@Override
	public void execJobCommand(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
		// TODO Auto-generated method stub

	}
	
	
	
	 class Domain2Notation extends HashMap<EObject, Set<org.eclipse.gmf.runtime.notation.View>> {


		/**
		 * Maps view.
		 *
		 * @param view
		 *            the view from which are mapped all subviews
		 */
		public void mapModel(org.eclipse.gmf.runtime.notation.View view) {
			
//			System.out.println("\n\nLavoro sulla vista " + view);
			
			if ((view instanceof org.eclipse.gmf.runtime.notation.Connector || 
					view instanceof org.eclipse.gmf.runtime.notation.Shape) && 
					!(view instanceof org.eclipse.gmf.runtime.notation.BasicCompartment)) {
//				System.out.println("\n\nsto per fare la putView singola di: " + view);
//				System.out.println("\tper l'elemento: " + /iew.getElement());
				putView(view);
			}
			@SuppressWarnings("unchecked")
			List<org.eclipse.gmf.runtime.notation.View> children = view.getChildren();
			for (org.eclipse.gmf.runtime.notation.View child : children) {
//				System.out.println("\n\tsto mappando i children, child = " + child);
//				System.out.println("\tsto mappando i children, child element = " + child.getElement());
				mapModel(child);
			}
			@SuppressWarnings("unchecked")
			List<org.eclipse.gmf.runtime.notation.View> sourceEdges = view.getSourceEdges();
			for (org.eclipse.gmf.runtime.notation.View edge : sourceEdges) {
//				System.out.println("\n\tsto mappando gli edge, edge = " + edge);
//				System.out.println("\tsto mappando gli edge, edge element = " + edge.getElement());
				mapModel(edge);
			}
//			System.out.println("\n\nFINE Lavoro sulla vista " + view);

		}


		/**
		 * Put view.
		 *
		 * @param view
		 *            the view
		 */
		public void putView(org.eclipse.gmf.runtime.notation.View view) {
			EObject element = view.getElement();
			if (element == null && view instanceof org.eclipse.gmf.runtime.notation.Connector) {
				final EObject source = ((org.eclipse.gmf.runtime.notation.Connector) view).getSource().getElement();
				final EObject target = ((org.eclipse.gmf.runtime.notation.Connector) view).getTarget().getElement();
				element = new EdgeWithNoSemanticElementRepresentationImpl(source, target, view.getType());
//				System.out.println("\nHo creato un edge: " + element);
//				System.out.println("\tCon source = " + source);
//				System.out.println("\tCon target = " + target);
			} else if (element == null) {
				return;
			}
			Set<org.eclipse.gmf.runtime.notation.View> set = this.get(element);
			if (set != null) {
				set.add(view);
			} else {
				Set<org.eclipse.gmf.runtime.notation.View> hashSet = new HashSet<org.eclipse.gmf.runtime.notation.View>();
				hashSet.add(view);
				put(element, hashSet);
			}
		}

		/**
		 * Put view.
		 *
		 * @param element
		 *            the element
		 * @param view
		 *            the view
		 */
		public void putView(EObject element, org.eclipse.gmf.runtime.notation.View view) {
			Set<org.eclipse.gmf.runtime.notation.View> set = this.get(element);
			if (set != null) {
				set.add(view);
			} else {
				Set<org.eclipse.gmf.runtime.notation.View> hashSet = new HashSet<org.eclipse.gmf.runtime.notation.View>();
				hashSet.add(view);
				put(element, hashSet);
			}
		}

		/**
		 * Gets the first view, prefer the get(Object key) method to get all the views
		 *
		 * @param key
		 *            the key
		 * @return the first view
		 */
		@Deprecated
		public org.eclipse.gmf.runtime.notation.View getFirstView(Object key) {
			Set<org.eclipse.gmf.runtime.notation.View> set = get(key);
			if (set != null) {
				return set.iterator().next();
			}
			return null;
		}
	}
}

// guardare questi file:
// ShowHideConnectionLabelsRequest
// ShowHideRelatedLink
// ShowHideRelatedLinkEditPolicy.java  getShowLinkCommand

//FIXME: attenzione che quando trascino una connection, va ad attaccarsi alla subcomponent sbagliata!


//getCreateOrRestoreElementCommand

/*
 *  Il messaggio "Create or Restore Connector"  viene usato da CreateOrShowExistingElementHelper.java 
 *  dentro getCreateOrRestoreElementCommand per generare un dialogo
 *  di CreateOrShowExistingLinkDialog.java dove si crea degli existingElement con i source e target
 */

// Guardare questa classe per gestire le associazioni SysML SysMLCreateOrShowExistingElementHelper


// Questo metodo sembra buono: getShowHideRelatedLinkCommandWithDialog


// Controllare questo metodo: getShowHideRelatedLinkCommand, e' quello che crea la richiesta con i vari parametri
// final ICommand tmp = getShowLinkCommand(domain, (EObject) current, domain2NotationMap, linkDescriptors);



// Controllare il modello fatto dalla Domain2Notation, sembra che Pedal_Pos sia uno solo



// Riesco ad ottenere le editpart delle porte che devo connettere! Adesso devo fare la struttura che 
// fa la richiesta di visualizzazione