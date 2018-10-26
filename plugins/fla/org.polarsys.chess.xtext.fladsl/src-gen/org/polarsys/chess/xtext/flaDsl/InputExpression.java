/**
 */
package org.polarsys.chess.xtext.flaDsl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Port;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.xtext.flaDsl.InputExpression#getRef <em>Ref</em>}</li>
 *   <li>{@link org.polarsys.chess.xtext.flaDsl.InputExpression#getFailureExpr <em>Failure Expr</em>}</li>
 * </ul>
 *
 * @see org.polarsys.chess.xtext.flaDsl.FlaDslPackage#getInputExpression()
 * @model
 * @generated
 */
public interface InputExpression extends EObject
{
  /**
   * Returns the value of the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ref</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' reference.
   * @see #setRef(Port)
   * @see org.polarsys.chess.xtext.flaDsl.FlaDslPackage#getInputExpression_Ref()
   * @model
   * @generated
   */
  Port getRef();

  /**
   * Sets the value of the '{@link org.polarsys.chess.xtext.flaDsl.InputExpression#getRef <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' reference.
   * @see #getRef()
   * @generated
   */
  void setRef(Port value);

  /**
   * Returns the value of the '<em><b>Failure Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Failure Expr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Failure Expr</em>' containment reference.
   * @see #setFailureExpr(InFailureExpr)
   * @see org.polarsys.chess.xtext.flaDsl.FlaDslPackage#getInputExpression_FailureExpr()
   * @model containment="true"
   * @generated
   */
  InFailureExpr getFailureExpr();

  /**
   * Sets the value of the '{@link org.polarsys.chess.xtext.flaDsl.InputExpression#getFailureExpr <em>Failure Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Failure Expr</em>' containment reference.
   * @see #getFailureExpr()
   * @generated
   */
  void setFailureExpr(InFailureExpr value);

} // InputExpression
