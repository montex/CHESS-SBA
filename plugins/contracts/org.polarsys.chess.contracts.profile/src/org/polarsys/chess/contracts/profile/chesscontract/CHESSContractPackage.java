/**
 */
package org.polarsys.chess.contracts.profile.chesscontract;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage;
import org.eclipse.papyrus.sysml.blocks.BlocksPackage;

import org.eclipse.papyrus.sysml.constraints.ConstraintsPackage;

import org.eclipse.papyrus.sysml.requirements.RequirementsPackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains
 * accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each operation of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSContractFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='CHESSContract'"
 * @generated
 */
public interface CHESSContractPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "chesscontract";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///CHESSContract.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "CHESSContract";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	CHESSContractPackage eINSTANCE = org.polarsys.chess.contracts.profile.chesscontract.impl.CHESSContractPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polarsys.chess.contracts.profile.chesscontract.impl.SystemImpl <em>System</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.polarsys.chess.contracts.profile.chesscontract.impl.SystemImpl
	 * @see org.polarsys.chess.contracts.profile.chesscontract.impl.CHESSContractPackageImpl#getSystem()
	 * @generated
	 */
	int SYSTEM = 5;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.contracts.profile.chesscontract.impl.ContractImpl <em>Contract</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.polarsys.chess.contracts.profile.chesscontract.impl.ContractImpl
	 * @see org.polarsys.chess.contracts.profile.chesscontract.impl.CHESSContractPackageImpl#getContract()
	 * @generated
	 */
	int CONTRACT = 6;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.contracts.profile.chesscontract.impl.FormalPropertyImpl <em>Formal Property</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.polarsys.chess.contracts.profile.chesscontract.impl.FormalPropertyImpl
	 * @see org.polarsys.chess.contracts.profile.chesscontract.impl.CHESSContractPackageImpl#getFormalProperty()
	 * @generated
	 */
	int FORMAL_PROPERTY = 3;

	/**
	 * The meta object id for the
	 * '{@link org.polarsys.chess.contracts.profile.chesscontract.impl.ContractRefinementAnalysisContextImpl
	 * <em>Contract Refinement Analysis Context</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.polarsys.chess.contracts.profile.chesscontract.impl.ContractRefinementAnalysisContextImpl
	 * @see org.polarsys.chess.contracts.profile.chesscontract.impl.CHESSContractPackageImpl#getContractRefinementAnalysisContext()
	 * @generated
	 */
	int CONTRACT_REFINEMENT_ANALYSIS_CONTEXT = 4;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.contracts.profile.chesscontract.impl.FormalizeImpl <em>Formalize</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.polarsys.chess.contracts.profile.chesscontract.impl.FormalizeImpl
	 * @see org.polarsys.chess.contracts.profile.chesscontract.impl.CHESSContractPackageImpl#getFormalize()
	 * @generated
	 */
	int FORMALIZE = 7;

	/**
	 * The meta object id for the
	 * '{@link org.polarsys.chess.contracts.profile.chesscontract.impl.SubSystemImpl
	 * <em>Sub System</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.polarsys.chess.contracts.profile.chesscontract.impl.SubSystemImpl
	 * @see org.polarsys.chess.contracts.profile.chesscontract.impl.CHESSContractPackageImpl#getSubSystem()
	 * @generated
	 */
	int SUB_SYSTEM = 8;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.contracts.profile.chesscontract.impl.CHESSRequirementImpl <em>CHESS Requirement</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.polarsys.chess.contracts.profile.chesscontract.impl.CHESSRequirementImpl
	 * @see org.polarsys.chess.contracts.profile.chesscontract.impl.CHESSContractPackageImpl#getCHESSRequirement()
	 * @generated
	 */
	int CHESS_REQUIREMENT = 9;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.contracts.profile.chesscontract.impl.ContractPropertyImpl <em>Contract Property</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.polarsys.chess.contracts.profile.chesscontract.impl.ContractPropertyImpl
	 * @see org.polarsys.chess.contracts.profile.chesscontract.impl.CHESSContractPackageImpl#getContractProperty()
	 * @generated
	 */
	int CONTRACT_PROPERTY = 1;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.contracts.profile.chesscontract.impl.ContractRefinementImpl <em>Contract Refinement</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.polarsys.chess.contracts.profile.chesscontract.impl.ContractRefinementImpl
	 * @see org.polarsys.chess.contracts.profile.chesscontract.impl.CHESSContractPackageImpl#getContractRefinement()
	 * @generated
	 */
	int CONTRACT_REFINEMENT = 2;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.contracts.profile.chesscontract.impl.DelegationConstraintImpl <em>Delegation Constraint</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.polarsys.chess.contracts.profile.chesscontract.impl.DelegationConstraintImpl
	 * @see org.polarsys.chess.contracts.profile.chesscontract.impl.CHESSContractPackageImpl#getDelegationConstraint()
	 * @generated
	 */
	int DELEGATION_CONSTRAINT = 10;

	/**
	 * The meta object id for the
	 * '{@link org.polarsys.chess.contracts.profile.chesscontract.impl.SRAComponentImpl
	 * <em>SRA Component</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.polarsys.chess.contracts.profile.chesscontract.impl.SRAComponentImpl
	 * @see org.polarsys.chess.contracts.profile.chesscontract.impl.CHESSContractPackageImpl#getSRAComponent()
	 * @generated
	 */
	int SRA_COMPONENT = 11;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.contracts.profile.chesscontract.impl.ComponentInstanceImpl <em>Component Instance</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.polarsys.chess.contracts.profile.chesscontract.impl.ComponentInstanceImpl
	 * @see org.polarsys.chess.contracts.profile.chesscontract.impl.CHESSContractPackageImpl#getComponentInstance()
	 * @generated
	 */
	int COMPONENT_INSTANCE = 0;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPONENT_INSTANCE__BASE_PROPERTY = 0;

	/**
	 * The feature id for the '<em><b>Weak Guarantees</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_INSTANCE__WEAK_GUARANTEES = 1;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_INSTANCE__BASE_INSTANCE_SPECIFICATION = 2;

	/**
	 * The number of structural features of the '<em>Component Instance</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_INSTANCE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Component Instance</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPONENT_INSTANCE_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTRACT_PROPERTY__BASE_PROPERTY = ConstraintsPackage.CONSTRAINT_PROPERTY__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTRACT_PROPERTY__REFINED_BY = ConstraintsPackage.CONSTRAINT_PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Contract Type</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTRACT_PROPERTY__CONTRACT_TYPE = ConstraintsPackage.CONSTRAINT_PROPERTY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Slot</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTRACT_PROPERTY__BASE_SLOT = ConstraintsPackage.CONSTRAINT_PROPERTY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTRACT_PROPERTY__STATUS = ConstraintsPackage.CONSTRAINT_PROPERTY_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Contract Property</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRACT_PROPERTY_FEATURE_COUNT = ConstraintsPackage.CONSTRAINT_PROPERTY_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Contract Property</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTRACT_PROPERTY_OPERATION_COUNT = ConstraintsPackage.CONSTRAINT_PROPERTY_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTRACT_REFINEMENT__BASE_DATA_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Instance</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTRACT_REFINEMENT__INSTANCE = 1;

	/**
	 * The feature id for the '<em><b>Contract</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTRACT_REFINEMENT__CONTRACT = 2;

	/**
	 * The feature id for the '<em><b>Instance Spec</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTRACT_REFINEMENT__INSTANCE_SPEC = 3;

	/**
	 * The feature id for the '<em><b>Upper Index Of Instance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRACT_REFINEMENT__UPPER_INDEX_OF_INSTANCE = 4;

	/**
	 * The feature id for the '<em><b>Lower Index Of Instance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRACT_REFINEMENT__LOWER_INDEX_OF_INSTANCE = 5;

	/**
	 * The number of structural features of the '<em>Contract Refinement</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRACT_REFINEMENT_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Contract Refinement</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRACT_REFINEMENT_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Base Constraint</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FORMAL_PROPERTY__BASE_CONSTRAINT = 0;

	/**
	 * The feature id for the '<em><b>Formalize</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FORMAL_PROPERTY__FORMALIZE = 1;

	/**
	 * The feature id for the '<em><b>Concern</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FORMAL_PROPERTY__CONCERN = 2;

	/**
	 * The number of structural features of the '<em>Formal Property</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAL_PROPERTY_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Formal Property</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FORMAL_PROPERTY_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Base Structured Classifier</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRACT_REFINEMENT_ANALYSIS_CONTEXT__BASE_STRUCTURED_CLASSIFIER = GQAMPackage.GA_ANALYSIS_CONTEXT__BASE_STRUCTURED_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTRACT_REFINEMENT_ANALYSIS_CONTEXT__BASE_PACKAGE = GQAMPackage.GA_ANALYSIS_CONTEXT__BASE_PACKAGE;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTRACT_REFINEMENT_ANALYSIS_CONTEXT__MODE = GQAMPackage.GA_ANALYSIS_CONTEXT__MODE;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRACT_REFINEMENT_ANALYSIS_CONTEXT__BASE_NAMED_ELEMENT = GQAMPackage.GA_ANALYSIS_CONTEXT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTRACT_REFINEMENT_ANALYSIS_CONTEXT__CONTEXT = GQAMPackage.GA_ANALYSIS_CONTEXT__CONTEXT;

	/**
	 * The feature id for the '<em><b>Workload</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTRACT_REFINEMENT_ANALYSIS_CONTEXT__WORKLOAD = GQAMPackage.GA_ANALYSIS_CONTEXT__WORKLOAD;

	/**
	 * The feature id for the '<em><b>Platform</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTRACT_REFINEMENT_ANALYSIS_CONTEXT__PLATFORM = GQAMPackage.GA_ANALYSIS_CONTEXT__PLATFORM;

	/**
	 * The feature id for the '<em><b>Check All Weak Contracts</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRACT_REFINEMENT_ANALYSIS_CONTEXT__CHECK_ALL_WEAK_CONTRACTS = GQAMPackage.GA_ANALYSIS_CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Contract Refinement
	 * Analysis Context</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTRACT_REFINEMENT_ANALYSIS_CONTEXT_FEATURE_COUNT = GQAMPackage.GA_ANALYSIS_CONTEXT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Contract Refinement Analysis Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	//int CONTRACT_REFINEMENT_ANALYSIS_CONTEXT_OPERATION_COUNT = GQAMPackage.GA_ANALYSIS_CONTEXT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Encapsulated</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYSTEM__IS_ENCAPSULATED = BlocksPackage.BLOCK__IS_ENCAPSULATED;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYSTEM__BASE_CLASS = BlocksPackage.BLOCK__BASE_CLASS;

	/**
	 * The number of structural features of the '<em>System</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYSTEM_FEATURE_COUNT = BlocksPackage.BLOCK_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>System</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYSTEM_OPERATION_COUNT = BlocksPackage.BLOCK_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Encapsulated</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTRACT__IS_ENCAPSULATED = ConstraintsPackage.CONSTRAINT_BLOCK__IS_ENCAPSULATED;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTRACT__BASE_CLASS = ConstraintsPackage.CONSTRAINT_BLOCK__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Assume</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTRACT__ASSUME = ConstraintsPackage.CONSTRAINT_BLOCK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Guarantee</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTRACT__GUARANTEE = ConstraintsPackage.CONSTRAINT_BLOCK_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Formalize</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTRACT__FORMALIZE = ConstraintsPackage.CONSTRAINT_BLOCK_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTRACT__LANGUAGE = ConstraintsPackage.CONSTRAINT_BLOCK_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Context Statement</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRACT__CONTEXT_STATEMENT = ConstraintsPackage.CONSTRAINT_BLOCK_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Artefact Statement</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRACT__ARTEFACT_STATEMENT = ConstraintsPackage.CONSTRAINT_BLOCK_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Contract</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTRACT_FEATURE_COUNT = ConstraintsPackage.CONSTRAINT_BLOCK_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Contract</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTRACT_OPERATION_COUNT = ConstraintsPackage.CONSTRAINT_BLOCK_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Abstraction</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FORMALIZE__BASE_ABSTRACTION = 0;

	/**
	 * The number of structural features of the '<em>Formalize</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FORMALIZE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Formalize</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FORMALIZE_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Is Encapsulated</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SUB_SYSTEM__IS_ENCAPSULATED = BlocksPackage.BLOCK__IS_ENCAPSULATED;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SUB_SYSTEM__BASE_CLASS = BlocksPackage.BLOCK__BASE_CLASS;

	/**
	 * The number of structural features of the '<em>Sub System</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_SYSTEM_FEATURE_COUNT = BlocksPackage.BLOCK_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Sub System</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SUB_SYSTEM_OPERATION_COUNT = BlocksPackage.BLOCK_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CHESS_REQUIREMENT__TEXT = RequirementsPackage.REQUIREMENT__TEXT;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CHESS_REQUIREMENT__ID = RequirementsPackage.REQUIREMENT__ID;

	/**
	 * The feature id for the '<em><b>Derived</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CHESS_REQUIREMENT__DERIVED = RequirementsPackage.REQUIREMENT__DERIVED;

	/**
	 * The feature id for the '<em><b>Derived From</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHESS_REQUIREMENT__DERIVED_FROM = RequirementsPackage.REQUIREMENT__DERIVED_FROM;

	/**
	 * The feature id for the '<em><b>Satisfied By</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHESS_REQUIREMENT__SATISFIED_BY = RequirementsPackage.REQUIREMENT__SATISFIED_BY;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CHESS_REQUIREMENT__REFINED_BY = RequirementsPackage.REQUIREMENT__REFINED_BY;

	/**
	 * The feature id for the '<em><b>Traced To</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CHESS_REQUIREMENT__TRACED_TO = RequirementsPackage.REQUIREMENT__TRACED_TO;

	/**
	 * The feature id for the '<em><b>Verified By</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CHESS_REQUIREMENT__VERIFIED_BY = RequirementsPackage.REQUIREMENT__VERIFIED_BY;

	/**
	 * The feature id for the '<em><b>Master</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CHESS_REQUIREMENT__MASTER = RequirementsPackage.REQUIREMENT__MASTER;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CHESS_REQUIREMENT__BASE_CLASS = RequirementsPackage.REQUIREMENT__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Author</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CHESS_REQUIREMENT__AUTHOR = RequirementsPackage.REQUIREMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CHESS_REQUIREMENT__STATUS = RequirementsPackage.REQUIREMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CHESS_REQUIREMENT__TYPE = RequirementsPackage.REQUIREMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CHESS_REQUIREMENT__PRIORITY = RequirementsPackage.REQUIREMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Performance</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CHESS_REQUIREMENT__PERFORMANCE = RequirementsPackage.REQUIREMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Tolerance</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CHESS_REQUIREMENT__TOLERANCE = RequirementsPackage.REQUIREMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Severity</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CHESS_REQUIREMENT__SEVERITY = RequirementsPackage.REQUIREMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Maturity</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CHESS_REQUIREMENT__MATURITY = RequirementsPackage.REQUIREMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Risk</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CHESS_REQUIREMENT__RISK = RequirementsPackage.REQUIREMENT_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>CHESS Requirement</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHESS_REQUIREMENT_FEATURE_COUNT = RequirementsPackage.REQUIREMENT_FEATURE_COUNT + 9;

	/**
	 * The number of operations of the '<em>CHESS Requirement</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CHESS_REQUIREMENT_OPERATION_COUNT = RequirementsPackage.REQUIREMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Constraint</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DELEGATION_CONSTRAINT__BASE_CONSTRAINT = 0;

	/**
	 * The number of structural features of the '<em>Delegation Constraint</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELEGATION_CONSTRAINT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Delegation Constraint</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELEGATION_CONSTRAINT_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SRA_COMPONENT__BASE_CLASS = 0;

	/**
	 * The number of structural features of the '<em>SRA Component</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRA_COMPONENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>SRA Component</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SRA_COMPONENT_OPERATION_COUNT = 0;

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.contracts.profile.chesscontract.System <em>System</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>System</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.System
	 * @generated
	 */
	EClass getSystem();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.contracts.profile.chesscontract.Contract <em>Contract</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Contract</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.Contract
	 * @generated
	 */
	EClass getContract();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.contracts.profile.chesscontract.Contract#getAssume <em>Assume</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Assume</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.Contract#getAssume()
	 * @see #getContract()
	 * @generated
	 */
	EReference getContract_Assume();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.contracts.profile.chesscontract.Contract#getGuarantee <em>Guarantee</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Guarantee</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.Contract#getGuarantee()
	 * @see #getContract()
	 * @generated
	 */
	EReference getContract_Guarantee();

	/**
	 * Returns the meta object for the reference list '{@link org.polarsys.chess.contracts.profile.chesscontract.Contract#getFormalize <em>Formalize</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Formalize</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.Contract#getFormalize()
	 * @see #getContract()
	 * @generated
	 */
	EReference getContract_Formalize();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.contracts.profile.chesscontract.Contract#getLanguage <em>Language</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Language</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.Contract#getLanguage()
	 * @see #getContract()
	 * @generated
	 */
	EAttribute getContract_Language();

	/**
	 * Returns the meta object for the attribute
	 * '{@link org.polarsys.chess.contracts.profile.chesscontract.Contract#getContextStatement
	 * <em>Context Statement</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for the attribute '<em>Context Statement</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.Contract#getContextStatement()
	 * @see #getContract()
	 * @generated
	 */
	EAttribute getContract_ContextStatement();

	/**
	 * Returns the meta object for the attribute list
	 * '{@link org.polarsys.chess.contracts.profile.chesscontract.Contract#getArtefactStatement
	 * <em>Artefact Statement</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for the attribute list '<em>Artefact
	 *         Statement</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.Contract#getArtefactStatement()
	 * @see #getContract()
	 * @generated
	 */
	EAttribute getContract_ArtefactStatement();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.contracts.profile.chesscontract.FormalProperty <em>Formal Property</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Formal Property</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.FormalProperty
	 * @generated
	 */
	EClass getFormalProperty();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.contracts.profile.chesscontract.FormalProperty#getBase_Constraint <em>Base Constraint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Constraint</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.FormalProperty#getBase_Constraint()
	 * @see #getFormalProperty()
	 * @generated
	 */
	EReference getFormalProperty_Base_Constraint();

	/**
	 * Returns the meta object for the reference list '{@link org.polarsys.chess.contracts.profile.chesscontract.FormalProperty#getFormalize <em>Formalize</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Formalize</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.FormalProperty#getFormalize()
	 * @see #getFormalProperty()
	 * @generated
	 */
	EReference getFormalProperty_Formalize();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.contracts.profile.chesscontract.FormalProperty#getConcern <em>Concern</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Concern</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.FormalProperty#getConcern()
	 * @see #getFormalProperty()
	 * @generated
	 */
	EAttribute getFormalProperty_Concern();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.contracts.profile.chesscontract.ContractRefinementAnalysisContext <em>Contract Refinement Analysis Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Contract Refinement Analysis Context</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.ContractRefinementAnalysisContext
	 * @generated
	 */
	EClass getContractRefinementAnalysisContext();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.contracts.profile.chesscontract.ContractRefinementAnalysisContext#isCheckAllWeakContracts <em>Check All Weak Contracts</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for the attribute '<em>Check All Weak Contracts</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.ContractRefinementAnalysisContext#isCheckAllWeakContracts()
	 * @see #getContractRefinementAnalysisContext()
	 * @generated
	 */
	EAttribute getContractRefinementAnalysisContext_CheckAllWeakContracts();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.contracts.profile.chesscontract.Formalize <em>Formalize</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Formalize</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.Formalize
	 * @generated
	 */
	EClass getFormalize();

	/**
	 * Returns the meta object for the reference
	 * '{@link org.polarsys.chess.contracts.profile.chesscontract.Formalize#getBase_Abstraction
	 * <em>Base Abstraction</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for the reference '<em>Base Abstraction</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.Formalize#getBase_Abstraction()
	 * @see #getFormalize()
	 * @generated
	 */
	EReference getFormalize_Base_Abstraction();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.contracts.profile.chesscontract.SubSystem <em>Sub System</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub System</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.SubSystem
	 * @generated
	 */
	EClass getSubSystem();

	/**
	 * Returns the meta object for class
	 * '{@link org.polarsys.chess.contracts.profile.chesscontract.CHESSRequirement
	 * <em>CHESS Requirement</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>CHESS Requirement</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSRequirement
	 * @generated
	 */
	EClass getCHESSRequirement();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.contracts.profile.chesscontract.CHESSRequirement#getAuthor <em>Author</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Author</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSRequirement#getAuthor()
	 * @see #getCHESSRequirement()
	 * @generated
	 */
	EAttribute getCHESSRequirement_Author();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.contracts.profile.chesscontract.CHESSRequirement#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSRequirement#getStatus()
	 * @see #getCHESSRequirement()
	 * @generated
	 */
	EAttribute getCHESSRequirement_Status();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.contracts.profile.chesscontract.CHESSRequirement#getType <em>Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSRequirement#getType()
	 * @see #getCHESSRequirement()
	 * @generated
	 */
	EAttribute getCHESSRequirement_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.contracts.profile.chesscontract.CHESSRequirement#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSRequirement#getPriority()
	 * @see #getCHESSRequirement()
	 * @generated
	 */
	EAttribute getCHESSRequirement_Priority();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.contracts.profile.chesscontract.CHESSRequirement#getPerformance <em>Performance</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Performance</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSRequirement#getPerformance()
	 * @see #getCHESSRequirement()
	 * @generated
	 */
	EAttribute getCHESSRequirement_Performance();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.contracts.profile.chesscontract.CHESSRequirement#getTolerance <em>Tolerance</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tolerance</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSRequirement#getTolerance()
	 * @see #getCHESSRequirement()
	 * @generated
	 */
	EAttribute getCHESSRequirement_Tolerance();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.contracts.profile.chesscontract.CHESSRequirement#getSeverity <em>Severity</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Severity</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSRequirement#getSeverity()
	 * @see #getCHESSRequirement()
	 * @generated
	 */
	EAttribute getCHESSRequirement_Severity();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.contracts.profile.chesscontract.CHESSRequirement#getMaturity <em>Maturity</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maturity</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSRequirement#getMaturity()
	 * @see #getCHESSRequirement()
	 * @generated
	 */
	EAttribute getCHESSRequirement_Maturity();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.contracts.profile.chesscontract.CHESSRequirement#getRisk <em>Risk</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Risk</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSRequirement#getRisk()
	 * @see #getCHESSRequirement()
	 * @generated
	 */
	EAttribute getCHESSRequirement_Risk();

	/**
	 * Returns the meta object for class
	 * '{@link org.polarsys.chess.contracts.profile.chesscontract.ContractProperty
	 * <em>Contract Property</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>Contract Property</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.ContractProperty
	 * @generated
	 */
	EClass getContractProperty();

	/**
	 * Returns the meta object for the reference list '{@link org.polarsys.chess.contracts.profile.chesscontract.ContractProperty#getRefinedBy <em>Refined By</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Refined By</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.ContractProperty#getRefinedBy()
	 * @see #getContractProperty()
	 * @generated
	 */
	EReference getContractProperty_RefinedBy();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.contracts.profile.chesscontract.ContractProperty#getContractType <em>Contract Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Contract Type</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.ContractProperty#getContractType()
	 * @see #getContractProperty()
	 * @generated
	 */
	EAttribute getContractProperty_ContractType();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.contracts.profile.chesscontract.ContractProperty#getBase_Slot <em>Base Slot</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Slot</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.ContractProperty#getBase_Slot()
	 * @see #getContractProperty()
	 * @generated
	 */
	EReference getContractProperty_Base_Slot();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.contracts.profile.chesscontract.ContractProperty#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.ContractProperty#getStatus()
	 * @see #getContractProperty()
	 * @generated
	 */
	EAttribute getContractProperty_Status();

	/**
	 * Returns the meta object for class
	 * '{@link org.polarsys.chess.contracts.profile.chesscontract.ContractRefinement
	 * <em>Contract Refinement</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>Contract Refinement</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.ContractRefinement
	 * @generated
	 */
	EClass getContractRefinement();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.contracts.profile.chesscontract.ContractRefinement#getBase_DataType <em>Base Data Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Data Type</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.ContractRefinement#getBase_DataType()
	 * @see #getContractRefinement()
	 * @generated
	 */
	EReference getContractRefinement_Base_DataType();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.contracts.profile.chesscontract.ContractRefinement#getInstance <em>Instance</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Instance</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.ContractRefinement#getInstance()
	 * @see #getContractRefinement()
	 * @generated
	 */
	EReference getContractRefinement_Instance();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.contracts.profile.chesscontract.ContractRefinement#getContract <em>Contract</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Contract</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.ContractRefinement#getContract()
	 * @see #getContractRefinement()
	 * @generated
	 */
	EReference getContractRefinement_Contract();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.contracts.profile.chesscontract.ContractRefinement#getInstanceSpec <em>Instance Spec</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Instance Spec</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.ContractRefinement#getInstanceSpec()
	 * @see #getContractRefinement()
	 * @generated
	 */
	EReference getContractRefinement_InstanceSpec();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.contracts.profile.chesscontract.ContractRefinement#getUpperIndexOfInstance <em>Upper Index Of Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper Index Of Instance</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.ContractRefinement#getUpperIndexOfInstance()
	 * @see #getContractRefinement()
	 * @generated
	 */
	EAttribute getContractRefinement_UpperIndexOfInstance();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.contracts.profile.chesscontract.ContractRefinement#getLowerIndexOfInstance <em>Lower Index Of Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower Index Of Instance</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.ContractRefinement#getLowerIndexOfInstance()
	 * @see #getContractRefinement()
	 * @generated
	 */
	EAttribute getContractRefinement_LowerIndexOfInstance();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.contracts.profile.chesscontract.DelegationConstraint <em>Delegation Constraint</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for class '<em>Delegation Constraint</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DelegationConstraint
	 * @generated
	 */
	EClass getDelegationConstraint();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.contracts.profile.chesscontract.DelegationConstraint#getBase_Constraint <em>Base Constraint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Constraint</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DelegationConstraint#getBase_Constraint()
	 * @see #getDelegationConstraint()
	 * @generated
	 */
	EReference getDelegationConstraint_Base_Constraint();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.contracts.profile.chesscontract.SRAComponent <em>SRA Component</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>SRA Component</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.SRAComponent
	 * @generated
	 */
	EClass getSRAComponent();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.contracts.profile.chesscontract.SRAComponent#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.SRAComponent#getBase_Class()
	 * @see #getSRAComponent()
	 * @generated
	 */
	EReference getSRAComponent_Base_Class();

	/**
	 * Returns the meta object for class
	 * '{@link org.polarsys.chess.contracts.profile.chesscontract.ComponentInstance
	 * <em>Component Instance</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>Component Instance</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.ComponentInstance
	 * @generated
	 */
	EClass getComponentInstance();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.contracts.profile.chesscontract.ComponentInstance#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.ComponentInstance#getBase_Property()
	 * @see #getComponentInstance()
	 * @generated
	 */
	EReference getComponentInstance_Base_Property();

	/**
	 * Returns the meta object for the reference list '{@link org.polarsys.chess.contracts.profile.chesscontract.ComponentInstance#getWeakGuarantees <em>Weak Guarantees</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Weak Guarantees</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.ComponentInstance#getWeakGuarantees()
	 * @see #getComponentInstance()
	 * @generated
	 */
	EReference getComponentInstance_WeakGuarantees();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.contracts.profile.chesscontract.ComponentInstance#getBase_InstanceSpecification <em>Base Instance Specification</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for the reference '<em>Base Instance Specification</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.ComponentInstance#getBase_InstanceSpecification()
	 * @see #getComponentInstance()
	 * @generated
	 */
	EReference getComponentInstance_Base_InstanceSpecification();

	/**
	 * Returns the factory that creates the instances of the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CHESSContractFactory getCHESSContractFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that
	 * represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each operation of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the
		 * '{@link org.polarsys.chess.contracts.profile.chesscontract.impl.SystemImpl
		 * <em>System</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see org.polarsys.chess.contracts.profile.chesscontract.impl.SystemImpl
		 * @see org.polarsys.chess.contracts.profile.chesscontract.impl.CHESSContractPackageImpl#getSystem()
		 * @generated
		 */
		EClass SYSTEM = eINSTANCE.getSystem();

		/**
		 * The meta object literal for the
		 * '{@link org.polarsys.chess.contracts.profile.chesscontract.impl.ContractImpl
		 * <em>Contract</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see org.polarsys.chess.contracts.profile.chesscontract.impl.ContractImpl
		 * @see org.polarsys.chess.contracts.profile.chesscontract.impl.CHESSContractPackageImpl#getContract()
		 * @generated
		 */
		EClass CONTRACT = eINSTANCE.getContract();

		/**
		 * The meta object literal for the '<em><b>Assume</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTRACT__ASSUME = eINSTANCE.getContract_Assume();

		/**
		 * The meta object literal for the '<em><b>Guarantee</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTRACT__GUARANTEE = eINSTANCE.getContract_Guarantee();

		/**
		 * The meta object literal for the '<em><b>Formalize</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTRACT__FORMALIZE = eINSTANCE.getContract_Formalize();

		/**
		 * The meta object literal for the '<em><b>Language</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTRACT__LANGUAGE = eINSTANCE.getContract_Language();

		/**
		 * The meta object literal for the '<em><b>Context Statement</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTRACT__CONTEXT_STATEMENT = eINSTANCE.getContract_ContextStatement();

		/**
		 * The meta object literal for the '<em><b>Artefact Statement</b></em>' attribute list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTRACT__ARTEFACT_STATEMENT = eINSTANCE.getContract_ArtefactStatement();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.contracts.profile.chesscontract.impl.FormalPropertyImpl <em>Formal Property</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.polarsys.chess.contracts.profile.chesscontract.impl.FormalPropertyImpl
		 * @see org.polarsys.chess.contracts.profile.chesscontract.impl.CHESSContractPackageImpl#getFormalProperty()
		 * @generated
		 */
		EClass FORMAL_PROPERTY = eINSTANCE.getFormalProperty();

		/**
		 * The meta object literal for the '<em><b>Base Constraint</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference FORMAL_PROPERTY__BASE_CONSTRAINT = eINSTANCE.getFormalProperty_Base_Constraint();

		/**
		 * The meta object literal for the '<em><b>Formalize</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference FORMAL_PROPERTY__FORMALIZE = eINSTANCE.getFormalProperty_Formalize();

		/**
		 * The meta object literal for the '<em><b>Concern</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORMAL_PROPERTY__CONCERN = eINSTANCE.getFormalProperty_Concern();

		/**
		 * The meta object literal for the
		 * '{@link org.polarsys.chess.contracts.profile.chesscontract.impl.ContractRefinementAnalysisContextImpl
		 * <em>Contract Refinement Analysis Context</em>}' class. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.polarsys.chess.contracts.profile.chesscontract.impl.ContractRefinementAnalysisContextImpl
		 * @see org.polarsys.chess.contracts.profile.chesscontract.impl.CHESSContractPackageImpl#getContractRefinementAnalysisContext()
		 * @generated
		 */
		EClass CONTRACT_REFINEMENT_ANALYSIS_CONTEXT = eINSTANCE.getContractRefinementAnalysisContext();

		/**
		 * The meta object literal for the '<em><b>Check All Weak Contracts</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute CONTRACT_REFINEMENT_ANALYSIS_CONTEXT__CHECK_ALL_WEAK_CONTRACTS = eINSTANCE.getContractRefinementAnalysisContext_CheckAllWeakContracts();

		/**
		 * The meta object literal for the
		 * '{@link org.polarsys.chess.contracts.profile.chesscontract.impl.FormalizeImpl
		 * <em>Formalize</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see org.polarsys.chess.contracts.profile.chesscontract.impl.FormalizeImpl
		 * @see org.polarsys.chess.contracts.profile.chesscontract.impl.CHESSContractPackageImpl#getFormalize()
		 * @generated
		 */
		EClass FORMALIZE = eINSTANCE.getFormalize();

		/**
		 * The meta object literal for the '<em><b>Base Abstraction</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference FORMALIZE__BASE_ABSTRACTION = eINSTANCE.getFormalize_Base_Abstraction();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.contracts.profile.chesscontract.impl.SubSystemImpl <em>Sub System</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.polarsys.chess.contracts.profile.chesscontract.impl.SubSystemImpl
		 * @see org.polarsys.chess.contracts.profile.chesscontract.impl.CHESSContractPackageImpl#getSubSystem()
		 * @generated
		 */
		EClass SUB_SYSTEM = eINSTANCE.getSubSystem();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.contracts.profile.chesscontract.impl.CHESSRequirementImpl <em>CHESS Requirement</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.polarsys.chess.contracts.profile.chesscontract.impl.CHESSRequirementImpl
		 * @see org.polarsys.chess.contracts.profile.chesscontract.impl.CHESSContractPackageImpl#getCHESSRequirement()
		 * @generated
		 */
		EClass CHESS_REQUIREMENT = eINSTANCE.getCHESSRequirement();

		/**
		 * The meta object literal for the '<em><b>Author</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHESS_REQUIREMENT__AUTHOR = eINSTANCE.getCHESSRequirement_Author();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHESS_REQUIREMENT__STATUS = eINSTANCE.getCHESSRequirement_Status();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHESS_REQUIREMENT__TYPE = eINSTANCE.getCHESSRequirement_Type();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHESS_REQUIREMENT__PRIORITY = eINSTANCE.getCHESSRequirement_Priority();

		/**
		 * The meta object literal for the '<em><b>Performance</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHESS_REQUIREMENT__PERFORMANCE = eINSTANCE.getCHESSRequirement_Performance();

		/**
		 * The meta object literal for the '<em><b>Tolerance</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHESS_REQUIREMENT__TOLERANCE = eINSTANCE.getCHESSRequirement_Tolerance();

		/**
		 * The meta object literal for the '<em><b>Severity</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHESS_REQUIREMENT__SEVERITY = eINSTANCE.getCHESSRequirement_Severity();

		/**
		 * The meta object literal for the '<em><b>Maturity</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHESS_REQUIREMENT__MATURITY = eINSTANCE.getCHESSRequirement_Maturity();

		/**
		 * The meta object literal for the '<em><b>Risk</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHESS_REQUIREMENT__RISK = eINSTANCE.getCHESSRequirement_Risk();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.contracts.profile.chesscontract.impl.ContractPropertyImpl <em>Contract Property</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.polarsys.chess.contracts.profile.chesscontract.impl.ContractPropertyImpl
		 * @see org.polarsys.chess.contracts.profile.chesscontract.impl.CHESSContractPackageImpl#getContractProperty()
		 * @generated
		 */
		EClass CONTRACT_PROPERTY = eINSTANCE.getContractProperty();

		/**
		 * The meta object literal for the '<em><b>Refined By</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTRACT_PROPERTY__REFINED_BY = eINSTANCE.getContractProperty_RefinedBy();

		/**
		 * The meta object literal for the '<em><b>Contract Type</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTRACT_PROPERTY__CONTRACT_TYPE = eINSTANCE.getContractProperty_ContractType();

		/**
		 * The meta object literal for the '<em><b>Base Slot</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTRACT_PROPERTY__BASE_SLOT = eINSTANCE.getContractProperty_Base_Slot();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTRACT_PROPERTY__STATUS = eINSTANCE.getContractProperty_Status();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.contracts.profile.chesscontract.impl.ContractRefinementImpl <em>Contract Refinement</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.polarsys.chess.contracts.profile.chesscontract.impl.ContractRefinementImpl
		 * @see org.polarsys.chess.contracts.profile.chesscontract.impl.CHESSContractPackageImpl#getContractRefinement()
		 * @generated
		 */
		EClass CONTRACT_REFINEMENT = eINSTANCE.getContractRefinement();

		/**
		 * The meta object literal for the '<em><b>Base Data Type</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTRACT_REFINEMENT__BASE_DATA_TYPE = eINSTANCE.getContractRefinement_Base_DataType();

		/**
		 * The meta object literal for the '<em><b>Instance</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTRACT_REFINEMENT__INSTANCE = eINSTANCE.getContractRefinement_Instance();

		/**
		 * The meta object literal for the '<em><b>Contract</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTRACT_REFINEMENT__CONTRACT = eINSTANCE.getContractRefinement_Contract();

		/**
		 * The meta object literal for the '<em><b>Instance Spec</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTRACT_REFINEMENT__INSTANCE_SPEC = eINSTANCE.getContractRefinement_InstanceSpec();

		/**
		 * The meta object literal for the '<em><b>Upper Index Of Instance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTRACT_REFINEMENT__UPPER_INDEX_OF_INSTANCE = eINSTANCE.getContractRefinement_UpperIndexOfInstance();

		/**
		 * The meta object literal for the '<em><b>Lower Index Of Instance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTRACT_REFINEMENT__LOWER_INDEX_OF_INSTANCE = eINSTANCE.getContractRefinement_LowerIndexOfInstance();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.contracts.profile.chesscontract.impl.DelegationConstraintImpl <em>Delegation Constraint</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.polarsys.chess.contracts.profile.chesscontract.impl.DelegationConstraintImpl
		 * @see org.polarsys.chess.contracts.profile.chesscontract.impl.CHESSContractPackageImpl#getDelegationConstraint()
		 * @generated
		 */
		EClass DELEGATION_CONSTRAINT = eINSTANCE.getDelegationConstraint();

		/**
		 * The meta object literal for the '<em><b>Base Constraint</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELEGATION_CONSTRAINT__BASE_CONSTRAINT = eINSTANCE.getDelegationConstraint_Base_Constraint();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.contracts.profile.chesscontract.impl.SRAComponentImpl <em>SRA Component</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.polarsys.chess.contracts.profile.chesscontract.impl.SRAComponentImpl
		 * @see org.polarsys.chess.contracts.profile.chesscontract.impl.CHESSContractPackageImpl#getSRAComponent()
		 * @generated
		 */
		EClass SRA_COMPONENT = eINSTANCE.getSRAComponent();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference SRA_COMPONENT__BASE_CLASS = eINSTANCE.getSRAComponent_Base_Class();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.contracts.profile.chesscontract.impl.ComponentInstanceImpl <em>Component Instance</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.polarsys.chess.contracts.profile.chesscontract.impl.ComponentInstanceImpl
		 * @see org.polarsys.chess.contracts.profile.chesscontract.impl.CHESSContractPackageImpl#getComponentInstance()
		 * @generated
		 */
		EClass COMPONENT_INSTANCE = eINSTANCE.getComponentInstance();

		/**
		 * The meta object literal for the '<em><b>Base Property</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_INSTANCE__BASE_PROPERTY = eINSTANCE.getComponentInstance_Base_Property();

		/**
		 * The meta object literal for the '<em><b>Weak Guarantees</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_INSTANCE__WEAK_GUARANTEES = eINSTANCE.getComponentInstance_WeakGuarantees();

		/**
		 * The meta object literal for the '<em><b>Base Instance Specification</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_INSTANCE__BASE_INSTANCE_SPECIFICATION = eINSTANCE.getComponentInstance_Base_InstanceSpecification();

	}

} // CHESSContractPackage
