/**
 */
package org.polarsys.chess.chessmlprofile.Dependability.DependableComponent;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Attack Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponentPackage#getAttackType()
 * @model
 * @generated
 */
public enum AttackType implements Enumerator {
	/**
	 * The '<em><b>Masquerade Attack</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MASQUERADE_ATTACK_VALUE
	 * @generated
	 * @ordered
	 */
	MASQUERADE_ATTACK(0, "masqueradeAttack", "masqueradeAttack"),

	/**
	 * The '<em><b>Denial Of Service Attack</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DENIAL_OF_SERVICE_ATTACK_VALUE
	 * @generated
	 * @ordered
	 */
	DENIAL_OF_SERVICE_ATTACK(1, "denialOfServiceAttack", "denialOfServiceAttack"),

	/**
	 * The '<em><b>Brute Force Attack</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BRUTE_FORCE_ATTACK_VALUE
	 * @generated
	 * @ordered
	 */
	BRUTE_FORCE_ATTACK(2, "bruteForceAttack", "bruteForceAttack"),

	/**
	 * The '<em><b>Data Spoofing Attack</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DATA_SPOOFING_ATTACK_VALUE
	 * @generated
	 * @ordered
	 */
	DATA_SPOOFING_ATTACK(3, "dataSpoofingAttack", "dataSpoofingAttack");

	/**
	 * The '<em><b>Masquerade Attack</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Masquerade Attack</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MASQUERADE_ATTACK
	 * @model name="masqueradeAttack"
	 * @generated
	 * @ordered
	 */
	public static final int MASQUERADE_ATTACK_VALUE = 0;

	/**
	 * The '<em><b>Denial Of Service Attack</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Denial Of Service Attack</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DENIAL_OF_SERVICE_ATTACK
	 * @model name="denialOfServiceAttack"
	 * @generated
	 * @ordered
	 */
	public static final int DENIAL_OF_SERVICE_ATTACK_VALUE = 1;

	/**
	 * The '<em><b>Brute Force Attack</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Brute Force Attack</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BRUTE_FORCE_ATTACK
	 * @model name="bruteForceAttack"
	 * @generated
	 * @ordered
	 */
	public static final int BRUTE_FORCE_ATTACK_VALUE = 2;

	/**
	 * The '<em><b>Data Spoofing Attack</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Data Spoofing Attack</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DATA_SPOOFING_ATTACK
	 * @model name="dataSpoofingAttack"
	 * @generated
	 * @ordered
	 */
	public static final int DATA_SPOOFING_ATTACK_VALUE = 3;

	/**
	 * An array of all the '<em><b>Attack Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final AttackType[] VALUES_ARRAY =
		new AttackType[] {
			MASQUERADE_ATTACK,
			DENIAL_OF_SERVICE_ATTACK,
			BRUTE_FORCE_ATTACK,
			DATA_SPOOFING_ATTACK,
		};

	/**
	 * A public read-only list of all the '<em><b>Attack Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<AttackType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Attack Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static AttackType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AttackType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Attack Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static AttackType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AttackType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Attack Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static AttackType get(int value) {
		switch (value) {
			case MASQUERADE_ATTACK_VALUE: return MASQUERADE_ATTACK;
			case DENIAL_OF_SERVICE_ATTACK_VALUE: return DENIAL_OF_SERVICE_ATTACK;
			case BRUTE_FORCE_ATTACK_VALUE: return BRUTE_FORCE_ATTACK;
			case DATA_SPOOFING_ATTACK_VALUE: return DATA_SPOOFING_ATTACK;
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
	private AttackType(int value, String name, String literal) {
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
	
} //AttackType
