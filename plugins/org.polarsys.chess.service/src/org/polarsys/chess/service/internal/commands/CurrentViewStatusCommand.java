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
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.commands.IElementUpdater;
import org.eclipse.ui.menus.UIElement;
import org.polarsys.chess.core.profiles.CHESSProfileManager;
import org.polarsys.chess.core.views.DiagramStatus;
import org.polarsys.chess.service.gui.utils.CHESSEditorUtils;
import org.polarsys.chess.service.internal.commands.switchers.SwitchSourceProvider;
import org.polarsys.chess.service.internal.service.CHESSService;
import org.polarsys.chess.service.internal.service.CHESSServiceFactory;

public class CurrentViewStatusCommand extends AbstractHandler implements IElementUpdater {
	
	public CurrentViewStatusCommand() {
		SwitchSourceProvider.commandsToRefresh.add(COMMAND_ID);
	}

	public static String COMMAND_ID = "org.polarsys.chess.service.CurrentViewStatus";
	
	public static void refresh(){
		ICommandService service = (ICommandService) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getService(ICommandService.class);
        service.refreshElements(COMMAND_ID, null);
	}
	
	public Object execute(ExecutionEvent event) throws ExecutionException {
		return null;
	}

	@SuppressWarnings("rawtypes")
	public void updateElement(UIElement element, Map parameters) {
		PapyrusMultiDiagramEditor editor = CHESSEditorUtils.getCHESSEditor();
		//DesignView currentView;
		DiagramStatus diagramStatus;
		
		if (editor != null && (null != (diagramStatus = CHESSEditorUtils.getDiagramStatus(editor)))){
			if (diagramStatus != null && null != (/*currentView = */diagramStatus.getCurrentView())){
	
				String n = diagramStatus.getActiveView();
				element.setTooltip(n);
				
				element.setIcon(CHESSService.viewIcons.get(n));
				return;
			}	
		}	

		element.setIcon(CHESSService.viewIcons.get(CHESSProfileManager.NULL_VIEW));

	    element.setTooltip(CHESSProfileManager.NULL_VIEW);
		element.setText(" ");
//		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor().getEditorSite().getActionBars().updateActionBars();
	}

}
