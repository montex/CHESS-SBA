/**
 */
package org.polarsys.chess.contracts.profile.chesscontract.DataTypes;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration
 * '<em><b>Req Maturities</b></em>', and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.DataTypesPackage#getReqMaturities()
 * @model
 * @generated
 */
public enum ReqMaturities implements Enumerator {
	/**
	 * The '<em><b>TBC</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #TBC_VALUE
	 * @generated
	 * @ordered
	 */
	TBC(0, "TBC", "TBC"),

	/**
	 * The '<em><b>TBD</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #TBD_VALUE
	 * @generated
	 * @ordered
	 */
	TBD(1, "TBD", "TBD"),

	/**
	 * The '<em><b>In Analysis</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IN_ANALYSIS_VALUE
	 * @generated
	 * @ordered
	 */
	IN_ANALYSIS(2, "InAnalysis", "InAnalysis"),

	/**
	 * The '<em><b>Analyzed</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ANALYZED_VALUE
	 * @generated
	 * @ordered
	 */
	ANALYZED(3, "Analyzed", "Analyzed");

	/**
	 * The '<em><b>TBC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TBC</b></em>' literal object isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TBC
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TBC_VALUE = 0;

	/**
	 * The '<em><b>TBD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TBD</b></em>' literal object isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TBD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TBD_VALUE = 1;

	/**
	 * The '<em><b>In Analysis</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>In Analysis</b></em>' literal object isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IN_ANALYSIS
	 * @model name="InAnalysis"
	 * @generated
	 * @ordered
	 */
	public static final int IN_ANALYSIS_VALUE = 2;

	/**
	 * The '<em><b>Analyzed</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Analyzed</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ANALYZED
	 * @model name="Analyzed"
	 * @generated
	 * @ordered
	 */
	public static final int ANALYZED_VALUE = 3;

	/**
	 * An array of all the '<em><b>Req Maturities</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final ReqMaturities[] VALUES_ARRAY = new ReqMaturities[] {
			TBC,
			TBD,
			IN_ANALYSIS,
			ANALYZED,
		};

	/**
	 * A public read-only list of all the '<em><b>Req Maturities</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ReqMaturities> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Req Maturities</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ReqMaturities get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ReqMaturities result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Req Maturities</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ReqMaturities getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ReqMaturities result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Req Maturities</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ReqMaturities get(int value) {
		switch (value) {
			case TBC_VALUE: return TBC;
			case TBD_VALUE: return TBD;
			case IN_ANALYSIS_VALUE: return IN_ANALYSIS;
			case ANALYZED_VALUE: return ANALYZED;
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
	private ReqMaturities(int value, String name, String literal) {
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

} // ReqMaturities
