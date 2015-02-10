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

import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.sasheditor.editor.ISashWindowsContainer;
import org.eclipse.papyrus.infra.core.services.IServiceFactory;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWindowListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

public class CHESSServiceFactory implements IServiceFactory {

	private CHESSService service;
	private ServicesRegistry serviceRegistry;
	private ISashWindowsContainer container;
	private IPartListener partListener;

	/*
	 * This service attach a PartListener upon its initialization to retrieve the needed ISashWindowsContainer service.
	 * The ISashWindowsContainer service, in fact, is available only after the
	 * actual service registry initialization (it is not strictly part of the service framework).
	 * 
	 * Once the CHESS service is correctly started, the listener is removed.
	 * */
	
	@Override
	public void init(ServicesRegistry servicesRegistry) throws ServiceException {
		this.serviceRegistry = servicesRegistry;
		IWorkbenchWindow w = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		partListener  = createPartListener();
		w.getPartService().addPartListener(partListener);

	}
	
	

	private IPartListener createPartListener() {
		return new IPartListener() {
			
			private void execute(IWorkbenchPart part) {
				if (part instanceof PapyrusMultiDiagramEditor) {
					try {
						container = serviceRegistry.getService(ISashWindowsContainer.class);
						 createCHESSService();
						boolean b = service.start(part);
						if(b) {
							removePartListner(this);
						} else {
							service = null;
						}
					} catch (ServiceException e) {
						/*if ISashWindowsContainer does not exist probably the CHESS service was initialised during the 
						 * creation of the CHESS model => nothing can be done other than removing the listener*/
						//System.err.println(e.getMessage());
						service = null;
						removePartListner(this);
					}
				}
			}
			
			@Override
			public void partOpened(IWorkbenchPart part) {
				execute(part);
			}
			
			@Override
			public void partDeactivated(IWorkbenchPart part) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void partClosed(IWorkbenchPart part) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void partBroughtToTop(IWorkbenchPart part) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void partActivated(IWorkbenchPart part) {
				execute(part);
			}
		};
	}
	
	

	@Override
	public void startService() throws ServiceException {
	}

	
	@Override
	public void disposeService() throws ServiceException {
		removePartListner(partListener);
		if (service !=null){
			System.err.println("CHESS Service terminated.");
			service.stopService();
			service = null;
		}
	}
	
	private void removePartListner(IPartListener partListener) {
		if (partListener != null)
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPartService().removePartListener(partListener);
	}

	private void createCHESSService() {
		service =  new CHESSService(container, serviceRegistry);
	}



	@Override
	public Object createServiceInstance() throws ServiceException {
		return service;
	}
}
