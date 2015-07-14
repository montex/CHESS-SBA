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

package org.polarsys.chess.service.internal.commands;

import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.commands.IElementUpdater;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.menus.UIElement;
import org.polarsys.chess.core.profiles.CHESSProfileManager;
import org.polarsys.chess.core.util.CHESSProjectSupport;
import org.polarsys.chess.core.views.DiagramStatus;
import org.polarsys.chess.service.utils.CHESSEditorUtils;

public class SupersuserToggleCommand extends AbstractHandler implements IElementUpdater {
	private boolean selected = false;

	String uncheckedText = "Enable superuser: deactivate write permission checking";
	String checkedText = "Disable superuser: activate write permission checking";;
	
	@Override
	public Object execute(ExecutionEvent event)
			throws org.eclipse.core.commands.ExecutionException {
		
		IEditorPart editor = HandlerUtil.getActiveEditorChecked(event);
		
		if (CHESSEditorUtils.isCHESSProject(editor) && CHESSProfileManager.ARE_VIEWS_LOADED) {

			DiagramStatus diagramStatus = CHESSEditorUtils.getDiagramStatus((PapyrusMultiDiagramEditor) editor);

			if (diagramStatus == null)
				return null;

			selected = !selected; 
			diagramStatus.setSuperuser(selected);
			CHESSProjectSupport.printlnToCHESSConsole("Superuser " + (selected?"ON":"OFF"));
		}

		return null;
	}

	
	@SuppressWarnings("rawtypes")
	public void updateElement(UIElement element, Map parameters) {
		PapyrusMultiDiagramEditor editor = CHESSEditorUtils.getCHESSEditor();
		if (editor != null && CHESSProfileManager.ARE_VIEWS_LOADED) {
			DiagramStatus st = CHESSEditorUtils.getDiagramStatus(editor);
			selected = st.isSuperuser();
		}
		element.setChecked(selected);
		element.setText(selected?checkedText:uncheckedText);
	}

}
