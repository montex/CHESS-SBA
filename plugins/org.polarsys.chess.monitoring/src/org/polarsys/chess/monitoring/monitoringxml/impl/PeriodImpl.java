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
package org.polarsys.chess.monitoring.monitoringxml.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polarsys.chess.monitoring.monitoringxml.MeasuredValue;
import org.polarsys.chess.monitoring.monitoringxml.MonitoredResource;
import org.polarsys.chess.monitoring.monitoringxml.MonitoringxmlPackage;
import org.polarsys.chess.monitoring.monitoringxml.Period;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Period</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.chess.monitoring.monitoringxml.impl.PeriodImpl#getMonitoredresource <em>Monitoredresource</em>}</li>
 *   <li>{@link org.polarsys.chess.monitoring.monitoringxml.impl.PeriodImpl#getMinimum <em>Minimum</em>}</li>
 *   <li>{@link org.polarsys.chess.monitoring.monitoringxml.impl.PeriodImpl#getMaximum <em>Maximum</em>}</li>
 *   <li>{@link org.polarsys.chess.monitoring.monitoringxml.impl.PeriodImpl#getAverage <em>Average</em>}</li>
 *   <li>{@link org.polarsys.chess.monitoring.monitoringxml.impl.PeriodImpl#getJitter <em>Jitter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PeriodImpl extends MinimalEObjectImpl.Container implements Period {
	/**
	 * The cached value of the '{@link #getMinimum() <em>Minimum</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimum()
	 * @generated
	 * @ordered
	 */
	protected MeasuredValue minimum;

	/**
	 * The cached value of the '{@link #getMaximum() <em>Maximum</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximum()
	 * @generated
	 * @ordered
	 */
	protected MeasuredValue maximum;

	/**
	 * The cached value of the '{@link #getAverage() <em>Average</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAverage()
	 * @generated
	 * @ordered
	 */
	protected MeasuredValue average;

	/**
	 * The cached value of the '{@link #getJitter() <em>Jitter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJitter()
	 * @generated
	 * @ordered
	 */
	protected MeasuredValue jitter;

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
		return MonitoringxmlPackage.Literals.PERIOD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MonitoredResource getMonitoredresource() {
		if (eContainerFeatureID() != MonitoringxmlPackage.PERIOD__MONITOREDRESOURCE) return null;
		return (MonitoredResource)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMonitoredresource(MonitoredResource newMonitoredresource, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newMonitoredresource, MonitoringxmlPackage.PERIOD__MONITOREDRESOURCE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMonitoredresource(MonitoredResource newMonitoredresource) {
		if (newMonitoredresource != eInternalContainer() || (eContainerFeatureID() != MonitoringxmlPackage.PERIOD__MONITOREDRESOURCE && newMonitoredresource != null)) {
			if (EcoreUtil.isAncestor(this, newMonitoredresource))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newMonitoredresource != null)
				msgs = ((InternalEObject)newMonitoredresource).eInverseAdd(this, MonitoringxmlPackage.MONITORED_RESOURCE__PERIOD, MonitoredResource.class, msgs);
			msgs = basicSetMonitoredresource(newMonitoredresource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MonitoringxmlPackage.PERIOD__MONITOREDRESOURCE, newMonitoredresource, newMonitoredresource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeasuredValue getMinimum() {
		return minimum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMinimum(MeasuredValue newMinimum, NotificationChain msgs) {
		MeasuredValue oldMinimum = minimum;
		minimum = newMinimum;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MonitoringxmlPackage.PERIOD__MINIMUM, oldMinimum, newMinimum);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimum(MeasuredValue newMinimum) {
		if (newMinimum != minimum) {
			NotificationChain msgs = null;
			if (minimum != null)
				msgs = ((InternalEObject)minimum).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MonitoringxmlPackage.PERIOD__MINIMUM, null, msgs);
			if (newMinimum != null)
				msgs = ((InternalEObject)newMinimum).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MonitoringxmlPackage.PERIOD__MINIMUM, null, msgs);
			msgs = basicSetMinimum(newMinimum, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MonitoringxmlPackage.PERIOD__MINIMUM, newMinimum, newMinimum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeasuredValue getMaximum() {
		return maximum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMaximum(MeasuredValue newMaximum, NotificationChain msgs) {
		MeasuredValue oldMaximum = maximum;
		maximum = newMaximum;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MonitoringxmlPackage.PERIOD__MAXIMUM, oldMaximum, newMaximum);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximum(MeasuredValue newMaximum) {
		if (newMaximum != maximum) {
			NotificationChain msgs = null;
			if (maximum != null)
				msgs = ((InternalEObject)maximum).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MonitoringxmlPackage.PERIOD__MAXIMUM, null, msgs);
			if (newMaximum != null)
				msgs = ((InternalEObject)newMaximum).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MonitoringxmlPackage.PERIOD__MAXIMUM, null, msgs);
			msgs = basicSetMaximum(newMaximum, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MonitoringxmlPackage.PERIOD__MAXIMUM, newMaximum, newMaximum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeasuredValue getAverage() {
		return average;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAverage(MeasuredValue newAverage, NotificationChain msgs) {
		MeasuredValue oldAverage = average;
		average = newAverage;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MonitoringxmlPackage.PERIOD__AVERAGE, oldAverage, newAverage);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAverage(MeasuredValue newAverage) {
		if (newAverage != average) {
			NotificationChain msgs = null;
			if (average != null)
				msgs = ((InternalEObject)average).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MonitoringxmlPackage.PERIOD__AVERAGE, null, msgs);
			if (newAverage != null)
				msgs = ((InternalEObject)newAverage).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MonitoringxmlPackage.PERIOD__AVERAGE, null, msgs);
			msgs = basicSetAverage(newAverage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MonitoringxmlPackage.PERIOD__AVERAGE, newAverage, newAverage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeasuredValue getJitter() {
		return jitter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetJitter(MeasuredValue newJitter, NotificationChain msgs) {
		MeasuredValue oldJitter = jitter;
		jitter = newJitter;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MonitoringxmlPackage.PERIOD__JITTER, oldJitter, newJitter);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJitter(MeasuredValue newJitter) {
		if (newJitter != jitter) {
			NotificationChain msgs = null;
			if (jitter != null)
				msgs = ((InternalEObject)jitter).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MonitoringxmlPackage.PERIOD__JITTER, null, msgs);
			if (newJitter != null)
				msgs = ((InternalEObject)newJitter).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MonitoringxmlPackage.PERIOD__JITTER, null, msgs);
			msgs = basicSetJitter(newJitter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MonitoringxmlPackage.PERIOD__JITTER, newJitter, newJitter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MonitoringxmlPackage.PERIOD__MONITOREDRESOURCE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
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
			case MonitoringxmlPackage.PERIOD__MONITOREDRESOURCE:
				return basicSetMonitoredresource(null, msgs);
			case MonitoringxmlPackage.PERIOD__MINIMUM:
				return basicSetMinimum(null, msgs);
			case MonitoringxmlPackage.PERIOD__MAXIMUM:
				return basicSetMaximum(null, msgs);
			case MonitoringxmlPackage.PERIOD__AVERAGE:
				return basicSetAverage(null, msgs);
			case MonitoringxmlPackage.PERIOD__JITTER:
				return basicSetJitter(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case MonitoringxmlPackage.PERIOD__MONITOREDRESOURCE:
				return eInternalContainer().eInverseRemove(this, MonitoringxmlPackage.MONITORED_RESOURCE__PERIOD, MonitoredResource.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MonitoringxmlPackage.PERIOD__MONITOREDRESOURCE:
				return getMonitoredresource();
			case MonitoringxmlPackage.PERIOD__MINIMUM:
				return getMinimum();
			case MonitoringxmlPackage.PERIOD__MAXIMUM:
				return getMaximum();
			case MonitoringxmlPackage.PERIOD__AVERAGE:
				return getAverage();
			case MonitoringxmlPackage.PERIOD__JITTER:
				return getJitter();
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
			case MonitoringxmlPackage.PERIOD__MONITOREDRESOURCE:
				setMonitoredresource((MonitoredResource)newValue);
				return;
			case MonitoringxmlPackage.PERIOD__MINIMUM:
				setMinimum((MeasuredValue)newValue);
				return;
			case MonitoringxmlPackage.PERIOD__MAXIMUM:
				setMaximum((MeasuredValue)newValue);
				return;
			case MonitoringxmlPackage.PERIOD__AVERAGE:
				setAverage((MeasuredValue)newValue);
				return;
			case MonitoringxmlPackage.PERIOD__JITTER:
				setJitter((MeasuredValue)newValue);
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
			case MonitoringxmlPackage.PERIOD__MONITOREDRESOURCE:
				setMonitoredresource((MonitoredResource)null);
				return;
			case MonitoringxmlPackage.PERIOD__MINIMUM:
				setMinimum((MeasuredValue)null);
				return;
			case MonitoringxmlPackage.PERIOD__MAXIMUM:
				setMaximum((MeasuredValue)null);
				return;
			case MonitoringxmlPackage.PERIOD__AVERAGE:
				setAverage((MeasuredValue)null);
				return;
			case MonitoringxmlPackage.PERIOD__JITTER:
				setJitter((MeasuredValue)null);
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
			case MonitoringxmlPackage.PERIOD__MONITOREDRESOURCE:
				return getMonitoredresource() != null;
			case MonitoringxmlPackage.PERIOD__MINIMUM:
				return minimum != null;
			case MonitoringxmlPackage.PERIOD__MAXIMUM:
				return maximum != null;
			case MonitoringxmlPackage.PERIOD__AVERAGE:
				return average != null;
			case MonitoringxmlPackage.PERIOD__JITTER:
				return jitter != null;
		}
		return super.eIsSet(featureID);
	}

} //PeriodImpl
