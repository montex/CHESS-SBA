package org.polarsys.chess.diagramsCreator.commands;

import java.util.ArrayList;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockDefinitionDiagramEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.AssociationEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.BlockEditPart;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.polarsys.chess.contracts.profile.chesscontract.util.ContractEntityUtil;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;
import org.polarsys.chess.service.gui.utils.SelectionUtil;

import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;

public class RefreshBDDHandler extends AbstractHandler {
	private ContractEntityUtil contractEntityUtil = ContractEntityUtil.getInstance();
	private EntityUtil entityUtil = EntityUtil.getInstance();

	/**
	 * Tries to show an Element in an EditPart.
	 * @param elementToShow the Element to show
	 * @param activeEditor the editor corresponding to the editPart
	 * @param editPart the EditPart to show the Element in
	 * @param position position is used to try to distribute the drop
	 * @return the Command to display the element
	 */
	private Command showElementIn(EObject elementToShow, DiagramEditor activeEditor, EditPart editPart, int position) {
		
		if (elementToShow instanceof Element) {
			DropObjectsRequest dropObjectsRequest = new DropObjectsRequest();
			ArrayList<Element> list = new ArrayList<Element>();
			list.add((Element) elementToShow);
			dropObjectsRequest.setObjects(list);
			dropObjectsRequest.setLocation(new Point(100 * position, 0));
			Command cmd = editPart.getCommand(dropObjectsRequest);

			if (cmd != null && cmd.canExecute()) {
				return cmd;
//				activeEditor.getDiagramEditDomain().getDiagramCommandStack().execute(cmd);
			}
		}
		return null;
	}

	
//	private void resizeElements(IGraphicalEditPart diagramEP) {
//
//		// Get all the views of the diagram and loop on them
//		List<?> childrenView = diagramEP.getNotationView().getChildren();
//		
//		final TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(diagramEP.getNotationView());
//		domain.getCommandStack().execute(new RecordingCommand(domain) {
//
//			@Override
//			protected void doExecute() {
//
//				for (Object child : childrenView) {
//					View childView = (View) child;
//					final Element semanticElement = (Element) childView.getElement();
//
//					if (entityUtil.isBlock(semanticElement)) {
//
//						// Enlarge the component but don't position it, arrange will do it later
//						if (childView instanceof CSSShapeImpl) {
//							final CSSShapeImpl viewShape = (CSSShapeImpl) childView;
//							final Bounds layout = (Bounds) viewShape.getLayoutConstraint();
//
//							final int[] size = getSize(semanticElement);
//							layout.setWidth(size[0]);
//							layout.setHeight(size[1]);
//						}
//					}
//				}
//			}
//		});
//	}

	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		final IGraphicalEditPart selectedEditPart = SelectionUtil.getInstance().getSelectedGraphicalObject(event);
		
		System.out.println("SelectedEditPart = " + selectedEditPart);
		
		// Get the EditorPart and the active editor
		IEditorPart editorPart =  PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		IEditorPart activeEditor = ((PapyrusMultiDiagramEditor) editorPart).getActiveEditor();
		
		// Get all the EditParts of the diagram
		final Map<?, ?> elements = selectedEditPart.getViewer().getEditPartRegistry();
		final Object[] editParts = elements.values().toArray();

		final EList<Class> displayedBlocks = new BasicEList<Class>();
		final EList<Association> displayedAssociations = new BasicEList<Association>();
		
		// Loop on all the editparts to collect the displayed elements
		for (int i = 0; i < editParts.length; i++) {
			System.out.println("\neditPart = " + editParts[i]);
			if (editParts[i] instanceof BlockEditPart) {
				displayedBlocks.add((Class) ((BlockEditPart) editParts[i]).resolveSemanticElement());
			} else if (editParts[i] instanceof AssociationEditPart) {
				displayedAssociations.add((Association) ((AssociationEditPart) editParts[i]).resolveSemanticElement());
			}
		}
//			if (editParts[i] instanceof IGraphicalEditPart) {
//				final EObject semanticElement = ((IGraphicalEditPart) editParts[i]).resolveSemanticElement();
//				System.out.println("\tSemanticElement = " + semanticElement);
//				if (semanticElement instanceof Class) {
//					displayedBlocks.add((Class) semanticElement);
//				} else if (semanticElement instanceof Association) {
//					displayedAssociations.add((Association) semanticElement);
//				}
//			}			
//		}

		for (Class block : displayedBlocks) {
			System.out.println("displayed block = " + block);
		}
		
		for (Association association : displayedAssociations) {
			System.out.println("displayed association = " + association);
		}
		
		
		// The package containing the model
		final Package pkg = displayedBlocks.get(0).getNearestPackage();
		System.out.println("Containing package = " + pkg);
		
		//TODO: ho il package che contiene il mio modello, lo navigo per vedere se ho gia' una rappresentazione 
		
		// Get all the existing blocks looping on all members
		EList<Element> existingElements = pkg.getOwnedElements();
		
		EList<Element> missingBlocks = new BasicEList<Element>();
		EList<Element> missingAssociations = new BasicEList<Element>();
		
		// Prepare the map to mark existing blocks
		for (Element element : existingElements) {
			if (entityUtil.isBlock(element) && !contractEntityUtil.isContract(element)) {
				System.out.println("\nblocco del modello = " + element);
				
				if (displayedBlocks.contains(element)) {
					System.out.println("block already present in diagram");
				} else {
					System.out.println("block is not present in diagram");
					missingBlocks.add(element);
				}
			} else if (element instanceof Association) {
				System.out.println("\nassociazione del modello = " + element);
				if (displayedAssociations.contains(element)) {
					System.out.println("association already present in diagram");
				} else {
					System.out.println("association is not present in diagram");
					missingAssociations.add(element);
				}
			}
		}

		CompoundCommand completeCmd = new CompoundCommand("Show Elements Command"); //$NON-NLS-1$

		int index = 0;
		for (Element element : missingBlocks) {
			System.out.println("block missing in the diagram = " + element);
			final Command cmd = showElementIn(element, (DiagramEditor) activeEditor, selectedEditPart, index++);
			try {
				if (cmd.canExecute()) {
					completeCmd.add(cmd);
				}
			} catch (Exception e) {
				System.err.println("Problems in displaying blocks");
			}
		}

		// Execute the commands to display blocks
		if (completeCmd.size() > 0) {
			completeCmd.execute();
		}
		
		
		
		
		completeCmd = new CompoundCommand("Show Elements Command"); //$NON-NLS-1$
		
		for (Element element : missingAssociations) {
			System.out.println("association missing in the diagram = " + element);
			final Command cmd = showElementIn(element, (DiagramEditor) activeEditor, selectedEditPart, 0); 
			try {
				if (cmd.canExecute()) {
					completeCmd.add(cmd);
				}
			} catch (Exception e) {
				System.err.println("Problems in displaying associations");
			}
		}
		
		// Execute the commands to display associations
		if (completeCmd.size() > 0) {
			completeCmd.execute();
		}
		
		return null;
	}
}
