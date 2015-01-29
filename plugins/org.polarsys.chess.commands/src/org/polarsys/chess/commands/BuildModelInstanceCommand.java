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
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.uml.tools.providers.UMLLabelProvider;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.dialogs.ListDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.ConnectableElement;
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
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.polarsys.chess.chessmlprofile.ComponentModel.ComponentImplementation;
import org.polarsys.chess.chessmlprofile.Core.CHESS;
import org.polarsys.chess.chessmlprofile.Core.CHGaResourcePlatform;
import org.polarsys.chess.chessmlprofile.Core.CHESSViews.DeploymentView;
import org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.Propagation;
import org.polarsys.chess.core.profiles.CHESSProfileManager;
import org.polarsys.chess.core.util.uml.ResourceUtils;
import org.polarsys.chess.core.util.uml.UMLUtils;
import org.polarsys.chess.core.views.DiagramStatus;
import org.polarsys.chess.core.views.ViewUtils;
import org.polarsys.chess.service.utils.CHESSEditorUtils;

public class BuildModelInstanceCommand extends AbstractHandler implements
		IHandler {

	private static final String CHESS = "CHESS::Core::CHESS";
	private static final String CHESS_COMPIMPL = "CHESS::ComponentModel::ComponentImplementation";
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
		PapyrusMultiDiagramEditor editor = CHESSEditorUtils.getCHESSEditor();
		final DiagramStatus ds = CHESSEditorUtils.getDiagramStatus(editor);
		List<Component> compImplList = new ArrayList<Component>();
		try{
			org.eclipse.emf.ecore.resource.Resource res = ResourceUtils.getUMLResource(editor.getServicesRegistry());
			final Model umlModel = ResourceUtils.getModel(res);
			CHESS chess = (CHESS) umlModel.getStereotypeApplication(umlModel.getAppliedStereotype(CHESS));		
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
						Package pkg = comp.getNearestPackage();
						Package instPkg = pkg.createNestedPackage(comp.getName() + "_instSpec");
						performBuildInstances(instPkg, comp, new HashMap<Property, InstanceSpecification>());
						regenerateAssignAllocations(umlModel);
						MessageDialog.openInformation(shell, "CHESS", "BuildInstance command completed");
					}
				});
			}
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(shell, "CHESS", "Problems while executing BuildInstance command: " + e.getMessage());
		}
		return null;

	}

	private void performBuildInstances(Package pkg, Component comp, Map<Property, InstanceSpecification> property2InstMap) {
		InstanceSpecification inst = UMLFactory.eINSTANCE.createInstanceSpecification();
		inst.setName(comp.getName());
		inst.getClassifiers().add(comp);
		pkg.getPackagedElements().add(inst);
		Stereotype stereo = UMLUtils.applyStereotype(inst, CHESS_RESPLATFORM);
		CHGaResourcePlatform resPlatform = (CHGaResourcePlatform) inst.getStereotypeApplication(stereo);
		for (Property prop : comp.getAttributes()) {
			if(prop.getType() instanceof Component){
				Component compImpl = (Component) prop.getType();
				InstanceSpecification subInst = buildComponentInstance(pkg, compImpl, resPlatform, inst, prop, property2InstMap);
				Slot slot = UMLFactory.eINSTANCE.createSlot();
				slot.setDefiningFeature(prop);
				inst.getSlots().add(slot);
				InstanceValue instValue = (InstanceValue) slot.createValue(prop.getName(), null, UMLPackage.Literals.INSTANCE_VALUE);
				instValue.setInstance(subInst);
			}
			//ports
			if(prop.getAppliedStereotype(MARTE_CSP) != null){
				Slot slot = UMLFactory.eINSTANCE.createSlot();
				slot.setDefiningFeature(prop);
				inst.getSlots().add(slot);
				slotList.add(slot);
			}
		}
		//connectors
		for (Connector conn : comp.getOwnedConnectors()) {
			buildConnectorInstance(pkg, conn, resPlatform, inst, property2InstMap);
		}
		instancesList.add(inst);
	}

	private InstanceSpecification buildComponentInstance(Package pkg, Component compImpl, CHGaResourcePlatform resPlatform, InstanceSpecification parentInstance, Property theProp, Map<Property, InstanceSpecification> property2InstMap) {
		InstanceSpecification inst = UMLFactory.eINSTANCE.createInstanceSpecification();
		String name = parentInstance.getName() + "." + theProp.getName();
		inst.setName(name);
		inst.getClassifiers().add(compImpl);
		pkg.getPackagedElements().add(inst);
		UMLUtils.applyStereotype(inst, MARTE_RESOURCE);
		Resource res = (Resource) inst.getStereotypeApplication(inst.getAppliedStereotype(MARTE_RESOURCE));
		resPlatform.getResources().add(res);
		for (Property subProp : compImpl.getAttributes()) {
			if(subProp.getType() instanceof Component){
				Component subCompImpl = (Component) subProp.getType();
				InstanceSpecification subInst = buildComponentInstance(pkg, subCompImpl, resPlatform, inst, subProp, property2InstMap);
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
			}
		}
		//connectors
		for (Connector conn : compImpl.getOwnedConnectors()) {
			buildConnectorInstance(pkg, conn, resPlatform, inst, property2InstMap);
		}
		instancesList.add(inst);
		property2InstMap.put(theProp, inst);
		return inst;
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
		
		//if the connector is <<propagation>> then attach <<propagation>> to instance specification also
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
