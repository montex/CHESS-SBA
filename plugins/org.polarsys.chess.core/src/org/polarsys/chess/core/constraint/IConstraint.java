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
import org.eclipse.emf.common.notify.Notification;

/**
 * Represents a constraint that the model validator should check.
 *
 */
public interface IConstraint {
	
	public static int WARNING = IStatus.WARNING;
	public static int ERROR = IStatus.ERROR;
	public static int INFO = IStatus.INFO;
	
	/**
	 * @return the name of the constraint
	 */
	public String getName();

	/**
	 * @param name  the name of the constraint
	 */
	public void setName(String name);

	/**
	 * @return the severity level, see {@link IStatus} constants for a list of severities
	 */
	public int getSeverity();

	/**
	 * @param severity  the severity level to be set
	 */
	public void setSeverity(int severity);
	
	/**
	 * @return the message of the constraint
	 */
	public String getMessage();

	/**
	 * @param message  the message of the constraint to be set
	 */
	public void setMessage(String message);
	
	/**
	 * Utility method to show to the user the constraint message in case of failure 
	 */
	public void showUserNotification();
	
	/**
	 * @return the {@link IStatus}
	 */
	public IStatus getStatus();

	/**
	 * Sets the status (see {@link IStatus})
	 * 
	 * @param severity  the severity of the IStatus
	 * @param message  the message of the IStatus
	 */
	public void setStatus(int severity, String message);
	
	/**
	 * Checks the constraints against the {@link Notification}
	 * @param notification  the notification to be checked against
	 * @return the resulting {@link IStatus} 
	 */
	public IStatus check(Notification notification);
}
