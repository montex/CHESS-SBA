/*******************************************************************************
 * Copyright (C) 2018 Fondazione Bruno Kessler.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Luca Cristoforetti - initial API and implementation
 ******************************************************************************/
package org.polarsys.chess.contracts.transformations.commands;

import java.util.StringJoiner;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

/**
 * This command permits the execution of FMEA using the xSAP tool.
 * @author cristofo
 *
 */
public class FMEAXSapHandler extends AbstractXSapHandler {
	
	/**
	 * Returns the string of expressions, formatted as requested by xSAP.
	 * @param conditions the string of conditions as reported to the user
	 * @return
	 */
	private String processConditions(String conditions) {
		StringJoiner arguments = new StringJoiner(" ");
		for (String condition : ftaCond.split(", ")) {
			arguments.add("\"" + condition + "\"");
		}
		return arguments.toString();
	}
	
	public Object execute(ExecutionEvent event) throws ExecutionException {

		// Compute all the required files for the analysis
		if (!prepareExpandedFiles(event)) {
			return null;
		}
			
		// Compute FMEA and show results in a dedicated view
		xSapExecService.computeFmea(extendedSmvFileName, fmsFileName, processConditions(ftaCond), 
				fmeaFileName, true);		
		return null;
	}
}

