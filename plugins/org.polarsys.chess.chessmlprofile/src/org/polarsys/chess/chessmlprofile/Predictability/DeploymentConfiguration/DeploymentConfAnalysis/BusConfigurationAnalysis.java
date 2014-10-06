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
package org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaAnalysisContext;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaStep;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwBus;
import org.polarsys.chess.chessmlprofile.Dependability.FMEA.FIBEX;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bus Configuration Analysis</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.BusConfigurationAnalysis#getResultingBusConfig <em>Resulting Bus Config</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.BusConfigurationAnalysis#getResultingCommLatencies <em>Resulting Comm Latencies</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.BusConfigurationAnalysis#getInputFibex <em>Input Fibex</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.BusConfigurationAnalysis#getHwBusPlatform <em>Hw Bus Platform</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.DeploymentConfAnalysisPackage#getBusConfigurationAnalysis()
 * @model
 * @generated
 */
public interface BusConfigurationAnalysis extends GaAnalysisContext {
	/**
	 * Returns the value of the '<em><b>Resulting Bus Config</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resulting Bus Config</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resulting Bus Config</em>' reference.
	 * @see #setResultingBusConfig(FIBEX)
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.DeploymentConfAnalysisPackage#getBusConfigurationAnalysis_ResultingBusConfig()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	FIBEX getResultingBusConfig();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.BusConfigurationAnalysis#getResultingBusConfig <em>Resulting Bus Config</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resulting Bus Config</em>' reference.
	 * @see #getResultingBusConfig()
	 * @generated
	 */
	void setResultingBusConfig(FIBEX value);

	/**
	 * Returns the value of the '<em><b>Resulting Comm Latencies</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaStep}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resulting Comm Latencies</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resulting Comm Latencies</em>' reference list.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.DeploymentConfAnalysisPackage#getBusConfigurationAnalysis_ResultingCommLatencies()
	 * @model ordered="false"
	 * @generated
	 */
	EList<SaStep> getResultingCommLatencies();

	/**
	 * Returns the value of the '<em><b>Input Fibex</b></em>' reference list.
	 * The list contents are of type {@link org.polarsys.chess.chessmlprofile.Dependability.FMEA.FIBEX}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Fibex</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Fibex</em>' reference list.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.DeploymentConfAnalysisPackage#getBusConfigurationAnalysis_InputFibex()
	 * @model ordered="false"
	 * @generated
	 */
	EList<FIBEX> getInputFibex();

	/**
	 * Returns the value of the '<em><b>Hw Bus Platform</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwBus}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hw Bus Platform</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hw Bus Platform</em>' reference list.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.DeploymentConfAnalysisPackage#getBusConfigurationAnalysis_HwBusPlatform()
	 * @model ordered="false"
	 * @generated
	 */
	EList<HwBus> getHwBusPlatform();

} // BusConfigurationAnalysis
