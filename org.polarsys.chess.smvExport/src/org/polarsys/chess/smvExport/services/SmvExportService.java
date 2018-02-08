/*******************************************************************************
 * Copyright (C) 2017 Fondazione Bruno Kessler.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *   Alberto Debiasi - initial API and implementation
 ******************************************************************************/
package org.polarsys.chess.smvExport.services;

import java.io.File;
import java.util.HashMap;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.uml2.uml.Class;
import org.polarsys.chess.service.internal.model.ChessSystemModel;
import org.polarsys.chess.smvExport.model.UMLStateMachineModel;
import eu.fbk.eclipse.standardtools.StateMachineTranslatorToSmv.services.SMVTranslatorService;
import eu.fbk.eclipse.standardtools.utils.DialogUtil;

public class SmvExportService {

	private static SmvExportService instance;

	private SMVTranslatorService smvTranslatorService = SMVTranslatorService.getInstance(ChessSystemModel.getInstance(),
			UMLStateMachineModel.getInstance());
	private DialogUtil dialogUtil = DialogUtil.getInstance();

	public static SmvExportService getInstance() {
		if (instance == null) {
			instance = new SmvExportService();
		}
		return instance;
	}

	public void exportAllNominalStateMachinesOfTheModel(UmlModel umlModel, String selectedDirectory, boolean showPopups,
			IProgressMonitor monitor) throws Exception {

		System.out.println("umlModel: " + umlModel);
		smvTranslatorService.exportAllNominalStateMachinesOfTheModel(umlModel, selectedDirectory, null, monitor);

		if (showPopups) {
			dialogUtil.showMessage_ExportNominalStateMachinesDone(selectedDirectory);
		}

	}

	public void exportNominalStateMachines(Class umlSelectedComponent, String selectedDirectory, boolean showPopups,
			IProgressMonitor monitor) throws Exception {

		smvTranslatorService.exportNominalStateMachines(umlSelectedComponent, selectedDirectory, null, monitor);

		if (showPopups) {
			dialogUtil.showMessage_ExportNominalStateMachinesDone(selectedDirectory);
		}

	}

	public File exportSingleSmv(Class umlSelectedComponent, boolean showPopups, String selectedDirectory,
			IProgressMonitor monitor) throws Exception {

		File smvFile = smvTranslatorService.exportSingleSmv(umlSelectedComponent, showPopups, selectedDirectory,
				monitor);

		if (showPopups) {
			dialogUtil.showMessage_ExportBehaviourDone(smvFile.getAbsolutePath());
		}

		return smvFile;

	}

	public HashMap<String, String> exportSmv(Class umlSelectedComponent, boolean showPopups, String selectedDirectory,
			IProgressMonitor monitor) throws Exception {

		HashMap<String, String> mapSmvFile_ComponentName = smvTranslatorService.exportSmv(umlSelectedComponent,
				selectedDirectory, monitor);

		if (showPopups) {
			dialogUtil.showMessage_ExportBehaviourDone(selectedDirectory);
		}

		return mapSmvFile_ComponentName;

	}

}
