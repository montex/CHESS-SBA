/*******************************************************************************
 * Copyright (C) 2018 Fondazione Bruno Kessler.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Luca Cristoforetti - initial API and implementation
 ******************************************************************************/
package org.polarsys.chess.tradeoffAnalysis.commands;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Class;
import org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.InstantiatedArchitecture;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;
import org.polarsys.chess.service.core.model.ChessSystemModel;
import org.polarsys.chess.service.gui.utils.SelectionUtil;
import org.polarsys.chess.tradeoffAnalysis.dialogs.ConfigurationSelectionDialog;

import eu.fbk.eclipse.standardtools.ExecOcraCommands.ui.services.OCRAExecService;
import eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.ui.services.OSSTranslatorServiceUI;
import eu.fbk.eclipse.standardtools.utils.ui.commands.AbstractJobCommand;
import eu.fbk.eclipse.standardtools.utils.ui.dialogs.MessageTimeModelDialog;
import eu.fbk.eclipse.standardtools.utils.ui.utils.ErrorsDialogUtil;
import eu.fbk.eclipse.standardtools.utils.ui.utils.OCRADirectoryUtil;

public class TradeoffCommand extends AbstractJobCommand {
	private ConfigurationSelectionDialog configurationSelectionDialog;
	private SelectionUtil selectionUtil = SelectionUtil.getInstance();
	private final ErrorsDialogUtil errorsDialogUtil = ErrorsDialogUtil.getInstance();
	private OCRAExecService ocraExecService = OCRAExecService.getInstance(ChessSystemModel.getInstance());
	private OCRADirectoryUtil ocraDirectoryUtil = OCRADirectoryUtil.getInstance();
	private OSSTranslatorServiceUI ocraTranslatorService = 
			OSSTranslatorServiceUI.getInstance(ChessSystemModel.getInstance());
	private Class umlSelectedComponent;
	private String checkType;
	private EList<InstantiatedArchitecture> configurations;
	private boolean isDiscreteTime;
	private File ossFile;
	
	public TradeoffCommand() {
		super("Trade-off Analysis");
	}

	/**
	 * Exports to OSS the selected component.
	 * @param isDiscreteTime type of time model
	 * @param event the event
	 * @param monitor the monitor
	 * @return the exported file
	 * @throws Exception
	 */
	// Taken from InstantiateArchitectureViaWizard.exportArchitectureAsOssFile()
	private File exportArchitectureAsOssFile(boolean isDiscreteTime, ExecutionEvent event, 
			IProgressMonitor monitor) throws Exception {

		final String ossFilepath = ocraDirectoryUtil.getOSSDirPath();
		final boolean showPopups = false;
		final boolean usexTextValidation = true;
		final Class umlSelectedComponent = selectionUtil.getUmlComponentFromSelectedObject(event);
		final Resource umlSelectedResource = umlSelectedComponent.eResource();

		return ocraTranslatorService.exportRootComponentToOssFile(umlSelectedComponent, umlSelectedResource,
				isDiscreteTime, usexTextValidation, showPopups, ossFilepath, monitor);
	}
	
	@Override
	public void execPreJobOperations(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
		umlSelectedComponent = selectionUtil.getUmlComponentFromSelectedObject(event);
		
		// The command should be executed only on root components
		if (!EntityUtil.getInstance().isSystem(umlSelectedComponent)) {
			errorsDialogUtil.showMessage_GenericError("Please select a <<System>> component");
			return;
		}
		
		final Display defaultDisplay = Display.getDefault();
		defaultDisplay.syncExec(new Runnable() {
			@Override
			public void run() {
				configurationSelectionDialog = new ConfigurationSelectionDialog(umlSelectedComponent);
				configurationSelectionDialog.open();
			}
		});

		if (!configurationSelectionDialog.goAhead()) {
			return;
		}
		checkType = configurationSelectionDialog.getCheckType();
		configurations = configurationSelectionDialog.getConfigurations();

		isDiscreteTime = MessageTimeModelDialog.openQuestion(false);
		
		// Generate the OSS file for the parametrized architecture
		ossFile = exportArchitectureAsOssFile(isDiscreteTime, event, monitor);
	}

	/**
	 * Converts the EList of parameters to a List. 
	 * @param parameters the list of parameters
	 * @return the required List
	 */
	private ArrayList<String> prepareParameterValuesAsArrayList(EList<String> parameters) {
		final ArrayList<String> parametersArray = new ArrayList<String>(); 
				
		for (String string : parameters) {
			parametersArray.add(string);
		}
		return parametersArray;
	}
	
	@Override
	public void execJobCommand(ExecutionEvent event, IProgressMonitor monitor) throws Exception {

		//TODO:
		// ho il tipo di check e le configurazioni da testare:
		// devo generare il file oss per ogni configurazione (tramite instanziazione!)
		// devo lanciare il check contract refinement per ogni configurazione
		// devo visualizzare i risultati
		
		if (!configurationSelectionDialog.goAhead()) {
			return;
		}
		
		// The list of analyses results
		final List<String> resultPaths = new ArrayList<String>();
		
		if (configurations.size() > 0) {
			if (checkType.equals(ConfigurationSelectionDialog.CHECK_CONTRACT_REFINEMENT)) {
				for (InstantiatedArchitecture configuration : configurations) {

					final ArrayList<String> parametersList = 
							prepareParameterValuesAsArrayList(configuration.getParameterList());

					final String componentName = configuration.getBase_Property().getName();
					
					final File parametersValuesFile = 
							ocraExecService.prepareParameterValuesFile(parametersList, ossFile.getName());
										
					final File instantiatedOssFile = ocraExecService.executeInstantiateArchitecture(componentName, 
							ossFile, parametersValuesFile, 1, isDiscreteTime, monitor);					
										
					final String resultFilePath = 
							ocraDirectoryUtil.getCommandCheckRefinementResultPath(componentName);
					
					final boolean internalExecution = true; // Wait to finish before saving result
					if (ocraExecService.executeCheckContractRefinement(instantiatedOssFile, isDiscreteTime,
							resultFilePath, monitor, internalExecution)) {

						// Store the resulting file
						resultPaths.add(resultFilePath);
					}
				}
				
				// TODO: in resultPaths ho tutti i file con i risultati, li devo parsare e mettere in tabella!
				
			}
		}	
	}
}
