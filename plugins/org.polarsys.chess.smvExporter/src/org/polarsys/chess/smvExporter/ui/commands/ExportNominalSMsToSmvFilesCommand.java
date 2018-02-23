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
package org.polarsys.chess.smvExporter.ui.commands;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.papyrus.uml.tools.model.UmlUtils;
import org.polarsys.chess.service.gui.utils.DialogUtils;
import org.polarsys.chess.smvExporter.ui.services.SmvExportService;

import eu.fbk.eclipse.standardtools.utils.ui.commands.AbstractJobCommand;

public class ExportNominalSMsToSmvFilesCommand extends AbstractJobCommand {

	private DialogUtils exportDialogUtils = DialogUtils.getInstance();
	private SmvExportService smvExportService = SmvExportService.getInstance();

	public ExportNominalSMsToSmvFilesCommand() {
		super("Export Nominal State Machines To .smv Files");
	}

	private String outputDirectoryName;
	private boolean showPopups;
	private UmlModel umlModel;

	@Override
	public void execPreJobOperations(ExecutionEvent event, IProgressMonitor monitor) throws Exception {

		outputDirectoryName = exportDialogUtils.getDirectoryNameFromDialog();
		showPopups = true;
		umlModel = UmlUtils.getUmlModel();
	}

	@Override
	public void execJobCommand(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
		smvExportService.exportAllNominalStateMachinesOfTheModel(umlModel, outputDirectoryName, showPopups, monitor);

	}

}
