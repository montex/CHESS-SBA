/**
 */
package org.polarsys.chess.xtext.flaDsl;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.polarsys.chess.xtext.flaDsl.FlaDslPackage
 * @generated
 */
public interface FlaDslFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  FlaDslFactory eINSTANCE = org.polarsys.chess.xtext.flaDsl.impl.FlaDslFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Behaviour</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Behaviour</em>'.
   * @generated
   */
  Behaviour createBehaviour();

  /**
   * Returns a new object of class '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression</em>'.
   * @generated
   */
  Expression createExpression();

  /**
   * Returns a new object of class '<em>Lhs</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Lhs</em>'.
   * @generated
   */
  Lhs createLhs();

  /**
   * Returns a new object of class '<em>Rhs</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rhs</em>'.
   * @generated
   */
  Rhs createRhs();

  /**
   * Returns a new object of class '<em>Input Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Input Expression</em>'.
   * @generated
   */
  InputExpression createInputExpression();

  /**
   * Returns a new object of class '<em>Output Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Output Expression</em>'.
   * @generated
   */
  OutputExpression createOutputExpression();

  /**
   * Returns a new object of class '<em>In Failure Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>In Failure Expr</em>'.
   * @generated
   */
  InFailureExpr createInFailureExpr();

  /**
   * Returns a new object of class '<em>Out Failure Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Out Failure Expr</em>'.
   * @generated
   */
  OutFailureExpr createOutFailureExpr();

  /**
   * Returns a new object of class '<em>Definitions</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Definitions</em>'.
   * @generated
   */
  Definitions createDefinitions();

  /**
   * Returns a new object of class '<em>Failure Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Failure Definition</em>'.
   * @generated
   */
  FailureDefinition createFailureDefinition();

  /**
   * Returns a new object of class '<em>No Failure Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>No Failure Definition</em>'.
   * @generated
   */
  NoFailureDefinition createNoFailureDefinition();

  /**
   * Returns a new object of class '<em>Complex Nofailure Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Complex Nofailure Definition</em>'.
   * @generated
   */
  ComplexNofailureDefinition createComplexNofailureDefinition();

  /**
   * Returns a new object of class '<em>Wildcard Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Wildcard Definition</em>'.
   * @generated
   */
  WildcardDefinition createWildcardDefinition();

  /**
   * Returns a new object of class '<em>Variable Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Variable Definition</em>'.
   * @generated
   */
  VariableDefinition createVariableDefinition();

  /**
   * Returns a new object of class '<em>ACI Davoidable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ACI Davoidable</em>'.
   * @generated
   */
  ACIDavoidable createACIDavoidable();

  /**
   * Returns a new object of class '<em>ACID Mitigation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ACID Mitigation</em>'.
   * @generated
   */
  ACIDMitigation createACIDMitigation();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  FlaDslPackage getFlaDslPackage();

} //FlaDslFactory
