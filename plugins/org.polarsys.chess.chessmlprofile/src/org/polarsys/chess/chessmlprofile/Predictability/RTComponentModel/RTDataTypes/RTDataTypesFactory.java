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
package org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RTDataTypes;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RTDataTypes.RTDataTypesPackage
 * @generated
 */
public interface RTDataTypesFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RTDataTypesFactory eINSTANCE = org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RTDataTypes.impl.RTDataTypesFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>CH Sporadic Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CH Sporadic Pattern</em>'.
	 * @generated
	 */
	CH_SporadicPattern createCH_SporadicPattern();

	/**
	 * Returns a new object of class '<em>CH Periodic Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CH Periodic Pattern</em>'.
	 * @generated
	 */
	CH_PeriodicPattern createCH_PeriodicPattern();

	/**
	 * Returns a new object of class '<em>CH Burst Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CH Burst Pattern</em>'.
	 * @generated
	 */
	CH_BurstPattern createCH_BurstPattern();

	/**
	 * Returns a new object of class '<em>TA Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TA Pattern</em>'.
	 * @generated
	 */
	TA_Pattern createTA_Pattern();

	/**
	 * Returns a new object of class '<em>TA Arbitrary Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TA Arbitrary Pattern</em>'.
	 * @generated
	 */
	TA_ArbitraryPattern createTA_ArbitraryPattern();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	RTDataTypesPackage getRTDataTypesPackage();

} //RTDataTypesFactory
