/*
-----------------------------------------------------------------------
--                    CHESS monitoring plugin                        --
--                                                                   --
--                    Copyright (C) 2015-2016                        --
--                 University of Padova, ITALY                       --
--                                                                   --
-- Author: Alessandro Zovi azovi@math.unipd.it                       --
--                                                                   --
-- All rights reserved. This program and the accompanying materials  --
-- are made available under the terms of the Eclipse Public License  --
-- v1.0 which accompanies this distribution, and is available at     --
-- http://www.eclipse.org/legal/epl-v10.html                         --
-----------------------------------------------------------------------
  */ 
package org.polarsys.chess.monitoring.monitoringxml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Monitoring</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.chess.monitoring.monitoringxml.Monitoring#getThreadNames <em>Thread Names</em>}</li>
 *   <li>{@link org.polarsys.chess.monitoring.monitoringxml.Monitoring#getSharedResources <em>Shared Resources</em>}</li>
 *   <li>{@link org.polarsys.chess.monitoring.monitoringxml.Monitoring#getAnalysisContext <em>Analysis Context</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.chess.monitoring.monitoringxml.MonitoringxmlPackage#getMonitoring()
 * @model
 * @generated
 */
public interface Monitoring extends EObject {
	/**
	 * Returns the value of the '<em><b>Thread Names</b></em>' containment reference list.
	 * The list contents are of type {@link org.polarsys.chess.monitoring.monitoringxml.Thread}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Thread Names</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Thread Names</em>' containment reference list.
	 * @see org.polarsys.chess.monitoring.monitoringxml.MonitoringxmlPackage#getMonitoring_ThreadNames()
	 * @model containment="true"
	 * @generated
	 */
	EList<org.polarsys.chess.monitoring.monitoringxml.Thread> getThreadNames();

	/**
	 * Returns the value of the '<em><b>Shared Resources</b></em>' containment reference list.
	 * The list contents are of type {@link org.polarsys.chess.monitoring.monitoringxml.Resource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shared Resources</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shared Resources</em>' containment reference list.
	 * @see org.polarsys.chess.monitoring.monitoringxml.MonitoringxmlPackage#getMonitoring_SharedResources()
	 * @model containment="true"
	 * @generated
	 */
	EList<Resource> getSharedResources();

	/**
	 * Returns the value of the '<em><b>Analysis Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Analysis Context</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Analysis Context</em>' containment reference.
	 * @see #setAnalysisContext(AnalysisContext)
	 * @see org.polarsys.chess.monitoring.monitoringxml.MonitoringxmlPackage#getMonitoring_AnalysisContext()
	 * @model containment="true" required="true"
	 * @generated
	 */
	AnalysisContext getAnalysisContext();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.monitoring.monitoringxml.Monitoring#getAnalysisContext <em>Analysis Context</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Analysis Context</em>' containment reference.
	 * @see #getAnalysisContext()
	 * @generated
	 */
	void setAnalysisContext(AnalysisContext value);

} // Monitoring
