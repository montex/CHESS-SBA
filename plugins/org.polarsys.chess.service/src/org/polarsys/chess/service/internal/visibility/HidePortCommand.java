/*
-----------------------------------------------------------------------
--          			CHESS editor plugin							 --
--                                                                   --
--                    Copyright (C) 2011-2012                        --
--                 University of Padova, ITALY                       --
--                                                                   --
-- Author: Alessandro Zovi         azovi@math.unipd.it 		         --
--                                                                   --
-- All rights reserved. This program and the accompanying materials  --
-- are made available under the terms of the Eclipse Public License  --
-- v1.0 which accompanies this distribution, and is available at     --
-- http://www.eclipse.org/legal/epl-v10.html                         --
-----------------------------------------------------------------------
*/

package org.polarsys.chess.service.internal.visibility;

import java.util.List;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;

//TODO The functionality provided by this class does not work.
//Either remove the class or investigate an alternative solution.
public class HidePortCommand {

	private PapyrusMultiDiagramEditor editor;
	private List<View> elements;
	private EditingDomain domain;

	public HidePortCommand(List<View> elements, PapyrusMultiDiagramEditor activeEditor) {
		this.domain = activeEditor.getEditingDomain();
		this.elements = elements;
		this.editor = activeEditor;
	}

	public void execute() {
		editor.getEditingDomain().getCommandStack()
				.execute(cmd);
	}

	RecordingCommand cmd = new RecordingCommand((TransactionalEditingDomain) domain) {
		@Override
		protected void doExecute() {
			for (View e : elements) {
				((View) e).setVisible(false);
			}
		}
	};
}