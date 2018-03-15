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

import org.eclipse.emf.ecore.resource.*;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.xtext.serializer.ISerializer;
import org.polarsys.chess.OSSImporter.exceptions.ImportException;
import org.polarsys.chess.contracts.profile.chesscontract.ContractProperty;
import org.polarsys.chess.contracts.profile.chesscontract.ContractRefinement;
import org.polarsys.chess.contracts.profile.chesscontract.util.ContractEntityUtil;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;
import com.google.inject.Injector;

import eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.core.services.OSSModelFactory;
import eu.fbk.tools.editor.basetype.baseType.*;
import eu.fbk.tools.editor.contract.contract.Assumption;
import eu.fbk.tools.editor.contract.contract.Contract;
import eu.fbk.tools.editor.contract.contract.Guarantee;
import eu.fbk.tools.editor.contract.expression.expression.*;
import eu.fbk.tools.editor.oss.OssStandaloneSetup;
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

import org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.BoundedSubtype;
import org.eclipse.papyrus.sysml.portandflows.FlowDirection;
import org.eclipse.papyrus.sysml.portandflows.FlowPort;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.service.types.utils.ElementUtil;
import org.eclipse.papyrus.uml.tools.utils.UMLUtil;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;

public class ImportOSSFileAction {

	private static final String DELEGATION_PREFIX = "Define_";
	private static final String DELEGATION_CONSTRAINT_NAME = "constraintSpec";
	private static final String CONNECTOR_NAME = "connector";
	private static final String ASSOCIATION_NAME = "association";
	private static final String ENUMERATION_NAME = "Enumeration";
	private static final String SIGNAL_NAME = "Signal";

//	private static final String INTEGER_TYPE =	"PrimitiveTypes::Integer";
//	private static final String REAL_TYPE =		"PrimitiveTypes::Real";	
//	private static final String BOOLEAN_TYPE =	"PrimitiveTypes::Boolean";
	
//	private static final String CHESS_CONTINUOUS_TYPE = "CHESSContract::DataTypes::Continuous";

	private static final String BOUNDED_TYPE = "MARTE::MARTE_Annexes::VSL::DataTypes::BoundedSubtype";
	
	private static final String CONTRACT =				"CHESSContract::Contract";
	private static final String CONTRACT_PROP =			"CHESSContract::ContractProperty";
	private static final String DELEGATION_CONST =		"CHESSContract::DelegationConstraint";
//	private static final String FORMAL_PROP =			"CHESSContract::FormalProperty";
	private static final String CONTRACT_REFINEMENT =	"CHESSContract::ContractRefinement";
	private static final String SYSTEM =				"CHESSContract::System";
//	private static final String COMPINST =				"CHESSContract::ComponentInstance";

//	private static final String SYSVIEW =	"CHESS::Core::CHESSViews::SystemView";
//	private static final String COMPVIEW =	"CHESS::Core::CHESSViews::ComponentView";
//	private static final String CHESS =		"CHESS::Core::CHESS";
	
	private static final String BLOCK =		"SysML::Blocks::Block";
	private static final String FLOWPORT =	"SysML::PortAndFlows::FlowPort";
	
//	private static final String SUBSYSTEM = "CHESSContract::SubSystem";
//	public static final String COLLECTIONTYPE = "MARTE::MARTE_Annexes::VSL::DataTypes::CollectionType";
//	private static final String MARTE_BOOLEAN_TYPE = "MARTE_Library::MARTE_PrimitivesTypes::Boolean";
//	private static final String MARTE_REAL_TYPE = "MARTE_Library::MARTE_PrimitivesTypes::Real";
//	private static final String MARTE_INTEGER_TYPE = "MARTE_Library::MARTE_PrimitivesTypes::Integer";
	 
	// Stereotype objects needed to customize the elements
	Stereotype contractPropertyStereotype;
	Stereotype delegationConstraintStereotype;
	Stereotype contractRefinementStereotype;
	Stereotype flowPortStereotype;
	Stereotype contractStereotype;
	Stereotype boundedTypeStereotype;
	Stereotype blockStereotype;
	Stereotype systemStereotype;
	
	//TODO use instead method in xText plugin
	final Injector injector = new OssStandaloneSetup().createInjector();
	private final ISerializer serializer = injector.getInstance(ISerializer.class);
	private Package sysView = null;

	/** Library for UML primitive types */
	private final Model umlLibrary = (Model) load(URI.createURI(UMLResource.UML_PRIMITIVE_TYPES_LIBRARY_URI));

	/** Library for CHESS types like continuous */
	final Profile chessContractLibrary = (Profile) load(URI.createURI("pathmap://CHESSContract/CHESSContract.profile.uml"));
	
	/** Map the name of the component with the Component object */
	private Map<String, Class> dslTypeToComponent;

	/** The instance of this class */
	private static ImportOSSFileAction sampleView;
	
	/** A possible exception that could happen during parsing */
	ImportException importException;

	/** Logger for messages */
	private static final Logger logger = Logger.getLogger(ImportOSSFileAction.class);

	/**
	 * The constructor.
	 */
	public ImportOSSFileAction() {
	}
	
	/**
	 * Gets an instance of the class if already present, or a new one if not.
	 * @return the instance of this class
	 */
	public static ImportOSSFileAction getInstance() {
		if (sampleView == null) {
			sampleView = new ImportOSSFileAction();
		}
		return sampleView;
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
		newUMLProperty.applyStereotype(contractPropertyStereotype);
		
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
		
		if (variable.getComponentName() != null)
			delegationText.append(variable.getComponentName() + ".");
		
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
		
		if (variable.getComponentName() != null)
			delegationName.append(variable.getComponentName() + ".");

		delegationName.append(variable.getName());
		
		logger.debug("\n\n\n Creating delegation constraint " + delegationName + " for owner " + owner);
		logger.debug("\n\n\n");

		Constraint newUMLConstraint = owner.createOwnedRule(delegationName.toString());
//		UMLUtils.applyStereotype(newUMLConstraint, DELEGATION_CONST);
		newUMLConstraint.applyStereotype(delegationConstraintStereotype);
		
		LiteralString literalString = UMLFactory.eINSTANCE.createLiteralString();
		literalString.setName(DELEGATION_CONSTRAINT_NAME);
		final String formalPropertyText = createDelegationConstraintText(variable, constraint);
		literalString.setValue(formalPropertyText);
		newUMLConstraint.setSpecification(literalString);

		logger.debug("\n\nCreated " + delegationName + " Delegation Constraint\n\n");
		return newUMLConstraint;
	}

	/**
	 * Returns the contract with the given name.
	 * @param umlComponent the component containing the contract
	 * @param contractName the name of the contract
	 * @return the UML class of the contract
	 */
	private Class getUMLContractFromContractName(Class umlComponent, String contractName) {
		return (Class) umlComponent.getNestedClassifier(contractName);
	}
	
	/** 
	 * Returns the contract property generated by the given contract name.
	 * @param component the component containing the contract
	 * @param contractName the name of the contract
	 * @return the associated Contract Property
	 */
	private ContractProperty getContractPropertyFromContract(Class component, String contractName) {
		
		// Get the contract definition from the component
		final Class umlContract = getUMLContractFromContractName(component, contractName);
		
		// Get the contract property name, derived from the contract name
		final String contractPropertyName = createContractPropertyNameFromContract(umlContract);
			
		// Get the contract property from the component, generic type
		final Property umlProperty = component.getOwnedAttribute(contractPropertyName, umlContract);
				
		// Return the correct type of object
		return ContractEntityUtil.getInstance().getContractProperty(umlProperty);
	}
	
	/**
	 *  Returns the refinement associated to the component.
	 *  @param owner of the refinement
	 *  @param refinementName the name of the refinement
	 *  @return the umlRefinement
	 */
	private DataType getUMLRefinement(Class owner, String refinementName) {
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
			if (umlProperty.getName().equals(componentName) && EntityUtil.getInstance().isComponentInstance(umlProperty)) {
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
					
		final Property componentInstance = getUMLComponentInstance(owner, componentName);

		logger.debug("\n\n\n Creating contract refinement for componentName = " + componentName + " of contract " + contractName);
		logger.debug("\n\n\n");
				
		// Get the component type where the contract property is defined
		final Class component = (Class) componentInstance.getType();
		
		final ContractProperty contractProperty = getContractPropertyFromContract(component, contractName);
		
		// Compose the correct name of the contract refinement 
		final String refinementName = componentName + "." + contractProperty.getBase_Property().getName();
		
		// Check if the refinement is already present
		final DataType umlRefinement = getUMLRefinement(owner, refinementName);
		
		if (umlRefinement != null) {
			return umlRefinement;
		} else {
			logger.debug("\n\n Creating contract refinement " + refinementName + " for owner " + owner.getName());
			logger.debug("\n\n");
	
			//TODO create a new class e.g. CHESSElementsUtil and move this method there
			DataType newUmlDataType = UMLFactory.eINSTANCE.createDataType();
			Classifier newClass = owner.createNestedClassifier(refinementName, newUmlDataType.eClass());
//			Stereotype stereotype = UMLUtils.applyStereotype(newClass, CONTRACT_REFINEMENT);
//			ContractRefinement contractRefinement = (ContractRefinement) newClass.getStereotypeApplication(stereotype);
			newClass.applyStereotype(contractRefinementStereotype);
			ContractRefinement contractRefinement = (ContractRefinement) newClass.getStereotypeApplication(contractRefinementStereotype);

			// Set the correct links for the refinement
			contractRefinement.setInstance(componentInstance); // The component instance containing the definition
			contractRefinement.setContract(contractProperty);  // The contract property that refines the contract
					
			logger.debug("\n\nCreated " + refinementName + " Contract Refinement\n\n");
			return (DataType) newClass;
		}
	}

	/**
	 * Loads a package from the given resource.
	 * @param uri the URI of the resource to load
	 * @return the retrieved package
	 */
	private static Package load(URI uri) {
		Package package_ = null;

		try {
			final ResourceSet resourceSet = new ResourceSetImpl();
			final Resource resource = resourceSet.getResource(uri, true);
			package_ = (Package) EcoreUtil.getObjectByType(resource.getContents(), UMLPackage.Literals.PACKAGE);
		} catch (WrappedException we) {
			logger.error(we.getMessage());
			System.exit(1);
		}
		return package_;
	}

	/**
	 * Returns the primitive type from the standard primitive library.
	 * @param name the name of the Type
	 * @return the requested primitive type
	 */
	private Type getPrimitiveType(String name) {
		
		// Get the correct type from the library
		final Type type = umlLibrary.getOwnedType(name);
		
		if (type != null) {
			logger.debug("Type '" + type.getQualifiedName() + "' found.");
			return type;
		}
		return null;
	}

//	/**
//	 * Returns the primitive type from another UML library.
//	 * @param name the name of the Type
//	 * @return the requested primitive type
//	 */
//	private Type getUMLPrimitiveType(String name) {
//			
//		// Get the correct model
//		final Model umlLibrary = (Model) load(URI.createURI("pathmap://UML_LIBRARIES/UMLPrimitiveTypes.library.uml"));
//			
//		// Get the correct type
//		final Type type = umlLibrary.getOwnedType(name);
//		
//		if (type != null) {
//			logger.debug("Type '" + type.getQualifiedName() + "' found.");
//			return type;
//		}
//		return null;
//	}

	/**
	 * Returns the Type Continuous.
	 * @param name the name of the Type
	 * @return the requested Type
	 */
	private Type getContinuousType(String name) {
		
		// The Continuous type is defined here: CHESSContract::DataTypes::Continuous
		
		// Get the correct package inside the profile
		final Package dataTypes = chessContractLibrary.getNestedPackage("DataTypes");
		
		// Get the correct type
		final Type type = dataTypes.getOwnedType(name);
		
		if (type != null) {
			logger.debug("Type '" + type.getQualifiedName() + "' found.");
			return type;
		}
		return null;
	}
	
	/**
	 * Creates a new BoundedSubType as requested.
	 * @param pkg the package where to create the Enumeration
	 * @param typeName the name of the type
	 * @param lowerBound the lower bound
	 * @param upperBound the upper bound
	 * @return the created type
	 */
	private Type createBoundedSubType(Package pkg, String typeName, int lowerBound, int upperBound) {
			
		// Create a data type to the component view and apply the stereotype
		Type dataType = pkg.createOwnedType(typeName, UMLPackage.Literals.DATA_TYPE);
//		Stereotype stereotype = UMLUtils.applyStereotype(dataType, BOUNDED_TYPE);
		dataType.applyStereotype(boundedTypeStereotype);

		// Extract the stereotiped type and configure it
//		BoundedSubtype boundedType = (BoundedSubtype) dataType.getStereotypeApplication(stereotype);
		BoundedSubtype boundedType = (BoundedSubtype) dataType.getStereotypeApplication(boundedTypeStereotype);
		boundedType.setMinValue(String.valueOf(lowerBound));
		boundedType.setMaxValue(String.valueOf(upperBound));
		boundedType.setBaseType((DataType) getPrimitiveType("Integer"));
//		boundedType.setBaseType((DataType) getUMLPrimitiveType("Integer"));	// Alternative version	

		logger.debug("Type '" + dataType.getQualifiedName() + "' created.");
		return dataType;
	}
	
	/**
	 * Returns a BoundedSubType as requested.
	 * @param rangeType the type containing the specifications 
	 * @return the requested type
	 */
	private Type getBoundedSubType(RangeType rangeType) {
		
		Package pkg = sysView;	// Or compView, where to look for and create the type
		int lowerBound = 0, upperBound = 0;
		Type type = null; 
		
		// Check to see if boundaries are integer values and extract them
		if (rangeType.getLowerBound() instanceof IntegerLiteral && rangeType.getUpperBound() instanceof IntegerLiteral) {
			IntegerLiteral intLit = (IntegerLiteral) rangeType.getLowerBound();
			lowerBound = Integer.parseInt(intLit.getValue());
			intLit = (IntegerLiteral) rangeType.getUpperBound();
			upperBound = Integer.parseInt(intLit.getValue());
		} else {
			logger.error("Import Error: Cannot understand the Bounded type limits! " + rangeType);
			return type;
		}
		
		// Generate a suitable type name
		final String typeName = "BoundedInteger_" + lowerBound + "_" + upperBound; 
		
		// Look for that type in the ComponentView
		type = pkg.getOwnedType(typeName);
		if (type != null) {
			
			// The type has been found in the package, use it
			logger.debug("Type '" + type.getQualifiedName() + "' found.");
			return type;
		} else {
			return (Type) createBoundedSubType(pkg, typeName, lowerBound, upperBound);
		}
	}

	/**
	 * Retrieves all the Enumerations owned by the package.
	 * @param pkg the package to be searched
	 * @return 
	 */
	private EList<Enumeration> getEnumerations(Package pkg) {
		EList<Enumeration> enumerations = new BasicEList<Enumeration>();
				
		EList<Type> types = pkg.getOwnedTypes();
		for (Type type : types) {
			if (type instanceof Enumeration) {
				enumerations.add((Enumeration) type);
			}
		}
		return enumerations;
	}
	
	/**
	 * Returns the list of the values inside a given Enumeration.
	 * @param enumeration the Enumeration to be analysed
	 * @return the list of contained values
	 */
	private Set<String> getListValuesForEnumeration(Enumeration enumeration) {
		Set<String> enumValuesNames = new TreeSet<String>();	// Ordered list of values
//		Set<String> enumValuesNames = new HashSet<String>();	// Original order of values
		for(EnumerationLiteral enumLit : enumeration.getOwnedLiterals()) {
			enumValuesNames.add(enumLit.getName());
		}
		return enumValuesNames;
	}
	
	/**
	 * Returns the list of the values inside a given EnumType.
	 * @param enumType the EnumType to be analysed
	 * @return the list of contained values
	 */
	private Set<String> getListValuesForEnumType(EnumType enumType) {
		Set<String> enumValuesNames = new TreeSet<String>();	// Ordered set
		
		for(EObject object :  enumType.getValues()) {
			enumValuesNames.add(((Identifier) object).getValue() );
		}
		return enumValuesNames;
	}

	/**
	 * Looks for a specific enumeration among existing enumerations of the given package.
	 * @param pkg the package in which look for the Enumeration
	 * @param enumType the enumeration to match
	 * @return the enumeration already defined
	 */
	private Enumeration getExistingEnumerationForEnumType(Package pkg, EnumType enumType) {

		EList<Enumeration> enumerations = getEnumerations(pkg);
		
		if (enumerations.size() > 0) {
			Set<String> enumValues = getListValuesForEnumType(enumType);

			for (Enumeration enumeration : enumerations) {
				if (enumValues.equals(getListValuesForEnumeration(enumeration))) {
					return enumeration;
				}			
			}
		}
		return null;	
	}
	
	/**
	 * Creates a new Enumeration as requested.
	 * @param pkg the package where to create the Enumeration
	 * @param enumType the type specifying the values
	 * @return the created Enumeration
	 */
	private Enumeration createEnumerationFromEnumType(Package pkg, EnumType enumType) {
		
		// Create the name using an incremental value
		final String enumerationName = ENUMERATION_NAME + (getEnumerations(pkg).size() + 1);

		Enumeration enumeration = pkg.createOwnedEnumeration(enumerationName);
		Set<String> values = getListValuesForEnumType(enumType);
		for (String string : values) {
			enumeration.createOwnedLiteral(string);
		}				

		logger.debug("Type '" + enumeration.getQualifiedName() + "' created.");
		return enumeration;
	}
	
	/**
	 * Returns an Enumeration as requested.
	 * @param enumType the type containing the specifications 
	 * @return the requested type
	 */
	private Type getEnumerationType(EnumType enumType) {
		Type type = null;
		Package pkg = sysView;	// Or compView, where to look for and create the type
		
		// Look for existing Enumerations in the package
		type = getExistingEnumerationForEnumType(pkg, enumType);
		
		if (type != null) {

			// The type has been found in the package, use it
			logger.debug("Type '" + type.getQualifiedName() + "' found.");
			return type;
		} else {
			return createEnumerationFromEnumType(pkg, enumType);
		}
	}
		
	/**
	 * Looks for a Signal already defined in the package.
	 * @param pkg the package in which look for the Signal
	 * @return the Signal already defined
	 */
	private Signal getExistingSignalType(Package pkg) {
		final EList<Type> types = pkg.getOwnedTypes();

		for (Type type : types) {
			if (type instanceof Signal) {
				return (Signal) type;
			}
		}
		return null;
	}

	//TODO create a new class e.g. CHESSElementsUtil and move this method there
	/**
	 * Creates a Signal type in the given package.
	 * @param pkg the package where to create the Enumeration 
	 * @return the newly created type 
	 */
	private Signal createSignalType(Package pkg) {
		final String signalName = SIGNAL_NAME;
				
		Type type = pkg.createOwnedType(signalName, UMLPackage.Literals.SIGNAL);
		
		logger.debug("Type '" + type.getQualifiedName() + "' created.");
		return (Signal) type;
	}
	
	/**
	 * Returns a Signal as requested (Only a Signal can be defined in the package).
	 * @return the requested type
	 */
	private Type getSignalType() {
		Type type = null;
		Package pkg = sysView;	// Or compView, where to look for and create the type
		
		// Look for existing Signal Type in the package
		type = getExistingSignalType(pkg);
		
		if (type != null) {
			
			// The type has been found in the package, use it
			logger.debug("Type '" + type.getQualifiedName() + "' found.");
			return type;
		} else {
			return createSignalType(pkg);
		}
	}
	
	/** 
	 * Returns the correct Type given the DSL SimpleType.
	 * @param dslSimpleType the type from OSS
	 * @return the UML Type
	 */
	private Type getTypeFromDSLType(SimpleType dslSimpleType) {
		
		if (dslSimpleType instanceof BooleanType) {
			logger.debug("BooleanType");
			return getPrimitiveType("Boolean");
		} else if (dslSimpleType instanceof IntegerType) {
			logger.debug("IntegerType");
			return  getPrimitiveType("Integer");
		} else if (dslSimpleType instanceof RealType) {
			logger.debug("RealType");
			return getPrimitiveType("Real");
		} else if (dslSimpleType instanceof WordType) {
			logger.debug("WordType");
		} else if (dslSimpleType instanceof UnsignedWordType) {
			logger.debug("UnsignedWordType");
		} else if (dslSimpleType instanceof SignedWordType) {
			logger.debug("SignedWordType");
		} else if (dslSimpleType instanceof ContinuousType) {
			logger.debug("ContinuousType");
			return getContinuousType("Continuous");
		} else if (dslSimpleType instanceof EventType) {
			logger.debug("EventType");
			return getSignalType();
		} else if (dslSimpleType instanceof RangeType) {
			logger.debug("RangeType");
			return getBoundedSubType((RangeType) dslSimpleType);
		} else if (dslSimpleType instanceof EnumType) {
			logger.debug("EnumType");
			return getEnumerationType((EnumType) dslSimpleType);
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
		umlPort.applyStereotype(flowPortStereotype);
		umlPort.setAggregation(AggregationKind.get(AggregationKind.COMPOSITE));
//		FlowPort flowPort = (FlowPort) umlPort.getStereotypeApplication(stereotype);
		FlowPort flowPort = (FlowPort) umlPort.getStereotypeApplication(flowPortStereotype);
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
		umlPort.applyStereotype(flowPortStereotype);
		umlPort.setAggregation(AggregationKind.get(AggregationKind.COMPOSITE));
//		FlowPort flowPort = (FlowPort) umlPort.getStereotypeApplication(stereotype);
		FlowPort flowPort = (FlowPort) umlPort.getStereotypeApplication(flowPortStereotype);
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
		sysBlock.applyStereotype(blockStereotype);
		sysBlock.applyStereotype(systemStereotype);
		
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
		newClass.applyStereotype(contractStereotype);
		
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
		umlClass.applyStereotype(blockStereotype);
		
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
		final Stereotype stereotype = umlRefinement.getAppliedStereotype(CONTRACT_REFINEMENT);	
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
	 * Parses the Refinements of the component.
	 * @param dslParentComponent the AST Component owning the refinement
	 * @param dslComponentRefinement the Refinement element to be parsed
	 * @throws ImportException 
	 */
	private void parseRefinements(AbstractComponent dslParentComponent, Refinement dslComponentRefinement) throws ImportException {
		
		// Get all the RefinementInstances of the Refinement
		final EList<RefinementInstance> dslRefInstances = dslComponentRefinement.getRefinements(); 

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

					// I should create an Association between the elements and not a Component Instance!
					createAssociation(dslTypeToComponent.get(dslParentComponent.getType()), subName, (Type) dslTypeToComponent.get(subType)); 
					
				} else if (dslRefInstance != null && dslRefInstance.getConnection() != null) {
					
					// CONNECTION processing
					final Connection connection = dslRefInstance.getConnection();
					final VariableId variable = connection.getVariable();
					final Expression constraint = connection.getConstraint();
					Connector connector = null;
										
					// Create the source end
					if (constraint instanceof PortId) {	//FIXME: there is also ParameterId
						
						// Create a connector, but only after I'm sure it isn't a delegation constraint
						connector = createConnector(dslTypeToComponent.get(dslParentComponent.getType()));
						
						final String portOwner = ((PortId) constraint).getComponentName();
						final String portName = ((PortId) constraint).getName();
						logger.debug("Creating source end " + portOwner + ":" + portName);
						createConnectorEnd(dslTypeToComponent.get(dslParentComponent.getType()), connector, portOwner, portName);
					} else if (constraint instanceof Expression) {
						
						// Create a delegation constraint, can be a LogicalExpression, IntegerLiteral, AddSubExpression, ...
						createDelegationConstraint(dslTypeToComponent.get(dslParentComponent.getType()), variable, constraint);
						continue;	// No need to go ahead in the processing
					} else {
						
						// Unknown type of connection
						logger.error("Constraint = " + constraint);
						throw new ImportException("Import Error: Not able to recognize the connection type " + constraint.getValue());
					}

					// Create the target end
					if (variable instanceof PortId) {
						final String portOwner = ((PortId) variable).getComponentName();
						final String portName = ((PortId) variable).getName();					
						logger.debug("Creating target end " + portOwner + ":" + portName);
						createConnectorEnd(dslTypeToComponent.get(dslParentComponent.getType()), connector, portOwner, portName);
					}
					
					// At last, add the connector to the owner
					addConnector(dslTypeToComponent.get(dslParentComponent.getType()), connector);

				} else if (dslRefInstance != null && dslRefInstance.getRefinedby() != null) {
					
					// REFINEDBY processing
					final RefinedBy refinement = dslRefInstance.getRefinedby();
					final String refinedContract = refinement.getName();
					
					logger.debug("\n\n\nContract name = " + refinedContract + " from " + dslTypeToComponent.get(dslParentComponent.getType()).getName());

					ContractProperty contractProperty = getContractPropertyFromContract(dslTypeToComponent.get(dslParentComponent.getType()), refinedContract);
					
					// Alternative version using a library function
//					Property p = ContractEntityUtil.getInstance().getUmlContractPropertyOfUmlComponentFromContractPropertyType(dslTypeToComponent.get(dslParentComponent.getType()), refinedContract);
//					ContractProperty cp = ContractEntityUtil.getInstance().getContractProperty(p);

					// Create a ContractRefinement for each ContractId found
					final EList<ContractId> contractIds = refinement.getContractIds();					
					for (ContractId contractId : contractIds) {
						logger.debug("\n\tContractID = " + contractId.getComponentName() +	"." + contractId.getName());	
						final DataType umlRefinement = createContractRefinement(dslTypeToComponent.get(dslParentComponent.getType()), contractId.getComponentName(), contractId.getName());
						addContractRefinementToContractProperty(contractProperty, umlRefinement);
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
	private void parseInterfaces(AbstractComponent dslParentComponent, Interface dslComponentInterface) throws ImportException {

		// Get all the InterfaceInstances of the Interface
		final EList<InterfaceInstance> dslIntInstances = dslComponentInterface.getInterfaces();

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

						if (dslVariable instanceof InputPort) {
							createNonStaticPort(dslTypeToComponent.get(dslParentComponent.getType()), dslVariableID, dslVariableType, true);
						} else if (dslVariable instanceof OutputPort) {
							createNonStaticPort(dslTypeToComponent.get(dslParentComponent.getType()), dslVariableID, dslVariableType, false);
						}
					} else if (dslVariable instanceof Parameter) {
						
						// PARAMETER processing
						final VariableId dslVariableID = dslVariable.getId();
						final SimpleType dslVariableType = dslVariable.getType();

						// Check if there are optional parameters, if yes, it cannot handle them
						EList<SimpleType> parameters = ((Parameter) dslVariable).getParameters();
						if (parameters.size() != 0) {
							logger.error("Import Error: Cannot handle this type of PARAMETER");
						} else {
							createStaticPort(dslTypeToComponent.get(dslParentComponent.getType()), dslVariableID, dslVariableType);
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

					// Create an empty Contract
					Class contract = createContract(dslTypeToComponent.get(dslParentComponent.getType()), dslContract.getName());

					// Add the two Formal Properties
					ContractEntityUtil.getInstance().saveFormalProperty("Assume", getConstraintText(dslAssumption.getConstraint()), contract);
					ContractEntityUtil.getInstance().saveFormalProperty("Guarantee", getConstraintText(dslGuarantee.getConstraint()), contract);

					// Create a Contract Property
					String contractPropertyName = createContractPropertyNameFromContract(contract);
					createContractProperty(dslTypeToComponent.get(dslParentComponent.getType()), contractPropertyName, (Type) contract);
				}
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
	
	/**
	 * Collects the needed stereotypes from the given package.
	 * @param pkg the package in which to look for the stereotypes
	 */
	private void refreshStereotypes(Package pkg) {
		
		for (Stereotype sub : UMLUtil.findSubstereotypes(pkg, CONTRACT_PROP)) {
			if (sub.getQualifiedName().equals(CONTRACT_PROP)) {
				contractPropertyStereotype = sub;
				break;
			}
		}
		
		for (Stereotype sub : UMLUtil.findSubstereotypes(pkg, DELEGATION_CONST)) {
			if (sub.getQualifiedName().equals(DELEGATION_CONST)) {
				delegationConstraintStereotype = sub;
				break;
			}
		}

		for (Stereotype sub : UMLUtil.findSubstereotypes(pkg, CONTRACT_REFINEMENT)) {
			if (sub.getQualifiedName().equals(CONTRACT_REFINEMENT)) {
				contractRefinementStereotype = sub;
				break;
			}
		}
		
		for (Stereotype sub : UMLUtil.findSubstereotypes(pkg, BOUNDED_TYPE)) {
			if (sub.getQualifiedName().equals(BOUNDED_TYPE)) {
				boundedTypeStereotype = sub;
				break;
			}
		}

		for (Stereotype sub : UMLUtil.findSubstereotypes(pkg, FLOWPORT)) {
			if (sub.getQualifiedName().equals(FLOWPORT)) {
				flowPortStereotype = sub;
				break;
			}
		}
		
		for (Stereotype sub : UMLUtil.findSubstereotypes(pkg, BLOCK)) {
			if (sub.getQualifiedName().equals(BLOCK)) {
				blockStereotype = sub;
				break;
			}
		}

		for (Stereotype sub : UMLUtil.findSubstereotypes(pkg, SYSTEM)) {
			if (sub.getQualifiedName().equals(SYSTEM)) {
				systemStereotype = sub;
				break;
			}
		}
		
		for (Stereotype sub : UMLUtil.findSubstereotypes(pkg, CONTRACT)) {
			if (sub.getQualifiedName().equals(CONTRACT)) {
				contractStereotype = sub;
				break;
			}
		}
	}
	
	/**
	 * Main method to be invoked to parse an OSS file.
	 * @throws Exception
	 */
	public void startParsing(Package pkg, File ossFile) throws Exception, ImportException, IOException {	
		OSS ocraOssFile;
		sysView = pkg;	// Set the given package as working package

		// Retrieve the needed stereotypes 
		refreshStereotypes(sysView);
		
		long startTime = System.currentTimeMillis();
		
		if (ossFile != null) {
			ocraOssFile = OSSModelFactory.getInstance().createOssModel(ossFile);
		} else {
			return;
		}
			
		//Retrieve SystemView and ComponentView packages
//		sysView = getSystemView();
//		compView = getComponentView();
				
		// For the specific WBS example, go inside a particular package
//		EList<Package> pkgList = sysView.getNestedPackages();
//		for (Package p : pkgList) {
//			if (p.getName().equals("PhysicalArchitecture")) {
//				sysView = p;
//				break;
//			}
//		}
						
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

		dslTypeToComponent = new HashMap<String, Class>();

		// Clear the exception before starting the import
		importException = null;
		
		// Start a transaction to modify the package content 
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(pkg);
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {

				// Add the systemComponent to the package
				Class systemComponent = createSystemBlock(sysView, dslSystemComponent.getType());

				// Store the systemComponent in a hash with its name
				dslTypeToComponent.put(dslSystemComponentName, systemComponent);

				// Populate the map and the package with the other Component elements 
				for (Component dslComponent : ocraOssFile.getComponents()) {
					Class component = createBlock(sysView, dslComponent.getType());
					if(dslTypeToComponent.put(dslComponent.getType(), component) != null) {
						logger.error("Duplicated component type, not added: " + dslComponent.getType());
					} else {
						logger.debug("component.type = " + dslComponent.getType());
					}
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
				
				logger.debug("Total time = " + (System.currentTimeMillis() - startTime));
				System.out.println("Total time = " + (System.currentTimeMillis() - startTime));
			}
		});
		
		// Propagate the exception, if any
		if (importException != null) {
			throw importException;
		}
	}
}
