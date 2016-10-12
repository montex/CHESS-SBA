/*
-----------------------------------------------------------------------
--          			CHESS core plugin							 --
--                    Copyright (C) 2016                             --
--                 University of Padova, ITALY                       --
--                                                                   --
-- Authors: Alessandro Zovi          azovi@math.unipd.it             --
--          Laura Baracchi           laura.baracchi@intecs.it        --
--          Stefano Puri             stefano.puri@intecs.it          --
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
import org.eclipse.papyrus.uml.tools.listeners.PapyrusStereotypeListener;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.polarsys.chess.chessmlprofile.Core.Domain;
import org.polarsys.chess.core.internal.views.InternalViewUtils;
import org.polarsys.chess.core.internal.views.permissions.EntryId;
import org.polarsys.chess.core.internal.views.permissions.PermissionEntry;
import org.polarsys.chess.core.profiles.CHESSProfileManager;
import org.polarsys.chess.core.util.CHESSProjectSupport;
import org.polarsys.chess.core.views.DiagramStatus.DesignView;
 



/**
 * This class contains utility methods to deal with design views.
 */
public class ViewUtils {

	/**
	 * Gets the corresponding design view the model element resides in.
	 * 
	 * This method returns the 'physical' view of an element , hence the owning package
	 * stereotyped with the corresponding design view.
	 * 
	 * @param element  the model element 
	 * @return the Package stereotyped with the corresponding design view
	 */
	public static /*@Nonnull*/Package getView(final EObject element) {
		if (element == null)
			return null;
		Package pkg = null;
		if (element instanceof Package) {
			pkg = (Package) element;
	
			if (InternalViewUtils.hasViewStereotypeApplied(pkg))
				return pkg;
		}
	
		return getView(element.eContainer());
	}

	/**
	 * Checks if the current design view (represented by the DesignView parameter) is the deployment view.
	 * 
	 * @deprecated use {@link #isDesignView(DesignView, String)} instead.
	 * 
	 * @param view  the design view, can be null
	 * @return true if it is the deployment view, false otherwise
	 */
	@Deprecated
	public static boolean isDeploymentView(/*@Nullable*/final DesignView view) {
		return view == null ? false : view.isEnabled(CHESSProfileManager.DEPLOYMENT_VIEW);
	}
	
	/**
	 * Checks if the current design view has the corresponding name.
	 * 
	 * If the name passed does not corresponds to a predefined design view an {@link IllegalArgumentException} is raised.
	 * 
	 * Typical usage:
	 * <code>
	 * //check if the current view is a deployment view
	 * //get the DesignView service
	 * designViewService = ...
	 * isDeploymentView = ViewUtils.isDesignView(designViewService, CHESSProfileManager.DEPLOYMENT_VIEW);
	 * </code>
	 * 
	 * @param view  the design view, can be null
	 * @param name  the name of the design view to check against
	 * @return true if it is the desired view, false otherwise
	 */
	public static boolean isDesignView(/*@Nullable*/final DesignView view, final String name) {
		if (view == null)
			return false;
		if (!CHESSProfileManager.CHESS_VIEWS_LIST.contains(name))
			throw new IllegalArgumentException("Invalid design view name");
		return view.isEnabled(name);
	}
	
	/**
	 * Checks if the {@link Package} passed as a parameter represents an actual design view.
	 * 
	 * @param pkg  the package to check
	 * @param name  the design view name
	 * @return  true if the package represents the desired design view, false otherwise
	 */
	public static boolean isDesignView(final Package pkg, final String name) {
		EList<Stereotype> list = pkg.getAppliedStereotypes();
		for (Stereotype stereotype : list) {
			if (stereotype.getName()
					.equals(name))
				return true;
		}
		return false;
	}

	/**
	 * @deprecated use isDesignView(pkg, CHESSProfileManager.DEPLOYMENT_VIEW)
	 * 
	 */
	@Deprecated
	public static boolean isDeploymentView(final Package pkg) {
		EList<Stereotype> list = pkg.getAppliedStereotypes();
		for (Stereotype stereotype : list) {
			if (stereotype.getName()
					.equals(CHESSProfileManager.DEPLOYMENT_VIEW))
				return true;
		}
		return false;
	}
	
	/**
	 * @deprecated use isDesignView(pkg, CHESSProfileManager.RT_ANALYSIS_VIEW)
	 */
	@Deprecated
	public static boolean isRTAnalysisView(Package pkg) {
		EList<Stereotype> list = pkg.getAppliedStereotypes();
		for (Stereotype stereotype : list) {
			if (stereotype.getName()
					.equals(CHESSProfileManager.RT_ANALYSIS_VIEW))
				return true;
		}
		return false;
	}
	
	/**
	 * @deprecated use isDesignView(pkg, CHESSProfileManager.DEPENDABILITY_ANALYSIS_VIEW)
	 */
	@Deprecated
	public static boolean isDependabilityAnalysisView(DesignView view) {
		return view == null ? false : view.isEnabled(CHESSProfileManager.DEPENDABILITY_ANALYSIS_VIEW);
	}

	/**
	 * Checks if the current view has write access to (i.e can edit) the element/feature passed.
	 * 
	 * @param element  the model element
	 * @param feature  the feature
	 * @param currentView  the DesignView service
	 * @return true if the design view can write on the element
	 */
	public static boolean isElementWritable_(EObject element, Object feature,
			DesignView currentView, Domain theDomain) {
		if (currentView != null) {
			ArrayList<EntryId> ids = EntryId.computeEntryIds_(element, feature);
			return checkIdPermission(ids, currentView, PermissionEntry.WRITABLE, theDomain);
		}
		return false;
	}
	
	
	/**
	 * Checks if the given view has write access to (i.e can edit) the element/feature passed.
	 * 
	 * @param element  the model element
	 * @param feature  the feature
	 * @param viewName  the view's name
	 * @return true if the view can write on the element
	 */
	public static boolean isElementWritable_(EObject element, Object feature,
			String viewName, DesignView currentView, Domain theDomain) {
		if (viewName != null) {
			ArrayList<EntryId> ids = EntryId.computeEntryIds_(element, feature);
			return checkIdPermission(ids, viewName, PermissionEntry.WRITABLE, currentView, theDomain);
		}
		return false;
	}
	
	
	/**
	 * Checks if the current view owns (i.e. can create) the element/feature passed.
	 * 
	 * @param element  the element
	 * @param feature  the feature
	 * @param currentView  the DesignView service
	 * @return true if the design view owns the element
	 */
	public static boolean isElementInstantiable(EObject element, Object feature,
			DesignView currentView, Domain theDomain) {
		if (currentView != null) {
			ArrayList<EntryId> ids = EntryId.computeEntryIds_(element, feature);
			return checkIdPermission(ids, currentView, PermissionEntry.OWNER, theDomain);
		}
		return false;
	}
	
	
	/**
	 * Checks if the current view can edit a stereotype
	 * 
	 * @param element  the element
	 * @param feature  the feature
	 * @param stereotype  the stereotype
	 * @param currentView  the DesignView service
	 * @return true if the view can edit the stereotype
	 */
	public static boolean isStereotypeWritable(EObject element, Object feature, 
			Object stereotype, DesignView currentView, Domain theDomain) {
		if (currentView != null) {
			ArrayList<EntryId> ids = EntryId.computeStereotypeEntryIds(element, feature, stereotype);
			//an element is writable iff all of the permission entry it matches have write rights
			return checkIdPermission(ids, currentView, PermissionEntry.WRITABLE, theDomain);
		}
		return false;
	}

	/**
	 * Checks if the current view can create a stereotype
	 * 
	 * @param element  the element
	 * @param feature  the feature
	 * @param stereotype  the stereotype
	 * @param currentView  the DesignView service
	 * @return true if the view can create the stereotype
	 */
	public static boolean isStereotypeInstantiable(EObject element, Object feature, Object stereotype, DesignView currentView, Domain theDomain) {
		if (currentView != null) {
			ArrayList<EntryId> ids = EntryId.computeStereotypeEntryIds(element, feature, stereotype);
			return checkIdPermission(ids, currentView, PermissionEntry.OWNER, theDomain);
		}
		return false;
	}
	
	private static boolean checkIdPermission(ArrayList<EntryId> ids,
			DesignView currentView, byte permission, Domain theDomain) {
		//an element is writable iff all of the permission entry it matches have write rights
		//unless it matches multiple permission with id2<>* (stereotype), in that case it is writable
		//if at least one entry have write rights
		if (ids.isEmpty())
			return true;
		boolean res4Stereo = false;
		for (EntryId entryId : ids) {
			CHESSProjectSupport.printlnToCHESSConsole(entryId.toString());
			boolean perm = InternalViewUtils.checkPermission(currentView, entryId, permission, theDomain);
			if (entryId.getStereotype().equals(EntryId.NONE)){
				if (!perm)
					return false;
			} 
			
			res4Stereo = res4Stereo || perm;
			
		}
		return res4Stereo;
	}
	
	
	private static boolean checkIdPermission(ArrayList<EntryId> ids,
			String viewName, byte permission, DesignView currentView, Domain theDomain) {
		//an element is writable iff all of the permission entry it matches have write rights
		//unless it matches multiple permission with id2<>* (stereotype), in that case it is writable
		//if at least one entry have write rights
		if (ids.isEmpty())
			return true;
		boolean res4Stereo = false;
		for (EntryId entryId : ids) {
			CHESSProjectSupport.printlnToCHESSConsole(entryId.toString());
			boolean perm = InternalViewUtils.checkPermission(viewName, entryId, permission, currentView, theDomain);
			if (entryId.getStereotype().equals(EntryId.NONE)){
				if (!perm)
					return false;
			} 
			
			res4Stereo = res4Stereo || perm;
			
		}
		return res4Stereo;
	}
	

	/**
	 * @deprecated use isDesignView(pkg, CHESSProfileManager.EXTRAFUNCTIONAL_VIEW)
	 */
	public static boolean isExtraFunctionalView(DesignView view) {
		return view == null ? false : view.isEnabled(CHESSProfileManager.EXTRAFUNCTIONAL_VIEW);
	}

	/**
	 * @deprecated use isDesignView(pkg, EXTRAFUNCTIONAL_VIEW)
	 */
	public static boolean isExtraFunctionalView(Package pkg) {
		EList<Stereotype> list = pkg.getAppliedStereotypes();
		for (Stereotype stereotype : list) {
			if (stereotype.getName().equals(
					CHESSProfileManager.EXTRAFUNCTIONAL_VIEW))
				return true;
		}
		return false;
	}

	/**
	 * @deprecated use isDesignView(pkg, CHESSProfileManager.COMPONENT_VIEW)
	 */
	public static boolean isComponentView(DesignView view) {
		//return view.isEnabled(CHESSProfileManager.FUNCTIONAL_VIEW);
		return view == null ? false : view.isEnabled(CHESSProfileManager.COMPONENT_VIEW);
	}

	/**
	 * @deprecated use isDesignView(pkg, COMPONENT_VIEW)
	 */
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

	/**
	 * @deprecated use isDesignView(pkg, REQUIREMENT_VIEW)
	 */
	public static boolean isRequirementView(Package pkg) {
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

	/**
	 * @deprecated use isDesignView(pkg, CHESSProfileManager.SYSTEM_VIEW)
	 */
	public static boolean isSystemView(Package pkg) {
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
	
	/**
	 * @deprecated use isDesignView(pkg, CHESSProfileManager.PSM_VIEW)
	 */
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
	
	/**
	 * Checks if the stereotype of an actual view is modified or removed.
	 * 
	 * @param notification  
	 * @return
	 */
	public static boolean isViewModifiedOrRemoved(Notification notification) {
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
				return InternalViewUtils.isView((EObject) o);
			}
		}
		if (el instanceof DynamicEObjectImpl) {
			DynamicEObjectImpl d = (DynamicEObjectImpl) el;
			Stereotype stereo = UMLUtil.getStereotype(d);
			return isViewStereotype(stereo);
		}
		if (notification.getEventType() == Notification.SET){
			if (el instanceof EObject)
				return InternalViewUtils.isView((EObject)el);
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

	/**
	 * Checks if the stereotype passed as a parameter represents a design view.
	 * 
	 * @param stereotype  the stereotype
	 * @return true if the stereotype represents a design view
	 */
	public static boolean isViewStereotype(Stereotype stereotype) {
		if (CHESSProfileManager.CHESS_VIEWS_LIST.contains(stereotype.getName()))
			return true;
		return false;
	}

	/**
	 * Checks if the current design view is a virtual view
	 * 
	 * @param currentView  the DesignView service
	 * @return true if the current design view is a virtual view
	 */
	public static boolean isConcurrentView(DesignView currentView) {
		if (currentView == null)
			return false;
		for (String view : CHESSProfileManager.CONCURRENT_VIEWS) {
			if (currentView.isEnabled(view))
				return true;
		}
		return false;
	}
	
	/**
	 * 
	 * Checks if the virtual design view is enabled.
	 * 
	 * @param currentView  the DesignView service
	 * @param view  the name of the virtual design view to check
	 * @return true if it is enabled
	 */
	public static boolean isOnView(DesignView currentView, String view) {
		if (currentView == null)
			return false;
		
		for(String v : CHESSProfileManager.CONCURRENT_VIEWS_ASSOCIATION.get(view)){
			if (currentView.isEnabled(v))
				return true;
		}
		return false;
	}
	
	/**
	 * Returns the package representing the RTAnalysisView
	 * 
	 * @param theModel  the model
	 * @return the package representing the RTAnalysisView
	 */
	public static Package getCHESSRtAnalysisPackage(Model theModel) {
		for (Element p : theModel.allOwnedElements()) {
			if (p instanceof Package)
				if (isRTAnalysisView((Package)p))
					return (Package) p;
		}
		return (Package)theModel;
	}
	
	/**
	 * Returns the package representing the DeploymentView
	 * 
	 * @param theModel  the model
	 * @return the package representing the RTAnalysisView
	 */
	public static Package getCHESSDeploymentPackage(Model theModel) {
		for (Element p : theModel.allOwnedElements()) {
			if (p instanceof Package)
				if (isDeploymentView((Package)p))
					return (Package) p;
		}
		return (Package)theModel;
	}
	
	/**
	 * Returns the package representing the PSMView
	 * 
	 * @param theModel  the model
	 * @return the package representing the RTAnalysisView
	 */
	public static Package getCHESSPSMPackage(Model theModel) {
		for (Element p : theModel.allOwnedElements()) {
			if (p instanceof Package)
				if (isPSMView((Package)p))
					return (Package) p;
		}
		return (Package)theModel;
	}

	/**
	 * Checks if the current view has virtual views activated.
	 * For example if the COMPONENT_VIEW has also the EXTRAFUNCTIONAL_VIEW activated on top of it
	 * then this method returns true.
	 * 
	 * @param currentView  the DesignView service
	 * @return  true if there are virtual view activated.
	 */
	public static boolean hasConcurrentViews(DesignView currentView) {
		for(String v : CHESSProfileManager.CONCURRENT_VIEWS_ASSOCIATION.keySet()){
			if(currentView.isEnabled(v))
				return true;
		}
		return false;
	}
	
	/**
	 * Checks if a design view can have virtual views.
	 * 
	 * @param viewName  the name of the view
	 * @return  true if this view can have virtual views.
	 */
	public static boolean hasConcurrentViews(String viewName) {
		return CHESSProfileManager.CONCURRENT_VIEWS_ASSOCIATION.keySet().contains(viewName);
	}
	
	/**
	 * Returns the name of the current actual view.
	 * 
	 * @param currentView  the DesignView service
	 * @return the name of the current actual view.
	 */
	public static String getBaseViewName(DesignView currentView) {
		return currentView.getName();
	}	
}
