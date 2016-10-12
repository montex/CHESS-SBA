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
 * A representation of the model object '<em><b>Blocking Time</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.chess.monitoring.monitoringxml.BlockingTime#getMonitoredresource <em>Monitoredresource</em>}</li>
 *   <li>{@link org.polarsys.chess.monitoring.monitoringxml.BlockingTime#getMinimum <em>Minimum</em>}</li>
 *   <li>{@link org.polarsys.chess.monitoring.monitoringxml.BlockingTime#getMaximum <em>Maximum</em>}</li>
 *   <li>{@link org.polarsys.chess.monitoring.monitoringxml.BlockingTime#getAverage <em>Average</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.chess.monitoring.monitoringxml.MonitoringxmlPackage#getBlockingTime()
 * @model
 * @generated
 */
public interface BlockingTime extends EObject {
	/**
	 * Returns the value of the '<em><b>Monitoredresource</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.polarsys.chess.monitoring.monitoringxml.MonitoredResource#getBlockingtime <em>Blockingtime</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Monitoredresource</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Monitoredresource</em>' container reference.
	 * @see #setMonitoredresource(MonitoredResource)
	 * @see org.polarsys.chess.monitoring.monitoringxml.MonitoringxmlPackage#getBlockingTime_Monitoredresource()
	 * @see org.polarsys.chess.monitoring.monitoringxml.MonitoredResource#getBlockingtime
	 * @model opposite="blockingtime" transient="false"
	 * @generated
	 */
	MonitoredResource getMonitoredresource();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.monitoring.monitoringxml.BlockingTime#getMonitoredresource <em>Monitoredresource</em>}' container reference.
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
	 * @see org.polarsys.chess.monitoring.monitoringxml.MonitoringxmlPackage#getBlockingTime_Minimum()
	 * @model containment="true"
	 * @generated
	 */
	MeasuredValue getMinimum();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.monitoring.monitoringxml.BlockingTime#getMinimum <em>Minimum</em>}' containment reference.
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
	 * @see org.polarsys.chess.monitoring.monitoringxml.MonitoringxmlPackage#getBlockingTime_Maximum()
	 * @model containment="true"
	 * @generated
	 */
	MeasuredValue getMaximum();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.monitoring.monitoringxml.BlockingTime#getMaximum <em>Maximum</em>}' containment reference.
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
	 * @see org.polarsys.chess.monitoring.monitoringxml.MonitoringxmlPackage#getBlockingTime_Average()
	 * @model containment="true"
	 * @generated
	 */
	MeasuredValue getAverage();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.monitoring.monitoringxml.BlockingTime#getAverage <em>Average</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Average</em>' containment reference.
	 * @see #getAverage()
	 * @generated
	 */
	void setAverage(MeasuredValue value);

} // BlockingTime
