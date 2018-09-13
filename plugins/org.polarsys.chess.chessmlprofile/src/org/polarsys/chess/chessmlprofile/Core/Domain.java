/**
 */
package org.polarsys.chess.chessmlprofile.Core;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Domain</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.polarsys.chess.chessmlprofile.Core.CorePackage#getDomain()
 * @model
 * @generated
 */
public enum Domain implements Enumerator {
	/**
	 * The '<em><b>Cross domain</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CROSS_DOMAIN_VALUE
	 * @generated
	 * @ordered
	 */
	CROSS_DOMAIN(0, "cross_domain", "cross_domain"), /**
	 * The '<em><b>Avionics</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AVIONICS_VALUE
	 * @generated
	 * @ordered
	 */
	AVIONICS(1, "avionics", "avionics"),

	/**
	 * The '<em><b>Automotive</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AUTOMOTIVE_VALUE
	 * @generated
	 * @ordered
	 */
	AUTOMOTIVE(2, "automotive", "automotive"),

	/**
	 * The '<em><b>Telecom</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TELECOM_VALUE
	 * @generated
	 * @ordered
	 */
	TELECOM(3, "telecom", "telecom"),

	/**
	 * The '<em><b>Space</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SPACE_VALUE
	 * @generated
	 * @ordered
	 */
	SPACE(4, "space", "space"),

	/**
	 * The '<em><b>Medical</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MEDICAL_VALUE
	 * @generated
	 * @ordered
	 */
	MEDICAL(5, "medical", "medical"),

	/**
	 * The '<em><b>Petroleum</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PETROLEUM_VALUE
	 * @generated
	 * @ordered
	 */
	PETROLEUM(6, "petroleum", "petroleum");

	/**
	 * The '<em><b>Cross domain</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Cross domain</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CROSS_DOMAIN
	 * @model name="cross_domain"
	 * @generated
	 * @ordered
	 */
	public static final int CROSS_DOMAIN_VALUE = 0;

	/**
	 * The '<em><b>Avionics</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Avionics</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AVIONICS
	 * @model name="avionics"
	 * @generated
	 * @ordered
	 */
	public static final int AVIONICS_VALUE = 1;

	/**
	 * The '<em><b>Automotive</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Automotive</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AUTOMOTIVE
	 * @model name="automotive"
	 * @generated
	 * @ordered
	 */
	public static final int AUTOMOTIVE_VALUE = 2;

	/**
	 * The '<em><b>Telecom</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Telecom</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TELECOM
	 * @model name="telecom"
	 * @generated
	 * @ordered
	 */
	public static final int TELECOM_VALUE = 3;

	/**
	 * The '<em><b>Space</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Space</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SPACE
	 * @model name="space"
	 * @generated
	 * @ordered
	 */
	public static final int SPACE_VALUE = 4;

	/**
	 * The '<em><b>Medical</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Medical</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MEDICAL
	 * @model name="medical"
	 * @generated
	 * @ordered
	 */
	public static final int MEDICAL_VALUE = 5;

	/**
	 * The '<em><b>Petroleum</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Petroleum</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PETROLEUM
	 * @model name="petroleum"
	 * @generated
	 * @ordered
	 */
	public static final int PETROLEUM_VALUE = 6;

	/**
	 * An array of all the '<em><b>Domain</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Domain[] VALUES_ARRAY =
		new Domain[] {
			CROSS_DOMAIN,
			AVIONICS,
			AUTOMOTIVE,
			TELECOM,
			SPACE,
			MEDICAL,
			PETROLEUM,
		};

	/**
	 * A public read-only list of all the '<em><b>Domain</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Domain> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Domain</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Domain get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Domain result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Domain</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Domain getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Domain result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Domain</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Domain get(int value) {
		switch (value) {
			case CROSS_DOMAIN_VALUE: return CROSS_DOMAIN;
			case AVIONICS_VALUE: return AVIONICS;
			case AUTOMOTIVE_VALUE: return AUTOMOTIVE;
			case TELECOM_VALUE: return TELECOM;
			case SPACE_VALUE: return SPACE;
			case MEDICAL_VALUE: return MEDICAL;
			case PETROLEUM_VALUE: return PETROLEUM;
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
	private Domain(int value, String name, String literal) {
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
	
} //Domain
