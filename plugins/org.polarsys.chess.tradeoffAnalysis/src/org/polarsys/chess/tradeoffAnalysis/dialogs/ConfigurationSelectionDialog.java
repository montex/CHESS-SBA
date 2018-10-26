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
package org.polarsys.chess.tradeoffAnalysis.dialogs;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.InstantiatedArchitecture;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.PlatformUI;

/**
 * A dialog that permits to select the type of check to compare and the configurations
 * that should be considered.
 *
 * @author cristofo
 *
 */
public class ConfigurationSelectionDialog extends Dialog {
	public static String CHECK_CONTRACT_REFINEMENT = "Check Contract Refinement";
	private Combo checkType;
	private String selectedCheckType;
	private Table configurationsTable;
	private EList<InstantiatedArchitecture> selectedConfigurations;
	private Class rootComponent;
	private boolean goAhead;

	/**
	 * Constructor
	 * @param rootComponent the root component
	 */
	public ConfigurationSelectionDialog(Class rootComponent) {
		super(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
		setShellStyle(SWT.TITLE | SWT.RESIZE);

		this.rootComponent = rootComponent;
	}
	
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Trade-off Analysis");
	}

	@Override
	protected void okPressed() {
		selectedCheckType = checkType.getText();
		selectedConfigurations = new BasicEList<InstantiatedArchitecture>();

		final TableItem[] tableItems = configurationsTable.getItems();
		for(TableItem item : tableItems) {
			if(item.getChecked()) {
				final Property property = rootComponent.getOwnedAttribute(item.getText(), null);
				final Stereotype stereotype;
				if ((stereotype = property.getAppliedStereotype(EntityUtil.INSTANTIATED_ARCHITECTURE)) != null) {
					selectedConfigurations.add((InstantiatedArchitecture) property.getStereotypeApplication(stereotype));
				}
			}
		}
		goAhead = true;
		super.okPressed();
	}
	
	/**
	 * Looks for configurations that could be selected and populate the table.
	 * @param configurationsTable the table to be populated
	 * @param rootComponent the root component where to look for configurations
	 */
	private void populateConfigurationsTable(Table configurationsTable, Class rootComponent) {
		final EList<Property> properties = rootComponent.getOwnedAttributes();
		
		for (Property property : properties) {
			if (property.getAppliedStereotype(EntityUtil.INSTANTIATED_ARCHITECTURE) != null) {
				final TableItem item = new TableItem(configurationsTable, SWT.NONE);
				item.setText(property.getName());
			}
		}
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		parent.setToolTipText("");
		final Composite container = (Composite) super.createDialogArea(parent);

		final GridLayout gridLayout = new GridLayout(2, false);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.horizontalSpan = 2;
		final Composite validationContainer = new Composite(container, SWT.NONE);
		validationContainer.setLayout(gridLayout);		
		validationContainer.setLayoutData(gridData);	
		
		final Label labelCheckType = new Label(validationContainer, SWT.LEFT);
		labelCheckType.setText("Check Type");

		checkType = new Combo(validationContainer, SWT.READ_ONLY);
		checkType.add(CHECK_CONTRACT_REFINEMENT);
		checkType.select(0);

		final Label labelConfigurations = new Label(validationContainer, SWT.LEFT);
		labelConfigurations.setText("Available Configurations");

		gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.heightHint = 240;
		configurationsTable = new Table(validationContainer, SWT.CHECK | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		configurationsTable.setLayoutData(gridData);		
		populateConfigurationsTable(configurationsTable, rootComponent);
		configurationsTable.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				// Enable the OK button only if two or more items are selected
				int checked = 0;
				final TableItem[] tableItems = configurationsTable.getItems();
				for(TableItem item : tableItems) {
					if(item.getChecked()) {
						checked++;
					}
				}
				if (checked > 1) {
					getButton(IDialogConstants.OK_ID).setEnabled(true);
				} else {
					getButton(IDialogConstants.OK_ID).setEnabled(false);
				}
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		
		return container;
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
		
		// Start with the OK button disabled, it will be enabled only if two or mode configurations are selected
		getButton(IDialogConstants.OK_ID).setEnabled(false);
	}

	@Override
	protected Point getInitialSize() {
		return new Point(500, 400);
	}

	@Override
	protected void cancelPressed() {
		goAhead = false;
		super.cancelPressed();
	}

	/** Getter. */
	public boolean goAhead() {
		return goAhead;
	}

	/** Getter. */
	public EList<InstantiatedArchitecture> getConfigurations() {
		return selectedConfigurations;
	}

	/** Getter. */
	public String getCheckType() {
		return selectedCheckType;
	}	
}
