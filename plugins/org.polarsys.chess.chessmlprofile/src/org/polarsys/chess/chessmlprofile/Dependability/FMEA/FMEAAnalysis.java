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
package org.polarsys.chess.chessmlprofile.Dependability.FMEA;

import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaAnalysisContext;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatState;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Analysis</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.FMEA.FMEAAnalysis#getErrorType <em>Error Type</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.FMEA.FMEAAnalysis#getSimulationRuns <em>Simulation Runs</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.FMEA.FMEAAnalysis#getAnalysisType <em>Analysis Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.chess.chessmlprofile.Dependability.FMEA.FMEAPackage#getFMEAAnalysis()
 * @model
 * @generated
 */
public interface FMEAAnalysis extends GaAnalysisContext {
	/**
	 * Returns the value of the '<em><b>Error Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Error Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Error Type</em>' reference.
	 * @see #setErrorType(ThreatState)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FMEA.FMEAPackage#getFMEAAnalysis_ErrorType()
	 * @model ordered="false"
	 * @generated
	 */
	ThreatState getErrorType();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.FMEA.FMEAAnalysis#getErrorType <em>Error Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Error Type</em>' reference.
	 * @see #getErrorType()
	 * @generated
	 */
	void setErrorType(ThreatState value);

	/**
	 * Returns the value of the '<em><b>Simulation Runs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simulation Runs</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simulation Runs</em>' attribute.
	 * @see #setSimulationRuns(int)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FMEA.FMEAPackage#getFMEAAnalysis_SimulationRuns()
	 * @model dataType="org.eclipse.uml2.types.Integer" required="true" ordered="false"
	 * @generated
	 */
	int getSimulationRuns();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.FMEA.FMEAAnalysis#getSimulationRuns <em>Simulation Runs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simulation Runs</em>' attribute.
	 * @see #getSimulationRuns()
	 * @generated
	 */
	void setSimulationRuns(int value);

	/**
	 * Returns the value of the '<em><b>Analysis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Analysis Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Analysis Type</em>' attribute.
	 * @see #setAnalysisType(String)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FMEA.FMEAPackage#getFMEAAnalysis_AnalysisType()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getAnalysisType();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.FMEA.FMEAAnalysis#getAnalysisType <em>Analysis Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Analysis Type</em>' attribute.
	 * @see #getAnalysisType()
	 * @generated
	 */
	void setAnalysisType(String value);

} // FMEAAnalysis
