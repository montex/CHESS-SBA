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
import org.polarsys.chess.core.Activator;
import org.polarsys.chess.core.constraint.IDynamicConstraint;

public class FilterableConstraint implements IFilterable {
	private boolean isActive;
	private IDynamicConstraint c;
	
	public FilterableConstraint(IDynamicConstraint c) {
		this.c = c;
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		if (store.contains(c.getName()))
			setActive(store.getBoolean(c.getName()));
		else
			isActive = true;
		store.setDefault(c.getName(), true);
    }
	
	@Override
	public void setActive(boolean b) {
		isActive = b;
	}
	@Override
	public boolean isActive() {
		return isActive;
	}

	public IDynamicConstraint getConstraint() {
		return c;
	}

}
