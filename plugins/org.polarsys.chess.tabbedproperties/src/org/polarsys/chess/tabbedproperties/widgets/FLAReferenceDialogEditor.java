/*------------------------------------------------------------------------------
 -
 - Copyright (c) 2017 Intecs SpA 
 - All rights reserved. This program and the accompanying materials
 - are made available under the terms of the Eclipse Public License v1.0
 - which accompanies this distribution, and is available at
 - http://www.eclipse.org/legal/epl-v10.html
 -
 - Contributors:
 - 
 - Stefano Puri stefano.puri@intecs.it
 -  
 - Initial API and implementation
 ------------------------------------------------------------------------------*/
package org.polarsys.chess.tabbedproperties.widgets;


import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.widgets.editors.ReferenceDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

import org.polarsys.chess.tabbedproperties.xtext.XtextInputDialog;
import org.polarsys.chess.xtext.global.utils.XtextUtils;

public class FLAReferenceDialogEditor extends ReferenceDialog {

	private Shell shell;
	private XtextInputDialog xtextDialog;

	public FLAReferenceDialogEditor(Composite parent, int style) {
		super(parent, style);
		shell = parent.getShell();
	}
	
	
	@Override
	protected void editAction() {
		//System.out.println(modelProperty.getValue());
		
		setContext(); 
		if(getValue() != null){
			xtextDialog = new XtextInputDialog(shell, "Edit FLA Expression", null, getValue().toString(), null);
		}else{
			xtextDialog = new XtextInputDialog(shell, "Edit FLA Expression", null, null, null);
		}

		int result = xtextDialog.open();
		if (result == Window.OK) {
			String newValue = xtextDialog.getValue();
			if (newValue == null) {
				return;
			}
			setValue(newValue);
		}
	}
	

	public void updateControls() {
		setExclusion(browseValuesButton, true);
		setExclusion(editInstanceButton, false);
		setExclusion(createInstanceButton, true);
		setExclusion(unsetButton, true);
	}

	/**
	 * This method is used in order to get the Stereotype whose property we are editing
	 */
	
	private void setContext() {
		XtextUtils.setContextElement(this.getContextElement());
	}
	
}
