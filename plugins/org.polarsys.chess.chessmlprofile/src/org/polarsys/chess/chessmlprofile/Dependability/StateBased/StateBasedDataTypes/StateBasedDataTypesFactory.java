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
package org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.StateBasedDataTypesPackage
 * @generated
 */
public interface StateBasedDataTypesFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StateBasedDataTypesFactory eINSTANCE = org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.StateBasedDataTypesFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Dependability Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dependability Measure</em>'.
	 * @generated
	 */
	DependabilityMeasure createDependabilityMeasure();

	/**
	 * Returns a new object of class '<em>Evaluation Method</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Evaluation Method</em>'.
	 * @generated
	 */
	EvaluationMethod createEvaluationMethod();

	/**
	 * Returns a new object of class '<em>Evaluation By Simulation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Evaluation By Simulation</em>'.
	 * @generated
	 */
	EvaluationBySimulation createEvaluationBySimulation();

	/**
	 * Returns a new object of class '<em>Evaluation Analytical</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Evaluation Analytical</em>'.
	 * @generated
	 */
	EvaluationAnalytical createEvaluationAnalytical();

	/**
	 * Returns a new object of class '<em>Reliability</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reliability</em>'.
	 * @generated
	 */
	Reliability createReliability();

	/**
	 * Returns a new object of class '<em>Evaluation Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Evaluation Type</em>'.
	 * @generated
	 */
	EvaluationType createEvaluationType();

	/**
	 * Returns a new object of class '<em>Steady State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Steady State</em>'.
	 * @generated
	 */
	SteadyState createSteadyState();

	/**
	 * Returns a new object of class '<em>Availability</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Availability</em>'.
	 * @generated
	 */
	Availability createAvailability();

	/**
	 * Returns a new object of class '<em>MTTF</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MTTF</em>'.
	 * @generated
	 */
	MTTF createMTTF();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	StateBasedDataTypesPackage getStateBasedDataTypesPackage();

} //StateBasedDataTypesFactory
