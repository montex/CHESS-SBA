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
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.uml.tools.listeners.PapyrusStereotypeListener;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ProfileApplication;
import org.eclipse.uml2.uml.Relationship;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.internal.impl.DependencyImpl;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.polarsys.chess.core.constraint.DynamicConstraint;
import org.polarsys.chess.core.constraint.FilterableDynamicConstraint;
import org.polarsys.chess.core.constraint.IConstraint;
import org.polarsys.chess.core.util.CHESSProjectSupport;
import org.polarsys.chess.core.util.NotificationManager;
import org.polarsys.chess.core.util.uml.ProfileUtils;
import org.polarsys.chess.core.util.uml.UMLUtils;
import org.polarsys.chess.core.views.DiagramStatus.DesignView;
import org.polarsys.chess.core.views.ViewUtils;
import org.polarsys.chess.validator.managers.ViewManager;


// TODO: Auto-generated Javadoc
/*
 * Framework usage:
 * 
 * In a Library of constraints: 
 * 
 * public static FilterableDynamicConstraint c1 = new FilterableDynamicConstraint(1, "c1", IConstraint.WARNING, "c1 message") {
 *   @Override
 *   public boolean checkConstraint(Notification notification, Package currentView){
 *      boolean successfullyVerifiedConstraint = false;
 *      ... //check conditionsEObject
 *      return successfullyVerifiedConstraint;
 *   }
 * }
 * 
 * In the listener:
 *   if (!Library.constraint1.check(notification).isOK()){
 *     //Library.constraint1.showUserNotification();  // NO
 *     throw new RollbackException(Library.constraint1.getStatus())
 *   }
 * */



/**
 * The Class ConstraintsLib contains the implementation of Dynamic Constraints
 */
public class ConstraintsLib {

	/** The Constant CSPORT. */
	protected static final String CSPORT = "MARTE::MARTE_DesignModel::GCM::ClientServerPort";

	/** The viewmgr. */
	private static ViewManager viewmgr = ViewManager.loadViewManager();

	/** The successfully verified. */
	static boolean successfullyVerified;
	
	/** The diagram. */
	static Diagram diagram = null;
	
	/** The notifier. */
	static Object notifier;


	// ResourceListener Constraints:
	/*
	 * @FilterableDynamicConstraint R_S_1
	 * 
	 */
	/** The R_ s_1. */
	public static FilterableDynamicConstraint R_S_1 = 
		new FilterableDynamicConstraint("R_S_1", IConstraint.ERROR, "A predefined profile cannot be removed") {
		@Override
		public boolean checkConstraint(Notification notification, DesignView currentView) {	

			if ((notification.getEventType() == Notification.SET ||
					notification.getEventType() == Notification.REMOVE) 
					&& ProfileUtils.isPredefinedProfile(notification.getOldValue()))
				successfullyVerified = false;
			else 
				successfullyVerified = true;

			return successfullyVerified;
		}
	};

	/*
	 * @FilterableDynamicConstraint V_SR_1
	 */
	/** The V_ s r_1. */
	public static FilterableDynamicConstraint V_SR_1 = 
		new FilterableDynamicConstraint("V_SR_1", IConstraint.ERROR, "A view cannot be modified or removed") {
		@Override
		public boolean checkConstraint(Notification notification, DesignView currentView) {
			if (ViewUtils.isViewModifiedOrRemoved((ENotificationImpl) notification)){
				if (!viewmgr.checkViewStereotype(notification)) 
					return false;
				}
			return true;
		}				
	};

	// ModelManager Constraints:

	/*
	 * @FilterableDynamicConstraint S_S_1
	 * a predefined stereotype cannot be removed
	 */
	/** The S_ s_1. */
	public static FilterableDynamicConstraint S_S_1 = new FilterableDynamicConstraint("S_S_1",
			IConstraint.ERROR, "a predefined stereotype cannot be removed") {
		@Override
		public boolean checkConstraint(Notification notification, DesignView currentView) {
			Object notifier = notification.getNotifier();
			// Check for modifications of the stereotype
			if (notifier instanceof DynamicEObjectImpl) {
				DynamicEObjectImpl d = (DynamicEObjectImpl) notifier;
				Stereotype stereo = UMLUtil.getStereotype(d);

				if (notification.getEventType() == Notification.SET
						&& notification.getNewValue() == null) {
					if (ProfileUtils.isPredefinedStereotype(stereo)) {
						return false;
					}
				}
			}
			return true;
		}
	};



	/*
	 * @FilterableDynamicConstraint M_A_1
	 * cannot apply profiles
	 */
	/** The M_ a_1. */
	public static FilterableDynamicConstraint M_A_1 = new FilterableDynamicConstraint("M_A_1",
			IConstraint.ERROR, "Cannot apply further profiles in the model") {
		@Override
		public boolean checkConstraint(Notification notification, DesignView currentView) {
			Object notifier = notification.getNotifier();
			if (notifier instanceof Model) {

				if (notification.getEventType() == Notification.ADD
						|| notification.getEventType() == Notification.ADD_MANY)
					if (notification.getNewValue() instanceof ProfileApplication)
						return false;
			}
			return true;
		}
	};

	/*
	 * @FilterableDynamicConstraint C_A_1
	 * Interface realization is not allowed because owned operations does not match.
	 */
	/** The C_ a_1. */
	public static FilterableDynamicConstraint C_A_1 = 
		new FilterableDynamicConstraint("C_A_1", IConstraint.ERROR, "Interface realization is not allowed because owned operations does not match.") {
		@Override
		public boolean checkConstraint(Notification notification, DesignView currentView) {
			notifier = notification.getNotifier();
			if (notifier instanceof Component && notification.getEventType() == Notification.REMOVE) 
			{

				Package view = ViewUtils.getView((Component) notifier);
				// cheks to be verified only in case the current component
				// belongs to the functional view
				if (ViewUtils.isComponentView(view)) {
					if (notification.getOldValue() instanceof Operation) {

						Component comp = (Component) notifier;
						Operation operation = (Operation) notification.getOldValue();
						EList<NamedElement> relationships = null;

						for (Relationship rel : comp.getRelationships()) {
							if (rel instanceof InterfaceRealization) {
								InterfaceRealization intRel = (InterfaceRealization) rel;
								relationships = intRel.getSuppliers();
							}
						}

						if (relationships != null) {
							for (NamedElement item : relationships) {
								if (item instanceof Classifier) {
									Classifier class_comp = (Classifier) item;
									if (UMLUtils.isOperationContained(class_comp, operation)) {
										return false;
									}
								}
							}
						}

					}
				}
			}
			return true;
			/*
			if (notification.getEventType() == Notification.ADD) {

				Package view = UMLUtils.getView((Component) notifier);
				// cheks to be verified only in case the current component
				// belongs to the functional view
				if (UMLUtils.isFunctionalView(view)) {
					if (notification.getNewValue() instanceof InterfaceRealization) {
						InterfaceRealization link = (InterfaceRealization) notification.getNewValue();
						Interface contract = link.getContract();
						Component comp = null;
						// each operation shall match in its signature (name,
						// parameter order, parameter type,
						// parameter direction)
						for (Operation operation : contract.getAllOperations()) {
							for (NamedElement element : link.getClients()) {
								if (element instanceof Component) {
									comp = (Component) element;
									if (!UMLUtils.isOperationContained(comp,operation)) {
										successfullyVerified = false;
									}

								}
							}
						}
					}
				}
			}*/

		}
	};


	/*
	 * FilterableDynamicConstraint O_S_1 
	 * Interface operations in the Functional View must have public visibility.
	 */
	/** The O_ s_1. */
	public static FilterableDynamicConstraint O_S_1 = 
		new FilterableDynamicConstraint("O_S_1", IConstraint.ERROR, "Interface operations in the Functional View must have public visibility.") {
		@Override
		public boolean checkConstraint(Notification notification, DesignView currentView) {
			if (notifier instanceof Operation && notification.getEventType() == Notification.SET) {
				notifier = notification.getNotifier();
				Operation op = (Operation) notifier;

				if (op.eContainer() instanceof Interface) {
					Package view = ViewUtils.getView(op.eContainer());
					// we must check whether the classifier belongs to the
					// functional view
					if (ViewUtils.isComponentView(view)) {
						// in this case only public visibility is allowed
						if (!UMLUtils.hasPublicVisibility(op)) {
							return false;
						}
					}
				}

			}
			return true;
		}				
	};


	/** The Add remove dependency. */
	public static FilterableDynamicConstraint AddRemoveDependency = 
		new FilterableDynamicConstraint("ADD_REMOVEDependency", IConstraint.ERROR, "Cannot modify dependency for ComponentType") {
		@Override
		public boolean checkConstraint(Notification notification, DesignView currentView) {
			Object value = null;
			boolean add = false;
			if (notification.getEventType() == Notification.ADD){
				value = notification.getNewValue();
				add = true;
			}
			if (notification.getEventType() == Notification.REMOVE)
				value = notification.getOldValue();
			
			if (value != null && (value instanceof InterfaceRealization || value.getClass().equals(DependencyImpl.class))) {
				Dependency dp = (Dependency) value;
				Object el = notification.getNotifier();
				if (el instanceof NamedElement && 
						UMLUtils.isComponentType((NamedElement) el)) {
					getStatus().setMessage(dp.getName(), ((NamedElement) el).getName(), add?"add":"remove");
					return false;
				}
			}				
			
			return true;
		}
	};
	
//	/*
//	 * @FilterableDynamicConstraint S_SA_1
//	 * Assure the element is edited only in the view it belongs to 
//	 */
//	public static FilterableDynamicConstraint S_SA_1 = 
//		new FilterableDynamicConstraint("S_SA_1", IConstraint.ERROR, "This element does not belong to the current view and cannot be therefore modified.") {
//		@Override
//		public boolean checkConstraint(Notification notification, DesignView currentView) {
//			successfullyVerified = true;
//			if (notification.getEventType() == Notification.SET || notification.getEventType() == Notification.ADD) {
//				successfullyVerified = false;
//			}
//			return successfullyVerified;
//		}
//	};

	/*
	 * @FilterableDynamicConstraint P_T_1 
	 * view stereotype cannot be applied
	 */
	/** The P_ t_1. */
public static FilterableDynamicConstraint P_T_1 = 
		new FilterableDynamicConstraint("P_T_1", IConstraint.ERROR, "Appling a view stereotype is forbidden.") {
		@Override
		public boolean checkConstraint(Notification notification, DesignView currentView) {
			if (notifier instanceof Package && notification.getEventType() == PapyrusStereotypeListener.APPLIED_STEREOTYPE) {
				if (notification.getNewValue() instanceof DynamicEObjectImpl) {
					DynamicEObjectImpl d = (DynamicEObjectImpl) notification.getNewValue();
					Stereotype stereo = UMLUtil.getStereotype(d);
					if (ViewUtils.isViewStereotype(stereo)) {
						return false;
					}
				}
			}
			return true;
		}
	};

	/*
	 * @FilterableDynamicConstraint P_A_1 
	 * an interface can be added only in functionalView or deploymentView
	 */
	/** The P_ a_1. */
	public static FilterableDynamicConstraint P_A_1 = 
		new FilterableDynamicConstraint("P_A_1", IConstraint.ERROR, 
				"Creation of interfaces is only allowed in the Functional View and Deployment View.") {
		@Override
		public boolean checkConstraint(Notification notification, DesignView currentView) {
			notifier = notification.getNotifier();
			if (notifier instanceof Package && notification.getEventType() == Notification.ADD && notification.getNewValue() instanceof Interface) {
				Package view = ViewUtils.getView((Package) notifier);
				if (!ViewUtils.isComponentView(view) && !ViewUtils.isDeploymentView(view)) {
					return false;
				}
			}
			return true;
		}
	};
	
	
	/*
	 * @FilterableDynamicConstraint C_A_2 
	 * Cannot create an Activity diagram for the Component. Select an operation instead
	 * In Papyrus 1.0, Eclipse 4.4 Luna is not possible to create an activity diagram for an operation
	 */
//	public static FilterableDynamicConstraint C_A_2 = 
//		new FilterableDynamicConstraint("C_A_2", IConstraint.ERROR, 
//				"Cannot create an Activity diagram for the Component. Select an operation instead.") {
//		@Override
//		public boolean checkConstraint(Notification notification, DesignView currentView) {
//			notifier = notification.getNotifier();
//			if (notifier instanceof Component && notification.getEventType() == Notification.SET && notification.getFeature() instanceof EReference) {
//				Package view = ViewUtils.getView((Component) notifier);
//				if (ViewUtils.isComponentView(view)) {
//					EReference f = (EReference) notification.getFeature();
//					Object v = notification.getNewValue();
//					if (f.getName().equals("classifierBehavior") && v != null && v instanceof Activity)
//						return false;
//				}
//			}
//			return true;
//		}
//	};
	
	
	

	/*
	 * @FilterableDynamicConstraint P_A_2 
	 * in case of components (with no additional stereotypes) we must check if the package under
	 * modification belongs to the functional view
	 */
	/*public static FilterableDynamicConstraint P_A_2 = 
		new FilterableDynamicConstraint("P_A_2", IConstraint.ERROR, "Creation of component with no additional stereotypes " +
				"is only allowed in the Functional View.") {
		@Override
		public boolean checkConstraint(Notification notification, Package currentView) {			
			successfullyVerified = true;
			if (notification.getNewValue() instanceof Component) {
				Component comp = (Component) notification.getNewValue();
				if (comp.getAppliedStereotypes().size() <= 0) {
					Package view = UMLUtils.getView((Package) notifier);
					if (!UMLUtils.isFunctionalView(view)) {
						successfullyVerified = false;
					}
				}
			}
			return successfullyVerified;
		}
	};*/

	/** The E_ s_1_ new. */
	public static DynamicConstraint E_S_1_NEW = 
		new DynamicConstraint("E_S_1", IConstraint.ERROR, 
		"The view \"{0}\" has no write access on the {1} \"{2}\", therefore it cannot be modified.") {
		@Override
		public boolean checkConstraint(Notification notification, DesignView currentView) {
			
			CHESSProjectSupport.printlnToCHESSConsole(NotificationManager.printNotification(notification));

			notifier = notification.getNotifier();
			if (notifier instanceof Element || notifier instanceof DynamicEObjectImpl || notifier instanceof EObject){
				if (notification.getEventType() == Notification.ADD
						|| notification.getEventType() == Notification.ADD_MANY
						|| notification.getEventType() == Notification.REMOVE
						|| notification.getEventType() == Notification.REMOVE_MANY
						|| (notification.getEventType() == Notification.SET && notification.getOldValue() != null && notification.getNewValue() == null)
						|| isBaseElementModification(notification)){
					if (!ViewUtils.isElementInstantiable((EObject)notifier, notification.getFeature(),currentView)) {
						getStatus().setMessage(currentView.getName(), "element", ((EObject)notifier).eClass().getName());
						return false;
					}
				} else
				if (notification.getEventType() == Notification.SET) {
					if (!ViewUtils.isElementWritable_((EObject)notifier, notification.getFeature(),currentView)) {
						getStatus().setMessage(currentView.getName(), "element", ((EObject)notifier).eClass().getName());
						return false;
					}
				} else
				if (notification.getEventType() == PapyrusStereotypeListener.APPLIED_STEREOTYPE 
						|| notification.getEventType() == PapyrusStereotypeListener.UNAPPLIED_STEREOTYPE){
					if (!ViewUtils.isStereotypeInstantiable((EObject)notifier, notification.getFeature(), notification.getNewValue(), currentView)) {
						getStatus().setMessage(currentView.getName(), "stereotype", ((EObject)notification.getNewValue()).eClass().getName());
						return false;
					}
				} 
				//REMOVED Misleading
//				else if (notification.getEventType() == PapyrusStereotypeListener.MODIFIED_STEREOTYPE){
//					if (!ViewUtils.isStereotypeWritable((EObject)notifier, notification.getFeature(), notification.getNewValue(), currentView)) {
//						getStatus().setMessage(currentView.getName(), "stereotype", ((EObject)notification.getNewValue()).eClass().getName());
//						return false;
//					}
//				}

			}
			return true;
		}

		private boolean isBaseElementModification(Notification notification) {
			if (notifier instanceof DynamicEObjectImpl && notification.getFeature() instanceof EReference){
				String name = ((EReference)notification.getFeature()).getName();
				return name.startsWith("base_");
			}
			return false;
		}
	};

	
		/** The check modified operation. */
		public static FilterableDynamicConstraint checkModifiedOperation = 
			new FilterableDynamicConstraint("ModifiedOperation", IConstraint.WARNING, 
			"Cannot modify inherited operations.") {
			
		@Override
			public boolean checkConstraint(Notification notification, DesignView currentView) {
			
			if (notifier instanceof Operation) {
				// in case of addition
				boolean b = (notification.getEventType() == Notification.SET)
						|| (notification.getEventType() == Notification.REMOVE && notification.getOldValue() instanceof Parameter)
						|| (notification.getEventType() == Notification.ADD && notification.getNewValue() instanceof Parameter);
				if (b) {
					return !checkModifiedOperation(notification);
				}
			}
			return true;
		}
		
		private boolean checkModifiedOperation(Notification notification) {
			if (!(notification.getNotifier() instanceof Operation))
				return false;
			Operation op = (Operation) notification.getNotifier();
			EObject opCont = op.eContainer();
			if (opCont instanceof Component) {
				Package view = ViewUtils.getView(opCont);
				// we must check whether the classifier belongs to the
				// functional view
				if (ViewUtils.isComponentView(view)) {
					if (isOperationContained(op, notification)) {
						return true;
					}
				}
			}
			return false;
		}
		
		private String getNotifiedOperationName(Operation op, Notification notification){
			String opName = op.getName();
			if (((EStructuralFeature) notification.getFeature()).getName().equalsIgnoreCase("name")) {
				if (notification.getOldStringValue() != null)
					opName = notification.getOldStringValue();
			}
			return opName;
		}
		
		private EList<Classifier> collectSuppliers(Classifier container){
			EList<Classifier> relationships = new BasicEList<Classifier>();
			for (Relationship rel : container.getRelationships()) {
				if (rel instanceof InterfaceRealization) {
					InterfaceRealization r = (InterfaceRealization) rel;
					relationships.addAll(collectClassifiers(r.getSuppliers()));
				}
			}
			return relationships;
		}
		
		private EList<Classifier> collectClassifiers(EList<NamedElement> eList){
			EList<Classifier> classifiers = new BasicEList<Classifier>();
			for (NamedElement namedElement : classifiers) {
				if (namedElement instanceof Classifier) {
					Classifier e = (Classifier) namedElement;
					if (ViewUtils.isComponentView(ViewUtils.getView(e))){
						classifiers.add(e);
					}
				}
			}
			return classifiers;
		}
		
		private boolean isOperationContained(Operation op, Notification notification) {
			// if nothing is changed
			EStructuralFeature feature = (EStructuralFeature) notification.getFeature();
			if (op.eGet(feature).equals(notification.getOldValue()))
				return false;
			
			// this case cannot happen
			if (feature.getName().equalsIgnoreCase("name") && notification.getOldStringValue() == null)
				return false;
			
			String opName = getNotifiedOperationName(op, notification);
			
			EList<Classifier> relationships = collectSuppliers((Classifier) op.eContainer());

			for (Classifier comp : relationships) {
				// for each operation belonging to the supplier
				// interface
				for (Operation cOp : comp.getOperations()) {
					
					// check the name
					boolean isEqual = cOp.getName().equals(opName) && 
							o(feature, notification, op, cOp);

					if (isEqual) {
						return true;
					}
				}
			}
			return false;
		}
		
		private boolean o(EStructuralFeature feature, Notification notification, Operation op ,Operation cOp ){
			
			String f = feature.getName().toLowerCase();
			//if the modification regards the parameter
			if (f.equals("ownedParameter")) {
				int cOpS = cOp.getOwnedParameters().size();
				int opS = op.getOwnedParameters().size();
				// user is trying to adding a parameter
				if (notification.getOldValue() == null) {
					if (cOpS != opS - 1)
						return false;
				} else if (cOpS != opS + 1)
					return false;
			} 
			
			if (cOp.getOwnedParameters().size() != op
					.getOwnedParameters().size())
				return false;

			if (f.equals("visibility")) {
				if (!cOp.getVisibility().equals(
						notification.getOldValue()))
					return false;
			} 
			
			if (cOp.getVisibility().getValue() != op
					.getVisibility().getValue())
				return false;

			if (f.equals("isAbstract")) {
				if (cOp.isAbstract() != notification
						.getOldBooleanValue())
					return false;
			}
			
			if (cOp.isAbstract() != op.isAbstract())
				return false;

			if (f.equals("isQuery")) {
				if (cOp.isQuery() != notification
						.getOldBooleanValue())
					return false;
			} else if (cOp.isQuery() != op.isQuery())
				return false;

			if (f.equals("isLeaf")) {
				if (cOp.isLeaf() != notification
						.getOldBooleanValue())
					return false;
			}
			
			if (cOp.isLeaf() != op.isLeaf())
				return false;

			if (f.equals("isStatic")) {
				if (cOp.isStatic() != notification
						.getOldBooleanValue())
					return false;
			} 
			
			if (cOp.isStatic() != op.isStatic())
				return false;

			if (f.equals("concurrency")) {
				if (!cOp.getConcurrency().equals(
						notification.getOldValue()))
					return false;
			}
			
			if (cOp.getConcurrency().getValue() != op
					.getConcurrency().getValue())
				return false;
			
			return true;
		}
		
		private boolean isOperationContainedOLD(Operation op, Notification notification) {
			
			// if nothing is changed
			if (op.eGet((EStructuralFeature) notification.getFeature()).equals(notification.getOldValue()))
				return false;
			
			if (notification.getOldStringValue() == null)
				return false;
			
			String opName = op.getName();
			if (((EStructuralFeature) notification.getFeature()).getName().equalsIgnoreCase("name")) {
				if (notification.getOldStringValue() != null)
					opName = notification.getOldStringValue();
				else
					return false;
			}
			EList<NamedElement> relationships = new BasicEList<NamedElement>();

			for (Relationship rel : ((Classifier) op.eContainer()).getRelationships()) {
				if (rel instanceof InterfaceRealization) {
					relationships.addAll(((InterfaceRealization) rel).getSuppliers());
				}
			}

			if (relationships != null && !relationships.isEmpty()) {
				for (NamedElement item : relationships) {
					if (!(item instanceof Classifier))
						continue;
					Classifier comp = (Classifier) item;
					if (!ViewUtils.isComponentView(ViewUtils.getView(comp))) 
						continue;
					
					boolean isContained = false;
					// for each operation belonging to the supplier
					// interface
					for (Operation cOp : comp.getOperations()) {
						boolean isEqual = true;
						// check the name
						if (cOp.getName().equals(opName)) {
							// if the modification regards the parameter
							if (((EStructuralFeature) notification
									.getFeature()).getName()
									.equalsIgnoreCase("ownedParameter")) {
								// user is trying to adding a parameter
								if (notification.getOldValue() == null) {
									if (cOp.getOwnedParameters().size() != op
											.getOwnedParameters().size() - 1)
										isEqual = false;
								} else if (cOp.getOwnedParameters().size() != op
										.getOwnedParameters().size() + 1)
									isEqual = false;
							} else if (cOp.getOwnedParameters().size() != op
									.getOwnedParameters().size())
								isEqual = false;

							if (((EStructuralFeature) notification
									.getFeature()).getName()
									.equalsIgnoreCase("visibility")) {
								if (!cOp.getVisibility().equals(
										notification.getOldValue()))
									isEqual = false;
							} else if (cOp.getVisibility().getValue() != op
									.getVisibility().getValue())
								isEqual = false;

							if (((EStructuralFeature) notification
									.getFeature()).getName()
									.equalsIgnoreCase("isAbstract")) {
								if (cOp.isAbstract() != notification
										.getOldBooleanValue())
									isEqual = false;
							} else if (cOp.isAbstract() != op.isAbstract())
								isEqual = false;

							if (((EStructuralFeature) notification
									.getFeature()).getName()
									.equalsIgnoreCase("isQuery")) {
								if (cOp.isQuery() != notification
										.getOldBooleanValue())
									isEqual = false;
							} else if (cOp.isQuery() != op.isQuery())
								isEqual = false;

							if (((EStructuralFeature) notification
									.getFeature()).getName()
									.equalsIgnoreCase("isLeaf")) {
								if (cOp.isLeaf() != notification
										.getOldBooleanValue())
									isEqual = false;
							} else if (cOp.isLeaf() != op.isLeaf())
								isEqual = false;

							if (((EStructuralFeature) notification
									.getFeature()).getName()
									.equalsIgnoreCase("isStatic")) {
								if (cOp.isStatic() != notification
										.getOldBooleanValue())
									isEqual = false;
							} else if (cOp.isStatic() != op.isStatic())
								isEqual = false;

							if (((EStructuralFeature) notification
									.getFeature()).getName()
									.equalsIgnoreCase("concurrency")) {
								if (!cOp.getConcurrency().equals(
										notification.getOldValue()))
									isEqual = false;
							} else if (cOp.getConcurrency().getValue() != op
									.getConcurrency().getValue())
								isEqual = false;

						} else
							isEqual = false;

						if (isEqual) {
							isContained = true;
							break;
						}
					}

					if (isContained) {
						return true;
					}
				}
			}
			return false;
		}
	};
	
	
}