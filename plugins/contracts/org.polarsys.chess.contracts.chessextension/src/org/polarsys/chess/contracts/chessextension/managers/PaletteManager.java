/*******************************************************************************
 *
 * Copyright (c) 2013, 2015 Intecs SpA 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Nicholas Pacini nicholas.pacini@intecs.it 
 * Stefano Puri stefano.puri@intecs.it
 * Laura Baracchi  laura.baracchi@intecs.it  
 * Initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.polarsys.chess.contracts.chessextension.managers;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.ui.IEditorPart;
import org.polarsys.chess.contracts.chessextension.Activator;
import org.polarsys.chess.core.constraint.PreferenceProperties;
import org.polarsys.chess.core.profiles.CHESSProfileManager;
import org.polarsys.chess.core.views.DiagramStatus;

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
	
	//TODO this class should be reengineered so to have a parent one common to all the chess plugins
	public static void setPaletteVisibility(PapyrusMultiDiagramEditor editor, DiagramStatus ds) {
		
		Boolean checkPalette =
				org.polarsys.chess.core.Activator.getDefault().getPreferenceStore().getBoolean(PreferenceProperties.PALETTES_IN_VIEW);
		
		if (!checkPalette)
			return;
		
		try {
					
			IEditorPart ep = editor.getActiveEditor();
			if (ep == null)
				return;
			ISelection selection = ep.getSite().getSelectionProvider().getSelection();
			List<Object> selections = lookupSelectedElements(selection);
			DiagramEditDomain de = null;
			if (selections.get(0) instanceof GraphicalEditPart){
				GraphicalEditPart a = (GraphicalEditPart) selections.get(0);
				de = (DiagramEditDomain) a.getDiagramEditDomain();
			}
			else{
				if (selections.get(0) instanceof ConnectionEditPart){
					ConnectionEditPart a = (ConnectionEditPart) selections.get(0);
					de = (DiagramEditDomain) a.getDiagramEditDomain();
				}
			}
			
			if (de == null){
				Activator.getDefault().getLog().log(new Status(IStatus.WARNING, Activator.PLUGIN_ID, "cannot retrieve DiagramEditDomain"));
				return;
			}
			
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
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage()));
			e.printStackTrace();
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
	//TODO the policy of the palette visibility should be re-engineered to allow CHESS external plugins "like 
	//CHESSContract, to add palettes to the ones already managed by CHESS. Now the CHESSContract palettes which regard the 
	//component view are managed in CHESS, not here. 
	private static void setPaletteVisibility(PaletteDrawer paletteDrawer, String viewName,
			String diagramName) {
		
		if (! viewName.equals(CHESSProfileManager.SYSTEM_VIEW)){
			//no restriction upon the CHESS main view
			return;
		}
		
		if (diagramName.equals("PapyrusUMLStateMachineDiagram")){
			return;
		}
		
			
		paletteDrawer.setVisible(true);
		String label = paletteDrawer.getLabel();
		String paletteId = paletteDrawer.getId();
		if (viewName.equals(CHESSProfileManager.SYSTEM_VIEW)){
			if (diagramName.compareTo("BlockDefinition")==0){
				//set visibility only for the palette's functional tools
				paletteDrawer.setVisible(false);
				if (paletteId.compareTo("ForeverBDDAssociationsDrawerID")==0|| paletteId.compareTo("ForeverBDDModelElementsDrawerID")==0
						|| paletteId.compareTo("ForeverBDDPortAndFlowsDrawerID")==0
						|| paletteId.compareTo("ForeverBDDDataTypesDrawerID")==0 
						|| paletteId.compareTo("ForeverBDDContractsDrawerID")==0 )
					paletteDrawer.setVisible(true);
			}
			if (diagramName.equals("InternalBlock")){
				paletteDrawer.setVisible(false);
				if (paletteId.compareTo("ForeverIBDNodesDrawerID")==0 || paletteId.compareTo("ForeverIBDEdgesDrawerID")==0)
					paletteDrawer.setVisible(true);
			}
			
			if (diagramName.equals("PapyrusUMLClassDiagram")){
				paletteDrawer.setVisible(true);
			}
			
			if (diagramName.equals("CompositeStructure")){
				paletteDrawer.setVisible(true);
			}
			
			
		}
		
	
	}

}
