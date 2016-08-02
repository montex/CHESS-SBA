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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.eclipse.core.resources.IFile;
import org.polarsys.chess.monitoring.traceanalyser.Event;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;


public class TraceReader
{ 
	private int time_Stamp_Column = 0;
	private int event_ID_Column   = 1; 	
	private int thread_ID_Column  = 2; 

	private double clockrate = 1;
	private String traceFileName; 
	private ArrayList<ArrayList<Event>> threadSpecificEvents; 
	private ArrayList<String> threadIDs; 
	
	private String analysisContext;

	public TraceReader(IFile traceFile, IFile threadIDsFile, String delimiter) 
	{
		traceFileName = traceFile.getLocation().toOSString(); 
		analysisContext = GetAnalysisContext(threadIDsFile.getLocation().toOSString());
		threadIDs = new ArrayList<String>();
		threadIDs = GetThreadIDs(threadIDsFile.getLocation().toOSString()); // the order in which threadIDs are provide will be used to maintain the events related that threadid in threadSpecificEvents 
		
		if(threadIDs.size() == 0)
		{
			System.out.println("Error: No thread ID to analyze.");
			System.exit(0); 
		}
		
		threadSpecificEvents = new ArrayList<ArrayList<Event>>(); 

		for(int i=0; i<threadIDs.size(); i++)
		{
			threadSpecificEvents.add(new ArrayList<Event>());   
		}
		ReadTraceFile(delimiter); 
	}
	
	private String GetAnalysisContext(String fileName)
	{
		String analContext = null;
		try
		{
			File fXmlFile = new File(fileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();
			
			NodeList contexts = doc.getElementsByTagName("analysisContext");			
			Node context = contexts.item(0);
			if(context.getNodeType() == Node.ELEMENT_NODE)
			{
				Element elem = (Element)context;
				analContext = elem.getAttribute("name");
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return analContext;
	}
	
	private ArrayList<String> GetThreadIDs(String fileName) 
	{
		ArrayList<String> threadNames = new ArrayList<String>();
		try
		{
			File fXmlFile = new File(fileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();
			
			NodeList contexts = doc.getElementsByTagName("analysisContext");			
			Node context = contexts.item(0);
			if(context.getNodeType() == Node.ELEMENT_NODE)
			{
				Element elem = (Element)context;
				this.analysisContext = elem.getAttribute("name");
			}
			
			NodeList allthreads = doc.getElementsByTagName("ThreadNames");

			for (int i = 0; i < allthreads.getLength(); i++) 
			{
				Node thread = allthreads.item(i);
				if (thread.getNodeType() == Node.ELEMENT_NODE) 
				{
					Element eElement = (Element) thread;
					threadNames.add(eElement.getAttribute("name"));//.getElementsByTagName("name").item(0).getTextContent()); 
				}
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return threadNames;
	}


	private void ReadTraceFile(String delimiter) 
	{
		try 
		{
			FileReader file = new FileReader(traceFileName);
			BufferedReader br = new BufferedReader(file); 
			String strLine; 
			Event event ;  
			
			strLine = br.readLine();
			if(strLine != null)
			{
				strLine = strLine.trim();
				String[] strEvent = strLine.split(delimiter);
				
				if(strEvent.length == 2 && strEvent[0].equals("clockrate"))
				{
					clockrate=Double.parseDouble(strEvent[1]);
				}
				else
				{
					System.out.println("Error: clockrate is not specified in the trace file.");
					br.close();
					return;
				}
			}

			while ((strLine = br.readLine()) != null) 
			{
				strLine = strLine.trim();
				String[] strEvent = strLine.split(delimiter); 
				
				if(strEvent.length ==3)
				{	
					event = new Event(Long.parseLong(strEvent[time_Stamp_Column]), Integer.parseInt(strEvent[event_ID_Column]), strEvent[thread_ID_Column]); 

					if(threadIDs.contains(event.GetThreadID()))
						threadSpecificEvents.get(threadIDs.indexOf(event.GetThreadID())).add(event);
				}
				else
				{
					System.out.println("Error: Some events do not follow the expected trace format.");
					br.close();
					return;
				}
			}
			br.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
	}

	public void PrintThreadSpecificEvents(String tid)
	{
		int indexOfThread = threadIDs.indexOf(tid); 

		System.out.println("Time Stamp \t EventID \t ThreadID");
		for(Event event : threadSpecificEvents.get(indexOfThread))
			System.out.println(event.GetTimeStamp()+"\t"+event.GetEventID() +"\t"+ event.GetThreadID());		
	}

	public void WriteThreadSpecificEventsIntoFile(String tid)
	{
		int indexOfThread = threadIDs.indexOf(tid); 

		FileWriter filewrite;
		try {
			filewrite = new FileWriter(tid.concat(".txt"), false);
			BufferedWriter out = new BufferedWriter(filewrite); 

			for(Event event : threadSpecificEvents.get(indexOfThread))
				out.write(event.GetTimeStamp()+"\t"+event.GetEventID() +"\t"+ event.GetThreadID()+"\n");		

			out.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}  
	}

	/*************
	 *  Getters
	 * ***********/
	public ArrayList<String> GetThreadIDs()
	{
		return threadIDs; 
	}
	
	public String GetAnalysisContext()
	{
		return this.analysisContext;
	}

	public ArrayList<ArrayList<Event>> GetThreadSpecificEvents()
	{
		return threadSpecificEvents; 
	}

	public String GetThreadIdOfGivenEvents(ArrayList<ArrayList<Integer>> eventsList)
	{
		if(threadSpecificEvents.contains(eventsList))
			return threadIDs.get(threadSpecificEvents.indexOf(eventsList));
		else 
			return null; 
	}

	public int GetThreadIDColumn()
	{
		return thread_ID_Column; 
	}

	public int GetEventIDColumn()
	{
		return event_ID_Column; 
	}

	public int GetTimeStampColumn()
	{
		return time_Stamp_Column; 
	}
	public double GetClockRate()
	{
		return clockrate; 
	}
}





