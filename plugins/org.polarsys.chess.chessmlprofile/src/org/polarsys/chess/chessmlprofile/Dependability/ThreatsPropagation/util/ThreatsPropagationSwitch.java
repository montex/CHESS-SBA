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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
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
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatsPropagationPackage
 * @generated
 */
public class ThreatsPropagationSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ThreatsPropagationPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThreatsPropagationSwitch() {
		if (modelPackage == null) {
			modelPackage = ThreatsPropagationPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ThreatsPropagationPackage.DEGRADED_STATE: {
				DegradedState degradedState = (DegradedState)theEObject;
				T result = caseDegradedState(degradedState);
				if (result == null) result = caseThreatState(degradedState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ThreatsPropagationPackage.THREAT_STATE: {
				ThreatState threatState = (ThreatState)theEObject;
				T result = caseThreatState(threatState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ThreatsPropagationPackage.NORMAL_STATE: {
				NormalState normalState = (NormalState)theEObject;
				T result = caseNormalState(normalState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ThreatsPropagationPackage.ERROR_STATE: {
				ErrorState errorState = (ErrorState)theEObject;
				T result = caseErrorState(errorState);
				if (result == null) result = caseThreatState(errorState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ThreatsPropagationPackage.STUCK_AT: {
				StuckAt stuckAt = (StuckAt)theEObject;
				T result = caseStuckAt(stuckAt);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ThreatsPropagationPackage.STUCK_AT_FIXED: {
				StuckAtFixed stuckAtFixed = (StuckAtFixed)theEObject;
				T result = caseStuckAtFixed(stuckAtFixed);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ThreatsPropagationPackage.INVERTED: {
				Inverted inverted = (Inverted)theEObject;
				T result = caseInverted(inverted);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ThreatsPropagationPackage.RAMP_DOWN: {
				RampDown rampDown = (RampDown)theEObject;
				T result = caseRampDown(rampDown);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ThreatsPropagationPackage.NORMAL_INPUT: {
				NormalInput normalInput = (NormalInput)theEObject;
				T result = caseNormalInput(normalInput);
				if (result == null) result = caseDepEvent(normalInput);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ThreatsPropagationPackage.DEP_EVENT: {
				DepEvent depEvent = (DepEvent)theEObject;
				T result = caseDepEvent(depEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ThreatsPropagationPackage.NORMAL_OUTPUT: {
				NormalOutput normalOutput = (NormalOutput)theEObject;
				T result = caseNormalOutput(normalOutput);
				if (result == null) result = caseDepEvent(normalOutput);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ThreatsPropagationPackage.FAILURE: {
				Failure failure = (Failure)theEObject;
				T result = caseFailure(failure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ThreatsPropagationPackage.INTERNAL_FAULT: {
				InternalFault internalFault = (InternalFault)theEObject;
				T result = caseInternalFault(internalFault);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ThreatsPropagationPackage.INTERNAL_PROPAGATION: {
				InternalPropagation internalPropagation = (InternalPropagation)theEObject;
				T result = caseInternalPropagation(internalPropagation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ThreatsPropagationPackage.ERROR_DETECTION: {
				ErrorDetection errorDetection = (ErrorDetection)theEObject;
				T result = caseErrorDetection(errorDetection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ThreatsPropagationPackage.ERROR_HANDLING: {
				ErrorHandling errorHandling = (ErrorHandling)theEObject;
				T result = caseErrorHandling(errorHandling);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ThreatsPropagationPackage.FAULT_HANDLING: {
				FaultHandling faultHandling = (FaultHandling)theEObject;
				T result = caseFaultHandling(faultHandling);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ThreatsPropagationPackage.ATTACK: {
				Attack attack = (Attack)theEObject;
				T result = caseAttack(attack);
				if (result == null) result = caseInternalPropagation(attack);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ThreatsPropagationPackage.VULNERABILITY: {
				Vulnerability vulnerability = (Vulnerability)theEObject;
				T result = caseVulnerability(vulnerability);
				if (result == null) result = caseInternalFault(vulnerability);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ThreatsPropagationPackage.ERROR_MODEL: {
				ErrorModel errorModel = (ErrorModel)theEObject;
				T result = caseErrorModel(errorModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Internal Fault</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Internal Fault</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInternalFault(InternalFault object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Internal Propagation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Internal Propagation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInternalPropagation(InternalPropagation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Error Detection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Error Detection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseErrorDetection(ErrorDetection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Error Handling</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Error Handling</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseErrorHandling(ErrorHandling object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fault Handling</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fault Handling</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFaultHandling(FaultHandling object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attack</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attack</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttack(Attack object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Vulnerability</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Vulnerability</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVulnerability(Vulnerability object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Error Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Error Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseErrorModel(ErrorModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Normal Input</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Normal Input</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNormalInput(NormalInput object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Normal Output</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Normal Output</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNormalOutput(NormalOutput object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Failure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Failure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFailure(Failure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Threat State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Threat State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThreatState(ThreatState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Degraded State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Degraded State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDegradedState(DegradedState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Normal State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Normal State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNormalState(NormalState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Error State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Error State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseErrorState(ErrorState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stuck At</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stuck At</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStuckAt(StuckAt object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stuck At Fixed</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stuck At Fixed</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStuckAtFixed(StuckAtFixed object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Inverted</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inverted</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInverted(Inverted object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ramp Down</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ramp Down</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRampDown(RampDown object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dep Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dep Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDepEvent(DepEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //ThreatsPropagationSwitch
