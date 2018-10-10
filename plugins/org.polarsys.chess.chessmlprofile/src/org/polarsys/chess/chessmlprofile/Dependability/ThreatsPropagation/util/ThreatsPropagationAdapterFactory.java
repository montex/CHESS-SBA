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
package org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.*;

import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.DegradedState;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.DepEvent;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ErrorModel;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Failure;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalFault;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalPropagation;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Inverted;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.NormalInput;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.NormalOutput;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.RampDown;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.StuckAt;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.StuckAtFixed;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatState;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatsPropagationPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatsPropagationPackage
 * @generated
 */
public class ThreatsPropagationAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ThreatsPropagationPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThreatsPropagationAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ThreatsPropagationPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ThreatsPropagationSwitch<Adapter> modelSwitch =
		new ThreatsPropagationSwitch<Adapter>() {
			@Override
			public Adapter caseDegradedState(DegradedState object) {
				return createDegradedStateAdapter();
			}
			@Override
			public Adapter caseThreatState(ThreatState object) {
				return createThreatStateAdapter();
			}
			@Override
			public Adapter caseNormalState(NormalState object) {
				return createNormalStateAdapter();
			}
			@Override
			public Adapter caseErrorState(ErrorState object) {
				return createErrorStateAdapter();
			}
			@Override
			public Adapter caseStuckAt(StuckAt object) {
				return createStuckAtAdapter();
			}
			@Override
			public Adapter caseStuckAtFixed(StuckAtFixed object) {
				return createStuckAtFixedAdapter();
			}
			@Override
			public Adapter caseInverted(Inverted object) {
				return createInvertedAdapter();
			}
			@Override
			public Adapter caseRampDown(RampDown object) {
				return createRampDownAdapter();
			}
			@Override
			public Adapter caseNormalInput(NormalInput object) {
				return createNormalInputAdapter();
			}
			@Override
			public Adapter caseDepEvent(DepEvent object) {
				return createDepEventAdapter();
			}
			@Override
			public Adapter caseNormalOutput(NormalOutput object) {
				return createNormalOutputAdapter();
			}
			@Override
			public Adapter caseFailure(Failure object) {
				return createFailureAdapter();
			}
			@Override
			public Adapter caseInternalFault(InternalFault object) {
				return createInternalFaultAdapter();
			}
			@Override
			public Adapter caseInternalPropagation(InternalPropagation object) {
				return createInternalPropagationAdapter();
			}
			@Override
			public Adapter caseErrorDetection(ErrorDetection object) {
				return createErrorDetectionAdapter();
			}
			@Override
			public Adapter caseErrorHandling(ErrorHandling object) {
				return createErrorHandlingAdapter();
			}
			@Override
			public Adapter caseFaultHandling(FaultHandling object) {
				return createFaultHandlingAdapter();
			}
			@Override
			public Adapter caseAttack(Attack object) {
				return createAttackAdapter();
			}
			@Override
			public Adapter caseVulnerability(Vulnerability object) {
				return createVulnerabilityAdapter();
			}
			@Override
			public Adapter caseErrorModel(ErrorModel object) {
				return createErrorModelAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalFault <em>Internal Fault</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalFault
	 * @generated
	 */
	public Adapter createInternalFaultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalPropagation <em>Internal Propagation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalPropagation
	 * @generated
	 */
	public Adapter createInternalPropagationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ErrorDetection <em>Error Detection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ErrorDetection
	 * @generated
	 */
	public Adapter createErrorDetectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ErrorHandling <em>Error Handling</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ErrorHandling
	 * @generated
	 */
	public Adapter createErrorHandlingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.FaultHandling <em>Fault Handling</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.FaultHandling
	 * @generated
	 */
	public Adapter createFaultHandlingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Attack <em>Attack</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Attack
	 * @generated
	 */
	public Adapter createAttackAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Vulnerability <em>Vulnerability</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Vulnerability
	 * @generated
	 */
	public Adapter createVulnerabilityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ErrorModel <em>Error Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ErrorModel
	 * @generated
	 */
	public Adapter createErrorModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.NormalInput <em>Normal Input</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.NormalInput
	 * @generated
	 */
	public Adapter createNormalInputAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.NormalOutput <em>Normal Output</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.NormalOutput
	 * @generated
	 */
	public Adapter createNormalOutputAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Failure <em>Failure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Failure
	 * @generated
	 */
	public Adapter createFailureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatState <em>Threat State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatState
	 * @generated
	 */
	public Adapter createThreatStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.DegradedState <em>Degraded State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.DegradedState
	 * @generated
	 */
	public Adapter createDegradedStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.NormalState <em>Normal State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.NormalState
	 * @generated
	 */
	public Adapter createNormalStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ErrorState <em>Error State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ErrorState
	 * @generated
	 */
	public Adapter createErrorStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.StuckAt <em>Stuck At</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.StuckAt
	 * @generated
	 */
	public Adapter createStuckAtAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.StuckAtFixed <em>Stuck At Fixed</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.StuckAtFixed
	 * @generated
	 */
	public Adapter createStuckAtFixedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Inverted <em>Inverted</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Inverted
	 * @generated
	 */
	public Adapter createInvertedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.RampDown <em>Ramp Down</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.RampDown
	 * @generated
	 */
	public Adapter createRampDownAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.DepEvent <em>Dep Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.DepEvent
	 * @generated
	 */
	public Adapter createDepEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ThreatsPropagationAdapterFactory
