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

package org.polarsys.chess.core.internal.views;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.polarsys.chess.core.util.CHESSProjectSupport;

public class ReloadXMLPermissions extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event)
			throws org.eclipse.core.commands.ExecutionException {
		CHESSProjectSupport.printlnToCHESSConsole("Load permissions...");
		ViewPermissions.initializeLists();
		ViewPermissions.readXMLPermissions();
		CHESSProjectSupport.printlnToCHESSConsole("Permissions loaded.");
		return null;
	}

}
