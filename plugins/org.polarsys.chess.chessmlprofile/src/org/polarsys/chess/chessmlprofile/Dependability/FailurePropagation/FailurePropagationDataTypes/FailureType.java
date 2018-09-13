/*****************************************************************************
 * Copyright (c) 2011 - 2014 University of Padova, Intecs
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *
 *****************************************************************************/
package org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Failure Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * deprecated, use FailureMode
 * <!-- end-model-doc -->
 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.FailurePropagationDataTypesPackage#getFailureType()
 * @model
 * @generated
 */
public enum FailureType implements Enumerator {
	/**
	 * The '<em><b>Late</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LATE_VALUE
	 * @generated
	 * @ordered
	 */
	LATE(0, "late", "late"),

	/**
	 * The '<em><b>Early</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EARLY_VALUE
	 * @generated
	 * @ordered
	 */
	EARLY(1, "early", "early"),

	/**
	 * The '<em><b>Value Subtle</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VALUE_SUBTLE_VALUE
	 * @generated
	 * @ordered
	 */
	VALUE_SUBTLE(2, "valueSubtle", "valueSubtle"),

	/**
	 * The '<em><b>Value Coarse</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VALUE_COARSE_VALUE
	 * @generated
	 * @ordered
	 */
	VALUE_COARSE(3, "valueCoarse", "valueCoarse"),

	/**
	 * The '<em><b>Omission</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OMISSION_VALUE
	 * @generated
	 * @ordered
	 */
	OMISSION(4, "omission", "omission"),

	/**
	 * The '<em><b>Commission</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMMISSION_VALUE
	 * @generated
	 * @ordered
	 */
	COMMISSION(5, "commission", "commission"),

	/**
	 * The '<em><b>No Failure</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NO_FAILURE_VALUE
	 * @generated
	 * @ordered
	 */
	NO_FAILURE(6, "noFailure", "noFailure"),

	/**
	 * The '<em><b>Variable</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VARIABLE_VALUE
	 * @generated
	 * @ordered
	 */
	VARIABLE(7, "variable", "variable"),

	/**
	 * The '<em><b>Wildcard</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WILDCARD_VALUE
	 * @generated
	 * @ordered
	 */
	WILDCARD(8, "wildcard", "wildcard");

	/**
	 * The '<em><b>Late</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Late</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LATE
	 * @model name="late"
	 * @generated
	 * @ordered
	 */
	public static final int LATE_VALUE = 0;

	/**
	 * The '<em><b>Early</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Early</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EARLY
	 * @model name="early"
	 * @generated
	 * @ordered
	 */
	public static final int EARLY_VALUE = 1;

	/**
	 * The '<em><b>Value Subtle</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Value Subtle</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VALUE_SUBTLE
	 * @model name="valueSubtle"
	 * @generated
	 * @ordered
	 */
	public static final int VALUE_SUBTLE_VALUE = 2;

	/**
	 * The '<em><b>Value Coarse</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Value Coarse</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VALUE_COARSE
	 * @model name="valueCoarse"
	 * @generated
	 * @ordered
	 */
	public static final int VALUE_COARSE_VALUE = 3;

	/**
	 * The '<em><b>Omission</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Omission</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OMISSION
	 * @model name="omission"
	 * @generated
	 * @ordered
	 */
	public static final int OMISSION_VALUE = 4;

	/**
	 * The '<em><b>Commission</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Commission</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COMMISSION
	 * @model name="commission"
	 * @generated
	 * @ordered
	 */
	public static final int COMMISSION_VALUE = 5;

	/**
	 * The '<em><b>No Failure</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>No Failure</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NO_FAILURE
	 * @model name="noFailure"
	 * @generated
	 * @ordered
	 */
	public static final int NO_FAILURE_VALUE = 6;

	/**
	 * The '<em><b>Variable</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Variable</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VARIABLE
	 * @model name="variable"
	 * @generated
	 * @ordered
	 */
	public static final int VARIABLE_VALUE = 7;

	/**
	 * The '<em><b>Wildcard</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Wildcard</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WILDCARD
	 * @model name="wildcard"
	 * @generated
	 * @ordered
	 */
	public static final int WILDCARD_VALUE = 8;

	/**
	 * An array of all the '<em><b>Failure Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final FailureType[] VALUES_ARRAY =
		new FailureType[] {
			LATE,
			EARLY,
			VALUE_SUBTLE,
			VALUE_COARSE,
			OMISSION,
			COMMISSION,
			NO_FAILURE,
			VARIABLE,
			WILDCARD,
		};

	/**
	 * A public read-only list of all the '<em><b>Failure Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<FailureType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Failure Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static FailureType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FailureType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Failure Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static FailureType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FailureType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Failure Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static FailureType get(int value) {
		switch (value) {
			case LATE_VALUE: return LATE;
			case EARLY_VALUE: return EARLY;
			case VALUE_SUBTLE_VALUE: return VALUE_SUBTLE;
			case VALUE_COARSE_VALUE: return VALUE_COARSE;
			case OMISSION_VALUE: return OMISSION;
			case COMMISSION_VALUE: return COMMISSION;
			case NO_FAILURE_VALUE: return NO_FAILURE;
			case VARIABLE_VALUE: return VARIABLE;
			case WILDCARD_VALUE: return WILDCARD;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private FailureType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //FailureType
