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
package org.polarsys.chess.smvExporter.commands;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.IProgressMonitor;
import org.polarsys.chess.service.utils.DialogUtils;
import org.polarsys.chess.service.utils.SelectionUtil;
import org.polarsys.chess.smvExporter.services.SmvExportService;

import eu.fbk.eclipse.standardtools.commands.AbstractJobCommand;
import org.eclipse.uml2.uml.Class;

public class ExportSelectedNominalSMsToSmvFilesCommand extends AbstractJobCommand {

	private SelectionUtil selectionUtil = SelectionUtil.getInstance();
	private DialogUtils dialogUtils = DialogUtils.getInstance();
	private SmvExportService smvExportService = SmvExportService.getInstance();

	public ExportSelectedNominalSMsToSmvFilesCommand() {
		super("Export Nominal State Machines To .smv Files");
	}

	private Class umlSelectedComponent;
	private String outputDirectoryName;
	private boolean showPopups;

	@Override
	public void execPreJobOperations(ExecutionEvent event, IProgressMonitor monitor) throws Exception {

		umlSelectedComponent = selectionUtil.getUmlComponentFromSelectedObject(event);
		outputDirectoryName = dialogUtils.getDirectoryNameFromDialog();
		showPopups = true;

	}

	@Override
	public void execJobCommand(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
		smvExportService.exportNominalStateMachines(umlSelectedComponent, outputDirectoryName, showPopups, monitor);
	}

}
