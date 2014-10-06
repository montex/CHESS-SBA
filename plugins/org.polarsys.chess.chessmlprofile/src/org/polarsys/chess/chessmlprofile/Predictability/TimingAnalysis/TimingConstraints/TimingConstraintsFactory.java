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
package org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.TimingConstraintsPackage
 * @generated
 */
public interface TimingConstraintsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TimingConstraintsFactory eINSTANCE = org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.impl.TimingConstraintsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Arbitrary Event Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Arbitrary Event Constraint</em>'.
	 * @generated
	 */
	ArbitraryEventConstraint createArbitraryEventConstraint();

	/**
	 * Returns a new object of class '<em>Pattern Event Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pattern Event Constraint</em>'.
	 * @generated
	 */
	PatternEventConstraint createPatternEventConstraint();

	/**
	 * Returns a new object of class '<em>Periodic Event Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Periodic Event Constraint</em>'.
	 * @generated
	 */
	PeriodicEventConstraint createPeriodicEventConstraint();

	/**
	 * Returns a new object of class '<em>Sporadic Event Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sporadic Event Constraint</em>'.
	 * @generated
	 */
	SporadicEventConstraint createSporadicEventConstraint();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TimingConstraintsPackage getTimingConstraintsPackage();

} //TimingConstraintsFactory
