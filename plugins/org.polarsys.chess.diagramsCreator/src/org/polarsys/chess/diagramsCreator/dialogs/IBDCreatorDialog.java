/*******************************************************************************
 * Copyright (c) 2013-2015 Fondazione Bruno Kessler
 *   
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *   
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 *  
 *******************************************************************************/
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

public class IBDCreatorDialog extends Dialog
{
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
	 * @param parentShell
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
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		parent.setToolTipText("");
		Composite container = (Composite) super.createDialogArea(parent);
		GridLayout gridLayout = (GridLayout) container.getLayout();
		gridLayout.numColumns = 1;

		btnPortLexicographicallyOrder = new Button(container, SWT.CHECK);
		btnPortLexicographicallyOrder.setSelection(false);
		btnPortLexicographicallyOrder.setAlignment(SWT.RIGHT);
		btnPortLexicographicallyOrder.setText("Lexicographically port name ordering");

		btnShowFlowPorts = new Button(container, SWT.CHECK);
		btnShowFlowPorts.setSelection(false);
		btnShowFlowPorts.setAlignment(SWT.RIGHT);
		btnShowFlowPorts.setText("Show <<FlowPort>> label");

		btnShowStereotypes = new Button(container, SWT.CHECK);
		btnShowStereotypes.setSelection(false);
		btnShowStereotypes.setAlignment(SWT.RIGHT);
		btnShowStereotypes.setText("Show stereotypes label");

		btnShowConnectorNames = new Button(container, SWT.CHECK);
		btnShowConnectorNames.setSelection(false);
		btnShowConnectorNames.setAlignment(SWT.RIGHT);
		btnShowConnectorNames.setText("Show connectors names");
		
		final Label selectRoutingStyle = new Label(container, SWT.RIGHT);
		selectRoutingStyle.setText("Select routing style");
		
	    combo = new Combo(parent, SWT.DROP_DOWN | SWT.READ_ONLY);
	    combo.setItems(new String [] {"Rectilinear", "Oblique"});
	    combo.select(0);

	    return container;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(363, 300);
	}

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
