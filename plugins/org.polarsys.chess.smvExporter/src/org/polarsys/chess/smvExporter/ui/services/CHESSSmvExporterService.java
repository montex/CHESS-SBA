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
package org.polarsys.chess.smvExporter.ui.services;

import org.eclipse.core.commands.ExecutionException;
import eu.fbk.eclipse.standardtools.utils.ui.utils.CommandBuilder;

public class CHESSSmvExporterService {

	private static CHESSSmvExporterService smvExporterService;

	public static CHESSSmvExporterService getInstance() {
		if (smvExporterService == null) {
			smvExporterService = new CHESSSmvExporterService();
		}
		return smvExporterService;
	}

	/**
	 * Creates a monolithic SMV file for the active package.
	 * @param smvFileName the name of the generated file
	 * @return false if errors occurred, true otherwise
	 */
	public boolean createMonolithicSmvFile(String smvFileName) {		
		final String monolithicSmvCommand = "org.polarsys.chess.smvExport.commands.ExportModelToSMVCommand";
		final String fileNameParam = "file_name";
		final CommandBuilder monolithicSmv;
		
		try {
			monolithicSmv = CommandBuilder.build(monolithicSmvCommand);
			monolithicSmv.setParameter(fileNameParam, smvFileName);
			monolithicSmv.execute();
		} catch (ExecutionException e) {
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;		
	}
}
