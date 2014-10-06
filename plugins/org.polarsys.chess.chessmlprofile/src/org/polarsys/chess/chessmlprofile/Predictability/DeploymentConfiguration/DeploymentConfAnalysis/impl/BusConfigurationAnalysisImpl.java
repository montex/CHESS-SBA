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
package org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaAnalysisContextImpl;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaStep;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwBus;
import org.polarsys.chess.chessmlprofile.Dependability.FMEA.FIBEX;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.BusConfigurationAnalysis;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.DeploymentConfAnalysisPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bus Configuration Analysis</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.impl.BusConfigurationAnalysisImpl#getResultingBusConfig <em>Resulting Bus Config</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.impl.BusConfigurationAnalysisImpl#getResultingCommLatencies <em>Resulting Comm Latencies</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.impl.BusConfigurationAnalysisImpl#getInputFibex <em>Input Fibex</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.impl.BusConfigurationAnalysisImpl#getHwBusPlatform <em>Hw Bus Platform</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BusConfigurationAnalysisImpl extends GaAnalysisContextImpl implements BusConfigurationAnalysis {
	/**
	 * The cached value of the '{@link #getResultingBusConfig() <em>Resulting Bus Config</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultingBusConfig()
	 * @generated
	 * @ordered
	 */
	protected FIBEX resultingBusConfig;

	/**
	 * The cached value of the '{@link #getResultingCommLatencies() <em>Resulting Comm Latencies</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultingCommLatencies()
	 * @generated
	 * @ordered
	 */
	protected EList<SaStep> resultingCommLatencies;

	/**
	 * The cached value of the '{@link #getInputFibex() <em>Input Fibex</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputFibex()
	 * @generated
	 * @ordered
	 */
	protected EList<FIBEX> inputFibex;

	/**
	 * The cached value of the '{@link #getHwBusPlatform() <em>Hw Bus Platform</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHwBusPlatform()
	 * @generated
	 * @ordered
	 */
	protected EList<HwBus> hwBusPlatform;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BusConfigurationAnalysisImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DeploymentConfAnalysisPackage.Literals.BUS_CONFIGURATION_ANALYSIS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FIBEX getResultingBusConfig() {
		if (resultingBusConfig != null && resultingBusConfig.eIsProxy()) {
			InternalEObject oldResultingBusConfig = (InternalEObject)resultingBusConfig;
			resultingBusConfig = (FIBEX)eResolveProxy(oldResultingBusConfig);
			if (resultingBusConfig != oldResultingBusConfig) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DeploymentConfAnalysisPackage.BUS_CONFIGURATION_ANALYSIS__RESULTING_BUS_CONFIG, oldResultingBusConfig, resultingBusConfig));
			}
		}
		return resultingBusConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FIBEX basicGetResultingBusConfig() {
		return resultingBusConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResultingBusConfig(FIBEX newResultingBusConfig) {
		FIBEX oldResultingBusConfig = resultingBusConfig;
		resultingBusConfig = newResultingBusConfig;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeploymentConfAnalysisPackage.BUS_CONFIGURATION_ANALYSIS__RESULTING_BUS_CONFIG, oldResultingBusConfig, resultingBusConfig));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SaStep> getResultingCommLatencies() {
		if (resultingCommLatencies == null) {
			resultingCommLatencies = new EObjectResolvingEList<SaStep>(SaStep.class, this, DeploymentConfAnalysisPackage.BUS_CONFIGURATION_ANALYSIS__RESULTING_COMM_LATENCIES);
		}
		return resultingCommLatencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FIBEX> getInputFibex() {
		if (inputFibex == null) {
			inputFibex = new EObjectResolvingEList<FIBEX>(FIBEX.class, this, DeploymentConfAnalysisPackage.BUS_CONFIGURATION_ANALYSIS__INPUT_FIBEX);
		}
		return inputFibex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HwBus> getHwBusPlatform() {
		if (hwBusPlatform == null) {
			hwBusPlatform = new EObjectResolvingEList<HwBus>(HwBus.class, this, DeploymentConfAnalysisPackage.BUS_CONFIGURATION_ANALYSIS__HW_BUS_PLATFORM);
		}
		return hwBusPlatform;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DeploymentConfAnalysisPackage.BUS_CONFIGURATION_ANALYSIS__RESULTING_BUS_CONFIG:
				if (resolve) return getResultingBusConfig();
				return basicGetResultingBusConfig();
			case DeploymentConfAnalysisPackage.BUS_CONFIGURATION_ANALYSIS__RESULTING_COMM_LATENCIES:
				return getResultingCommLatencies();
			case DeploymentConfAnalysisPackage.BUS_CONFIGURATION_ANALYSIS__INPUT_FIBEX:
				return getInputFibex();
			case DeploymentConfAnalysisPackage.BUS_CONFIGURATION_ANALYSIS__HW_BUS_PLATFORM:
				return getHwBusPlatform();
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
			case DeploymentConfAnalysisPackage.BUS_CONFIGURATION_ANALYSIS__RESULTING_BUS_CONFIG:
				setResultingBusConfig((FIBEX)newValue);
				return;
			case DeploymentConfAnalysisPackage.BUS_CONFIGURATION_ANALYSIS__RESULTING_COMM_LATENCIES:
				getResultingCommLatencies().clear();
				getResultingCommLatencies().addAll((Collection<? extends SaStep>)newValue);
				return;
			case DeploymentConfAnalysisPackage.BUS_CONFIGURATION_ANALYSIS__INPUT_FIBEX:
				getInputFibex().clear();
				getInputFibex().addAll((Collection<? extends FIBEX>)newValue);
				return;
			case DeploymentConfAnalysisPackage.BUS_CONFIGURATION_ANALYSIS__HW_BUS_PLATFORM:
				getHwBusPlatform().clear();
				getHwBusPlatform().addAll((Collection<? extends HwBus>)newValue);
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
			case DeploymentConfAnalysisPackage.BUS_CONFIGURATION_ANALYSIS__RESULTING_BUS_CONFIG:
				setResultingBusConfig((FIBEX)null);
				return;
			case DeploymentConfAnalysisPackage.BUS_CONFIGURATION_ANALYSIS__RESULTING_COMM_LATENCIES:
				getResultingCommLatencies().clear();
				return;
			case DeploymentConfAnalysisPackage.BUS_CONFIGURATION_ANALYSIS__INPUT_FIBEX:
				getInputFibex().clear();
				return;
			case DeploymentConfAnalysisPackage.BUS_CONFIGURATION_ANALYSIS__HW_BUS_PLATFORM:
				getHwBusPlatform().clear();
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
			case DeploymentConfAnalysisPackage.BUS_CONFIGURATION_ANALYSIS__RESULTING_BUS_CONFIG:
				return resultingBusConfig != null;
			case DeploymentConfAnalysisPackage.BUS_CONFIGURATION_ANALYSIS__RESULTING_COMM_LATENCIES:
				return resultingCommLatencies != null && !resultingCommLatencies.isEmpty();
			case DeploymentConfAnalysisPackage.BUS_CONFIGURATION_ANALYSIS__INPUT_FIBEX:
				return inputFibex != null && !inputFibex.isEmpty();
			case DeploymentConfAnalysisPackage.BUS_CONFIGURATION_ANALYSIS__HW_BUS_PLATFORM:
				return hwBusPlatform != null && !hwBusPlatform.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //BusConfigurationAnalysisImpl
