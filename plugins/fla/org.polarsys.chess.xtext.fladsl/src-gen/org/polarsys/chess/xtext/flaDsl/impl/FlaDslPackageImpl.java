/**
 */
package org.polarsys.chess.xtext.flaDsl.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.uml2.uml.UMLPackage;

import org.polarsys.chess.xtext.flaDsl.ACIDMitigation;
import org.polarsys.chess.xtext.flaDsl.ACIDavoidable;
import org.polarsys.chess.xtext.flaDsl.Aavoidable;
import org.polarsys.chess.xtext.flaDsl.Amitigation;
import org.polarsys.chess.xtext.flaDsl.Behaviour;
import org.polarsys.chess.xtext.flaDsl.Cavoidable;
import org.polarsys.chess.xtext.flaDsl.Cmitigation;
import org.polarsys.chess.xtext.flaDsl.ComplexNofailureDefinition;
import org.polarsys.chess.xtext.flaDsl.Davoidable;
import org.polarsys.chess.xtext.flaDsl.Definitions;
import org.polarsys.chess.xtext.flaDsl.Dmitigation;
import org.polarsys.chess.xtext.flaDsl.Expression;
import org.polarsys.chess.xtext.flaDsl.FailureDefinition;
import org.polarsys.chess.xtext.flaDsl.FailureType;
import org.polarsys.chess.xtext.flaDsl.FlaDslFactory;
import org.polarsys.chess.xtext.flaDsl.FlaDslPackage;
import org.polarsys.chess.xtext.flaDsl.Iavoidable;
import org.polarsys.chess.xtext.flaDsl.Imitigation;
import org.polarsys.chess.xtext.flaDsl.InFailureExpr;
import org.polarsys.chess.xtext.flaDsl.InputExpression;
import org.polarsys.chess.xtext.flaDsl.Lhs;
import org.polarsys.chess.xtext.flaDsl.NoFailureDefinition;
import org.polarsys.chess.xtext.flaDsl.OutFailureExpr;
import org.polarsys.chess.xtext.flaDsl.OutputExpression;
import org.polarsys.chess.xtext.flaDsl.Rhs;
import org.polarsys.chess.xtext.flaDsl.VariableDefinition;
import org.polarsys.chess.xtext.flaDsl.WildcardDefinition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FlaDslPackageImpl extends EPackageImpl implements FlaDslPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass behaviourEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass expressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass lhsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rhsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass inputExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass outputExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass inFailureExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass outFailureExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass definitionsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass failureDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass noFailureDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass complexNofailureDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass wildcardDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass variableDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aciDavoidableEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass acidMitigationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum failureTypeEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum aavoidableEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum cavoidableEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum iavoidableEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum davoidableEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum amitigationEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum cmitigationEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum imitigationEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum dmitigationEEnum = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.polarsys.chess.xtext.flaDsl.FlaDslPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private FlaDslPackageImpl()
  {
    super(eNS_URI, FlaDslFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link FlaDslPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static FlaDslPackage init()
  {
    if (isInited) return (FlaDslPackage)EPackage.Registry.INSTANCE.getEPackage(FlaDslPackage.eNS_URI);

    // Obtain or create and register package
    FlaDslPackageImpl theFlaDslPackage = (FlaDslPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof FlaDslPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new FlaDslPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    UMLPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theFlaDslPackage.createPackageContents();

    // Initialize created meta-data
    theFlaDslPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theFlaDslPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(FlaDslPackage.eNS_URI, theFlaDslPackage);
    return theFlaDslPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBehaviour()
  {
    return behaviourEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBehaviour_Rules()
  {
    return (EReference)behaviourEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExpression()
  {
    return expressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExpression_Lhs()
  {
    return (EReference)expressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExpression_Rhs()
  {
    return (EReference)expressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLhs()
  {
    return lhsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLhs_Failures()
  {
    return (EReference)lhsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRhs()
  {
    return rhsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRhs_Failures()
  {
    return (EReference)rhsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInputExpression()
  {
    return inputExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInputExpression_Ref()
  {
    return (EReference)inputExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInputExpression_FailureExpr()
  {
    return (EReference)inputExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOutputExpression()
  {
    return outputExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOutputExpression_Ref()
  {
    return (EReference)outputExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOutputExpression_FailureExpr()
  {
    return (EReference)outputExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInFailureExpr()
  {
    return inFailureExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInFailureExpr_Failures()
  {
    return (EReference)inFailureExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOutFailureExpr()
  {
    return outFailureExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOutFailureExpr_Failures()
  {
    return (EReference)outFailureExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDefinitions()
  {
    return definitionsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFailureDefinition()
  {
    return failureDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFailureDefinition_Type()
  {
    return (EAttribute)failureDefinitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFailureDefinition_AcidAvoidable()
  {
    return (EReference)failureDefinitionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNoFailureDefinition()
  {
    return noFailureDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNoFailureDefinition_AcidMitigation()
  {
    return (EReference)noFailureDefinitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getComplexNofailureDefinition()
  {
    return complexNofailureDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getWildcardDefinition()
  {
    return wildcardDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVariableDefinition()
  {
    return variableDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVariableDefinition_VariableName()
  {
    return (EAttribute)variableDefinitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getACIDavoidable()
  {
    return aciDavoidableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getACIDavoidable_A()
  {
    return (EAttribute)aciDavoidableEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getACIDavoidable_C()
  {
    return (EAttribute)aciDavoidableEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getACIDavoidable_I()
  {
    return (EAttribute)aciDavoidableEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getACIDavoidable_D()
  {
    return (EAttribute)aciDavoidableEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getACIDMitigation()
  {
    return acidMitigationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getACIDMitigation_A()
  {
    return (EAttribute)acidMitigationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getACIDMitigation_C()
  {
    return (EAttribute)acidMitigationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getACIDMitigation_I()
  {
    return (EAttribute)acidMitigationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getACIDMitigation_D()
  {
    return (EAttribute)acidMitigationEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getFailureType()
  {
    return failureTypeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getAavoidable()
  {
    return aavoidableEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getCavoidable()
  {
    return cavoidableEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getIavoidable()
  {
    return iavoidableEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getDavoidable()
  {
    return davoidableEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getAmitigation()
  {
    return amitigationEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getCmitigation()
  {
    return cmitigationEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getImitigation()
  {
    return imitigationEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getDmitigation()
  {
    return dmitigationEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FlaDslFactory getFlaDslFactory()
  {
    return (FlaDslFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    behaviourEClass = createEClass(BEHAVIOUR);
    createEReference(behaviourEClass, BEHAVIOUR__RULES);

    expressionEClass = createEClass(EXPRESSION);
    createEReference(expressionEClass, EXPRESSION__LHS);
    createEReference(expressionEClass, EXPRESSION__RHS);

    lhsEClass = createEClass(LHS);
    createEReference(lhsEClass, LHS__FAILURES);

    rhsEClass = createEClass(RHS);
    createEReference(rhsEClass, RHS__FAILURES);

    inputExpressionEClass = createEClass(INPUT_EXPRESSION);
    createEReference(inputExpressionEClass, INPUT_EXPRESSION__REF);
    createEReference(inputExpressionEClass, INPUT_EXPRESSION__FAILURE_EXPR);

    outputExpressionEClass = createEClass(OUTPUT_EXPRESSION);
    createEReference(outputExpressionEClass, OUTPUT_EXPRESSION__REF);
    createEReference(outputExpressionEClass, OUTPUT_EXPRESSION__FAILURE_EXPR);

    inFailureExprEClass = createEClass(IN_FAILURE_EXPR);
    createEReference(inFailureExprEClass, IN_FAILURE_EXPR__FAILURES);

    outFailureExprEClass = createEClass(OUT_FAILURE_EXPR);
    createEReference(outFailureExprEClass, OUT_FAILURE_EXPR__FAILURES);

    definitionsEClass = createEClass(DEFINITIONS);

    failureDefinitionEClass = createEClass(FAILURE_DEFINITION);
    createEAttribute(failureDefinitionEClass, FAILURE_DEFINITION__TYPE);
    createEReference(failureDefinitionEClass, FAILURE_DEFINITION__ACID_AVOIDABLE);

    noFailureDefinitionEClass = createEClass(NO_FAILURE_DEFINITION);
    createEReference(noFailureDefinitionEClass, NO_FAILURE_DEFINITION__ACID_MITIGATION);

    complexNofailureDefinitionEClass = createEClass(COMPLEX_NOFAILURE_DEFINITION);

    wildcardDefinitionEClass = createEClass(WILDCARD_DEFINITION);

    variableDefinitionEClass = createEClass(VARIABLE_DEFINITION);
    createEAttribute(variableDefinitionEClass, VARIABLE_DEFINITION__VARIABLE_NAME);

    aciDavoidableEClass = createEClass(ACI_DAVOIDABLE);
    createEAttribute(aciDavoidableEClass, ACI_DAVOIDABLE__A);
    createEAttribute(aciDavoidableEClass, ACI_DAVOIDABLE__C);
    createEAttribute(aciDavoidableEClass, ACI_DAVOIDABLE__I);
    createEAttribute(aciDavoidableEClass, ACI_DAVOIDABLE__D);

    acidMitigationEClass = createEClass(ACID_MITIGATION);
    createEAttribute(acidMitigationEClass, ACID_MITIGATION__A);
    createEAttribute(acidMitigationEClass, ACID_MITIGATION__C);
    createEAttribute(acidMitigationEClass, ACID_MITIGATION__I);
    createEAttribute(acidMitigationEClass, ACID_MITIGATION__D);

    // Create enums
    failureTypeEEnum = createEEnum(FAILURE_TYPE);
    aavoidableEEnum = createEEnum(AAVOIDABLE);
    cavoidableEEnum = createEEnum(CAVOIDABLE);
    iavoidableEEnum = createEEnum(IAVOIDABLE);
    davoidableEEnum = createEEnum(DAVOIDABLE);
    amitigationEEnum = createEEnum(AMITIGATION);
    cmitigationEEnum = createEEnum(CMITIGATION);
    imitigationEEnum = createEEnum(IMITIGATION);
    dmitigationEEnum = createEEnum(DMITIGATION);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    UMLPackage theUMLPackage = (UMLPackage)EPackage.Registry.INSTANCE.getEPackage(UMLPackage.eNS_URI);
    EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    failureDefinitionEClass.getESuperTypes().add(this.getDefinitions());
    noFailureDefinitionEClass.getESuperTypes().add(this.getDefinitions());
    noFailureDefinitionEClass.getESuperTypes().add(this.getComplexNofailureDefinition());
    complexNofailureDefinitionEClass.getESuperTypes().add(this.getDefinitions());
    wildcardDefinitionEClass.getESuperTypes().add(this.getDefinitions());
    variableDefinitionEClass.getESuperTypes().add(this.getDefinitions());

    // Initialize classes and features; add operations and parameters
    initEClass(behaviourEClass, Behaviour.class, "Behaviour", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBehaviour_Rules(), this.getExpression(), null, "rules", null, 0, -1, Behaviour.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(expressionEClass, Expression.class, "Expression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getExpression_Lhs(), this.getLhs(), null, "lhs", null, 0, 1, Expression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getExpression_Rhs(), this.getRhs(), null, "rhs", null, 0, 1, Expression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(lhsEClass, Lhs.class, "Lhs", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLhs_Failures(), this.getInputExpression(), null, "failures", null, 0, -1, Lhs.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(rhsEClass, Rhs.class, "Rhs", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRhs_Failures(), this.getOutputExpression(), null, "failures", null, 0, -1, Rhs.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(inputExpressionEClass, InputExpression.class, "InputExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getInputExpression_Ref(), theUMLPackage.getPort(), null, "ref", null, 0, 1, InputExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getInputExpression_FailureExpr(), this.getInFailureExpr(), null, "failureExpr", null, 0, 1, InputExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(outputExpressionEClass, OutputExpression.class, "OutputExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOutputExpression_Ref(), theUMLPackage.getPort(), null, "ref", null, 0, 1, OutputExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOutputExpression_FailureExpr(), this.getOutFailureExpr(), null, "failureExpr", null, 0, 1, OutputExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(inFailureExprEClass, InFailureExpr.class, "InFailureExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getInFailureExpr_Failures(), this.getDefinitions(), null, "failures", null, 0, -1, InFailureExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(outFailureExprEClass, OutFailureExpr.class, "OutFailureExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOutFailureExpr_Failures(), this.getDefinitions(), null, "failures", null, 0, -1, OutFailureExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(definitionsEClass, Definitions.class, "Definitions", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(failureDefinitionEClass, FailureDefinition.class, "FailureDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFailureDefinition_Type(), this.getFailureType(), "type", null, 0, 1, FailureDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFailureDefinition_AcidAvoidable(), this.getACIDavoidable(), null, "acidAvoidable", null, 0, 1, FailureDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(noFailureDefinitionEClass, NoFailureDefinition.class, "NoFailureDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNoFailureDefinition_AcidMitigation(), this.getACIDMitigation(), null, "acidMitigation", null, 0, 1, NoFailureDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(complexNofailureDefinitionEClass, ComplexNofailureDefinition.class, "ComplexNofailureDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(wildcardDefinitionEClass, WildcardDefinition.class, "WildcardDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(variableDefinitionEClass, VariableDefinition.class, "VariableDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVariableDefinition_VariableName(), theEcorePackage.getEString(), "variableName", null, 0, 1, VariableDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aciDavoidableEClass, ACIDavoidable.class, "ACIDavoidable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getACIDavoidable_A(), this.getAavoidable(), "a", null, 0, 1, ACIDavoidable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getACIDavoidable_C(), this.getCavoidable(), "c", null, 0, 1, ACIDavoidable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getACIDavoidable_I(), this.getIavoidable(), "i", null, 0, 1, ACIDavoidable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getACIDavoidable_D(), this.getDavoidable(), "d", null, 0, 1, ACIDavoidable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(acidMitigationEClass, ACIDMitigation.class, "ACIDMitigation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getACIDMitigation_A(), this.getAmitigation(), "a", null, 0, 1, ACIDMitigation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getACIDMitigation_C(), this.getCmitigation(), "c", null, 0, 1, ACIDMitigation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getACIDMitigation_I(), this.getImitigation(), "i", null, 0, 1, ACIDMitigation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getACIDMitigation_D(), this.getDmitigation(), "d", null, 0, 1, ACIDMitigation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(failureTypeEEnum, FailureType.class, "FailureType");
    addEEnumLiteral(failureTypeEEnum, FailureType.NO_FAILURE);
    addEEnumLiteral(failureTypeEEnum, FailureType.EARLY);
    addEEnumLiteral(failureTypeEEnum, FailureType.LATE);
    addEEnumLiteral(failureTypeEEnum, FailureType.COMMISSION);
    addEEnumLiteral(failureTypeEEnum, FailureType.OMISSION);
    addEEnumLiteral(failureTypeEEnum, FailureType.VALUE_SUBTLE);
    addEEnumLiteral(failureTypeEEnum, FailureType.VALUE_COARSE);
    addEEnumLiteral(failureTypeEEnum, FailureType.WILDCARD);
    addEEnumLiteral(failureTypeEEnum, FailureType.VARIABLE);

    initEEnum(aavoidableEEnum, Aavoidable.class, "Aavoidable");
    addEEnumLiteral(aavoidableEEnum, Aavoidable.INCOMPLETION);
    addEEnumLiteral(aavoidableEEnum, Aavoidable.NONE);
    addEEnumLiteral(aavoidableEEnum, Aavoidable.UNSPECIFIED);

    initEEnum(cavoidableEEnum, Cavoidable.class, "Cavoidable");
    addEEnumLiteral(cavoidableEEnum, Cavoidable.INCONSISTENCY);
    addEEnumLiteral(cavoidableEEnum, Cavoidable.NONE);
    addEEnumLiteral(cavoidableEEnum, Cavoidable.UNSPECIFIED);

    initEEnum(iavoidableEEnum, Iavoidable.class, "Iavoidable");
    addEEnumLiteral(iavoidableEEnum, Iavoidable.INTERFERENCE);
    addEEnumLiteral(iavoidableEEnum, Iavoidable.NONE);
    addEEnumLiteral(iavoidableEEnum, Iavoidable.UNSPECIFIED);

    initEEnum(davoidableEEnum, Davoidable.class, "Davoidable");
    addEEnumLiteral(davoidableEEnum, Davoidable.IMPERMANENCE);
    addEEnumLiteral(davoidableEEnum, Davoidable.NONE);
    addEEnumLiteral(davoidableEEnum, Davoidable.UNSPECIFIED);

    initEEnum(amitigationEEnum, Amitigation.class, "Amitigation");
    addEEnumLiteral(amitigationEEnum, Amitigation.ALL_OR_NOTHING);
    addEEnumLiteral(amitigationEEnum, Amitigation.ALL_OR_COMPENSATION);
    addEEnumLiteral(amitigationEEnum, Amitigation.NONE);
    addEEnumLiteral(amitigationEEnum, Amitigation.UNSPECIFIED);

    initEEnum(cmitigationEEnum, Cmitigation.class, "Cmitigation");
    addEEnumLiteral(cmitigationEEnum, Cmitigation.FULL_CONSISTENCY);
    addEEnumLiteral(cmitigationEEnum, Cmitigation.RANGE_VIOLATION_ALLOWED);
    addEEnumLiteral(cmitigationEEnum, Cmitigation.NONE);
    addEEnumLiteral(cmitigationEEnum, Cmitigation.UNSPECIFIED);

    initEEnum(imitigationEEnum, Imitigation.class, "Imitigation");
    addEEnumLiteral(imitigationEEnum, Imitigation.SERIALIZABLE);
    addEEnumLiteral(imitigationEEnum, Imitigation.PORTABLE_LEVEL);
    addEEnumLiteral(imitigationEEnum, Imitigation.NONE);
    addEEnumLiteral(imitigationEEnum, Imitigation.UNSPECIFIED);

    initEEnum(dmitigationEEnum, Dmitigation.class, "Dmitigation");
    addEEnumLiteral(dmitigationEEnum, Dmitigation.NO_LOSS);
    addEEnumLiteral(dmitigationEEnum, Dmitigation.PARTIAL_LOSS_ALLOWED);
    addEEnumLiteral(dmitigationEEnum, Dmitigation.NONE);
    addEEnumLiteral(dmitigationEEnum, Dmitigation.UNSPECIFIED);

    // Create resource
    createResource(eNS_URI);
  }

} //FlaDslPackageImpl
