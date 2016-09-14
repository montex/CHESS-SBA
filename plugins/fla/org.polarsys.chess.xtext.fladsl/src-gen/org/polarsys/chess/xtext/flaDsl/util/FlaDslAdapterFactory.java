/**
 */
package org.polarsys.chess.xtext.flaDsl.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.polarsys.chess.xtext.flaDsl.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.polarsys.chess.xtext.flaDsl.FlaDslPackage
 * @generated
 */
public class FlaDslAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static FlaDslPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FlaDslAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = FlaDslPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FlaDslSwitch<Adapter> modelSwitch =
    new FlaDslSwitch<Adapter>()
    {
      @Override
      public Adapter caseBehaviour(Behaviour object)
      {
        return createBehaviourAdapter();
      }
      @Override
      public Adapter caseExpression(Expression object)
      {
        return createExpressionAdapter();
      }
      @Override
      public Adapter caseLhs(Lhs object)
      {
        return createLhsAdapter();
      }
      @Override
      public Adapter caseRhs(Rhs object)
      {
        return createRhsAdapter();
      }
      @Override
      public Adapter caseInputExpression(InputExpression object)
      {
        return createInputExpressionAdapter();
      }
      @Override
      public Adapter caseOutputExpression(OutputExpression object)
      {
        return createOutputExpressionAdapter();
      }
      @Override
      public Adapter caseInFailureExpr(InFailureExpr object)
      {
        return createInFailureExprAdapter();
      }
      @Override
      public Adapter caseOutFailureExpr(OutFailureExpr object)
      {
        return createOutFailureExprAdapter();
      }
      @Override
      public Adapter caseDefinitions(Definitions object)
      {
        return createDefinitionsAdapter();
      }
      @Override
      public Adapter caseFailureDefinition(FailureDefinition object)
      {
        return createFailureDefinitionAdapter();
      }
      @Override
      public Adapter caseNoFailureDefinition(NoFailureDefinition object)
      {
        return createNoFailureDefinitionAdapter();
      }
      @Override
      public Adapter caseComplexNofailureDefinition(ComplexNofailureDefinition object)
      {
        return createComplexNofailureDefinitionAdapter();
      }
      @Override
      public Adapter caseWildcardDefinition(WildcardDefinition object)
      {
        return createWildcardDefinitionAdapter();
      }
      @Override
      public Adapter caseVariableDefinition(VariableDefinition object)
      {
        return createVariableDefinitionAdapter();
      }
      @Override
      public Adapter caseACIDavoidable(ACIDavoidable object)
      {
        return createACIDavoidableAdapter();
      }
      @Override
      public Adapter caseACIDMitigation(ACIDMitigation object)
      {
        return createACIDMitigationAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link org.polarsys.chess.xtext.flaDsl.Behaviour <em>Behaviour</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.polarsys.chess.xtext.flaDsl.Behaviour
   * @generated
   */
  public Adapter createBehaviourAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.polarsys.chess.xtext.flaDsl.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.polarsys.chess.xtext.flaDsl.Expression
   * @generated
   */
  public Adapter createExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.polarsys.chess.xtext.flaDsl.Lhs <em>Lhs</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.polarsys.chess.xtext.flaDsl.Lhs
   * @generated
   */
  public Adapter createLhsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.polarsys.chess.xtext.flaDsl.Rhs <em>Rhs</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.polarsys.chess.xtext.flaDsl.Rhs
   * @generated
   */
  public Adapter createRhsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.polarsys.chess.xtext.flaDsl.InputExpression <em>Input Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.polarsys.chess.xtext.flaDsl.InputExpression
   * @generated
   */
  public Adapter createInputExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.polarsys.chess.xtext.flaDsl.OutputExpression <em>Output Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.polarsys.chess.xtext.flaDsl.OutputExpression
   * @generated
   */
  public Adapter createOutputExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.polarsys.chess.xtext.flaDsl.InFailureExpr <em>In Failure Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.polarsys.chess.xtext.flaDsl.InFailureExpr
   * @generated
   */
  public Adapter createInFailureExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.polarsys.chess.xtext.flaDsl.OutFailureExpr <em>Out Failure Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.polarsys.chess.xtext.flaDsl.OutFailureExpr
   * @generated
   */
  public Adapter createOutFailureExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.polarsys.chess.xtext.flaDsl.Definitions <em>Definitions</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.polarsys.chess.xtext.flaDsl.Definitions
   * @generated
   */
  public Adapter createDefinitionsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.polarsys.chess.xtext.flaDsl.FailureDefinition <em>Failure Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.polarsys.chess.xtext.flaDsl.FailureDefinition
   * @generated
   */
  public Adapter createFailureDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.polarsys.chess.xtext.flaDsl.NoFailureDefinition <em>No Failure Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.polarsys.chess.xtext.flaDsl.NoFailureDefinition
   * @generated
   */
  public Adapter createNoFailureDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.polarsys.chess.xtext.flaDsl.ComplexNofailureDefinition <em>Complex Nofailure Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.polarsys.chess.xtext.flaDsl.ComplexNofailureDefinition
   * @generated
   */
  public Adapter createComplexNofailureDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.polarsys.chess.xtext.flaDsl.WildcardDefinition <em>Wildcard Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.polarsys.chess.xtext.flaDsl.WildcardDefinition
   * @generated
   */
  public Adapter createWildcardDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.polarsys.chess.xtext.flaDsl.VariableDefinition <em>Variable Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.polarsys.chess.xtext.flaDsl.VariableDefinition
   * @generated
   */
  public Adapter createVariableDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.polarsys.chess.xtext.flaDsl.ACIDavoidable <em>ACI Davoidable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.polarsys.chess.xtext.flaDsl.ACIDavoidable
   * @generated
   */
  public Adapter createACIDavoidableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.polarsys.chess.xtext.flaDsl.ACIDMitigation <em>ACID Mitigation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.polarsys.chess.xtext.flaDsl.ACIDMitigation
   * @generated
   */
  public Adapter createACIDMitigationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //FlaDslAdapterFactory
