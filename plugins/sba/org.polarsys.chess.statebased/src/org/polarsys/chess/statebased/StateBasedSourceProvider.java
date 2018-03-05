/*
-----------------------------------------------------------------------
-- Copyright (C) 2011-2016                                           --
-- University of Firenze, Italy	                                     --
-- Intecs S.p.A., Italy                                              --
--                                                                   --
-- All rights reserved. This program and the accompanying materials  --
-- are made available under the terms of the Eclipse Public License  --
-- v1.0 which accompanies this distribution, and is available at     --
-- http://www.eclipse.org/legal/epl-v10.html                         --
--                                                                   --
-- Contributors:                                                     --
-- Nicholas Pacini		nicholas.pacini@intecs.it                    --
-----------------------------------------------------------------------
*/

package org.polarsys.chess.statebased;

import org.polarsys.chess.core.views.DiagramStatus;
import org.polarsys.chess.core.views.ViewUtils;
import org.polarsys.chess.core.views.DiagramStatus.DesignView;
import org.polarsys.chess.service.gui.utils.CHESSEditorUtils;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.ui.AbstractSourceProvider;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISources;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;

public class StateBasedSourceProvider extends AbstractSourceProvider {

	public static final String ANALYSIS = "org.polarsys.chess.statebased.stateBased";
	private static final String ENABLED = "enabled";
	private final static String DISABLED = "disabled";
	boolean enabled;
	
	@Override
	public void dispose() {
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map getCurrentState() {	
		Map currentStateMap = new HashMap(2);
		String currentState = enabled ? ENABLED : DISABLED;
		currentStateMap.put(ANALYSIS, currentState);
		return currentStateMap;
	}

	@Override
	public String[] getProvidedSourceNames() {
		return new String[] {ANALYSIS};
	}
	
	private void setEnabled(boolean enabled) {
		if (this.enabled == enabled)
			return; // no change
		this.enabled = enabled;
		String currentState = enabled ? ENABLED : DISABLED;
		fireSourceChanged(ISources.WORKBENCH, ANALYSIS, currentState);
	}
	
	public void updateStatus(IEditorPart activeEditor) {
		try {
			if (CHESSEditorUtils.isCHESSProject(activeEditor)) {
				DiagramStatus ds = CHESSEditorUtils.getDiagramStatus((PapyrusMultiDiagramEditor) activeEditor);
				if (ds != null) {
					DesignView currentView = ds.getCurrentView();
					if (currentView != null && ViewUtils.isDependabilityAnalysisView(currentView)){
						setEnabled(true);
					}		
					else 
						setEnabled(false);
				}
			}
			refreshElements();
		} catch (Exception e) {
			return;
		}
	}

	private void refreshElements() {
		ICommandService service = (ICommandService) PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getService(ICommandService.class);
		service.refreshElements(StateBasedTransformationCommand.COMMAND_ID, null);
	}

}
