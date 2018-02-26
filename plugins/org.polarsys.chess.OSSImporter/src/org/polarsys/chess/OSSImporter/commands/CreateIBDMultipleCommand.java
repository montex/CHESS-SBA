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
package org.polarsys.chess.OSSImporter.commands;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.polarsys.chess.OSSImporter.actions.ShowIBDElementsAction;
import org.polarsys.chess.OSSImporter.utils.Utils;
import org.polarsys.chess.contracts.profile.chesscontract.util.ContractEntityUtil;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;
import org.polarsys.chess.service.utils.SelectionUtil;

import eu.fbk.eclipse.standardtools.commands.AbstractJobCommand;

public class CreateIBDMultipleCommand extends AbstractJobCommand {
	private static final String DIALOG_TITLE =	"Multiple IBD creator";
	
	private Object umlObject;
	private SelectionUtil selectionUtil = SelectionUtil.getInstance();
	private ShowIBDElementsAction action;

	public CreateIBDMultipleCommand() {
		super("Create IBD Single");
	}

	@Override
	public void execPreJobOperations(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
		final ISelection selection = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();
		umlObject = selectionUtil.getUmlSelectedObject(selection);
		action = new ShowIBDElementsAction();
		
//		System.out.println("selectedUmlElement: " + umlObject);
		
		if (Utils.objectIsSystemViewPackage(umlObject)) {
			
			// Now browse all the blocks and create the diagram
			Package pkg = (Package) umlObject;
			
			EList<Element> packageChildren = pkg.getOwnedElements();
			
			for (Element element : packageChildren) {
				
				if (EntityUtil.getInstance().isBlock(element) && !ContractEntityUtil.getInstance().isContract(element)) {
					final Diagram diagram = action.addIBD((Class) element);
					action.populateDiagram(diagram, element);
				}
			}
		} else {
			Utils.showMessage(DIALOG_TITLE, "Please select a package from <<SystemView>>");
		}
	}

	@Override
	public void execJobCommand(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
	}

}
