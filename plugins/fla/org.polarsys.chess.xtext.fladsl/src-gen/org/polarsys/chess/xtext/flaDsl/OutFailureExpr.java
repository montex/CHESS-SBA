/**
 */
package org.polarsys.chess.xtext.flaDsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Out Failure Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.xtext.flaDsl.OutFailureExpr#getFailures <em>Failures</em>}</li>
 * </ul>
 *
 * @see org.polarsys.chess.xtext.flaDsl.FlaDslPackage#getOutFailureExpr()
 * @model
 * @generated
 */
public interface OutFailureExpr extends EObject
{
  /**
   * Returns the value of the '<em><b>Failures</b></em>' containment reference list.
   * The list contents are of type {@link org.polarsys.chess.xtext.flaDsl.Definitions}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Failures</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Failures</em>' containment reference list.
   * @see org.polarsys.chess.xtext.flaDsl.FlaDslPackage#getOutFailureExpr_Failures()
   * @model containment="true"
   * @generated
   */
  EList<Definitions> getFailures();

} // OutFailureExpr
