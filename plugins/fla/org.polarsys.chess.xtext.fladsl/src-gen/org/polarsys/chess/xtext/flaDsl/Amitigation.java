/**
 */
package org.polarsys.chess.xtext.flaDsl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Amitigation</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.polarsys.chess.xtext.flaDsl.FlaDslPackage#getAmitigation()
 * @model
 * @generated
 */
public enum Amitigation implements Enumerator
{
  /**
   * The '<em><b>ALL OR NOTHING</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ALL_OR_NOTHING_VALUE
   * @generated
   * @ordered
   */
  ALL_OR_NOTHING(0, "ALL_OR_NOTHING", "all_or_nothing"),

  /**
   * The '<em><b>ALL OR COMPENSATION</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ALL_OR_COMPENSATION_VALUE
   * @generated
   * @ordered
   */
  ALL_OR_COMPENSATION(1, "ALL_OR_COMPENSATION", "all_or_compensation"),

  /**
   * The '<em><b>NONE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #NONE_VALUE
   * @generated
   * @ordered
   */
  NONE(2, "NONE", "none"),

  /**
   * The '<em><b>UNSPECIFIED</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #UNSPECIFIED_VALUE
   * @generated
   * @ordered
   */
  UNSPECIFIED(3, "UNSPECIFIED", "unspecified");

  /**
   * The '<em><b>ALL OR NOTHING</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>ALL OR NOTHING</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ALL_OR_NOTHING
   * @model literal="all_or_nothing"
   * @generated
   * @ordered
   */
  public static final int ALL_OR_NOTHING_VALUE = 0;

  /**
   * The '<em><b>ALL OR COMPENSATION</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>ALL OR COMPENSATION</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ALL_OR_COMPENSATION
   * @model literal="all_or_compensation"
   * @generated
   * @ordered
   */
  public static final int ALL_OR_COMPENSATION_VALUE = 1;

  /**
   * The '<em><b>NONE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>NONE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #NONE
   * @model literal="none"
   * @generated
   * @ordered
   */
  public static final int NONE_VALUE = 2;

  /**
   * The '<em><b>UNSPECIFIED</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>UNSPECIFIED</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #UNSPECIFIED
   * @model literal="unspecified"
   * @generated
   * @ordered
   */
  public static final int UNSPECIFIED_VALUE = 3;

  /**
   * An array of all the '<em><b>Amitigation</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final Amitigation[] VALUES_ARRAY =
    new Amitigation[]
    {
      ALL_OR_NOTHING,
      ALL_OR_COMPENSATION,
      NONE,
      UNSPECIFIED,
    };

  /**
   * A public read-only list of all the '<em><b>Amitigation</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<Amitigation> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Amitigation</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static Amitigation get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      Amitigation result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Amitigation</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static Amitigation getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      Amitigation result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Amitigation</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static Amitigation get(int value)
  {
    switch (value)
    {
      case ALL_OR_NOTHING_VALUE: return ALL_OR_NOTHING;
      case ALL_OR_COMPENSATION_VALUE: return ALL_OR_COMPENSATION;
      case NONE_VALUE: return NONE;
      case UNSPECIFIED_VALUE: return UNSPECIFIED;
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
  private Amitigation(int value, String name, String literal)
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
  
} //Amitigation
