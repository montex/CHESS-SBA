/**
 */
package org.polarsys.chess.xtext.flaDsl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Failure Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.polarsys.chess.xtext.flaDsl.FlaDslPackage#getFailureType()
 * @model
 * @generated
 */
public enum FailureType implements Enumerator
{
  /**
   * The '<em><b>NO FAILURE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #NO_FAILURE_VALUE
   * @generated
   * @ordered
   */
  NO_FAILURE(0, "NO_FAILURE", "noFailure"),

  /**
   * The '<em><b>EARLY</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #EARLY_VALUE
   * @generated
   * @ordered
   */
  EARLY(1, "EARLY", "early"),

  /**
   * The '<em><b>LATE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #LATE_VALUE
   * @generated
   * @ordered
   */
  LATE(2, "LATE", "late"),

  /**
   * The '<em><b>COMMISSION</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #COMMISSION_VALUE
   * @generated
   * @ordered
   */
  COMMISSION(3, "COMMISSION", "commission"),

  /**
   * The '<em><b>OMISSION</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #OMISSION_VALUE
   * @generated
   * @ordered
   */
  OMISSION(4, "OMISSION", "omission"),

  /**
   * The '<em><b>VALUE SUBTLE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #VALUE_SUBTLE_VALUE
   * @generated
   * @ordered
   */
  VALUE_SUBTLE(5, "VALUE_SUBTLE", "valueSubtle"),

  /**
   * The '<em><b>VALUE COARSE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #VALUE_COARSE_VALUE
   * @generated
   * @ordered
   */
  VALUE_COARSE(6, "VALUE_COARSE", "valueCoarse"),

  /**
   * The '<em><b>WILDCARD</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #WILDCARD_VALUE
   * @generated
   * @ordered
   */
  WILDCARD(7, "WILDCARD", "wildcard"),

  /**
   * The '<em><b>VARIABLE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #VARIABLE_VALUE
   * @generated
   * @ordered
   */
  VARIABLE(8, "VARIABLE", "variable");

  /**
   * The '<em><b>NO FAILURE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>NO FAILURE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #NO_FAILURE
   * @model literal="noFailure"
   * @generated
   * @ordered
   */
  public static final int NO_FAILURE_VALUE = 0;

  /**
   * The '<em><b>EARLY</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>EARLY</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #EARLY
   * @model literal="early"
   * @generated
   * @ordered
   */
  public static final int EARLY_VALUE = 1;

  /**
   * The '<em><b>LATE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>LATE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #LATE
   * @model literal="late"
   * @generated
   * @ordered
   */
  public static final int LATE_VALUE = 2;

  /**
   * The '<em><b>COMMISSION</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>COMMISSION</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #COMMISSION
   * @model literal="commission"
   * @generated
   * @ordered
   */
  public static final int COMMISSION_VALUE = 3;

  /**
   * The '<em><b>OMISSION</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>OMISSION</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #OMISSION
   * @model literal="omission"
   * @generated
   * @ordered
   */
  public static final int OMISSION_VALUE = 4;

  /**
   * The '<em><b>VALUE SUBTLE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>VALUE SUBTLE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #VALUE_SUBTLE
   * @model literal="valueSubtle"
   * @generated
   * @ordered
   */
  public static final int VALUE_SUBTLE_VALUE = 5;

  /**
   * The '<em><b>VALUE COARSE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>VALUE COARSE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #VALUE_COARSE
   * @model literal="valueCoarse"
   * @generated
   * @ordered
   */
  public static final int VALUE_COARSE_VALUE = 6;

  /**
   * The '<em><b>WILDCARD</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>WILDCARD</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #WILDCARD
   * @model literal="wildcard"
   * @generated
   * @ordered
   */
  public static final int WILDCARD_VALUE = 7;

  /**
   * The '<em><b>VARIABLE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>VARIABLE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #VARIABLE
   * @model literal="variable"
   * @generated
   * @ordered
   */
  public static final int VARIABLE_VALUE = 8;

  /**
   * An array of all the '<em><b>Failure Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final FailureType[] VALUES_ARRAY =
    new FailureType[]
    {
      NO_FAILURE,
      EARLY,
      LATE,
      COMMISSION,
      OMISSION,
      VALUE_SUBTLE,
      VALUE_COARSE,
      WILDCARD,
      VARIABLE,
    };

  /**
   * A public read-only list of all the '<em><b>Failure Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<FailureType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Failure Type</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static FailureType get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      FailureType result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Failure Type</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static FailureType getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      FailureType result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Failure Type</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static FailureType get(int value)
  {
    switch (value)
    {
      case NO_FAILURE_VALUE: return NO_FAILURE;
      case EARLY_VALUE: return EARLY;
      case LATE_VALUE: return LATE;
      case COMMISSION_VALUE: return COMMISSION;
      case OMISSION_VALUE: return OMISSION;
      case VALUE_SUBTLE_VALUE: return VALUE_SUBTLE;
      case VALUE_COARSE_VALUE: return VALUE_COARSE;
      case WILDCARD_VALUE: return WILDCARD;
      case VARIABLE_VALUE: return VARIABLE;
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
  private FailureType(int value, String name, String literal)
  {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLiteral()
  {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    return literal;
  }
  
} //FailureType
