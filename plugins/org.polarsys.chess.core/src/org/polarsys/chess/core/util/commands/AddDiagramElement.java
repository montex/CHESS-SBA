/*
-----------------------------------------------------------------------
--          			CHESS core plugin							 --
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

package org.polarsys.chess.core.util.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ComponentOperationCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.ComponentCompositeCompartmentEditPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Realization;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.polarsys.chess.core.util.CHESSProjectSupport;
import org.polarsys.chess.core.util.uml.UMLUtils;


public class AddDiagramElement {
	public static Command addOperationCommand(
			TransactionalEditingDomain domain, final Interface interf, final Component comp) {
		
		return new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				PapyrusMultiDiagramEditor editor = (PapyrusMultiDiagramEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				StringBuilder s = new StringBuilder();
				
				s.delete(0, s.length());
				s.append("CREATING OP");
				CHESSProjectSupport.CHESS_CONSOLE.println(s.toString());
				
				for (Operation operation : interf.getAllOperations()) 
				{
					s.delete(0, s.length());
					s.append("OP " + operation);
					CHESSProjectSupport.CHESS_CONSOLE.println(s.toString());
					 
					if ( !UMLUtils.isOperationContained(comp, operation) )
					{
						s.delete(0, s.length());
						s.append("OP DA CREARE");
						CHESSProjectSupport.CHESS_CONSOLE.println(s.toString());
						
						//EList<String> paramNames = UMLUtils.getParamNames(operation.getOwnedParameters());
						Operation newOp = comp.createOwnedOperation(operation.getName(),null,null);
						s.delete(0, s.length());
						s.append("OP CREATA");
						CHESSProjectSupport.CHESS_CONSOLE.println(s.toString());
						
						UMLUtils.copyOperation(operation, newOp);
						s.delete(0, s.length());
						s.append("OP COPIATA");
						CHESSProjectSupport.CHESS_CONSOLE.println(s.toString());
						
						
						createGraphicalOperation(comp, newOp);
					}
				}
				
			}
			
		};
	}
	
	public static Command addOperationCommand(TransactionalEditingDomain domain, final Component interf, final Component comp) {
		
		return new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				PapyrusMultiDiagramEditor editor = (PapyrusMultiDiagramEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				for (Operation operation : interf.getAllOperations()) 
				{
					if ( !UMLUtils.isOperationContained(comp, operation) )
					{
						//EList<String> paramNames = UMLUtils.getParamNames(operation.getOwnedParameters());
						Operation newOp = comp.createOwnedOperation(operation.getName(),null,null);
						UMLUtils.copyOperation(operation, newOp);
						
						createGraphicalOperation(comp, newOp);
					}
				}
				
			}
			
		};
	}

	public static void addClientServerPort(Component comp, EList<Dependency> dependencies)
	{
		Profile gcm = null;
		Stereotype stereo = null;
		EList<Profile> profiles = comp.getNearestPackage().getAppliedProfiles();
		
		for (Profile profile : profiles) 
		{
			if ( profile.getName().equalsIgnoreCase("gcm"))
			{
				//MARTEProfileManager.getClientServerPort() is not working so far :(
				gcm = profile;
			}
		}
		
		for (Dependency dependency : dependencies) 
		{
			//Dependency dep = (Dependency) dependency;
			for (NamedElement dep_sup : dependency.getSuppliers()) 
			{
				if ( comp.getOwnedPort(dep_sup.getName(), (Interface)dep_sup) == null )
				{
					Port port = comp.createOwnedPort(dep_sup.getName(), (Interface)dep_sup);
					EObject p = port.applyStereotype(gcm.getOwnedStereotype("ClientServerPort"));
					if (p instanceof DynamicEObjectImpl) 
					{
						DynamicEObjectImpl d = (DynamicEObjectImpl) p;
						stereo = UMLUtil.getStereotype(d);
					}
					
					EList<Interface> tmp = null;
					
					if ( dependency instanceof InterfaceRealization )
					{
						if ( port.getValue(stereo, "provInterface") != null  )
						{
							tmp =  (EList<Interface>) port.getValue(stereo, "provInterface");
							tmp.add((Interface)dep_sup);
						}
						port.setValue(stereo, "kind", "provided");
						//DO NOT SET THE VALUE AGAIN OR THE LIST WILL BE CLEARED UP!!!
						//port.setValue(gcm.getOwnedStereotype("ClientServerPort"), "reqInterface", tmp);
					}
					else if ( dependency instanceof Realization )
					{
						//NOT YET DEFINED
					}
					else 
					{
						if ( port.getValue(stereo, "reqInterface") != null  )
						{
							tmp =  (EList<Interface>) port.getValue(stereo, "reqInterface");
							tmp.add((Interface)dep_sup);
							port.setValue(stereo, "kind", "required");
							//DO NOT SET THE VALUE AGAIN OR THE LIST WILL BE CLEARED UP!!!
							//port.setValue(gcm.getOwnedStereotype("ClientServerPort"), "reqInterface", tmp);
						}
					}
					
					createGraphicalPort(comp, port);
				}
			}
		}
	}
	
	public static Command addPortCommand(TransactionalEditingDomain domain, final Component interf, final Component comp) {
		
		return new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				//addClientServerPort(comp, interf.getClientDependencies());
				Profile gcm = null;
				Stereotype stereo = null;
				EList<Profile> profiles = comp.getNearestPackage().getAppliedProfiles();
				
				for (Profile profile : profiles) 
				{
					if ( profile.getName().equalsIgnoreCase("gcm"))
					{
						//MARTEProfileManager.getClientServerPort() is not working so far :(
						gcm = profile;
					}
				}
				
				stereo = gcm.getOwnedStereotype("ClientServerPort");
				
				for (Dependency dependency : interf.getClientDependencies()) 
				{
					for (NamedElement dep_sup : dependency.getSuppliers()) 
					{
						if ( comp.getOwnedPort(dep_sup.getName(), (Interface)dep_sup) == null )
						{
							Port port = comp.createOwnedPort(dep_sup.getName(), (Interface)dep_sup);
							
							EObject p = port.applyStereotype(stereo);
							
							EList<Interface> tmp = null;
							
							if ( dependency instanceof InterfaceRealization )
							{
								if ( port.getValue(stereo, "provInterface") != null  )
								{
									tmp =  (EList<Interface>) port.getValue(stereo, "provInterface");
									tmp.add((Interface)dep_sup);
								}
								port.setValue(stereo, "kind", "provided");
								//DO NOT SET THE VALUE AGAIN OR THE LIST WILL BE CLEARED UP!!!
								//port.setValue(gcm.getOwnedStereotype("ClientServerPort"), "reqInterface", tmp);
							}
							else if ( dependency instanceof Realization )
							{
								//NOT YET DEFINED
							}
							else 
							{
								if ( port.getValue(stereo, "reqInterface") != null  )
								{
									tmp =  (EList<Interface>) port.getValue(stereo, "reqInterface");
									tmp.add((Interface)dep_sup);
									port.setValue(stereo, "kind", "required");
									//DO NOT SET THE VALUE AGAIN OR THE LIST WILL BE CLEARED UP!!!
									//port.setValue(gcm.getOwnedStereotype("ClientServerPort"), "reqInterface", tmp);
								}
							}
							
							createGraphicalPort(comp, port);
						}
					}
				}

			}
			
		};
	}

	
	//add operation to the interface's clients
	public static Command addOperationCommand1(TransactionalEditingDomain domain, final Interface interf, final Operation operation){
		return new RecordingCommand(domain) {

			@Override
			protected void doExecute() {							
				PapyrusMultiDiagramEditor editor = (PapyrusMultiDiagramEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				EList<NamedElement> relationships = UMLUtils.getInterfaceClients(interf);
				if ( relationships != null )
				{
					for (int i = 0; i < relationships.size(); i++) 
					{
						if ( relationships.get(i) instanceof Component )
						{
							Component comp = (Component)relationships.get(i);
							Operation newOp = comp.createOwnedOperation(operation.getName(),null,null);
							UMLUtils.copyOperation(operation, newOp);
							
							createGraphicalOperation(comp, newOp);			
						}
					}
				}
				
			}
			
		};
	}
	
	
	
	private static void createGraphicalOperation(Component containerComp, Operation newOp){
		//PapyrusMultiDiagramEditor editor = (PapyrusMultiDiagramEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		IDiagramWorkbenchPart editor = (IDiagramWorkbenchPart) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		DropObjectsRequest dropObjectsRequest = new DropObjectsRequest();
		dropObjectsRequest.setLocation(new Point(1, 1));
		ArrayList<Object> objectList = new ArrayList<Object>();
		objectList.add(newOp);
		dropObjectsRequest.setObjects(objectList);
		List<EditPart> editParts = (List<EditPart>)editor.getDiagramGraphicalViewer().findEditPartsForElement(
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
				
				org.eclipse.gef.commands.Command cmd = compAttrEpart.getCommand(dropObjectsRequest);
				s.delete(0, s.length());
				s.append("EXEC GUI COMMAND" + editParts);
				CHESSProjectSupport.CHESS_CONSOLE.println(s.toString());
				
				editor.getDiagramEditPart().getDiagramEditDomain().getDiagramCommandStack().execute(cmd);
				
			}  
		}
		
	}
	
	private static void createGraphicalPort(Component containerComp, Port port){
		IDiagramWorkbenchPart editor = (IDiagramWorkbenchPart) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		DropObjectsRequest dropObjectsRequest = new DropObjectsRequest();
		dropObjectsRequest.setLocation(new Point(1, 1));
		ArrayList<Object> objectList = new ArrayList<Object>();
		objectList.add(port);
		dropObjectsRequest.setObjects(objectList);
		List<EditPart> editParts = (List<EditPart>)editor.getDiagramGraphicalViewer().findEditPartsForElement(
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
					
					editor.getDiagramEditPart().getDiagramEditDomain().getDiagramCommandStack().execute(cmd);
					
				}  
			}
		}
	}
}
