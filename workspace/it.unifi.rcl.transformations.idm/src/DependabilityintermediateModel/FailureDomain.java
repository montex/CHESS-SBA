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
 * A representation of the literals of the enumeration '<em><b>Failure Domain</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getFailureDomain()
 * @model
 * @generated
 */
public enum FailureDomain implements Enumerator {
	/**
	 * The '<em><b>Content</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTENT_VALUE
	 * @generated
	 * @ordered
	 */
	CONTENT(0, "Content", "Content"),

	/**
	 * The '<em><b>Early Timing</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EARLY_TIMING_VALUE
	 * @generated
	 * @ordered
	 */
	EARLY_TIMING(1, "EarlyTiming", "EarlyTiming"),

	/**
	 * The '<em><b>Late Timing</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LATE_TIMING_VALUE
	 * @generated
	 * @ordered
	 */
	LATE_TIMING(2, "LateTiming", "LateTiming"),

	/**
	 * The '<em><b>Halt</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HALT_VALUE
	 * @generated
	 * @ordered
	 */
	HALT(3, "Halt", "Halt"),

	/**
	 * The '<em><b>Erratic</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ERRATIC_VALUE
	 * @generated
	 * @ordered
	 */
	ERRATIC(4, "Erratic", "Erratic");

	/**
	 * The '<em><b>Content</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Content</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONTENT
	 * @model name="Content"
	 * @generated
	 * @ordered
	 */
	public static final int CONTENT_VALUE = 0;

	/**
	 * The '<em><b>Early Timing</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Early Timing</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EARLY_TIMING
	 * @model name="EarlyTiming"
	 * @generated
	 * @ordered
	 */
	public static final int EARLY_TIMING_VALUE = 1;

	/**
	 * The '<em><b>Late Timing</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Late Timing</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LATE_TIMING
	 * @model name="LateTiming"
	 * @generated
	 * @ordered
	 */
	public static final int LATE_TIMING_VALUE = 2;

	/**
	 * The '<em><b>Halt</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Halt</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HALT
	 * @model name="Halt"
	 * @generated
	 * @ordered
	 */
	public static final int HALT_VALUE = 3;

	/**
	 * The '<em><b>Erratic</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Erratic</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ERRATIC
	 * @model name="Erratic"
	 * @generated
	 * @ordered
	 */
	public static final int ERRATIC_VALUE = 4;

	/**
	 * An array of all the '<em><b>Failure Domain</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final FailureDomain[] VALUES_ARRAY =
		new FailureDomain[] {
			CONTENT,
			EARLY_TIMING,
			LATE_TIMING,
			HALT,
			ERRATIC,
		};

	/**
	 * A public read-only list of all the '<em><b>Failure Domain</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<FailureDomain> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Failure Domain</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FailureDomain get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FailureDomain result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Failure Domain</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FailureDomain getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FailureDomain result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Failure Domain</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FailureDomain get(int value) {
		switch (value) {
			case CONTENT_VALUE: return CONTENT;
			case EARLY_TIMING_VALUE: return EARLY_TIMING;
			case LATE_TIMING_VALUE: return LATE_TIMING;
			case HALT_VALUE: return HALT;
			case ERRATIC_VALUE: return ERRATIC;
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
	private FailureDomain(int value, String name, String literal) {
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
	
} //FailureDomain
