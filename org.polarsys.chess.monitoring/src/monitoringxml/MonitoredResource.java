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
package monitoringxml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Monitored Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link monitoringxml.MonitoredResource#getName <em>Name</em>}</li>
 *   <li>{@link monitoringxml.MonitoredResource#getPeriod <em>Period</em>}</li>
 *   <li>{@link monitoringxml.MonitoredResource#getExecutiontime <em>Executiontime</em>}</li>
 *   <li>{@link monitoringxml.MonitoredResource#getBlockingtime <em>Blockingtime</em>}</li>
 *   <li>{@link monitoringxml.MonitoredResource#getResponsetime <em>Responsetime</em>}</li>
 * </ul>
 *
 * @see monitoringxml.MonitoringPackage#getMonitoredResource()
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
	 * @see monitoringxml.MonitoringPackage#getMonitoredResource_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link monitoringxml.MonitoredResource#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Period</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link monitoringxml.Period#getMonitoredresource <em>Monitoredresource</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Period</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Period</em>' reference.
	 * @see #setPeriod(Period)
	 * @see monitoringxml.MonitoringPackage#getMonitoredResource_Period()
	 * @see monitoringxml.Period#getMonitoredresource
	 * @model opposite="monitoredresource"
	 * @generated
	 */
	Period getPeriod();

	/**
	 * Sets the value of the '{@link monitoringxml.MonitoredResource#getPeriod <em>Period</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Period</em>' reference.
	 * @see #getPeriod()
	 * @generated
	 */
	void setPeriod(Period value);

	/**
	 * Returns the value of the '<em><b>Executiontime</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link monitoringxml.ExecutionTime#getMonitoredresource <em>Monitoredresource</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Executiontime</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Executiontime</em>' reference.
	 * @see #setExecutiontime(ExecutionTime)
	 * @see monitoringxml.MonitoringPackage#getMonitoredResource_Executiontime()
	 * @see monitoringxml.ExecutionTime#getMonitoredresource
	 * @model opposite="monitoredresource"
	 * @generated
	 */
	ExecutionTime getExecutiontime();

	/**
	 * Sets the value of the '{@link monitoringxml.MonitoredResource#getExecutiontime <em>Executiontime</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Executiontime</em>' reference.
	 * @see #getExecutiontime()
	 * @generated
	 */
	void setExecutiontime(ExecutionTime value);

	/**
	 * Returns the value of the '<em><b>Blockingtime</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link monitoringxml.BlockingTime#getMonitoredresource <em>Monitoredresource</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Blockingtime</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Blockingtime</em>' reference.
	 * @see #setBlockingtime(BlockingTime)
	 * @see monitoringxml.MonitoringPackage#getMonitoredResource_Blockingtime()
	 * @see monitoringxml.BlockingTime#getMonitoredresource
	 * @model opposite="monitoredresource"
	 * @generated
	 */
	BlockingTime getBlockingtime();

	/**
	 * Sets the value of the '{@link monitoringxml.MonitoredResource#getBlockingtime <em>Blockingtime</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Blockingtime</em>' reference.
	 * @see #getBlockingtime()
	 * @generated
	 */
	void setBlockingtime(BlockingTime value);

	/**
	 * Returns the value of the '<em><b>Responsetime</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link monitoringxml.ResponseTime#getMonitoredresource <em>Monitoredresource</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Responsetime</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Responsetime</em>' reference.
	 * @see #setResponsetime(ResponseTime)
	 * @see monitoringxml.MonitoringPackage#getMonitoredResource_Responsetime()
	 * @see monitoringxml.ResponseTime#getMonitoredresource
	 * @model opposite="monitoredresource"
	 * @generated
	 */
	ResponseTime getResponsetime();

	/**
	 * Sets the value of the '{@link monitoringxml.MonitoredResource#getResponsetime <em>Responsetime</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Responsetime</em>' reference.
	 * @see #getResponsetime()
	 * @generated
	 */
	void setResponsetime(ResponseTime value);

} // MonitoredResource
