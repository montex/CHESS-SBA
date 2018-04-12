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
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.FunctionBehavior;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Constraint;
import org.polarsys.chess.OSSImporter.exceptions.ImportException;
import org.polarsys.chess.OSSImporter.utils.CHESSElementsUtil;
import org.polarsys.chess.OSSImporter.utils.TypesUtil;
import org.polarsys.chess.contracts.profile.chesscontract.ContractProperty;
import org.polarsys.chess.contracts.profile.chesscontract.ContractRefinement;
import org.polarsys.chess.contracts.profile.chesscontract.FormalProperty;
import org.polarsys.chess.contracts.profile.chesscontract.util.ContractEntityUtil;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;
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
import org.eclipse.papyrus.sysml.portandflows.FlowDirection;
import org.eclipse.papyrus.sysml.portandflows.FlowPort;

import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.service.types.utils.ElementUtil;
import org.eclipse.papyrus.uml.tools.utils.UMLUtil;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.equinox.internal.app.AppPersistence;
import org.eclipse.jface.viewers.IStructuredSelection;

/**
 * This class takes as input a file in OCRA format and creates the equivalent CHESS model.
 * @author cristofo
 *
 */
public class ImportOSSFileAction {

	// The instance of this class
	private static ImportOSSFileAction classInstance;

	private final ChessSystemModel chessSystemModel = ChessSystemModel.getInstance();
	private final ContractEntityUtil contractEntityUtil = ContractEntityUtil.getInstance();
	private final EntityUtil entityUtil = EntityUtil.getInstance();
	private final TypesUtil typeUtil = TypesUtil.getInstance();
	private final CHESSElementsUtil chessElementsUtil = CHESSElementsUtil.getInstance();
	
	// Will contain elements being added to the model, big enough
	private final EList<Element> addedElements = new BasicEList<>(2000);	 
	
	private static final String BLOCK =		"SysML::Blocks::Block";
	private static final String FLOWPORT =	"SysML::PortAndFlows::FlowPort";
	
//	private static final String SUBSYSTEM = "CHESSContract::SubSystem";
//	public static final String COLLECTIONTYPE = "MARTE::MARTE_Annexes::VSL::DataTypes::CollectionType";
//	private static final String MARTE_BOOLEAN_TYPE = "MARTE_Library::MARTE_PrimitivesTypes::Boolean";
//	private static final String MARTE_REAL_TYPE = "MARTE_Library::MARTE_PrimitivesTypes::Real";
//	private static final String MARTE_INTEGER_TYPE = "MARTE_Library::MARTE_PrimitivesTypes::Integer";
	 
	
	//TODO the list of Stereotype variables and the refreshStereotypes method should be moved to a new class e.g. StereotypeUtil 
	// Stereotype objects needed to customize the elements
	Stereotype contractPropertyStereotype;
	Stereotype delegationConstraintStereotype;
	Stereotype contractRefinementStereotype;
	Stereotype flowPortStereotype;
	Stereotype contractStereotype;
	Stereotype boundedTypeStereotype;
	Stereotype blockStereotype;
	Stereotype systemStereotype;
	
	final Injector injector = XTextResourceUtil.getInstance().getOssInjector();
	private final ISerializer serializer = injector.getInstance(ISerializer.class);

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
	 * @return the instance of this class
	 */
	public static ImportOSSFileAction getInstance() {
		if (classInstance == null) {
			classInstance = new ImportOSSFileAction();
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
		
	/**
	 * Returns the list of contract refinements associated to a Class
	 * @param owner the owner Class
	 * @return the list of contract refinements
	 */
	private EList<DataType> getContractRefinementsOfClass(Class owner) {
		EList<DataType> contractRefinements = new BasicEList<DataType>();
		
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
		ConnectableElement role;
		Property partWithPort;
		
		if (sourceOwner == null) {

			// I'm the owner of the port
			role = owner.getOwnedPort(sourcePort, null);
			partWithPort = null;
		} else {

			// Retrieve the component instance containing the port and set it
			partWithPort = entityUtil.getUMLComponentInstance(owner, sourceOwner);

			// Now I have to get the port object from the owning element
			// Get the component type
			final String typeName = partWithPort.getType().getName();

			// Get the component object containing the definition of the port
			final Class portOwner = dslTypeToComponent.get(typeName);

			// Get the port and set it
			role = portOwner.getOwnedPort(sourcePort, null);
		}
		return chessElementsUtil.createConnectorEnd(connector, partWithPort, role);
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
		EList<Constraint> existingDelegationConstraints = entityUtil.getDelegationConstraintsAsUMLConstraints(owner);
		
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
		
		// Get all the refinement formal properties
		final EList<Constraint> existingFormalProperties = (EList<Constraint>) chessSystemModel.getRefinementAssertions(owner);

		// Prepare the map to mark existing formal properties
		final HashMap<String, Boolean> mapFormalProperties = Maps.newHashMapWithExpectedSize(existingFormalProperties.size());
		for (Constraint formalProperty : existingFormalProperties) {
			mapFormalProperties.put(formalProperty.getQualifiedName(), null);
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
						addedElements.add(chessElementsUtil.createAssociation(owner, subName, (Type) dslTypeToComponent.get(subType))); 
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
					
					if ((connector = chessElementsUtil.getExistingConnector(existingConnectors, variable, constraint)) != null) {
						logger.debug("connector already present");
						
						// Set the flag to signal the connector is still used
						mapConnectors.put(connector.getQualifiedName(), Boolean.TRUE);
						continue;
					} else if ((constraint instanceof Expression && !(constraint instanceof PortId)) ||
							(isFunctionBehavior(owner, variable) && isFunctionBehavior(owner, constraint))) {
						
						// It could be a delegation constraint, check it
						Constraint delegationConstraint = null;

						if ((delegationConstraint = chessElementsUtil.getExistingDelegationConstraint(existingDelegationConstraints, variable, constraint)) != null) {
							logger.debug("delegation constraint already present");

							// Set the flag to signal the delegation constraint is still used
							mapDelegationContraints.put(delegationConstraint.getQualifiedName(), Boolean.TRUE);
							continue;
						} else {
							logger.debug("delegation constraint is not present");

							// Create a delegation constraint, can be a LogicalExpression, IntegerLiteral, AddSubExpression, ...
							addedElements.add(chessElementsUtil.createDelegationConstraint(owner, variable, constraint));
							continue;
						}						
					}
					
					logger.debug("connector is not present");

					// Create the source end
					if (constraint instanceof PortId) {
						
						// Create a connector, but only after I'm sure it isn't a delegation constraint
						connector = chessElementsUtil.createConnector(owner);
						
						String portOwner = null;
						
						// Get the component name, should be at max one
						final EList<String> componentNames = ((PortId) constraint).getComponentNames();
						if (componentNames != null && componentNames.size() != 0) {
							portOwner = componentNames.get(0);
						}

						final String portName = ((PortId) constraint).getName();
						logger.debug("Creating source end " + portOwner + ":" + portName);
						if (createConnectorEnd(owner, connector, portOwner, portName) == null) {
							continue;
						}
					}

					// Create the target end
					if (variable instanceof PortId) {						
						String portOwner = null;
						
						// Get the component name, should be at max one
						final EList<String> componentNames = ((PortId) variable).getComponentNames();
						if (componentNames != null && componentNames.size() != 0) {
							portOwner = componentNames.get(0);
						}
						
						final String portName = ((PortId) variable).getName();					
						logger.debug("Creating target end " + portOwner + ":" + portName);
						if (createConnectorEnd(owner, connector, portOwner, portName) == null) {
							continue;
						}
					} else if (variable instanceof ParameterId) {
						
						// ParameterId not handled
						final String message = "Found ParameterId, don't know how to handle it!";
						logger.error("Import Error: " + message);
						importErrors.append(message + "\n");
					} else {
						final String message = "Found " + variable + " don't know how to handle it!";
						logger.error("Import Error: " + message);
						importErrors.append(message + "\n");						
					}
										
					// At last, add the connector to the owner
					chessElementsUtil.addConnector(owner, connector);
					
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
						final Property refiningComponentInstance = entityUtil.getUMLComponentInstance(owner, contractId.getComponentName());

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
							final DataType umlRefinement = chessElementsUtil.createContractRefinement(owner, contractId.getComponentName(), contractId.getName());
							chessElementsUtil.addContractRefinementToContractProperty(contractProperty, umlRefinement);

							// Store the new refinement
							addedElements.add(umlRefinement);
						}
					}
					
				} else if (dslRefInstance != null && dslRefInstance.getFormula() != null) {
					
					// CONSTRAINT processing
					final String message = "Found a CONSTRAINT tag, don't know how to handle it!";
					logger.error("Import Error: " + message);
					importErrors.append(message + "\n");
				} else if (dslRefInstance != null && dslRefInstance.getProp() != null) {

					// PROP processing
					final String message = "Found a PROP tag, don't know how to handle it!";
					logger.error("Import Error: " + message);
					importErrors.append(message + "\n");
				} else if (dslRefInstance != null && dslRefInstance.getAssertion() != null) {

					// ASSERTION processing
					final Assertion assertion = dslRefInstance.getAssertion();
					final String assertionName = assertion.getName();
					final String assertionText = chessElementsUtil.getConstraintText(assertion.getConstraint());

					// Retrieve the formal property from the owner, if any (working on the assertion name)
					Constraint umlConstraint = owner.getOwnedRule(assertionName);

					if (umlConstraint == null || !entityUtil.isFormalProperty(umlConstraint)) {
						logger.debug("Formal property non found, creating one");
						umlConstraint = chessElementsUtil.createRefinementFormalProperty(owner, assertionName, assertionText);
						
						// Add the constraint to the list of created elements
						addedElements.add(umlConstraint);
					} else {
						if (entityUtil.isFormalProperty(umlConstraint)) {
							logger.debug("Formal property already present");

							// Update the formal property if needed

							final FormalProperty formalProperty = entityUtil.getFormalProperty(umlConstraint);						
							final String formalPropertyText = entityUtil.getFormalPropertyStr(formalProperty);
							
							// If the expression is different, save it, otherwise go on
							if (!assertionText.equals(formalPropertyText)) {
								contractEntityUtil.saveFormalProperty(umlConstraint, assertionText);
							}
							
							// Set the flag to signal the formal property is still used
							mapFormalProperties.put(umlConstraint.getQualifiedName(), Boolean.TRUE);
						}
					}
				}
			}
		}
		
		// Component instances cleanup time, associations will be removed automatically
		for (String qualifiedElement : mapComponentInstances.keySet()) {
			if (mapComponentInstances.get(qualifiedElement) == null) {
//				System.out.println("component instance " + qualifiedElement + " should be removed");
				chessElementsUtil.removeProperty(existingComponentInstances, qualifiedElement);
			}
		}
		
		// Connectors cleanup time
		for (String qualifiedElement : mapConnectors.keySet()) {
			if (mapConnectors.get(qualifiedElement) == null) {
//				System.out.println("connector " + qualifiedElement + " should be removed");
				chessElementsUtil.removeConnector(existingConnectors, qualifiedElement);
			}
		}
		
		// Delegation constraints cleanup time
		for (String qualifiedElement : mapDelegationContraints.keySet()) {
			if (mapDelegationContraints.get(qualifiedElement) == null) {
//				System.out.println("delegation constraint " + qualifiedElement + " should be removed");
				chessElementsUtil.removeDelegationConstraint(existingDelegationConstraints, qualifiedElement);
			}
		}

		// Contract refinements cleanup time
		for (String qualifiedElement : mapContractRefinements.keySet()) {
			if (mapContractRefinements.get(qualifiedElement) == null) {
//				System.out.println("contract refinement " + qualifiedElement + " should be removed");
				chessElementsUtil.removeContractRefinement(existingContractRefinements, qualifiedElement);
			}
		}
		
		// Formal properties cleanup time
		for (String qualifiedElement : mapFormalProperties.keySet()) {
			if (mapFormalProperties.get(qualifiedElement) == null) {
//				System.out.println("formalProperty " + qualifiedElement + " should be removed");
				chessElementsUtil.removeFormalProperty(existingFormalProperties, qualifiedElement);
			}
		}
	}
	
	/**
	 * Creates a map with the formal properties text and the objects
	 * @param existingFormalProperties the list of constraints of the object
	 * @return the requested map
	 */
	//FIXME: this works only if expressions are different, otherwise they'll be overwritten
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
		
		// Prepare the map to mark existing contracts
		final HashMap<String, Boolean> mapContractProperties = Maps.newHashMapWithExpectedSize(existingContractProperties.size());
		for (ContractProperty contractProperty : existingContractProperties) {
			mapContractProperties.put(contractProperty.getBase_Property().getQualifiedName(), null);
		}
		// Get all the interface formal properties
		final EList<Constraint> existingFormalProperties = (EList<Constraint>) chessSystemModel.getInterfaceAssertions(owner);

		// Create an hash map for the existing formal properties
		final HashMap<String, FormalProperty> hashFormalProperties = prepareFormalPropertiesMap(existingFormalProperties);
		
		// Prepare the map to mark existing formal properties
		final HashMap<String, Boolean> mapFormalProperties = Maps.newHashMapWithExpectedSize(existingFormalProperties.size());
		for (Constraint formalProperty : existingFormalProperties) {
			mapFormalProperties.put(formalProperty.getQualifiedName(), null);
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
								final Type newType = chessElementsUtil.getTypeFromDSLType(dslVariableType, owner.getNearestPackage());
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
								addedElements.add(chessElementsUtil.createNonStaticPort(owner, dslVariableID, dslVariableType, true));
							} else if (dslVariable instanceof OutputPort) {
								addedElements.add(chessElementsUtil.createNonStaticPort(owner, dslVariableID, dslVariableType, false));
							}
						}
												
					} else if (dslVariable instanceof Parameter) {
						
						// PARAMETER processing
						final VariableId dslVariableID = dslVariable.getId();
						final SimpleType dslVariableType = dslVariable.getType();

						// Check if there are optional parameters to detect how to handle it
						final EList<SimpleType> parameters = ((Parameter) dslVariable).getParameters();
						if (parameters.size() != 0) {
							
							// Check if the functionBehavior is already present
							FunctionBehavior functionBehavior = (FunctionBehavior) owner.getOwnedBehavior(dslVariableID.getName());
							
							if (functionBehavior == null) {
								logger.debug("functionBehavior not found, creating one");
								
								// Create an empty functionBehavior
								functionBehavior = chessElementsUtil.createFunctionBehavior(owner, dslVariableID.getName());
								
								// Create the input parameters
								for (SimpleType parameterType : parameters) {
									chessElementsUtil.createFunctionBehaviorParameter(functionBehavior, parameterType, true);
								}

								// Create the output parameter
								chessElementsUtil.createFunctionBehaviorParameter(functionBehavior, dslVariableType, false);
																
								addedElements.add(functionBehavior);
							} else {
								logger.debug("functionBehavior already present");
								
								// Get all the existing parameters of the functionBehavior
								final EList<org.eclipse.uml2.uml.Parameter> existingFunctionBehaviorParameters = functionBehavior.getOwnedParameters(); 
								
								// Stategy here is a little different. Remove all the parameters and add them from scratch

								final EList<org.eclipse.uml2.uml.Parameter> toRemoveFunctionBehaviorParameters = new BasicEList<org.eclipse.uml2.uml.Parameter>(existingFunctionBehaviorParameters);

								// Remove all the existing parameters
								for (org.eclipse.uml2.uml.Parameter parameter : toRemoveFunctionBehaviorParameters) {
									chessElementsUtil.removeFunctionBehaviorParameter(existingFunctionBehaviorParameters, parameter.getQualifiedName());
								}

								// Create the input parameters
								for (SimpleType parameterType : parameters) {
									chessElementsUtil.createFunctionBehaviorParameter(functionBehavior, parameterType, true);
								}

								// Create the output parameter
								chessElementsUtil.createFunctionBehaviorParameter(functionBehavior, dslVariableType, false);

								// Old code that tries to solve it in a different manner
//								// Prepare the map to mark existing parameters
//								final HashMap<String, Boolean> mapFunctionBehaviorParameters = Maps.newHashMapWithExpectedSize(existingFunctionBehaviorParameters.size());
//								for (org.eclipse.uml2.uml.Parameter parameter : existingFunctionBehaviorParameters) {
//									mapFunctionBehaviorParameters.put(parameter.getQualifiedName(), null);
//								}
//
//								org.eclipse.uml2.uml.Parameter parameter = null;
//								
//								// Check the input parameters
//								for (SimpleType parameterType : parameters) {
//									if ((parameter = chessElementsUtil.getExistingFunctionBehaviorParameter(existingFunctionBehaviorParameters, parameterType, true)) != null) {
//										mapFunctionBehaviorParameters.put(parameter.getQualifiedName(), Boolean.TRUE);
//										logger.debug("functionBehavior input parameter already present");
//									} else {
//										logger.debug("functionBehavior input parameter is not present");
//										
//										// Create the input parameter
//										chessElementsUtil.createFunctionBehaviorParameter(functionBehavior, parameterType, true);
//									}
//								}
//									
//								// Check the output parameter
//								if ((parameter = chessElementsUtil.getExistingFunctionBehaviorParameter(existingFunctionBehaviorParameters, dslVariableType, false)) != null) {
//									logger.debug("functionBehavior output parameter already present");
//									mapFunctionBehaviorParameters.put(parameter.getQualifiedName(), Boolean.TRUE);
//								} else {
//									logger.debug("functionBehavior output parameter is not present");
//
//									// Create the output parameter
//									chessElementsUtil.createFunctionBehaviorParameter(functionBehavior, dslVariableType, false);
//								}
//								
//								// Parameters cleanup time
//								for (String qualifiedElement : mapFunctionBehaviorParameters.keySet()) {
//									if (mapFunctionBehaviorParameters.get(qualifiedElement) == null) {
//										System.out.println("functionBehaviorParameter " + qualifiedElement + " should be removed");
//										chessElementsUtil.removeFunctionBehaviorParameter(existingFunctionBehaviorParameters, qualifiedElement);
//									}
//								}
								
								// Set the flag to signal the functionBehavior is still used
								mapFunctionBehaviors.put(functionBehavior.getQualifiedName(), Boolean.TRUE);
							}
						} else {
							
							// Convert the parameter to a static port
							// Check if the port is already present
							org.eclipse.uml2.uml.Port port = null;
							for (Object object : existingPorts) {
								final org.eclipse.uml2.uml.Port tmpPort = (org.eclipse.uml2.uml.Port) object;
								if (tmpPort.getName().equals(dslVariableID.getName()) && 
										tmpPort.getType().getName().equals(chessElementsUtil.getTypeFromDSLType(dslVariableType, owner.getNearestPackage()).getName())) {
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
								addedElements.add(chessElementsUtil.createStaticPort(owner, dslVariableID, dslVariableType));
								continue;
							}
						}
					} else if (dslVariable instanceof Operation) {
						
						// PROVIDED OPERATION processing
						final String message = "Found a OPERATION tag, don't know how to handle it!";
						logger.error("Import Error: " + message);
						importErrors.append(message + "\n");
					} else {
						final String message = "Found a " + dslVariable + " tag, don't know how to handle it!";
						logger.error("Import Error: " + message);
						importErrors.append(message + "\n");						
					}
				} else if (dslIntInstance != null && dslIntInstance.getDefine() != null) {
				
					// DEFINE processing
					final String message = "Found a DEFINE tag, don't know how to handle it!";
					logger.error("Import Error: " + message);
					importErrors.append(message + "\n");
				} else if (dslIntInstance != null && dslIntInstance.getContract() != null) {
					
					// CONTRACT processing					
					final Contract dslContract = dslIntInstance.getContract();					
					final Assumption dslAssumption = dslContract.getAssumption();
					final Guarantee dslGuarantee = dslContract.getGuarantee();

					// Retrieve the contract type from the owner, if any
					Class umlContract = (Class) owner.getOwnedMember(dslContract.getName(), false, UMLFactory.eINSTANCE.createClass().eClass());

					if (umlContract == null) {
						logger.debug("contract non found, creating one");
						
						// Create an empty Contract
						umlContract = chessElementsUtil.createContract(owner, dslContract.getName());
						org.polarsys.chess.contracts.profile.chesscontract.Contract contract = contractEntityUtil.getContract(umlContract);

						// Check if the assumption formal property is already defined
						//FIXME: this works good only if expressions are different
						final FormalProperty assumption = hashFormalProperties.get(chessElementsUtil.getConstraintText(dslAssumption.getConstraint()));
						if (assumption != null) {
							
							// Add the assume formal property
							contract.setAssume(assumption);						
						} else {
							
							// Create a new formal property
							contractEntityUtil.saveFormalProperty("Assume", 
									chessElementsUtil.getConstraintText(dslAssumption.getConstraint()), umlContract);
						}
						
						// Check if the guarantee formal property is already defined
						final FormalProperty guarantee = hashFormalProperties.get(chessElementsUtil.getConstraintText(dslGuarantee.getConstraint()));
						if (guarantee != null) {
							
							logger.debug("guarantee already present = " + guarantee);
							
							// Add the assume formal property
							contract.setGuarantee(guarantee);
						} else {
							
							logger.debug("guarantee not present");
							
							// Create a new formal property
							contractEntityUtil.saveFormalProperty("Guarantee", 
									chessElementsUtil.getConstraintText(dslGuarantee.getConstraint()), umlContract);
						}						
						
//						// Add the two Formal Properties
//						contractEntityUtil.saveFormalProperty("Assume", chessElementsUtil.getConstraintText(dslAssumption.getConstraint()), umlContract);
//						contractEntityUtil.saveFormalProperty("Guarantee", chessElementsUtil.getConstraintText(dslGuarantee.getConstraint()), contract);
	
						// Create a Contract Property
						final String contractPropertyName = chessElementsUtil.createContractPropertyNameFromContract(umlContract);
						chessElementsUtil.createContractProperty(owner, contractPropertyName, (Type) umlContract);				
						addedElements.add(umlContract);
					}  else {
						logger.debug("Contract already present");

						// The contract type is already present, update the formal properties if needed

						final String assumeString = contractEntityUtil.getAssumeStrFromUmlContract(umlContract);
						final FormalProperty assumeFormalProperty = contractEntityUtil.getAssumeFromUmlContract(umlContract);
						
						// The formal property is the same, mark it as still used
						mapFormalProperties.put(assumeFormalProperty.getBase_Constraint().getQualifiedName(), Boolean.TRUE);							
						
						if (chessElementsUtil.getConstraintText(dslAssumption.getConstraint()).equals(assumeString)) {							
						} else {
							
							// Change the text of the assume property
							final ValueSpecification vs = assumeFormalProperty.getBase_Constraint().getSpecification();
							((LiteralString) vs).setValue(chessElementsUtil.getConstraintText(dslAssumption.getConstraint()));
							assumeFormalProperty.getBase_Constraint().setSpecification(vs);
						}
						
						final String guaranteeString = contractEntityUtil.getGuaranteeStrFromUmlContract(umlContract);
						final FormalProperty guaranteeFormalProperty = contractEntityUtil.getGuaranteeFromUmlContract(umlContract);
						
						// The formal property is the same, mark it as still used
						mapFormalProperties.put(guaranteeFormalProperty.getBase_Constraint().getQualifiedName(), Boolean.TRUE);							

						if (chessElementsUtil.getConstraintText(dslGuarantee.getConstraint()).equals(guaranteeString)) {
						} else {
							
							// Change the text of the guarantee property
							final ValueSpecification vs = guaranteeFormalProperty.getBase_Constraint().getSpecification();
							((LiteralString) vs).setValue(chessElementsUtil.getConstraintText(dslGuarantee.getConstraint()));
							guaranteeFormalProperty.getBase_Constraint().setSpecification(vs);
						}
						
						// Set the flag to signal the contractProperty is still used
						final ContractProperty contractProperty = (ContractProperty) chessSystemModel.getContract(owner, dslContract.getName());
						mapContractProperties.put(contractProperty.getBase_Property().getQualifiedName(), Boolean.TRUE);
					}
				} else if (dslIntInstance != null && dslIntInstance.getAssertion() != null) {
					
					// ASSERTION processing
					final Assertion assertion = dslIntInstance.getAssertion();
					final String assertionName = assertion.getName();
					final String assertionText = chessElementsUtil.getConstraintText(assertion.getConstraint());
					
					// Retrieve the formal property from the owner, if any (working on the assertion name)
					Constraint umlConstraint = owner.getOwnedRule(assertionName);

					if (umlConstraint == null || !entityUtil.isFormalProperty(umlConstraint)) {
						logger.debug("Formal property non found, creating one");
						umlConstraint = chessElementsUtil.createInterfaceFormalProperty(owner, assertionName, assertionText);
						
						// Add the constraint to the list of created elements
						addedElements.add(umlConstraint);
						
						// Add the formal property to the hash
						hashFormalProperties.put(assertionText, entityUtil.getFormalProperty(umlConstraint));
					} else {
						if (entityUtil.isFormalProperty(umlConstraint)) {
							logger.debug("Formal property already present");

							// Update the formal property if needed

							final FormalProperty formalProperty = entityUtil.getFormalProperty(umlConstraint);						
							final String formalPropertyText = entityUtil.getFormalPropertyStr(formalProperty);
							
							// If the expression is different, save it, otherwise go on
							if (!assertionText.equals(formalPropertyText)) {
								
								hashFormalProperties.remove(formalPropertyText, formalProperty);
								contractEntityUtil.saveFormalProperty(umlConstraint, assertionText);
								
								hashFormalProperties.put(assertionText, formalProperty);
							}
							
							// Set the flag to signal the formal property is still used
							mapFormalProperties.put(umlConstraint.getQualifiedName(), Boolean.TRUE);
						}
					}
				}
			}
		}
		
		// Ports cleanup time 
		for (String qualifiedElement : mapPorts.keySet()) {
			if (mapPorts.get(qualifiedElement) == null) {
//				System.out.println("port " + qualifiedElement + " should be removed");
				chessElementsUtil.removePort(existingPorts, qualifiedElement);
			}
		}
		
		// Contracts cleanup time
		// ** Contract instances and contract types are removed, but not their formal properties and refinements!
		for (String qualifiedElement : mapContractProperties.keySet()) {
			if (mapContractProperties.get(qualifiedElement) == null) {
//				System.out.println("contractProperty " + qualifiedElement + " should be removed");
				chessElementsUtil.removeContractProperty(existingContractProperties, qualifiedElement);
			}
		}
		
		// Formal properties cleanup time
		for (String qualifiedElement : mapFormalProperties.keySet()) {
			if (mapFormalProperties.get(qualifiedElement) == null) {
//				System.out.println("formalProperty " + qualifiedElement + " should be removed");
				chessElementsUtil.removeFormalProperty(existingFormalProperties, qualifiedElement);
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
	public StringBuffer startParsing(Package pkg, File ossFile) throws Exception, ImportException, IOException {	
		OSS ocraOssFile;
		sysView = pkg;	// Set the given package as working package
		
		importErrors = new StringBuffer();

		// Retrieve the needed stereotypes 

		refreshStereotypes(sysView);
		
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
					systemComponent = chessElementsUtil.createSystemBlock(sysView, dslSystemComponent.getType());
					
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
						component = chessElementsUtil.createBlock(sysView, dslComponent.getType());

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
						chessElementsUtil.removeElement(existingBlocks, qualifiedElement);
					}
				}
				
				logger.debug("Total time = " + (System.currentTimeMillis() - startTime));

				System.out.println("Total time = " + (System.currentTimeMillis() - startTime));

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
		
		return importErrors;
	}
}

//TODO: andrebbero rimossi anche i tipi creati, signal, enumeration, boundedsubtype,...
