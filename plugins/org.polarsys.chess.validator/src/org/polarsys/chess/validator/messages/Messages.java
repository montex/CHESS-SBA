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

package org.polarsys.chess.validator.messages;

import org.eclipse.osgi.util.NLS;

// TODO: Auto-generated Javadoc
/**
 * The Class Messages contains the string constants used in the validation
 */
public class Messages extends NLS {
	
	/** The Constant BUNDLE_NAME. */
	private static final String BUNDLE_NAME = "org.polarsys.chess.validator.messages.messages"; //$NON-NLS-1$
	
	/** The error_diagram in view. */
	public static String error_diagramInView;
	
	/** The error_diagram current view. */
	public static String error_diagramCurrentView;
	
	/** The Null view msg. */
	public static String NullViewMsg;
	
	/** The Model manager_1. */
	public static String ModelManager_1;	
	
	/** The Model manager_2. */
	public static String ModelManager_2;
	
	/** The Model manager_3. */
	public static String ModelManager_3;
	
	/** The Model manager_4. */
	public static String ModelManager_4;
	
	/** The Model manager_5. */
	public static String ModelManager_5;
	
	/** The Model manager_6. */
	public static String ModelManager_6;
	
	/** The Model manager_7. */
	public static String ModelManager_7;
	
	/** The Model manager_8. */
	public static String ModelManager_8;
	
	/** The Model manager_9. */
	public static String ModelManager_9;
	
	/** The View deletion msg. */
	public static String ViewDeletionMsg;
	
	/** The operation aborted. */
	public static String operationAborted;
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	/**
	 * Instantiates a new messages.
	 */
	private Messages() {
	}
}
