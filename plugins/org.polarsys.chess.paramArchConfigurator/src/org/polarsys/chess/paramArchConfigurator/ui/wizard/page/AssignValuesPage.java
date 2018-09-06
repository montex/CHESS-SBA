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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
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
	
	private Table table;
	private Label tableLabel;
	private TableColumn columnParNames;
	private TableColumn columnParValues;
	private ArrayList<Text> parameterValueTexts = new ArrayList<Text>();

	// private File parametersListFile;
	// private File parametersValuesFile;
	private String originalOssFileName;
	private File ossFile;
	private Map<String, String> parametersHashMap;
	private EObject selectedElement;
	
	private boolean isDiscreteTime;
	private int currNumInstatiation;
	private IProgressMonitor monitor;

	public AssignValuesPage(String originalOssFileName, EObject selectedElement, File ossFile, Map<String, String> parametersHashMap,
			ArrayList<ArrayList<String>> prevParametersList, int currNumInstatiation, boolean isDiscreteTime,
			IProgressMonitor monitor, IWizard iWizard) throws FileNotFoundException {
		super("Assign values to parameters", prevParametersList);
		setTitle("Architecture Instantiation " + currNumInstatiation + ". Assign values to parameters");
		setDescription("Please assign a value to each parameter.");
		this.setWizard(iWizard);
		this.originalOssFileName = originalOssFileName;
		this.selectedElement = selectedElement;
		this.ossFile = ossFile;
		this.parametersHashMap = parametersHashMap;
		// this.prevParametersList = prevParametersList;
		this.isDiscreteTime = isDiscreteTime;
		this.currNumInstatiation = currNumInstatiation;
		this.monitor = monitor;

		setPageComplete(false);
	}

	@Override
	public IWizardPage getNextPage() {

		logger.debug("getNextPage");

		try {
			setParametersValues(parametersHashMap, parameterValueTexts);
			ArrayList<String> parametersList = prepareParameterValuesAsArrayList(parametersHashMap);

			File newOssFile = ocraExecService.executeInstantiateArchitecture(originalOssFileName, ossFile,
					parametersList, currNumInstatiation, isDiscreteTime, monitor);
			logger.debug("newOssFile path: " + newOssFile.getPath());

			ArrayList<ArrayList<String>> allParametersList = new ArrayList<ArrayList<String>>(prevParametersList);
			allParametersList.add(parametersList);

			Map<String, String> newParametersList = ocraExecService.executeGetParameters(newOssFile, isDiscreteTime,
					monitor);
			
			if ((newParametersList != null) && (!newParametersList.isEmpty())) {
				logger.debug("newParametersList size: " + newParametersList.entrySet().size());
				logger.debug("prevParametersList size: " + prevParametersList.size());
				logger.debug("allParametersList size: " + allParametersList.size());

				AssignValuesPage nextPage = new AssignValuesPage(originalOssFileName, selectedElement,newOssFile, newParametersList,
						allParametersList, currNumInstatiation + 1, isDiscreteTime, monitor, this.getWizard());
				return nextPage;
			} else {				
				LastPage lastPage = new LastPage(selectedElement,newOssFile,allParametersList);
				lastPage.setWizard(this.getWizard());
				return lastPage;
			}
		} catch (Exception e) {
			e.printStackTrace();
			dialogUtil.showMessage_ExceptionError(e);
			return null;
		}
		// return super.getNextPage();
	}

	@Override
	public void createControl(Composite parent) {
		
		 container = new Composite(parent, SWT.BORDER);
		GridLayout containerLayout = new GridLayout(2, true);
		container.setLayout(containerLayout);

		createViewPrevParametersArea(container);		
		createSetParametersArea(container);

		
		container.redraw();
		// required to avoid an error in the system
		setControl(container);
		// setPageComplete(false);
		setPageComplete(true);
	}

	
	
	@Override
	public boolean canFlipToNextPage() {
		return isPageComplete();
	}

	protected Control createSetParametersArea(Composite parent) {

		// container = parent;
		parameterValueTexts.clear();
		Composite compositeContent = new Composite(parent, SWT.BORDER);
		GridLayout layout = new GridLayout(1, true);
		compositeContent.setLayout(layout);
		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
		gd.widthHint = 500;
		gd.heightHint = 500;
		compositeContent.setLayoutData(gd);

		tableLabel = new Label(compositeContent, SWT.NONE);
		tableLabel.setText("Set values:");
		tableLabel.setLayoutData(new GridData());

		table = new Table(compositeContent, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		columnParNames = new TableColumn(table, SWT.NONE);
		columnParValues = new TableColumn(table, SWT.NONE);

		final int minRangeSize = 60;

		for (Entry<String, String> parameterEntry : parametersHashMap.entrySet()) {

			TableItem parameterNameItem = new TableItem(table, SWT.NONE);
			parameterNameItem.setText(0, parameterEntry.getKey());

			Text parameterValueText = new Text(table, SWT.LEFT);
			parameterValueText.setData(parameterEntry.getKey());
			parameterValueTexts.add(parameterValueText);
			// updateGUIExistingRefiningContracts(checkButton,
			// contractRefinement, selectedRange);

			TableEditor editor = new TableEditor(table);
			editor.minimumWidth = 100;
			editor.horizontalAlignment = SWT.LEFT;
			editor.grabHorizontal = true;
			editor.grabVertical = true;
			editor.setEditor(parameterValueText, parameterNameItem, 1);

		}

		columnParNames.setText("Parameters Name");
		columnParNames.pack();
		columnParValues.setText("Parameters Value");
		columnParValues.pack();
		columnParValues.setWidth(Math.max(columnParValues.getWidth(), minRangeSize));

		GridData tableGridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		//tableGridData.heightHint = 180;
		table.setLayoutData(tableGridData);
		compositeContent.redraw();

		return compositeContent;
	}

	private void setParametersValues(Map<String, String> parametersList, ArrayList<Text> parameterValueTexts) {

		for (int i = 0; i < parameterValueTexts.size(); i++) {
			parametersList.put((String) parameterValueTexts.get(i).getData(),
					(String) parameterValueTexts.get(i).getText());
		}

	}

	private ArrayList<String> prepareParameterValuesAsArrayList(Map<String, String> parametersList) {

		ArrayList<String> parList = new ArrayList<String>();

		for (Entry<String, String> parameterEntry : parametersList.entrySet()) {
			if (parameterEntry.getValue() != "") {
				parList.add(parameterEntry.getKey() + "=" + parameterEntry.getValue());
			}
		}

		return parList;
	}
}
