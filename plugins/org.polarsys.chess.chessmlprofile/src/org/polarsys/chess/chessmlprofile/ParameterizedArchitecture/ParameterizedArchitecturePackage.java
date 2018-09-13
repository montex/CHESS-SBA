/**
 */
package org.polarsys.chess.chessmlprofile.ParameterizedArchitecture;

import org.eclipse.emf.ecore.EAttribute;
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
 * @see org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.ParameterizedArchitectureFactory
 * @model kind="package"
 * @generated
 */
public interface ParameterizedArchitecturePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ParameterizedArchitecture";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///CHESS/ParameterizedArchitecture.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "CHESS.ParameterizedArchitecture";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ParameterizedArchitecturePackage eINSTANCE = org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.impl.ParameterizedArchitecturePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.impl.InstantiatedByImpl <em>Instantiated By</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.impl.InstantiatedByImpl
	 * @see org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.impl.ParameterizedArchitecturePackageImpl#getInstantiatedBy()
	 * @generated
	 */
	int INSTANTIATED_BY = 0;

	/**
	 * The feature id for the '<em><b>Parameter List</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATED_BY__PARAMETER_LIST = 0;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATED_BY__BASE_DEPENDENCY = 1;

	/**
	 * The number of structural features of the '<em>Instantiated By</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATED_BY_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.InstantiatedBy <em>Instantiated By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instantiated By</em>'.
	 * @see org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.InstantiatedBy
	 * @generated
	 */
	EClass getInstantiatedBy();

	/**
	 * Returns the meta object for the attribute list '{@link org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.InstantiatedBy#getParameterList <em>Parameter List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Parameter List</em>'.
	 * @see org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.InstantiatedBy#getParameterList()
	 * @see #getInstantiatedBy()
	 * @generated
	 */
	EAttribute getInstantiatedBy_ParameterList();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.InstantiatedBy#getBase_Dependency <em>Base Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Dependency</em>'.
	 * @see org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.InstantiatedBy#getBase_Dependency()
	 * @see #getInstantiatedBy()
	 * @generated
	 */
	EReference getInstantiatedBy_Base_Dependency();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ParameterizedArchitectureFactory getParameterizedArchitectureFactory();

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
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.impl.InstantiatedByImpl <em>Instantiated By</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.impl.InstantiatedByImpl
		 * @see org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.impl.ParameterizedArchitecturePackageImpl#getInstantiatedBy()
		 * @generated
		 */
		EClass INSTANTIATED_BY = eINSTANCE.getInstantiatedBy();

		/**
		 * The meta object literal for the '<em><b>Parameter List</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INSTANTIATED_BY__PARAMETER_LIST = eINSTANCE.getInstantiatedBy_ParameterList();

		/**
		 * The meta object literal for the '<em><b>Base Dependency</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANTIATED_BY__BASE_DEPENDENCY = eINSTANCE.getInstantiatedBy_Base_Dependency();

	}

} //ParameterizedArchitecturePackage
