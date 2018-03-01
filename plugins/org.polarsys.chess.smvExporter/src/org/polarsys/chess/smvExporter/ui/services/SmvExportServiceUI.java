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
package org.polarsys.chess.smvExporter.ui.services;

import java.io.File;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Property;
import org.polarsys.chess.service.core.model.ChessSystemModel;
import org.polarsys.chess.smvExporter.core.model.UMLStateMachineModel;

import eu.fbk.eclipse.standardtools.StateMachineTranslatorToSmv.core.services.SMVTranslatorServiceAPI;
import eu.fbk.eclipse.standardtools.utils.ui.utils.DialogUtil;

public class SmvExportServiceUI {

	private static final Logger logger = Logger.getLogger(SmvExportServiceUI.class);

	private static SmvExportServiceUI instance;
	private ChessSystemModel chessSystemModel = ChessSystemModel.getInstance();

	private SMVTranslatorServiceAPI smvTranslatorServiceAPI = SMVTranslatorServiceAPI.getInstance(chessSystemModel,
			UMLStateMachineModel.getInstance());
	private DialogUtil dialogUtil = DialogUtil.getInstance();

	public static SmvExportServiceUI getInstance() {
		if (instance == null) {
			instance = new SmvExportServiceUI();
		}
		return instance;
	}

	public void exportAllNominalStateMachinesOfTheModel(UmlModel umlModel, String selectedDirectory, boolean showPopups,
			IProgressMonitor monitor) throws Exception {

		logger.debug("umlModel: " + umlModel);
		smvTranslatorServiceAPI.exportAllNominalStateMachinesOfTheModel(umlModel, selectedDirectory, null, monitor);

		if (showPopups) {
			dialogUtil.showMessage_ExportNominalStateMachinesDone(selectedDirectory);
		}

	}

	public void exportNominalStateMachines(Class umlSelectedComponent, String selectedDirectory, boolean showPopups,
			IProgressMonitor monitor) throws Exception {

		smvTranslatorServiceAPI.exportNominalStateMachines(umlSelectedComponent, selectedDirectory, null, monitor);

		if (showPopups) {
			dialogUtil.showMessage_ExportNominalStateMachinesDone(selectedDirectory);
		}

	}

	public String exportSingleSmv(Class umlSelectedComponent, boolean showPopups, String selectedDirectory,
			IProgressMonitor monitor) throws Exception {

		File smvFile = smvTranslatorServiceAPI.exportStateMachineOfComponentToSMVFile(umlSelectedComponent, showPopups, selectedDirectory,
				monitor);

		//inserire check errors
		
		if (showPopups) {
			dialogUtil.showMessage_ExportBehaviourDone(smvFile.getAbsolutePath());
		}

		return smvFile.getPath();

	}

	public HashMap<String, String> exportSmv(Class umlSelectedComponent, boolean showPopups, String selectedDirectory,
			IProgressMonitor monitor) throws Exception {

		HashMap<String, String> mapSmvFile_ComponentName = smvTranslatorServiceAPI.exportAllStateMachinesToSMVFiles(umlSelectedComponent,
				selectedDirectory, monitor);

		//inserire check errors
		
		logger.debug("exportSmv done");
		if (showPopups) {
			dialogUtil.showMessage_ExportBehaviourDone(selectedDirectory);
		}

		return mapSmvFile_ComponentName;

	}

	public boolean isLeafComponent(Class umlSelectedComponent) {
		EList<Property> subComponents = chessSystemModel.getSubComponentsInstances(umlSelectedComponent);
		return ((subComponents == null) || (subComponents.size() == 0));
	}

}
