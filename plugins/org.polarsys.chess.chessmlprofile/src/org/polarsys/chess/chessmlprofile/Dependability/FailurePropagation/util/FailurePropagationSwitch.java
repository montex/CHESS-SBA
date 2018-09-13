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
package org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaAnalysisContext;
import org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.Variables.ExpressionContext;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.Configuration;
import org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponent;
import org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.*;

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
 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationPackage
 * @generated
 */
public class FailurePropagationSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static FailurePropagationPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FailurePropagationSwitch() {
		if (modelPackage == null) {
			modelPackage = FailurePropagationPackage.eINSTANCE;
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
			case FailurePropagationPackage.FPTC_SPECIFICATION: {
				FPTCSpecification fptcSpecification = (FPTCSpecification)theEObject;
				T result = caseFPTCSpecification(fptcSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FailurePropagationPackage.FPTC_PORT_SLOT: {
				FPTCPortSlot fptcPortSlot = (FPTCPortSlot)theEObject;
				T result = caseFPTCPortSlot(fptcPortSlot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FailurePropagationPackage.FPTC: {
				FPTC fptc = (FPTC)theEObject;
				T result = caseFPTC(fptc);
				if (result == null) result = caseDependableComponent(fptc);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FailurePropagationPackage.FLA_BEHAVIOR: {
				FLABehavior flaBehavior = (FLABehavior)theEObject;
				T result = caseFLABehavior(flaBehavior);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FailurePropagationPackage.FAILURE_PROPAGATION_ANALYSIS: {
				FailurePropagationAnalysis failurePropagationAnalysis = (FailurePropagationAnalysis)theEObject;
				T result = caseFailurePropagationAnalysis(failurePropagationAnalysis);
				if (result == null) result = caseGaAnalysisContext(failurePropagationAnalysis);
				if (result == null) result = caseConfiguration(failurePropagationAnalysis);
				if (result == null) result = caseExpressionContext(failurePropagationAnalysis);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FailurePropagationPackage.FI4FA: {
				FI4FA fi4FA = (FI4FA)theEObject;
				T result = caseFI4FA(fi4FA);
				if (result == null) result = caseDependableComponent(fi4FA);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FailurePropagationPackage.FI4FA_SPECIFICATION: {
				FI4FASpecification fi4FASpecification = (FI4FASpecification)theEObject;
				T result = caseFI4FASpecification(fi4FASpecification);
				if (result == null) result = caseFPTCSpecification(fi4FASpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FailurePropagationPackage.ACID_AVOIDABLE: {
				ACIDAvoidable acidAvoidable = (ACIDAvoidable)theEObject;
				T result = caseACIDAvoidable(acidAvoidable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FailurePropagationPackage.ACID_MITIGATION: {
				ACIDMitigation acidMitigation = (ACIDMitigation)theEObject;
				T result = caseACIDMitigation(acidMitigation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FailurePropagationPackage.FI4FA_ANALYSIS: {
				FI4FAAnalysis fi4FAAnalysis = (FI4FAAnalysis)theEObject;
				T result = caseFI4FAAnalysis(fi4FAAnalysis);
				if (result == null) result = caseGaAnalysisContext(fi4FAAnalysis);
				if (result == null) result = caseConfiguration(fi4FAAnalysis);
				if (result == null) result = caseExpressionContext(fi4FAAnalysis);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FPTC</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FPTC</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFPTC(FPTC object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FLA Behavior</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FLA Behavior</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFLABehavior(FLABehavior object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Analysis</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Analysis</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFailurePropagationAnalysis(FailurePropagationAnalysis object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FPTC Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FPTC Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFPTCSpecification(FPTCSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FPTC Port Slot</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FPTC Port Slot</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFPTCPortSlot(FPTCPortSlot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FI4FA</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FI4FA</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFI4FA(FI4FA object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FI4FA Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FI4FA Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFI4FASpecification(FI4FASpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ACID Avoidable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ACID Avoidable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseACIDAvoidable(ACIDAvoidable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ACID Mitigation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ACID Mitigation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseACIDMitigation(ACIDMitigation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FI4FA Analysis</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FI4FA Analysis</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFI4FAAnalysis(FI4FAAnalysis object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dependable Component</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dependable Component</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDependableComponent(DependableComponent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConfiguration(Configuration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpressionContext(ExpressionContext object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ga Analysis Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ga Analysis Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGaAnalysisContext(GaAnalysisContext object) {
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

} //FailurePropagationSwitch
