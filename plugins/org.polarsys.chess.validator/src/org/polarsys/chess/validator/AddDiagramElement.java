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

package org.polarsys.chess.validator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.ClientServerKind;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.ClientServerPort;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowPort;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.sasheditor.editor.ISashWindowsContainer;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageRef;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ComponentOperationCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.ComponentCompositeCompartmentEditPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
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
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.internal.impl.DependencyImpl;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.ResizeableListCompartmentEditPart;
import org.polarsys.chess.core.profiles.MARTEProfileManager;
import org.polarsys.chess.core.util.CHESSProjectSupport;
import org.polarsys.chess.core.util.uml.ResourceUtils;
import org.polarsys.chess.core.util.uml.UMLUtils;
import org.polarsys.chess.core.views.ViewUtils;
import org.polarsys.chess.service.utils.CHESSEditorUtils;


@SuppressWarnings("restriction")
public class AddDiagramElement {
	
	public static Command createDependencies(TransactionalEditingDomain domain, final Component comp, final ClientServerPort port){
		return new RecordingCommand(domain) {
			
			@Override
			protected void doExecute() {
				//Dependency dependency = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createDependency();
				//dependency.getClients().add(namedElement1);
				//dependency.getSuppliers().add(namedElement2);
				if (port.getKind() == ClientServerKind.PROVIDED || port.getKind() == ClientServerKind.PROREQ) {
					for (Interface mInterface : port.getProvInterface()) {
						if (!exists(comp, mInterface, true)){
							StringBuilder s = new StringBuilder(25);
							s.append(comp.getName()).append("_Rlz_").append(mInterface.getName());
							comp.createInterfaceRealization(s.toString(), mInterface);
						}						
						//createGraphicalDependency(comp, dep);
					}
				}
				
				if (port.getKind() == ClientServerKind.REQUIRED || port.getKind() == ClientServerKind.PROREQ) {
					for (Interface mInterface : port.getReqInterface()) {
						if (!exists(comp, mInterface, false)){
							Dependency dep = comp.createDependency(mInterface);
							StringBuilder s = new StringBuilder(25);
							s.append(comp.getName()).append("_Dpn_").append(mInterface.getName());
							dep.setName(s.toString());
							//createGraphicalDependency(comp, dep);
						}
					}
				}
			}

			private boolean exists(Component comp, Interface mInterface,
					boolean interfaceRealization) {
				// interfaceRealization is false when we want to check for pure Dependencies
				if (interfaceRealization) {
					for (InterfaceRealization ir : comp
							.getInterfaceRealizations()) {
						if (ir.getContract().equals(mInterface)) {
							return true;
						}
					}
				} else {
					for (Dependency dp : comp.getClientDependencies()){
						if (dp.getClass().equals(DependencyImpl.class)){
							for (NamedElement i : dp.getSuppliers()) {
								if (i instanceof Interface && mInterface.equals(i))
									return true;
							}
						}
					}
				}

				return false;
			}
		};
	}
	
	public static Command destroyDependencies(TransactionalEditingDomain domain, final EList<? extends Dependency> deps){
		return new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				for (Dependency dependency : deps) {
					dependency.destroy();
				}
			}
		};
	}
	
	
	public static Command addOperationCommand(
			TransactionalEditingDomain domain, final Classifier interf, final Component comp) {
		
		return new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				for (Operation operation : interf.getAllOperations()) {
					if (!UMLUtils.isOperationContained(comp, operation)) {
						Operation newOp = comp.createOwnedOperation(operation.getName(),null,null);
						UMLUtils.copyOperation(operation, newOp);
						createGraphicalOperation(comp, newOp);
					}
				}
				
			}
			
		};
	}
	
//	public static Command addOperationCommand(TransactionalEditingDomain domain, final Component interf, final Component comp) {
//		
//		return new RecordingCommand(domain) {
//
//			@Override
//			protected void doExecute() {
//				for (Operation operation : interf.getAllOperations()) {
//					if (!UMLUtils.isOperationContained(comp, operation))	{
//						//EList<String> paramNames = UMLUtils.getParamNames(operation.getOwnedParameters());
//						Operation newOp = comp.createOwnedOperation(operation.getName(),null,null);
//						UMLUtils.copyOperation(operation, newOp);
//						createGraphicalOperation(comp, newOp);
//					}
//				}
//				
//			}
//			
//		};
//	}

//	public static void addClientServerPort(Component comp, EList<Dependency> dependencies)
//	{
//		Profile gcm = null;
//		Stereotype stereo = null;
//		EList<Profile> profiles = comp.getNearestPackage().getAppliedProfiles();
//		
//		for (Profile profile : profiles) 
//		{
//			if ( profile.getName().equalsIgnoreCase("gcm"))
//			{
//				//MARTEProfileManager.getClientServerPort() is not working so far :(
//				gcm = profile;
//			}
//		}
//		
//		for (Dependency dependency : dependencies) 
//		{
//			Dependency dep = (Dependency) dependency;
//			for (NamedElement dep_sup : dep.getSuppliers()) 
//			{
//				if ( comp.getOwnedPort(dep_sup.getName(), (Interface)dep_sup) == null )
//				{
//					Port port = comp.createOwnedPort(dep_sup.getName(), (Interface)dep_sup);
//					EObject p = port.applyStereotype(gcm.getOwnedStereotype("ClientServerPort"));
//					if (p instanceof DynamicEObjectImpl) 
//					{
//						DynamicEObjectImpl d = (DynamicEObjectImpl) p;
//						stereo = UMLUtil.getStereotype(d);
//					}
//					
//					EList<Interface> tmp = null;
//					
//					if ( dependency instanceof InterfaceRealization )
//					{
//						if ( port.getValue(stereo, "provInterface") != null  )
//						{
//							tmp =  (EList<Interface>) port.getValue(stereo, "provInterface");
//							tmp.add((Interface)dep_sup);
//						}
//						port.setValue(stereo, "kind", "provided");
//						//DO NOT SET THE VALUE AGAIN OR THE LIST WILL BE CLEARED UP!!!
//						//port.setValue(gcm.getOwnedStereotype("ClientServerPort"), "reqInterface", tmp);
//					}
//					else if ( dependency instanceof Realization )
//					{
//						//NOT YET DEFINED
//					}
//					else 
//					{
//						if ( port.getValue(stereo, "reqInterface") != null  )
//						{
//							tmp =  (EList<Interface>) port.getValue(stereo, "reqInterface");
//							tmp.add((Interface)dep_sup);
//							port.setValue(stereo, "kind", "required");
//							//DO NOT SET THE VALUE AGAIN OR THE LIST WILL BE CLEARED UP!!!
//							//port.setValue(gcm.getOwnedStereotype("ClientServerPort"), "reqInterface", tmp);
//						}
//					}
//					
//					createGraphicalPort(comp, port);
//				}
//			}
//		}
//	}
	
	public static Command addAllPortsCommand(TransactionalEditingDomain domain, final Component providerComp, final Component clientComp) {
		return new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				//addClientServerPort(comp, interf.getClientDependencies());
				Profile gcm = ViewUtils.getView(clientComp).getAppliedProfile("MARTE::MARTE_DesignModel::GCM");
				if (gcm == null) 
					return;
				Stereotype cspStereotype = gcm.getOwnedStereotype("ClientServerPort");
				
				for (Port supplierPort : providerComp.getOwnedPorts()) {
					ClientServerPort cspSupplied = UMLUtils.getStereotypeApplication(supplierPort, ClientServerPort.class);
					if (cspSupplied == null)
						continue;
					if (clientComp.getOwnedPort(supplierPort.getName(), supplierPort.getType()) == null){
						Port clientPort = clientComp.createOwnedPort(supplierPort.getName(), supplierPort.getType());
						ClientServerPort cspClient = (ClientServerPort) clientPort.applyStereotype(cspStereotype);
						cspClient.setKind(cspSupplied.getKind());
						clientPort.setValue(cspStereotype, "provInterface", supplierPort.getValue(cspStereotype, "provInterface"));
						clientPort.setValue(cspStereotype, "reqInterface", supplierPort.getValue(cspStereotype, "reqInterface"));
					}
					
				}
				
				//flow ports!
				EList<Port> typePortList = providerComp.getOwnedPorts();
				for (Port typePort : typePortList) {
					Stereotype typeFlowPort = typePort.getAppliedStereotype("MARTE::MARTE_DesignModel::GCM::FlowPort");
//					EList<Dependency> typePortMappings = typePort.getClientDependencies();
					//if port doesn't already exists in the implementation (client)
					if (clientComp.getOwnedPort(typePort.getName(), typePort.getType()) == null){
						//create it!
						Port implPort = clientComp.createOwnedPort(typePort.getName(), typePort.getType());
						//apply <<FlowPort>> and set "direction"
						implPort.applyStereotype(typeFlowPort);
						Stereotype implFlowPort = implPort.getAppliedStereotype("MARTE::MARTE_DesignModel::GCM::FlowPort");
						implPort.setValue(implFlowPort, "direction", typePort.getValue(typeFlowPort, "direction"));
						
						//copy the mappings: SKIPPED FOR THE MOMENT -  mappings are defined at ComponentType level
//						Package owningPkg = implPort.allOwningPackages().get(0);
//						for (Dependency dep : typePortMappings) {
//							if(dep instanceof Abstraction && dep.getAppliedStereotype("MARTE::MARTE_Foundations::Alloc::Allocate") != null){
//								Abstraction abs = UMLFactory.eINSTANCE.createAbstraction();
//								
////								abs.getClients().add();
//								abs.getSuppliers().add(implPort);
//								abs.setName(dep.getName());
//								owningPkg.getPackagedElements().add(abs);
//								//apply <<Allocate>> stereotype
//								MARTEProfileManager.applyStereotypeTo("allocate", abs);
//							}
//						}
					}
				}
				
				
//				for (Port p : providerComp.getOwnedPorts()) {
//					Port po = p;
//					boolean alreadyExits = false;
//					
//					clientComp.getOwnedPort(p.getName(), p.getType());
//					if (!alreadyExits){
//						clientComp.createOwnedPort(name, type)
//					}
//				}
				
				
//				for (Dependency dependency : providerComp.getClientDependencies()) {
//					for (NamedElement supplier : dependency.getSuppliers()) {
//						if (clientComp.getOwnedPort(supplier.getName(), (Interface)supplier) == null )	{
//							Port port = clientComp.createOwnedPort(supplier.getName(), (Interface)supplier);
//							
//							port.applyStereotype(cspStereotype);
//							
//							EList<Interface> tmp = null;
//							
//							if ( dependency instanceof InterfaceRealization )
//							{
//								if ( port.getValue(cspStereotype, "provInterface") != null  )
//								{
//									tmp =  (EList<Interface>) port.getValue(cspStereotype, "provInterface");
//									tmp.add((Interface)supplier);
//								}
//								port.setValue(cspStereotype, "kind", "provided");
//								//DO NOT SET THE VALUE AGAIN OR THE LIST WILL BE CLEARED UP!!!
//								//port.setValue(gcm.getOwnedStereotype("ClientServerPort"), "reqInterface", tmp);
//							}
//							else if ( dependency instanceof Realization )
//							{
//								//NOT YET DEFINED
//							}
//							else 
//							{
//								if ( port.getValue(cspStereotype, "reqInterface") != null  )
//								{
//									tmp =  (EList<Interface>) port.getValue(cspStereotype, "reqInterface");
//									tmp.add((Interface)supplier);
//									port.setValue(cspStereotype, "kind", "required");
//									//DO NOT SET THE VALUE AGAIN OR THE LIST WILL BE CLEARED UP!!!
//									//port.setValue(gcm.getOwnedStereotype("ClientServerPort"), "reqInterface", tmp);
//								}
//							}
//							
//							createGraphicalPort(clientComp, port);
//						}
//					}
//				}

			}
			
		};
	}

	
	
	
	public static Command addPortCommand(TransactionalEditingDomain domain, final Component providerComp, final Component clientComp, final Port supplierPort) {
		return new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				//addClientServerPort(comp, interf.getClientDependencies());
				Profile gcm = ViewUtils.getView(clientComp).getAppliedProfile("MARTE::MARTE_DesignModel::GCM");
				if (gcm == null) 
					return;
				Stereotype cspStereotype = gcm.getOwnedStereotype("ClientServerPort");
				ClientServerPort cspSupplied = UMLUtils.getStereotypeApplication(supplierPort, ClientServerPort.class);
				if (cspSupplied == null)
					return;
				if (clientComp.getOwnedPort(supplierPort.getName(), supplierPort.getType()) == null){
					Port clientPort = clientComp.createOwnedPort(supplierPort.getName(), supplierPort.getType());
					ClientServerPort cspClient = (ClientServerPort) clientPort.applyStereotype(cspStereotype);
					cspClient.setKind(cspSupplied.getKind());
					clientPort.setValue(cspStereotype, "provInterface", supplierPort.getValue(cspStereotype, "provInterface"));
					clientPort.setValue(cspStereotype, "reqInterface", supplierPort.getValue(cspStereotype, "reqInterface"));
				}
			}
		};
	}
	
	
	//add operation to the interface's clients
	public static Command addOperationCommand1(TransactionalEditingDomain domain, final Interface interf, final Operation operation){
		return new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				EList<NamedElement> relationships = UMLUtils.getInterfaceClients(interf);
				if (relationships != null && !relationships.isEmpty()) {
					for (NamedElement element : relationships) {
						if (element instanceof Component){
							Component comp = (Component)element;
							for (NamedElement compImpl : UMLUtils.getComponentImplementations(comp)) {
								if (compImpl instanceof Component){
									Operation newOp = ((Class) compImpl).createOwnedOperation(operation.getName(),null,null);
									UMLUtils.copyOperation(operation, newOp);
									createGraphicalOperation((Component) compImpl, newOp);
								}
							}
							Operation newOp = comp.createOwnedOperation(operation.getName(),null,null);
							UMLUtils.copyOperation(operation, newOp);
							
							createGraphicalOperation(comp, newOp);			
						}
					}
				}
				
			}
			
		};
	}
	
	
	/*private static void createGraphicalDependency(Component comp, Dependency dep){
		PapyrusMultiDiagramEditor editor = (PapyrusMultiDiagramEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		ISashWindowsContainer container = null;
		try {
			container = ServiceUtils.getInstance().getISashWindowsContainer(editor.getServicesRegistry());
		} catch (ServiceException e) {
			return;
		}
		
		DropObjectsRequest dropObjectsRequest = new DropObjectsRequest();
		dropObjectsRequest.setLocation(new Point(1, 1));
		ArrayList<Object> objectList = new ArrayList<Object>();
		objectList.add(dep);
		dropObjectsRequest.setObjects(objectList);
		List<EditPart> editParts = (List<EditPart>)editor.getDiagramGraphicalViewer().findEditPartsForElement(
				EMFCoreUtil.getProxyID(comp),
				INodeEditPart.class
			);
		
		List<Object> childrenEparts = editParts.get(0).getChildren();
		ComponentOperationCompartmentEditPart compAttrEpart = null;
		for(int i=0; i<childrenEparts.size(); i++){
			if(childrenEparts.get(i) instanceof ComponentOperationCompartmentEditPart){
				compAttrEpart = (ComponentOperationCompartmentEditPart)childrenEparts.get(i);
				
				org.eclipse.gef.commands.Command cmd = compAttrEpart.getCommand(dropObjectsRequest);
				
				editor.getDiagramEditPart().getDiagramEditDomain().getDiagramCommandStack().execute(cmd);
				
			}  
		}
		
	}*/
	
	private static void createGraphicalOperation(Component containerComp, Operation newOp){
		IMultiDiagramEditor editor = EditorUtils.getMultiDiagramEditor();
		/*ISashWindowsContainer container = null;
		try {
			container = ServiceUtils.getInstance().getISashWindowsContainer(editor.getServicesRegistry());
		} catch (ServiceException e) {
			return;
		}
		Object model = container.getActiveSashWindowsPage().getRawModel();
		Diagram diagram = null;
		if (model instanceof PageRef) {
			EObject diagramEObj = ((PageRef) model).getEmfPageIdentifier();
			if (diagramEObj instanceof Diagram) {
				diagram = (Diagram) diagramEObj;
			}
		}*/
		Diagram diagram = (Diagram)editor.getAdapter(Diagram.class);
		DiagramEditPart diagramEP = (DiagramEditPart)editor.getAdapter(DiagramEditPart.class);
		IDiagramGraphicalViewer viewer = (IDiagramGraphicalViewer)diagramEP.getViewer();
		
		DropObjectsRequest dropObjectsRequest = new DropObjectsRequest();
		dropObjectsRequest.setLocation(new Point(1, 1));
		ArrayList<Object> objectList = new ArrayList<Object>();
		objectList.add(newOp);
		dropObjectsRequest.setObjects(objectList);
		@SuppressWarnings("unchecked")
		List<EditPart> editParts = (List<EditPart>)viewer.findEditPartsForElement(
				EMFCoreUtil.getProxyID(containerComp),
				INodeEditPart.class
			);
		
		StringBuilder s = new StringBuilder();
		
		s.delete(0, s.length());
		s.append("CREATING GUI OP");
		CHESSProjectSupport.CHESS_CONSOLE.println(s.toString());
		
		
		s.delete(0, s.length());
		s.append("EDITPARTS " + editParts);
		CHESSProjectSupport.CHESS_CONSOLE.println(s.toString());
		
		s.delete(0, s.length());
		s.append("EDITPARTS SIZE " + editParts.size());
		CHESSProjectSupport.CHESS_CONSOLE.println(s.toString());
		
		List<Object> childrenEparts = editParts.get(0).getChildren();
		ComponentOperationCompartmentEditPart compAttrEpart = null;
		for(int i=0; i<childrenEparts.size(); i++){
			if(childrenEparts.get(i) instanceof ComponentOperationCompartmentEditPart){
				compAttrEpart = (ComponentOperationCompartmentEditPart)childrenEparts.get(i);
				org.eclipse.gef.commands.Command cmd = compAttrEpart.getTargetEditPart(dropObjectsRequest).getCommand(dropObjectsRequest);
				//org.eclipse.gef.commands.Command cmd = compAttrEpart.getCommand(dropObjectsRequest);
				s.delete(0, s.length());
				s.append("EXEC GUI COMMAND" + editParts);
				CHESSProjectSupport.CHESS_CONSOLE.println(s.toString());
				diagramEP.getDiagramEditDomain().getDiagramCommandStack().execute(cmd);
			}  
		}
		
	}
	
	private static void createGraphicalPort(Component containerComp, Port port){
		IMultiDiagramEditor editor = EditorUtils.getMultiDiagramEditor();
		Diagram diagram = (Diagram)editor.getAdapter(Diagram.class);
		DiagramEditPart diagramEP = (DiagramEditPart)editor.getAdapter(DiagramEditPart.class);
		IDiagramGraphicalViewer viewer = (IDiagramGraphicalViewer)diagramEP.getViewer();
		DropObjectsRequest dropObjectsRequest = new DropObjectsRequest();
		dropObjectsRequest.setLocation(new Point(1, 1));
		ArrayList<Object> objectList = new ArrayList<Object>();
		objectList.add(port);
		dropObjectsRequest.setObjects(objectList);
		@SuppressWarnings("unchecked")
		List<EditPart> editParts = (List<EditPart>)viewer.findEditPartsForElement(
				EMFCoreUtil.getProxyID(containerComp),
				INodeEditPart.class
			);
		
		if ( editParts.size() > 0 )
		{
			List<Object> childrenEparts = editParts.get(0).getChildren();
			ComponentCompositeCompartmentEditPart compAttrEpart = null;
			for(int i=0; i<childrenEparts.size(); i++)
			{		
				if(childrenEparts.get(i) instanceof ComponentCompositeCompartmentEditPart){
					compAttrEpart = (ComponentCompositeCompartmentEditPart)childrenEparts.get(i);
					
					org.eclipse.gef.commands.Command cmd = compAttrEpart.getCommand(dropObjectsRequest);
					
					diagramEP.getDiagramEditDomain().getDiagramCommandStack().execute(cmd);
					
				}  
			}
		}
	}
	
	
	//adds a Comment stereotyped with Assign to the assignList of the deployment view
	public static Command addCommentCommand(
			TransactionalEditingDomain domain, final Comment comm) {
		
		return new RecordingCommand(domain) {

			@Override
			protected void doExecute() {

				
				PapyrusMultiDiagramEditor editor = CHESSEditorUtils.getCHESSEditor();
				if (editor == null)
					return;
				
				if(comm.getAppliedStereotype("MARTE::MARTE_Foundations::Alloc::Assign")!= null){
					try {
						Resource res = ResourceUtils.getUMLResource(editor.getServicesRegistry());
						Model umlModel = ResourceUtils.getModel(res);
						
						Package deplViewPkg = (Package) umlModel.getPackagedElement("modelDeploymentView");
						Stereotype deplView = deplViewPkg.getAppliedStereotype("CHESS::Core::CHESSViews::DeploymentView");
						if (deplView != null){
							EList<Comment> tmp = (EList<Comment>) deplViewPkg.getValue(deplView, "AssignList");
							tmp.add(comm);
							//editor.getDiagramStatus().setUserAction(false);
							System.out.println(deplViewPkg.getValue(deplView, "AssignList").toString());
						}
						
					} catch (ServiceException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
	}
	
	public static Command removeCommentCommand(
			TransactionalEditingDomain domain, final Comment comm) {

		return new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				PapyrusMultiDiagramEditor editor = CHESSEditorUtils.getCHESSEditor();
				if (editor == null)
					return;
				
				if(comm.getAppliedStereotype("MARTE::MARTE_Foundations::Alloc::Assign")!= null){

					try {
						Resource res = ResourceUtils.getUMLResource(editor.getServicesRegistry());
						Model umlModel = ResourceUtils.getModel(res);

						Package deplViewPkg = (Package) umlModel.getPackagedElement("modelDeploymentView");
						Stereotype deplView = deplViewPkg.getAppliedStereotype("CHESS::Core::CHESSViews::DeploymentView");
						if (deplView != null){
							EList<Comment> tmp = (EList<Comment>) deplViewPkg.getValue(deplView, "AssignList");
							tmp.remove(comm);
						}

					} catch (ServiceException e) {
						e.printStackTrace();
					}

				}

			}
		};

	}
	
	public static Command addParameterCommand(final Interface opCont, final Parameter param, final Operation operation, TransactionalEditingDomain domain) {
		return new RecordingCommand(domain) {
		
			@Override
			protected void doExecute() {
				
				EList<Component> relationships = UMLUtils.getAllInterfaceComponents(opCont);
				if (relationships == null || relationships.isEmpty()) 
					return;
				for (Component comp : relationships) {
					for (Operation op : comp.getOwnedOperations()) {
						if (UMLUtils.areOperationsEqual(operation, op, param)) {
							Parameter tmp = op.createOwnedParameter(param.getName(),param.getType());
							tmp.setDirection(param.getDirection());
							tmp.setEffect(param.getEffect());
						}
					}
				}
			}
		};
	}
	
	
	//TODO very similar to addAllPortsCommand: refactor? 
	public static Command updateImplementationsPorts(
			TransactionalEditingDomain domain, final ClientServerPort cspSupplied) {
		
		return new RecordingCommand(domain) {
			
			@Override
			protected void doExecute() {
				Port supplierPort = cspSupplied.getBase_Port();
				Element supplierComp = supplierPort.getOwner();
				if (!UMLUtils.isComponentType(supplierComp))
					return;
				
				Profile gcm = ViewUtils.getView(supplierComp).getAppliedProfile("MARTE::MARTE_DesignModel::GCM");
				if (gcm == null) 
					return;
				Stereotype cspStereotype = gcm.getOwnedStereotype("ClientServerPort");
				
				for(Component clientComp: UMLUtils.getComponentImplementations((Component) supplierComp)){
					Port clientPort = clientComp.getOwnedPort(supplierPort.getName(), supplierPort.getType());
					if (clientPort == null){
						clientPort = clientComp.createOwnedPort(supplierPort.getName(), supplierPort.getType());
						MARTEProfileManager.applyStereotypeTo("ClientServerPort", clientPort);
					}
//						return;
					ClientServerPort cspClient = (ClientServerPort) clientPort.getStereotypeApplication(cspStereotype);
					cspClient.setKind(cspSupplied.getKind());
					clientPort.setValue(cspStereotype, "provInterface", supplierPort.getValue(cspStereotype, "provInterface"));
					clientPort.setValue(cspStereotype, "reqInterface", supplierPort.getValue(cspStereotype, "reqInterface"));
				}
			}
		};
	}
	
	
	public static Command updateImplementationsFlowPorts(
			TransactionalEditingDomain domain, final FlowPort flPort) {
		
		return new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				// TODO Auto-generated method stub
				Port portType = flPort.getBase_Port();
				Element compType = portType.getOwner();
				if (!UMLUtils.isComponentType(compType))
					return;
				
				Stereotype flpType = portType.getAppliedStereotype("MARTE::MARTE_DesignModel::GCM::FlowPort");
				
				for(Component compImpl : UMLUtils.getComponentImplementations((Component) compType)){
					Port portImpl = compImpl.getOwnedPort(portType.getName(), portType.getType());
					if (portImpl == null){
						portImpl = compImpl.createOwnedPort(portType.getName(), portType.getType());
						MARTEProfileManager.applyStereotypeTo("FlowPort", portImpl);
					}
					Stereotype flpImpl = portImpl.getAppliedStereotype("MARTE::MARTE_DesignModel::GCM::FlowPort");
					portImpl.setValue(flpImpl, "direction", portType.getValue(flpType, "direction"));
				}
			}
			
		};

	}
	
	
	public static Command removeImplementationsPorts(
			TransactionalEditingDomain domain, final Port supplierPort) {
		
		return new RecordingCommand(domain) {
			
			@Override
			protected void doExecute() {
				Element supplierComp = supplierPort.getOwner();
				if (!UMLUtils.isComponentType(supplierComp))
					return;
				
				for(Component clientComp: UMLUtils.getComponentImplementations((Component) supplierComp)){
					Port clientPort = clientComp.getOwnedPort(supplierPort.getName(), supplierPort.getType());
					if (clientPort == null)
						return;
					clientPort.destroy();
				}
			}
		};
	}

	
}
