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
package org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RTDataTypes.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RTDataTypes.*;

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
 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RTDataTypes.RTDataTypesPackage
 * @generated
 */
public class RTDataTypesSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static RTDataTypesPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RTDataTypesSwitch() {
		if (modelPackage == null) {
			modelPackage = RTDataTypesPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
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
			case RTDataTypesPackage.CH_SPORADIC_PATTERN: {
				CH_SporadicPattern cH_SporadicPattern = (CH_SporadicPattern)theEObject;
				T result = caseCH_SporadicPattern(cH_SporadicPattern);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RTDataTypesPackage.CH_PERIODIC_PATTERN: {
				CH_PeriodicPattern cH_PeriodicPattern = (CH_PeriodicPattern)theEObject;
				T result = caseCH_PeriodicPattern(cH_PeriodicPattern);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RTDataTypesPackage.CH_BURST_PATTERN: {
				CH_BurstPattern cH_BurstPattern = (CH_BurstPattern)theEObject;
				T result = caseCH_BurstPattern(cH_BurstPattern);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RTDataTypesPackage.TA_PATTERN: {
				TA_Pattern tA_Pattern = (TA_Pattern)theEObject;
				T result = caseTA_Pattern(tA_Pattern);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RTDataTypesPackage.TA_ARBITRARY_PATTERN: {
				TA_ArbitraryPattern tA_ArbitraryPattern = (TA_ArbitraryPattern)theEObject;
				T result = caseTA_ArbitraryPattern(tA_ArbitraryPattern);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CH Sporadic Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CH Sporadic Pattern</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCH_SporadicPattern(CH_SporadicPattern object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CH Periodic Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CH Periodic Pattern</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCH_PeriodicPattern(CH_PeriodicPattern object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CH Burst Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CH Burst Pattern</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCH_BurstPattern(CH_BurstPattern object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TA Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TA Pattern</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTA_Pattern(TA_Pattern object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TA Arbitrary Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TA Arbitrary Pattern</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTA_ArbitraryPattern(TA_ArbitraryPattern object) {
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

} //RTDataTypesSwitch
