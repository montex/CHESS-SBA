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
package org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatsPropagationPackage
 * @generated
 */
public interface ThreatsPropagationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ThreatsPropagationFactory eINSTANCE = org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Internal Fault</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Internal Fault</em>'.
	 * @generated
	 */
	InternalFault createInternalFault();

	/**
	 * Returns a new object of class '<em>Internal Propagation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Internal Propagation</em>'.
	 * @generated
	 */
	InternalPropagation createInternalPropagation();

	/**
	 * Returns a new object of class '<em>Error Detection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Error Detection</em>'.
	 * @generated
	 */
	ErrorDetection createErrorDetection();

	/**
	 * Returns a new object of class '<em>Error Handling</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Error Handling</em>'.
	 * @generated
	 */
	ErrorHandling createErrorHandling();

	/**
	 * Returns a new object of class '<em>Fault Handling</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fault Handling</em>'.
	 * @generated
	 */
	FaultHandling createFaultHandling();

	/**
	 * Returns a new object of class '<em>Error Model Behavior</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Error Model Behavior</em>'.
	 * @generated
	 */
	ErrorModelBehavior createErrorModelBehavior();

	/**
	 * Returns a new object of class '<em>External Fault</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>External Fault</em>'.
	 * @generated
	 */
	ExternalFault createExternalFault();

	/**
	 * Returns a new object of class '<em>Normal Input</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Normal Input</em>'.
	 * @generated
	 */
	NormalInput createNormalInput();

	/**
	 * Returns a new object of class '<em>Recovery Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Recovery Event</em>'.
	 * @generated
	 */
	RecoveryEvent createRecoveryEvent();

	/**
	 * Returns a new object of class '<em>Normal Output</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Normal Output</em>'.
	 * @generated
	 */
	NormalOutput createNormalOutput();

	/**
	 * Returns a new object of class '<em>Failure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Failure</em>'.
	 * @generated
	 */
	Failure createFailure();

	/**
	 * Returns a new object of class '<em>Normal Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Normal Event</em>'.
	 * @generated
	 */
	NormalEvent createNormalEvent();

	/**
	 * Returns a new object of class '<em>Internal Threat</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Internal Threat</em>'.
	 * @generated
	 */
	InternalThreat createInternalThreat();

	/**
	 * Returns a new object of class '<em>Threat State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Threat State</em>'.
	 * @generated
	 */
	ThreatState createThreatState();

	/**
	 * Returns a new object of class '<em>Error Free</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Error Free</em>'.
	 * @generated
	 */
	ErrorFree createErrorFree();

	/**
	 * Returns a new object of class '<em>Unclassified Error</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unclassified Error</em>'.
	 * @generated
	 */
	UnclassifiedError createUnclassifiedError();

	/**
	 * Returns a new object of class '<em>Failure Mode</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Failure Mode</em>'.
	 * @generated
	 */
	FailureMode createFailureMode();

	/**
	 * Returns a new object of class '<em>Degraded State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Degraded State</em>'.
	 * @generated
	 */
	DegradedState createDegradedState();

	/**
	 * Returns a new object of class '<em>Normal State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Normal State</em>'.
	 * @generated
	 */
	NormalState createNormalState();

	/**
	 * Returns a new object of class '<em>Failure Free</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Failure Free</em>'.
	 * @generated
	 */
	FailureFree createFailureFree();

	/**
	 * Returns a new object of class '<em>CH Internal Fault</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CH Internal Fault</em>'.
	 * @generated
	 */
	CHInternalFault createCHInternalFault();

	/**
	 * Returns a new object of class '<em>CH External Fault</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CH External Fault</em>'.
	 * @generated
	 */
	CHExternalFault createCHExternalFault();

	/**
	 * Returns a new object of class '<em>Error State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Error State</em>'.
	 * @generated
	 */
	ErrorState createErrorState();

	/**
	 * Returns a new object of class '<em>Unclassified Failure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unclassified Failure</em>'.
	 * @generated
	 */
	UnclassifiedFailure createUnclassifiedFailure();

	/**
	 * Returns a new object of class '<em>Stuck At</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stuck At</em>'.
	 * @generated
	 */
	StuckAt createStuckAt();

	/**
	 * Returns a new object of class '<em>Stuck At Fixed</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stuck At Fixed</em>'.
	 * @generated
	 */
	StuckAtFixed createStuckAtFixed();

	/**
	 * Returns a new object of class '<em>Inverted</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Inverted</em>'.
	 * @generated
	 */
	Inverted createInverted();

	/**
	 * Returns a new object of class '<em>Ramp Down</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ramp Down</em>'.
	 * @generated
	 */
	RampDown createRampDown();

	/**
	 * Returns a new object of class '<em>Input Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Input Event</em>'.
	 * @generated
	 */
	InputEvent createInputEvent();

	/**
	 * Returns a new object of class '<em>Dep Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dep Event</em>'.
	 * @generated
	 */
	DepEvent createDepEvent();

	/**
	 * Returns a new object of class '<em>Output Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Output Event</em>'.
	 * @generated
	 */
	OutputEvent createOutputEvent();

	/**
	 * Returns a new object of class '<em>Internal Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Internal Event</em>'.
	 * @generated
	 */
	InternalEvent createInternalEvent();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ThreatsPropagationPackage getThreatsPropagationPackage();

} //ThreatsPropagationFactory
