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
import org.polarsys.chess.service.gui.utils.DialogUtils;
import org.polarsys.chess.service.gui.utils.SelectionUtil;
import org.polarsys.chess.smvExporter.ui.services.SmvExportServiceUI;

import eu.fbk.eclipse.standardtools.utils.ui.commands.AbstractJobCommand;

import org.eclipse.uml2.uml.Class;

public class ExportSelectedNominalSMsToSmvFilesCommand extends AbstractJobCommand {

	private SelectionUtil selectionUtil = SelectionUtil.getInstance();
	private DialogUtils dialogUtils = DialogUtils.getInstance();
	private SmvExportServiceUI smvExportServiceUI = SmvExportServiceUI.getInstance();

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
		smvExportServiceUI.exportNominalStateMachines(umlSelectedComponent, outputDirectoryName, showPopups, monitor);
	}

}
