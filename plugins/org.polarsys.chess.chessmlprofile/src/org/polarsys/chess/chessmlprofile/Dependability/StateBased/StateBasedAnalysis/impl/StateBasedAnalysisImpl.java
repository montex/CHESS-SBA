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
package org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaAnalysisContextImpl;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.StateBasedAnalysis;
import org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.StateBasedAnalysisPackage;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.FailureMode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State Based Analysis</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.impl.StateBasedAnalysisImpl#getMeasure <em>Measure</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.impl.StateBasedAnalysisImpl#getMeasureEvaluationResult <em>Measure Evaluation Result</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.impl.StateBasedAnalysisImpl#getEvalMethod <em>Eval Method</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.impl.StateBasedAnalysisImpl#getTargetFailureMode <em>Target Failure Mode</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.impl.StateBasedAnalysisImpl#getTargetDepComponent <em>Target Dep Component</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StateBasedAnalysisImpl extends GaAnalysisContextImpl implements StateBasedAnalysis {
	/**
	 * The default value of the '{@link #getMeasure() <em>Measure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasure()
	 * @generated
	 * @ordered
	 */
	protected static final String MEASURE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMeasure() <em>Measure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasure()
	 * @generated
	 * @ordered
	 */
	protected String measure = MEASURE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMeasureEvaluationResult() <em>Measure Evaluation Result</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasureEvaluationResult()
	 * @generated
	 * @ordered
	 */
	protected static final String MEASURE_EVALUATION_RESULT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMeasureEvaluationResult() <em>Measure Evaluation Result</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasureEvaluationResult()
	 * @generated
	 * @ordered
	 */
	protected String measureEvaluationResult = MEASURE_EVALUATION_RESULT_EDEFAULT;

	/**
	 * The default value of the '{@link #getEvalMethod() <em>Eval Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvalMethod()
	 * @generated
	 * @ordered
	 */
	protected static final String EVAL_METHOD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEvalMethod() <em>Eval Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvalMethod()
	 * @generated
	 * @ordered
	 */
	protected String evalMethod = EVAL_METHOD_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTargetFailureMode() <em>Target Failure Mode</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetFailureMode()
	 * @generated
	 * @ordered
	 */
	protected EList<FailureMode> targetFailureMode;

	/**
	 * The cached value of the '{@link #getTargetDepComponent() <em>Target Dep Component</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetDepComponent()
	 * @generated
	 * @ordered
	 */
	protected EList<InstanceSpecification> targetDepComponent;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateBasedAnalysisImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StateBasedAnalysisPackage.Literals.STATE_BASED_ANALYSIS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMeasure() {
		return measure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeasure(String newMeasure) {
		String oldMeasure = measure;
		measure = newMeasure;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StateBasedAnalysisPackage.STATE_BASED_ANALYSIS__MEASURE, oldMeasure, measure));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMeasureEvaluationResult() {
		return measureEvaluationResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeasureEvaluationResult(String newMeasureEvaluationResult) {
		String oldMeasureEvaluationResult = measureEvaluationResult;
		measureEvaluationResult = newMeasureEvaluationResult;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StateBasedAnalysisPackage.STATE_BASED_ANALYSIS__MEASURE_EVALUATION_RESULT, oldMeasureEvaluationResult, measureEvaluationResult));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEvalMethod() {
		return evalMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEvalMethod(String newEvalMethod) {
		String oldEvalMethod = evalMethod;
		evalMethod = newEvalMethod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StateBasedAnalysisPackage.STATE_BASED_ANALYSIS__EVAL_METHOD, oldEvalMethod, evalMethod));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FailureMode> getTargetFailureMode() {
		if (targetFailureMode == null) {
			targetFailureMode = new EObjectResolvingEList<FailureMode>(FailureMode.class, this, StateBasedAnalysisPackage.STATE_BASED_ANALYSIS__TARGET_FAILURE_MODE);
		}
		return targetFailureMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InstanceSpecification> getTargetDepComponent() {
		if (targetDepComponent == null) {
			targetDepComponent = new EObjectResolvingEList<InstanceSpecification>(InstanceSpecification.class, this, StateBasedAnalysisPackage.STATE_BASED_ANALYSIS__TARGET_DEP_COMPONENT);
		}
		return targetDepComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceSpecification getTargetDepComponent(String name) {
		return getTargetDepComponent(name, false, null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceSpecification getTargetDepComponent(String name, boolean ignoreCase, EClass eClass) {
		targetDepComponentLoop: for (InstanceSpecification targetDepComponent : getTargetDepComponent()) {
			if (eClass != null && !eClass.isInstance(targetDepComponent))
				continue targetDepComponentLoop;
			if (name != null && !(ignoreCase ? name.equalsIgnoreCase(targetDepComponent.getName()) : name.equals(targetDepComponent.getName())))
				continue targetDepComponentLoop;
			return targetDepComponent;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StateBasedAnalysisPackage.STATE_BASED_ANALYSIS__MEASURE:
				return getMeasure();
			case StateBasedAnalysisPackage.STATE_BASED_ANALYSIS__MEASURE_EVALUATION_RESULT:
				return getMeasureEvaluationResult();
			case StateBasedAnalysisPackage.STATE_BASED_ANALYSIS__EVAL_METHOD:
				return getEvalMethod();
			case StateBasedAnalysisPackage.STATE_BASED_ANALYSIS__TARGET_FAILURE_MODE:
				return getTargetFailureMode();
			case StateBasedAnalysisPackage.STATE_BASED_ANALYSIS__TARGET_DEP_COMPONENT:
				return getTargetDepComponent();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case StateBasedAnalysisPackage.STATE_BASED_ANALYSIS__MEASURE:
				setMeasure((String)newValue);
				return;
			case StateBasedAnalysisPackage.STATE_BASED_ANALYSIS__MEASURE_EVALUATION_RESULT:
				setMeasureEvaluationResult((String)newValue);
				return;
			case StateBasedAnalysisPackage.STATE_BASED_ANALYSIS__EVAL_METHOD:
				setEvalMethod((String)newValue);
				return;
			case StateBasedAnalysisPackage.STATE_BASED_ANALYSIS__TARGET_FAILURE_MODE:
				getTargetFailureMode().clear();
				getTargetFailureMode().addAll((Collection<? extends FailureMode>)newValue);
				return;
			case StateBasedAnalysisPackage.STATE_BASED_ANALYSIS__TARGET_DEP_COMPONENT:
				getTargetDepComponent().clear();
				getTargetDepComponent().addAll((Collection<? extends InstanceSpecification>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case StateBasedAnalysisPackage.STATE_BASED_ANALYSIS__MEASURE:
				setMeasure(MEASURE_EDEFAULT);
				return;
			case StateBasedAnalysisPackage.STATE_BASED_ANALYSIS__MEASURE_EVALUATION_RESULT:
				setMeasureEvaluationResult(MEASURE_EVALUATION_RESULT_EDEFAULT);
				return;
			case StateBasedAnalysisPackage.STATE_BASED_ANALYSIS__EVAL_METHOD:
				setEvalMethod(EVAL_METHOD_EDEFAULT);
				return;
			case StateBasedAnalysisPackage.STATE_BASED_ANALYSIS__TARGET_FAILURE_MODE:
				getTargetFailureMode().clear();
				return;
			case StateBasedAnalysisPackage.STATE_BASED_ANALYSIS__TARGET_DEP_COMPONENT:
				getTargetDepComponent().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case StateBasedAnalysisPackage.STATE_BASED_ANALYSIS__MEASURE:
				return MEASURE_EDEFAULT == null ? measure != null : !MEASURE_EDEFAULT.equals(measure);
			case StateBasedAnalysisPackage.STATE_BASED_ANALYSIS__MEASURE_EVALUATION_RESULT:
				return MEASURE_EVALUATION_RESULT_EDEFAULT == null ? measureEvaluationResult != null : !MEASURE_EVALUATION_RESULT_EDEFAULT.equals(measureEvaluationResult);
			case StateBasedAnalysisPackage.STATE_BASED_ANALYSIS__EVAL_METHOD:
				return EVAL_METHOD_EDEFAULT == null ? evalMethod != null : !EVAL_METHOD_EDEFAULT.equals(evalMethod);
			case StateBasedAnalysisPackage.STATE_BASED_ANALYSIS__TARGET_FAILURE_MODE:
				return targetFailureMode != null && !targetFailureMode.isEmpty();
			case StateBasedAnalysisPackage.STATE_BASED_ANALYSIS__TARGET_DEP_COMPONENT:
				return targetDepComponent != null && !targetDepComponent.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (measure: ");
		result.append(measure);
		result.append(", measureEvaluationResult: ");
		result.append(measureEvaluationResult);
		result.append(", evalMethod: ");
		result.append(evalMethod);
		result.append(')');
		return result.toString();
	}

} //StateBasedAnalysisImpl
