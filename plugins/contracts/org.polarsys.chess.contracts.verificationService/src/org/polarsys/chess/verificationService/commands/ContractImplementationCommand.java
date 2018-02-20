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
package org.polarsys.chess.verificationService.commands;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Class;

import eu.fbk.eclipse.standardtools.ExecOcraCommands.services.OCRAExecService;
import eu.fbk.eclipse.standardtools.commands.AbstractJobCommand;
import eu.fbk.eclipse.standardtools.dialogs.MessageTimeModelDialog;
import eu.fbk.eclipse.standardtools.nuXmvService.utils.NuXmvDirectoryUtil;
import eu.fbk.eclipse.standardtools.utils.OCRADirectoryUtil;

import org.polarsys.chess.service.internal.model.ChessSystemModel;
import org.polarsys.chess.service.utils.SelectionUtil;
import org.polarsys.chess.smvExporter.services.SmvExportService;

public class ContractImplementationCommand extends AbstractJobCommand {

	private OCRAExecService ocraExecService = OCRAExecService.getInstance(ChessSystemModel.getInstance());
	private SelectionUtil selectionUtil = SelectionUtil.getInstance();
	// private OCRADirectoryUtil ocraDirectoryUtil =
	// OCRADirectoryUtil.getInstance();
	private SmvExportService smvExportService = SmvExportService.getInstance();
	private OCRADirectoryUtil ocraDirectoryUtil = OCRADirectoryUtil.getInstance();
	private NuXmvDirectoryUtil nuXmvDirectoryUtil = NuXmvDirectoryUtil.getInstance();

	public ContractImplementationCommand() {
		super("Check Contract Implementation");
	}

	private Class umlSelectedComponent;
	private Resource umlSelectedResource;
	private boolean isDiscreteTime;
	private boolean showPopups;
	private String ossFilepath;
	private String smvFileDirectory;
	private String resultFilePath;

	@Override
	public void execPreJobOperations(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
		umlSelectedComponent = selectionUtil.getUmlComponentFromSelectedObject(event);
		umlSelectedResource = umlSelectedComponent.eResource();
		isDiscreteTime = MessageTimeModelDialog.openQuestion();
		showPopups = false;
		ossFilepath = ocraDirectoryUtil.getOSSFilePath();
		smvFileDirectory = nuXmvDirectoryUtil.getSmvFileDirectory();
		resultFilePath = ocraDirectoryUtil.getCommandCheckImplementationResultPath(umlSelectedComponent.getName());
	}

	@Override
	public void execJobCommand(ExecutionEvent event, IProgressMonitor monitor) throws Exception {

		String smvOutputPath = smvExportService.exportSingleSmv(umlSelectedComponent, showPopups, smvFileDirectory,
				monitor);
		ocraExecService.executeCheckContractImplementation(umlSelectedComponent, umlSelectedResource, smvOutputPath,
				isDiscreteTime, showPopups, ossFilepath, resultFilePath, monitor);

	}

}
