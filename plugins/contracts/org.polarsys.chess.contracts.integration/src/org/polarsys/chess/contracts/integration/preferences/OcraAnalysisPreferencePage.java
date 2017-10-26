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

package org.polarsys.chess.contracts.integration.preferences;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.polarsys.chess.contracts.integration.Activator;

public class OcraAnalysisPreferencePage extends FieldEditorPreferencePage 
	implements IWorkbenchPreferencePage{
	
	public static final String OCRA_PATH = "OCRA_PATH";

	public OcraAnalysisPreferencePage() {
		super(GRID);
	}

	@Override
	protected void createFieldEditors() {
		FileFieldEditor ocraPathFileEditor = new FileFieldEditor(OCRA_PATH, "OCRA executable path:",
		true, getFieldEditorParent());	
		addField(ocraPathFileEditor);
	}

	public void init(IWorkbench workbench) {
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Preferences page for Ocra Analysis Tool");
	}

}
