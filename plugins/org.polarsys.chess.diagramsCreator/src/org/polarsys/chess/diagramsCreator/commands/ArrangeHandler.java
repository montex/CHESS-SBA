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
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.ArrangeRequest;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSShapeImpl;
import org.eclipse.uml2.uml.Property;
import org.polarsys.chess.service.gui.utils.SelectionUtil;

/**
 * A class that arranges the graphical elements inside the diagram (via arrange all command) and
 * resizes the main block if requested. Used for both IBDs and BDD.
 * @author cristofo
 *
 */
public class ArrangeHandler extends AbstractHandler {

	/** Int value that indicates the number of times to execute the command */
	public static final String LOOP_TIMES = "loop_times";
	
	/** Boolean flag that indicates whether the main diagram should be processed, or its main element */
	public static final String PROCESS_DIAGRAM = "process_diagram";
	
	/**
	 * Resizes the given element depending on the contained components.
	 * @param element the element to resize
	 */
	private void resizeElement(IGraphicalEditPart element) {
		int maxX = 0;
		int maxY = 0;
		
		// Get the compartment edit part
		IGraphicalEditPart compartmentEP = (IGraphicalEditPart) element.getChildren().get(1);
		
		// Loop on all the edit parts
		List<?>compartmentChildren = compartmentEP.getChildren();
		for (Object childEP : compartmentChildren) {
			
			// Get the UML element associated to the EP and look for properties
			EObject semanticElement = ((IGraphicalEditPart) childEP).resolveSemanticElement();
			if (semanticElement instanceof Property) {			
			
				// Get the size and position of the Property box
				final CSSShapeImpl viewShape = (CSSShapeImpl) ((IGraphicalEditPart) childEP).getNotationView();
				final Bounds layout = (Bounds) viewShape.getLayoutConstraint();

				int x = layout.getX() + layout.getWidth();
				int y = layout.getY() + layout.getHeight();
				
				if (x > maxX) {
					maxX = x;
				}
				if (y > maxY) {
					maxY = y;
				}
			}
		}

		final int width = maxX + 100;	// Needed to pass it to the inner class
		final int heigth = maxY + 100;	// Needed to pass it to the inner class
		
		// Resize the main element to fit all the internal boxes
		final TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(element.getNotationView());
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				final CSSShapeImpl viewShape = (CSSShapeImpl) ((IGraphicalEditPart) element).getNotationView();
				final Bounds layout = (Bounds) viewShape.getLayoutConstraint();
				
				// If needed, resize the box 
				if (layout.getWidth() < width) {
					layout.setWidth(width);
				}
				if (layout.getHeight() < heigth) {
					layout.setHeight(heigth);
				}
			}
		});
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final List<IGraphicalEditPart> selection = new ArrayList<IGraphicalEditPart>();
		final IGraphicalEditPart selectedEditPart = SelectionUtil.getInstance().getSelectedGraphicalObject(event);

		// Read the parameter to understand what to arrange
		final String processDiagram = event.getParameter(PROCESS_DIAGRAM);
		
		if (processDiagram != null && processDiagram.equals("false")) {
			
			// Get the EditPart of the main element
			final IGraphicalEditPart elementEditPart = (IGraphicalEditPart) selectedEditPart.getChildren().get(0); 
			
			// Process the structure compartment of the main element
			selection.add((IGraphicalEditPart) elementEditPart.getChildren().get(1));
		} else {

			// Process the main element
			selection.add(selectedEditPart);
		}
		
		final ArrangeRequest request = new ArrangeRequest("arrangeAllAction"); //$NON-NLS-1$
		request.setPartsToArrange((selection));

		final Command cmd = selection.get(0).getCommand(request);

		// Retrieve the number of times to execute the command
		int loopTimes = 1;
		try {
			loopTimes = Integer.parseInt(event.getParameter(LOOP_TIMES));	
		} catch (NumberFormatException e) {

			// No parameter given or NAN, just do one loop
		}

		// Call the command the given number of times
		if (cmd != null && cmd.canExecute()) {
			for (int i = 0; i < loopTimes; i++) {
				cmd.execute();
			}
		}
		
		// Resize the main element and not the diagram, if needed
		if (processDiagram != null && processDiagram.equals("false")) {		
			resizeElement((IGraphicalEditPart) selectedEditPart.getChildren().get(0));
		}
		
		return null;
	}
}
