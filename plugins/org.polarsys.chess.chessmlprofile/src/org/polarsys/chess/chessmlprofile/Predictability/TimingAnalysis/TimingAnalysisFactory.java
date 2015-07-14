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
package org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingAnalysisPackage
 * @generated
 */
public interface TimingAnalysisFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TimingAnalysisFactory eINSTANCE = org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.impl.TimingAnalysisFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Simulation Based Timing Analysis</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simulation Based Timing Analysis</em>'.
	 * @generated
	 */
	SimulationBasedTimingAnalysis createSimulationBasedTimingAnalysis();

	/**
	 * Returns a new object of class '<em>Age Timing Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Age Timing Constraint</em>'.
	 * @generated
	 */
	AgeTimingConstraint createAgeTimingConstraint();

	/**
	 * Returns a new object of class '<em>Reaction Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reaction Constraint</em>'.
	 * @generated
	 */
	ReactionConstraint createReactionConstraint();

	/**
	 * Returns a new object of class '<em>Output Synchronization Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Output Synchronization Constraint</em>'.
	 * @generated
	 */
	OutputSynchronizationConstraint createOutputSynchronizationConstraint();

	/**
	 * Returns a new object of class '<em>Input Synchronization Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Input Synchronization Constraint</em>'.
	 * @generated
	 */
	InputSynchronizationConstraint createInputSynchronizationConstraint();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TimingAnalysisPackage getTimingAnalysisPackage();

} //TimingAnalysisFactory
