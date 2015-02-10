/*
-----------------------------------------------------------------------
--          			CHESS editor plugin							 --
--                                                                   --
--                    Copyright (C) 2011-2012                        --
--                 University of Padova, ITALY                       --
--                                                                   --
-- Author: Alessandro Zovi         azovi@math.unipd.it 		         --
--                                                                   --
-- All rights reserved. This program and the accompanying materials  --
-- are made available under the terms of the Eclipse Public License  --
-- v1.0 which accompanies this distribution, and is available at     --
-- http://www.eclipse.org/legal/epl-v10.html                         --
-----------------------------------------------------------------------
*/

package org.polarsys.chess.service;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.impl.EObjectTreeElementImpl;
import org.eclipse.papyrus.infra.core.sasheditor.editor.IPage;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerPageBookView;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.services.ISourceProviderService;
import org.eclipse.ui.views.properties.PropertySheet;
import org.polarsys.chess.core.resourcelistener.SelectionListenerExtra;
import org.polarsys.chess.core.views.DiagramStatus;
import org.polarsys.chess.service.commands.SwitchSourceProvider;
import org.polarsys.chess.service.utils.CHESSEditorUtils;

public class SelectionListener extends SelectionListenerExtra {

	DiagramStatus diagramStatus = null;

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		// lazy association
		if (diagramStatus == null)
			
		diagramStatus = CHESSEditorUtils.getDiagramStatus(getRegistry());
		if (diagramStatus == null) {
			return;
		}
		diagramStatus.setUserAction(true);
		if (part instanceof PropertySheet) {
			part = ((PropertySheet) part).getSite().getWorkbenchWindow()
					.getActivePage().getActiveEditor();
		}
//		if (part instanceof IEditorPart && CHESSEditorUtils.isCHESSProject((IEditorPart)part) && CHESSEditorUtils.isModelEditor(part)) {
		if (part instanceof PapyrusMultiDiagramEditor && CHESSEditorUtils.isCHESSProject((IEditorPart)part)) {
			// listens to sash page change events in the editor
			PapyrusMultiDiagramEditor editor = (PapyrusMultiDiagramEditor) part;
			IPage newPage = (editor).getISashWindowsContainer()
					.getActiveSashWindowsPage();
//			System.out.println("PAGE:" + newPage);

			diagramStatus.setActualView(newPage);
			
			// enable/disable palettes
			
			PaletteManager.setPaletteVisibility(editor, diagramStatus);
			
		} else if (part instanceof ModelExplorerPageBookView
				&& selection instanceof TreeSelection && !selection.isEmpty()) {
			// listens to model element selection in Model Explorer
			TreeSelection tSelection = (TreeSelection) selection;
			Object fElement = tSelection.getFirstElement();
			if (fElement instanceof EObjectTreeElementImpl) {
				diagramStatus.setActualView(tSelection);
			}
		}

		IWorkbenchWindow window = null;
		try {
			window = part.getSite().getWorkbenchWindow();
		} catch (Exception e) {
			//Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage()));
			return;
		}
		
		
		if (window.getActivePage() != null) {
			// Enable/disable the switch to extra-functional view command
			// Enable when the current view is the functional view
			ISourceProviderService spService = (ISourceProviderService) window
					.getService(ISourceProviderService.class);
			SwitchSourceProvider sp = (SwitchSourceProvider) spService
					.getSourceProvider(SwitchSourceProvider.SWITCH);

			sp.updateStatus(window.getActivePage().getActiveEditor());
		}
	}
	
	
}
