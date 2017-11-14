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
package org.polarsys.chess.contracts.hierarchicalContractView.listener;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.papyrus.uml.tools.model.UmlUtils;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.polarsys.chess.contracts.hierarchicalContractView.view.CustomHierarchicalView;
import org.polarsys.chess.core.resourcelistener.SelectionListenerExtra;

import eu.fbk.eclipse.standardtools.hierarchicalContractView.core.view.HierarchicalView;

public class SelectionListener extends SelectionListenerExtra {

	private UmlModel prevModelID;

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			Object element = ((IStructuredSelection) selection).getFirstElement();
			if (element instanceof IAdaptable) {
				IResource resource = (IResource) ((IAdaptable) element).getAdapter(IResource.class);
				if (resource != null) {

					UmlModel modelID = UmlUtils.getUmlModel();

					if (modelID != prevModelID) {
						IWorkbench workbench = PlatformUI.getWorkbench();
						IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
						IViewPart modelExplorerViewPart;

						modelExplorerViewPart = window.getActivePage().findView(CustomHierarchicalView.View_ID);
						if (modelExplorerViewPart != null) {
							HierarchicalView view = (HierarchicalView) modelExplorerViewPart;
							view.updateView();
							prevModelID = modelID;
						}
					}
				}
			}
		}

	}

	public static IProject getCurrentSelectedProject() {
		IProject project = null;
		ISelectionService selectionService = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService();

		ISelection selection = selectionService.getSelection();

		if (selection instanceof IStructuredSelection) {
			Object element = ((IStructuredSelection) selection).getFirstElement();

			IResource resource = (IResource) ((IAdaptable) element).getAdapter(IResource.class);
			if (resource != null) {
				project = resource.getProject();
			}
		}
		return project;
	}

}
