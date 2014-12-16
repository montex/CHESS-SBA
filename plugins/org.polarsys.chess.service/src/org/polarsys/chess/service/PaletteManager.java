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

package org.polarsys.chess.service;

import java.util.List;

import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.sasheditor.editor.ISashWindowsContainer;
import org.eclipse.ui.IEditorPart;
import org.polarsys.chess.core.profiles.CHESSProfileManager;
import org.polarsys.chess.core.views.DiagramStatus;
import org.polarsys.chess.core.views.ViewDiagramAssociations;


public class PaletteManager {
	
	protected static List<Object> lookupSelectedElements(ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			return structuredSelection.toList();
		} else if (selection instanceof TreeSelection) {
			TreeSelection treeSelection = (TreeSelection) selection;
			return treeSelection.toList();
		}
		return null;
	}
	
	public static void setPaletteVisibility(PapyrusMultiDiagramEditor editor, DiagramStatus ds) {
		//INFO code from org.eclipse.papyrus.diagram.common.part.PaletteMenuAction
		//if(true) return;
		try {
			//final IEditorPart part = getActiveSashPage(editor);
			//DiagramEditPart ep = editor.getDiagramEditPart();
			IEditorPart ep = editor.getActiveEditor();
			ISelection selection = ep.getSite().getSelectionProvider().getSelection();
			List<Object> selections = lookupSelectedElements(selection);
			GraphicalEditPart a = (GraphicalEditPart) selections.get(0);
			DiagramEditDomain de = (DiagramEditDomain) a.getDiagramEditDomain();
			//TODO get palette working! see Marte profile palette
			PaletteViewer pv = de.getPaletteViewer();
			
//			String viewName = ds.getCurrentView().getName();
			String viewName = ds.getActiveView();
			//System.out.println("activew view" + viewName);
			
			String diagramName = ds.getCurrentView().getCurrentDiagramName();
			
			for (Object o : pv.getPaletteRoot().getChildren()){
				if (o instanceof PaletteDrawer){
					PaletteDrawer d = (PaletteDrawer) o;
					setPaletteVisibility(d, viewName, diagramName);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			//Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage()));
		}
		//final List<String> hiddenPalettes = PapyrusPalettePreferences.getHiddenPalettes(part);
		
		//PapyrusPaletteService ps = PapyrusPaletteService.getInstance();
		
		
//		for(PapyrusPaletteService.ProviderDescriptor descriptor : ps.getContributingProviders(part, pv.getPaletteRoot())) {
//			
//			String id = descriptor.getContributionID();
//			String name = descriptor.getContributionName();
//			CHESSProjectSupport.printlnToCHESSConsole(id + " " + name);
//			//TODO what are the palette to hide/show given the current view and diagram?
//			//PapyrusPalettePreferences.changePaletteVisibility(id, editor.getActiveEditor().getClass().getName(), false);
//		}
	}
	//TODO this code is temporary needs refactoring
	private static void setPaletteVisibility(PaletteDrawer paletteDrawer, String viewName,
			String diagramName) {
				
		if (diagramName.equals(CHESSProfileManager.SYSTEM_VIEW)) {
			//paletteDrawer.setVisible(false);
			return;
		}
		
		if (diagramName.equals(ViewDiagramAssociations.ANYDIAGRAM)) {
			paletteDrawer.setVisible(false);
			return;
		}
		
		paletteDrawer.setVisible(true);
		String label = paletteDrawer.getLabel();
		String paletteId = paletteDrawer.getId();
		if (viewName.equals(CHESSProfileManager.COMPONENT_VIEW)){
			if (diagramName.equals(ViewDiagramAssociations.classDiagram)||
				diagramName.equals(ViewDiagramAssociations.compositeDiagram)){
				//set visibility only for the palette's functional tools
				paletteDrawer.setVisible(false);
				if (label.equals("CHESS FunctView") || label.equals("FoReVer")) //TODO here we should re-engineer the code to allow a more flexible management of additional profile palettes
					paletteDrawer.setVisible(true);
			}
			if (diagramName.equals(ViewDiagramAssociations.activityDiagram)){
				paletteDrawer.setVisible(false);
				if (label.equals("CHESS/Activity"))
					paletteDrawer.setVisible(true);
			}
			
			if (diagramName.equals(ViewDiagramAssociations.stateMachineDiagram)){
				paletteDrawer.setVisible(true);
				String id = paletteDrawer.getId();
				if (id.compareTo("SM_FunctionalDrawer__1317124986519")!=0)
					paletteDrawer.setVisible(false);
			}
			
			if (diagramName.equals(ViewDiagramAssociations.sequenceDiagram)){
				paletteDrawer.setVisible(true);
				String id = paletteDrawer.getId();
				if (id.compareTo("CHESSSequenceDiagramPalette_Nodes")!=0 && id.compareTo("CHESSSequenceDiagramPalette_Edges")!=0)
					paletteDrawer.setVisible(false);
			}
			
			
		}
		if (viewName.equals(CHESSProfileManager.EXTRAFUNCTIONAL_VIEW)){
			//if (diagramName.equals(ViewDiagramAssociations.compositeDiagram)){
				//hide the palette's functional tools
				/*paletteDrawer.setVisible(true);
				if (label.equals("CHESS FunctView") || label.equals("CHESS/Deployment") || label.equals("CHESS/Activity"))
					paletteDrawer.setVisible(false);*/
			//}
				if (diagramName.equals(ViewDiagramAssociations.stateMachineDiagram)){
					paletteDrawer.setVisible(true);
					
					if (paletteId.compareTo("SM_ErrorModelDrawer__1317126136270")!=0)
						paletteDrawer.setVisible(false);
				}
				
				if (diagramName.equals(ViewDiagramAssociations.compositeDiagram)){
					//hide the palette's functional tools
					paletteDrawer.setVisible(true);
					if (paletteId.compareTo("CSD_RTDrawer__1302019186026")!=0 && paletteId.compareTo("CSD_FPTC_Drawer__1317635175167")!=0)
						paletteDrawer.setVisible(false);
				}
				
				if (diagramName.equals(ViewDiagramAssociations.classDiagram)){
					
					paletteDrawer.setVisible(false);
				}
					
				if (diagramName.equals(ViewDiagramAssociations.activityDiagram)){
					
					paletteDrawer.setVisible(false);
				}
				
				if (diagramName.equals(ViewDiagramAssociations.sequenceDiagram)){
					paletteDrawer.setVisible(true);
					if (paletteId.compareTo("drawer_1329924117088")!=0 && paletteId.compareTo("Drawer__1329924033356")!=0)
						paletteDrawer.setVisible(false);
				}
				
				
		}
		if (viewName.equals(CHESSProfileManager.DEPLOYMENT_VIEW)){
			if (diagramName.equals(ViewDiagramAssociations.classDiagram)){
				//hide the palette's functional tools
				paletteDrawer.setVisible(false);
				if (label.equals("CHESS/Deployment") || label.equals("FoReVerDeploymentCD"))
					paletteDrawer.setVisible(true);
			}
			if (diagramName.equals(ViewDiagramAssociations.compositeDiagram)){
				//hide the palette's functional tools
				paletteDrawer.setVisible(false);
				if (label.equals("CHESS/Deployment")|| label.equals("FoReVer"))
					paletteDrawer.setVisible(true);
			}
			
			if (diagramName.equals(ViewDiagramAssociations.stateMachineDiagram)){
				paletteDrawer.setVisible(true);
				if (paletteId.compareTo("SM_FunctionalDrawer__1317124986519")!=0)
					paletteDrawer.setVisible(false);
			}
		}
		
		if (viewName.equals(CHESSProfileManager.DEPENDABILITY_VIEW)){
				
			if (diagramName.equals(ViewDiagramAssociations.stateMachineDiagram)){
				paletteDrawer.setVisible(true);
				if (paletteId.compareTo("SM_ErrorModelDrawer__1317126136270")!=0)
					paletteDrawer.setVisible(false);
			}
			else if (diagramName.equals(ViewDiagramAssociations.classDiagram)){
					paletteDrawer.setVisible(false);
			}
			else if (diagramName.equals(ViewDiagramAssociations.compositeDiagram)){
				paletteDrawer.setVisible(true);
				if (paletteId.compareTo("CSD_FPTC_Drawer__1317635175167")!=0)
					paletteDrawer.setVisible(false);
			}
		}
		
		if (viewName.equals(CHESSProfileManager.DEPENDABILITY_ANALYSIS_VIEW)){
			if (diagramName.equals(ViewDiagramAssociations.classDiagram)){
				paletteDrawer.setVisible(true);
				if (paletteId.compareTo("DepAnalysisViewDrawer__1317300165546")!=0)
					paletteDrawer.setVisible(false);
			}
		}
		
		if (viewName.equals(CHESSProfileManager.RT_ANALYSIS_VIEW)){
			if (diagramName.equals(ViewDiagramAssociations.classDiagram)){
				if (paletteId.compareTo("CHESS-TimingAnalysisDrawer")!=0)
					paletteDrawer.setVisible(false);
				else
					paletteDrawer.setVisible(true);
			}
		}
		
		if (viewName.equals(CHESSProfileManager.RAILWAY_VIEW)){
			paletteDrawer.setVisible(false);
			if (diagramName.equals(ViewDiagramAssociations.compositeDiagram)){
				//show only the railway palette
				if (paletteId.compareTo("Drawer__1301934597253")==0)
					paletteDrawer.setVisible(true);
				}
		}
	
	}

}
