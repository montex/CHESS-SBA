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
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.NullProgressMonitor;
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
import org.eclipse.uml2.uml.PackageableElement;
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
import org.polarsys.chess.chessmlprofile.util.Constants;

import org.polarsys.chess.core.profiles.CHESSProfileManager;
import org.polarsys.chess.core.util.CHESSProjectSupport;
import org.polarsys.chess.core.util.uml.ResourceUtils;
import org.polarsys.chess.core.util.uml.UMLUtils;
import org.polarsys.chess.core.views.DiagramStatus;
import org.polarsys.chess.m2m.transformations.QVToTransformation;
import org.polarsys.chess.service.utils.CHESSEditorUtils;
import static org.polarsys.chess.core.util.CHESSProjectSupport.printlnToCHESSConsole;

/**
 * BuildModelInstanceCommand allows to create UML InstanceSpecifications starting from a Component definition
 */
public class BuildModelInstanceCommand extends AbstractHandler implements
		IHandler {

	/** The Constant CHESS. */
	private static final String CHESS = "CHESS::Core::CHESS";
	/** The Constant CHESS_CHRTSPEC. */
private static final String CHESS_CHRTSPEC = "CHESS::Predictability::RTComponentModel::CHRtSpecification";
	
	/** The Constant CHESS_RESPLATFORM. */
	private static final String CHESS_RESPLATFORM = "CHESS::Core::CHGaResourcePlatform";
	
	/** The Constant MARTE_CSP. */
	private static final String MARTE_CSP = "MARTE::MARTE_DesignModel::GCM::ClientServerPort";
	
	/** The Constant MARTE_RESOURCE. */
	private static final String MARTE_RESOURCE = "MARTE::MARTE_Foundations::GRM::Resource";
	
	/** The Constant MARTE_ASSIGN. */
	private static final String MARTE_ASSIGN = "MARTE::MARTE_Foundations::Alloc::Assign";
	/** The Constant MARTE_MEMORYPARTITION. */
	private static final String MARTE_MEMORYPARTITION = "MARTE::MARTE_DesignModel::SRM::SW_Concurrency::MemoryPartition";
	
	/** The ac list. */
	private static ArrayList<AssignCopy> acList;
	
	/** The assigns. */
	private static EList<Comment> assigns;
	
	/** The instances list. */
	private static ArrayList<InstanceSpecification> instancesList = new ArrayList<InstanceSpecification>();
	
	/** The slot list. */
	private static ArrayList<Slot> slotList =  new ArrayList<Slot>();
	private boolean ignoreErrors;
	
	private InstanceSpecification oldRootInstance = null;
	private Package oldInstancePackage = null;

	/* (non-Javadoc)
	 * Launches the dialog to select the Component from which InstanceSpecifications (i.e. the object view) needs to be created
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ignoreErrors = false;
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		final Shell shell = window.getShell();
		//get the CEHSS Editor
		PapyrusMultiDiagramEditor editor = CHESSEditorUtils.getCHESSEditor();
		final DiagramStatus ds = CHESSEditorUtils.getDiagramStatus(editor);
		List<Component> compImplList = new ArrayList<Component>();
		try{;
			//get the UML model
			final org.eclipse.emf.ecore.resource.Resource res = ResourceUtils.getUMLResource(editor.getServicesRegistry());
			final IFile modelFile = CHESSProjectSupport.resourceToFile(res);
			final Model umlModel = ResourceUtils.getModel(res);
			CHESS chess = (CHESS) umlModel.getStereotypeApplication(umlModel.getAppliedStereotype(CHESS));		
			//get the Components (implementation) of the componentView and deploymentView
			for (Element elem : chess.getComponentView().getBase_Package().allOwnedElements()) {
					//check if the component owns property of type ComponentImplementation
					if (elem instanceof Component){
						Component comp = (Component) elem;
						for (Property prop : comp.getAttributes()){
							if (prop.getType() == null)
								continue;
							if (UMLUtils.getStereotypeApplication(prop.getType(), ComponentImplementation.class) != null){
								compImplList.add((Component) elem);
								break;
							}
						}
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
						//get the instance Package, if present
						Package instPkg = null;
						for(Element elem : comp.getOwner().getOwnedElements()){
							if(elem instanceof Package && ((Package) elem).getName().equals(comp.getName() + "_instSpec")){
								instPkg = (Package) elem;
							}
						}
						//reuse instance package, if present, but destroy its children
						if(instPkg != null){
							EList<PackageableElement> elems = instPkg.getPackagedElements();
							
							//save the root old instance
							Package pkg = comp.getNearestPackage();
							oldInstancePackage = pkg.createNestedPackage(comp.getName() + "_oldinstSpec");
							//oldInstancePackage = UMLFactory.eINSTANCE.createPackage();
							
							
							int size = elems.size(); 
							for(int i = 0; i < size; i++){
								PackageableElement pe = elems.get(0);
								if (!pe.getName().contains("."))
									oldRootInstance = (InstanceSpecification) pe;
								//pe.destroy();
								oldInstancePackage.getPackagedElements().add(pe);
							}
						}else{
							//create the instance package, if needed.
							Package pkg = comp.getNearestPackage();
							instPkg = pkg.createNestedPackage(comp.getName() + "_instSpec");
							UMLUtils.applyStereotype(instPkg, CHESS_RESPLATFORM);
						}
						instancesList.clear();
						slotList.clear();
						
						//perform build instances
						buildComponentInstance(instPkg, comp, null, null, null, new HashMap<Property, InstanceSpecification>(), comp.getOwnedComments(), oldRootInstance);
		
						regenerateAssignAllocations(umlModel);
						/*The multi instance support has to be re-engineered
						try {
							//TODO: WARNING - saving the resource probably is not the best way to deal with
							//the problem of creating the multi instances at this moment
							
							res.save(null);
							
							// Remove the package with the multi instances, if any
							QVToTransformation.launchRemoveMultiInstance(modelFile, new NullProgressMonitor());
							//perform build multi instances
							QVToTransformation.launchBuildMultiInstance(modelFile, new NullProgressMonitor());
							
							MessageDialog.openInformation(shell, "CHESS", "BuildInstance command completed");
							ignoreErrors = true;
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}*/
						if (oldInstancePackage != null)
							oldInstancePackage.destroy();
					}
						
				});
			}
		} catch (Exception e) {
			if(!ignoreErrors){
			ds.setUserAction(false);
			e.printStackTrace();
			MessageDialog.openError(shell, "CHESS", "Problems while executing BuildInstance command: " + e.getMessage());
			}
		}
		ds.setUserAction(false);
		return null;
	}
	
	/**
	 * Builds the instance-level representation of the given Component structure.
	 *
	 * @param pkg the Package owner of the created instance level entities
	 * @param comp the Component for which the instance-level representation has to be created
	 * @param resPlatform the MARTE CHGaResourcePlatform owning the reference to the Resource instances.
	 * @param parentInstance the parent instance
	 * @param theProp the UML property for which the instance-level representation has to be created
	 * @param property2InstMap the properties to instances map
	 * @param commList the list of CHRtSPecification from which the instance-level representation has to be created
	 * @param oldInst the instanceSpecification that will be replaced in the model; it allows to retrieve available properties on the instance, to be applied to the new one. It can be null
	 * @return the instance specification, stereotyped as MARTE Resource
	 */
	private InstanceSpecification buildComponentInstance(Package pkg, Component comp, CHGaResourcePlatform resPlatform, InstanceSpecification parentInstance, Property theProp, Map<Property, InstanceSpecification> property2InstMap, List<Comment> commList, InstanceSpecification oldInst) {
		
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
				InstanceSpecification oldsubInst = getCorrespondingOldChildInstance (subProp, oldInst);
				InstanceSpecification subInst = buildComponentInstance(pkg, subCompImpl, resPlatform, inst, subProp, property2InstMap, commList, oldsubInst);
				Slot slot = UMLFactory.eINSTANCE.createSlot();
				slot.setDefiningFeature(subProp);
				inst.getSlots().add(slot);
				InstanceValue instValue = (InstanceValue) slot.createValue(subProp.getName(), null, UMLPackage.Literals.INSTANCE_VALUE);
				instValue.setInstance(subInst);
				/*
				//if the property is stereotyped, then apply the same stereotype to the instance (if applicable)
				Stereotype memPartition = subProp.getAppliedStereotype(MARTE_MEMORYPARTITION);
				if (memPartition != null){
					subInst.applyStereotype(memPartition);
				}*/
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
				CHRtPortSlot chrtportSlot = null;
				if(tmpList.size() > 0){
					Stereotype portSlotStereo = CHESSProfileManager.applyChRTPortSlotStereotype(slot);
					chrtportSlot = (CHRtPortSlot) slot.getStereotypeApplication(portSlotStereo);
					chrtportSlot.getCH_RtSpecification().addAll(tmpList);
				}
				
				//check old slot
				Slot oldSlot = getCorrespondingOldChildSlot(subProp, oldInst);
				if (oldSlot != null){
					Stereotype oldstereo = oldSlot.getApplicableStereotype(Constants.CH_CHRtPortSlot);
					if (oldstereo != null){
						CHRtPortSlot oldchrtportSlot = (CHRtPortSlot) oldSlot.getStereotypeApplication(oldstereo);
						if (oldchrtportSlot != null){
							if (chrtportSlot == null){
								Stereotype portSlotStereo = CHESSProfileManager.applyChRTPortSlotStereotype(slot);
								chrtportSlot = (CHRtPortSlot) slot.getStereotypeApplication(portSlotStereo);
							}
							
							chrtportSlot.getCH_RtSpecification().addAll(oldchrtportSlot.getCH_RtSpecification());
						}
						
					}
					
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
	/**
	 * Map stereotypes from property to instance.
	 *
	 * @param property the property
	 * @param instance the instance
	 */
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
//			instance.setValue(chHwComputingRes, "nbCores", elem.getValue(chHwComputingRes, "nbCores"));
		}
		//if the property is stereotyped, then apply the same stereotype to the instance (if applicable)
		Stereotype memPartition = property.getAppliedStereotype(MARTE_MEMORYPARTITION);
		if (memPartition != null){
			instance.applyStereotype(memPartition);
		}
	}

	/**
	 * Builds the connector instance.
	 *
	 * @param pkg the pkg
	 * @param conn the conn
	 * @param resPlatform the res platform
	 * @param parentInstance the parent instance
	 * @param property2InstMap the property2 inst map
	 */
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
			newPropagation.setDelay(origPropagation.getDelay());
			newPropagation.getTransfFunct().addAll(origPropagation.getTransfFunct());
			newPropagation.setWeight(origPropagation.getWeight());
		}	
	}
	
	/**
	 * Save assign allocations, in case the build instance command is invoked to update the instance level view
	 *
	 * @param umlModel the uml model
	 */
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
	
	/**
	 * Regenerate assign allocations.
	 *
	 * @param umlModel the uml model
	 */
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
	
	private InstanceSpecification getCorrespondingOldChildInstance (Property prop, InstanceSpecification inst){
		if (inst == null)
			return null;
		EList<Slot> slots = inst.getSlots();
		for (Slot s: slots){
			if (s.getDefiningFeature().equals(prop)){
				InstanceValue instvalue = (InstanceValue) s.getValues().get(0);
				return instvalue.getInstance();
			}
		}
		return null;
	}
	
	private Slot getCorrespondingOldChildSlot (Property prop, InstanceSpecification inst){
		if (inst == null)
			return null;
		EList<Slot> slots = inst.getSlots();
		for (Slot s: slots){
			if (s.getDefiningFeature().equals(prop)){
				return s;
			}
		}
		return null;
	}
	
}
