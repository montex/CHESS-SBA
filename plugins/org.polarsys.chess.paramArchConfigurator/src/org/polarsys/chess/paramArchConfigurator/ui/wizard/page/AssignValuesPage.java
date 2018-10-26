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
package org.polarsys.chess.paramArchConfigurator.ui.wizard.page;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.polarsys.chess.service.core.model.ChessSystemModel;

import eu.fbk.eclipse.standardtools.ExecOcraCommands.ui.services.OCRAExecService;
import eu.fbk.eclipse.standardtools.utils.ui.utils.DialogUtil;

public class AssignValuesPage extends BasicWizardPage {

	private OCRAExecService ocraExecService = OCRAExecService.getInstance(ChessSystemModel.getInstance());
	private DialogUtil dialogUtil = DialogUtil.getInstance();
	private static final Logger logger = Logger.getLogger(AssignValuesPage.class);

	private Composite container;
	private Composite compositeAssignParamsContent;

	Button selectExistingParamsButton;
	private Table table;
	private Label tableLabel;
	private TableColumn columnParNames;
	private TableColumn columnParValues;
	private ArrayList<Text> parameterValueTexts = new ArrayList<Text>();
private ArrayList<TableEditor> parameterValueEditor = new ArrayList<TableEditor>();
	private String originalOssFileName;
	private File ossFile;
	private Map<String, String> parametersHashMap;
	private Map<String, String> selectedExistingParametersList;
	private Integer selectedExistingArchitectureIndex;
	private Map<String, Map<String, String>> existingParametersLists;
	private EObject selectedElement;

	private boolean isFirstPage;
	private boolean isDiscreteTime;
	private int currNumInstatiation;
	private IProgressMonitor monitor;

	public AssignValuesPage(boolean isFirstPage, String originalOssFileName, EObject selectedElement, File ossFile,
			Integer selectedExistingArchitectureIndex, Map<String, String> selectedExistingParametersList,
			Map<String, Map<String, String>> existingParametersLists, Map<String, String> parametersHashMap,
			ArrayList<ArrayList<String>> prevParametersList, int currNumInstatiation, boolean isDiscreteTime,
			IProgressMonitor monitor, IWizard iWizard) throws FileNotFoundException {
		super("Assign values to parameters", prevParametersList);
		setTitle("Architecture Instantiation " + currNumInstatiation + ". Assign values to parameters");
		setDescription("Please assign a value to each parameter.");
		this.setWizard(iWizard);
		this.isFirstPage = isFirstPage;
		this.originalOssFileName = originalOssFileName;
		this.selectedElement = selectedElement;
		this.ossFile = ossFile;
		this.parametersHashMap = parametersHashMap;
		this.selectedExistingArchitectureIndex = selectedExistingArchitectureIndex;
		this.selectedExistingParametersList = selectedExistingParametersList;
		this.existingParametersLists = existingParametersLists;
		this.isDiscreteTime = isDiscreteTime;
		this.currNumInstatiation = currNumInstatiation;
		this.monitor = monitor;

		setPageComplete(false);
	}

	private void updateParametersHashMapWithExistingValues(Map<String, String> parametersHashMap,
			Map<String, String> selectedExistingParametersList) {

		logger.debug("updateParametersHashMapWithExistingValues");
		logger.debug(("selectedExistingParametersList!=null: " + null) != null);
		logger.debug("parametersHashMap!=null: " + parametersHashMap != null);
		logger.debug("(selectedExistingParametersList != null) && (parametersHashMap != null): "
				+ ((selectedExistingParametersList != null) && (parametersHashMap != null)));

		if ((selectedExistingParametersList != null) && (parametersHashMap != null)) {

			logger.debug("in cicle for");
			logger.debug("in cicle for: " + parametersHashMap.entrySet().size());

			for (Entry<String, String> par : parametersHashMap.entrySet()) {
				logger.debug("curr Param in the GUI: " + par);
			}

			for (Entry<String, String> existingParam : selectedExistingParametersList.entrySet()) {
				logger.debug("currExistingParam: " + existingParam);
				if (parametersHashMap.containsKey(existingParam.getKey())) {
					logger.debug("parametersHashMap.put: " + existingParam.getKey() + " - " + existingParam.getValue());
					parametersHashMap.put(existingParam.getKey(), existingParam.getValue());
				}
			}
		}

	}

	@Override
	public IWizardPage getNextPage() {

		logger.debug("getNextPage");

		try {
			setParametersValues(parametersHashMap, parameterValueTexts);
			ArrayList<String> parametersList = prepareParameterValuesAsArrayList(parametersHashMap);

			File parametersValuesFile = ocraExecService.prepareParameterValuesFile(parametersList, ossFile.getName());

			File newOssFile = ocraExecService.executeInstantiateArchitecture(originalOssFileName, ossFile,
					parametersValuesFile, currNumInstatiation, isDiscreteTime, monitor);
			logger.debug("newOssFile path: " + newOssFile.getPath());

			ArrayList<ArrayList<String>> allParametersList = new ArrayList<ArrayList<String>>(prevParametersList);
			allParametersList.add(parametersList);

			Map<String, String> newParametersList = ocraExecService.executeGetParameters(newOssFile, isDiscreteTime,
					monitor);

			if (selectExistingParamsButton.getSelection()) {
				updateParametersHashMapWithExistingValues(newParametersList, this.selectedExistingParametersList);
			}

			if ((newParametersList != null) && (!newParametersList.isEmpty())) {
				logger.debug("newParametersList size: " + newParametersList.entrySet().size());
				logger.debug("prevParametersList size: " + prevParametersList.size());
				logger.debug("allParametersList size: " + allParametersList.size());
				logger.debug("selectedExistingArchitectureIndex: " + selectedExistingArchitectureIndex);

				AssignValuesPage nextPage = new AssignValuesPage(false, originalOssFileName, selectedElement,
						newOssFile,
						selectExistingParamsButton.getSelection() ? selectedExistingArchitectureIndex : null,
						selectedExistingParametersList, existingParametersLists, newParametersList, allParametersList,
						currNumInstatiation + 1, isDiscreteTime, monitor, this.getWizard());
				return nextPage;
			} else {
				LastPage lastPage = new LastPage(selectedElement, newOssFile, allParametersList);
				lastPage.setWizard(this.getWizard());
				return lastPage;
			}
		} catch (Exception e) {
			e.printStackTrace();
			dialogUtil.showMessage_ExceptionError(e);
			return null;
		}
	}

	@Override
	public void createControl(Composite parent) {

		container = new Composite(parent, SWT.BORDER);
		GridLayout containerLayout = new GridLayout(2, true);
		container.setLayout(containerLayout);

		createExistingParamsSelectionArea(container);
		createViewPrevParametersArea(container);
		createSetParametersArea(container);

		container.redraw();
		// required to avoid an error in the system
		setControl(container);
		// setPageComplete(false);
		setPageComplete(true);
	}

	private void createExistingParamsSelectionArea(Composite parent) {
		// TODO Auto-generated method stub
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;

		// the label in the first row should span across both columns
		gridData.horizontalSpan = 2;

		Composite compositeContent = new Composite(parent, SWT.BORDER);
		GridLayout layout = new GridLayout(3, false);
		compositeContent.setEnabled(isFirstPage);
		compositeContent.setLayout(layout);
		compositeContent.setLayoutData(gridData);

		selectExistingParamsButton = new Button(compositeContent, SWT.CHECK);
		if ((!isFirstPage) && (selectedExistingArchitectureIndex != null)) {
			selectExistingParamsButton.setSelection(true);
		} else {
			selectExistingParamsButton.setSelection(false);
		}

		Label labelCheck = new Label(compositeContent, SWT.NONE);
		labelCheck.setText("Select parameters used to instantiate the following architecture:");
		Combo c = createCombo(compositeContent, existingParametersLists);

	}

	// Create a Combo
	private Combo createCombo(Composite parent, Map<String, Map<String, String>> existingParametersLists) {

		Combo combo = new Combo(parent, SWT.DROP_DOWN | SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);
		setComboContents(combo, existingParametersLists);
		combo.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				logger.debug("selectedExistingParametersList: " + e);
				if (selectExistingParamsButton.getSelection()) {
					selectedExistingParametersList = (Map<String, String>) combo.getData(combo.getText());
					selectedExistingArchitectureIndex = combo.getSelectionIndex();

					updateParametersHashMapWithExistingValues(parametersHashMap, selectedExistingParametersList);
					
					//createAssignValueTable();
					//compositeAssignParamsContent.dispose();
					
					populateColumnParValues();
					compositeAssignParamsContent.layout(true);

				}
				logger.debug("selectedExistingParametersList size: " + selectedExistingParametersList.size());
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		return combo;
	}

	private void setComboContents(Combo combo, Map<String, Map<String, String>> existingParametersLists) {
		combo.removeAll();
		if (existingParametersLists != null) {
			for (Entry<String, Map<String, String>> entry : existingParametersLists.entrySet()) {
				combo.add(entry.getKey());
				combo.setData(entry.getKey(), entry.getValue());
			}
			if (selectedExistingArchitectureIndex != null) {
				combo.select(selectedExistingArchitectureIndex);
			}
		}
	}

	@Override
	public boolean canFlipToNextPage() {
		return isPageComplete();
	}

	protected Control createSetParametersArea(Composite parent) {

		logger.debug("createSetParametersArea");
		// container = parent;

		compositeAssignParamsContent = new Composite(parent, SWT.BORDER);
		GridLayout layout = new GridLayout(1, true);
		compositeAssignParamsContent.setLayout(layout);
		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
		gd.widthHint = 500;
		gd.heightHint = 500;
		compositeAssignParamsContent.setLayoutData(gd);

		tableLabel = new Label(compositeAssignParamsContent, SWT.NONE);
		tableLabel.setText("Set values:");
		tableLabel.setLayoutData(new GridData());

		createAssignValueTable();
		compositeAssignParamsContent.redraw();

		return compositeAssignParamsContent;
	}

	private void createAssignValueTable() {
		table = new Table(compositeAssignParamsContent, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		columnParNames = new TableColumn(table, SWT.NONE);
		columnParValues = new TableColumn(table, SWT.NONE);

		final int minRangeSize = 60;

		populateColumnParValues();

		columnParNames.setText("Parameters Name");
		columnParNames.pack();
		columnParValues.setText("Parameters Value");
		columnParValues.pack();
		columnParValues.setWidth(Math.max(columnParValues.getWidth(), minRangeSize));

		GridData tableGridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		table.setLayoutData(tableGridData);
		compositeAssignParamsContent.redraw();
	}

	private void populateColumnParValues() {
		
		logger.debug("populateColumnParValues");
		table.removeAll();
		parameterValueTexts.clear();
		
		clearTableEditors();
		
		
		for (Entry<String, String> parameterEntry : parametersHashMap.entrySet()) {

			TableItem parameterNameItem = new TableItem(table, SWT.NONE);
			
			parameterNameItem.setText(0, parameterEntry.getKey());

			Text parameterValueText = new Text(table, SWT.LEFT);
			parameterValueText.setData(parameterEntry.getKey());
			parameterValueText.setText(parameterEntry.getValue());
			//parameterValueText.redraw();
			//parameterValueText.pack();
			//parameterValueText.update();
			parameterValueTexts.add(parameterValueText);

			TableEditor editor = new TableEditor(table);
			editor.minimumWidth = 100;
			editor.horizontalAlignment = SWT.LEFT;
			editor.grabHorizontal = true;
			editor.grabVertical = true;
			editor.setEditor(parameterValueText, parameterNameItem, 1);
			parameterValueEditor.add(editor);

		}
	}

	private void clearTableEditors() {
		if(parameterValueEditor!=null){
			for(TableEditor tableEditor : parameterValueEditor){
				tableEditor.getEditor().dispose();
			}
			parameterValueEditor.clear();
		}
		
	}

	private void setParametersValues(Map<String, String> parametersList, ArrayList<Text> parameterValueTexts) {

		for (int i = 0; i < parameterValueTexts.size(); i++) {
			logger.debug("setParametersValues. "+(String) parameterValueTexts.get(i).getData()+" , "+(String) parameterValueTexts.get(i).getText() );
			parametersList.put((String) parameterValueTexts.get(i).getData(),
					(String) parameterValueTexts.get(i).getText());
		}

	}

	private ArrayList<String> prepareParameterValuesAsArrayList(Map<String, String> parametersList) throws Exception {

		ArrayList<String> parList = new ArrayList<String>();

		for (Entry<String, String> parameterEntry : parametersList.entrySet()) {
			if (!parameterEntry.getValue().equals("")) {
				logger.debug("prepareParameterValuesAsArrayList. "+parameterEntry.getKey()+" , "+parameterEntry.getValue());
				parList.add(parameterEntry.getKey() + "=" + parameterEntry.getValue());
			}
		}

		if(parList.isEmpty()){
			throw new Exception("No parameters are set.");
		}
		return parList;
	}
}
