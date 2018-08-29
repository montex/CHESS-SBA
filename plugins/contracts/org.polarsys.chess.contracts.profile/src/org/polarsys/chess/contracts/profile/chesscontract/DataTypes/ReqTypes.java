/**
 */
package org.polarsys.chess.contracts.profile.chesscontract.DataTypes;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration
 * '<em><b>Req Types</b></em>', and utility methods for working with them. <!--
 * end-user-doc -->
 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.DataTypesPackage#getReqTypes()
 * @model
 * @generated
 */
public enum ReqTypes implements Enumerator {
	/**
	 * The '<em><b>Functional</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FUNCTIONAL_VALUE
	 * @generated
	 * @ordered
	 */
	FUNCTIONAL(0, "Functional", "Functional"),

	/**
	 * The '<em><b>Mission</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MISSION_VALUE
	 * @generated
	 * @ordered
	 */
	MISSION(1, "Mission", "Mission"),

	/**
	 * The '<em><b>Interface</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INTERFACE_VALUE
	 * @generated
	 * @ordered
	 */
	INTERFACE(2, "Interface", "Interface"),

	/**
	 * The '<em><b>Environmental</b></em>' literal object.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #ENVIRONMENTAL_VALUE
	 * @generated
	 * @ordered
	 */
	ENVIRONMENTAL(3, "Environmental", "Environmental"),

	/**
	 * The '<em><b>Physical</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PHYSICAL_VALUE
	 * @generated
	 * @ordered
	 */
	PHYSICAL(4, "Physical", "Physical"),

	/**
	 * The '<em><b>Operational</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OPERATIONAL_VALUE
	 * @generated
	 * @ordered
	 */
	OPERATIONAL(5, "Operational", "Operational"),

	/**
	 * The '<em><b>Human Factor</b></em>' literal object.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #HUMAN_FACTOR_VALUE
	 * @generated
	 * @ordered
	 */
	HUMAN_FACTOR(6, "HumanFactor", "HumanFactor"),

	/**
	 * The '<em><b>Logistics Support</b></em>' literal object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #LOGISTICS_SUPPORT_VALUE
	 * @generated
	 * @ordered
	 */
	LOGISTICS_SUPPORT(7, "LogisticsSupport", "LogisticsSupport"),

	/**
	 * The '<em><b>Configuration</b></em>' literal object.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #CONFIGURATION_VALUE
	 * @generated
	 * @ordered
	 */
	CONFIGURATION(8, "Configuration", "Configuration"),

	/**
	 * The '<em><b>Design</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #DESIGN_VALUE
	 * @generated
	 * @ordered
	 */
	DESIGN(9, "Design", "Design"),

	/**
	 * The '<em><b>Verification</b></em>' literal object.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #VERIFICATION_VALUE
	 * @generated
	 * @ordered
	 */
	VERIFICATION(10, "Verification", "Verification"),

	/**
	 * The '<em><b>Product Assurance</b></em>' literal object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #PRODUCT_ASSURANCE_VALUE
	 * @generated
	 * @ordered
	 */
	PRODUCT_ASSURANCE(11, "ProductAssurance", "ProductAssurance");

	/**
	 * The '<em><b>Functional</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Functional</b></em>' literal object isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FUNCTIONAL
	 * @model name="Functional"
	 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='Functional '"
	 * @generated
	 * @ordered
	 */
	public static final int FUNCTIONAL_VALUE = 0;

	/**
	 * The '<em><b>Mission</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Mission</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MISSION
	 * @model name="Mission"
	 * @generated
	 * @ordered
	 */
	public static final int MISSION_VALUE = 1;

	/**
	 * The '<em><b>Interface</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Interface</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INTERFACE
	 * @model name="Interface"
	 * @generated
	 * @ordered
	 */
	public static final int INTERFACE_VALUE = 2;

	/**
	 * The '<em><b>Environmental</b></em>' literal value.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of '<em><b>Environmental</b></em>' literal object isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ENVIRONMENTAL
	 * @model name="Environmental"
	 * @generated
	 * @ordered
	 */
	public static final int ENVIRONMENTAL_VALUE = 3;

	/**
	 * The '<em><b>Physical</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Physical</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PHYSICAL
	 * @model name="Physical"
	 * @generated
	 * @ordered
	 */
	public static final int PHYSICAL_VALUE = 4;

	/**
	 * The '<em><b>Operational</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Operational</b></em>' literal object isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OPERATIONAL
	 * @model name="Operational"
	 * @generated
	 * @ordered
	 */
	public static final int OPERATIONAL_VALUE = 5;

	/**
	 * The '<em><b>Human Factor</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Human Factor</b></em>' literal object isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HUMAN_FACTOR
	 * @model name="HumanFactor"
	 * @generated
	 * @ordered
	 */
	public static final int HUMAN_FACTOR_VALUE = 6;

	/**
	 * The '<em><b>Logistics Support</b></em>' literal value. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Logistics Support</b></em>' literal object
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #LOGISTICS_SUPPORT
	 * @model name="LogisticsSupport"
	 * @generated
	 * @ordered
	 */
	public static final int LOGISTICS_SUPPORT_VALUE = 7;

	/**
	 * The '<em><b>Configuration</b></em>' literal value.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of '<em><b>Configuration</b></em>' literal object isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONFIGURATION
	 * @model name="Configuration"
	 * @generated
	 * @ordered
	 */
	public static final int CONFIGURATION_VALUE = 8;

	/**
	 * The '<em><b>Design</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Design</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DESIGN
	 * @model name="Design"
	 * @generated
	 * @ordered
	 */
	public static final int DESIGN_VALUE = 9;

	/**
	 * The '<em><b>Verification</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Verification</b></em>' literal object isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VERIFICATION
	 * @model name="Verification"
	 * @generated
	 * @ordered
	 */
	public static final int VERIFICATION_VALUE = 10;

	/**
	 * The '<em><b>Product Assurance</b></em>' literal value. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Product Assurance</b></em>' literal object
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #PRODUCT_ASSURANCE
	 * @model name="ProductAssurance"
	 * @generated
	 * @ordered
	 */
	public static final int PRODUCT_ASSURANCE_VALUE = 11;

	/**
	 * An array of all the '<em><b>Req Types</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final ReqTypes[] VALUES_ARRAY = new ReqTypes[] {
			FUNCTIONAL,
			MISSION,
			INTERFACE,
			ENVIRONMENTAL,
			PHYSICAL,
			OPERATIONAL,
			HUMAN_FACTOR,
			LOGISTICS_SUPPORT,
			CONFIGURATION,
			DESIGN,
			VERIFICATION,
			PRODUCT_ASSURANCE,
		};

	/**
	 * A public read-only list of all the '<em><b>Req Types</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ReqTypes> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Req Types</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ReqTypes get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ReqTypes result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Req Types</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ReqTypes getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ReqTypes result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Req Types</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ReqTypes get(int value) {
		switch (value) {
			case FUNCTIONAL_VALUE: return FUNCTIONAL;
			case MISSION_VALUE: return MISSION;
			case INTERFACE_VALUE: return INTERFACE;
			case ENVIRONMENTAL_VALUE: return ENVIRONMENTAL;
			case PHYSICAL_VALUE: return PHYSICAL;
			case OPERATIONAL_VALUE: return OPERATIONAL;
			case HUMAN_FACTOR_VALUE: return HUMAN_FACTOR;
			case LOGISTICS_SUPPORT_VALUE: return LOGISTICS_SUPPORT;
			case CONFIGURATION_VALUE: return CONFIGURATION;
			case DESIGN_VALUE: return DESIGN;
			case VERIFICATION_VALUE: return VERIFICATION;
			case PRODUCT_ASSURANCE_VALUE: return PRODUCT_ASSURANCE;
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
	private ReqTypes(int value, String name, String literal) {
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

} // ReqTypes
