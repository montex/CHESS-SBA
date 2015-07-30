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

import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;

/**
 * An extension of the {@link ResourceSetListenerImpl} that knows the Papyrus
 * service registry. 
 *
 */
public class ResourceSetListenerExtra extends ResourceSetListenerImpl{

	protected ServicesRegistry sr;
	
	/**
	 * Sets the service registry.
	 * 
	 * @param sr  the service registry
	 */
	public void setRegistry(ServicesRegistry sr){
		this.sr = sr;
	}
}
