/*******************************************************************************
 *  * Copyright (c) 2015 University of Padova, Intecs
 *  *
 *  *    
 *  * All rights reserved. This program and the accompanying materials
 *  * are made available under the terms of the Eclipse Public License v1.0
 *  * which accompanies this distribution, and is available at
 *  * http://www.eclipse.org/legal/epl-v10.html
 *  *
 *******************************************************************************/
/**
 */
package org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Recovery Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatsPropagationPackage#getRecoveryKind()
 * @model
 * @generated
 */
public enum RecoveryKind implements Enumerator {
	/**
	 * The '<em><b>Repair</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REPAIR_VALUE
	 * @generated
	 * @ordered
	 */
	REPAIR(0, "Repair", "Repair"),

	/**
	 * The '<em><b>Compensation</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMPENSATION_VALUE
	 * @generated
	 * @ordered
	 */
	COMPENSATION(1, "Compensation", "Compensation"),

	/**
	 * The '<em><b>Error Detection</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ERROR_DETECTION_VALUE
	 * @generated
	 * @ordered
	 */
	ERROR_DETECTION(2, "ErrorDetection", "ErrorDetection"),

	/**
	 * The '<em><b>Reconfiguration</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RECONFIGURATION_VALUE
	 * @generated
	 * @ordered
	 */
	RECONFIGURATION(3, "Reconfiguration", "Reconfiguration");

	/**
	 * The '<em><b>Repair</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Repair</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REPAIR
	 * @model name="Repair"
	 * @generated
	 * @ordered
	 */
	public static final int REPAIR_VALUE = 0;

	/**
	 * The '<em><b>Compensation</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Compensation</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COMPENSATION
	 * @model name="Compensation"
	 * @generated
	 * @ordered
	 */
	public static final int COMPENSATION_VALUE = 1;

	/**
	 * The '<em><b>Error Detection</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Error Detection</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ERROR_DETECTION
	 * @model name="ErrorDetection"
	 * @generated
	 * @ordered
	 */
	public static final int ERROR_DETECTION_VALUE = 2;

	/**
	 * The '<em><b>Reconfiguration</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Reconfiguration</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RECONFIGURATION
	 * @model name="Reconfiguration"
	 * @generated
	 * @ordered
	 */
	public static final int RECONFIGURATION_VALUE = 3;

	/**
	 * An array of all the '<em><b>Recovery Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final RecoveryKind[] VALUES_ARRAY =
		new RecoveryKind[] {
			REPAIR,
			COMPENSATION,
			ERROR_DETECTION,
			RECONFIGURATION,
		};

	/**
	 * A public read-only list of all the '<em><b>Recovery Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<RecoveryKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Recovery Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static RecoveryKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RecoveryKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Recovery Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static RecoveryKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RecoveryKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Recovery Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static RecoveryKind get(int value) {
		switch (value) {
			case REPAIR_VALUE: return REPAIR;
			case COMPENSATION_VALUE: return COMPENSATION;
			case ERROR_DETECTION_VALUE: return ERROR_DETECTION;
			case RECONFIGURATION_VALUE: return RECONFIGURATION;
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
	private RecoveryKind(int value, String name, String literal) {
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
	
} //RecoveryKind
