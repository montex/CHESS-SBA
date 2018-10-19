/*******************************************************************************
 * Copyright (C) 2018 Fondazione Bruno Kessler.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *   Alberto Debiasi - initial API and implementation
 ******************************************************************************/
package org.polarsys.chess.verificationService.ui.commands;

import java.util.HashMap;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Class;
import org.polarsys.chess.contracts.transformations.utils.AnalysisResultUtil;
import org.polarsys.chess.contracts.transformations.utils.FileNamesUtil;
import org.polarsys.chess.service.core.exceptions.NoComponentException;
import org.polarsys.chess.service.core.model.ChessSystemModel;
import org.polarsys.chess.service.core.model.UMLStateMachineModel;
import org.polarsys.chess.service.gui.utils.SelectionUtil;

import eu.fbk.eclipse.standardtools.ExecOcraCommands.ui.services.OCRAExecService;
import eu.fbk.eclipse.standardtools.StateMachineTranslatorToSmv.ui.services.SmvExportServiceUI;
import eu.fbk.eclipse.standardtools.nuXmvService.ui.utils.NuXmvDirectoryUtil;
import eu.fbk.eclipse.standardtools.utils.ui.commands.AbstractJobCommand;
import eu.fbk.eclipse.standardtools.utils.ui.dialogs.MessageTimeModelDialog;
import eu.fbk.eclipse.standardtools.utils.ui.utils.OCRADirectoryUtil;
import eu.fbk.tools.adapter.ocra.CheckContractCompositeImplementation;

public class CompositeContractImplementationCommand extends AbstractJobCommand {

	private OCRAExecService ocraExecService = OCRAExecService.getInstance(ChessSystemModel.getInstance());
	private SelectionUtil selectionUtil = SelectionUtil.getInstance();
	private SmvExportServiceUI smvExportService = SmvExportServiceUI.getInstance(ChessSystemModel.getInstance(), UMLStateMachineModel.getInstance());
	private OCRADirectoryUtil ocraDirectoryUtil = OCRADirectoryUtil.getInstance();
	private NuXmvDirectoryUtil nuXmvDirectoryUtil = NuXmvDirectoryUtil.getInstance();
	private AnalysisResultUtil analysisResultUtil = AnalysisResultUtil.getInstance();
	
	public CompositeContractImplementationCommand() {
		super("Check Compositional Contract Implementation");
	}

	private Class umlSelectedComponent;
	private Resource umlSelectedResource;
	private boolean isDiscreteTime;
	private boolean showPopups;
	private boolean usexTextValidation;
	private String smvMapFilepath;
	private String smvFilePath;
	private String resultFilePath;
	private String ossFilePath;
	private boolean storeResult;
	
	@Override
	public void execPreJobOperations(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
		final String storeResultParam = "store_result";

		// The user could select a component or a package containing an architecture
		// In the latter case, extract the system component from that package
		try {
			umlSelectedComponent = selectionUtil.getUmlComponentFromSelectedObject(event);
		} catch (NoComponentException e) {
			umlSelectedComponent = analysisResultUtil.getSystemComponentFromEvent(event);
		}	
//		umlSelectedComponent = selectionUtil.getUmlComponentFromSelectedObject(event);
		umlSelectedResource = umlSelectedComponent.eResource();
		isDiscreteTime = MessageTimeModelDialog.openQuestion(true);
		showPopups = false;
		usexTextValidation=true;
		ossFilePath = ocraDirectoryUtil.getOSSFilePath();
		smvMapFilepath = nuXmvDirectoryUtil.getSmvMapFilePath();
		smvFilePath = nuXmvDirectoryUtil.getSmvFileDirectory();
//		resultFilePath = ocraDirectoryUtil.getCommandCheckImplementationResultPath(umlSelectedComponent.getName());

		storeResult = (event.getParameter(storeResultParam) != null && 
				event.getParameter(storeResultParam).equals("true")) ? true : false;

		if (storeResult) {
			resultFilePath = FileNamesUtil.getInstance().computeContractImplementationFileName(umlSelectedComponent);
		} else {
			resultFilePath = ocraDirectoryUtil.getCommandCheckImplementationResultPath(umlSelectedComponent.getName());
		}

		// If requested to store the data, execute the command here, cannot be called later
		if (storeResult) {
			HashMap<String, String> smvPathComponentNameMap = smvExportService.exportSmv(umlSelectedComponent, showPopups,
					smvFilePath, monitor);
			if (ocraExecService.executeCheckCompositeContractImplementation(umlSelectedComponent, umlSelectedResource,
					smvPathComponentNameMap, isDiscreteTime, usexTextValidation,showPopups, 
					ossFilePath, smvMapFilepath, resultFilePath, monitor, true)) {
				
				// Store the result
				analysisResultUtil.storeResult(AnalysisResultUtil.CONTRACT_IMPLEMENTATION_ANALYSIS, null, 
						resultFilePath, umlSelectedComponent, null);
				
				// Visualize the result
				analysisResultUtil.showResult(CheckContractCompositeImplementation.FUNCTION_NAME, resultFilePath);
			}
		}
	}

	@Override
	public void execJobCommand(ExecutionEvent event, IProgressMonitor monitor) throws Exception {

		if (!storeResult) {
			HashMap<String, String> smvPathComponentNameMap = smvExportService.exportSmv(umlSelectedComponent, showPopups,
					smvFilePath, monitor);
			ocraExecService.executeCheckCompositeContractImplementation(umlSelectedComponent, umlSelectedResource,
					smvPathComponentNameMap, isDiscreteTime, usexTextValidation,showPopups, 
					ossFilePath, smvMapFilepath, resultFilePath, monitor, false);
		}
	}
}
