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

package org.polarsys.chess.service.internal.commands.switchers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.ui.AbstractSourceProvider;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISources;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.part.WorkbenchPart;
import org.polarsys.chess.core.views.DiagramStatus;
import org.polarsys.chess.core.views.DiagramStatus.DesignView;
import org.polarsys.chess.core.views.ViewUtils;
import org.polarsys.chess.service.utils.CHESSEditorUtils;

public class SwitchSourceProvider extends AbstractSourceProvider {

	public final static String SWITCH = "org.polarsys.chess.service.commands.switchState";
	
	private final static String DISABLED = "disabled";
	
	private String currentState = DISABLED;
	
	
	public static List<String> commandsToRefresh = new ArrayList<String>();

	public void dispose() {
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map getCurrentState() {
		Map currentSt = new HashMap(2);
		currentSt.put(SWITCH, currentState);
		return currentSt;
	}

	public String[] getProvidedSourceNames() {
		return new String[] { SWITCH };
	}
	
	private void setEnabledValue(String v) {
		currentState = v;
		fireSourceChanged(ISources.WORKBENCH, SWITCH, v);
	}

	public void updateStatus(IEditorPart activeEditor) {
		try {
			if (!CHESSEditorUtils.isCHESSProject(activeEditor)) {
				setEnabledValue(DISABLED);
			} else {
				
				DiagramStatus ds = CHESSEditorUtils.getDiagramStatus((PapyrusMultiDiagramEditor) activeEditor);
				if (ds == null) {
					setEnabledValue(DISABLED);
				}else {
				DesignView currentView = ds.getCurrentView();

				if (currentView != null && (ViewUtils.hasConcurrentViews(currentView) || ViewUtils.isConcurrentView(currentView))){
					String name = ViewUtils.getBaseViewName(currentView);
					setEnabledValue(name);
				}
				
				
				else 
					setEnabledValue(DISABLED);
				}
			} 
			refreshElements(activeEditor);
		} catch (Exception e) {
			return;
		}
	}

	private void refreshElements(IEditorPart activeEditor) {
		ICommandService service = (ICommandService) activeEditor.getSite().getWorkbenchWindow().getService(ICommandService.class);
		
		for (String commandId : commandsToRefresh) {
			service.refreshElements(commandId, null);
		}
		
//		service.refreshElements(CurrentViewStatus.COMMAND_ID, null);
//		service.refreshElements(SwitchToExtraFunctional.COMMAND_ID, null);
//		service.refreshElements(SwitchToDependability.COMMAND_ID, null);
	}
}
