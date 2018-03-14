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
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.ArrangeRequest;
import org.polarsys.chess.service.gui.utils.SelectionUtil;

public class ArrangeHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final List<IGraphicalEditPart> selection = new ArrayList<IGraphicalEditPart>();
		final IGraphicalEditPart selectedEditPart = SelectionUtil.getInstance().getSelectedGraphicalObject(event);

		// Get the EditPart of the main element
		final IGraphicalEditPart elementEditPart = (IGraphicalEditPart) selectedEditPart.getChildren().get(0); 
		
		// Read the parameter to understand what to arrange
		final String processDiagram = event.getParameter(CreateBDDCommand.ARRANGE_PROCESS_DIAGRAM);
		
		if (processDiagram != null && processDiagram.equals("false")) {
			
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
		return null;
	}
}
