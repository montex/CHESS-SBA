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
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.menus.UIElement;
import org.eclipse.ui.services.ISourceProviderService;
import org.polarsys.chess.core.profiles.CHESSProfileManager;
import org.polarsys.chess.core.views.DiagramStatus;
import org.polarsys.chess.core.views.DiagramStatus.DesignView;
import org.polarsys.chess.service.internal.palette.PaletteManager;
import org.polarsys.chess.service.internal.utils.CHESSInternalEditorUtils;
import org.polarsys.chess.service.internal.visibility.HidePortCommand;
import org.polarsys.chess.service.utils.CHESSEditorUtils;

public class SwitchToView {

	public String commandId;
	
	private String theView;
	
	String checkedText;
	String uncheckedText;
	
	public SwitchToView(String theView, String commandId) {
		this.theView = theView;
		this.commandId = commandId;
		
		checkedText = "Deactivate " + theView;
		uncheckedText = "Activate " + theView;
		
		SwitchSourceProvider.commandsToRefresh.add(commandId);
	}
	
	private boolean selected = false;

	public void refresh() {
		ICommandService service = (ICommandService) PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getService(ICommandService.class);
		service.refreshElements(commandId, null);
	}

	public Object execute(ExecutionEvent event) throws ExecutionException {
		IEditorPart editorPart = HandlerUtil.getActiveEditorChecked(event);
		
		if (CHESSEditorUtils.isCHESSProject(editorPart) && CHESSProfileManager.ARE_VIEWS_LOADED) {
			
			DiagramStatus diagramStatus = CHESSEditorUtils.getDiagramStatus((PapyrusMultiDiagramEditor) editorPart);

			if (diagramStatus == null)
				return null;

			IWorkbenchWindow window = editorPart.getSite().getWorkbenchWindow();
			ISourceProviderService spService = (ISourceProviderService) window
					.getService(ISourceProviderService.class);
			SwitchSourceProvider sp = (SwitchSourceProvider) spService
					.getSourceProvider(SwitchSourceProvider.SWITCH);

			selected = diagramStatus.requestView(theView, !selected);
			hideShowElements((PapyrusMultiDiagramEditor) editorPart);
			PaletteManager.setPaletteVisibility((PapyrusMultiDiagramEditor) editorPart, diagramStatus);
			sp.updateStatus(editorPart);
		}

		return null;
	}

	//TODO currently this method does not work. Do no use it.
	private void hideShowElements(PapyrusMultiDiagramEditor editor) {
		if (false){
			List<View> elements = new ArrayList<View>();
			try {
				elements = CHESSInternalEditorUtils.getDiagramAllVisiblePort(CHESSEditorUtils.getDiagram(editor));
				new HidePortCommand(elements, editor).execute();
			} catch (Exception e) {}
		}
	}

	@SuppressWarnings("rawtypes")
	public void updateElement(UIElement element, Map parameters) {
		PapyrusMultiDiagramEditor editor = CHESSEditorUtils.getCHESSEditor();
		if (editor != null && CHESSProfileManager.ARE_VIEWS_LOADED) {
			DiagramStatus st = CHESSEditorUtils.getDiagramStatus(editor);
			if (st== null)
				return;
//			System.out.println("switcher for " + theView);
			DesignView currentView = st.getCurrentView();
			if(selected && currentView != null)
				selected = st.getCurrentView().isEnabled(theView);
		}
		element.setChecked(selected);
		if (selected)
			element.setText(checkedText);
		else	
			element.setText(uncheckedText);
	}

}
