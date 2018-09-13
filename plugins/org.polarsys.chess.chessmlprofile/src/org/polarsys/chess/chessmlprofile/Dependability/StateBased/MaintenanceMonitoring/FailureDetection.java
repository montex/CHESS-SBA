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

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Activity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Failure Detection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.FailureDetection#getOnDetection <em>On Detection</em>}</li>
 * </ul>
 *
 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MaintenanceMonitoringPackage#getFailureDetection()
 * @model
 * @generated
 */
public interface FailureDetection extends MMActivities {
	/**
	 * Returns the value of the '<em><b>On Detection</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.Activity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On Detection</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Detection</em>' reference list.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MaintenanceMonitoringPackage#getFailureDetection_OnDetection()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<Activity> getOnDetection();

	/**
	 * Retrieves the first {@link org.eclipse.uml2.uml.Activity} with the specified '<em><b>Name</b></em>' from the '<em><b>On Detection</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.Activity} to retrieve, or <code>null</code>.
	 * @return The first {@link org.eclipse.uml2.uml.Activity} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getOnDetection()
	 * @generated
	 */
	Activity getOnDetection(String name);

	/**
	 * Retrieves the first {@link org.eclipse.uml2.uml.Activity} with the specified '<em><b>Name</b></em>' from the '<em><b>On Detection</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.Activity} to retrieve, or <code>null</code>.
	 * @param ignoreCase Whether to ignore case in {@link java.lang.String} comparisons.
	 * @return The first {@link org.eclipse.uml2.uml.Activity} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getOnDetection()
	 * @generated
	 */
	Activity getOnDetection(String name, boolean ignoreCase);

} // FailureDetection
