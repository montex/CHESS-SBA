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
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.impl.InstantiatedArchitectureImpl <em>Instantiated Architecture</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.impl.InstantiatedArchitectureImpl
	 * @see org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.impl.ParameterizedArchitecturePackageImpl#getInstantiatedArchitecture()
	 * @generated
	 */
	int INSTANTIATED_ARCHITECTURE = 0;

	/**
	 * The feature id for the '<em><b>Parameter List</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATED_ARCHITECTURE__PARAMETER_LIST = 0;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATED_ARCHITECTURE__BASE_PROPERTY = 1;

	/**
	 * The feature id for the '<em><b>Instantiated Root Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATED_ARCHITECTURE__INSTANTIATED_ROOT_COMPONENT = 2;

	/**
	 * The number of structural features of the '<em>Instantiated Architecture</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATED_ARCHITECTURE_FEATURE_COUNT = 3;


	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.InstantiatedArchitecture <em>Instantiated Architecture</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instantiated Architecture</em>'.
	 * @see org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.InstantiatedArchitecture
	 * @generated
	 */
	EClass getInstantiatedArchitecture();

	/**
	 * Returns the meta object for the attribute list '{@link org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.InstantiatedArchitecture#getParameterList <em>Parameter List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Parameter List</em>'.
	 * @see org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.InstantiatedArchitecture#getParameterList()
	 * @see #getInstantiatedArchitecture()
	 * @generated
	 */
	EAttribute getInstantiatedArchitecture_ParameterList();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.InstantiatedArchitecture#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.InstantiatedArchitecture#getBase_Property()
	 * @see #getInstantiatedArchitecture()
	 * @generated
	 */
	EReference getInstantiatedArchitecture_Base_Property();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.InstantiatedArchitecture#getInstantiatedRootComponent <em>Instantiated Root Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Instantiated Root Component</em>'.
	 * @see org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.InstantiatedArchitecture#getInstantiatedRootComponent()
	 * @see #getInstantiatedArchitecture()
	 * @generated
	 */
	EReference getInstantiatedArchitecture_InstantiatedRootComponent();

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
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.impl.InstantiatedArchitectureImpl <em>Instantiated Architecture</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.impl.InstantiatedArchitectureImpl
		 * @see org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.impl.ParameterizedArchitecturePackageImpl#getInstantiatedArchitecture()
		 * @generated
		 */
		EClass INSTANTIATED_ARCHITECTURE = eINSTANCE.getInstantiatedArchitecture();

		/**
		 * The meta object literal for the '<em><b>Parameter List</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INSTANTIATED_ARCHITECTURE__PARAMETER_LIST = eINSTANCE.getInstantiatedArchitecture_ParameterList();

		/**
		 * The meta object literal for the '<em><b>Base Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANTIATED_ARCHITECTURE__BASE_PROPERTY = eINSTANCE.getInstantiatedArchitecture_Base_Property();

		/**
		 * The meta object literal for the '<em><b>Instantiated Root Component</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANTIATED_ARCHITECTURE__INSTANTIATED_ROOT_COMPONENT = eINSTANCE.getInstantiatedArchitecture_InstantiatedRootComponent();

	}

} //ParameterizedArchitecturePackage
