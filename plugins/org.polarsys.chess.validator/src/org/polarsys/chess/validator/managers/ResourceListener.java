/*
-----------------------------------------------------------------------
--          			CHESS validator plugin					     --
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

package org.polarsys.chess.validator.managers;

import java.util.List;
import java.util.Map.Entry;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageList;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.polarsys.chess.core.notifications.ResourceNotification;
import org.polarsys.chess.core.profiles.CHESSProfileManager;
import org.polarsys.chess.core.resourcelistener.ResourceSetListenerExtra;
import org.polarsys.chess.core.util.CHESSProjectSupport;
import org.polarsys.chess.core.util.NotificationManager;
import org.polarsys.chess.core.views.DiagramStatus;
import org.polarsys.chess.service.utils.CHESSEditorUtils;
import org.polarsys.chess.validator.Activator;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving resource events.
 * The class that is interested in processing a resource
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addResourceListener<code> method. When
 * the resource event occurs, that object's appropriate
 * method is invoked.
 *
 * @see ResourceEvent
 */
public class ResourceListener extends ResourceSetListenerExtra {

	/** The s. */
	private StringBuffer s = new StringBuffer();
	//private OCLEvaluator validator = OCLEvaluator.loadEvaluator();	
	/** The viewmgr. */
	private ViewManager viewmgr = ViewManager.loadViewManager();
	
	/** The automated action manager. */
	private ModelManager automatedActionManager = ModelManager.loadModelManager();
	//private ModelManagerOld modelManager = ModelManagerOld.loadModelManagerOld();
	/** The modelparser. */
	private ModelParser modelparser = new ModelParser();
	
//	private IStatus statusCheckViewStereotype = new Status(IStatus.ERROR, Activator.PLUGIN_ID,
//	"A view cannot be modified or removed");
	
	
//	
//	private IStatus statusInstanceSpecification = new Status(IStatus.ERROR, Activator.PLUGIN_ID,
//	"Cannot edit InstanceSpecification elements");
	
//	private IStatus predefinedProfileError =  new Status(IStatus.ERROR, Activator.PLUGIN_ID,
//	"A predefined profile cannot be removed");
	
	/* (non-Javadoc)
 * @see org.eclipse.emf.transaction.ResourceSetListenerImpl#transactionAboutToCommit(org.eclipse.emf.transaction.ResourceSetChangeEvent)
 */
@Override
	public Command transactionAboutToCommit(ResourceSetChangeEvent event) throws RollbackException {
		List<Notification> list = event.getNotifications();
		DiagramStatus ds;
		CompoundCommand command = new CompoundCommand();
		
			ds = CHESSEditorUtils.getDiagramStatus(sr);
		if (ds == null){
			return command;
		}
		
		
		//printList(list);

		boolean executeModelParser = true;
		if (!ds.isUserAction()){
			System.out.println("SUPER USER ACTIONS");
			executeModelParser = false;
		}
		//ds.setUserAction(true);
		int i = 0;
		for (Notification notif : list) {
			i++;
			if (notif instanceof ENotificationImpl) {
				ENotificationImpl notification = (ENotificationImpl) notif;
				final Object notifier = notification.getNotifier();
				if (isNotationElement(notifier))
					continue;
				
				System.out.println("ACTION "+i+" OF "+list.size()+": "+notif);	
				System.out.println("TYPE: " + NotificationManager.printEventType(notification));
				System.out.println("NOTIFIER: " + notifier);
				System.out.println("FEATURE: " + notification.getFeature());
				if (notification.getEventType()==Notification.REMOVE)
					System.out.println("OLDVALUE: " + notification.getOldValue());
				else if (notification.getEventType()==Notification.ADD)
					System.out.println("NEWVALUE: " + notification.getNewValue());
				else {
					System.out.println("OLDVALUE: " + notification.getOldValue());
					System.out.println("NEWVALUE: " + notification.getNewValue());
				}
				
				System.out.println("SUPERUSER: " + !executeModelParser);
				if (!allowedNotifier(notifier)){
					continue;
				}

				
				s.delete(0, s.length());
				s.append("R.");
				s.append(NotificationManager.printEventType(notification));
				
				
//				/*
//				 * @dynamicConstraint R_S_1
//				 */
//				if (notifier instanceof ProfileApplication){
//					System.out.println(notif.getEventType());
//					if ((notif.getEventType() == Notification.SET || 
//						 notif.getEventType() == Notification.REMOVE) 
//							&& UMLUtils.isPredefinedProfile(notif.getOldValue())){
//						ResourceNotification.showInfo(predefinedProfileError.getMessage());
//						throw new RollbackException(predefinedProfileError);
//					}
//				}
				
//				/*
//				 * @dynamicConstraint V_SR_1
//				 * check if a view stereotype has been modified or removed
//				 */
//				if (ViewUtils.isViewModifiedOrRemoved(notification))
//				{
//					if (!viewmgr.checkViewStereotype(notification)){
//						ResourceNotification.showInfo(statusCheckViewStereotype.getMessage());
//						throw new RollbackException(statusCheckViewStereotype);
//					}
//				}
				
				
//				if (!ConstraintsLib.DefaultStereotypeRemoved.check(notification).isOK()){
//					ResourceNotification.showInfo(ConstraintsLib.DefaultStereotypeRemoved.getMessage());
//					throw new RollbackException(ConstraintsLib.DefaultStereotypeRemoved.getStatus());
//				}
				
				//TODO BUG when a ClientServerPort is removed it generates Slot-related transactions
//				if (isInstanceSpecification((ENotificationImpl)notif)){
//					ResourceNotification.showInfo(statusInstanceSpecification.getMessage());
//					throw new RollbackException(statusInstanceSpecification);
//				}
				
				try{
					//do not check any constraint in case of automated actions
					if (executeModelParser){
						modelparser.check(notification, notifier, ds.getCurrentView(), ds.isSuperuser());
					}
				} catch (RollbackException e) {
					ResourceNotification.showInfo(e.getStatus().getMessage());
					throw e;
				}
				
				if ( notifier instanceof Element 
					 || notifier instanceof DynamicEObjectImpl
					 || canBeStaticStereotype(notifier))
				{
					try {
						Command comm = automatedActionManager.check(list, notification, notifier, s, ds,event.getEditingDomain());
						if ( comm != null ){
							ds.setUserAction(false);
							command.append(comm);
							
							System.out.println("COMMAND: " + comm.getLabel());
							System.out.println("SUPERUSER set to true");
						}
					} catch (RollbackException e) {
						s.delete(0, s.length());
						s.append(e.getStatus().getMessage());
						ResourceNotification.showInfo(e.getStatus().getMessage());
						throw e;
					}
				}
				/*
				 * Use "instanceof Shape" instead else if (notifier instanceof
				 * Diagram) { Diagram di = (Diagram) notifier;
				 * s.append(" model modified: "); s.append(di.getName());
				 * 
				 * }*/
				 else
					if (notifier instanceof Shape) {
					Shape shape = (Shape) notifier;
					s.append(" shape modified: ");
					s.append(" for the element: ");
					s.append(shape.getElement());
					if (shape.getElement()!= null){
						s.append(" that belong to the view: ");
						s.append(shape.getElement().eContainer());
					}
					
					//modelmanager.check(notification, shape.getElement(), validator, s);
					//TODO drag and drop constraints
					//TODO same constraint of @dynamicConstraint P_A_1 an interface can be added only in
					//functionalView
//					if (shape.getElement() instanceof Interface && 
//							shape.getDiagram().getType().equals(ModelEditPart.MODEL_ID) && 
//							!UMLUtils.isFunctionalView(UMLUtils.getView(shape.getDiagram().getElement()))){
//						ResourceNotification.showInfo(ModelManager.cannotCreateInterface.getMessage());
//						throw new RollbackException(ModelManager.cannotCreateInterface);
//					}
					if (shape.getDiagram()!=null){
						s.append(" in the diagram: ");
						s.append(shape.getDiagram().getName());
						s.append(" in the view: ");
						s.append(shape.getDiagram().getElement());
					}
					if (!(notification.getNewValue() instanceof EObject))
						continue;
				} 
				
				//it's needed to avoid the graphical representation of stereotype to be shown
				//used in case of applying the view stereotype
				else if (notifier instanceof EAnnotation)
				{
					EAnnotation annotation = (EAnnotation) notifier;
					System.out.println("ANN: " + annotation);
					EMap< String, String> details = annotation.getDetails();
					for (Entry<String, String> entry : details) {
						if ( entry.getValue().indexOf(CHESSProfileManager.DEPLOYMENT_VIEW) > 0
							|| entry.getValue().indexOf(CHESSProfileManager.COMPONENT_VIEW) > 0
							//|| entry.getValue().indexOf(CHESSProfileManager.EXTRAFUNCTIONAL_VIEW) > 0 
							|| entry.getValue().indexOf(CHESSProfileManager.ANALYSIS_VIEW) > 0
							|| entry.getValue().indexOf(CHESSProfileManager.DEPENDABILITY_ANALYSIS_VIEW) > 0 
							|| entry.getValue().indexOf(CHESSProfileManager.RT_ANALYSIS_VIEW) > 0
							|| entry.getValue().indexOf(CHESSProfileManager.TIMING_DATAFLOW_VIEW) > 0 )
							{
								s.delete(0, s.length());
								s.append("Can't apply view stereotype!");
								CHESSProjectSupport.printlnToCHESSConsole(s.toString());
								ResourceNotification.showError(s.toString());
								throw new RollbackException(new Status(IStatus.ERROR,
										Activator.PLUGIN_ID, s.toString()));
							}
					}
				}
				
				else if (notifier instanceof PageList) {
					try {
						viewmgr.check(notification.getNewValue(), s, ds.getCurrentView(),event.getEditingDomain());
					} catch (RollbackException e) {
						ResourceNotification.showInfo(e.getStatus().getMessage());
						throw e;
					}
				}
			}
			else { //check diagram creation permission
				Object newz = notif.getNewValue();
				if (newz instanceof Diagram){
									
					try {
					viewmgr.check((Diagram) newz, s, ds.getCurrentView(),event.getEditingDomain());
					} catch (RollbackException e) {
						ResourceNotification.showInfo(e.getStatus().getMessage());
						throw e;
					}
				}
			}
		}
		
		return command.getCommandList().isEmpty() ? super.transactionAboutToCommit(event) : command;
	}


	/**
	 * Prints the list. Test
	 *
	 * @param list the List to be printed
	 */
	private void printList(List<Notification> list) {
		System.out.println("----------------------------------");
		int j = 0;
		for (Notification notif1 : list) {
			j++;
			if (notif1 instanceof ENotificationImpl) {
				ENotificationImpl notification = (ENotificationImpl) notif1;
				final Object notifier = notification.getNotifier();
				if (isNotationElement(notifier))
					continue;

				System.out.println("ACTION " + j + " OF " + list.size());
				System.out.println("TYPE: "
						+ NotificationManager.printEventType(notification));
				System.out.println("NOTIFIER: " + notifier);
				System.out.println("FEATURE: " + notification.getFeature());
				if (notification.getEventType() == Notification.REMOVE)
					System.out.println("OLDVALUE: "
							+ notification.getOldValue());
				else if (notification.getEventType() == Notification.ADD)
					System.out.println("NEWVALUE: "
							+ notification.getNewValue());
				else {
					System.out.println("OLDVALUE: "
							+ notification.getOldValue());
					System.out.println("NEWVALUE: "
							+ notification.getNewValue());
				}
			}
		}
		System.out.println("----------------------------------");
	}


	/**
	 * Checks if is the notifier notation element.
	 *
	 * @param notifier the notifier
	 * @return true, if is notation element
	 */
	private boolean isNotationElement(Object notifier) {
		if (notifier instanceof EObject){
			String pkgName = notifier.getClass().getPackage().getName();
			if (pkgName.startsWith("org.eclipse.gmf.runtime.notation"))
				return true;
		}
		return false;
			
	}
	
	/**
	 * Chek if the notifier can be a static stereotype.
	 *
	 * @param notifier the notifier
	 * @return true, if successful
	 */
	private boolean canBeStaticStereotype(Object notifier) {
		if (notifier instanceof EObject) {
			String pkgName = notifier.getClass().getPackage().getName();
			if (pkgName.startsWith("org.eclipse.papyrus.MARTE") || pkgName.startsWith("org.polarsys.chess.chessmlprofile"))
				return true;
			if (notifier instanceof EAnnotation || notifier instanceof Shape){
				return false;
			}
			return true;
		}
		return false;
	}


	/** The allowed notifier types. */
	private static Class[] allowedNotifierTypes = {Element.class, DynamicEObjectImpl.class, Diagram.class, PageList.class, Shape.class, EAnnotation.class, EObject.class};
	
	
	/**
	 * Allowed notifier.
	 *
	 * @param notifier the notifier
	 * @return true, if successful
	 */
	private boolean allowedNotifier(Object notifier) {
		for (Class<?> allowedType : allowedNotifierTypes) {
			if (allowedType.isInstance(notifier))
				return true;
		}
		return false;
	}


	/**
	 * Checks if the notification is instance specification.
	 *
	 * @param notif the notification
	 * @return true, if is instance specification
	 */
	private boolean isInstanceSpecification(ENotificationImpl notif) {
		// TODO Problematic when we need to remove a clientserverport
		// => it removes also Slot which is of an InstanceSpecification
		
		if (notif.getEventType() == Notification.SET){
			Object notifer = notif.getNotifier();
			return (notifer instanceof Element && isContainedInInstanceSpecification((Element) notifer));
		}
		if (notif.getEventType() == Notification.REMOVE){
			Object notifer = notif.getOldValue();
			return (notifer instanceof Element && isContainedInInstanceSpecification((Element) notifer));
		}
		return false;
	}

	/**
	 * Checks if the notifier is contained in instance specification.
	 *
	 * @param notifer the notifier
	 * @return true, if is contained in instance specification
	 */
	private boolean isContainedInInstanceSpecification(Element notifier) {
		if (notifier == null)
			return false;
		if (notifier instanceof InstanceSpecification)
			return true;
		EObject cont = notifier.eContainer();
		if (cont instanceof Element)
		  return isContainedInInstanceSpecification((Element)cont);
		return false;
	}

	/*
	private void printElementType(EObject notifier) {
		if (notifier instanceof DynamicEObjectImpl) {
			notifier = UMLUtil.getBaseElement((DynamicEObjectImpl) notifier);
		}
		if (notifier instanceof Model) {
			Model m = (Model) notifier;
			s.append(" for model: ");
			s.append(m.getName());
		} else if (notifier instanceof Class) {
			Class c = (Class) notifier;
			s.append(" for class: ");
			s.append(c.getName());
			s.append(" in the model: ");
			s.append(c.getModel().getName());
			validator.validate(c);
		} else if (notifier instanceof Interface) {
			Interface in = (Interface) notifier;
			s.append(" for interface: ");
			s.append(in.getName());
		} else if (notifier instanceof Operation) {
			Operation op = (Operation) notifier;
			s.append(" for operation: ");
			s.append(op.getName());

			Classifier c = OCLUMLUtil.getClassifier(op.eClass(), op.eResource()
					.getResourceSet());
			s.append(" in class: ");
			s.append(c.getName());

		} else if (notifier instanceof Property) {
			Property pr = (Property) notifier;
			s.append(" for property: ");
			s.append(pr.getName());
		} else if (notifier instanceof NamedElement) {
			NamedElement ne = (NamedElement) notifier;
			s.append(" for unknown ne: ");
			s.append(ne.getName());
		} else if (notifier instanceof DynamicEObjectImpl) {
			Element el = UMLUtil.getBaseElement((DynamicEObjectImpl) notifier);
			NamedElement ne = (NamedElement) el;
			s.append(" for unknown ne: ");
			s.append(ne.getName());
		}
	}
	*/
}
