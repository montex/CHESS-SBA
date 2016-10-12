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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Shell;
import org.polarsys.chess.core.util.CHESSProjectSupport;
import org.polarsys.chess.monitoring.monitoringxml.AnalysisContext;
import org.polarsys.chess.monitoring.monitoringxml.BlockingTime;
import org.polarsys.chess.monitoring.monitoringxml.ExecutionTime;
import org.polarsys.chess.monitoring.monitoringxml.MeasuredValue;
import org.polarsys.chess.monitoring.monitoringxml.Monitoring;
import org.polarsys.chess.monitoring.monitoringxml.MonitoringxmlFactory;
import org.polarsys.chess.monitoring.monitoringxml.Period;
import org.polarsys.chess.monitoring.monitoringxml.ResponseTime;
import org.polarsys.chess.monitoring.monitoringxml.Thread;
import org.polarsys.chess.monitoring.traceanalyser.Parameters;
import org.polarsys.chess.monitoring.traceanalyser.TraceReader;

public class TraceAnalyser 
{
	private IFile inputFile;
	private IFile inTraceFile;
	private IFolder traceExtractionPath;
	private String delimiter;
	private Shell shell;
	private String unitName = "ms";
	private double unitFactor = 0.001;
	
	public TraceAnalyser(Shell shell, IFile inXMLFile, String outXMLFileName, IFile traceFile)  
	{
		this.delimiter = " "; 
		this.shell = shell;
		this.inputFile = inXMLFile;
		this.inTraceFile = traceFile;
		this.traceExtractionPath = traceFile.getProject().getFolder(traceFile.getParent().getName()+ File.separator +"traces");
		try {
			CHESSProjectSupport.createFolder(traceExtractionPath);
		} catch (CoreException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void doTraceAnalysis()
	{
		try{
			ProgressMonitorDialog progDialog = new ProgressMonitorDialog(shell);
			progDialog.run(true, true, new IRunnableWithProgress(){ 
		    public void run(IProgressMonitor monitor) {
		 
		        monitor.beginTask("Analyzing measured values ...", 100); 
		        // execute the task ... 
		        if (monitor.isCanceled())
					throw new OperationCanceledException();

		        // Read trace file and get thread specific data
		        TraceReader trace;
		        trace = new TraceReader(inTraceFile, inputFile, delimiter);
		        monitor.worked(45);

		        // Extract the required parameters
		        Parameters parameters = new Parameters(trace, traceExtractionPath); 
		        parameters.ComputeParameters();
		        monitor.worked(45);

		        String[] actxName = trace.GetAnalysisContext().split("::");
		        String outputName = actxName[actxName.length-1]+"_monitoring.xml";
		        // Write output data in a file
		        //WriteoutputFile(outputFileName, trace.GetAnalysisContext(), trace.GetThreadIDs(), parameters, unitFactor, unitName,trace.GetClockRate());
		        try {
		        	CreateMonitoringXMLOutput(inputFile, outputName, trace.GetAnalysisContext(), trace.GetThreadIDs(), parameters, unitFactor, unitName,trace.GetClockRate());
		        } catch (Exception e) {
		        	// TODO Auto-generated catch block
		        	e.printStackTrace();
		        }
		        monitor.worked(10);
		        monitor.done();
		   }
		   });
		} catch(Exception ex){//throw new OperationCanceledException("Operation aborted by the user.");};}
			throw new OperationCanceledException(ex.getMessage());
		}
	}

/*	private static void addXMLelement(Document doc, Element parent, String name, String unit, String value)
	{
		Element elem = doc.createElement(name);
		Attr unitAttr = doc.createAttribute("unit");
		unitAttr.setValue(unit);
		elem.setAttributeNode(unitAttr);
		Attr valueAttr = doc.createAttribute("value");
		valueAttr.setValue(value);
		elem.setAttributeNode(valueAttr);
		parent.appendChild(elem);
	}
	
	private static void WriteoutputFile(final String fileName, final String analysisContext, final ArrayList<String> threadNames, final Parameters parameters, final double unitFactor, final String unitName, final double clockRate) 
	{
		double totalUtilization = 0.0; 
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// Root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("monitoringxml:Monitoring");
			doc.appendChild(rootElement);

			Element cr = doc.createElement("ClockRate");
			cr.appendChild(doc.createTextNode(String.valueOf(clockRate)));
			rootElement.appendChild(cr);
			Attr unitcr = doc.createAttribute("unit");
			unitcr.setValue("MHz");
			cr.setAttributeNode(unitcr);

			// Extracted thread parameters
			for(int i=0; i < threadNames.size(); i++)
			{
				Element thread = doc.createElement("ThreadNames");
				Attr name = doc.createAttribute("name");
				name.setValue(threadNames.get(i));
				thread.setAttributeNode(name);
				rootElement.appendChild(thread);

				long exec = parameters.GetWCETOfAllThreads().get(i);

				double util = 0.0;
				if(exec > 0)
					util = (double)exec / (double)parameters.GetMinimumInterArrivalTimeOfAllThreads().get(i); 
				Element utilization = doc.createElement("utilization");
				utilization.appendChild(doc.createTextNode(String.valueOf(util)));
				thread.appendChild(utilization);

				totalUtilization +=  util; 

				Element executionTime = doc.createElement("executiontime");
				thread.appendChild(executionTime);

				addXMLelement(doc, executionTime, "maximum", unitName, 
						String.valueOf(((double)parameters.GetWCETOfAllThreads().get(i)*unitFactor)/clockRate));
				addXMLelement(doc, executionTime, "average", unitName, 
						String.valueOf(((double)parameters.GetACETOfAllThreads().get(i)*unitFactor)/clockRate));
				addXMLelement(doc, executionTime, "minimum", unitName, 
						String.valueOf(((double)parameters.GetBCETOfAllThreads().get(i)*unitFactor)/clockRate));
				addXMLelement(doc, executionTime, "stdDeviation", unitName, 
						String.valueOf((Math.sqrt((double)parameters.GetVarianceInExecutionTimeOfAllThreads().get(i))*unitFactor)/clockRate));

				Element period = doc.createElement("period");
				thread.appendChild(period);
				
				addXMLelement(doc, period, "maximum", unitName, 
						String.valueOf(((double)parameters.GetMaximumInterArrivalTimeOfAllThreads().get(i)*unitFactor)/clockRate));
				addXMLelement(doc, period, "average", unitName, 
						String.valueOf(((double)parameters.GetAverageInterArrivalTimeOfAllThreads().get(i)*unitFactor)/clockRate));
				addXMLelement(doc, period, "minimum", unitName, 
						String.valueOf(((double)parameters.GetMinimumInterArrivalTimeOfAllThreads().get(i)*unitFactor)/clockRate));
				addXMLelement(doc, period, "jitter", unitName, 
						String.valueOf(((double)parameters.GetReleaseJitterOfAllThreads().get(i)*unitFactor)/clockRate));
				addXMLelement(doc, period, "stdDeviation", unitName, 
						String.valueOf((Math.sqrt((double)parameters.GetVarianceInArrivalTimeOfAllThreads().get(i))*unitFactor)/clockRate));

				Element blockingTime = doc.createElement("blockingtime");
				thread.appendChild(blockingTime);
				
				addXMLelement(doc, blockingTime, "maximum", unitName, 
						String.valueOf(((double)parameters.GetMaximumBlockingTimeOfAllThreads().get(i)*unitFactor)/clockRate));
				addXMLelement(doc, blockingTime, "average", unitName, 
						String.valueOf(((double)parameters.GetAverageBlockingTimeOfAllThreads().get(i)*unitFactor)/clockRate));
				addXMLelement(doc, blockingTime, "minimum", unitName, 
						String.valueOf(((double)parameters.GetMinimumBlockingTimeOfAllThreads().get(i)*unitFactor)/clockRate));
				addXMLelement(doc, blockingTime, "stdDeviation", unitName, 
						String.valueOf((Math.sqrt((double)parameters.GetVarianceInBlockingTimeOfAllThreads().get(i))*unitFactor)/clockRate));

				Element responseTime = doc.createElement("responsetime");
				thread.appendChild(responseTime);

				addXMLelement(doc, responseTime, "maximum", unitName, 
						String.valueOf(((double)parameters.GetWorstCaseResponseTimeOfAllThreads().get(i)*unitFactor)/clockRate));
				addXMLelement(doc, responseTime, "average", unitName, 
						String.valueOf(((double)parameters.GetAverageCaseResponseTimeOfAllThreads().get(i)*unitFactor)/clockRate));
				addXMLelement(doc, responseTime, "minimum", unitName, 
						String.valueOf(((double)parameters.GetBestCaseResponseTimeOfAllThreads().get(i)*unitFactor)/clockRate));
				addXMLelement(doc, responseTime, "stdDeviation", unitName, 
						String.valueOf((Math.sqrt((double)parameters.GetVarianceInResponseTimeOfAllThreads().get(i))*unitFactor)/clockRate));
				addXMLelement(doc, responseTime, "jitter", unitName, 
						String.valueOf(((double)parameters.GetJitterInResponseTimetOfAllThreads().get(i)*unitFactor)/clockRate));
			}

			Element tu = doc.createElement("totalutilization");
			tu.appendChild(doc.createTextNode(String.valueOf(totalUtilization)));
			rootElement.appendChild(tu);
			
			Element context = doc.createElement("analysisContext");
			Attr contextname = doc.createAttribute("name");
			contextname.setValue(analysisContext);
			context.setAttributeNode(contextname);
			rootElement.appendChild(context);

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "5");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(fileName));

			transformer.transform(source, result);
		} 
		catch (ParserConfigurationException pce) 
		{
			pce.printStackTrace();
		} 
		catch (TransformerException te) 
		{
			te.printStackTrace();
		}
	}*/

	public static void CreateMonitoringXMLOutput(IFile inputFile, String outXMLFileName, String saAnalysisName, final ArrayList<String> threadNames, final Parameters parameters, final double unitFactor, final String unitName, final double clockRate) throws Exception {
		
		// Retrieve the default factory singleton
		MonitoringxmlFactory factory = MonitoringxmlFactory.eINSTANCE;
		Monitoring mon = factory.createMonitoring();
		AnalysisContext analysisContext = factory.createAnalysisContext();
		analysisContext.setName(saAnalysisName);
		mon.setAnalysisContext(analysisContext);
		
		// Extracted thread parameters
		for(int i=0; i < threadNames.size(); i++)
		{
			Thread thread = factory.createThread();
			thread.setName(threadNames.get(i));

			ExecutionTime executionTime = factory.createExecutionTime();
			MeasuredValue maximumET = factory.createMeasuredValue();
			maximumET.setUnit(unitName);
			maximumET.setValue((float)((parameters.GetWCETOfAllThreads().get(i)*unitFactor)/clockRate));
			executionTime.setMaximum(maximumET);	
			MeasuredValue averageET = factory.createMeasuredValue();
			averageET.setUnit(unitName);
			averageET.setValue((float)((parameters.GetACETOfAllThreads().get(i)*unitFactor)/clockRate));
			executionTime.setAverage(averageET);	
			MeasuredValue minimumET = factory.createMeasuredValue();
			minimumET.setUnit(unitName);
			minimumET.setValue((float)((parameters.GetBCETOfAllThreads().get(i)*unitFactor)/clockRate));
			executionTime.setMinimum(minimumET);
			thread.setExecutiontime(executionTime);

			Period period = factory.createPeriod();
			MeasuredValue maximumP = factory.createMeasuredValue();
			maximumP.setUnit(unitName);
			maximumP.setValue((float)((parameters.GetMaximumInterArrivalTimeOfAllThreads().get(i)*unitFactor)/clockRate));
			period.setMaximum(maximumP);	
			MeasuredValue averageP = factory.createMeasuredValue();
			averageP.setUnit(unitName);
			averageP.setValue((float)((parameters.GetAverageInterArrivalTimeOfAllThreads().get(i)*unitFactor)/clockRate));
			period.setAverage(averageP);	
			MeasuredValue minimumP = factory.createMeasuredValue();
			minimumP.setUnit(unitName);
			minimumP.setValue((float)((parameters.GetMinimumInterArrivalTimeOfAllThreads().get(i)*unitFactor)/clockRate));
			period.setMinimum(minimumP);
			MeasuredValue jitterP = factory.createMeasuredValue();
			jitterP.setUnit(unitName);
			jitterP.setValue((float)((parameters.GetMinimumInterArrivalTimeOfAllThreads().get(i)*unitFactor)/clockRate));
			period.setJitter(jitterP);
			thread.setPeriod(period);
			
			BlockingTime blockingTime = factory.createBlockingTime();
			MeasuredValue maximumBT = factory.createMeasuredValue();
			maximumBT.setUnit(unitName);
			maximumBT.setValue((float)((parameters.GetMaximumBlockingTimeOfAllThreads().get(i)*unitFactor)/clockRate));
			blockingTime.setMaximum(maximumBT);	
			MeasuredValue averageBT = factory.createMeasuredValue();
			averageBT.setUnit(unitName);
			averageBT.setValue((float)((parameters.GetAverageBlockingTimeOfAllThreads().get(i)*unitFactor)/clockRate));
			blockingTime.setAverage(averageBT);	
			MeasuredValue minimumBT = factory.createMeasuredValue();
			minimumBT.setUnit(unitName);
			minimumBT.setValue((float)((parameters.GetMinimumBlockingTimeOfAllThreads().get(i)*unitFactor)/clockRate));
			blockingTime.setMinimum(minimumBT);
			thread.setBlockingtime(blockingTime);

			ResponseTime responseTime = factory.createResponseTime();
			MeasuredValue maximumRT = factory.createMeasuredValue();
			maximumRT.setUnit(unitName);
			maximumRT.setValue((float)((parameters.GetWorstCaseResponseTimeOfAllThreads().get(i)*unitFactor)/clockRate));
			responseTime.setMaximum(maximumRT);	
			MeasuredValue averageRT = factory.createMeasuredValue();
			averageRT.setUnit(unitName);
			averageRT.setValue((float)((parameters.GetAverageCaseResponseTimeOfAllThreads().get(i)*unitFactor)/clockRate));
			responseTime.setAverage(averageRT);	
			MeasuredValue minimumRT = factory.createMeasuredValue();
			minimumRT.setUnit(unitName);
			minimumRT.setValue((float)((parameters.GetBestCaseResponseTimeOfAllThreads().get(i)*unitFactor)/clockRate));
			responseTime.setMinimum(minimumRT);
			MeasuredValue jitterRT = factory.createMeasuredValue();
			jitterRT.setUnit(unitName);
			jitterRT.setValue((float)((parameters.GetJitterInResponseTimetOfAllThreads().get(i)*unitFactor)/clockRate));
			responseTime.setJitter(jitterRT);
			thread.setResponsetime(responseTime);

			mon.getThreadNames().add(thread);
		}
		    
		ResourceSet resourceSet = new ResourceSetImpl();
		/*
		* Register XML Factory implementation using DEFAULT_EXTENSION
		*/
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
		    "*", new  XMIResourceFactoryImpl());

		Resource resource = resourceSet.createResource(URI.createURI(inputFile.getParent().getLocationURI()+ File.separator +outXMLFileName));

		/*
		* Add bookStoreObject to contents list of the resource 
		*/
		resource.getContents().add(mon);

		try{
		    /*
		    * Save the resource
		    */
		    resource.save(null);
		    inputFile.getProject().refreshLocal(IResource.DEPTH_INFINITE, null);
		   }catch (IOException e) {
		      e.printStackTrace();
		   }
	}
}
