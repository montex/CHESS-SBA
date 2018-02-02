/*******************************************************************************
 * Copyright (C) 2017 Fondazione Bruno Kessler.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Alberto Debiasi - initial API and implementation
 ******************************************************************************/
package org.polarsys.chess.verificationService.services;

/*import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.uml2.uml.Class;
import org.polarsys.chess.contracts.transformations.main.GenerateErrorModel;

import eu.fbk.eclipse.standardtools.exceptions.NoComponentException;
//import eu.fbk.eclipse.standardtools.nuXmvService.utils.NuXmvDirectoryUtil;
import eu.fbk.eclipse.standardtools.utils.DialogUtil;*/

/**
 * 
 *
 */
public class SmvExportService {

	private static SmvExportService smvExportService;
	
	public static SmvExportService getInstance() {
		if (smvExportService == null) {
			smvExportService = new SmvExportService();
		}
		return smvExportService;
	}

	//private final Logger logger = Logger.getLogger(SmvExportService.class);
	
	//private DialogUtil dialogUtil = DialogUtil.getInstance();
	//private static NuXmvDirectoryUtil nuXmvDirectoryUtil = NuXmvDirectoryUtil.getInstance();

	

	/*private File exportSmv(Class umlSelectedComponent,boolean showPopups, String smvFilePath, IProgressMonitor monitor)
			throws Exception {
		if (umlSelectedComponent == null) {
			throw new NoComponentException();
		}

		File smvOutput = new File(smvFilePath);
		List<String> args = returnParams(umlSelectedComponent);

		exportSmv(umlSelectedComponent, smvOutput, args, showPopups,monitor);

		return new File(smvOutput + "/" + getSmvFileName(umlSelectedComponent)+".smv");
	}*/
	

	/*private List<String> returnParams(Class umlSelectedComponent) {
		String systemQN = umlSelectedComponent.getQualifiedName();
		final List<String> args = new ArrayList<String>();
		args.add(systemQN);
		String systemName = systemQN.substring(systemQN.lastIndexOf("::") + 2);
		args.add(systemName);
		args.add(umlSelectedComponent.getName());

		return args;
	}

	private String getSmvFileName(Class umlSelectedComponent) {
	//	String systemQN = umlSelectedComponent.getQualifiedName();
	//	String systemName = systemQN.substring(systemQN.lastIndexOf("::") + 2);
	//	return umlSelectedComponent.getModel().getName() + "_" + systemName + ".smv";
		return umlSelectedComponent.getName();
	}

	private void exportSmv(Class umlSelectedComponent, File targetDir, List<String> args, boolean showPopups, IProgressMonitor monitor)
			throws IOException {
		monitor.beginTask("operation in progress ...", 3);
		monitor.subTask("transforming...");

		for (String s : args) {
			logger.debug("-> " + s);
		}

		GenerateErrorModel gen = new GenerateErrorModel(umlSelectedComponent, targetDir, args);
		gen.doGenerate(null);
		monitor.worked(1);

	
if(showPopups){
		dialogUtil.showMessage_ExportBehaviourDone(targetDir.getAbsolutePath());
}
		monitor.done();
	}*/
}
