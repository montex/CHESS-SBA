/*
-----------------------------------------------------------------------
--          			CHESS core plugin							 --
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

package org.polarsys.chess.core.views;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Stack;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EObjectTreeElement;
import org.eclipse.papyrus.infra.core.sasheditor.editor.IPage;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageRef;
import org.eclipse.uml2.uml.Package;
import org.polarsys.chess.core.internal.views.InternalViewUtils;
import org.polarsys.chess.core.internal.views.ViewPermissions;
import org.polarsys.chess.core.internal.views.permissions.PermissionList;
import org.polarsys.chess.core.profiles.CHESSProfileManager;


/**
 * This class is registered as a CHESS service and allow the programmer to know
 * at any time the diagram that the user is working on. This is mandatory to
 * know the current view and thus to execute view-specific constraints during
 * the editing of the model.
 * 
 * @author Alessandro Zovi
 * 
 */
public class DiagramStatus {
	
	
	/**
	 * The DesignView must be treated as a singleton service class. It is an integral part of DiagramStatus service.
	 *
	 */
	public static class DesignView {

		Hashtable<String, Boolean> views;
//		Hashtable<String, PermissionList> permissions = ViewPermissions.permissions;
//		Hashtable<String, PermissionList> permissions = new Hashtable<String, PermissionList>(
//				CHESSProfileManager.CHESS_VIEWS_LIST.size());

		short enabledNum = 0, concurNum = 0;
		
		String currentDiagram = null;

		private DesignView() {
			
			views = new Hashtable<String, Boolean>(
					CHESSProfileManager.CHESS_VIEWS_LIST.size());
			//Force loading of permissions
			try {
				Class.forName(ViewPermissions.class.getName());
			} catch (Exception e) {
				// TODO: handle exception
			}
			clearAll();
		}

		private void clearAll() {
			for (String v : CHESSProfileManager.CHESS_VIEWS_LIST) {
				views.put(v, false);
			}
			enabledNum = 0;
			concurNum = 0;
		}

		private void clearNotConcurrent(String view) {
			//disable all non-concurrent views.
			for (String v : CHESSProfileManager.CHESS_VIEWS_LIST) {
				if (!CHESSProfileManager.CONCURRENT_VIEWS.contains(v)) {
					views.put(v, false);
				}
			}
			//disable all the concurrent views of top of others view
			for (String k : CHESSProfileManager.CONCURRENT_VIEWS_ASSOCIATION.keySet()) {
				if (!CHESSProfileManager.CONCURRENT_VIEWS_ASSOCIATION.get(k).contains(view)) {
					for(String l : CHESSProfileManager.CONCURRENT_VIEWS_ASSOCIATION.get(k)){
						views.put(l, false);
					}
				}
			}
			
			enabledNum = 0;
		}

		void enableView(String view) {
			if (view == null) {
				clearAll();
			} else if (CHESSProfileManager.CONCURRENT_VIEWS.contains(view)) {
				clearNotConcurrent(view);
				views.put(view, true);
				++concurNum;
			} else {
				clearAll();
				views.put(view, true);
				++enabledNum;
				assert (enabledNum == 1);
			}
		}
		
		void disableView(String view){
			views.put(view, false);
			--concurNum;
		}
		

		/**
		 * Gets the names of the active design views.
		 * 
		 * If more that one design view is active then this method concatenates the names.
		 * 
		 * @return the resulting name.
		 */
		public String getName() {
			ArrayList<String> names = new ArrayList<String>();
			
			for (String v : CHESSProfileManager.CHESS_VIEWS_LIST) {
				if (views.get(v)) {
					names.add(v);
				}
			}
			
			if (names.size()==0)
				return CHESSProfileManager.NULL_VIEW;
			if (names.size()==1)
				return names.get(0);
			
			
			Collections.sort(names);
			
			StringBuffer name = new StringBuffer();
			
			for (int i = 0; i < names.size() - 1; i++) {
				name.append(names.get(i)).append('-');
			}
			name.append(names.get(names.size()-1));
			
			return name.toString();
		}

		/**
		 * Checks is a view is enabled by providing its name.
		 * 
		 * @param view  the view name
		 * @return true if it is enable
		 */
		public boolean isEnabled(String view) {
			return views.get(view);
		}
		
		/**
		 * Returns the current active diagram name
		 * 
		 * @return the name of the active diagram
		 */
		public String getCurrentDiagramName(){
			return currentDiagram;
		}

		/**
		 * Returns the permissions associated with the view and the diagram provided by name.
		 * 
		 * @param view  the name of the view
		 * @param diagram  the name of the diagram
		 * @return the {@link PermissionList} associated with the view and the diagram
		 */
		private PermissionList getViewPermissions(String view, String diagram) {
			
			if (diagram.equals(ViewDiagramAssociations.ANYDIAGRAM)){
				return ViewPermissions.permissions.get(view).get(diagram);
			}else{
				PermissionList list = new PermissionList();
				PermissionList d = ViewPermissions.permissions.get(view).get(ViewDiagramAssociations.ANYDIAGRAM);
				if (d != null)
					list.addAll(d);
				String actualDiagram = ViewDiagramAssociations.papyrusNames2Standard.get(diagram);
				HashMap<String, PermissionList> viewPermissions = ViewPermissions.permissions.get(view);
				d = viewPermissions.get(actualDiagram);
				if (d != null)
					list.addAll(d);
				return list;
			}
		}
		
		/**
		 * Returns all the enabled permissions based on the enabled views.
		 * 
		 * @return the {@link PermissionList} with all the enabled permissions
		 */
		public PermissionList getEnabledPermissions() {
			//TODO code must be refactored to avoid continuous generation of permissions!

			if (concurNum > 1) {
				PermissionList union = new PermissionList();
				for (String v : CHESSProfileManager.CONCURRENT_VIEWS) {
					if (views.get(v)) {
						union.addAll(getViewPermissions(v, currentDiagram));
					}
				}
				return union;
			}
			for (String v : CHESSProfileManager.CHESS_VIEWS_LIST) {
				if (views.get(v)) {
					return getViewPermissions(v, currentDiagram);
				}
			}
			return null;
		}
		
		
		/**
		 * Returns all the enabled permissions based on the given views.
		 * 
		 * @return the {@link PermissionList} with all the enabled permissions
		 */
		public PermissionList getEnabledPermissions(String viewName) {
			
			if (concurNum > 1) {
				PermissionList union = new PermissionList();
				for (String v : CHESSProfileManager.CONCURRENT_VIEWS) {
					if (v.equals(viewName))
						union.addAll(getViewPermissions(v, currentDiagram));
				}
				return union;
			}
			for (String v : CHESSProfileManager.CHESS_VIEWS_LIST) {
				if (v.equals(viewName)) {
					return getViewPermissions(v, currentDiagram);
				}
			}
			return null;
		}
		
		/**
		 * Checks if the diagram passed as a parameter is allowed in the enabled views.
		 * 
		 * A diagram is allowed in a view if that view contains a permissions list for the diagram.
		 * 
		 * @param diagram  the diagram
		 * @return true if the diagram is allowed
		 */
		public boolean isDiagramAllowed(final Diagram diagram) {
			if (concurNum > 1) {
				for (String v : CHESSProfileManager.CONCURRENT_VIEWS) {
					HashSet<String> h;
					if (views.get(v) &&
					    null != (h = ViewDiagramAssociations.viewDiagramsAssociation.get(v))) {
						if (h.contains(diagram.getType())) {
							return true;
						}
					}
				}
				return false;
			} else {
				for (String v : CHESSProfileManager.CHESS_VIEWS_LIST) {
					HashSet<String> h;
					if (views.get(v) &&
						null != (h = ViewDiagramAssociations.viewDiagramsAssociation.get(v))) {
						return (h.contains(diagram.getType()));
					}
				}
				return false;
			}
		}

	
	}

	// private IPage currentDiagram;

	/**
	 * Represents the concrete view, that is the design view associated to the root Package
	 * containing all the elements that model a specific concern.
	 */
	private Package actualView;

	private DesignView currentDesignView = new DesignView();

	private HashMap<String, Boolean> concurrentToggles = new HashMap<String, Boolean>(CHESSProfileManager.CONCURRENT_VIEWS.size());

	private boolean isUser = true;

	private boolean superuser = false;

	private Stack<String> lastToggledView = new Stack<String>();

	public DiagramStatus() {
		disableAllToggles();
	}

	/**
	 * Creates the DiagramStatus service given the initial {@link IPage} that corresponds to a Papyrus diagram
	 * 
	 * @param initialDiagram  the initial IPage that corresponds to a Papyrus diagram
	 */
	public DiagramStatus(IPage initialDiagram) {
		disableAllToggles();
		setActualView(initialDiagram);
		
	}

	private void disableAllToggles() {
		for (String view : CHESSProfileManager.CONCURRENT_VIEWS) {
			concurrentToggles.put(view, false);
		}
	}

	/*@Deprecated
	public Package getActualView() {
		return actualView;
	}*/

	public synchronized DesignView getCurrentView() {
		if (actualView == null)
			return null;
		return currentDesignView;
	}

	/**
	 * Request the extra-functional view, and return whether the extra functional
	 * view is being activated or not
	 * 
	 * @param view  the name of the requested view
	 * @param activate  true to request the view and activate it, false to deactivate it
	 * @return
	 */
	private boolean requestConcurrentView(String view, boolean activate) {
		concurrentToggles.put(view, activate);
		if (activate)
			lastToggledView.push(view);
		else if (lastToggledView.peek().equals(view))
			lastToggledView.pop();
		setCurrentView();
		return concurrentToggles.get(view);
	}
	
	/**
	 * Returns the name of the active view.
	 * 
	 * @return the name of the active view
	 */
	public String getActiveView(){
		return lastToggledView.peek();
	}

	/**
	 * Request the activation/deactivation of a view given its name.
	 * 
	 * 
	 * @param view  the name of the view
	 * @param activate  true to request the activation, false to request the deactivation
	 * @return  true when the request succeed
	 */
	public boolean requestView(String view, boolean activate) {
		if (CHESSProfileManager.CONCURRENT_VIEWS.contains(view))
			return requestConcurrentView(view, activate);
		return false;
	}

	/**
	 * Set the actual view given a diagram represented by an {@link IPage}
	 * 
	 * @param currentDiagram  the diagram
	 */
	public synchronized void setActualView(IPage currentDiagram) {
  		if (currentDiagram != null) {
			if (((PageRef) currentDiagram.getRawModel()).getEmfPageIdentifier() instanceof Diagram) {
				Diagram dg = ((Diagram) ((PageRef) currentDiagram.getRawModel())
						.getEmfPageIdentifier());
				Package newActualView = currentDiagram == null ? null : ViewUtils
						.getView(dg.getElement());
				// System.out.println(actualView == null ? "null view" :
				// actualView.getName());
				currentDesignView.currentDiagram = dg.getType();
				
				if (actualView != null && 
						newActualView != null){
					
					String av = InternalViewUtils.getViewName(actualView);
					String nv = InternalViewUtils.getViewName(newActualView);
					
					if (av!= null && nv!=null && !av.equals(nv)){
						disableAllToggles();
					}
				}
					
				
				actualView = newActualView;
				
				setCurrentView();
			}
		}
	}

	/**
	 * Sets the actual view given the tree selection.
	 * 
	 * @param currentTreeViewSelection  the tree selection
	 */
	public synchronized void setActualView(
			TreeSelection currentTreeViewSelection) {
		TreeSelection tSelection = currentTreeViewSelection;
		EObjectTreeElement elem = (EObjectTreeElement) tSelection.getFirstElement();
		
		Package newActualView = currentTreeViewSelection == null ? null : ViewUtils
				.getView(elem.getEObject());
		
		currentDesignView.currentDiagram = ViewDiagramAssociations.ANYDIAGRAM;
		
		if (actualView != null && !InternalViewUtils.getViewName(actualView).equals(InternalViewUtils.getViewName(newActualView)))
			disableAllToggles();
		
		actualView = newActualView;
		
		setCurrentView();
	}

	private synchronized void setCurrentView() {
		if (actualView == null) {
			currentDesignView.enableView(null);
			lastToggledView.removeAllElements();
			disableAllToggles();
		} else if (ViewUtils.hasConcurrentViews(InternalViewUtils.getViewName(actualView))) {
			// inspect toggles
			boolean toggled = false;
			for (String concurrentView : CHESSProfileManager.CONCURRENT_VIEWS_ASSOCIATION.get(InternalViewUtils.getViewName(actualView))) {
				if (concurrentToggles.get(concurrentView)){
					currentDesignView.enableView(concurrentView);
//					if (concurrentView.equals(lastToggledView))
						toggled = true;
				} else {
					currentDesignView.disableView(concurrentView);
				}
			}
			if (!toggled) {
				
				//lastToggledView = ViewUtils.getViewName(actualView);
				lastToggledView.removeAllElements();
				lastToggledView.push(InternalViewUtils.getViewName(actualView));
				currentDesignView.enableView(InternalViewUtils.getViewName(actualView));
			}
		} else {
			// if this views has no concurrent views,
			// match currentView with actualView and disable toggles
			//lastToggledView = ViewUtils.getViewName(actualView);
			lastToggledView.removeAllElements();
			lastToggledView.push(InternalViewUtils.getViewName(actualView));
			currentDesignView.enableView(InternalViewUtils.getViewName(actualView));
			disableAllToggles();
		}
	}

	/**
	 * Set if the action is done by the user or is done by something else.
	 * 
	 * For example an automated action is not a user action.
	 * An automated action usually undergo less permission checks.
	 * 
	 * @param b  true to set the action to true.
	 */
	public synchronized void setUserAction(boolean b) {
		isUser = b;
	}
	
	/**
	 * Checks if the action is done by the user or not.
	 */
	public boolean isUserAction(){
		return isUser;
	}

	/**
	 * Checks if the DiagramStatus service is in superuser mode.
	 * 
	 * In this mode permissions are not checked.
	 * 
	 * @return true if DiagramStatus is in superuser mode.
	 */
	public boolean isSuperuser() {
		return superuser;
	}
	
	/**
	 * Sets the superuser mode.
	 * 
	 * @param b  true to set the superuser mode, false otherwise
	 */
	public void setSuperuser(boolean b){
		superuser = b;
	}
	

}
