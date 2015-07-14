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

package org.polarsys.chess.core.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.polarsys.chess.core.constraint.IConstraint;
import org.polarsys.chess.core.Activator;

/**
 * This class is a wrapper for {@link IConstraint} that is exposed to the preference store of Eclipse
 * and allows to enable/disable the check of the constraint during the model validation.
 */
public class FilterableConstraint implements IFilterable {
	private boolean isActive;
	private IConstraint constraint;
	
	/**
	 * Wraps the IConstraint passed as parameter and set its status accordingly to the one set in the preferences.
	 * If there are no preferences set, then it sets the status to active by default.
	 */
	public FilterableConstraint(IConstraint constraint) {
		this.constraint = constraint;
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		if (store.contains(constraint.getName()))
			setActive(store.getBoolean(constraint.getName()));
		else
			isActive = true;
		store.setDefault(constraint.getName(), true);
    }
	
	/* (non-Javadoc)
	 * @see org.polarsys.chess.core.preferences.IFilterable#setActive(boolean)
	 */
	@Override
	public void setActive(boolean b) {
		isActive = b;
	}
	
	/* (non-Javadoc)
	 * @see org.polarsys.chess.core.preferences.IFilterable#isActive()
	 */
	@Override
	public boolean isActive() {
		return isActive;
	}

	/**
	 * Returns the wrapped constraint.
	 * 
	 * @return the wrapped constraint.
	 */
	public IConstraint getConstraint() {
		return constraint;
	}

}
