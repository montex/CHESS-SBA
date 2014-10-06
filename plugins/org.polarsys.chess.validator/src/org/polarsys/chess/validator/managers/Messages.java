/*
-----------------------------------------------------------------------
--          			CHESS validator plugin					     --
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

package org.polarsys.chess.validator.managers;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.polarsys.chess.validator.managers.messages"; //$NON-NLS-1$
	public static String error_diagramInView;
	public static String error_diagramCurrentView;
	public static String NullViewMsg;
	public static String ModelManager_1;	
	public static String ModelManager_2;
	public static String ModelManager_3;
	public static String ModelManager_4;
	public static String ModelManager_5;
	public static String ModelManager_6;
	public static String ModelManager_7;
	public static String ModelManager_8;
	public static String ModelManager_9;
	public static String ViewDeletionMsg;
	public static String operationAborted;
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
