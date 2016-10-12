/*
-----------------------------------------------------------------------
--          			CHESS core plugin							 --
--                                                                   --
--                    Copyright (C) 2011-2012                        --
--                 University of Padova, ITALY                       --
--                                                                   --
-- All rights reserved. This program and the accompanying materials  --
-- are made available under the terms of the Eclipse Public License  --
-- v1.0 which accompanies this distribution, and is available at     --
-- http://www.eclipse.org/legal/epl-v10.html                         --
-----------------------------------------------------------------------
*/

package org.polarsys.chess.core.internal.preferences;

import java.util.ArrayList;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.polarsys.chess.core.constraint.ConstraintList;
import org.polarsys.chess.core.constraint.IConstraint;
import org.polarsys.chess.core.preferences.FilterableConstraint;
import org.polarsys.chess.core.Activator;

/**
 * This class represents a preference page that is contributed to the
 * Preferences dialog. By subclassing <samp>FieldEditorPreferencePage</samp>, we
 * can use the field support built into JFace that allows us to create a page
 * that is small and knows how to save, restore and apply itself.
 * <p>
 * This page is used to modify preferences only. They are stored in the
 * preference store that belongs to the main plug-in class. That way,
 * preferences can be accessed directly via the preference store.
 */

public class ConstraintPreferencePage extends FieldEditorPreferencePage
		implements IWorkbenchPreferencePage {

	private static int i = 0;

	public ConstraintPreferencePage() {
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("List of dynamic constraints.");
		System.out.println("ConstraintPreferencePage" + ++i);
	}

	/**
	 * Creates the field editors. Field editors are abstractions of the common
	 * GUI blocks needed to manipulate various types of preferences. Each field
	 * editor knows how to save and restore itself.
	 */
	public void createFieldEditors() {
		refresh();
	}

	public void refresh() {
		ArrayList<FilterableConstraint> list = ConstraintList.getList();
		if (list.isEmpty()) {
			addField(new LabelField("Open the CHESS editor to load the constraints!", getFieldEditorParent()));
		} else {
			for (FilterableConstraint c : ConstraintList.getList()) {
//				if (!(c instanceof ParsableConstraint))
//					continue;
				IConstraint cc = c.getConstraint();
				BooleanFieldEditor b = new BooleanFieldEditor(cc.getName(), cc.getMessage(), BooleanFieldEditor.SEPARATE_LABEL, getFieldEditorParent());
				addField(b);
			}
		}
	}
	
	
	//Actively set the filter values on the ConstraintList
	@Override
	public boolean performOk() {
		super.performOk();
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		for (FilterableConstraint c : ConstraintList.getList()) {
//			if (!(c instanceof ParsableConstraint))
//				continue;
			IConstraint cc = c.getConstraint();
			
			c.setActive(store.getBoolean(cc.getName()));
		}
		return true;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
	}

}