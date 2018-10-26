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
package org.polarsys.chess.verificationService.ui.commands;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Class;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;
import org.polarsys.chess.contracts.transformations.utils.AnalysisResultUtil;
import org.polarsys.chess.contracts.transformations.utils.FileNamesUtil;
import org.polarsys.chess.service.core.exceptions.NoComponentException;
import org.polarsys.chess.service.core.model.ChessSystemModel;
import org.polarsys.chess.service.core.model.UMLStateMachineModel;
import org.polarsys.chess.service.gui.utils.SelectionUtil;

import eu.fbk.eclipse.standardtools.ExecOcraCommands.ui.services.OCRAExecService;
import eu.fbk.eclipse.standardtools.StateMachineTranslatorToSmv.ui.services.SmvExportServiceUI;
import eu.fbk.eclipse.standardtools.nuXmvService.ui.services.NuXmvExecService;
import eu.fbk.eclipse.standardtools.nuXmvService.ui.utils.NuXmvDirectoryUtil;
import eu.fbk.eclipse.standardtools.utils.ui.commands.AbstractJobCommand;
import eu.fbk.eclipse.standardtools.utils.ui.dialogs.MessageTimeModelDialog;
import eu.fbk.eclipse.standardtools.utils.ui.utils.OCRADirectoryUtil;
import eu.fbk.tools.adapter.nuxmv.CheckModel;

/**
 * 
 *
 */
public class ModelCheckingCommand extends AbstractJobCommand {

	private static final Logger logger = Logger.getLogger(ModelCheckingCommand.class);

	private SelectionUtil selectionUtil = SelectionUtil.getInstance();
	private SmvExportServiceUI smvExportService = SmvExportServiceUI.getInstance(ChessSystemModel.getInstance(), UMLStateMachineModel.getInstance());
	private NuXmvExecService nuXmvExecService = NuXmvExecService.getInstance();
	private static NuXmvDirectoryUtil nuXmvDirectoryUtil = NuXmvDirectoryUtil.getInstance();
	private OCRADirectoryUtil ocraDirectoryUtil = OCRADirectoryUtil.getInstance();
	private OCRAExecService ocraExecService = OCRAExecService.getInstance(ChessSystemModel.getInstance());
	private EntityUtil entityUtil = EntityUtil.getInstance();
	private AnalysisResultUtil analysisResultUtil = AnalysisResultUtil.getInstance();

	public ModelCheckingCommand() {
		super("Model Checking");
	}

	private boolean isProgrExec;
	private Class umlSelectedComponent;
	private boolean showPopups;
	private boolean usexTextValidation;
	private String smvFileDirectory;
	private boolean isDiscreteTime;
	private String monolithicSMVFilePath;
	private String resultFilePath;
	private String smvMapDirPath;
	private Resource umlSelectedResource;
	private String ossDirPath;
	private boolean storeResult;

	@Override
	public void execPreJobOperations(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
		final String storeResultParam = "store_result";

		isProgrExec = isProgrammaticallyExecuted(event);
		if (!isProgrExec) {
			logger.debug("!isProgrammaticallyExecution(event)");

			// The user could select a component or a package containing an architecture
			// In the latter case, extract the system component from that package
			try {
				umlSelectedComponent = selectionUtil.getUmlComponentFromSelectedObject(event);
			} catch (NoComponentException e) {
				umlSelectedComponent = analysisResultUtil.getSystemComponentFromEvent(event);
			}	
//			umlSelectedComponent = selectionUtil.getUmlComponentFromSelectedObject(event);
			isDiscreteTime = MessageTimeModelDialog.openQuestion(true);
			smvFileDirectory = nuXmvDirectoryUtil.getSmvFileDirectory();
			monolithicSMVFilePath = nuXmvDirectoryUtil.getMonolithicSMVFilePath(umlSelectedComponent.getName());
			resultFilePath = nuXmvDirectoryUtil.getModelCheckingResultPath(umlSelectedComponent.getName());

			smvMapDirPath = nuXmvDirectoryUtil.getSmvFileDirectory();
			ossDirPath = ocraDirectoryUtil.getOSSDirPath();


			umlSelectedResource = umlSelectedComponent.eResource();
			showPopups = false;
			usexTextValidation=true;

			
			storeResult = (event.getParameter(storeResultParam) != null && 
					event.getParameter(storeResultParam).equals("true")) ? true : false;

			if (storeResult) {
				resultFilePath = FileNamesUtil.getInstance().computeModelCheckingFileName(umlSelectedComponent);
			} else {
				resultFilePath = nuXmvDirectoryUtil.getModelCheckingResultPath(umlSelectedComponent.getName());
			}

			// If requested to store the data, execute the command here, cannot be called later
			if (storeResult) {
				final String generatedSmvFilePath;
				final boolean internalExecution = true;
				String[] conditions = new String[1]; // It will be filled by the method
				if (isLeafComponent(umlSelectedComponent)) {
					generatedSmvFilePath = smvExportService.exportSingleSmv(umlSelectedComponent, 
							showPopups, smvFileDirectory, monitor);
				} else {
					logger.debug("exportSmv");
					HashMap<String, String> smvPathComponentNameMap = smvExportService.exportSmv(umlSelectedComponent,
							showPopups, smvFileDirectory, monitor);
					logger.debug("createMonolithicSMV");
					ocraExecService.createMonolithicSMV(umlSelectedComponent, umlSelectedResource, smvPathComponentNameMap,
							isDiscreteTime, usexTextValidation,showPopups, ossDirPath, smvMapDirPath, 
							monolithicSMVFilePath, isProgrExec, internalExecution, monitor);

					generatedSmvFilePath = monolithicSMVFilePath;
					logger.debug("createMonolithicSMV done");
				}

				if(nuXmvExecService.executeModelChecking(generatedSmvFilePath, resultFilePath,
						event.getParameter("algorithm_type"), event.getParameter("check_type"), 
						event.getParameter("property"), isProgrExec, internalExecution, conditions)) {
					
					// Store the result
					analysisResultUtil.storeResult(AnalysisResultUtil.MODEL_CHECKING_ANALYSIS, 
							conditions[0], resultFilePath, umlSelectedComponent, null);
					
					// Visualize the result
					analysisResultUtil.showResult(CheckModel.FUNCTION_NAME, resultFilePath);
				}
			}

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

			smvMapDirPath = nuXmvDirectoryUtil.getSmvFileDirectory(projectPath);
			ossDirPath = ocraDirectoryUtil.getOSSDirPath(projectPath);
			//resultFilePath = nuXmvDirectoryUtil.getModelCheckingResultPath(projectPath, umlSelectedComponent.getName());
		}

//		umlSelectedResource = umlSelectedComponent.eResource();
//		showPopups = false;
//		usexTextValidation=true;
	}

	@Override
	public void execJobCommand(ExecutionEvent event, IProgressMonitor monitor) throws Exception {

		if (!storeResult) {
			String generatedSmvFilePath;
			boolean internalExecution = true;

			// CommandBuilder checkContractImplementation =
			// CommandBuilder.build("org.polarsys.chess.verificationService.commands.TestCommand2");
			// checkContractImplementation.execute();

			if (isLeafComponent(umlSelectedComponent)) {
				generatedSmvFilePath = smvExportService.exportSingleSmv(umlSelectedComponent, showPopups, smvFileDirectory,
						monitor);
			} else {
				logger.debug("exportSmv");
				HashMap<String, String> smvPathComponentNameMap = smvExportService.exportSmv(umlSelectedComponent,
						showPopups, smvFileDirectory, monitor);
				logger.debug("createMonolithicSMV");
				ocraExecService.createMonolithicSMV(umlSelectedComponent, umlSelectedResource, smvPathComponentNameMap,
						isDiscreteTime, usexTextValidation,showPopups, ossDirPath, smvMapDirPath, 
						monolithicSMVFilePath, isProgrExec, internalExecution, monitor);

				generatedSmvFilePath = monolithicSMVFilePath;
				logger.debug("createMonolithicSMV done");
			}
			// nuXmvExecService.executeModelChecking(smvOutput,resultFilePath);

			internalExecution = false;
			logger.debug("executeModelChecking");
			nuXmvExecService.executeModelChecking(generatedSmvFilePath, resultFilePath,
					event.getParameter("algorithm_type"), event.getParameter("check_type"), 
					event.getParameter("property"), isProgrExec, internalExecution, null);
			logger.debug("executeModelChecking done");
		}
	}

	
	private boolean isLeafComponent(Class umlSelectedComponent) {
		EList<org.eclipse.uml2.uml.Property> subComponents = ChessSystemModel.getInstance().getSubComponentsInstances(umlSelectedComponent);
		return ((subComponents == null) || (subComponents.size() == 0));
	}
}
