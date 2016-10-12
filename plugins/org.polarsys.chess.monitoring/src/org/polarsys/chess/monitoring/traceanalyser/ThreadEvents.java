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

import java.util.ArrayList;

import org.polarsys.chess.monitoring.traceanalyser.Event;
import org.polarsys.chess.monitoring.traceanalyser.EventType;

public class ThreadEvents
{		
	private String threadID; 
	private ArrayList<Event> runningEvents; 
	private ArrayList<Event> readyEvents;
	private ArrayList<Event> blockedEvents;
	private ArrayList<Event> sleepEvents;
	private ArrayList<Event> wakeupEvents;

	public ThreadEvents(String inThreadID, final ArrayList<Event> inThreadEvents) 
	{	
		this.threadID = inThreadID; 		
		runningEvents = new ArrayList<Event>(); 
		readyEvents   = new ArrayList<Event>();
		blockedEvents = new ArrayList<Event>(); 
		sleepEvents   = new ArrayList<Event>(); 
		wakeupEvents  = new ArrayList<Event>(); 
		
		for(Event event : inThreadEvents)
		{
			if(event.GetEventID() == EventType.runningEventID)
				runningEvents.add(event); 
			else if(event.GetEventID() == EventType.readyEventID)
				readyEvents.add(event);
			else if(event.GetEventID() == EventType.blockedEventID)
				blockedEvents.add(event);
			else if(event.GetEventID() == EventType.sleepEventID)
				sleepEvents.add(event);
			else if(event.GetEventID() == EventType.wakeupEventID)
				wakeupEvents.add(event);
			else 
				System.out.println("Invalid event ID in " + event); 	
		} 
	}
	
	public ArrayList<Event> GetRunningEvents()
	{
		return runningEvents; 
	}
	public ArrayList<Event> GetReadyEvents()
	{
		return readyEvents; 
	}
	public ArrayList<Event> GetBlockedEvents()
	{
		return blockedEvents; 
	}
	public ArrayList<Event> GetSleepEvents()
	{
		return sleepEvents; 
	}
	public ArrayList<Event> GetWakeupEvents()
	{
		return wakeupEvents; 
	}
	public String GetThreadID()
	{
		return threadID; 
	}
	
	public long GetFirstReadyEventInGivenInterval(long timeStart, long timeEnd)
	{ 
		for(Event event: readyEvents)
		{
			if(event.GetTimeStamp() >= timeStart && event.GetTimeStamp() <= timeEnd)
			{
				return event.GetTimeStamp();  
			}
			else if(event.GetTimeStamp() > timeEnd)
			{
				return -1; 
			}
		}		
		return -1; 
	}
	
	public long GetFirstRunningEventInGivenInterval(long timeStart, long timeEnd)
	{ 
		for(Event event: runningEvents)
		{
			if(event.GetTimeStamp()>=timeStart && event.GetTimeStamp()<=timeEnd)
			{
				return event.GetTimeStamp();  
			}
			else if(event.GetTimeStamp()>timeEnd)
			{
				return -1; 
			}		
		}
		return -1; 
	}
	
	
	public long GetLastSleepEventInGivenInterval(long timeStart, long timeEnd)
	{ 
		long prev = -1; 
		
		for(Event event: sleepEvents)
		{
			if(event.GetTimeStamp()>=timeStart && event.GetTimeStamp()<=timeEnd)
			{
				prev = event.GetTimeStamp();  
			}
			else if(event.GetTimeStamp()>timeEnd)
			{
				break; 
			}		
		}		
		return prev; 
	}

	public long FindLastSleepIfAnyAvailable(long currentWakeupTime) 
	{
		for(Event event: sleepEvents)
		{
			if(event.GetTimeStamp()>=currentWakeupTime)
				return event.GetTimeStamp();  
		}	
		return -1; 
	}
}

