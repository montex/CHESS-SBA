/**
 */
package org.polarsys.chess.xtext.flaDsl.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.polarsys.chess.xtext.flaDsl.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FlaDslFactoryImpl extends EFactoryImpl implements FlaDslFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static FlaDslFactory init()
  {
    try
    {
      FlaDslFactory theFlaDslFactory = (FlaDslFactory)EPackage.Registry.INSTANCE.getEFactory(FlaDslPackage.eNS_URI);
      if (theFlaDslFactory != null)
      {
        return theFlaDslFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new FlaDslFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FlaDslFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case FlaDslPackage.BEHAVIOUR: return createBehaviour();
      case FlaDslPackage.EXPRESSION: return createExpression();
      case FlaDslPackage.LHS: return createLhs();
      case FlaDslPackage.RHS: return createRhs();
      case FlaDslPackage.INPUT_EXPRESSION: return createInputExpression();
      case FlaDslPackage.OUTPUT_EXPRESSION: return createOutputExpression();
      case FlaDslPackage.IN_FAILURE_EXPR: return createInFailureExpr();
      case FlaDslPackage.OUT_FAILURE_EXPR: return createOutFailureExpr();
      case FlaDslPackage.DEFINITIONS: return createDefinitions();
      case FlaDslPackage.FAILURE_DEFINITION: return createFailureDefinition();
      case FlaDslPackage.NO_FAILURE_DEFINITION: return createNoFailureDefinition();
      case FlaDslPackage.COMPLEX_NOFAILURE_DEFINITION: return createComplexNofailureDefinition();
      case FlaDslPackage.WILDCARD_DEFINITION: return createWildcardDefinition();
      case FlaDslPackage.VARIABLE_DEFINITION: return createVariableDefinition();
      case FlaDslPackage.ACI_DAVOIDABLE: return createACIDavoidable();
      case FlaDslPackage.ACID_MITIGATION: return createACIDMitigation();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case FlaDslPackage.FAILURE_TYPE:
        return createFailureTypeFromString(eDataType, initialValue);
      case FlaDslPackage.AAVOIDABLE:
        return createAavoidableFromString(eDataType, initialValue);
      case FlaDslPackage.CAVOIDABLE:
        return createCavoidableFromString(eDataType, initialValue);
      case FlaDslPackage.IAVOIDABLE:
        return createIavoidableFromString(eDataType, initialValue);
      case FlaDslPackage.DAVOIDABLE:
        return createDavoidableFromString(eDataType, initialValue);
      case FlaDslPackage.AMITIGATION:
        return createAmitigationFromString(eDataType, initialValue);
      case FlaDslPackage.CMITIGATION:
        return createCmitigationFromString(eDataType, initialValue);
      case FlaDslPackage.IMITIGATION:
        return createImitigationFromString(eDataType, initialValue);
      case FlaDslPackage.DMITIGATION:
        return createDmitigationFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case FlaDslPackage.FAILURE_TYPE:
        return convertFailureTypeToString(eDataType, instanceValue);
      case FlaDslPackage.AAVOIDABLE:
        return convertAavoidableToString(eDataType, instanceValue);
      case FlaDslPackage.CAVOIDABLE:
        return convertCavoidableToString(eDataType, instanceValue);
      case FlaDslPackage.IAVOIDABLE:
        return convertIavoidableToString(eDataType, instanceValue);
      case FlaDslPackage.DAVOIDABLE:
        return convertDavoidableToString(eDataType, instanceValue);
      case FlaDslPackage.AMITIGATION:
        return convertAmitigationToString(eDataType, instanceValue);
      case FlaDslPackage.CMITIGATION:
        return convertCmitigationToString(eDataType, instanceValue);
      case FlaDslPackage.IMITIGATION:
        return convertImitigationToString(eDataType, instanceValue);
      case FlaDslPackage.DMITIGATION:
        return convertDmitigationToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Behaviour createBehaviour()
  {
    BehaviourImpl behaviour = new BehaviourImpl();
    return behaviour;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression createExpression()
  {
    ExpressionImpl expression = new ExpressionImpl();
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Lhs createLhs()
  {
    LhsImpl lhs = new LhsImpl();
    return lhs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rhs createRhs()
  {
    RhsImpl rhs = new RhsImpl();
    return rhs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InputExpression createInputExpression()
  {
    InputExpressionImpl inputExpression = new InputExpressionImpl();
    return inputExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OutputExpression createOutputExpression()
  {
    OutputExpressionImpl outputExpression = new OutputExpressionImpl();
    return outputExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InFailureExpr createInFailureExpr()
  {
    InFailureExprImpl inFailureExpr = new InFailureExprImpl();
    return inFailureExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OutFailureExpr createOutFailureExpr()
  {
    OutFailureExprImpl outFailureExpr = new OutFailureExprImpl();
    return outFailureExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Definitions createDefinitions()
  {
    DefinitionsImpl definitions = new DefinitionsImpl();
    return definitions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FailureDefinition createFailureDefinition()
  {
    FailureDefinitionImpl failureDefinition = new FailureDefinitionImpl();
    return failureDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NoFailureDefinition createNoFailureDefinition()
  {
    NoFailureDefinitionImpl noFailureDefinition = new NoFailureDefinitionImpl();
    return noFailureDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComplexNofailureDefinition createComplexNofailureDefinition()
  {
    ComplexNofailureDefinitionImpl complexNofailureDefinition = new ComplexNofailureDefinitionImpl();
    return complexNofailureDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WildcardDefinition createWildcardDefinition()
  {
    WildcardDefinitionImpl wildcardDefinition = new WildcardDefinitionImpl();
    return wildcardDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VariableDefinition createVariableDefinition()
  {
    VariableDefinitionImpl variableDefinition = new VariableDefinitionImpl();
    return variableDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ACIDavoidable createACIDavoidable()
  {
    ACIDavoidableImpl aciDavoidable = new ACIDavoidableImpl();
    return aciDavoidable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ACIDMitigation createACIDMitigation()
  {
    ACIDMitigationImpl acidMitigation = new ACIDMitigationImpl();
    return acidMitigation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FailureType createFailureTypeFromString(EDataType eDataType, String initialValue)
  {
    FailureType result = FailureType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertFailureTypeToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Aavoidable createAavoidableFromString(EDataType eDataType, String initialValue)
  {
    Aavoidable result = Aavoidable.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertAavoidableToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Cavoidable createCavoidableFromString(EDataType eDataType, String initialValue)
  {
    Cavoidable result = Cavoidable.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertCavoidableToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Iavoidable createIavoidableFromString(EDataType eDataType, String initialValue)
  {
    Iavoidable result = Iavoidable.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertIavoidableToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Davoidable createDavoidableFromString(EDataType eDataType, String initialValue)
  {
    Davoidable result = Davoidable.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertDavoidableToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Amitigation createAmitigationFromString(EDataType eDataType, String initialValue)
  {
    Amitigation result = Amitigation.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertAmitigationToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Cmitigation createCmitigationFromString(EDataType eDataType, String initialValue)
  {
    Cmitigation result = Cmitigation.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertCmitigationToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Imitigation createImitigationFromString(EDataType eDataType, String initialValue)
  {
    Imitigation result = Imitigation.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertImitigationToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Dmitigation createDmitigationFromString(EDataType eDataType, String initialValue)
  {
    Dmitigation result = Dmitigation.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertDmitigationToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FlaDslPackage getFlaDslPackage()
  {
    return (FlaDslPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static FlaDslPackage getPackage()
  {
    return FlaDslPackage.eINSTANCE;
  }

} //FlaDslFactoryImpl
