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


import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.ClientServerPort;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowPort;
import org.eclipse.papyrus.commands.wrappers.EMFtoGMFCommandWrapper;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.tools.listeners.PapyrusStereotypeListener;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Realization;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.internal.impl.RealizationImpl;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification;
import org.polarsys.chess.validator.automatedActions.IAutomatedAction;
import org.polarsys.chess.core.util.CHESSProjectSupport;
import org.polarsys.chess.core.util.uml.UMLUtils;
import org.polarsys.chess.core.views.ViewUtils;
import org.polarsys.chess.service.utils.CHESSEditorUtils;
import org.polarsys.chess.validator.Activator;
import org.polarsys.chess.validator.managers.AddDiagramElement;
import org.polarsys.chess.validator.messages.Messages;

// TODO: Auto-generated Javadoc
/**
 * The Class ActionsLib contains the implementation of the Automated Actions
 */
public class ActionsLib {
	
	/** The port modification action. */
	public static IAutomatedAction portModificationAction = new IAutomatedAction() {
		@Override
		public Command compile(Notification notification, List<Notification> notificationList,
				TransactionalEditingDomain domain) {
			Object notifier = notification.getNotifier();
			// in case of modification of a clientserverport
			if (notifier instanceof Port
					&& notification.getEventType() == PapyrusStereotypeListener.MODIFIED_STEREOTYPE) {
				// if
				// (((EObject)notification.getNewValue()).eClass().getName().equals("ClientServerPort")){}
				if (notification.getNewValue() instanceof ClientServerPort) {
					if (((Port) notifier).getOwner() instanceof Component) {
						Component comp = (Component) ((Port) notifier).getOwner();
						if (!(UMLUtils.isComponentType(comp) && ViewUtils.isComponentView(ViewUtils.getView(comp))))
							return null;
						

						ClientServerPort port = (ClientServerPort) notification.getNewValue();

						EList<Dependency> cDependenciesToRemove = UMLUtils.computeDependenciesToRemove(comp);
						EList<InterfaceRealization> cRealizationsToRemove = UMLUtils.computeRealizationsToRemove(comp);

						// CompositeCommand cc = new
						// CompositeCommand("portAutomations");
						// cc.add(new
						// EMFtoGMFCommandWrapper(AddDiagramElement.destroyDependencies(domain,
						// cDependenciesToRemove)));
						// cc.add(new
						// EMFtoGMFCommandWrapper(AddDiagramElement.destroyDependencies(domain,
						// cRealizationsToRemove)));
						// cc.add(new
						// EMFtoGMFCommandWrapper(AddDiagramElement.createDependencies(domain,
						// comp, port)));
						// if (!cc.isEmpty()){
						// return new GMFToEMFCommand(ccc);
						// }

						CompoundCommand ccc = new CompoundCommand("portAutomations");
						ccc.append(AddDiagramElement.updateImplementationsPorts(domain, port));
						ccc.append(AddDiagramElement.destroyDependencies(domain, cDependenciesToRemove));
						ccc.append(AddDiagramElement.destroyDependencies(domain, cRealizationsToRemove));
						ccc.append(AddDiagramElement.createDependencies(domain,	comp, port));
						return ccc;
					}
				}
				
				else if(notification.getNewValue() instanceof FlowPort){
					if (((Port) notifier).getOwner() instanceof Component) {
						Component comp = (Component) ((Port) notifier).getOwner();
						if (!(UMLUtils.isComponentType(comp) && ViewUtils.isComponentView(ViewUtils.getView(comp))))
							return null;
						
						FlowPort flPort = (FlowPort) notification.getNewValue();
						
						CompoundCommand cc = new CompoundCommand("portAutomations");
						cc.append(AddDiagramElement.updateImplementationsFlowPorts(domain, flPort));
						return cc;
					}
				}
			}
			return null;
		}
	};

	/** The port removal action. */
	public static IAutomatedAction portRemovalAction = new IAutomatedAction() {
		@Override
		public Command compile(Notification notification, List<Notification> notificationList,
				TransactionalEditingDomain domain) {
			Object notifier = notification.getNotifier();
			// in case of removal of a clientserverport or FlowPort
			if ((notifier instanceof ClientServerPort || notifier instanceof FlowPort)
					&& notification.getEventType() == Notification.SET) {
				if (notification.getFeature() instanceof EReference	
						&& ((EReference) notification.getFeature()).getName().equals("base_Port")
						&& notification.getNewValue() == null) {
					Port p = (Port) notification.getOldValue();
					Element el = p.getOwner();
					
					if (!(el instanceof NamedElement 
							&& UMLUtils.isComponentType((NamedElement) el) 
							&& ViewUtils.isComponentView(ViewUtils.getView(el))))
						return null;
					Component comp = (Component) el;

					EList<Dependency> cDependenciesToRemove = UMLUtils.computeDependenciesToRemove(comp);
					EList<InterfaceRealization> cRealizationsToRemove = UMLUtils.computeRealizationsToRemove(comp);

					CompoundCommand ccc = new CompoundCommand("portAutomations");
					ccc.append(AddDiagramElement.removeImplementationsPorts(domain, p));
					ccc.append(AddDiagramElement.destroyDependencies(domain,
							cDependenciesToRemove));
					ccc.append(AddDiagramElement.destroyDependencies(domain,
							cRealizationsToRemove));
					return ccc;
				}
			}
			return null;
		}
	};
	
	/*
	 * inherited operations are automatically added
	 */
	/** The component interface realization action. */
	public static IAutomatedAction componentInterfaceRealizationAction = new IAutomatedAction() {
		@Override
		public Command compile(Notification notification, List<Notification> notificationList,
				TransactionalEditingDomain domain) {
			Object notifier = notification.getNotifier();
			if (notifier instanceof Component) {
				Component comp = (Component) notifier;
				if (notification.getEventType() == Notification.ADD && notification.getNewValue() instanceof InterfaceRealization) {
					InterfaceRealization link = (InterfaceRealization) notification.getNewValue();
					Interface contract = link.getContract();
					// cheks to be verified only in case the current component
					// belongs to the functional view
					if (ViewUtils.isComponentView(ViewUtils.getView(comp)) && UMLUtils.isComponentType(comp)) {
						return AddDiagramElement.addOperationCommand(domain, contract, comp);
					}
				}
			}
			return null;
		}
	};
	
	/** The component realization action. */
	public static IAutomatedAction componentRealizationAction = new IAutomatedAction() {
		@Override
		public Command compile(Notification notification, List<Notification> notificationList,
				TransactionalEditingDomain domain) {
			Object notifier = notification.getNotifier();
			Object feature = notification.getFeature();
			if(feature instanceof EReference){
				EReference ref = (EReference) feature;
				if(notifier instanceof Realization && ref.getName().equals("supplier")){
					Realization link = (Realization) notifier;
					//get the client (ComponentImplementation) - according to the notifications chain, the client is set before the supplier
					if (link.getClients().size() != 1)
						return null;
					Component clientComp = (Component) link.getClients().get(0);
					//now get the supplier (ComponentType)
					Object newVal = notification.getNewValue();
					if(newVal instanceof Component){
						Component supplierComp = (Component) newVal;
						//checks to be verified only in case the current ComponentImplementation belongs to the functional view
						if (!ViewUtils.isComponentView(ViewUtils.getView(clientComp)) || !UMLUtils.isComponentImplementation(clientComp))
							return null;
						//add operations and ports to the client (ComponentImplementation)
						CompositeCommand cc = new CompositeCommand("portAndOpCommand");
						Command cmd = AddDiagramElement.addOperationCommand(domain,	supplierComp, clientComp);
						cc.add(new EMFtoGMFCommandWrapper(cmd));
						Command cmd2 = AddDiagramElement.addAllPortsCommand(domain, supplierComp, clientComp);
						cc.add(new EMFtoGMFCommandWrapper(cmd2));
						if (!cc.isEmpty()) {
							return new GMFtoEMFCommandWrapper(cc);
						}
					}
				}
			}
			return null;
		}

	};
	
	/** The remove realization operations action. */
	public static IAutomatedAction removeRealizationOperationsAction = new IAutomatedAction() {
		
		private IStatus operationAborted = new Status(IStatus.ERROR,
				Activator.PLUGIN_ID, Messages.operationAborted);
		
		
		@Override
		public Command compile(Notification notification, List<Notification> notificationList,
				TransactionalEditingDomain domain) throws RollbackException {
			Object notifier = notification.getNotifier();
			if (notifier instanceof Component) {
				Component comp = (Component) notifier;

				// Deletion of a Realization link
				if (notification.getEventType() == Notification.REMOVE
						&& notification.getOldValue().getClass().equals(RealizationImpl.class) && notification.getFeature() instanceof EReference && ((EReference)notification.getFeature()).getName().equals("clientDependency")) {
					Package view = ViewUtils.getView((Component) notifier);
					// checks to be verified only in case the current component
					// belongs to the functional view
					Realization rel = (Realization) notification.getOldValue();
					if (!(ViewUtils.isComponentView(view) && UMLUtils.isComponentImplementation(comp)))
						return null;
					PapyrusMultiDiagramEditor editor = CHESSEditorUtils.getCHESSEditor();
					if (editor == null) 
						return null;
					MessageDialog md = CHESSEditorUtils.showConfirmDialog(editor, "Confirm", "Do you want to propagate the removal of the operations of this realization "+rel.getName()+"?");
					// * 0 - OK
					int result = md.open();
					if (result == 0){
						return deleteOperations(comp, view, domain);
					}
					// CANCEL
					if (result == 2){
						CHESSProjectSupport.CHESS_CONSOLE.println(operationAborted.getMessage());
						// TODO why?
						//throw new RollbackException(operationAborted);
					}	
				}
			}
			return null;
		}
		
		
		//TODO it needs to be checked 
		private Command deleteOperations(Component component, Package view,
				TransactionalEditingDomain domain) {
			CompositeCommand cmd = new CompositeCommand("delOpCommand");

			// Delete all the operations of the component
			// implementation
			ArrayList<Operation> opToDel = new ArrayList<Operation>();
			// Delete all the activity diagram
			ArrayList<Behavior> behaviorToDel = new ArrayList<Behavior>();
			// Delete all the owned port
			ArrayList<Port> portToDel = new ArrayList<Port>();
			// Delete all ChRtSpecification attached to the ports
			ArrayList<Comment> commentToDel = new ArrayList<Comment>();

			for (Operation op : component.getOwnedOperations()) {
				opToDel.add(op);
				behaviorToDel.addAll(op.getMethods());
			}

			for (Port p : component.getOwnedPorts()) {
				if (!UMLUtils.isClientServerPort(p))
					continue;
				portToDel.add(p);
				commentToDel.addAll(UMLUtils.getCHRtSpecificationComments(view, p));
			}

			behaviorToDel.addAll(component.getOwnedBehaviors());

			DeleteCommand delC = new DeleteCommand(domain, opToDel);
			cmd.add(new EMFtoGMFCommandWrapper(delC));

			if (portToDel.size() > 0) {

				for (int i = 0; i < portToDel.size(); i++) {
					IElementEditService provider = ElementEditServiceUtils
							.getCommandProvider(portToDel.get(i));

					if (provider == null) {

						continue;

					}
					// Retrieve delete command from the Element Edit
					// service

					DestroyElementRequest request = new DestroyElementRequest(
							portToDel.get(i), false);

					ICommand deleteCommand = provider
							.getEditCommand(request);

					cmd.add(deleteCommand);
				}
			}

			if (commentToDel.size() > 0) {

				for (int i = 0; i < commentToDel.size(); i++) {
					IElementEditService provider = ElementEditServiceUtils
							.getCommandProvider(commentToDel.get(i));

					if (provider == null) {
						continue;
					}
					// Retrieve delete command from the Element Edit
					// service

					DestroyElementRequest request = new DestroyElementRequest(
							commentToDel.get(i), false);

					ICommand deleteCommand = provider.getEditCommand(request);

					cmd.add(deleteCommand);
				}
			}

			// remove all the bahavior related to the selected
			// operation
			if (behaviorToDel.size() > 0) {

				for (int i = 0; i < behaviorToDel.size(); i++) {
					IElementEditService provider = ElementEditServiceUtils
							.getCommandProvider(behaviorToDel.get(i));

					if (provider == null) {
						continue;
					}
					// Retrieve delete command from the Element Edit
					// service

					DestroyElementRequest request = new DestroyElementRequest(
							behaviorToDel.get(i), false);

					ICommand deleteCommand = provider
							.getEditCommand(request);

					cmd.add(deleteCommand);
				}
			}

			if (!cmd.isEmpty())
				return new GMFtoEMFCommandWrapper(cmd);
			return null;
		}
	};
	
	/** The propagate operation modification. */
	public static IAutomatedAction propagateOperationModification = new IAutomatedAction() {
		
		@Override
		public Command compile(Notification notification, List<Notification> notificationList,
				TransactionalEditingDomain domain) throws RollbackException {
			Object notifier = notification.getNotifier();
			if (notifier instanceof Operation) {
				// in case of addition
				if (notification.getEventType() == Notification.SET) {
					Operation op = (Operation) notifier;
					EObject container = op.eContainer();
//					if (container == null && notification.getOldValue() instanceof Interface){
//						container = (EObject) notification.getOldValue();
//					}
						
					if (!(container instanceof Interface))
						return null;
					if (!ViewUtils.isComponentView(ViewUtils.getView(container))) 
						return null;
					
					EList<Component> relationships = UMLUtils.getAllInterfaceComponents((Interface) container);
					if (relationships == null || relationships.isEmpty()) 
						return null;
					
					CompositeCommand cmd = new CompositeCommand("setCommand");
					for (Component comp : relationships) {
							propagateFeature(notification, domain, op, cmd,	comp);
					}
					if (!cmd.isEmpty())
						return new GMFtoEMFCommandWrapper(cmd);
				}
			}
			return null;
		}

		private void propagateFeature(Notification notification,
				TransactionalEditingDomain domain, Operation op,
				CompositeCommand cmd, Component comp) {
			String opName = op.getName();
			if (notification.getFeature() instanceof EAttribute && ((EAttribute)notification.getFeature()).getName().equals("name"))
				opName = (String) notification.getOldValue();
			for (Operation cOperation : comp.getOwnedOperations()) {
				if (cOperation.getName().equalsIgnoreCase(opName)) {
					if (UMLUtils.areParametersEquals(cOperation, op)) {
						SetCommand setC = new SetCommand(domain, cOperation, (EStructuralFeature) notification.getFeature(),
								notification.getNewValue());
						cmd.add(new EMFtoGMFCommandWrapper(setC));
					}
				}
			}
		}
	};
	
	
	/** The propagate interface modification. */
	public static IAutomatedAction propagateInterfaceModification = new IAutomatedAction() {
		
		private IStatus operationAborted = new Status(IStatus.ERROR,
				Activator.PLUGIN_ID, Messages.operationAborted);
		
		@Override
		public Command compile(Notification notification, List<Notification> notificationList,
				TransactionalEditingDomain domain) throws RollbackException {
			Object notifier = notification.getNotifier();
			if (notifier instanceof Interface) {
				Interface interfce = (Interface) notifier;
				
				if (notification.getEventType() == Notification.ADD
						&& notification.getNewValue() instanceof Operation) {
					
					Operation operation = (Operation) notification.getNewValue();
					// checks to be verified only in case the current component
					// belongs to the functional view
					if (ViewUtils.isComponentView(ViewUtils.getView(interfce))) {
						return AddDiagramElement.addOperationCommand1(domain, interfce, operation);
					}
				}
				
				// Deletion of an operation belonging to an interface
				if (notification.getEventType() == Notification.REMOVE
						&& notification.getOldValue() instanceof Operation) {
					Operation operation = (Operation) notification.getOldValue();
					if (!ViewUtils.isComponentView(ViewUtils.getView(interfce)))
						return null;
						
					PapyrusMultiDiagramEditor editor = CHESSEditorUtils.getCHESSEditor();
					if (editor == null) 
						return null;
					MessageDialog md = CHESSEditorUtils.showConfirmDialog(editor, "Confirm", "Do you want to propagate the removal of "+operation.getName()+" from all the  related model elements?");
					// * 0 - OK
					int result = md.open();
					
					
					// * 0 - OK
					// * 1 - No
					// * 2 - Cancel
					switch (result) {
					case 0:
						EList<Component> relationships = UMLUtils.getAllInterfaceComponents(interfce);
						CompositeCommand cmd = new CompositeCommand("delOpCommand");
						
						ArrayList<Operation> opToDel = new ArrayList<Operation>();
						ArrayList<Behavior> behaviorToDel = new ArrayList<Behavior>();

						
						//opToDel.add(operation);
						for (Component cmp : relationships) {
							for (Operation op : cmp.getOwnedOperations()) {
								if (UMLUtils.isOperationEquals(op, operation)) {
									opToDel.add(op);
									behaviorToDel.addAll(op.getMethods());
								}
							}
						}
						cmd.add(new EMFtoGMFCommandWrapper(new DeleteCommand(domain, opToDel)));
						// Remove all <<ChRtSpecification>> with the context
						// attribute set to the equivalent operation of the
						// component implementation
						// <<ChRtSpecification>> are only inside system
						ArrayList<Comment> commentToDel = new ArrayList<Comment>();
						for (Notification aNotification : notificationList) {
							if (aNotification.equals(notification))
								continue;
							if (aNotification.getNotifier() instanceof CHRtSpecification
									&& aNotification.getEventType() == Notification.SET) {
								if (aNotification.getOldValue() instanceof Operation && aNotification.getOldValue().equals(operation)) {
									commentToDel.add(((CHRtSpecification) aNotification.getNotifier()).getBase_Comment());
								}
							}
						}

						if (!commentToDel.isEmpty()) {
							for (Comment comment : commentToDel) {
								IElementEditService provider = ElementEditServiceUtils.getCommandProvider(comment);
								if (provider == null)
									continue;
								// Retrieve delete command from the Element Edit
								// service
								DestroyElementRequest request = new DestroyElementRequest(comment, false);
								ICommand deleteCommand = provider.getEditCommand(request);
								cmd.add(deleteCommand);
							}
						}

						// remove all the bahavior related to the selected
						// operation
						if (!behaviorToDel.isEmpty()) {
							for (Behavior behavior : behaviorToDel) {
								IElementEditService provider = ElementEditServiceUtils.getCommandProvider(behavior);

								if (provider == null)
									continue;

								DestroyElementRequest request = new DestroyElementRequest(behavior, false);
								ICommand deleteCommand = provider.getEditCommand(request);
								cmd.add(deleteCommand);
							}
						}

						if (!cmd.isEmpty())
							return new GMFtoEMFCommandWrapper(cmd);
						break;
					case 2:
						CHESSProjectSupport.CHESS_CONSOLE.println(operationAborted.getMessage());
						throw new RollbackException(operationAborted);
					}
				}
			}
			return null;
		}
	};
		

	/** The propagate parameter removal action. */
	public static IAutomatedAction propagateParameterRemovalAction = new IAutomatedAction() {
		
		@Override
		public Command compile(Notification notification,
				List<Notification> notificationList,
				TransactionalEditingDomain domain) throws RollbackException {
			Object notifier = notification.getNotifier();
			if (notifier instanceof Operation) {
				if ((notification.getEventType() == Notification.REMOVE && notification
						.getOldValue() instanceof Parameter)) {
					Parameter param = (Parameter) notification.getOldValue();
					Operation operation = (Operation) notifier;
					CompositeCommand cmd = new CompositeCommand("delCommand");

					EObject opCont = operation.eContainer();
					if (!(opCont instanceof Interface) || !ViewUtils.isComponentView(ViewUtils.getView(opCont)))
						return null;

					EList<Component> relationships = UMLUtils.getAllInterfaceComponents((Interface) opCont);
					if (relationships == null || relationships.isEmpty())
						return null;
					for (Component comp : relationships) {
						checkOperation:
						for (Operation op : comp.getOwnedOperations()) {
							if (!UMLUtils.areOperationsEqual(op, operation, param))
								continue;
							for (Parameter p : op.getOwnedParameters()) {
								if (UMLUtils.areParametersEqual(p, param)) {
									cmd.add(new DestroyElementCommand(new DestroyElementRequest(p, false)));
									break checkOperation;
								}
							}
							
						}
					
					}

					if (!cmd.isEmpty())
						return new GMFtoEMFCommandWrapper(cmd);
				}
				//case REMOVE_MANY
				if ((notification.getEventType() == Notification.REMOVE_MANY && notification
						.getOldValue() instanceof EList)) {

					@SuppressWarnings("rawtypes")
					EList paramList = (EList) notification.getOldValue();
					boolean test = true;
					for (Object ob : paramList){
						if ((ob instanceof Parameter)) {
							Parameter param = (Parameter) ob;
							Operation operation = (Operation) notifier;
							CompositeCommand cmd = new CompositeCommand("delCommand");
							
							EObject opCont = operation.eContainer();
							if (!(opCont instanceof Interface) || !ViewUtils.isComponentView(ViewUtils.getView(opCont)))
								return null;
							EList<Component> relationships = UMLUtils.getAllInterfaceComponents((Interface) opCont);
							for (Component comp : relationships) {
								checkOperation:
								for (Operation op : comp.getOwnedOperations()) {
									if (!UMLUtils.areOperationsEqual(op, operation, param))
										continue;
									for (Parameter p : op.getOwnedParameters()) {
										if (UMLUtils.areParametersEqual(p, param)) {
											cmd.add(new DestroyElementCommand(new DestroyElementRequest(p, false)));
											break checkOperation;
										}
									}
									
								}
							
							}
							if (!cmd.isEmpty())
								return new GMFtoEMFCommandWrapper(cmd);
						}
					}
				}
				
				
				// end case
				
				
				
			}
			return null;
		}
	};
	
	/** The propagate parameter addition action. */
	public static IAutomatedAction propagateParameterAdditionAction = new IAutomatedAction() {
		
		@Override
		public Command compile(Notification notification,
				List<Notification> notificationList,
				TransactionalEditingDomain domain) throws RollbackException {
			
			Object notifier = notification.getNotifier();
			if (notifier instanceof Operation) {
				if ((notification.getEventType() == Notification.ADD && notification
						.getNewValue() instanceof Parameter)) {
					Parameter param = (Parameter) notification.getNewValue();
					Operation operation = param.getOperation();
					
					EObject opCont = operation.eContainer();
					if ((opCont instanceof Interface) && ViewUtils.isComponentView(ViewUtils.getView(opCont)))
						return AddDiagramElement.addParameterCommand((Interface) opCont, param, operation, domain);
				}
				
				if (notification.getEventType() == Notification.ADD_MANY && notification.getNewValue() instanceof EList){

					@SuppressWarnings("rawtypes")
					EList paramList = (EList) notification.getNewValue();
					boolean test = true;
					EObject opCont = null;
					Operation operation = null;
					for (Object ob : paramList){
						if (!(ob instanceof Parameter)) {
							test = false;
							break;
						}else{
							Parameter par = (Parameter) ob;
							operation = par.getOperation();

							opCont = operation.eContainer();
							if (!(opCont instanceof Interface) || !(ViewUtils.isComponentView(ViewUtils.getView(opCont)))){
								test = false;
								break;
							}
						}
					}
					if (test){
						Parameter param = (Parameter) paramList.get(paramList.size() - 1);
						return AddDiagramElement.addParameterCommand((Interface) opCont, param, operation, domain);
					}
				}				
			}
			return null;
		}
	};
	
	
	/** The comment action. */
	public static IAutomatedAction commentAction = new IAutomatedAction() {
		
		@Override
		public Command compile(Notification notification,
				List<Notification> notificationList,
				TransactionalEditingDomain domain) throws RollbackException {
			if (notification.getNotifier() instanceof Comment) {
				Comment comment = (Comment) notification.getNotifier();
				if (notification.getEventType() == PapyrusStereotypeListener.APPLIED_STEREOTYPE) {
					return AddDiagramElement.addCommentCommand(domain, comment);
				}
				if (notification.getEventType() == PapyrusStereotypeListener.UNAPPLIED_STEREOTYPE) {
					return AddDiagramElement.removeCommentCommand(domain, comment);
				}
			}
			return null;
		}
	};
		
	/** The port addition action. */
	public static IAutomatedAction portAdditionAction = new IAutomatedAction() {
		@Override
		public Command compile(Notification notification,
				List<Notification> notificationList,
				TransactionalEditingDomain domain) throws RollbackException {
			if (notification.getNotifier() instanceof Port && notification.getEventType()==Notification.SET && notification.getFeature() instanceof EAttribute && ((EAttribute)notification.getFeature()).getName().equals("visibility")){
				Port port = (Port)notification.getNotifier();
				Element supplierComp = port.getOwner();
				if (!(UMLUtils.isClientServerPort(port) && UMLUtils.isComponentType(supplierComp)))
					return null;
				
				CompositeCommand cc = new CompositeCommand("portAndOpCommand");
				for(Component cImpl: UMLUtils.getComponentImplementations((Component) supplierComp)){
					Command cmd2 = AddDiagramElement.addPortCommand(domain, (Component) supplierComp, cImpl, port);
					cc.add(new EMFtoGMFCommandWrapper(cmd2));
				}
				
				if (!cc.isEmpty()) {
					return new GMFtoEMFCommandWrapper(cc);
				}
			}
			return null;
		}
	};
	
	
	/** The propagate port modification. */
	public static IAutomatedAction propagatePortModification = new IAutomatedAction() {
		
		@Override
		public Command compile(Notification notification, List<Notification> notificationList,
				TransactionalEditingDomain domain) throws RollbackException {
			Object notifier = notification.getNotifier();
			if (notifier instanceof Port) {
				// in case of addition
				if (notification.getEventType() == Notification.SET) {
					//PAPYRUS BUG: do NOT propagate the name "Port0"
					if (notification.getFeature() instanceof EAttribute && ((EAttribute)notification.getFeature()).getName().equals("name") && notification.getNewValue().equals("Port0"))
						return null;
					
					
					Port port = (Port) notifier;
					EObject container = port.eContainer();
						
					if (!(container instanceof Component))
						return null;
					if (!ViewUtils.isComponentView(ViewUtils.getView(container)) || !UMLUtils.isComponentType(container)) 
						return null;
					
					
					
					EList<Component> relationships = UMLUtils.getComponentImplementations((Component) container);
					if (relationships == null || relationships.isEmpty()) 
						return null;
					
					CompositeCommand cmd = new CompositeCommand("setCommand");
					for (Component comp : relationships) {
							propagateFeature(notification, domain, port, cmd, comp);
					}
					if (!cmd.isEmpty())
						return new GMFtoEMFCommandWrapper(cmd);
				}
			}
			return null;
		}

		private void propagateFeature(Notification notification,
				TransactionalEditingDomain domain, Port port,
				CompositeCommand cmd, Component comp) {
			String opName = port.getName();
			if (notification.getFeature() instanceof EAttribute && ((EAttribute)notification.getFeature()).getName().equals("name"))
				opName = (String) notification.getOldValue();
			Type portType = port.getType();
			if (notification.getFeature() instanceof EAttribute && ((EAttribute)notification.getFeature()).getName().equals("type"))
				portType = (Type) notification.getOldValue();
			Port portComp = comp.getOwnedPort(opName, portType);
			if (portComp == null)
				return;
			SetCommand setC = new SetCommand(domain, portComp, (EStructuralFeature) notification.getFeature(),
					notification.getNewValue());
			cmd.add(new EMFtoGMFCommandWrapper(setC));
		}
	};
	
	
	
	
	
//	public static IAutomatedAction[] actionList = {portModificationAction,
//			portRemovalAction, componentInterfaceRealizationAction,
//			componentRealizationAction, removeRealizationOperationsAction,
//			propagateOperationModification, propagateInterfaceModification,
//			propagateParameterRemovalAction, propagateParameterAdditionAction,
//			commentAction, portAdditionAction, propagatePortModification};
	
	/** The action list. */
public static IAutomatedAction[] actionList = {portModificationAction,
			componentInterfaceRealizationAction, componentRealizationAction,
			commentAction};
	
}
