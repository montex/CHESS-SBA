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

package org.polarsys.chess.service.internal.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.uml2.uml.Port;
import org.polarsys.chess.service.internal.Activator;

public class CHESSInternalEditorUtils {
	
	static public List<View> getDiagramAllVisiblePort(final View diagram) {
		List<View> list = new ArrayList<View>();
		list = CHESSInternalEditorUtils.getDiagramAllVisiblePortRecur(
				list, diagram);
		return list;
	}
	
	static public /* @NonNull */ List<View> getDiagramAllVisiblePortRecur(/* @NonNull */ final List<View> list,
			/* @NonNull */ final View view) {
		for (Object v : view.getVisibleChildren()) {
			if (!(v instanceof View))
				continue;
			if (((View) v).getElement() instanceof Port)
				list.add((View) v);
			getDiagramAllVisiblePortRecur(list, (View) v);
		}
		return list;
	}

	public static /*@Nullable*/IEditorPart getEditor() {
		IEditorPart editor = null;
		try {
			editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getActivePage().getActiveEditor();
		} catch (Exception e) {
			Activator.error("Editor not found", e);
		}
		return editor;
	}


	public static int StatusDialog( EditorPart editor, String dialogTitle,
			String dialogMessage, IStatus status) {
		ErrorDialog errDlg = new ErrorDialog(editor.getSite().getShell(),
				dialogTitle, dialogMessage, status, IStatus.ERROR) {

			protected void buttonPressed(int id) {
				if (id == IDialogConstants.YES_ID)
					id = IDialogConstants.OK_ID;
				if (id == IDialogConstants.NO_ID) {
					setReturnCode(5);
					close();
				} else {
					super.buttonPressed(id);
				}
			}

			protected void createButtonsForButtonBar(Composite parent) {
				// create OK and Details buttons
				createButton(parent, IDialogConstants.YES_ID,
						IDialogConstants.YES_LABEL, true);
				createButton(parent, IDialogConstants.NO_ID,
						IDialogConstants.NO_LABEL, true);
				createDetailsButton(parent);
			}
		};
		return errDlg.open();
	}
	
	public static MessageDialog showYesNoDialog(EditorPart editor,
			String dialogTitle, String dialogMessage) {
		MessageDialog md = new MessageDialog(editor.getSite().getShell(),
				dialogTitle, null, dialogMessage, MessageDialog.CONFIRM,
				new String[] { "Yes", "No" }, 0);
		md.setBlockOnOpen(true);
		return md;
	}
}
