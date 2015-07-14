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
package org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Basic Operation</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.HardwareBaselinePackage#getBasicOperation()
 * @model
 * @generated
 */
public enum BasicOperation implements Enumerator {
	/**
	 * The '<em><b>Add</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADD_VALUE
	 * @generated
	 * @ordered
	 */
	ADD(0, "add", "add"),

	/**
	 * The '<em><b>Mul</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MUL_VALUE
	 * @generated
	 * @ordered
	 */
	MUL(1, "mul", "mul"),

	/**
	 * The '<em><b>Div</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIV_VALUE
	 * @generated
	 * @ordered
	 */
	DIV(2, "div", "div"),

	/**
	 * The '<em><b>Mod</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOD_VALUE
	 * @generated
	 * @ordered
	 */
	MOD(3, "mod", "mod"),

	/**
	 * The '<em><b>Shift</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SHIFT_VALUE
	 * @generated
	 * @ordered
	 */
	SHIFT(4, "shift", "shift");

	/**
	 * The '<em><b>Add</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Add</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADD
	 * @model name="add"
	 * @generated
	 * @ordered
	 */
	public static final int ADD_VALUE = 0;

	/**
	 * The '<em><b>Mul</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Mul</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MUL
	 * @model name="mul"
	 * @generated
	 * @ordered
	 */
	public static final int MUL_VALUE = 1;

	/**
	 * The '<em><b>Div</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Div</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DIV
	 * @model name="div"
	 * @generated
	 * @ordered
	 */
	public static final int DIV_VALUE = 2;

	/**
	 * The '<em><b>Mod</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Mod</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MOD
	 * @model name="mod"
	 * @generated
	 * @ordered
	 */
	public static final int MOD_VALUE = 3;

	/**
	 * The '<em><b>Shift</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Shift</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SHIFT
	 * @model name="shift"
	 * @generated
	 * @ordered
	 */
	public static final int SHIFT_VALUE = 4;

	/**
	 * An array of all the '<em><b>Basic Operation</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final BasicOperation[] VALUES_ARRAY =
		new BasicOperation[] {
			ADD,
			MUL,
			DIV,
			MOD,
			SHIFT,
		};

	/**
	 * A public read-only list of all the '<em><b>Basic Operation</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<BasicOperation> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Basic Operation</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BasicOperation get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			BasicOperation result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Basic Operation</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BasicOperation getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			BasicOperation result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Basic Operation</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BasicOperation get(int value) {
		switch (value) {
			case ADD_VALUE: return ADD;
			case MUL_VALUE: return MUL;
			case DIV_VALUE: return DIV;
			case MOD_VALUE: return MOD;
			case SHIFT_VALUE: return SHIFT;
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
	private BasicOperation(int value, String name, String literal) {
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
	
} //BasicOperation
