/*******************************************************************************
 *                  CHESS core plugin
 *
 *               Copyright (C) 2011-2015
 *            Mälardalen University, Sweden
 *
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License
 *  v1.0 which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.polarsys.chess.fla.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import org.polarsys.chess.fla.launch.Activator;

public class ConcertoFlaPreferencePage extends FieldEditorPreferencePage
		implements IWorkbenchPreferencePage {
	
	public ConcertoFlaPreferencePage(){
		super(GRID);
	}

	@Override
	public void init(IWorkbench workbench) {
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Concerto-FLA: Failure Logic Analysis");
	}

	@Override
	protected void createFieldEditors() {
		
		addField(new BooleanFieldEditor(FlaParameters.INIT_NO_FAILURE, 
				"Initialize all connections to noFailure (needed for circular dependencies).",
				getFieldEditorParent()));
		Label initLabel = createDescriptionLabel(getFieldEditorParent());
		initLabel.setText("This will add the noFailure token to all input ports before performing the FLA analysis.\n");
		
		addField(new BooleanFieldEditor(FlaParameters.PROPAGATE_UNMATCHED_FAILURES, 
				"Propagate unmatches failures to all output ports.",
				getFieldEditorParent()));
		Label unmatchedLabel = createDescriptionLabel(getFieldEditorParent());
		unmatchedLabel.setText("In case a propagation rule does not include an incoming failure type, \nthis failure type is propagated as-is to all output ports of the component.\n");
		
		addField(new BooleanFieldEditor(FlaParameters.TREAT_UNMENTIONED_PORTS_AS_WILDCARDS, 
				"Treat ports not mentioned by rules as specified wild wildcards.",
				getFieldEditorParent()));
		Label unmentionedPortLabel = createDescriptionLabel(getFieldEditorParent());
		unmentionedPortLabel.setText("If a transformation rule is missing information about an input port, \nthis is treated as if the rule had specified the input port with wildcard.\n" +
				"If the rule does not mention inputPort1, inputPort1.wildcard is silently added to the rule.");
	}
}