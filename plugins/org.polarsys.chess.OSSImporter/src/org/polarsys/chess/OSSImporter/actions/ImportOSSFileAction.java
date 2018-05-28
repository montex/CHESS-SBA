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
package org.polarsys.chess.OSSImporter.actions;

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
import org.polarsys.chess.OSSImporter.exceptions.ImportException;
import org.polarsys.chess.OSSImporter.utils.ChessElementsUtil;
import org.polarsys.chess.contracts.profile.chesscontract.ContractProperty;
import org.polarsys.chess.contracts.profile.chesscontract.ContractRefinement;
import org.polarsys.chess.contracts.profile.chesscontract.FormalProperty;
import org.polarsys.chess.contracts.profile.chesscontract.util.ContractEntityUtil;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;
import org.polarsys.chess.contracts.profile.chesscontract.util.StereotypeUtil;
import org.polarsys.chess.service.core.model.ChessSystemModel;

import com.google.common.collect.Maps;

import eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.core.services.OSSModelFactory;
import eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.core.utils.OSSModelUtil;
import eu.fbk.tools.editor.basetype.baseType.*;
import eu.fbk.tools.editor.contract.contract.Assumption;
import eu.fbk.tools.editor.contract.contract.Contract;
import eu.fbk.tools.editor.contract.contract.Guarantee;
import eu.fbk.tools.editor.contract.expression.expression.ExtendedExpression;
import eu.fbk.tools.editor.contract.expression.expression.ParameterId;
import eu.fbk.tools.editor.contract.expression.expression.PortId;
import eu.fbk.tools.editor.contract.expression.expression.VariableId;
import eu.fbk.tools.editor.oss.oss.SystemComponent;
import eu.fbk.tools.editor.oss.oss.Variable;
import eu.fbk.tools.editor.oss.oss.AbstractComponent;
import eu.fbk.tools.editor.oss.oss.Assertion;
import eu.fbk.tools.editor.oss.oss.Component;
import eu.fbk.tools.editor.oss.oss.Connection;
import eu.fbk.tools.editor.oss.oss.ContractId;
import eu.fbk.tools.editor.oss.oss.InputPort;
import eu.fbk.tools.editor.oss.oss.Interface;
import eu.fbk.tools.editor.oss.oss.InterfaceInstance;
import eu.fbk.tools.editor.oss.oss.OSS;
import eu.fbk.tools.editor.oss.oss.OutputPort;
import eu.fbk.tools.editor.oss.oss.Port;
import eu.fbk.tools.editor.oss.oss.RefinedBy;
import eu.fbk.tools.editor.oss.oss.Operation;
import eu.fbk.tools.editor.oss.oss.Parameter;
import eu.fbk.tools.editor.oss.oss.Refinement;
import eu.fbk.tools.editor.oss.oss.RefinementInstance;
import eu.fbk.tools.editor.oss.oss.SubComponent;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;

/**
 * This class takes as input a file in OCRA format and creates the equivalent
 * CHESS model.
 * 
 * @author cristofo
 *
 */

// TODO add array of ports and subcomponents
public class ImportOSSFileAction {

	// The instance of this class
	private static ImportOSSFileAction classInstance;

	private final ChessSystemModel chessSystemModel = ChessSystemModel.getInstance();
	private final ContractEntityUtil contractEntityUtil = ContractEntityUtil.getInstance();
	private final EntityUtil entityUtil = EntityUtil.getInstance();
	// FIXME think how to manage this class
	private final StereotypeUtil stereotypeUtil = StereotypeUtil.getInstance();
	//private final OssElementsUtil ossElementsUtil = OssElementsUtil.getInstance();
	private final ChessElementsUtil chessElementsUtil = ChessElementsUtil.getInstance();
	private static OSSModelUtil ossModelUtil = OSSModelUtil.getInstance();

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
	 * Returns the list of contract refinements associated to a Class
	 * 
	 * @param owner
	 *            the owner Class
	 * @return the list of contract refinements
	 */
	private EList<DataType> getContractRefinementsOfClass(Class owner) {
		EList<DataType> contractRefinements = new BasicEList<DataType>();

		for (Classifier classifier : owner.getNestedClassifiers()) {
			if (classifier instanceof DataType) {
				contractRefinements.add((DataType) classifier);
			}
		}
		return contractRefinements;
	}

	/**
	 * Checks if the given expression refers to a function behavior
	 * 
	 * @param owner
	 *            the owner element
	 * @param expression
	 *            the expression defining the function behavior
	 * @return
	 */
	private boolean isFunctionBehavior(Class owner, Expression expression) {
		if (expression instanceof VariableId) {
			final VariableId variable = (VariableId) expression;

			String variableOwner = null;
			Class component = null;

			// Get the name of the owner of the behavior, if present find the
			// type
			final EList<String> componentNames = variable.getComponentNames();
			if (componentNames != null && componentNames.size() != 0) {
				variableOwner = componentNames.get(0);

				// Retrieve the component instance containing the behavior
				final Property behaviorOwner = entityUtil.getUMLComponentInstance(owner, variableOwner);

				// Get the component type
				final String typeName = behaviorOwner.getType().getName();

				// Get the component object containing the definition of the
				// port
				component = dslTypeToComponent.get(typeName);
			}

			if (variableOwner == null) {

				// I'm the owner of the functionBehavior
				component = owner;
			}
			return (component.getOwnedBehavior(variable.getName()) != null);
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
		return (ossModelUtil.getOssElementAsString(tag, true).split(" ")[0]);
	}

	/**
	 * Parses the Refinements of the component.
	 * 
	 * @param dslParentComponent
	 *            the AST Component owning the refinement
	 * @param dslComponentRefinement
	 *            the Refinement element to be parsed
	 * @throws ImportException
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
		HashMap<String, Boolean> mapComponentInstances = Maps
				.newHashMapWithExpectedSize(existingComponentInstances.size());
		for (Property componentInstance : existingComponentInstances) {
			mapComponentInstances.put(componentInstance.getQualifiedName(), null);
		}

		// Get all the existing connectors of the element
		// Doing a copy because the list will otherwise increase as soon as a
		// connector is created
		EList<Connector> existingConnectors = new BasicEList<Connector>(owner.getOwnedConnectors());
		// EList<Connector> connectors = owner.getOwnedConnectors();

		// Prepare the map to mark existing connectors
		HashMap<String, Boolean> mapConnectors = Maps.newHashMapWithExpectedSize(existingConnectors.size());
		for (Connector connector : existingConnectors) {
			mapConnectors.put(connector.getQualifiedName(), null);
		}

		// Get all the existing delegation contraints of the element
		EList<Constraint> existingDelegationConstraints = entityUtil.getDelegationConstraintsAsUMLConstraints(owner);

		// Prepare the map to mark existing delegation contraints
		HashMap<String, Boolean> mapDelegationContraints = Maps
				.newHashMapWithExpectedSize(existingDelegationConstraints.size());
		for (Constraint delegationConstraint : existingDelegationConstraints) {
			mapDelegationContraints.put(delegationConstraint.getQualifiedName(), null);
		}

		// Get all the contract refinements of the element
		EList<DataType> existingContractRefinements = getContractRefinementsOfClass(owner);

		// Prepare the map to mark existing contract refinements
		HashMap<String, Boolean> mapContractRefinements = Maps
				.newHashMapWithExpectedSize(existingContractRefinements.size());
		for (Classifier contractRefinement : existingContractRefinements) {
			mapContractRefinements.put(contractRefinement.getQualifiedName(), null);
		}

		// Get all the refinement formal properties
		@SuppressWarnings("unchecked")
		final EList<Constraint> existingFormalProperties = (EList<Constraint>) chessSystemModel
				.getRefinementAssertions(owner);

		// Prepare the map to mark existing formal properties
		final HashMap<String, Boolean> mapFormalProperties = Maps
				.newHashMapWithExpectedSize(existingFormalProperties.size());
		for (Constraint formalProperty : existingFormalProperties) {
			mapFormalProperties.put(formalProperty.getQualifiedName(), null);
		}

		// If some RefinementInstances are present, loop on them
		if ((dslRefInstances != null) && !dslRefInstances.isEmpty()) {
			for (RefinementInstance dslRefInstance : dslRefInstances) {

				// Process the different types of refinements
				if (containsSubComponent(dslRefInstance)) {

					parseSubComponent(dslRefInstance.getSubcomponent(), mapComponentInstances, owner);

				} else if (containsConnection(dslRefInstance)) {

					parseConnection(dslRefInstance.getConnection(), existingConnectors, existingDelegationConstraints,
							mapConnectors, mapDelegationContraints, owner);

				} else if (containsRefinedBy(dslRefInstance)) {

					parseRefinedBy(dslRefInstance.getRefinedby(), mapContractRefinements, owner);

				} else if (containsFormula(dslRefInstance)) {

					// CONSTRAINT processing
					addImportError("Found a CONSTRAINT tag, don't know how to handle it!");
				} else if (containsProp(dslRefInstance)) {

					// PROP processing
					addImportError("Found a PROP tag, don't know how to handle it!");
				} else if (containsAssertion(dslRefInstance)) {
					parseRefinementAssertion(dslRefInstance.getAssertion(), mapFormalProperties, owner);
				} else if (dslRefInstance != null) {
					addImportError("Found a " + getTextOfTag(dslRefInstance) + " tag, don't know how to handle it!");
				}
			}
		}

		// Component instances cleanup time, associations will be removed
		// automatically
		for (String qualifiedElement : mapComponentInstances.keySet()) {
			if (mapComponentInstances.get(qualifiedElement) == null) {
				// System.out.println("component instance " + qualifiedElement +
				// " should be removed");
				entityUtil.removeProperty(existingComponentInstances, qualifiedElement);
			}
		}

		// Connectors cleanup time
		for (String qualifiedElement : mapConnectors.keySet()) {
			if (mapConnectors.get(qualifiedElement) == null) {
				// System.out.println("connector " + qualifiedElement + " should
				// be removed");
				entityUtil.removeConnector(existingConnectors, qualifiedElement);
			}
		}

		// Delegation constraints cleanup time
		for (String qualifiedElement : mapDelegationContraints.keySet()) {
			if (mapDelegationContraints.get(qualifiedElement) == null) {
				// System.out.println("delegation constraint " +
				// qualifiedElement + " should be removed");
				entityUtil.removeDelegationConstraint(existingDelegationConstraints, qualifiedElement);
			}
		}

		// Contract refinements cleanup time
		for (String qualifiedElement : mapContractRefinements.keySet()) {
			if (mapContractRefinements.get(qualifiedElement) == null) {
				// System.out.println("contract refinement " + qualifiedElement
				// + " should be removed");
				contractEntityUtil.removeContractRefinement(existingContractRefinements, qualifiedElement);
			}
		}

		// Formal properties cleanup time
		for (String qualifiedElement : mapFormalProperties.keySet()) {
			if (mapFormalProperties.get(qualifiedElement) == null) {
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

	private void parseRefinementAssertion(Assertion assertion, HashMap<String, Boolean> mapFormalProperties,
			Class owner) {

		// ASSERTION processing
		// final Assertion assertion = dslRefInstance.getAssertion();
		final String assertionName = assertion.getName();
		final String assertionText = ossModelUtil.getOssElementAsString(assertion.getConstraint(), true);

		// Retrieve the formal property from the owner, if any
		// (working on the assertion name)
		Constraint umlConstraint = owner.getOwnedRule(assertionName);

		if (umlConstraint == null || !entityUtil.isFormalProperty(umlConstraint)) {
			logger.debug("Formal property non found, creating one");
			addedElements.add(chessElementsUtil.createUmlRefinementFormalProperty(assertionName, assertionText, owner));
		} else {
			if (entityUtil.isFormalProperty(umlConstraint)) {
				logger.debug("Formal property already present");
				chessElementsUtil.updateUmlRefinementFormalProperty(umlConstraint, assertionText, mapFormalProperties);
			}
		}

	}

	private void parseRefinedBy(RefinedBy refinement, HashMap<String, Boolean> mapContractRefinements, Class owner) {

		// REFINEDBY processing
		// final RefinedBy refinement = dslRefInstance.getRefinedby();
		final String refinedContract = refinement.getName();

		logger.debug("\n\n\nContract name = " + refinedContract + " from " + owner.getName());

		// final ContractProperty contractProperty =
		// getContractPropertyFromContract(owner, refinedContract);

		// Get the instance of the contract, using a library
		// function
		final Property umlProperty = contractEntityUtil
				.getUmlContractPropertyOfUmlComponentFromContractPropertyType(owner, refinedContract);
		final ContractProperty contractProperty = contractEntityUtil.getContractProperty(umlProperty);

		// Get the refinements linked to that contract property
		final EList<ContractRefinement> contractPropertyRefinements = chessSystemModel
				.getContractRefinements(contractProperty);

		// Loop on all the refinements to see if they already exist
		final EList<ContractId> contractIds = refinement.getContractIds();
		for (ContractId contractId : contractIds) {

			// The component instance containing the refining
			// contract
			final Property refiningComponentInstance = entityUtil.getUMLComponentInstance(owner,
					contractId.getComponentName());

			// The component type where the contract property is
			// defined
			final Class refiningComponent = (Class) refiningComponentInstance.getType();

			// The refining contract property
			final Property refiningProperty = contractEntityUtil
					.getUmlContractPropertyOfUmlComponentFromContractPropertyType(refiningComponent,
							contractId.getName());

			// Compose the name that the contract refinement should
			// have
			final String refinementName = contractId.getComponentName() + "." + refiningProperty.getName();

			// Check to see if the refinement is already linked to
			// the contract property
			boolean alreadyLinked = false;
			for (ContractRefinement contractRefinement : contractPropertyRefinements) {
				if (contractRefinement.getBase_DataType().getName().equals(refinementName)) {
					logger.debug("refinement already defined for the contract");

					// Set the flag to signal the contract
					// refinement is still used
					mapContractRefinements.put(contractRefinement.getBase_DataType().getQualifiedName(), Boolean.TRUE);
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
				final DataType umlRefinement = chessElementsUtil.getOrCreateContractRefinement(owner,
						contractId.getComponentName(), contractId.getName());
				contractEntityUtil.addContractRefinementToContractProperty(contractProperty, umlRefinement);

				// Store the new refinement
				addedElements.add(umlRefinement);
			}
		}

	}

	private void parseConnection(Connection connection, EList<Connector> existingConnectors,
			EList<Constraint> existingDelegationConstraints, HashMap<String, Boolean> mapConnectors,
			HashMap<String, Boolean> mapDelegationContraints, Class owner) {

		// CONNECTION processing
		// final Connection connection = dslRefInstance.getConnection();
		final VariableId variable = connection.getVariable();
		final ExtendedExpression constraint = (ExtendedExpression) connection.getConstraint();
		Connector connector = chessElementsUtil.getExistingConnector(existingConnectors, variable, constraint);

		if (connector != null) {
			logger.debug("connector already present");

			// Set the flag to signal the connector is still used
			mapConnectors.put(connector.getQualifiedName(), Boolean.TRUE);
			// continue;
			return;
		} else
		// It could be a delegation constraint, check it
		if (isDelegationConstraint(variable,constraint,owner)) {

			Constraint delegationConstraint = null;
			// String constraintText =
			// chessElementsUtil.getConstraintText(constraint);
			String constraintText = ossModelUtil.getOssElementAsString(constraint, true);
			if ((delegationConstraint = chessElementsUtil.getExistingDelegationConstraint(existingDelegationConstraints,
					variable, constraintText)) != null) {
				logger.debug("delegation constraint already present");

				// Set the flag to signal the delegation constraint
				// is still used
				mapDelegationContraints.put(delegationConstraint.getQualifiedName(), Boolean.TRUE);
				// continue;
				return;
			} else {
				logger.debug("delegation constraint is not present");

				// Create a delegation constraint, can be a
				// LogicalExpression, IntegerLiteral,
				// AddSubExpression, ...
				addedElements.add(chessElementsUtil.createUmlDelegationConstraint(owner, variable, constraintText));
				// continue;
				return;
			}
		} else if (chessElementsUtil.isSimpleConnection(variable, constraint)) {

			logger.debug("connector is not present");
			final String constraintName = ((PortId) constraint.getExpression()).getName();
			Property partWithPortOfConstraint = getPartWithPort((PortId) constraint.getExpression(), owner);
			final Class portOwnerOfConstraint = getPortOwner(partWithPortOfConstraint, owner);

			final String variableName = ((PortId) variable).getName();
			Property partWithPortOfVariable = getPartWithPort((PortId) variable, owner);
			final Class portOwnerOfVariable = getPortOwner(partWithPortOfVariable, owner);

			// Store the new connector
			addedElements.add(chessElementsUtil.createUmlConnector(constraintName, partWithPortOfConstraint,
					portOwnerOfConstraint, variableName, partWithPortOfVariable, portOwnerOfVariable, owner));
		} else if ((variable instanceof ParameterId) || (constraint.getExpression() instanceof ParameterId)) {
			// ParameterId not handled
			addImportError("Found a connection with a ParameterId, don't know how to handle it!");
		} else {
			addImportError("Found a connetion with a" + variable + ", don't know how to handle it!");
		}

	}

	boolean isDelegationConstraint(VariableId variable,ExtendedExpression constraint,Class owner){
		return  !(constraint.getExpression() instanceof PortId)
		|| (isFunctionBehavior(owner, variable) && isFunctionBehavior(owner, constraint.getExpression()));
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

	private Property getPartWithPort(PortId constraint, Class owner) {
		final EList<String> componentNames = (constraint).getComponentNames();

		Property partWithPort = null;

		if (componentNames != null && componentNames.size() != 0) {
			String portOwnerName = componentNames.get(0);
			partWithPort = entityUtil.getUMLComponentInstance(owner, portOwnerName);

		}
		return partWithPort;
	}

	private void parseSubComponent(SubComponent subComponent, HashMap<String, Boolean> mapComponentInstances,
			Class owner) {

		// SubComponent subComponent = dslRefInstance.getSubcomponent();
		// SUB processing
		final String subName = subComponent.getName();
		final String subType = ossModelUtil.getSubComponentTypeName(subComponent);
		final Type subComponentType = (Type) dslTypeToComponent.get(subType);
		logger.debug("\tsubcomponent name = " + subName);
		logger.debug("\tsubcomponent type = " + subType);

		// Retrieve the component instance from the owner, if any
		final Property componentInstance = entityUtil.getSubComponentInstance(owner, subName);

		if (componentInstance == null) {
			logger.debug("componentInstance not found, creating one");
			addedElements.add(chessElementsUtil.createUmlAssociation(subName, subComponentType, owner));
		} else {
			logger.debug("componentInstance already present");
			if (!componentInstance.getType().equals(subComponentType)) {
				// Add the association to the list of changes, it
				// needs to be redrawn
				addedElements.add(componentInstance.getAssociation());
			}
			chessElementsUtil.updateUmlAssociation(componentInstance, subComponent, subComponentType,
					mapComponentInstances);
		}

	}

	/**
	 * Creates a map with the formal properties text and the objects
	 * 
	 * @param existingFormalProperties
	 *            the list of constraints of the object
	 * @return the requested map
	 */
	// FIXME: this works only if expressions are different, otherwise they'll be
	// overwritten
	private HashMap<String, FormalProperty> prepareFormalPropertiesMap(EList<Constraint> existingFormalProperties) {
		final HashMap<String, FormalProperty> map = Maps.newHashMapWithExpectedSize(existingFormalProperties.size());

		// If the constaint is a formal property, store it
		for (Constraint constraint : existingFormalProperties) {
			final FormalProperty formalProperty = entityUtil.getFormalProperty(constraint);
			if (formalProperty != null) {
				map.put(entityUtil.getFormalPropertyStr(formalProperty), formalProperty);
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
		final EList<NamedElement> existingPorts = (EList<NamedElement>) chessSystemModel.getNonStaticPorts(owner);
		existingPorts.addAll((Collection<? extends NamedElement>) chessSystemModel.getStaticPorts(owner));

		// Prepare the map to mark existing ports
		final HashMap<String, Boolean> mapPorts = Maps.newHashMapWithExpectedSize(existingPorts.size());
		for (NamedElement port : existingPorts) {
			mapPorts.put(port.getQualifiedName(), null);
		}

		// Get all the existing contract properties
		final EList<ContractProperty> existingContractProperties = (EList<ContractProperty>) chessSystemModel
				.getContractsOfComponent(owner);

		// Prepare the map to mark existing contracts
		final HashMap<String, Boolean> mapContractProperties = Maps
				.newHashMapWithExpectedSize(existingContractProperties.size());
		for (ContractProperty contractProperty : existingContractProperties) {
			mapContractProperties.put(contractProperty.getBase_Property().getQualifiedName(), null);
		}

		// Get all the interface formal properties
		final EList<Constraint> existingFormalProperties = (EList<Constraint>) chessSystemModel
				.getInterfaceAssertions(owner);

		// Create an hash map for the existing formal properties
		final HashMap<String, FormalProperty> hashFormalProperties = prepareFormalPropertiesMap(
				existingFormalProperties);

		// Prepare the map to mark existing formal properties
		final HashMap<String, Boolean> mapFormalProperties = Maps
				.newHashMapWithExpectedSize(existingFormalProperties.size());
		for (Constraint formalProperty : existingFormalProperties) {
			mapFormalProperties.put(formalProperty.getQualifiedName(), null);
		}

		// Get all the functionBehaviors
		final EList<Behavior> existingFunctionBehaviors = owner.getOwnedBehaviors();

		// Prepare the map to mark existing functionBehaviors
		final HashMap<String, Boolean> mapFunctionBehaviors = Maps
				.newHashMapWithExpectedSize(existingFunctionBehaviors.size());
		for (Behavior behavior : existingFunctionBehaviors) {
			mapFunctionBehaviors.put(behavior.getQualifiedName(), null);
		}

		// If some InterfaceInstances are present, loop on them
		if ((dslIntInstances != null) && !dslIntInstances.isEmpty()) {
			for (InterfaceInstance dslIntInstance : dslIntInstances) {

				// Process the different types of interfaces
				if (containsVariable(dslIntInstance)) {

					final Variable dslVariable = dslIntInstance.getVariable();

					if (dslVariable instanceof Port) {
						parsePort(dslVariable, existingPorts, mapPorts, owner);

					} else if (dslVariable instanceof Parameter) {
						parseParameter(dslVariable, mapFunctionBehaviors, existingPorts, mapPorts, owner);

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
					parseContract(dslIntInstance.getContract(), hashFormalProperties, mapFormalProperties,
							mapContractProperties, owner);
				} else if (containsAssertion(dslIntInstance)) {
					// ASSERTION processing
					parseAssertion(dslIntInstance.getAssertion(), hashFormalProperties, mapFormalProperties, owner);
				} else if (dslIntInstance != null) {
					addImportError("Found a " + getTextOfTag(dslIntInstance) + " tag, don't know how to handle it!");
				}
			}
		}

		// Ports cleanup time
		for (String qualifiedElement : mapPorts.keySet()) {
			if (mapPorts.get(qualifiedElement) == null) {
				// System.out.println("port " + qualifiedElement + " should be
				// removed");
				entityUtil.removePort(existingPorts, qualifiedElement);
			}
		}

		// Contracts cleanup time
		// ** Contract instances and contract types are removed, but not their
		// formal properties and refinements!
		for (String qualifiedElement : mapContractProperties.keySet()) {
			if (mapContractProperties.get(qualifiedElement) == null) {
				// System.out.println("contractProperty " + qualifiedElement + "
				// should be removed");
				contractEntityUtil.removeContractProperty(existingContractProperties, qualifiedElement);
			}
		}

		// Formal properties cleanup time
		for (String qualifiedElement : mapFormalProperties.keySet()) {
			if (mapFormalProperties.get(qualifiedElement) == null) {
				// System.out.println("formalProperty " + qualifiedElement + "
				// should be removed");
				entityUtil.removeFormalProperty(existingFormalProperties, qualifiedElement);
			}
		}

		// FunctionBehavior cleanup time
		for (String qualifiedElement : mapFunctionBehaviors.keySet()) {
			if (mapFunctionBehaviors.get(qualifiedElement) == null) {
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

	private void parseAssertion(Assertion assertion, HashMap<String, FormalProperty> hashFormalProperties,
			HashMap<String, Boolean> mapFormalProperties, Class owner) {

		final String assertionName = assertion.getName();
		final String assertionText = ossModelUtil.getOssElementAsString(assertion.getConstraint(), true);

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
						mapFormalProperties);
			}
		}

	}

	private void parseContract(Contract dslContract, HashMap<String, FormalProperty> hashFormalProperties,
			HashMap<String, Boolean> mapFormalProperties, HashMap<String, Boolean> mapContractProperties, Class owner) {
		// parseContract();
		// final Contract dslContract = dslIntInstance.getContract();
		final Assumption dslAssumption = dslContract.getAssumption();
		final Guarantee dslGuarantee = dslContract.getGuarantee();
		String ossAssumptionText = ossModelUtil.getOssElementAsString(dslAssumption.getConstraint(), true);
		String ossGuaranteeText = ossModelUtil.getOssElementAsString(dslGuarantee.getConstraint(), true);
		final String contractName = dslContract.getName();
		// Retrieve the contract type from the owner, if any
		Class umlContract = (Class) owner.getOwnedMember(contractName, false,
				UMLFactory.eINSTANCE.createClass().eClass());

		if (umlContract == null) {
			logger.debug("contract non found, creating one");
			addedElements.add(chessElementsUtil.createUmlContract(contractName, ossAssumptionText, ossGuaranteeText,
					hashFormalProperties, owner));
		} else {
			logger.debug("Contract already present");
			chessElementsUtil.updateUmlContract(umlContract, ossAssumptionText, ossGuaranteeText, mapContractProperties,
					mapFormalProperties, owner);
		}

	}

	private void parsePort(Variable dslVariable, EList<NamedElement> existingPorts, HashMap<String, Boolean> mapPorts,
			Class owner) throws ImportException {
		// PORT processing
		final VariableId dslVariableID = dslVariable.getId();
		final EObject dslVariableType = ((Port) dslVariable).getType();

		// Version that updates the port
		// Loop on all the ports to see if it is already existing
		org.eclipse.uml2.uml.Port port = chessElementsUtil.getExistingUmlPort(dslVariableID.getName(), existingPorts);

		if (port != null) {
			chessElementsUtil.updateUmlPort(port, dslVariable, dslVariableType, owner, mapPorts);
		} else {
			logger.debug("Port not found, creating it");

			if (dslVariable instanceof InputPort) {
				addedElements
						.add(chessElementsUtil.createUmlNonStaticPort(owner, dslVariableID, dslVariableType, true));
			} else if (dslVariable instanceof OutputPort) {
				addedElements
						.add(chessElementsUtil.createUmlNonStaticPort(owner, dslVariableID, dslVariableType, false));
			}
		}

	}

	private void parseParameter(Variable dslVariable, HashMap<String, Boolean> mapFunctionBehaviors,
			EList<NamedElement> existingPorts, HashMap<String, Boolean> mapPorts, Class owner) throws ImportException {

		// PARAMETER processing
		final VariableId dslVariableID = dslVariable.getId();
		final EObject dslVariableType = (((Parameter) dslVariable).getType());

		// Check if there are optional parameters to detect how to handle it
		final EList<SimpleType> parameters = ((Parameter) dslVariable).getParameters();
		if (parameters.size() != 0) {
			parseParameterAsUmlFunctionBehaviour(dslVariableID, dslVariableType, parameters, mapFunctionBehaviors,
					owner);
		} else {
			parseParameterAsUmlStaticPort(dslVariableID, dslVariableType, existingPorts, mapPorts, owner);
		}

	}

	private void parseParameterAsUmlStaticPort(VariableId dslVariableID, EObject dslVariableType,
			EList<NamedElement> existingPorts, HashMap<String, Boolean> mapPorts, Class owner) throws ImportException {
		// Convert the parameter to a static port
		// Check if the port is already present
		String ossPortName = dslVariableID.getName();
		//Type ossPortType = ossElementsUtil.getOrCreateTypeFromOssType(dslVariableType, owner.getNearestPackage());
		org.eclipse.uml2.uml.Port port = chessElementsUtil.getExistingUmlPort(ossPortName, dslVariableType, existingPorts,owner.getNearestPackage());

		/*
		 * for (Object object : existingPorts) { final org.eclipse.uml2.uml.Port
		 * tmpPort = (org.eclipse.uml2.uml.Port) object; if
		 * (tmpPort.getName().equals(dslVariableID.getName()) &&
		 * tmpPort.getType().getName().equals().getName())) { port = tmpPort;
		 * break; // Port found } }
		 */

		if (port != null) {
			logger.debug("Port already present");
			chessElementsUtil.updateUmlPort(port, dslVariableType, mapPorts);
		} else {
			// Create the port and mark it
			addedElements.add(chessElementsUtil.createUmlStaticPort(owner, dslVariableID, dslVariableType));
			// continue;
		}

	}

	private void parseParameterAsUmlFunctionBehaviour(VariableId dslVariableID, EObject dslVariableType,
			EList<SimpleType> parameters, HashMap<String, Boolean> mapFunctionBehaviors, Class owner) {

		// Check if the functionBehavior is already present
		FunctionBehavior functionBehavior = (FunctionBehavior) owner.getOwnedBehavior(dslVariableID.getName());

		if (functionBehavior == null) {
			logger.debug("functionBehavior not found, creating one");
			addedElements.add(
					chessElementsUtil.createUmlFunctionBehaviour(dslVariableID, dslVariableType, parameters, owner));
		} else {
			logger.debug("functionBehavior already present");
			chessElementsUtil.updateUmlFunctionBehaviour(functionBehavior, dslVariableType, parameters,
					mapFunctionBehaviors);
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
	 * @throws ImportException
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
	public StringBuffer startParsing(Package pkg, File ossFile) throws Exception, ImportException, IOException {
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
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(pkg);
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {

				String blockQualifiedName = pkg.getQualifiedName() + "::" + dslSystemComponentName;
				Class systemComponent = null;
				if (!mapBlocks.containsKey(blockQualifiedName)) {
					logger.debug("block not present: " + blockQualifiedName);

					// Add a new systemComponent to the package
					systemComponent = chessElementsUtil.createSystemBlock(sysView, dslSystemComponent.getType());

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
						component = chessElementsUtil.createBlock(sysView, dslComponent.getType());

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
					return;
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
