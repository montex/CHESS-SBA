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
package org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring;

import org.eclipse.uml2.uml.Property;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.FailureMode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Error Detection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.ErrorDetection#getTargets <em>Targets</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.ErrorDetection#getCorrectionProbability <em>Correction Probability</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MaintenanceMonitoringPackage#getErrorDetection()
 * @model
 * @generated
 */
public interface ErrorDetection extends MMActivities {
	/**
	 * Returns the value of the '<em><b>Targets</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Targets</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Targets</em>' reference.
	 * @see #setTargets(Property)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MaintenanceMonitoringPackage#getErrorDetection_Targets()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Property getTargets();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.ErrorDetection#getTargets <em>Targets</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Targets</em>' reference.
	 * @see #getTargets()
	 * @generated
	 */
	void setTargets(Property value);

	/**
	 * Returns the value of the '<em><b>Correction Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Correction Probability</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Correction Probability</em>' attribute.
	 * @see #setCorrectionProbability(String)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MaintenanceMonitoringPackage#getErrorDetection_CorrectionProbability()
	 * @model dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Real" required="true" ordered="false"
	 * @generated
	 */
	String getCorrectionProbability();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.ErrorDetection#getCorrectionProbability <em>Correction Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Correction Probability</em>' attribute.
	 * @see #getCorrectionProbability()
	 * @generated
	 */
	void setCorrectionProbability(String value);

} // ErrorDetection
