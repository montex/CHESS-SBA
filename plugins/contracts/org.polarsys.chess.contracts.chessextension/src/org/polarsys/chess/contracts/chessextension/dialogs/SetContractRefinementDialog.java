/*******************************************************************************
 *
 * Copyright (c) 2013, 2015 Intecs SpA 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Nicholas Pacini nicholas.pacini@intecs.it 
 * Stefano Puri stefano.puri@intecs.it
 * Laura Baracchi  laura.baracchi@intecs.it  
 * Initial API and implementation and/or initial documentation
 * 
 * Alberto Debiasi adebiasi@fbk.eu: updated set contract refinement to select contracts associated to array of subcomponents
 *******************************************************************************/

package org.polarsys.chess.contracts.chessextension.dialogs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Property;
import org.polarsys.chess.contracts.chessextension.popup.actions.SetContractRefinement;
import org.polarsys.chess.contracts.profile.chesscontract.ComponentInstance;
import org.polarsys.chess.contracts.profile.chesscontract.ContractProperty;
import org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ContractTypes;
import org.polarsys.chess.contracts.profile.chesscontract.util.ContractEntityUtil;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;

import eu.fbk.eclipse.standardtools.utils.ui.utils.DialogUtil;

public class SetContractRefinementDialog extends Dialog {

	String RANGE_EXCEPTION = "The ranges of the indexes of subcomponents must be delimited with ','. The format of each range is 'lowerValue..upperValue'. For example: : 1..4,7..n";

	private Set<Integer> selectedContractRefinementIndexes = new HashSet<Integer>();
	private ArrayList<ContractRefinementObj> refineList = new ArrayList<SetContractRefinementDialog.ContractRefinementObj>();
	private Class ownerClass;

	private ArrayList<ContractRefinementObj> selectedContractRefinementObjs;
	private ArrayList<Text> rangeTexts = new ArrayList<Text>();

	Table table;
	TableColumn columnCheckBoxes;
	TableColumn columnContracts;
	TableColumn columnRanges;

	public SetContractRefinementDialog(Shell shell, Class ownerClass) {
		super(shell);
		this.ownerClass = ownerClass;
	}

	private void populateRefineList() throws Exception{
		refineList.clear();
		for (Property subComponentInstance : EntityUtil.getInstance().getSubComponentsInstances(ownerClass)) {

			String[] range = EntityUtil.getInstance().getAttributeMultiplicity(subComponentInstance);

			for (ContractProperty contractProperty : ContractEntityUtil.getInstance()
					.getContractProperties((Class) subComponentInstance.getType())) {

				if (!contractProperty.getContractType().equals(ContractTypes.STRONG))
					continue;
				refineList.add(new ContractRefinementObj(subComponentInstance.getName(),
						contractProperty.getBase_Property().getName(), range[0], range[1]));

			}

			// check if the weak contract is selected for the part\instance
			if (subComponentInstance.getAppliedStereotype(SetContractRefinement.COMPONENT_INSTANCE) != null) {
				ComponentInstance compInst = (ComponentInstance) subComponentInstance.getStereotypeApplication(
						subComponentInstance.getAppliedStereotype(SetContractRefinement.COMPONENT_INSTANCE));
				for (ContractProperty contractProperty : compInst.getWeakGuarantees()) {

					refineList.add(new ContractRefinementObj(subComponentInstance.getName(),
							contractProperty.getBase_Property().getName(), range[0], range[1]));
				}
			}
		}
		
		if(refineList.size()==0){			
				throw new Exception("No refining contracts available in the sub-components");			
		}
	}
	
	
	public void populateRefineListAndCreateDialog() throws Exception {		
			populateRefineList();
			super.create();						
	}

	@Override
	protected Control createDialogArea(Composite parent) {

		rangeTexts.clear();
	
		GridLayout layout = new GridLayout(1, true);

		layout.horizontalSpacing = 4;
		layout.verticalSpacing = 4;
		layout.marginBottom = 5;
		layout.marginTop = 5;

		parent.setLayout(layout);
		new Label(parent, SWT.NONE).setText("Select Refinements:");
	
		table = new Table(parent, SWT.BORDER);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		columnCheckBoxes = new TableColumn(table, SWT.NONE);
		columnContracts = new TableColumn(table, SWT.NONE);
		columnRanges = new TableColumn(table, SWT.NONE);
		int minWidth = 0;

		int index = 0;
		for (ContractRefinementObj contractRefinement : refineList) {

			Button checkButton = new Button(table, SWT.CHECK);

			checkButton.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent event) {
					Button btn = (Button) event.getSource();
					System.out.println(btn.getSelection());

					int selectedIndex = (Integer) (btn.getData());

					if (btn.getSelection()) {
						selectedContractRefinementIndexes.add(selectedIndex);
					} else {
						selectedContractRefinementIndexes.remove(selectedIndex);
					}
				}
			});

			checkButton.pack();
			checkButton.setData(index);
			index++;
			Point size = checkButton.computeSize(SWT.DEFAULT, SWT.DEFAULT);

			TableEditor editor = new TableEditor(table);
			editor.minimumWidth = size.x;
			minWidth = Math.max(size.x, minWidth);
			editor.minimumHeight = size.y;
			editor.horizontalAlignment = SWT.LEFT;
			editor.verticalAlignment = SWT.CENTER;

			String rangeStr = "";

			if (contractRefinement.getLower() != null && contractRefinement.getUpper() != null) {
				rangeStr = "[" + contractRefinement.getLower() + ".." + contractRefinement.getUpper() + "]";
			}

			TableItem contractName = new TableItem(table, SWT.NONE);
			contractName.setText(1,
					contractRefinement.getSubComponentName() + rangeStr + "." + contractRefinement.getContractName());

			editor.setEditor(checkButton, contractName, 0);

			editor = new TableEditor(table);
			editor.minimumHeight = size.y;
			editor.minimumWidth = 50;
			editor.horizontalAlignment = SWT.LEFT;
			editor.verticalAlignment = SWT.CENTER;

			Text relectedRange = new Text(table, SWT.LEFT);
			rangeTexts.add(relectedRange);
			if (contractRefinement.getLower() != null && contractRefinement.getUpper() != null) {
				relectedRange.setText(contractRefinement.getLower() + ".." + contractRefinement.getUpper());
			} else {
				relectedRange.setEnabled(false);
			}
			editor.setEditor(relectedRange, contractName, 2);

		}
		columnCheckBoxes.pack();
		columnContracts.setText("contract");
		columnContracts.pack();
		columnContracts.setWidth(columnContracts.getWidth() + minWidth);
		columnRanges.setText("range");
		columnRanges.pack();
		columnRanges.setWidth(columnRanges.getWidth() + minWidth);

		return parent;
	}

	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("Set Contract Refinement");
	}

	@Override
	protected boolean isResizable() {
		return false;
	}

	@Override
	protected void okPressed() {

		selectedContractRefinementObjs = new ArrayList<ContractRefinementObj>();

		for (int selIndex : selectedContractRefinementIndexes) {

			Text text = rangeTexts.get(selIndex);
			if (text.isEnabled()) {
				ContractRefinementObj contractRefinementObj = refineList.get(selIndex);
				String[][] ranges = null;
				try {
					ranges = extractRanges(text.getText());
				} catch (Exception e) {
					e.printStackTrace();
					DialogUtil.getInstance().showMessage_ExceptionError(e);
				}
				for (String[] range : ranges) {
					ContractRefinementObj newContractRefinementObj = new ContractRefinementObj(
							contractRefinementObj.getSubComponentName(), contractRefinementObj.getContractName(),
							range[0], range[1]);
					selectedContractRefinementObjs.add(newContractRefinementObj);
				}
			} else {
				selectedContractRefinementObjs.add(refineList.get(selIndex));
			}

		}

			super.okPressed();
	}

	private String[][] extractRanges(String text) throws Exception {

		if (text == "") {
			throw new Exception(RANGE_EXCEPTION);
		}

		String[] ranges = text.split(",");

		String[][] res = new String[ranges.length][2];

		for (int i = 0; i < ranges.length; i++) {
			System.out.println("ranges[" + i + "]= " + ranges[i]);
			String[] uppLowRange = ranges[i].split("\\.\\.");
			if (uppLowRange.length != 2) {
				throw new Exception(RANGE_EXCEPTION);
			}
		
			res[i][0] = uppLowRange[0];
			res[i][1] = uppLowRange[1];
		}
		return res;
	}

	public ArrayList<ContractRefinementObj> getSelected() {
		return selectedContractRefinementObjs;
	}



	public class ContractRefinementObj {
		String subComponentName;
		String contractName;
		String lower;
		String upper;

		public ContractRefinementObj(String subComponentName, String contractName, String lower, String upper) {
			super();
			this.subComponentName = subComponentName;
			this.contractName = contractName;
			this.lower = lower;
			this.upper = upper;
		}

		public String getSubComponentName() {
			return subComponentName;
		}

		public String getContractName() {
			return contractName;
		}

		public String getLower() {
			return lower;
		}

		public String getUpper() {
			return upper;
		}

		public String getID() {
			String optRange = "";
			if ((lower != null) && (upper != null)) {
				optRange = lower + "_" + upper + ".";
			}
			return subComponentName + "." + optRange + contractName;
		}

	}
}
