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

package org.polarsys.chess.core.notifications;

import org.eclipse.papyrus.infra.widgets.toolbox.notification.INotification;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.Type;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.builders.NotificationBuilder;

public class ResourceNotification {

	private static NotificationBuilder errorPopup = NotificationBuilder.createErrorPopup(null);
	private static NotificationBuilder infoPopup = new NotificationBuilder();//NotificationBuilder.createAsyncPopup(null);
	
	public static INotification showError(String message){		
		errorPopup.setMessage(message);
		return errorPopup.run();	
	}
	
	public static INotification showInfo(String message){		
		infoPopup.setMessage(message);
		infoPopup.setType(Type.WARNING);
		return infoPopup.run();	
	}
	
	public static INotification showOk(String message){		
		infoPopup.setMessage(message);
		infoPopup.setType(Type.INFO);
		return infoPopup.run();	
	}
	
	
}
