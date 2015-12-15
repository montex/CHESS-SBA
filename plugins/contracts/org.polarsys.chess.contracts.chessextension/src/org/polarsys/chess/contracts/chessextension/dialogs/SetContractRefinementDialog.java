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

package org.polarsys.chess.contracts.chessextension.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.polarsys.chess.contracts.chessextension.popup.actions.SetContractRefinement;
import org.polarsys.chess.contracts.profile.chesscontract.ComponentInstance;
import org.polarsys.chess.contracts.profile.chesscontract.ContractProperty;
import org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ContractTypes;

public class SetContractRefinementDialog extends Dialog {
	

	private List refineList;
	private Class ownerClass;
	
	private String[] selected;

	public SetContractRefinementDialog(Shell shell, Class ownerClass) {
		super(shell);
		this.ownerClass = ownerClass;
	}
	
	@Override
	protected Control createDialogArea(Composite parent) {
		GridLayout layout = new GridLayout(1, true);

		layout.horizontalSpacing = 4;
		layout.verticalSpacing = 4;
		layout.marginBottom = 5;
		layout.marginTop = 5;
	
		parent.setLayout(layout);
		new Label(parent, SWT.NONE).setText("Select Refinements:");
		
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		refineList = new List(parent, SWT.BORDER | SWT.MULTI| SWT.V_SCROLL);
		for (Property part : ownerClass.getParts()) {
			if(!(part instanceof Port)){
				Class partClass = (Class) part.getType();
				
				for (Property prop : partClass.getAttributes()) {
					
					if(prop.getAppliedStereotype(SetContractRefinement.CONTRACT_PROPERTY) != null){
						ContractProperty cp =(ContractProperty) prop.getStereotypeApplication(prop.getAppliedStereotype(SetContractRefinement.CONTRACT_PROPERTY));
						if (cp.getContractType().equals(ContractTypes.STRONG))
							refineList.add(part.getName() + "." + prop.getName());
						
					}
				}
				
				//check if the weak contract is selected for the part\instance
				if (part.getAppliedStereotype(SetContractRefinement.COMPONENT_INSTANCE) != null){
					ComponentInstance compInst = (ComponentInstance) part.getStereotypeApplication(part.getAppliedStereotype(SetContractRefinement.COMPONENT_INSTANCE));
						for (ContractProperty c:compInst.getWeakGuarantees()){
							refineList.add(part.getName() + "." + c.getBase_Property().getName());
						}
				}
				
			}
		}
	
		refineList.setLayoutData(gridData);
				
		return parent;	
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
	protected void okPressed() {
		setSelected(refineList.getSelection());
		super.okPressed();

	}

	public String[] getSelected() {
		return selected;
	}

	public void setSelected(String[] selected) {
		this.selected = selected;
	}
}
