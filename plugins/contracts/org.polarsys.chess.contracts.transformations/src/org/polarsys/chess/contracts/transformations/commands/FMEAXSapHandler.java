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
import org.eclipse.uml2.uml.Class;
import org.polarsys.chess.contracts.transformations.utils.AnalysisResultUtil;

import eu.fbk.tools.adapter.xsap.ComputeFaultTree;
import eu.fbk.tools.adapter.xsap.ComputeFmeaTable;

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
		for (String condition : ftaFmeaCond.split(", ")) {
			arguments.add("\"" + condition + "\"");
		}
		return arguments.toString();
	}
	
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final String storeResultParam = "store_result";
		
		// Get the root component of the package
		//FIXME: potrebbe diventare inutile se metto l'analysis context...
		final Class systemComponent = analysisResultUtil.getSystemComponentFromEvent(event);
		

		// Compute all the required files for the analysis
		if (!prepareExpandedFiles(event)) {
			return null;
		}
			
		final boolean storeResult = (event.getParameter(storeResultParam) != null && 
				event.getParameter(storeResultParam).equals("true")) ? true : false;

		final String fmeaFileName = fileNamesUtil.computeFmeaFileName(editor, modelName, storeResult);
		
		// Compute FMEA and show results in a dedicated view
		if (xSapExecService.computeFmea(extendedSmvFileName, fmsFileName, processConditions(ftaFmeaCond), 
				fmeaFileName, true)) {
			
			// If requested, store the result
			if (storeResult) {
				analysisResultUtil.storeResult(AnalysisResultUtil.FMEA_ANALYSIS, ftaFmeaCond, 
						fmeaFileName, systemComponent, analysisContext);
			}

			// Visualize the result
			analysisResultUtil.showResult(ComputeFmeaTable.FUNCTION_NAME, fmeaFileName);
		}
		return null;
	}
}

