/*
-----------------------------------------------------------------------
--          			CHESS core plugin							 --
--                                                                   --
--                    Copyright (C) 2011-2012                        --
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

package org.polarsys.chess.core.constraint;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.validation.internal.util.TextUtils;

/**
 * Extends {@link Status} in order to allow the setting of properties that in Status are readonly.
 *
 */
public class SettableStatus extends Status {

	String messagePattern;
	
	/**
	 * Creates a SettableStatus object, see {@link Status#Status(int, String, String)}
	 * 
	 */
	public SettableStatus(int severity, String pluginId, String messagePattern) {
		super(severity, pluginId, messagePattern);
		this.messagePattern = messagePattern;
	}

	/**
	 * Changes the internal code.
	 * 
	 * @param ok  set the code to IStatus.OK if true, IStatus.ERROR otherwise
	 */
	public void setSuccess(boolean ok) {
		setCode(ok ? IStatus.OK : IStatus.ERROR);
	}

	/**
	 * Sets the message.
	 * 
	 * @param messagePattern  the message
	 */
	public void setMessagePattern(String messagePattern) {
		this.messagePattern = messagePattern;
		super.setMessage(messagePattern);
	}
	
	/**
	 * Sets the message arguments if the message is a pattern.
	 * @param messageArgs
	 */
	public void setMessage(Object... messageArgs) {

		String message = TextUtils.formatMessage(messagePattern,
				(messageArgs == null) ? new Object[0] : messageArgs);
		super.setMessage(message);
	}	

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.Status#isOK()
	 */
	public boolean isOK() {
		return getCode() == IStatus.OK;
	}

}
