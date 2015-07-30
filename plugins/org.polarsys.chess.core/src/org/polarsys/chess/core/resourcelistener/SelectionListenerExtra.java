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

/**
 * An implementation of {@link ISelectionListener} which knows the service registry of
 * Papyrus.
 *
 */
public abstract class SelectionListenerExtra implements ISelectionListener {

	private ServicesRegistry mr;

	/**
	 * Retrieves the service registry.
	 * 
	 *
	 */
	public ServicesRegistry getRegistry() {
		return mr;
	}

	/**
	 * Sets the service registry.
	 * 
	 * @param serviceRegistry  the Papyrus service registry
	 */
	public void setRegistry(ServicesRegistry serviceRegistry) {
		this.mr = serviceRegistry;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.ISelectionListener#selectionChanged(org.eclipse.ui.IWorkbenchPart, org.eclipse.jface.viewers.ISelection)
	 */
	public abstract void selectionChanged(IWorkbenchPart part,
			ISelection selection);
}
