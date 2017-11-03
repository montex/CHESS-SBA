/*------------------------------------------------------------------------------
 -
 - Copyright (c) 2013, 2017 Intecs SpA 
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


import org.eclipse.papyrus.infra.properties.ui.widgets.ReferenceDialog;
import org.eclipse.swt.widgets.Composite;

public class FLAReferenceDialog extends ReferenceDialog {

	public FLAReferenceDialog(Composite parent, int style) {
		super(parent, style);
	}

	
	protected org.eclipse.papyrus.infra.widgets.editors.ReferenceDialog createReferenceDialog(Composite parent, int style) {
		return new FLAReferenceDialogEditor(parent, style);
		
	}
	
}
