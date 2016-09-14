/**
 */
package org.polarsys.chess.xtext.flaDsl.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.polarsys.chess.xtext.flaDsl.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.polarsys.chess.xtext.flaDsl.FlaDslPackage
 * @generated
 */
public class FlaDslSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static FlaDslPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FlaDslSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = FlaDslPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case FlaDslPackage.BEHAVIOUR:
      {
        Behaviour behaviour = (Behaviour)theEObject;
        T result = caseBehaviour(behaviour);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FlaDslPackage.EXPRESSION:
      {
        Expression expression = (Expression)theEObject;
        T result = caseExpression(expression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FlaDslPackage.LHS:
      {
        Lhs lhs = (Lhs)theEObject;
        T result = caseLhs(lhs);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FlaDslPackage.RHS:
      {
        Rhs rhs = (Rhs)theEObject;
        T result = caseRhs(rhs);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FlaDslPackage.INPUT_EXPRESSION:
      {
        InputExpression inputExpression = (InputExpression)theEObject;
        T result = caseInputExpression(inputExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FlaDslPackage.OUTPUT_EXPRESSION:
      {
        OutputExpression outputExpression = (OutputExpression)theEObject;
        T result = caseOutputExpression(outputExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FlaDslPackage.IN_FAILURE_EXPR:
      {
        InFailureExpr inFailureExpr = (InFailureExpr)theEObject;
        T result = caseInFailureExpr(inFailureExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FlaDslPackage.OUT_FAILURE_EXPR:
      {
        OutFailureExpr outFailureExpr = (OutFailureExpr)theEObject;
        T result = caseOutFailureExpr(outFailureExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FlaDslPackage.DEFINITIONS:
      {
        Definitions definitions = (Definitions)theEObject;
        T result = caseDefinitions(definitions);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FlaDslPackage.FAILURE_DEFINITION:
      {
        FailureDefinition failureDefinition = (FailureDefinition)theEObject;
        T result = caseFailureDefinition(failureDefinition);
        if (result == null) result = caseDefinitions(failureDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FlaDslPackage.NO_FAILURE_DEFINITION:
      {
        NoFailureDefinition noFailureDefinition = (NoFailureDefinition)theEObject;
        T result = caseNoFailureDefinition(noFailureDefinition);
        if (result == null) result = caseComplexNofailureDefinition(noFailureDefinition);
        if (result == null) result = caseDefinitions(noFailureDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FlaDslPackage.COMPLEX_NOFAILURE_DEFINITION:
      {
        ComplexNofailureDefinition complexNofailureDefinition = (ComplexNofailureDefinition)theEObject;
        T result = caseComplexNofailureDefinition(complexNofailureDefinition);
        if (result == null) result = caseDefinitions(complexNofailureDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FlaDslPackage.WILDCARD_DEFINITION:
      {
        WildcardDefinition wildcardDefinition = (WildcardDefinition)theEObject;
        T result = caseWildcardDefinition(wildcardDefinition);
        if (result == null) result = caseDefinitions(wildcardDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FlaDslPackage.VARIABLE_DEFINITION:
      {
        VariableDefinition variableDefinition = (VariableDefinition)theEObject;
        T result = caseVariableDefinition(variableDefinition);
        if (result == null) result = caseDefinitions(variableDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FlaDslPackage.ACI_DAVOIDABLE:
      {
        ACIDavoidable aciDavoidable = (ACIDavoidable)theEObject;
        T result = caseACIDavoidable(aciDavoidable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FlaDslPackage.ACID_MITIGATION:
      {
        ACIDMitigation acidMitigation = (ACIDMitigation)theEObject;
        T result = caseACIDMitigation(acidMitigation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Behaviour</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Behaviour</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBehaviour(Behaviour object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpression(Expression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Lhs</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Lhs</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLhs(Lhs object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rhs</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rhs</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRhs(Rhs object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Input Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Input Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInputExpression(InputExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Output Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Output Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOutputExpression(OutputExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>In Failure Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>In Failure Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInFailureExpr(InFailureExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Out Failure Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Out Failure Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOutFailureExpr(OutFailureExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Definitions</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Definitions</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDefinitions(Definitions object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Failure Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Failure Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFailureDefinition(FailureDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>No Failure Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>No Failure Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNoFailureDefinition(NoFailureDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Complex Nofailure Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Complex Nofailure Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseComplexNofailureDefinition(ComplexNofailureDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Wildcard Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Wildcard Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseWildcardDefinition(WildcardDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Variable Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Variable Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVariableDefinition(VariableDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ACI Davoidable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ACI Davoidable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseACIDavoidable(ACIDavoidable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ACID Mitigation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ACID Mitigation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseACIDMitigation(ACIDMitigation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //FlaDslSwitch
