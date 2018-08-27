/**
 */
package org.polarsys.chess.contracts.profile.chesscontract.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.papyrus.MARTE.MARTEPackage;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage;
import org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.BasicNFP_TypesPackage;
import org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.GRM_BasicTypesPackage;
import org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.MARTE_DataTypesPackage;
import org.eclipse.papyrus.MARTE_Library.MARTE_PrimitivesTypes.MARTE_PrimitivesTypesPackage;
import org.eclipse.papyrus.MARTE_Library.MeasurementUnits.MeasurementUnitsPackage;
import org.eclipse.papyrus.MARTE_Library.RS_Library.RS_LibraryPackage;
import org.eclipse.papyrus.MARTE_Library.TimeLibrary.TimeLibraryPackage;
import org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.TimeTypesLibraryPackage;
import org.eclipse.papyrus.sysml.SysmlPackage;
import org.eclipse.papyrus.sysml.blocks.BlocksPackage;
import org.eclipse.papyrus.sysml.constraints.ConstraintsPackage;
import org.eclipse.papyrus.sysml.requirements.RequirementsPackage;
import org.eclipse.uml2.types.TypesPackage;
import org.eclipse.uml2.uml.UMLPackage;
import org.polarsys.chess.contracts.profile.chesscontract.CHESSContractFactory;
import org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage;
import org.polarsys.chess.contracts.profile.chesscontract.CHESSRequirement;
import org.polarsys.chess.contracts.profile.chesscontract.ComponentInstance;
import org.polarsys.chess.contracts.profile.chesscontract.Contract;
import org.polarsys.chess.contracts.profile.chesscontract.ContractProperty;
import org.polarsys.chess.contracts.profile.chesscontract.ContractRefinement;
import org.polarsys.chess.contracts.profile.chesscontract.ContractRefinementAnalysisContext;
import org.polarsys.chess.contracts.profile.chesscontract.DataTypes.DataTypesPackage;
import org.polarsys.chess.contracts.profile.chesscontract.DataTypes.impl.DataTypesPackageImpl;
import org.polarsys.chess.contracts.profile.chesscontract.DelegationConstraint;
import org.polarsys.chess.contracts.profile.chesscontract.FormalProperty;
import org.polarsys.chess.contracts.profile.chesscontract.Formalize;
import org.polarsys.chess.contracts.profile.chesscontract.SRAComponent;
import org.polarsys.chess.contracts.profile.chesscontract.SubSystem;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!--
 * end-user-doc -->
 * @generated
 */
public class CHESSContractPackageImpl extends EPackageImpl implements CHESSContractPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass systemEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contractEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass formalPropertyEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contractRefinementAnalysisContextEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass formalizeEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subSystemEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass chessRequirementEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contractPropertyEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contractRefinementEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass delegationConstraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sraComponentEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentInstanceEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
	 * package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory
	 * method {@link #init init()}, which also performs initialization of the
	 * package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CHESSContractPackageImpl() {
		super(eNS_URI, CHESSContractFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model,
	 * and for any others upon which it depends.
	 * 
	 * <p>
	 * This method is used to initialize {@link CHESSContractPackage#eINSTANCE}
	 * when that field is accessed. Clients should not invoke it directly.
	 * Instead, they should simply access that field to obtain the package. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CHESSContractPackage init() {
		if (isInited) return (CHESSContractPackage)EPackage.Registry.INSTANCE.getEPackage(CHESSContractPackage.eNS_URI);

		// Obtain or create and register package
		CHESSContractPackageImpl theCHESSContractPackage = (CHESSContractPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CHESSContractPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CHESSContractPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		MARTEPackage.eINSTANCE.eClass();
		MeasurementUnitsPackage.eINSTANCE.eClass();
		GRM_BasicTypesPackage.eINSTANCE.eClass();
		MARTE_DataTypesPackage.eINSTANCE.eClass();
		BasicNFP_TypesPackage.eINSTANCE.eClass();
		TimeTypesLibraryPackage.eINSTANCE.eClass();
		TimeLibraryPackage.eINSTANCE.eClass();
		RS_LibraryPackage.eINSTANCE.eClass();
		MARTE_PrimitivesTypesPackage.eINSTANCE.eClass();
		SysmlPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		DataTypesPackageImpl theDataTypesPackage = (DataTypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DataTypesPackage.eNS_URI) instanceof DataTypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DataTypesPackage.eNS_URI) : DataTypesPackage.eINSTANCE);

		// Create package meta-data objects
		theCHESSContractPackage.createPackageContents();
		theDataTypesPackage.createPackageContents();

		// Initialize created meta-data
		theCHESSContractPackage.initializePackageContents();
		theDataTypesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCHESSContractPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CHESSContractPackage.eNS_URI, theCHESSContractPackage);
		return theCHESSContractPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSystem() {
		return systemEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContract() {
		return contractEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContract_Assume() {
		return (EReference)contractEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContract_Guarantee() {
		return (EReference)contractEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContract_Formalize() {
		return (EReference)contractEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getContract_Language() {
		return (EAttribute)contractEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getContract_ContextStatement() {
		return (EAttribute)contractEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getContract_ArtefactStatement() {
		return (EAttribute)contractEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFormalProperty() {
		return formalPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFormalProperty_Base_Constraint() {
		return (EReference)formalPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFormalProperty_Formalize() {
		return (EReference)formalPropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFormalProperty_Concern() {
		return (EAttribute)formalPropertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContractRefinementAnalysisContext() {
		return contractRefinementAnalysisContextEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getContractRefinementAnalysisContext_CheckAllWeakContracts() {
		return (EAttribute)contractRefinementAnalysisContextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFormalize() {
		return formalizeEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFormalize_Base_Abstraction() {
		return (EReference)formalizeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubSystem() {
		return subSystemEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCHESSRequirement() {
		return chessRequirementEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCHESSRequirement_Author() {
		return (EAttribute)chessRequirementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCHESSRequirement_Status() {
		return (EAttribute)chessRequirementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCHESSRequirement_Type() {
		return (EAttribute)chessRequirementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCHESSRequirement_Priority() {
		return (EAttribute)chessRequirementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCHESSRequirement_Performance() {
		return (EAttribute)chessRequirementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCHESSRequirement_Tolerance() {
		return (EAttribute)chessRequirementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCHESSRequirement_Severity() {
		return (EAttribute)chessRequirementEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCHESSRequirement_Maturity() {
		return (EAttribute)chessRequirementEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCHESSRequirement_Risk() {
		return (EAttribute)chessRequirementEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContractProperty() {
		return contractPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContractProperty_RefinedBy() {
		return (EReference)contractPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getContractProperty_ContractType() {
		return (EAttribute)contractPropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContractProperty_Base_Slot() {
		return (EReference)contractPropertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getContractProperty_Status() {
		return (EAttribute)contractPropertyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContractRefinement() {
		return contractRefinementEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContractRefinement_Base_DataType() {
		return (EReference)contractRefinementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContractRefinement_Instance() {
		return (EReference)contractRefinementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContractRefinement_Contract() {
		return (EReference)contractRefinementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContractRefinement_InstanceSpec() {
		return (EReference)contractRefinementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getContractRefinement_UpperIndexOfInstance() {
		return (EAttribute)contractRefinementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getContractRefinement_LowerIndexOfInstance() {
		return (EAttribute)contractRefinementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDelegationConstraint() {
		return delegationConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDelegationConstraint_Base_Constraint() {
		return (EReference)delegationConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSRAComponent() {
		return sraComponentEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSRAComponent_Base_Class() {
		return (EReference)sraComponentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentInstance() {
		return componentInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentInstance_Base_Property() {
		return (EReference)componentInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentInstance_WeakGuarantees() {
		return (EReference)componentInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentInstance_Base_InstanceSpecification() {
		return (EReference)componentInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public CHESSContractFactory getCHESSContractFactory() {
		return (CHESSContractFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		componentInstanceEClass = createEClass(COMPONENT_INSTANCE);
		createEReference(componentInstanceEClass, COMPONENT_INSTANCE__BASE_PROPERTY);
		createEReference(componentInstanceEClass, COMPONENT_INSTANCE__WEAK_GUARANTEES);
		createEReference(componentInstanceEClass, COMPONENT_INSTANCE__BASE_INSTANCE_SPECIFICATION);

		contractPropertyEClass = createEClass(CONTRACT_PROPERTY);
		createEReference(contractPropertyEClass, CONTRACT_PROPERTY__REFINED_BY);
		createEAttribute(contractPropertyEClass, CONTRACT_PROPERTY__CONTRACT_TYPE);
		createEReference(contractPropertyEClass, CONTRACT_PROPERTY__BASE_SLOT);
		createEAttribute(contractPropertyEClass, CONTRACT_PROPERTY__STATUS);

		contractRefinementEClass = createEClass(CONTRACT_REFINEMENT);
		createEReference(contractRefinementEClass, CONTRACT_REFINEMENT__BASE_DATA_TYPE);
		createEReference(contractRefinementEClass, CONTRACT_REFINEMENT__INSTANCE);
		createEReference(contractRefinementEClass, CONTRACT_REFINEMENT__CONTRACT);
		createEReference(contractRefinementEClass, CONTRACT_REFINEMENT__INSTANCE_SPEC);
		createEAttribute(contractRefinementEClass, CONTRACT_REFINEMENT__UPPER_INDEX_OF_INSTANCE);
		createEAttribute(contractRefinementEClass, CONTRACT_REFINEMENT__LOWER_INDEX_OF_INSTANCE);

		formalPropertyEClass = createEClass(FORMAL_PROPERTY);
		createEReference(formalPropertyEClass, FORMAL_PROPERTY__BASE_CONSTRAINT);
		createEReference(formalPropertyEClass, FORMAL_PROPERTY__FORMALIZE);
		createEAttribute(formalPropertyEClass, FORMAL_PROPERTY__CONCERN);

		contractRefinementAnalysisContextEClass = createEClass(CONTRACT_REFINEMENT_ANALYSIS_CONTEXT);
		createEAttribute(contractRefinementAnalysisContextEClass, CONTRACT_REFINEMENT_ANALYSIS_CONTEXT__CHECK_ALL_WEAK_CONTRACTS);

		systemEClass = createEClass(SYSTEM);

		contractEClass = createEClass(CONTRACT);
		createEReference(contractEClass, CONTRACT__ASSUME);
		createEReference(contractEClass, CONTRACT__GUARANTEE);
		createEReference(contractEClass, CONTRACT__FORMALIZE);
		createEAttribute(contractEClass, CONTRACT__LANGUAGE);
		createEAttribute(contractEClass, CONTRACT__CONTEXT_STATEMENT);
		createEAttribute(contractEClass, CONTRACT__ARTEFACT_STATEMENT);

		formalizeEClass = createEClass(FORMALIZE);
		createEReference(formalizeEClass, FORMALIZE__BASE_ABSTRACTION);

		subSystemEClass = createEClass(SUB_SYSTEM);

		chessRequirementEClass = createEClass(CHESS_REQUIREMENT);
		createEAttribute(chessRequirementEClass, CHESS_REQUIREMENT__AUTHOR);
		createEAttribute(chessRequirementEClass, CHESS_REQUIREMENT__STATUS);
		createEAttribute(chessRequirementEClass, CHESS_REQUIREMENT__TYPE);
		createEAttribute(chessRequirementEClass, CHESS_REQUIREMENT__PRIORITY);
		createEAttribute(chessRequirementEClass, CHESS_REQUIREMENT__PERFORMANCE);
		createEAttribute(chessRequirementEClass, CHESS_REQUIREMENT__TOLERANCE);
		createEAttribute(chessRequirementEClass, CHESS_REQUIREMENT__SEVERITY);
		createEAttribute(chessRequirementEClass, CHESS_REQUIREMENT__MATURITY);
		createEAttribute(chessRequirementEClass, CHESS_REQUIREMENT__RISK);

		delegationConstraintEClass = createEClass(DELEGATION_CONSTRAINT);
		createEReference(delegationConstraintEClass, DELEGATION_CONSTRAINT__BASE_CONSTRAINT);

		sraComponentEClass = createEClass(SRA_COMPONENT);
		createEReference(sraComponentEClass, SRA_COMPONENT__BASE_CLASS);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This
	 * method is guarded to have no affect on any invocation but its first. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		DataTypesPackage theDataTypesPackage = (DataTypesPackage)EPackage.Registry.INSTANCE.getEPackage(DataTypesPackage.eNS_URI);
		UMLPackage theUMLPackage = (UMLPackage)EPackage.Registry.INSTANCE.getEPackage(UMLPackage.eNS_URI);
		ConstraintsPackage theConstraintsPackage = (ConstraintsPackage)EPackage.Registry.INSTANCE.getEPackage(ConstraintsPackage.eNS_URI);
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
		RequirementsPackage theRequirementsPackage = (RequirementsPackage)EPackage.Registry.INSTANCE.getEPackage(RequirementsPackage.eNS_URI);
		GQAMPackage theGQAMPackage = (GQAMPackage)EPackage.Registry.INSTANCE.getEPackage(GQAMPackage.eNS_URI);
		BlocksPackage theBlocksPackage = (BlocksPackage)EPackage.Registry.INSTANCE.getEPackage(BlocksPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theDataTypesPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		contractPropertyEClass.getESuperTypes().add(theConstraintsPackage.getConstraintProperty());
		contractRefinementAnalysisContextEClass.getESuperTypes().add(theGQAMPackage.getGaAnalysisContext());
		systemEClass.getESuperTypes().add(theBlocksPackage.getBlock());
		contractEClass.getESuperTypes().add(theConstraintsPackage.getConstraintBlock());
		subSystemEClass.getESuperTypes().add(theBlocksPackage.getBlock());
		chessRequirementEClass.getESuperTypes().add(theRequirementsPackage.getRequirement());

		// Initialize classes, features, and operations; add parameters
		initEClass(componentInstanceEClass, ComponentInstance.class, "ComponentInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponentInstance_Base_Property(), theUMLPackage.getProperty(), null, "base_Property", null, 1, 1, ComponentInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getComponentInstance_WeakGuarantees(), this.getContractProperty(), null, "WeakGuarantees", null, 0, -1, ComponentInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getComponentInstance_Base_InstanceSpecification(), theUMLPackage.getInstanceSpecification(), null, "base_InstanceSpecification", null, 1, 1, ComponentInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(contractPropertyEClass, ContractProperty.class, "ContractProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getContractProperty_RefinedBy(), this.getContractRefinement(), null, "RefinedBy", null, 0, -1, ContractProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getContractProperty_ContractType(), theDataTypesPackage.getContractTypes(), "ContractType", null, 1, 1, ContractProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getContractProperty_Base_Slot(), theUMLPackage.getSlot(), null, "base_Slot", null, 1, 1, ContractProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getContractProperty_Status(), theDataTypesPackage.getContractStatus(), "status", null, 1, 1, ContractProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(contractRefinementEClass, ContractRefinement.class, "ContractRefinement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getContractRefinement_Base_DataType(), theUMLPackage.getDataType(), null, "base_DataType", null, 1, 1, ContractRefinement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getContractRefinement_Instance(), theUMLPackage.getProperty(), null, "Instance", null, 0, 1, ContractRefinement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getContractRefinement_Contract(), this.getContractProperty(), null, "Contract", null, 1, 1, ContractRefinement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getContractRefinement_InstanceSpec(), theUMLPackage.getInstanceSpecification(), null, "instanceSpec", null, 0, 1, ContractRefinement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getContractRefinement_UpperIndexOfInstance(), theTypesPackage.getString(), "UpperIndexOfInstance", null, 1, 1, ContractRefinement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getContractRefinement_LowerIndexOfInstance(), theTypesPackage.getString(), "LowerIndexOfInstance", null, 1, 1, ContractRefinement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(formalPropertyEClass, FormalProperty.class, "FormalProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFormalProperty_Base_Constraint(), theUMLPackage.getConstraint(), null, "base_Constraint", null, 1, 1, FormalProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFormalProperty_Formalize(), theRequirementsPackage.getRequirement(), null, "Formalize", null, 0, -1, FormalProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFormalProperty_Concern(), theDataTypesPackage.getConcerns(), "concern", null, 1, 1, FormalProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(contractRefinementAnalysisContextEClass, ContractRefinementAnalysisContext.class, "ContractRefinementAnalysisContext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getContractRefinementAnalysisContext_CheckAllWeakContracts(), theTypesPackage.getBoolean(), "checkAllWeakContracts", "false", 1, 1, ContractRefinementAnalysisContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(systemEClass, org.polarsys.chess.contracts.profile.chesscontract.System.class, "System", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(contractEClass, Contract.class, "Contract", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getContract_Assume(), this.getFormalProperty(), null, "Assume", null, 1, 1, Contract.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getContract_Guarantee(), this.getFormalProperty(), null, "Guarantee", null, 1, 1, Contract.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getContract_Formalize(), theRequirementsPackage.getRequirement(), null, "Formalize", null, 0, -1, Contract.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getContract_Language(), theDataTypesPackage.getLanguages(), "Language", null, 1, 1, Contract.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getContract_ContextStatement(), theTypesPackage.getString(), "contextStatement", null, 0, 1, Contract.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getContract_ArtefactStatement(), theTypesPackage.getString(), "artefactStatement", null, 0, -1, Contract.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(formalizeEClass, Formalize.class, "Formalize", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFormalize_Base_Abstraction(), theUMLPackage.getAbstraction(), null, "base_Abstraction", null, 1, 1, Formalize.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(subSystemEClass, SubSystem.class, "SubSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(chessRequirementEClass, CHESSRequirement.class, "CHESSRequirement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCHESSRequirement_Author(), theTypesPackage.getString(), "Author", null, 1, 1, CHESSRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCHESSRequirement_Status(), theDataTypesPackage.getReqStatuses(), "Status", null, 1, 1, CHESSRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCHESSRequirement_Type(), theDataTypesPackage.getReqTypes(), "Type", null, 1, 1, CHESSRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCHESSRequirement_Priority(), theDataTypesPackage.getReqPriorities(), "Priority", null, 1, 1, CHESSRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCHESSRequirement_Performance(), theTypesPackage.getString(), "Performance", null, 1, 1, CHESSRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCHESSRequirement_Tolerance(), theTypesPackage.getString(), "Tolerance", null, 1, 1, CHESSRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCHESSRequirement_Severity(), theTypesPackage.getString(), "Severity", null, 1, 1, CHESSRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCHESSRequirement_Maturity(), theDataTypesPackage.getReqMaturities(), "Maturity", null, 1, 1, CHESSRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCHESSRequirement_Risk(), theDataTypesPackage.getReqRisks(), "Risk", null, 1, 1, CHESSRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(delegationConstraintEClass, DelegationConstraint.class, "DelegationConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDelegationConstraint_Base_Constraint(), theUMLPackage.getConstraint(), null, "base_Constraint", null, 1, 1, DelegationConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(sraComponentEClass, SRAComponent.class, "SRAComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSRAComponent_Base_Class(), theUMLPackage.getClass_(), null, "base_Class", null, 1, 1, SRAComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/uml2/2.0.0/UML
		createUMLAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/uml2/2.0.0/UML</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createUMLAnnotations() {
		String source = "http://www.eclipse.org/uml2/2.0.0/UML";	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "originalName", "CHESSContract"
		   });	
		addAnnotation
		  (getCHESSRequirement_Performance(), 
		   source, 
		   new String[] {
			 "originalName", "Performance "
		   });
	}

} // CHESSContractPackageImpl
