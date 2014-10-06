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

package org.polarsys.chess.validator.managers;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageRef;
import org.eclipse.papyrus.uml.tools.listeners.PapyrusStereotypeListener;
import org.eclipse.uml2.uml.Model;
import org.polarsys.chess.core.profiles.CHESSProfileManager;
import org.polarsys.chess.core.util.CHESSProjectSupport;
import org.polarsys.chess.core.views.DiagramStatus;
import org.polarsys.chess.core.views.DiagramStatus.DesignView;
import org.polarsys.chess.service.utils.CHESSEditorUtils;
import org.polarsys.chess.validator.Activator;

/**
 * ViewManager is a singleton class which provides the data structure which contains the 
 * view-diagram association.
 * Each CHESS view owns a list of types of diagram that view is allowed to expose and modify.   
 */
public class ViewManager {
	
	public static String classDiagramKind = "PapyrusUMLClassDiagram";

	private static ViewManager instance = new ViewManager();

	public static ViewManager loadViewManager() {
		return instance;
	}

//	public boolean isDiagramAllowed(String view, String diagram) {
//		if (view != null) {
//			HashSet<String> diagrams = viewDiagramsAssociation.get(view);
//			return diagrams.contains(diagram);
//		}
//		return false;
//	}

	
	/**
	 * Check constraints concerning view ownership of diagrams. 
	 * A diagram must be created as a child of a view which allows its creation
	 * @param domain 
	 * @param currentView 
	 */
	public void check(Object notifier, StringBuffer s, DesignView currentView, TransactionalEditingDomain domain)
			throws RollbackException {
		if (notifier instanceof PageRef) {
			PageRef ref = (PageRef) notifier;
			Diagram diagram = null;

			// check if we are working on a real diagram
			if (ref.getEmfPageIdentifier() instanceof Diagram)
				diagram = (Diagram) ref.getEmfPageIdentifier();
			else
				return;
			
			check(diagram, s, currentView, domain);

		}
	}
	
	
	/**
	 * Check constraints concerning view ownership of diagrams. 
	 * A diagram must be created as a child of a view which allows its creation
	 * @param domain 
	 * @param currentView 
	 */
	public void check(Diagram diagram, StringBuffer s, DesignView currentView, TransactionalEditingDomain domain)
			throws RollbackException {
		
			/*
			 * @dynamicConstraint D_1
			 * if the diagram is created in the root of the model
			 */
			if (diagram.getElement() instanceof Model) {
				s.append(Messages.error_diagramInView);
//				ResourceNotification.showError(Messages.error_diagramInView);
				throw new RollbackException(new Status(IStatus.ERROR,
						Activator.PLUGIN_ID, Messages.error_diagramInView));
			} else {
				/*
				 * dynamicConstraint D_2
				 * A diagram must be created as a child of a view which allows its creation
				 */
				if (!currentView.isDiagramAllowed(diagram)){
					CHESSProjectSupport.printlnToCHESSConsole(s.toString());
					throw new RollbackException(new Status(IStatus.ERROR,
							Activator.PLUGIN_ID, Messages.error_diagramCurrentView)); //$NON-NLS-1$
				}
//				
			}
		
	}

//	/*
//	 * dynamicConstraint D_2
//	 * A diagram must be created as a child of a view which allows its creation
//	 */
//	private boolean isDiagramAllowed(Package containingView, Diagram diagram) {
//		Stereotype view = ViewUtils.getViewStereotypeApplied(containingView);
//		if (view != null) {
//			HashSet<String> diagrams = viewDiagramsAssociation.get(view
//					.getName());
//			return diagrams.contains(diagram.getType());
//		}
//		return false;
//	}

//	public void checkViewPackage(Notification notification)
//			throws RollbackException {
//		if (notification.getEventType() == Notification.REMOVE) {
//			throw new RollbackException(new Status(IStatus.ERROR,
//					Activator.PLUGIN_ID, "Can't delete a view!"));
//		}
//	}

	
	/**
	 * Check if a stereotype representing a CHESS view has been modified.
	 * A stereotype representing a CHESS must not be modified or removed.
	 */
	public boolean checkViewStereotype(Notification notification) {
		
		//it should be allowed to modify the deployment view in order to add/remove assignment references
		PapyrusMultiDiagramEditor editor = CHESSEditorUtils.getCHESSEditor();
		DiagramStatus ds = CHESSEditorUtils.getDiagramStatus(editor);
		if(ds == null)
			return true;
		
		DesignView dview = 
				ds.getCurrentView();
		if(notification.getEventType() == PapyrusStereotypeListener.MODIFIED_STEREOTYPE &&
				dview.getName().equals(CHESSProfileManager.DEPLOYMENT_VIEW)){
			return true;
		}
		
		else if (notification.getEventType() == Notification.SET ||
			notification.getEventType() == Notification.REMOVE ||
			notification.getEventType() == PapyrusStereotypeListener.APPLIED_STEREOTYPE || 
			notification.getEventType() == PapyrusStereotypeListener.UNAPPLIED_STEREOTYPE ||
			notification.getEventType() == PapyrusStereotypeListener.MODIFIED_STEREOTYPE	
			) {
			return false;
		}
		return true;
	}
};