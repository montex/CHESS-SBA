/**
 */
package org.polarsys.chess.chessmlprofile.SystemModel.STS;

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
 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.STSFactory
 * @model kind="package"
 * @generated
 */
public interface STSPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "STS";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://CHESS/SystemModel/STS";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "STS";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	STSPackage eINSTANCE = org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HumanImpl <em>Human</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HumanImpl
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getHuman()
	 * @generated
	 */
	int HUMAN = 0;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN__BASE_CLASS = 0;

	/**
	 * The number of structural features of the '<em>Human</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.OrganizationalImpl <em>Organizational</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.OrganizationalImpl
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getOrganizational()
	 * @generated
	 */
	int ORGANIZATIONAL = 1;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATIONAL__BASE_CLASS = 0;

	/**
	 * The number of structural features of the '<em>Organizational</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATIONAL_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.TechnologicalImpl <em>Technological</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.TechnologicalImpl
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getTechnological()
	 * @generated
	 */
	int TECHNOLOGICAL = 2;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TECHNOLOGICAL__BASE_CLASS = 0;

	/**
	 * The number of structural features of the '<em>Technological</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TECHNOLOGICAL_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.Human <em>Human</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Human</em>'.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.Human
	 * @generated
	 */
	EClass getHuman();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.Human#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.Human#getBase_Class()
	 * @see #getHuman()
	 * @generated
	 */
	EReference getHuman_Base_Class();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.Organizational <em>Organizational</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Organizational</em>'.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.Organizational
	 * @generated
	 */
	EClass getOrganizational();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.Organizational#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.Organizational#getBase_Class()
	 * @see #getOrganizational()
	 * @generated
	 */
	EReference getOrganizational_Base_Class();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.Technological <em>Technological</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Technological</em>'.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.Technological
	 * @generated
	 */
	EClass getTechnological();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.Technological#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.Technological#getBase_Class()
	 * @see #getTechnological()
	 * @generated
	 */
	EReference getTechnological_Base_Class();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	STSFactory getSTSFactory();

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
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HumanImpl <em>Human</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HumanImpl
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getHuman()
		 * @generated
		 */
		EClass HUMAN = eINSTANCE.getHuman();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HUMAN__BASE_CLASS = eINSTANCE.getHuman_Base_Class();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.OrganizationalImpl <em>Organizational</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.OrganizationalImpl
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getOrganizational()
		 * @generated
		 */
		EClass ORGANIZATIONAL = eINSTANCE.getOrganizational();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ORGANIZATIONAL__BASE_CLASS = eINSTANCE.getOrganizational_Base_Class();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.TechnologicalImpl <em>Technological</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.TechnologicalImpl
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getTechnological()
		 * @generated
		 */
		EClass TECHNOLOGICAL = eINSTANCE.getTechnological();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TECHNOLOGICAL__BASE_CLASS = eINSTANCE.getTechnological_Base_Class();

	}

} //STSPackage
