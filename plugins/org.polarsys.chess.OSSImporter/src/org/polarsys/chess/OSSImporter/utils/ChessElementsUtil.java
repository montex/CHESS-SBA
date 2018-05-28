package org.polarsys.chess.OSSImporter.utils;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.sysml.portandflows.FlowDirection;
import org.eclipse.papyrus.sysml.portandflows.FlowPort;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.FunctionBehavior;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.ValueSpecification;
import org.polarsys.chess.OSSImporter.exceptions.ImportException;
import org.polarsys.chess.contracts.profile.chesscontract.ContractProperty;
import org.polarsys.chess.contracts.profile.chesscontract.FormalProperty;
import org.polarsys.chess.contracts.profile.chesscontract.util.ContractEntityUtil;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;
import org.polarsys.chess.contracts.profile.chesscontract.util.StereotypeUtil;
import org.polarsys.chess.service.core.model.ChessSystemModel;
import eu.fbk.tools.editor.basetype.baseType.SimpleType;
import eu.fbk.tools.editor.contract.contract.Contract;
import eu.fbk.tools.editor.contract.expression.expression.ExtendedExpression;
import eu.fbk.tools.editor.contract.expression.expression.PortId;
import eu.fbk.tools.editor.contract.expression.expression.VariableId;
import eu.fbk.tools.editor.oss.oss.InputPort;
import eu.fbk.tools.editor.oss.oss.OutputPort;
import eu.fbk.tools.editor.oss.oss.SubComponent;
import eu.fbk.tools.editor.oss.oss.Variable;

public class ChessElementsUtil {

	private static final String DELEGATION_PREFIX = "Define_";
	private static final String ASSOCIATION_NAME = "association";
	private static final String CONNECTOR_NAME = "connector";
	private static final String DELEGATION_CONSTRAINT_LITERAL_STRING_NAME = "constraintSpec";
	
	// Logger for messages
	private static final Logger logger = Logger.getLogger(ChessElementsUtil.class);

	private final StereotypeUtil stereotypeUtil = StereotypeUtil.getInstance();
	private final ChessSystemModel chessSystemModel = ChessSystemModel.getInstance();
	private final EntityUtil entityUtil = EntityUtil.getInstance();
	private final OssElementsUtil ossElementsUtil = OssElementsUtil.getInstance();
	private final ContractEntityUtil contractEntityUtil = ContractEntityUtil.getInstance();
	private static ChessElementsUtil chessElementsUtil;

	/**
	 * Gets an instance of the class if already present, or a new one if not.
	 * 
	 * @return the instance of this class
	 */
	public static ChessElementsUtil getInstance() {
		if (chessElementsUtil == null) {
			chessElementsUtil = new ChessElementsUtil();
		}
		return chessElementsUtil;
	}

	/**
	 * Returns the Connector with the given ends if present among a list of
	 * Connectors
	 * 
	 * @param connectors
	 *            the list of Connectors to scan
	 * @param variable
	 *            the first end of the Connector
	 * @param constraint
	 *            the second end of the Connector
	 * @return the Connector, if found
	 */
	public Connector getExistingConnector(EList<Connector> connectors, VariableId variable, ExtendedExpression constraint) {

		// Details of the connector ends
		String variablePortOwner = null;
		String variablePortName = null;
		String constraintPortOwner = null;
		String constraintPortName = null;

		
		
		if(isSimpleConnection(variable,constraint)) {

			// Get the component name, should be at max one
			EList<String> variableComponentNames = ((PortId) variable).getComponentNames();
			if (variableComponentNames != null && variableComponentNames.size() != 0) {
				variablePortOwner = variableComponentNames.get(0);
			}
			variablePortName = ((PortId) variable).getName();
		

			// Get the component name, should be at max one
			EList<String> constraintComponentNames = ((PortId) constraint.getExpression()).getComponentNames();
			if (constraintComponentNames != null && constraintComponentNames.size() != 0) {
				constraintPortOwner = constraintComponentNames.get(0);
			}
			constraintPortName = ((PortId) constraint.getExpression()).getName();
		
		}

		return entityUtil.getExistingConnector(connectors, variablePortOwner, variablePortName, constraintPortOwner, constraintPortName);
	}
	
	public boolean isSimpleConnection(VariableId variable, ExtendedExpression constraint){
		return (constraint.getExpression() instanceof PortId)&&(constraint.getIterativeCondition()==null)&&(variable instanceof PortId);
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
	public Constraint getExistingDelegationConstraint(EList<Constraint> delegationConstraints, VariableId variable,
			String constraintText) {

		final String variableName = variable.getName();
		final EList<String> componentNames = variable.getComponentNames();
		//String constraintText = getConstraintText(constraint);

		String prefixComponentName = null;

		if (componentNames != null && componentNames.size() != 0) {
			prefixComponentName = (componentNames.get(0) + ".");
		}

		// Text of the delegation constraint
		final String formalPropertyText = entityUtil.createDelegationConstraintText(variableName, prefixComponentName,
				constraintText);

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
	public Parameter getExistingFunctionBehaviorParameter(EList<Parameter> parameters, SimpleType type,
			boolean isInput) {
		for (Parameter parameter : parameters) {
			if (parameter.getType() == ossElementsUtil.getOrCreateTypeFromOssType(type, parameter.getNearestPackage())) {
				if ((isInput && parameter.getDirection() == ParameterDirectionKind.IN_LITERAL)
						|| (!isInput && parameter.getDirection() == ParameterDirectionKind.OUT_LITERAL)) {
					return parameter;
				}
			}
		}
		return null;
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

	public org.eclipse.uml2.uml.Port getExistingUmlPort(String portName, EObject portType,
			EList<NamedElement> existingPorts, Package pkg) {
		
		Type ossPortType = ossElementsUtil.getOrCreateTypeFromOssType(portType, pkg);
		
		
		// Check if the port is already present
		for (Object object : existingPorts) {
			final org.eclipse.uml2.uml.Port tmpPort = (org.eclipse.uml2.uml.Port) object;
			if (tmpPort.getName().equals(portName) && tmpPort.getType().getName().equals(ossPortType.getName())) {
				return tmpPort;
				// Port found
			}
		}
		return null;

	}
	
	private Constraint createDelegationConstraint(Class owner, String delegationName, String variableName,String prefixSubComponentName,
			String constraintText) {

		logger.debug("\n\n\n Creating delegation constraint " + delegationName + " for owner " + owner);
		logger.debug("\n\n\n");

		final Constraint newUMLConstraint = owner.createOwnedRule(delegationName.toString());
		newUMLConstraint.applyStereotype(stereotypeUtil.delegationConstraintStereotype);

		final LiteralString literalString = UMLFactory.eINSTANCE.createLiteralString();
		literalString.setName(DELEGATION_CONSTRAINT_LITERAL_STRING_NAME);

		final String formalPropertyText = entityUtil.createDelegationConstraintText(variableName, prefixSubComponentName, constraintText);
		literalString.setValue(formalPropertyText);
		newUMLConstraint.setSpecification(literalString);

		logger.debug("\n\nCreated " + delegationName + " Delegation Constraint\n\n");
		return newUMLConstraint;
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
	public Class createBlock(Package owner, final String elementName) {

		Class umlClass = owner.createOwnedClass(elementName, false);
		umlClass.applyStereotype(stereotypeUtil.blockStereotype);

		// owner.createPackagedElement(elementName, newUMLClass.eClass()); This
		// also works...
		// owner.getPackagedElements().add(newUMLClass); // This works too!

		logger.debug("\n\nCreated " + elementName + " Block\n\n");
		return umlClass; // Return the first occurence
	}

	/**
	 * Creates a System Block element in the given package.
	 * 
	 * @param owner
	 *            the Package that will contain the element
	 * @param elementName
	 *            the name of the new System Block
	 * @return the created Class
	 */
	public Class createSystemBlock(Package owner, final String elementName) {

		Class sysBlock = owner.createOwnedClass(elementName, false);
		sysBlock.applyStereotype(stereotypeUtil.blockStereotype);
		sysBlock.applyStereotype(stereotypeUtil.systemStereotype);

		logger.debug("\n\nCreated " + elementName + " System Block\n\n");
		return sysBlock;
	}
	
	private Port createNonStaticPort(Class owner, String portName, Type portType, String[] multiplicityBounds,
			boolean isInput) {

		org.eclipse.uml2.uml.Port umlPort = UMLFactory.eINSTANCE.createPort();
		umlPort.setName(portName);
		umlPort.setType(portType);
		owner.getOwnedPorts().add(umlPort);
		// Stereotype stereotype = UMLUtils.applyStereotype(umlPort, FLOWPORT);
		umlPort.applyStereotype(stereotypeUtil.flowPortStereotype);
		umlPort.setAggregation(AggregationKind.get(AggregationKind.COMPOSITE));
		// FlowPort flowPort = (FlowPort)
		// umlPort.getStereotypeApplication(stereotype);
		FlowPort flowPort = (FlowPort) umlPort.getStereotypeApplication(stereotypeUtil.flowPortStereotype);
		flowPort.setDirection(isInput ? FlowDirection.IN : FlowDirection.OUT);

		// TODO setmultiplicity
		// This version is nicer but a little slower
		// org.eclipse.uml2.uml.Port umlPort = owner.createOwnedPort(portName,
		// portType);
		// Stereotype stereotype = UMLUtils.applyStereotype(umlPort, FLOWPORT);
		// umlPort.setAggregation(AggregationKind.get(AggregationKind.COMPOSITE));
		// FlowPort flowPort = (FlowPort)
		// umlPort.getStereotypeApplication(stereotype);
		// flowPort.setDirection(isInput? FlowDirection.IN: FlowDirection.OUT);

		
		return umlPort;
	}

	private Port createStaticPort(Class owner, String portName, Type portType, String[] multiplicityBounds) {

		org.eclipse.uml2.uml.Port umlPort = UMLFactory.eINSTANCE.createPort();
		umlPort.setName(portName);
		umlPort.setType(portType);
		owner.getOwnedPorts().add(umlPort);
		// Stereotype stereotype = UMLUtils.applyStereotype(umlPort, FLOWPORT);
		umlPort.applyStereotype(stereotypeUtil.flowPortStereotype);
		umlPort.setAggregation(AggregationKind.get(AggregationKind.COMPOSITE));
		// FlowPort flowPort = (FlowPort)
		// umlPort.getStereotypeApplication(stereotype);
		FlowPort flowPort = (FlowPort) umlPort.getStereotypeApplication(stereotypeUtil.flowPortStereotype);
		flowPort.setDirection(FlowDirection.INOUT);
		umlPort.setIsStatic(true);
		// TODO setmuliplicity
		
		return umlPort;
	}

	/**
	 * Creates and adds a Delegation Constraint to the model.
	 * 
	 * @param owner
	 *            the parent Class
	 * @param connection
	 *            the Connection defining the delegation
	 * @param variable
	 *            the target of the connection
	 * @param constraint
	 *            the source of the connection
	 * @return the created delegation constraint
	 */
	public Constraint createUmlDelegationConstraint(Class owner, VariableId variable, String constraintText) {

		final String variableName = variable.getName();
		// String constraintText = getConstraintText(constraint);
		logger.debug("variableName: "+variableName);
		final StringBuffer delegationName = new StringBuffer(DELEGATION_PREFIX);
		final EList<String> componentNames = variable.getComponentNames();

		String prefixSubComponentName = null;
		if (componentNames != null && componentNames.size() != 0) {
			prefixSubComponentName = (componentNames.get(0) + ".");
			delegationName.append(prefixSubComponentName);
		}

		delegationName.append(variableName);

		logger.debug("prefixSubComponentName: "+prefixSubComponentName);
		logger.debug("delegationName: "+delegationName.toString());
		logger.debug("constraintText: "+constraintText);
		
		return createDelegationConstraint(owner, delegationName.toString(), variableName,
				prefixSubComponentName, constraintText);
	}

	/**
	 * Creates a parameter for the given FunctionBehavior
	 * 
	 * @param owner
	 *            the owning FunctionBehavior
	 * @param type
	 *            the type of the parameter
	 * @param isInput
	 *            the direction of the parameter
	 * @return the newly created Parameter
	 */
	public org.eclipse.uml2.uml.Parameter createUmlFunctionBehaviorParameter(FunctionBehavior owner, EObject type,
			boolean isInput) {
		final Type parameterType = ossElementsUtil.getOrCreateTypeFromOssType(type, owner.getNearestPackage());
		return entityUtil.createFunctionBehaviorParameter(owner, parameterType, isInput);
	}

	public Association createUmlAssociation(String subName, Type type, Class owner) {

		final String associationName = ASSOCIATION_NAME
				+ (countPackageAssociations(owner.getNearestPackage()) + 1);
		// I should create an Association between the elements
		// and not a Component Instance!

		return entityUtil.createAssociation(owner, associationName, subName, type);

	}

	private ConnectorEnd createUmlConnectorEnd(Connector connector,  String sourcePort,
			Property partWithPort,Class portOwner) {

		// Get the port and set it
		ConnectableElement role = portOwner.getOwnedPort(sourcePort, null);

		if (role != null) {
			return entityUtil.createConnectorEnd(connector, partWithPort, role);
		}
		return null;
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
	
	public Connector createUmlConnector(String constraintName, Property partWithPortOfConstraint,
			Class portOwnerOfConstraint, String variableName, Property partWithPortOfVariable,
			Class portOwnerOfVariable, Class owner) {
		// Create the source end

		// Create the name using an incremental value
		final String connectorName = CONNECTOR_NAME + (owner.getOwnedConnectors().size() + 1);
		// Create a connector, but only after I'm sure it isn't
		// a delegation constraint
		Connector connector = entityUtil.createConnector(connectorName, owner);
		logger.debug("Creating source end :" + constraintName);
		ConnectorEnd connectorEndConstraint = createUmlConnectorEnd(connector, constraintName,
				partWithPortOfConstraint, portOwnerOfConstraint);

		// Create the target end
		logger.debug("Creating source end :" + variableName);
		ConnectorEnd connectorEndVariable = createUmlConnectorEnd(connector, variableName,
				partWithPortOfVariable, portOwnerOfVariable);

		// At last, add the connector to the owner
		entityUtil.addConnector(owner, connector);

		return connector;

	}
	
/*public ConnectorEnd createConnectorEnd(Connector connector,PortId constraint,Property partWithPort, Class owner){
		
		final String portName = ((PortId) constraint).getName();
		logger.debug("Creating source end :" + portName);
		
		// Get the port and set it
		return createUmlConnectorEnd(connector, portName, partWithPort,owner);
		
		//return createUmlConnectorEnd(connector, portOwnerName, portName,owner);
		
	}*/
	
	public Class createUmlContract(String contractName, String ossAssumptionText, String ossGuaranteeText,
			HashMap<String, FormalProperty> hashFormalProperties, Class owner) {

		// Create an empty Contract
		Class umlContract = contractEntityUtil.createContract(owner, contractName);
		org.polarsys.chess.contracts.profile.chesscontract.Contract contract = contractEntityUtil
				.getContract(umlContract);

		// Check if the assumption formal property is already
		// defined
		// FIXME: this works good only if expressions are
		// different
		final FormalProperty assumption = hashFormalProperties.get(ossAssumptionText);
		if (assumption != null) {

			// Add the assume formal property
			contract.setAssume(assumption);
		} else {

			// Create a new formal property
			contractEntityUtil.setTextToAssumeOrCreateAssume(ossAssumptionText, umlContract);
		}

		// Check if the guarantee formal property is already
		// defined
		final FormalProperty guarantee = hashFormalProperties.get(ossGuaranteeText);
		if (guarantee != null) {

			logger.debug("guarantee already present = " + guarantee);

			// Add the assume formal property
			contract.setGuarantee(guarantee);
		} else {

			logger.debug("guarantee not present");

			// Create a new formal property
			contractEntityUtil.setTextToGuaranteeOrCreateGuarantee(ossGuaranteeText, umlContract);
		}

		// // Add the two Formal Properties
		// contractEntityUtil.saveFormalProperty("Assume",
		// chessElementsUtil.getConstraintText(dslAssumption.getConstraint()),
		// umlContract);
		// contractEntityUtil.saveFormalProperty("Guarantee",
		// chessElementsUtil.getConstraintText(dslGuarantee.getConstraint()),
		// contract);

		// Create a Contract Property
		final String contractPropertyName = deriveContractPropertyNameFromContract(umlContract);
		contractEntityUtil.createContractProperty(owner, contractPropertyName, (Type) umlContract);

		return umlContract;

	}

	public Constraint createUmlInterfaceFormalProperty(String assertionName, String assertionText,
			HashMap<String, FormalProperty> hashFormalProperties, Class owner) {

		Constraint umlConstraint = entityUtil.createInterfaceFormalProperty(owner, assertionName, assertionText);

		// Add the formal property to the hash
		hashFormalProperties.put(assertionText, entityUtil.getFormalProperty(umlConstraint));

		return umlConstraint;
	}

	public Constraint createUmlRefinementFormalProperty(String assertionName, String assertionText, Class owner) {

		Constraint umlConstraint = contractEntityUtil.createRefinementFormalProperty(owner, assertionName,
				assertionText);

		return umlConstraint;
	}

	/**
	 * Creates a ContractRefinement for the given owner component. The
	 * refinement should specify the component instance that contains the
	 * original contract property and the contract property itself
	 * 
	 * @param owner
	 *            the container of the refinement
	 * @param componentName
	 *            the component instance containing the contract property
	 * @param contractName
	 *            the type of the contract
	 * @return the created DataType
	 */
	public DataType getOrCreateContractRefinement(Class owner, String componentName, String contractName) {

		logger.debug("\n\n\n Creating contract refinement for componentName = " + componentName + " of contract "
				+ contractName);
		logger.debug("\n\n\n");

		// The component instance containing the refining contract
		final Property refiningComponentInstance = entityUtil.getUMLComponentInstance(owner, componentName);

		// The component type where the contract property is defined
		final Class refiningComponent = (Class) refiningComponentInstance.getType();

		// The instance of the refining contract
		// final ContractProperty refiningContractProperty =
		// getContractPropertyFromContract(refiningComponent, contractName);
		final Property umlContractProperty = contractEntityUtil
				.getUmlContractPropertyOfUmlComponentFromContractPropertyType(refiningComponent, contractName);
		final ContractProperty refiningContractProperty = contractEntityUtil.getContractProperty(umlContractProperty);

		// Compose the correct name of the contract refinement
		final String refinementName = componentName + "." + umlContractProperty.getName();

		// Check if the refinement is already present
		final DataType umlRefinement = contractEntityUtil.getExistingUmlContractRefinement(owner, refinementName);

		if (umlRefinement != null) {
			return umlRefinement;
		} else {
			logger.debug("\n\n Creating contract refinement " + refinementName + " for owner " + owner.getName());
			logger.debug("\n\n");

			return contractEntityUtil.createContractRefinement(refinementName, refiningComponentInstance,
					refiningContractProperty, owner);

		}

	}

	/**
	 * Creates and adds a non-static Port to the model.
	 * 
	 * @param owner
	 *            the parent Class
	 * @param elementName
	 *            the name of the port to create
	 * @param elementType
	 *            the type of the port to create
	 * @param isInput
	 *            tells the direction of the flow
	 * @return the created Port
	 * @throws ImportException
	 */
	public org.eclipse.uml2.uml.Port createUmlNonStaticPort(Class owner, VariableId elementName, EObject elementType,
			boolean isInput) throws ImportException {
		final String portName = elementName.getName();
		final Type portType = ossElementsUtil.getOrCreateTypeFromOssType(elementType, owner.getNearestPackage());
		final String[] multiplicityBounds = ossElementsUtil.getMultiplicityBoundariesFromDSLType(elementType);

		if (portType == null) {
			throw new ImportException("Not able to map the requested type for port : " + portName);
			// return null; // Create the port anyway, without type
		}

		org.eclipse.uml2.uml.Port umlPort = createNonStaticPort(owner, portName, portType,
				multiplicityBounds, isInput);

		logger.debug("\n\nCreated " + portName + " Port\n\n");
		return umlPort;
	}

	public FunctionBehavior createUmlFunctionBehaviour(VariableId dslVariableID, EObject dslVariableType,
			EList<SimpleType> parameters, Class owner) {

		// Create an empty functionBehavior
		FunctionBehavior functionBehavior = entityUtil.createFunctionBehavior(owner, dslVariableID.getName());

		// Create the input parameters
		for (SimpleType parameterType : parameters) {
			chessElementsUtil.createUmlFunctionBehaviorParameter(functionBehavior, parameterType, true);
		}

		// Create the output parameter
		chessElementsUtil.createUmlFunctionBehaviorParameter(functionBehavior, dslVariableType, false);

		return functionBehavior;

	}

	/**
	 * Creates and adds a static Port to the model.
	 * 
	 * @param owner
	 *            the parent Class
	 * @param elementName
	 *            the name of the port to create
	 * @param elementType
	 *            the type of the port to create
	 * @return the created Port
	 * @throws ImportException
	 */
	public org.eclipse.uml2.uml.Port createUmlStaticPort(Class owner, VariableId elementName, EObject elementType)
			throws ImportException {
		final String portName = elementName.getName();
		final Type portType = ossElementsUtil.getOrCreateTypeFromOssType(elementType, owner.getNearestPackage());
		final String[] multiplicityBounds = ossElementsUtil.getMultiplicityBoundariesFromDSLType(elementType);

		if (portType == null) {
			throw new ImportException("Not able to map the requested type for port : " + portName);
		}

		org.eclipse.uml2.uml.Port umlPort = createStaticPort(owner, portName, portType, multiplicityBounds);
		logger.debug("\n\nCreated " + portName + " Port\n\n");

		return umlPort;
	}

	public void updateUmlAssociation(Property componentInstance, SubComponent subComponent, Type type,
			HashMap<String, Boolean> mapComponentInstances) {

		// The component instance is already present, update its
		// type if needed
		if (!componentInstance.getType().equals(type)) {
			componentInstance.setType(type);

			// Add the association to the list of changes, it
			// needs to be redrawn
			//addedElements.add(componentInstance.getAssociation());
		}

		String[] componentInstanceMultiplicity = (entityUtil.getComponentInstanceMultiplicity(componentInstance));
		String[] ossSubComponentInstanceMultiplicity = ossElementsUtil
				.getMultiplicityBoundariesFromOssSubComponent(subComponent);
		if (!entityUtil.equalMultiplicityBoundaries(componentInstanceMultiplicity,
				ossSubComponentInstanceMultiplicity)) {
			entityUtil.setAttributeMultiplicity(ossSubComponentInstanceMultiplicity);
		}
		// Set the flag to signal the componentInstance is still
		// used
		mapComponentInstances.put(componentInstance.getQualifiedName(), Boolean.TRUE);

	}
	
	public void updateUmlContract(Class umlContract, String ossAssumptionText, String ossGuaranteeText,
			HashMap<String, Boolean> mapContractProperties, HashMap<String, Boolean> mapFormalProperties, Class owner) {

		// The contract type is already present, update the
		// formal properties if needed
		final String assumeString = contractEntityUtil.getAssumeStrFromUmlContract(umlContract);
		final FormalProperty assumeFormalProperty = contractEntityUtil.getAssumeFromUmlContract(umlContract);

		// The formal property is the same, mark it as still
		// used
		mapFormalProperties.put(assumeFormalProperty.getBase_Constraint().getQualifiedName(), Boolean.TRUE);

		if (!ossAssumptionText.equals(assumeString)) {

			// Change the text of the assume property
			final ValueSpecification vs = assumeFormalProperty.getBase_Constraint().getSpecification();
			((LiteralString) vs).setValue(ossAssumptionText);
			assumeFormalProperty.getBase_Constraint().setSpecification(vs);
		}

		final String guaranteeString = contractEntityUtil.getGuaranteeStrFromUmlContract(umlContract);
		final FormalProperty guaranteeFormalProperty = contractEntityUtil.getGuaranteeFromUmlContract(umlContract);

		// The formal property is the same, mark it as still
		// used
		mapFormalProperties.put(guaranteeFormalProperty.getBase_Constraint().getQualifiedName(), Boolean.TRUE);

		if (!ossGuaranteeText.equals(guaranteeString)) {

			// Change the text of the guarantee property
			final ValueSpecification vs = guaranteeFormalProperty.getBase_Constraint().getSpecification();
			((LiteralString) vs).setValue(ossGuaranteeText);
			guaranteeFormalProperty.getBase_Constraint().setSpecification(vs);
		}

		// Set the flag to signal the contractProperty is still
		// used
		final ContractProperty contractProperty = (ContractProperty) chessSystemModel.getContract(owner,
				// dslContract.getName() should be the same
				umlContract.getName());
		mapContractProperties.put(contractProperty.getBase_Property().getQualifiedName(), Boolean.TRUE);

	}

	public void updateUmlRefinementFormalProperty(Constraint umlConstraint, String assertionText,
			HashMap<String, Boolean> mapFormalProperties) {

		// Update the formal property if needed

		final FormalProperty formalProperty = entityUtil.getFormalProperty(umlConstraint);
		final String formalPropertyText = entityUtil.getFormalPropertyStr(formalProperty);

		// If the expression is different, save it,
		// otherwise go on
		if (!assertionText.equals(formalPropertyText)) {
			entityUtil.setTextInUMLConstraint(umlConstraint, assertionText);
		}

		// Set the flag to signal the formal property is
		// still used
		mapFormalProperties.put(umlConstraint.getQualifiedName(), Boolean.TRUE);

	}

	public void updateUmlFormalProperty(Constraint umlConstraint, String assertionText,
			HashMap<String, FormalProperty> hashFormalProperties, HashMap<String, Boolean> mapFormalProperties) {

		// Update the formal property if needed

		final FormalProperty formalProperty = entityUtil.getFormalProperty(umlConstraint);
		final String formalPropertyText = entityUtil.getFormalPropertyStr(formalProperty);

		// If the expression is different, save it,
		// otherwise go on
		if (!assertionText.equals(formalPropertyText)) {

			hashFormalProperties.remove(formalPropertyText, formalProperty);
			entityUtil.setTextInUMLConstraint(umlConstraint, assertionText);

			hashFormalProperties.put(assertionText, formalProperty);
		}

		// Set the flag to signal the formal property is
		// still used
		mapFormalProperties.put(umlConstraint.getQualifiedName(), Boolean.TRUE);

	}

	public void updateUmlPort(org.eclipse.uml2.uml.Port port, EObject dslVariableType,
			HashMap<String, Boolean> mapPorts) {

		// Update its multiplicity if needed
		final String[] newMultiplicityRange = ossElementsUtil.getMultiplicityBoundariesFromDSLType(dslVariableType);
		final String[] multiplicityRange = entityUtil.getAttributeMultiplicity(port);

		if (entityUtil.equalMultiplicityBoundaries(newMultiplicityRange, multiplicityRange)) {
			entityUtil.setAttributeMultiplicity(newMultiplicityRange);
		}
		// Set the flag to signal the port is still used
		mapPorts.put(port.getQualifiedName(), Boolean.TRUE);
		// continue;

	}

	public void updateUmlPort(org.eclipse.uml2.uml.Port port, Variable dslVariable, EObject dslVariableType,
			Class owner, HashMap<String, Boolean> mapPorts) {

		// Port found, update its direction if needed
		final FlowPort flowPort = (FlowPort) port.getStereotypeApplication(stereotypeUtil.flowPortStereotype);
		if (dslVariable instanceof InputPort && flowPort.getDirection() != FlowDirection.IN) {
			flowPort.setDirection(FlowDirection.IN);
		} else if (dslVariable instanceof OutputPort && flowPort.getDirection() != FlowDirection.OUT) {
			flowPort.setDirection(FlowDirection.OUT);
		}

		// Update its type if needed
		final Type newType = ossElementsUtil.getOrCreateTypeFromOssType(dslVariableType, owner.getNearestPackage());
		if (!port.getType().getName().equals(newType.getName())) {
			port.setType(newType);
		}

		// Update its multiplicity if needed
		final String[] newMultiplicityRange = ossElementsUtil.getMultiplicityBoundariesFromDSLType(dslVariableType);
		final String[] multiplicityRange = entityUtil.getAttributeMultiplicity(port);

		if (entityUtil.equalMultiplicityBoundaries(newMultiplicityRange, multiplicityRange)) {
			entityUtil.setAttributeMultiplicity(newMultiplicityRange);
		}

		// Set the flag to signal the port is still used
		mapPorts.put(port.getQualifiedName(), Boolean.TRUE);

		// Add the port to the list of changes NOT NEEDED BECAUSE
		// DIAGRAMS ARE AUTO-UPDATING
		// addedElements.add(port);

	}

	public void updateUmlFunctionBehaviour(FunctionBehavior functionBehavior, EObject dslVariableType,
			EList<SimpleType> parameters, HashMap<String, Boolean> mapFunctionBehaviors) {

		// Get all the existing parameters of the functionBehavior
		final EList<org.eclipse.uml2.uml.Parameter> existingFunctionBehaviorParameters = functionBehavior
				.getOwnedParameters();

		// Stategy here is a little different. Remove all the parameters
		// and add them from scratch

		final EList<org.eclipse.uml2.uml.Parameter> toRemoveFunctionBehaviorParameters = new BasicEList<org.eclipse.uml2.uml.Parameter>(
				existingFunctionBehaviorParameters);

		// Remove all the existing parameters
		for (org.eclipse.uml2.uml.Parameter parameter : toRemoveFunctionBehaviorParameters) {
			entityUtil.removeFunctionBehaviorParameter(existingFunctionBehaviorParameters,
					parameter.getQualifiedName());
		}

		// Create the input parameters
		for (SimpleType parameterType : parameters) {
			chessElementsUtil.createUmlFunctionBehaviorParameter(functionBehavior, parameterType, true);
		}

		// Create the output parameter
		chessElementsUtil.createUmlFunctionBehaviorParameter(functionBehavior, dslVariableType, false);

		// Old code that tries to solve it in a different manner
		// // Prepare the map to mark existing parameters
		// final HashMap<String, Boolean> mapFunctionBehaviorParameters
		// =
		// Maps.newHashMapWithExpectedSize(existingFunctionBehaviorParameters.size());
		// for (org.eclipse.uml2.uml.Parameter parameter :
		// existingFunctionBehaviorParameters) {
		// mapFunctionBehaviorParameters.put(parameter.getQualifiedName(),
		// null);
		// }
		//
		// org.eclipse.uml2.uml.Parameter parameter = null;
		//
		// // Check the input parameters
		// for (SimpleType parameterType : parameters) {
		// if ((parameter =
		// chessElementsUtil.getExistingFunctionBehaviorParameter(existingFunctionBehaviorParameters,
		// parameterType, true)) != null) {
		// mapFunctionBehaviorParameters.put(parameter.getQualifiedName(),
		// Boolean.TRUE);
		// logger.debug("functionBehavior input parameter already
		// present");
		// } else {
		// logger.debug("functionBehavior input parameter is not
		// present");
		//
		// // Create the input parameter
		// chessElementsUtil.createFunctionBehaviorParameter(functionBehavior,
		// parameterType, true);
		// }
		// }
		//
		// // Check the output parameter
		// if ((parameter =
		// chessElementsUtil.getExistingFunctionBehaviorParameter(existingFunctionBehaviorParameters,
		// dslVariableType, false)) != null) {
		// logger.debug("functionBehavior output parameter already
		// present");
		// mapFunctionBehaviorParameters.put(parameter.getQualifiedName(),
		// Boolean.TRUE);
		// } else {
		// logger.debug("functionBehavior output parameter is not
		// present");
		//
		// // Create the output parameter
		// chessElementsUtil.createFunctionBehaviorParameter(functionBehavior,
		// dslVariableType, false);
		// }
		//
		// // Parameters cleanup time
		// for (String qualifiedElement :
		// mapFunctionBehaviorParameters.keySet()) {
		// if (mapFunctionBehaviorParameters.get(qualifiedElement) ==
		// null) {
		// System.out.println("functionBehaviorParameter " +
		// qualifiedElement + " should be removed");
		// chessElementsUtil.removeFunctionBehaviorParameter(existingFunctionBehaviorParameters,
		// qualifiedElement);
		// }
		// }

		// Set the flag to signal the functionBehavior is still used
		mapFunctionBehaviors.put(functionBehavior.getQualifiedName(), Boolean.TRUE);

	}

}
