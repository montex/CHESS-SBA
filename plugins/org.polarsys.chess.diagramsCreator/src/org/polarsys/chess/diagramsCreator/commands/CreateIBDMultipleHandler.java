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
import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.polarsys.chess.contracts.profile.chesscontract.util.ContractEntityUtil;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;
import org.polarsys.chess.diagramsCreator.actions.ShowIBDElementsAction;
import org.polarsys.chess.service.gui.utils.SelectionUtil;

import eu.fbk.eclipse.standardtools.utils.ui.utils.DialogUtil;

/**
 * This class is a command that is invoked by another command.
 * It will start the creation of all the IBDs.
 * @author cristofo
 *
 */
public class CreateIBDMultipleHandler extends AbstractHandler {
	private static final String DIALOG_TITLE =	"Multiple IBD creator";

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final ISelection selection = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();
		final Object umlObject = SelectionUtil.getInstance().getUmlSelectedObject(selection);
		final ShowIBDElementsAction action = new ShowIBDElementsAction();
		final EntityUtil entityUtil = EntityUtil.getInstance();
		final ContractEntityUtil contractEntityUtil = ContractEntityUtil.getInstance();
		
		if (entityUtil.isSystemViewPackage((Element) umlObject)) {
			
			// Now browse all the blocks and create the diagram
			final Package pkg = (Package) umlObject;
			
			final EList<Element> packageChildren = pkg.getOwnedElements();
			
			for (Element element : packageChildren) {
				
				if (entityUtil.isBlock(element) && !contractEntityUtil.isContract(element)) {
					try {
						final Diagram diagram = action.addIBD((Class) element);
						action.populateDiagram(diagram, true);//FIXME: mettere un parametro
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} else {
			DialogUtil.getInstance().showMessage_GenericMessage(DIALOG_TITLE, "Please select a package from <<SystemView>>");
		}
		return null;
	}
}
