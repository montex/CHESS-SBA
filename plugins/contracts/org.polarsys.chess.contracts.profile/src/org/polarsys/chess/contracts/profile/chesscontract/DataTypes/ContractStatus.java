/**
 */
package org.polarsys.chess.contracts.profile.chesscontract.DataTypes;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration
 * '<em><b>Contract Status</b></em>', and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.DataTypesPackage#getContractStatus()
 * @model
 * @generated
 */
public enum ContractStatus implements Enumerator {
	/**
	 * The '<em><b>Not Validated</b></em>' literal object.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #NOT_VALIDATED_VALUE
	 * @generated
	 * @ordered
	 */
	NOT_VALIDATED(0, "notValidated", "notValidated"),

	/**
	 * The '<em><b>Validated</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VALIDATED_VALUE
	 * @generated
	 * @ordered
	 */
	VALIDATED(1, "validated", "validated"),

	/**
	 * The '<em><b>Needs Runtime Support</b></em>' literal object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #NEEDS_RUNTIME_SUPPORT_VALUE
	 * @generated
	 * @ordered
	 */
	NEEDS_RUNTIME_SUPPORT(2, "needsRuntimeSupport", "needsRuntimeSupport");

	/**
	 * The '<em><b>Not Validated</b></em>' literal value.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of '<em><b>Not Validated</b></em>' literal object isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NOT_VALIDATED
	 * @model name="notValidated"
	 * @generated
	 * @ordered
	 */
	public static final int NOT_VALIDATED_VALUE = 0;

	/**
	 * The '<em><b>Validated</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Validated</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VALIDATED
	 * @model name="validated"
	 * @generated
	 * @ordered
	 */
	public static final int VALIDATED_VALUE = 1;

	/**
	 * The '<em><b>Needs Runtime Support</b></em>' literal value. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Needs Runtime Support</b></em>' literal object
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #NEEDS_RUNTIME_SUPPORT
	 * @model name="needsRuntimeSupport"
	 * @generated
	 * @ordered
	 */
	public static final int NEEDS_RUNTIME_SUPPORT_VALUE = 2;

	/**
	 * An array of all the '<em><b>Contract Status</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final ContractStatus[] VALUES_ARRAY = new ContractStatus[] {
			NOT_VALIDATED,
			VALIDATED,
			NEEDS_RUNTIME_SUPPORT,
		};

	/**
	 * A public read-only list of all the '<em><b>Contract Status</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ContractStatus> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Contract Status</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ContractStatus get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ContractStatus result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Contract Status</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ContractStatus getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ContractStatus result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Contract Status</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ContractStatus get(int value) {
		switch (value) {
			case NOT_VALIDATED_VALUE: return NOT_VALIDATED;
			case VALIDATED_VALUE: return VALIDATED;
			case NEEDS_RUNTIME_SUPPORT_VALUE: return NEEDS_RUNTIME_SUPPORT;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	private ContractStatus(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

} // ContractStatus
