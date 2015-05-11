/*****************************************************************************
 * Copyright (c) 2011, 2015 University of Padova, Intecs
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *
 *****************************************************************************/
package org.polarsys.chess.chessmlprofile.Core;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.polarsys.chess.chessmlprofile.Core.CorePackage
 * @generated
 */
public interface CoreFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CoreFactory eINSTANCE = org.polarsys.chess.chessmlprofile.Core.impl.CoreFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>CHESS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CHESS</em>'.
	 * @generated
	 */
	CHESS createCHESS();

	/**
	 * Returns a new object of class '<em>CH Ga Resource Platform</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CH Ga Resource Platform</em>'.
	 * @generated
	 */
	CHGaResourcePlatform createCHGaResourcePlatform();

	/**
	 * Returns a new object of class '<em>Identif Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Identif Instance</em>'.
	 * @generated
	 */
	IdentifInstance createIdentifInstance();

	/**
	 * Returns a new object of class '<em>Identif Slot</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Identif Slot</em>'.
	 * @generated
	 */
	IdentifSlot createIdentifSlot();

	/**
	 * Returns a new object of class '<em>Multi Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Multi Instance</em>'.
	 * @generated
	 */
	MultiInstance createMultiInstance();

	/**
	 * Returns a new object of class '<em>Multi Slot</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Multi Slot</em>'.
	 * @generated
	 */
	MultiSlot createMultiSlot();

	/**
	 * Returns a new object of class '<em>PSM Package</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PSM Package</em>'.
	 * @generated
	 */
	PSMPackage createPSMPackage();

	/**
	 * Returns a new object of class '<em>Functional Partitions</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Functional Partitions</em>'.
	 * @generated
	 */
	FunctionalPartitions createFunctionalPartitions();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CorePackage getCorePackage();

} //CoreFactory
