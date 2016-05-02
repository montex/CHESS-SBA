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
 * A representation of the model object '<em><b>Blocking Time</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link monitoringxml.BlockingTime#getMaximum <em>Maximum</em>}</li>
 *   <li>{@link monitoringxml.BlockingTime#getMonitoredresource <em>Monitoredresource</em>}</li>
 * </ul>
 *
 * @see monitoringxml.MonitoringPackage#getBlockingTime()
 * @model
 * @generated
 */
public interface BlockingTime extends EObject {
	/**
	 * Returns the value of the '<em><b>Maximum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maximum</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maximum</em>' attribute.
	 * @see #setMaximum(Float)
	 * @see monitoringxml.MonitoringPackage#getBlockingTime_Maximum()
	 * @model
	 * @generated
	 */
	Float getMaximum();

	/**
	 * Sets the value of the '{@link monitoringxml.BlockingTime#getMaximum <em>Maximum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum</em>' attribute.
	 * @see #getMaximum()
	 * @generated
	 */
	void setMaximum(Float value);

	/**
	 * Returns the value of the '<em><b>Monitoredresource</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link monitoringxml.MonitoredResource#getBlockingtime <em>Blockingtime</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Monitoredresource</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Monitoredresource</em>' reference.
	 * @see #setMonitoredresource(MonitoredResource)
	 * @see monitoringxml.MonitoringPackage#getBlockingTime_Monitoredresource()
	 * @see monitoringxml.MonitoredResource#getBlockingtime
	 * @model opposite="blockingtime"
	 * @generated
	 */
	MonitoredResource getMonitoredresource();

	/**
	 * Sets the value of the '{@link monitoringxml.BlockingTime#getMonitoredresource <em>Monitoredresource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Monitoredresource</em>' reference.
	 * @see #getMonitoredresource()
	 * @generated
	 */
	void setMonitoredresource(MonitoredResource value);

} // BlockingTime
