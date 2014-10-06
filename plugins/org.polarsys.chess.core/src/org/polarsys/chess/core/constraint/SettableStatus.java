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

public class SettableStatus extends Status {

	String messagePattern;
	
	public SettableStatus(int severity, String pluginId, String messagePattern) {
		super(severity, pluginId, messagePattern);
		this.messagePattern = messagePattern;
	}

	public void setSuccess(boolean ok) {
		if (ok)
			setCode(IStatus.OK);
		else
			setCode(IStatus.ERROR);
	}

	public void setMessagePattern(String messagePattern) {
		this.messagePattern = messagePattern;
		super.setMessage(messagePattern);
	}
	
	public void setMessage(Object... messageArgs) {

		String message = TextUtils.formatMessage(messagePattern,
				(messageArgs == null) ? new Object[0] : messageArgs);
		super.setMessage(message);
	}	

	public boolean isOK() {
		return getCode() == IStatus.OK;
	}

}
