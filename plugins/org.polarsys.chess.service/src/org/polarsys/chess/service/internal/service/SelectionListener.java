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

package org.polarsys.chess.service.internal.service;

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
import org.polarsys.chess.service.exceptions.NoDiagramStatusException;
import org.polarsys.chess.service.internal.Activator;
import org.polarsys.chess.service.internal.commands.switchers.SwitchSourceProvider;
import org.polarsys.chess.service.internal.palette.PaletteManager;
import org.polarsys.chess.service.utils.CHESSEditorUtils;

public class SelectionListener extends SelectionListenerExtra {

	DiagramStatus diagramStatus = null;
	
	private void retrieveDiagramStatus() throws NoDiagramStatusException{
		// lazy association
		if (diagramStatus == null)
			diagramStatus = CHESSEditorUtils.getDiagramStatus(getRegistry());
		
		if (diagramStatus == null) {
			throw new NoDiagramStatusException();
		}
	}
	
	private void processPart(IWorkbenchPart part, ISelection selection){
		if (part instanceof PropertySheet) {
			/*get the actual active editor*/
			part = ((PropertySheet) part).getSite().getWorkbenchWindow()
					.getActivePage().getActiveEditor();
		} else if (part instanceof PapyrusMultiDiagramEditor && 
				CHESSEditorUtils.isCHESSProject((IEditorPart)part)) {
			// listens to sash page change events in the editor and
			// modify the view
			PapyrusMultiDiagramEditor editor = (PapyrusMultiDiagramEditor) part;
			IPage activePage = (editor).getISashWindowsContainer()
					.getActiveSashWindowsPage();

			diagramStatus.setActualView(activePage);			
			// enable/disable palette according to current view
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
	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		try {
			retrieveDiagramStatus();

			diagramStatus.setUserAction(true);
			processPart(part, selection);

			IWorkbenchWindow window = part.getSite().getWorkbenchWindow();

			if (window.getActivePage() != null) {
				
				updateStatus(window);
			}
		} catch (NoDiagramStatusException e1) {
			Activator.error(null, e1);
		} catch (Exception e2) {
			Activator.error(null, e2);
		}
	}

	/**
	 *  Enable/disable the switch to extra-functional view command
	 *  Enable when the current view is the functional view
	 */
	private void updateStatus(IWorkbenchWindow window) {
		ISourceProviderService spService = (ISourceProviderService) window
				.getService(ISourceProviderService.class);
		SwitchSourceProvider sp = (SwitchSourceProvider) spService
				.getSourceProvider(SwitchSourceProvider.SWITCH);

		sp.updateStatus(window.getActivePage().getActiveEditor());
	}
	
}
