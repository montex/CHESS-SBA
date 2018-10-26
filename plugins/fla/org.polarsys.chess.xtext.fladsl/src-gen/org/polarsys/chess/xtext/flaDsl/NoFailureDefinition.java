/**
 */
package org.polarsys.chess.xtext.flaDsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>No Failure Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.xtext.flaDsl.NoFailureDefinition#getAcidMitigation <em>Acid Mitigation</em>}</li>
 * </ul>
 *
 * @see org.polarsys.chess.xtext.flaDsl.FlaDslPackage#getNoFailureDefinition()
 * @model
 * @generated
 */
public interface NoFailureDefinition extends Definitions, ComplexNofailureDefinition
{
  /**
   * Returns the value of the '<em><b>Acid Mitigation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Acid Mitigation</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Acid Mitigation</em>' containment reference.
   * @see #setAcidMitigation(ACIDMitigation)
   * @see org.polarsys.chess.xtext.flaDsl.FlaDslPackage#getNoFailureDefinition_AcidMitigation()
   * @model containment="true"
   * @generated
   */
  ACIDMitigation getAcidMitigation();

  /**
   * Sets the value of the '{@link org.polarsys.chess.xtext.flaDsl.NoFailureDefinition#getAcidMitigation <em>Acid Mitigation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Acid Mitigation</em>' containment reference.
   * @see #getAcidMitigation()
   * @generated
   */
  void setAcidMitigation(ACIDMitigation value);

} // NoFailureDefinition
