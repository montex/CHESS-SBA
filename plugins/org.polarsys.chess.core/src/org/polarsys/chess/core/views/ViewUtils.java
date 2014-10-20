/*
-----------------------------------------------------------------------
--          			CHESS core plugin							 --
--                                                                   --
--                    Copyright (C) 2011-2012                        --
--                 University of Padova, ITALY                       --
--                                                                   --
-- All rights reserved. This program and the accompanying materials  --
-- are made available under the terms of the Eclipse Public License  --
-- v1.0 which accompanies this distribution, and is available at     --
-- http://www.eclipse.org/legal/epl-v10.html                         --
-----------------------------------------------------------------------
*/

package org.polarsys.chess.core.views;

import java.util.ArrayList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.uml.tools.listeners.PapyrusStereotypeListener;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.polarsys.chess.core.profiles.CHESSProfileManager;
import org.polarsys.chess.core.util.CHESSProjectSupport;
import org.polarsys.chess.core.views.DiagramStatus.DesignView;
import org.polarsys.chess.core.views.permissions.EntryId;
import org.polarsys.chess.core.views.permissions.PermissionEntry;
 



/**
 * @author Alessandro Zovi
 */
public class ViewUtils {

	public static Package getView(EObject ob) {
		if (ob == null)
			return null;
		Package pkg = null;
		if (ob instanceof Package) {
			pkg = (Package) ob;
	
			if (hasViewStereotypeApplied(pkg))
				return pkg;
		}
	
		return getView(ob.eContainer());
	}

	public static String getViewName(Package pkg) {
		Stereotype s = ViewUtils.getViewStereotypeApplied(pkg);
		return s != null ? s.getName() : null;
	}

	public static Stereotype getViewStereotypeApplied(Package pkg) {
		if (pkg == null)
			return null;
		EList<Stereotype> list = pkg.getAppliedStereotypes();
		for (Stereotype stereotype : list) {
			if (isViewStereotype(stereotype)) {
				return stereotype;
			}
		}
		return null;
	}

	public static Package getViewWithThrows(EObject ob) throws Exception {
		if (ob == null)
			throw new Exception("containing object is null");
		Package pkg = null;
		if (ob instanceof Package) {
			pkg = (Package) ob;
	
			if (hasViewStereotypeApplied(pkg))
				return pkg;
		}
	
		return getViewWithThrows(ob.eContainer());
	}

	public static boolean hasViewStereotypeApplied(Package pkg) {
		EList<Stereotype> list = pkg.getAppliedStereotypes();
		for (Stereotype stereotype : list) {
			if (ViewUtils.isViewStereotype(stereotype)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isDeploymentView(DesignView view) {
		return view == null ? false : view.isEnabled(CHESSProfileManager.DEPLOYMENT_VIEW);
	}

	public static boolean isDeploymentView(Package pkg) {
		EList<Stereotype> list = pkg.getAppliedStereotypes();
		for (Stereotype stereotype : list) {
			if (stereotype.getName()
					.equals(CHESSProfileManager.DEPLOYMENT_VIEW))
				return true;
		}
		return false;
	}
	
	public static boolean isRTAnalysisView(Package pkg) {
		EList<Stereotype> list = pkg.getAppliedStereotypes();
		for (Stereotype stereotype : list) {
			if (stereotype.getName()
					.equals(CHESSProfileManager.RT_ANALYSIS_VIEW))
				return true;
		}
		return false;
	}
	
	public static boolean isDependabilityAnalysisView(DesignView view) {
		return view == null ? false : view.isEnabled(CHESSProfileManager.DEPENDABILITY_ANALYSIS_VIEW);
	}

	@Deprecated
	public static boolean isElementWritable(Element element, DesignView currentView) {
		Package view = null;
		if ((view = getView(element.eContainer())) != null
				&& currentView != null) {
			String viewName = getViewName(view);
			return currentView.isEnabled(viewName);
		}
		return true;
	}
	
	public static boolean isElementWritable_(EObject element, Object feature,
			DesignView currentView) {
		if (currentView != null) {
			ArrayList<EntryId> ids = EntryId.computeEntryIds_(element, feature);
			return checkIdPermission(ids, currentView, PermissionEntry.WRITABLE);
		}
		return false;
	}
	
	public static boolean isElementInstantiable(EObject element, Object feature,
			DesignView currentView) {
		if (currentView != null) {
			ArrayList<EntryId> ids = EntryId.computeEntryIds_(element, feature);
			return checkIdPermission(ids, currentView, PermissionEntry.OWNER);
		}
		return false;
	}
	
	
	public static boolean isStereotypeWritable(EObject element, Object feature, Object stereotype, DesignView currentView) {
		if (currentView != null) {
			ArrayList<EntryId> ids = EntryId.computeStereotypeEntryIds(element, feature, stereotype);
			//an element is writable iff all of the permission entry it matches have write rights
			return checkIdPermission(ids, currentView, PermissionEntry.WRITABLE);
		}
		return false;
	}

	public static boolean isStereotypeInstantiable(EObject element, Object feature, Object stereotype, DesignView currentView) {
		if (currentView != null) {
			ArrayList<EntryId> ids = EntryId.computeStereotypeEntryIds(element, feature, stereotype);
			return checkIdPermission(ids, currentView, PermissionEntry.OWNER);
		}
		return false;
	}
	
	private static boolean checkIdPermission(ArrayList<EntryId> ids,
			DesignView currentView, byte permission) {
		//an element is writable iff all of the permission entry it matches have write rights
		//unless it matches multiple permission with id2<>* (stereotype),in that case it is writable
		//if at least one entry have write rights
		if (ids.isEmpty())
			return true;
		boolean res4Stereo = false;
		for (EntryId entryId : ids) {
			CHESSProjectSupport.printlnToCHESSConsole(entryId.toString());
			boolean perm = currentView.checkPermission(entryId, permission);
			if (entryId.getStereotype().equals(entryId.NONE)){
				if (!perm)
					return false;
			} 
			
			res4Stereo = res4Stereo || perm;
			
		}
		return res4Stereo;
	}
	

	public static boolean isExtraFunctionalView(DesignView view) {
		return view == null ? false : view.isEnabled(CHESSProfileManager.EXTRAFUNCTIONAL_VIEW);
	}

	public static boolean isExtraFunctionalView(Package pkg) {
		EList<Stereotype> list = pkg.getAppliedStereotypes();
		for (Stereotype stereotype : list) {
			if (stereotype.getName().equals(
					CHESSProfileManager.EXTRAFUNCTIONAL_VIEW))
				return true;
		}
		return false;
	}

	public static boolean isComponentView(DesignView view) {
		//return view.isEnabled(CHESSProfileManager.FUNCTIONAL_VIEW);
		return view == null ? false : view.isEnabled(CHESSProfileManager.COMPONENT_VIEW);
	}

	public static boolean isComponentView(Package pkg) {
		if ( pkg != null )
		{
			EList<Stereotype> list = pkg.getAppliedStereotypes();
			for (Stereotype stereotype : list) {
				if (stereotype.getName().equals(CHESSProfileManager.COMPONENT_VIEW/*CHESSProfileManager.FUNCTIONAL_VIEW*/))
					return true;
			}
		}
		return false;
	}

	private static boolean isRequirementView(Package pkg) {
		if ( pkg != null )
		{
			EList<Stereotype> list = pkg.getAppliedStereotypes();
			for (Stereotype stereotype : list) {
				if (stereotype.getName().equals(CHESSProfileManager.REQUIREMENT_VIEW))
					return true;
			}
		}
		return false;
	}

	private static boolean isSystemView(Package pkg) {
		if ( pkg != null )
		{
			EList<Stereotype> list = pkg.getAppliedStereotypes();
			for (Stereotype stereotype : list) {
				if (stereotype.getName().equals(CHESSProfileManager.SYSTEM_VIEW))
					return true;
			}
		}
		return false;
	}
	
	public static boolean isPSMView(Package pkg) {
		if ( pkg != null )
		{
			EList<Stereotype> list = pkg.getAppliedStereotypes();
			for (Stereotype stereotype : list) {
				if (stereotype.getName().equals(CHESSProfileManager.PSM_VIEW))
					return true;
			}
		}
		return false;
	}
	
	public static boolean isView(EObject notifier) {
		if (notifier instanceof Package
				&& hasViewStereotypeApplied((Package) notifier))
			return true;
		if (CHESSProfileManager.CHESS_VIEWS_LIST.contains((notifier.eClass().getName())))
			return true;
		return false;
	}

	public static boolean isViewModifiedOrRemoved(ENotificationImpl notification) {
		Object el = notification.getNotifier();
		
		if (notification.getEventType() == PapyrusStereotypeListener.APPLIED_STEREOTYPE 
				|| notification.getEventType() == PapyrusStereotypeListener.UNAPPLIED_STEREOTYPE
				|| notification.getEventType() == PapyrusStereotypeListener.MODIFIED_STEREOTYPE){
			Object st = notification.getNewValue();
			if (el instanceof EObject && st instanceof EObject){
				String viewName = ((EObject) st).eClass().getName();
				return (CHESSProfileManager.CHESS_VIEWS_LIST.contains(viewName));
			}
		}
		if (notification.getEventType() == Notification.REMOVE){
			Object o = notification.getOldValue();
			if (o instanceof EObject){
				return isView((EObject) o);
			}
		}
		if (el instanceof DynamicEObjectImpl) {
			DynamicEObjectImpl d = (DynamicEObjectImpl) el;
			Stereotype stereo = UMLUtil.getStereotype(d);
			return isViewStereotype(stereo);
		}
		if (notification.getEventType() == Notification.SET){
			if (el instanceof EObject)
				return isView((EObject)el);
		}
		
		
		return false;
	}

//	public static boolean isElementWritable(Element element, Package currentView) {
//		Package view = null;
//		if ((view = getView(element.eContainer())) != null
//				&& currentView != null) {
//			Stereotype viewStereotype = getViewStereotypeApplied(view);
//			Stereotype currentViewStereotype = getViewStereotypeApplied(currentView);
//			if (!viewStereotype.equals(currentViewStereotype)) {
//				return false;
//			}
//		}
//		return true;
//	}

	public static boolean isViewStereotype(Stereotype stereotype) {
		if (CHESSProfileManager.CHESS_VIEWS_LIST.contains(stereotype.getName()))
			return true;
		return false;
	}

	public static boolean isConcurrentView(DesignView currentView) {
		if (currentView == null)
			return false;
		for (String view : CHESSProfileManager.CONCURRENT_VIEWS) {
			if (currentView.isEnabled(view))
				return true;
		}
		return false;
	}
	
	public static boolean isOnView(DesignView currentView, String view) {
		if (currentView == null)
			return false;
		
		for(String v : CHESSProfileManager.CONCURRENT_VIEWS_ASSOCIATION.get(view)){
			if (currentView.isEnabled(v))
				return true;
		}
		return false;
	}
	
	public static Package getCHESSRequirementPackage(Model theModel) {
		for (Element p : theModel.allOwnedElements()) {
			if (p instanceof Package)
				if (isRequirementView((Package)p))
					return (Package) p;
		}
		return (Package)theModel;
	}

	public static Package getCHESSSystemPackage(Model theModel) {
		for (Element p : theModel.allOwnedElements()) {
			if (p instanceof Package)
				if (isSystemView((Package)p))
					return (Package) p;
		}
		return (Package)theModel;
	}

	public static Package getCHESSRtAnalysisPackage(Model theModel) {
		for (Element p : theModel.allOwnedElements()) {
			if (p instanceof Package)
				if (isRTAnalysisView((Package)p))
					return (Package) p;
		}
		return (Package)theModel;
	}
	
	public static Package getCHESSComponentPackage(Model theModel) {
		for (Element p : theModel.allOwnedElements()) {
			if (p instanceof Package)
				if (isComponentView((Package)p))
					return (Package) p;
		}
		return (Package)theModel;
	}
	
	public static Package getCHESSDeploymentPackage(Model theModel) {
		for (Element p : theModel.allOwnedElements()) {
			if (p instanceof Package)
				if (isDeploymentView((Package)p))
					return (Package) p;
		}
		return (Package)theModel;
	}
	
	public static Package getCHESSPSMPackage(Model theModel) {
		for (Element p : theModel.allOwnedElements()) {
			if (p instanceof Package)
				if (isPSMView((Package)p))
					return (Package) p;
		}
		return (Package)theModel;
	}

	public static boolean hasConcurrentViews(DesignView currentView) {
		for(String v : CHESSProfileManager.CONCURRENT_VIEWS_ASSOCIATION.keySet()){
			if(currentView.isEnabled(v))
				return true;
		}
		return false;
	}
	
	public static boolean hasConcurrentViews(String viewName) {
		return CHESSProfileManager.CONCURRENT_VIEWS_ASSOCIATION.keySet().contains(viewName);
	}
	
	public static String getBaseViewName(DesignView currentView) {
//		for(String baseView : CHESSProfileManager.CONCURRENT_VIEWS_ASSOCIATION.keySet()){
//			if(currentView.isEnabled(baseView))
//				return baseView;
//			for (String concurrentView : CHESSProfileManager.CONCURRENT_VIEWS_ASSOCIATION.get(baseView)) {
//				if (currentView.isEnabled(concurrentView))
//					return baseView;
//			}
//		}
		return currentView.getName();
	}	
	
}
