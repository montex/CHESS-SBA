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
 * A representation of the model object '<em><b>Period</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link monitoringxml.Period#getMinimum <em>Minimum</em>}</li>
 *   <li>{@link monitoringxml.Period#getMaximum <em>Maximum</em>}</li>
 *   <li>{@link monitoringxml.Period#getJitter <em>Jitter</em>}</li>
 *   <li>{@link monitoringxml.Period#getMonitoredresource <em>Monitoredresource</em>}</li>
 * </ul>
 *
 * @see monitoringxml.MonitoringPackage#getPeriod()
 * @model
 * @generated
 */
public interface Period extends EObject {
	/**
	 * Returns the value of the '<em><b>Minimum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Minimum</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minimum</em>' attribute.
	 * @see #setMinimum(Float)
	 * @see monitoringxml.MonitoringPackage#getPeriod_Minimum()
	 * @model
	 * @generated
	 */
	Float getMinimum();

	/**
	 * Sets the value of the '{@link monitoringxml.Period#getMinimum <em>Minimum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimum</em>' attribute.
	 * @see #getMinimum()
	 * @generated
	 */
	void setMinimum(Float value);

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
	 * @see monitoringxml.MonitoringPackage#getPeriod_Maximum()
	 * @model
	 * @generated
	 */
	Float getMaximum();

	/**
	 * Sets the value of the '{@link monitoringxml.Period#getMaximum <em>Maximum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum</em>' attribute.
	 * @see #getMaximum()
	 * @generated
	 */
	void setMaximum(Float value);

	/**
	 * Returns the value of the '<em><b>Jitter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Jitter</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jitter</em>' attribute.
	 * @see #setJitter(Float)
	 * @see monitoringxml.MonitoringPackage#getPeriod_Jitter()
	 * @model
	 * @generated
	 */
	Float getJitter();

	/**
	 * Sets the value of the '{@link monitoringxml.Period#getJitter <em>Jitter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jitter</em>' attribute.
	 * @see #getJitter()
	 * @generated
	 */
	void setJitter(Float value);

	/**
	 * Returns the value of the '<em><b>Monitoredresource</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link monitoringxml.MonitoredResource#getPeriod <em>Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Monitoredresource</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Monitoredresource</em>' reference.
	 * @see #setMonitoredresource(MonitoredResource)
	 * @see monitoringxml.MonitoringPackage#getPeriod_Monitoredresource()
	 * @see monitoringxml.MonitoredResource#getPeriod
	 * @model opposite="period"
	 * @generated
	 */
	MonitoredResource getMonitoredresource();

	/**
	 * Sets the value of the '{@link monitoringxml.Period#getMonitoredresource <em>Monitoredresource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Monitoredresource</em>' reference.
	 * @see #getMonitoredresource()
	 * @generated
	 */
	void setMonitoredresource(MonitoredResource value);

} // Period
