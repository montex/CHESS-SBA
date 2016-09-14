/*******************************************************************************
 *                  CHESS core plugin
 *
 *               Copyright (C) 2011-2015
 *            Mälardalen University, Sweden
 *
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License
 *  v1.0 which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
/**
 */
package org.polarsys.chess.fla.flaxml;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Failure Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.polarsys.chess.fla.flaxml.FlaxmlPackage#getFailureType()
 * @model extendedMetaData="name='failureType'"
 * @generated
 */
public enum FailureType implements Enumerator {
	/**
	 * The '<em><b>No Failure</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NO_FAILURE_VALUE
	 * @generated
	 * @ordered
	 */
	NO_FAILURE(0, "noFailure", "noFailure"),

	/**
	 * The '<em><b>Late</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LATE_VALUE
	 * @generated
	 * @ordered
	 */
	LATE(1, "late", "late"),

	/**
	 * The '<em><b>Early</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EARLY_VALUE
	 * @generated
	 * @ordered
	 */
	EARLY(2, "early", "early"),

	/**
	 * The '<em><b>Value Subtle</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VALUE_SUBTLE_VALUE
	 * @generated
	 * @ordered
	 */
	VALUE_SUBTLE(3, "valueSubtle", "valueSubtle"),

	/**
	 * The '<em><b>Value Coarse</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VALUE_COARSE_VALUE
	 * @generated
	 * @ordered
	 */
	VALUE_COARSE(4, "valueCoarse", "valueCoarse"),

	/**
	 * The '<em><b>Omission</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OMISSION_VALUE
	 * @generated
	 * @ordered
	 */
	OMISSION(5, "omission", "omission"),

	/**
	 * The '<em><b>Commission</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMMISSION_VALUE
	 * @generated
	 * @ordered
	 */
	COMMISSION(6, "commission", "commission");

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
	public static final int NO_FAILURE_VALUE = 0;

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
	public static final int LATE_VALUE = 1;

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
	public static final int EARLY_VALUE = 2;

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
	public static final int VALUE_SUBTLE_VALUE = 3;

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
	public static final int VALUE_COARSE_VALUE = 4;

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
	public static final int OMISSION_VALUE = 5;

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
	public static final int COMMISSION_VALUE = 6;

	/**
	 * An array of all the '<em><b>Failure Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final FailureType[] VALUES_ARRAY =
		new FailureType[] {
			NO_FAILURE,
			LATE,
			EARLY,
			VALUE_SUBTLE,
			VALUE_COARSE,
			OMISSION,
			COMMISSION,
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
	 * @generated
	 */
	public static FailureType get(int value) {
		switch (value) {
			case NO_FAILURE_VALUE: return NO_FAILURE;
			case LATE_VALUE: return LATE;
			case EARLY_VALUE: return EARLY;
			case VALUE_SUBTLE_VALUE: return VALUE_SUBTLE;
			case VALUE_COARSE_VALUE: return VALUE_COARSE;
			case OMISSION_VALUE: return OMISSION;
			case COMMISSION_VALUE: return COMMISSION;
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
