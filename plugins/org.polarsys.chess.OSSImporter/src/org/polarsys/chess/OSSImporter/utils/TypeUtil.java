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
package org.polarsys.chess.OSSImporter.utils;

import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.BoundedSubtype;
import org.eclipse.papyrus.uml.tools.utils.UMLUtil;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;

import eu.fbk.tools.editor.basetype.baseType.EnumType;
import eu.fbk.tools.editor.basetype.baseType.Identifier;
import eu.fbk.tools.editor.basetype.baseType.IntegerLiteral;
import eu.fbk.tools.editor.basetype.baseType.RangeType;

/**
 * A class with some util methods to handle types, stereotypes and constants.
 * @author cristofo
 *
 */
public class TypeUtil {

	// The instance of this class
	private static TypeUtil classInstance;
	
//	private static final String INTEGER_TYPE =			"PrimitiveTypes::Integer";
//	private static final String REAL_TYPE =				"PrimitiveTypes::Real";	
//	private static final String BOOLEAN_TYPE =			"PrimitiveTypes::Boolean";
	
	public static final String CONTRACT =				"CHESSContract::Contract";
	public static final String CONTRACT_PROP =			"CHESSContract::ContractProperty";
	public static final String DELEGATION_CONST =		"CHESSContract::DelegationConstraint";
	public static final String CONTRACT_REFINEMENT =	"CHESSContract::ContractRefinement";
	public static final String SYSTEM =					"CHESSContract::System";
//	private static final String SUBSYSTEM = 			"CHESSContract::SubSystem";
//	private static final String COMPINST =				"CHESSContract::ComponentInstance";
//	private static final String FORMAL_PROP =			"CHESSContract::FormalProperty";
//	private static final String CHESS_CONTINUOUS_TYPE = "CHESSContract::DataTypes::Continuous";

//	private static final String SYSVIEW =				"CHESS::Core::CHESSViews::SystemView";
//	private static final String COMPVIEW =				"CHESS::Core::CHESSViews::ComponentView";
//	private static final String CHESS =					"CHESS::Core::CHESS";
	
	public static final String BLOCK =					"SysML::Blocks::Block";
	public static final String FLOWPORT =				"SysML::PortAndFlows::FlowPort";
	
	public static final String BOUNDED_TYPE = 			"MARTE::MARTE_Annexes::VSL::DataTypes::BoundedSubtype";
//	public static final String COLLECTIONTYPE = 		"MARTE::MARTE_Annexes::VSL::DataTypes::CollectionType";
//	private static final String MARTE_BOOLEAN_TYPE = 	"MARTE_Library::MARTE_PrimitivesTypes::Boolean";
//	private static final String MARTE_REAL_TYPE = 		"MARTE_Library::MARTE_PrimitivesTypes::Real";
//	private static final String MARTE_INTEGER_TYPE = 	"MARTE_Library::MARTE_PrimitivesTypes::Integer";
	
	private static final String ENUMERATION_NAME = 		"Enumeration";
	private static final String SIGNAL_NAME = 			"Signal";
	
	// Library for UML primitive types
	private final Model umlLibrary = (Model) load(URI.createURI(UMLResource.UML_PRIMITIVE_TYPES_LIBRARY_URI));

	// Library for CHESS types like continuous
	private final Profile chessContractLibrary = (Profile) load(URI.createURI("pathmap://CHESSContract/CHESSContract.profile.uml"));

	// Logger for messages
	private static final Logger logger = Logger.getLogger(TypeUtil.class);

	// Stereotype objects needed to customize the elements
	public Stereotype contractPropertyStereotype;
	public Stereotype delegationConstraintStereotype;
	public Stereotype contractRefinementStereotype;
	public Stereotype flowPortStereotype;
	public Stereotype contractStereotype;
	public Stereotype boundedTypeStereotype;
	public Stereotype blockStereotype;
	public Stereotype systemStereotype;

	/**
	 * Gets an instance of the class if already present, or a new one if not.
	 * @return the instance of this class
	 */
	public static TypeUtil getInstance() {
		if (classInstance == null) {
			classInstance = new TypeUtil();
		}
		return classInstance;
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
	 * Collects the needed stereotypes from the given package.
	 * @param pkg the package in which to look for the stereotypes
	 */
	public void refreshStereotypes(Package pkg) {
		
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
	 * Returns the primitive type from the standard primitive library.
	 * @param name the name of the Type
	 * @return the requested primitive type
	 */
	public Type getPrimitiveType(String name) {
		
		// Get the correct type from the library
		final Type type = umlLibrary.getOwnedType(name);
		
		if (type != null) {
			logger.debug("Type '" + type.getQualifiedName() + "' found.");
			logger.debug("Type object'" + type + "' found.");
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
	public Type getContinuousType(String name) {
		
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
		final Type dataType = pkg.createOwnedType(typeName, UMLPackage.Literals.DATA_TYPE);
//		Stereotype stereotype = UMLUtils.applyStereotype(dataType, BOUNDED_TYPE);
		dataType.applyStereotype(boundedTypeStereotype);

		// Extract the stereotiped type and configure it
//		BoundedSubtype boundedType = (BoundedSubtype) dataType.getStereotypeApplication(stereotype);
		final BoundedSubtype boundedType = (BoundedSubtype) dataType.getStereotypeApplication(boundedTypeStereotype);
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
	 * @param pkg the package in which the type should be created
	 * @return the requested type
	 */
	public Type getBoundedSubType(RangeType rangeType, Package pkg) {	
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

	/**
	 * Creates a Signal type in the given package.
	 * @param pkg the package where to create the Enumeration 
	 * @return the newly created type 
	 */
	private Signal createSignalType(Package pkg) {
		final String signalName = SIGNAL_NAME;
				
		final Type type = pkg.createOwnedType(signalName, UMLPackage.Literals.SIGNAL);
		
		logger.debug("Type '" + type.getQualifiedName() + "' created.");
		return (Signal) type;
	}
	
	/**
	 * Returns a Signal as requested (Only a Signal can be defined in the package).
	 * @param pkg the package where to look for or create the new type
	 * @return the requested type
	 */
	public Type getSignalType(Package pkg) {
		
		// Look for existing Signal Type in the package
		final Type type = getExistingSignalType(pkg);
		
		if (type != null) {
			
			// The type has been found in the package, use it
			logger.debug("Type '" + type.getQualifiedName() + "' found.");
			return type;
		} else {
			return createSignalType(pkg);
		}
	}
	
	/**
	 * Retrieves all the Enumerations owned by the package.
	 * @param pkg the package to be searched
	 * @return 
	 */
	private EList<Enumeration> getEnumerations(Package pkg) {
		final EList<Enumeration> enumerations = new BasicEList<Enumeration>();
				
		final EList<Type> types = pkg.getOwnedTypes();
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
		final Set<String> enumValuesNames = new TreeSet<String>();	// Ordered list of values
//		Set<String> enumValuesNames = new HashSet<String>();	// Original order of values

		for(EnumerationLiteral enumLit : enumeration.getOwnedLiterals()) {
			enumValuesNames.add(enumLit.getName());
		}
		return enumValuesNames;
	}
	
	/**
	 * Returns the list of the values inside a given EnumType.
	 * @param enumType the EnumType to be analyzed
	 * @return the list of contained values
	 */
	private Set<String> getListValuesForEnumType(EnumType enumType) {
		final Set<String> enumValuesNames = new TreeSet<String>();	// Ordered set
		
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
		final EList<Enumeration> enumerations = getEnumerations(pkg);
		
		if (enumerations.size() > 0) {
			final Set<String> enumValues = getListValuesForEnumType(enumType);

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

		final Enumeration enumeration = pkg.createOwnedEnumeration(enumerationName);
		final Set<String> values = getListValuesForEnumType(enumType);
		for (String string : values) {
			enumeration.createOwnedLiteral(string);
		}				

		logger.debug("Type '" + enumeration.getQualifiedName() + "' created.");
		return enumeration;
	}
	
	/**
	 * Returns an Enumeration as requested.
	 * @param enumType the type containing the specifications
	 * @param pkg the package where to look for or create the new type
	 * @return the requested type
	 */
	public Type getEnumerationType(EnumType enumType, Package pkg) {

		// Look for existing Enumerations in the package
		final Type type = getExistingEnumerationForEnumType(pkg, enumType);
		
		if (type != null) {

			// The type has been found in the package, use it
			logger.debug("Type '" + type.getQualifiedName() + "' found.");
			return type;
		} else {
			return createEnumerationFromEnumType(pkg, enumType);
		}
	}
}
