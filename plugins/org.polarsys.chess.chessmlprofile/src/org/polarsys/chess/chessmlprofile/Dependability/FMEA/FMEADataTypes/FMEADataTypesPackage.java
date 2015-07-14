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
package org.polarsys.chess.chessmlprofile.Dependability.FMEA.FMEADataTypes;

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
 * @see org.polarsys.chess.chessmlprofile.Dependability.FMEA.FMEADataTypes.FMEADataTypesFactory
 * @model kind="package"
 * @generated
 */
public interface FMEADataTypesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "FMEADataTypes";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///CHESS/Dependability/FMEA/FMEADataTypes.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "CHESS.Dependability.FMEA.FMEADataTypes";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FMEADataTypesPackage eINSTANCE = org.polarsys.chess.chessmlprofile.Dependability.FMEA.FMEADataTypes.impl.FMEADataTypesPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.FMEA.FMEADataTypes.Persistency <em>Persistency</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FMEA.FMEADataTypes.Persistency
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FMEA.FMEADataTypes.impl.FMEADataTypesPackageImpl#getPersistency()
	 * @generated
	 */
	int PERSISTENCY = 0;


	/**
	 * Returns the meta object for enum '{@link org.polarsys.chess.chessmlprofile.Dependability.FMEA.FMEADataTypes.Persistency <em>Persistency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Persistency</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FMEA.FMEADataTypes.Persistency
	 * @generated
	 */
	EEnum getPersistency();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FMEADataTypesFactory getFMEADataTypesFactory();

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
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.FMEA.FMEADataTypes.Persistency <em>Persistency</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.FMEA.FMEADataTypes.Persistency
		 * @see org.polarsys.chess.chessmlprofile.Dependability.FMEA.FMEADataTypes.impl.FMEADataTypesPackageImpl#getPersistency()
		 * @generated
		 */
		EEnum PERSISTENCY = eINSTANCE.getPersistency();

	}

} //FMEADataTypesPackage
