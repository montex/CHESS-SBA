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

public interface IConstraint {
	
	public static int WARNING = IStatus.WARNING;
	public static int ERROR = IStatus.ERROR;
	public static int INFO = IStatus.INFO;
	
	public String getName();

	public void setName(String name);

	public int getSeverity();

	public void setSeverity(int severity);
	
	public String getMessage();

	public void setMessage(String message);
	
	public void showUserNotification();
	
	public IStatus getStatus();

	public void setStatus(int severity, String message);
}
