/*
-----------------------------------------------------------------------
--          			CHESS core plugin							 --
--                                                                   --
--                    Copyright (C) 2014                        --
--                 University of Padova, ITALY                       --
--                                                                   --
-- Author: Alessandro Zovi         azovi@math.unipd.it               --
--                                                                   --
-- All rights reserved. This program and the accompanying materials  --
-- are made available under the terms of the Eclipse Public License  --
-- v1.0 which accompanies this distribution, and is available at     --
-- http://www.eclipse.org/legal/epl-v10.html                         --
-----------------------------------------------------------------------
*/

package org.polarsys.chess.service;

import java.net.URL;
import java.util.Hashtable;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.sasheditor.editor.ISashWindowsContainer;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.polarsys.chess.core.profiles.CHESSProfileManager;
import org.polarsys.chess.core.resourcelistener.ResourceSetListenerManager;
import org.polarsys.chess.core.resourcelistener.SelectionListenerManager;
import org.polarsys.chess.core.views.DiagramStatus;
import org.polarsys.chess.service.utils.CHESSEditorUtils;

public class CHESSService {
	private static final String ICON_LOCATION = "org.polarsys.chess.service";
	public static Hashtable<String, ImageDescriptor> viewIcons = new Hashtable<String, ImageDescriptor>();
	private ISashWindowsContainer container;
	private ServicesRegistry serviceRegistry;
	private DiagramStatus diagramStatus;
	private SelectionListenerManager selectionListener;
	private ResourceSetListenerManager resourceListener;
	private TransactionalEditingDomain editingDomain;
	private IEditorPart currentEditor;
	private IWorkbenchPage currentPage;
	
	public CHESSService(ISashWindowsContainer container, ServicesRegistry registry) {
		this.container = container;
		serviceRegistry = registry;
	}

	public boolean start(IWorkbenchPart part) {
		
			IEditorPart activeEditor = container.getActiveEditor();
			ISashWindowsContainer t;
			
			
			if (activeEditor!=null && CHESSEditorUtils.isCHESSProject(activeEditor)) {
				initializeCHESS(activeEditor);
				return true;
			}
			if (activeEditor == null) {
				//waitForActiveEditor();
				//return true;
				try {
					if (part instanceof PapyrusMultiDiagramEditor){
						PapyrusMultiDiagramEditor editor =  (PapyrusMultiDiagramEditor)part;
						serviceRegistry = (ServicesRegistry)editor.getAdapter(ServicesRegistry.class);
						container = serviceRegistry.getService(ISashWindowsContainer.class);
						IEditorPart e= container.getActiveEditor();
						if (CHESSEditorUtils.isCHESSProject(editor)) {
							initializeCHESS(editor);
							return true;
						}
					}
					
				} catch (ServiceException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			return false;

	}

	private void initializeCHESS(IEditorPart activeEditor) {
		System.err.println("CHESS Service initialized...");
		ModelSet modelSet = null;
		//ISashWindowsContainer container = null;
		try {
			modelSet = serviceRegistry.getService(ModelSet.class);

			container = ServiceUtils.getInstance().getISashWindowsContainer(
					serviceRegistry);

			diagramStatus = new DiagramStatus(
					container.getActiveSashWindowsPage());
			editingDomain = modelSet
					.getTransactionalEditingDomain();

			CHESSProfileManager
					.loadCHESSProfile(editingDomain.getResourceSet());
			
			//let plugins to load external profiles
			CHESSProfileManager.loadExternalProfiles(editingDomain.getResourceSet());

			resourceListener = new ResourceSetListenerManager(
					serviceRegistry);
			
			editingDomain
					.addResourceSetListener(resourceListener);

			//serviceRegistry.add(DiagramStatus.class, 5, diagramStatus);

			selectionListener = new SelectionListenerManager(
					serviceRegistry);
			currentEditor = activeEditor;
			currentPage = currentEditor.getSite().getPage();
			currentPage.addSelectionListener(selectionListener);

			loadIcons();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	public void stopService(){
		currentPage.removeSelectionListener(selectionListener);
		editingDomain.removeResourceSetListener(resourceListener);
	}

	private void loadIcons() {
		// Load view icons
		
		if (!viewIcons.keySet().isEmpty()){
			return;
		}
		
		URL nullFile = FileLocator.find(Platform
				.getBundle(ICON_LOCATION), new Path(
				"icons/NullView.gif"), null);

		ImageDescriptor icon = ImageDescriptor.createFromURL(nullFile);
		viewIcons.put(CHESSProfileManager.NULL_VIEW, icon);

		for (String v : CHESSProfileManager.CHESS_VIEWS_LIST) {
			URL file = FileLocator.find(
					Platform.getBundle(ICON_LOCATION),
					new Path("icons/" + v + ".gif"), null);
			if (file != null) {
				icon = ImageDescriptor.createFromURL(file);
			} else {
				icon = ImageDescriptor.createFromURL(nullFile);
			}
			viewIcons.put(v, icon);
		}
	}

	public void unload() {
		// TODO Auto-generated method stub
		
	}

	public DiagramStatus getDiagramStatus() {
		return diagramStatus;
	}

}
