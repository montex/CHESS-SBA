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
 *******************************************************************************/

package org.polarsys.chess.contracts.transformations.dialogs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Class;

public class SelectSystemDialog extends Dialog {

	private static final String SYSTEM = "CHESSContract::System";
	private Combo chooseSystemField;
	private Model model;
	private String system;
	
	public SelectSystemDialog(Shell shell, Model model) {
		super(shell);
		this.model = model;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		GridLayout layout = new GridLayout(2, false);

		layout.horizontalSpacing = 4;
		layout.verticalSpacing = 4;
		layout.marginBottom = 5;
		layout.marginTop = 5;
	
		parent.setLayout(layout);
		new Label(parent, SWT.NONE).setText("Systems found in model:");
		
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		chooseSystemField = new Combo(parent, SWT.DROP_DOWN | SWT.READ_ONLY);
		for(Class sys : getSystems(model)){
			chooseSystemField.add(sys.getQualifiedName());
		}
		chooseSystemField.setLayoutData(gridData);
		
		new Label(parent, SWT.NONE).setText("");
		
		return parent;	
	}
	
	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("Select System to analyze");
	}

	@Override
	protected boolean isResizable() {
		return true;
	}
	
	@Override
	protected void okPressed() {
		setSystem(chooseSystemField.getText());
		super.okPressed();
	}
	
	public void setSystem(String qname) {
		this.system = qname;
	}

	public String getSystem() {
		return system;
	}
	
	private List<Class> getSystems(Model model){
		List<Class> result = new ArrayList<Class>();
		for (Element elem : model.allOwnedElements()){
			if(elem.getAppliedStereotype(SYSTEM) != null){
				result.add((Class) elem);
			}
		}
		return result ;
	}

}
