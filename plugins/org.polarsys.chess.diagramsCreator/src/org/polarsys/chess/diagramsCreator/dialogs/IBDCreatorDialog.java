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
 * This class dispays a dialog to set some parameters for the IBD creation.
 * @author cristofo
 *
 */
public class IBDCreatorDialog extends Dialog {
	private Button btnPortLexicographicallyOrder;
	private boolean portLexicographicallyOrder;

	private Button btnShowFlowPorts;
	private boolean showFlowPorts;
	
	private Button btnShowStereotypes;
	private boolean showStereotypes;
	
	private Button btnShowConnectorNames;
	private boolean showConnectorNames;
	
	private Combo combo;
	private boolean rectilinearRouting;
	
	private boolean goAhead = false;

	/**
	 * Creates the dialog.
	 * @param parentShell the parent shell
	 * @param blocking indicates if the dialog should be modal
	 */
	public IBDCreatorDialog(Shell parentShell, boolean blocking) {
		super(parentShell);
		setShellStyle(SWT.TITLE);
//		setShellStyle(SWT.CLOSE | SWT.MODELESS| SWT.BORDER | SWT.TITLE);
	    setBlockOnOpen(blocking);
	    
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("IBD diagram parameters");
	}

	@Override
	protected void okPressed() {
		portLexicographicallyOrder = btnPortLexicographicallyOrder.getSelection();
		showFlowPorts = btnShowFlowPorts.getSelection();
		showStereotypes = btnShowStereotypes.getSelection();
		showConnectorNames = btnShowConnectorNames.getSelection();
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

		btnPortLexicographicallyOrder = new Button(container, SWT.CHECK);
		btnPortLexicographicallyOrder.setSelection(false);
		btnPortLexicographicallyOrder.setAlignment(SWT.RIGHT);
		btnPortLexicographicallyOrder.setText("Alphabetical port name ordering");

		btnShowFlowPorts = new Button(container, SWT.CHECK);
		btnShowFlowPorts.setSelection(false);
		btnShowFlowPorts.setAlignment(SWT.RIGHT);
		btnShowFlowPorts.setText("Show <<FlowPort>> labels");

		btnShowStereotypes = new Button(container, SWT.CHECK);
		btnShowStereotypes.setSelection(false);
		btnShowStereotypes.setAlignment(SWT.RIGHT);
		btnShowStereotypes.setText("Show stereotypes labels");

		btnShowConnectorNames = new Button(container, SWT.CHECK);
		btnShowConnectorNames.setSelection(false);
		btnShowConnectorNames.setAlignment(SWT.RIGHT);
		btnShowConnectorNames.setText("Show connectors names");
		
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
		return new Point(500, 230);
	}

	/**
	 * Returns true if the user pressed the OK button.
	 * @return
	 */
	public boolean goAhead() {
		return goAhead;
	}

	public boolean getPortLexicographicallyOrder() {
		return portLexicographicallyOrder;
	}
	
	public boolean getShowConnectors() {
		return showConnectorNames;
	}
	
	public boolean getShowFlowPorts() {
		return showFlowPorts;
	}

	public boolean getShowStereotypes() {
		return showStereotypes;
	}
	
	public boolean getRectilinearRouting() {
		return rectilinearRouting;
	}
}
