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
import org.polarsys.chess.core.Activator;
import org.polarsys.chess.core.notifications.ResourceNotification;
import org.polarsys.chess.core.views.DiagramStatus.DesignView;

/*
 * Framework usage:
 * 
 * In a Library of constraints: 
 * 
 * public static DynamicConstraint c1 = new DynamicConstraint(1, "c1", IConstraint.WARNING, "c1 message") {
 *   @Override
 *   public boolean checkConstraint(Notification notification){
 *      boolean successfullyVerifiedConstraint = false;
 *      ... //check conditions
 *      return successfullyVerifiedConstraint;
 *   }
 * }
 * 
 * In the listener:
 *   if (!Library.constraint1.check(notification).isOK()){
 *     Library.constraint1.showUserNotification();
 *     throw new RollbackException(Library.constraint1.getStatus())
 *   }
 * */

public abstract class DynamicConstraint implements IDynamicConstraint {
	
	private String name;
	
	private int severity;
	
	private String message;
	
	SettableStatus status;
	
	public DynamicConstraint(){
		ConstraintList.add(this);
	};
	
	public DynamicConstraint(String name, int severity, String messagePattern){
		setName(name);
		setStatus(severity, messagePattern);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSeverity() {
		return severity;
	}

	public void setSeverity(int severity) {
		this.severity = severity;
	}

	public SettableStatus getStatus() {
		return status;
	}

	public void showUserNotification() {
		switch (status.getSeverity()) {
		case IStatus.ERROR:
			ResourceNotification.showError(status.getMessage());
		case IStatus.INFO:
		case IStatus.WARNING:
		default:
			ResourceNotification.showInfo(status.getMessage());
		}
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void setStatusMessage(String message) {
		status.setMessagePattern(message);
	}

	public void setStatus(int severity, String messagePattern) {
		setSeverity(severity);
		setMessage(messagePattern);
		status = new SettableStatus(severity, Activator.PLUGIN_ID, messagePattern);
	}
	
	public IStatus check(Notification notification, DesignView currentView){
		status.setSuccess(checkConstraint(notification, currentView));
		return status;
	}
	
	public IStatus check(Notification notification){
		status.setSuccess(checkConstraint(notification, null));
		return status;
	}
	
	public abstract boolean checkConstraint(Notification notification, DesignView currentView);

}
