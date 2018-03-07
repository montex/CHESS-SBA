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

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.polarsys.chess.diagramsCreator.actions.ShowBDDElementsAction;
import org.polarsys.chess.diagramsCreator.utils.Utils;
import org.polarsys.chess.service.gui.utils.SelectionUtil;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;

public class CreateBDDHandler extends AbstractHandler {
	private static final String DIALOG_TITLE =	"BDD creator";
	
	public CreateBDDHandler() {
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final ISelection selection = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();
		final Object umlObject = SelectionUtil.getInstance().getUmlSelectedObject(selection);
		final EntityUtil entityUtil = EntityUtil.getInstance();

		if (entityUtil.isSystemViewPackage((Element) umlObject)) {
			final Package pkg = (Package) umlObject;
			final ShowBDDElementsAction action = new ShowBDDElementsAction();
			
			try {
				final Diagram diagram = action.addBDD(pkg);
				action.populateDiagram(diagram);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			Utils.showMessage(DIALOG_TITLE, "Please select a package from <<SystemView>>");
		}
		return null;
	}
}
