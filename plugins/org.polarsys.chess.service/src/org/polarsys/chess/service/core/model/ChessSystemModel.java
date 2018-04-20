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
package org.polarsys.chess.service.core.model;


import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.sysml.portandflows.FlowDirection;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.FunctionBehavior;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.polarsys.chess.contracts.profile.chesscontract.ContractProperty;
import org.polarsys.chess.contracts.profile.chesscontract.ContractRefinement;
import org.polarsys.chess.contracts.profile.chesscontract.util.ContractEntityUtil;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;

import eu.fbk.eclipse.standardtools.utils.core.model.AbstractSystemModel;

public class ChessSystemModel implements AbstractSystemModel {

	private static ChessSystemModel chessToOCRAModelRunner;

	public static ChessSystemModel getInstance() {
		if (chessToOCRAModelRunner == null) {
			chessToOCRAModelRunner = new ChessSystemModel();
		}
		return chessToOCRAModelRunner;
	}

	private final Logger logger = Logger.getLogger(ChessSystemModel.class);
	
	private ContractEntityUtil contractEntityUtil = ContractEntityUtil.getInstance();
	private EntityUtil entityUtil = EntityUtil.getInstance();

	@Override
	public String[] getLowerUpperBoundsForRangeType(Object rangeTypePort) {
		return entityUtil.getLowerUpperBoundsForRangeType((Port) rangeTypePort);
	}

	@Override
	public String[] getLowerUpperBoundsForRangeTypeParameter(Object rangeTypeParameter) {
		if (rangeTypeParameter instanceof Parameter) {
			return entityUtil.getLowerUpperBoundsForRangeType(((Parameter) rangeTypeParameter).getType());
		}
		return null;
	}	 
	
	@Override
	public String[] getValuesForEnumeratorType(Object enumTypePort) {
		return entityUtil.getValuesForEnumeratorType((Port) enumTypePort);
	}

	@Override
	public String[] getValuesForEnumeratorTypeParameter(Object enumTypeParameter) {
		return entityUtil.getValuesForEnumeratorTypeParameter((Parameter) enumTypeParameter);
	}

	@Override
	public String getComponentTypeName(Object component) {

		if(entityUtil.isBlock((Element) component)) {
			return entityUtil.getComponentName((Element)component);
		}
		return null;
	}



	@Override
	public boolean isRangeAttribute(Object port) {
		return entityUtil.isRangeAttribute((Property) port);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 *eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.dsl.run.model.ToolToOCRAModel#
	 * getContractsOfComponent(java.lang.Object)
	 */
	@Override
	public EList<?> getContractsOfComponent(Object component) {
		return contractEntityUtil.getContractProperties((Class) component);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 *eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.dsl.run.model.ToolToOCRAModel#
	 * getComponentType(java.lang.Object)
	 */
	@Override
	public String getComponentInstanceTypeName(Object component) {

if (entityUtil.isBlock((Element) component)) {
			return "";
		}

		if (entityUtil.isComponentInstance((Element) component)) {
			return ((Class) ((Property) component).getType()).getName();
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 *eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.dsl.run.model.ToolToOCRAModel#
	 * preCompileOperations(java.lang.Object)
	 */
	@Override
	public void preCompileOperations(Object component) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 *eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.dsl.run.model.ToolToOCRAModel#
	 * getPortName(java.lang.Object)
	 */
	@Override
	public String getPortName(Object port) {
		// return ((Port)port).getQualifiedName().replaceAll("::", "_");
		return entityUtil.getPortName((Port)port);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 *eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.dsl.run.model.ToolToOCRAModel#
	 * getConnectorName(java.lang.Object)
	 */
	@Override
	public String getConnectorName(Object connector) {
		if (((ConnectorEnd) connector).getRole() != null) {
			return ((ConnectorEnd) connector).getRole().getName();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 *eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.dsl.run.model.ToolToOCRAModel#
	 * getContractDefinitionsText(java.lang.Object)
	 */
	@Override
	public String getContractDefinitionsText(Object component) throws Exception {

		List<ContractProperty> listCp = null;
		if (entityUtil.isComponentInstance((Element) component)) {
			Class componentType = (Class) (((Property) component).getType());
			listCp = contractEntityUtil.getContractProperties(componentType);
		} else if ((// entityUtil.isSystem((Element) component)||
		(entityUtil.isBlock((Element) component)))) {
			listCp = contractEntityUtil.getContractProperties((Class) component);
		}
		String definitions = "";
		if(listCp!=null){
		for (ContractProperty contractProperty : listCp) {
			String currContract = contractEntityUtil.convertContractPropertyInStr(contractProperty);
			definitions = definitions.concat(currContract);
		}
		}
		return definitions;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 *eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.dsl.run.model.ToolToOCRAModel#
	 * getOrcaFormulaConstraintText(java.lang.Object)
	 */
	@Override
	public String getOrcaFormulaConstraintText(Object formulaConstraint) {
		return ((Constraint) formulaConstraint).getSpecification().stringValue();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 *eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.dsl.run.model.ToolToOCRAModel#
	 * getFormulaConstraints(java.lang.Object)
	 */
	@Override
	public EList<Constraint> getFormulaConstraints(Object component) {
		return contractEntityUtil.getConstraintsProperties((Element) component);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 *eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.dsl.run.model.ToolToOCRAModel#
	 * getInputPorts(java.lang.Object)
	 */
	@Override
	public EList<Port> getNonStaticInputPorts(Object component) {
		return new BasicEList<Port>(entityUtil.getUMLPorts((Element) component, FlowDirection.IN_VALUE,false));
	}

	@Override
	public EList<?> getNonStaticPorts(Object component) {
		return entityUtil.getUMLPorts((Element)component,false);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 *eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.dsl.run.model.ToolToOCRAModel#
	 * getParameterName(java.lang.Object)
	 */
	@Override
	public String getAttributeName(Object parameter) {
		return entityUtil.getAttributeName((Property)parameter);
		//return ((Property) parameter).getName();
	}

	@Override
	public String getUninterpretedFunctionName(Object function) {
		if (function instanceof FunctionBehavior) {
			return entityUtil.getFunctionBehaviorName((FunctionBehavior) function);
		}
		return null;
	}
	
	@Override
	public Object getUninterpretedFunctionType(Object function) {
		if (function instanceof FunctionBehavior) {
			return entityUtil.getFunctionBehaviorType((FunctionBehavior) function);
		}
		return null;
	}
	
	@Override
	public EList<?>	getUninterpretedFunctionParameters(Object function) {
		if (function instanceof FunctionBehavior) {
			return entityUtil.getFunctionBehaviorInputParameters((FunctionBehavior) function);
		}
		return null;
	}
	
	@Override
	public String getUninterpretedFunctionOwnerName(Object owner) {
		if (owner instanceof Element) {
			return entityUtil.getComponentName((Element) owner);
		}
		return null;
	}

	
	@Override
	public Object getUninterpretedFunctionOwner(Object function) {
		if (function instanceof FunctionBehavior) {
			return entityUtil.getFunctionBehaviorOwner((FunctionBehavior) function);
		}
		return null;
	}
	
	@Override
	public String getUninterpretedFunctionParameterName(Object parameter) {
		if (parameter instanceof Parameter) {
			return entityUtil.getParameterName((Parameter) parameter);
		}
		return null;
	}
	
	@Override
	public Object getUninterpretedFunctionParameterOwner(Object parameter) {
		if (parameter instanceof Parameter) {
			return entityUtil.getParameterOwner((Parameter) parameter);
		}
		return null;
		
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 *eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.dsl.run.model.ToolToOCRAModel#
	 * getParameters(java.lang.Object)
	 */
	/*@Override
	public EList<Property> getParameters(Object component) {
		return null;
		//return new BasicEList<Property>(entityUtil.getBooleanAttributesExceptPorts((Element) component));
	}*/

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 *eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.dsl.run.model.ToolToOCRAModel#
	 * getOutputPorts(java.lang.Object)
	 */
	@Override
	public EList<Port> getNonStaticOutputPorts(Object component) {
		int direction = FlowDirection.OUT_VALUE;
		return new BasicEList<Port>(entityUtil.getUMLPorts((Element) component, direction,false));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 *eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.dsl.run.model.ToolToOCRAModel#
	 * getGenericPorts(java.lang.Object)
	 */
	@Override
	public EList<Port> getNonStaticGenericPorts(Object component) {
		int direction = FlowDirection.INOUT_VALUE;
		return new BasicEList<Port>(entityUtil.getUMLPorts((Element) component, direction, false));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 *eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.dsl.run.model.ToolToOCRAModel#
	 * getConnectionSource(java.lang.Object)
	 */
	@Override
	public Object getConnectionSource(Object connection) throws Exception {

		ConnectorEnd source = ((Connector) connection).getEnds().get(0);
		ConnectorEnd target = ((Connector) connection).getEnds().get(1);
		Element sourceOwner = source.getPartWithPort();
		Element targetOwner = target.getPartWithPort();

		Element sourcePort = source.getRole();
		Element targetPort = target.getRole();

		if(sourcePort == null){
			throw new Exception("The connection '"+((Connector) connection).getName()+"' of the component '" +entityUtil.getComponentName(entityUtil.getOwner((Connector)connection))+"' does not have a source port");
		}
		
		if(targetPort == null){
			throw new Exception("The connection '"+((Connector) connection).getName()+"' of the component '" +entityUtil.getComponentName(entityUtil.getOwner((Connector)connection))+"' does not have a target port");
		}
		
		Integer sourceDir = entityUtil.getPortDirection(sourcePort);
		Integer targetDir = entityUtil.getPortDirection(targetPort);

		if(sourceDir == null){
			throw new Exception("The source port of the connection '"+((Connector) connection).getName()+"' of the component '" +entityUtil.getComponentName(entityUtil.getOwner((Connector)connection))+"' does not have assiociated a port");
		}
		
		if(targetDir == null){
			throw new Exception("The target port of the connection '"+((Connector) connection).getName()+"' of the component '" +entityUtil.getComponentName(entityUtil.getOwner((Connector)connection))+"' does not have assiociated a port");
			}
		
		if ((sourceOwner == null) && (sourceDir == FlowDirection.IN_VALUE)) {
			return source;
		}
		if ((targetOwner == null) && (targetDir == FlowDirection.IN_VALUE)) {
			return target;
		}
		if ((sourceOwner != null) && (sourceDir == FlowDirection.OUT_VALUE)) {
			return source;
		}
		if ((targetOwner != null) && (targetDir == FlowDirection.OUT_VALUE)) {
			return target;
		}

	
		return ((Connector) connection).getEnds().get(0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 *eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.dsl.run.model.ToolToOCRAModel#
	 * getConnectionTarget(java.lang.Object)
	 */
	@Override
	public Object getConnectionTarget(Object connection) throws Exception {

		ConnectorEnd source = ((Connector) connection).getEnds().get(0);
		ConnectorEnd target = ((Connector) connection).getEnds().get(1);
		Element sourceOwner = source.getPartWithPort();
		Element targetOwner = target.getPartWithPort();

	
		Element sourcePort = source.getRole();
		Element targetPort = target.getRole();

		if(sourcePort == null){
			throw new Exception("The connection '"+((Connector) connection).getName()+"' of the component '" +entityUtil.getComponentName(entityUtil.getOwner((Connector)connection))+"' does not have a source port");
		}
		
		if(targetPort == null){
			throw new Exception("The connection '"+((Connector) connection).getName()+"' of the component '" +entityUtil.getComponentName(entityUtil.getOwner((Connector)connection))+"' does not have a target port");
		}
		
		Integer sourceDir = entityUtil.getPortDirection(sourcePort);
		Integer targetDir = entityUtil.getPortDirection(targetPort);

		if(sourceDir == null){
			throw new Exception("The source port of the connection '"+((Connector) connection).getName()+"' of the component '" +entityUtil.getComponentName(entityUtil.getOwner((Connector)connection))+"' does not have assiociated a port");
		}
		
		if(targetDir == null){
			throw new Exception("The target port of the connection '"+((Connector) connection).getName()+"' of the component '" +entityUtil.getComponentName(entityUtil.getOwner((Connector)connection))+"' does not have assiociated a port");
			}
		
		
	
		if ((sourceOwner == null) && (sourceDir == FlowDirection.OUT_VALUE)) {
			return source;
		}
		if ((targetOwner == null) && (targetDir == FlowDirection.OUT_VALUE)) {
			return target;
		}
		if ((sourceOwner != null) && (sourceDir == FlowDirection.IN_VALUE)) {
			return source;
		}
		if ((targetOwner != null) && (targetDir == FlowDirection.IN_VALUE)) {
			return target;
		}

		return ((Connector) connection).getEnds().get(1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 *eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.dsl.run.model.ToolToOCRAModel#
	 * getConnectionsPorts(java.lang.Object)
	 */
	@Override
	public EList<Connector> getConnectionsPorts(Object component) {
		if (
		// entityUtil.isSystem((Element) component)||
		(entityUtil.isBlock((Element) component))) {
			return ((Class) component).getOwnedConnectors();
		} else if (entityUtil.isComponentInstance((Element) component)) {
			return ((Class) ((Property) component).getType()).getOwnedConnectors();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 *eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.dsl.run.model.ToolToOCRAModel#
	 * getSourceConnectorOwner(java.lang.Object)
	 */
	@Override
	public Object getSourceConnectorOwner(Object connector) {
		if (connector != null) {
			return ((ConnectorEnd) connector).getPartWithPort();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 *eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.dsl.run.model.ToolToOCRAModel#
	 * getTargetConnectorOwner(java.lang.Object)
	 */
	@Override
	public Object getTargetConnectorOwner(Object connector) {
		if (connector != null) {
			return ((ConnectorEnd) connector).getPartWithPort();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 *eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.dsl.run.model.ToolToOCRAModel#
	 * getComponentInstanceName(java.lang.Object)
	 */
	@Override
	public String getComponentInstanceName(Object component) {
		if (entityUtil.isComponentInstance((Element) component)) {
			return ((Property) component).getName().replaceAll("::", "_");
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 *eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.dsl.run.model.ToolToOCRAModel#
	 * getContract(java.lang.Object, java.lang.String)
	 */
	@Override
	public Object getContract(Object component, String contractName) {
		if (entityUtil.isComponentInstance((Element) component)) {
			Class compClass = ((Class) ((Property) component).getType());
			return contractEntityUtil.getContractProperty(contractEntityUtil
					.getUmlContractPropertyOfUmlComponentFromContractPropertyType(compClass, contractName));
		} else if (
		// entityUtil.isSystem((Element) component)||
		(entityUtil.isBlock((Element) component))) {
			logger.debug("1 component: "+component);
			logger.debug("1 contractName: "+contractName);
			Property property = contractEntityUtil
			.getUmlContractPropertyOfUmlComponentFromContractPropertyType((Class) component, contractName);
			if(property!=null){
			return contractEntityUtil.getContractProperty(property);
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 *eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.dsl.run.model.ToolToOCRAModel#
	 * getContractName(java.lang.Object)
	 */
	@Override
	public String getContractInstanceName(Object contractProperty) throws Exception {
		
		
		if (contractProperty instanceof ContractProperty) {
			Type contractType = ((ContractProperty) contractProperty).getBase_Property().getType();

			if (contractType != null) {
				return ((ContractProperty) contractProperty).getBase_Property().getType().getName();
			} else {
				throw new Exception(
						"The ContractProperty \"" + ((ContractProperty) contractProperty).getBase_Property().getName()
								+ "\" does not have a type.");
			}
		} else {
			throw new Exception("The element \"" + contractProperty + "\" is not a contract property.");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 *eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.dsl.run.model.ToolToOCRAModel#
	 * getComponentName(java.lang.Object)
	 */
	@Override
	public String getComponentName(Object component) {
		return entityUtil.getComponentName((Element)component);
	}

	
	
	@Override
	public String getContractQualifiedName(Object contract) {
		return contractEntityUtil.getContractQualifiedName((Class)contract);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 *eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.dsl.run.model.ToolToOCRAModel#
	 * getContractRefinements(java.lang.Object)
	 */
	@Override
	public EList<ContractRefinement> getContractRefinements(Object parentContract) {
		return ((ContractProperty) parentContract).getRefinedBy();
	}

	
	
	@Override
	public String getContractRefinementName(Object contractRefinement) {
		return ((ContractRefinement) contractRefinement).getBase_DataType().getName();
	}



	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 *eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.dsl.run.model.ToolToOCRAModel#
	 * getComponentOfContractRefinement(java.lang.Object)
	 */
	@Override
	public Object getComponentOfContractRefinement(Object contractRefinement) {
		return ((ContractRefinement) contractRefinement).getInstance();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 *eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.dsl.run.model.ToolToOCRAModel#
	 * getContractOfContractRefinement(java.lang.Object)
	 */
	@Override
	public Object getContractInstanceOfContractRefinement(Object contractRefinement) {
		return ((ContractRefinement) contractRefinement).getContract();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 *eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.dsl.run.model.ToolToOCRAModel#
	 * isBooleanType(java.lang.Object)
	 */
	@Override
	public boolean isBooleanAttribute(Object port_or_parameter) {
		return entityUtil.isBooleanAttribute((Property) port_or_parameter);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 *eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.dsl.run.model.ToolToOCRAModel#
	 * isDoubleType(java.lang.Object)
	 */
	@Override
	public boolean isDoubleAttribute(Object port_or_parameter) {
		return entityUtil.isDoubleAttribute((Property) port_or_parameter);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 *eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.dsl.run.model.ToolToOCRAModel#
	 * isRealType(java.lang.Object)
	 */
	@Override
	public boolean isRealAttribute(Object port_or_parameter) {
		return entityUtil.isRealAttribute((Property) port_or_parameter);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 *eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.dsl.run.model.ToolToOCRAModel#
	 * isIntType(java.lang.Object)
	 */
	@Override
	public boolean isIntAttribute(Object port_or_parameter) {
		return entityUtil.isIntegerAttribute((Property) port_or_parameter);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 *eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.dsl.run.model.ToolToOCRAModel#
	 * isContinuousType(java.lang.Object)
	 */
	@Override
	public boolean isContinuousAttribute(Object port_or_parameter) {
		return entityUtil.isContinuousAttribute((Property) port_or_parameter);
	}

	
	
	@Override
	public boolean isEnumAttribute(Object port_or_parameter) {
		return entityUtil.isEnumerationAttribute((Property) port_or_parameter);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 *eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.dsl.run.model.ToolToOCRAModel#
	 * getSubComponents(java.lang.Object)
	 */
	@Override
	public EList<Property> getSubComponentsInstances(Object component) {
		if ((
		// entityUtil.isSystem((Element) component)||
		(entityUtil.isBlock((Element) component)))) {
			return new BasicEList<Property>(entityUtil.getSubComponentsInstances((Class) component));
		} else if (entityUtil.isComponentInstance((Element) component)) {
			return new BasicEList<Property>(entityUtil.getSubComponentsInstances((Class) ((Property) component).getType()));
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 *eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.dsl.run.model.ToolToOCRAModel#
	 * isContractOwnerEqualToComponent(java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean isContractInstanceOwnerEqualToComponent(Object contract, Object component) {
		
		logger.debug("isContractInstanceOwnerEqualToComponent, contractProperty name: "+((ContractProperty) contract).getBase_Property().getName());
		
		Element contractOwner = entityUtil
		.getOwner(((ContractProperty) contract).getBase_Property());
		
		logger.debug("contract owner: "+((Class)contractOwner).getName());
		
		Element componentType = (((Property) component).getType());
		
		logger.debug("component type: "+((Class)componentType).getName());
		
		return contractOwner == componentType;
	}



	@Override
	public boolean isEventAttribute(Object attribute) {
		return entityUtil.isEventPortAttribute((Property)attribute);
	}



	@Override
	public String getAttributeOwnerName(Object attribute) {
		return entityUtil.getComponentName(entityUtil.getOwner((Element)attribute));
	}



	@Override
	public boolean isNullAttribute(Object attribute) {
		return (((Property)attribute).getType() == null);
	}



	@Override
	public boolean isInputPort(Object port) {
		return entityUtil.isInputPort((Port)port);
	}



	@Override
	public boolean isOutputPort(Object port) {
		return entityUtil.isOutputPort((Port)port);
	}



	@Override
	public boolean isInOutPort(Object port) {
		return entityUtil.isInOutPort((Port)port);
	}



	@Override
	public boolean isNumberAttribute(Object attribute) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean isWordAttribute(Object attribute) {
		return entityUtil.isStringAttribute((Property)attribute);
		
	}



	@Override
	public String getVariableName(Object attribute) {
		return entityUtil.getAttributeName((Property)attribute);
}



	@Override
	public String getFormalPropertyName(Object formalProperty) {
		return contractEntityUtil.getFormalPropertyName(formalProperty);
	}

	@Override
	public EList<?> getOwnerNonStaticPorts(Object formalProperty) {
		
		Element owner = entityUtil.getOwner((Element)formalProperty);
		
		if(!(owner instanceof Class)){
			return null;
		}
		//block added to manage formal properties with contract as owner
		if(contractEntityUtil.isContract(owner)){
			owner = (Class)entityUtil.getOwner(owner);
		}
		return entityUtil.getUMLPorts(owner,false);		
	}

/*	
	//@Override
	private Set<?> getOwnerVariables(Object formalProperty) {
		Element owner = (Element)entityUtil.getOwner((Element)formalProperty);
		
		if(!(owner instanceof Class)){
			return null;
		}
		//block added to manage formal properties with contract as owner
		if(contractEntityUtil.isContract(owner)){
			owner = (Class)entityUtil.getOwner(owner);
		}
		//FIXME use instead entityUtil.getStaticPorts
		//return entityUtil.getAttributes(owner);
		return null;
	}*/

	@Override
	public String[] getEnumValuesFromOwnerAttributes(Object formalProperty) {
		Element owner = (Element)entityUtil.getOwner((Element)formalProperty);
		
		if(!(owner instanceof Class)){
			return null;
		}
		//block added to manage formal properties with contract as owner
		if(contractEntityUtil.isContract(owner)){
			owner = (Class)entityUtil.getOwner(owner);
		}
		//return entityUtil.getEnumValuesFromComponentPorts(element);	
		return entityUtil.getEnumValuesFromComponentAttributes((Class)owner);
	}



	@Override
	public String[] getSubComponentsName(Object constraint) {
		return entityUtil.getSubComponentsNameOfConstraintOwner((Constraint)constraint);
	}



	@Override
	public Object getSubComponent(Object constraint, String subCompName) {
		return entityUtil.getSubComponentOfConstraintOwner((Constraint)constraint, subCompName);
	}


	@Override
	public String getConstraintQualifiedName(Object constraint) {
		return entityUtil.getQualifiedName((NamedElement)constraint);
	}



	@Override
	public String getComponentQualifiedName(Object component) {
		return entityUtil.getQualifiedName((NamedElement)component);
	}



	/*@Override
	public String[] getEnumValuesFromOwnerPorts(Object port_or_parameter) {
		Element owner = entityUtil.getOwner((Element)port_or_parameter);
		
		if(!(owner instanceof Class)){
			return null;
		}
		
		if(contractEntityUtil.isContract(owner)){
			owner = (Class)entityUtil.getOwner(owner);
		}
		return entityUtil.getEnumValuesFromComponentPorts((Class)owner);	
	}*/



	@Override
	public EList<?> getOwnerStaticPorts(Object element) {
		Element owner = entityUtil.getOwner((Element)element);

		if(!(owner instanceof Class)){
			return null;
		}
		//block added to manage formal properties with contract as owner
		if(contractEntityUtil.isContract(owner)){
			owner = (Class)entityUtil.getOwner(owner);
		}
		return entityUtil.getUMLPorts(owner,true);	
	}



	@Override
	public EList<?> getStaticPorts(Object component) {
		return entityUtil.getUMLPorts((Element)component,true);
	}
	
	

	@Override
	public EList<?> getUninterpretedFunctions(Object component) {
		if (entityUtil.isBlock((Element) component)) {
			return ((Class) component).getOwnedBehaviors();
		} else if (entityUtil.isComponentInstance((Element) component)) {
			return ((Class) ((Property) component).getType()).getOwnedBehaviors();
		}
		return null;
	}

	
	
	@Override
	public boolean isNullParameter(Object parameter) {
		if (parameter instanceof Parameter) {
			return (((Parameter) parameter).getType() == null);
		}
		return false;
	}



	@Override
	public boolean isBooleanParameter(Object parameter) {
		if (parameter instanceof Parameter) {
			return entityUtil.isBooleanParameter((Parameter) parameter);
		}
		return false;
	}



	@Override
	public boolean isContinuousParameter(Object parameter) {
		if (parameter instanceof Parameter) {
			return entityUtil.isContinuousParameter((Parameter) parameter);
		}
		return false;
	}



	@Override
	public boolean isDoubleParameter(Object parameter) {
		if (parameter instanceof Parameter) {
			return entityUtil.isDoubleParameter((Parameter) parameter);
		}
		return false;
	}



	@Override
	public boolean isRealParameter(Object parameter) {
		if (parameter instanceof Parameter) {
			return entityUtil.isRealParameter((Parameter) parameter);
		}
		return false;
	}


	@Override
	public boolean isIntParameter(Object parameter) {
		if (parameter instanceof Parameter) {
			return entityUtil.isIntegerParameter((Parameter) parameter);
		}
		return false;
	}



	@Override
	public boolean isRangeParameter(Object parameter) {
		if (parameter instanceof Parameter) {
			return entityUtil.isRangeParameter((Parameter) parameter);
		}
		return false;
	}



	@Override
	public boolean isEnumParameter(Object parameter) {
		if (parameter instanceof Parameter) {
			return entityUtil.isEnumerationParameter((Parameter) parameter);
		}
		return false;
	}



	@Override
	public boolean isEventParameter(Object parameter) {
		if (parameter instanceof Parameter) {
			return entityUtil.isEventParameter((Parameter) parameter);
		}
		return false;
	}
}
