package org.chess.statebased.preferences;

import org.chess.statebased.Activator;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

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
		
		addField(new FileFieldEditor("PARAMFILE", "[Parametric] Parameters File",
				getFieldEditorParent()));
			
		IntegerFieldEditor ife = new IntegerFieldEditor("EXECPERIOD", "[Parametric] Interval (seconds)", getFieldEditorParent());
		ife.setValidRange(0, Integer.MAX_VALUE);
		addField(ife);
		
		BooleanFieldEditor bfe = new BooleanFieldEditor("RUNONCE", "[Parametric] Single Run", 
				getFieldEditorParent());
		bfe.fillIntoGrid(getFieldEditorParent(), 2);
		addField(bfe);
	}

}
