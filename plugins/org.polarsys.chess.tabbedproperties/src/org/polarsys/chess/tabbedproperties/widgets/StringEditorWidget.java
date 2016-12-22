/*------------------------------------------------------------------------------
 -
 - Copyright (c) 2013, 2015 Intecs SpA 
 - All rights reserved. This program and the accompanying materials
 - are made available under the terms of the Eclipse Public License v1.0
 - which accompanies this distribution, and is available at
 - http://www.eclipse.org/legal/epl-v10.html
 -
 - Contributors:
 - 
 - Stefano Puri stefano.puri@intecs.it
 -  
 - Initial API and implementation and/or initial documentation
 ------------------------------------------------------------------------------*/
package org.polarsys.chess.tabbedproperties.widgets;

import org.eclipse.papyrus.infra.properties.ui.modelelement.DataSource;
import org.eclipse.papyrus.infra.properties.ui.widgets.AbstractPropertyEditor;
import org.eclipse.papyrus.infra.widgets.editors.StringEditor;

import org.eclipse.swt.widgets.Composite;

public class StringEditorWidget extends AbstractPropertyEditor {

	public StringEditorWidget(Composite parent){
		
		super.setEditor(new StringEditor (parent, 0)); 
	}
	
	//@override 
	public void setInput(DataSource input) {
		super.setInput(input);
	};
	

	protected void checkInput() {
		// TODO Auto-generated method stub
		super.checkInput();
	}
	
}