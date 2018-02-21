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

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Class;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;
import org.polarsys.chess.service.internal.model.ChessSystemModel;
import org.polarsys.chess.service.utils.SelectionUtil;
import org.polarsys.chess.smvExporter.services.SmvExportService;

import eu.fbk.eclipse.standardtools.ExecOcraCommands.services.OCRAExecService;
import eu.fbk.eclipse.standardtools.commands.AbstractJobCommand;
import eu.fbk.eclipse.standardtools.dialogs.MessageTimeModelDialog;
import eu.fbk.eclipse.standardtools.nuXmvService.services.NuXmvExecService;
import eu.fbk.eclipse.standardtools.nuXmvService.utils.NuXmvDirectoryUtil;
import eu.fbk.eclipse.standardtools.utils.OCRADirectoryUtil;

/**
 * 
 *
 */
public class ModelCheckingCommand extends AbstractJobCommand {

	private static final Logger logger = Logger.getLogger(ModelCheckingCommand.class);

	private SelectionUtil selectionUtil = SelectionUtil.getInstance();
	private SmvExportService smvExportService = SmvExportService.getInstance();
	private NuXmvExecService nuXmvExecService = NuXmvExecService.getInstance();
	private static NuXmvDirectoryUtil nuXmvDirectoryUtil = NuXmvDirectoryUtil.getInstance();
	private OCRADirectoryUtil ocraDirectoryUtil = OCRADirectoryUtil.getInstance();
	private OCRAExecService ocraExecService = OCRAExecService.getInstance(ChessSystemModel.getInstance());
	private EntityUtil entityUtil = EntityUtil.getInstance();

	public ModelCheckingCommand() {
		super("Model Checking");
	}

	private boolean isProgrExec;
	private Class umlSelectedComponent;
	private boolean showPopups;
	private String smvFileDirectory;
	private boolean isDiscreteTime;
	private String monolithicSMVFilePath;
	private String resultFilePath;
	private String smvMapFilepath;
	private Resource umlSelectedResource;

	@Override
	public void execPreJobOperations(ExecutionEvent event, IProgressMonitor monitor) throws Exception {

		isProgrExec = isProgrammaticallyExecuted(event);
		if (!isProgrExec) {
			logger.debug("!isProgrammaticallyExecution(event)");
			umlSelectedComponent = selectionUtil.getUmlComponentFromSelectedObject(event);
			isDiscreteTime = MessageTimeModelDialog.openQuestion();
			smvFileDirectory = nuXmvDirectoryUtil.getSmvFileDirectory();
			monolithicSMVFilePath = nuXmvDirectoryUtil.getMonolithicSMVFilePath(umlSelectedComponent.getName());
			resultFilePath = nuXmvDirectoryUtil.getModelCheckingResultPath(umlSelectedComponent.getName());
			smvMapFilepath = ocraDirectoryUtil.getSmvMapFilePath();
		} else {
			String elementURI = event.getParameter("elementURI");
			String projectName = event.getParameter("projectName");
			String modelName = event.getParameter("modelName");
			String projectPath = event.getParameter("projectPath");
			resultFilePath = event.getParameter("resultFilePath");

			logger.debug(elementURI);
			logger.debug(projectName);
			logger.debug(modelName);
			logger.debug(projectPath);
			logger.debug("isProgrammaticallyExecution(event)");
			umlSelectedComponent = (Class) entityUtil.getElement(projectName, modelName, elementURI);
			String paramIsDiscrete = event.getParameter("isDiscrete");
			isDiscreteTime = Boolean.valueOf(paramIsDiscrete);
			smvFileDirectory = nuXmvDirectoryUtil.getSmvFileDirectory(projectPath);
			monolithicSMVFilePath = nuXmvDirectoryUtil.getMonolithicSMVFilePath(projectPath,
					umlSelectedComponent.getName());
			smvMapFilepath = ocraDirectoryUtil.getSmvMapFilePath(projectPath);
			//resultFilePath = nuXmvDirectoryUtil.getModelCheckingResultPath(projectPath, umlSelectedComponent.getName());

		}

		umlSelectedResource = umlSelectedComponent.eResource();
		showPopups = false;

	}

	@Override
	public void execJobCommand(ExecutionEvent event, IProgressMonitor monitor) throws Exception {

		String generatedSmvFilePath;

		// CommandBuilder checkContractImplementation =
		// CommandBuilder.build("org.polarsys.chess.verificationService.commands.TestCommand2");
		// checkContractImplementation.execute();

		if (smvExportService.isLeafComponent(umlSelectedComponent)) {
			generatedSmvFilePath = smvExportService.exportSingleSmv(umlSelectedComponent, showPopups, smvFileDirectory,
					monitor);
		} else {
			logger.debug("exportSmv");
			HashMap<String, String> smvPathComponentNameMap = smvExportService.exportSmv(umlSelectedComponent,
					showPopups, smvFileDirectory, monitor);
			logger.debug("createMonolithicSMV");
			ocraExecService.createMonolithicSMV(umlSelectedComponent, umlSelectedResource, smvPathComponentNameMap,
					isDiscreteTime, showPopups, smvMapFilepath, monolithicSMVFilePath, isProgrExec,monitor);

			generatedSmvFilePath = monolithicSMVFilePath;
			logger.debug("createMonolithicSMV done");
		}
		// nuXmvExecService.executeModelChecking(smvOutput,resultFilePath);

		logger.debug("executeModelChecking");
		nuXmvExecService.executeModelChecking(generatedSmvFilePath, resultFilePath,
				event.getParameter("algorithm_type"), event.getParameter("check_type"), event.getParameter("property"),isProgrExec);
		logger.debug("executeModelChecking done");
	}

}
