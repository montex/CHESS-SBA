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
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.Model;
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
import org.polarsys.chess.OSSImporter.parser.ParseHelper;
import org.polarsys.chess.contracts.profile.chesscontract.ContractProperty;
import org.polarsys.chess.contracts.profile.chesscontract.ContractRefinement;
import org.polarsys.chess.contracts.profile.chesscontract.util.ContractEntityUtil;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;
import org.polarsys.chess.core.util.uml.UMLUtils;

import com.google.inject.Injector;

import eu.fbk.eclipse.standardtools.utils.FileSystemUtil;
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
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.dialogs.MessageDialog;

/**
 */
public class ImportOSSFileAction {

	private static ImportOSSFileAction sampleView;
	
	/**
	 * Gets an instance of the class if already present, or a new one if not
	 * @return the instance of this class
	 */
	public static ImportOSSFileAction getInstance() {
		if (sampleView == null) {
			sampleView = new ImportOSSFileAction();
		}
		return sampleView;
	}
	
//	private static final String SUFFIX = "_test";	// It could be possible to add a suffix to block names
	private static final String DELEGATION_PREFIX = "Define_";
	private static final String DELEGATION_CONSTRAINT_NAME = "constraintSpec";
	private static final String CONNECTOR_NAME = "connector";
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
	private static final String COMPINST =				"CHESSContract::ComponentInstance";

//	private static final String SYSVIEW =	"CHESS::Core::CHESSViews::SystemView";
//	private static final String COMPVIEW =	"CHESS::Core::CHESSViews::ComponentView";
//	private static final String CHESS =		"CHESS::Core::CHESS";
	
	private static final String BLOCK =		"SysML::Blocks::Block";
	
	private static final String FLOWPORT =	"SysML::PortAndFlows::FlowPort";
	
	/*
	
	private static final String SUBSYSTEM = "CHESSContract::SubSystem";
	public static final String COLLECTIONTYPE = "MARTE::MARTE_Annexes::VSL::DataTypes::CollectionType";
	private static final String MARTE_BOOLEAN_TYPE = "MARTE_Library::MARTE_PrimitivesTypes::Boolean";
	private static final String MARTE_REAL_TYPE = "MARTE_Library::MARTE_PrimitivesTypes::Real";
	private static final String MARTE_INTEGER_TYPE = "MARTE_Library::MARTE_PrimitivesTypes::Integer";

	 */
	
	final Injector injector = new OssStandaloneSetup().createInjector();
	private final ISerializer serializer = injector.getInstance(ISerializer.class);
//	private ContractEntityUtil contractEntityUtil = ContractEntityUtil.getInstance();
//	private EntityUtil entityUtil = EntityUtil.getInstance();
	private Package sysView = null;
//	private Package compView = null;

	// Map the name of the component with the Component object
	private final Map<String, Class> dslTypeToComponent = new HashMap<String, Class>();

	/**
	 * The constructor
	 */
	public ImportOSSFileAction() {
	}

	/**
	 * Utility dialog to display a message on screen
	 * @param message the text to display
	 */
	private void showMessage(String message) {
		
		Display defaultDisplay = Display.getDefault();

		defaultDisplay.syncExec(new Runnable() {
			@Override
			public void run() {
				Shell currShell = defaultDisplay.getActiveShell();
				MessageDialog.openInformation(currShell, "OSS parser", message);
			}
		});
	}

	/**
	 * Print a message on the console
	 * @param message the message to print
	 */
	private void printMessageOnOut(String message) {
//		System.out.println(message);	// Comment to avoid printing
	}
	
	/** 
	 * Creates a OSS Model 
	 * @param ossFile a File containing the OCRA model
	 * @return the OSS object 
	 */
	private OSS getOssModel(File ossFile) throws Exception {
		String ossDefinition = FileSystemUtil.getFileContent(ossFile);
		final ParseHelper<?> parseHelper = injector.getInstance(ParseHelper.class);
		OSS result = (OSS) parseHelper.parse(ossDefinition);

		return result;
	}

	/** 
	 * Creates and adds a Component Instance to the model
	 * @param owner the parent Class
	 * @param elementName the name of the property to create
	 * @param elementType the type of the property to create
	 * @return the created Property
	 */
	private Property createComponentInstance(Class owner, String elementName, Type elementType) {
		
		printMessageOnOut("\n\n\n Creating property " + elementName + " for owner " + owner + " with type " + elementType);
		printMessageOnOut("\n\n\n");

		Property newUMLProperty = owner.createOwnedAttribute(elementName, elementType);
		UMLUtils.applyStereotype(newUMLProperty, COMPINST);
		newUMLProperty.setAggregation(AggregationKind.get(AggregationKind.COMPOSITE));

		printMessageOnOut("\n\nCreated " + elementName + " Property\n\n");
		return newUMLProperty;
	}
	
	/** 
	 * Creates and adds a Contract Property to the model
	 * @param owner the parent Class
	 * @param elementName the name of the property to create
	 * @param elementType the type of the property to create
	 * @return the created Property
	 */
	private Property createContractProperty(Class owner, String elementName, Type elementType) {
		
		printMessageOnOut("\n\n\n Creating contract property " + elementName + " for owner " + owner + " with type " + elementType);
		printMessageOnOut("\n\n\n");

		Property newUMLProperty = owner.createOwnedAttribute(elementName, elementType);
		UMLUtils.applyStereotype(newUMLProperty, CONTRACT_PROP);

		printMessageOnOut("\n\nCreated " + elementName + " Property\n\n");
		return newUMLProperty;
	}
	
	/**
	 * Creates the Delegation Constraint value
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
	 * Creates and adds a Delegation Constraint to the model
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
		
		printMessageOnOut("\n\n\n Creating delegation constraint " + delegationName + " for owner " + owner);
		printMessageOnOut("\n\n\n");

		Constraint newUMLConstraint = owner.createOwnedRule(delegationName.toString());
		UMLUtils.applyStereotype(newUMLConstraint, DELEGATION_CONST);

		LiteralString literalString = UMLFactory.eINSTANCE.createLiteralString();
		literalString.setName(DELEGATION_CONSTRAINT_NAME);
		final String formalPropertyText = createDelegationConstraintText(variable, constraint);
		literalString.setValue(formalPropertyText);
		newUMLConstraint.setSpecification(literalString);

		printMessageOnOut("\n\nCreated " + delegationName + " Delegation Constraint\n\n");
		return newUMLConstraint;
	}

	/**
	 * Returns the contract with the given name
	 * @param umlComponent the component containing the contract
	 * @param contractName the name of the contract
	 * @return the UML class of the contract
	 */
	private Class getUMLContractFromContractName(Class umlComponent, String contractName) {
		return (Class) umlComponent.getNestedClassifier(contractName);
	}
	
	/** 
	 * Returns the contract property generated by the given contract name
	 * @param component the component containing the contract
	 * @param contractName the name of the contract
	 * @return the associated Contract Property
	 */
	private ContractProperty getContractPropertyFromContract(Class component, String contractName) {
		
		// Get the contract definition from the component
		final Class umlContract = getUMLContractFromContractName(component, contractName);
		
		// Get the contract property name, derived from the contract name
		final String contractPropertyName = getContractPropertyName(umlContract);
			
		// Get the contract property from the component, generic type
		final Property umlProperty = component.getOwnedAttribute(contractPropertyName, umlContract);
				
		// Return the correct type of object
		return ContractEntityUtil.getInstance().getContractProperty(umlProperty);
	}
	
	/**
	 *  Returns the refinement associated to the component
	 *  @param owner of the refinement
	 *  @param refinementName the name of the refinement
	 *  @return the umlRefinement
	 */
	private DataType getUMLRefinement(Class owner, String refinementName) {
		return (DataType) owner.getNestedClassifier(refinementName);
	}

	/**
	 * Returns the component instance with the given name 
	 * @param owner the class owning the instance
	 * @param componentName the name of the instance
	 * @return the UML property representing the component instance
	 */
	private Property getUMLComponentInstance(Class owner, String componentName) {
		
		final Set<Property> componentInstances = EntityUtil.getInstance().getSubComponentsInstances(owner);
		for (Property property : componentInstances) {
			if (property.getAppliedStereotype(COMPINST) != null && property.getName().equals(componentName)) {
				return property;
			}
		}
		return null;
	}
	
	/** 
	 * Creates a ContractRefinement for the given owner component.
	 * The refinement should specify the component instance that contains the original contract property
	 * and the contract property itself 
	 *  
	 * @param owner the containter of the refinement
	 * @param componentName the component instance containing the contract property
	 * @param contractName the type of the contract
	 * @return the created DataType 
	 */
	private DataType createContractRefinement(Class owner, String componentName, String contractName) {
					
		final Property componentInstance = getUMLComponentInstance(owner, componentName);
				
		// Get the type of the component instance 
		String typeName = componentInstance.getType().getName();
		
		printMessageOnOut("\n\n\n Creating contract refinement for componentName = " + componentName + " of contract " + contractName);
		printMessageOnOut("\n\n\n");
				
		// Remove the optional suffix
//		typeName = typeName.substring(0, typeName.indexOf(SUFFIX));
				
		// Get the component type where the contract property is defined
		final Class component = dslTypeToComponent.get(typeName);
		
		final ContractProperty contractProperty = getContractPropertyFromContract(component, contractName);
				
		// Compose the correct name of the contract refinement 
		final String refinementName = componentName + "." + contractProperty.getBase_Property().getName();
		
		// Check if the refinement is already present
		final DataType umlRefinement = getUMLRefinement(owner, refinementName);
		
		if (umlRefinement != null) {
			return umlRefinement;
		} else {
			printMessageOnOut("\n\n Creating contract refinement " + refinementName + " for owner " + owner.getName());
			printMessageOnOut("\n\n");
	
			DataType newUmlDataType = UMLFactory.eINSTANCE.createDataType();
			Classifier newClass = owner.createNestedClassifier(refinementName, newUmlDataType.eClass());
			Stereotype stereotype = UMLUtils.applyStereotype(newClass, CONTRACT_REFINEMENT);
			ContractRefinement contractRefinement = (ContractRefinement) newClass.getStereotypeApplication(stereotype);

			// Set the correct links for the refinement
			contractRefinement.setInstance(componentInstance); // The component instance containing the definition
			contractRefinement.setContract(contractProperty);  // The contract property that refines the contract
					
			printMessageOnOut("\n\nCreated " + refinementName + " Contract Refinement\n\n");
			return (DataType) newClass;
		}
	}

	/**
	 * Loads a package from the given resource
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
			System.err.println(we.getMessage());
			System.exit(1);
		}
		return package_;
	}

	/**
	 * Returns the primitive type from the standard primitive library
	 * @param name the name of the Type
	 * @return the requested primitive type
	 */
	private Type getPrimitiveType(String name) {

		// Load the correct library
		final Model umlLibrary = (Model) load(URI.createURI(UMLResource.UML_PRIMITIVE_TYPES_LIBRARY_URI));

		// Get the correct type
		final Type type = umlLibrary.getOwnedType(name);

		if (type != null) {
			printMessageOnOut("Type '" + type.getQualifiedName() + "' found.");
			return type;
		}
		return null;
	}

	/**
	 * Returns the primitive type from another UML library
	 * @param name the name of the Type
	 * @return the requested primitive type
	 */
	private Type getUMLPrimitiveType(String name) {
			
		// Get the correct model
		final Model chessContract = (Model) load(URI.createURI("pathmap://UML_LIBRARIES/UMLPrimitiveTypes.library.uml"));
			
		// Get the correct type
		final Type type = chessContract.getOwnedType(name);
		
		if (type != null) {
			printMessageOnOut("Type '" + type.getQualifiedName() + "' found.");
			return type;
		}
		return null;
	}

	/**
	 * Returns the Type Continuous
	 * @param name the name of the Type
	 * @return the requested Type
	 */
	private Type getContinuousType(String name) {
		
		// The Continuous type is defined here: CHESSContract::DataTypes::Continuous
		
		// Get the correct profile
		final Profile chessContract = (Profile) load(URI.createURI("pathmap://CHESSContract/CHESSContract.profile.uml"));
		
		// Get the correct package inside the profile
		final Package dataTypes = chessContract.getNestedPackage("DataTypes");
		
		// Get the correct type
		final Type type = dataTypes.getOwnedType(name);
		
		if (type != null) {
			printMessageOnOut("Type '" + type.getQualifiedName() + "' found.");
			return type;
		}
		return null;
	}
	
	/**
	 * Creates a new BoundedSubType as requested
	 * @param pkg the package where to create the Enumeration
	 * @param typeName the name of the type
	 * @param lowerBound the lower bound
	 * @param upperBound the upper bound
	 * @return the created type
	 */
	private Type createBoundedSubType(Package pkg, String typeName, int lowerBound, int upperBound) {
			
		// Create a data type to the component view and apply the stereotype
		Type dataType = pkg.createOwnedType(typeName, UMLPackage.Literals.DATA_TYPE);
		Stereotype stereotype = UMLUtils.applyStereotype(dataType, BOUNDED_TYPE);

		// Extract the stereotiped type and configure it
		BoundedSubtype boundedType = (BoundedSubtype) dataType.getStereotypeApplication(stereotype);		
		boundedType.setMinValue(String.valueOf(lowerBound));
		boundedType.setMaxValue(String.valueOf(upperBound));
		boundedType.setBaseType((DataType) getPrimitiveType("Integer"));
//		boundedType.setBaseType((DataType) getUMLPrimitiveType("Integer"));	// Alternative version	

		printMessageOnOut("Type '" + dataType.getQualifiedName() + "' created.");
		return dataType;
	}
	
	/**
	 * Returns a BoundedSubType as requested
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
			System.err.println("Import Error: Cannot understand the Bounded type limits! " + rangeType);
			return type;
		}
		
		// Generate a suitable type name
		final String typeName = "BoundedInteger_" + lowerBound + "_" + upperBound; 
		
		// Look for that type in the ComponentView
		type = pkg.getOwnedType(typeName);
		if (type != null) {
			
			// The type has been found in the package, use it
			printMessageOnOut("Type '" + type.getQualifiedName() + "' found.");
			return type;
		} else {
			return (Type) createBoundedSubType(pkg, typeName, lowerBound, upperBound);
		}
	}

	/**
	 * Retrieves all the Enumerations owned by the package
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
	 * Returns the list of the values inside a given Enumeration
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
	 * Returns the list of the values inside a given EnumType
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
	 * Looks for a specific enumeration among existing enumerations of the given package
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
	 * Creates a new Enumeration as requested
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

		printMessageOnOut("Type '" + enumeration.getQualifiedName() + "' created.");
		return enumeration;
	}
	
	/**
	 * Returns an Enumeration as requested
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
			printMessageOnOut("Type '" + type.getQualifiedName() + "' found.");
			return type;
		} else {
			return createEnumerationFromEnumType(pkg, enumType);
		}
	}
		
	/**
	 * Looks for a Signal already defined in the package
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

	/**
	 * Creates a Signal type in the given package
	 * @param pkg the package where to create the Enumeration 
	 * @return the newly created type 
	 */
	private Signal createSignalType(Package pkg) {
		final String signalName = SIGNAL_NAME;
				
		Type type = pkg.createOwnedType(signalName, UMLPackage.Literals.SIGNAL);
		
		printMessageOnOut("Type '" + type.getQualifiedName() + "' created.");
		return (Signal) type;
	}
	
	/**
	 * Returns a Signal as requested (Only a Signal can be defined in the package)
	 * @return the requested type
	 */
	private Type getSignalType() {
		Type type = null;
		Package pkg = sysView;	// Or compView, where to look for and create the type
		
		// Look for existing Signal Type in the package
		type = getExistingSignalType(pkg);
		
		if (type != null) {
			
			// The type has been found in the package, use it
			printMessageOnOut("Type '" + type.getQualifiedName() + "' found.");
			return type;
		} else {
			return createSignalType(pkg);
		}
	}
	
	/** 
	 * Returns the correct Type given the DSL SimpleType
	 * @param dslSimpleType the type from OSS
	 * @return the UML Type
	 */
	private Type getTypeFromDSLType(SimpleType dslSimpleType) {
		
		if (dslSimpleType instanceof BooleanType) {
			printMessageOnOut("BooleanType");
			return getPrimitiveType("Boolean");
		} else if (dslSimpleType instanceof IntegerType) {
			printMessageOnOut("IntegerType");
			return  getPrimitiveType("Integer");
		} else if (dslSimpleType instanceof RealType) {
			printMessageOnOut("RealType");
			return getPrimitiveType("Real");
		} else if (dslSimpleType instanceof WordType) {
			printMessageOnOut("WordType");
		} else if (dslSimpleType instanceof UnsignedWordType) {
			printMessageOnOut("UnsignedWordType");
		} else if (dslSimpleType instanceof SignedWordType) {
			printMessageOnOut("SignedWordType");
		} else if (dslSimpleType instanceof ContinuousType) {
			printMessageOnOut("ContinuousType");
			return getContinuousType("Continuous");
		} else if (dslSimpleType instanceof EventType) {
			printMessageOnOut("EventType");
			return getSignalType();
		} else if (dslSimpleType instanceof RangeType) {
			printMessageOnOut("RangeType");
			return getBoundedSubType((RangeType) dslSimpleType);
		} else if (dslSimpleType instanceof EnumType) {
			printMessageOnOut("EnumType");
			return getEnumerationType((EnumType) dslSimpleType);
		} else if (dslSimpleType instanceof ArrayType) {
			printMessageOnOut("ArrayType");
		} else if (dslSimpleType instanceof IntegerArrayType) {
			printMessageOnOut("IntegerArrayType");
		} else if (dslSimpleType instanceof WordArrayType) {
			printMessageOnOut("WordArrayType");
		}
		System.err.println("Import Error: Not able to map the requested DSL type!");
		return null;
	}
	
	/** 
	 * Creates and adds a Port to the model
	 * @param owner the parent Class
	 * @param elementName the name of the port to create
	 * @param elementType the type of the port to create
	 * @param isInput tells the direction of the flow
	 * @return the created Port
	 */
	private org.eclipse.uml2.uml.Port createPort(Class owner, VariableId elementName, SimpleType elementType, boolean isInput) {
		final String portName = elementName.getName();
		final Type portType = getTypeFromDSLType(elementType);
		  
		if(portType == null) {
			showMessage("Not able to map the requested type for port : " + portName);
//			return null;	// Create the port anyway, without type
		}
		
		org.eclipse.uml2.uml.Port umlPort = owner.createOwnedPort(portName, portType);
		Stereotype stereotype = UMLUtils.applyStereotype(umlPort, FLOWPORT);
		umlPort.setAggregation(AggregationKind.get(AggregationKind.COMPOSITE));
		FlowPort flowPort = (FlowPort) umlPort.getStereotypeApplication(stereotype);
		flowPort.setDirection(isInput? FlowDirection.IN: FlowDirection.OUT);

		printMessageOnOut("\n\nCreated " + portName + " Port\n\n");
		return umlPort;
	}
	
	/** 
	 * Creates a System Block element in the given package
	 * @param owner the Package that will contain the element
	 * @param elementName the name of the new System Block
	 * @return the created Class
	 */
	private Class createSystemBlock(Package owner, final String elementName) {

		Class sysBlock = owner.createOwnedClass(elementName, false);
		UMLUtils.applyStereotype(sysBlock, BLOCK);
		UMLUtils.applyStereotype(sysBlock, SYSTEM);
		
		printMessageOnOut("\n\nCreated " + elementName + " System Block\n\n");
		return sysBlock;
	}
	
	/** 
	 * Creates a Contract element
	 * @param owner the Class that will contain the element
	 * @param contractName the name of the new Contract
	 * @return the newly created Class
	 */
	private Class createContract(Class owner, String contractName) {

		printMessageOnOut("\n\n\n Creating contract " + contractName + " for owner " + owner);
		printMessageOnOut("\n\n\n");

		Class newUmlClass = UMLFactory.eINSTANCE.createClass();
		Classifier newClass = owner.createNestedClassifier(contractName, newUmlClass.eClass());
		UMLUtils.applyStereotype(newClass, CONTRACT);
		
		printMessageOnOut("\n\nCreated " + contractName + " Property\n\n");

		return (Class) newClass;
	}
	
	/** 
	 * Creates a Block element in the given package
	 * @param owner the Package that will contain the element
	 * @param elementName the name of the new Block
	 * @return the newly created Class
	 */
	private Class createBlock(Package owner, final String elementName) {

		Class umlClass = owner.createOwnedClass(elementName, false);
		UMLUtils.applyStereotype(umlClass, BLOCK);

//		owner.createPackagedElement(elementName, newUMLClass.eClass()); This also works...
//		owner.getPackagedElements().add(newUMLClass);	// This works too!
		
		printMessageOnOut("\n\nCreated " + elementName + " Block\n\n");
		return umlClass;	// Return the first occurence
	}
	
	/** 
	 * Adds a contract refinement to a contract property
	 * @param contractProperty the property to be enriched
	 * @param umlRefinement the refinement to add
	 */
	private void addContractRefinementToContractProperty(ContractProperty contractProperty, DataType umlRefinement) {
		final Stereotype stereotype = umlRefinement.getAppliedStereotype(CONTRACT_REFINEMENT);	
		final ContractRefinement contractRefinement = (ContractRefinement) umlRefinement.getStereotypeApplication(stereotype);
		
		// Add the new refinement to the list
		contractProperty.getRefinedBy().add(contractRefinement);
	}
	
	/**
	 * Creates a connector, but doesn't add it to the owner
	 * @param owner the owner element
	 * @return the created Connector
	 */
	private Connector createConnector(Class owner) {
		
		// Create the name using an incremental value
		final String connectorName = CONNECTOR_NAME + (owner.getOwnedConnectors().size() + 1);
		
		printMessageOnOut("\n\n\n Creating connector " + connectorName + " for owner " + owner);
		printMessageOnOut("\n\n\n");

		Connector connector = UMLFactory.eINSTANCE.createConnector();
		connector.setName(connectorName);
		
		printMessageOnOut("\n\nCreated " + connectorName + " Connector\n\n");
		return connector;	
	}

	/**
	 * Adds a connector to the given element
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

			// Remove the optional suffix
//			typeName = typeName.substring(0, typeName.indexOf(SUFFIX));

			// Get the component object containing the definition of the port
			final Class portOwner = dslTypeToComponent.get(typeName);

			// Get the port and set it
			org.eclipse.uml2.uml.Port port = portOwner.getOwnedPort(sourcePort, null);
			end.setRole(port);
		}

		return end;
	}

	/** 
	 * Parses the Refinements of the component
	 * @param dslParentComponent the AST Component owning the refinement
	 * @param dslComponentRefinement the Refinement element to be parsed
	 */
	private void parseRefinements(AbstractComponent dslParentComponent, Refinement dslComponentRefinement) {

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

					printMessageOnOut("\tsubcomponent name = " + subName);
					printMessageOnOut("\tsubcomponent type = " + subType);

					createComponentInstance(dslTypeToComponent.get(dslParentComponent.getType()), subName, (Type) dslTypeToComponent.get(subType));
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
						printMessageOnOut("Creating source end " + portOwner + ":" + portName);
						createConnectorEnd(dslTypeToComponent.get(dslParentComponent.getType()), connector, portOwner, portName);
					} else if (constraint instanceof Expression) {
						
						// Create a delegation constraint, can be a LogicalExpression, IntegerLiteral, AddSubExpression, ...
						createDelegationConstraint(dslTypeToComponent.get(dslParentComponent.getType()), variable, constraint);
						continue;	// No need to go ahead in the processing
					} else {
						
						// Unknown type of connection
						System.err.println("Constraint = " + constraint);
						showMessage("Import Error: Not able to recognize the connection type " + constraint.getValue());
						continue;						
					}

					// Create the target end
					if (variable instanceof PortId) {
						final String portOwner = ((PortId) variable).getComponentName();
						final String portName = ((PortId) variable).getName();					
						printMessageOnOut("Creating target end " + portOwner + ":" + portName);
						createConnectorEnd(dslTypeToComponent.get(dslParentComponent.getType()), connector, portOwner, portName);
					}
					
					// At last, add the connector to the owner
					addConnector(dslTypeToComponent.get(dslParentComponent.getType()), connector);
					
				} else if (dslRefInstance != null && dslRefInstance.getRefinedby() != null) {
					
					// REFINEDBY processing
					final RefinedBy refinement = dslRefInstance.getRefinedby();
					final String refinedContract = refinement.getName();
					
					printMessageOnOut("\n\n\nContract name = " + refinedContract + " from " + dslTypeToComponent.get(dslParentComponent.getType()).getName());

					ContractProperty contractProperty = getContractPropertyFromContract(dslTypeToComponent.get(dslParentComponent.getType()), refinedContract);

					// Alternative version using a library function
//					Property p = ContractEntityUtil.getInstance().getUmlContractPropertyOfUmlComponentFromContractPropertyType(dslTypeToComponent.get(dslParentComponent.getType()), refinedContract);
//					ContractProperty cp = ContractEntityUtil.getInstance().getContractProperty(p);

					// Create a ContractRefinement for each ContractId found
					final EList<ContractId> contractIds = refinement.getContractIds();					
					for (ContractId contractId : contractIds) {
						printMessageOnOut("\n\tContractID = " + contractId.getComponentName() +	"." + contractId.getName());	
						final DataType umlRefinement = createContractRefinement(dslTypeToComponent.get(dslParentComponent.getType()), contractId.getComponentName(), contractId.getName());
						addContractRefinementToContractProperty(contractProperty, umlRefinement);
					}
				} else if (dslRefInstance != null && dslRefInstance.getFormula() != null) {
					
					// CONSTRAINT processing
					//TODO: implement this
//					showMessage("Found a CONSTRAINT tag, don't know how to handle it!");
					System.err.println("Import Error: Found a CONSTRAINT tag, don't know how to handle it!");
				} else if (dslRefInstance != null && dslRefInstance.getProp() != null) {

					// PROP processing
					//TODO: implement this
//					showMessage("Found a PROP tag, don't know how to handle it!");
					System.err.println("Import Error: Found a PROP tag, don't know how to handle it!");
				}
			}
		}
	}
	
	/** 
	 * Gets the expression string from the Expression constraint
	 * @param constraint the expression to convert
	 */
	private String getConstraintText(Expression constraint) {
		final String text = serializer.serialize(constraint);

		return text.trim();
	}
	
	/** 
	 * Returns a name for the ContractProperty, deriving it from the Contract type
	 * @param contract the contract from which it derives
	 * @return a derived name, going lowercase
	 */
	private String getContractPropertyName(Class contract) {
		String contractName = contract.getName();
//		contractName = contractName.substring(contractName.indexOf('_') + 1);
		
		if (contractName.length() > 0) {
			return contractName.toLowerCase();
		} else {
			return ((Contract) contract).getName().toLowerCase();
		}
	}
	
	/** 
	 * Parses the Interfaces of the component
	 * @param dslParentComponent the AST Component owning the refinement
	 * @param dslComponentInterface the Interface element to be parsed
	 */
	private void parseInterfaces(AbstractComponent dslParentComponent, Interface dslComponentInterface) {

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
							createPort(dslTypeToComponent.get(dslParentComponent.getType()), dslVariableID, dslVariableType, true);
						} else if (dslVariable instanceof OutputPort) {
							createPort(dslTypeToComponent.get(dslParentComponent.getType()), dslVariableID, dslVariableType, false);
						}
						
					} else if (dslVariable instanceof Parameter) {
						
						// PARAMETER processing
						//TODO: implement this
//						showMessage("Found a PARAMETER tag, don't know how to handle it!");
						System.err.println("Import Error: Found a PARAMETER tag, don't know how to handle it!");
					} else if (dslVariable instanceof Operation) {
						
						// PROVIDED OPERATION processing
						//TODO: implement this
//						showMessage("Found a OPERATION tag, don't know how to handle it!");
						System.err.println("Import Error: Found a OPERATION tag, don't know how to handle it!");
					}
				} else if (dslIntInstance != null && dslIntInstance.getDefine() != null) {
				
					// DEFINE processing
					//TODO: implement this
//					showMessage("Found a DEFINE tag, don't know how to handle it!");
					System.err.println("Import Error: Found a DEFINE tag, don't know how to handle it!");
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
					String contractPropertyName = getContractPropertyName(contract);
					createContractProperty(dslTypeToComponent.get(dslParentComponent.getType()), contractPropertyName, (Type) contract);
				}
			}
		}
	}
	
	/** Navigates the component and processes its interfaces
	 * @param dslParentComponent the element in the tree
	 */
	private void parseComponentInterfaces(AbstractComponent dslParentComponent) {

		printMessageOnOut("\n\n\nParsing Interfaces for  " + dslParentComponent.getType() + "\n");
		
		// Get the Interfaces, if any
		final Interface dslComponentInterface = dslParentComponent.getInterface();
		if (dslComponentInterface != null) {
			parseInterfaces(dslParentComponent, dslComponentInterface);
		}
	}

	/** Navigates the component and processes its refinements
	 * @param dslParentComponent the element in the tree
	 */
	private void parseComponentRefinements(AbstractComponent dslParentComponent) {

		printMessageOnOut("\n\n\nParsing Refinements for " + dslParentComponent.getType() + "\n");

		// Get the Refinement, if any
		final Refinement dslComponentRefinement = dslParentComponent.getRefinement();
		if (dslComponentRefinement != null) {
			parseRefinements(dslParentComponent, dslComponentRefinement);
		}
	}
	
	/**
	 * Main method to be invoked to parse an OSS file
	 * @throws Exception
	 */
	public void startParsing(Package pkg, File ossFile) throws Exception {
		
		OSS ocraOssFile;
//		File ossFile;
		
		sysView = pkg;	// Set the given package as working package

//		ossFile = new File("/hardmnt/nemesis0/home/cristofo/Downloads/System.oss");
//		ossFile = getOSSFile();
		if (ossFile != null) {
			ocraOssFile = getOssModel(ossFile);
		} else {
			return;
		}
		
		// Retrieve the SystemComponent
		SystemComponent dslSystemComponent = ocraOssFile.getSystem();
		
		if (dslSystemComponent == null) {
			System.err.println("Import Error: System component is missing");
			showMessage("System component is missing");
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
						
		// If the OCRA system component type is not defined, set it to 'System'
		final String dslSystemComponentName = dslSystemComponent.getType() == null ? "System" : dslSystemComponent.getType();
		dslSystemComponent.setType(dslSystemComponentName);

		printMessageOnOut("dslSystemComponent.type = " + dslSystemComponentName);

		// Start a transaction to modify the package content 
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(pkg);
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {


				// Add the systemComponent to the package
				Class systemComponent = createSystemBlock(sysView, dslSystemComponent.getType());
				//		Class systemComponent = createSystemBlock(sysView, dslSystemComponent.getType() + SUFFIX);

				// Store the systemComponent in a hash with its name
				dslTypeToComponent.put(dslSystemComponentName, systemComponent);

				// Populate the map and the package with the other Component elements 
				for (Component dslComponent : ocraOssFile.getComponents()) {
					Class component = createBlock(sysView, dslComponent.getType());
					//			Class component = createBlock(sysView, dslComponent.getType() + SUFFIX);
					if(dslTypeToComponent.put(dslComponent.getType(), component) != null) {
						printMessageOnOut("Duplicated component type, not added: " + dslComponent.getType());
					} else {
						printMessageOnOut("component.type = " + dslComponent.getType());
					}
				}

				// Now I have created all the Blocks in the package, loop on them, but not getting them from 
				// the package (it may be polluted with other blocks), but from the OSS model again.

				// parse the system component
				parseComponentInterfaces(dslSystemComponent);

				// Parse all the other components 
				for (Component dslComponent : ocraOssFile.getComponents()) {
					parseComponentInterfaces(dslComponent);
				}

				// parse the system component
				parseComponentRefinements(dslSystemComponent);

				// Parse all the other components 
				for (Component dslComponent : ocraOssFile.getComponents()) {
					parseComponentRefinements(dslComponent);
				}
			}
		});
	}
}
