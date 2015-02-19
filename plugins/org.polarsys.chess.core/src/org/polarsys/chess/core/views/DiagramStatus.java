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
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.impl.EObjectTreeElementImpl;
import org.eclipse.papyrus.infra.core.sasheditor.editor.IPage;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageRef;
import org.eclipse.uml2.uml.Package;
import org.polarsys.chess.core.profiles.CHESSProfileManager;
import org.polarsys.chess.core.views.permissions.EntryId;
import org.polarsys.chess.core.views.permissions.PermissionList;


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
		
//		private String getBaseViewName(String concurrentView){
//			for(String baseView : CHESSProfileManager.CONCURRENT_VIEWS_ASSOCIATION.keySet()){
//				for (String cView : CHESSProfileManager.CONCURRENT_VIEWS_ASSOCIATION.get(baseView)) {
//					if (cView.equals(concurrentView))
//						return baseView;
//				}
//			}
//			return null;
//		}

		public String getName() {
			ArrayList<String> names = new ArrayList<String>();
			
			for (String v : CHESSProfileManager.CHESS_VIEWS_LIST) {
				if (views.get(v) == true) {
					names.add(v);
				}
			}
			
			if (names.size()==0)
				return CHESSProfileManager.NULL_VIEW;
			if (names.size()==1)
				return names.get(0);
			
			
			Collections.sort(names);
			
			StringBuffer name = new StringBuffer();
			int count = 0;
			for (String v : names) {
				count++;
				if (count > 1)
					name.append('-');
				name.append(v);
			}
			return name.toString();
		}

		public boolean isEnabled(String view) {
			return views.get(view);
		}

//		public void setPermissions(String view, PermissionList list) {
//			ViewPermissions.permissions.put(view, list);
//		}
		
		public String getCurrentDiagramName(){
			return currentDiagram;
		}

		public PermissionList getViewPermissions(String view, String diagram) {
			
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
		
		private PermissionList getEnabledPermissions() {
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
		
		public boolean checkPermission(EntryId entryId, byte permission) {
			//TODO code must be refactored to avoid continuous generation of permissions!
			if (entryId.isANY())
				return true;
			PermissionList l = getEnabledPermissions();
			if (l != null && !l.checkPermission(entryId, permission))
				return false;
			return true;
		}

		public boolean isDiagramAllowed(Diagram d) {
			if (concurNum > 1) {
				for (String v : CHESSProfileManager.CONCURRENT_VIEWS) {
					HashSet<String> h;
					if (views.get(v) &&
					    null != (h = ViewDiagramAssociations.viewDiagramsAssociation.get(v))) {
						if (h.contains(d.getType())) {
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
						return (h.contains(d.getType()));
					}
				}
				return false;
			}
		}

	
	}

	// private IPage currentDiagram;

	private Package actualView;

	private DesignView currentView = new DesignView();

	//private boolean extraFunctionalToggle;
	private HashMap<String, Boolean> concurrentToggles = new HashMap<String, Boolean>(CHESSProfileManager.CONCURRENT_VIEWS.size());

	private boolean isUser = true;

	private boolean superuser = false;

	private Stack<String> lastToggledView = new Stack<String>();

	public DiagramStatus() {
		disableAllToggles();
	}

	public DiagramStatus(IPage initialDiagram) {
		// this.currentDiagram = initialDiagram;
		// setActualView(currentDiagram);
		disableAllToggles();
		setActualView(initialDiagram);
		
	}

	private void disableAllToggles() {
		//extraFunctionalToggle = false;
		for (String view : CHESSProfileManager.CONCURRENT_VIEWS) {
			concurrentToggles.put(view, false);
		}
	}

	@Deprecated
	public Package getActualView() {
		return actualView;
	}

	// public IPage getCurrentIPage() {
	// return currentDiagram;
	// }

	public synchronized DesignView getCurrentView() {
		if (actualView == null)
			return null;
		return currentView;
	}

	/**
	 * Request extra functional view, and return whether the extra functional
	 * view is being activated or not
	 */
//	private boolean requestExtraFunctionalView(boolean yes) {
////		extraFunctionalToggle = yes;
//		concurrentToggles.put(CHESSProfileManager.EXTRAFUNCTIONAL_VIEW, yes);
//		setCurrentView();
////		return extraFunctionalToggle;
//		return concurrentToggles.get(CHESSProfileManager.EXTRAFUNCTIONAL_VIEW);
//	}
	
	private boolean requestConcurrentView(String view, boolean yes) {
		concurrentToggles.put(view, yes);
		if (yes)
			lastToggledView.push(view);
		else if (lastToggledView.peek().equals(view))
			lastToggledView.pop();
		setCurrentView();
		return concurrentToggles.get(view);
	}
	
	public String getActiveView(){
		return lastToggledView.peek();
	}

	public boolean requestView(String view, boolean b) {
//		if (view.equals(CHESSProfileManager.EXTRAFUNCTIONAL_VIEW))
//			return requestExtraFunctionalView(b);
		if (CHESSProfileManager.CONCURRENT_VIEWS.contains(view))
			return requestConcurrentView(view, b);
		return false;
	}

	public synchronized void setActualView(IPage currentDiagram) {
		// this.currentDiagram = currentDiagram;
		if (currentDiagram != null) {
			if (((PageRef) currentDiagram.getRawModel()).getEmfPageIdentifier() instanceof Diagram) {
				Diagram dg = ((Diagram) ((PageRef) currentDiagram.getRawModel())
						.getEmfPageIdentifier());
				Package newActualView = currentDiagram == null ? null : ViewUtils
						.getView(dg.getElement());
				// System.out.println(actualView == null ? "null view" :
				// actualView.getName());
				currentView.currentDiagram = dg.getType();
				
				if (actualView != null && 
						newActualView != null){
					
					String av = ViewUtils.getViewName(actualView);
					String nv = ViewUtils.getViewName(newActualView);
					
					if (av!= null && nv!=null && !av.equals(nv)){
						disableAllToggles();
					}
				}
					
				
				actualView = newActualView;
				
				setCurrentView();
			}
			/*
			 * else if (
			 * ((PageRef)currentDiagram.getRawModel()).getEmfPageIdentifier()
			 * instanceof EObject ) { EObject ob =
			 * (EObject)(((PageRef)currentDiagram
			 * .getRawModel()).getEmfPageIdentifier()); ob.
			 * 
			 * }
			 */
		}
	}

	public synchronized void setActualView(
			TreeSelection currentTreeViewSelection) {
		TreeSelection tSelection = currentTreeViewSelection;
		EObjectTreeElementImpl elem = (EObjectTreeElementImpl) tSelection.getFirstElement();
		
		Package newActualView = currentTreeViewSelection == null ? null : ViewUtils
				.getView(elem.getEObject());
		
		currentView.currentDiagram = ViewDiagramAssociations.ANYDIAGRAM;
		
		if (actualView != null && !ViewUtils.getViewName(actualView).equals(ViewUtils.getViewName(newActualView)))
			disableAllToggles();
		
		actualView = newActualView;
		
		setCurrentView();
		// System.out.println(currentView == null ? "null view" :
		// currentView.getName());
	}

//	private synchronized void setCurrentViewOLD() {
//		if (actualView == null) {
//			currentView.enableView(null);
//		} else if (ViewUtils.isComponentView(actualView)) {
//			// inspect toggles
//			if (extraFunctionalToggle) {
//				currentView
//						.enableView(CHESSProfileManager.EXTRAFUNCTIONAL_VIEW);
//			} else {
//				currentView.enableView(ViewUtils.getViewName(actualView));
//			}
//		} else {
//			// match currentView with actualView and disable toggles
//			currentView.enableView(ViewUtils.getViewName(actualView));
//			disableAllToggles();
//		}
//	}
	
	private synchronized void setCurrentView() {
		if (actualView == null) {
			currentView.enableView(null);
			lastToggledView.removeAllElements();
			disableAllToggles();
		} else if (ViewUtils.hasConcurrentViews(ViewUtils.getViewName(actualView))) {
			// inspect toggles
			boolean toggled = false;
			for (String concurrentView : CHESSProfileManager.CONCURRENT_VIEWS_ASSOCIATION.get(ViewUtils.getViewName(actualView))) {
				if (concurrentToggles.get(concurrentView)){
					currentView.enableView(concurrentView);
//					if (concurrentView.equals(lastToggledView))
						toggled = true;
				} else {
					currentView.disableView(concurrentView);
				}
			}
			if (!toggled) {
				
				//lastToggledView = ViewUtils.getViewName(actualView);
				lastToggledView.removeAllElements();
				lastToggledView.push(ViewUtils.getViewName(actualView));
				currentView.enableView(ViewUtils.getViewName(actualView));
			}
		} else {
			// if this views has no concurrent views,
			// match currentView with actualView and disable toggles
			//lastToggledView = ViewUtils.getViewName(actualView);
			lastToggledView.removeAllElements();
			lastToggledView.push(ViewUtils.getViewName(actualView));
			currentView.enableView(ViewUtils.getViewName(actualView));
			disableAllToggles();
		}
	}

	//set if the action is done by the user or is done by something else:
	//for example an automated action is not a user action
	public synchronized void setUserAction(boolean b) {
		isUser = b;
	}
	public boolean isUserAction(){
		return isUser;
	}

	public boolean isSuperuser() {
		return superuser;
	}
	
	public void setSuperuser(boolean b){
		superuser = b;
	}
	

}
