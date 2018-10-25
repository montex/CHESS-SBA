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

import org.apache.log4j.Logger;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Class;
import org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.InstantiatedArchitecture;
import org.polarsys.chess.contracts.profile.chesscontract.ContractProperty;
import org.polarsys.chess.contracts.profile.chesscontract.FormalProperty;
import org.polarsys.chess.contracts.profile.chesscontract.util.ContractEntityUtil;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;
import org.polarsys.chess.service.core.model.ChessSystemModel;
import org.polarsys.chess.service.gui.utils.SelectionUtil;
import org.polarsys.chess.tradeoffAnalysis.dialogs.ConfigurationSelectionDialog;
import org.polarsys.chess.tradeoffAnalysis.views.TradeoffView;
import org.polarsys.chess.tradeoffAnalysis.views.TradeoffView.Row;

import eu.fbk.eclipse.standardtools.ExecOcraCommands.ui.services.OCRAExecService;
import eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.ui.services.OSSTranslatorServiceUI;
import eu.fbk.eclipse.standardtools.utils.ui.commands.AbstractJobCommand;
import eu.fbk.eclipse.standardtools.utils.ui.dialogs.MessageTimeModelDialog;
import eu.fbk.eclipse.standardtools.utils.ui.utils.DialogUtil;
import eu.fbk.eclipse.standardtools.utils.ui.utils.ErrorsDialogUtil;
import eu.fbk.eclipse.standardtools.utils.ui.utils.OCRADirectoryUtil;
import eu.fbk.tools.adapter.ocra.CheckContractRefinement;
import eu.fbk.tools.adapter.ocra.CheckContractResultBuilder;
import eu.fbk.tools.adapter.ocra.OcraOutput;
import eu.fbk.tools.adapter.results.ContractCheckResult;
import eu.fbk.tools.adapter.results.ModelCheckResult;

/**
 * This command triggers the trade-off analysis.
 * @author cristofo
 *
 */
public class TradeoffCommand extends AbstractJobCommand {
	private static final Logger logger = Logger.getLogger(TradeoffCommand.class);
	private ConfigurationSelectionDialog configurationSelectionDialog;
	private SelectionUtil selectionUtil = SelectionUtil.getInstance();
	private ContractEntityUtil contractEntityUtil = ContractEntityUtil.getInstance();
	private final ErrorsDialogUtil errorsDialogUtil = ErrorsDialogUtil.getInstance();
	private DialogUtil dialogUtil = DialogUtil.getInstance();
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
	
	/**
	 * Navigates the given component to the specified contract and retrieves the concerns it addresses.
	 * @param umlSelectedComponent the component to navigate
	 * @param contractName the name of the contract to analyse
	 * @return the concerns addressed
	 */
	private String getConcerns(Class umlSelectedComponent, String contractName) {
		String concerns = null;

		// Get the contract properties of the component and look for the correct one
		final EList<ContractProperty> contractProperties = 
				contractEntityUtil.getContractProperties(umlSelectedComponent);
		
		for (ContractProperty contractProperty : contractProperties) {
			final Class contractPropertyType = (Class) contractProperty.getBase_Property().getType();
			
			if (contractPropertyType.getName().equals(contractName)) {
				final FormalProperty assume = 
						contractEntityUtil.getAssumeFromUmlContract(contractPropertyType);
				concerns = assume.getConcern().getName();
				final FormalProperty guarantee = 
						contractEntityUtil.getGuaranteeFromUmlContract(contractPropertyType);
				if (!guarantee.getConcern().getName().equals(concerns)) {
					concerns += ", " + guarantee.getConcern().getName();
				}
			}
		}
		return concerns;
	}
	
	/**
	 * Takes the result of an analysis an creates an entry row for the table.
	 * @param index the number of configuration being parsed
	 * @param analysisResult the analysis result
	 * @param rows the row being populated
	 * @param labels the list of column labels to be populated
	 * @param concernsRow the concerns row to be populated
	 */
	private void processResult(int index, AnalysisResult analysisResult, Row row, 
			List<String> labels, Row concernsRow) {
				
		// Open the file containing the results
		final File resultFile;
		try {
			resultFile = new File(analysisResult.getResultFilePath());
		} catch (Exception e) {
			dialogUtil.showMessage_ExceptionError(e);
			e.printStackTrace();
			return;
		}

		// Parse the results file
		final CheckContractResultBuilder resultBuilder = new CheckContractResultBuilder();
		final OcraOutput ocraOutput = resultBuilder.unmarshalResult(resultFile);
		if(ocraOutput == null || ocraOutput.getOcraResult() == null || ocraOutput.getOcraResult().isEmpty()) {
			logger.debug("Error while unmarshalling the result. For more info see the console");
			return;
		}

		final ModelCheckResult contractCheckResult = resultBuilder.buildResult(ocraOutput);
		if(contractCheckResult == null) {
			logger.debug("Internal error while building the result. For more info see the console");
			return;
		}

		final List<ContractCheckResult> contractCheckResults = contractCheckResult.getContractCheckResults();
		for (ContractCheckResult result : contractCheckResults) {
			if (result.getCheckType().equals("ocra_check_refinement")) {
				
				// Check only the contracts of the root component
				if(result.getComponentType().equals(umlSelectedComponent.getName())) {
					String contractName = result.getContractName();
					
					// If the configuration is the first, populate also labels and concerns
					if (index == 0) {
						labels.add(contractName);
						concernsRow.addResult(getConcerns(umlSelectedComponent, contractName));
					}
					
					// Store the result of the check;
					final String checkResult = result.getFailed()? "NOT OK": "Success";					
					row.addResult(checkResult);
				}
			}
		}	
	}

	/**
	 * Fills the table view with the given results.
	 * @param results the results of the analyses
	 */
	private void displayResult(List<AnalysisResult> results) {
		final Display display = PlatformUI.getWorkbench().getDisplay();
		
		display.asyncExec(() -> {
			try {
				final TradeoffView viewPart = (TradeoffView) PlatformUI.getWorkbench().getActiveWorkbenchWindow().
						getActivePage().showView(TradeoffView.ID, null, IWorkbenchPage.VIEW_VISIBLE);

				if (viewPart != null) {
					
					// Prepare the names of the fixed columns
					final List<String> labels = new ArrayList<String>();
					labels.add("");	// The upper-left entry is empty
					labels.add("");	// Hidden field used to store analysis type
					labels.add("");	// Hidden field used to store file path

					// The rows for the table
					final List<Row> rows = new ArrayList<Row>();
					
					// First row is for concerns, will be completed later
					final Row concernsRow = new Row("Concerns");
					rows.add(concernsRow);
					
					int index = 0;
					for (AnalysisResult analysisResult : results) {
						
						// Create a row foreach analysis
						final Row configuration = new Row(analysisResult.getConfigurationName());
						rows.add(configuration);
						configuration.setAnalysisName(checkType);
						configuration.setResultFilePath(analysisResult.getResultFilePath());
						
						processResult(index++, analysisResult, configuration, labels, concernsRow);
						
					}
					
					// Create the columns names for the table
					viewPart.createColumns(viewPart.getViewer(), labels);

					// Check to see if everything is fine
					final TableViewer tableViewer = viewPart.getViewer();
					final IContentProvider provider = tableViewer.getContentProvider();
					if (provider == null) {
						return;
					}

					// Set the values for the table
					tableViewer.setInput(rows);
					tableViewer.refresh();

					// Switch to the view
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().activate(viewPart);
				}
			}
			catch (Exception e) {
				dialogUtil.showMessage_ExceptionError(e);
				e.printStackTrace();
			}
		});
	}
	
	@Override
	public void execJobCommand(ExecutionEvent event, IProgressMonitor monitor) throws Exception {

		if (!configurationSelectionDialog.goAhead() || ossFile == null) {
			return;
		}
		
		// The list of analyses results
		final List<AnalysisResult> results = new ArrayList<AnalysisResult>();
		
		if (configurations.size() > 0) {
			if (checkType.equals(ConfigurationSelectionDialog.CHECK_CONTRACT_REFINEMENT)) {
				
				// Change the type to the actual function name used
				checkType = CheckContractRefinement.FUNCTION_NAME;
				for (InstantiatedArchitecture configuration : configurations) {

					final ArrayList<String> parametersList = 
							prepareParameterValuesAsArrayList(configuration.getParameterList());

					final String configurationName = configuration.getBase_Property().getName();
					
					final File parametersValuesFile = 
							ocraExecService.prepareParameterValuesFile(parametersList, ossFile.getName());
										
					final File instantiatedOssFile = ocraExecService.executeInstantiateArchitecture(configurationName, 
							ossFile, parametersValuesFile, 1, isDiscreteTime, monitor);					
										
					final String resultFilePath = 
							ocraDirectoryUtil.getCommandCheckRefinementResultPath(configurationName);
					
					final boolean internalExecution = true; // Wait to finish before saving result
					if (ocraExecService.executeCheckContractRefinement(instantiatedOssFile, isDiscreteTime,
							resultFilePath, monitor, internalExecution)) {

						// Store the result
						final AnalysisResult result = new AnalysisResult(configurationName, resultFilePath);
						results.add(result);
					}
				}
				displayResult(results);
			}
		}
	}
	
	/**
	 * Small class to store the configuration name and its result file.
	 * @author cristofo
	 *
	 */
	protected class AnalysisResult {
		private String configurationName;
		private String resultFilePath;
		
		public AnalysisResult(String configurationName, String resultFilePath) {
			this.configurationName = configurationName;
			this.resultFilePath = resultFilePath;
		}

		public String getConfigurationName() {
			return configurationName;
		}
		
		public void setConfigurationName(String configurationName) {
			this.configurationName = configurationName;
		}
		
		public String getResultFilePath() {
			return resultFilePath;
		}
		
		public void setResultFilePath(String resultFilePath) {
			this.resultFilePath = resultFilePath;
		}
	}
}
