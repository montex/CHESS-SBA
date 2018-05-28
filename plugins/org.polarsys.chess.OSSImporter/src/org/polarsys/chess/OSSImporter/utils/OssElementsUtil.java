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
public class OssElementsUtil {

	// The instance of this class
	private static OssElementsUtil classInstance;

	private final TypeUtil typeUtil = TypeUtil.getInstance();

	// Logger for messages
	private static final Logger logger = Logger.getLogger(OssElementsUtil.class);

	

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
	public static OssElementsUtil getInstance() {
		if (classInstance == null) {
			classInstance = new OssElementsUtil();
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
	public Type getOrCreateTypeFromOssType(EObject dslType, Package pkg) {

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
			return getOrCreateTypeFromOssType(((FixedSizeArrayType) dslType).getType(), pkg);
		} else if (dslType instanceof BoundedArrayType) {
			logger.debug("BoundedArrayType");
			return getOrCreateTypeFromOssType(((BoundedArrayType) dslType).getType(), pkg);
		} else if (dslType instanceof UnboundedArrayType) {
			logger.debug("UnboundedArrayType");
			return getOrCreateTypeFromOssType(((UnboundedArrayType) dslType).getType(), pkg);
		} else if (dslType instanceof WordArrayType) {
			logger.debug("WordArrayType");
		} else if (dslType instanceof ParameterizedArrayType) {
			return getOrCreateTypeFromOssType(((ParameterizedArrayType) dslType).getType(), pkg);
		}
		logger.error("Not able to map the requested DSL type!");
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
	public String deriveContractPropertyNameFromContract(Class contract) {
		final String contractName = contract.getName();

		if (contractName.length() > 0) {
			return contractName.toLowerCase();
		} else {
			return ((Contract) contract).getName().toLowerCase();
		}
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
