/*******************************************************************************
 * Copyright (c) 2015 Intecs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Intecs
 *******************************************************************************/
package org.polarsys.chess.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Assign;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Resource;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.uml.tools.providers.UMLLabelProvider;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.dialogs.ListDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.polarsys.chess.chessmlprofile.ComponentModel.ComponentImplementation;
import org.polarsys.chess.chessmlprofile.Core.CHESS;
import org.polarsys.chess.chessmlprofile.Core.CHGaResourcePlatform;
import org.polarsys.chess.chessmlprofile.Core.CHESSViews.DeploymentView;
import org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.Propagation;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtPortSlot;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification;
import org.polarsys.chess.core.profiles.CHESSProfileManager;
import org.polarsys.chess.core.util.uml.ResourceUtils;
import org.polarsys.chess.core.util.uml.UMLUtils;
import org.polarsys.chess.core.views.DiagramStatus;
import org.polarsys.chess.service.utils.CHESSEditorUtils;

public class BuildModelInstanceCommand extends AbstractHandler implements
		IHandler {

	private static final String CHESS = "CHESS::Core::CHESS";
//	private static final String CHESS_COMPIMPL = "CHESS::ComponentModel::ComponentImplementation";
	private static final String CHESS_CHRTSPEC = "CHESS::Predictability::RTComponentModel::CHRtSpecification";
	private static final String CHESS_RESPLATFORM = "CHESS::Core::CHGaResourcePlatform";
	private static final String MARTE_CSP = "MARTE::MARTE_DesignModel::GCM::ClientServerPort";
	private static final String MARTE_RESOURCE = "MARTE::MARTE_Foundations::GRM::Resource";
	private static final String MARTE_ASSIGN = "MARTE::MARTE_Foundations::Alloc::Assign";
	private static ArrayList<AssignCopy> acList;
	private static EList<Comment> assigns;
	private static ArrayList<InstanceSpecification> instancesList = new ArrayList<InstanceSpecification>();
	private static ArrayList<Slot> slotList =  new ArrayList<Slot>();

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		final Shell shell = window.getShell();
		//get the CEHSS Editor
		PapyrusMultiDiagramEditor editor = CHESSEditorUtils.getCHESSEditor();
		final DiagramStatus ds = CHESSEditorUtils.getDiagramStatus(editor);
		List<Component> compImplList = new ArrayList<Component>();
		try{
			//get the UML model
			org.eclipse.emf.ecore.resource.Resource res = ResourceUtils.getUMLResource(editor.getServicesRegistry());
			final Model umlModel = ResourceUtils.getModel(res);
			CHESS chess = (CHESS) umlModel.getStereotypeApplication(umlModel.getAppliedStereotype(CHESS));		
			//get the Components (implementation) of the componentView and deploymentView
			for (Element elem : chess.getComponentView().getBase_Package().allOwnedElements()) {
				if (UMLUtils.getStereotypeApplication(elem, ComponentImplementation.class) != null) {
					compImplList.add((Component) elem);
				}
			}
			for (Element elem : chess.getDeploymentView().getBase_Package().allOwnedElements()) {
				if (elem instanceof Component) {
					compImplList.add((Component) elem);
				}
			}
			//launch the dialog
			ListDialog selectionDialog = new ListDialog(shell);
			selectionDialog.setInput(compImplList);
			selectionDialog.setContentProvider(new ArrayContentProvider());
			selectionDialog.setLabelProvider(new UMLLabelProvider());
			selectionDialog.setTitle("Select the Component for Build Instances");
			Object[] selection = null;
			if(selectionDialog.open() == Window.OK){
				selection = selectionDialog.getResult();
			}
			if(selection != null && selection.length > 0){
				Object obj = selection[0];
				final Component comp = (Component) obj;
				TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(comp);
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					protected void doExecute() {
						ds.setUserAction(false);
						saveAssignAllocations(umlModel);
						//clear instance package, if present
						for(Element elem : comp.getOwner().getOwnedElements()){
							if(elem instanceof Package && ((Package) elem).getName().equals(comp.getName() + "_instSpec")){
								Package pkg = (Package) elem;
								pkg.destroy();
							}
						}
						instancesList.clear();
						slotList.clear();
						//create the instance package
						Package pkg = comp.getNearestPackage();
						Package instPkg = pkg.createNestedPackage(comp.getName() + "_instSpec");
						UMLUtils.applyStereotype(instPkg, CHESS_RESPLATFORM);
						//perform build instances
						buildComponentInstance(instPkg, comp, null, null, null, new HashMap<Property, InstanceSpecification>(), comp.getOwnedComments());
						regenerateAssignAllocations(umlModel);
						//to keep the support to the existing transformations for RT analysis, 
						//apply the <<CHGaResourcePlatform>> stereotype also on the package
						MessageDialog.openInformation(shell, "CHESS", "BuildInstance command completed");
					}
				});
			}
		} catch (Exception e) {
			ds.setUserAction(false);
			e.printStackTrace();
			MessageDialog.openError(shell, "CHESS", "Problems while executing BuildInstance command: " + e.getMessage());
		}
		ds.setUserAction(false);
		return null;
	}
	
	private InstanceSpecification buildComponentInstance(Package pkg, Component comp, CHGaResourcePlatform resPlatform, InstanceSpecification parentInstance, Property theProp, Map<Property, InstanceSpecification> property2InstMap, List<Comment> commList) {
		InstanceSpecification inst = UMLFactory.eINSTANCE.createInstanceSpecification();
		if(theProp != null){
			String name = parentInstance.getName() + "." + theProp.getName();
			inst.setName(name);
		}else{
			inst.setName(comp.getName());
		}
		inst.getClassifiers().add(comp);
		pkg.getPackagedElements().add(inst);
		if(parentInstance != null){
			UMLUtils.applyStereotype(inst, MARTE_RESOURCE);
			Resource res = (Resource) inst.getStereotypeApplication(inst.getAppliedStereotype(MARTE_RESOURCE));
			resPlatform.getResources().add(res);
		}else{
			Stereotype stereo = UMLUtils.applyStereotype(inst, CHESS_RESPLATFORM);
			resPlatform = (CHGaResourcePlatform) inst.getStereotypeApplication(stereo);
		}
		//apply stereotypes to instances according to those applied to the property or the property type
		if(theProp != null){
			mapStereotypesFromPropertyToInstance(theProp, inst);
		}
		for (Property subProp : comp.getAttributes()) {
			//properties
			if(subProp.getType() instanceof Component){
				Component subCompImpl = (Component) subProp.getType();
				commList.addAll(subCompImpl.getOwnedComments());
				InstanceSpecification subInst = buildComponentInstance(pkg, subCompImpl, resPlatform, inst, subProp, property2InstMap, commList);
				Slot slot = UMLFactory.eINSTANCE.createSlot();
				slot.setDefiningFeature(subProp);
				inst.getSlots().add(slot);
				InstanceValue instValue = (InstanceValue) slot.createValue(subProp.getName(), null, UMLPackage.Literals.INSTANCE_VALUE);
				instValue.setInstance(subInst);
			}
			//ports
			if(subProp.getAppliedStereotype(MARTE_CSP) != null){
				Slot slot = UMLFactory.eINSTANCE.createSlot();
				slot.setDefiningFeature(subProp);
				inst.getSlots().add(slot);
				slotList.add(slot);
				//check if there are CHRtSpecifications linked to the port
				List<CHRtSpecification> tmpList = new ArrayList<CHRtSpecification>();
				for (Comment comm : commList) {
					if(comm.getAppliedStereotype(CHESS_CHRTSPEC) != null && comm.getAnnotatedElements().contains(subProp)){
						Stereotype chrtStereo = comm.getAppliedStereotype(CHESS_CHRTSPEC);
						CHRtSpecification chrt = (CHRtSpecification) comm.getStereotypeApplication(chrtStereo);
						tmpList.add(chrt);
					}
				}
				if(tmpList.size() > 0){
					Stereotype portSlotStereo = CHESSProfileManager.applyChRTPortSlotStereotype(slot);
					CHRtPortSlot portSlot = (CHRtPortSlot) slot.getStereotypeApplication(portSlotStereo);
					portSlot.getCH_RtSpecification().addAll(tmpList);
				}
			}
		}
		//connectors
		for (Connector conn : comp.getOwnedConnectors()) {
			buildConnectorInstance(pkg, conn, resPlatform, inst, property2InstMap);
		}
		instancesList.add(inst);
		if(theProp != null){
			property2InstMap.put(theProp, inst);
		}
		return inst;
	}
	
	//this method has been moved from BuildInstanceCommand (and made public)
	public static void mapStereotypesFromPropertyToInstance(Property property, InstanceSpecification instance){
		Type type = property.getType();
		EObject stereo = property.getStereotypeApplication(CHESSProfileManager.getCH_HWBus(property));
		Element elem = property;
		if (stereo == null){
			//try to use the classifier
			 stereo = type.getStereotypeApplication(CHESSProfileManager.getCH_HWBus(type));
			 elem = type;
		}
		if (stereo != null){
			Stereotype chHwBus = CHESSProfileManager.applyCH_HwBusStereotype(instance);
			instance.setValue(chHwBus, "transmMode", elem.getValue(chHwBus, "transmMode"));
			instance.setValue(chHwBus, "blockT", elem.getValue(chHwBus, "blockT"));
			instance.setValue(chHwBus, "packetT", elem.getValue(chHwBus, "packetT"));
			instance.setValue(chHwBus, "speedFactor", elem.getValue(chHwBus, "speedFactor"));
			instance.setValue(chHwBus, "resMult", elem.getValue(chHwBus, "resMult"));
		}
		stereo = property.getStereotypeApplication(CHESSProfileManager.getCH_HWComputingResource(property));
		elem = property;
		if (stereo == null){
			//try to use the classifier
			stereo = type.getStereotypeApplication(CHESSProfileManager.getCH_HWComputingResource(type));
			elem = type;
		}
		if (stereo != null){
			Stereotype chHwComputingRes = CHESSProfileManager.applyCH_HwComputingResourceStereotype(instance);
			instance.setValue(chHwComputingRes, "speedFactor", elem.getValue(chHwComputingRes, "speedFactor"));
			instance.setValue(chHwComputingRes, "resMult", elem.getValue(chHwComputingRes, "resMult"));
		}
		
		stereo = property.getStereotypeApplication(CHESSProfileManager.getCH_HWProcessor(property));
		elem = property;
		if (stereo == null){
			//try to use the classifier
			stereo = type.getStereotypeApplication(CHESSProfileManager.getCH_HWProcessor(type));
			elem = type;
		}
		if (stereo != null){
			Stereotype chHwComputingRes = CHESSProfileManager.applyCH_HwProcessorStereotype(instance);
			instance.setValue(chHwComputingRes, "speedFactor", elem.getValue(chHwComputingRes, "speedFactor"));
			instance.setValue(chHwComputingRes, "resMult", elem.getValue(chHwComputingRes, "resMult"));
			instance.setValue(chHwComputingRes, "nbCores", elem.getValue(chHwComputingRes, "nbCores"));
		}
	}

	private void buildConnectorInstance(Package pkg, Connector conn, CHGaResourcePlatform resPlatform, InstanceSpecification parentInstance, Map<Property, InstanceSpecification> property2InstMap) {
		InstanceSpecification connInst = UMLFactory.eINSTANCE.createInstanceSpecification();
		String name = parentInstance.getName() + "." + conn.getName();
		connInst.setName(name);
		pkg.getPackagedElements().add(connInst);
		UMLUtils.applyStereotype(connInst, MARTE_RESOURCE);
		Resource res =  UMLUtils.getStereotypeApplication(connInst, Resource.class);
		resPlatform.getResources().add(res);
		Slot sourceSlot = connInst.createSlot();
		Slot targetSlot = connInst.createSlot();
		Port sourcePort = (Port) conn.getEnds().get(0).getRole();
		sourceSlot.setDefiningFeature(sourcePort);
		InstanceValue value = (InstanceValue) sourceSlot.createValue("partWithPort", null, UMLPackage.Literals.INSTANCE_VALUE);
		Property sourceProperty = conn.getEnds().get(0).getPartWithPort();
		InstanceSpecification sourceInstance = property2InstMap.get(sourceProperty);
		value.setInstance(sourceInstance);
		targetSlot.setDefiningFeature((StructuralFeature) conn.getEnds().get(1).getRole());
		value = (InstanceValue) targetSlot.createValue("partWithPort", null, UMLPackage.Literals.INSTANCE_VALUE);
		Property targetProperty = conn.getEnds().get(1).getPartWithPort();
		InstanceSpecification targetInstance = property2InstMap.get(targetProperty);
		value.setInstance(targetInstance);
		
		//if the connector is <<propagation>> then attach <<propagation>> to instance specification as well
		Propagation origPropagation = UMLUtils.getStereotypeApplication(conn, Propagation.class);
		if (origPropagation != null){
			CHESSProfileManager.applyPropagationStereotype(connInst);
			Propagation newPropagation = UMLUtils.getStereotypeApplication(connInst, Propagation.class);
			newPropagation.setProb(origPropagation.getProb());
			newPropagation.setPropDelay(origPropagation.getPropDelay());
			newPropagation.getTransfFunct().addAll(origPropagation.getTransfFunct());
			newPropagation.setWeight(origPropagation.getWeight());
		}	
	}
	
	private static void saveAssignAllocations(Model umlModel){
		//save assign allocations before build instance specifications
		CHESS chess = UMLUtils.getStereotypeApplication(umlModel, CHESS.class);		
		DeploymentView deplView = chess.getDeploymentView();
		EList<Comment> tmp = deplView.getAssignList();
		assigns = new BasicEList<Comment>();
		for (int i = 0; i < tmp.size(); i++){
			if(tmp.get(i).getAppliedStereotype(MARTE_ASSIGN) != null){
				assigns.add(tmp.get(i));
			}
		}
		acList = AssignCopy.toAssignCopyList(assigns);
	}
	
	private static void regenerateAssignAllocations(Model umlModel){
		//regenerate, if possible, assign allocations
		Iterator<InstanceSpecification> instIt;
		Iterator<Slot> slotIt;
		for (int i = 0; i < acList.size(); i++){
			Comment com = assigns.get(i);
			Assign assign = UMLUtils.getStereotypeApplication(com, Assign.class);
			EList<Element> from = assign.getFrom();
			EList<Element> to = assign.getTo();
			
			AssignCopy ac = acList.get(i);
			
			for (String fromName : ac.getFrom()){
				instIt = instancesList.iterator();
				InstanceSpecification isFrom = null;
				while(instIt.hasNext()){
					InstanceSpecification tmpInst = instIt.next();
					if(tmpInst.getName().equals(fromName)){
						isFrom = tmpInst;
						break;
					}
				}
				if (isFrom != null && !from.contains(isFrom)){
					from.add(isFrom);
				}
				else{
					slotIt = slotList.iterator();
					Slot slFrom = null;
					while (slotIt.hasNext()){
						Slot tmpSlot = slotIt.next();
						String slotName = tmpSlot.getOwningInstance().getQualifiedName() + "::" 
							+ tmpSlot.getDefiningFeature().getName();
						if(slotName.equals(fromName)){
							slFrom = tmpSlot;
							break;
						}
					}
					if(slFrom != null && !from.contains(slFrom)){
						from.add(slFrom);
					}	
				}
			}
			for (String toName : ac.getTo()){
				instIt = instancesList.iterator();
				InstanceSpecification isTo = null;
				while(instIt.hasNext()){
					InstanceSpecification tmpInst = instIt.next();
					if(tmpInst.getName().equals(toName)){
						isTo = tmpInst;
						break;
					}
				}
				if (isTo != null && !to.contains(isTo)){
					to.add(isTo);
				}
				else{
					slotIt = slotList.iterator();
					Slot slTo = null;
					while (slotIt.hasNext()){
						Slot tmpSlot = slotIt.next();					
						String slotName = tmpSlot.getOwningInstance().getQualifiedName() + "::" 
							+ tmpSlot.getDefiningFeature().getName();
						if(slotName.equals(toName)){
							slTo = tmpSlot;
							break;
						}
					}
					if(slTo != null && !to.contains(slTo)){
						to.add(slTo);
					}
				}
			}
		}
	}
}
