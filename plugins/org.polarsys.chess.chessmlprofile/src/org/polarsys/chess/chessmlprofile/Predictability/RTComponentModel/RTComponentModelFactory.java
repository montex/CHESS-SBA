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
package org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RTComponentModelPackage
 * @generated
 */
public interface RTComponentModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RTComponentModelFactory eINSTANCE = org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.RTComponentModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>CH Rt Port Slot</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CH Rt Port Slot</em>'.
	 * @generated
	 */
	CHRtPortSlot createCHRtPortSlot();

	/**
	 * Returns a new object of class '<em>Run Time Support</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Run Time Support</em>'.
	 * @generated
	 */
	RunTimeSupport createRunTimeSupport();

	/**
	 * Returns a new object of class '<em>CH Rt Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CH Rt Specification</em>'.
	 * @generated
	 */
	CHRtSpecification createCHRtSpecification();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	RTComponentModelPackage getRTComponentModelPackage();

} //RTComponentModelFactory
