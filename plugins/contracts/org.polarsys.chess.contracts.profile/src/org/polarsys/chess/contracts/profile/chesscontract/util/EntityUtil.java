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

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
//import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.BoundedSubtype;
import org.eclipse.papyrus.sysml.portandflows.FlowDirection;
import org.eclipse.papyrus.sysml.portandflows.FlowPort;
import org.eclipse.papyrus.uml.tools.utils.UMLUtil;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
//import org.polarsys.chess.contracts.profile.chesscontract.util.ContractEntityUtil;

/**
 * Util class that provides methods to manage SysML/CHESS/MARTE objects.
 *
 */
public class EntityUtil {

	private static final String BLOCK = "SysML::Blocks::Block";
	private static final String SYSTEM = "CHESSContract::System";
	private static final String FLOW_Port = "SysML::PortAndFlows::FlowPort";
	private static final String FLOW_Port_MARTE = "MARTE::MARTE_DesignModel::GCM::FlowPort";
	private static final String BOUNDED_TYPE = "MARTE::MARTE_Annexes::VSL::DataTypes::BoundedSubtype";
	private static final String COMP_TYPE = "CHESS::ComponentModel::ComponentType";
	private static final String COMP_IMPL = "CHESS::ComponentModel::ComponentImplementation";

	private static EntityUtil entityUtil;
	private static ContractEntityUtil contractEntityUtil = ContractEntityUtil.getInstance();

	public static EntityUtil getInstance() {
		if (entityUtil == null) {
			entityUtil = new EntityUtil();
		}
		return entityUtil;
	}

	public String getComponentID(Object umlComponent) {

		if (
		// isSystem((Element) umlComponent)||
		(isBlock((Element) umlComponent))) {
			return ((Class) umlComponent).getName();
		}

		if (isComponentInstance((Element) umlComponent)) {
			return (((Property) umlComponent).getName());
		}

		return null;
	}

	public String getComponentName(Object umlComponent) {

		if (
		// isSystem((Element) umlComponent)||
		(isBlock((Element) umlComponent))) {
			return ((Class) umlComponent).getName();
		}

		if (isComponentInstance((Element) umlComponent)) {
			return (((Property) umlComponent).getName());
		}

		return null;
	}

	public EList<Property> getSubComponents(Class umlComponent) {
		EList<Property> subComponents = new BasicEList<Property>();
		for (Property umlProperty : ((Class) umlComponent).getAttributes()) {
			if (isComponentInstance(umlProperty)) {
				subComponents.add(umlProperty);
			}
		}
		return subComponents;
	}

	public EList<String> getSubComponentsNames(Class umlComponent) {

		EList<String> subComponentsNames = new BasicEList<String>();
		for (Property umlProperty : getSubComponents(umlComponent)) {
			subComponentsNames.add((umlProperty).getName());
		}
		return subComponentsNames;
	}

	public EList<Port> getUmlPorts(Element umlElement, int portDirection) {
		EList<Port> portsArr = new BasicEList<Port>();
		if (isBlock(umlElement)) {
			portsArr.addAll(getUmlPortsFromClass((Class) umlElement, portDirection));
		}

		if (isCompType(umlElement) || (isComponentImplementation(umlElement))) {
			portsArr.addAll(getUmlPortsFromComponent((Component) umlElement, portDirection));
		}

		if (isComponentInstance(umlElement)) {
			portsArr.addAll(getUmlPorts(getUmlType((Property) umlElement), portDirection));
		}
		return portsArr;

	}

	private EList<Port> getUmlPortsFromClass(Class umlComponent, int portDirection) {
		EList<Port> ports = new BasicEList<Port>();
		for (Port umlPort : umlComponent.getOwnedPorts()) {
			FlowPort fp = getFlowPort(umlPort);
			if (fp.getDirection().getValue() == portDirection) {
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

	private EList<Port> getUmlPortsFromComponent(Component umlComponent, int portDirection) {
		EList<Port> ports = new BasicEList<Port>();

		for (Port umlPort : umlComponent.getOwnedPorts()) {
			org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowPort fp = getFlowPortMarte(umlPort);
			if (fp.getDirection().getValue() == portDirection) {
				ports.add(umlPort);
			}
		}
		return ports;
	}

	public org.eclipse.uml2.uml.Package getToPackage(org.eclipse.uml2.uml.Element umlElememt) {

		org.eclipse.uml2.uml.Package tmp = umlElememt.getNearestPackage();
		while (tmp.getOwner() != null && (tmp.getOwner() instanceof Package)) {
			tmp = (org.eclipse.uml2.uml.Package) tmp.getOwner();
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
		return isFlowPort(umlElement) || isFlowPortMarte(umlElement);
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
		if (contractEntityUtil.isContractProperty(umlProperty)) {
			return false;
		}
		Type umlPropertyType = ((Property) umlProperty).getType();
		return (isBlock(umlPropertyType) || isComponentImplementation(umlPropertyType));
	}

	public boolean isBooleanAttribute(Property umlProperty) {
		if (umlProperty.getType() != null) {
			return (umlProperty.getType().getName().compareTo("Boolean") == 0);
		}
		return false;
	}

	public String[] getLowerUpperBoundsForRangeType(Property umlProperty) {
		BoundedSubtype boundedSubtype = getRangeAttribute(umlProperty.getType());
		String[] bounds = { boundedSubtype.getMinValue(), boundedSubtype.getMaxValue() };

		return bounds;
	}

	private BoundedSubtype getRangeAttribute(Type umlProperty) {
		Stereotype boundedStereo = UMLUtil.getAppliedStereotype(umlProperty, BOUNDED_TYPE, false);
		return (BoundedSubtype) umlProperty.getStereotypeApplication(boundedStereo);
	}

	public boolean isRangeAttribute(Property umlProperty) {
		if (umlProperty.getType() != null) {

			if (UMLUtil.getAppliedStereotype(umlProperty.getType(), BOUNDED_TYPE, false) != null) {
				System.out.println("true");
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

	public boolean isIntegerAttribute(Property umlProperty) {
		if (umlProperty.getType() != null) {
			return (umlProperty.getType().getName().compareTo("Integer") == 0);
		}
		return false;
	}

	public boolean isContinuousAttribute(Property umlProperty) {
		if (umlProperty.getType() != null) {
			return (umlProperty.getType().getName().compareTo("Continuous") == 0);
		}
		return false;
	}

	public Class getUmlType(Property umlProperty) {
		return ((Class) umlProperty.getType());
	}

	public boolean isBlock(Element umlClass) {
		return UMLUtil.getAppliedStereotype(umlClass, BLOCK, false) != null;
	}

	public boolean isCompType(Element umlComponent) {
		return UMLUtil.getAppliedStereotype(umlComponent, COMP_TYPE, false) != null;
	}

	public boolean isSystem(Element umlElement) {
		return UMLUtil.getAppliedStereotype(umlElement, SYSTEM, false) != null;
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

	public String[] getPortsNames(Element umlElement, int portDirection) {
		EList<String> portsNames = new BasicEList<String>();

		for (Port umlPort : getUmlPorts(umlElement, portDirection)) {
			portsNames.add(umlPort.getName());
		}

		String[] portsStrArr = new String[portsNames.size()];
		return portsNames.toArray(portsStrArr);
	}

	public String[] getInputPortsNames(Element umlElement) {		
		return getPortsNames(umlElement, FlowDirection.IN_VALUE);
	}
	
	public String[] getOutputPortsNames(Element umlElement) {		
		return getPortsNames(umlElement, FlowDirection.OUT_VALUE);
	}
	
	public String[] getInputOutputPortsNames(Element umlElement) {		
		return getPortsNames(umlElement, FlowDirection.INOUT_VALUE);
	}
	public EList<String> getBooleanAttributesNames(Element umlElement) {

		EList<String> booleanAttributesNames = new BasicEList<String>();
		for (Property umlProperty : getBooleanAttributes(umlElement)) {
			booleanAttributesNames.add(umlProperty.getName());
		}
		return booleanAttributesNames;
	}

	public EList<String> getBooleanAttributesNamesExceptsPorts(Element umlElement) {
		EList<String> booleanAttributesNames = new BasicEList<String>();
		for (Property umlProperty : getBooleanAttributesExceptsPorts(umlElement)) {
			booleanAttributesNames.add(umlProperty.getName());
		}
		return booleanAttributesNames;
	}

	public EList<Property> getBooleanAttributes(Element umlElement) {
		EList<Property> booleanAttributes = new BasicEList<Property>();

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
			booleanAttributes.addAll(getBooleanAttributes(getUmlType((Property) umlElement)));
		}
		return booleanAttributes;
	}

	public EList<Property> getBooleanAttributesExceptsPorts(Element umlElement) {
		EList<Property> booleanAttributes = new BasicEList<Property>();
		for (Property umlProperty : getBooleanAttributes(umlElement)) {
			if (!isPort(umlProperty)) {
				booleanAttributes.add(umlProperty);
			}
		}
		return booleanAttributes;
	}



}
