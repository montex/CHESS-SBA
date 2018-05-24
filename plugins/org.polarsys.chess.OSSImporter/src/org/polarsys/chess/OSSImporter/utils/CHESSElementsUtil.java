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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.FunctionBehavior;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Type;
import org.polarsys.chess.OSSImporter.exceptions.ImportException;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;
import org.polarsys.chess.contracts.profile.chesscontract.util.TypeUtil;
import eu.fbk.tools.editor.basetype.baseType.BooleanType;
import eu.fbk.tools.editor.basetype.baseType.BoundedArrayType;
import eu.fbk.tools.editor.basetype.baseType.ContinuousType;
import eu.fbk.tools.editor.basetype.baseType.EnumType;
import eu.fbk.tools.editor.basetype.baseType.EventType;
import eu.fbk.tools.editor.basetype.baseType.Expression;
import eu.fbk.tools.editor.basetype.baseType.FixedSizeArrayType;
import eu.fbk.tools.editor.basetype.baseType.Identifier;
import eu.fbk.tools.editor.basetype.baseType.IntegerLiteral;
import eu.fbk.tools.editor.basetype.baseType.IntegerType;
import eu.fbk.tools.editor.basetype.baseType.RangeType;
import eu.fbk.tools.editor.basetype.baseType.RealType;
import eu.fbk.tools.editor.basetype.baseType.SignedWordType;
import eu.fbk.tools.editor.basetype.baseType.SimpleType;
import eu.fbk.tools.editor.basetype.baseType.UnboundedArrayType;
import eu.fbk.tools.editor.basetype.baseType.UnsignedWordType;
import eu.fbk.tools.editor.basetype.baseType.WordArrayType;
import eu.fbk.tools.editor.basetype.baseType.WordType;
import eu.fbk.tools.editor.contract.contract.Contract;
import eu.fbk.tools.editor.contract.expression.expression.PortId;
import eu.fbk.tools.editor.contract.expression.expression.VariableId;
import eu.fbk.tools.editor.oss.oss.ParameterizedArrayType;
import eu.fbk.tools.editor.oss.oss.SubComponent;

/**
 * A class that contains some utility methods to create CHESS elements.
 * 
 * @author cristofo
 *
 */
public class CHESSElementsUtil {

	// The instance of this class
	private static CHESSElementsUtil classInstance;

	private final TypeUtil typeUtil = TypeUtil.getInstance();
	private final EntityUtil entityUtil = EntityUtil.getInstance();

	// Logger for messages
	private static final Logger logger = Logger.getLogger(CHESSElementsUtil.class);

	private static final String DELEGATION_PREFIX = "Define_";

	// private static final String DELETE_COMMAND_ID =
	// "org.eclipse.ui.edit.delete";
	// private static final String MODELEXPLORER_VIEW_ID =
	// "org.eclipse.papyrus.views.modelexplorer.modelexplorer";

	//private final Injector injector = XTextResourceUtil.getInstance().getOssInjector();
	//private final ISerializer serializer = injector.getInstance(ISerializer.class);

	/**
	 * Gets an instance of the class if already present, or a new one if not.
	 * 
	 * @return the instance of this class
	 */
	public static CHESSElementsUtil getInstance() {
		if (classInstance == null) {
			classInstance = new CHESSElementsUtil();
		}
		return classInstance;
	}

	/**
	 * Returns the correct Type given the DSL SimpleType.
	 * 
	 * @param dslType
	 *            the type from OSS
	 * @param pkg
	 *            the package where the types could be
	 * @return the UML Type
	 */
	public Type getTypeFromDSLType(EObject dslType, Package pkg) {

		if (dslType instanceof BooleanType) {
			logger.debug("BooleanType");
			return typeUtil.getPrimitiveType("Boolean");
		} else if (dslType instanceof IntegerType) {
			logger.debug("IntegerType");
			return typeUtil.getPrimitiveType("Integer");
		} else if (dslType instanceof RealType) {
			logger.debug("RealType");
			return typeUtil.getPrimitiveType("Real");
		} else if (dslType instanceof WordType) {
			logger.debug("WordType");
		} else if (dslType instanceof UnsignedWordType) {
			logger.debug("UnsignedWordType");
		} else if (dslType instanceof SignedWordType) {
			logger.debug("SignedWordType");
		} else if (dslType instanceof ContinuousType) {
			logger.debug("ContinuousType");
			return typeUtil.getContinuousType("Continuous");
		} else if (dslType instanceof EventType) {
			logger.debug("EventType");
			return typeUtil.getOrCreateSignalType(pkg);
		} else if (dslType instanceof RangeType) {
			logger.debug("RangeType");
			return getOrCreateBoundedSubType((RangeType) dslType, pkg);
		} else if (dslType instanceof EnumType) {
			logger.debug("EnumType");
			return getOrCreateEnumerationType((EnumType) dslType, pkg);
		} else if (dslType instanceof FixedSizeArrayType) {
			logger.debug("FixedSizeArrayType");
			return getTypeFromDSLType(((FixedSizeArrayType) dslType).getType(), pkg);
		} else if (dslType instanceof BoundedArrayType) {
			logger.debug("BoundedArrayType");
			return getTypeFromDSLType(((BoundedArrayType) dslType).getType(), pkg);
		} else if (dslType instanceof UnboundedArrayType) {
			logger.debug("UnboundedArrayType");
			return getTypeFromDSLType(((UnboundedArrayType) dslType).getType(), pkg);
		} else if (dslType instanceof WordArrayType) {
			logger.debug("WordArrayType");
		} else if (dslType instanceof ParameterizedArrayType) {
			return getTypeFromDSLType(((ParameterizedArrayType) dslType).getType(), pkg);
		}
		logger.error("Not able to map the requested DSL type!");
		return null;
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
	public org.eclipse.uml2.uml.Port createNonStaticPort(Class owner, VariableId elementName, EObject elementType,
			boolean isInput) throws ImportException {
		final String portName = elementName.getName();
		final Type portType = getTypeFromDSLType(elementType, owner.getNearestPackage());
		final String[] multiplicityBounds = getMultiplicityBoundariesFromDSLType(elementType);

		if (portType == null) {
			throw new ImportException("Not able to map the requested type for port : " + portName);
			// return null; // Create the port anyway, without type
		}

		org.eclipse.uml2.uml.Port umlPort = entityUtil.createNonStaticPort(owner, portName, portType,
				multiplicityBounds, isInput);

		logger.debug("\n\nCreated " + portName + " Port\n\n");
		return umlPort;
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
	public org.eclipse.uml2.uml.Port createStaticPort(Class owner, VariableId elementName, EObject elementType)
			throws ImportException {
		final String portName = elementName.getName();
		final Type portType = getTypeFromDSLType(elementType, owner.getNearestPackage());
		final String[] multiplicityBounds = getMultiplicityBoundariesFromDSLType(elementType);

		if (portType == null) {
			throw new ImportException("Not able to map the requested type for port : " + portName);
		}

		org.eclipse.uml2.uml.Port umlPort = entityUtil.createStaticPort(owner, portName, portType, multiplicityBounds);
		logger.debug("\n\nCreated " + portName + " Port\n\n");

		return umlPort;
	}

	/**
	 * Returns a name for the ContractProperty, deriving it from the Contract
	 * type.
	 * 
	 * @param contract
	 *            the contract from which it derives
	 * @return a derived name, going lowercase
	 */
	public String deriveContractPropertyNameFromContract(Class contract) {
		final String contractName = contract.getName();

		if (contractName.length() > 0) {
			return contractName.toLowerCase();
		} else {
			return ((Contract) contract).getName().toLowerCase();
		}
	}

	/**
	 * Returns the number or defined associations for the given package.
	 * 
	 * @param pkg
	 *            the package to analyze
	 * @return the number of associations found in package
	 */
	public int countPackageAssociations(Package pkg) {
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
	 * Gets the expression string from the Expression constraint.
	 * 
	 * @param constraint
	 *            the expression to convert
	 *//*
	public String getConstraintText(Expression constraint) {
		final String text = serializer.serialize(constraint);

		return text.trim();
	}*/

	/**
	 * Creates the Delegation Constraint value.
	 * 
	 * @param variable
	 *            the left part of the expression
	 * @param constraint
	 *            the right part of the expression
	 * @return a string with the expression
	 *//*
		 * private String createDelegationConstraintText(VariableId variable,
		 * Expression constraint) {
		 * 
		 * final String variableName = variable.getName(); final EList<String>
		 * componentNames = variable.getComponentNames(); String constraintText
		 * = getConstraintText(constraint);
		 * 
		 * return createDelegationConstraintText(variableName, componentNames,
		 * constraintText); }
		 */
	

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
	public Constraint createDelegationConstraint(Class owner, VariableId variable, String constraintText) {

		final String variableName = variable.getName();
		//String constraintText = getConstraintText(constraint);

		final StringBuffer delegationName = new StringBuffer(DELEGATION_PREFIX);
		final EList<String> componentNames = variable.getComponentNames();

		String prefixSubComponentName = null;
		if (componentNames != null && componentNames.size() != 0) {
			prefixSubComponentName= (componentNames.get(0) + ".");
			delegationName.append(prefixSubComponentName);
		}

		delegationName.append(variableName);

		return entityUtil.createDelegationConstraint(owner, delegationName.toString(), variableName, prefixSubComponentName, constraintText);
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
	public Parameter createFunctionBehaviorParameter(FunctionBehavior owner, EObject type, boolean isInput) {
		final Type parameterType = getTypeFromDSLType(type, owner.getNearestPackage());
		return entityUtil.createFunctionBehaviorParameter(owner, parameterType, isInput);
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
			if (parameter.getType() == getTypeFromDSLType(type, parameter.getNearestPackage())) {
				if ((isInput && parameter.getDirection() == ParameterDirectionKind.IN_LITERAL)
						|| (!isInput && parameter.getDirection() == ParameterDirectionKind.OUT_LITERAL)) {
					return parameter;
				}
			}
		}
		return null;
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
	public Connector getExistingConnector(EList<Connector> connectors, VariableId variable, Expression constraint) {

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

		return entityUtil.getExistingConnector(connectors, variablePortOwner, variablePortName, constraintPortOwner, constraintPortName);
	}
	
	
	public String[] getMultiplicityBoundariesFromDSLType(EObject elementType) {
		// TODO Auto-generated method stub
		return null;
	}
	
		
	public String[] getMultiplicityBoundariesFromOssSubComponent(SubComponent subComponent) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	
	/**
	 * Returns a BoundedSubType as requested.
	 * @param rangeType the type containing the specifications
	 * @param pkg the package in which the type should be created
	 * @return the requested type
	 */
	public Type getOrCreateBoundedSubType(RangeType rangeType, Package pkg) {	
				
		Integer[] boundaries = getBoundariesForBoundedSubType(rangeType);
		int lowerBound = boundaries[0];
		int upperBound = boundaries[1];
		// Generate a suitable type name
		final String typeName = "BoundedInteger_" + lowerBound + "_" + upperBound; 
		
		return typeUtil.getOrCreateBoundedSubType(typeName, pkg, lowerBound, upperBound);
	}
	
	
	
	private Integer[] getBoundariesForBoundedSubType(RangeType rangeType) {
		
		Integer[] boundaries = new Integer[2];
		
		// Check to see if boundaries are integer values and extract them
		if (rangeType.getLowerBound() instanceof IntegerLiteral && rangeType.getUpperBound() instanceof IntegerLiteral) {
			IntegerLiteral intLit = (IntegerLiteral) rangeType.getLowerBound();
			boundaries[0] = Integer.parseInt(intLit.getValue());
			intLit = (IntegerLiteral) rangeType.getUpperBound();
			boundaries[1] = Integer.parseInt(intLit.getValue());
		} else {
			logger.error("Cannot understand the Bounded type limits! " + rangeType);
			return null;
		}
		return boundaries;
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
	 * Returns an Enumeration as requested.
	 * @param enumType the type containing the specifications
	 * @param pkg the package where to look for or create the new type
	 * @return the requested type
	 */
	public Type getOrCreateEnumerationType(EnumType enumType, Package pkg) {

		final Set<String> enumValues = getListValuesForEnumType(enumType);
		return typeUtil.getOrCreateEnumerationType(enumValues, pkg);
	}
}
