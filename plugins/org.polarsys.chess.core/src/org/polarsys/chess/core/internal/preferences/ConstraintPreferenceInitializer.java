/*
-----------------------------------------------------------------------
--          			CHESS core plugin							 --
--                                                                   --
--                    Copyright (C) 2011-2012                        --
--                 University of Padova, ITALY                       --
--                                                                   --
-- Author: Alessandro Zovi         azovi@math.unipd.it               --
--                                                                   --
-- All rights reserved. This program and the accompanying materials  --
-- are made available under the terms of the Eclipse Public License  --
-- v1.0 which accompanies this distribution, and is available at     --
-- http://www.eclipse.org/legal/epl-v10.html                         --
-----------------------------------------------------------------------
*/

package org.polarsys.chess.core.internal.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.polarsys.chess.core.Activator;
import org.polarsys.chess.core.constraint.ConstraintList;
import org.polarsys.chess.core.constraint.IConstraint;
import org.polarsys.chess.core.constraint.PreferenceProperties;
import org.polarsys.chess.core.preferences.FilterableConstraint;

/**
 * Class used to initialize default preference values.
 */
public class ConstraintPreferenceInitializer extends AbstractPreferenceInitializer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		for (FilterableConstraint c : ConstraintList.getList()) {
			IConstraint cc = c.getConstraint();
			store.setDefault(cc.getName(), true);
		}
		
		store.setDefault(PreferenceProperties.DIAGRAM_IN_VIEW, true);
		store.setDefault(PreferenceProperties.PALETTES_IN_VIEW, true);
	}

}
