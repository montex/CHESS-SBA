/**
 */
package org.polarsys.chess.chessmlprofile.SystemModel;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.papyrus.sysml.blocks.BlocksPackage;

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
 * @see org.polarsys.chess.chessmlprofile.SystemModel.SystemModelFactory
 * @model kind="package"
 * @generated
 */
public interface SystemModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "SystemModel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://CHESS/SystemModel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "SystemModel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SystemModelPackage eINSTANCE = org.polarsys.chess.chessmlprofile.SystemModel.impl.SystemModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.impl.HumanImpl <em>Human</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.impl.HumanImpl
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.impl.SystemModelPackageImpl#getHuman()
	 * @generated
	 */
	int HUMAN = 0;

	/**
	 * The feature id for the '<em><b>Is Encapsulated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN__IS_ENCAPSULATED = BlocksPackage.BLOCK__IS_ENCAPSULATED;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN__BASE_CLASS = BlocksPackage.BLOCK__BASE_CLASS;

	/**
	 * The number of structural features of the '<em>Human</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_FEATURE_COUNT = BlocksPackage.BLOCK_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.impl.OrganizationalImpl <em>Organizational</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.impl.OrganizationalImpl
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.impl.SystemModelPackageImpl#getOrganizational()
	 * @generated
	 */
	int ORGANIZATIONAL = 1;

	/**
	 * The feature id for the '<em><b>Is Encapsulated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATIONAL__IS_ENCAPSULATED = BlocksPackage.BLOCK__IS_ENCAPSULATED;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATIONAL__BASE_CLASS = BlocksPackage.BLOCK__BASE_CLASS;

	/**
	 * The number of structural features of the '<em>Organizational</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATIONAL_FEATURE_COUNT = BlocksPackage.BLOCK_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.impl.TechnologicalImpl <em>Technological</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.impl.TechnologicalImpl
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.impl.SystemModelPackageImpl#getTechnological()
	 * @generated
	 */
	int TECHNOLOGICAL = 2;

	/**
	 * The feature id for the '<em><b>Is Encapsulated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TECHNOLOGICAL__IS_ENCAPSULATED = BlocksPackage.BLOCK__IS_ENCAPSULATED;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TECHNOLOGICAL__BASE_CLASS = BlocksPackage.BLOCK__BASE_CLASS;

	/**
	 * The number of structural features of the '<em>Technological</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TECHNOLOGICAL_FEATURE_COUNT = BlocksPackage.BLOCK_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.SystemModel.Human <em>Human</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Human</em>'.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.Human
	 * @generated
	 */
	EClass getHuman();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.SystemModel.Organizational <em>Organizational</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Organizational</em>'.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.Organizational
	 * @generated
	 */
	EClass getOrganizational();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.SystemModel.Technological <em>Technological</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Technological</em>'.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.Technological
	 * @generated
	 */
	EClass getTechnological();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SystemModelFactory getSystemModelFactory();

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
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.impl.HumanImpl <em>Human</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.impl.HumanImpl
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.impl.SystemModelPackageImpl#getHuman()
		 * @generated
		 */
		EClass HUMAN = eINSTANCE.getHuman();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.impl.OrganizationalImpl <em>Organizational</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.impl.OrganizationalImpl
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.impl.SystemModelPackageImpl#getOrganizational()
		 * @generated
		 */
		EClass ORGANIZATIONAL = eINSTANCE.getOrganizational();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.impl.TechnologicalImpl <em>Technological</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.impl.TechnologicalImpl
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.impl.SystemModelPackageImpl#getTechnological()
		 * @generated
		 */
		EClass TECHNOLOGICAL = eINSTANCE.getTechnological();

	}

} //SystemModelPackage
