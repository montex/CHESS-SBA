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

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
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
import org.polarsys.chess.contracts.profile.chesscontract.ContractRefinement;
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
	private EList<ContractRefinement> refinedByList;

	Table table;
	Label tableLabel;
	TableColumn columnCheckBoxes;
	TableColumn columnContracts;
	TableColumn columnRanges;
	Composite composite;

	public SetContractRefinementDialog(Shell shell, Class ownerClass, EList<ContractRefinement> refineList) {
		super(shell);
		this.ownerClass = ownerClass;
		this.refinedByList = refineList;
	}

	private void populateRefineList() throws Exception {
		refineList.clear();
		for (Property subComponentInstance : EntityUtil.getInstance().getSubComponentsInstances(ownerClass)) {

			String[] range = EntityUtil.getInstance().getAttributeMultiplicity(subComponentInstance);

			if ((range[0] != null) && (range[1] != null) && (range[0].compareTo(range[1]) != 0)) {
				throw new Exception("The multiplicity of the subcomponent " + subComponentInstance.getName()
						+ " should not be a range. Please set a unique value for the upper and lower ranges.");
			}

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

		if (refineList.size() == 0) {
			throw new Exception("No refining contracts available in the sub-components");
		}
	}

	public void populateRefineListAndCreateDialog() throws Exception {
		populateRefineList();
		super.create();
		composite.redraw();
	}

	@Override
	protected Control createDialogArea(Composite parent) {

		composite = parent;
		rangeTexts.clear();

		GridLayout layout = new GridLayout(1, true);

		parent.setLayout(layout);
		
		tableLabel = new Label(parent, SWT.NONE);
		tableLabel.setText("Select Refinements:");
		tableLabel.setLayoutData(new GridData(SWT.FILL, SWT.NONE, true, false));

		table = new Table(parent, SWT.NO_SCROLL | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		columnCheckBoxes = new TableColumn(table, SWT.FILL);
		columnContracts = new TableColumn(table, SWT.FILL);
		columnRanges = new TableColumn(table, SWT.FILL);

		final int minCheckSize = 26;
		final int minRangeSize = 60;

		int index = 0;
		for (ContractRefinementObj contractRefinement : refineList) {

			Button checkButton = new Button(table, SWT.CHECK);

			checkButton.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent event) {
					Button btn = (Button) event.getSource();

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

			String rangeStr = contractRefinement.getRangeStr(true);

			TableItem contractName = new TableItem(table, SWT.NONE);
			contractName.setText(1,
					contractRefinement.getSubComponentName() + rangeStr + "." + contractRefinement.getContractName());

			TableEditor editor = new TableEditor(table);
			editor.horizontalAlignment = SWT.CENTER;
			editor.grabHorizontal = true;
			editor.grabVertical = true;
			editor.setEditor(checkButton, contractName, 0);

			Text selectedRange = new Text(table, SWT.LEFT);
			rangeTexts.add(selectedRange);
			updateGUIExistingRefiningContracts(checkButton, contractRefinement, selectedRange);

			if (contractRefinement.getLower() != null && contractRefinement.getUpper() != null) {
				if (selectedRange.getText().compareTo("") == 0) {
					String rangeStrToEdit = contractRefinement.getRangeStr(false);
					selectedRange.setText(rangeStrToEdit);
				}
			} else {
				selectedRange.setEnabled(false);
			}

			editor = new TableEditor(table);
			editor.minimumWidth = 100;
			editor.horizontalAlignment = SWT.LEFT;
			editor.grabHorizontal = true;
			editor.grabVertical = true;
			editor.setEditor(selectedRange, contractName, 2);

		}
		
		columnCheckBoxes.pack();
		columnCheckBoxes.setWidth(Math.max(columnCheckBoxes.getWidth(), minCheckSize));
		columnContracts.setText("contract");
		columnContracts.pack();
		columnRanges.setText("range");
		columnRanges.pack();
		columnRanges.setWidth(Math.max(columnRanges.getWidth(), minRangeSize));

		final float columnRatio = (float) columnContracts.getWidth() / columnRanges.getWidth();
		
		composite.addControlListener(new ControlAdapter() {
			public void controlResized(ControlEvent e) {
				refreshTableSize(columnRatio);
			}
		});
		
		GridData tableGridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		tableGridData.heightHint = table.getItemHeight() * (table.getItemCount() + 1) + 10;
		table.setLayoutData(tableGridData);
		composite.redraw();

		return parent;
	}

	private void refreshTableSize(float columnRatio){
		org.eclipse.swt.graphics.Rectangle area = composite.getClientArea();

		if (area.width != table.getSize().x) {
			columnRanges.setWidth(Math.round((area.width - columnCheckBoxes.getWidth()) / (columnRatio + 1)));
			columnContracts.setWidth(area.width - columnCheckBoxes.getWidth() - columnRanges.getWidth());
		}
	}
	
	private void updateGUIExistingRefiningContracts(Button checkButton, ContractRefinementObj contractRefinement,
			Text selectedRange) {

		for (ContractRefinement contractRef : refinedByList) {

			if ((contractRef.getInstance().getName().compareTo(contractRefinement.getSubComponentName()) == 0)
					&& (contractRef.getContract().getBase_Property().getName()
							.compareTo(contractRefinement.getContractName()) == 0)) {
				checkButton.setSelection(true);
				int selectedIndex = (Integer) (checkButton.getData());
				selectedContractRefinementIndexes.add(selectedIndex);

				if (contractRefinement.getLower() != null && contractRefinement.getUpper() != null) {
					if (selectedRange.getText().compareTo("") != 0) {
						selectedRange.setText(selectedRange.getText() + ",");
					}
					selectedRange.setText(selectedRange.getText() + contractRef.getLowerIndexOfInstance() + ".."
							+ contractRef.getUpperIndexOfInstance());
				}
			}
		}
	}

	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("Set Contract Refinement");
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	@Override
	protected Control createButtonBar(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		// create a layout with spacing and margins appropriate for the font
		// size.
		GridLayout layout = new GridLayout();
		layout.numColumns = 0; // this is incremented by createButton
		layout.makeColumnsEqualWidth = true;
		layout.marginWidth = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
		layout.marginHeight = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_MARGIN);
		layout.horizontalSpacing = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_SPACING);
		layout.verticalSpacing = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_SPACING);
		composite.setLayout(layout);
		GridData data = new GridData(SWT.END,SWT.END,true,false);
		composite.setLayoutData(data);
		composite.setFont(parent.getFont());

		// Add the buttons to the button bar.
		createButtonsForButtonBar(composite);
		return composite;
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

		public String getRangeStr(boolean withBrackets) {
			String res;
			if (getLower() != null && getUpper() != null) {
				if (getUpper().compareTo(getLower()) == 0) {
					res = 1 + ".." + getUpper();
				} else {
					res = getLower() + ".." + getUpper();
				}

				if (withBrackets) {
					return "[" + res + "]";
				} else {
					return res;
				}

			}

			return "";
		}

	}
}
