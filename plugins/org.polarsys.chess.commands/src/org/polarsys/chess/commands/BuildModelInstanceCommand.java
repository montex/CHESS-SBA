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
import java.util.Collection;
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
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EObjectTreeElement;
import org.eclipse.papyrus.sysml.blocks.Block;
import org.eclipse.papyrus.sysml.portandflows.FlowPort;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Operation;
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
import org.polarsys.chess.chessmlprofile.ComponentModel.ComponentType;
import org.polarsys.chess.chessmlprofile.Core.CHESS;
import org.polarsys.chess.chessmlprofile.Core.CHGaResourcePlatform;
import org.polarsys.chess.chessmlprofile.Core.CHESSViews.DeploymentView;
import org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.Propagation;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtPortSlot;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification;
import org.polarsys.chess.chessmlprofile.util.Constants;
import org.polarsys.chess.core.notifications.ResourceNotification;
import org.polarsys.chess.core.profiles.CHESSProfileManager;
import org.polarsys.chess.core.util.uml.UMLUtils;
import org.polarsys.chess.core.views.DiagramStatus;
import org.polarsys.chess.core.views.ViewUtils;
import org.polarsys.chess.service.utils.CHESSEditorUtils;

import static org.polarsys.chess.core.util.CHESSProjectSupport.printlnToCHESSConsole;

/**
 * BuildModelInstanceCommand allows to create UML InstanceSpecifications starting from a Component definition
 */
public class BuildModelInstanceCommand extends AbstractHandler implements
		IHandler {
	
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
	
	//holds the mapping between a Property and the corresponding InstanceSpecification
	private Map<Property, InstanceSpecification> property2InstMap = new HashMap<Property, InstanceSpecification>();
	
	//the MARTE CHGaResourcePlatform stereotype applied to the root instance: it owns the reference to the Resource instances.
	private CHGaResourcePlatform resPlatform = null;

	/* (non-Javadoc)
	 * from the current selection retrieves the Component from which InstanceSpecifications (i.e. the object view) needs to be created.
	 * This handler is expected to the be invoked through the Papyrus ModelExplorer popup command
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ignoreErrors = false;
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		
		
		ISelectionService selectionService = window.getSelectionService();
		ISelection selectionX = selectionService.getSelection();
		if (!(selectionX instanceof ITreeSelection)){
			ResourceNotification.showOk("Please invoke the Build Instance command on a single selection on the ModelExplorer");
			return null;
		}
		ITreeSelection treesel = (ITreeSelection)selectionX;
		if (treesel.getPaths().length == 0 ||  treesel.getPaths().length > 1){
			ResourceNotification.showError("Please invoke the Build Instance command on a single selection on the ModelExplorer");
			return null;
		}
		
		Object obj = treesel.getFirstElement();
		if (!(obj instanceof EObjectTreeElement)){
			ResourceNotification.showError("Please invoke the Build Instance command on a single selection on the ModelExplorer");
		}
		EObject eobj = ((EObjectTreeElement) obj).getEObject();
		final Package view = ViewUtils.getView(eobj);
		
		final Model umlModel = view.getModel();
		final Class umlClass = (Class) eobj;
		
		if (!ViewUtils.isDesignView(view, CHESSProfileManager.SYSTEM_VIEW) &&
				!ViewUtils.isDesignView(view, CHESSProfileManager.COMPONENT_VIEW) &&
				!ViewUtils.isDesignView(view, CHESSProfileManager.DEPLOYMENT_VIEW)) {
			ResourceNotification.showError("Build Instance command can only be invoked on resources of the SystemView, ComponentView and DeploymentView");
			return null;
		}
		
		if (ViewUtils.isDesignView(view, CHESSProfileManager.COMPONENT_VIEW)){
			if (UMLUtils.getStereotypeApplication(umlClass, ComponentType.class)!= null){
				ResourceNotification.showError("Build Instance command cannot be invoked on ComponentType");
				return null;
			}
		}
		
		return buildInstance(umlClass);
	}
	
	/**
	 * Prepares the package which will own the instances and create the instances for the given UML::Class and its internal structure, i.e. the owned properties (parts and ports) and connectors.
	 * 
	 * Extra functional information specified at class\property level is propagated to the instance level, where foreseen by the CHESS methodology
	 * (e.g. the CHRtSpecification specified for the ports are applied to the instances of the ports); 
	 * Note that in case of multiple instances of the same class instantiated at different levels of the SW hierarchy,
	 * the assignment of the proper extra functional information for the derived instances cannot work while considering the information available at class-property level.
	 * 
	 * This method tries to preserve the current SW to HW allocation, i.e. the Assign having the instances in 'from' and 'to' attributes.
	 * Moreover this method check if an instance model is already available for the given class; in case it tries to synchronize
	 * the new model with the information about extra functional properties specified in the old instance model.
	 * 
	 * The model is updated by using a transactional command.
	 * 
	 * @param umlClass the Class for which the instance-level representation has to be created
	 * @return the instance specification, stereotyped as MARTE Resource
	 * @since 0.10
	 */
	
	public InstanceSpecification buildInstance(final Class umlClass){
		PapyrusMultiDiagramEditor editor = CHESSEditorUtils.getCHESSEditor();
		final DiagramStatus ds = CHESSEditorUtils.getDiagramStatus(editor);
		final Package view = ViewUtils.getView(umlClass);
		final Model umlModel = view.getModel();
		oldInstancePackage = null;
		oldRootInstance = null;
		try{

			TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(umlClass);
			editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
				protected void doExecute() {
					ds.setUserAction(false);
					saveAssignAllocations(umlModel);
					//get the instance Package, if present
					Package instPkg = null;
					for(Element elem : umlClass.getOwner().getOwnedElements()){
						if(elem instanceof Package && ((Package) elem).getName().equals(umlClass.getName() + "_instSpec")){
							instPkg = (Package) elem;
						}
					}
					//reuse instance package, if present, but destroy its children
					if(instPkg != null){
						EList<PackageableElement> elems = instPkg.getPackagedElements();
						
						//save the root old instance
						Package pkg = umlClass.getNearestPackage();
						oldInstancePackage = pkg.createNestedPackage(umlClass.getName() + "_oldinstSpec");
													EList<PackageableElement> tempElems = new BasicEList<PackageableElement>();
						
						int size = elems.size(); 
						for(int i = 0; i < size; i++){
							PackageableElement pe = elems.get(i);
							if (pe.getName() != null && !pe.getName().contains("."))
								oldRootInstance = (InstanceSpecification) pe;
							tempElems.add(pe);
						}
						oldInstancePackage.getPackagedElements().addAll(tempElems);
						
					}else{
						//create the instance package, if needed.
						Package pkg = umlClass.getNearestPackage();
						instPkg = pkg.createNestedPackage(umlClass.getName() + "_instSpec");
						UMLUtils.applyStereotype(instPkg, Constants.CHGARESOURCEPLATFORM);
					}
					instancesList.clear();
					slotList.clear();
					
					//perform build instances
					buildComponentInstance(instPkg, umlClass, null, null, oldRootInstance);
					
					//Assign are not used in the SystemView
					if (!ViewUtils.isDesignView(view, CHESSProfileManager.SYSTEM_VIEW))
						regenerateAssignAllocations(umlModel);
					if (oldInstancePackage != null)
						oldInstancePackage.destroy();
					
					boolean compView = ViewUtils.isDesignView(view, CHESSProfileManager.COMPONENT_VIEW);
					
					String msg = "Instances have been successfully generated under the  "+instPkg.getName()+" Package.";
					
					if (compView)
						msg = msg+ "\n Check the CHESS Instance View to navigate and edit extra functional properties for SW instances.";
					
					ResourceNotification.showOk(msg);
				}
					
			});
		
		} catch (Exception e) {
			if(!ignoreErrors){
			ds.setUserAction(false);
			e.printStackTrace();
			ResourceNotification.showError("Problems while executing BuildInstance command: " + e.getMessage());
			}
		}
		ds.setUserAction(false);
		return null;
	}
	
	
	/**
	 * Builds the instance-level representation of the given Component\Property.
	 * For a given UML::Class, instances are created for the Class itself and for its internal, i.e.: owned properties and connectors. 
	 *
	 * @param pkg the Package which will own the created instance entities
	 * @param umlClass the Class for which the instance-level representation has to be created. If theProp is provided then comp must be the type of theProp.
	 * @param parentInstance the parent instance; it can be null.
	 * @param theProp the UML property for which the instance-level representation has to be created. It can be null.
	 * @param oldInst the instanceSpecification that will be replaced in the model; it allows to retrieve available properties on the instance, to be applied to the new one. It can be null
	 * @return the instance specification, stereotyped as MARTE Resource
	 */
	private InstanceSpecification buildComponentInstance(Package pkg, Class umlClass, InstanceSpecification parentInstance, Property theProp, InstanceSpecification oldInst) {
		
		
		//CHESS supports annotation of ports with CHRTSpecification through the composite diagram: in this case the instances of the ports derive the chrtSpecification from the decorated ports
		List<Comment> commList = getAllCHRTSpec(umlClass, theProp);
		
		InstanceSpecification inst = UMLFactory.eINSTANCE.createInstanceSpecification();
		if(theProp != null){
			String name = parentInstance.getName() + "." + theProp.getName();
			inst.setName(name);
		}else{
			inst.setName(umlClass.getName());
		}
		inst.getClassifiers().add(umlClass);
		pkg.getPackagedElements().add(inst);
		if(parentInstance != null){
			UMLUtils.applyStereotype(inst, MARTE_RESOURCE);
			Resource res = (Resource) inst.getStereotypeApplication(inst.getAppliedStereotype(MARTE_RESOURCE));
			resPlatform.getResources().add(res);
		}else{
			Stereotype stereo = UMLUtils.applyStereotype(inst, Constants.CHGARESOURCEPLATFORM);
			resPlatform = (CHGaResourcePlatform) inst.getStereotypeApplication(stereo);
		}
		//apply stereotypes to instances according to those applied to the property or the property type
		if(theProp != null){
			mapStereotypesFromPropertyToInstance(theProp, inst, oldInst);
		}
		
		for (Property subProp : umlClass.getAttributes()) {
			//properties
			if(subProp.getType() instanceof Class){
				Class subCompImpl = (Class) subProp.getType();
				if (!(subCompImpl instanceof Component) && (UMLUtils.getStereotypeApplication(subCompImpl, Block.class)== null)){
					continue;
				}
				//commList.addAll(subCompImpl.getOwnedComments());
				InstanceSpecification oldsubInst = getCorrespondingOldChildInstance (subProp, oldInst);
				InstanceSpecification subInst = buildComponentInstance(pkg, subCompImpl, inst, subProp, oldsubInst);
				Slot slot = UMLFactory.eINSTANCE.createSlot();
				slot.setDefiningFeature(subProp);
				inst.getSlots().add(slot);
				InstanceValue instValue = (InstanceValue) slot.createValue(subProp.getName(), null, UMLPackage.Literals.INSTANCE_VALUE);
				instValue.setInstance(subInst);

			}
			//ports
			else if(subProp.getAppliedStereotype(MARTE_CSP) != null || (UMLUtils.getStereotypeApplication(subProp, FlowPort.class)!=null)){
				Slot slot = UMLFactory.eINSTANCE.createSlot();
				slot.setDefiningFeature(subProp);
				inst.getSlots().add(slot);
				slotList.add(slot);
				//check if there are CHRtSpecifications linked to the port
				List<CHRtSpecification> tmpList = new ArrayList<CHRtSpecification>();
				for (Comment comm : commList) {
					if(comm.getAppliedStereotype(Constants.CHRT_SPECIFICATION) != null && comm.getAnnotatedElements().contains(subProp)){
						Stereotype chrtStereo = comm.getAppliedStereotype(Constants.CHRT_SPECIFICATION);
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
		for (Connector conn : umlClass.getOwnedConnectors()) {
			buildConnectorInstance(pkg, conn, resPlatform, inst, property2InstMap);
		}
		instancesList.add(inst);
		if(theProp != null){
			property2InstMap.put(theProp, inst);
		}
		
		//set <<chrtportslot>> attribute for the instance
		//TODO this should be extended in case of multiple instances of the same class!!!
		List<CHRtSpecification> tmpList = new ArrayList<CHRtSpecification>();
		for (Comment comm : commList) {
			if(comm.getAppliedStereotype(Constants.CHRT_SPECIFICATION) != null && comm.getAnnotatedElements().contains(umlClass)){
				Stereotype chrtStereo = comm.getAppliedStereotype(Constants.CHRT_SPECIFICATION);
				CHRtSpecification chrt = (CHRtSpecification) comm.getStereotypeApplication(chrtStereo);
				tmpList.add(chrt);
			}
		}
		CHRtPortSlot chrtportSlot = null;
		if(tmpList.size() > 0){
			Stereotype portSlotStereo = null;
			if (inst.getAppliedStereotype(Constants.CH_CHRtPortSlot) != null)
				portSlotStereo = inst.getAppliedStereotype(Constants.CH_CHRtPortSlot);
			else
				portSlotStereo = CHESSProfileManager.applyChRTPortSlotStereotype(inst);
			chrtportSlot = (CHRtPortSlot) inst.getStereotypeApplication(portSlotStereo);
			chrtportSlot.getCH_RtSpecification().addAll(tmpList);
		}
		//TODO asynchronize with the old instance....
		
		//end set <<chrtportslot>>
		
		return inst;
	}
	
	//this method has been moved from BuildInstanceCommand (and made public)
	/**
	 * Map stereotypes from property to instance.
	 *
	 * @param property the property
	 * @param instance the instance
	 */
	public static void mapStereotypesFromPropertyToInstance(Property property, InstanceSpecification instance, InstanceSpecification oldinstance){
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
		
		if (oldinstance != null){
			
			Stereotype oldstereo = oldinstance.getApplicableStereotype(Constants.CH_CHRtPortSlot);
			CHRtPortSlot oldchrtportSlot = (CHRtPortSlot) oldinstance.getStereotypeApplication(oldstereo);
				if (oldchrtportSlot != null){
					Stereotype newstereo = instance.getApplicableStereotype(Constants.CH_CHRtPortSlot);
					CHRtPortSlot chrtportSlot = (CHRtPortSlot) instance.getStereotypeApplication(newstereo);
					if (chrtportSlot == null){
						Stereotype portSlotStereo = CHESSProfileManager.applyChRTPortSlotStereotype(instance);
						chrtportSlot = (CHRtPortSlot) instance.getStereotypeApplication(portSlotStereo);
					}
					chrtportSlot.getCH_RtSpecification().addAll(oldchrtportSlot.getCH_RtSpecification());
				}
				
			
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
		
		/**
		 * from UML spec about ConnectorEnd: If a ConnectorEnd is attached to a Port of the containing Classifier, partWithPort will be empty.
		 * here, to keep the things simple, the instance field of the InstanceValue 'partWithPort' is set to the parent instance target\source of the delegation
		 */
		 
		InstanceSpecification sourceInstance = (sourceProperty == null ? parentInstance: property2InstMap.get(sourceProperty));
		value.setInstance(sourceInstance);
		targetSlot.setDefiningFeature((StructuralFeature) conn.getEnds().get(1).getRole());
		value = (InstanceValue) targetSlot.createValue("partWithPort", null, UMLPackage.Literals.INSTANCE_VALUE);
		Property targetProperty = conn.getEnds().get(1).getPartWithPort();
		InstanceSpecification targetInstance = (targetProperty == null ? parentInstance : property2InstMap.get(targetProperty));
		value.setInstance(targetInstance);
		
		//if the connector is <<propagation>> then attach <<propagation>> to instance specification as well
		Propagation origPropagation = UMLUtils.getStereotypeApplication(conn, Propagation.class);
		if (origPropagation != null){
			CHESSProfileManager.applyPropagationStereotype(connInst);
			Propagation newPropagation = UMLUtils.getStereotypeApplication(connInst, Propagation.class);
			newPropagation.setProb(origPropagation.getProb());
			newPropagation.setDelay(origPropagation.getDelay());
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
			if (s.getDefiningFeature() != null && s.getDefiningFeature().equals(prop)){
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
			if (s.getDefiningFeature()!= null && s.getDefiningFeature().equals(prop)){
				return s;
			}
		}
		return null;
	}
	
	/**
	 * returns the CHRTspecification Comments that have been already created for the operations of given class and/or property
	 * @param umlClass the class owning the operations possibly annotated with chrtspecification
	 * @param theProp can be null, the property (instance of component) which can have ports-operations annotated with CHRTspecification
	 * @return
	 */
	private List<Comment> getAllCHRTSpec(Class umlClass, Property theProp){
		
		//take all the comment owner by the Class
		List<Comment> commList = umlClass.getOwnedComments();
		List<Comment> mycommlist = new ArrayList<Comment>();
		for (Comment comm:commList){
			mycommlist.add(comm);
		}

		//when working with composite diagram the comments annotating ports of a given property are placed under the context classifier
		if (theProp != null){
			commList = theProp.getFeaturingClassifiers().get(0).getOwnedComments();
			for (Comment comm:commList){
				mycommlist.add(comm);
			}
		}
		
		//check for chrt owned by operations
		for (Operation op : umlClass.getOperations()){
			commList = op.getOwnedComments();
			for (Comment comm:commList){
				mycommlist.add(comm);
			}
		}
		return mycommlist;
		
	}
	
}
