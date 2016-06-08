/*******************************************************************************
 *
 * Copyright (c) 2015 Intecs SpA 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Laura Baracchi  laura.baracchi@intecs.it  - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.polarsys.chess.m2m.ui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Operation;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtPortSlot;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification;
import org.polarsys.chess.core.util.AnalysisResultData;
import org.polarsys.chess.core.util.HWAnalysisResultData;
import org.polarsys.chess.core.util.uml.UMLUtils;

/**
 * Used to display a window that shows the results of two different schedulability analyses
 * @author laura
 * @since 0.9
 *
 */
public class CompareSchedResultDialog extends Dialog {

	private Shell shell;
	private String result;
	private String analysisContextName1;
	private String analysisContextName2;
	private List<AnalysisResultData>resultData1; 
	private List<AnalysisResultData>resultData2;
	private List<HWAnalysisResultData> resultHWData1;
	private List<HWAnalysisResultData> resultHWData2;
	private String title;
	private Map <String, AnalysisResultData> resultMap1;
	private Map <String, AnalysisResultData> resultMap2;

	public CompareSchedResultDialog(Shell parentShell,
			String analysisContextName1,
			String analysisContextName2,
			List<AnalysisResultData> analysisResData1, 
			List<AnalysisResultData> analysisResData2,
			List<HWAnalysisResultData> listHWData1,
			List<HWAnalysisResultData> listHWData2,
			String title) {
		super(parentShell);
		this.shell = parentShell;
		this.analysisContextName1 = analysisContextName1;
		this.analysisContextName2 = analysisContextName2;
		this.resultData1 = analysisResData1;
		this.resultData2 = analysisResData2;
		this.resultHWData1 = listHWData1;
		this.resultHWData2 = listHWData2;
		this.title = title;

		Map <String, AnalysisResultData> resultMap1 = new HashMap<String, AnalysisResultData>();
		Map <String, AnalysisResultData> resultMap2 = new HashMap<String, AnalysisResultData>();

		for(AnalysisResultData theResult : analysisResData1) {
			String theInstanceKey = theResult.instance;
			resultMap1.put(theInstanceKey, theResult);			
		}
		this.resultMap1 = resultMap1;

		for(AnalysisResultData theResult : analysisResData2) {
			String theInstanceKey = theResult.instance;
			resultMap2.put(theInstanceKey, theResult);			
		}
		this.resultMap2 = resultMap2;
	}


	/**
	 * Creates the dialog area for displaying the results of two different schedulability analyses 
	 */
	@Override
	protected Control createDialogArea(Composite parent) {

		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		layout.horizontalSpacing = 4;
		layout.verticalSpacing = 4;
		layout.marginBottom = 5;
		layout.marginTop = 5;

		parent.setLayout(layout);

		Device display = shell.getDisplay();
		Color green = display.getSystemColor(SWT.COLOR_GREEN);
		Color red = display.getSystemColor(SWT.COLOR_RED);
		//Color yellow = display.getSystemColor(SWT.COLOR_YELLOW);

		Label resultLabel = new Label(parent, SWT.NONE);
		resultLabel.setFont(new Font(display,"Tahoma", 14, SWT.BOLD));
		if(result != null){
			resultLabel.setText(result);
		}

		Table theTable = new Table (parent, SWT.BORDER | SWT.NO_SCROLL);
		theTable.setLinesVisible (true);
		theTable.setHeaderVisible (true);
		GridData data = new GridData(GridData.FILL, 
				GridData.BEGINNING, true, false, 1, 1);
		theTable.setLayoutData(data);
		String[] hwTitles = {"HW Instance", "Utilization", "Result", "Analysis Context"};
		for (int i = 0; i < hwTitles.length; i++) {
			TableColumn column = new TableColumn(theTable, SWT.NONE);
			column.setText(hwTitles[i]);
		}	

		for (HWAnalysisResultData hwResDataElem : resultHWData1) {
			String theHwUtilization = hwResDataElem.hw_utilization;
			String theHwUtilizationPerc = UMLUtils.getValue(theHwUtilization, "value");

			if (theHwUtilizationPerc!=null && theHwUtilizationPerc.length()>0) {
				TableItem hwItem = new TableItem(theTable, SWT.NONE);	
				int i = 0;

				String theHwInstance = hwResDataElem.hw_instance;
				hwItem.setText(i, theHwInstance);
				i++;

				theHwUtilizationPerc+="%";
				hwItem.setText(i, theHwUtilizationPerc);
				i++;

				String theHwResult = hwResDataElem.getResultString();
				if (theHwResult.equalsIgnoreCase("OK")) {
					hwItem.setForeground(i, green);
				}
				else {
					hwItem.setForeground(i, red);
				}
				hwItem.setText(i, theHwResult);
				i++;

				hwItem.setText(i, analysisContextName1+" (1)");
				i++;			
			}	
		}

		for (HWAnalysisResultData hwResDataElem : resultHWData2) {			
			String theHwUtilization = hwResDataElem.hw_utilization;
			String theHwUtilizationPerc = UMLUtils.getValue(theHwUtilization, "value");
			if (theHwUtilizationPerc!=null &&theHwUtilizationPerc.length()>0) {
				theHwUtilizationPerc+="%";
				TableItem hwItem = new TableItem(theTable, SWT.NONE);	
				int i = 0;

				String theHwInstance = hwResDataElem.hw_instance;
				//hwItem.setBackground(i, yellow);
				hwItem.setText(i, theHwInstance);
				i++;

				//hwItem.setBackground(i, yellow);
				hwItem.setText(i, theHwUtilizationPerc);
				i++;

				String theHwResult = hwResDataElem.getResultString();
				if (theHwResult.equalsIgnoreCase("OK")) {
					hwItem.setForeground(i, green);
				}
				else {
					hwItem.setForeground(i, red);
				}
				//hwItem.setBackground(i, yellow);
				hwItem.setText(i, theHwResult);
				i++;

				//hwItem.setBackground(i, yellow);
				hwItem.setText(i, analysisContextName2+" (2)");
				i++;			
			}		
		}

		for (int i = 0; i < hwTitles.length; i++) {
			theTable.getColumn(i).pack();
		}

		Table theSwTable = new Table (parent, SWT.MULTI | SWT.BORDER | SWT.H_SCROLL|SWT.V_SCROLL);
		theSwTable.setLinesVisible (true);
		theSwTable.setHeaderVisible (true);

		data = new GridData(GridData.FILL, 
				GridData.BEGINNING, true, false, 1, 1);

		theSwTable.setLayoutData(data);

		String[] swTitles = {"SW Instance", "Operation", "Resp. T. (1)", "Resp. T. (2)", "Block. T. (1) ", "Block. T. (2) ", "Sched. (1)", "Sched. (2)"};
		for (int i = 0; i < swTitles.length; i++) {
			TableColumn column = new TableColumn(theSwTable, SWT.NONE);
			if(i==2 || i==4 || i==6) {
				column.setToolTipText(analysisContextName1);
			}
			if (i==3 || i==5 || i==7) {
				column.setToolTipText(analysisContextName2);
			}
			column.setText(swTitles[i]);
		}
		

		for (AnalysisResultData resDataElem : resultData1) {
			int i = 0;
			String theSwInstance = resDataElem.instance;
			AnalysisResultData otherAnalysisResult = resultMap2.get(theSwInstance);
			TableItem item = new TableItem(theSwTable, SWT.NONE);			
			item.setText(i, theSwInstance);
			i++;		
			
			Operation theOperation = resDataElem.ctxOP;
			String theOperationName = theOperation.getName();
			item.setText(i, theOperationName);
			i++;
			
			String theRespTime = resDataElem.respT;
			item.setText(i, theRespTime);
			i++;

			String otherRespTime = otherAnalysisResult.respT;
			//item.setBackground(i, yellow);
			item.setText(i, otherRespTime);
			i++;
			
			String theBlockingTime = resDataElem.blockT;			
			item.setText(i, theBlockingTime);
			i++;

			String otherBlockingTime = otherAnalysisResult.blockT;		
			//item.setBackground(i, yellow);
			item.setText(i, otherBlockingTime);
			i++;
			
			String theResult = convertToOkNok(resDataElem.isSched);			
			if (theResult.equalsIgnoreCase("OK")) {
				item.setForeground(i, green);
			}
			else {
				item.setForeground(i, red);
			}
			item.setText(i, theResult);
			i++;
			
			String otherResult = convertToOkNok(otherAnalysisResult.isSched);			
			if (otherResult.equalsIgnoreCase("OK")) {
				item.setForeground(i, green);
			}
			else {
				item.setForeground(i, red);
			}
			item.setText(i, otherResult);
			i++;			
		}


		for (int i = 0; i < swTitles.length; i++) {
			theSwTable.getColumn(i).pack();
		}

		return super.createDialogArea(parent);

	}


	/**
	 * Convert schedulability results:
	 * "YES" -> "OK" 
	 * "NO"  -> "NOT OK"
	 * @param isSched
	 * @return
	 */
	private String convertToOkNok(String isSched) {
		String result ="NOT OK";
		if(isSched.equalsIgnoreCase("YES")) {
			result = "OK";
		}
		return result;
	}

	/**
	 * Configure shell for comparison of results with its title
	 */
	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText(title);
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	@Override
	protected void okPressed() {		
		super.close();
	}
}
