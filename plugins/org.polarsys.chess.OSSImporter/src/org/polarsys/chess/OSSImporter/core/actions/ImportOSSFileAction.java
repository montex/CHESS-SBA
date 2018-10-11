/*******************************************************************************
 * Copyright (C) 2018 Fondazione Bruno Kessler.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *     Luca Cristoforetti - initial API and implementation
 ******************************************************************************/
package org.polarsys.chess.OSSImporter.core.actions;

import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.FunctionBehavior;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.DataType;
import org.polarsys.chess.OSSImporter.core.exceptions.ImportException;
import org.polarsys.chess.OSSImporter.core.utils.ChessElementsUtil;
import org.polarsys.chess.OSSImporter.core.utils.OssTypeTranslator;
import org.polarsys.chess.OSSImporter.core.utils.StereotypeUtil;
import org.polarsys.chess.contracts.profile.chesscontract.ContractProperty;
import org.polarsys.chess.contracts.profile.chesscontract.ContractRefinement;
import org.polarsys.chess.contracts.profile.chesscontract.FormalProperty;
import org.polarsys.chess.contracts.profile.chesscontract.util.ContractEntityUtil;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;
import org.polarsys.chess.service.core.model.ChessSystemModel;
import org.polarsys.chess.service.gui.utils.SelectionUtil;

import com.google.common.collect.Maps;

import eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.core.services.OSSModelFactory;
import eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.core.utils.OSSModelUtil;
import eu.fbk.eclipse.standardtools.utils.core.utils.StringArrayUtil;
import eu.fbk.tools.editor.basetype.baseType.*;
import eu.fbk.tools.editor.contract.contract.Assumption;
import eu.fbk.tools.editor.contract.contract.Contract;
import eu.fbk.tools.editor.contract.contract.Guarantee;
import eu.fbk.tools.editor.contract.expression.expression.FullParameterId;
import eu.fbk.tools.editor.contract.expression.expression.FullVariableId;
import eu.fbk.tools.editor.oss.oss.SystemComponent;
import eu.fbk.tools.editor.oss.oss.Variable;
import eu.fbk.tools.editor.oss.oss.AbstractComponent;
import eu.fbk.tools.editor.oss.oss.Assertion;
import eu.fbk.tools.editor.oss.oss.ComplexType;
import eu.fbk.tools.editor.oss.oss.Component;
import eu.fbk.tools.editor.oss.oss.Connection;
import eu.fbk.tools.editor.oss.oss.FullContractIdList;
import eu.fbk.tools.editor.oss.oss.InputPort;
import eu.fbk.tools.editor.oss.oss.Interface;
import eu.fbk.tools.editor.oss.oss.InterfaceInstance;
import eu.fbk.tools.editor.oss.oss.IterativeCondition;
import eu.fbk.tools.editor.oss.oss.OSS;
import eu.fbk.tools.editor.oss.oss.OutputPort;
import eu.fbk.tools.editor.oss.oss.Port;
import eu.fbk.tools.editor.oss.oss.RefinedBy;
import eu.fbk.tools.editor.oss.oss.Operation;
import eu.fbk.tools.editor.oss.oss.Parameter;
import eu.fbk.tools.editor.oss.oss.ParameterAssumptions;
import eu.fbk.tools.editor.oss.oss.Refinement;
import eu.fbk.tools.editor.oss.oss.RefinementInstance;
import eu.fbk.tools.editor.oss.oss.SubComponent;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.papyrus.sysml.portandflows.FlowDirection;

/**
 * This class takes as input a file in OCRA format and creates the equivalent
 * CHESS model.
 * 
 * @author cristofo
 *
 */
public class ImportOSSFileAction {

	private static boolean validateSerializedElements = false;
	// The instance of this class
	private static ImportOSSFileAction classInstance;

	private final ChessSystemModel chessSystemModel = ChessSystemModel.getInstance();
	private final ContractEntityUtil contractEntityUtil = ContractEntityUtil.getInstance();
	private final EntityUtil entityUtil = EntityUtil.getInstance();

	// FIXME think how to manage this class
	private final StereotypeUtil stereotypeUtil = StereotypeUtil.getInstance();
	private final ChessElementsUtil chessElementsUtil = ChessElementsUtil.getInstance();
	private OSSModelUtil ossModelUtil = OSSModelUtil.getInstance();
	private OssTypeTranslator ossTypeTranslator = OssTypeTranslator.getInstance();

	// Will contain elements being added to the model, big enough
	private final EList<Element> addedElements = new BasicEList<>(2000);

	private Package sysView = null;

	// Map the name of the component with the Component object
	private Map<String, Class> dslTypeToComponent;

	// A possible exception that could happen during parsing
	private ImportException importException;

	// Logger for messages
	private static final Logger logger = Logger.getLogger(ImportOSSFileAction.class);

	// Error messages during parsing
	private StringBuffer importErrors;

	/**
	 * Gets an instance of the class if already present, or a new one if not.
	 * 
	 * @return the instance of this class
	 */
	public static ImportOSSFileAction getInstance() {
		if (classInstance == null) {
			classInstance = new ImportOSSFileAction();
		}
		return classInstance;
	}

	/**
	 * Checks if the given expression refers to a function behavior
	 * 
	 * @param owner
	 *            the owner element
	 * @param expression
	 *            the expression defining the function behavior
	 * @return
	 * @throws Exception
	 */
	private boolean isFunctionBehavior(Class owner, Expression expression) throws ImportException {
		if (expression instanceof FullVariableId) {
			final FullVariableId variable = (FullVariableId) expression;

			Class component = null;

			// Get the name of the owner of the behavior, if present find the
			// type
			String variableOwnerName = ossModelUtil.getNearestComponentName(variable);
			if (variableOwnerName != null) {

				// Retrieve the component instance containing the behavior
				final Property behaviorOwner = entityUtil.getUmlComponentInstance(owner, variableOwnerName);

				if (behaviorOwner.getType() != null) {
					// Get the component type
					final String typeName = behaviorOwner.getType().getName();

					// Get the component object containing the definition of the
					// port
					component = dslTypeToComponent.get(typeName);
				} else {
					throw new ImportException(variableOwnerName + " has no type");
				}
			}

			if (variableOwnerName == null) {

				// I'm the owner of the functionBehavior
				component = owner;
			}
			return (component.getOwnedBehavior(variable.getId().getName()) != null);
		}
		return false;
	}

	/**
	 * Returns the first item contained in the tag
	 * 
	 * @param tag
	 *            the tag to be processed
	 * @return the unknown text
	 */
	private String getTextOfTag(EObject tag) {
		return (ossModelUtil.getOssElementAsString(tag, validateSerializedElements, true).split(" ")[0]);
	}

	/**
	 * Parses the Refinements of the component.
	 * 
	 * @param dslParentComponent
	 *            the AST Component owning the refinement
	 * @param dslComponentRefinement
	 *            the Refinement element to be parsed
	 * @throws Exception
	 */
	private void parseRefinements(AbstractComponent dslParentComponent, Refinement dslComponentRefinement)
			throws ImportException {

		// Get all the RefinementInstances of the Refinement
		final EList<RefinementInstance> dslRefInstances = dslComponentRefinement.getRefinements();

		final Class owner = dslTypeToComponent.get(dslParentComponent.getType());

		// Get all the existing component instances of the element
		EList<Property> existingComponentInstances = (EList<Property>) chessSystemModel
				.getSubComponentsInstances(owner);

		// Prepare the map to mark existing component instances
		HashMap<String, Boolean> mapComponentInstancesToKeep = Maps
				.newHashMapWithExpectedSize(existingComponentInstances.size());
		for (Property componentInstance : existingComponentInstances) {
			mapComponentInstancesToKeep.put(componentInstance.getQualifiedName(), null);
		}

		// Get all the existing connectors of the element
		// Doing a copy because the list will otherwise increase as soon as a
		// connector is created
		EList<Connector> existingConnectors = new BasicEList<Connector>(owner.getOwnedConnectors());
		// EList<Connector> connectors = owner.getOwnedConnectors();

		// Prepare the map to mark existing connectors
		HashMap<String, Boolean> mapConnectorsToKeep = Maps.newHashMapWithExpectedSize(existingConnectors.size());
		for (Connector connector : existingConnectors) {
			mapConnectorsToKeep.put(connector.getQualifiedName(), null);
		}

		// Get all the existing delegation contraints of the element
		EList<Constraint> existingDelegationConstraints = entityUtil.getDelegationConstraintsAsUMLConstraints(owner);

		// Prepare the map to mark existing delegation contraints
		HashMap<String, Boolean> mapDelegationContraintsToKeep = Maps
				.newHashMapWithExpectedSize(existingDelegationConstraints.size());
		for (Constraint delegationConstraint : existingDelegationConstraints) {
			mapDelegationContraintsToKeep.put(delegationConstraint.getQualifiedName(), null);
		}

		// Get all the contract refinements of the element
		EList<DataType> existingContractRefinements = entityUtil.getDataTypes(owner);

		// Prepare the map to mark existing contract refinements
		HashMap<String, Boolean> mapContractRefinementsToKeep = Maps
				.newHashMapWithExpectedSize(existingContractRefinements.size());
		for (Classifier contractRefinement : existingContractRefinements) {
			mapContractRefinementsToKeep.put(contractRefinement.getQualifiedName(), null);
		}

		// Get all the refinement formal properties
		@SuppressWarnings("unchecked")
		final EList<Constraint> existingFormalProperties = (EList<Constraint>) chessSystemModel
				.getRefinementAssertions(owner);

		// Prepare the map to mark existing formal properties
		final HashMap<String, Boolean> mapFormalPropertiesToKeep = Maps
				.newHashMapWithExpectedSize(existingFormalProperties.size());
		for (Constraint formalProperty : existingFormalProperties) {
			mapFormalPropertiesToKeep.put(formalProperty.getQualifiedName(), null);
		}

		// If some RefinementInstances are present, loop on them
		if ((dslRefInstances != null) && !dslRefInstances.isEmpty()) {
			for (RefinementInstance dslRefInstance : dslRefInstances) {

				// Process the different types of refinements
				if (containsSubComponent(dslRefInstance)) {

					parseSubComponent(dslRefInstance.getSubcomponent(), mapComponentInstancesToKeep, owner);

				} else if (containsConnection(dslRefInstance)) {
					logger.debug("parse connection");
					parseConnection(dslRefInstance.getConnection(), existingConnectors, existingDelegationConstraints,
							mapConnectorsToKeep, mapDelegationContraintsToKeep, owner);

				} else if (containsRefinedBy(dslRefInstance)) {

					parseRefinedBy(dslRefInstance.getRefinedby(), mapContractRefinementsToKeep, owner);

				} else if (containsFormula(dslRefInstance)) {

					// CONSTRAINT processing
					addImportError("Found a CONSTRAINT tag, don't know how to handle it!");
				} else if (containsProp(dslRefInstance)) {

					// PROP processing
					addImportError("Found a PROP tag, don't know how to handle it!");
				} else if (containsAssertion(dslRefInstance)) {
					parseRefinementAssertion(dslRefInstance.getAssertion(), mapFormalPropertiesToKeep, owner);
				} else if (dslRefInstance != null) {
					addImportError("Found a " + getTextOfTag(dslRefInstance) + " tag, don't know how to handle it!");
				}
			}
		}

		removeUnusedRefinementElements(mapComponentInstancesToKeep, existingComponentInstances, mapConnectorsToKeep,
				existingConnectors, mapDelegationContraintsToKeep, existingDelegationConstraints,
				mapContractRefinementsToKeep, existingContractRefinements, mapFormalPropertiesToKeep,
				existingFormalProperties);
	}

	private void removeUnusedRefinementElements(HashMap<String, Boolean> mapComponentInstancesToKeep,
			EList<Property> existingComponentInstances, HashMap<String, Boolean> mapConnectorsToKeep,
			EList<Connector> existingConnectors, HashMap<String, Boolean> mapDelegationContraintsToKeep,
			EList<Constraint> existingDelegationConstraints, HashMap<String, Boolean> mapContractRefinementsToKeep,
			EList<DataType> existingContractRefinements, HashMap<String, Boolean> mapFormalPropertiesToKeep,
			EList<Constraint> existingFormalProperties) {

		// Component instances cleanup time, associations will be removed
		// automatically
		for (String qualifiedElement : mapComponentInstancesToKeep.keySet()) {
			if (mapComponentInstancesToKeep.get(qualifiedElement) == null) {
				// System.out.println("component instance " + qualifiedElement +
				// " should be removed");
				entityUtil.removeProperty(existingComponentInstances, qualifiedElement);
			}
		}

		// Connectors cleanup time
		for (String qualifiedElement : mapConnectorsToKeep.keySet()) {
			if (mapConnectorsToKeep.get(qualifiedElement) == null) {
				// System.out.println("connector " + qualifiedElement + " should
				// be removed");
				entityUtil.removeConnector(existingConnectors, qualifiedElement);
			}
		}

		// Delegation constraints cleanup time
		for (String qualifiedElement : mapDelegationContraintsToKeep.keySet()) {
			if (mapDelegationContraintsToKeep.get(qualifiedElement) == null) {
				// System.out.println("delegation constraint " +
				// qualifiedElement + " should be removed");
				entityUtil.removeDelegationConstraint(existingDelegationConstraints, qualifiedElement);
			}
		}

		// Contract refinements cleanup time
		for (String qualifiedElement : mapContractRefinementsToKeep.keySet()) {
			if (mapContractRefinementsToKeep.get(qualifiedElement) == null) {
				// System.out.println("contract refinement " + qualifiedElement
				// + " should be removed");
				contractEntityUtil.removeContractRefinement(existingContractRefinements, qualifiedElement);
			}
		}

		// Formal properties cleanup time
		for (String qualifiedElement : mapFormalPropertiesToKeep.keySet()) {
			if (mapFormalPropertiesToKeep.get(qualifiedElement) == null) {
				// System.out.println("formalProperty " + qualifiedElement + "
				// should be removed");
				entityUtil.removeFormalProperty(existingFormalProperties, qualifiedElement);
			}
		}
	}

	private boolean containsAssertion(RefinementInstance dslRefInstance) {
		return dslRefInstance != null && dslRefInstance.getAssertion() != null;
	}

	private boolean containsProp(RefinementInstance dslRefInstance) {
		return dslRefInstance != null && dslRefInstance.getProp() != null;
	}

	private boolean containsFormula(RefinementInstance dslRefInstance) {
		return dslRefInstance != null && dslRefInstance.getFormula() != null;
	}

	private boolean containsRefinedBy(RefinementInstance dslRefInstance) {
		return dslRefInstance != null && dslRefInstance.getRefinedby() != null;
	}

	private boolean containsConnection(RefinementInstance dslRefInstance) {
		return dslRefInstance != null && dslRefInstance.getConnection() != null;
	}

	private boolean containsSubComponent(RefinementInstance dslRefInstance) {
		return dslRefInstance != null && dslRefInstance.getSubcomponent() != null;
	}

	private void parseRefinementAssertion(Assertion assertion, HashMap<String, Boolean> mapFormalPropertiesToKeep,
			Class owner) {

		// ASSERTION processing
		// final Assertion assertion = dslRefInstance.getAssertion();
		final String assertionName = assertion.getName();
		final String assertionText = ossModelUtil.getExpressionAsString(assertion.getConstraint(),
				validateSerializedElements);

		// Retrieve the formal property from the owner, if any
		// (working on the assertion name)
		Constraint umlConstraint = owner.getOwnedRule(assertionName);

		if (umlConstraint == null || !entityUtil.isFormalProperty(umlConstraint)) {
			logger.debug("Formal property non found, creating one");
			addedElements.add(entityUtil.createRefinementFormalProperty(owner, assertionName, assertionText));
		} else {
			if (entityUtil.isFormalProperty(umlConstraint)) {
				logger.debug("Formal property already present");
				chessElementsUtil.updateUmlRefinementFormalProperty(umlConstraint, assertionText,
						mapFormalPropertiesToKeep);
			}
		}

	}

	private void parseRefinedBy(RefinedBy refinedBy, HashMap<String, Boolean> mapContractRefinementsToKeep,
			Class owner) {

		// REFINEDBY processing
		// final RefinedBy refinement = dslRefInstance.getRefinedby();
		final String refinedContractTypeName = refinedBy.getName();

		logger.debug("\n\n\nContract name = " + refinedContractTypeName + " from " + owner.getName());

		// Get the instance of the contract, using a library
		// function
		final ContractProperty chessContractProperty = contractEntityUtil
				.getUmlContractPropertyOfUmlComponentFromContractPropertyType(owner, refinedContractTypeName);

		// Get the refinements linked to that contract property
		final EList<ContractRefinement> chessContractPropertyRefinements = chessSystemModel
				.getContractRefinements(chessContractProperty);

		// Loop on all the refinements to see if they already exist
		final EList<FullContractIdList> refiningContractIds = refinedBy.getFullContractIds();
		for (FullContractIdList refiningContractId : refiningContractIds) {

			String componentInstanceName = ossModelUtil
					.getNearestComponentInstanceNameFromFullContractId(refiningContractId);
			String[] componentInstanceRange = ossModelUtil
					.getNearestComponentInstanceRangeFromFullContractId(refiningContractId, validateSerializedElements);
			String componentInstanceIndex = ossModelUtil
					.getNearestComponentInstanceIndexFromFullContractId(refiningContractId, validateSerializedElements);

			String refinementNameOptSuffix = "";
			if (!StringArrayUtil.isUndefined(componentInstanceRange)) {
				refinementNameOptSuffix = refinementNameOptSuffix
						.concat("." + componentInstanceRange[0] + "_" + componentInstanceRange[1]);
			} else if (componentInstanceIndex != null) {
				refinementNameOptSuffix = refinementNameOptSuffix.concat("." + componentInstanceIndex);
			}

			// Compose the name that the contract refinement should
			// have
			final String refinementName = componentInstanceName + "." +
			// refiningContractProperty.getName()+
					getRefiningContractPropertyName(componentInstanceName, owner, refiningContractId.getName())
					+ refinementNameOptSuffix;

			// Check to see if the refinement is already linked to
			// the contract property
			boolean alreadyLinked = false;
			for (ContractRefinement contractRefinement : chessContractPropertyRefinements) {
				if (contractRefinement.getBase_DataType().getName().equals(refinementName)) {
					logger.debug("refinement already defined for the contract");

					// Set the flag to signal the contract
					// refinement is still used
					mapContractRefinementsToKeep.put(contractRefinement.getBase_DataType().getQualifiedName(),
							Boolean.TRUE);
					alreadyLinked = true;
					break;
				}
			}

			if (alreadyLinked) {
				continue; // Go to the next refinement
			} else {
				logger.debug("refinement not present");

				// Create a new refinement and add it to the
				// contract property
				final DataType umlRefinement = contractEntityUtil.getOrCreateContractRefinement(owner,
						componentInstanceName, componentInstanceRange, componentInstanceIndex,
						refiningContractId.getName(), stereotypeUtil.contractRefinementStereotype);
				contractEntityUtil.addContractRefinementToContractProperty(chessContractProperty, umlRefinement);

				// Store the new refinement
				addedElements.add(umlRefinement);
			}
		}

	}

	private String getRefiningContractPropertyName(String componentInstanceName, Class owner,
			String refiningContractTypeName) {
		final Class refiningComponent = (Class) entityUtil.getUmlComponentInstance(owner, componentInstanceName)
				.getType();

		logger.debug("refiningComponent: " + refiningComponent);
		logger.debug("contractId.getName(): " + refiningContractTypeName);

		// The refining contract property
		final Property refiningContractProperty = contractEntityUtil
				.getPropertyOfUmlComponentWithContractPropertyType(refiningComponent, refiningContractTypeName);

		logger.debug("refiningContractProperty.getName(): " + refiningContractProperty.getName());
		return refiningContractProperty.getName();
	}

	private void parseConnection(Connection connection, EList<Connector> existingConnectors,
			EList<Constraint> existingDelegationConstraints, HashMap<String, Boolean> mapConnectors,
			HashMap<String, Boolean> mapDelegationContraintsToKeep, Class owner) throws ImportException {

		boolean isConnectionWithNoArray = false;
		boolean isEnumValue=false;
		
		// CONNECTION processing
		// final Connection connection = dslRefInstance.getConnection();
		final FullVariableId variable = connection.getVariable();
		final Expression constraint = connection.getConstraint();
		final IterativeCondition iterCondition = connection.getIterativeCondition();
		if (ossModelUtil.isConnectionWithNoArray(variable, constraint, iterCondition)
				&& !isFunctionBehavior(owner, variable) && !isFunctionBehavior(owner, constraint)) {

			isConnectionWithNoArray=true;
			
			// Details of the connector ends
			String variablePortOwner = ossModelUtil.getNearestComponentName(variable);
			String variablePortName = ossModelUtil.getVariableIdAsString(variable.getId(),validateSerializedElements);
			String constraintPortOwner = ossModelUtil.getNearestComponentName((FullVariableId) constraint);
			String constraintPortName = ossModelUtil.getVariableIdAsString(((FullVariableId) constraint).getId(), validateSerializedElements);

			Connector connector = entityUtil.getExistingConnector(existingConnectors, variablePortOwner,
					variablePortName, constraintPortOwner, constraintPortName);

			if (connector != null) {
				logger.debug("connector already present");

				// Set the flag to signal the connector is still used
				mapConnectors.put(connector.getQualifiedName(), Boolean.TRUE);
				// continue;
				return;
			} else {

				logger.debug("connector is not present");
				Property partWithPortOfConstraint = getPartWithPort((FullVariableId) constraint, owner);
				final Class portOwnerOfConstraint = getPortOwner(partWithPortOfConstraint, owner);

				if(portOwnerOfConstraint.getOwnedPort(constraintPortName,null)==null){
					logger.debug("isEnumValue");
					isEnumValue=true;
				}else{
				
				Property partWithPortOfVariable = getPartWithPort((FullVariableId) variable, owner);
				final Class portOwnerOfVariable = getPortOwner(partWithPortOfVariable, owner);

				// Store the new connector
				addedElements.add(entityUtil.createUmlConnector(constraintPortName, partWithPortOfConstraint,
						portOwnerOfConstraint, variablePortName, partWithPortOfVariable, portOwnerOfVariable, owner));
				}
			}
		} 
		if(!isConnectionWithNoArray||isEnumValue){
		// It could be a delegation constraint, check it
		if (isEnumValue||isDelegationConstraint(variable, constraint,iterCondition, owner)) {
			logger.debug("isDelegationConstraint: "+ossModelUtil.getOssElementAsString(connection, validateSerializedElements, true));
			Constraint delegationConstraint = null;
			// String constraintText =
			// chessElementsUtil.getConstraintText(constraint);
			String constraintText = ossModelUtil.getExpressionAsString(constraint, validateSerializedElements);
			String variableIdText = ossModelUtil.getFullVariableIdAsString(variable, validateSerializedElements);
			String iterConditionText = null;
			if (iterCondition != null) {
				iterConditionText = ossModelUtil.getIterativeConditionAsString(iterCondition, validateSerializedElements);
			}
			if ((delegationConstraint = entityUtil.getExistingDelegationConstraint(existingDelegationConstraints,
					variableIdText, iterConditionText, constraintText)) != null) {
				logger.debug("delegation constraint already present");

				// Set the flag to signal the delegation constraint
				// is still used
				mapDelegationContraintsToKeep.put(delegationConstraint.getQualifiedName(), Boolean.TRUE);
				// continue;
				return;
			} else {
				logger.debug("delegation constraint is not present");
				logger.debug("variableIdText: " + variableIdText);
				logger.debug("constraintText: " + constraintText);
				logger.debug("iterConditionText: " + iterConditionText);
				// Create a delegation constraint, can be a
				// LogicalExpression, IntegerLiteral,
				// AddSubExpression, ...
				addedElements.add(entityUtil.createDelegationConstraint(owner, variableIdText, constraintText,
						iterConditionText, stereotypeUtil.delegationConstraintStereotype));
				// continue;
				return;
			}
		} else if ((variable instanceof FullParameterId) || (constraint instanceof FullParameterId)) {
			// ParameterId not handled
			addImportError("Found a connection with a ParameterId, don't know how to handle it!");
		} else {
			// System.out.println("variable: " + variable);
			logger.debug("constraint not handled: " + ossModelUtil.getOssElementAsString(connection, validateSerializedElements, true));
			addImportError("Found the connetion: " + getTextOfTag(connection) + ", don't know how to handle it!");
		}
		}
	}

	private boolean isDelegationConstraint(FullVariableId variable, Expression constraint,
			IterativeCondition iterCondition, Class owner) throws ImportException {
		logger.debug("isDelegationConstraint constraint: " + constraint);
		logger.debug("constraint instanceof FullVariableId: " + (constraint instanceof FullVariableId));
		return !(constraint instanceof FullVariableId)
				|| (ossModelUtil.isVariableWithArray((FullVariableId) constraint))
				|| !(variable instanceof FullVariableId)
				|| (ossModelUtil.isVariableWithArray((FullVariableId) variable))
				|| (isFunctionBehavior(owner, variable) && isFunctionBehavior(owner, constraint))
				|| (iterCondition != null);
	}

	private Class getPortOwner(Property partWithPort, Class owner) {
		Class portOwner = owner;
		if (partWithPort != null) {
			// Now I have to get the port object from the owning element
			// Get the component type
			final String typeName = partWithPort.getType().getName();

			// Get the component object containing the definition of the port
			portOwner = dslTypeToComponent.get(typeName);
		}

		return portOwner;
	}

	private Property getPartWithPort(FullVariableId portId, Class owner) {

		Property partWithPort = null;
		String portOwnerName = ossModelUtil.getNearestComponentName(portId);
		if (portOwnerName != null) {
			partWithPort = entityUtil.getUmlComponentInstance(owner, portOwnerName);
		}
		return partWithPort;
	}

	private void parseSubComponent(SubComponent subComponent, HashMap<String, Boolean> mapComponentInstancesToKeep,
			Class owner) throws ImportException {

		// SubComponent subComponent = dslRefInstance.getSubcomponent();
		// SUB processing
		final String subName = ossModelUtil.getSubComponentName(subComponent, validateSerializedElements);
		logger.debug("\tsubcomponent name = " + subName);

		final String subType = ossModelUtil.getSubComponentTypeName(subComponent);
		logger.debug("\tsubcomponent type = " + subType);

		String[] mulitplicityBoundaries = ossModelUtil
				.getMultiplicityBoundariesFromOssSubComponentType(subComponent.getType(), validateSerializedElements);
		logger.debug("\tsubcomponent multiplicityBoundaries = " + mulitplicityBoundaries[0] + " , "
				+ mulitplicityBoundaries[1]);
		final Type subComponentType = (Type) dslTypeToComponent.get(subType);

		// Retrieve the component instance from the owner, if any
		final Property componentInstance = entityUtil.getSubComponentInstance(owner, subName);

		if (componentInstance == null) {
			logger.debug("componentInstance not found, creating one");
			addedElements
					.add(entityUtil.createUmlAssociation(subName, subComponentType, mulitplicityBoundaries, owner));
		} else {
			logger.debug("componentInstance already present");
			if (!componentInstance.getType().equals(subComponentType)) {
				// Add the association to the list of changes, it
				// needs to be redrawn
				addedElements.add(componentInstance.getAssociation());
			}
			try {
				chessElementsUtil.updateUmlAssociation(componentInstance, subComponentType, mulitplicityBoundaries,
						mapComponentInstancesToKeep);
			} catch (Exception e) {
				if (e.getMessage() != null) {
					throw new ImportException(e.getMessage());
				} else {
					e.printStackTrace();
					throw new ImportException(e.toString());
				}
			}
		}
	}

	/**
	 * Creates a map with the formal properties names and the objects
	 * 
	 * @param existingFormalProperties
	 *            the list of constraints of the object
	 * @return the requested map
	 */
	private HashMap<String, FormalProperty> prepareFormalPropertiesMap(EList<Constraint> existingFormalProperties) {
		final HashMap<String, FormalProperty> map = Maps.newHashMapWithExpectedSize(existingFormalProperties.size());

		// If the constraint is a formal property, store it
		for (Constraint constraint : existingFormalProperties) {
			final FormalProperty formalProperty = entityUtil.getFormalProperty(constraint);
			if (formalProperty != null) {
				map.put(formalProperty.getBase_Constraint().getName(), formalProperty);
			}
		}
		return map;
	}

	/**
	 * Parses the Interfaces of the component.
	 * 
	 * @param dslParentComponent
	 *            the AST Component owning the refinement
	 * @param dslComponentInterface
	 *            the Interface element to be parsed
	 * @throws ImportException
	 */
	@SuppressWarnings("unchecked")
	private void parseInterfaces(AbstractComponent dslParentComponent, Interface dslComponentInterface)
			throws ImportException {

		// Get all the InterfaceInstances of the Interface
		final EList<InterfaceInstance> dslIntInstances = dslComponentInterface.getInterfaces();

		final Class owner = dslTypeToComponent.get(dslParentComponent.getType());

		// Get all the existing ports of the element, static or not
		final EList<NamedElement> existingNonStaticPorts = (EList<NamedElement>) chessSystemModel
				.getNonStaticPorts(owner);
		existingNonStaticPorts.addAll((Collection<? extends NamedElement>) chessSystemModel.getStaticPorts(owner));

		// Prepare the map to mark existing ports
		final HashMap<String, Boolean> mapPortsToKeep = Maps.newHashMapWithExpectedSize(existingNonStaticPorts.size());
		for (NamedElement port : existingNonStaticPorts) {
			mapPortsToKeep.put(port.getQualifiedName(), null);
		}

		// Get all the existing contract properties
		final EList<ContractProperty> existingContractProperties = (EList<ContractProperty>) chessSystemModel
				.getContractsOfComponent(owner);

		// Prepare the map to mark existing contracts
		final HashMap<String, Boolean> mapContractPropertiesToKeep = Maps
				.newHashMapWithExpectedSize(existingContractProperties.size());
		for (ContractProperty contractProperty : existingContractProperties) {
			mapContractPropertiesToKeep.put(contractProperty.getBase_Property().getQualifiedName(), null);
		}

		// Get all the interface formal properties
		final EList<Constraint> existingFormalProperties = (EList<Constraint>) chessSystemModel
				.getInterfaceAssertions(owner);

		// Create an hash map for the existing formal properties
		final HashMap<String, FormalProperty> hashFormalProperties = prepareFormalPropertiesMap(
				existingFormalProperties);

		// Prepare the map to mark existing formal properties
		final HashMap<String, Boolean> mapFormalPropertiesToKeep = Maps
				.newHashMapWithExpectedSize(existingFormalProperties.size());
		for (Constraint formalProperty : existingFormalProperties) {
			mapFormalPropertiesToKeep.put(formalProperty.getQualifiedName(), null);
		}

		// Get all the parameter assumptions
		final EList<Constraint> existingParameterAssumptions = (EList<Constraint>) chessSystemModel
				.getParameterAssumptions(owner);

		// Prepare the map to mark existing parameter assumptions
		final HashMap<String, Boolean> mapParameterAssumptionsToKeep = Maps
				.newHashMapWithExpectedSize(existingParameterAssumptions.size());
		for (Constraint parameterAssumptions : existingParameterAssumptions) {
			mapParameterAssumptionsToKeep.put(parameterAssumptions.getQualifiedName(), null);
		}

		// Get all the functionBehaviors
		final EList<Behavior> existingFunctionBehaviors = owner.getOwnedBehaviors();

		// Prepare the map to mark existing functionBehaviors
		final HashMap<String, Boolean> mapFunctionBehaviorsToKeep = Maps
				.newHashMapWithExpectedSize(existingFunctionBehaviors.size());
		for (Behavior behavior : existingFunctionBehaviors) {
			mapFunctionBehaviorsToKeep.put(behavior.getQualifiedName(), null);
		}

		// If some InterfaceInstances are present, loop on them
		if ((dslIntInstances != null) && !dslIntInstances.isEmpty()) {
			for (InterfaceInstance dslIntInstance : dslIntInstances) {

				// Process the different types of interfaces
				if (containsVariable(dslIntInstance)) {

					final Variable dslVariable = dslIntInstance.getVariable();

					if (dslVariable instanceof Port) {
						parsePort((Port) dslVariable, existingNonStaticPorts, mapPortsToKeep, owner);

					} else if (dslVariable instanceof Parameter) {
						parseParameter((Parameter) dslVariable, mapFunctionBehaviorsToKeep, existingNonStaticPorts,
								mapPortsToKeep, owner);

					} else if (dslVariable instanceof Operation) {
						addImportError("Found a OPERATION tag, don't know how to handle it!");
					} else {
						addImportError("Found a " + getTextOfTag(dslVariable) + " tag, don't know how to handle it!");
					}
				} else if (containsDefine(dslIntInstance)) {

					// DEFINE processing
					addImportError("Found a DEFINE tag, don't know how to handle it!");
				} else if (containsContract(dslIntInstance)) {

					// CONTRACT processing
					parseContract(dslIntInstance.getContract(), hashFormalProperties, mapFormalPropertiesToKeep,
							mapContractPropertiesToKeep, owner);
				} else if (containsAssertion(dslIntInstance)) {

					// ASSERTION processing
					parseInterfaceAssertion(dslIntInstance.getAssertion(), hashFormalProperties,
							mapFormalPropertiesToKeep, owner);
				} else if (containsParameterAssumptions(dslIntInstance)) {

					// PARAMETER ASSUMPTIONS processing
					parseParameterAssumptions(dslIntInstance.getParameterAssumptions(), mapParameterAssumptionsToKeep,
							owner);
				} else if (dslIntInstance != null) {
					addImportError("Found a " + getTextOfTag(dslIntInstance) + " tag, don't know how to handle it!");
				}
			}
		}

		// Elements cleanup time
		removeUnusedInterfaceElements(mapPortsToKeep, existingNonStaticPorts, mapContractPropertiesToKeep,
				existingContractProperties, mapFormalPropertiesToKeep, existingFormalProperties,
				mapParameterAssumptionsToKeep, existingParameterAssumptions, mapFunctionBehaviorsToKeep,
				existingFunctionBehaviors);
	}

	private void parseParameterAssumptions(ParameterAssumptions parameterAssumptions,
			HashMap<String, Boolean> mapParameterAssumptionsToKeep, Class owner) {

		final String parameterAssumptionsText = ossModelUtil.getExpressionAsString(parameterAssumptions.getConstraint(),
				validateSerializedElements);

		// Retrieve the constraint from the owner, if any
		// (working on the constraint text)
		Constraint umlConstraint = entityUtil.getUmlConstraintFromText(parameterAssumptionsText, owner);

		if (umlConstraint == null || !entityUtil.isParameterAssumption(umlConstraint)) {
			logger.debug("Parameter assumptions non found, creating one");
			addedElements.add(entityUtil.createUmlConstraint(owner, parameterAssumptionsText));
		} else {
			if (entityUtil.isParameterAssumption(umlConstraint)) {
				logger.debug("Parameter assumptions already present");
				// Set the flag to signal the Parameter Assumptions is
				// still used
				mapParameterAssumptionsToKeep.put(umlConstraint.getQualifiedName(), Boolean.TRUE);
			}
		}
	}

	private boolean containsParameterAssumptions(InterfaceInstance dslIntInstance) {
		return dslIntInstance != null && dslIntInstance.getParameterAssumptions() != null;
	}

	private void removeUnusedInterfaceElements(HashMap<String, Boolean> mapPortsToKeep,
			EList<NamedElement> existingNonStaticPorts, HashMap<String, Boolean> mapContractPropertiesToKeep,
			EList<ContractProperty> existingContractProperties, HashMap<String, Boolean> mapFormalPropertiesToKeep,
			EList<Constraint> existingFormalProperties, HashMap<String, Boolean> mapParameterAssumptionsToKeep,
			EList<Constraint> existingParameterAssumptions, HashMap<String, Boolean> mapFunctionBehaviorsToKeep,
			EList<Behavior> existingFunctionBehaviors) {

		// Ports cleanup time
		for (String qualifiedElement : mapPortsToKeep.keySet()) {
			if (mapPortsToKeep.get(qualifiedElement) == null) {
				// System.out.println("port " + qualifiedElement + " should be
				// removed");
				entityUtil.removePort(existingNonStaticPorts, qualifiedElement);
			}
		}

		// Contracts cleanup time
		// ** Contract instances and contract types are removed, but not their
		// formal properties and refinements!
		for (String qualifiedElement : mapContractPropertiesToKeep.keySet()) {
			if (mapContractPropertiesToKeep.get(qualifiedElement) == null) {
				// System.out.println("contractProperty " + qualifiedElement + "
				// should be removed");
				contractEntityUtil.removeContractProperty(existingContractProperties, qualifiedElement);
			}
		}

		// Formal properties cleanup time
		for (String qualifiedElement : mapFormalPropertiesToKeep.keySet()) {
			if (mapFormalPropertiesToKeep.get(qualifiedElement) == null) {
				// System.out.println("formalProperty " + qualifiedElement + "
				// should be removed");
				entityUtil.removeFormalProperty(existingFormalProperties, qualifiedElement);
			}
		}

		// Parameter Assumptions cleanup time
		for (String qualifiedElement : mapParameterAssumptionsToKeep.keySet()) {
			if (mapParameterAssumptionsToKeep.get(qualifiedElement) == null) {
				// System.out.println("formalProperty " + qualifiedElement + "
				// should be removed");
				entityUtil.removeParameterAssumptions(existingParameterAssumptions, qualifiedElement);
			}
		}

		// FunctionBehavior cleanup time
		for (String qualifiedElement : mapFunctionBehaviorsToKeep.keySet()) {
			if (mapFunctionBehaviorsToKeep.get(qualifiedElement) == null) {
				// System.out.println("functionBehavior " + qualifiedElement + "
				// should be removed");
				entityUtil.removeFunctionBehavior(existingFunctionBehaviors, qualifiedElement);
			}
		}
	}

	private void addImportError(String message) {
		// PROVIDED OPERATION processing
		logger.error("Import Error: " + message);
		importErrors.append(message + "\n");
	}

	private boolean containsAssertion(InterfaceInstance dslIntInstance) {
		return dslIntInstance != null && dslIntInstance.getAssertion() != null;
	}

	private boolean containsContract(InterfaceInstance dslIntInstance) {
		return dslIntInstance != null && dslIntInstance.getContract() != null;
	}

	private boolean containsDefine(InterfaceInstance dslIntInstance) {
		return dslIntInstance != null && dslIntInstance.getDefine() != null;
	}

	private boolean containsVariable(InterfaceInstance dslIntInstance) {
		return dslIntInstance != null && dslIntInstance.getVariable() != null;
	}

	private void parseInterfaceAssertion(Assertion assertion, HashMap<String, FormalProperty> hashFormalProperties,
			HashMap<String, Boolean> mapFormalPropertiesToKeep, Class owner) {

		final String assertionName = assertion.getName();
		final String assertionText = ossModelUtil.getExpressionAsString(assertion.getConstraint(),
				validateSerializedElements);

		// Retrieve the formal property from the owner, if any
		// (working on the assertion name)
		Constraint umlConstraint = owner.getOwnedRule(assertionName);

		if (umlConstraint == null || !entityUtil.isFormalProperty(umlConstraint)) {
			logger.debug("Formal property non found, creating one");
			addedElements.add(chessElementsUtil.createUmlInterfaceFormalProperty(assertionName, assertionText,
					hashFormalProperties, owner));
		} else {
			if (entityUtil.isFormalProperty(umlConstraint)) {
				logger.debug("Formal property already present");
				chessElementsUtil.updateUmlFormalProperty(umlConstraint, assertionText, hashFormalProperties,
						mapFormalPropertiesToKeep);
			}
		}
	}

	private void parseContract(Contract dslContract, HashMap<String, FormalProperty> hashFormalProperties,
			HashMap<String, Boolean> mapFormalPropertiesToKeep, HashMap<String, Boolean> mapContractPropertiesToKeep,
			Class owner) {

		// parseContract();
		// final Contract dslContract = dslIntInstance.getContract();
		final Assumption dslAssumption = dslContract.getAssumption();
		final Guarantee dslGuarantee = dslContract.getGuarantee();
		final String ossAssumptionText = ossModelUtil.getExpressionAsString(dslAssumption.getConstraint(),
				validateSerializedElements);
		final String ossGuaranteeText = ossModelUtil.getExpressionAsString(dslGuarantee.getConstraint(),
				validateSerializedElements);
		final String contractName = dslContract.getName();

		// Retrieve the contract type from the owner, if any
		Class umlContract = (Class) owner.getOwnedMember(contractName, false,
				UMLFactory.eINSTANCE.createClass().eClass());

		if (umlContract == null) {
			logger.debug("contract not found, creating one");
			umlContract = chessElementsUtil.createUmlContract(contractName, ossAssumptionText, ossGuaranteeText,
					hashFormalProperties, owner, stereotypeUtil.contractStereotype);

			// Create a Contract Property
			final String contractPropertyName = deriveContractPropertyNameFromContract(umlContract);
			contractEntityUtil.createContractProperty(owner, contractPropertyName, (Type) umlContract,
					stereotypeUtil.contractPropertyStereotype);
			addedElements.add(umlContract);
		} else {
			logger.debug("Contract already present");
			chessElementsUtil.updateUmlContract(umlContract, ossAssumptionText, ossGuaranteeText, hashFormalProperties,
					mapContractPropertiesToKeep, mapFormalPropertiesToKeep, owner);
		}
	}

	/**
	 * Returns a name for the ContractProperty, deriving it from the Contract
	 * type.
	 * 
	 * @param contract
	 *            the contract from which it derives
	 * @return a derived name, going lowercase
	 */
	private String deriveContractPropertyNameFromContract(Class contract) {
		final String contractName = contract.getName();

		if (contractName.length() > 0) {
			return contractName.toLowerCase();
		} else {
			return ((Contract) contract).getName().toLowerCase();
		}
	}

	private void parsePort(Port ossPort, EList<NamedElement> existingPorts, HashMap<String, Boolean> mapPortsToKeep,
			Class owner) throws ImportException {
		// PORT processing
		// final VariableId dslVariableID = ossPort.getId();
		final ComplexType ossPortType = ossPort.getType();
		String portName = ossModelUtil.getPortName(ossPort, validateSerializedElements);
		logger.debug("port: " + ossPort);
		logger.debug("portName: " + portName);
		Type newPortType = ossTypeTranslator.getOrCreateTypeFromOssComplexType(ossPortType, owner.getNearestPackage());
		if (newPortType == null) {
			throw new ImportException("Not able to map the requested type for port : " + portName);
			// return null; // Create the port anyway, without type
		}
		String[] newMultiplicityRange = ossModelUtil.getMultiplicityBoundariesFromOssComplexType(ossPortType,
				validateSerializedElements);
		// Version that updates the port
		// Loop on all the ports to see if it is already existing
		org.eclipse.uml2.uml.Port port = entityUtil.getExistingUmlPort(portName, existingPorts);

		if (port != null) {
			if (ossPort instanceof InputPort) {
				chessElementsUtil.updateUmlNonStaticPort(port, ossPort, newPortType, newMultiplicityRange,
						FlowDirection.IN, stereotypeUtil.flowPortStereotype, mapPortsToKeep);
			} else if (ossPort instanceof OutputPort) {
				chessElementsUtil.updateUmlNonStaticPort(port, ossPort, newPortType, newMultiplicityRange,
						FlowDirection.OUT, stereotypeUtil.flowPortStereotype, mapPortsToKeep);
			}
		} else {
			logger.debug("Port not found, creating it");

			if (ossPort instanceof InputPort) {
				addedElements.add(entityUtil.createNonStaticPort(owner, portName, newPortType, newMultiplicityRange,
						true, stereotypeUtil.flowPortStereotype));
			} else if (ossPort instanceof OutputPort) {
				addedElements.add(entityUtil.createNonStaticPort(owner, portName, newPortType, newMultiplicityRange,
						false, stereotypeUtil.flowPortStereotype));
			}
		}
	}

	private void parseParameter(Parameter ossParameter, HashMap<String, Boolean> mapFunctionBehaviorsToKeep,
			EList<NamedElement> existingNonStaticPorts, HashMap<String, Boolean> mapPortsToKeep, Class owner)
			throws ImportException {

		// PARAMETER processing
		// final FullParameterId ossParameterID =
		// (FullParameterId)dslVariable.getId();
		final ComplexType ossOutputType = ossParameter.getType();

		// Check if there are optional parameters to detect how to handle it
		final EList<ComplexType> ossInputTypes = ossParameter.getParameters();
		String parameterName = ossModelUtil.getVariableIdAsString(ossParameter.getId(), validateSerializedElements);
		if (ossInputTypes.size() != 0) {
			parseParameterAsUmlFunctionBehaviour(parameterName, ossOutputType, ossInputTypes,
					mapFunctionBehaviorsToKeep, owner);
		} else {
			parseParameterAsUmlStaticPort(parameterName, ossOutputType, existingNonStaticPorts, mapPortsToKeep, owner);
		}
	}

	private void parseParameterAsUmlStaticPort(String ossParameterName, ComplexType ossParameterType,
			EList<NamedElement> existingStaticPorts, HashMap<String, Boolean> mapPortsToKeep, Class owner)
			throws ImportException {
		// Convert the parameter to a static port
		// Check if the port is already present
		// String ossParameterName =
		// ossModelUtil.getParameterName(ossParameterId);
		final String[] newMultiplicityRange = ossModelUtil.getMultiplicityBoundariesFromOssComplexType(ossParameterType,
				validateSerializedElements);
		Type newParameterType = ossTypeTranslator.getOrCreateTypeFromOssComplexType(ossParameterType,
				owner.getNearestPackage());
		if (newParameterType == null) {
			throw new ImportException("Not able to map the requested type for port : " + ossParameterName);
		}
		// Type ossPortType =
		// ossElementsUtil.getOrCreateTypeFromOssType(dslVariableType,
		// owner.getNearestPackage());
		org.eclipse.uml2.uml.Port staticPort = entityUtil.getExistingUmlPort(ossParameterName,
				newParameterType.getName(), existingStaticPorts);

		/*
		 * for (Object object : existingPorts) { final org.eclipse.uml2.uml.Port
		 * tmpPort = (org.eclipse.uml2.uml.Port) object; if
		 * (tmpPort.getName().equals(dslVariableID.getName()) &&
		 * tmpPort.getType().getName().equals().getName())) { port = tmpPort;
		 * break; // Port found } }
		 */

		if (staticPort != null) {
			logger.debug("Port already present");
			chessElementsUtil.updateUmlStaticPort(staticPort, newMultiplicityRange, mapPortsToKeep);
		} else {
			// Create the port and mark it
			addedElements.add(entityUtil.createStaticPort(owner, ossParameterName, newParameterType,
					newMultiplicityRange, stereotypeUtil.flowPortStereotype));
			// continue;
		}
	}

	private void parseParameterAsUmlFunctionBehaviour(String parameterName, ComplexType ossOutputType,
			EList<ComplexType> ossInputTypes, HashMap<String, Boolean> mapFunctionBehaviorsToKeep, Class owner)
			throws ImportException {

		// Check if the functionBehavior is already present
		FunctionBehavior functionBehavior = (FunctionBehavior) owner.getOwnedBehavior(parameterName);

		Type newOutputType = ossTypeTranslator.getOrCreateTypeFromOssComplexType(ossOutputType,
				owner.getNearestPackage());
		final String[] newMultiplicity = ossModelUtil.getMultiplicityBoundariesFromOssComplexType(ossOutputType,
				validateSerializedElements);

		EList<Type> newInputTypes = ossTypeTranslator.getOrCreateTypesFromOssComplexTypes(ossInputTypes,
				owner.getNearestPackage());
		final EList<String[]> newMultiplicities = ossModelUtil
				.getMultiplicityBoundariesFromOssComplexTypes(ossInputTypes, validateSerializedElements);

		if (newOutputType == null) {
			throw new ImportException("Not able to map the requested type for port : " + parameterName);
		}

		if (functionBehavior == null) {
			logger.debug("functionBehavior not found, creating one");
			addedElements.add(entityUtil.createUmlFunctionBehaviour(parameterName, newInputTypes, newMultiplicities,
					newOutputType, newMultiplicity, owner));
		} else {
			logger.debug("functionBehavior already present");
			chessElementsUtil.updateUmlFunctionBehaviour(functionBehavior, newInputTypes, newMultiplicities,
					newOutputType, newMultiplicity, mapFunctionBehaviorsToKeep);
		}
	}

	/*
	 * private SimpleType getSimpleType(EObject type){ if (type instanceof
	 * ParameterizedArrayType) { return
	 * ((ParameterizedArrayType)type).getType(); }else { return
	 * (SimpleType)type; } }
	 */

	/**
	 * Navigates the component and processes its interfaces.
	 * 
	 * @param dslParentComponent
	 *            the element in the tree
	 * @throws ImportException
	 */
	private void parseComponentInterfaces(AbstractComponent dslParentComponent) throws ImportException {

		logger.debug("\n\n\nParsing Interfaces for  " + dslParentComponent.getType() + "\n");

		// Get the Interfaces, if any
		final Interface dslComponentInterface = dslParentComponent.getInterface();
		if (dslComponentInterface != null) {
			parseInterfaces(dslParentComponent, dslComponentInterface);
		}
	}

	/**
	 * Navigates the component and processes its refinements.
	 * 
	 * @param dslParentComponent
	 *            the element in the tree
	 * @throws Exception
	 */
	private void parseComponentRefinements(AbstractComponent dslParentComponent) throws ImportException {

		logger.debug("\n\n\nParsing Refinements for " + dslParentComponent.getType() + "\n");

		// Get the Refinement, if any
		final Refinement dslComponentRefinement = dslParentComponent.getRefinement();
		if (dslComponentRefinement != null) {
			parseRefinements(dslParentComponent, dslComponentRefinement);
		}
	}

	/**
	 * Main method to be invoked to parse an OSS file.
	 * 
	 * @throws Exception
	 */
	public StringBuffer startParsing(Package pkg, File ossFile) throws Exception {

		logger.debug("pkg: " + pkg);

		OSS ocraOssFile;
		sysView = pkg; // Set the given package as working package

		importErrors = new StringBuffer();

		// Retrieve the needed stereotypes
		stereotypeUtil.refreshStereotypes(sysView);

		long startTime = System.currentTimeMillis();

		if (ossFile != null) {
			ocraOssFile = OSSModelFactory.getInstance().createOssModel(ossFile);
		} else {
			return importErrors;
		}

		// Retrieve the SystemComponent
		SystemComponent dslSystemComponent = ocraOssFile.getSystem();

		if (dslSystemComponent == null) {
			logger.error("Import Error: System component is missing");
			throw new ImportException("System component is missing");
		}

		// If the OCRA system component type is not defined, set it to 'System'
		final String dslSystemComponentName = dslSystemComponent.getType() == null ? "System"
				: dslSystemComponent.getType();
		dslSystemComponent.setType(dslSystemComponentName);

		logger.debug("dslSystemComponent.type = " + dslSystemComponentName);

		// Get all the existing members
		EList<NamedElement> existingMembers = sysView.getOwnedMembers();
		EList<Class> existingBlocks = new BasicEList<Class>(existingMembers.size());

		// Prepare the map to mark existing blocks
		HashMap<String, Boolean> mapBlocks = Maps.newHashMapWithExpectedSize(existingMembers.size());
		for (Element member : existingMembers) {
			if (entityUtil.isBlock(member) && !contractEntityUtil.isContract(member)) {
				mapBlocks.put(((Class) member).getQualifiedName(), null);
				existingBlocks.add((Class) member);
			}
		}

		// New elements that will be added to the model
		addedElements.clear();

		// A map used to connect block names to their implementation
		dslTypeToComponent = new HashMap<String, Class>();

		// Clear the exception before starting the import
		importException = null;

		// Start a transaction to modify the package content
		Resource modelRes = SelectionUtil.getInstance().getSelectedModelResource();
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(modelRes);
		logger.debug("pkg.eResource(): " + pkg.eResource());
		logger.debug("pkg.eResource().getResourceSet(): " + pkg.eResource().getResourceSet());
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {

				String blockQualifiedName = pkg.getQualifiedName() + "::" + dslSystemComponentName;
				Class systemComponent = null;
				if (!mapBlocks.containsKey(blockQualifiedName)) {
					logger.debug("block not present: " + blockQualifiedName);

					// Add a new systemComponent to the package
					systemComponent = entityUtil.createSystemBlock(sysView, dslSystemComponent.getType(),
							stereotypeUtil.blockStereotype, stereotypeUtil.systemStereotype);

					// Add the component to the list of changes
					addedElements.add(systemComponent);

				} else {
					logger.debug("block already present");

					// Should retrieve the old one from the package
					systemComponent = (Class) sysView.getOwnedMember(dslSystemComponentName, false,
							UMLFactory.eINSTANCE.createClass().eClass());

					// Set the flag to signal the block is still used
					mapBlocks.put(blockQualifiedName, Boolean.TRUE);
				}

				// Store the systemComponent in a hash with its name
				dslTypeToComponent.put(dslSystemComponentName, systemComponent);

				// Populate the map and the package with the other Component
				// elements
				for (Component dslComponent : ocraOssFile.getComponents()) {

					blockQualifiedName = pkg.getQualifiedName() + "::" + dslComponent.getType();

					Class component = null;
					if (!mapBlocks.containsKey(blockQualifiedName)) {

						logger.debug("block not present: " + blockQualifiedName);

						// Add a new block to the package
						component = entityUtil.createBlock(sysView, dslComponent.getType(),
								stereotypeUtil.blockStereotype);

						// Add the component to the list of changes
						addedElements.add(component);
					} else {

						logger.debug("block already present: " + blockQualifiedName);

						// Retrieve the old one
						component = (Class) sysView.getOwnedMember(dslComponent.getType(), false,
								UMLFactory.eINSTANCE.createClass().eClass());

						// Set the flag to signal the block is still used
						mapBlocks.put(blockQualifiedName, Boolean.TRUE);
					}

					// Store the component in a hash with its name
					dslTypeToComponent.put(dslComponent.getType(), component);
				}

				// Now I have created all the Blocks in the package, loop on
				// them, but not getting them from
				// the package (it may be polluted with other blocks), but from
				// the OSS model again.
				try {

					// Parse the system component
					parseComponentInterfaces(dslSystemComponent);

					// Parse all the other components
					for (Component dslComponent : ocraOssFile.getComponents()) {
						parseComponentInterfaces(dslComponent);
					}

					// Parse the system component
					parseComponentRefinements(dslSystemComponent);

					// Parse all the other components
					for (Component dslComponent : ocraOssFile.getComponents()) {
						parseComponentRefinements(dslComponent);
					}
				} catch (ImportException e) {
					importException = e;
					// return;
				}

				// Blocks cleanup time, remove blocks no more needed
				for (String qualifiedElement : mapBlocks.keySet()) {
					if (mapBlocks.get(qualifiedElement) == null) {
						// System.out.println("block " + qualifiedElement + "
						// should be removed");
						entityUtil.removeElement(existingBlocks, qualifiedElement);
					}
				}

				logger.debug("Total time = " + (System.currentTimeMillis() - startTime));
				// System.out.println("Total time = " +
				// (System.currentTimeMillis() - startTime));
			}
		});

		// addedElements contains all the elements that have been added or
		// modified
		logger.debug("addedElements size = " + addedElements.size());
		for (Element element : addedElements) {
			logger.debug("modified element = " + element);
		}

		// Propagate the exception, if any
		if (importException != null) {
			throw importException;
		}

		return importErrors;
	}
}

// TODO: andrebbero rimossi anche i tipi creati, signal, enumeration,
// boundedsubtype,...
