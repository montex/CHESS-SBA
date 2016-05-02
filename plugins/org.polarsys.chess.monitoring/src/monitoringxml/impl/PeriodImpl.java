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
import monitoringxml.Period;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Period</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link monitoringxml.impl.PeriodImpl#getMinimum <em>Minimum</em>}</li>
 *   <li>{@link monitoringxml.impl.PeriodImpl#getMaximum <em>Maximum</em>}</li>
 *   <li>{@link monitoringxml.impl.PeriodImpl#getJitter <em>Jitter</em>}</li>
 *   <li>{@link monitoringxml.impl.PeriodImpl#getMonitoredresource <em>Monitoredresource</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PeriodImpl extends MinimalEObjectImpl.Container implements Period {
	/**
	 * The default value of the '{@link #getMinimum() <em>Minimum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimum()
	 * @generated
	 * @ordered
	 */
	protected static final Float MINIMUM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMinimum() <em>Minimum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimum()
	 * @generated
	 * @ordered
	 */
	protected Float minimum = MINIMUM_EDEFAULT;

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
	protected PeriodImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MonitoringPackage.Literals.PERIOD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float getMinimum() {
		return minimum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimum(Float newMinimum) {
		Float oldMinimum = minimum;
		minimum = newMinimum;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MonitoringPackage.PERIOD__MINIMUM, oldMinimum, minimum));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MonitoringPackage.PERIOD__MAXIMUM, oldMaximum, maximum));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MonitoringPackage.PERIOD__JITTER, oldJitter, jitter));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MonitoringPackage.PERIOD__MONITOREDRESOURCE, oldMonitoredresource, monitoredresource));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MonitoringPackage.PERIOD__MONITOREDRESOURCE, oldMonitoredresource, newMonitoredresource);
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
				msgs = ((InternalEObject)monitoredresource).eInverseRemove(this, MonitoringPackage.MONITORED_RESOURCE__PERIOD, MonitoredResource.class, msgs);
			if (newMonitoredresource != null)
				msgs = ((InternalEObject)newMonitoredresource).eInverseAdd(this, MonitoringPackage.MONITORED_RESOURCE__PERIOD, MonitoredResource.class, msgs);
			msgs = basicSetMonitoredresource(newMonitoredresource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MonitoringPackage.PERIOD__MONITOREDRESOURCE, newMonitoredresource, newMonitoredresource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MonitoringPackage.PERIOD__MONITOREDRESOURCE:
				if (monitoredresource != null)
					msgs = ((InternalEObject)monitoredresource).eInverseRemove(this, MonitoringPackage.MONITORED_RESOURCE__PERIOD, MonitoredResource.class, msgs);
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
			case MonitoringPackage.PERIOD__MONITOREDRESOURCE:
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
			case MonitoringPackage.PERIOD__MINIMUM:
				return getMinimum();
			case MonitoringPackage.PERIOD__MAXIMUM:
				return getMaximum();
			case MonitoringPackage.PERIOD__JITTER:
				return getJitter();
			case MonitoringPackage.PERIOD__MONITOREDRESOURCE:
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
			case MonitoringPackage.PERIOD__MINIMUM:
				setMinimum((Float)newValue);
				return;
			case MonitoringPackage.PERIOD__MAXIMUM:
				setMaximum((Float)newValue);
				return;
			case MonitoringPackage.PERIOD__JITTER:
				setJitter((Float)newValue);
				return;
			case MonitoringPackage.PERIOD__MONITOREDRESOURCE:
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
			case MonitoringPackage.PERIOD__MINIMUM:
				setMinimum(MINIMUM_EDEFAULT);
				return;
			case MonitoringPackage.PERIOD__MAXIMUM:
				setMaximum(MAXIMUM_EDEFAULT);
				return;
			case MonitoringPackage.PERIOD__JITTER:
				setJitter(JITTER_EDEFAULT);
				return;
			case MonitoringPackage.PERIOD__MONITOREDRESOURCE:
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
			case MonitoringPackage.PERIOD__MINIMUM:
				return MINIMUM_EDEFAULT == null ? minimum != null : !MINIMUM_EDEFAULT.equals(minimum);
			case MonitoringPackage.PERIOD__MAXIMUM:
				return MAXIMUM_EDEFAULT == null ? maximum != null : !MAXIMUM_EDEFAULT.equals(maximum);
			case MonitoringPackage.PERIOD__JITTER:
				return JITTER_EDEFAULT == null ? jitter != null : !JITTER_EDEFAULT.equals(jitter);
			case MonitoringPackage.PERIOD__MONITOREDRESOURCE:
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
		result.append(" (minimum: ");
		result.append(minimum);
		result.append(", maximum: ");
		result.append(maximum);
		result.append(", jitter: ");
		result.append(jitter);
		result.append(')');
		return result.toString();
	}

} //PeriodImpl
