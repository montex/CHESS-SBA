/**
 */
package org.polarsys.chess.contracts.profile.chesscontract.DataTypes.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.papyrus.MARTE.MARTEPackage;
import org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.BasicNFP_TypesPackage;
import org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.GRM_BasicTypesPackage;
import org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.MARTE_DataTypesPackage;
import org.eclipse.papyrus.MARTE_Library.MARTE_PrimitivesTypes.MARTE_PrimitivesTypesPackage;
import org.eclipse.papyrus.MARTE_Library.MeasurementUnits.MeasurementUnitsPackage;
import org.eclipse.papyrus.MARTE_Library.RS_Library.RS_LibraryPackage;
import org.eclipse.papyrus.MARTE_Library.TimeLibrary.TimeLibraryPackage;
import org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.TimeTypesLibraryPackage;
import org.eclipse.papyrus.sysml.SysmlPackage;

import org.eclipse.uml2.types.TypesPackage;

import org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage;

import org.polarsys.chess.contracts.profile.chesscontract.DataTypes.Concerns;
import org.polarsys.chess.contracts.profile.chesscontract.DataTypes.Continuous;
import org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ContractStatus;
import org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ContractTypes;
import org.polarsys.chess.contracts.profile.chesscontract.DataTypes.DataTypesFactory;
import org.polarsys.chess.contracts.profile.chesscontract.DataTypes.DataTypesPackage;
import org.polarsys.chess.contracts.profile.chesscontract.DataTypes.Languages;
import org.polarsys.chess.contracts.profile.chesscontract.DataTypes.OthelloConstraint;
import org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqMaturities;
import org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqPriorities;
import org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqRisks;
import org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqStatuses;
import org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqTypes;

import org.polarsys.chess.contracts.profile.chesscontract.impl.CHESSContractPackageImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!--
 * end-user-doc -->
 * @generated
 */
public class DataTypesPackageImpl extends EPackageImpl implements DataTypesPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass othelloConstraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass continuousEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum reqStatusesEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum reqTypesEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum reqPrioritiesEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum reqMaturitiesEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum reqRisksEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum languagesEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum contractStatusEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum concernsEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum contractTypesEEnum = null;

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
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.DataTypesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DataTypesPackageImpl() {
		super(eNS_URI, DataTypesFactory.eINSTANCE);
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
	 * This method is used to initialize {@link DataTypesPackage#eINSTANCE} when
	 * that field is accessed. Clients should not invoke it directly. Instead,
	 * they should simply access that field to obtain the package. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DataTypesPackage init() {
		if (isInited) return (DataTypesPackage)EPackage.Registry.INSTANCE.getEPackage(DataTypesPackage.eNS_URI);

		// Obtain or create and register package
		DataTypesPackageImpl theDataTypesPackage = (DataTypesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DataTypesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DataTypesPackageImpl());

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
		CHESSContractPackageImpl theCHESSContractPackage = (CHESSContractPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CHESSContractPackage.eNS_URI) instanceof CHESSContractPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CHESSContractPackage.eNS_URI) : CHESSContractPackage.eINSTANCE);

		// Create package meta-data objects
		theDataTypesPackage.createPackageContents();
		theCHESSContractPackage.createPackageContents();

		// Initialize created meta-data
		theDataTypesPackage.initializePackageContents();
		theCHESSContractPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDataTypesPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DataTypesPackage.eNS_URI, theDataTypesPackage);
		return theDataTypesPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOthelloConstraint() {
		return othelloConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOthelloConstraint_Expression() {
		return (EAttribute)othelloConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContinuous() {
		return continuousEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getReqStatuses() {
		return reqStatusesEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getReqTypes() {
		return reqTypesEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getReqPriorities() {
		return reqPrioritiesEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getReqMaturities() {
		return reqMaturitiesEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getReqRisks() {
		return reqRisksEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getLanguages() {
		return languagesEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getContractStatus() {
		return contractStatusEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getConcerns() {
		return concernsEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getContractTypes() {
		return contractTypesEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DataTypesFactory getDataTypesFactory() {
		return (DataTypesFactory)getEFactoryInstance();
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
		othelloConstraintEClass = createEClass(OTHELLO_CONSTRAINT);
		createEAttribute(othelloConstraintEClass, OTHELLO_CONSTRAINT__EXPRESSION);

		continuousEClass = createEClass(CONTINUOUS);

		// Create enums
		reqStatusesEEnum = createEEnum(REQ_STATUSES);
		reqTypesEEnum = createEEnum(REQ_TYPES);
		reqPrioritiesEEnum = createEEnum(REQ_PRIORITIES);
		reqMaturitiesEEnum = createEEnum(REQ_MATURITIES);
		reqRisksEEnum = createEEnum(REQ_RISKS);
		languagesEEnum = createEEnum(LANGUAGES);
		contractStatusEEnum = createEEnum(CONTRACT_STATUS);
		concernsEEnum = createEEnum(CONCERNS);
		contractTypesEEnum = createEEnum(CONTRACT_TYPES);
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
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(othelloConstraintEClass, OthelloConstraint.class, "OthelloConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOthelloConstraint_Expression(), theTypesPackage.getString(), "Expression", null, 1, 1, OthelloConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(continuousEClass, Continuous.class, "Continuous", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(reqStatusesEEnum, ReqStatuses.class, "ReqStatuses");
		addEEnumLiteral(reqStatusesEEnum, ReqStatuses.INITIAL);
		addEEnumLiteral(reqStatusesEEnum, ReqStatuses.DERIVED);
		addEEnumLiteral(reqStatusesEEnum, ReqStatuses.FINAL);

		initEEnum(reqTypesEEnum, ReqTypes.class, "ReqTypes");
		addEEnumLiteral(reqTypesEEnum, ReqTypes.FUNCTIONAL);
		addEEnumLiteral(reqTypesEEnum, ReqTypes.MISSION);
		addEEnumLiteral(reqTypesEEnum, ReqTypes.INTERFACE);
		addEEnumLiteral(reqTypesEEnum, ReqTypes.ENVIRONMENTAL);
		addEEnumLiteral(reqTypesEEnum, ReqTypes.PHYSICAL);
		addEEnumLiteral(reqTypesEEnum, ReqTypes.OPERATIONAL);
		addEEnumLiteral(reqTypesEEnum, ReqTypes.HUMAN_FACTOR);
		addEEnumLiteral(reqTypesEEnum, ReqTypes.LOGISTICS_SUPPORT);
		addEEnumLiteral(reqTypesEEnum, ReqTypes.CONFIGURATION);
		addEEnumLiteral(reqTypesEEnum, ReqTypes.DESIGN);
		addEEnumLiteral(reqTypesEEnum, ReqTypes.VERIFICATION);
		addEEnumLiteral(reqTypesEEnum, ReqTypes.PRODUCT_ASSURANCE);

		initEEnum(reqPrioritiesEEnum, ReqPriorities.class, "ReqPriorities");
		addEEnumLiteral(reqPrioritiesEEnum, ReqPriorities.HIGH);
		addEEnumLiteral(reqPrioritiesEEnum, ReqPriorities.MEDIUM);
		addEEnumLiteral(reqPrioritiesEEnum, ReqPriorities.LOW);

		initEEnum(reqMaturitiesEEnum, ReqMaturities.class, "ReqMaturities");
		addEEnumLiteral(reqMaturitiesEEnum, ReqMaturities.TBC);
		addEEnumLiteral(reqMaturitiesEEnum, ReqMaturities.TBD);
		addEEnumLiteral(reqMaturitiesEEnum, ReqMaturities.IN_ANALYSIS);
		addEEnumLiteral(reqMaturitiesEEnum, ReqMaturities.ANALYZED);

		initEEnum(reqRisksEEnum, ReqRisks.class, "ReqRisks");
		addEEnumLiteral(reqRisksEEnum, ReqRisks.HIGH);
		addEEnumLiteral(reqRisksEEnum, ReqRisks.MEDIUM);
		addEEnumLiteral(reqRisksEEnum, ReqRisks.LOW);

		initEEnum(languagesEEnum, Languages.class, "Languages");
		addEEnumLiteral(languagesEEnum, Languages.OCRA);
		addEEnumLiteral(languagesEEnum, Languages.FPTC);
		addEEnumLiteral(languagesEEnum, Languages.OTHER);

		initEEnum(contractStatusEEnum, ContractStatus.class, "ContractStatus");
		addEEnumLiteral(contractStatusEEnum, ContractStatus.NOT_VALIDATED);
		addEEnumLiteral(contractStatusEEnum, ContractStatus.VALIDATED);
		addEEnumLiteral(contractStatusEEnum, ContractStatus.NEEDS_RUNTIME_SUPPORT);

		initEEnum(concernsEEnum, Concerns.class, "Concerns");
		addEEnumLiteral(concernsEEnum, Concerns.UNSPECIFIED);
		addEEnumLiteral(concernsEEnum, Concerns.SAFETY);
		addEEnumLiteral(concernsEEnum, Concerns.SECURITY);
		addEEnumLiteral(concernsEEnum, Concerns.PERFORMANCE);

		initEEnum(contractTypesEEnum, ContractTypes.class, "ContractTypes");
		addEEnumLiteral(contractTypesEEnum, ContractTypes.STRONG);
		addEEnumLiteral(contractTypesEEnum, ContractTypes.WEAK);

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
		  (reqTypesEEnum.getELiterals().get(0), 
		   source, 
		   new String[] {
			 "originalName", "Functional "
		   });
	}

} // DataTypesPackageImpl
