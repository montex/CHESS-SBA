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

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

/**
 * This command permits the execution of FTA using the xSAP tool.
 * @author cristofo
 *
 */
public class FTAXSapHandler extends AbstractXSapHandler {
	
	public Object execute(ExecutionEvent event) throws ExecutionException {

		// Compute all the required files for the analysis
		if (!prepareExpandedFiles(event)) {
			return null;
		}
		
		// Compute and display the FTA for each condition requested
		int index = 0;
		for (String condition : ftaCond.split(", ")) {
			final String ftFileName = fileNamesUtil.computeFtFileName(editor, modelName, ++index);
			if (!xSapExecService.computeFt(extendedSmvFileName, fmsFileName, condition, ftFileName, false)) {
				return null;
			}		
		}
		return null;
	}
}

