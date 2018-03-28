/*******************************************************************************
 * Copyright (C) 2017 Fondazione Bruno Kessler.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Alberto Debiasi - initial API and implementation
 ******************************************************************************/
package org.polarsys.chess.contracts.profile.chesscontract.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.uml2.uml.Package;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.NamedElement;
//import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.BoundedSubtype;
import org.eclipse.papyrus.sysml.portandflows.FlowDirection;
import org.eclipse.papyrus.sysml.portandflows.FlowPort;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.papyrus.uml.tools.model.UmlUtils;
import org.eclipse.papyrus.uml.tools.utils.UMLUtil;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.PseudostateKind;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Type;
//import org.polarsys.chess.contracts.profile.chesscontract.util.ContractEntityUtil;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.Vertex;
import org.polarsys.chess.core.util.uml.ResourceUtils;


//TODO update the following methods with a check on the elements type (i.e. Property/Class/Port/ecc..):
//isCompType,isComponentImplementation - Class
//isFaultyStateMachine - StateMachine
//isInputPort,isInOutPort,isOutputPort,isFlowPort,isFlowPortMarte - Port

/**
 * Util class that provides methods to manage SysML/CHESS/MARTE objects.
 *
 */
public class EntityUtil {

	// private static final Logger logger = Logger.getLogger(EntityUtil.class);

	private static final String BLOCK = "SysML::Blocks::Block";
	private static final String SYSTEM = "CHESSContract::System";
	private static final String FLOW_Port = "SysML::PortAndFlows::FlowPort";
	private static final String FLOW_Port_MARTE = "MARTE::MARTE_DesignModel::GCM::FlowPort";
	private static final String BOUNDED_TYPE = "MARTE::MARTE_Annexes::VSL::DataTypes::BoundedSubtype";
	private static final String COMP_TYPE = "CHESS::ComponentModel::ComponentType";
	private static final String COMP_IMPL = "CHESS::ComponentModel::ComponentImplementation";
	private static final String SYSVIEW =	"CHESS::Core::CHESSViews::SystemView";

	private static final String INTEGER_TYPE = "PrimitiveTypes::Integer";
	private static final String STRING_TYPE = "PrimitiveTypes::String";
	private static final String REAL_TYPE = "PrimitiveTypes::Real";
	private static final String BOOLEAN_TYPE = "PrimitiveTypes::Boolean";

	private static final String CHESS_CONTINUOUS_TYPE = "CHESSContract::DataTypes::Continuous";

	private static final String MARTE_BOOLEAN_TYPE = "MARTE_Library::MARTE_PrimitivesTypes::Boolean";
	private static final String MARTE_REAL_TYPE = "MARTE_Library::MARTE_PrimitivesTypes::Real";
	private static final String MARTE_INTEGER_TYPE = "MARTE_Library::MARTE_PrimitivesTypes::Integer";

	private static final String FAULTY_STATE_MACHINE = "CHESS::Dependability::ThreatsPropagation::ErrorModel";

	// not yet used
	// private static final String STRING_TYPE = "PrimitiveTypes::String";
	// private static final String UNLIMITED_NAT_TYPE =
	// "PrimitiveTypes::UnlimitedNatural";

	private static EntityUtil entityUtil;
	// private static ContractEntityUtil contractEntityUtil =
	// ContractEntityUtil.getInstance();

	public static EntityUtil getInstance() {
		if (entityUtil == null) {
			entityUtil = new EntityUtil();
		}
		return entityUtil;
	}

	public Model loadModel(String projectName, String fileName) {
		IWorkspaceRoot wRoot = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wRoot.getProject(projectName);
		IFile file = proj.getFile(fileName);
		IPath loc = file.getLocation();
		ResourceSet resSet = new ResourceSetImpl();
		Resource resource = resSet.getResource(URI.createFileURI(loc.toString()), true);
		Model model = ResourceUtils.getModel(resource);
		return model;
	}

	 /**
     * Returns the component instance with the given name.
     * @param owner the class owning the instance
     * @param componentName the name of the instance
     * @return the UML property representing the component instance
     */
    public Property getSubComponentInstance(Class owner, String componentName) {
       
        for (Property umlProperty : (owner.getAttributes())) {
            if (umlProperty.getName().equals(componentName) && EntityUtil.getInstance().isComponentInstance(umlProperty)) {
                return umlProperty;
            }
        }
        return null;
    }
	
	public String getSystemElementURIFragment(Model model) throws Exception {

		if (model != null) {
			TreeIterator<EObject> allElements = model.eResource().getAllContents();
			if (allElements != null) {
				Collection<org.eclipse.uml2.uml.Class> classes = EcoreUtil
						.getObjectsByType(iterator2Collection(allElements), UMLPackage.eINSTANCE.getClass_());

				for (Class c : classes) {
					if (entityUtil.isSystem(c)) {
						return c.eResource().getURIFragment(c);
					}
				}
			}
		}
		throw new Exception("Element does not exist.");
	}

	public EObject getElement(String projectName, String fileModelPath, String elementID) throws Exception {

		Model model = loadModel(projectName, fileModelPath);
		return getElement(model, elementID);

	}

	public EObject getElement(Model model, String elementID) throws Exception {

		if (model != null) {
			/*
			 * TreeIterator<EObject> allElements =
			 * model.eResource().getAllContents(); while(allElements.hasNext()){
			 * logger.debug("URI  fragment: "+allElements.next().eResource().
			 * getURI().fragment()); }
			 */
			EObject umlElement = model.eResource().getEObject(elementID.trim());
			return umlElement;
		}

		return null;

	}

	public String getUMLElementName(String projectName, String fileModelPath, String elementID) throws Exception {

		Model model = loadModel(projectName, fileModelPath);

		if (model != null) {
			EObject umlElement = model.eResource().getEObject(elementID.trim());
			return ((Class) umlElement).getName();
		}

		return null;

	}

	public Element getSubComponentOfConstraintOwner(Constraint constraint, String componentName) {
		Element element = constraint.getOwner();

		for (Property umlProperty : getSubComponentsInstances((Class) element)) {
			if (umlProperty.getName().compareTo(componentName) == 0) {
				return getUMLType(umlProperty);
			}
		}

		return null;
	}

	public String[] getSubComponentsNameOfConstraintOwner(Constraint constraint) {
		Element umlElement = constraint.getOwner();
		Set<String> subCompArr = getSubComponentsNames((Class) umlElement);
		return toArray(subCompArr);
	}

	private String[] toArray(Set<String> set) {
		String[] strArray = new String[set.size()];
		return set.toArray(strArray);
	}

	private String[] toArray(EList<String> eList) {
		String[] strArray = new String[eList.size()];
		return eList.toArray(strArray);
	}

	public String getComponentID(Element umlComponent) {

		if ((isBlock(umlComponent))) {
			return ((Class) umlComponent).getName();
		}

		if (isComponentInstance((Element) umlComponent)) {
			return (((Property) umlComponent).getName());
		}

		return null;
	}

	public String getQualifiedName(NamedElement element) {
		return ((NamedElement) element).getQualifiedName();
	}

	public String getComponentName(Element umlComponent) {

		if ((isBlock( umlComponent))) {
			return ((Class) umlComponent).getName();
		}

		if (isComponentInstance((Element) umlComponent)) {
			return (((Property) umlComponent).getName());
		}

		return null;
	}

	public Set<Property> getSubComponentsInstances(Class umlComponent) {
		Set<Property> subComponents = new HashSet<Property>();
		for (Property umlProperty : ((Class) umlComponent).getAttributes()) {
			if (isComponentInstance(umlProperty)) {
				subComponents.add(umlProperty);
			}
		}
		return subComponents;
	}

	
	public String[] getEnumValuesFromComponentPorts(Class umlComponent) {
		EList<String> enumValuesEList = new BasicEList<String>();

		for (Port port : getUMLPortsFromClass(umlComponent)) {
			if (isEnumerationAttribute(port)) {
				Set<String> currValues = getListValuesForEnumeratorType(port);
				enumValuesEList.addAll(currValues);
			}
		}

		return toArray(enumValuesEList);
	}

	public String[] getEnumValuesFromComponentAttributes(Class umlComponent) {
		EList<String> enumValuesEList = new BasicEList<String>();

		for (Property element : getSupportedAttributes(umlComponent,null)) {
			if (isEnumerationAttribute(element)) {
				Set<String> currValues = getListValuesForEnumeratorType(element);
				enumValuesEList.addAll(currValues);
			}
		}

		return toArray(enumValuesEList);
	}

	public Set<String> getSubComponentsNames(Class umlComponent) {

		Set<String> subComponentsNames = new HashSet<String>();
		for (Property umlProperty : getSubComponentsInstances(umlComponent)) {
			subComponentsNames.add((umlProperty).getName());
		}
		return subComponentsNames;
	}

	

	public EList<Port> getUMLPorts(Element umlElement, boolean isStaticPort) {
		EList<Port> portsArr = new BasicEList<Port>();
		if (isBlock(umlElement)||isCompType(umlElement) || isComponentImplementation(umlElement)) {
			portsArr.addAll(getUMLPortsFromClass((Class) umlElement,isStaticPort));
		}

		if (isComponentInstance(umlElement)) {
			portsArr.addAll(getUMLPortsFromProperty((Property) umlElement,isStaticPort));
		}
		return portsArr;

	}
	
	private Set<Port> getUMLPortsFromProperty(Property umlElement, boolean isStaticPort) {
		return getUMLPortsFromClass((Class)getUMLType((Property) umlElement),isStaticPort);
	}
	
	public Set<Port> getUMLPorts(Element umlElement, int portDirection, boolean isStaticPort) {
		Set<Port> portsArr = new HashSet<Port>();
		if (isBlock(umlElement)) {
			portsArr.addAll(getUMLPortsFromClass((Class) umlElement, portDirection,isStaticPort));
		}

		if (isCompType(umlElement) || (isComponentImplementation(umlElement))) {
			portsArr.addAll(getUMLPortsFromComponent((Component) umlElement, portDirection,isStaticPort));
		}

		if (isComponentInstance(umlElement)) {
			portsArr.addAll(getUMLPorts(getUMLType((Property) umlElement), portDirection,isStaticPort));
		}
		return portsArr;

	}

	private Set<Port> getUMLPortsFromClass(Class umlComponent, int portDirection, boolean isStatic) {
		System.out.println(umlComponent);
		Set<Port> ports = new HashSet<Port>();
		for (Port umlPort : umlComponent.getOwnedPorts()) {
			System.out.println(umlPort);
			FlowPort fp = getFlowPort(umlPort);
			if ((fp.getDirection().getValue() == portDirection)&&(umlPort.isStatic()==isStatic) ){
				ports.add(umlPort);
			}
		}
		return ports;
	}

	

	public boolean isInputPort(Element umlPort) {
		if (getPortDirection(umlPort) == FlowDirection.IN_VALUE) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isInOutPort(Element umlPort) {
		if (getPortDirection(umlPort) == FlowDirection.INOUT_VALUE) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isOutputPort(Element umlPort) {
		if (getPortDirection(umlPort) == FlowDirection.OUT_VALUE) {
			return true;
		} else {
			return false;
		}
	}

	public Integer getPortDirection(Element umlPort) {
		if (isFlowPort(umlPort)) {
			return ((FlowPort) getFlowPort((Port) umlPort)).getDirection().getValue();
		} else if (isFlowPortMarte(umlPort)) {
			return ((org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowPort) getFlowPortMarte((Port) umlPort))
					.getDirection().getValue();
		} else {
			return null;
		}
	}

	private Set<Port> getUMLPortsFromComponent(Component umlComponent, int portDirection, boolean isStaticPort) {
		Set<Port> ports = new HashSet<Port>();

		for (Port umlPort : umlComponent.getOwnedPorts()) {
			org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowPort fp = getFlowPortMarte(umlPort);
			if ((fp.getDirection().getValue() == portDirection)&&(umlPort.isStatic()==isStaticPort)){
				ports.add(umlPort);
			}
		}
		return ports;
	}

	
	
	private Set<Port> getUMLPortsFromClass(Class umlComponent, boolean isStaticPort) {
		Set<Port> ports = new HashSet<Port>();
		for (Port umlPort : umlComponent.getOwnedPorts()) {
			if(umlPort.isStatic()==isStaticPort){
			ports.add(umlPort);
			}
		}
		return ports;
	}
	
	private Set<Port> getUMLPortsFromClass(Class umlComponent) {
		Set<Port> ports = new HashSet<Port>();
		for (Port umlPort : umlComponent.getOwnedPorts()) {			
			ports.add(umlPort);
		}
		return ports;
	}
	
	/*private Set<Port> getUmlPortsFromComponent(Component umlComponent) {
		Set<Port> ports = new HashSet<Port>();

		for (Port umlPort : umlComponent.getOwnedPorts()) {
			ports.add(umlPort);
		}
		return ports;
	}*/

	public Package getToPackage(org.eclipse.uml2.uml.Element umlElememt) {

		Package tmp = umlElememt.getNearestPackage();
		while (tmp.getOwner() != null && (tmp.getOwner() instanceof Package)) {
			tmp = (Package) tmp.getOwner();
		}
		return tmp;
	}

	private FlowPort getFlowPort(Port umlPort) {
		Stereotype contrStereo = UMLUtil.getAppliedStereotype(umlPort, FLOW_Port, false);
		return (FlowPort) umlPort.getStereotypeApplication(contrStereo);

	}

	private org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowPort getFlowPortMarte(Port umlPort) {
		Stereotype flowPortStereo = UMLUtil.getAppliedStereotype(umlPort, FLOW_Port_MARTE, false);
		return (org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowPort) umlPort
				.getStereotypeApplication(flowPortStereo);
	}

	public boolean isPort(Element umlElement) {
		return ((umlElement instanceof Property) && (isFlowPort(umlElement) || isFlowPortMarte(umlElement)));
	}

	private boolean isFlowPort(Element umlElement) {
		return (UMLUtil.getAppliedStereotype(umlElement, FLOW_Port, false) != null);
	}

	private boolean isFlowPortMarte(Element umlElement) {
		return (UMLUtil.getAppliedStereotype(umlElement, FLOW_Port_MARTE, false) != null);
	}

	public void deleteComponentContract(Class clazz) {
		clazz.destroy();
	}

	public boolean isComponentImplementation(Element umlElement) {
		return UMLUtil.getAppliedStereotype(umlElement, COMP_IMPL, false) != null;
	}

	// modified method!!
	public boolean isComponentInstance(Element umlProperty) {
		// return UMLUtil.getAppliedStereotype(umlProperty, COMP_INST, false) !=
		// null;
		if (!(umlProperty instanceof Property)) {
			return false;
		}

		Property property = (Property) umlProperty;

		if (property.getAssociation() == null) {
			return false;
		}

		// if (contractEntityUtil.isContractProperty(property)) {
		// return false;
		// }

		Element owner = (getOwner(umlProperty));
		Association association = property.getAssociation();
		int associationEndsSize = association.getEndTypes().size();
		boolean End1TypeIsOwner = association.getEndTypes().get(0).equals(owner);
		boolean End2TypeIsOwner = association.getEndTypes().get(1).equals(owner);

		return (associationEndsSize == 2) && ((End1TypeIsOwner) | (End2TypeIsOwner));

		// Type umlPropertyType = ((Property) umlProperty).getType();
		// return (isBlock(umlPropertyType) ||
		// isComponentImplementation(umlPropertyType));
	}

	public boolean isBooleanAttribute(Property umlProperty) {
		return isBooleanType(umlProperty.getType());
	}

	public boolean isBooleanType(Type type) {
		if (type != null) {
			return ((type.getQualifiedName().compareTo(BOOLEAN_TYPE) == 0)
					|| (type.getQualifiedName().compareTo(MARTE_BOOLEAN_TYPE) == 0));
		}
		return false;
	}

	public String[] getLowerUpperBoundsForRangeType(Property umlProperty) {
		return getLowerUpperBoundsForRangeType(umlProperty.getType());
	}

	public String[] getLowerUpperBoundsForRangeType(Type umlType) {
		BoundedSubtype boundedSubtype = getRangeAttribute(umlType);
		String[] bounds = { boundedSubtype.getMinValue(), boundedSubtype.getMaxValue() };

		return bounds;
	}

	private BoundedSubtype getRangeAttribute(Type umlType) {
		Stereotype boundedStereo = UMLUtil.getAppliedStereotype(umlType, BOUNDED_TYPE, false);
		return (BoundedSubtype) umlType.getStereotypeApplication(boundedStereo);
	}

	public boolean isRangeAttribute(Property umlProperty) {
		return isRangeType(umlProperty.getType());
	}

	public boolean isRangeType(Type umlType) {
		if (umlType != null) {
			if (UMLUtil.getAppliedStereotype(umlType, BOUNDED_TYPE, false) != null) {
				return true;
			}
		}
		return false;
	}

	public boolean isDoubleAttribute(Property umlProperty) {
		if (umlProperty.getType() != null) {
			return (umlProperty.getType().getName().compareTo("Double") == 0);
		}
		return false;
	}

	public boolean isStringAttribute(Property umlProperty) {
		return isStringType(umlProperty.getType());
	}

	public boolean isRealAttribute(Property umlProperty) {
		return isRealType(umlProperty.getType());
	}

	public boolean isIntegerAttribute(Property umlProperty) {
		return isIntegerType(umlProperty.getType());
	}

	public boolean isContinuousAttribute(Property umlProperty) {
		if (umlProperty.getType() != null) {
			return (umlProperty.getType().getQualifiedName().compareTo(CHESS_CONTINUOUS_TYPE) == 0);
		}
		return false;
	}

	public boolean isEnumerationAttribute(Property umlProperty) {
		return isEnumerationType(umlProperty.getType());
	}

	public boolean isEnumerationType(Type umlType) {
		if (umlType != null) {
			return (umlType instanceof Enumeration);
		}
		return false;
	}

	public Set<String> getListValuesForEnumeratorType(Property umlProperty) {
		return getListValuesForEnumeratorType(umlProperty.getType());
	}

	public Set<String> getListValuesForEnumeratorType(Type umlType) {
		Set<String> enumValuesNames = new HashSet<String>();
		if (umlType instanceof Enumeration) {
			for (EnumerationLiteral enumLit : ((Enumeration) umlType).getOwnedLiterals()) {
				enumValuesNames.add(enumLit.getName());
			}
			return enumValuesNames;

		}
		return null;
	}

	public String[] getValuesForEnumeratorType(Property umlProperty) {
		Set<String> enumValuesNames = getListValuesForEnumeratorType(umlProperty);
		if (enumValuesNames != null) {
			return toArray(enumValuesNames);
		}
		return null;

	}

	public Element getUMLType(Property umlProperty) {
		return ((Element) umlProperty.getType());
	}

	public boolean isBlock(Element umlClass) {
		return ((umlClass instanceof Class) && (UMLUtil.getAppliedStereotype(umlClass, BLOCK, false) != null));
	}

	public boolean isCompType(Element umlComponent) {
		return UMLUtil.getAppliedStereotype(umlComponent, COMP_TYPE, false) != null;
	}

	public boolean isSystem(Element umlElement) {
		return ((umlElement instanceof Class) && (UMLUtil.getAppliedStereotype(umlElement, SYSTEM, false) != null));
	}

	public boolean isFaultyStateMachine(Element umlElement) {
		return UMLUtil.getAppliedStereotype(umlElement, FAULTY_STATE_MACHINE, false) != null;
	}

	public boolean isNominalStateMachine(Element umlElement) {
		return (umlElement instanceof StateMachine)
				& (UMLUtil.getAppliedStereotype(umlElement, FAULTY_STATE_MACHINE, false) == null);
	}

	public void saveConstraint(final Constraint constraint, final String text) {

		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(constraint);
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {

				LiteralString litString = (LiteralString) constraint.getSpecification();
				litString.setValue(text);
				constraint.setSpecification(litString);
			}
		});
	}

	public Element getOwner(Element umlElement) {
		return umlElement.getOwner();
	}

	public String getName(Class umlClass) {
		return umlClass.getName();
	}

	public String[] getPortsNames(Element umlElement, int portDirection, boolean isStaticPort) {
		EList<String> portsNames = new BasicEList<String>();

		for (Port umlPort : getUMLPorts(umlElement, portDirection,isStaticPort)) {
			portsNames.add(umlPort.getName());
		}

		return toArray(portsNames);
	}

	public EList<String> getPortsName(EList<Port> ports) {
		EList<String> portsNames = new BasicEList<String>();

		for (Port umlPort : ports) {
			portsNames.add(umlPort.getName());
		}
		return portsNames;
	}

	public String[] getInputPortsNames(Element umlElement,boolean isStaticPort) {
		return getPortsNames(umlElement, FlowDirection.IN_VALUE, isStaticPort);
	}

	public String[] getOutputPortsNames(Element umlElement,boolean isStaticPort) {
		return getPortsNames(umlElement, FlowDirection.OUT_VALUE,isStaticPort);
	}

	public String[] getInputOutputPortsNames(Element umlElement,boolean isStaticPort) {
		return getPortsNames(umlElement, FlowDirection.INOUT_VALUE,isStaticPort);
	}

	

	
	


	private Set<Property> getSupportedAttributes(Element umlElement, Boolean isStaticAttribute) {
		Set<Property> simpleAttributes = new HashSet<Property>();

		if (isComponentInstance(umlElement)) {
			umlElement = getUMLType((Property) umlElement);
		}

		if (isBlock(umlElement) || (isCompType(umlElement) || (isComponentImplementation(umlElement)))) {
			Class umlClass = (Class) umlElement;
			for (Property umlProperty : umlClass.getOwnedAttributes()) {
				if((isStaticAttribute==null)||(umlProperty.isStatic()==isStaticAttribute)){
				if (isBooleanAttribute(umlProperty)) {
					simpleAttributes.add(umlProperty);
				}
				if (isContinuousAttribute(umlProperty)) {
					simpleAttributes.add(umlProperty);
				}
				if (isDoubleAttribute(umlProperty)) {
					simpleAttributes.add(umlProperty);
				}
				if (isRangeAttribute(umlProperty)) {
					simpleAttributes.add(umlProperty);
				}
				if (isEnumerationAttribute(umlProperty)) {
					simpleAttributes.add(umlProperty);
				}
				if (isIntegerAttribute(umlProperty)) {
					simpleAttributes.add(umlProperty);
				}
				if (isRealAttribute(umlProperty)) {
					simpleAttributes.add(umlProperty);
				}
				}
			}
		}

		return simpleAttributes;
	}

	private Set<Property> getIntegerAttributes(Element umlElement) {
		Set<Property> integerAttributes = new HashSet<Property>();

		if (isBlock(umlElement) || (isCompType(umlElement) || (isComponentImplementation(umlElement)))) {
			Class umlClass = (Class) umlElement;
			EList<Property> attributes = umlClass.getOwnedAttributes();
			for (Property umlProperty : attributes) {
				if (isIntegerAttribute(umlProperty)) {
					integerAttributes.add(umlProperty);
				}
			}
		}

		if (isComponentInstance(umlElement)) {
			integerAttributes.addAll(getIntegerAttributes(getUMLType((Property) umlElement)));
		}
		return integerAttributes;
	}

	

	public Set<Property> getAttributesExceptPorts(Element umlElement, Boolean isStaticAttribute) {
		Set<Property> attributes = new HashSet<Property>();
		for (Property umlProperty : getSupportedAttributes(umlElement,isStaticAttribute)) {
			if (!isPort(umlProperty)) {
				attributes.add(umlProperty);
			}
		}
		return attributes;
	}

	public Set<Property> getIntegerAttributesExceptPorts(Element umlElement) {
		Set<Property> integerAttributes = new HashSet<Property>();
		for (Property umlProperty : getIntegerAttributes(umlElement)) {
			if (!isPort(umlProperty)) {
				integerAttributes.add(umlProperty);
			}
		}
		return integerAttributes;
	}

	public Collection<StateMachine> getNominalStateMachines() {

		UmlModel umlModel = UmlUtils.getUmlModel();
		Set<StateMachine> stateMachines = getNominalStateMachines(umlModel);
		return stateMachines;

	}

	public Set<StateMachine> getNominalStateMachines(UmlModel umlModel) {

		Set<StateMachine> stateMachines = new HashSet<StateMachine>();

		if (umlModel != null) {
			TreeIterator<EObject> allElements = umlModel.getResource().getAllContents();
			if (allElements != null) {
				Collection<org.eclipse.uml2.uml.Class> classes = EcoreUtil
						.getObjectsByType(iterator2Collection(allElements), UMLPackage.eINSTANCE.getClass_());
				for (Class c : classes) {
					if (isNominalStateMachine(c)) {
						stateMachines.add((StateMachine) c);
					}
				}
			}
		}

		return stateMachines;
	}

	public Set<StateMachine> getNominalStateMachines(Class umlSelectedComponent, boolean fromSubComponent) {

		Set<StateMachine> stateMachines = getNominalStateMachines(umlSelectedComponent);
		if (fromSubComponent) {
			for (Property subComponentInstance : getSubComponentsInstances(umlSelectedComponent)) {
				stateMachines.addAll(getNominalStateMachines((Class) subComponentInstance.getType(), true));
			}
		}
		return stateMachines;
	}

	public StateMachine getFirstNominalStateMachine(Class umlSelectedComponent) {
		Set<StateMachine> stateMachines = getNominalStateMachines(umlSelectedComponent);
		if ((stateMachines != null) && (stateMachines.size() > 0)) {
			return stateMachines.iterator().next();
		} else
			return null;
	}

	public Set<StateMachine> getNominalStateMachines(Class umlSelectedComponent) {

		Set<StateMachine> stateMachines = new HashSet<StateMachine>();

		if (umlSelectedComponent != null) {
			EList<Behavior> behaviours = umlSelectedComponent.getOwnedBehaviors();
			if (behaviours != null) {
				for (Class c : behaviours) {
					if (isNominalStateMachine(c)) {
						stateMachines.add((StateMachine) c);
					}
				}
			}
		}

		return stateMachines;
	}

	private <T> Collection<T> iterator2Collection(final Iterator<T> iter) {
		ArrayList<T> list = new ArrayList<T>();
		for (; iter.hasNext();) {
			T item = iter.next();
			list.add(item);
		}
		return list;
	}

	public EList<Transition> getTranstitions(StateMachine stateMachine) {
		Region region = stateMachine.getRegions().get(0);
		return region.getTransitions();
	}

	public EList<Vertex> getStates(StateMachine stateMachine) {
		Region region = stateMachine.getRegions().get(0);
		return region.getSubvertices();
	}

	public boolean isInitialState(Vertex state) {
		return (state instanceof Pseudostate)
				&& ((Pseudostate) state).getKind().equals(PseudostateKind.INITIAL_LITERAL);
	}

	public boolean isFinalState(Vertex state) {
		return ((state instanceof Pseudostate)
				&& ((Pseudostate) state).getKind().getName().compareTo("Terminate") == 0);
	}

	public EList<Vertex> getIntermediateStates(StateMachine stateMachine) {
		EList<Vertex> intermediateStates = new BasicEList<Vertex>();
		for (Vertex state : getStates(stateMachine)) {
			if (!isInitialState(state) & !isFinalState(state)) {
				intermediateStates.add(state);
			}
		}
		return intermediateStates;
	}

	public EList<String> getStatesNameList(EList<Vertex> states) {
		EList<String> names = new BasicEList<String>();
		for (Vertex state : states) {
			names.add(state.getName());
		}
		return names;
	}

	public EList<String> getTransitionNameList(EList<Transition> transitions) throws Exception {
		EList<String> transNames = new BasicEList<String>();
		for (Transition trans : transitions) {
			if (trans.getName() == null) {
				throw new Exception("In " + trans.containingStateMachine().getQualifiedName()
						+ ", one transition has name == null.");
			}
			transNames.add(trans.getName());
		}

		return transNames;
	}

	public String getStateMachineName(StateMachine stateMachine) {
		return stateMachine.getName();
	}

	public String getTransitionName(Transition transition) {
		return transition.getName();
	}

	public Vertex getInitialState(StateMachine stateMachine) {
		for (Vertex state : getStates(stateMachine)) {
			if (isInitialState(state)) {
				return state;
			}
		}
		return null;
	}

	public EList<Transition> getInitialTransitions(StateMachine stateMachine) throws Exception {
		Vertex initialState = getInitialState(stateMachine);
		if (initialState != null) {
			return initialState.getOutgoings();
		} else {
			throw new Exception(stateMachine.getName() + " does not have the initial state.");
		}

	}

	public EList<Transition> getNonInitialTransitions(StateMachine stateMachine) {
		EList<Vertex> states = getIntermediateStates(stateMachine);
		EList<Transition> transitions = new BasicEList<Transition>();
		for (Vertex state : states) {
			if (!isInitialState(state)) {
				transitions.addAll(state.getOutgoings());
			}
		}
		return transitions;
	}

	public Vertex getTransitionNextState(Transition transition) {
		return transition.getTarget();
	}

	public Vertex getTransitionSourceState(Transition transition) {
		return transition.getSource();
	}

	public Constraint getTransitionGuard(Transition transition) {
		return transition.getGuard();
	}

	public OpaqueBehavior getTransitionEffect(Transition transition) {
		if (transition.getEffect() instanceof OpaqueBehavior) {
			return (OpaqueBehavior) transition.getEffect();
		}
		return null;
	}

	public String getTransitionEffectText(Transition transition) {
		OpaqueBehavior effect = getTransitionEffect(transition);
		if ((effect != null) && (effect.getBodies() != null) && (effect.getBodies().size() != 0)) {
			String effectAsString = effect.getBodies().get(0);
			return effectAsString;
		}
		return null;
	}

	public String getGuardName(Constraint guard) {
		return guard.getName();
	}

	public String getStateName(Vertex state) {
		return state.getName();
	}

	public String getEffectName(Behavior effect) {
		return effect.getName();
	}

	public boolean isFinalTransition(Transition transition) {
		return isFinalState(transition.getTarget());
	}

	public EList<Port> getEvents(StateMachine stateMachine) {
		EList<Port> eventsPort = getEventPorts(getOwner(stateMachine));
		return eventsPort;
	}

	public EList<Port> getEventPorts(Element umlElement) {

		EList<Port> eventPorts = new BasicEList<Port>();

		if (isComponentInstance(umlElement)) {
			umlElement = getUMLType((Property) umlElement);
		}

		if (isBlock(umlElement) || (isCompType(umlElement) || (isComponentImplementation(umlElement)))) {
			Class umlClass = (Class) umlElement;
			for (Property umlProperty : umlClass.getOwnedAttributes()) {
				if (isEventPortAttribute(umlProperty)) {
					eventPorts.add((Port) umlProperty);
				}
			}
		}

		return eventPorts;
	}

	public boolean isEventPortAttribute(Property umlProperty) {
		return ((umlProperty.getType() != null) && (umlProperty.getType() instanceof Signal));
	}

	public EList<Port> getTransitionEvents(Transition transition) {
		if (!isTransitionWithNoEvent(transition)) {
			return transition.getTriggers().get(0).getPorts();
		}
		return null;
	}

	public String getPortName(Port port) {
		return port.getName();
	}

	public String getAttributeName(Property attribute) {
		return attribute.getName();
	}

	public boolean isTransitionWithNoEvent(Transition transition) {
		return !((transition.getTriggers() != null) && (transition.getTriggers().size() != 0)
				&& (transition.getTriggers().get(0).getPorts() != null)
				&& transition.getTriggers().get(0).getPorts().size() != 0);

	}

	public boolean isRealType(Type type) {
		if (type != null) {
			return ((type.getQualifiedName().compareTo(REAL_TYPE) == 0)
					|| (type.getQualifiedName().compareTo(MARTE_REAL_TYPE) == 0));
		}
		return false;
	}

	public boolean isIntegerType(Type type) {
		if (type != null) {
			return ((type.getQualifiedName().compareTo(INTEGER_TYPE) == 0)
					|| (type.getQualifiedName().compareTo(MARTE_INTEGER_TYPE) == 0));
		}
		return false;
	}

	private boolean isStringType(Type type) {
		if (type != null) {
			return (type.getQualifiedName().compareTo(STRING_TYPE) == 0);
		}
		return false;
	}

	public Collection<? extends Port> getUMLPortsExceptEvents(Element umlElement, int portDirection) {

		if (isComponentInstance(umlElement)) {
			umlElement = getUMLType((Property) umlElement);
		}

		Set<Port> portsArr = new HashSet<Port>();
		if (isBlock(umlElement)) {
			portsArr.addAll(getUMLPortsExceptEventsFromClass((Class) umlElement, portDirection));
		}

		if (isCompType(umlElement) || (isComponentImplementation(umlElement))) {
			portsArr.addAll(getUMLPortsExceptEventsFromComponent((Component) umlElement, portDirection));
		}

		return portsArr;
	}

	private Collection<? extends Port> getUMLPortsExceptEventsFromComponent(Component umlComponent, int portDirection) {
		Set<Port> ports = new HashSet<Port>();

		for (Port umlPort : umlComponent.getOwnedPorts()) {
			org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowPort fp = getFlowPortMarte(umlPort);
			if ((fp.getDirection().getValue() == portDirection) & (!isEventPortAttribute(umlPort))) {
				ports.add(umlPort);
			}
		}
		return ports;
	}

	private Collection<? extends Port> getUMLPortsExceptEventsFromClass(Class umlElement, int portDirection) {
		Set<Port> ports = new HashSet<Port>();
		for (Port umlPort : umlElement.getOwnedPorts()) {
			FlowPort fp = getFlowPort(umlPort);
			if ((fp.getDirection().getValue() == portDirection) & (!isEventPortAttribute(umlPort))) {
				ports.add(umlPort);
			}
		}
		return ports;
	}

	public String getConditionExpression(Constraint condition) {
		if ((condition.getSpecification() instanceof OpaqueExpression) && (condition.getSpecification() != null)
				&& ((OpaqueExpression) condition.getSpecification()).getBodies() != null) {
			return ((OpaqueExpression) condition.getSpecification()).getBodies().get(0);
		}
		return null;
	}

	/**
	 * Checks if the selected object is a package in the <<SystemView>> branch.
	 * @param pkg the selected element 
	 * @return true if the package is valid
	 */
	public boolean isSystemViewPackage(Element obj) {
		if (obj instanceof Package) {
			final Package pkg = (Package) obj;
			if(pkg.getAppliedStereotype(SYSVIEW) != null) {
				return true;
			} else {
				EList<Package> owningPackages = pkg.allOwningPackages();
				for (Package owningPackage : owningPackages) {
					if (owningPackage.getAppliedStereotype(SYSVIEW) != null) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
/*	UNUSED METHODS
  
  private Set<Property> getBooleanAttributesExceptPorts(Element umlElement) {
		Set<Property> booleanAttributes = new HashSet<Property>();
		for (Property umlProperty : getBooleanAttributes(umlElement)) {
			if (!isPort(umlProperty)) {
				booleanAttributes.add(umlProperty);
			}
		}
		return booleanAttributes;
	}
  
  
  private Set<String> getBooleanAttributesNames(Element umlElement) {

		Set<String> booleanAttributesNames = new HashSet<String>();
		for (Property umlProperty : getBooleanAttributes(umlElement)) {
			booleanAttributesNames.add(umlProperty.getName());
		}
		return booleanAttributesNames;
	}

private Set<String> getAttributesNamesExceptsPorts(Element umlElement) {
		Set<String> booleanAttributesNames = new HashSet<String>();
		for (Property umlProperty : getAttributesExceptPorts(umlElement,null)) {
			booleanAttributesNames.add(umlProperty.getName());
		}
		return booleanAttributesNames;
	}

	

	private Set<Property> getBooleanAttributes(Element umlElement) {
		Set<Property> booleanAttributes = new HashSet<Property>();

		if (isBlock(umlElement) || (isCompType(umlElement) || (isComponentImplementation(umlElement)))) {
			Class umlClass = (Class) umlElement;
			EList<Property> attributes = umlClass.getOwnedAttributes();
			for (Property umlProperty : attributes) {
				if (isBooleanAttribute(umlProperty)) {
					booleanAttributes.add(umlProperty);
				}
			}
		}

		if (isComponentInstance(umlElement)) {
			booleanAttributes.addAll(getBooleanAttributes(getUMLType((Property) umlElement)));
		}
		return booleanAttributes;
	}


	private Set<String> getBooleanAttributesNamesExceptsPorts(Element umlElement) {
		Set<String> booleanAttributesNames = new HashSet<String>();
		for (Property umlProperty : getBooleanAttributesExceptPorts(umlElement)) {
			booleanAttributesNames.add(umlProperty.getName());
		}
		return booleanAttributesNames;
	}
	
	private Set<Property> getRealAttributes(Element umlElement) {
		Set<Property> realAttributes = new HashSet<Property>();

		if (isBlock(umlElement) || (isCompType(umlElement) || (isComponentImplementation(umlElement)))) {
			Class umlClass = (Class) umlElement;
			EList<Property> attributes = umlClass.getOwnedAttributes();
			for (Property umlProperty : attributes) {
				if (isRealAttribute(umlProperty)) {
					realAttributes.add(umlProperty);
				}
			}
		}

		if (isComponentInstance(umlElement)) {
			realAttributes.addAll(getRealAttributes(getUMLType((Property) umlElement)));
		}
		return realAttributes;
	}

	private Set<Property> getContinuousAttributes(Element umlElement) {
		Set<Property> continuousAttributes = new HashSet<Property>();

		if (isBlock(umlElement) || (isCompType(umlElement) || (isComponentImplementation(umlElement)))) {
			Class umlClass = (Class) umlElement;
			EList<Property> attributes = umlClass.getOwnedAttributes();
			for (Property umlProperty : attributes) {
				if (isContinuousAttribute(umlProperty)) {
					continuousAttributes.add(umlProperty);
				}
			}
		}

		if (isComponentInstance(umlElement)) {
			continuousAttributes.addAll(getContinuousAttributes(getUMLType((Property) umlElement)));
		}
		return continuousAttributes;
	}

	private Set<Property> getDoubleAttributes(Element umlElement) {
		Set<Property> doubleAttributes = new HashSet<Property>();

		if (isBlock(umlElement) || (isCompType(umlElement) || (isComponentImplementation(umlElement)))) {
			Class umlClass = (Class) umlElement;
			EList<Property> attributes = umlClass.getOwnedAttributes();
			for (Property umlProperty : attributes) {
				if (isDoubleAttribute(umlProperty)) {
					doubleAttributes.add(umlProperty);
				}
			}
		}

		if (isComponentInstance(umlElement)) {
			doubleAttributes.addAll(getDoubleAttributes(getUMLType((Property) umlElement)));
		}
		return doubleAttributes;
	}

	private Set<Property> getEnumerationAttributes(Element umlElement) {
		Set<Property> enumAttributes = new HashSet<Property>();

		if (isBlock(umlElement) || (isCompType(umlElement) || (isComponentImplementation(umlElement)))) {
			Class umlClass = (Class) umlElement;
			EList<Property> attributes = umlClass.getOwnedAttributes();
			for (Property umlProperty : attributes) {
				if (isEnumerationAttribute(umlProperty)) {
					enumAttributes.add(umlProperty);
				}
			}
		}

		if (isComponentInstance(umlElement)) {
			enumAttributes.addAll(getEnumerationAttributes(getUMLType((Property) umlElement)));
		}
		return enumAttributes;
	}

	private Set<Property> getRangeAttributes(Element umlElement) {
		Set<Property> rangeAttributes = new HashSet<Property>();

		if (isBlock(umlElement) || (isCompType(umlElement) || (isComponentImplementation(umlElement)))) {
			Class umlClass = (Class) umlElement;
			EList<Property> attributes = umlClass.getOwnedAttributes();
			for (Property umlProperty : attributes) {
				if (isRangeAttribute(umlProperty)) {
					rangeAttributes.add(umlProperty);
				}
			}
		}

		if (isComponentInstance(umlElement)) {
			rangeAttributes.addAll(getRangeAttributes(getUMLType((Property) umlElement)));
		}
		return rangeAttributes;
	}
	
	private String[] getOwnerAttributesNames(Class contract) {

		Set<String> attrArr = getAttributesNamesExceptsPorts(contract.getOwner());
		return toArray(attrArr);
	}*/
}
