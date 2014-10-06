/*
-----------------------------------------------------------------------
--          			CHESS core plugin							 --
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

package org.polarsys.chess.core.resourcelistener;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;

public abstract class SelectionListenerExtra implements ISelectionListener {
	
	private ServicesRegistry mr;
	
	public ServicesRegistry getRegistry(){
		return mr;
	}	
	
	public void setRegistry(ServicesRegistry serviceRegistry){
		this.mr = serviceRegistry;
	}

	public abstract void selectionChanged(IWorkbenchPart part, ISelection selection);
}
