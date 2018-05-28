package org.polarsys.chess.OSSImporter.utils;

import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.BoundedSubtype;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;

public class TypeUtil {

	// Logger for messages
	private static final Logger logger = Logger.getLogger(TypeUtil.class);

	// Library for UML primitive types
	private final Model umlLibrary = (Model) load(URI.createURI(UMLResource.UML_PRIMITIVE_TYPES_LIBRARY_URI));

	// Library for CHESS types like continuous
	private final Profile chessContractLibrary = (Profile) load(
			URI.createURI("pathmap://CHESSContract/CHESSContract.profile.uml"));

	private StereotypeUtil stereotypeUtil = StereotypeUtil.getInstance();

	private static TypeUtil typeUtil = TypeUtil.getInstance();

	public static TypeUtil getInstance() {
		if (typeUtil == null) {
			typeUtil = new TypeUtil();
		}
		return typeUtil;
	}

	/**
	 * Loads a package from the given resource.
	 * 
	 * @param uri
	 *            the URI of the resource to load
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
	 * 
	 * @param name
	 *            the name of the Type
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

	// /**
	// * Returns the primitive type from another UML library.
	// * @param name the name of the Type
	// * @return the requested primitive type
	// */
	// private Type getUMLPrimitiveType(String name) {
	//
	// // Get the correct model
	// final Model umlLibrary = (Model)
	// load(URI.createURI("pathmap://UML_LIBRARIES/UMLPrimitiveTypes.library.uml"));
	//
	// // Get the correct type
	// final Type type = umlLibrary.getOwnedType(name);
	//
	// if (type != null) {
	// logger.debug("Type '" + type.getQualifiedName() + "' found.");
	// return type;
	// }
	// return null;
	// }

	/**
	 * Returns the Type Continuous.
	 * 
	 * @param name
	 *            the name of the Type
	 * @return the requested Type
	 */
	public Type getContinuousType(String name) {

		// The Continuous type is defined here:
		// CHESSContract::DataTypes::Continuous
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
	 * Looks for a Signal already defined in the package.
	 * 
	 * @param pkg
	 *            the package in which look for the Signal
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
	 * Looks for a specific enumeration among existing enumerations of the given
	 * package.
	 * 
	 * @param pkg
	 *            the package in which look for the Enumeration
	 * @param enumType
	 *            the enumeration to match
	 * @return the enumeration already defined
	 */
	private Enumeration getExistingEnumerationForEnumType(Package pkg, Set<String> enumValues) {
		final EList<Enumeration> enumerations = getEnumerations(pkg);

		if (enumerations.size() > 0) {

			for (Enumeration enumeration : enumerations) {
				if (enumValues.equals(getListValuesForEnumeration(enumeration))) {
					return enumeration;
				}
			}
		}
		return null;
	}

	/**
	 * Returns the list of the values inside a given Enumeration.
	 * 
	 * @param enumeration
	 *            the Enumeration to be analysed
	 * @return the list of contained values
	 */
	private Set<String> getListValuesForEnumeration(Enumeration enumeration) {
		final Set<String> enumValuesNames = new TreeSet<String>(); // Ordered
																	// list of
																	// values
		// Set<String> enumValuesNames = new HashSet<String>(); // Original
		// order of values

		for (EnumerationLiteral enumLit : enumeration.getOwnedLiterals()) {
			enumValuesNames.add(enumLit.getName());
		}
		return enumValuesNames;
	}

	/**
	 * Creates a new Enumeration as requested.
	 * 
	 * @param pkg
	 *            the package where to create the Enumeration
	 * @param enumType
	 *            the type specifying the values
	 * @return the created Enumeration
	 */
	private Enumeration createEnumerationFromEnumType(Package pkg, Set<String> enumValues) {

		// Create the name using an incremental value
		final String enumerationName = StereotypeUtil.ENUMERATION_NAME + (getEnumerations(pkg).size() + 1);

		final Enumeration enumeration = pkg.createOwnedEnumeration(enumerationName);
		// final Set<String> values = getListValuesForEnumType(enumType);
		for (String string : enumValues) {
			enumeration.createOwnedLiteral(string);
		}

		logger.debug("Type '" + enumeration.getQualifiedName() + "' created.");
		return enumeration;
	}

	/**
	 * Creates a Signal type in the given package.
	 * 
	 * @param pkg
	 *            the package where to create the Enumeration
	 * @return the newly created type
	 */
	private Signal createSignalType(Package pkg) {
		final String signalName = StereotypeUtil.SIGNAL_NAME;

		final Type type = pkg.createOwnedType(signalName, UMLPackage.Literals.SIGNAL);

		logger.debug("Type '" + type.getQualifiedName() + "' created.");
		return (Signal) type;
	}

	/**
	 * Returns a Signal as requested (Only a Signal can be defined in the
	 * package).
	 * 
	 * @param pkg
	 *            the package where to look for or create the new type
	 * @return the requested type
	 */
	public Type getOrCreateSignalType(Package pkg) {

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

	public Type getOrCreateEnumerationType(Set<String> enumValues, Package pkg) {

		// Look for existing Enumerations in the package
		final Type type = getExistingEnumerationForEnumType(pkg, enumValues);

		if (type != null) {

			// The type has been found in the package, use it
			logger.debug("Type '" + type.getQualifiedName() + "' found.");
			return type;
		} else {
			return createEnumerationFromEnumType(pkg, enumValues);
		}
	}

	public Type getOrCreateBoundedSubType(String typeName, Package pkg, int lowerBound, int upperBound) {
		// Look for that type in the ComponentView
		Type type = pkg.getOwnedType(typeName);
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
	 * 
	 * @param pkg
	 *            the package to be searched
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
	 * Creates a new BoundedSubType as requested.
	 * 
	 * @param pkg
	 *            the package where to create the Enumeration
	 * @param typeName
	 *            the name of the type
	 * @param lowerBound
	 *            the lower bound
	 * @param upperBound
	 *            the upper bound
	 * @return the created type
	 */
	private Type createBoundedSubType(Package pkg, String typeName, int lowerBound, int upperBound) {

		// Create a data type to the component view and apply the stereotype
		final Type dataType = pkg.createOwnedType(typeName, UMLPackage.Literals.DATA_TYPE);
		// Stereotype stereotype = UMLUtils.applyStereotype(dataType,
		// BOUNDED_TYPE);
		dataType.applyStereotype(stereotypeUtil.boundedTypeStereotype);

		// Extract the stereotiped type and configure it
		// BoundedSubtype boundedType = (BoundedSubtype)
		// dataType.getStereotypeApplication(stereotype);
		final BoundedSubtype boundedType = (BoundedSubtype) dataType
				.getStereotypeApplication(stereotypeUtil.boundedTypeStereotype);
		boundedType.setMinValue(String.valueOf(lowerBound));
		boundedType.setMaxValue(String.valueOf(upperBound));
		boundedType.setBaseType((DataType) getPrimitiveType("Integer"));
		// boundedType.setBaseType((DataType) getUMLPrimitiveType("Integer"));
		// // Alternative version

		logger.debug("Type '" + dataType.getQualifiedName() + "' created.");
		return dataType;
	}

}
