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

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StateMachine;

public class SelectImplementationDialog extends Dialog {

	private List blockList;
	private Class startingSystem;
	private String block;
	private java.util.List<Class> leafsList;

	public SelectImplementationDialog(Shell parentShell, Class sysClass) {
		super(parentShell);
		this.startingSystem = sysClass;
	}
	
	@Override
	protected Control createDialogArea(Composite parent) {
		
		GridLayout layout = new GridLayout(1, true);

		layout.horizontalSpacing = 4;
		layout.verticalSpacing = 4;
		layout.marginBottom = 5;
		layout.marginTop = 5;
	
		parent.setLayout(layout);
			
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		blockList = new List(parent, SWT.BORDER | SWT.V_SCROLL);
		leafsList = getLeafs(startingSystem, new ArrayList<Class>());
		for(Class leaf : leafsList){
			blockList.add(leaf.getQualifiedName());
		}		
		blockList.setLayoutData(gridData);
		
		new Label(parent, SWT.NONE).setText("");
		
		return parent;
		
	}
	
	private java.util.List<Class> getLeafs(Class block, java.util.List<Class> result) {
		java.util.List<Class> children = getChildren(block);
		if( children.size() > 0){
			for (Class cl : children) {
				getLeafs(cl, result);
			}
		}else{ //a leaf
			boolean test = false;
			for (Behavior behavior : block.getOwnedBehaviors()) {
				if(behavior instanceof StateMachine){
					test = true;
				}
			}
			if(test){
				result.add(block);
			}
		}
		return result;
	}


	private java.util.List<Class> getChildren(Class block) {
		java.util.List<Class> result = new ArrayList<Class>();
		for (Element elem : block.allOwnedElements()){
			if(elem instanceof Property && !(elem instanceof Port)){
				Property prop = (Property) elem;
				if(prop.getAggregation().toString().equals("composite")){
					Class cl = (Class) prop.getType();
					if(!result.contains(cl)){
						result.add(cl);
					}
				}
			}

		}
		return result;
	}

	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("Select the Block or Component to be Analyzed");
	}

	@Override
	protected boolean isResizable() {
		return true;
	}
	
	@Override
	protected void okPressed() {
		if(blockList.getSelectionCount() == 1){
			setBlock(blockList.getSelection()[0]);
		}
		super.okPressed();
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

}
