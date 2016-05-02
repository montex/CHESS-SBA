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
package monitoringxml.impl;

import monitoringxml.MonitoredResource;
import monitoringxml.MonitoringPackage;
import monitoringxml.ResponseTime;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Response Time</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link monitoringxml.impl.ResponseTimeImpl#getMaximum <em>Maximum</em>}</li>
 *   <li>{@link monitoringxml.impl.ResponseTimeImpl#getJitter <em>Jitter</em>}</li>
 *   <li>{@link monitoringxml.impl.ResponseTimeImpl#getMonitoredresource <em>Monitoredresource</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResponseTimeImpl extends MinimalEObjectImpl.Container implements ResponseTime {
	/**
	 * The default value of the '{@link #getMaximum() <em>Maximum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximum()
	 * @generated
	 * @ordered
	 */
	protected static final Float MAXIMUM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaximum() <em>Maximum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximum()
	 * @generated
	 * @ordered
	 */
	protected Float maximum = MAXIMUM_EDEFAULT;

	/**
	 * The default value of the '{@link #getJitter() <em>Jitter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJitter()
	 * @generated
	 * @ordered
	 */
	protected static final Float JITTER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getJitter() <em>Jitter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJitter()
	 * @generated
	 * @ordered
	 */
	protected Float jitter = JITTER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMonitoredresource() <em>Monitoredresource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMonitoredresource()
	 * @generated
	 * @ordered
	 */
	protected MonitoredResource monitoredresource;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResponseTimeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MonitoringPackage.Literals.RESPONSE_TIME;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float getMaximum() {
		return maximum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximum(Float newMaximum) {
		Float oldMaximum = maximum;
		maximum = newMaximum;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MonitoringPackage.RESPONSE_TIME__MAXIMUM, oldMaximum, maximum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float getJitter() {
		return jitter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJitter(Float newJitter) {
		Float oldJitter = jitter;
		jitter = newJitter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MonitoringPackage.RESPONSE_TIME__JITTER, oldJitter, jitter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MonitoredResource getMonitoredresource() {
		if (monitoredresource != null && monitoredresource.eIsProxy()) {
			InternalEObject oldMonitoredresource = (InternalEObject)monitoredresource;
			monitoredresource = (MonitoredResource)eResolveProxy(oldMonitoredresource);
			if (monitoredresource != oldMonitoredresource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MonitoringPackage.RESPONSE_TIME__MONITOREDRESOURCE, oldMonitoredresource, monitoredresource));
			}
		}
		return monitoredresource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MonitoredResource basicGetMonitoredresource() {
		return monitoredresource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMonitoredresource(MonitoredResource newMonitoredresource, NotificationChain msgs) {
		MonitoredResource oldMonitoredresource = monitoredresource;
		monitoredresource = newMonitoredresource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MonitoringPackage.RESPONSE_TIME__MONITOREDRESOURCE, oldMonitoredresource, newMonitoredresource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMonitoredresource(MonitoredResource newMonitoredresource) {
		if (newMonitoredresource != monitoredresource) {
			NotificationChain msgs = null;
			if (monitoredresource != null)
				msgs = ((InternalEObject)monitoredresource).eInverseRemove(this, MonitoringPackage.MONITORED_RESOURCE__RESPONSETIME, MonitoredResource.class, msgs);
			if (newMonitoredresource != null)
				msgs = ((InternalEObject)newMonitoredresource).eInverseAdd(this, MonitoringPackage.MONITORED_RESOURCE__RESPONSETIME, MonitoredResource.class, msgs);
			msgs = basicSetMonitoredresource(newMonitoredresource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MonitoringPackage.RESPONSE_TIME__MONITOREDRESOURCE, newMonitoredresource, newMonitoredresource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MonitoringPackage.RESPONSE_TIME__MONITOREDRESOURCE:
				if (monitoredresource != null)
					msgs = ((InternalEObject)monitoredresource).eInverseRemove(this, MonitoringPackage.MONITORED_RESOURCE__RESPONSETIME, MonitoredResource.class, msgs);
				return basicSetMonitoredresource((MonitoredResource)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MonitoringPackage.RESPONSE_TIME__MONITOREDRESOURCE:
				return basicSetMonitoredresource(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MonitoringPackage.RESPONSE_TIME__MAXIMUM:
				return getMaximum();
			case MonitoringPackage.RESPONSE_TIME__JITTER:
				return getJitter();
			case MonitoringPackage.RESPONSE_TIME__MONITOREDRESOURCE:
				if (resolve) return getMonitoredresource();
				return basicGetMonitoredresource();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MonitoringPackage.RESPONSE_TIME__MAXIMUM:
				setMaximum((Float)newValue);
				return;
			case MonitoringPackage.RESPONSE_TIME__JITTER:
				setJitter((Float)newValue);
				return;
			case MonitoringPackage.RESPONSE_TIME__MONITOREDRESOURCE:
				setMonitoredresource((MonitoredResource)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MonitoringPackage.RESPONSE_TIME__MAXIMUM:
				setMaximum(MAXIMUM_EDEFAULT);
				return;
			case MonitoringPackage.RESPONSE_TIME__JITTER:
				setJitter(JITTER_EDEFAULT);
				return;
			case MonitoringPackage.RESPONSE_TIME__MONITOREDRESOURCE:
				setMonitoredresource((MonitoredResource)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MonitoringPackage.RESPONSE_TIME__MAXIMUM:
				return MAXIMUM_EDEFAULT == null ? maximum != null : !MAXIMUM_EDEFAULT.equals(maximum);
			case MonitoringPackage.RESPONSE_TIME__JITTER:
				return JITTER_EDEFAULT == null ? jitter != null : !JITTER_EDEFAULT.equals(jitter);
			case MonitoringPackage.RESPONSE_TIME__MONITOREDRESOURCE:
				return monitoredresource != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (maximum: ");
		result.append(maximum);
		result.append(", jitter: ");
		result.append(jitter);
		result.append(')');
		return result.toString();
	}

} //ResponseTimeImpl
