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

package org.polarsys.chess.service.internal.palette;

import java.util.List;

import javax.rmi.CORBA.Util;

import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagramImpl;
import org.eclipse.ui.IEditorPart;
import org.eclipse.uml2.uml.internal.impl.StateMachineImpl;
import org.polarsys.chess.chessmlprofile.util.Constants;
import org.polarsys.chess.core.constraint.PreferenceProperties;
import org.polarsys.chess.core.profiles.CHESSProfileManager;
import org.polarsys.chess.core.views.DiagramStatus;
import org.polarsys.chess.core.views.ViewDiagramAssociations;
import org.polarsys.chess.service.gui.utils.CHESSEditorUtils;


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
		
		Boolean checkPalette =
				org.polarsys.chess.core.Activator.getDefault().getPreferenceStore().getBoolean(PreferenceProperties.PALETTES_IN_VIEW);
		
		if (!checkPalette)
			return;
		
		try {
			
			IEditorPart ep = editor.getActiveEditor();
			ISelection selection = ep.getSite().getSelectionProvider().getSelection();
			List<Object> selections = lookupSelectedElements(selection);
			GraphicalEditPart a = (GraphicalEditPart) selections.get(0);
			DiagramEditDomain de = (DiagramEditDomain) a.getDiagramEditDomain();
			PaletteViewer pv = de.getPaletteViewer();
	
			String viewName = ds.getActiveView();
			
			String diagramName = ds.getCurrentView().getCurrentDiagramName();
			
			for (Object o : pv.getPaletteRoot().getChildren()){
				if (o instanceof PaletteDrawer){
					PaletteDrawer d = (PaletteDrawer) o;
					setPaletteVisibility(d, viewName, diagramName);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	//TODO this code is temporary needs refactoring
	private static void setPaletteVisibility(PaletteDrawer paletteDrawer, String viewName,
			String diagramName) {
		
		String paletteId = paletteDrawer.getId();
		
		
		
		if (viewName.equals(CHESSProfileManager.SYSTEM_VIEW) ) {
			//paletteDrawer.setVisible(false);
			

			if (diagramName.compareTo("PapyrusUMLStateMachineDiagram")==0){
				paletteDrawer.setVisible(true);
				
				boolean isErrorModel = false;
				try{
					StateMachineImpl obj = (StateMachineImpl) ((CSSDiagramImpl) CHESSEditorUtils.getDiagramEditPart().getModel()).getElement();
					if (obj != null){
						if (obj.getAppliedStereotype(Constants.ERROR_MODEL)!= null){
							isErrorModel = true;
						}
					}
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
				
				
				if (paletteId.compareTo("SM_ErrorModelDrawer__1317126136270")==0){
					if (isErrorModel)
							paletteDrawer.setVisible(true);
					else
						paletteDrawer.setVisible(false);
				}
					
				
				if (paletteId.compareTo("SM_FunctionalDrawer__1317124986519")==0)
					if (!isErrorModel)
						paletteDrawer.setVisible(true);
					else
						paletteDrawer.setVisible(false);
			}
			return;
			
		}
		
		if (diagramName.equals(ViewDiagramAssociations.ANYDIAGRAM)) {
			paletteDrawer.setVisible(false);
			return;
		}
		
		paletteDrawer.setVisible(true);
		String label = paletteDrawer.getLabel();
		;
		if (viewName.equals(CHESSProfileManager.COMPONENT_VIEW)){
			if (diagramName.equals(ViewDiagramAssociations.classDiagram)){
				//set visibility only for the palette's functional tools
				paletteDrawer.setVisible(false);
				if (paletteId.compareTo("CHESSNodesFunctionalViewDrawerID")==0 || 	
						paletteId.compareTo("CHESSEdgeFunctionalViewDrawerID")==0 ||
						paletteId.compareTo("ContractsClassDiagramDrawer")==0) //TODO here we should re-engineer the code to allow a more flexible management of additional profile palettes
					paletteDrawer.setVisible(true);
			}
			if (diagramName.equals(ViewDiagramAssociations.compositeDiagram)){
					//set visibility only for the palette's functional tools
					paletteDrawer.setVisible(false);
					if (paletteId.compareTo("CompositeDiagramFunctionalViewDrawerID")==0 || 	
						paletteId.compareTo("CompositeFunctionalViewContractDrawerID")==0) //TODO here we should re-engineer the code to allow a more flexible management of additional profile palettes
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
				if (paletteId.compareTo("DeploymentClassDrawerID")==0 || paletteId.compareTo("DeploymentContractClassDrawerID")==0)
					paletteDrawer.setVisible(true);
			}
			if (diagramName.equals(ViewDiagramAssociations.compositeDiagram)){
				//hide the palette's functional tools
				paletteDrawer.setVisible(false);
				if (paletteId.compareTo("DeploymentCSDDrawerID")==0 || paletteId.compareTo("CompositeFunctionalViewContractDrawerID")==0)
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
				//paletteDrawer.setVisible(true);
				if (paletteId.compareTo("DepAnalysisViewDrawer__1317300165546")!=0 && !paletteId.startsWith("chess"))
					paletteDrawer.setVisible(false);
				else
					paletteDrawer.setVisible(true);
			}
		}
		
		if (viewName.equals(CHESSProfileManager.RT_ANALYSIS_VIEW)){
			if (diagramName.equals(ViewDiagramAssociations.classDiagram)){
				if (paletteId.compareTo("CHESS-TimingAnalysisDrawer")!=0)
					paletteDrawer.setVisible(false);
				else
					paletteDrawer.setVisible(true);
			}else if (diagramName.equals(ViewDiagramAssociations.activityDiagram)){
				if (paletteId.compareTo("RTActivityDiagramDrawerID")!=0)
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
