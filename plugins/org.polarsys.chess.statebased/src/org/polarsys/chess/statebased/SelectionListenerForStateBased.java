/*
-----------------------------------------------------------------------
-- Copyright (C) 2011-2016                                           --
-- University of Firenze, Italy	                                     --
-- Intecs S.p.A., Italy                                              --
--                                                                   --
-- All rights reserved. This program and the accompanying materials  --
-- are made available under the terms of the Eclipse Public License  --
-- v1.0 which accompanies this distribution, and is available at     --
-- http://www.eclipse.org/legal/epl-v10.html                         --
--                                                                   --
-- Contributors:                                                     --
-- Nicholas Pacini		nicholas.pacini@intecs.it                    --
-----------------------------------------------------------------------
*/

package org.polarsys.chess.statebased;

import org.polarsys.chess.core.resourcelistener.SelectionListenerExtra;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.services.ISourceProviderService;

public class SelectionListenerForStateBased extends SelectionListenerExtra {

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {

		// Enable/disable the command to call state-based analysis
		// Enable when the current view is the dependability analysis view

		IWorkbenchWindow window = part.getSite().getWorkbenchWindow();
		if (window.getActivePage() != null) {
			ISourceProviderService spService = (ISourceProviderService) window
					.getService(ISourceProviderService.class);
			StateBasedSourceProvider sbsp = (StateBasedSourceProvider) spService
					.getSourceProvider(StateBasedSourceProvider.ANALYSIS);

			sbsp.updateStatus(window.getActivePage().getActiveEditor());
		}
	}

}
