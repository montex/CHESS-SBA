/**
 */
package org.polarsys.chess.xtext.flaDsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Failure Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.xtext.flaDsl.FailureDefinition#getType <em>Type</em>}</li>
 *   <li>{@link org.polarsys.chess.xtext.flaDsl.FailureDefinition#getAcidAvoidable <em>Acid Avoidable</em>}</li>
 * </ul>
 *
 * @see org.polarsys.chess.xtext.flaDsl.FlaDslPackage#getFailureDefinition()
 * @model
 * @generated
 */
public interface FailureDefinition extends Definitions
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * The literals are from the enumeration {@link org.polarsys.chess.xtext.flaDsl.FailureType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see org.polarsys.chess.xtext.flaDsl.FailureType
   * @see #setType(FailureType)
   * @see org.polarsys.chess.xtext.flaDsl.FlaDslPackage#getFailureDefinition_Type()
   * @model
   * @generated
   */
  FailureType getType();

  /**
   * Sets the value of the '{@link org.polarsys.chess.xtext.flaDsl.FailureDefinition#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see org.polarsys.chess.xtext.flaDsl.FailureType
   * @see #getType()
   * @generated
   */
  void setType(FailureType value);

  /**
   * Returns the value of the '<em><b>Acid Avoidable</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Acid Avoidable</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Acid Avoidable</em>' containment reference.
   * @see #setAcidAvoidable(ACIDavoidable)
   * @see org.polarsys.chess.xtext.flaDsl.FlaDslPackage#getFailureDefinition_AcidAvoidable()
   * @model containment="true"
   * @generated
   */
  ACIDavoidable getAcidAvoidable();

  /**
   * Sets the value of the '{@link org.polarsys.chess.xtext.flaDsl.FailureDefinition#getAcidAvoidable <em>Acid Avoidable</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Acid Avoidable</em>' containment reference.
   * @see #getAcidAvoidable()
   * @generated
   */
  void setAcidAvoidable(ACIDavoidable value);

} // FailureDefinition
