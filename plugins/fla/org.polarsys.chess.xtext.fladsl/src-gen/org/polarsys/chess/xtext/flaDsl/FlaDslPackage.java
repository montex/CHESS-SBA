/**
 */
package org.polarsys.chess.xtext.flaDsl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.polarsys.chess.xtext.flaDsl.FlaDslFactory
 * @model kind="package"
 * @generated
 */
public interface FlaDslPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "flaDsl";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.intecs.org/chess/xtext/FlaDsl";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "flaDsl";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  FlaDslPackage eINSTANCE = org.polarsys.chess.xtext.flaDsl.impl.FlaDslPackageImpl.init();

  /**
   * The meta object id for the '{@link org.polarsys.chess.xtext.flaDsl.impl.BehaviourImpl <em>Behaviour</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.polarsys.chess.xtext.flaDsl.impl.BehaviourImpl
   * @see org.polarsys.chess.xtext.flaDsl.impl.FlaDslPackageImpl#getBehaviour()
   * @generated
   */
  int BEHAVIOUR = 0;

  /**
   * The feature id for the '<em><b>Rules</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOUR__RULES = 0;

  /**
   * The number of structural features of the '<em>Behaviour</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOUR_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.polarsys.chess.xtext.flaDsl.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.polarsys.chess.xtext.flaDsl.impl.ExpressionImpl
   * @see org.polarsys.chess.xtext.flaDsl.impl.FlaDslPackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 1;

  /**
   * The feature id for the '<em><b>Lhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__LHS = 0;

  /**
   * The feature id for the '<em><b>Rhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__RHS = 1;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.polarsys.chess.xtext.flaDsl.impl.LhsImpl <em>Lhs</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.polarsys.chess.xtext.flaDsl.impl.LhsImpl
   * @see org.polarsys.chess.xtext.flaDsl.impl.FlaDslPackageImpl#getLhs()
   * @generated
   */
  int LHS = 2;

  /**
   * The feature id for the '<em><b>Failures</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LHS__FAILURES = 0;

  /**
   * The number of structural features of the '<em>Lhs</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LHS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.polarsys.chess.xtext.flaDsl.impl.RhsImpl <em>Rhs</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.polarsys.chess.xtext.flaDsl.impl.RhsImpl
   * @see org.polarsys.chess.xtext.flaDsl.impl.FlaDslPackageImpl#getRhs()
   * @generated
   */
  int RHS = 3;

  /**
   * The feature id for the '<em><b>Failures</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RHS__FAILURES = 0;

  /**
   * The number of structural features of the '<em>Rhs</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RHS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.polarsys.chess.xtext.flaDsl.impl.InputExpressionImpl <em>Input Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.polarsys.chess.xtext.flaDsl.impl.InputExpressionImpl
   * @see org.polarsys.chess.xtext.flaDsl.impl.FlaDslPackageImpl#getInputExpression()
   * @generated
   */
  int INPUT_EXPRESSION = 4;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INPUT_EXPRESSION__REF = 0;

  /**
   * The feature id for the '<em><b>Failure Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INPUT_EXPRESSION__FAILURE_EXPR = 1;

  /**
   * The number of structural features of the '<em>Input Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INPUT_EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.polarsys.chess.xtext.flaDsl.impl.OutputExpressionImpl <em>Output Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.polarsys.chess.xtext.flaDsl.impl.OutputExpressionImpl
   * @see org.polarsys.chess.xtext.flaDsl.impl.FlaDslPackageImpl#getOutputExpression()
   * @generated
   */
  int OUTPUT_EXPRESSION = 5;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTPUT_EXPRESSION__REF = 0;

  /**
   * The feature id for the '<em><b>Failure Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTPUT_EXPRESSION__FAILURE_EXPR = 1;

  /**
   * The number of structural features of the '<em>Output Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTPUT_EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.polarsys.chess.xtext.flaDsl.impl.InFailureExprImpl <em>In Failure Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.polarsys.chess.xtext.flaDsl.impl.InFailureExprImpl
   * @see org.polarsys.chess.xtext.flaDsl.impl.FlaDslPackageImpl#getInFailureExpr()
   * @generated
   */
  int IN_FAILURE_EXPR = 6;

  /**
   * The feature id for the '<em><b>Failures</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IN_FAILURE_EXPR__FAILURES = 0;

  /**
   * The number of structural features of the '<em>In Failure Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IN_FAILURE_EXPR_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.polarsys.chess.xtext.flaDsl.impl.OutFailureExprImpl <em>Out Failure Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.polarsys.chess.xtext.flaDsl.impl.OutFailureExprImpl
   * @see org.polarsys.chess.xtext.flaDsl.impl.FlaDslPackageImpl#getOutFailureExpr()
   * @generated
   */
  int OUT_FAILURE_EXPR = 7;

  /**
   * The feature id for the '<em><b>Failures</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUT_FAILURE_EXPR__FAILURES = 0;

  /**
   * The number of structural features of the '<em>Out Failure Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUT_FAILURE_EXPR_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.polarsys.chess.xtext.flaDsl.impl.DefinitionsImpl <em>Definitions</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.polarsys.chess.xtext.flaDsl.impl.DefinitionsImpl
   * @see org.polarsys.chess.xtext.flaDsl.impl.FlaDslPackageImpl#getDefinitions()
   * @generated
   */
  int DEFINITIONS = 8;

  /**
   * The number of structural features of the '<em>Definitions</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITIONS_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.polarsys.chess.xtext.flaDsl.impl.FailureDefinitionImpl <em>Failure Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.polarsys.chess.xtext.flaDsl.impl.FailureDefinitionImpl
   * @see org.polarsys.chess.xtext.flaDsl.impl.FlaDslPackageImpl#getFailureDefinition()
   * @generated
   */
  int FAILURE_DEFINITION = 9;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAILURE_DEFINITION__TYPE = DEFINITIONS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Acid Avoidable</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAILURE_DEFINITION__ACID_AVOIDABLE = DEFINITIONS_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Failure Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAILURE_DEFINITION_FEATURE_COUNT = DEFINITIONS_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.polarsys.chess.xtext.flaDsl.impl.NoFailureDefinitionImpl <em>No Failure Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.polarsys.chess.xtext.flaDsl.impl.NoFailureDefinitionImpl
   * @see org.polarsys.chess.xtext.flaDsl.impl.FlaDslPackageImpl#getNoFailureDefinition()
   * @generated
   */
  int NO_FAILURE_DEFINITION = 10;

  /**
   * The feature id for the '<em><b>Acid Mitigation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NO_FAILURE_DEFINITION__ACID_MITIGATION = DEFINITIONS_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>No Failure Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NO_FAILURE_DEFINITION_FEATURE_COUNT = DEFINITIONS_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.polarsys.chess.xtext.flaDsl.impl.ComplexNofailureDefinitionImpl <em>Complex Nofailure Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.polarsys.chess.xtext.flaDsl.impl.ComplexNofailureDefinitionImpl
   * @see org.polarsys.chess.xtext.flaDsl.impl.FlaDslPackageImpl#getComplexNofailureDefinition()
   * @generated
   */
  int COMPLEX_NOFAILURE_DEFINITION = 11;

  /**
   * The number of structural features of the '<em>Complex Nofailure Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPLEX_NOFAILURE_DEFINITION_FEATURE_COUNT = DEFINITIONS_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.polarsys.chess.xtext.flaDsl.impl.WildcardDefinitionImpl <em>Wildcard Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.polarsys.chess.xtext.flaDsl.impl.WildcardDefinitionImpl
   * @see org.polarsys.chess.xtext.flaDsl.impl.FlaDslPackageImpl#getWildcardDefinition()
   * @generated
   */
  int WILDCARD_DEFINITION = 12;

  /**
   * The number of structural features of the '<em>Wildcard Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WILDCARD_DEFINITION_FEATURE_COUNT = DEFINITIONS_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.polarsys.chess.xtext.flaDsl.impl.VariableDefinitionImpl <em>Variable Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.polarsys.chess.xtext.flaDsl.impl.VariableDefinitionImpl
   * @see org.polarsys.chess.xtext.flaDsl.impl.FlaDslPackageImpl#getVariableDefinition()
   * @generated
   */
  int VARIABLE_DEFINITION = 13;

  /**
   * The feature id for the '<em><b>Variable Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DEFINITION__VARIABLE_NAME = DEFINITIONS_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Variable Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DEFINITION_FEATURE_COUNT = DEFINITIONS_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.polarsys.chess.xtext.flaDsl.impl.ACIDavoidableImpl <em>ACI Davoidable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.polarsys.chess.xtext.flaDsl.impl.ACIDavoidableImpl
   * @see org.polarsys.chess.xtext.flaDsl.impl.FlaDslPackageImpl#getACIDavoidable()
   * @generated
   */
  int ACI_DAVOIDABLE = 14;

  /**
   * The feature id for the '<em><b>A</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACI_DAVOIDABLE__A = 0;

  /**
   * The feature id for the '<em><b>C</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACI_DAVOIDABLE__C = 1;

  /**
   * The feature id for the '<em><b>I</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACI_DAVOIDABLE__I = 2;

  /**
   * The feature id for the '<em><b>D</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACI_DAVOIDABLE__D = 3;

  /**
   * The number of structural features of the '<em>ACI Davoidable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACI_DAVOIDABLE_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.polarsys.chess.xtext.flaDsl.impl.ACIDMitigationImpl <em>ACID Mitigation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.polarsys.chess.xtext.flaDsl.impl.ACIDMitigationImpl
   * @see org.polarsys.chess.xtext.flaDsl.impl.FlaDslPackageImpl#getACIDMitigation()
   * @generated
   */
  int ACID_MITIGATION = 15;

  /**
   * The feature id for the '<em><b>A</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACID_MITIGATION__A = 0;

  /**
   * The feature id for the '<em><b>C</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACID_MITIGATION__C = 1;

  /**
   * The feature id for the '<em><b>I</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACID_MITIGATION__I = 2;

  /**
   * The feature id for the '<em><b>D</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACID_MITIGATION__D = 3;

  /**
   * The number of structural features of the '<em>ACID Mitigation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACID_MITIGATION_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.polarsys.chess.xtext.flaDsl.FailureType <em>Failure Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.polarsys.chess.xtext.flaDsl.FailureType
   * @see org.polarsys.chess.xtext.flaDsl.impl.FlaDslPackageImpl#getFailureType()
   * @generated
   */
  int FAILURE_TYPE = 16;

  /**
   * The meta object id for the '{@link org.polarsys.chess.xtext.flaDsl.Aavoidable <em>Aavoidable</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.polarsys.chess.xtext.flaDsl.Aavoidable
   * @see org.polarsys.chess.xtext.flaDsl.impl.FlaDslPackageImpl#getAavoidable()
   * @generated
   */
  int AAVOIDABLE = 17;

  /**
   * The meta object id for the '{@link org.polarsys.chess.xtext.flaDsl.Cavoidable <em>Cavoidable</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.polarsys.chess.xtext.flaDsl.Cavoidable
   * @see org.polarsys.chess.xtext.flaDsl.impl.FlaDslPackageImpl#getCavoidable()
   * @generated
   */
  int CAVOIDABLE = 18;

  /**
   * The meta object id for the '{@link org.polarsys.chess.xtext.flaDsl.Iavoidable <em>Iavoidable</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.polarsys.chess.xtext.flaDsl.Iavoidable
   * @see org.polarsys.chess.xtext.flaDsl.impl.FlaDslPackageImpl#getIavoidable()
   * @generated
   */
  int IAVOIDABLE = 19;

  /**
   * The meta object id for the '{@link org.polarsys.chess.xtext.flaDsl.Davoidable <em>Davoidable</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.polarsys.chess.xtext.flaDsl.Davoidable
   * @see org.polarsys.chess.xtext.flaDsl.impl.FlaDslPackageImpl#getDavoidable()
   * @generated
   */
  int DAVOIDABLE = 20;

  /**
   * The meta object id for the '{@link org.polarsys.chess.xtext.flaDsl.Amitigation <em>Amitigation</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.polarsys.chess.xtext.flaDsl.Amitigation
   * @see org.polarsys.chess.xtext.flaDsl.impl.FlaDslPackageImpl#getAmitigation()
   * @generated
   */
  int AMITIGATION = 21;

  /**
   * The meta object id for the '{@link org.polarsys.chess.xtext.flaDsl.Cmitigation <em>Cmitigation</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.polarsys.chess.xtext.flaDsl.Cmitigation
   * @see org.polarsys.chess.xtext.flaDsl.impl.FlaDslPackageImpl#getCmitigation()
   * @generated
   */
  int CMITIGATION = 22;

  /**
   * The meta object id for the '{@link org.polarsys.chess.xtext.flaDsl.Imitigation <em>Imitigation</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.polarsys.chess.xtext.flaDsl.Imitigation
   * @see org.polarsys.chess.xtext.flaDsl.impl.FlaDslPackageImpl#getImitigation()
   * @generated
   */
  int IMITIGATION = 23;

  /**
   * The meta object id for the '{@link org.polarsys.chess.xtext.flaDsl.Dmitigation <em>Dmitigation</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.polarsys.chess.xtext.flaDsl.Dmitigation
   * @see org.polarsys.chess.xtext.flaDsl.impl.FlaDslPackageImpl#getDmitigation()
   * @generated
   */
  int DMITIGATION = 24;


  /**
   * Returns the meta object for class '{@link org.polarsys.chess.xtext.flaDsl.Behaviour <em>Behaviour</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Behaviour</em>'.
   * @see org.polarsys.chess.xtext.flaDsl.Behaviour
   * @generated
   */
  EClass getBehaviour();

  /**
   * Returns the meta object for the containment reference list '{@link org.polarsys.chess.xtext.flaDsl.Behaviour#getRules <em>Rules</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Rules</em>'.
   * @see org.polarsys.chess.xtext.flaDsl.Behaviour#getRules()
   * @see #getBehaviour()
   * @generated
   */
  EReference getBehaviour_Rules();

  /**
   * Returns the meta object for class '{@link org.polarsys.chess.xtext.flaDsl.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see org.polarsys.chess.xtext.flaDsl.Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.polarsys.chess.xtext.flaDsl.Expression#getLhs <em>Lhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Lhs</em>'.
   * @see org.polarsys.chess.xtext.flaDsl.Expression#getLhs()
   * @see #getExpression()
   * @generated
   */
  EReference getExpression_Lhs();

  /**
   * Returns the meta object for the containment reference '{@link org.polarsys.chess.xtext.flaDsl.Expression#getRhs <em>Rhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Rhs</em>'.
   * @see org.polarsys.chess.xtext.flaDsl.Expression#getRhs()
   * @see #getExpression()
   * @generated
   */
  EReference getExpression_Rhs();

  /**
   * Returns the meta object for class '{@link org.polarsys.chess.xtext.flaDsl.Lhs <em>Lhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Lhs</em>'.
   * @see org.polarsys.chess.xtext.flaDsl.Lhs
   * @generated
   */
  EClass getLhs();

  /**
   * Returns the meta object for the containment reference list '{@link org.polarsys.chess.xtext.flaDsl.Lhs#getFailures <em>Failures</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Failures</em>'.
   * @see org.polarsys.chess.xtext.flaDsl.Lhs#getFailures()
   * @see #getLhs()
   * @generated
   */
  EReference getLhs_Failures();

  /**
   * Returns the meta object for class '{@link org.polarsys.chess.xtext.flaDsl.Rhs <em>Rhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rhs</em>'.
   * @see org.polarsys.chess.xtext.flaDsl.Rhs
   * @generated
   */
  EClass getRhs();

  /**
   * Returns the meta object for the containment reference list '{@link org.polarsys.chess.xtext.flaDsl.Rhs#getFailures <em>Failures</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Failures</em>'.
   * @see org.polarsys.chess.xtext.flaDsl.Rhs#getFailures()
   * @see #getRhs()
   * @generated
   */
  EReference getRhs_Failures();

  /**
   * Returns the meta object for class '{@link org.polarsys.chess.xtext.flaDsl.InputExpression <em>Input Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Input Expression</em>'.
   * @see org.polarsys.chess.xtext.flaDsl.InputExpression
   * @generated
   */
  EClass getInputExpression();

  /**
   * Returns the meta object for the reference '{@link org.polarsys.chess.xtext.flaDsl.InputExpression#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see org.polarsys.chess.xtext.flaDsl.InputExpression#getRef()
   * @see #getInputExpression()
   * @generated
   */
  EReference getInputExpression_Ref();

  /**
   * Returns the meta object for the containment reference '{@link org.polarsys.chess.xtext.flaDsl.InputExpression#getFailureExpr <em>Failure Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Failure Expr</em>'.
   * @see org.polarsys.chess.xtext.flaDsl.InputExpression#getFailureExpr()
   * @see #getInputExpression()
   * @generated
   */
  EReference getInputExpression_FailureExpr();

  /**
   * Returns the meta object for class '{@link org.polarsys.chess.xtext.flaDsl.OutputExpression <em>Output Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Output Expression</em>'.
   * @see org.polarsys.chess.xtext.flaDsl.OutputExpression
   * @generated
   */
  EClass getOutputExpression();

  /**
   * Returns the meta object for the reference '{@link org.polarsys.chess.xtext.flaDsl.OutputExpression#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see org.polarsys.chess.xtext.flaDsl.OutputExpression#getRef()
   * @see #getOutputExpression()
   * @generated
   */
  EReference getOutputExpression_Ref();

  /**
   * Returns the meta object for the containment reference '{@link org.polarsys.chess.xtext.flaDsl.OutputExpression#getFailureExpr <em>Failure Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Failure Expr</em>'.
   * @see org.polarsys.chess.xtext.flaDsl.OutputExpression#getFailureExpr()
   * @see #getOutputExpression()
   * @generated
   */
  EReference getOutputExpression_FailureExpr();

  /**
   * Returns the meta object for class '{@link org.polarsys.chess.xtext.flaDsl.InFailureExpr <em>In Failure Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>In Failure Expr</em>'.
   * @see org.polarsys.chess.xtext.flaDsl.InFailureExpr
   * @generated
   */
  EClass getInFailureExpr();

  /**
   * Returns the meta object for the containment reference list '{@link org.polarsys.chess.xtext.flaDsl.InFailureExpr#getFailures <em>Failures</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Failures</em>'.
   * @see org.polarsys.chess.xtext.flaDsl.InFailureExpr#getFailures()
   * @see #getInFailureExpr()
   * @generated
   */
  EReference getInFailureExpr_Failures();

  /**
   * Returns the meta object for class '{@link org.polarsys.chess.xtext.flaDsl.OutFailureExpr <em>Out Failure Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Out Failure Expr</em>'.
   * @see org.polarsys.chess.xtext.flaDsl.OutFailureExpr
   * @generated
   */
  EClass getOutFailureExpr();

  /**
   * Returns the meta object for the containment reference list '{@link org.polarsys.chess.xtext.flaDsl.OutFailureExpr#getFailures <em>Failures</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Failures</em>'.
   * @see org.polarsys.chess.xtext.flaDsl.OutFailureExpr#getFailures()
   * @see #getOutFailureExpr()
   * @generated
   */
  EReference getOutFailureExpr_Failures();

  /**
   * Returns the meta object for class '{@link org.polarsys.chess.xtext.flaDsl.Definitions <em>Definitions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Definitions</em>'.
   * @see org.polarsys.chess.xtext.flaDsl.Definitions
   * @generated
   */
  EClass getDefinitions();

  /**
   * Returns the meta object for class '{@link org.polarsys.chess.xtext.flaDsl.FailureDefinition <em>Failure Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Failure Definition</em>'.
   * @see org.polarsys.chess.xtext.flaDsl.FailureDefinition
   * @generated
   */
  EClass getFailureDefinition();

  /**
   * Returns the meta object for the attribute '{@link org.polarsys.chess.xtext.flaDsl.FailureDefinition#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see org.polarsys.chess.xtext.flaDsl.FailureDefinition#getType()
   * @see #getFailureDefinition()
   * @generated
   */
  EAttribute getFailureDefinition_Type();

  /**
   * Returns the meta object for the containment reference '{@link org.polarsys.chess.xtext.flaDsl.FailureDefinition#getAcidAvoidable <em>Acid Avoidable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Acid Avoidable</em>'.
   * @see org.polarsys.chess.xtext.flaDsl.FailureDefinition#getAcidAvoidable()
   * @see #getFailureDefinition()
   * @generated
   */
  EReference getFailureDefinition_AcidAvoidable();

  /**
   * Returns the meta object for class '{@link org.polarsys.chess.xtext.flaDsl.NoFailureDefinition <em>No Failure Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>No Failure Definition</em>'.
   * @see org.polarsys.chess.xtext.flaDsl.NoFailureDefinition
   * @generated
   */
  EClass getNoFailureDefinition();

  /**
   * Returns the meta object for the containment reference '{@link org.polarsys.chess.xtext.flaDsl.NoFailureDefinition#getAcidMitigation <em>Acid Mitigation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Acid Mitigation</em>'.
   * @see org.polarsys.chess.xtext.flaDsl.NoFailureDefinition#getAcidMitigation()
   * @see #getNoFailureDefinition()
   * @generated
   */
  EReference getNoFailureDefinition_AcidMitigation();

  /**
   * Returns the meta object for class '{@link org.polarsys.chess.xtext.flaDsl.ComplexNofailureDefinition <em>Complex Nofailure Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Complex Nofailure Definition</em>'.
   * @see org.polarsys.chess.xtext.flaDsl.ComplexNofailureDefinition
   * @generated
   */
  EClass getComplexNofailureDefinition();

  /**
   * Returns the meta object for class '{@link org.polarsys.chess.xtext.flaDsl.WildcardDefinition <em>Wildcard Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Wildcard Definition</em>'.
   * @see org.polarsys.chess.xtext.flaDsl.WildcardDefinition
   * @generated
   */
  EClass getWildcardDefinition();

  /**
   * Returns the meta object for class '{@link org.polarsys.chess.xtext.flaDsl.VariableDefinition <em>Variable Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable Definition</em>'.
   * @see org.polarsys.chess.xtext.flaDsl.VariableDefinition
   * @generated
   */
  EClass getVariableDefinition();

  /**
   * Returns the meta object for the attribute '{@link org.polarsys.chess.xtext.flaDsl.VariableDefinition#getVariableName <em>Variable Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Variable Name</em>'.
   * @see org.polarsys.chess.xtext.flaDsl.VariableDefinition#getVariableName()
   * @see #getVariableDefinition()
   * @generated
   */
  EAttribute getVariableDefinition_VariableName();

  /**
   * Returns the meta object for class '{@link org.polarsys.chess.xtext.flaDsl.ACIDavoidable <em>ACI Davoidable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>ACI Davoidable</em>'.
   * @see org.polarsys.chess.xtext.flaDsl.ACIDavoidable
   * @generated
   */
  EClass getACIDavoidable();

  /**
   * Returns the meta object for the attribute '{@link org.polarsys.chess.xtext.flaDsl.ACIDavoidable#getA <em>A</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>A</em>'.
   * @see org.polarsys.chess.xtext.flaDsl.ACIDavoidable#getA()
   * @see #getACIDavoidable()
   * @generated
   */
  EAttribute getACIDavoidable_A();

  /**
   * Returns the meta object for the attribute '{@link org.polarsys.chess.xtext.flaDsl.ACIDavoidable#getC <em>C</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>C</em>'.
   * @see org.polarsys.chess.xtext.flaDsl.ACIDavoidable#getC()
   * @see #getACIDavoidable()
   * @generated
   */
  EAttribute getACIDavoidable_C();

  /**
   * Returns the meta object for the attribute '{@link org.polarsys.chess.xtext.flaDsl.ACIDavoidable#getI <em>I</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>I</em>'.
   * @see org.polarsys.chess.xtext.flaDsl.ACIDavoidable#getI()
   * @see #getACIDavoidable()
   * @generated
   */
  EAttribute getACIDavoidable_I();

  /**
   * Returns the meta object for the attribute '{@link org.polarsys.chess.xtext.flaDsl.ACIDavoidable#getD <em>D</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>D</em>'.
   * @see org.polarsys.chess.xtext.flaDsl.ACIDavoidable#getD()
   * @see #getACIDavoidable()
   * @generated
   */
  EAttribute getACIDavoidable_D();

  /**
   * Returns the meta object for class '{@link org.polarsys.chess.xtext.flaDsl.ACIDMitigation <em>ACID Mitigation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>ACID Mitigation</em>'.
   * @see org.polarsys.chess.xtext.flaDsl.ACIDMitigation
   * @generated
   */
  EClass getACIDMitigation();

  /**
   * Returns the meta object for the attribute '{@link org.polarsys.chess.xtext.flaDsl.ACIDMitigation#getA <em>A</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>A</em>'.
   * @see org.polarsys.chess.xtext.flaDsl.ACIDMitigation#getA()
   * @see #getACIDMitigation()
   * @generated
   */
  EAttribute getACIDMitigation_A();

  /**
   * Returns the meta object for the attribute '{@link org.polarsys.chess.xtext.flaDsl.ACIDMitigation#getC <em>C</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>C</em>'.
   * @see org.polarsys.chess.xtext.flaDsl.ACIDMitigation#getC()
   * @see #getACIDMitigation()
   * @generated
   */
  EAttribute getACIDMitigation_C();

  /**
   * Returns the meta object for the attribute '{@link org.polarsys.chess.xtext.flaDsl.ACIDMitigation#getI <em>I</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>I</em>'.
   * @see org.polarsys.chess.xtext.flaDsl.ACIDMitigation#getI()
   * @see #getACIDMitigation()
   * @generated
   */
  EAttribute getACIDMitigation_I();

  /**
   * Returns the meta object for the attribute '{@link org.polarsys.chess.xtext.flaDsl.ACIDMitigation#getD <em>D</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>D</em>'.
   * @see org.polarsys.chess.xtext.flaDsl.ACIDMitigation#getD()
   * @see #getACIDMitigation()
   * @generated
   */
  EAttribute getACIDMitigation_D();

  /**
   * Returns the meta object for enum '{@link org.polarsys.chess.xtext.flaDsl.FailureType <em>Failure Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Failure Type</em>'.
   * @see org.polarsys.chess.xtext.flaDsl.FailureType
   * @generated
   */
  EEnum getFailureType();

  /**
   * Returns the meta object for enum '{@link org.polarsys.chess.xtext.flaDsl.Aavoidable <em>Aavoidable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Aavoidable</em>'.
   * @see org.polarsys.chess.xtext.flaDsl.Aavoidable
   * @generated
   */
  EEnum getAavoidable();

  /**
   * Returns the meta object for enum '{@link org.polarsys.chess.xtext.flaDsl.Cavoidable <em>Cavoidable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Cavoidable</em>'.
   * @see org.polarsys.chess.xtext.flaDsl.Cavoidable
   * @generated
   */
  EEnum getCavoidable();

  /**
   * Returns the meta object for enum '{@link org.polarsys.chess.xtext.flaDsl.Iavoidable <em>Iavoidable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Iavoidable</em>'.
   * @see org.polarsys.chess.xtext.flaDsl.Iavoidable
   * @generated
   */
  EEnum getIavoidable();

  /**
   * Returns the meta object for enum '{@link org.polarsys.chess.xtext.flaDsl.Davoidable <em>Davoidable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Davoidable</em>'.
   * @see org.polarsys.chess.xtext.flaDsl.Davoidable
   * @generated
   */
  EEnum getDavoidable();

  /**
   * Returns the meta object for enum '{@link org.polarsys.chess.xtext.flaDsl.Amitigation <em>Amitigation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Amitigation</em>'.
   * @see org.polarsys.chess.xtext.flaDsl.Amitigation
   * @generated
   */
  EEnum getAmitigation();

  /**
   * Returns the meta object for enum '{@link org.polarsys.chess.xtext.flaDsl.Cmitigation <em>Cmitigation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Cmitigation</em>'.
   * @see org.polarsys.chess.xtext.flaDsl.Cmitigation
   * @generated
   */
  EEnum getCmitigation();

  /**
   * Returns the meta object for enum '{@link org.polarsys.chess.xtext.flaDsl.Imitigation <em>Imitigation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Imitigation</em>'.
   * @see org.polarsys.chess.xtext.flaDsl.Imitigation
   * @generated
   */
  EEnum getImitigation();

  /**
   * Returns the meta object for enum '{@link org.polarsys.chess.xtext.flaDsl.Dmitigation <em>Dmitigation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Dmitigation</em>'.
   * @see org.polarsys.chess.xtext.flaDsl.Dmitigation
   * @generated
   */
  EEnum getDmitigation();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  FlaDslFactory getFlaDslFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.polarsys.chess.xtext.flaDsl.impl.BehaviourImpl <em>Behaviour</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.polarsys.chess.xtext.flaDsl.impl.BehaviourImpl
     * @see org.polarsys.chess.xtext.flaDsl.impl.FlaDslPackageImpl#getBehaviour()
     * @generated
     */
    EClass BEHAVIOUR = eINSTANCE.getBehaviour();

    /**
     * The meta object literal for the '<em><b>Rules</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BEHAVIOUR__RULES = eINSTANCE.getBehaviour_Rules();

    /**
     * The meta object literal for the '{@link org.polarsys.chess.xtext.flaDsl.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.polarsys.chess.xtext.flaDsl.impl.ExpressionImpl
     * @see org.polarsys.chess.xtext.flaDsl.impl.FlaDslPackageImpl#getExpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getExpression();

    /**
     * The meta object literal for the '<em><b>Lhs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION__LHS = eINSTANCE.getExpression_Lhs();

    /**
     * The meta object literal for the '<em><b>Rhs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION__RHS = eINSTANCE.getExpression_Rhs();

    /**
     * The meta object literal for the '{@link org.polarsys.chess.xtext.flaDsl.impl.LhsImpl <em>Lhs</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.polarsys.chess.xtext.flaDsl.impl.LhsImpl
     * @see org.polarsys.chess.xtext.flaDsl.impl.FlaDslPackageImpl#getLhs()
     * @generated
     */
    EClass LHS = eINSTANCE.getLhs();

    /**
     * The meta object literal for the '<em><b>Failures</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LHS__FAILURES = eINSTANCE.getLhs_Failures();

    /**
     * The meta object literal for the '{@link org.polarsys.chess.xtext.flaDsl.impl.RhsImpl <em>Rhs</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.polarsys.chess.xtext.flaDsl.impl.RhsImpl
     * @see org.polarsys.chess.xtext.flaDsl.impl.FlaDslPackageImpl#getRhs()
     * @generated
     */
    EClass RHS = eINSTANCE.getRhs();

    /**
     * The meta object literal for the '<em><b>Failures</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RHS__FAILURES = eINSTANCE.getRhs_Failures();

    /**
     * The meta object literal for the '{@link org.polarsys.chess.xtext.flaDsl.impl.InputExpressionImpl <em>Input Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.polarsys.chess.xtext.flaDsl.impl.InputExpressionImpl
     * @see org.polarsys.chess.xtext.flaDsl.impl.FlaDslPackageImpl#getInputExpression()
     * @generated
     */
    EClass INPUT_EXPRESSION = eINSTANCE.getInputExpression();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INPUT_EXPRESSION__REF = eINSTANCE.getInputExpression_Ref();

    /**
     * The meta object literal for the '<em><b>Failure Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INPUT_EXPRESSION__FAILURE_EXPR = eINSTANCE.getInputExpression_FailureExpr();

    /**
     * The meta object literal for the '{@link org.polarsys.chess.xtext.flaDsl.impl.OutputExpressionImpl <em>Output Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.polarsys.chess.xtext.flaDsl.impl.OutputExpressionImpl
     * @see org.polarsys.chess.xtext.flaDsl.impl.FlaDslPackageImpl#getOutputExpression()
     * @generated
     */
    EClass OUTPUT_EXPRESSION = eINSTANCE.getOutputExpression();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OUTPUT_EXPRESSION__REF = eINSTANCE.getOutputExpression_Ref();

    /**
     * The meta object literal for the '<em><b>Failure Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OUTPUT_EXPRESSION__FAILURE_EXPR = eINSTANCE.getOutputExpression_FailureExpr();

    /**
     * The meta object literal for the '{@link org.polarsys.chess.xtext.flaDsl.impl.InFailureExprImpl <em>In Failure Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.polarsys.chess.xtext.flaDsl.impl.InFailureExprImpl
     * @see org.polarsys.chess.xtext.flaDsl.impl.FlaDslPackageImpl#getInFailureExpr()
     * @generated
     */
    EClass IN_FAILURE_EXPR = eINSTANCE.getInFailureExpr();

    /**
     * The meta object literal for the '<em><b>Failures</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IN_FAILURE_EXPR__FAILURES = eINSTANCE.getInFailureExpr_Failures();

    /**
     * The meta object literal for the '{@link org.polarsys.chess.xtext.flaDsl.impl.OutFailureExprImpl <em>Out Failure Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.polarsys.chess.xtext.flaDsl.impl.OutFailureExprImpl
     * @see org.polarsys.chess.xtext.flaDsl.impl.FlaDslPackageImpl#getOutFailureExpr()
     * @generated
     */
    EClass OUT_FAILURE_EXPR = eINSTANCE.getOutFailureExpr();

    /**
     * The meta object literal for the '<em><b>Failures</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OUT_FAILURE_EXPR__FAILURES = eINSTANCE.getOutFailureExpr_Failures();

    /**
     * The meta object literal for the '{@link org.polarsys.chess.xtext.flaDsl.impl.DefinitionsImpl <em>Definitions</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.polarsys.chess.xtext.flaDsl.impl.DefinitionsImpl
     * @see org.polarsys.chess.xtext.flaDsl.impl.FlaDslPackageImpl#getDefinitions()
     * @generated
     */
    EClass DEFINITIONS = eINSTANCE.getDefinitions();

    /**
     * The meta object literal for the '{@link org.polarsys.chess.xtext.flaDsl.impl.FailureDefinitionImpl <em>Failure Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.polarsys.chess.xtext.flaDsl.impl.FailureDefinitionImpl
     * @see org.polarsys.chess.xtext.flaDsl.impl.FlaDslPackageImpl#getFailureDefinition()
     * @generated
     */
    EClass FAILURE_DEFINITION = eINSTANCE.getFailureDefinition();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FAILURE_DEFINITION__TYPE = eINSTANCE.getFailureDefinition_Type();

    /**
     * The meta object literal for the '<em><b>Acid Avoidable</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FAILURE_DEFINITION__ACID_AVOIDABLE = eINSTANCE.getFailureDefinition_AcidAvoidable();

    /**
     * The meta object literal for the '{@link org.polarsys.chess.xtext.flaDsl.impl.NoFailureDefinitionImpl <em>No Failure Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.polarsys.chess.xtext.flaDsl.impl.NoFailureDefinitionImpl
     * @see org.polarsys.chess.xtext.flaDsl.impl.FlaDslPackageImpl#getNoFailureDefinition()
     * @generated
     */
    EClass NO_FAILURE_DEFINITION = eINSTANCE.getNoFailureDefinition();

    /**
     * The meta object literal for the '<em><b>Acid Mitigation</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NO_FAILURE_DEFINITION__ACID_MITIGATION = eINSTANCE.getNoFailureDefinition_AcidMitigation();

    /**
     * The meta object literal for the '{@link org.polarsys.chess.xtext.flaDsl.impl.ComplexNofailureDefinitionImpl <em>Complex Nofailure Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.polarsys.chess.xtext.flaDsl.impl.ComplexNofailureDefinitionImpl
     * @see org.polarsys.chess.xtext.flaDsl.impl.FlaDslPackageImpl#getComplexNofailureDefinition()
     * @generated
     */
    EClass COMPLEX_NOFAILURE_DEFINITION = eINSTANCE.getComplexNofailureDefinition();

    /**
     * The meta object literal for the '{@link org.polarsys.chess.xtext.flaDsl.impl.WildcardDefinitionImpl <em>Wildcard Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.polarsys.chess.xtext.flaDsl.impl.WildcardDefinitionImpl
     * @see org.polarsys.chess.xtext.flaDsl.impl.FlaDslPackageImpl#getWildcardDefinition()
     * @generated
     */
    EClass WILDCARD_DEFINITION = eINSTANCE.getWildcardDefinition();

    /**
     * The meta object literal for the '{@link org.polarsys.chess.xtext.flaDsl.impl.VariableDefinitionImpl <em>Variable Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.polarsys.chess.xtext.flaDsl.impl.VariableDefinitionImpl
     * @see org.polarsys.chess.xtext.flaDsl.impl.FlaDslPackageImpl#getVariableDefinition()
     * @generated
     */
    EClass VARIABLE_DEFINITION = eINSTANCE.getVariableDefinition();

    /**
     * The meta object literal for the '<em><b>Variable Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE_DEFINITION__VARIABLE_NAME = eINSTANCE.getVariableDefinition_VariableName();

    /**
     * The meta object literal for the '{@link org.polarsys.chess.xtext.flaDsl.impl.ACIDavoidableImpl <em>ACI Davoidable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.polarsys.chess.xtext.flaDsl.impl.ACIDavoidableImpl
     * @see org.polarsys.chess.xtext.flaDsl.impl.FlaDslPackageImpl#getACIDavoidable()
     * @generated
     */
    EClass ACI_DAVOIDABLE = eINSTANCE.getACIDavoidable();

    /**
     * The meta object literal for the '<em><b>A</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ACI_DAVOIDABLE__A = eINSTANCE.getACIDavoidable_A();

    /**
     * The meta object literal for the '<em><b>C</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ACI_DAVOIDABLE__C = eINSTANCE.getACIDavoidable_C();

    /**
     * The meta object literal for the '<em><b>I</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ACI_DAVOIDABLE__I = eINSTANCE.getACIDavoidable_I();

    /**
     * The meta object literal for the '<em><b>D</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ACI_DAVOIDABLE__D = eINSTANCE.getACIDavoidable_D();

    /**
     * The meta object literal for the '{@link org.polarsys.chess.xtext.flaDsl.impl.ACIDMitigationImpl <em>ACID Mitigation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.polarsys.chess.xtext.flaDsl.impl.ACIDMitigationImpl
     * @see org.polarsys.chess.xtext.flaDsl.impl.FlaDslPackageImpl#getACIDMitigation()
     * @generated
     */
    EClass ACID_MITIGATION = eINSTANCE.getACIDMitigation();

    /**
     * The meta object literal for the '<em><b>A</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ACID_MITIGATION__A = eINSTANCE.getACIDMitigation_A();

    /**
     * The meta object literal for the '<em><b>C</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ACID_MITIGATION__C = eINSTANCE.getACIDMitigation_C();

    /**
     * The meta object literal for the '<em><b>I</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ACID_MITIGATION__I = eINSTANCE.getACIDMitigation_I();

    /**
     * The meta object literal for the '<em><b>D</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ACID_MITIGATION__D = eINSTANCE.getACIDMitigation_D();

    /**
     * The meta object literal for the '{@link org.polarsys.chess.xtext.flaDsl.FailureType <em>Failure Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.polarsys.chess.xtext.flaDsl.FailureType
     * @see org.polarsys.chess.xtext.flaDsl.impl.FlaDslPackageImpl#getFailureType()
     * @generated
     */
    EEnum FAILURE_TYPE = eINSTANCE.getFailureType();

    /**
     * The meta object literal for the '{@link org.polarsys.chess.xtext.flaDsl.Aavoidable <em>Aavoidable</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.polarsys.chess.xtext.flaDsl.Aavoidable
     * @see org.polarsys.chess.xtext.flaDsl.impl.FlaDslPackageImpl#getAavoidable()
     * @generated
     */
    EEnum AAVOIDABLE = eINSTANCE.getAavoidable();

    /**
     * The meta object literal for the '{@link org.polarsys.chess.xtext.flaDsl.Cavoidable <em>Cavoidable</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.polarsys.chess.xtext.flaDsl.Cavoidable
     * @see org.polarsys.chess.xtext.flaDsl.impl.FlaDslPackageImpl#getCavoidable()
     * @generated
     */
    EEnum CAVOIDABLE = eINSTANCE.getCavoidable();

    /**
     * The meta object literal for the '{@link org.polarsys.chess.xtext.flaDsl.Iavoidable <em>Iavoidable</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.polarsys.chess.xtext.flaDsl.Iavoidable
     * @see org.polarsys.chess.xtext.flaDsl.impl.FlaDslPackageImpl#getIavoidable()
     * @generated
     */
    EEnum IAVOIDABLE = eINSTANCE.getIavoidable();

    /**
     * The meta object literal for the '{@link org.polarsys.chess.xtext.flaDsl.Davoidable <em>Davoidable</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.polarsys.chess.xtext.flaDsl.Davoidable
     * @see org.polarsys.chess.xtext.flaDsl.impl.FlaDslPackageImpl#getDavoidable()
     * @generated
     */
    EEnum DAVOIDABLE = eINSTANCE.getDavoidable();

    /**
     * The meta object literal for the '{@link org.polarsys.chess.xtext.flaDsl.Amitigation <em>Amitigation</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.polarsys.chess.xtext.flaDsl.Amitigation
     * @see org.polarsys.chess.xtext.flaDsl.impl.FlaDslPackageImpl#getAmitigation()
     * @generated
     */
    EEnum AMITIGATION = eINSTANCE.getAmitigation();

    /**
     * The meta object literal for the '{@link org.polarsys.chess.xtext.flaDsl.Cmitigation <em>Cmitigation</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.polarsys.chess.xtext.flaDsl.Cmitigation
     * @see org.polarsys.chess.xtext.flaDsl.impl.FlaDslPackageImpl#getCmitigation()
     * @generated
     */
    EEnum CMITIGATION = eINSTANCE.getCmitigation();

    /**
     * The meta object literal for the '{@link org.polarsys.chess.xtext.flaDsl.Imitigation <em>Imitigation</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.polarsys.chess.xtext.flaDsl.Imitigation
     * @see org.polarsys.chess.xtext.flaDsl.impl.FlaDslPackageImpl#getImitigation()
     * @generated
     */
    EEnum IMITIGATION = eINSTANCE.getImitigation();

    /**
     * The meta object literal for the '{@link org.polarsys.chess.xtext.flaDsl.Dmitigation <em>Dmitigation</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.polarsys.chess.xtext.flaDsl.Dmitigation
     * @see org.polarsys.chess.xtext.flaDsl.impl.FlaDslPackageImpl#getDmitigation()
     * @generated
     */
    EEnum DMITIGATION = eINSTANCE.getDmitigation();

  }

} //FlaDslPackage
