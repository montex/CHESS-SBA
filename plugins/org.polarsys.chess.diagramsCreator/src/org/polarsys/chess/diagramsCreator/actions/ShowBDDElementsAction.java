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
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.OffscreenEditPartFactory;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResource;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.ServiceUtilsForEditPart;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSShapeImpl;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.BlockDefinitionDiagramCreateCommand;
import org.eclipse.papyrus.uml.diagram.common.actions.ShowHideContentsAction;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.polarsys.chess.contracts.profile.chesscontract.util.ContractEntityUtil;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;

import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;


public class ShowBDDElementsAction extends ShowHideContentsAction {
	
	/** Selection of all the possible elements */
	private List<Object> selection;

	/** Logger for messages */
	private static final Logger logger = Logger.getLogger(ShowBDDElementsAction.class);

	/**
	 * Tries to show an Element in an EditPart.
	 * @param elementToShow the Element to show
	 * @param activeEditor the editor corresponding to the editPart
	 * @param editPart the EditPart to show the Element in
	 * @param position position is used to try to distribute the drop
	 * @return the EditPart in which the Element has been actually added
	 */
	private EditPart showElementIn(EObject elementToShow, DiagramEditor activeEditor, EditPart editPart, int position) {
		EditPart returnEditPart = null;

		if (elementToShow instanceof Element) {
			DropObjectsRequest dropObjectsRequest = new DropObjectsRequest();
			ArrayList<Element> list = new ArrayList<Element>();
			list.add((Element) elementToShow);
			dropObjectsRequest.setObjects(list);
			dropObjectsRequest.setLocation(new Point(20, 100 * position));
			Command cmd = editPart.getCommand(dropObjectsRequest);

			if (cmd != null && cmd.canExecute()) {
				activeEditor.getDiagramEditDomain().getDiagramCommandStack().execute(cmd);
				returnEditPart = editPart;
			}
		}

		return returnEditPart;
	}

	/**
	 * Adds a IBD diagram to the given block.
	 * @param owner the selected block
	 * @throws Exception
	 */
	public Diagram addBDD(Package owner) throws Exception {

		// Get the services registry
		final ServicesRegistry servicesRegistry = ServiceUtilsForResource.getInstance().getServiceRegistry(owner.eResource());

		// Get the modelSet
		final ModelSet modelSet = ServiceUtils.getInstance().getModelSet(servicesRegistry);

		// Create a IBD diagram for the selected owner
		final BlockDefinitionDiagramCreateCommand command = new BlockDefinitionDiagramCreateCommand();
		return command.createDiagram(modelSet, owner, owner.getName() + "_BDD");
	}

	/**
	 * Resizes the component blocks.
	 * @param diagramEP the diagram EditPart
	 */
	private void resizeElements(IGraphicalEditPart diagramEP) {
		final AtomicInteger subElementCounter = new AtomicInteger(0);

		// Get all the views of the diagram and loop on them
		List<?> childrenView = diagramEP.getNotationView().getChildren();
		
		for (Object child : childrenView) {
			View childView = (View) child;
			logger.debug("child View = " + child);
			logger.debug("\telement of view = " + childView.getElement());
			
			if (EntityUtil.getInstance().isSystem((Element) childView.getElement())) {

				// Enlarge and center the system component
				if (childView instanceof CSSShapeImpl) {
					final CSSShapeImpl viewShape = (CSSShapeImpl) childView;
					final Bounds layout = (Bounds) viewShape.getLayoutConstraint();

					final TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(childView);
					domain.getCommandStack().execute(new RecordingCommand(domain) {

						@Override
						protected void doExecute() {
							layout.setWidth(250);
							layout.setHeight(250);
							layout.setX(400);
							layout.setY(50);
						}
					});
				}
			} else if (EntityUtil.getInstance().isBlock((Element) childView.getElement())) {
				
				// Enlarge the other components
				if (childView instanceof CSSShapeImpl) {
					final CSSShapeImpl viewShape = (CSSShapeImpl) childView;
					final Bounds layout = (Bounds) viewShape.getLayoutConstraint();

					final TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(childView);
					domain.getCommandStack().execute(new RecordingCommand(domain) {

						@Override
						protected void doExecute() {
							layout.setWidth(250);
							layout.setHeight(250);
							layout.setX(50 + 300 * subElementCounter.getAndIncrement());
							layout.setY(400);
						}
					});
				}
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
	 * Builds a list of elements I'm interested to display.
	 * @param results the list of all the possible EditPartRepresentation elements
	 */
//	@Override
	protected void buildShowHideElementsList(Object[] results) {	
		final EntityUtil entityUtil = EntityUtil.getInstance();
		final ContractEntityUtil contractEntityUtil = ContractEntityUtil.getInstance();

		viewsToCreate = new ArrayList<EditPartRepresentation>();
		viewsToDestroy = new ArrayList<EditPartRepresentation>();

		List<Object> result = new ArrayList<>();
		for (int i = 0; i < results.length; i++) {
			
			final EditPartRepresentation editPartRepresentation = (EditPartRepresentation) results[i];

			logger.debug("\n\n\nWorking on results[" + i + "] = " + editPartRepresentation);
			
			final Element semanticElement = (Element) editPartRepresentation.getSemanticElement();
			
			logger.debug("Semantic Element = " + semanticElement);
			logger.debug("Label = " + editPartRepresentation.getLabel());
			logger.debug("Parent = " + editPartRepresentation.getParentRepresentation());
			
			// If the element is interesting, add it
			if((entityUtil.isPort(semanticElement) && 
					!(editPartRepresentation.getParentRepresentation() instanceof AffixedChildrenEditPartRepresentation)) || 
					contractEntityUtil.isContractProperty(semanticElement)||
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
	 * Gets the editing domain.
	 *
	 * @return the editing domain
	 *         the editing domain to use
	 */
	protected final TransactionalEditingDomain getEditingDomain(EditPart host) {
		try {
			return ServiceUtilsForEditPart.getInstance().getTransactionalEditingDomain(host);
		} catch (ServiceException e) {
		}
		return null;
	}
	
	/**
	 * Fills the diagram with graphical components.
	 * @param diagram
	 */
	public void populateDiagram(Diagram diagram) {
		
		final Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		
		// Get the EditPart associated to the diagram
		final IGraphicalEditPart diagramEP = OffscreenEditPartFactory.getInstance().createDiagramEditPart(diagram, shell);
		
		logger.debug("diagram = " + diagram);
		
		Package pkg = (Package) diagramEP.resolveSemanticElement();
				
		EList<Element> packageChildren = pkg.getOwnedElements();
		
		IEditorPart ed =  PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		
		logger.debug("ed = " + ed);
		
		IEditorPart activeEditor = ((PapyrusMultiDiagramEditor) ed).getActiveEditor();
		
		logger.debug("activeEditor = " + activeEditor);

		// First loop to draw Block elements and contracts
		for (Element element : packageChildren) {
//			if (EntityUtil.getInstance().isBlock(element) && !ContractEntityUtil.getInstance().isContract(element)) {
			if (EntityUtil.getInstance().isBlock(element)) {
				logger.debug("calling showElementIn for element = " + element);
				showElementIn(element, (DiagramEditor) activeEditor, diagramEP, 1);
			}
		}
		
		// Resize the graphical elements
		resizeElements(diagramEP);

		// Fill inner fields of the elements

		// Select all the blocks avoiding contracts and add them to the list to be enriched
		selectedElements = new ArrayList<IGraphicalEditPart>();
		List<?> editPartChildren = diagramEP.getChildren();
		for (Object editPartChild : editPartChildren) {
			Element element = (Element) ((IGraphicalEditPart) editPartChild).resolveSemanticElement();
			if (EntityUtil.getInstance().isBlock(element) && !ContractEntityUtil.getInstance().isContract(element)) {
				selectedElements.add((IGraphicalEditPart) editPartChild);
			}
		}

		// Call superclass methods to setup the action
		initAction();
		buildInitialSelection();
		
		// Get a selection with all the possible elements
		buildSelection();

		logger.debug("Selection size = " + selection.size());

		// Draw the innter attributes
		if (selection.size() > 0) {

			// Filter the list to extract only the elements I'm interested in
			buildShowHideElementsList(selection.toArray());

			// Create the list of commands to display the elements
			final Command command = getActionCommand();		

			// Execute the commands
			final TransactionalEditingDomain domain = this.selectedElements.get(0).getEditingDomain();
			domain.getCommandStack().execute(new GEFtoEMFCommandWrapper(command));
		}
		
		// Second loop to draw Associations
		for (Element element : packageChildren) {
			if (element instanceof Association) {
				logger.debug("calling showElementIn for Association = " + element);
				showElementIn(element, (DiagramEditor) activeEditor, diagramEP, 1);
			}
		}
	}
}
