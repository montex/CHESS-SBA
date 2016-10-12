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

package org.polarsys.chess.core.util;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.papyrus.uml.tools.listeners.PapyrusStereotypeListener;

/**
 * This class handles the output of a {@link Notification}. 
 *
 */
public class NotificationManager {
	private static StringBuffer s = new StringBuffer();
	
	/**
	 * Converts a {@link Notification} to string with a predefined template.
	 * 
	 * @param notif  the notification
	 * @return  the converted notification
	 */
	public static /*@NonNull*/ String printNotification(/*@NonNull*/final Notification notif){
		StringBuffer s = new StringBuffer();
		s.append("Notification type: ");
		s.append(NotificationManager.printEventType(notif));
		s.append("\nNotifier ");
		s.append(notif.getNotifier());
		s.append("\nFeature ");
		s.append(notif.getFeature());
		return s.toString();
	}
	

	/**
	 * Converts the notification event type to string with a predefined template.
	 * 
	 * @param notification  the notification
	 * @return  the converted notification event type
	 */
	@SuppressWarnings("deprecation")
	public static String printEventType(final Notification notification) {
		s.delete(0, s.length());
		switch (notification.getEventType()) {
		case Notification.ADD:
			s.append("ADD");
			break;
		case Notification.ADD_MANY:
			s.append("ADD_MANY");
			break;
		case Notification.CREATE:
			s.append("CREATE");
			break;
		case Notification.EVENT_TYPE_COUNT:
			s.append("EVENT_TYPE_COUNT");
			break;
		case Notification.MOVE:
			s.append("MOVE");
			break;
		//case Notification.NO_FEATURE_ID:
		//
		// break;
		case Notification.NO_INDEX:
			s.append("NO_INDEX");
			break;

		case Notification.REMOVE:
			s.append("REMOVE");
			break;
		case Notification.REMOVE_MANY:
			s.append("REMOVE_MANY");
			break;
		case Notification.REMOVING_ADAPTER:
			s.append("REMOVING_ADAPTER");
			break;
		case Notification.RESOLVE:
			s.append("RESOLVE");
			break;
		case Notification.SET:
			s.append("SET");
			break;
		case Notification.UNSET:
			s.append("UNSET");
			break;
		case PapyrusStereotypeListener.APPLIED_STEREOTYPE:	
			s.append("APPLIED_STEREOTYPE");
			break;
		case PapyrusStereotypeListener.UNAPPLIED_STEREOTYPE:	
			s.append("UNAPPLIED_STEREOTYPE");
			break;
		case PapyrusStereotypeListener.MODIFIED_STEREOTYPE:
			s.append("MODIFIED_STEREOTYPE");
			break;
		default:
			s.append("UNREGISTERED EVENT");
			break;
		}
		return s.toString();
	}
}