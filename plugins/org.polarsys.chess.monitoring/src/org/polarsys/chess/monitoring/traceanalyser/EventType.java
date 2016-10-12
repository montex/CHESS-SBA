/*******************************************************************************
 *                  CHESS monitoring plugin
 *
 *               Copyright (C) 2015-2016
 *            Mälardalen University, Sweden
 *
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License
 *  v1.0 which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.polarsys.chess.monitoring.traceanalyser;

public final class EventType {
	public static final int runningEventID = 0; 
	public static final int readyEventID   = 1; 
	public static final int blockedEventID = 2; 
	public static final int sleepEventID   = 3; 
	public static final int wakeupEventID  = 4; 
}
