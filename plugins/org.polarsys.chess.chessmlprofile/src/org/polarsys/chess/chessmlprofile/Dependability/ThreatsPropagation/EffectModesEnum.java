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
package org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Effect Modes Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatsPropagationPackage#getEffectModesEnum()
 * @model
 * @generated
 */
public enum EffectModesEnum implements Enumerator {
	/**
	 * The '<em><b>Stuck At</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STUCK_AT_VALUE
	 * @generated
	 * @ordered
	 */
	STUCK_AT(0, "StuckAt", "StuckAt"),

	/**
	 * The '<em><b>Stuck At Fixed</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STUCK_AT_FIXED_VALUE
	 * @generated
	 * @ordered
	 */
	STUCK_AT_FIXED(1, "StuckAtFixed", "StuckAtFixed"),

	/**
	 * The '<em><b>Inverted</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INVERTED_VALUE
	 * @generated
	 * @ordered
	 */
	INVERTED(2, "Inverted", "Inverted"),

	/**
	 * The '<em><b>Ramp Down</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RAMP_DOWN_VALUE
	 * @generated
	 * @ordered
	 */
	RAMP_DOWN(3, "RampDown", "RampDown");

	/**
	 * The '<em><b>Stuck At</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Stuck At</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STUCK_AT
	 * @model name="StuckAt"
	 * @generated
	 * @ordered
	 */
	public static final int STUCK_AT_VALUE = 0;

	/**
	 * The '<em><b>Stuck At Fixed</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Stuck At Fixed</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STUCK_AT_FIXED
	 * @model name="StuckAtFixed"
	 * @generated
	 * @ordered
	 */
	public static final int STUCK_AT_FIXED_VALUE = 1;

	/**
	 * The '<em><b>Inverted</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Inverted</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INVERTED
	 * @model name="Inverted"
	 * @generated
	 * @ordered
	 */
	public static final int INVERTED_VALUE = 2;

	/**
	 * The '<em><b>Ramp Down</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Ramp Down</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RAMP_DOWN
	 * @model name="RampDown"
	 * @generated
	 * @ordered
	 */
	public static final int RAMP_DOWN_VALUE = 3;

	/**
	 * An array of all the '<em><b>Effect Modes Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EffectModesEnum[] VALUES_ARRAY =
		new EffectModesEnum[] {
			STUCK_AT,
			STUCK_AT_FIXED,
			INVERTED,
			RAMP_DOWN,
		};

	/**
	 * A public read-only list of all the '<em><b>Effect Modes Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EffectModesEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Effect Modes Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EffectModesEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EffectModesEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Effect Modes Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EffectModesEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EffectModesEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Effect Modes Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EffectModesEnum get(int value) {
		switch (value) {
			case STUCK_AT_VALUE: return STUCK_AT;
			case STUCK_AT_FIXED_VALUE: return STUCK_AT_FIXED;
			case INVERTED_VALUE: return INVERTED;
			case RAMP_DOWN_VALUE: return RAMP_DOWN;
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
	private EffectModesEnum(int value, String name, String literal) {
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
	
} //EffectModesEnum
