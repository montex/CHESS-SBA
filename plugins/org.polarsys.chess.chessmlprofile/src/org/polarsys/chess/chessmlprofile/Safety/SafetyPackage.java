/**
 */
package org.polarsys.chess.chessmlprofile.Safety;

import org.eclipse.emf.ecore.EClass;
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
 * @see org.polarsys.chess.chessmlprofile.Safety.SafetyFactory
 * @model kind="package"
 * @generated
 */
public interface SafetyPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "Safety";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://CHESS/Safety";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "Safety";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SafetyPackage eINSTANCE = org.polarsys.chess.chessmlprofile.Safety.impl.SafetyPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Safety.impl.CriticalityInterfaceSpecificationImpl <em>Criticality Interface Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Safety.impl.CriticalityInterfaceSpecificationImpl
	 * @see org.polarsys.chess.chessmlprofile.Safety.impl.SafetyPackageImpl#getCriticalityInterfaceSpecification()
	 * @generated
	 */
	int CRITICALITY_INTERFACE_SPECIFICATION = 0;

	/**
	 * The feature id for the '<em><b>Base Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITICALITY_INTERFACE_SPECIFICATION__BASE_CONSTRAINT = 0;

	/**
	 * The feature id for the '<em><b>Accepted Criticality For Clients</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITICALITY_INTERFACE_SPECIFICATION__ACCEPTED_CRITICALITY_FOR_CLIENTS = 1;

	/**
	 * The number of structural features of the '<em>Criticality Interface Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITICALITY_INTERFACE_SPECIFICATION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Safety.impl.CriticalitySpecificationImpl <em>Criticality Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Safety.impl.CriticalitySpecificationImpl
	 * @see org.polarsys.chess.chessmlprofile.Safety.impl.SafetyPackageImpl#getCriticalitySpecification()
	 * @generated
	 */
	int CRITICALITY_SPECIFICATION = 2;

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Safety.CriticalityInterfaceSpecification <em>Criticality Interface Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Criticality Interface Specification</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Safety.CriticalityInterfaceSpecification
	 * @generated
	 */
	EClass getCriticalityInterfaceSpecification();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Safety.CriticalityInterfaceSpecification#getBase_Constraint <em>Base Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Constraint</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Safety.CriticalityInterfaceSpecification#getBase_Constraint()
	 * @see #getCriticalityInterfaceSpecification()
	 * @generated
	 */
	EReference getCriticalityInterfaceSpecification_Base_Constraint();

	/**
	 * Returns the meta object for the reference list '{@link org.polarsys.chess.chessmlprofile.Safety.CriticalityInterfaceSpecification#getAcceptedCriticalityForClients <em>Accepted Criticality For Clients</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Accepted Criticality For Clients</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Safety.CriticalityInterfaceSpecification#getAcceptedCriticalityForClients()
	 * @see #getCriticalityInterfaceSpecification()
	 * @generated
	 */
	EReference getCriticalityInterfaceSpecification_AcceptedCriticalityForClients();

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Safety.impl.CriticalityLevelImpl <em>Criticality Level</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Safety.impl.CriticalityLevelImpl
	 * @see org.polarsys.chess.chessmlprofile.Safety.impl.SafetyPackageImpl#getCriticalityLevel()
	 * @generated
	 */
	int CRITICALITY_LEVEL = 1;

	/**
	 * The feature id for the '<em><b>Base Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITICALITY_LEVEL__BASE_CONSTRAINT = 0;

	/**
	 * The feature id for the '<em><b>Is Higher Than</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITICALITY_LEVEL__IS_HIGHER_THAN = 1;

	/**
	 * The feature id for the '<em><b>Maps To</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITICALITY_LEVEL__MAPS_TO = 2;

	/**
	 * The number of structural features of the '<em>Criticality Level</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITICALITY_LEVEL_FEATURE_COUNT = 3;

	/**
	 * The feature id for the '<em><b>Base Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITICALITY_SPECIFICATION__BASE_CONSTRAINT = 0;

	/**
	 * The feature id for the '<em><b>Criticality Level</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITICALITY_SPECIFICATION__CRITICALITY_LEVEL = 1;

	/**
	 * The number of structural features of the '<em>Criticality Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITICALITY_SPECIFICATION_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Safety.CriticalitySpecification <em>Criticality Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Criticality Specification</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Safety.CriticalitySpecification
	 * @generated
	 */
	EClass getCriticalitySpecification();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Safety.CriticalitySpecification#getBase_Constraint <em>Base Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Constraint</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Safety.CriticalitySpecification#getBase_Constraint()
	 * @see #getCriticalitySpecification()
	 * @generated
	 */
	EReference getCriticalitySpecification_Base_Constraint();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Safety.CriticalitySpecification#getCriticalityLevel <em>Criticality Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Criticality Level</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Safety.CriticalitySpecification#getCriticalityLevel()
	 * @see #getCriticalitySpecification()
	 * @generated
	 */
	EReference getCriticalitySpecification_CriticalityLevel();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Safety.CriticalityLevel <em>Criticality Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Criticality Level</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Safety.CriticalityLevel
	 * @generated
	 */
	EClass getCriticalityLevel();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Safety.CriticalityLevel#getBase_Constraint <em>Base Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Constraint</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Safety.CriticalityLevel#getBase_Constraint()
	 * @see #getCriticalityLevel()
	 * @generated
	 */
	EReference getCriticalityLevel_Base_Constraint();

	/**
	 * Returns the meta object for the reference list '{@link org.polarsys.chess.chessmlprofile.Safety.CriticalityLevel#getIsHigherThan <em>Is Higher Than</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Is Higher Than</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Safety.CriticalityLevel#getIsHigherThan()
	 * @see #getCriticalityLevel()
	 * @generated
	 */
	EReference getCriticalityLevel_IsHigherThan();

	/**
	 * Returns the meta object for the reference list '{@link org.polarsys.chess.chessmlprofile.Safety.CriticalityLevel#getMapsTo <em>Maps To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Maps To</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Safety.CriticalityLevel#getMapsTo()
	 * @see #getCriticalityLevel()
	 * @generated
	 */
	EReference getCriticalityLevel_MapsTo();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SafetyFactory getSafetyFactory();

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
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Safety.impl.CriticalityInterfaceSpecificationImpl <em>Criticality Interface Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Safety.impl.CriticalityInterfaceSpecificationImpl
		 * @see org.polarsys.chess.chessmlprofile.Safety.impl.SafetyPackageImpl#getCriticalityInterfaceSpecification()
		 * @generated
		 */
		EClass CRITICALITY_INTERFACE_SPECIFICATION = eINSTANCE.getCriticalityInterfaceSpecification();

		/**
		 * The meta object literal for the '<em><b>Base Constraint</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CRITICALITY_INTERFACE_SPECIFICATION__BASE_CONSTRAINT = eINSTANCE.getCriticalityInterfaceSpecification_Base_Constraint();

		/**
		 * The meta object literal for the '<em><b>Accepted Criticality For Clients</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CRITICALITY_INTERFACE_SPECIFICATION__ACCEPTED_CRITICALITY_FOR_CLIENTS = eINSTANCE.getCriticalityInterfaceSpecification_AcceptedCriticalityForClients();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Safety.impl.CriticalitySpecificationImpl <em>Criticality Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Safety.impl.CriticalitySpecificationImpl
		 * @see org.polarsys.chess.chessmlprofile.Safety.impl.SafetyPackageImpl#getCriticalitySpecification()
		 * @generated
		 */
		EClass CRITICALITY_SPECIFICATION = eINSTANCE.getCriticalitySpecification();

		/**
		 * The meta object literal for the '<em><b>Base Constraint</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CRITICALITY_SPECIFICATION__BASE_CONSTRAINT = eINSTANCE.getCriticalitySpecification_Base_Constraint();

		/**
		 * The meta object literal for the '<em><b>Criticality Level</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CRITICALITY_SPECIFICATION__CRITICALITY_LEVEL = eINSTANCE.getCriticalitySpecification_CriticalityLevel();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Safety.impl.CriticalityLevelImpl <em>Criticality Level</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Safety.impl.CriticalityLevelImpl
		 * @see org.polarsys.chess.chessmlprofile.Safety.impl.SafetyPackageImpl#getCriticalityLevel()
		 * @generated
		 */
		EClass CRITICALITY_LEVEL = eINSTANCE.getCriticalityLevel();

		/**
		 * The meta object literal for the '<em><b>Base Constraint</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CRITICALITY_LEVEL__BASE_CONSTRAINT = eINSTANCE.getCriticalityLevel_Base_Constraint();

		/**
		 * The meta object literal for the '<em><b>Is Higher Than</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CRITICALITY_LEVEL__IS_HIGHER_THAN = eINSTANCE.getCriticalityLevel_IsHigherThan();

		/**
		 * The meta object literal for the '<em><b>Maps To</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CRITICALITY_LEVEL__MAPS_TO = eINSTANCE.getCriticalityLevel_MapsTo();

	}

} //SafetyPackage
