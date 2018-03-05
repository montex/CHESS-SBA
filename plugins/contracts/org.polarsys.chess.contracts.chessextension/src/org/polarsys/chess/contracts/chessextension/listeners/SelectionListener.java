/*******************************************************************************
 *
 * Copyright (c) 2013, 2015 Intecs SpA 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Nicholas Pacini nicholas.pacini@intecs.it 
 * Stefano Puri stefano.puri@intecs.it
 * Laura Baracchi  laura.baracchi@intecs.it  
 * Initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.polarsys.chess.contracts.chessextension.listeners;


import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.sasheditor.editor.IPage;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.PropertySheet;
import org.polarsys.chess.contracts.chessextension.managers.PaletteManager;
import org.polarsys.chess.core.resourcelistener.SelectionListenerExtra;
import org.polarsys.chess.core.views.DiagramStatus;
import org.polarsys.chess.service.gui.utils.CHESSEditorUtils;

public class SelectionListener extends SelectionListenerExtra {

	DiagramStatus diagramStatus = null;

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		
		// lazy association
		if (diagramStatus == null)
			
		diagramStatus = CHESSEditorUtils.getDiagramStatus(getRegistry());
			
		diagramStatus.setUserAction(true);
		if (part instanceof PropertySheet) {
			part = ((PropertySheet) part).getSite().getWorkbenchWindow()
					.getActivePage().getActiveEditor();
		}
		if (part instanceof PapyrusMultiDiagramEditor && CHESSEditorUtils.isCHESSProject((IEditorPart)part)) {
			// listens to sash page change events in the editor
			PapyrusMultiDiagramEditor editor = (PapyrusMultiDiagramEditor) part;
			
			IPage newPage = (editor).getISashWindowsContainer()
					.getActiveSashWindowsPage();
			
			// enable/disable palettes
			
			PaletteManager.setPaletteVisibility(editor, diagramStatus);
			
		} 
		
	}
	
	
}
