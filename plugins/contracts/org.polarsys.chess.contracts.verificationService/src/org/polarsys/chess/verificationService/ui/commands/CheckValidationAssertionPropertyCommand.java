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

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Class;
import org.polarsys.chess.contracts.transformations.utils.AnalysisResultUtil;
import org.polarsys.chess.contracts.transformations.utils.FileNamesUtil;
import org.polarsys.chess.service.core.exceptions.NoComponentException;
import org.polarsys.chess.service.core.model.ChessSystemModel;
import org.polarsys.chess.service.gui.utils.SelectionUtil;

import eu.fbk.eclipse.standardtools.ExecOcraCommands.ui.services.OCRAExecService;
import eu.fbk.eclipse.standardtools.utils.ui.commands.AbstractJobCommand;
import eu.fbk.eclipse.standardtools.utils.ui.dialogs.MessageTimeModelDialog;
import eu.fbk.eclipse.standardtools.utils.ui.utils.OCRADirectoryUtil;
import eu.fbk.tools.adapter.ocra.CheckValidationProperty;

/**
 * 
 *
 */
public class CheckValidationAssertionPropertyCommand extends AbstractJobCommand {

	private ChessSystemModel chessToOCRAModelTranslator = ChessSystemModel.getInstance();
	private OCRAExecService ocraExecService = OCRAExecService.getInstance(chessToOCRAModelTranslator);
	private SelectionUtil selectionUtil = SelectionUtil.getInstance();
	private OCRADirectoryUtil ocraDirectoryUtil = OCRADirectoryUtil.getInstance();
	private AnalysisResultUtil analysisResultUtil = AnalysisResultUtil.getInstance();
	
	public CheckValidationAssertionPropertyCommand() {
		super("Check Validation Property");
	}

	private Class umlSelectedComponent;
	private Resource umlSelectedResource;
	private boolean isDiscreteTime;
	private boolean showPopups;
	private boolean usexTextValidation;
	private String ossFilepath;
	private String resultFilePath;
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
		isDiscreteTime = MessageTimeModelDialog.openQuestion(false);
		showPopups = false;
		usexTextValidation=true;

		ossFilepath = ocraDirectoryUtil.getOSSDirPath();
		
		storeResult = (event.getParameter(storeResultParam) != null && 
				event.getParameter(storeResultParam).equals("true")) ? true : false;

		if (storeResult) {
			resultFilePath = FileNamesUtil.getInstance().computePropertyValidationFileName(umlSelectedComponent);
		} else {
			resultFilePath = ocraDirectoryUtil.getCommandCheckPropertyResultPath(umlSelectedComponent.getName());
		}

		// If requested to store the data, execute the command here, cannot be called later
		if (storeResult) {
			String[] conditions = new String[1]; // It will be filled by the method
			if(ocraExecService.executeValidationAssertionProperty(umlSelectedComponent, umlSelectedResource, isDiscreteTime, usexTextValidation,showPopups,
					ossFilepath, resultFilePath, monitor, true, conditions)) {
				
				// Store the result
				analysisResultUtil.storeResult(AnalysisResultUtil.PROPERTY_VALIDATION_ANALYSIS, conditions[0], 
						resultFilePath, umlSelectedComponent, null);
				
				// Visualize the result
				analysisResultUtil.showResult(CheckValidationProperty.FUNCTION_NAME, resultFilePath);
			}
		}
	}

	@Override
	public void execJobCommand(ExecutionEvent event, IProgressMonitor monitor) throws Exception {

		if (!storeResult) {
			ocraExecService.executeValidationAssertionProperty(umlSelectedComponent, umlSelectedResource, isDiscreteTime, usexTextValidation,showPopups,
					ossFilepath, resultFilePath, monitor, false, null);
		}
	}
}
