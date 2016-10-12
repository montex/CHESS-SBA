/*****************************************************************************
 * Copyright (c) 2010 - 2014 University of Padova.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Alessandro Zovi
 *
 *****************************************************************************/
package org.polarsys.chess.discovery.ui.menu.handler;

import org.eclipse.jface.action.Action;
import org.polarsys.chess.discovery.ui.wizards.DiscoveryComponent;

/**
 * Action used for discovery 
 */
public class CHESSDiscoveryAction extends Action {
	/**
	 * The constructor.
	 */
	public CHESSDiscoveryAction() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		DiscoveryComponent.execute();
	}
}
