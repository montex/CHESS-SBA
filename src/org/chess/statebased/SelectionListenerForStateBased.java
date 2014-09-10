package org.chess.statebased;

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
