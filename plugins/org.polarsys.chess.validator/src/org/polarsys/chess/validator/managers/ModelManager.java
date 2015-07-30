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

import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.papyrus.commands.wrappers.EMFtoGMFCommandWrapper;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Type;
import org.polarsys.chess.validator.automatedActions.IAutomatedAction;
import org.polarsys.chess.core.util.uml.UMLUtils;
import org.polarsys.chess.core.views.DiagramStatus;
import org.polarsys.chess.core.views.ViewUtils;
import org.polarsys.chess.validator.libs.ActionsLib;

// TODO: Auto-generated Javadoc
/**
 * The Class ModelManager.
 */
public class ModelManager {

	/** The instance. */
	private static ModelManager instance = new ModelManager();


	/**
	 * Instantiates a new model manager.
	 */
	private ModelManager() {
	}

	/**
	 * Load model manager.
	 *
	 * @return the model manager
	 */
	public static ModelManager loadModelManager() {
		return instance;
	}

	/**
	 * Check.
	 *
	 * @param notificationList the notification list
	 * @param notification the notification
	 * @param _notifier the _notifier
	 * @param s the s
	 * @param diagramStatus the diagram status
	 * @param domain the domain
	 * @return the command
	 * @throws RollbackException the rollback exception
	 */
	public Command check(List<Notification> notificationList, Notification notification,
			Object _notifier, StringBuffer s, DiagramStatus diagramStatus,
			TransactionalEditingDomain domain) throws RollbackException {

		Command command = null;
		
		Object notifier = notification.getNotifier();

		for (IAutomatedAction act : ActionsLib.actionList) {
			command = act.compile(notification, notificationList, domain);
			if (command != null)
				return command;
		}
				
		
		/*
		 * @dynamicConstraint T_S_1 this code is used to catch modification that
		 * occurs on interfaces such that in case the latter are realized by
		 * some component: we need to perform checks in order to assure that the
		 * contract of the interface itself is fulfilled
		 */
		if (notifier instanceof Parameter) {
			if (notification.getEventType() == Notification.SET && ((Parameter) notifier).eContainer() instanceof Operation) {
				Parameter param = (Parameter) notifier;
				Operation op = (Operation) param.eContainer();
				if (op != null && op.eContainer() instanceof Interface) {
					Package view = ViewUtils.getView(op.eContainer());
					// we must check whether the classifier belongs to the
					// functional view
					if (ViewUtils.isComponentView(view)) {

						final Interface intFace = (Interface) op.eContainer();
						EList<NamedElement> relationships = UMLUtils.getInterfaceClients(intFace);
						CompositeCommand cmd = new CompositeCommand("setCommand");
						if (relationships != null) {
							for (int i = 0; i < relationships.size(); i++) {
								if (relationships.get(i) instanceof Component) {
									Component comp = (Component) relationships.get(i);
									relationships.addAll(UMLUtils.getComponentImplementations(comp));

									for (Operation cOperation : comp.getOwnedOperations()) {
										if (cOperation.getName().equalsIgnoreCase(op.getName())) {
											if (notification.getNewValue() instanceof String) {
												if (UMLUtils.areParametersEquals(cOperation, op, param)) {
													Parameter p = cOperation.getOwnedParameter((String) notification.getOldValue(), param.getType());
													SetCommand setC = new SetCommand(domain, p, (EStructuralFeature) notification.getFeature(), notification.getNewValue());
													cmd.add(new EMFtoGMFCommandWrapper(setC));
												}
											} else if (UMLUtils.areParametersEquals(cOperation, op, param)) {
												Type type = null;
												if (notification.getNewValue() instanceof Type)
													type = (Type) notification.getOldValue();
												else
													type = param.getType();

												Parameter p = cOperation.getOwnedParameter(param.getName(), type);
												SetCommand setC = new SetCommand(domain, p, (EStructuralFeature) notification.getFeature(), notification.getNewValue());
												cmd.add(new EMFtoGMFCommandWrapper(setC));
											}
										}
									}
								}
							}
						}
						if (cmd.size() > 0)
							return new GMFtoEMFCommandWrapper(cmd);
					}
				} 
				
			}
		}



		return command;
	}
}
