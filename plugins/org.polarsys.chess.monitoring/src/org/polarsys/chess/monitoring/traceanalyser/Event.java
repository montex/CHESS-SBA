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

public class Event
{
	private long timeStamp; 
	private int eventID;
	private String threadID; 

	public Event(long inTimeStamp, int inEventId, String inThreadID ) 
	{
		this.timeStamp = inTimeStamp; 
		this.eventID = inEventId; 
		this.threadID = inThreadID; 
	}
	
	public long GetTimeStamp()
	{
		return timeStamp; 
	}
	
	public int GetEventID()
	{
		return eventID; 
	}
	
	public String GetThreadID()
	{
		return threadID; 
	}	
	
	public void PrintEvent()
	{
		System.out.println("TimeStamp:"+timeStamp+"\tEventID:"+eventID+"\t ThreadID:"+threadID);
	}
	
}

