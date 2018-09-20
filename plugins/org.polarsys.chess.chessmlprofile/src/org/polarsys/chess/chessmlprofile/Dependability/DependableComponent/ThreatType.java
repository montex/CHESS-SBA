/**
 */
package org.polarsys.chess.chessmlprofile.Dependability.DependableComponent;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Threat Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponentPackage#getThreatType()
 * @model
 * @generated
 */
public enum ThreatType implements Enumerator {
	/**
	 * The '<em><b>Unauthorized Access Of Service</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNAUTHORIZED_ACCESS_OF_SERVICE_VALUE
	 * @generated
	 * @ordered
	 */
	UNAUTHORIZED_ACCESS_OF_SERVICE(0, "unauthorizedAccessOfService", "unauthorizedAccessOfService"),

	/**
	 * The '<em><b>Unauthorized Modification Of Service</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNAUTHORIZED_MODIFICATION_OF_SERVICE_VALUE
	 * @generated
	 * @ordered
	 */
	UNAUTHORIZED_MODIFICATION_OF_SERVICE(1, "unauthorizedModificationOfService", "unauthorizedModificationOfService"),

	/**
	 * The '<em><b>Unauthorized Denial Of Service</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNAUTHORIZED_DENIAL_OF_SERVICE_VALUE
	 * @generated
	 * @ordered
	 */
	UNAUTHORIZED_DENIAL_OF_SERVICE(2, "unauthorizedDenialOfService", "unauthorizedDenialOfService");

	/**
	 * The '<em><b>Unauthorized Access Of Service</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Unauthorized Access Of Service</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNAUTHORIZED_ACCESS_OF_SERVICE
	 * @model name="unauthorizedAccessOfService"
	 * @generated
	 * @ordered
	 */
	public static final int UNAUTHORIZED_ACCESS_OF_SERVICE_VALUE = 0;

	/**
	 * The '<em><b>Unauthorized Modification Of Service</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Unauthorized Modification Of Service</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNAUTHORIZED_MODIFICATION_OF_SERVICE
	 * @model name="unauthorizedModificationOfService"
	 * @generated
	 * @ordered
	 */
	public static final int UNAUTHORIZED_MODIFICATION_OF_SERVICE_VALUE = 1;

	/**
	 * The '<em><b>Unauthorized Denial Of Service</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Unauthorized Denial Of Service</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNAUTHORIZED_DENIAL_OF_SERVICE
	 * @model name="unauthorizedDenialOfService"
	 * @generated
	 * @ordered
	 */
	public static final int UNAUTHORIZED_DENIAL_OF_SERVICE_VALUE = 2;

	/**
	 * An array of all the '<em><b>Threat Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ThreatType[] VALUES_ARRAY =
		new ThreatType[] {
			UNAUTHORIZED_ACCESS_OF_SERVICE,
			UNAUTHORIZED_MODIFICATION_OF_SERVICE,
			UNAUTHORIZED_DENIAL_OF_SERVICE,
		};

	/**
	 * A public read-only list of all the '<em><b>Threat Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ThreatType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Threat Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ThreatType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ThreatType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Threat Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ThreatType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ThreatType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Threat Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ThreatType get(int value) {
		switch (value) {
			case UNAUTHORIZED_ACCESS_OF_SERVICE_VALUE: return UNAUTHORIZED_ACCESS_OF_SERVICE;
			case UNAUTHORIZED_MODIFICATION_OF_SERVICE_VALUE: return UNAUTHORIZED_MODIFICATION_OF_SERVICE;
			case UNAUTHORIZED_DENIAL_OF_SERVICE_VALUE: return UNAUTHORIZED_DENIAL_OF_SERVICE;
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
	private ThreatType(int value, String name, String literal) {
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
	
} //ThreatType
