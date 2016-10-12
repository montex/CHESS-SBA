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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Response Time</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.chess.monitoring.monitoringxml.ResponseTime#getMonitoredresource <em>Monitoredresource</em>}</li>
 *   <li>{@link org.polarsys.chess.monitoring.monitoringxml.ResponseTime#getMinimum <em>Minimum</em>}</li>
 *   <li>{@link org.polarsys.chess.monitoring.monitoringxml.ResponseTime#getMaximum <em>Maximum</em>}</li>
 *   <li>{@link org.polarsys.chess.monitoring.monitoringxml.ResponseTime#getAverage <em>Average</em>}</li>
 *   <li>{@link org.polarsys.chess.monitoring.monitoringxml.ResponseTime#getJitter <em>Jitter</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.chess.monitoring.monitoringxml.MonitoringxmlPackage#getResponseTime()
 * @model
 * @generated
 */
public interface ResponseTime extends EObject {
	/**
	 * Returns the value of the '<em><b>Monitoredresource</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.polarsys.chess.monitoring.monitoringxml.MonitoredResource#getResponsetime <em>Responsetime</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Monitoredresource</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Monitoredresource</em>' container reference.
	 * @see #setMonitoredresource(MonitoredResource)
	 * @see org.polarsys.chess.monitoring.monitoringxml.MonitoringxmlPackage#getResponseTime_Monitoredresource()
	 * @see org.polarsys.chess.monitoring.monitoringxml.MonitoredResource#getResponsetime
	 * @model opposite="responsetime" transient="false"
	 * @generated
	 */
	MonitoredResource getMonitoredresource();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.monitoring.monitoringxml.ResponseTime#getMonitoredresource <em>Monitoredresource</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Monitoredresource</em>' container reference.
	 * @see #getMonitoredresource()
	 * @generated
	 */
	void setMonitoredresource(MonitoredResource value);

	/**
	 * Returns the value of the '<em><b>Minimum</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Minimum</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minimum</em>' containment reference.
	 * @see #setMinimum(MeasuredValue)
	 * @see org.polarsys.chess.monitoring.monitoringxml.MonitoringxmlPackage#getResponseTime_Minimum()
	 * @model containment="true"
	 * @generated
	 */
	MeasuredValue getMinimum();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.monitoring.monitoringxml.ResponseTime#getMinimum <em>Minimum</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimum</em>' containment reference.
	 * @see #getMinimum()
	 * @generated
	 */
	void setMinimum(MeasuredValue value);

	/**
	 * Returns the value of the '<em><b>Maximum</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maximum</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maximum</em>' containment reference.
	 * @see #setMaximum(MeasuredValue)
	 * @see org.polarsys.chess.monitoring.monitoringxml.MonitoringxmlPackage#getResponseTime_Maximum()
	 * @model containment="true"
	 * @generated
	 */
	MeasuredValue getMaximum();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.monitoring.monitoringxml.ResponseTime#getMaximum <em>Maximum</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum</em>' containment reference.
	 * @see #getMaximum()
	 * @generated
	 */
	void setMaximum(MeasuredValue value);

	/**
	 * Returns the value of the '<em><b>Average</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Average</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Average</em>' containment reference.
	 * @see #setAverage(MeasuredValue)
	 * @see org.polarsys.chess.monitoring.monitoringxml.MonitoringxmlPackage#getResponseTime_Average()
	 * @model containment="true"
	 * @generated
	 */
	MeasuredValue getAverage();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.monitoring.monitoringxml.ResponseTime#getAverage <em>Average</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Average</em>' containment reference.
	 * @see #getAverage()
	 * @generated
	 */
	void setAverage(MeasuredValue value);

	/**
	 * Returns the value of the '<em><b>Jitter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Jitter</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jitter</em>' containment reference.
	 * @see #setJitter(MeasuredValue)
	 * @see org.polarsys.chess.monitoring.monitoringxml.MonitoringxmlPackage#getResponseTime_Jitter()
	 * @model containment="true"
	 * @generated
	 */
	MeasuredValue getJitter();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.monitoring.monitoringxml.ResponseTime#getJitter <em>Jitter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jitter</em>' containment reference.
	 * @see #getJitter()
	 * @generated
	 */
	void setJitter(MeasuredValue value);

} // ResponseTime
