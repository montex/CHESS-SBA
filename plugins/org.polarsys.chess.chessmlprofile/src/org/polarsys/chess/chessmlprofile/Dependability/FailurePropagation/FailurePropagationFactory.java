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
package org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationPackage
 * @generated
 */
public interface FailurePropagationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FailurePropagationFactory eINSTANCE = org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FailurePropagationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>FPTC</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FPTC</em>'.
	 * @generated
	 */
	FPTC createFPTC();

	/**
	 * Returns a new object of class '<em>Analysis</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Analysis</em>'.
	 * @generated
	 */
	FailurePropagationAnalysis createFailurePropagationAnalysis();

	/**
	 * Returns a new object of class '<em>FPTC Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FPTC Specification</em>'.
	 * @generated
	 */
	FPTCSpecification createFPTCSpecification();

	/**
	 * Returns a new object of class '<em>FPTC Port Slot</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FPTC Port Slot</em>'.
	 * @generated
	 */
	FPTCPortSlot createFPTCPortSlot();

	/**
	 * Returns a new object of class '<em>FI4FA</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FI4FA</em>'.
	 * @generated
	 */
	FI4FA createFI4FA();

	/**
	 * Returns a new object of class '<em>FI4FA Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FI4FA Specification</em>'.
	 * @generated
	 */
	FI4FASpecification createFI4FASpecification();

	/**
	 * Returns a new object of class '<em>ACID Avoidable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ACID Avoidable</em>'.
	 * @generated
	 */
	ACIDAvoidable createACIDAvoidable();

	/**
	 * Returns a new object of class '<em>ACID Mitigation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ACID Mitigation</em>'.
	 * @generated
	 */
	ACIDMitigation createACIDMitigation();

	/**
	 * Returns a new object of class '<em>FI4FA Analysis</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FI4FA Analysis</em>'.
	 * @generated
	 */
	FI4FAAnalysis createFI4FAAnalysis();

	/**
	 * Returns a new object of class '<em>FLA Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FLA Specification</em>'.
	 * @generated
	 */
	FLASpecification createFLASpecification();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	FailurePropagationPackage getFailurePropagationPackage();

} //FailurePropagationFactory
