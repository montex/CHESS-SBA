/**
 */
package org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.polarsys.chess.chessmlprofile.ComponentModel.ComponentModelPackage;

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
 * @see org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.ARINCComponentModelFactory
 * @model kind="package"
 * @generated
 */
public interface ARINCComponentModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ARINCComponentModel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://CHESS/Predictability/ARINCComponentModel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ARINCComponentModel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ARINCComponentModelPackage eINSTANCE = org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.impl.ARINCComponentModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.impl.ARINCComponentImplImpl <em>ARINC Component Impl</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.impl.ARINCComponentImplImpl
	 * @see org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.impl.ARINCComponentModelPackageImpl#getARINCComponentImpl()
	 * @generated
	 */
	int ARINC_COMPONENT_IMPL = 0;

	/**
	 * The feature id for the '<em><b>Base Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARINC_COMPONENT_IMPL__BASE_COMPONENT = 0;

	/**
	 * The number of structural features of the '<em>ARINC Component Impl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARINC_COMPONENT_IMPL_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.impl.ARINCProcessImpl <em>ARINC Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.impl.ARINCProcessImpl
	 * @see org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.impl.ARINCComponentModelPackageImpl#getARINCProcess()
	 * @generated
	 */
	int ARINC_PROCESS = 1;

	/**
	 * The feature id for the '<em><b>Base Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARINC_PROCESS__BASE_OPERATION = 0;

	/**
	 * The feature id for the '<em><b>Base Comment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARINC_PROCESS__BASE_COMMENT = 1;

	/**
	 * The feature id for the '<em><b>Operations Groups</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARINC_PROCESS__OPERATIONS_GROUPS = 2;

	/**
	 * The number of structural features of the '<em>ARINC Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARINC_PROCESS_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.impl.ARINCFunctionImpl <em>ARINC Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.impl.ARINCFunctionImpl
	 * @see org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.impl.ARINCComponentModelPackageImpl#getARINCFunction()
	 * @generated
	 */
	int ARINC_FUNCTION = 2;

	/**
	 * The feature id for the '<em><b>Base Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARINC_FUNCTION__BASE_OPERATION = 0;

	/**
	 * The feature id for the '<em><b>Base Comment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARINC_FUNCTION__BASE_COMMENT = 1;

	/**
	 * The feature id for the '<em><b>Followed By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARINC_FUNCTION__FOLLOWED_BY = 2;

	/**
	 * The feature id for the '<em><b>Rate Divider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARINC_FUNCTION__RATE_DIVIDER = 3;

	/**
	 * The number of structural features of the '<em>ARINC Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARINC_FUNCTION_FEATURE_COUNT = 4;


	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.ARINCComponentImpl <em>ARINC Component Impl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ARINC Component Impl</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.ARINCComponentImpl
	 * @generated
	 */
	EClass getARINCComponentImpl();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.ARINCComponentImpl#getBase_Component <em>Base Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Component</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.ARINCComponentImpl#getBase_Component()
	 * @see #getARINCComponentImpl()
	 * @generated
	 */
	EReference getARINCComponentImpl_Base_Component();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.ARINCProcess <em>ARINC Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ARINC Process</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.ARINCProcess
	 * @generated
	 */
	EClass getARINCProcess();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.ARINCProcess#getBase_Operation <em>Base Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Operation</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.ARINCProcess#getBase_Operation()
	 * @see #getARINCProcess()
	 * @generated
	 */
	EReference getARINCProcess_Base_Operation();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.ARINCProcess#getBase_Comment <em>Base Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Comment</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.ARINCProcess#getBase_Comment()
	 * @see #getARINCProcess()
	 * @generated
	 */
	EReference getARINCProcess_Base_Comment();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.ARINCProcess#getOperationsGroups <em>Operations Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operations Groups</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.ARINCProcess#getOperationsGroups()
	 * @see #getARINCProcess()
	 * @generated
	 */
	EAttribute getARINCProcess_OperationsGroups();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.ARINCFunction <em>ARINC Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ARINC Function</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.ARINCFunction
	 * @generated
	 */
	EClass getARINCFunction();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.ARINCFunction#getBase_Operation <em>Base Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Operation</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.ARINCFunction#getBase_Operation()
	 * @see #getARINCFunction()
	 * @generated
	 */
	EReference getARINCFunction_Base_Operation();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.ARINCFunction#getBase_Comment <em>Base Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Comment</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.ARINCFunction#getBase_Comment()
	 * @see #getARINCFunction()
	 * @generated
	 */
	EReference getARINCFunction_Base_Comment();

	/**
	 * Returns the meta object for the reference list '{@link org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.ARINCFunction#getFollowedBy <em>Followed By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Followed By</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.ARINCFunction#getFollowedBy()
	 * @see #getARINCFunction()
	 * @generated
	 */
	EReference getARINCFunction_FollowedBy();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.ARINCFunction#getRateDivider <em>Rate Divider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rate Divider</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.ARINCFunction#getRateDivider()
	 * @see #getARINCFunction()
	 * @generated
	 */
	EAttribute getARINCFunction_RateDivider();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ARINCComponentModelFactory getARINCComponentModelFactory();

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
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.impl.ARINCComponentImplImpl <em>ARINC Component Impl</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.impl.ARINCComponentImplImpl
		 * @see org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.impl.ARINCComponentModelPackageImpl#getARINCComponentImpl()
		 * @generated
		 */
		EClass ARINC_COMPONENT_IMPL = eINSTANCE.getARINCComponentImpl();

		/**
		 * The meta object literal for the '<em><b>Base Component</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARINC_COMPONENT_IMPL__BASE_COMPONENT = eINSTANCE.getARINCComponentImpl_Base_Component();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.impl.ARINCProcessImpl <em>ARINC Process</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.impl.ARINCProcessImpl
		 * @see org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.impl.ARINCComponentModelPackageImpl#getARINCProcess()
		 * @generated
		 */
		EClass ARINC_PROCESS = eINSTANCE.getARINCProcess();

		/**
		 * The meta object literal for the '<em><b>Base Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARINC_PROCESS__BASE_OPERATION = eINSTANCE.getARINCProcess_Base_Operation();

		/**
		 * The meta object literal for the '<em><b>Base Comment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARINC_PROCESS__BASE_COMMENT = eINSTANCE.getARINCProcess_Base_Comment();

		/**
		 * The meta object literal for the '<em><b>Operations Groups</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARINC_PROCESS__OPERATIONS_GROUPS = eINSTANCE.getARINCProcess_OperationsGroups();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.impl.ARINCFunctionImpl <em>ARINC Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.impl.ARINCFunctionImpl
		 * @see org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.impl.ARINCComponentModelPackageImpl#getARINCFunction()
		 * @generated
		 */
		EClass ARINC_FUNCTION = eINSTANCE.getARINCFunction();

		/**
		 * The meta object literal for the '<em><b>Base Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARINC_FUNCTION__BASE_OPERATION = eINSTANCE.getARINCFunction_Base_Operation();

		/**
		 * The meta object literal for the '<em><b>Base Comment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARINC_FUNCTION__BASE_COMMENT = eINSTANCE.getARINCFunction_Base_Comment();

		/**
		 * The meta object literal for the '<em><b>Followed By</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARINC_FUNCTION__FOLLOWED_BY = eINSTANCE.getARINCFunction_FollowedBy();

		/**
		 * The meta object literal for the '<em><b>Rate Divider</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARINC_FUNCTION__RATE_DIVIDER = eINSTANCE.getARINCFunction_RateDivider();

	}

} //ARINCComponentModelPackage
