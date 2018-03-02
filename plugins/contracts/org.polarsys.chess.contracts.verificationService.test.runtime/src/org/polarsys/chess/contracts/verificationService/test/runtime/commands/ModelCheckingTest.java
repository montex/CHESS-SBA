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
package org.polarsys.chess.contracts.verificationService.test.runtime.commands;

import java.io.File;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.internal.junit.model.JUnitModel;
import org.eclipse.ui.handlers.HandlerUtil;
import org.junit.runner.Computer;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.polarsys.chess.contracts.verificationService.test.runtime.tests.AllTests;
import org.polarsys.chess.contracts.verificationService.test.runtime.util.TestUtil;

import eu.fbk.eclipse.standardtools.utils.ui.commands.AbstractJobCommand;

public class ModelCheckingTest extends AbstractJobCommand {

	private static final String resultsFilePath = "ModelCheckingTest.xml";
	
	public ModelCheckingTest() {
		super("ModelCheckingTest");
	}

	@Override
	public void execPreJobOperations(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
		//Run the tests
		Computer computer = new Computer();
		JUnitCore jUnitCore = new JUnitCore();
		Result result = jUnitCore.run(computer, AllTests.class);
		
		//Generate Ant-like XML report
		File file = null;
		try {
			file = TestUtil.getInstance().generateXMLReport(resultsFilePath,result,AllTests.class);
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
	}

	@Override
	public void execJobCommand(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
		
	}

}
