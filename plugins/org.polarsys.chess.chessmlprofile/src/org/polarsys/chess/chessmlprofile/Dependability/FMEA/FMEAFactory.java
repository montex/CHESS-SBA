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
package org.polarsys.chess.chessmlprofile.Dependability.FMEA;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.polarsys.chess.chessmlprofile.Dependability.FMEA.FMEAPackage
 * @generated
 */
public interface FMEAFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FMEAFactory eINSTANCE = org.polarsys.chess.chessmlprofile.Dependability.FMEA.impl.FMEAFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>FIBEX</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FIBEX</em>'.
	 * @generated
	 */
	FIBEX createFIBEX();

	/**
	 * Returns a new object of class '<em>Analysis</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Analysis</em>'.
	 * @generated
	 */
	FMEAAnalysis createFMEAAnalysis();

	/**
	 * Returns a new object of class '<em>Error Model Assign</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Error Model Assign</em>'.
	 * @generated
	 */
	ErrorModelAssign createErrorModelAssign();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	FMEAPackage getFMEAPackage();

} //FMEAFactory
