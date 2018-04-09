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

import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.xtext.serializer.ISerializer;
import org.polarsys.chess.OSSImporter.exceptions.ImportException;
import org.polarsys.chess.OSSImporter.utils.TypeUtil;
import org.polarsys.chess.contracts.profile.chesscontract.ContractProperty;
import org.polarsys.chess.contracts.profile.chesscontract.ContractRefinement;
import org.polarsys.chess.contracts.profile.chesscontract.FormalProperty;
import org.polarsys.chess.contracts.profile.chesscontract.util.ContractEntityUtil;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;
import org.polarsys.chess.service.core.model.ChessSystemModel;

import com.google.common.collect.Maps;
import com.google.inject.Injector;

import eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.core.services.OSSModelFactory;
import eu.fbk.eclipse.standardtools.xtextService.core.utils.XTextResourceUtil;
import eu.fbk.tools.editor.basetype.baseType.*;
import eu.fbk.tools.editor.contract.contract.Assumption;
import eu.fbk.tools.editor.contract.contract.Contract;
import eu.fbk.tools.editor.contract.contract.Guarantee;
import eu.fbk.tools.editor.contract.expression.expression.*;
import eu.fbk.tools.editor.oss.oss.SystemComponent;
import eu.fbk.tools.editor.oss.oss.Variable;
import eu.fbk.tools.editor.oss.oss.AbstractComponent;
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

import org.eclipse.papyrus.sysml.portandflows.FlowDirection;
import org.eclipse.papyrus.sysml.portandflows.FlowPort;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.service.types.utils.ElementUtil;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerPage;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerPageBookView;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerView;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;

public class ImportOSSFileAction {

	// The instance of this class
	private static ImportOSSFileAction classInstance;

	private static final String DELEGATION_PREFIX = "Define_";
	private static final String DELEGATION_CONSTRAINT_NAME = "constraintSpec";
	private static final String CONNECTOR_NAME = "connector";
	private static final String ASSOCIATION_NAME = "association";
	private static final String DELETE_COMMAND_ID = "org.eclipse.ui.edit.delete";

	private static final String MODELEXPLORER_VIEW_ID = "org.eclipse.papyrus.views.modelexplorer.modelexplorer";
	
	private final ChessSystemModel chessSystemModel = ChessSystemModel.getInstance();
	
	private final ContractEntityUtil contractEntityUtil = ContractEntityUtil.getInstance();
	private final EntityUtil entityUtil = EntityUtil.getInstance();
	private final TypeUtil typeUtil = TypeUtil.getInstance();
	
	// Will contain elements being added to the model, big enough
	private final EList<Element> addedElements = new BasicEList<>(2000);	 
	
	private final Injector injector = XTextResourceUtil.getInstance().getOssInjector();
	private final ISerializer serializer = injector.getInstance(ISerializer.class);
	private Package sysView = null;

	// Map the name of the component with the Component object
	private Map<String, Class> dslTypeToComponent;

	// A possible exception that could happen during parsing
	private ImportException importException;

	// Logger for messages
	private static final Logger logger = Logger.getLogger(ImportOSSFileAction.class);
	
	/**
	 * Gets an instance of the class if already present, or a new one if not.
	 * @return the instance of this class
	 */
	public static ImportOSSFileAction getInstance() {
		if (classInstance == null) {
			classInstance = new ImportOSSFileAction();
		}
		return classInstance;
	}
	
	/**
	 * Returns the number or defined associations for the given package.
	 * @param pkg the package to analyze
	 * @return the number of associations found in package
	 */
	private int countPackageAssociations(Package pkg) {
		int counter = 0;
		
		EList<NamedElement> namedList = pkg.getOwnedMembers();
		for (NamedElement namedElement : namedList) {
			if (namedElement instanceof Association) {
				counter++;
			}
		}
		return counter;
	}
	
	/**
	 * Creates an association between the given owner and element. It will also create the relative
	 * component instance inside the owner element.
	 * @param owner the parent Class
	 * @param elementName the name of the end element
	 * @param elementType the type of the end element
	 * @return the created Association
	 */
	private Association createAssociation(Class owner, String elementName, Type elementType) {
		
		// Create the name using an incremental value
		final String associationName = ASSOCIATION_NAME + (countPackageAssociations(owner.getNearestPackage()) + 1);

		logger.debug("\n\n\n Creating association " + associationName + " for owner " + owner);
		logger.debug("elementName = " + elementName + " with type " + elementType);
		logger.debug("\n\n\n");
	
		// Create the association and adds it to the owning package
		final Association association = owner.createAssociation(
				true, AggregationKind.get(AggregationKind.COMPOSITE), elementName, 1, 1, elementType, 
				false, AggregationKind.get(AggregationKind.NONE), owner.getName().toLowerCase(), 1, 1);

		association.setName(associationName);
		
		// Add SysML Nature on the new Association
		ElementUtil.addNature(association, SysMLElementTypes.SYSML_NATURE);
		
		logger.debug("\n\nCreated " + associationName + " Association\n\n");
		return association;
	}
 	
	//TODO create a new class e.g. CHESSElementsUtil and move this method there
	/** 
	 * Creates and adds a Contract Property to the model.
	 * @param owner the parent Class
	 * @param elementName the name of the property to create
	 * @param elementType the type of the property to create
	 * @return the created Property
	 */
	private Property createContractProperty(Class owner, String elementName, Type elementType) {
		
		logger.debug("\n\n\n Creating contract property " + elementName + " for owner " + owner + " with type " + elementType);
		logger.debug("\n\n\n");

		Property newUMLProperty = owner.createOwnedAttribute(elementName, elementType);
//		UMLUtils.applyStereotype(newUMLProperty, CONTRACT_PROP);
		newUMLProperty.applyStereotype(typeUtil.contractPropertyStereotype);
		
		logger.debug("\n\nCreated " + elementName + " Property\n\n");
		return newUMLProperty;
	}
	
	/**
	 * Creates the Delegation Constraint value.
	 * @param variable the left part of the expression
	 * @param constraint the right part of the expression
	 * @return a string with the expression
	 */
	private String createDelegationConstraintText(VariableId variable, Expression constraint) {
		final StringBuffer delegationText = new StringBuffer();

		EList<String> componentNames = variable.getComponentNames();
		
		if (componentNames != null && componentNames.size() != 0) {
			delegationText.append(componentNames.get(0) + ".");
		}
		
//		if (variable.getComponentName() != null)
//			delegationText.append(variable.getComponentName() + ".");
		
		delegationText.append(variable.getName() + " := " + getConstraintText(constraint));
		
		return delegationText.toString();
	}
			
	/** 
	 * Creates and adds a Delegation Constraint to the model.
	 * @param owner the parent Class
	 * @param connection the Connection defining the delegation
	 * @param variable the target of the connection
	 * @param constraint the source of the connection
	 * @return the created delegation constraint 
	 */
	private Constraint createDelegationConstraint(Class owner, VariableId variable, Expression constraint) {		
		final StringBuffer delegationName = new StringBuffer(DELEGATION_PREFIX);
		
		EList<String> componentNames = variable.getComponentNames();
		
		if (componentNames != null && componentNames.size() != 0) {
			delegationName.append(componentNames.get(0) + ".");
		}

//		if (variable.getComponentName() != null)
//			delegationName.append(variable.getComponentName() + ".");

		delegationName.append(variable.getName());
		
		logger.debug("\n\n\n Creating delegation constraint " + delegationName + " for owner " + owner);
		logger.debug("\n\n\n");

		Constraint newUMLConstraint = owner.createOwnedRule(delegationName.toString());
//		UMLUtils.applyStereotype(newUMLConstraint, DELEGATION_CONST);
		newUMLConstraint.applyStereotype(typeUtil.delegationConstraintStereotype);
		
		LiteralString literalString = UMLFactory.eINSTANCE.createLiteralString();
		literalString.setName(DELEGATION_CONSTRAINT_NAME);
		final String formalPropertyText = createDelegationConstraintText(variable, constraint);
		literalString.setValue(formalPropertyText);
		newUMLConstraint.setSpecification(literalString);

		logger.debug("\n\nCreated " + delegationName + " Delegation Constraint\n\n");
		return newUMLConstraint;
	}

	// METHODS NO MORE USED
//	/**
//	 * Returns the contract with the given name.
//	 * @param umlComponent the component containing the contract
//	 * @param contractName the name of the contract
//	 * @return the UML class of the contract
//	 */
//	private Class getUMLContractFromContractName(Class umlComponent, String contractName) {
//		return (Class) umlComponent.getNestedClassifier(contractName);
//	}
//
//	
//	/** 
//	 * Returns the contract property generated by the given contract name.
//	 * @param component the component containing the contract
//	 * @param contractName the name of the contract
//	 * @return the associated Contract Property
//	 */
//	private ContractProperty getContractPropertyFromContract(Class component, String contractName) {
//		
//		// Get the contract definition from the component
//		final Class umlContract = getUMLContractFromContractName(component, contractName);
//		
//		// Get the contract property name, derived from the contract name
//		final String contractPropertyName = createContractPropertyNameFromContract(umlContract);
//			
//		// Get the contract property from the component, generic type
//		final Property umlProperty = component.getOwnedAttribute(contractPropertyName, umlContract);
//				
//		// Return the correct type of object
//		return contractEntityUtil.getContractProperty(umlProperty);
//	}
	
	/**
	 *  Returns the contract refinement associated to the component.
	 *  @param owner of the contract refinement
	 *  @param refinementName the name of the contract refinement
	 *  @return the UML contract refinement
	 */
	private DataType getExistingUMLContractRefinement(Class owner, String refinementName) {
		return (DataType) owner.getNestedClassifier(refinementName);
	}

	//TODO move to entityutils class
	/**
	 * Returns the component instance with the given name.
	 * @param owner the class owning the instance
	 * @param componentName the name of the instance
	 * @return the UML property representing the component instance
	 */
	private Property getUMLComponentInstance(Class owner, String componentName) {
		
		for (Property umlProperty : (owner.getAttributes())) {
			if (umlProperty.getName().equals(componentName) && entityUtil.isComponentInstance(umlProperty)) {
				return umlProperty;
			}
		}
		return null;
	}
	
	/** 
	 * Creates a ContractRefinement for the given owner component.
	 * The refinement should specify the component instance that contains the original contract property
	 * and the contract property itself 
	 *  
	 * @param owner the container of the refinement
	 * @param componentName the component instance containing the contract property
	 * @param contractName the type of the contract
	 * @return the created DataType 
	 */
	private DataType createContractRefinement(Class owner, String componentName, String contractName) {
					
		logger.debug("\n\n\n Creating contract refinement for componentName = " + componentName + " of contract " + contractName);
		logger.debug("\n\n\n");
				
		// The component instance containing the refining contract
		final Property refiningComponentInstance = getUMLComponentInstance(owner, componentName);

		// The component type where the contract property is defined
		final Class refiningComponent = (Class) refiningComponentInstance.getType();
		
		// The instance of the refining contract
		//final ContractProperty refiningContractProperty = getContractPropertyFromContract(refiningComponent, contractName);
		final Property umlContractProperty = contractEntityUtil.getUmlContractPropertyOfUmlComponentFromContractPropertyType(refiningComponent, contractName);
		final ContractProperty refiningContractProperty = contractEntityUtil.getContractProperty(umlContractProperty);

		// Compose the correct name of the contract refinement 
		final String refinementName = componentName + "." + umlContractProperty.getName();
		
		// Check if the refinement is already present
		final DataType umlRefinement = getExistingUMLContractRefinement(owner, refinementName);
		
		if (umlRefinement != null) {
			return umlRefinement;
		} else {
			logger.debug("\n\n Creating contract refinement " + refinementName + " for owner " + owner.getName());
			logger.debug("\n\n");
	
			//TODO create a new class e.g. CHESSElementsUtil and move this method there
			final DataType newUmlDataType = UMLFactory.eINSTANCE.createDataType();
			Classifier newClass = owner.createNestedClassifier(refinementName, newUmlDataType.eClass());
//			Stereotype stereotype = UMLUtils.applyStereotype(newClass, CONTRACT_REFINEMENT);
//			ContractRefinement contractRefinement = (ContractRefinement) newClass.getStereotypeApplication(stereotype);
			newClass.applyStereotype(typeUtil.contractRefinementStereotype);
			final ContractRefinement contractRefinement = (ContractRefinement) newClass.getStereotypeApplication(typeUtil.contractRefinementStereotype);

			// Set the correct links for the refinement
			contractRefinement.setInstance(refiningComponentInstance); // The component instance containing the definition
			contractRefinement.setContract(refiningContractProperty);  // The contract property that refines the contract
					
			logger.debug("\n\nCreated " + refinementName + " Contract Refinement\n\n");
			return (DataType) newClass;
		}
	}

	//TODO create a new class e.g. CHESSElementsUtil and move this method there
	/** 
	 * Returns the correct Type given the DSL SimpleType.
	 * @param dslSimpleType the type from OSS
	 * @return the UML Type
	 */
	private Type getTypeFromDSLType(SimpleType dslSimpleType) {
		
		if (dslSimpleType instanceof BooleanType) {
			logger.debug("BooleanType");
			return typeUtil.getPrimitiveType("Boolean");
		} else if (dslSimpleType instanceof IntegerType) {
			logger.debug("IntegerType");
			return typeUtil.getPrimitiveType("Integer");
		} else if (dslSimpleType instanceof RealType) {
			logger.debug("RealType");
			return typeUtil.getPrimitiveType("Real");
		} else if (dslSimpleType instanceof WordType) {
			logger.debug("WordType");
		} else if (dslSimpleType instanceof UnsignedWordType) {
			logger.debug("UnsignedWordType");
		} else if (dslSimpleType instanceof SignedWordType) {
			logger.debug("SignedWordType");
		} else if (dslSimpleType instanceof ContinuousType) {
			logger.debug("ContinuousType");
			return typeUtil.getContinuousType("Continuous");
		} else if (dslSimpleType instanceof EventType) {
			logger.debug("EventType");
			return typeUtil.getSignalType(sysView);
		} else if (dslSimpleType instanceof RangeType) {
			logger.debug("RangeType");
			return typeUtil.getBoundedSubType((RangeType) dslSimpleType, sysView);
		} else if (dslSimpleType instanceof EnumType) {
			logger.debug("EnumType");
			return typeUtil.getEnumerationType((EnumType) dslSimpleType, sysView);
		} else if (dslSimpleType instanceof ArrayType) {
			logger.debug("ArrayType");
		} else if (dslSimpleType instanceof IntegerArrayType) {
			logger.debug("IntegerArrayType");
		} else if (dslSimpleType instanceof WordArrayType) {
			logger.debug("WordArrayType");
		}
		logger.error("Import Error: Not able to map the requested DSL type!");
		return null;
	}
	
	/** 
	 * Creates and adds a non-static Port to the model.
	 * @param owner the parent Class
	 * @param elementName the name of the port to create
	 * @param elementType the type of the port to create
	 * @param isInput tells the direction of the flow
	 * @return the created Port
	 * @throws ImportException 
	 */
	//TODO create a new class e.g. CHESSElementsUtil and move this method there
	private org.eclipse.uml2.uml.Port createNonStaticPort(Class owner, VariableId elementName, SimpleType elementType, boolean isInput) throws ImportException {
		final String portName = elementName.getName();
		final Type portType = getTypeFromDSLType(elementType);
		
		if(portType == null) {
			throw new ImportException("Not able to map the requested type for port : " + portName);
//			return null;	// Create the port anyway, without type
		}
		
		org.eclipse.uml2.uml.Port umlPort = UMLFactory.eINSTANCE.createPort();
		umlPort.setName(portName);
		umlPort.setType(portType);
		owner.getOwnedPorts().add(umlPort);
//		Stereotype stereotype = UMLUtils.applyStereotype(umlPort, FLOWPORT);
		umlPort.applyStereotype(typeUtil.flowPortStereotype);
		umlPort.setAggregation(AggregationKind.get(AggregationKind.COMPOSITE));
//		FlowPort flowPort = (FlowPort) umlPort.getStereotypeApplication(stereotype);
		FlowPort flowPort = (FlowPort) umlPort.getStereotypeApplication(typeUtil.flowPortStereotype);
		flowPort.setDirection(isInput? FlowDirection.IN: FlowDirection.OUT);
		
		// This version is nicer but a little slower
//		org.eclipse.uml2.uml.Port umlPort = owner.createOwnedPort(portName, portType);
//		Stereotype stereotype = UMLUtils.applyStereotype(umlPort, FLOWPORT);
//		umlPort.setAggregation(AggregationKind.get(AggregationKind.COMPOSITE));
//		FlowPort flowPort = (FlowPort) umlPort.getStereotypeApplication(stereotype);
//		flowPort.setDirection(isInput? FlowDirection.IN: FlowDirection.OUT);
		
		logger.debug("\n\nCreated " + portName + " Port\n\n");
		return umlPort;
	}
	
	/** 
	 * Creates and adds a static Port to the model.
	 * @param owner the parent Class
	 * @param elementName the name of the port to create
	 * @param elementType the type of the port to create
	 * @return the created Port
	 * @throws ImportException 
	 */
	//TODO create a new class e.g. CHESSElementsUtil and move this method there
	private org.eclipse.uml2.uml.Port createStaticPort(Class owner, VariableId elementName, SimpleType elementType) throws ImportException {
		final String portName = elementName.getName();
		final Type portType = getTypeFromDSLType(elementType);
		
		if(portType == null) {
			throw new ImportException("Not able to map the requested type for port : " + portName);
		}
		
		org.eclipse.uml2.uml.Port umlPort = UMLFactory.eINSTANCE.createPort();
		umlPort.setName(portName);
		umlPort.setType(portType);
		owner.getOwnedPorts().add(umlPort);
//		Stereotype stereotype = UMLUtils.applyStereotype(umlPort, FLOWPORT);
		umlPort.applyStereotype(typeUtil.flowPortStereotype);
		umlPort.setAggregation(AggregationKind.get(AggregationKind.COMPOSITE));
//		FlowPort flowPort = (FlowPort) umlPort.getStereotypeApplication(stereotype);
		FlowPort flowPort = (FlowPort) umlPort.getStereotypeApplication(typeUtil.flowPortStereotype);
		flowPort.setDirection(FlowDirection.INOUT);
		umlPort.setIsStatic(true);
		
		logger.debug("\n\nCreated " + portName + " Port\n\n");
		return umlPort;
	}
	
	//TODO create a new class e.g. CHESSElementsUtil and move this method there
	/** 
	 * Creates a System Block element in the given package.
	 * @param owner the Package that will contain the element
	 * @param elementName the name of the new System Block
	 * @return the created Class
	 */
	private Class createSystemBlock(Package owner, final String elementName) {

		Class sysBlock = owner.createOwnedClass(elementName, false);
//		UMLUtils.applyStereotype(sysBlock, BLOCK);
//		UMLUtils.applyStereotype(sysBlock, SYSTEM);
		sysBlock.applyStereotype(typeUtil.blockStereotype);
		sysBlock.applyStereotype(typeUtil.systemStereotype);
		
		logger.debug("\n\nCreated " + elementName + " System Block\n\n");
		return sysBlock;
	}
	
	//TODO create a new class e.g. CHESSElementsUtil and move this method there
	/** 
	 * Creates a Contract element.
	 * @param owner the Class that will contain the element
	 * @param contractName the name of the new Contract
	 * @return the newly created Class
	 */
	private Class createContract(Class owner, String contractName) {

		logger.debug("\n\n\n Creating contract " + contractName + " for owner " + owner);
		logger.debug("\n\n\n");

		Class newUmlClass = UMLFactory.eINSTANCE.createClass();
		Classifier newClass = owner.createNestedClassifier(contractName, newUmlClass.eClass());
//		UMLUtils.applyStereotype(newClass, CONTRACT);
		newClass.applyStereotype(typeUtil.contractStereotype);
		
		logger.debug("\n\nCreated " + contractName + " Property\n\n");
		return (Class) newClass;
	}
	
	//TODO create a new class e.g. CHESSElementsUtil and move this method there
	/** 
	 * Creates a Block element in the given package.
	 * @param owner the Package that will contain the element
	 * @param elementName the name of the new Block
	 * @return the newly created Class
	 */
	private Class createBlock(Package owner, final String elementName) {

		Class umlClass = owner.createOwnedClass(elementName, false);
//		UMLUtils.applyStereotype(umlClass, BLOCK);
		umlClass.applyStereotype(typeUtil.blockStereotype);
		
//		owner.createPackagedElement(elementName, newUMLClass.eClass()); This also works...
//		owner.getPackagedElements().add(newUMLClass);	// This works too!
		
		logger.debug("\n\nCreated " + elementName + " Block\n\n");
		return umlClass;	// Return the first occurence
	}
	
	/** 
	 * Adds a contract refinement to a contract property.
	 * @param contractProperty the property to be enriched
	 * @param umlRefinement the refinement to add
	 */
	private void addContractRefinementToContractProperty(ContractProperty contractProperty, DataType umlRefinement) {
		final Stereotype stereotype = umlRefinement.getAppliedStereotype(TypeUtil.CONTRACT_REFINEMENT);	
		final ContractRefinement contractRefinement = (ContractRefinement) umlRefinement.getStereotypeApplication(stereotype);
		
		// Add the new refinement to the list
		contractProperty.getRefinedBy().add(contractRefinement);
	}
	
	//TODO create a new class e.g. CHESSElementsUtil and move this method there
	/**
	 * Creates a connector, but doesn't add it to the owner.
	 * @param owner the owner element
	 * @return the created Connector
	 */
	private Connector createConnector(Class owner) {
		
		// Create the name using an incremental value
		final String connectorName = CONNECTOR_NAME + (owner.getOwnedConnectors().size() + 1);
		
		logger.debug("\n\n\n Creating connector " + connectorName + " for owner " + owner);
		logger.debug("\n\n\n");

		Connector connector = UMLFactory.eINSTANCE.createConnector();
		connector.setName(connectorName);
		
		logger.debug("\n\nCreated " + connectorName + " Connector\n\n");
		return connector;	
	}

	/**
	 * Adds a connector to the given element.
	 * @param owner the owner element
	 * @param connector the conne
	 */
	private void addConnector(Class owner, Connector connector) {
		
		// Add the new connector to the list
		owner.getOwnedConnectors().add(connector);
	}
	
	/**
	 * Creates an end to the given connector.
	 * @param owner the owner element
	 * @param connector the owner Connector
	 * @param sourceOwner the name of component instance owning the port
	 * @param sourcePort the name of the port to be connected
	 * @return the Connector End
	 */
	private ConnectorEnd createConnectorEnd(Class owner, Connector connector, String sourceOwner, String sourcePort) {
		
		ConnectorEnd end = connector.createEnd();

		if (sourceOwner == null) {

			// I'm the owner of the port
			org.eclipse.uml2.uml.Port port = owner.getOwnedPort(sourcePort, null);
			end.setRole(port);
			end.setPartWithPort(null);
		} else {

			// Retrieve the component instance containing the port and set it
			Property componentInstance = getUMLComponentInstance(owner, sourceOwner);
			end.setPartWithPort(componentInstance);

			// Now I have to get the port object from the owning element
			// Get the component type
			String typeName = componentInstance.getType().getName();

			// Get the component object containing the definition of the port
			final Class portOwner = dslTypeToComponent.get(typeName);

			// Get the port and set it
			org.eclipse.uml2.uml.Port port = portOwner.getOwnedPort(sourcePort, null);
			end.setRole(port);
		}

		return end;
	}
	
	/**
	 * Returns the Connector with the given ends if present among a list of Connectors
	 * @param connectors the list of Connectors to scan
	 * @param variable the first end of the Connector
	 * @param constraint the second end of the Connector
	 * @return the Connector, if found
	 */
	private Connector getExistingConnector(EList<Connector> connectors, VariableId variable, Expression constraint) {

		// Details of the connector ends
		String variablePortOwner = null;
		String variablePortName = null;
		String constraintPortOwner = null;
		String constraintPortName = null;
		
		if (variable instanceof PortId) {
			
			// Get the component name, should be at max one
			EList<String> componentNames = ((PortId) variable).getComponentNames();
			if (componentNames != null && componentNames.size() != 0) {
				variablePortOwner = componentNames.get(0);
			}
			variablePortName = ((PortId) variable).getName();					
		} else {
			return null;
		}

		if (constraint instanceof PortId) {
			
			// Get the component name, should be at max one
			EList<String> componentNames = ((PortId) constraint).getComponentNames();
			if (componentNames != null && componentNames.size() != 0) {
				constraintPortOwner = componentNames.get(0);
			}
			constraintPortName = ((PortId) constraint).getName();
		} else {
			return null;
		}
		
		// Loop on all the connectors to find one with same values
		for (Connector connector : connectors) {
			final EList<ConnectorEnd> ends = connector.getEnds();
			if (ends.size() == 2) {
				final Property sourceOwner = ends.get(0).getPartWithPort();	// Should be the owner of the port
				final org.eclipse.uml2.uml.Port sourcePort = (org.eclipse.uml2.uml.Port) ends.get(0).getRole();	// Should be the port
				
				if (sourcePort.getName().equals(constraintPortName) && (sourceOwner == null || sourceOwner.getName().equals(constraintPortOwner))) {

					// One end is correct, go on with the second
					final Property targetOwner = ends.get(1).getPartWithPort();	// Should be the owner of the port
					final org.eclipse.uml2.uml.Port targetPort = (org.eclipse.uml2.uml.Port) ends.get(1).getRole();	// Should be the port

					if (targetPort.getName().equals(variablePortName) && (targetOwner == null || targetOwner.getName().equals(variablePortOwner))) {
						return connector;					
					}
				}					
			}
		}
		return null;	
	}
	
	/**
	 * Returns the delegation constraint with the given specs from a list
	 * @param delegationConstraints the list of delegation constraints to scan
	 * @param variable variable part
	 * @param constraint costraint part
	 * @return the delegation constraint, if found
	 */
	private Constraint getExistingDelegationConstraint(EList<Constraint> delegationConstraints, VariableId variable, Expression constraint) {

		// Text of the delegation constraint
		final String formalPropertyText = createDelegationConstraintText(variable, constraint);
		
		// Loop on all the delegation constraints to find one with same text
		for (Constraint delegationConstraint : delegationConstraints) {
			final LiteralString specification = (LiteralString) delegationConstraint.getSpecification();
			if (specification.getValue().equals(formalPropertyText)) {
				return delegationConstraint;
			}
		}
		return null;
	}
	
	/**
	 * Removes a contract property from the list
	 * @param members the list of members
	 * @param qualifiedElement the qualified name of the contract property to remove
	 */
	private void removeContractProperty(EList<ContractProperty> members, String qualifiedElement) {
		for (ContractProperty element : members) {
			if (element.getBase_Property().getQualifiedName().equals(qualifiedElement)) {
				try {
//					((Element) element.getBase_Property()).destroy();	//TODO: investigate this line!
					deleteElementInTheModel(element.getBase_Property());
				} catch (Exception e) {
					e.printStackTrace();
				}
				members.remove(element);
				break;
			}
		}
	}	//FIXME: sara' piu' efficente cancellare tutti gli elementi assieme... possibile farlo?

	/**
	 * Removes a named element from the given list
	 * @param members the list of members
	 * @param qualifiedElement the qualified name of the element to remove
	 */
	private void removeNamedElement(EList<?> members, String qualifiedElement) {
		for (Object object : members) {
			NamedElement element = (NamedElement) object;
			if (element.getQualifiedName().equals (qualifiedElement)) {
				try {
//					((Element) element).destroy();	//TODO: investigate this line!
					deleteElementInTheModel(element);
				} catch (Exception e) {
					e.printStackTrace();
				}
				members.remove(element);
				break;
			}
		}		
	}	//FIXME: sara' piu' efficente cancellare tutti gli elementi assieme... possibile farlo?

	/**
	 * Removes a property from the list
	 * @param members the list of members
	 * @param qualifiedElement the qualified name of the  property to remove
	 */
	private void removeProperty(EList<Property> members, String qualifiedElement) {
		removeNamedElement(members, qualifiedElement);
	}

	/**
	 * Removes a property from the list
	 * @param members the list of members
	 * @param qualifiedElement the qualified name of the  property to remove
	 */
	private void removeConnector(EList<Connector> members, String qualifiedElement) {
		removeNamedElement(members, qualifiedElement);
	}
	
	/**
	 * Removes a port from the list
	 * @param members the list of members
	 * @param qualifiedElement the qualified name of the port to remove
	 */
	private void removePort(EList<NamedElement> members, String qualifiedElement) {
		removeNamedElement(members, qualifiedElement);
	}
	
	/**
	 * Removes a delegation constraint from the list
	 * @param members the list of members
	 * @param qualifiedElement the qualified name of the delegation constraint to remove
	 */
	private void removeDelegationConstraint(EList<Constraint> members, String qualifiedElement) {
		removeNamedElement(members, qualifiedElement);
	}

	/**
	 * Removes a contract refinement from the list
	 * @param members the list of members
	 * @param qualifiedElement the qualified name of the contract refinement to remove
	 */
	private void removeContractRefinement(EList<DataType> members, String qualifiedElement) {
		removeNamedElement(members, qualifiedElement);
	}

	/**
	 * Removes an element from the list
	 * @param members the list of members
	 * @param qualifiedElement the qualified name of the element to remove
	 */
	private void removeElement(EList<Class> members, String qualifiedElement) {
		removeNamedElement(members, qualifiedElement);
	}

	/**
	 * Returns the list of contract refinements associated to a Class
	 * @param owner the owner Class
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
	 * Parses the Refinements of the component.
	 * @param dslParentComponent the AST Component owning the refinement
	 * @param dslComponentRefinement the Refinement element to be parsed
	 * @throws ImportException 
	 */
	private void parseRefinements(AbstractComponent dslParentComponent, Refinement dslComponentRefinement) throws ImportException {
		
		// Get all the RefinementInstances of the Refinement
		final EList<RefinementInstance> dslRefInstances = dslComponentRefinement.getRefinements(); 

		final Class owner = dslTypeToComponent.get(dslParentComponent.getType());
		
		// Get all the existing component instances of the element
		EList<Property> existingComponentInstances = (EList<Property>) chessSystemModel.getSubComponentsInstances(owner);

		// Prepare the map to mark existing component instances 
		HashMap<String, Boolean> mapComponentInstances = Maps.newHashMapWithExpectedSize(existingComponentInstances.size());
		for (Property componentInstance : existingComponentInstances) {
			mapComponentInstances.put(componentInstance.getQualifiedName(), null);
		}
		
		// Get all the existing connectors of the element
		// Doing a copy because the list will otherwise increase as soon as a connector is created
		EList<Connector> existingConnectors = new BasicEList<Connector>(owner.getOwnedConnectors());
//		EList<Connector> connectors = owner.getOwnedConnectors();
		
		// Prepare the map to mark existing connectors 
		HashMap<String, Boolean> mapConnectors = Maps.newHashMapWithExpectedSize(existingConnectors.size());
		for (Connector connector : existingConnectors) {
			mapConnectors.put(connector.getQualifiedName(), null);
		}
		
		// Get all the existing delegation contraints of the element
		EList<Constraint> existingDelegationConstraints = contractEntityUtil.getConstraintsProperties(owner);
		
		// Prepare the map to mark existing delegation contraints 
		HashMap<String, Boolean> mapDelegationContraints = Maps.newHashMapWithExpectedSize(existingDelegationConstraints.size());
		for (Constraint delegationConstraint : existingDelegationConstraints) {
			mapDelegationContraints.put(delegationConstraint.getQualifiedName(), null);
		}
		
		// Get all the contract refinements of the element
		EList<DataType> existingContractRefinements = getContractRefinementsOfClass(owner);
		
		// Prepare the map to mark existing contract refinements
		HashMap<String, Boolean> mapContractRefinements = Maps.newHashMapWithExpectedSize(existingContractRefinements.size());
		for (Classifier contractRefinement : existingContractRefinements) {
			mapContractRefinements.put(contractRefinement.getQualifiedName(), null);
		}
		
		// If some RefinementInstances are present, loop on them
		if ((dslRefInstances != null) && !dslRefInstances.isEmpty()) {
			for (RefinementInstance dslRefInstance : dslRefInstances) {

				// Process the different types of refinements
				if (dslRefInstance != null && dslRefInstance.getSubcomponent() != null) {

					// SUB processing
					final String subName = dslRefInstance.getSubcomponent().getName();					
					final String subType = dslRefInstance.getSubcomponent().getType();

					logger.debug("\tsubcomponent name = " + subName);
					logger.debug("\tsubcomponent type = " + subType);

					// Retrieve the component instance from the owner, if any
					final Property componentInstance = entityUtil.getSubComponentInstance(owner, subName);

					if (componentInstance == null) {
						
						logger.debug("componentInstance not found, creating one");
						
						// I should create an Association between the elements and not a Component Instance!
						addedElements.add(createAssociation(owner, subName, (Type) dslTypeToComponent.get(subType))); 
					}  else {

						logger.debug("componentInstance already present");

						// The component instance is already present, update its type if needed
						if (!componentInstance.getType().getName().equals(subType)) {
							componentInstance.setType(dslTypeToComponent.get(subType));
							
							// Add the association to the list of changes, it needs to be redrawn
							addedElements.add(componentInstance.getAssociation());
						}
						
						// Set the flag to signal the componentInstance is still used
						mapComponentInstances.put(componentInstance.getQualifiedName(), Boolean.TRUE);						
					}
				} else if (dslRefInstance != null && dslRefInstance.getConnection() != null) {
					
					// CONNECTION processing
					final Connection connection = dslRefInstance.getConnection();
					final VariableId variable = connection.getVariable();
					final Expression constraint = connection.getConstraint();
					Connector connector = null;
										
					if ((connector = getExistingConnector(existingConnectors, variable, constraint)) != null) {
						logger.debug("connector already present");
						
						// Set the flag to signal the connector is still used
						mapConnectors.put(connector.getQualifiedName(), Boolean.TRUE);
						continue;
					} else if (constraint instanceof Expression && !(constraint instanceof PortId)) {
						
						// It could be a delegation constraint, check it
						Constraint delegationConstraint = null;

						if ((delegationConstraint = getExistingDelegationConstraint(existingDelegationConstraints, variable, constraint)) != null) {
							logger.debug("delegation constraint already present");

							// Set the flag to signal the delegation constraint is still used
							mapDelegationContraints.put(delegationConstraint.getQualifiedName(), Boolean.TRUE);
							continue;
						} else {
							logger.debug("delegation constraint is not present");

							// Create a delegation constraint, can be a LogicalExpression, IntegerLiteral, AddSubExpression, ...
							addedElements.add(createDelegationConstraint(owner, variable, constraint));
							continue;
						}						
					}

					logger.debug("connector is not present");

					// Create the source end
					if (constraint instanceof PortId) {	//FIXME: there is also ParameterId
						
						// Create a connector, but only after I'm sure it isn't a delegation constraint
						connector = createConnector(owner);
						
						String portOwner = null;
						
						// Get the component name, should be at max one
						EList<String> componentNames = ((PortId) constraint).getComponentNames();
						if (componentNames != null && componentNames.size() != 0) {
							portOwner = componentNames.get(0);
						}

						final String portName = ((PortId) constraint).getName();
						logger.debug("Creating source end " + portOwner + ":" + portName);
						createConnectorEnd(owner, connector, portOwner, portName);
					}

					// Create the target end
					if (variable instanceof PortId) {
						
						String portOwner = null;
						
						// Get the component name, should be at max one
						EList<String> componentNames = ((PortId) variable).getComponentNames();
						if (componentNames != null && componentNames.size() != 0) {
							portOwner = componentNames.get(0);
						}
						
						final String portName = ((PortId) variable).getName();					
						logger.debug("Creating target end " + portOwner + ":" + portName);
						createConnectorEnd(owner, connector, portOwner, portName);
					}
					
					// At last, add the connector to the owner
					addConnector(owner, connector);
					
					// Store the new connector
					addedElements.add(connector);

				} else if (dslRefInstance != null && dslRefInstance.getRefinedby() != null) {
					
					// REFINEDBY processing
					final RefinedBy refinement = dslRefInstance.getRefinedby();
					final String refinedContract = refinement.getName();
					
					logger.debug("\n\n\nContract name = " + refinedContract + " from " + owner.getName());

//					final ContractProperty contractProperty = getContractPropertyFromContract(owner, refinedContract);
					
					// Get the instance of the contract, using a library function
					final Property umlProperty = contractEntityUtil.getUmlContractPropertyOfUmlComponentFromContractPropertyType(owner, refinedContract);
					final ContractProperty contractProperty = contractEntityUtil.getContractProperty(umlProperty);

					// Get the refinements linked to that contract property
					final EList<ContractRefinement> contractPropertyRefinements = chessSystemModel.getContractRefinements(contractProperty);
					
					// Loop on all the refinements to see if they already exist
					final EList<ContractId> contractIds = refinement.getContractIds();					
					for (ContractId contractId : contractIds) {
						
						// The component instance containing the refining contract
						final Property refiningComponentInstance = getUMLComponentInstance(owner, contractId.getComponentName());

						// The component type where the contract property is defined
						final Class refiningComponent = (Class) refiningComponentInstance.getType();
						
						// The refining contract property
						final Property refiningProperty = contractEntityUtil.getUmlContractPropertyOfUmlComponentFromContractPropertyType(refiningComponent, contractId.getName()); 
												
						// Compose the name that the contract refinement should have
						final String refinementName = contractId.getComponentName() + "." + refiningProperty.getName();
												
						// Check to see if the refinement is already linked to the contract property
						boolean alreadyLinked = false;
						for (ContractRefinement contractRefinement : contractPropertyRefinements) {
							if (contractRefinement.getBase_DataType().getName().equals(refinementName)) {
								logger.debug("refinement already defined for the contract");
								
								// Set the flag to signal the contract refinement is still used
								mapContractRefinements.put(contractRefinement.getBase_DataType().getQualifiedName(), Boolean.TRUE);
								alreadyLinked = true;
								break;
							}
						}
						
						if (alreadyLinked) {
							continue;	// Go to the next refinement
						} else {						
							logger.debug("refinement not present");

							// Create a new refinement and add it to the contract property
							final DataType umlRefinement = createContractRefinement(owner, contractId.getComponentName(), contractId.getName());
							addContractRefinementToContractProperty(contractProperty, umlRefinement);

							// Store the new refinement
							addedElements.add(umlRefinement);
						}
					}
					
				} else if (dslRefInstance != null && dslRefInstance.getFormula() != null) {
					
					// CONSTRAINT processing
					//TODO: implement this
					logger.error("Import Error: Found a CONSTRAINT tag, don't know how to handle it!");
				} else if (dslRefInstance != null && dslRefInstance.getProp() != null) {

					// PROP processing
					//TODO: implement this
					logger.error("Import Error: Found a PROP tag, don't know how to handle it!");
				}
			}
		}
		
		// Component instances cleanup time, associations will be removed automatically
		for (String qualifiedElement : mapComponentInstances.keySet()) {
			if (mapComponentInstances.get(qualifiedElement) == null) {
//				System.out.println("component instance " + qualifiedElement + " should be removed");
				removeProperty(existingComponentInstances, qualifiedElement);
			}
		}
		
		// Connectors cleanup time
		for (String qualifiedElement : mapConnectors.keySet()) {
			if (mapConnectors.get(qualifiedElement) == null) {
//				System.out.println("connector " + qualifiedElement + " should be removed");
				removeConnector(existingConnectors, qualifiedElement);
			}
		}
		
		// Delegation constraints cleanup time
		for (String qualifiedElement : mapDelegationContraints.keySet()) {
			if (mapDelegationContraints.get(qualifiedElement) == null) {
//				System.out.println("delegation constraint " + qualifiedElement + " should be removed");
				removeDelegationConstraint(existingDelegationConstraints, qualifiedElement);
			}
		}

		// Contract refinements cleanup time
		for (String qualifiedElement : mapContractRefinements.keySet()) {
			if (mapContractRefinements.get(qualifiedElement) == null) {
//				System.out.println("contract refinement " + qualifiedElement + " should be removed");
				removeContractRefinement(existingContractRefinements, qualifiedElement);
			}
		}
	}
	
	/** 
	 * Gets the expression string from the Expression constraint.
	 * @param constraint the expression to convert
	 */
	private String getConstraintText(Expression constraint) {
		final String text = serializer.serialize(constraint);

		return text.trim();
	}
	
	/** 
	 * Returns a name for the ContractProperty, deriving it from the Contract type.
	 * @param contract the contract from which it derives
	 * @return a derived name, going lowercase
	 */
	private String createContractPropertyNameFromContract(Class contract) {
		String contractName = contract.getName();
		
		if (contractName.length() > 0) {
			return contractName.toLowerCase();
		} else {
			return ((Contract) contract).getName().toLowerCase();
		}
	}
	
	/** 
	 * Parses the Interfaces of the component.
	 * @param dslParentComponent the AST Component owning the refinement
	 * @param dslComponentInterface the Interface element to be parsed
	 * @throws ImportException 
	 */
	@SuppressWarnings("unchecked")
	private void parseInterfaces(AbstractComponent dslParentComponent, Interface dslComponentInterface) throws ImportException {

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
		final EList<ContractProperty> existingContractProperties = (EList<ContractProperty>) chessSystemModel.getContractsOfComponent(owner);
		
//		// Prepare the map to mark existing contracts
		final HashMap<String, Boolean> mapContractProperties = Maps.newHashMapWithExpectedSize(existingContractProperties.size());
		for (ContractProperty contractProperty : existingContractProperties) {
			mapContractProperties.put(contractProperty.getBase_Property().getQualifiedName(), null);
		}
		
		// If some InterfaceInstances are present, loop on them
		if ((dslIntInstances != null) && !dslIntInstances.isEmpty()) {
			for (InterfaceInstance dslIntInstance : dslIntInstances) {

				// Process the different types of interfaces
				if (dslIntInstance != null && dslIntInstance.getVariable() != null) {

					final Variable dslVariable = dslIntInstance.getVariable();

					if (dslVariable instanceof Port) {

						// PORT processing
						final VariableId dslVariableID = dslVariable.getId();
						final SimpleType dslVariableType = dslVariable.getType();
						
						// Version that updates the port
						// Loop on all the ports to see if it is already existing
						org.eclipse.uml2.uml.Port port = null;
						for (Object object : existingPorts) {
							final org.eclipse.uml2.uml.Port tmpPort = (org.eclipse.uml2.uml.Port) object;
							if (tmpPort.getName().equals(dslVariableID.getName())) {
								
								// Port found, update its direction if needed
								final FlowPort flowPort = (FlowPort) tmpPort.getStereotypeApplication(typeUtil.flowPortStereotype);
								if (dslVariable instanceof InputPort && flowPort.getDirection() != FlowDirection.IN) {
									flowPort.setDirection(FlowDirection.IN);
								} else if (dslVariable instanceof OutputPort && flowPort.getDirection() != FlowDirection.OUT) {
									flowPort.setDirection(FlowDirection.OUT);
								}

								// Update its type if needed
								final Type newType = getTypeFromDSLType(dslVariableType);
								if (!tmpPort.getType().getName().equals(newType.getName())) {
									tmpPort.setType(newType);
								}

								// Set the flag to signal the port is still used
								mapPorts.put(tmpPort.getQualifiedName(), Boolean.TRUE);
								port = tmpPort;
								
								// Add the port to the list of changes NOT NEEDED BECAUSE DIAGRAMS ARE AUTO-UPDATING
//								addedElements.add(port);

								break;	// Port found
							}
						}
						
						if (port == null) {
							logger.debug("Port not found, creating it");

							if (dslVariable instanceof InputPort) {
								addedElements.add(createNonStaticPort(owner, dslVariableID, dslVariableType, true));
							} else if (dslVariable instanceof OutputPort) {
								addedElements.add(createNonStaticPort(owner, dslVariableID, dslVariableType, false));
							}
						}
												
						// The following method doesn't work, type is different!
//						org.eclipse.uml2.uml.Port port = owner.getOwnedPort(dslVariableID.getName(), t);
						
						// Version that replaces the port with a new one
//						// Loop on all the ports to see if it is already existing
//						org.eclipse.uml2.uml.Port port = null;
//						for (Object object : ports) {
//							final org.eclipse.uml2.uml.Port tmpPort = (org.eclipse.uml2.uml.Port) object;
//							if (tmpPort.getName().equals(dslVariableID.getName()) && 
//									tmpPort.getType().getName().equals(getTypeFromDSLType(dslVariableType).getName())) {
//								System.out.println("\nFound port " + tmpPort.getName());
//								System.out.println("with type " + tmpPort.getType().getName());
//								port = tmpPort;
//								break;	// Port found
//							}
//						}
//
//						if (port != null) {
//							if (dslVariable instanceof InputPort) {
//								if (entityUtil.isInputPort(port)) {
//
//									System.out.println("Port already existing");
//
//									// Set the flag to signal the port is still used
//									existingPorts.put(port.getQualifiedName(), Boolean.TRUE);
//									continue;
//								} else {
//
//									System.out.println("port not present: " + port.getName());
//
//									port = createNonStaticPort(owner, dslVariableID, dslVariableType, true);
//
//									// Add the port to the list of changes
//									addedElements.add(port);
//									continue;
//								}
//							} else {
//								if (entityUtil.isOutputPort(port)) {
//
//									System.out.println("Port already existing");
//
//									// Set the flag to signal the port is still used
//									existingPorts.put(port.getQualifiedName(), Boolean.TRUE);
//									continue;
//								} else {
//
//									System.out.println("port not present: " + port.getName());
//
//									port = createNonStaticPort(owner, dslVariableID, dslVariableType, false);
//
//									// Add the port to the list of changes
//									addedElements.add(port);
//									continue;
//								}
//							}
//						} else {
//						
//							System.out.println("PORT NOT FOUND, CREATING IT");
//							
//							if (dslVariable instanceof InputPort) {
//								createNonStaticPort(owner, dslVariableID, dslVariableType, true);
//							} else if (dslVariable instanceof OutputPort) {
//								createNonStaticPort(owner, dslVariableID, dslVariableType, false);
//							}
//	  			     		// Add the port to the list of changes
//					    	addedElements.add(port);
//						}
					} else if (dslVariable instanceof Parameter) {
						
						// PARAMETER processing
						final VariableId dslVariableID = dslVariable.getId();
						final SimpleType dslVariableType = dslVariable.getType();

						// Check if there are optional parameters, if yes, it cannot handle them
						final EList<SimpleType> parameters = ((Parameter) dslVariable).getParameters();
						if (parameters.size() != 0) {
							logger.error("Import Error: Cannot handle this type of PARAMETER");
						} else {
							
							// I should check if the port is already present
							org.eclipse.uml2.uml.Port port = null;
							for (Object object : existingPorts) {
								final org.eclipse.uml2.uml.Port tmpPort = (org.eclipse.uml2.uml.Port) object;
								if (tmpPort.getName().equals(dslVariableID.getName()) && 
										tmpPort.getType().getName().equals(getTypeFromDSLType(dslVariableType).getName())) {
									port = tmpPort;
									break;	// Port found
								}
							}

							if (port != null) {
								logger.debug("Port already present");

								// Set the flag to signal the port is still used
								mapPorts.put(port.getQualifiedName(), Boolean.TRUE);
								continue;
							} else {

								// Create the port and mark it
								addedElements.add(createStaticPort(owner, dslVariableID, dslVariableType));
								continue;
							}
						}
					} else if (dslVariable instanceof Operation) {
						
						// PROVIDED OPERATION processing
						//TODO: implement this
						logger.error("Import Error: Found a OPERATION tag, don't know how to handle it!");
					}
				} else if (dslIntInstance != null && dslIntInstance.getDefine() != null) {
				
					// DEFINE processing
					//TODO: implement this
					logger.error("Import Error: Found a DEFINE tag, don't know how to handle it!");
				} else if (dslIntInstance != null && dslIntInstance.getContract() != null) {
					
					// CONTRACT processing					
					final Contract dslContract = dslIntInstance.getContract();					
					final Assumption dslAssumption = dslContract.getAssumption();
					final Guarantee dslGuarantee = dslContract.getGuarantee();

					// Retrieve the contract type from the owner, if any
					Class contract = (Class) owner.getOwnedMember(dslContract.getName(), false, UMLFactory.eINSTANCE.createClass().eClass());

					if (contract == null) {
					
						logger.debug("contract non found, creating one");
						
						// Create an empty Contract
						contract = createContract(owner, dslContract.getName());
	
						// Add the two Formal Properties
						contractEntityUtil.saveFormalProperty("Assume", getConstraintText(dslAssumption.getConstraint()), contract);
						contractEntityUtil.saveFormalProperty("Guarantee", getConstraintText(dslGuarantee.getConstraint()), contract);
	
						// Create a Contract Property
						String contractPropertyName = createContractPropertyNameFromContract(contract);
						createContractProperty(owner, contractPropertyName, (Type) contract);
						
						addedElements.add(contract);
					}  else {

						logger.debug("Contract already present");

						// The contract type is already present, update the formal properties if needed
						final String assumeString = contractEntityUtil.getAssumeStrFromUmlContract(contract);
						if (getConstraintText(dslAssumption.getConstraint()).equals(assumeString)) {
						} else {
							
							// Change the text of the assume property
							final FormalProperty assumeFormalProperty = contractEntityUtil.getAssumeFromUmlContract(contract);
							final ValueSpecification vs = assumeFormalProperty.getBase_Constraint().getSpecification();
							((LiteralString) vs).setValue(getConstraintText(dslAssumption.getConstraint()));
							assumeFormalProperty.getBase_Constraint().setSpecification(vs);
						}
						
						final String guaranteeString = contractEntityUtil.getGuaranteeStrFromUmlContract(contract);
						if (getConstraintText(dslGuarantee.getConstraint()).equals(guaranteeString)) {
						} else {
							
							// Change the text of the guarantee property
							final FormalProperty guaranteeFormalProperty = contractEntityUtil.getGuaranteeFromUmlContract(contract);
							final ValueSpecification vs = guaranteeFormalProperty.getBase_Constraint().getSpecification();
							((LiteralString) vs).setValue(getConstraintText(dslGuarantee.getConstraint()));
							guaranteeFormalProperty.getBase_Constraint().setSpecification(vs);
						}
						
						// Set the flag to signal the contractProperty is still used
						final ContractProperty contractProperty = (ContractProperty) chessSystemModel.getContract(owner, dslContract.getName());
						mapContractProperties.put(contractProperty.getBase_Property().getQualifiedName(), Boolean.TRUE);
					}
				}
			}
		}
		
		// Ports cleanup time 
		for (String qualifiedElement : mapPorts.keySet()) {
			if (mapPorts.get(qualifiedElement) == null) {
//				System.out.println("port " + qualifiedElement + " should be removed");
				removePort(existingPorts, qualifiedElement);
			}
		}
		
		// Contracts cleanup time
		// ** Contract instances and contract types are removed, but not their formal properties and refinements!
		for (String qualifiedElement : mapContractProperties.keySet()) {
			if (mapContractProperties.get(qualifiedElement) == null) {
//				System.out.println("contractProperty " + qualifiedElement + " should be removed");
				removeContractProperty(existingContractProperties, qualifiedElement);
			}
		}
	}
	
	/** Navigates the component and processes its interfaces.
	 * @param dslParentComponent the element in the tree
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

	/** Navigates the component and processes its refinements.
	 * @param dslParentComponent the element in the tree
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
	
	// Needed to bring out a reference from the inner class...
	ModelExplorerView modelExplorerView;
	
	/**
	 * Returns the ModelExplorerView
	 * @return
	 */
	private ModelExplorerView getModelExplorerView() {

		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				final IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();

				// we look for the modelexplorer
				IViewPart modelexplorer;
				try {
					modelexplorer = activeWorkbenchWindow.getActivePage().showView(MODELEXPLORER_VIEW_ID);
				} catch (PartInitException ex) {
					ex.printStackTrace(System.out);
					return;
				}
				final ModelExplorerPageBookView view = (ModelExplorerPageBookView) modelexplorer;
				final ModelExplorerPage page = (ModelExplorerPage) view.getCurrentPage();
				final IViewPart viewer = page.getViewer();
				modelExplorerView = (ModelExplorerView) viewer;
			}
		});
		return modelExplorerView;
	}

	/**
	 * Returns the handler for the given command
	 * @param commandId the command
	 * @return the handler
	 */
	private IHandler getActiveHandlerFor(final String commandId) {
		final ICommandService commandService = 
				(ICommandService) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getService(ICommandService.class);
		commandService.refreshElements(commandId, null);
		final Command cmd = commandService.getCommand(commandId);
		return cmd.getHandler();
	}

	private void deleteElementInTheModel(NamedElement element) throws Exception {
		
		// Give the focus to the ModelExplorerView
		ModelExplorerView modelExplorerView = getModelExplorerView();
		modelExplorerView.setFocus();

		// Select the requested element
		List<Object> elements = new ArrayList<Object>();
		elements.add(element);
		modelExplorerView.revealSemanticElement(elements);

		IHandler deleteHandler = getActiveHandlerFor(DELETE_COMMAND_ID);
		deleteHandler.execute(new ExecutionEvent());
	}

	/**
	 * Main method to be invoked to parse an OSS file.
	 * @throws Exception
	 */
	public void startParsing(Package pkg, File ossFile) throws Exception, ImportException, IOException {	
		OSS ocraOssFile;
		sysView = pkg;	// Set the given package as working package

		// Retrieve the needed stereotypes 
		typeUtil.refreshStereotypes(sysView);
		
		long startTime = System.currentTimeMillis();
		
		if (ossFile != null) {
			ocraOssFile = OSSModelFactory.getInstance().createOssModel(ossFile);
		} else {
			return;
		}

		// Retrieve the SystemComponent
		SystemComponent dslSystemComponent = ocraOssFile.getSystem();
		
		if (dslSystemComponent == null) {
			logger.error("Import Error: System component is missing");
			throw new ImportException("System component is missing");
		}

		// If the OCRA system component type is not defined, set it to 'System'
		final String dslSystemComponentName = dslSystemComponent.getType() == null ? "System" : dslSystemComponent.getType();
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
					systemComponent = createSystemBlock(sysView, dslSystemComponent.getType());
					
					// Add the component to the list of changes
					addedElements.add(systemComponent);
					
				} else {
				
					logger.debug("block already present");
					
					// Should retrieve the old one from the package
					systemComponent = (Class) sysView.getOwnedMember(dslSystemComponentName, false, UMLFactory.eINSTANCE.createClass().eClass());
					
					// Set the flag to signal the block is still used
					mapBlocks.put(blockQualifiedName, Boolean.TRUE);
				}
				
				// Store the systemComponent in a hash with its name
				dslTypeToComponent.put(dslSystemComponentName, systemComponent);

				// Populate the map and the package with the other Component elements 
				for (Component dslComponent : ocraOssFile.getComponents()) {
					
					blockQualifiedName = pkg.getQualifiedName() + "::" + dslComponent.getType();
					
					Class component = null;
					if(!mapBlocks.containsKey(blockQualifiedName)) {

						logger.debug("block not present: " + blockQualifiedName);

						// Add a new block to the package
						component = createBlock(sysView, dslComponent.getType());

						// Add the component to the list of changes
						addedElements.add(component);
					} else {
					
						logger.debug("block already present: " + blockQualifiedName);
						
						// Retrieve the old one
						component = (Class) sysView.getOwnedMember(dslComponent.getType(), false, UMLFactory.eINSTANCE.createClass().eClass());

						// Set the flag to signal the block is still used
						mapBlocks.put(blockQualifiedName, Boolean.TRUE);
					}

					// Store the component in a hash with its name
					dslTypeToComponent.put(dslComponent.getType(), component);
				}

				// Now I have created all the Blocks in the package, loop on them, but not getting them from 
				// the package (it may be polluted with other blocks), but from the OSS model again.
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
//						System.out.println("block " + qualifiedElement + " should be removed");
						removeElement(existingBlocks, qualifiedElement);
					}
				}
				
				logger.debug("Total time = " + (System.currentTimeMillis() - startTime));
//				System.out.println("Total time = " + (System.currentTimeMillis() - startTime));
			}
		});
		
		// addedElements contains all the elements that have been added or modified 
		logger.debug("addedElements size = " + addedElements.size());
		for (Element element : addedElements) {
			logger.debug("modified element = " + element);
		}
		
		// Propagate the exception, if any
		if (importException != null) {
			throw importException;
		}
	}
}

//TODO:	per ogni diagramma, vedo se per ogni componente del diagramma c'e' qualcosa dentro changes che andrebbe
//      visualizzato.

//TODO: andrebbero rimossi anche i tipi creati, signal, enumeration, boundedsubtype, formal properties, ...


