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
 * A representation of the model object '<em><b>Monitored Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.chess.monitoring.monitoringxml.MonitoredResource#getName <em>Name</em>}</li>
 *   <li>{@link org.polarsys.chess.monitoring.monitoringxml.MonitoredResource#getPeriod <em>Period</em>}</li>
 *   <li>{@link org.polarsys.chess.monitoring.monitoringxml.MonitoredResource#getExecutiontime <em>Executiontime</em>}</li>
 *   <li>{@link org.polarsys.chess.monitoring.monitoringxml.MonitoredResource#getBlockingtime <em>Blockingtime</em>}</li>
 *   <li>{@link org.polarsys.chess.monitoring.monitoringxml.MonitoredResource#getResponsetime <em>Responsetime</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.chess.monitoring.monitoringxml.MonitoringxmlPackage#getMonitoredResource()
 * @model abstract="true"
 * @generated
 */
public interface MonitoredResource extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.polarsys.chess.monitoring.monitoringxml.MonitoringxmlPackage#getMonitoredResource_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.monitoring.monitoringxml.MonitoredResource#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Period</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.polarsys.chess.monitoring.monitoringxml.Period#getMonitoredresource <em>Monitoredresource</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Period</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Period</em>' containment reference.
	 * @see #setPeriod(Period)
	 * @see org.polarsys.chess.monitoring.monitoringxml.MonitoringxmlPackage#getMonitoredResource_Period()
	 * @see org.polarsys.chess.monitoring.monitoringxml.Period#getMonitoredresource
	 * @model opposite="monitoredresource" containment="true"
	 * @generated
	 */
	Period getPeriod();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.monitoring.monitoringxml.MonitoredResource#getPeriod <em>Period</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Period</em>' containment reference.
	 * @see #getPeriod()
	 * @generated
	 */
	void setPeriod(Period value);

	/**
	 * Returns the value of the '<em><b>Executiontime</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.polarsys.chess.monitoring.monitoringxml.ExecutionTime#getMonitoredresource <em>Monitoredresource</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Executiontime</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Executiontime</em>' containment reference.
	 * @see #setExecutiontime(ExecutionTime)
	 * @see org.polarsys.chess.monitoring.monitoringxml.MonitoringxmlPackage#getMonitoredResource_Executiontime()
	 * @see org.polarsys.chess.monitoring.monitoringxml.ExecutionTime#getMonitoredresource
	 * @model opposite="monitoredresource" containment="true"
	 * @generated
	 */
	ExecutionTime getExecutiontime();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.monitoring.monitoringxml.MonitoredResource#getExecutiontime <em>Executiontime</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Executiontime</em>' containment reference.
	 * @see #getExecutiontime()
	 * @generated
	 */
	void setExecutiontime(ExecutionTime value);

	/**
	 * Returns the value of the '<em><b>Blockingtime</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.polarsys.chess.monitoring.monitoringxml.BlockingTime#getMonitoredresource <em>Monitoredresource</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Blockingtime</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Blockingtime</em>' containment reference.
	 * @see #setBlockingtime(BlockingTime)
	 * @see org.polarsys.chess.monitoring.monitoringxml.MonitoringxmlPackage#getMonitoredResource_Blockingtime()
	 * @see org.polarsys.chess.monitoring.monitoringxml.BlockingTime#getMonitoredresource
	 * @model opposite="monitoredresource" containment="true"
	 * @generated
	 */
	BlockingTime getBlockingtime();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.monitoring.monitoringxml.MonitoredResource#getBlockingtime <em>Blockingtime</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Blockingtime</em>' containment reference.
	 * @see #getBlockingtime()
	 * @generated
	 */
	void setBlockingtime(BlockingTime value);

	/**
	 * Returns the value of the '<em><b>Responsetime</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.polarsys.chess.monitoring.monitoringxml.ResponseTime#getMonitoredresource <em>Monitoredresource</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Responsetime</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Responsetime</em>' containment reference.
	 * @see #setResponsetime(ResponseTime)
	 * @see org.polarsys.chess.monitoring.monitoringxml.MonitoringxmlPackage#getMonitoredResource_Responsetime()
	 * @see org.polarsys.chess.monitoring.monitoringxml.ResponseTime#getMonitoredresource
	 * @model opposite="monitoredresource" containment="true"
	 * @generated
	 */
	ResponseTime getResponsetime();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.monitoring.monitoringxml.MonitoredResource#getResponsetime <em>Responsetime</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Responsetime</em>' containment reference.
	 * @see #getResponsetime()
	 * @generated
	 */
	void setResponsetime(ResponseTime value);

} // MonitoredResource
