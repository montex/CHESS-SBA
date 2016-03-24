/**
 */
package org.polarsys.chess.xtext.flaDsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.xtext.flaDsl.Expression#getLhs <em>Lhs</em>}</li>
 *   <li>{@link org.polarsys.chess.xtext.flaDsl.Expression#getRhs <em>Rhs</em>}</li>
 * </ul>
 *
 * @see org.polarsys.chess.xtext.flaDsl.FlaDslPackage#getExpression()
 * @model
 * @generated
 */
public interface Expression extends EObject
{
  /**
   * Returns the value of the '<em><b>Lhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Lhs</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lhs</em>' containment reference.
   * @see #setLhs(Lhs)
   * @see org.polarsys.chess.xtext.flaDsl.FlaDslPackage#getExpression_Lhs()
   * @model containment="true"
   * @generated
   */
  Lhs getLhs();

  /**
   * Sets the value of the '{@link org.polarsys.chess.xtext.flaDsl.Expression#getLhs <em>Lhs</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lhs</em>' containment reference.
   * @see #getLhs()
   * @generated
   */
  void setLhs(Lhs value);

  /**
   * Returns the value of the '<em><b>Rhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rhs</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rhs</em>' containment reference.
   * @see #setRhs(Rhs)
   * @see org.polarsys.chess.xtext.flaDsl.FlaDslPackage#getExpression_Rhs()
   * @model containment="true"
   * @generated
   */
  Rhs getRhs();

  /**
   * Sets the value of the '{@link org.polarsys.chess.xtext.flaDsl.Expression#getRhs <em>Rhs</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rhs</em>' containment reference.
   * @see #getRhs()
   * @generated
   */
  void setRhs(Rhs value);

} // Expression
