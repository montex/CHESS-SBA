/*******************************************************************************
 * Copyright (c) 2015 Intecs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Nicholas Pacini
 *******************************************************************************/
package org.polarsys.chess.test.runtime.handlers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jdt.internal.junit.model.JUnitModel;
import org.eclipse.ui.handlers.HandlerUtil;
import org.junit.runner.Computer;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite.SuiteClasses;
import org.polarsys.chess.test.runtime.tests.AllTests;
import org.polarsys.chess.test.runtime.util.TestUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

@SuppressWarnings("restriction")
public class TestsHandler extends AbstractHandler {

	private static final String resultsFilePath = "AllTests.xml";

	public TestsHandler() {
	}

	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		//Run the tests
		Computer computer = new Computer();
		JUnitCore jUnitCore = new JUnitCore();
		Result result = jUnitCore.run(computer, AllTests.class);
		
		//Generate Ant-like XML report
		File file = null;
		try {
			file = generateXMLReport(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(file != null){
			//Open the JUnit View and display results
			String viewId = "org.eclipse.jdt.junit.ResultView";
			try {
				HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().showView(viewId);
				JUnitModel.importTestRunSession(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}

	private File generateXMLReport(Result result) throws Exception {
			
		File resultsFile = new File(resultsFilePath);
		if(!resultsFile.exists()){
			resultsFile.createNewFile();
		}
		
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		
		Document doc = docBuilder.newDocument();
		Element testSuiteElem = doc.createElement("testsuite");
		testSuiteElem.setAttribute("errors", "0"); //can't find a way to get this info, assuming zero for the moment
		testSuiteElem.setAttribute("failures", Integer.toString(result.getFailureCount()));
		testSuiteElem.setAttribute("hostname", "CHESS Runtime Tests");
		testSuiteElem.setAttribute("name", "org.polarsys.chess.test.runtime.tests.AllTests");
		testSuiteElem.setAttribute("skipped", "0");
		testSuiteElem.setAttribute("tests", Integer.toString(result.getRunCount()));
		long l = result.getRunTime();
		if (l < Integer.MIN_VALUE || l > Integer.MAX_VALUE){
			throw new IllegalArgumentException
            (l + " cannot be cast to int without changing its value.");
		}else{
			float f  = l;
			f = f / 1000;
			testSuiteElem.setAttribute("time", Float.toString(f));
		}
		doc.appendChild(testSuiteElem);
		
		List<String> failedTests = new ArrayList<String>();
		for (Failure failure : result.getFailures()) {
			Element testCaseElem = doc.createElement("testcase");
			String th = failure.getTestHeader();
			String classname = th.substring(th.indexOf("(")+1, th.indexOf(")"));
			String name = th.substring(0, th.indexOf("("));
			testCaseElem.setAttribute("classname", classname);
			testCaseElem.setAttribute("name", name);
			failedTests.add(classname);
			Element failureElem = doc.createElement("failure");
			failureElem.setAttribute("message", failure.getException().getMessage());
			failureElem.setAttribute("type", failure.getException().getClass().getName());
			failureElem.appendChild(doc.createTextNode(failure.getTrace()));
			testCaseElem.appendChild(failureElem);
			testSuiteElem.appendChild(testCaseElem);
		}
		
//		System.out.println(failedTests);
		SuiteClasses suite = AllTests.class.getAnnotation(SuiteClasses.class);
		List<String> allTests = TestUtil.extractQNamesFromSuite(suite);
//		System.out.println(allTests);
		List<String> passedTests = new ArrayList<String>();
		
		for (String aTest : allTests) {
			if(!failedTests.contains(aTest)){
				passedTests.add(aTest);
			}
		}
//		System.out.println(passedTests);
		for (String pTest : passedTests) {
			Element testCaseElem = doc.createElement("testcase");
			testCaseElem.setAttribute("classname", pTest);
			testCaseElem.setAttribute("name", pTest.substring(pTest.lastIndexOf(".")+1, pTest.length()));
			testSuiteElem.appendChild(testCaseElem);
		}
		
		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		DOMSource source = new DOMSource(doc);
		StreamResult streamResult = new StreamResult(resultsFile);
		transformer.transform(source, streamResult);
		
		return resultsFile;
	}
}
