/**
 */
package org.polarsys.chess.contracts.profile.chesscontract.DataTypes;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

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
 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.DataTypesFactory
 * @model kind="package"
 * @generated
 */
public interface DataTypesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "DataTypes";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///CHESSContract/DataTypes.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "CHESSContract.DataTypes";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	DataTypesPackage eINSTANCE = org.polarsys.chess.contracts.profile.chesscontract.DataTypes.impl.DataTypesPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polarsys.chess.contracts.profile.chesscontract.DataTypes.impl.OthelloConstraintImpl <em>Othello Constraint</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.impl.OthelloConstraintImpl
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.impl.DataTypesPackageImpl#getOthelloConstraint()
	 * @generated
	 */
	int OTHELLO_CONSTRAINT = 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OTHELLO_CONSTRAINT__EXPRESSION = 0;

	/**
	 * The number of structural features of the '<em>Othello Constraint</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHELLO_CONSTRAINT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Othello Constraint</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OTHELLO_CONSTRAINT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the
	 * '{@link org.polarsys.chess.contracts.profile.chesscontract.DataTypes.impl.ContinuousImpl
	 * <em>Continuous</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.impl.ContinuousImpl
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.impl.DataTypesPackageImpl#getContinuous()
	 * @generated
	 */
	int CONTINUOUS = 1;

	/**
	 * The number of structural features of the '<em>Continuous</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUOUS_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Continuous</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTINUOUS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the
	 * '{@link org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqStatuses
	 * <em>Req Statuses</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqStatuses
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.impl.DataTypesPackageImpl#getReqStatuses()
	 * @generated
	 */
	int REQ_STATUSES = 2;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqTypes <em>Req Types</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqTypes
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.impl.DataTypesPackageImpl#getReqTypes()
	 * @generated
	 */
	int REQ_TYPES = 3;

	/**
	 * The meta object id for the
	 * '{@link org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqPriorities
	 * <em>Req Priorities</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqPriorities
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.impl.DataTypesPackageImpl#getReqPriorities()
	 * @generated
	 */
	int REQ_PRIORITIES = 4;

	/**
	 * The meta object id for the
	 * '{@link org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqMaturities
	 * <em>Req Maturities</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqMaturities
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.impl.DataTypesPackageImpl#getReqMaturities()
	 * @generated
	 */
	int REQ_MATURITIES = 5;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqRisks <em>Req Risks</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqRisks
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.impl.DataTypesPackageImpl#getReqRisks()
	 * @generated
	 */
	int REQ_RISKS = 6;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.contracts.profile.chesscontract.DataTypes.Languages <em>Languages</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.Languages
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.impl.DataTypesPackageImpl#getLanguages()
	 * @generated
	 */
	int LANGUAGES = 7;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ContractStatus <em>Contract Status</em>}' enum.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ContractStatus
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.impl.DataTypesPackageImpl#getContractStatus()
	 * @generated
	 */
	int CONTRACT_STATUS = 8;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.contracts.profile.chesscontract.DataTypes.Concerns <em>Concerns</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.Concerns
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.impl.DataTypesPackageImpl#getConcerns()
	 * @generated
	 */
	int CONCERNS = 9;

	/**
	 * The meta object id for the
	 * '{@link org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ContractTypes
	 * <em>Contract Types</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ContractTypes
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.impl.DataTypesPackageImpl#getContractTypes()
	 * @generated
	 */
	int CONTRACT_TYPES = 10;

	/**
	 * Returns the meta object for class
	 * '{@link org.polarsys.chess.contracts.profile.chesscontract.DataTypes.OthelloConstraint
	 * <em>Othello Constraint</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>Othello Constraint</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.OthelloConstraint
	 * @generated
	 */
	EClass getOthelloConstraint();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.contracts.profile.chesscontract.DataTypes.OthelloConstraint#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expression</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.OthelloConstraint#getExpression()
	 * @see #getOthelloConstraint()
	 * @generated
	 */
	EAttribute getOthelloConstraint_Expression();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.contracts.profile.chesscontract.DataTypes.Continuous <em>Continuous</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Continuous</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.Continuous
	 * @generated
	 */
	EClass getContinuous();

	/**
	 * Returns the meta object for enum '{@link org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqStatuses <em>Req Statuses</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Req Statuses</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqStatuses
	 * @generated
	 */
	EEnum getReqStatuses();

	/**
	 * Returns the meta object for enum '{@link org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqTypes <em>Req Types</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Req Types</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqTypes
	 * @generated
	 */
	EEnum getReqTypes();

	/**
	 * Returns the meta object for enum '{@link org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqPriorities <em>Req Priorities</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Req Priorities</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqPriorities
	 * @generated
	 */
	EEnum getReqPriorities();

	/**
	 * Returns the meta object for enum '{@link org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqMaturities <em>Req Maturities</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Req Maturities</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqMaturities
	 * @generated
	 */
	EEnum getReqMaturities();

	/**
	 * Returns the meta object for enum '{@link org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqRisks <em>Req Risks</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Req Risks</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqRisks
	 * @generated
	 */
	EEnum getReqRisks();

	/**
	 * Returns the meta object for enum '{@link org.polarsys.chess.contracts.profile.chesscontract.DataTypes.Languages <em>Languages</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Languages</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.Languages
	 * @generated
	 */
	EEnum getLanguages();

	/**
	 * Returns the meta object for enum '{@link org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ContractStatus <em>Contract Status</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Contract Status</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ContractStatus
	 * @generated
	 */
	EEnum getContractStatus();

	/**
	 * Returns the meta object for enum '{@link org.polarsys.chess.contracts.profile.chesscontract.DataTypes.Concerns <em>Concerns</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Concerns</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.Concerns
	 * @generated
	 */
	EEnum getConcerns();

	/**
	 * Returns the meta object for enum '{@link org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ContractTypes <em>Contract Types</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Contract Types</em>'.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ContractTypes
	 * @generated
	 */
	EEnum getContractTypes();

	/**
	 * Returns the factory that creates the instances of the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DataTypesFactory getDataTypesFactory();

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
		 * The meta object literal for the '{@link org.polarsys.chess.contracts.profile.chesscontract.DataTypes.impl.OthelloConstraintImpl <em>Othello Constraint</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.impl.OthelloConstraintImpl
		 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.impl.DataTypesPackageImpl#getOthelloConstraint()
		 * @generated
		 */
		EClass OTHELLO_CONSTRAINT = eINSTANCE.getOthelloConstraint();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OTHELLO_CONSTRAINT__EXPRESSION = eINSTANCE.getOthelloConstraint_Expression();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.contracts.profile.chesscontract.DataTypes.impl.ContinuousImpl <em>Continuous</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.impl.ContinuousImpl
		 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.impl.DataTypesPackageImpl#getContinuous()
		 * @generated
		 */
		EClass CONTINUOUS = eINSTANCE.getContinuous();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqStatuses <em>Req Statuses</em>}' enum.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqStatuses
		 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.impl.DataTypesPackageImpl#getReqStatuses()
		 * @generated
		 */
		EEnum REQ_STATUSES = eINSTANCE.getReqStatuses();

		/**
		 * The meta object literal for the
		 * '{@link org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqTypes
		 * <em>Req Types</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqTypes
		 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.impl.DataTypesPackageImpl#getReqTypes()
		 * @generated
		 */
		EEnum REQ_TYPES = eINSTANCE.getReqTypes();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqPriorities <em>Req Priorities</em>}' enum.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqPriorities
		 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.impl.DataTypesPackageImpl#getReqPriorities()
		 * @generated
		 */
		EEnum REQ_PRIORITIES = eINSTANCE.getReqPriorities();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqMaturities <em>Req Maturities</em>}' enum.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqMaturities
		 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.impl.DataTypesPackageImpl#getReqMaturities()
		 * @generated
		 */
		EEnum REQ_MATURITIES = eINSTANCE.getReqMaturities();

		/**
		 * The meta object literal for the
		 * '{@link org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqRisks
		 * <em>Req Risks</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqRisks
		 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.impl.DataTypesPackageImpl#getReqRisks()
		 * @generated
		 */
		EEnum REQ_RISKS = eINSTANCE.getReqRisks();

		/**
		 * The meta object literal for the
		 * '{@link org.polarsys.chess.contracts.profile.chesscontract.DataTypes.Languages
		 * <em>Languages</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.Languages
		 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.impl.DataTypesPackageImpl#getLanguages()
		 * @generated
		 */
		EEnum LANGUAGES = eINSTANCE.getLanguages();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ContractStatus <em>Contract Status</em>}' enum.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ContractStatus
		 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.impl.DataTypesPackageImpl#getContractStatus()
		 * @generated
		 */
		EEnum CONTRACT_STATUS = eINSTANCE.getContractStatus();

		/**
		 * The meta object literal for the
		 * '{@link org.polarsys.chess.contracts.profile.chesscontract.DataTypes.Concerns
		 * <em>Concerns</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.Concerns
		 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.impl.DataTypesPackageImpl#getConcerns()
		 * @generated
		 */
		EEnum CONCERNS = eINSTANCE.getConcerns();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ContractTypes <em>Contract Types</em>}' enum.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ContractTypes
		 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.impl.DataTypesPackageImpl#getContractTypes()
		 * @generated
		 */
		EEnum CONTRACT_TYPES = eINSTANCE.getContractTypes();

	}

} // DataTypesPackage
