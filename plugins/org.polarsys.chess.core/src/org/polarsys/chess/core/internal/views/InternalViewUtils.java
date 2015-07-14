package org.polarsys.chess.core.internal.views;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Stereotype;
import org.polarsys.chess.core.internal.views.permissions.EntryId;
import org.polarsys.chess.core.internal.views.permissions.PermissionEntry;
import org.polarsys.chess.core.internal.views.permissions.PermissionList;
import org.polarsys.chess.core.profiles.CHESSProfileManager;
import org.polarsys.chess.core.views.DiagramStatus.DesignView;
import org.polarsys.chess.core.views.ViewUtils;

public class InternalViewUtils {

	/**
	 * Gets the name of the stereotype of the package that represents the design view.
	 * 
	 * @param pkg  the package 
	 * @return the stereotype name or null
	 */
	public static /*Nullable*/String getViewName(final Package pkg) {
		Stereotype s = InternalViewUtils.getViewStereotypeApplied(pkg);
		return s != null ? s.getName() : null;
	}

	public static Stereotype getViewStereotypeApplied(Package pkg) {
		if (pkg == null)
			return null;
		EList<Stereotype> list = pkg.getAppliedStereotypes();
		for (Stereotype stereotype : list) {
			if (ViewUtils.isViewStereotype(stereotype)) {
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
	
			if (InternalViewUtils.hasViewStereotypeApplied(pkg))
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

	@Deprecated
	public static boolean isElementWritable(Element element, DesignView currentView) {
		Package view = null;
		if ((view = ViewUtils.getView(element.eContainer())) != null
				&& currentView != null) {
			String viewName = getViewName(view);
			return currentView.isEnabled(viewName);
		}
		return true;
	}

	public static boolean isView(EObject notifier) {
		if (notifier instanceof Package
				&& hasViewStereotypeApplied((Package) notifier))
			return true;
		if (CHESSProfileManager.CHESS_VIEWS_LIST.contains((notifier.eClass().getName())))
			return true;
		return false;
	}

	public static Package getCHESSRequirementPackage(Model theModel) {
		for (Element p : theModel.allOwnedElements()) {
			if (p instanceof Package)
				if (ViewUtils.isRequirementView((Package)p))
					return (Package) p;
		}
		return (Package)theModel;
	}

	public static Package getCHESSSystemPackage(Model theModel) {
		for (Element p : theModel.allOwnedElements()) {
			if (p instanceof Package)
				if (ViewUtils.isSystemView((Package)p))
					return (Package) p;
		}
		return (Package)theModel;
	}

	public static Package getCHESSComponentPackage(Model theModel) {
		for (Element p : theModel.allOwnedElements()) {
			if (p instanceof Package)
				if (ViewUtils.isComponentView((Package)p))
					return (Package) p;
		}
		return (Package)theModel;
	}

	/**
	 * Checks the 
	 * @param entryId  
	 * @param permission  the permission type, i.e  {@link PermissionEntry#OWNER}
	 * @return
	 */
	public static boolean checkPermission(DesignView designView, EntryId entryId, byte permission) {
		//TODO code must be refactored to avoid continuous generation of permissions!
		if (entryId.isANY())
			return true;
		PermissionList l = designView.getEnabledPermissions();
		if (l != null && !l.checkPermission(entryId, permission))
			return false;
		return true;
	}

}
