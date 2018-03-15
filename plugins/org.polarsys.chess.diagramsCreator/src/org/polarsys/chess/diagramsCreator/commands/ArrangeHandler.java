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

public class ArrangeHandler extends AbstractHandler {

	private void resizeMainBlock(IGraphicalEditPart block) {

		//TODO: devo passare tutti i blocchi figli e trovare le loro coordinate massime (x+width
		
		int maxX = 0;
		int maxY = 0;
		
		// Get the compartment edit part
		IGraphicalEditPart compartmentEP = (IGraphicalEditPart) block.getChildren().get(1);
		

		List<?>compartmentChildren = compartmentEP.getChildren();
		for (Object childEP : compartmentChildren) {
			System.out.println("child of compartment = " + childEP);
			
			// Get the UML element associated to the EP
			EObject semanticElement = ((IGraphicalEditPart) childEP).resolveSemanticElement();
			System.out.println("SemanticElement of compartment = " + semanticElement);
									
			if (semanticElement instanceof Property) {			
			
				// Get the width of the component to set the position of output ports
				final CSSShapeImpl viewShape = (CSSShapeImpl) ((IGraphicalEditPart) childEP).getNotationView();
				final Bounds layout = (Bounds) viewShape.getLayoutConstraint();

				int x = layout.getX() + layout.getWidth();
				int y = layout.getY() + layout.getHeight();
				
				System.out.println("x = " + x + ", y = " + y);
				
				if (x > maxX) {
					maxX = x;
				}
				
				if (y > maxY) {
					maxY = y;
				}
			}
		}
		System.out.println("max X = " + maxX + ", max Y = " + maxY);

		final int width = maxX;
		final int heigth = maxY;
		
		final TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(block.getNotationView());
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				final CSSShapeImpl viewShape = (CSSShapeImpl) ((IGraphicalEditPart) block).getNotationView();
				final Bounds layout = (Bounds) viewShape.getLayoutConstraint();
				layout.setWidth(width + 250);	// Should cover also output ports...
				layout.setHeight(heigth + 100);

			}
		});
		
		
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final List<IGraphicalEditPart> selection = new ArrayList<IGraphicalEditPart>();
		final IGraphicalEditPart selectedEditPart = SelectionUtil.getInstance().getSelectedGraphicalObject(event);

		// Read the parameter to understand what to arrange
		final String processDiagram = event.getParameter(CreateBDDCommand.ARRANGE_PROCESS_DIAGRAM);
		
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
			loopTimes = Integer.parseInt(event.getParameter(CreateBDDCommand.ARRANGE_LOOP_TIMES));	
		} catch (NumberFormatException e) {

			// No parameter given or NAN, just do one loop
		}

		// Call the command the given number of times
		if (cmd != null && cmd.canExecute()) {
			for (int i = 0; i < loopTimes; i++) {
				cmd.execute();
			}
		}
		
		// Resize the main block, if needed
		if (processDiagram != null && processDiagram.equals("false")) {		
			resizeMainBlock((IGraphicalEditPart) selectedEditPart.getChildren().get(0));
			
		}
		
		return null;
	}
}
