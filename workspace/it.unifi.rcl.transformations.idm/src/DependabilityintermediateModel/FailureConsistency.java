/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package DependabilityintermediateModel;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Failure Consistency</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getFailureConsistency()
 * @model
 * @generated
 */
public enum FailureConsistency implements Enumerator {
	/**
	 * The '<em><b>Consistent</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONSISTENT_VALUE
	 * @generated
	 * @ordered
	 */
	CONSISTENT(0, "Consistent", "Consistent"),

	/**
	 * The '<em><b>Inconsistent</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INCONSISTENT_VALUE
	 * @generated
	 * @ordered
	 */
	INCONSISTENT(1, "Inconsistent", "Inconsistent");

	/**
	 * The '<em><b>Consistent</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Consistent</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONSISTENT
	 * @model name="Consistent"
	 * @generated
	 * @ordered
	 */
	public static final int CONSISTENT_VALUE = 0;

	/**
	 * The '<em><b>Inconsistent</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Inconsistent</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INCONSISTENT
	 * @model name="Inconsistent"
	 * @generated
	 * @ordered
	 */
	public static final int INCONSISTENT_VALUE = 1;

	/**
	 * An array of all the '<em><b>Failure Consistency</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final FailureConsistency[] VALUES_ARRAY =
		new FailureConsistency[] {
			CONSISTENT,
			INCONSISTENT,
		};

	/**
	 * A public read-only list of all the '<em><b>Failure Consistency</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<FailureConsistency> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Failure Consistency</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FailureConsistency get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FailureConsistency result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Failure Consistency</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FailureConsistency getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FailureConsistency result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Failure Consistency</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FailureConsistency get(int value) {
		switch (value) {
			case CONSISTENT_VALUE: return CONSISTENT;
			case INCONSISTENT_VALUE: return INCONSISTENT;
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
	private FailureConsistency(int value, String name, String literal) {
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
	
} //FailureConsistency
