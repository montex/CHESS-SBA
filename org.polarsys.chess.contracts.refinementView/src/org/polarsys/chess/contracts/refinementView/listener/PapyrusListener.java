/*******************************************************************************
 * Copyright (C) 2017 Fondazione Bruno Kessler.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Alberto Debiasi - initial API and implementation
 ******************************************************************************/
package org.polarsys.chess.contracts.refinementView.listener;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.papyrus.infra.core.listenerservice.IPapyrusListener;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Element;
import org.polarsys.chess.contracts.refinementView.view.CustomRefinementView;

public class PapyrusListener implements IPapyrusListener {

	public PapyrusListener() {
	}

	@Override
	public void notifyChanged(Notification notification) {

		Object notifier = notification.getNotifier();

		if (notifier instanceof Element) {

			IWorkbench workbench = PlatformUI.getWorkbench();
			IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
			IViewPart modelExplorerViewPart;

			modelExplorerViewPart = window.getActivePage().findView(CustomRefinementView.View_ID);

			if (modelExplorerViewPart != null) {
				CustomRefinementView view = (CustomRefinementView) modelExplorerViewPart;
				view.updateView();
			}
		}

	}

}
