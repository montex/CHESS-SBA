/*
-----------------------------------------------------------------------
--          			CHESS editor plugin							 --
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

package org.polarsys.chess.service.internal.commands.switchers;

import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.commands.IElementUpdater;
import org.eclipse.ui.menus.UIElement;
import org.polarsys.chess.core.profiles.CHESSProfileManager;

/**
 * @since 0.10
 */
public class SwitchToRailwayCommand extends AbstractHandler implements
		IElementUpdater {

	public static String COMMAND_ID = "org.polarsys.chess.service.switchRailCommand";
	public static String theView = CHESSProfileManager.RAILWAY_VIEW;
	
	private static SwitchToView handler = new SwitchToView(theView, COMMAND_ID);

	public Object execute(ExecutionEvent event) throws ExecutionException {
		handler.execute(event);
		return null;
	}

	@SuppressWarnings("rawtypes")
	public void updateElement(UIElement element, Map parameters) {
		handler.updateElement(element, parameters);
	}

	public static void refresh() {
		handler.refresh();
	}
}
