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
package org.polarsys.chess.chessmlprofile.Dependability.FMEA.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaAnalysisContextImpl;
import org.polarsys.chess.chessmlprofile.Dependability.FMEA.FMEAAnalysis;
import org.polarsys.chess.chessmlprofile.Dependability.FMEA.FMEAPackage;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatState;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Analysis</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.FMEA.impl.FMEAAnalysisImpl#getErrorType <em>Error Type</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.FMEA.impl.FMEAAnalysisImpl#getSimulationRuns <em>Simulation Runs</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.FMEA.impl.FMEAAnalysisImpl#getAnalysisType <em>Analysis Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FMEAAnalysisImpl extends GaAnalysisContextImpl implements FMEAAnalysis {
	/**
	 * The cached value of the '{@link #getErrorType() <em>Error Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrorType()
	 * @generated
	 * @ordered
	 */
	protected ThreatState errorType;

	/**
	 * The default value of the '{@link #getSimulationRuns() <em>Simulation Runs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimulationRuns()
	 * @generated
	 * @ordered
	 */
	protected static final int SIMULATION_RUNS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSimulationRuns() <em>Simulation Runs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimulationRuns()
	 * @generated
	 * @ordered
	 */
	protected int simulationRuns = SIMULATION_RUNS_EDEFAULT;

	/**
	 * The default value of the '{@link #getAnalysisType() <em>Analysis Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnalysisType()
	 * @generated
	 * @ordered
	 */
	protected static final String ANALYSIS_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAnalysisType() <em>Analysis Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnalysisType()
	 * @generated
	 * @ordered
	 */
	protected String analysisType = ANALYSIS_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FMEAAnalysisImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FMEAPackage.Literals.FMEA_ANALYSIS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThreatState getErrorType() {
		if (errorType != null && errorType.eIsProxy()) {
			InternalEObject oldErrorType = (InternalEObject)errorType;
			errorType = (ThreatState)eResolveProxy(oldErrorType);
			if (errorType != oldErrorType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FMEAPackage.FMEA_ANALYSIS__ERROR_TYPE, oldErrorType, errorType));
			}
		}
		return errorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThreatState basicGetErrorType() {
		return errorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setErrorType(ThreatState newErrorType) {
		ThreatState oldErrorType = errorType;
		errorType = newErrorType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FMEAPackage.FMEA_ANALYSIS__ERROR_TYPE, oldErrorType, errorType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSimulationRuns() {
		return simulationRuns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimulationRuns(int newSimulationRuns) {
		int oldSimulationRuns = simulationRuns;
		simulationRuns = newSimulationRuns;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FMEAPackage.FMEA_ANALYSIS__SIMULATION_RUNS, oldSimulationRuns, simulationRuns));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAnalysisType() {
		return analysisType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnalysisType(String newAnalysisType) {
		String oldAnalysisType = analysisType;
		analysisType = newAnalysisType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FMEAPackage.FMEA_ANALYSIS__ANALYSIS_TYPE, oldAnalysisType, analysisType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FMEAPackage.FMEA_ANALYSIS__ERROR_TYPE:
				if (resolve) return getErrorType();
				return basicGetErrorType();
			case FMEAPackage.FMEA_ANALYSIS__SIMULATION_RUNS:
				return getSimulationRuns();
			case FMEAPackage.FMEA_ANALYSIS__ANALYSIS_TYPE:
				return getAnalysisType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FMEAPackage.FMEA_ANALYSIS__ERROR_TYPE:
				setErrorType((ThreatState)newValue);
				return;
			case FMEAPackage.FMEA_ANALYSIS__SIMULATION_RUNS:
				setSimulationRuns((Integer)newValue);
				return;
			case FMEAPackage.FMEA_ANALYSIS__ANALYSIS_TYPE:
				setAnalysisType((String)newValue);
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
			case FMEAPackage.FMEA_ANALYSIS__ERROR_TYPE:
				setErrorType((ThreatState)null);
				return;
			case FMEAPackage.FMEA_ANALYSIS__SIMULATION_RUNS:
				setSimulationRuns(SIMULATION_RUNS_EDEFAULT);
				return;
			case FMEAPackage.FMEA_ANALYSIS__ANALYSIS_TYPE:
				setAnalysisType(ANALYSIS_TYPE_EDEFAULT);
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
			case FMEAPackage.FMEA_ANALYSIS__ERROR_TYPE:
				return errorType != null;
			case FMEAPackage.FMEA_ANALYSIS__SIMULATION_RUNS:
				return simulationRuns != SIMULATION_RUNS_EDEFAULT;
			case FMEAPackage.FMEA_ANALYSIS__ANALYSIS_TYPE:
				return ANALYSIS_TYPE_EDEFAULT == null ? analysisType != null : !ANALYSIS_TYPE_EDEFAULT.equals(analysisType);
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
		result.append(" (simulationRuns: ");
		result.append(simulationRuns);
		result.append(", analysisType: ");
		result.append(analysisType);
		result.append(')');
		return result.toString();
	}

} //FMEAAnalysisImpl
