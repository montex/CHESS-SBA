/**
 */
package org.polarsys.chess.xtext.flaDsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.xtext.flaDsl.VariableDefinition#getVariableName <em>Variable Name</em>}</li>
 * </ul>
 *
 * @see org.polarsys.chess.xtext.flaDsl.FlaDslPackage#getVariableDefinition()
 * @model
 * @generated
 */
public interface VariableDefinition extends Definitions
{
  /**
   * Returns the value of the '<em><b>Variable Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Variable Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Variable Name</em>' attribute.
   * @see #setVariableName(String)
   * @see org.polarsys.chess.xtext.flaDsl.FlaDslPackage#getVariableDefinition_VariableName()
   * @model
   * @generated
   */
  String getVariableName();

  /**
   * Sets the value of the '{@link org.polarsys.chess.xtext.flaDsl.VariableDefinition#getVariableName <em>Variable Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Variable Name</em>' attribute.
   * @see #getVariableName()
   * @generated
   */
  void setVariableName(String value);

} // VariableDefinition
