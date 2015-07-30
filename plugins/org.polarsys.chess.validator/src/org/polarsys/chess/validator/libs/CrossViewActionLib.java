/*
-----------------------------------------------------------------------
--          			CHESS validator plugin					     --
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

package org.polarsys.chess.validator.libs;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.sasheditor.editor.IPage;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageRef;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.polarsys.chess.core.views.ViewUtils;
import org.polarsys.chess.core.views.DiagramStatus.DesignView;
import org.polarsys.chess.validator.managers.ViewManager;

// TODO: Auto-generated Javadoc
/**
 * The Class CrossViewActionLib.
 */
public class CrossViewActionLib {
	
	/**
	 * Cross view deployment action.
	 *
	 * @param notifier the Object notifier
	 * @param notification the notification
	 * @param currentView the Package representing the current view
	 * @return true, if successful
	 */
	public static boolean crossViewDeploymentAction(Object notifier,
			Notification notification, Package currentView) {
		PapyrusMultiDiagramEditor editor = (PapyrusMultiDiagramEditor) PlatformUI
				.getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.getActiveEditor();
		IPage currentPage = editor.getISashWindowsContainer()
				.getActiveSashWindowsPage();
		Diagram currentDiagram = ((Diagram) ((PageRef) currentPage
				.getRawModel()).getEmfPageIdentifier());
		if (currentDiagram.getType().equals(ViewManager.classDiagramKind)
				&& ViewUtils.isDeploymentView(currentView)) {
			if (notifier instanceof Abstraction)
				return true;
			if (notifier instanceof DynamicEObjectImpl) {
				DynamicEObjectImpl d = (DynamicEObjectImpl) notifier;
				Stereotype stereo = UMLUtil.getStereotype(d);
				if (stereo.getName().equals("Allocate"))
					return true;
			}
			// deals with strange set operation
			if (notifier instanceof Property
					&& ((Property) notifier).eContainer() instanceof Component)
				return true;
		}
		return false;
	}

	/**
	 * Cross view deployment action.
	 *
	 * @param notifier the Object notifier
	 * @param notification the notification
	 * @param currentView the DesignView representing current view
	 * @return true, if successful
	 */
	public static boolean crossViewDeploymentAction(Object notifier,
			Notification notification, DesignView currentView) {
		PapyrusMultiDiagramEditor editor = (PapyrusMultiDiagramEditor) PlatformUI
				.getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.getActiveEditor();
		IPage currentPage = editor.getISashWindowsContainer()
				.getActiveSashWindowsPage();
		Diagram currentDiagram = ((Diagram) ((PageRef) currentPage
				.getRawModel()).getEmfPageIdentifier());
		if (currentDiagram.getType().equals(ViewManager.classDiagramKind)
				&& ViewUtils.isDeploymentView(currentView)) {
			if (notifier instanceof Abstraction)
				return true;
			if (notifier instanceof DynamicEObjectImpl) {
				DynamicEObjectImpl d = (DynamicEObjectImpl) notifier;
				Stereotype stereo = UMLUtil.getStereotype(d);
				if (stereo.getName().equals("Allocate"))
					return true;
			}
			// deals with strange set operation
			if (notifier instanceof Property
					&& ((Property) notifier).eContainer() instanceof Component)
				return true;
		}
		return false;
	}
}
