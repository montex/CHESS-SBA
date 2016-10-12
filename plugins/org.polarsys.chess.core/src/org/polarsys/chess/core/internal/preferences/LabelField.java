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

import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;

public final class LabelField extends FieldEditor {

	public LabelField(String labelText, Composite parent) {
		super("label", labelText, parent);
	}

	@Override
	public int getNumberOfControls() {
		return 1;
	}

	@Override
	protected void doStore() {
	}

	@Override
	protected void doLoadDefault() {
	}

	@Override
	protected void doLoad() {
	}

	@Override
	protected void doFillIntoGrid(Composite parent, int numColumns) {
		getLabelControl(parent).setLayoutData(new GridData());
	}

	@Override
	protected void adjustForNumColumns(int numColumns) {
		GridData gd = (GridData) getLabelControl().getLayoutData();
		gd.horizontalSpan = numColumns;

	}
}