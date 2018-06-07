/*******************************************************************************
 * Copyright (C) 2018 Fondazione Bruno Kessler.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *     Luca Cristoforetti - initial API and implementation
 *     Pietro Braghieri - original code
 ******************************************************************************/
package org.polarsys.chess.diagramsCreator.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;

/**
 * This class dispays a dialog to set some parameters for the BDD creation.
 * No more used since CSS.
 * @author cristofo
 *
 */
public class BDDCreatorDialog extends Dialog {
	private static final String TITLE = "BDD diagram parameters";
	
	private Button btnShowStereotypes;
	private boolean showStereotypes;
	
	private Button btnShowAssociationsNames;
	private boolean showAssociationsNames;
	
	private Button btnShowSourceMultiplicity;
	private boolean showSourceMultiplicity;
	
	private Button btnShowTargetMultiplicity;
	private boolean showTargetMultiplicity;
	
	private Button btnShowSourceRole;
	private boolean showSourceRole;
	
	private Button btnShowTargetRole;
	private boolean showTargetRole;

	private Combo combo;
	private boolean rectilinearRouting;
	
	private boolean goAhead = false;

	/**
	 * Creates the dialog.
	 * @param parentShell the parent shell
	 * @param blocking indicates if the dialog should be modal
	 */
	public BDDCreatorDialog(Shell parentShell, boolean blocking) {
		super(parentShell);
		setShellStyle(SWT.TITLE);
//		setShellStyle(SWT.CLOSE | SWT.MODELESS| SWT.BORDER | SWT.TITLE);
	    setBlockOnOpen(blocking);
	    
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText(TITLE);
	}

	@Override
	protected void okPressed() {
		showStereotypes = btnShowStereotypes.getSelection();
		showAssociationsNames = btnShowAssociationsNames.getSelection();
		showSourceRole = btnShowSourceRole.getSelection();
		showSourceMultiplicity = btnShowSourceMultiplicity.getSelection();
		showTargetRole = btnShowTargetRole.getSelection();
		showTargetMultiplicity = btnShowTargetMultiplicity.getSelection();
		rectilinearRouting = (combo.getSelectionIndex() == 0); 
		goAhead = true;

		super.okPressed();
	}
	/**
	 * Creates contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		parent.setToolTipText("");
		Composite container = (Composite) super.createDialogArea(parent);
		GridLayout gridLayout = (GridLayout) container.getLayout();
		gridLayout.numColumns = 2;
		gridLayout.makeColumnsEqualWidth = true;

		btnShowStereotypes = new Button(container, SWT.CHECK);
		btnShowStereotypes.setSelection(false);
		btnShowStereotypes.setAlignment(SWT.RIGHT);
		btnShowStereotypes.setText("Show stereotypes labels");

		btnShowAssociationsNames = new Button(container, SWT.CHECK);
		btnShowAssociationsNames.setSelection(false);
		btnShowAssociationsNames.setAlignment(SWT.RIGHT);
		btnShowAssociationsNames.setText("Show associations names");
		
		btnShowSourceRole = new Button(container, SWT.CHECK);
		btnShowSourceRole.setSelection(false);
		btnShowSourceRole.setAlignment(SWT.RIGHT);
		btnShowSourceRole.setText("Show source role");
		
		btnShowSourceMultiplicity = new Button(container, SWT.CHECK);
		btnShowSourceMultiplicity.setSelection(false);
		btnShowSourceMultiplicity.setAlignment(SWT.RIGHT);
		btnShowSourceMultiplicity.setText("Show source multiplicity");
		
		btnShowTargetRole = new Button(container, SWT.CHECK);
		btnShowTargetRole.setSelection(false);
		btnShowTargetRole.setAlignment(SWT.RIGHT);
		btnShowTargetRole.setText("Show target role");
		
		btnShowTargetMultiplicity = new Button(container, SWT.CHECK);
		btnShowTargetMultiplicity.setSelection(false);
		btnShowTargetMultiplicity.setAlignment(SWT.RIGHT);
		btnShowTargetMultiplicity.setText("Show target multiplicity");
		
		final Label selectRoutingStyle = new Label(container, SWT.RIGHT);
		selectRoutingStyle.setText("Select routing style:");
		
	    combo = new Combo(container, SWT.DROP_DOWN | SWT.READ_ONLY);
	    combo.setItems(new String [] {"Rectilinear", "Oblique"});
	    combo.select(0);

	    return container;
	}

	/**
	 * Creates contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, true);
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
	}

	/**
	 * Returns the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(435, 230);
	}

	/**
	 * Returns true if the user pressed the OK button.
	 * @return
	 */
	public boolean goAhead() {
		return goAhead;
	}

	public boolean getShowAssociationsNames() {
		return showAssociationsNames;
	}
	
	public boolean getShowStereotypes() {
		return showStereotypes;
	}

	public boolean getShowSourceRole() {
		return showSourceRole;
	}
	
	public boolean getShowSourceMultiplicity() {
		return showSourceMultiplicity;
	}
	
	public boolean getShowTargetRole() {
		return showTargetRole;
	}
	
	public boolean getShowTargetMultiplicity() {
		return showTargetMultiplicity;
	}

	public boolean getRectilinearRouting() {
		return rectilinearRouting;
	}
}
