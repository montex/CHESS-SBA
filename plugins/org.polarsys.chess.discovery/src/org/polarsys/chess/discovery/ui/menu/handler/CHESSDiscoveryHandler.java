/*****************************************************************************
 * Copyright (c) 2011 - 2014 University of Padova.
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

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.polarsys.chess.discovery.ui.wizards.DiscoveryComponent;

public class CHESSDiscoveryHandler extends AbstractHandler {
	
	public CHESSDiscoveryHandler() {
	}

	public Object execute(ExecutionEvent event) throws ExecutionException {
		DiscoveryComponent.execute();
		return null;
	}
}
