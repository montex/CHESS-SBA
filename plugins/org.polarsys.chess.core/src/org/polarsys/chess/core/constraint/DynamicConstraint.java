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

/**
 * Implements the {@link IConstraint} interface.
 * 
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

public abstract class DynamicConstraint implements IConstraint {
	
	private String name;
	
	private int severity;
	
	private String message;
	
	SettableStatus status;
	
	/**
	 * Creates the constraint and add it to the {@link ConstraintList}
	 */
	public DynamicConstraint(){
		ConstraintList.add(this);
	};
	
	/**
	 * Creates the constraint and add it to the {@link ConstraintList}
	 * 
	 * @param name  the name of the constraint
	 * @param severity  the severity, see {@link IConstraint} constants
	 * @param messagePattern  the message pattern of the constraint
	 */
	public DynamicConstraint(String name, int severity, String messagePattern){
		setName(name);
		setStatus(severity, messagePattern);
		ConstraintList.add(this);
	}
	
	/* (non-Javadoc)
	 * @see org.polarsys.chess.core.constraint.IConstraint#getName()
	 */
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see org.polarsys.chess.core.constraint.IConstraint#setName(java.lang.String)
	 */
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see org.polarsys.chess.core.constraint.IConstraint#getSeverity()
	 */
	public int getSeverity() {
		return severity;
	}

	/* (non-Javadoc)
	 * @see org.polarsys.chess.core.constraint.IConstraint#setSeverity(int)
	 */
	public void setSeverity(int severity) {
		this.severity = severity;
	}

	/* (non-Javadoc)
	 * @see org.polarsys.chess.core.constraint.IConstraint#getStatus()
	 */
	public SettableStatus getStatus() {
		return status;
	}

	/* (non-Javadoc)
	 * @see org.polarsys.chess.core.constraint.IConstraint#showUserNotification()
	 */
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

	/* (non-Javadoc)
	 * @see org.polarsys.chess.core.constraint.IConstraint#getMessage()
	 */
	public String getMessage() {
		return message;
	}

	/* (non-Javadoc)
	 * @see org.polarsys.chess.core.constraint.IConstraint#setMessage(java.lang.String)
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * Sets the message.
	 * 
	 * @param message
	 */
	public void setStatusMessage(String message) {
		status.setMessagePattern(message);
	}

	/* (non-Javadoc)
	 * @see org.polarsys.chess.core.constraint.IConstraint#setStatus(int, java.lang.String)
	 */
	public void setStatus(int severity, String messagePattern) {
		setSeverity(severity);
		setMessage(messagePattern);
		status = new SettableStatus(severity, Activator.PLUGIN_ID, messagePattern);
	}
	
	/**
	 * Execute {@link #checkConstraint(Notification, DesignView)} method given the current {@link DesignView}.
	 * 
	 * @param notification
	 * @param currentView
	 * @return
	 */
	public IStatus check(Notification notification, DesignView currentView){
		status.setSuccess(checkConstraint(notification, currentView));
		return status;
	}
	
	/* (non-Javadoc)
	 * @see org.polarsys.chess.core.constraint.IConstraint#check(org.eclipse.emf.common.notify.Notification)
	 */
	public IStatus check(Notification notification){
		status.setSuccess(checkConstraint(notification, null));
		return status;
	}
	
	/**
	 * This is the method to implement in order to perform all the checks required by this constraint.
	 * 
	 * @param notification  the {@link Notification} this constraint is run against
	 * @param currentView  the current {@link DesignView}
	 * @return true if the constraint passes / false otherwise
	 */
	public abstract boolean checkConstraint(Notification notification, DesignView currentView);

}
