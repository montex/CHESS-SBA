/*******************************************************************************
 * Copyright (c) 2011 -2014 Intecs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Stefano Puri, Nicholas Pacini - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.polarsys.chess.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.impl.BasicCompartmentImpl;
import org.eclipse.gmf.runtime.notation.impl.ConnectorImpl;
import org.eclipse.gmf.runtime.notation.impl.DiagramImpl;
import org.eclipse.gmf.runtime.notation.impl.ShapeImpl;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.Activator;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.uml.diagram.common.editparts.NamedElementEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.ClassCompositeEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.CommentEditPartCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.ComponentCompositeEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.CompositeStructureDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.PortEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.PropertyPartEditPartCN;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.sasheditor.editor.ISashWindowsContainer;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.BlockCompositeEditPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.edit.part.InternalBlockDiagramEditPart;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
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
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;
import org.polarsys.chess.core.notifications.ResourceNotification;
import org.polarsys.chess.core.profiles.CHESSProfileManager;
import org.polarsys.chess.core.util.uml.ResourceUtils;
import org.polarsys.chess.core.util.uml.UMLUtils;
import org.polarsys.chess.core.views.DiagramStatus;
import org.polarsys.chess.core.views.ViewUtils;
import org.polarsys.chess.service.utils.CHESSEditorUtils;




/**
 * The Class BuildInstanceCommand.
 * @deprecated  replaced by {@link org.polarsys.chess.commands.BuildModelInstanceCommand}
 *
 */
@Deprecated
public class BuildInstanceCommand extends AbstractHandler {
	
	/** The Constant ASSIGN. */
	private static final String ASSIGN = "MARTE::MARTE_Foundations::Alloc::Assign";
	
	/** The Constant PLATFORM. */
	private static final String PLATFORM = "CHESS::Core::CHGaResourcePlatform";
	
	/** The ac list. */
	private static ArrayList<AssignCopy> acList;
	
	/** The instances list. */
	private static ArrayList<InstanceSpecification> instancesList = new ArrayList<InstanceSpecification>();
	
	/** The slot list. */
	private static ArrayList<Slot> slotList =  new ArrayList<Slot>();
	
	/** The comments. */
	private static EList<Comment> comments = null;

	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 *
	 */
	@Deprecated
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final PapyrusMultiDiagramEditor editor = CHESSEditorUtils.getCHESSEditor();
		final DiagramStatus ds = CHESSEditorUtils.getDiagramStatus(editor);
		if (editor == null || ds == null) 
			return null;
		try {
				
		Object temp = getEditPart();
		
		if (temp == null ||  ( !(temp instanceof CompositeStructureDiagramEditPart) && !(temp instanceof InternalBlockDiagramEditPart)) )
			throw new Exception("BuildInstance command does not work on this element");
		
		final DiagramEditPart csd_ep = (DiagramEditPart) temp;
		TransactionalEditingDomain editingDomain = csd_ep.getEditingDomain();
				
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
			protected void doExecute() {
					
					
					StringBuffer resultMsg = new StringBuffer();
					if (buildPrototypeInstanceRestoringAssigns(editor, csd_ep, resultMsg) != null){
						
						ds.setUserAction(false);
						ResourceNotification.showOk("Build Instance completed"+resultMsg);
					}
					else{
						ResourceNotification.showError("Build Instance failed"+resultMsg);
					}
			}
		});
		
		} catch (Exception e) {
			e.printStackTrace();
			ResourceNotification.showInfo(e.getMessage());
			ds.setUserAction(true);
		}
		ds.setUserAction(true);
		return null;
	}

	/**
	 * Gets the edits the part.
	 *
	 * @return the edits the part
	 *
	 */
	 @Deprecated
	private Object getEditPart() {
		Object ep = null;
		try {
				ep = CHESSEditorUtils.getDiagramGraphicalViewer().getRootEditPart().getChildren().get(0);	
		} catch (Exception e) {
			//Catch NPE
			return null;
		}
		return ep;
	}
	
	/**
	 * Build the prototype instance starting frmo the given Composite Structure Diagram, 
	 * saving and restoring the information 'from' 'to' available in the Assign entities.
	 *
	 * @param editor the editor
	 * @param csd_ep the csd_ep
	 * @param resultMsg the result msg
	 * @return the edit part of the element, null if it doesn't exist
	 * 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Deprecated
	public static InstanceSpecification buildPrototypeInstanceRestoringAssigns(PapyrusMultiDiagramEditor editor, DiagramEditPart csd_ep, StringBuffer resultMsg) {
		saveAssignAllocations(editor);
		InstanceSpecification instance = buildPrototypeInstance(editor, csd_ep, (DiagramImpl) csd_ep.getModel(), null, null, new HashMap(), resultMsg);
		regenerateAssignAllocations();
		
		return instance;
	}
	
	
	/**
	 * Build the prototype instance starting from the given Composite Structure Diagram,.
	 *
	 * @param editor The current CHESS editor
	 * @param csd_ep The CompositeStructureDiagramEditPart, needed for the top level diagram only
	 * @param diagram The current diagram from which InstanceSpecifications need to be created
	 * @param instanceRoot The InstanceSpecification which is the context of the current diagram
	 * @param pack4instances The Package where InstanceSpecifications need to be created
	 * @param shape2instanceMap The Map owning associations between GMF shape and UML InstanceSpecification
	 * @param warningMsg the warning msg
	 * @return the InstanceSpecification which is the context of this diagram
	 * @see buildPrototypeInstance(CHESSEditor editor, CompositeStructureDiagramEditPart csd_ep, StringBuffer resultMsg)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Deprecated
	private static InstanceSpecification buildPrototypeInstance(PapyrusMultiDiagramEditor editor, DiagramEditPart csd_ep, DiagramImpl diagram, InstanceSpecification instanceRoot, Package pack4instances, Map shape2instanceMap, StringBuffer warningMsg) {
			
		//assert diagram != null;
		Classifier rootcomponent = (Classifier) diagram.getElement();
		Package pack = rootcomponent.getPackage();
		
//		//only to test comments
//		System.out.println("BEFORE");
//		for (int i=0; i<comments.size(); i++){
//			System.out.println(comments.get(i).getValue(comments.get(i).getAppliedStereotype(ASSIGN), "from").toString());
//			System.out.println(comments.get(i).getValue(comments.get(i).getAppliedStereotype(ASSIGN), "to").toString());
//		}
		
		if (instanceRoot == null){
			//it means that this is the main invocation of the command on top of the root composite structure diagram
			//Create instance in a dedicated package having '<component's name> + _instSpec' as default name
			pack4instances = (Package) pack.getOwnedMember(rootcomponent.getName()+"_instSpec");
			if (pack4instances != null){
				//pack4instances.destroy(); reuse it, but destroy its children
				EList<PackageableElement> elems = pack4instances.getPackagedElements();
				int size = elems.size(); 
				for(int i = 0; i < size; i++){
					PackageableElement pe = elems.get(0);
					pe.destroy();
				}
				instancesList.clear();
				slotList.clear();
				if(pack4instances.getAppliedStereotype(PLATFORM) == null){
					CHESSProfileManager.applyCHGaResourcePlatformStereotype(pack4instances);
				}
			} else{
				pack4instances = pack.createNestedPackage(rootcomponent.getName()+"_instSpec");
				//apply "CHGaResourcePlatform" to the instance package if it was applied to the starting component
				//if(rootcomponent.getAppliedStereotype(PLATFORM) != null){
					CHESSProfileManager.applyCHGaResourcePlatformStereotype(pack4instances);
				//}
			}
			
			//create the root component instance
			instanceRoot = (InstanceSpecification) pack4instances.createPackagedElement(
		            null, UMLPackage.Literals.INSTANCE_SPECIFICATION);
			instanceRoot.setName(rootcomponent.getName());
			instanceRoot.getClassifiers().add(rootcomponent);
			
			//store instanceRoot
			instancesList.add(instanceRoot);
			Iterator persChilds = diagram.getPersistedChildren().iterator();
			ShapeImpl rootshape = null;
			rootshape = (ShapeImpl) persChilds.next(); //this is Component owner of the CSD, it owns two Shape, the one for the compartmens owns the inner Shape Properties
			shape2instanceMap.put(rootshape, instanceRoot);
						
		}
		
		if (csd_ep != null){
			//it means that this is the main invocation of the command on top of the root composite structure diagram
			//Create port instances for the root instance
			
			List l = csd_ep.getChildren();
			EditPart epTemp = null;
			NamedElementEditPart compositeEP = null;
			for (int i=0; i< l.size(); i++){
				epTemp = (EditPart) l.get(i);
				if (epTemp instanceof ComponentCompositeEditPart){
					compositeEP = (ComponentCompositeEditPart) epTemp;
					break;
				}
				if (epTemp instanceof ClassCompositeEditPart){
					compositeEP = (ClassCompositeEditPart) epTemp;
					break;
				}
				if (epTemp instanceof BlockCompositeEditPart){
					compositeEP = (BlockCompositeEditPart) epTemp;
					break;
				}
				
				
			}
			
			//create port instances for root instance
			if (rootcomponent instanceof org.eclipse.uml2.uml.Class)
				// LB 20150701: porting to MARS casting to compositeEP (following eclipse's suggestion) 
				//buildPortInstances((org.eclipse.uml2.uml.Class) rootcomponent, instanceRoot, (ShapeImpl) compositeEP.getModel() );
				buildPortInstances((org.eclipse.uml2.uml.Class) rootcomponent, instanceRoot, (ShapeImpl) ((EditPart) compositeEP).getModel() );
		}
		
		
		//create instanceSpecification for inner properties (properties are instantiated according to the
		//information available in the GMF model)
		Iterator persChilds = diagram.getPersistedChildren().iterator();
		ShapeImpl shape = null;
		while (persChilds.hasNext()){
			shape = (ShapeImpl) persChilds.next(); //this is Component owner of the CSD, it owns two Shape, the one for the compartmens owns the inner Shape Properties
			Iterator tempIter = shape.getPersistedChildren().iterator();
			Object obj = null;
			while (tempIter.hasNext()){
				obj = tempIter.next();
				if (obj instanceof BasicCompartmentImpl){
					break;
				}
			}
			Iterator firstLevelPropertiesIter = ((BasicCompartmentImpl) obj).getPersistedChildren().iterator();
			while (firstLevelPropertiesIter.hasNext()){
				obj = firstLevelPropertiesIter.next();
				if (obj instanceof ShapeImpl && ((ShapeImpl)obj).getElement() instanceof Property){
					
				    //build instances for this property
					InstanceSpecification childInstance = buildInstance4Property((ShapeImpl) obj, pack4instances, instanceRoot, shape2instanceMap);
					
					//check if instanceSpecifications has to be created starting from information stored in other diagram
					Type type = ((Property)((ShapeImpl)obj).getElement()).getType();
					if (type instanceof Class){// && UMLUtils.isComponentImplementation(type)){
						//if property 'obj' is decomposed in the model but is leaf in this diagram then...
						if (isLeafShape((ShapeImpl) obj) && isDecomposedComponent((Class)type)){
							DiagramImpl childDiagram = getDiagram(editor, ((Property)((ShapeImpl)obj).getElement()).getType());
							if (childDiagram != null){
								buildPrototypeInstance(editor, null, childDiagram, childInstance, pack4instances, shape2instanceMap, warningMsg);
							}else{
								
							   warningMsg.append(System.getProperty("line.separator")+"-cannot find CompositeStructureDiagram\\IBD for Component "+type.getName());
						
							}
						}
					}
					//
				}
				
			}

		}
		
		//create instance specifications for connectors
		List listEdges = diagram.getPersistedEdges();
		Edge tempEdge = null;
		Shape targetShape = null;
		Shape sourceShape = null;
		Shape targetPropertyShape = null;
		Shape sourcePropertyShape = null;
		InstanceSpecification connectorInstance = null;
		Slot sourceSlot = null;
		Slot targetSlot = null;
		for (int i=0; i<listEdges.size(); i++){
			tempEdge = (Edge) listEdges.get(i);
			sourceShape = (Shape) tempEdge.getSource();
			targetShape = (Shape) tempEdge.getTarget();
			if (!(sourceShape.getElement() instanceof Port && targetShape.getElement() instanceof Port))
				continue;
			//need to create an instance specification with two slots, one for each port
			connectorInstance = (InstanceSpecification) pack4instances.createPackagedElement(
		            null, UMLPackage.Literals.INSTANCE_SPECIFICATION);
			sourceSlot = connectorInstance.createSlot();
			targetSlot = connectorInstance.createSlot();
			sourceSlot.setDefiningFeature((Port)sourceShape.getElement());
			targetSlot.setDefiningFeature((Port)targetShape.getElement());
			
			//need to set instanceSpecification (equivalent to connector.partwithPort)
			sourcePropertyShape = (Shape) sourceShape.eContainer();
			InstanceSpecification inst = (InstanceSpecification) shape2instanceMap.get(sourcePropertyShape);
			if (inst == null){
				//check if source is actually the root of the composite structure currently addressed
				if (sourcePropertyShape.getElement() instanceof Component){
					//need to retrieve the InstanceSpecification
					inst = instanceRoot;
				}
			}
			InstanceValue value = (InstanceValue) sourceSlot.createValue("partWithPort", null, UMLPackage.Literals.INSTANCE_VALUE);
			value.setInstance(inst);
			targetPropertyShape = (Shape) targetShape.eContainer();
			inst = (InstanceSpecification) shape2instanceMap.get(targetPropertyShape);
			
			if (inst == null){
				//check if target is actually the root of the composite structure currently addressed
				if (targetPropertyShape.getElement() instanceof Component){
					//need to retrieve the InstanceSpecification
					inst = instanceRoot;
				}
			}
						
			value = (InstanceValue) targetSlot.createValue("partWithPort", null, UMLPackage.Literals.INSTANCE_VALUE);
			value.setInstance(inst);
			
			//if the connector is <<propagation>> then attach <<propagation>> to instance specification also
			Connector connector = (Connector) tempEdge.getElement();
			Stereotype origPropagation = connector.getAppliedStereotype("CHESS::Dependability::DependableComponent::Propagation");
			if (origPropagation != null){
				Stereotype propagation = CHESSProfileManager.applyPropagationStereotype(connectorInstance);
				connectorInstance.setValue(propagation, "prob", connector.getValue(origPropagation, "prob"));
				connectorInstance.setValue(propagation, "propDelay", connector.getValue(origPropagation, "propDelay"));
				connectorInstance.setValue(propagation, "transfFunct", connector.getValue(origPropagation, "transfFunct"));
			}			
			
		}	
				
		return instanceRoot;
	}
	
	
	/**
	 * Builds the instance4 property.
	 *
	 * @param propertyShape the property shape
	 * @param pack the pack
	 * @param parentInstance the parent instance
	 * @param shape2instanceMap the shape2instance map
	 * @return the instance specification
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Deprecated
	public static InstanceSpecification  buildInstance4Property(ShapeImpl propertyShape, Package pack, InstanceSpecification parentInstance, Map shape2instanceMap) {
		Property property = (Property) propertyShape.getElement();
				
		InstanceSpecification newInstance = (InstanceSpecification) pack.createPackagedElement(
	            null, UMLPackage.Literals.INSTANCE_SPECIFICATION);
		
		shape2instanceMap.put(propertyShape, newInstance);
		
		//check for Property multiplicity
		if (property.upperBound() > 1){
			Stereotype stereo = CHESSProfileManager.applyMultiInstanceStereotype(newInstance);
			newInstance.setValue(stereo, "upperBound", property.upperBound());
		}
		
		
		if (parentInstance != null){
			Slot slot = parentInstance.createSlot();
			slot.setDefiningFeature(property);
			InstanceValue instValue = (InstanceValue) slot.createValue(property.getName(), null, UMLPackage.Literals.INSTANCE_VALUE);
			instValue.setInstance(newInstance);
		}
		
		if (parentInstance!=null)
			newInstance.setName(parentInstance.getName()+"."+property.getName());
		else
			newInstance.setName(property.getName());
		
		newInstance.getClassifiers().add((Classifier) property.getType());
		
		if (parentInstance == null){
			//remove old instance from model
			ValueSpecification oldvalue = property.getDefaultValue();
			if (oldvalue instanceof InstanceValue){
				InstanceSpecification oldinstance = ((InstanceValue) oldvalue).getInstance();
				if (oldinstance != null)
					oldinstance.destroy();
			}
			
			//set default value only for root properties
			InstanceValue value1 = (InstanceValue) pack.createPackagedElement(
		            null, UMLPackage.Literals.INSTANCE_VALUE);
			property.setDefaultValue(value1);
			value1.setInstance(newInstance);
		}
		
		//store newInstance
		instancesList.add(newInstance);
		
		//create port instances
		buildPortInstances((org.eclipse.uml2.uml.Class) property.getType(), newInstance, propertyShape);
		
		BuildModelInstanceCommand.mapStereotypesFromPropertyToInstance(property, newInstance);
		
		//check inner properties in the current diagram
		Iterator inners = getInnerShapes(propertyShape).iterator();
		Object obj = null;
		while (inners.hasNext()){
			obj = inners.next();
			if (obj instanceof ShapeImpl && ((ShapeImpl)obj).getElement() instanceof Property){
				buildInstance4Property((ShapeImpl)obj, pack, newInstance, shape2instanceMap);
			}
		}
			
		return newInstance;
	}
	
	
	/**
	 * Gets the comments for port ep.
	 *
	 * @param portEP the port ep
	 * @return the comments for port ep
	 */
	@SuppressWarnings("rawtypes")
	@Deprecated
	public static List<Comment> getCommentsForPortEP(PortEditPart portEP){
		List<Comment> v = new Vector<Comment>();
		List targetConnsList = portEP.getTargetConnections();
		Object tempTargetConn = null;
		CommentAnnotatedElementEditPart annotatedElemEP = null;
		for (int i=0; i<targetConnsList.size(); i++){
			tempTargetConn = targetConnsList.get(i);
			if (!(tempTargetConn instanceof CommentAnnotatedElementEditPart))
				continue;
			annotatedElemEP = (CommentAnnotatedElementEditPart) tempTargetConn;
			EditPart sourceEP = annotatedElemEP.getSource();
					
			if (! (sourceEP instanceof CommentEditPartCN))
				continue;
			Comment comment = (Comment) ((Shape) sourceEP.getModel()).getElement();
			v.add(comment);
		}
		return v;
	}
	
	/**
	 * Gets the comments for port shape.
	 *
	 * @param portShape the port shape
	 * @return the comments for port shape
	 */
	@Deprecated
	public static List<Comment> getCommentsForPortShape(ShapeImpl portShape){
		List<Comment> v = new Vector<Comment>();
		List targetConnsList = portShape.getTargetEdges();
		Object tempTargetConn = null;
		ConnectorImpl connectorImpl = null;
		for (int i=0; i<targetConnsList.size(); i++){
			tempTargetConn = targetConnsList.get(i);
			
			if (!(tempTargetConn instanceof ConnectorImpl))
				continue;
			connectorImpl = (ConnectorImpl) tempTargetConn;
			Object obj = connectorImpl.getSource();
			if ((obj instanceof ShapeImpl) && ((ShapeImpl)obj).getElement() instanceof Comment)
				v.add((Comment)((ShapeImpl)obj).getElement());
		}
		return v;
	}
	
	
	/**
	 * Gets the port edit part.
	 *
	 * @param propertyEP the property ep
	 * @param port the port
	 * @return the port edit part
	 */
	@SuppressWarnings("rawtypes")
	@Deprecated
	public static PortEditPart getPortEditPart(NamedElementEditPart propertyEP, Port port){
		// LB 20150701: porting MARS casting to propertyEP (following eclipse's suggestion)
		//List listEP = propertyEP.getChildren();
		List listEP = ((EditPart) propertyEP).getChildren();
		Object temp = null;
		for (int i=0; i<listEP.size(); i++){
			temp = listEP.get(i);
			if (!(temp instanceof PortEditPart))
				continue;
			if (((Shape)((PortEditPart)temp).getModel()).getElement().equals(port))
				return (PortEditPart) temp;
		
		}
		return null;
	}
	
	/**
	 * Gets the port shape.
	 *
	 * @param propertyShape the property shape
	 * @param port the port
	 * @return the port shape
	 */
	@Deprecated
	public static ShapeImpl getPortShape(ShapeImpl propertyShape, Port port){
		Vector<ShapeImpl> v = getInnerPortShapes(propertyShape);
		if (v.isEmpty())
			return null;
		Iterator<ShapeImpl> iter = v.iterator();
		ShapeImpl temp = null;
		while (iter.hasNext()){
			temp = iter.next();
			if (temp.getElement().equals(port))
				return temp;
		}
		return null;
	}
	
	/**
	 * Gets the CH rt specification.
	 *
	 * @param propertyEP the property ep
	 * @param port the port
	 * @return the CH rt specification
	 */
	@Deprecated
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<Comment> getCHRtSpecification(NamedElementEditPart propertyEP, Port port){
		PortEditPart portEP = getPortEditPart(propertyEP, port);
		if (portEP == null){
			Activator.log.info("port edit part not faound for port " + port.getName());
			return new Vector();
		}
		return getCommentsForPortEP(portEP);
	}

	
	/**
	 * Gets the comments.
	 *
	 * @param propertyShape the property shape
	 * @param port the port
	 * @return the comments
	 */
	@Deprecated
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<Comment> getComments(ShapeImpl propertyShape, Port port){
		ShapeImpl portShape = getPortShape(propertyShape, port);
		if (portShape == null){
			Activator.log.info("port edit part not faound for port " + port.getName());
			return new Vector();
		}
			
		return getCommentsForPortShape(portShape);
	}
	
	/**
	 * Builds the inner instance4 property.
	 *
	 * @param propertyEP the property ep
	 * @param pack the pack
	 */
	@Deprecated
	public static void buildInnerInstance4Property(PropertyPartEditPartCN propertyEP, Package pack){
		
	}
	
	
	/**
	 * Builds the port instances.
	 *
	 * @param classifier the classifier
	 * @param ownerInstance the owner instance
	 * @param propertyShape the property shape
	 */
	@Deprecated
	private static void buildPortInstances(org.eclipse.uml2.uml.Class classifier, InstanceSpecification ownerInstance,
			ShapeImpl propertyShape){
		List<Port> ports = classifier.getOwnedPorts();
		Port tempPort = null;
		Slot tempSlot = null;
		Stereotype portSlotStereo = null;
		for (int i=0; i<ports.size(); i++){
			tempPort = ports.get(i);
			//tempSlot = (Slot) pack.createPackagedElement(null, UMLPackage.Literals.SLOT);
			tempSlot = ownerInstance.createSlot();
			tempSlot.setDefiningFeature(tempPort);
			
			//check for Port multiplicity
			if (tempPort.upperBound() > 1){
				Stereotype stereo = CHESSProfileManager.applyMultiSlotStereotype(tempSlot);
				tempSlot.setValue(stereo, "upperBound", tempPort.upperBound());
			}
			
			//create connection to CHRtSpecification
			List<Comment> listComment = getComments(propertyShape, tempPort);
			//TODO why Vector?
			Vector<Object> v = new Vector<Object>();
			Object stereo  = null;
			
			//check ChRtSpecification
			for (int j=0; j<listComment.size(); j++){
				Comment comm = listComment.get(j);
				stereo = comm.getStereotypeApplication(CHESSProfileManager.getCHRTSpecification(comm));
				if (stereo != null)
					v.add(stereo);
			}
			if (v.size()>0){
				portSlotStereo = CHESSProfileManager.applyChRTPortSlotStereotype(tempSlot);
				tempSlot.setValue(portSlotStereo, "cH_RtSpecification", v);
			}
			
			//check FPTCSpecification, FI4FASpecification
			portSlotStereo = null;
			for (int j=0; j<listComment.size(); j++){
				Comment comm = listComment.get(j);
				stereo = comm.getStereotypeApplication(CHESSProfileManager.getFPTCSpecification(comm));
				if (stereo != null){
					portSlotStereo = CHESSProfileManager.applyFPTCPortSlotStereotype(tempSlot);
					tempSlot.setValue(portSlotStereo, "FPTCSpecification", stereo);
				} else {
					stereo = comm.getStereotypeApplication(CHESSProfileManager.getFI4FASpecification(comm));
					if (stereo != null){
						portSlotStereo = CHESSProfileManager.applyFPTCPortSlotStereotype(tempSlot);
						tempSlot.setValue(portSlotStereo, "FPTCSpecification", stereo);
					}
				}
			}
		
			// store tempSlot
			slotList.add(tempSlot);
		}
	}
	
	/**
	 * Gets the inner shapes.
	 *
	 * @param shape the shape
	 * @return the inner shapes
	 */
	@Deprecated
	protected static EList getInnerShapes(ShapeImpl shape){
		
			Iterator tempIter = shape.getPersistedChildren().iterator();
			Object obj;
			while (tempIter.hasNext()){
				obj = tempIter.next();
				if (obj instanceof ShapeImpl)
					return shape.getPersistedChildren();
				if (obj instanceof BasicCompartmentImpl){
					return ((BasicCompartmentImpl) obj).getPersistedChildren();
				}
			}
			return null;
	}
	
	/**
	 * Gets the inner port shapes.
	 *
	 * @param shape the shape
	 * @return the inner port shapes
	 */
	@Deprecated
	protected static Vector<ShapeImpl> getInnerPortShapes(ShapeImpl shape){
		Vector<ShapeImpl> v = new Vector<ShapeImpl>();
		Iterator tempIter = shape.getPersistedChildren().iterator();
		Object obj = null;
		while (tempIter.hasNext()){
			obj = tempIter.next();
			if (obj instanceof ShapeImpl && ((ShapeImpl)obj).getElement() instanceof Port){
				v.add((ShapeImpl)obj);
			}
			
		}
		return v;
}
	
	
	/**
	 * Gets the i sash windows container.
	 *
	 * @param editor the editor
	 * @return the i sash windows container
	 */
	@Deprecated
	public ISashWindowsContainer getISashWindowsContainer(PapyrusMultiDiagramEditor editor){		
		ServicesRegistry serviceRegistry = editor.getServicesRegistry();
				
		ISashWindowsContainer container = null;
		try {
			container = ServiceUtils.getInstance().getISashWindowsContainer(serviceRegistry);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return container;
	}
	
	/**
	 * Gets the diagram.
	 *
	 * @param editor the editor
	 * @param comp the comp
	 * @return the diagram
	 */
	@Deprecated
	private static DiagramImpl getDiagram(PapyrusMultiDiagramEditor editor, Type comp){
		ServicesRegistry serviceRegistry = editor.getServicesRegistry();
		IPageManager pageMngr = null;
		try {
			pageMngr = ServiceUtils.getInstance().getIPageManager(serviceRegistry);
		} catch (ServiceException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Iterator<?> iter = pageMngr.allPages().iterator();
		DiagramImpl dia = null;
		Object tempObj = null;
		while (iter.hasNext()){
			tempObj = iter.next();
			if (!(tempObj instanceof DiagramImpl))
				continue;
			dia = (DiagramImpl) tempObj;
			if (dia.getElement() == null)
				continue;
			if (dia.getElement().equals(comp))
				return dia;
		}
		return null;
	}
	
	/**
	 * Checks if is decomposed component.
	 *
	 * @param comp The componenImplementation
	 * @return true if the given comp is decomposed, i.e. it has attributes typed with Component
	 */
	@Deprecated
	public static boolean isDecomposedComponent(Class comp){
		EList<Property> list = comp.getAttributes();
		if (list.size() == 0)
			return false;
		for (Property p:list){
			
			if (UMLUtils.isComponentImplementation(p.getType()) || p.getType() instanceof Class)
				return true;
		}
		return false;
	}
	
	/**
	 * Checks if is leaf shape.
	 *
	 * @param shape the shape
	 * @return true, if is leaf shape
	 */
	@Deprecated
	public static boolean isLeafShape(ShapeImpl shape){
		Iterator inners = getInnerShapes(shape).iterator();
		Object obj = null;
		while (inners.hasNext()){
			obj = inners.next();
			if (obj instanceof ShapeImpl && ((ShapeImpl)obj).getElement() instanceof Property){
				Property property = (Property) ((ShapeImpl)obj).getElement();
				if (property.getType() instanceof Component)
					return false;
			}
		}
		return true;
	}
	
	/**
	 * set 'acList' and 'comments' self variable.
	 *
	 * @param editor the editor
	 */
	@Deprecated
	private static void saveAssignAllocations(PapyrusMultiDiagramEditor editor){
		//saving assign allocations before destroying and regenerating instance specifications
		EList<Comment> tmp = null;
		try {
			Resource res = ResourceUtils.getUMLResource(editor.getServicesRegistry());
			Model umlModel = ResourceUtils.getModel(res);
			
			Package deplViewPkg = ViewUtils.getCHESSDeploymentPackage(umlModel);
			Stereotype deplView = deplViewPkg.getAppliedStereotype("CHESS::Core::CHESSViews::DeploymentView");
			if (deplView != null){
				tmp = (EList<Comment>) deplViewPkg.getValue(deplView, "AssignList");
			}
			
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		comments = new BasicEList<Comment>();
		for (int i = 0; i < tmp.size(); i++){
			if(tmp.get(i).getAppliedStereotype(ASSIGN) != null){
				comments.add(tmp.get(i));
			}
		}
		acList = AssignCopy.toAssignCopyList(comments);
	}
	
	/**
	 * Regenerate assign allocations.
	 */
	@Deprecated
	private static void regenerateAssignAllocations(){
		//regenerating, if possible, assign allocations
		Iterator<InstanceSpecification> instIt;
		Iterator<Slot> slotIt;
				
		for (int i = 0; i < acList.size(); i++){
			Comment com = comments.get(i);
			EList<Element> from = (EList<Element>) com.getValue(com.getAppliedStereotype(ASSIGN), "from");
			EList<Element> to = (EList<Element>) com.getValue(com.getAppliedStereotype(ASSIGN), "to");
			
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
