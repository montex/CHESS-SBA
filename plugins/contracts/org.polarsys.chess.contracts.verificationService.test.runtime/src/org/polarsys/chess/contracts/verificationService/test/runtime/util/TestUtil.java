/*******************************************************************************
 * Copyright (C) 2018 Fondazione Bruno Kessler.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *   Alberto Debiasi - initial API and implementation
 ******************************************************************************/
package org.polarsys.chess.contracts.verificationService.test.runtime.util;

import java.io.File;
import java.lang.reflect.AnnotatedElement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite.SuiteClasses;
import org.w3c.dom.Document;
import org.w3c.dom.Element;



public class TestUtil {
	
	private static TestUtil testUtil;

	public static TestUtil getInstance() {
		if (testUtil == null) {
			testUtil = new TestUtil();
		}
		return testUtil;
	}
	
	

	private List<String> extractQNamesFromSuite(SuiteClasses suite) {
		List<String> allTests = new ArrayList<String>();
		String str = suite.toString();
		str = str.substring(str.indexOf("[")+1, str.indexOf("]"));
		String[] tokens = str.split("class");
		for (String token : tokens) {
			token = token.trim();
			if (token.endsWith(",")){
				token = token.substring(0, token.lastIndexOf(","));
			}
			if(!token.isEmpty()){
				allTests.add(token);
			}
		}
		
		return allTests;
		
	}
	
	public File generateXMLReport(String resultsFilePath,Result result, AnnotatedElement classTest) throws Exception {
		
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
		testSuiteElem.setAttribute("name", classTest.toString());
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
		SuiteClasses suite =  ((AnnotatedElement) classTest).getAnnotation(SuiteClasses.class);
		List<String> allTests = extractQNamesFromSuite(suite);
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
