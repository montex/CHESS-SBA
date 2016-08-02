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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.polarsys.chess.monitoring.traceanalyser.Event;
import org.polarsys.chess.monitoring.traceanalyser.EventType;
import org.polarsys.chess.monitoring.traceanalyser.ThreadEvents;
import org.polarsys.chess.monitoring.traceanalyser.TraceReader;

public class Parameters
{ 
	private TraceReader trace; 
	private ArrayList<String> threadIDs; 
	private ArrayList<ArrayList<Event>> threadSpecificEvents ; 

	private ArrayList<Long> wcetOfAllThreads; 
	private ArrayList<Long> bcetOfAllThreads; 
	private ArrayList<Double> acetOfAllThreads; 

	private ArrayList<Long> minimumInterArrivalTimeOfAllThreads; 
	private ArrayList<Long> maximumInterArrivalTimeOfAllThreads; 
	private ArrayList<Double> averageInterArrivalTimeOfAllThreads; 
	private ArrayList<Long> releaseJitterOfAllThreads; 

	private ArrayList<Long> minimumBlockingOfAllThreads; 
	private ArrayList<Long> maximumBlockingOfAllThreads; 
	private ArrayList<Double> averageBlockingOfAllThreads; 

	private ArrayList<Long> worstCaseResponseTimetOfAllThreads; 
	private ArrayList<Long> bestCaseResponseTimetOfAllThreads; 
	private ArrayList<Long> jitterInResponseTimetOfAllThreads; 
	private ArrayList<Double> averageCaseResponseTimetOfAllThreads; 

	private ArrayList<Double> varianceInExecutionTimeOfAllThreads;
	private ArrayList<Double> varianceInArrivalTimeOfAllThreads;
	private ArrayList<Double> varianceInBlockingOfAllThreads;
	private ArrayList<Double> varianceInResponseTimeOfAllThreads;
	
	private double clockRate; 	
	private IFolder traceExtractionPath; // This path is used to output files that contains all the values of execution time, inter-arrival time and response time
	private int noOfThreads; 

	public Parameters(TraceReader inTrace, IFolder inTraceExtractionPath) 
	{
		this.trace = inTrace; 
		threadSpecificEvents = trace.GetThreadSpecificEvents();
		threadIDs = trace.GetThreadIDs(); 
		noOfThreads = threadIDs.size();
		clockRate = trace.GetClockRate(); 

		this.traceExtractionPath = inTraceExtractionPath; 

		/* Execution related parameters */
		wcetOfAllThreads = new ArrayList<Long>(noOfThreads);
		bcetOfAllThreads = new ArrayList<Long>(noOfThreads);
		acetOfAllThreads = new ArrayList<Double>(noOfThreads);

		/* Arrival time related parameters */
		minimumInterArrivalTimeOfAllThreads = new ArrayList<Long>(noOfThreads);
		maximumInterArrivalTimeOfAllThreads = new ArrayList<Long>(noOfThreads);
		averageInterArrivalTimeOfAllThreads = new ArrayList<Double>(noOfThreads); 
		releaseJitterOfAllThreads = new ArrayList<Long>(noOfThreads);

		/* Block related parameters */
		minimumBlockingOfAllThreads  = new ArrayList<Long>(noOfThreads); 
		maximumBlockingOfAllThreads  = new ArrayList<Long>(noOfThreads); 
		averageBlockingOfAllThreads  = new ArrayList<Double>(noOfThreads); 

		/* Response time related parameters */
		worstCaseResponseTimetOfAllThreads = new ArrayList<Long>(noOfThreads); 
		bestCaseResponseTimetOfAllThreads = new ArrayList<Long>(noOfThreads);
		jitterInResponseTimetOfAllThreads = new ArrayList<Long>(noOfThreads);
		averageCaseResponseTimetOfAllThreads = new ArrayList<Double>(noOfThreads);

		/* Variance related parameters */
		varianceInExecutionTimeOfAllThreads = new ArrayList<Double>(noOfThreads); 
		varianceInArrivalTimeOfAllThreads = new ArrayList<Double>(noOfThreads); 
		varianceInBlockingOfAllThreads = new ArrayList<Double>(noOfThreads); 
		varianceInResponseTimeOfAllThreads = new ArrayList<Double>(noOfThreads); 
	}

	public void ComputeParameters()
	{
		ComputeArrivalTimeRelatedParameters();
		ComputeExecutionTimeRelatedParameters();
	}
	
	private void ComputeArrivalTimeRelatedParameters() 
	{
		ArrayList<Long> arrivalTimeOfThread = new ArrayList<Long>(); 
		ArrayList<Long> responseTimeOfThread = new ArrayList<Long>(); 

		long previousWakeupTime = -1, currentWakeupTime = -1, lastSleepTime = -1 ;
		String threadID = null; 

		for(ArrayList<Event> threadEvents : threadSpecificEvents) // check each task 
		{
			threadID = threadIDs.get(threadSpecificEvents.indexOf(threadEvents));  
			ThreadEvents events = new ThreadEvents(threadID,threadEvents);

			for(Event event : events.GetWakeupEvents()) // check blocked events of a task 
			{
				currentWakeupTime = event.GetTimeStamp();  

				if(previousWakeupTime != (long)-1)
				{
					arrivalTimeOfThread.add(currentWakeupTime - previousWakeupTime); 

					lastSleepTime = events.GetLastSleepEventInGivenInterval(previousWakeupTime, currentWakeupTime);

					if(lastSleepTime !=-1)
					{
						responseTimeOfThread.add(lastSleepTime - previousWakeupTime);

						if(events.GetWakeupEvents().indexOf(event) == events.GetWakeupEvents().size()-1) // if there exists any sleep event after the last wakeup event 
						{
							lastSleepTime = events.FindLastSleepIfAnyAvailable(currentWakeupTime); 
							if(lastSleepTime != -1)
							{
								responseTimeOfThread.add(lastSleepTime - currentWakeupTime);
							}
						}
					}
					else 
						System.out.println("Warning: No Ready event and/or sleep event exists between two wakeup events \t "+ previousWakeupTime + "\t"+ currentWakeupTime);
				}
				previousWakeupTime = currentWakeupTime; 
			}

			// Writing all values in the file
			try 
			{
				WriteAllValuesInFile(arrivalTimeOfThread, traceExtractionPath, "InterArrivalTime_"+ threadID +".txt");
				WriteAllValuesInFile(responseTimeOfThread, traceExtractionPath, "ResponseTime_"+ threadID +".txt");
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}

			if(arrivalTimeOfThread.isEmpty())
			{
				minimumInterArrivalTimeOfAllThreads.add((long) 0.0);
				maximumInterArrivalTimeOfAllThreads.add((long) 0.0);
				averageInterArrivalTimeOfAllThreads.add(0.0);
				releaseJitterOfAllThreads.add((long) 0.0); 
				varianceInArrivalTimeOfAllThreads.add(0.0); 
			}
			else
			{
				minimumInterArrivalTimeOfAllThreads.add(Collections.min(arrivalTimeOfThread));
				maximumInterArrivalTimeOfAllThreads.add(Collections.max(arrivalTimeOfThread));
				averageInterArrivalTimeOfAllThreads.add( (double)Sum(arrivalTimeOfThread)/(double)arrivalTimeOfThread.size() );
				releaseJitterOfAllThreads.add(Collections.max(arrivalTimeOfThread)-Collections.min(arrivalTimeOfThread)); 
				varianceInArrivalTimeOfAllThreads.add(ComputeVariance(arrivalTimeOfThread)); 
			}

			if(responseTimeOfThread.isEmpty())
			{
				worstCaseResponseTimetOfAllThreads.add((long) 0.0); 
				bestCaseResponseTimetOfAllThreads.add((long) 0.0); 
				averageCaseResponseTimetOfAllThreads.add(0.0); 
				jitterInResponseTimetOfAllThreads.add((long)0.0);
				varianceInResponseTimeOfAllThreads.add(0.0); 
			}
			else 
			{
				worstCaseResponseTimetOfAllThreads.add(Collections.max(responseTimeOfThread)); 
				bestCaseResponseTimetOfAllThreads.add(Collections.min(responseTimeOfThread)); 
				averageCaseResponseTimetOfAllThreads.add(((double)Sum(responseTimeOfThread)/(double)responseTimeOfThread.size())); 
				jitterInResponseTimetOfAllThreads.add(Collections.max(responseTimeOfThread)-Collections.min(responseTimeOfThread)); 
				varianceInResponseTimeOfAllThreads.add(ComputeVariance(responseTimeOfThread)); 
			}
			previousWakeupTime = -1;
			currentWakeupTime = -1; 
			arrivalTimeOfThread.clear();
			responseTimeOfThread.clear();
		}
	}

	private void ComputeExecutionTimeRelatedParameters()
	{
		boolean flag = false; 
		long blockedTime = 0, executionTime = 0; 

		Event currentEvent = null, previousEvent = null; 

		ArrayList<Long> executionTimeOfThread = new ArrayList<Long>();
		ArrayList<Long> blockingTimeOfThread = new ArrayList<Long>();

		for(ArrayList<Event> threadEvents : threadSpecificEvents) // check each task 
		{
			for(Event event: threadEvents)
			{ 
				currentEvent = event; 

				if(currentEvent.GetEventID() == EventType.wakeupEventID || (currentEvent.GetEventID() == EventType.readyEventID && flag == false))
				{
					flag = true;
					blockedTime = 0; 
					executionTime = 0; 
				}
				else if(currentEvent.GetEventID() == EventType.runningEventID && flag == true)
				{
					if(previousEvent.GetEventID() == EventType.readyEventID || previousEvent.GetEventID() == EventType.blockedEventID || previousEvent.GetEventID() == EventType.wakeupEventID)
					{
						blockedTime+= (currentEvent.GetTimeStamp() - previousEvent.GetTimeStamp()); 
					}
					else if(previousEvent.GetEventID() == EventType.runningEventID)
					{
						executionTime += (currentEvent.GetTimeStamp() -previousEvent.GetTimeStamp()); 
					}
					else if(blockedTime!=0 )
					{
						System.out.print("Warning: Strange previous event: \t");
						previousEvent.PrintEvent();
						System.out.print("before current event: \t");
						currentEvent.PrintEvent();
					}
				}
				else if((currentEvent.GetEventID() == EventType.readyEventID || currentEvent.GetEventID() == EventType.blockedEventID) && flag == true)
				{
					if(previousEvent.GetEventID() == EventType.runningEventID)
					{
						executionTime+= (currentEvent.GetTimeStamp() -previousEvent.GetTimeStamp()); 
					}
					else if( (previousEvent.GetEventID() == EventType.readyEventID || previousEvent.GetEventID() == EventType.blockedEventID || previousEvent.GetEventID() == EventType.wakeupEventID))
					{
						blockedTime+= (currentEvent.GetTimeStamp() -previousEvent.GetTimeStamp()); 
					}
					else
					{
						System.out.print("Warning: Strange previous event:");
						previousEvent.PrintEvent();
						System.out.print("before current event:");
						currentEvent.PrintEvent();
					}
				}
				else if(currentEvent.GetEventID() == EventType.sleepEventID && flag == true)
				{
					if(previousEvent.GetEventID() == EventType.runningEventID)
					{
						executionTime += (currentEvent.GetTimeStamp() -previousEvent.GetTimeStamp()); 
					}
					else if((executionTime!=0) && (previousEvent.GetEventID() == EventType.readyEventID || previousEvent.GetEventID() == EventType.blockedEventID))
					{
						//blockedTime+= (currentEvent.GetTimeStamp() -previousEvent.GetTimeStamp()); // rescheduling followed by completion of job is not included in blocking
					}
					else
					{
						System.out.print("Warning: Strange previous event:");
						previousEvent.PrintEvent();
						System.out.print("before current event:");
						currentEvent.PrintEvent();
					} 
					executionTimeOfThread.add(executionTime); 
					blockingTimeOfThread.add(blockedTime); 

					blockedTime = 0; 
					executionTime = 0; 
					flag = false; 
				}
				previousEvent = currentEvent; 
			}

			// Writing all values in the file
			try 
			{
				WriteAllValuesInFile(blockingTimeOfThread,  traceExtractionPath, "BlockingTime_"+threadIDs.get(threadSpecificEvents.indexOf(threadEvents))+".txt");
				WriteAllValuesInFile(executionTimeOfThread, traceExtractionPath, "Executiontime_"+threadIDs.get(threadSpecificEvents.indexOf(threadEvents))+".txt");
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}

			if(executionTimeOfThread.isEmpty())
			{
				wcetOfAllThreads.add((long) 0.0);
				bcetOfAllThreads.add((long) 0.0);
				acetOfAllThreads.add(0.0);
				varianceInExecutionTimeOfAllThreads.add(0.0); 
			}
			else 
			{
				wcetOfAllThreads.add(Collections.max(executionTimeOfThread));
				bcetOfAllThreads.add(Collections.min(executionTimeOfThread));
				acetOfAllThreads.add(((double)Sum(executionTimeOfThread)/(double)executionTimeOfThread.size()));
				varianceInExecutionTimeOfAllThreads.add(ComputeVariance(executionTimeOfThread)); 
			}

			if(blockingTimeOfThread.isEmpty())
			{
				maximumBlockingOfAllThreads.add((long) 0.0); 
				minimumBlockingOfAllThreads.add((long) 0.0); 
				averageBlockingOfAllThreads.add(0.0);
				varianceInBlockingOfAllThreads.add(0.0);
			}
			else 
			{
				maximumBlockingOfAllThreads.add(Collections.max(blockingTimeOfThread)); 
				minimumBlockingOfAllThreads.add(Collections.min(blockingTimeOfThread)); 
				averageBlockingOfAllThreads.add(((double)Sum(blockingTimeOfThread)/(double)blockingTimeOfThread.size()));
				varianceInBlockingOfAllThreads.add(ComputeVariance(blockingTimeOfThread)); 
			}

			//	Initializing all variables 
			executionTimeOfThread.clear();
			blockingTimeOfThread.clear();
			blockedTime = -1; 
			executionTime = -1; 
			currentEvent = null; 
			previousEvent = null;
			flag = false; 
		}
	}

	private double ComputeVariance(ArrayList<Long> listOfValues) 
	{
		double variance = 0;
		double sumOfSquaredValues = 0, sumValues = 0;
		double size = (double) listOfValues.size(); 
		for(double x: listOfValues)
		{
			sumOfSquaredValues += Math.pow(x,2); 
			sumValues += x; 
		}
		variance = ((1/size)*sumOfSquaredValues) - (Math.pow(((1/size)*sumValues),2)); 
		return variance ;
	}

	private long Sum(ArrayList<Long> values) 
	{
		long total = 0; 
		for(long v : values)
		{
			total += v;
		}
		return total;
	}
	
	public void WriteAllValuesInFile(ArrayList<Long> parameter, IFolder path, String fileName) throws IOException
	{
//		File dir = new File(path);
//		dir.mkdirs();

		IFile outputFile = path.getProject().getFile(path.getProjectRelativePath()+ File.separator +fileName);
		FileWriter fstream = new FileWriter(outputFile.getLocation().toOSString());
		BufferedWriter out = new BufferedWriter(fstream);

		for(long element : parameter)
		{ 
			out.write((double)element/clockRate+"\n"); 
		}
		out.close();	
	}
	
	/*****************
	 *  Getters
	 ****************/

	public ArrayList<Long> GetMinimumInterArrivalTimeOfAllThreads()
	{
		return minimumInterArrivalTimeOfAllThreads; 
	}

	public ArrayList<Long> GetMaximumInterArrivalTimeOfAllThreads()
	{
		return maximumInterArrivalTimeOfAllThreads; 
	}

	public ArrayList<Long> GetReleaseJitterOfAllThreads()
	{
		return releaseJitterOfAllThreads; 
	}

	public ArrayList<Long> GetWCETOfAllThreads()
	{
		return wcetOfAllThreads; 
	}

	public ArrayList<Long> GetBCETOfAllThreads()
	{
		return bcetOfAllThreads; 
	}

	public ArrayList<Double> GetACETOfAllThreads()
	{
		return acetOfAllThreads; 
	}

	public ArrayList<Long> GetWorstCaseResponseTimeOfAllThreads()
	{
		return worstCaseResponseTimetOfAllThreads;  
	}

	public ArrayList<Long> GetBestCaseResponseTimeOfAllThreads()
	{
		return bestCaseResponseTimetOfAllThreads;  
	}

	public ArrayList<Double> GetAverageCaseResponseTimeOfAllThreads()
	{
		return averageCaseResponseTimetOfAllThreads;  
	}

	public ArrayList<Long> GetMaximumBlockingTimeOfAllThreads()
	{
		return maximumBlockingOfAllThreads;   
	}

	public ArrayList<Long> GetMinimumBlockingTimeOfAllThreads()
	{
		return minimumBlockingOfAllThreads;  
	}

	public ArrayList<Double> GetAverageBlockingTimeOfAllThreads()
	{
		return averageBlockingOfAllThreads;  
	}

	public ArrayList<Double> GetVarianceInBlockingTimeOfAllThreads()
	{
		return varianceInBlockingOfAllThreads;  
	}

	public ArrayList<Double> GetVarianceInExecutionTimeOfAllThreads()
	{
		return varianceInExecutionTimeOfAllThreads;  
	}

	public ArrayList<Double> GetVarianceInArrivalTimeOfAllThreads()
	{
		return varianceInArrivalTimeOfAllThreads;  
	}

	public ArrayList<Double> GetVarianceInResponseTimeOfAllThreads()
	{
		return varianceInResponseTimeOfAllThreads;  
	}

	public ArrayList<Long> GetJitterInResponseTimetOfAllThreads()
	{
		return jitterInResponseTimetOfAllThreads; 
	}

	public ArrayList<Double> GetAverageInterArrivalTimeOfAllThreads() {
		return averageInterArrivalTimeOfAllThreads;
	}
}