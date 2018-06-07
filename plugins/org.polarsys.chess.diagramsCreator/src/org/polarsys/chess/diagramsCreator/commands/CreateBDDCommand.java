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

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.elk.core.service.DiagramLayoutEngine;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.infra.ui.editor.IMultiDiagramEditor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.Element;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;
import org.polarsys.chess.service.gui.utils.SelectionUtil;

import eu.fbk.eclipse.standardtools.utils.ui.commands.AbstractJobCommand;
import eu.fbk.eclipse.standardtools.utils.ui.utils.CommandBuilder;

/**
 * Class that creates a BDD by calling different handlers. 
 * It is triggered by the contextual menu item on a package.
 * @author cristofo
 *
 */
public class CreateBDDCommand extends AbstractJobCommand {
	private static final String BDD_CREATOR_COMMAND = "org.polarsys.chess.diagramsCreator.commands.createBDDHandler";

	public CreateBDDCommand() {
		super("Create BDD");
	}

	@Override
	public void execPreJobOperations(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
	}

	@Override
	public void execJobCommand(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
		
		// Call the command to create the diagram and populate it
		try {
			final CommandBuilder diagramBDDCreator = CommandBuilder.build(BDD_CREATOR_COMMAND);
			diagramBDDCreator.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Needed otherwise the diagram is layouted before being completed
		Thread.sleep(1000);
			
		// Call the Eclipse Layout Kernel engine        			
		// Get the active editor, which is expected to contain the diagram for applying layout
		IEditorPart editorPart = HandlerUtil.getActiveEditor(event);        
		final ISelection selection = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();
		final Object umlObject = SelectionUtil.getInstance().getUmlSelectedObject(selection);

		if (EntityUtil.getInstance().isSystemViewPackage((Element) umlObject)) {
			if (editorPart instanceof IMultiDiagramEditor) {
				editorPart = ((IMultiDiagramEditor) editorPart).getActiveEditor();
			}

			if (editorPart instanceof DiagramEditor) {
				Object diagramPart = null;
				final boolean zoomToFit = true;
				DiagramLayoutEngine.invokeLayout(editorPart, diagramPart, false, false, false, zoomToFit);
			}
		}		
	}
}
