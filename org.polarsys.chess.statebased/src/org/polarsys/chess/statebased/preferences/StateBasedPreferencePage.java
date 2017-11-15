/*
-----------------------------------------------------------------------
-- Copyright (C) 2011-2016                                           --
-- University of Firenze, Italy	                                     --
-- Intecs S.p.A., Italy                                              --
--                                                                   --
-- All rights reserved. This program and the accompanying materials  --
-- are made available under the terms of the Eclipse Public License  --
-- v1.0 which accompanies this distribution, and is available at     --
-- http://www.eclipse.org/legal/epl-v10.html                         --
--                                                                   --
-- Contributors:                                                     --
-- Leonardo Montecchi 	lmontecchi@unifi.it                          --
-- Nicholas Pacini		nicholas.pacini@intecs.it                    --
-----------------------------------------------------------------------
*/

package org.polarsys.chess.statebased.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.polarsys.chess.statebased.Activator;

public class StateBasedPreferencePage extends FieldEditorPreferencePage
		implements IWorkbenchPreferencePage {
	
	public StateBasedPreferencePage(){
		super(GRID);
	}

	@Override
	public void init(IWorkbench workbench) {
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Preferences page for State Based Analysis");
	}

	@Override
	protected void createFieldEditors() {

		addField(new StringFieldEditor("HOST", "DEEM Server Host (hostname or IP address)",
				getFieldEditorParent()));
		addField(new StringFieldEditor("PORT", "DEEM Server Port",
				getFieldEditorParent()));
		addField(new StringFieldEditor("TIMEOUT", "Connection timeout (seconds)",
				getFieldEditorParent()));
		addField(new IntegerFieldEditor("MINBATCHES", "Minimum Batches",
				getFieldEditorParent()));
		addField(new IntegerFieldEditor("MAXBATCHES", "Maximum Batches", 
				getFieldEditorParent()));
		addField(new StringFieldEditor("CONFINTERVAL", "Confidence Interval (Relative)", 
				getFieldEditorParent()));
		addField(new StringFieldEditor("CONFLEVEL", "Confidence Level", 
				getFieldEditorParent()));
		addField(new IntegerFieldEditor("DISPUPDATE", "Display Update Interval", 
				getFieldEditorParent()));
		addField(new IntegerFieldEditor("MEASUPDATE", "Measure Update Interval", 
				getFieldEditorParent()));
		addField(new IntegerFieldEditor("SEED", "Simulation Seed", 
				getFieldEditorParent()));
		
		FileFieldEditor ffe = new FileFieldEditor("PARAMFILE", "Parametric: Parameters File", getFieldEditorParent());
		ffe.setEmptyStringAllowed(true);
		addField(ffe);
		
		ffe = new FileFieldEditor("RESULTFILE", "Parametric: Results File", getFieldEditorParent());
		ffe.setEmptyStringAllowed(true);
		addField(ffe);
			
		IntegerFieldEditor ife = new IntegerFieldEditor("EXECPERIOD", "Parametric: Interval (seconds)", getFieldEditorParent());
		ife.setValidRange(0, Integer.MAX_VALUE);
		addField(ife);
		
		BooleanFieldEditor bfe = new BooleanFieldEditor("RUNPERIODIC", "Parametric: Periodic Runs", 
				getFieldEditorParent());
		bfe.fillIntoGrid(getFieldEditorParent(), 2);
		addField(bfe);
	}

}
