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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.apache.log4j.Logger;
import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
//import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.BoundedSubtype;
import org.eclipse.papyrus.sysml.portandflows.FlowDirection;
import org.eclipse.papyrus.sysml.portandflows.FlowPort;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.service.types.utils.ElementUtil;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.papyrus.uml.tools.model.UmlUtils;
import org.eclipse.papyrus.uml.tools.utils.OpaqueExpressionUtil;
import org.eclipse.papyrus.uml.tools.utils.UMLUtil;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerPage;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerPageBookView;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerView;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchCommandConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.FunctionBehavior;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.LiteralUnlimitedNatural;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.PseudostateKind;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
//import org.polarsys.chess.contracts.profile.chesscontract.util.ContractEntityUtil;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.Vertex;
import org.eclipse.uml2.uml.VisibilityKind;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.polarsys.chess.contracts.profile.chesscontract.FormalProperty;
import org.polarsys.chess.core.util.uml.ResourceUtils;
import org.polarsys.chess.core.util.uml.UMLUtils;

/**
 * Util class that provides methods to manage SysML/CHESS/MARTE objects.
 *
 */
public class EntityUtil {

	private static final Logger logger = Logger.getLogger(EntityUtil.class);

	public static final String BLOCK = "SysML::Blocks::Block";
	public static final String SYSTEM = "CHESSContract::System";
	public static final String FLOW_Port = "SysML::PortAndFlows::FlowPort";
	private static final String FLOW_Port_MARTE = "MARTE::MARTE_DesignModel::GCM::FlowPort";
	public static final String BOUNDED_TYPE = "MARTE::MARTE_Annexes::VSL::DataTypes::BoundedSubtype";
	private static final String COMP_TYPE = "CHESS::ComponentModel::ComponentType";
	private static final String COMP_IMPL = "CHESS::ComponentModel::ComponentImplementation";
	private static final String SYSVIEW = "CHESS::Core::CHESSViews::SystemView";

	private static final String INTEGER_TYPE = "PrimitiveTypes::Integer";
	private static final String STRING_TYPE = "PrimitiveTypes::String";
	private static final String REAL_TYPE = "PrimitiveTypes::Real";
	private static final String BOOLEAN_TYPE = "PrimitiveTypes::Boolean";

	private static final String CHESS_CONTINUOUS_TYPE = "CHESSContract::DataTypes::Continuous";

	private static final String MARTE_BOOLEAN_TYPE = "MARTE_Library::MARTE_PrimitivesTypes::Boolean";
	private static final String MARTE_REAL_TYPE = "MARTE_Library::MARTE_PrimitivesTypes::Real";
	private static final String MARTE_INTEGER_TYPE = "MARTE_Library::MARTE_PrimitivesTypes::Integer";
	private static final String FORMAL_PROP = "CHESSContract::FormalProperty";
	private static final String FAULTY_STATE_MACHINE = "CHESS::Dependability::ThreatsPropagation::ErrorModel";
	public static final String DELEGATION_CONST = "CHESSContract::DelegationConstraint";

	// default names of created objects
	private static final String DEFAULT_DELEGATION_PREFIX = "Define_";
	private static final String DEFAULT_PAR_ASSUMPTION_PREFIX = "ParamAssumption_";
	private static final String DEFAULT_ASSOCIATION_NAME = "association";
	private static final String DEFAULT_ENUMERATION_NAME = "Enumeration";
	private static final String DEFAULT_SIGNAL_NAME = "Signal";
	private static final String DEFAULT_CONNECTOR_NAME = "connector";
	private static final String DEFAULT_DELEGATION_CONSTRAINT_LITERAL_STRING_NAME = "constraintSpec";
	private static final String DEFAULT_PAR_ASSUMPTION_LITERAL_STRING_NAME = "constraintSpec";
	private static final String DEFAULT_PARAMETER_IN_NAME = "parameterIn";
	private static final String DEFAULT_PARAMETER_OUT_NAME = "parameterOut";
	private static final String DEFAULT_BOUNDEDTYPE_NAME = "BoundedInteger_";

	// Library for UML primitive types
	private Model umlLibrary = null;
	// Library for CHESS types like continuous
	private Profile chessContractLibrary = null;

	private static EntityUtil entityUtilInstance;

	public static EntityUtil getInstance() {
		if (entityUtilInstance == null) {
			entityUtilInstance = new EntityUtil();
		}
		return entityUtilInstance;
	}

	public Model loadModel(String projectName, String fileName) {
		IWorkspaceRoot wRoot = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wRoot.getProject(projectName);
		IFile file = proj.getFile(fileName);
		IPath loc = file.getLocation();
		ResourceSet resSet = new ResourceSetImpl();
		Resource resource = resSet.getResource(URI.createFileURI(loc.toString()), true);
		Model model = ResourceUtils.getModel(resource);
		return model;
	}

	/**
	 * Loads a package from the given resource.
	 * 
	 * @param uri
	 *            the URI of the resource to load
	 * @return the retrieved package
	 */
	public Package loadPackage(URI uri) {
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
	 * Returns the Type Continuous.
	 * 
	 * @return the requested Type
	 */
	public Type getContinuousType() {

		if (chessContractLibrary == null) {
			chessContractLibrary = (Profile) loadPackage(
					URI.createURI("pathmap://CHESSContract/CHESSContract.profile.uml"));
		}

		// The Continuous type is defined here:
		// CHESSContract::DataTypes::Continuous
		// Get the correct package inside the profile
		final Package dataTypes = chessContractLibrary.getNestedPackage("DataTypes");

		// Get the correct type
		final Type type = dataTypes.getOwnedType("Continuous");

		if (type != null) {
			logger.debug("Type '" + type.getQualifiedName() + "' found.");
			return type;
		}
		return null;
	}

	/**
	 * Returns the primitive type from the standard primitive library.
	 * 
	 * @param name
	 *            the name of the Type
	 * @return the requested primitive type
	 */
	public Type getPrimitiveType(String name) {

		if (umlLibrary == null) {
			umlLibrary = (Model) loadPackage(URI.createURI(UMLResource.UML_PRIMITIVE_TYPES_LIBRARY_URI));
		}

		// Get the correct type from the library
		final Type type = umlLibrary.getOwnedType(name);

		if (type != null) {
			logger.debug("Type '" + type.getQualifiedName() + "' found.");
			logger.debug("Type object'" + type + "' found.");
			return type;
		}
		return null;
	}

	/**
	 * Returns the delegation constraint with the given specs from a list
	 * 
	 * @param delegationConstraints
	 *            the list of delegation constraints to scan
	 * @param variable
	 *            variable part
	 * @param constraint
	 *            costraint part
	 * @return the delegation constraint, if found
	 */
	public Constraint getExistingDelegationConstraint(EList<Constraint> delegationConstraints, String variableIdText,
			String constraintText, String iterConditionText) {

		// Text of the delegation constraint
		final String formalPropertyText = createDelegationConstraintText(variableIdText, constraintText,
				iterConditionText);

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
	 * Return the Parameter with the given speccs if present among a list of
	 * Parameters
	 * 
	 * @param parameters
	 *            the list of Parameters to scan
	 * @param type
	 *            the type of the Parameter
	 * @param isInput
	 *            the direction of the Parameter
	 * @return the Parameter, if found
	 */
	public Parameter getExistingFunctionBehaviorParameter(EList<Parameter> parameters, Type functionBehaviourType,
			boolean isInput) {
		for (Parameter parameter : parameters) {
			if (parameter.getType() == functionBehaviourType) {
				if ((isInput && parameter.getDirection() == ParameterDirectionKind.IN_LITERAL)
						|| (!isInput && parameter.getDirection() == ParameterDirectionKind.OUT_LITERAL)) {
					return parameter;
				}
			}
		}
		return null;
	}

	/**
	 * Returns the list of contract refinements associated to a Class
	 * 
	 * @param owner
	 *            the owner Class
	 * @return the list of contract refinements
	 */
	public EList<DataType> getDataTypes(Class owner) {
		EList<DataType> contractRefinements = new BasicEList<DataType>();

		for (Classifier classifier : owner.getNestedClassifiers()) {
			if (classifier instanceof DataType) {
				contractRefinements.add((DataType) classifier);
			}
		}
		return contractRefinements;
	}

	public org.eclipse.uml2.uml.Port getExistingUmlPort(String portName, EList<NamedElement> existingPorts) {
		for (Object object : existingPorts) {
			final org.eclipse.uml2.uml.Port tmpPort = (org.eclipse.uml2.uml.Port) object;
			if (tmpPort.getName().equals(portName)) {
				return (org.eclipse.uml2.uml.Port) tmpPort;
			}
		}
		return null;
	}

	public org.eclipse.uml2.uml.Port getExistingUmlPort(String portName, String typeName,
			EList<NamedElement> existingPorts) {
		for (Object object : existingPorts) {
			final org.eclipse.uml2.uml.Port tmpPort = (org.eclipse.uml2.uml.Port) object;
			if (tmpPort.getName().equals(portName) && tmpPort.getType().getName().equals(typeName)) {
				return tmpPort;
				// Port found
			}
		}
		return null;
	}

	public Stereotype findStereotype(Package pkg, String stereotypeName) {

		for (Stereotype sub : UMLUtil.findSubstereotypes(pkg, stereotypeName)) {
			if (sub.getQualifiedName().equals(stereotypeName)) {
				return sub;
			}
		}
		return null;
	}

	public void updateUmlStaticPort(org.eclipse.uml2.uml.Port port, String[] newMultiplicityRange) {
		final String[] multiplicityRange = getAttributeMultiplicity(port);

		// Update its multiplicity if needed
		if (!equalMultiplicityBoundaries(newMultiplicityRange, multiplicityRange)) {
			setAttributeMultiplicity(port, newMultiplicityRange);
		}
	}

	public void updateUmlNonStaticPort(Port port, Type newType, String[] newMultiplicityRange) {
		if (!port.getType().getName().equals(newType.getName())) {
			port.setType(newType);
		}

		// Update its multiplicity if needed
		final String[] multiplicityRange = getAttributeMultiplicity(port);
		if (!equalMultiplicityBoundaries(newMultiplicityRange, multiplicityRange)) {
			setAttributeMultiplicity(port, newMultiplicityRange);
		}

	}

	public FunctionBehavior createUmlFunctionBehaviour(String functionBehaviourName, Type outputParameterType,
			EList<Type> inputParametersTypes, Class owner) {

		// Create an empty functionBehavior
		FunctionBehavior functionBehavior = createFunctionBehavior(owner, functionBehaviourName);

		createUmlFunctionBehaviorParameters(functionBehavior, inputParametersTypes, outputParameterType);

		return functionBehavior;

	}

	public void createUmlFunctionBehaviorParameters(FunctionBehavior functionBehavior, EList<Type> inputParameterstypes,
			Type outputParameterType) {
		// Create the input parameters
		for (Type parameterType : inputParameterstypes) {
			createFunctionBehaviorParameter(functionBehavior, parameterType, true);
		}

		// Create the output parameter
		createFunctionBehaviorParameter(functionBehavior, outputParameterType, false);
	}

	public Constraint createDelegationConstraint(Class owner, String variableIdText, String constraintText,
			String iterConditionText, Stereotype delegationConstraintStereotype) {

		String delegationName = DEFAULT_DELEGATION_PREFIX + variableIdText;

		logger.debug("\n\n\n Creating delegation constraint " + delegationName + " for owner " + owner);
		logger.debug("\n\n\n");

		final Constraint newUMLConstraint = owner.createOwnedRule(delegationName.toString());
		newUMLConstraint.applyStereotype(delegationConstraintStereotype);

		final LiteralString literalString = UMLFactory.eINSTANCE.createLiteralString();
		literalString.setName(DEFAULT_DELEGATION_CONSTRAINT_LITERAL_STRING_NAME);

		final String formalPropertyText = createDelegationConstraintText(variableIdText, constraintText,
				iterConditionText);
		literalString.setValue(formalPropertyText);
		newUMLConstraint.setSpecification(literalString);

		logger.debug("\n\nCreated " + delegationName + " Delegation Constraint\n\n");
		return newUMLConstraint;
	}

	public Connector createUmlConnector(String constraintName, Property partWithPortOfConstraint,
			Class portOwnerOfConstraint, String variableName, Property partWithPortOfVariable,
			Class portOwnerOfVariable, Class owner) {
		// Create the source end

		// Create the name using an incremental value
		final String connectorName = DEFAULT_CONNECTOR_NAME + (owner.getOwnedConnectors().size() + 1);
		// Create a connector, but only after I'm sure it isn't
		// a delegation constraint

		logger.debug("\n\n\n Creating connector " + connectorName + " for owner " + owner);
		logger.debug("\n\n\n");
		Connector connector = createConnector(connectorName);
		logger.debug("Creating source end :" + constraintName);
		createUmlConnectorEnd(connector, constraintName, partWithPortOfConstraint, portOwnerOfConstraint);

		// Create the target end
		logger.debug("Creating source end :" + variableName);
		createUmlConnectorEnd(connector, variableName, partWithPortOfVariable, portOwnerOfVariable);

		// At last, add the connector to the owner
		entityUtilInstance.addConnector(owner, connector);

		return connector;

	}

	/**
	 * Creates a Block element in the given package.
	 * 
	 * @param owner
	 *            the Package that will contain the element
	 * @param elementName
	 *            the name of the new Block
	 * @return the newly created Class
	 */
	public Class createBlock(Package owner, final String elementName, Stereotype blockStereotype) {

		Class umlClass = owner.createOwnedClass(elementName, false);
		umlClass.applyStereotype(blockStereotype);

		// owner.createPackagedElement(elementName, newUMLClass.eClass()); This
		// also works...
		// owner.getPackagedElements().add(newUMLClass); // This works too!

		logger.debug("\n\nCreated " + elementName + " Block\n\n");
		return umlClass; // Return the first occurence
	}

	public Class createSystemBlock(Package owner, final String elementName, Stereotype blockStereotype,
			Stereotype sytemblockStereotype) {
		Class umlClass = createBlock(owner, elementName, blockStereotype);
		umlClass.applyStereotype(sytemblockStereotype);
		return umlClass;
	}

	private ConnectorEnd createUmlConnectorEnd(Connector connector, String sourcePort, Property partWithPort,
			Class portOwner) {

		// Get the port and set it
		ConnectableElement role = portOwner.getOwnedPort(sourcePort, null);

		if (role != null) {
			return entityUtilInstance.createConnectorEnd(connector, partWithPort, role);
		}
		return null;
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
	public Type createBoundedSubType(Package pkg, String typeName, int lowerBound, int upperBound,
			Stereotype boundedTypeStereotype) {

		// Create a data type to the component view and apply the stereotype
		final Type dataType = pkg.createOwnedType(typeName, UMLPackage.Literals.DATA_TYPE);
		// Stereotype stereotype = UMLUtils.applyStereotype(dataType,
		// BOUNDED_TYPE);
		dataType.applyStereotype(boundedTypeStereotype);

		// Extract the stereotiped type and configure it
		// BoundedSubtype boundedType = (BoundedSubtype)
		// dataType.getStereotypeApplication(stereotype);
		final BoundedSubtype boundedType = (BoundedSubtype) dataType.getStereotypeApplication(boundedTypeStereotype);
		boundedType.setMinValue(String.valueOf(lowerBound));
		boundedType.setMaxValue(String.valueOf(upperBound));
		boundedType.setBaseType((DataType) getPrimitiveType("Integer"));
		// boundedType.setBaseType((DataType) getUMLPrimitiveType("Integer"));
		// // Alternative version

		logger.debug("Type '" + dataType.getQualifiedName() + "' created.");
		return dataType;
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
	public Enumeration createEnumerationFromEnumType(Package pkg, Set<String> enumValues) {

		// Create the name using an incremental value
		final String enumerationName = DEFAULT_ENUMERATION_NAME + (getEnumerations(pkg).size() + 1);

		final Enumeration enumeration = pkg.createOwnedEnumeration(enumerationName);
		// final Set<String> values = getListValuesForEnumType(enumType);
		for (String string : enumValues) {
			enumeration.createOwnedLiteral(string);
		}

		logger.debug("Type '" + enumeration.getQualifiedName() + "' created.");
		return enumeration;
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
	 * Creates a Signal type in the given package.
	 * 
	 * @param pkg
	 *            the package where to create the Enumeration
	 * @return the newly created type
	 */
	public Signal createSignalType(Package pkg) {
		final String signalName = DEFAULT_SIGNAL_NAME;

		final Type type = pkg.createOwnedType(signalName, UMLPackage.Literals.SIGNAL);

		logger.debug("Type '" + type.getQualifiedName() + "' created.");
		return (Signal) type;
	}

	/**
	 * Looks for a Signal already defined in the package.
	 * 
	 * @param pkg
	 *            the package in which look for the Signal
	 * @return the Signal already defined
	 */
	public Signal getExistingSignalType(Package pkg) {
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
	public Enumeration getExistingEnumerationForEnumType(Package pkg, Set<String> enumValues) {
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

	public Type getOrCreateBoundedSubType(Integer[] boundaries, Package pkg, Stereotype boundedTypeStereotype) {

		int lowerBound = boundaries[0];
		int upperBound = boundaries[1];
		// Generate a suitable type name
		final String typeName = DEFAULT_BOUNDEDTYPE_NAME + lowerBound + "_" + upperBound;

		return getOrCreateBoundedSubType(typeName, pkg, lowerBound, upperBound, boundedTypeStereotype);
	}

	public Type getOrCreateBoundedSubType(String typeName, Package pkg, int lowerBound, int upperBound,
			Stereotype boundedTypeStereotype) {
		// Look for that type in the ComponentView
		Type type = pkg.getOwnedType(typeName);
		if (type != null) {

			// The type has been found in the package, use it
			logger.debug("Type '" + type.getQualifiedName() + "' found.");
			return type;
		} else {
			return (Type) createBoundedSubType(pkg, typeName, lowerBound, upperBound, boundedTypeStereotype);
		}
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

	public String getFormalPropertyStr(FormalProperty formalProperty) {

		String str = null;
		if (formalProperty != null) {
			str = getConstraintBodyStr(formalProperty.getBase_Constraint());
		}
		return str;
	}

	public void updateUmlAssociation(Property componentInstance, Type type, String[] ossSubComponentMultiplicity)
			throws Exception {
		// The component instance is already present, update its
		// type if needed
		if (!componentInstance.getType().equals(type)) {
			componentInstance.setType(type);

			// Add the association to the list of changes, it
			// needs to be redrawn
			// addedElements.add(componentInstance.getAssociation());
		}

		String[] componentInstanceMultiplicity = getComponentInstanceMultiplicity(componentInstance);

		if (!equalMultiplicityBoundaries(componentInstanceMultiplicity, ossSubComponentMultiplicity)) {
			setAttributeMultiplicity(componentInstance, ossSubComponentMultiplicity);
		}

	}

	public void updateUmlConstraint(Constraint umlConstraint, String updatedText) {
		final String formalPropertyText = getConstraintBodyStr(umlConstraint);

		// If the expression is different, save it,
		// otherwise go on
		if (!updatedText.equals(formalPropertyText)) {
			setTextInUMLConstraint(umlConstraint, updatedText);
		}
	}

	public String getConstraintBodyStr(Constraint formalProperty) {

		String str = null;
		if (formalProperty != null) {
			if (formalProperty.getSpecification() != null) {
				if (formalProperty.getSpecification() instanceof LiteralString) {
					str = formalProperty.getSpecification().stringValue();
				} else if (formalProperty.getSpecification() instanceof OpaqueExpression) {
					str = OpaqueExpressionUtil.getBodyForLanguage((OpaqueExpression) formalProperty.getSpecification(),
							"OCRA");
				}

			}
		}
		// logger.debug("getFormalPropertyStr: "+str);

		return str;
	}

	/**
	 * Returns the component instance with the given name.
	 * 
	 * @param owner
	 *            the class owning the instance
	 * @param componentName
	 *            the name of the instance
	 * @return the UML property representing the component instance
	 */
	public Property getSubComponentInstance(Class owner, String componentName) {
		logger.debug("getSubComponentInstance");
		for (Property umlProperty : (owner.getAttributes())) {
			// FIXME remove println
			logger.debug("umlProperty: " + umlProperty);
			logger.debug("umlProperty.getname: " + umlProperty.getName());
			if (umlProperty.getName().equals(componentName)
					&& EntityUtil.getInstance().isComponentInstance(umlProperty)) {
				return umlProperty;
			}
		}
		return null;
	}

	public String getSystemElementURIFragment(Model model) throws Exception {

		if (model != null) {
			TreeIterator<EObject> allElements = model.eResource().getAllContents();
			if (allElements != null) {
				Collection<org.eclipse.uml2.uml.Class> classes = EcoreUtil
						.getObjectsByType(iterator2Collection(allElements), UMLPackage.eINSTANCE.getClass_());

				for (Class c : classes) {
					if (isSystem(c)) {
						return c.eResource().getURIFragment(c);
					}
				}
			}
		}
		throw new Exception("Element does not exist.");
	}

	public EObject getElement(String projectName, String fileModelPath, String elementID) throws Exception {

		Model model = loadModel(projectName, fileModelPath);
		return getElement(model, elementID);

	}

	public EObject getElement(Model model, String elementID) throws Exception {

		if (model != null) {
			/*
			 * TreeIterator<EObject> allElements =
			 * model.eResource().getAllContents(); while(allElements.hasNext()){
			 * logger.debug("URI  fragment: "+allElements.next().eResource().
			 * getURI().fragment()); }
			 */
			EObject umlElement = model.eResource().getEObject(elementID.trim());
			return umlElement;
		}

		return null;

	}

	public String getUMLElementName(String projectName, String fileModelPath, String elementID) throws Exception {

		Model model = loadModel(projectName, fileModelPath);

		if (model != null) {
			EObject umlElement = model.eResource().getEObject(elementID.trim());
			return ((Class) umlElement).getName();
		}

		return null;

	}

	public EList<Element> getSubComponentsOfOwner(Constraint constraint) {
		Element element = constraint.getOwner();
		EList<Element> subComponents = new BasicEList<Element>();

		for (Property umlProperty : getSubComponentsInstances((Class) element)) {
			subComponents.add(getUMLType(umlProperty));
		}

		return subComponents;
	}

	public Element getSubComponent(Element element, String componentName) {

		for (Property umlProperty : getSubComponentsInstances((Class) element)) {
			if (umlProperty.getName().compareTo(componentName) == 0) {
				return getUMLType(umlProperty);
			}
		}

		return null;
	}

	public String[] getSubComponentsNameOfConstraintOwner(Constraint constraint) {
		Element umlElement = constraint.getOwner();
		Set<String> subCompArr = getSubComponentsNames((Class) umlElement);
		return toArray(subCompArr);
	}

	private String[] toArray(Set<String> set) {
		String[] strArray = new String[set.size()];
		return set.toArray(strArray);
	}

	private String[] toArray(EList<String> eList) {
		String[] strArray = new String[eList.size()];
		return eList.toArray(strArray);
	}

	public String getComponentID(Element umlComponent) {

		if ((isBlock(umlComponent))) {
			return ((Class) umlComponent).getName();
		}

		if (isComponentInstance((Element) umlComponent)) {
			return (((Property) umlComponent).getName());
		}

		return null;
	}

	public String getQualifiedName(NamedElement element) {
		return ((NamedElement) element).getQualifiedName();
	}

	public String getComponentName(Element umlComponent) {

		if ((isBlock(umlComponent))) {
			return ((Class) umlComponent).getName();
		}

		if (isComponentInstance((Element) umlComponent)) {
			return (((Property) umlComponent).getName());
		}

		return null;
	}

	public Set<Property> getSubComponentsInstances(Class umlComponent) {
		Set<Property> subComponents = new HashSet<Property>();
		for (Property umlProperty : ((Class) umlComponent).getAttributes()) {
			if (isComponentInstance(umlProperty)) {
				subComponents.add(umlProperty);
			}
		}
		return subComponents;
	}

	/**
	 * Returns the component instance with the given name.
	 * 
	 * @param umlComponent
	 *            the class owning the instance
	 * @param componentName
	 *            the name of the instance
	 * @return the UML property representing the component instance
	 */
	public Property getUMLComponentInstance(Class umlComponent, String componentName) {

		for (Property umlProperty : (umlComponent.getAttributes())) {
			if (umlProperty.getName().equals(componentName) && isComponentInstance(umlProperty)) {
				return umlProperty;
			}
		}
		return null;
	}

	public String[] getEnumValuesFromComponentPorts(Class umlComponent) {
		EList<String> enumValuesEList = new BasicEList<String>();

		for (Port port : getUMLPortsFromClass(umlComponent)) {
			if (isEnumerationAttribute(port)) {
				Set<String> currValues = getListValuesForEnumeratorType(port.getType());
				enumValuesEList.addAll(currValues);
			}
		}

		return toArray(enumValuesEList);
	}

	public EList<String> getEnumValuesFromComponentAttributes(Element umlComponent) {
		EList<String> enumValuesEList = new BasicEList<String>();

		for (Property property : getSupportedAttributes(umlComponent, null)) {
			if (isEnumerationAttribute(property)) {
				Set<String> currValues = getListValuesForEnumeratorType(property.getType());
				enumValuesEList.addAll(currValues);
			}
		}

		return enumValuesEList;
		// return toArray(enumValuesEList);
	}

	public Set<String> getSubComponentsNames(Class umlComponent) {

		Set<String> subComponentsNames = new HashSet<String>();
		for (Property umlProperty : getSubComponentsInstances(umlComponent)) {
			subComponentsNames.add((umlProperty).getName());
		}
		return subComponentsNames;
	}

	public String[] getSubComponentsName(Class umlComponent) {
		return toArray(getSubComponentsNames(umlComponent));
	}

	public EList<Port> getUMLPorts(Element umlElement, boolean isStaticPort) {
		EList<Port> portsArr = new BasicEList<Port>();
		if (isBlock(umlElement) || isCompType(umlElement) || isComponentImplementation(umlElement)) {
			portsArr.addAll(getUMLPortsFromClass((Class) umlElement, isStaticPort));
		}

		if (isComponentInstance(umlElement)) {
			portsArr.addAll(getUMLPortsFromProperty((Property) umlElement, isStaticPort));
		}
		return portsArr;

	}

	private EList<Port> getUMLPortsFromProperty(Property umlElement, boolean isStaticPort) {
		return getUMLPortsFromClass((Class) getUMLType((Property) umlElement), isStaticPort);
	}

	/*
	 * private EList<Port> getUMLPortsFromProperty(Element umlElement, int
	 * portDirection, boolean isStaticPort) { return
	 * getUMLPortsFromClass((Class)getUMLType((Property)
	 * umlElement),portDirection,isStaticPort); }
	 */

	public EList<Port> getUMLPorts(Element umlElement, int portDirection, boolean isStaticPort) {
		EList<Port> portsArr = new BasicEList<Port>();
		if (isBlock(umlElement)) {
			portsArr.addAll(getUMLPortsFromClass((Class) umlElement, portDirection, isStaticPort));
		}

		if (isCompType(umlElement) || (isComponentImplementation(umlElement))) {
			portsArr.addAll(getUMLPortsFromComponent((Component) umlElement, portDirection, isStaticPort));
		}

		if (isComponentInstance(umlElement)) {
			portsArr.addAll(getUMLPorts(getUMLType((Property) umlElement), portDirection, isStaticPort));
		}
		return portsArr;

	}

	private EList<Port> getUMLPortsFromClass(Class umlComponent, int portDirection, boolean isStatic) {
		EList<Port> ports = new BasicEList<Port>();
		for (Port umlPort : umlComponent.getOwnedPorts()) {
			FlowPort fp = getFlowPort(umlPort);
			if ((fp.getDirection().getValue() == portDirection) && (umlPort.isStatic() == isStatic)) {
				ports.add(umlPort);
			}
		}
		return ports;
	}

	public boolean isInputPort(Element umlPort) {
		return (umlPort instanceof Property && getPortDirection(umlPort) == FlowDirection.IN_VALUE);
		// if (getPortDirection(umlPort) == FlowDirection.IN_VALUE) {
		// return true;
		// } else {
		// return false;
		// }
	}

	public boolean isInOutPort(Element umlPort) {
		return (umlPort instanceof Property && getPortDirection(umlPort) == FlowDirection.INOUT_VALUE);
		// if (getPortDirection(umlPort) == FlowDirection.INOUT_VALUE) {
		// return true;
		// } else {
		// return false;
		// }
	}

	public boolean isOutputPort(Element umlPort) {
		return (umlPort instanceof Property && getPortDirection(umlPort) == FlowDirection.OUT_VALUE);
		// if (getPortDirection(umlPort) == FlowDirection.OUT_VALUE) {
		// return true;
		// } else {
		// return false;
		// }
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

	private Set<Port> getUMLPortsFromComponent(Component umlComponent, int portDirection, boolean isStaticPort) {
		Set<Port> ports = new HashSet<Port>();

		for (Port umlPort : umlComponent.getOwnedPorts()) {
			org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowPort fp = getFlowPortMarte(umlPort);
			if ((fp.getDirection().getValue() == portDirection) && (umlPort.isStatic() == isStaticPort)) {
				ports.add(umlPort);
			}
		}
		return ports;
	}

	private EList<Port> getUMLPortsFromClass(Class umlComponent, boolean isStaticPort) {
		EList<Port> ports = new BasicEList<Port>();
		for (Port umlPort : umlComponent.getOwnedPorts()) {
			if (umlPort.isStatic() == isStaticPort) {
				ports.add(umlPort);
			}
		}
		return ports;
	}

	private Set<Port> getUMLPortsFromClass(Class umlComponent) {
		Set<Port> ports = new HashSet<Port>();
		for (Port umlPort : umlComponent.getOwnedPorts()) {
			ports.add(umlPort);
		}
		return ports;
	}

	/*
	 * private Set<Port> getUmlPortsFromComponent(Component umlComponent) {
	 * Set<Port> ports = new HashSet<Port>();
	 * 
	 * for (Port umlPort : umlComponent.getOwnedPorts()) { ports.add(umlPort); }
	 * return ports; }
	 */

	public Package getToPackage(org.eclipse.uml2.uml.Element umlElememt) {

		Package tmp = umlElememt.getNearestPackage();
		while (tmp.getOwner() != null && (tmp.getOwner() instanceof Package)) {
			tmp = (Package) tmp.getOwner();
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
		return ((umlElement instanceof Property) && (isFlowPort(umlElement) || isFlowPortMarte(umlElement)));
	}

	private boolean isFlowPort(Element umlElement) {
		return (umlElement instanceof Property && UMLUtil.getAppliedStereotype(umlElement, FLOW_Port, false) != null);
	}

	private boolean isFlowPortMarte(Element umlElement) {
		return (umlElement instanceof Property
				&& UMLUtil.getAppliedStereotype(umlElement, FLOW_Port_MARTE, false) != null);
	}

	public void deleteComponentContract(Class clazz) {
		clazz.destroy();
	}

	public boolean isComponentImplementation(Element umlElement) {
		return (umlElement instanceof Class && UMLUtil.getAppliedStereotype(umlElement, COMP_IMPL, false) != null);
	}

	// modified method!!
	public boolean isComponentInstance(Element umlProperty) {
		// return UMLUtil.getAppliedStereotype(umlProperty, COMP_INST, false) !=
		// null;
		if (!(umlProperty instanceof Property)) {
			return false;
		}

		Property property = (Property) umlProperty;

		if (property.getAssociation() == null) {
			return false;
		}

		if (ContractEntityUtil.getInstance().isContractProperty(property)) {
			return false;
		}

		Element owner = (getOwner(umlProperty));
		Association association = property.getAssociation();
		int associationEndsSize = association.getEndTypes().size();
		if (associationEndsSize != 2) {
			return false;
		}
		boolean End1TypeIsOwner = association.getEndTypes().get(0).equals(owner);
		boolean End2TypeIsOwner = association.getEndTypes().get(1).equals(owner);

		return (associationEndsSize == 2) && ((End1TypeIsOwner) | (End2TypeIsOwner));

		// Type umlPropertyType = ((Property) umlProperty).getType();
		// return (isBlock(umlPropertyType) ||
		// isComponentImplementation(umlPropertyType));
	}

	public boolean isBooleanAttribute(Property umlProperty) {
		return isBooleanType(umlProperty.getType());
	}

	public boolean isBooleanType(Type type) {
		if (type != null) {
			return ((type.getQualifiedName().compareTo(BOOLEAN_TYPE) == 0)
					|| (type.getQualifiedName().compareTo(MARTE_BOOLEAN_TYPE) == 0));
		}
		return false;
	}

	/*
	 * public String[] getLowerUpperBoundsForRangeType(Property umlProperty) {
	 * return getLowerUpperBoundsForRangeType(umlProperty.getType()); }
	 */

	public String[] getLowerUpperBoundsForRangeType(Type umlType) {
		BoundedSubtype boundedSubtype = getRangeAttribute(umlType);
		String[] bounds = { boundedSubtype.getMinValue(), boundedSubtype.getMaxValue() };

		return bounds;
	}

	private BoundedSubtype getRangeAttribute(Type umlType) {
		Stereotype boundedStereo = UMLUtil.getAppliedStereotype(umlType, BOUNDED_TYPE, false);
		return (BoundedSubtype) umlType.getStereotypeApplication(boundedStereo);
	}

	public boolean isRangeAttribute(Property umlProperty) {
		return isRangeType(umlProperty.getType());
	}

	public boolean isRangeType(Type umlType) {
		if (umlType != null) {
			if (UMLUtil.getAppliedStereotype(umlType, BOUNDED_TYPE, false) != null) {
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

	public boolean isStringAttribute(Property umlProperty) {
		return isStringType(umlProperty.getType());
	}

	public boolean isRealAttribute(Property umlProperty) {
		return isRealType(umlProperty.getType());
	}

	public boolean isIntegerAttribute(Property umlProperty) {
		return isIntegerType(umlProperty.getType());
	}

	public boolean isContinuousAttribute(Property umlProperty) {
		if (umlProperty.getType() != null) {
			return isContinuousType(umlProperty.getType());
		}
		return false;
	}

	public boolean isContinuousType(Type type) {
		if (type != null) {
			return type.getQualifiedName().compareTo(CHESS_CONTINUOUS_TYPE) == 0;
		} else
			return false;
	}

	public Type getAttributeType(Property umlProperty) {
		return (umlProperty.getType());
	}

	public boolean isEnumerationAttribute(Property umlProperty) {
		return isEnumerationType(umlProperty.getType());
	}

	public boolean isEnumerationType(Type umlType) {
		if (umlType != null) {
			return (umlType instanceof Enumeration);
		}
		return false;
	}

	public Set<String> getListValuesForEnumeratorType(Type umlType) {
		Set<String> enumValuesNames = new HashSet<String>();
		if (umlType instanceof Enumeration) {
			for (EnumerationLiteral enumLit : ((Enumeration) umlType).getOwnedLiterals()) {
				enumValuesNames.add(enumLit.getName());
			}
			return enumValuesNames;

		}
		return null;
	}

	public String[] getValuesForEnumeratorType(Type umlType) {
		Set<String> enumValuesNames = getListValuesForEnumeratorType(umlType);
		if (enumValuesNames != null) {
			return toArray(enumValuesNames);
		}
		return null;
	}

	public Element getUMLType(Property umlProperty) {
		return ((Element) umlProperty.getType());
	}

	public boolean isBlock(Element umlClass) {
		return (umlClass instanceof Class && UMLUtil.getAppliedStereotype(umlClass, BLOCK, false) != null);
	}

	public boolean isCompType(Element umlComponent) {
		return (umlComponent instanceof Class && UMLUtil.getAppliedStereotype(umlComponent, COMP_TYPE, false) != null);
	}

	public boolean isSystem(Element umlElement) {
		return (umlElement instanceof Class && UMLUtil.getAppliedStereotype(umlElement, SYSTEM, false) != null);
	}

	public boolean isFaultyStateMachine(Element umlElement) {
		return (umlElement instanceof StateMachine
				&& UMLUtil.getAppliedStereotype(umlElement, FAULTY_STATE_MACHINE, false) != null);
	}

	public boolean isNominalStateMachine(Element umlElement) {
		return (umlElement instanceof StateMachine
				&& UMLUtil.getAppliedStereotype(umlElement, FAULTY_STATE_MACHINE, false) == null);
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

	public String[] getPortsNames(Element umlElement, int portDirection, boolean isStaticPort) {
		EList<String> portsNames = new BasicEList<String>();

		for (Port umlPort : getUMLPorts(umlElement, portDirection, isStaticPort)) {
			portsNames.add(umlPort.getName());
		}

		return toArray(portsNames);
	}

	public EList<String> getPortsName(EList<Port> ports) {
		EList<String> portsNames = new BasicEList<String>();

		for (Port umlPort : ports) {
			portsNames.add(umlPort.getName());
		}
		return portsNames;
	}

	public String[] getInputPortsNames(Element umlElement, boolean isStaticPort) {
		return getPortsNames(umlElement, FlowDirection.IN_VALUE, isStaticPort);
	}

	public String[] getOutputPortsNames(Element umlElement, boolean isStaticPort) {
		return getPortsNames(umlElement, FlowDirection.OUT_VALUE, isStaticPort);
	}

	public String[] getInputOutputPortsNames(Element umlElement, boolean isStaticPort) {
		return getPortsNames(umlElement, FlowDirection.INOUT_VALUE, isStaticPort);
	}

	private Set<Property> getSupportedAttributes(Element umlElement, Boolean isStaticAttribute) {
		Set<Property> simpleAttributes = new HashSet<Property>();

		if (isComponentInstance(umlElement)) {
			umlElement = getUMLType((Property) umlElement);
		}

		if (isBlock(umlElement) || (isCompType(umlElement) || (isComponentImplementation(umlElement)))) {
			Class umlClass = (Class) umlElement;
			for (Property umlProperty : umlClass.getOwnedAttributes()) {
				if ((isStaticAttribute == null) || (umlProperty.isStatic() == isStaticAttribute)) {
					if (isBooleanAttribute(umlProperty)) {
						simpleAttributes.add(umlProperty);
					}
					if (isContinuousAttribute(umlProperty)) {
						simpleAttributes.add(umlProperty);
					}
					if (isDoubleAttribute(umlProperty)) {
						simpleAttributes.add(umlProperty);
					}
					if (isRangeAttribute(umlProperty)) {
						simpleAttributes.add(umlProperty);
					}
					if (isEnumerationAttribute(umlProperty)) {
						simpleAttributes.add(umlProperty);
					}
					if (isIntegerAttribute(umlProperty)) {
						simpleAttributes.add(umlProperty);
					}
					if (isRealAttribute(umlProperty)) {
						simpleAttributes.add(umlProperty);
					}
				}
			}
		}

		return simpleAttributes;
	}

	private Set<Property> getIntegerAttributes(Element umlElement) {
		Set<Property> integerAttributes = new HashSet<Property>();

		if (isBlock(umlElement) || (isCompType(umlElement) || (isComponentImplementation(umlElement)))) {
			Class umlClass = (Class) umlElement;
			EList<Property> attributes = umlClass.getOwnedAttributes();
			for (Property umlProperty : attributes) {
				if (isIntegerAttribute(umlProperty)) {
					integerAttributes.add(umlProperty);
				}
			}
		}

		if (isComponentInstance(umlElement)) {
			integerAttributes.addAll(getIntegerAttributes(getUMLType((Property) umlElement)));
		}
		return integerAttributes;
	}

	public Set<Property> getAttributesExceptPorts(Element umlElement, Boolean isStaticAttribute) {
		Set<Property> attributes = new HashSet<Property>();
		for (Property umlProperty : getSupportedAttributes(umlElement, isStaticAttribute)) {
			if (!isPort(umlProperty)) {
				attributes.add(umlProperty);
			}
		}
		return attributes;
	}

	public Set<Property> getIntegerAttributesExceptPorts(Element umlElement) {
		Set<Property> integerAttributes = new HashSet<Property>();
		for (Property umlProperty : getIntegerAttributes(umlElement)) {
			if (!isPort(umlProperty)) {
				integerAttributes.add(umlProperty);
			}
		}
		return integerAttributes;
	}

	public Collection<StateMachine> getNominalStateMachines() {

		UmlModel umlModel = UmlUtils.getUmlModel();
		Set<StateMachine> stateMachines = getNominalStateMachines(umlModel);
		return stateMachines;

	}

	public Set<StateMachine> getNominalStateMachines(UmlModel umlModel) {

		Set<StateMachine> stateMachines = new HashSet<StateMachine>();

		if (umlModel != null) {
			TreeIterator<EObject> allElements = umlModel.getResource().getAllContents();
			if (allElements != null) {
				Collection<org.eclipse.uml2.uml.Class> classes = EcoreUtil
						.getObjectsByType(iterator2Collection(allElements), UMLPackage.eINSTANCE.getClass_());
				for (Class c : classes) {
					if (isNominalStateMachine(c)) {
						stateMachines.add((StateMachine) c);
					}
				}
			}
		}

		return stateMachines;
	}

	public Set<StateMachine> getNominalStateMachines(Class umlSelectedComponent, boolean fromSubComponent) {

		Set<StateMachine> stateMachines = getNominalStateMachines(umlSelectedComponent);
		if (fromSubComponent) {
			for (Property subComponentInstance : getSubComponentsInstances(umlSelectedComponent)) {
				stateMachines.addAll(getNominalStateMachines((Class) subComponentInstance.getType(), true));
			}
		}
		return stateMachines;
	}

	public StateMachine getFirstNominalStateMachine(Class umlSelectedComponent) {
		Set<StateMachine> stateMachines = getNominalStateMachines(umlSelectedComponent);
		if ((stateMachines != null) && (stateMachines.size() > 0)) {
			return stateMachines.iterator().next();
		} else
			return null;
	}

	public Set<StateMachine> getNominalStateMachines(Class umlSelectedComponent) {

		Set<StateMachine> stateMachines = new HashSet<StateMachine>();

		if (umlSelectedComponent != null) {
			EList<Behavior> behaviours = umlSelectedComponent.getOwnedBehaviors();
			if (behaviours != null) {
				for (Class c : behaviours) {
					if (isNominalStateMachine(c)) {
						stateMachines.add((StateMachine) c);
					}
				}
			}
		}

		return stateMachines;
	}

	private <T> Collection<T> iterator2Collection(final Iterator<T> iter) {
		ArrayList<T> list = new ArrayList<T>();
		for (; iter.hasNext();) {
			T item = iter.next();
			list.add(item);
		}
		return list;
	}

	public EList<Transition> getTranstitions(StateMachine stateMachine) {
		Region region = stateMachine.getRegions().get(0);
		return region.getTransitions();
	}

	public EList<Vertex> getStates(StateMachine stateMachine) {
		Region region = stateMachine.getRegions().get(0);
		return region.getSubvertices();
	}

	public boolean isInitialState(Vertex state) {
		return (state instanceof Pseudostate)
				&& ((Pseudostate) state).getKind().equals(PseudostateKind.INITIAL_LITERAL);
	}

	public boolean isFinalState(Vertex state) {
		return ((state instanceof Pseudostate)
				&& ((Pseudostate) state).getKind().getName().compareTo("Terminate") == 0);
	}

	public EList<Vertex> getIntermediateStates(StateMachine stateMachine) {
		EList<Vertex> intermediateStates = new BasicEList<Vertex>();
		for (Vertex state : getStates(stateMachine)) {
			if (!isInitialState(state) && !isFinalState(state)) {
				intermediateStates.add(state);
			}
		}
		return intermediateStates;
	}

	public EList<String> getStatesNameList(EList<Vertex> states) {
		EList<String> names = new BasicEList<String>();
		for (Vertex state : states) {
			names.add(state.getName());
		}
		return names;
	}

	public EList<String> getTransitionNameList(EList<Transition> transitions) throws Exception {
		logger.debug("getTransitionNameList");
		EList<String> transNames = new BasicEList<String>();
		for (Transition trans : transitions) {
			if (trans.getName() == null) {
				throw new Exception("In " + trans.containingStateMachine().getQualifiedName()
						+ ", one transition has name == null.");
			}
			logger.debug("transition Name: " + trans.getName());
			transNames.add(trans.getName());
		}

		return transNames;
	}

	public String getStateMachineName(StateMachine stateMachine) {
		return stateMachine.getName();
	}

	public String getTransitionName(Transition transition) {
		return transition.getName();
	}

	public Vertex getInitialState(StateMachine stateMachine) {
		for (Vertex state : getStates(stateMachine)) {
			if (isInitialState(state)) {
				return state;
			}
		}
		return null;
	}

	public EList<Transition> getInitialTransitions(StateMachine stateMachine) throws Exception {
		Vertex initialState = getInitialState(stateMachine);
		if (initialState != null) {
			return initialState.getOutgoings();
		} else {
			throw new Exception(stateMachine.getName() + " does not have the initial state.");
		}

	}

	public EList<Transition> getNonInitialTransitions(StateMachine stateMachine) {
		EList<Vertex> states = getIntermediateStates(stateMachine);
		EList<Transition> transitions = new BasicEList<Transition>();
		for (Vertex state : states) {
			if (!isInitialState(state)) {
				transitions.addAll(state.getOutgoings());
			}
		}
		return transitions;
	}

	public Vertex getTransitionNextState(Transition transition) {
		return transition.getTarget();
	}

	public Vertex getTransitionSourceState(Transition transition) {
		return transition.getSource();
	}

	public Constraint getTransitionGuard(Transition transition) {
		return transition.getGuard();
	}

	public OpaqueBehavior getTransitionEffect(Transition transition) {
		if (transition.getEffect() instanceof OpaqueBehavior) {
			return (OpaqueBehavior) transition.getEffect();
		}
		return null;
	}

	public String getTransitionEffectText(Transition transition) {
		OpaqueBehavior effect = getTransitionEffect(transition);
		if ((effect != null) && (effect.getBodies() != null) && (effect.getBodies().size() != 0)) {
			String effectAsString = effect.getBodies().get(0);
			return effectAsString;
		}
		return null;
	}

	public String getGuardName(Constraint guard) {
		return guard.getName();
	}

	public String getStateName(Vertex state) {
		return state.getName();
	}

	public String getEffectName(Behavior effect) {
		return effect.getName();
	}

	public boolean isFinalTransition(Transition transition) {
		return isFinalState(transition.getTarget());
	}

	public EList<Port> getEvents(StateMachine stateMachine) {
		EList<Port> eventsPort = getEventPorts(getOwner(stateMachine));
		return eventsPort;
	}

	public EList<Port> getEventPorts(Element umlElement) {

		EList<Port> eventPorts = new BasicEList<Port>();

		if (isComponentInstance(umlElement)) {
			umlElement = getUMLType((Property) umlElement);
		}

		if (isBlock(umlElement) || (isCompType(umlElement) || (isComponentImplementation(umlElement)))) {
			Class umlClass = (Class) umlElement;
			for (Property umlProperty : umlClass.getOwnedAttributes()) {
				if (isEventPortAttribute(umlProperty)) {
					eventPorts.add((Port) umlProperty);
				}
			}
		}

		return eventPorts;
	}

	public boolean isEventPortAttribute(Property umlProperty) {
		return ((umlProperty.getType() != null) && (isEventType(umlProperty.getType())));
	}

	public boolean isEventType(Type type) {
		return (type instanceof Signal);
	}

	public EList<Port> getTransitionEvents(Transition transition) {
		if (!isTransitionWithNoEvent(transition)) {
			return transition.getTriggers().get(0).getPorts();
		}
		return null;
	}

	public String getPortName(Port port) {
		return port.getName();
	}

	public String getAttributeName(Property attribute) {
		return attribute.getName();
	}

	/**
	 * Returns the name of the given parameter
	 * 
	 * @param parameter
	 *            the parameter
	 * @return the requested name
	 */
	public String getParameterName(Parameter parameter) {
		return parameter.getName();
	}

	/**
	 * Returns the owner of the given parameter
	 * 
	 * @param parameter
	 *            the parameter
	 * @return the owner of the parameter
	 */
	public Element getParameterOwner(Parameter parameter) {
		return parameter.getOwner();
	}

	/**
	 * Returns the owner of the given function behavior
	 * 
	 * @param function
	 *            the function behavior
	 * @return the owner of the function behavior
	 */
	public Element getUMLFunctionBehaviorOwner(FunctionBehavior function) {
		return function.getOwner();
	}

	public boolean isTransitionWithNoEvent(Transition transition) {
		return !((transition.getTriggers() != null) && (transition.getTriggers().size() != 0)
				&& (transition.getTriggers().get(0).getPorts() != null)
				&& transition.getTriggers().get(0).getPorts().size() != 0);

	}

	public boolean isRealType(Type type) {
		if (type != null) {
			return ((type.getQualifiedName().compareTo(REAL_TYPE) == 0)
					|| (type.getQualifiedName().compareTo(MARTE_REAL_TYPE) == 0));
		}
		return false;
	}

	public boolean isIntegerType(Type type) {
		if (type != null) {
			return ((type.getQualifiedName().compareTo(INTEGER_TYPE) == 0)
					|| (type.getQualifiedName().compareTo(MARTE_INTEGER_TYPE) == 0));
		}
		return false;
	}

	public boolean isStringType(Type type) {
		if (type != null) {
			return (type.getQualifiedName().compareTo(STRING_TYPE) == 0);
		}
		return false;
	}

	public Collection<? extends Port> getUMLPortsExceptEvents(Element umlElement, int portDirection) {

		if (isComponentInstance(umlElement)) {
			umlElement = getUMLType((Property) umlElement);
		}

		Set<Port> portsArr = new HashSet<Port>();
		if (isBlock(umlElement)) {
			portsArr.addAll(getUMLPortsExceptEventsFromClass((Class) umlElement, portDirection));
		}

		if (isCompType(umlElement) || (isComponentImplementation(umlElement))) {
			portsArr.addAll(getUMLPortsExceptEventsFromComponent((Component) umlElement, portDirection));
		}

		return portsArr;
	}

	private Collection<? extends Port> getUMLPortsExceptEventsFromComponent(Component umlComponent, int portDirection) {
		Set<Port> ports = new HashSet<Port>();

		for (Port umlPort : umlComponent.getOwnedPorts()) {
			org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowPort fp = getFlowPortMarte(umlPort);
			if ((fp.getDirection().getValue() == portDirection) && (!isEventPortAttribute(umlPort))) {
				ports.add(umlPort);
			}
		}
		return ports;
	}

	private Collection<? extends Port> getUMLPortsExceptEventsFromClass(Class umlElement, int portDirection) {
		Set<Port> ports = new HashSet<Port>();
		for (Port umlPort : umlElement.getOwnedPorts()) {
			FlowPort fp = getFlowPort(umlPort);
			if ((fp.getDirection().getValue() == portDirection) && (!isEventPortAttribute(umlPort))) {
				ports.add(umlPort);
			}
		}
		return ports;
	}

	// FIXME no control on languages on OpaqueExpression
	public String getConditionExpression(Constraint condition) {
		if ((condition.getSpecification() != null) && (condition.getSpecification() instanceof OpaqueExpression)
				&& ((OpaqueExpression) condition.getSpecification()).getBodies() != null) {
			return ((OpaqueExpression) condition.getSpecification()).getBodies().get(0);
		}
		return null;
	}

	/**
	 * Checks if the selected object is a package in the <<SystemView>> branch.
	 * 
	 * @param pkg
	 *            the selected element
	 * @return true if the package is valid
	 */
	public boolean isSystemViewPackage(Element obj) {
		if (obj instanceof Package) {
			final Package pkg = (Package) obj;
			if (pkg.getAppliedStereotype(SYSVIEW) != null) {
				return true;
			} else {
				EList<Package> owningPackages = pkg.allOwningPackages();
				for (Package owningPackage : owningPackages) {
					if (owningPackage.getAppliedStereotype(SYSVIEW) != null) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public EList<Constraint> getRefinementFormalPropertiesAsConstraints(Element component) {

		if (component instanceof Class) {
			return getRefinementFormalPropertiesAsConstraintsFromClass((Class) component);
		} else if (component instanceof Property) {
			return getRefinementFormalPropertiesAsConstraintsFromProperty((Property) component);
		}

		return null;
	}

	private EList<Constraint> getRefinementFormalPropertiesAsConstraintsFromClass(Class component) {

		EList<Constraint> formalProperties = new BasicEList<Constraint>();

		for (Constraint umlConstraint : ((Class) component).getOwnedRules()) {
			if (isRefinementFormalProperty(umlConstraint)) {
				formalProperties.add(umlConstraint);
			}
		}

		return formalProperties;
	}

	private EList<Constraint> getRefinementFormalPropertiesAsConstraintsFromProperty(Property componentInstance) {

		return getRefinementFormalPropertiesAsConstraintsFromClass((Class) componentInstance.getType());
	}

	public EList<Constraint> getInterfaceFormalPropertiesAsConstraints(Element component) {

		if (component instanceof Class) {
			return getInterfaceFormalPropertiesAsConstraintsFromClass((Class) component);
		} else if (component instanceof Property) {
			return getInterfaceFormalPropertiesAsConstraintsFromProperty((Property) component);
		}

		return null;
	}

	private EList<Constraint> getInterfaceFormalPropertiesAsConstraintsFromClass(Class component) {

		EList<Constraint> formalProperties = new BasicEList<Constraint>();

		for (Constraint umlConstraint : ((Class) component).getOwnedRules()) {
			if (isInterfaceFormalProperty(umlConstraint)) {
				formalProperties.add(umlConstraint);
			}
		}

		return formalProperties;
	}

	private EList<Constraint> getInterfaceFormalPropertiesAsConstraintsFromProperty(Property componentInstance) {

		return getInterfaceFormalPropertiesAsConstraintsFromClass((Class) componentInstance.getType());
	}

	public boolean isFormalProperty(Element umlConstraint) {
		if (umlConstraint instanceof Constraint) {
			return UMLUtil.getAppliedStereotype(umlConstraint, FORMAL_PROP, false) != null;
		}
		return false;
	}

	public boolean isInterfaceFormalProperty(Element umlConstraint) {
		return (isFormalProperty(umlConstraint)
				&& (((Constraint) umlConstraint).getVisibility() == VisibilityKind.PUBLIC_LITERAL));
	}

	public boolean isRefinementFormalProperty(Element umlConstraint) {
		return (isFormalProperty(umlConstraint)
				&& (((Constraint) umlConstraint).getVisibility() == VisibilityKind.PRIVATE_LITERAL));
	}

	public String getConstraintQualifiedName(Constraint formalProperty) {
		if (formalProperty != null) {
			return ((Constraint) formalProperty).getQualifiedName();
		}
		return null;
	}

	public String getConstraintName(Constraint constraint) {
		if (constraint != null) {
			return ((Constraint) constraint).getName();
		}
		return null;
	}

	public FormalProperty getFormalProperty(Constraint umlConstraint) {
		Stereotype formalPropertyStereotype = UMLUtil.getAppliedStereotype(umlConstraint, FORMAL_PROP, false);
		return (FormalProperty) umlConstraint.getStereotypeApplication(formalPropertyStereotype);
	}

	public boolean isDelegationConstraints(Element umlProperty) {
		return ((umlProperty instanceof Constraint)
				&& (UMLUtil.getAppliedStereotype(umlProperty, DELEGATION_CONST, false) != null));
	}

	public EList<Constraint> getDelegationConstraintsAsUMLConstraints(Element umlElement) {
		EList<Constraint> constraints = new BasicEList<Constraint>();

		if (isBlock(umlElement) || isCompType(umlElement) || isComponentImplementation(umlElement)) {
			for (Constraint umlConstraint : ((Class) umlElement).getOwnedRules()) {
				if (isDelegationConstraints(umlConstraint)) {
					constraints.add((Constraint) umlConstraint);
				}
			}
		}

		if (isComponentInstance(umlElement)) {
			constraints.addAll(getDelegationConstraintsAsUMLConstraints(getUMLType((Property) umlElement)));
		}

		return constraints;
	}

	public EList<FunctionBehavior> getUMLFunctionBehaviors(Element umlElement) {

		EList<FunctionBehavior> functionBehaviours = null;

		if (isComponentInstance((Element) umlElement)) {
			umlElement = ((Property) umlElement).getType();
		}

		if (umlElement instanceof Class) {
			Class umlClass = (Class) umlElement;
			EList<Behavior> behaviours = umlClass.getOwnedBehaviors();
			for (Behavior behavior : behaviours) {
				if (behavior instanceof FunctionBehavior) {
					if (functionBehaviours == null) {
						functionBehaviours = new BasicEList<FunctionBehavior>();
					}
					functionBehaviours.add((FunctionBehavior) behavior);
				}
			}
		}

		return functionBehaviours;
	}

	/**
	 * Returns the name of the given function behavior
	 * 
	 * @param function
	 *            the function behavior
	 * @return the requested name
	 */
	public String getUMLFunctionBehaviorName(FunctionBehavior uninterpretedFunction) {
		return uninterpretedFunction.getName();
	}

	public Type getUMLFunctionBehaviorOutputType(FunctionBehavior uninterpretedFunction) {
		for (Parameter parameter : uninterpretedFunction.getOwnedParameters()) {
			if (parameter.getDirection() == ParameterDirectionKind.OUT_LITERAL) {
				return parameter.getType();
			}
		}
		return null;
	}

	public EList<Type> getUMLFunctionBehaviorInputTypes(FunctionBehavior uninterpretedFunction) {

		EList<Type> inputTypes = new BasicEList<Type>();

		for (Parameter parameter : uninterpretedFunction.getOwnedParameters()) {
			if (parameter.getDirection() == ParameterDirectionKind.IN_LITERAL) {
				inputTypes.add(parameter.getType());
			}
		}
		return inputTypes;
	}

	/**
	 * Returns the input parameters of the given function behavior
	 * 
	 * @param function
	 *            the function behavior
	 * @return the input parameters
	 */
	public EList<Parameter> getUMLFunctionBehaviorInputParameters(FunctionBehavior function) {
		final EList<Parameter> inputParameters = new BasicEList<Parameter>();

		// Loop on all the parameters to find the input ones
		final EList<Parameter> parameters = function.getOwnedParameters();
		for (Parameter parameter : parameters) {
			if (parameter.getDirection() == ParameterDirectionKind.IN_LITERAL) {
				inputParameters.add(parameter);
			}
		}
		return inputParameters;
	}

	public Parameter getUMLFunctionBehaviorOutputParameter(FunctionBehavior function) {
		// Loop on all the parameters to find the input ones
		final EList<Parameter> parameters = function.getOwnedParameters();
		for (Parameter parameter : parameters) {
			if (parameter.getDirection() == ParameterDirectionKind.OUT_LITERAL) {
				return (parameter);
			}
		}
		return null;
	}

	public Object getParameterType(Parameter parameter) {
		return parameter.getType();
	}

	public String[] getComponentInstanceMultiplicity(Property component) throws Exception {
		if (isComponentInstance(component)) {
			return getAttributeMultiplicity(component);
		}

		throw new Exception("" + component.getName() + " is not a component instance");

	}

	public String[] getAttributeMultiplicity(Property attribute) {
		logger.debug("getAttributeMultiplicity");

		ValueSpecification upperValueSpecification = ((Property) attribute).getUpperValue();
		ValueSpecification lowerValueSpecification = ((Property) attribute).getLowerValue();

		String upperValue = getValueSpecificationValue(upperValueSpecification);
		String lowerValue = getValueSpecificationValue(lowerValueSpecification);

		String[] boundaries = { lowerValue, upperValue };
		return boundaries;
	}

	public String getValueSpecificationValue(ValueSpecification valueSpecification) {

		String strValue = null;
		Object value = null;
		if (valueSpecification instanceof LiteralInteger) {
			logger.debug("instanceof LiteralInteger");
			value = ((LiteralInteger) valueSpecification).getValue();

		} else if (valueSpecification instanceof LiteralUnlimitedNatural) {
			logger.debug("instanceof LiteralUnlimitedNatural");
			value = ((LiteralUnlimitedNatural) valueSpecification).getValue();

		} else if (valueSpecification instanceof LiteralString) {
			logger.debug("instanceof LiteralString");
			value = ((LiteralString) valueSpecification).getValue();
		}

		logger.debug("value: " + value);

		strValue = String.valueOf(value);

		if (strValue == "null") {
			strValue = null;
		}

		logger.debug("getValueSpecificationValue: " + strValue);
		return strValue;
	}

	/**
	 * Adds a connector to the given element.
	 * 
	 * @param owner
	 *            the owner element
	 * @param connector
	 *            the conne
	 */
	public void addConnector(Class owner, Connector connector) {

		// Add the new connector to the list
		owner.getOwnedConnectors().add(connector);
	}

	/**
	 * Creates a connector, but doesn't add it to the owner.
	 * 
	 * @param owner
	 *            the owner element
	 * @return the created Connector
	 */
	public Connector createConnector(String connectorName) {

		Connector connector = UMLFactory.eINSTANCE.createConnector();
		connector.setName(connectorName);

		logger.debug("\n\nCreated " + connectorName + " Connector\n\n");
		return connector;
	}

	/**
	 * Creates an end to the given connector.
	 * 
	 * @param connector
	 *            the owner Connector
	 * @param sourceOwner
	 *            the component instance owning the port
	 * @param sourcePort
	 *            the port to be connected
	 * @return
	 */
	public ConnectorEnd createConnectorEnd(Connector connector, Property sourceOwner, ConnectableElement sourcePort) {
		final ConnectorEnd end = connector.createEnd();

		end.setRole(sourcePort);
		end.setPartWithPort(sourceOwner);
		return end;
	}

	public Parameter createFunctionBehaviorParameter(FunctionBehavior owner, String parameterName, Type parameterType,
			boolean isInput) {

		logger.debug("\n\n\n Creating functionBehaviorParameter " + parameterName + " for owner " + owner);
		logger.debug("\n\n\n");

		final Parameter parameter = owner.createOwnedParameter(parameterName, parameterType);
		parameter.setDirection(isInput ? ParameterDirectionKind.IN_LITERAL : ParameterDirectionKind.OUT_LITERAL);
		logger.debug("\n\nCreated " + parameterName + " functionBehaviorParameter\n\n");
		return parameter;
	}

	public Constraint createFormalProperty(final Namespace formalPropertyOwner, String formalPropertyName) {

		// Contract contract = getContract(umlContract);
		// final String formalPropertyName = prefix_name + "_" +
		// umlContract.getName();
		final String propertyName = formalPropertyName;

		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(formalPropertyOwner);
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				Constraint umlNewConstraint = formalPropertyOwner.createOwnedRule(propertyName);
				UMLUtils.applyStereotype(umlNewConstraint, FORMAL_PROP);
			}
		});
		return formalPropertyOwner.getOwnedRule(propertyName);

	}

	/**
	 * Creates an empty FunctionBehavior belonging to the given owner
	 * 
	 * @param owner
	 *            the owner class of the functionBehavior
	 * @param functionBehaviorName
	 *            the name of the functionBehavior
	 * @return the newly created FunctionBehavior
	 */
	public FunctionBehavior createFunctionBehavior(Class owner, String functionBehaviorName) {

		logger.debug("\n\n\n Creating functionBehavior " + functionBehaviorName + " for owner " + owner);
		logger.debug("\n\n\n");

		final FunctionBehavior functionBehavior = (FunctionBehavior) owner.createOwnedBehavior(functionBehaviorName,
				UMLPackage.eINSTANCE.getFunctionBehavior());

		logger.debug("\n\nCreated " + functionBehaviorName + " FunctionBehavior\n\n");
		return functionBehavior;
	}

	/**
	 * Returns the input Parameters of the given FunctionBehavior
	 * 
	 * @param owner
	 *            the FunctionBehavior to analyze
	 * @return the list of input Parameters
	 */
	public EList<Parameter> getOwnedInputParameters(FunctionBehavior owner) {
		EList<Parameter> inputParameters = new BasicEList<Parameter>();

		for (Parameter parameter : owner.getOwnedParameters()) {
			if (parameter.getDirection() == ParameterDirectionKind.IN_LITERAL) {
				inputParameters.add(parameter);
			}
		}
		return inputParameters;
	}

	public Parameter createFunctionBehaviorParameter(FunctionBehavior owner, Type parameterType, boolean isInput) {

		// Create the name
		String parameterName = null;
		if (isInput) {
			parameterName = DEFAULT_PARAMETER_IN_NAME + (getOwnedInputParameters(owner).size() + 1); // Incremental
			// name
		} else {
			parameterName = DEFAULT_PARAMETER_OUT_NAME; // There could be only
														// one
			// output
		}

		return createFunctionBehaviorParameter(owner, parameterName, parameterType, isInput);
	}

	public org.eclipse.uml2.uml.Port createNonStaticPort(Class owner, String portName, Type portType,
			String[] multiplicityBounds, boolean isInput, Stereotype flowportStereotype) {
		org.eclipse.uml2.uml.Port umlPort = UMLFactory.eINSTANCE.createPort();
		umlPort.setName(portName);
		umlPort.setType(portType);
		owner.getOwnedPorts().add(umlPort);
		umlPort.applyStereotype(flowportStereotype);
		umlPort.setAggregation(AggregationKind.get(AggregationKind.COMPOSITE));
		FlowPort flowPort = (FlowPort) umlPort.getStereotypeApplication(flowportStereotype);
		flowPort.setDirection(isInput ? FlowDirection.IN : FlowDirection.OUT);

		setAttributeMultiplicity(umlPort, multiplicityBounds);

		// This version is nicer but a little slower
		// org.eclipse.uml2.uml.Port umlPort = owner.createOwnedPort(portName,
		// portType);
		// Stereotype stereotype = UMLUtils.applyStereotype(umlPort, FLOWPORT);
		// umlPort.setAggregation(AggregationKind.get(AggregationKind.COMPOSITE));
		// FlowPort flowPort = (FlowPort)
		// umlPort.getStereotypeApplication(stereotype);
		// flowPort.setDirection(isInput? FlowDirection.IN: FlowDirection.OUT);
		logger.debug("\n\nCreated " + portName + " Port\n\n");
		return umlPort;
	}

	public org.eclipse.uml2.uml.Port createStaticPort(Class owner, String portName, Type portType,
			String[] multiplicityBounds, Stereotype flowPortStereotype) {

		org.eclipse.uml2.uml.Port umlPort = UMLFactory.eINSTANCE.createPort();
		umlPort.setName(portName);
		umlPort.setType(portType);
		owner.getOwnedPorts().add(umlPort);
		umlPort.applyStereotype(flowPortStereotype);
		umlPort.setAggregation(AggregationKind.get(AggregationKind.COMPOSITE));
		FlowPort flowPort = (FlowPort) umlPort.getStereotypeApplication(flowPortStereotype);
		flowPort.setDirection(FlowDirection.INOUT);
		umlPort.setIsStatic(true);

		setAttributeMultiplicity(umlPort, multiplicityBounds);

		return umlPort;
	}

	public String createDelegationConstraintText(String variableIdTextName, String constraintText,
			String iterConditionText) {

		final StringBuffer delegationText = new StringBuffer();

		delegationText.append(variableIdTextName + " := " + constraintText);
		if (iterConditionText != null) {
			delegationText.append(" " + iterConditionText);
		}
		return delegationText.toString();
	}

	public Connector getExistingConnector(EList<Connector> connectors, String variablePortOwner,
			String variablePortName, String constraintPortOwner, String constraintPortName) {

		// Loop on all the connectors to find one with same values
		for (Connector connector : connectors) {
			final EList<ConnectorEnd> ends = connector.getEnds();
			if (ends.size() == 2) {

				// Check the first end
				final Property sourceOwner = ends.get(0).getPartWithPort(); // Should
																			// be
																			// the
																			// owner
																			// of
																			// the
																			// port
				final org.eclipse.uml2.uml.Port sourcePort = (org.eclipse.uml2.uml.Port) ends.get(0).getRole(); // Should
																												// be
																												// the
																												// port

				if (sourcePort.getName().equals(constraintPortName)) {
					if (sourceOwner != null && sourceOwner.getName().equals(constraintPortOwner)) {
					} else if (sourceOwner == null && constraintPortOwner == null) {
					} else {
						continue;
					}
				} else {
					continue;
				}

				// One end is correct, go on with the second
				final Property targetOwner = ends.get(1).getPartWithPort(); // Should
																			// be
																			// the
																			// owner
																			// of
																			// the
																			// port
				final org.eclipse.uml2.uml.Port targetPort = (org.eclipse.uml2.uml.Port) ends.get(1).getRole(); // Should
																												// be
																												// the
																												// port

				if (targetPort.getName().equals(variablePortName)) {
					if (targetOwner != null && targetOwner.getName().equals(variablePortOwner)) {
					} else if (targetOwner == null && variablePortOwner == null) {
					} else {
						continue;
					}
				} else {
					continue;
				}

				// Connector found
				return connector;
			}
		}
		return null;
	}

	/**
	 * Create a public formal property
	 * 
	 * @param owner
	 *            the owner of the property
	 * @param assertionName
	 *            the name of the formal property
	 * @param assertionText
	 *            the text of the formal property
	 * @return the newly created formal property
	 */
	public Constraint createInterfaceFormalProperty(Class owner, String assertionName, String assertionText) {

		final Constraint umlConstraint = createFormalProperty(owner, assertionName);
		final LiteralString newLs = UMLFactory.eINSTANCE.createLiteralString();
		final ValueSpecification vs = umlConstraint.createSpecification("ConstraintSpec", null, newLs.eClass());
		umlConstraint.setSpecification(vs);

		setTextInUMLConstraint(umlConstraint, assertionText);

		return umlConstraint;
	}

	public void setTextInUMLConstraint(final Constraint umlConstraint, final String formalPropertyText) {

		logger.debug("saveFormalProperty: " + formalPropertyText);

		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(umlConstraint);
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {

				// Constraint umlConstraint =
				// formalProperty.getBase_Constraint();
				if (umlConstraint.getSpecification() instanceof LiteralString) {
					// logger.debug("saveFormalProperty LiteralString");
					LiteralString litString = (LiteralString) umlConstraint.getSpecification();
					litString.setValue(formalPropertyText);
					umlConstraint.setSpecification(litString);
				} else if (umlConstraint.getSpecification() instanceof OpaqueExpression) {
					// logger.debug("saveFormalProperty OpaqueExpression");
					OpaqueExpression opaqueExpr = (OpaqueExpression) umlConstraint.getSpecification();
					// opaqueExpr.getLanguages().
					setOpaqueExpressionBodyForLanguage(opaqueExpr, "OCRA", formalPropertyText);

				}
			}
		});
	}

	private void setOpaqueExpressionBodyForLanguage(org.eclipse.uml2.uml.OpaqueExpression opaqueExpression,
			String language, String body) {
		// checks both lists by size
		OpaqueExpressionUtil.checkAndCorrectLists(opaqueExpression);
		// checks if language exists, if not, creates one
		if (!opaqueExpression.getLanguages().contains(language)) {
			opaqueExpression.getLanguages().add(0, language);
			opaqueExpression.getBodies().add(0, body);
		} else {
			// retrieve the index of the given language in the opaque Expression
			int index = opaqueExpression.getLanguages().indexOf(language);
			// sets the body at the given index in the list of bodies.
			opaqueExpression.getBodies().set(index, body);
		}
	}

	/**
	 * Deletes an element from the model.
	 * 
	 * @param element
	 *            the element to remove
	 * @throws Exception
	 */
	public void deleteElementInTheModel(NamedElement element) throws Exception {

		// Give the focus to the ModelExplorerView
		ModelExplorerView modelExplorerView = getModelExplorerView();
		modelExplorerView.setFocus();

		// Select the requested element
		List<Object> elements = new ArrayList<Object>();
		elements.add(element);
		modelExplorerView.revealSemanticElement(elements);

		IHandler deleteHandler = getActiveHandlerFor(IWorkbenchCommandConstants.EDIT_DELETE);
		deleteHandler.execute(new ExecutionEvent());
	}

	/**
	 * Returns the handler for the given command.
	 * 
	 * @param commandId
	 *            the command
	 * @return the handler
	 */
	private IHandler getActiveHandlerFor(final String commandId) {
		final ICommandService commandService = (ICommandService) PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getService(ICommandService.class);
		commandService.refreshElements(commandId, null);
		final Command cmd = commandService.getCommand(commandId);
		return cmd.getHandler();
	}

	// Needed to bring out a reference from the inner class...
	ModelExplorerView modelExplorerView;

	/**
	 * Returns the ModelExplorerView.
	 * 
	 * @return
	 */
	private ModelExplorerView getModelExplorerView() {

		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				final IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();

				// we look for the modelexplorer
				IViewPart modelexplorer;
				try {
					modelexplorer = activeWorkbenchWindow.getActivePage().showView(ModelExplorerPageBookView.VIEW_ID);
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
	 * Removes an element from the list.
	 * 
	 * @param members
	 *            the list of members
	 * @param qualifiedElement
	 *            the qualified name of the element to remove
	 */
	public void removeElement(EList<Class> members, String qualifiedElement) {
		removeNamedElement(members, qualifiedElement);
	}

	/**
	 * Removes a function behavior from the list.
	 * 
	 * @param members
	 *            the list of members
	 * @param qualifiedElement
	 *            the qualified name of the function behavior to remove
	 */
	public void removeFunctionBehavior(EList<Behavior> members, String qualifiedElement) {
		removeNamedElement(members, qualifiedElement);
	}

	/**
	 * Removes a FunctionBehavior parameter from the list.
	 * 
	 * @param members
	 *            the list of members
	 * @param qualifiedElement
	 *            the qualified name of the function behavior parameter to
	 *            remove
	 */
	public void removeFunctionBehaviorParameter(EList<Parameter> members, String qualifiedElement) {
		removeNamedElement(members, qualifiedElement);
	}

	/**
	 * Removes a formal property from the list.
	 * 
	 * @param members
	 *            the list of members
	 * @param qualifiedElement
	 *            the qualified name of the formal property to remove
	 */
	public void removeFormalProperty(EList<Constraint> members, String qualifiedElement) {
		removeNamedElement(members, qualifiedElement);
	}

	/**
	 * Removes a named element from the given list.
	 * 
	 * @param members
	 *            the list of members
	 * @param qualifiedElement
	 *            the qualified name of the element to remove
	 */
	public void removeNamedElement(EList<?> members, String qualifiedElement) {
		for (Object object : members) {
			NamedElement element = (NamedElement) object;
			if (element.getQualifiedName().equals(qualifiedElement)) {
				try {
					// ((Element) element).destroy(); //TODO: investigate this
					// line!
					deleteElementInTheModel(element);
				} catch (Exception e) {
					e.printStackTrace();
				}
				members.remove(element);
				break;
			}
		}
	}

	/**
	 * Removes a property from the list.
	 * 
	 * @param members
	 *            the list of members
	 * @param qualifiedElement
	 *            the qualified name of the property to remove
	 */
	public void removeProperty(EList<Property> members, String qualifiedElement) {
		removeNamedElement(members, qualifiedElement);
	}

	/**
	 * Removes a property from the list.
	 * 
	 * @param members
	 *            the list of members
	 * @param qualifiedElement
	 *            the qualified name of the property to remove
	 */
	public void removeConnector(EList<Connector> members, String qualifiedElement) {
		removeNamedElement(members, qualifiedElement);
	}

	/**
	 * Removes a port from the list.
	 * 
	 * @param members
	 *            the list of members
	 * @param qualifiedElement
	 *            the qualified name of the port to remove
	 */
	public void removePort(EList<NamedElement> members, String qualifiedElement) {
		removeNamedElement(members, qualifiedElement);
	}

	public Association createUmlAssociation(String subComponentName, Type type, String[] multiplicity, Class owner) {

		final String associationName = DEFAULT_ASSOCIATION_NAME
				+ (countPackageAssociations(owner.getNearestPackage()) + 1);
		// I should create an Association between the elements
		// and not a Component Instance!

		return createAssociation(owner, associationName, subComponentName, type, multiplicity);

	}

	/**
	 * Returns the number or defined associations for the given package.
	 * 
	 * @param pkg
	 *            the package to analyze
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
	 * Creates an association between the given owner and element. It will also
	 * create the relative component instance inside the owner element.
	 * 
	 * @param owner
	 *            the parent Class
	 * @param elementName
	 *            the name of the end element
	 * @param elementType
	 *            the type of the end element
	 * @return the created Association
	 */
	public Association createAssociation(Class owner, String associationName, String elementName, Type elementType,
			String[] multiplicity) {
		logger.debug("createAssociation");

		logger.debug("\n\n\n Creating association " + associationName + " for owner " + owner);
		logger.debug("elementName = " + elementName + " with type " + elementType.getName() + " [" + multiplicity[0]
				+ "," + multiplicity[1] + "]");
		logger.debug("\n\n\n");

		org.eclipse.uml2.uml.Package package_ = owner.getNearestPackage();
		Association association = (Association) package_.createOwnedType(null, UMLPackage.Literals.ASSOCIATION);
		Property subComponentInstance = buildAssociationEndInternal(association, elementName, elementType, null, true,
				(AggregationKind) AggregationKind.get(AggregationKind.COMPOSITE));
		buildAssociationEndInternal(association, owner.getName().toLowerCase(), owner, null, false,
				(AggregationKind) AggregationKind.get(AggregationKind.NONE));
		if (associationName != null) {
			association.setName(associationName);
		}

		owner.getOwnedAttributes().add(subComponentInstance);

		// Create the association and adds it to the owning package
		// the method owner.createAssociation does not allow to set multiplicity
		// equal to null
		/*
		 * final Association association = owner.createAssociation( true,
		 * AggregationKind.get(AggregationKind.COMPOSITE), elementName, 1, 1,
		 * elementType, false, AggregationKind.get(AggregationKind.NONE),
		 * owner.getName().toLowerCase(), 1, 1);
		 * association.setName(associationName);
		 */
		logger.debug("createAssociation done");

		if (!isOneInstance(multiplicity)) {
			logger.debug("!isOneInstance");
			setAttributeMultiplicity(subComponentInstance, multiplicity);
		}
		// Add SysML Nature on the new Association
		ElementUtil.addNature(association, SysMLElementTypes.SYSML_NATURE);

		logger.debug("\n\nCreated " + associationName + " Association\n\n");
		return association;
	}

	/*
	 * public static Association createAssociation(Type type, boolean
	 * end1IsNavigable, AggregationKind end1Aggregation, String end1Name, int
	 * end1Lower, int end1Upper, Type end1Type, boolean end2IsNavigable,
	 * AggregationKind end2Aggregation, String end2Name, int end2Lower, int
	 * end2Upper) { org.eclipse.uml2.uml.Package package_ =
	 * type.getNearestPackage(); if (package_ == null) { throw new
	 * IllegalStateException(); } if (end1Aggregation == null) { throw new
	 * IllegalArgumentException(String.valueOf(end1Aggregation)); } if
	 * (end2Aggregation == null) { throw new
	 * IllegalArgumentException(String.valueOf(end2Aggregation)); } Association
	 * association = (Association) package_.createOwnedType(null,
	 * UMLPackage.Literals.ASSOCIATION); createAssociationEnd(type, association,
	 * end1IsNavigable, end1Aggregation, end1Name, end1Lower, end1Upper,
	 * end1Type); createAssociationEnd(end1Type, association, end2IsNavigable,
	 * end2Aggregation, end2Name, end2Lower, end2Upper, type); return
	 * association; }
	 * 
	 * protected static Property createAssociationEnd(Class type, Association
	 * association, boolean isNavigable, AggregationKind aggregation, String
	 * name, int lower, int upper, Type endType) { EList<Property>
	 * ownedAttributes = type.getOwnedAttributes(); Property associationEnd =
	 * type.createOwnedProperty(ownedAttributes == null || !isNavigable ?
	 * association : type, name, endType, lower, upper);
	 * associationEnd.setAggregation(aggregation); if (isNavigable) { if
	 * (ownedAttributes == null) {
	 * association.getNavigableOwnedEnds().add(associationEnd); } else {
	 * association.getMemberEnds().add(associationEnd); } } return
	 * associationEnd; }
	 */

	private Property buildAssociationEndInternal(final Association assoc, final String name, final Type type,
			final Integer[] multi, final Boolean navigable, final AggregationKind aggregation) {
		// The attribute 'targetScope' of an AssociationEnd in UML1.x is no
		// longer supported in UML2.x

		Property property = UMLFactory.eINSTANCE.createProperty();
		property.setType((Type) type);
		property.setAssociation((Association) assoc);
		if (name != null) {
			property.setName(name);
		}
		if (navigable != null) {
			property.setIsNavigable(navigable);
			if (!(Boolean) navigable) {
				((Association) assoc).getOwnedEnds().add(property);
			}
		}
		if (aggregation != null) {
			property.setAggregation((AggregationKind) aggregation);
		}

		if (multi != null) {
			if (multi[0] != null) {
				property.setLower(multi[0]);
			}
			if (multi[1] != null) {
				property.setUpper(multi[1]);
			}
		}

		return property;
	}

	private boolean isOneInstance(String[] multiplicityBoundariesAsExpressons) {
		logger.debug("isOneInstance");
		return (((multiplicityBoundariesAsExpressons[0] == null) && (multiplicityBoundariesAsExpressons[1] == null))
				|| (multiplicityBoundariesAsExpressons[0] == "") && (multiplicityBoundariesAsExpressons[1] == ""))
				|| (isEqualToOne(multiplicityBoundariesAsExpressons[0])
						&& isEqualToOne(multiplicityBoundariesAsExpressons[1]));
	}

	private boolean isEqualToOne(String expression) {
		return isInteger(expression) && (Integer.valueOf(expression) == 1);
	}

	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
		// only got here if we didn't return false
		return true;
	}

	/**
	 * Removes a delegation constraint from the list.
	 * 
	 * @param members
	 *            the list of members
	 * @param qualifiedElement
	 *            the qualified name of the delegation constraint to remove
	 */
	public void removeDelegationConstraint(EList<Constraint> members, String qualifiedElement) {
		removeNamedElement(members, qualifiedElement);
	}

	public boolean equalMultiplicityBoundaries(String[] newMultiplicityRange, String[] multiplicityRange) {
		return (equals(newMultiplicityRange[0], multiplicityRange[0])
				&& equals(newMultiplicityRange[1], multiplicityRange[1]));

	}

	private boolean equals(String text1, String text2) {
		return ((text1 == text2) && (text2 == null)) || (text1.equals(text2));
	}

	public void setAttributeMultiplicity(Property property, String[] newMultiplicityRange) {

		if (newMultiplicityRange[0] != null) {
			property.setLowerValue(createLiteralStringWithValue(newMultiplicityRange[0]));
		}

		if (newMultiplicityRange[1] != null) {
			property.setUpperValue(createLiteralStringWithValue(newMultiplicityRange[1]));
		}
	}

	private LiteralString createLiteralStringWithValue(String value) {
		LiteralString literalString = UMLFactory.eINSTANCE.createLiteralString();
		literalString.setValue(value);
		return literalString;
	}

	public EList<Constraint> getParameterAssumptionsAsConstraintsUml(Element umlElement) {
		EList<Constraint> constraints = new BasicEList<Constraint>();

		if (isBlock(umlElement) || isCompType(umlElement) || isComponentImplementation(umlElement)) {
			for (Constraint umlConstraint : ((Class) umlElement).getOwnedRules()) {
				if (isParameterAssumption(umlConstraint)) {
					constraints.add((Constraint) umlConstraint);
				}
			}
		}

		if (isComponentInstance(umlElement)) {
			constraints.addAll(getParameterAssumptionsAsConstraintsUml(getUMLType((Property) umlElement)));
		}

		return constraints;
	}

	public boolean isParameterAssumption(Element umlProperty) {
		return ((umlProperty instanceof Constraint)
				&& (UMLUtil.getAppliedStereotype(umlProperty, DELEGATION_CONST, false) == null));
	}

	public Element createUmlConstraint(Class owner, String parameterAssumptionsText) {
		int numParameterAssumptions = getParameterAssumptionsAsConstraintsUml(owner).size();
		String parameterAssumptionsName = DEFAULT_PAR_ASSUMPTION_PREFIX + numParameterAssumptions;

		logger.debug("\n\n\n Creating constraint " + parameterAssumptionsName + " for owner " + owner);
		logger.debug("\n\n\n");

		final Constraint newUMLConstraint = owner.createOwnedRule(parameterAssumptionsName);
		final LiteralString literalString = UMLFactory.eINSTANCE.createLiteralString();
		literalString.setName(DEFAULT_PAR_ASSUMPTION_LITERAL_STRING_NAME);
		literalString.setValue(parameterAssumptionsText);
		newUMLConstraint.setSpecification(literalString);

		logger.debug("\n\nCreated " + parameterAssumptionsName + " Constraint\n\n");
		return newUMLConstraint;
	}

	public Constraint getUmlConstraintFromText(String parameterAssumptionsText, Class owner) {
		for (Constraint umlConstraint : ((Class) owner).getOwnedRules()) {
			if (isParameterAssumption(umlConstraint)
					&& getConstraintBodyStr(umlConstraint).equals(parameterAssumptionsText)) {
				return umlConstraint;
			}
		}
		return null;
	}

	public void removeParameterAssumptions(EList<Constraint> members, String qualifiedElement) {
		removeNamedElement(members, qualifiedElement);

	}

}