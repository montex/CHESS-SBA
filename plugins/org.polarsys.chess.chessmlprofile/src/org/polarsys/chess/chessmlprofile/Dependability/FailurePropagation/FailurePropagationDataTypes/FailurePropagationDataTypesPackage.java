/*****************************************************************************
 * Copyright (c) 2011 - 2014 University of Padova, Intecs
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *
 *****************************************************************************/
package org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

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
 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.FailurePropagationDataTypesFactory
 * @model kind="package"
 * @generated
 */
public interface FailurePropagationDataTypesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "FailurePropagationDataTypes";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///CHESS/Dependability/FailurePropagation/FailurePropagationDataTypes.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "CHESS.Dependability.FailurePropagation.FailurePropagationDataTypes";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FailurePropagationDataTypesPackage eINSTANCE = org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.impl.FailurePropagationDataTypesPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.D_avoidable <em>Davoidable</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.D_avoidable
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.impl.FailurePropagationDataTypesPackageImpl#getD_avoidable()
	 * @generated
	 */
	int DAVOIDABLE = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.I_avoidable <em>Iavoidable</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.I_avoidable
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.impl.FailurePropagationDataTypesPackageImpl#getI_avoidable()
	 * @generated
	 */
	int IAVOIDABLE = 1;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.C_avoidable <em>Cavoidable</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.C_avoidable
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.impl.FailurePropagationDataTypesPackageImpl#getC_avoidable()
	 * @generated
	 */
	int CAVOIDABLE = 2;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.FailureType <em>Failure Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.FailureType
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.impl.FailurePropagationDataTypesPackageImpl#getFailureType()
	 * @generated
	 */
	int FAILURE_TYPE = 3;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.A_avoidable <em>Aavoidable</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.A_avoidable
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.impl.FailurePropagationDataTypesPackageImpl#getA_avoidable()
	 * @generated
	 */
	int AAVOIDABLE = 4;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.A_mitigation <em>Amitigation</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.A_mitigation
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.impl.FailurePropagationDataTypesPackageImpl#getA_mitigation()
	 * @generated
	 */
	int AMITIGATION = 5;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.C_mitigation <em>Cmitigation</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.C_mitigation
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.impl.FailurePropagationDataTypesPackageImpl#getC_mitigation()
	 * @generated
	 */
	int CMITIGATION = 6;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.I_mitigation <em>Imitigation</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.I_mitigation
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.impl.FailurePropagationDataTypesPackageImpl#getI_mitigation()
	 * @generated
	 */
	int IMITIGATION = 7;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.D_mitigation <em>Dmitigation</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.D_mitigation
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.impl.FailurePropagationDataTypesPackageImpl#getD_mitigation()
	 * @generated
	 */
	int DMITIGATION = 8;


	/**
	 * Returns the meta object for enum '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.D_avoidable <em>Davoidable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Davoidable</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.D_avoidable
	 * @generated
	 */
	EEnum getD_avoidable();

	/**
	 * Returns the meta object for enum '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.I_avoidable <em>Iavoidable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Iavoidable</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.I_avoidable
	 * @generated
	 */
	EEnum getI_avoidable();

	/**
	 * Returns the meta object for enum '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.C_avoidable <em>Cavoidable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Cavoidable</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.C_avoidable
	 * @generated
	 */
	EEnum getC_avoidable();

	/**
	 * Returns the meta object for enum '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.FailureType <em>Failure Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Failure Type</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.FailureType
	 * @generated
	 */
	EEnum getFailureType();

	/**
	 * Returns the meta object for enum '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.A_avoidable <em>Aavoidable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Aavoidable</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.A_avoidable
	 * @generated
	 */
	EEnum getA_avoidable();

	/**
	 * Returns the meta object for enum '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.A_mitigation <em>Amitigation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Amitigation</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.A_mitigation
	 * @generated
	 */
	EEnum getA_mitigation();

	/**
	 * Returns the meta object for enum '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.C_mitigation <em>Cmitigation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Cmitigation</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.C_mitigation
	 * @generated
	 */
	EEnum getC_mitigation();

	/**
	 * Returns the meta object for enum '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.I_mitigation <em>Imitigation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Imitigation</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.I_mitigation
	 * @generated
	 */
	EEnum getI_mitigation();

	/**
	 * Returns the meta object for enum '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.D_mitigation <em>Dmitigation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Dmitigation</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.D_mitigation
	 * @generated
	 */
	EEnum getD_mitigation();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FailurePropagationDataTypesFactory getFailurePropagationDataTypesFactory();

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
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.D_avoidable <em>Davoidable</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.D_avoidable
		 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.impl.FailurePropagationDataTypesPackageImpl#getD_avoidable()
		 * @generated
		 */
		EEnum DAVOIDABLE = eINSTANCE.getD_avoidable();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.I_avoidable <em>Iavoidable</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.I_avoidable
		 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.impl.FailurePropagationDataTypesPackageImpl#getI_avoidable()
		 * @generated
		 */
		EEnum IAVOIDABLE = eINSTANCE.getI_avoidable();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.C_avoidable <em>Cavoidable</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.C_avoidable
		 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.impl.FailurePropagationDataTypesPackageImpl#getC_avoidable()
		 * @generated
		 */
		EEnum CAVOIDABLE = eINSTANCE.getC_avoidable();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.FailureType <em>Failure Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.FailureType
		 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.impl.FailurePropagationDataTypesPackageImpl#getFailureType()
		 * @generated
		 */
		EEnum FAILURE_TYPE = eINSTANCE.getFailureType();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.A_avoidable <em>Aavoidable</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.A_avoidable
		 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.impl.FailurePropagationDataTypesPackageImpl#getA_avoidable()
		 * @generated
		 */
		EEnum AAVOIDABLE = eINSTANCE.getA_avoidable();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.A_mitigation <em>Amitigation</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.A_mitigation
		 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.impl.FailurePropagationDataTypesPackageImpl#getA_mitigation()
		 * @generated
		 */
		EEnum AMITIGATION = eINSTANCE.getA_mitigation();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.C_mitigation <em>Cmitigation</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.C_mitigation
		 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.impl.FailurePropagationDataTypesPackageImpl#getC_mitigation()
		 * @generated
		 */
		EEnum CMITIGATION = eINSTANCE.getC_mitigation();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.I_mitigation <em>Imitigation</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.I_mitigation
		 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.impl.FailurePropagationDataTypesPackageImpl#getI_mitigation()
		 * @generated
		 */
		EEnum IMITIGATION = eINSTANCE.getI_mitigation();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.D_mitigation <em>Dmitigation</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.D_mitigation
		 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.impl.FailurePropagationDataTypesPackageImpl#getD_mitigation()
		 * @generated
		 */
		EEnum DMITIGATION = eINSTANCE.getD_mitigation();

	}

} //FailurePropagationDataTypesPackage
