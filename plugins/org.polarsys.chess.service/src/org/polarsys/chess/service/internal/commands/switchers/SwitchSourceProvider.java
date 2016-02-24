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

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.editor.CoreMultiDiagramEditor;
import org.eclipse.ui.AbstractSourceProvider;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISources;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Stereotype;
import org.polarsys.chess.core.util.uml.ResourceUtils;
import org.polarsys.chess.core.views.DiagramStatus;
import org.polarsys.chess.core.views.DiagramStatus.DesignView;
import org.polarsys.chess.core.views.ViewUtils;
import org.polarsys.chess.service.utils.CHESSEditorUtils;
import org.polarsys.chess.chessmlprofile.Core.CHESS;
import org.polarsys.chess.chessmlprofile.Core.Domain;
import org.polarsys.chess.chessmlprofile.util.Constants;

public class SwitchSourceProvider extends AbstractSourceProvider {

	public final static String SWITCH = "org.polarsys.chess.service.commands.switchState";
	
	// for Domain dependent management of Menu contributions 
	public final static String DOMAIN = "org.polarsys.chess.service.commands.domain";	
	private final static String defaultDomain = Domain.CROSS_DOMAIN.name();
	private String currentDomain = defaultDomain;
		
	
	private final static String DISABLED = "disabled";
	
	private String currentState = DISABLED;
	
	
	public static List<String> commandsToRefresh = new ArrayList<String>();

	public void dispose() {
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map getCurrentState() {
		Map currentSt = new HashMap(2);
		currentSt.put(SWITCH, currentState);
		currentSt.put(DOMAIN, currentDomain);
		return currentSt;
	}

	public String[] getProvidedSourceNames() {
		return new String[] { SWITCH };
	}
	
	private void setEnabledValue(String v) {
		currentState = v;
		fireSourceChanged(ISources.WORKBENCH, SWITCH, v);
	}
	
	private void setEnabledValueDomain(String d) {
		currentDomain = d;		
		fireSourceChanged(ISources.WORKBENCH, DOMAIN, d);
	}

	/**
	 * Updates the variables used to guide the menu/toolbar population:
	 * - Variable SWITCH (org.polarsys.chess.service.commands.switchState) is used for the change View toggle buttons
	 * - Variable DOMAIN (org.polarsys.chess.service.commands.domain) is used for identifying AVIONICS models to visualize IMA commands
	 * @param activeEditor
	 */
	public void updateStatus(IEditorPart activeEditor) {
		try {
			if (!CHESSEditorUtils.isCHESSProject(activeEditor)) {
				setEnabledValue(DISABLED);
				setEnabledValueDomain(defaultDomain);
			} else {
				
				DiagramStatus ds = CHESSEditorUtils.getDiagramStatus((PapyrusMultiDiagramEditor) activeEditor);
				if (ds == null) {
					setEnabledValue(DISABLED);
					setEnabledValueDomain(defaultDomain);
				}else {
				DesignView currentView = ds.getCurrentView();
								
				// Read the model's domain and assign it to the variable DOMAIN (org.polarsys.chess.service.commands.domain)				
				Resource res = ResourceUtils.getUMLResource(((CoreMultiDiagramEditor) activeEditor).getServicesRegistry());
				Model umlModel = ResourceUtils.getModel(res);
				if (umlModel == null) {
					setEnabledValueDomain(defaultDomain);					
				}
				else {
					if (umlModel.getAppliedStereotype(Constants.CHESS_MODEL_STEREOTYPE) != null) {
						Stereotype chessModelStereo = umlModel.getAppliedStereotype(Constants.CHESS_MODEL_STEREOTYPE);
						CHESS chessModel = (CHESS) umlModel.getStereotypeApplication(chessModelStereo);
						Domain theDomain = chessModel.getDomain();
						setEnabledValueDomain(theDomain.name());
					}
					else {
						setEnabledValueDomain(defaultDomain);		
					}
				}							

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
