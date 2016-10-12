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
import org.polarsys.chess.monitoring.monitoringxml.ExecutionTime;
import org.polarsys.chess.monitoring.monitoringxml.MeasuredValue;
import org.polarsys.chess.monitoring.monitoringxml.MonitoredResource;
import org.polarsys.chess.monitoring.monitoringxml.MonitoringxmlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execution Time</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.chess.monitoring.monitoringxml.impl.ExecutionTimeImpl#getMonitoredresource <em>Monitoredresource</em>}</li>
 *   <li>{@link org.polarsys.chess.monitoring.monitoringxml.impl.ExecutionTimeImpl#getMinimum <em>Minimum</em>}</li>
 *   <li>{@link org.polarsys.chess.monitoring.monitoringxml.impl.ExecutionTimeImpl#getMaximum <em>Maximum</em>}</li>
 *   <li>{@link org.polarsys.chess.monitoring.monitoringxml.impl.ExecutionTimeImpl#getAverage <em>Average</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExecutionTimeImpl extends MinimalEObjectImpl.Container implements ExecutionTime {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecutionTimeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MonitoringxmlPackage.Literals.EXECUTION_TIME;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MonitoredResource getMonitoredresource() {
		if (eContainerFeatureID() != MonitoringxmlPackage.EXECUTION_TIME__MONITOREDRESOURCE) return null;
		return (MonitoredResource)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMonitoredresource(MonitoredResource newMonitoredresource, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newMonitoredresource, MonitoringxmlPackage.EXECUTION_TIME__MONITOREDRESOURCE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMonitoredresource(MonitoredResource newMonitoredresource) {
		if (newMonitoredresource != eInternalContainer() || (eContainerFeatureID() != MonitoringxmlPackage.EXECUTION_TIME__MONITOREDRESOURCE && newMonitoredresource != null)) {
			if (EcoreUtil.isAncestor(this, newMonitoredresource))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newMonitoredresource != null)
				msgs = ((InternalEObject)newMonitoredresource).eInverseAdd(this, MonitoringxmlPackage.MONITORED_RESOURCE__EXECUTIONTIME, MonitoredResource.class, msgs);
			msgs = basicSetMonitoredresource(newMonitoredresource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MonitoringxmlPackage.EXECUTION_TIME__MONITOREDRESOURCE, newMonitoredresource, newMonitoredresource));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MonitoringxmlPackage.EXECUTION_TIME__MINIMUM, oldMinimum, newMinimum);
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
				msgs = ((InternalEObject)minimum).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MonitoringxmlPackage.EXECUTION_TIME__MINIMUM, null, msgs);
			if (newMinimum != null)
				msgs = ((InternalEObject)newMinimum).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MonitoringxmlPackage.EXECUTION_TIME__MINIMUM, null, msgs);
			msgs = basicSetMinimum(newMinimum, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MonitoringxmlPackage.EXECUTION_TIME__MINIMUM, newMinimum, newMinimum));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MonitoringxmlPackage.EXECUTION_TIME__MAXIMUM, oldMaximum, newMaximum);
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
				msgs = ((InternalEObject)maximum).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MonitoringxmlPackage.EXECUTION_TIME__MAXIMUM, null, msgs);
			if (newMaximum != null)
				msgs = ((InternalEObject)newMaximum).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MonitoringxmlPackage.EXECUTION_TIME__MAXIMUM, null, msgs);
			msgs = basicSetMaximum(newMaximum, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MonitoringxmlPackage.EXECUTION_TIME__MAXIMUM, newMaximum, newMaximum));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MonitoringxmlPackage.EXECUTION_TIME__AVERAGE, oldAverage, newAverage);
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
				msgs = ((InternalEObject)average).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MonitoringxmlPackage.EXECUTION_TIME__AVERAGE, null, msgs);
			if (newAverage != null)
				msgs = ((InternalEObject)newAverage).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MonitoringxmlPackage.EXECUTION_TIME__AVERAGE, null, msgs);
			msgs = basicSetAverage(newAverage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MonitoringxmlPackage.EXECUTION_TIME__AVERAGE, newAverage, newAverage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MonitoringxmlPackage.EXECUTION_TIME__MONITOREDRESOURCE:
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
			case MonitoringxmlPackage.EXECUTION_TIME__MONITOREDRESOURCE:
				return basicSetMonitoredresource(null, msgs);
			case MonitoringxmlPackage.EXECUTION_TIME__MINIMUM:
				return basicSetMinimum(null, msgs);
			case MonitoringxmlPackage.EXECUTION_TIME__MAXIMUM:
				return basicSetMaximum(null, msgs);
			case MonitoringxmlPackage.EXECUTION_TIME__AVERAGE:
				return basicSetAverage(null, msgs);
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
			case MonitoringxmlPackage.EXECUTION_TIME__MONITOREDRESOURCE:
				return eInternalContainer().eInverseRemove(this, MonitoringxmlPackage.MONITORED_RESOURCE__EXECUTIONTIME, MonitoredResource.class, msgs);
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
			case MonitoringxmlPackage.EXECUTION_TIME__MONITOREDRESOURCE:
				return getMonitoredresource();
			case MonitoringxmlPackage.EXECUTION_TIME__MINIMUM:
				return getMinimum();
			case MonitoringxmlPackage.EXECUTION_TIME__MAXIMUM:
				return getMaximum();
			case MonitoringxmlPackage.EXECUTION_TIME__AVERAGE:
				return getAverage();
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
			case MonitoringxmlPackage.EXECUTION_TIME__MONITOREDRESOURCE:
				setMonitoredresource((MonitoredResource)newValue);
				return;
			case MonitoringxmlPackage.EXECUTION_TIME__MINIMUM:
				setMinimum((MeasuredValue)newValue);
				return;
			case MonitoringxmlPackage.EXECUTION_TIME__MAXIMUM:
				setMaximum((MeasuredValue)newValue);
				return;
			case MonitoringxmlPackage.EXECUTION_TIME__AVERAGE:
				setAverage((MeasuredValue)newValue);
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
			case MonitoringxmlPackage.EXECUTION_TIME__MONITOREDRESOURCE:
				setMonitoredresource((MonitoredResource)null);
				return;
			case MonitoringxmlPackage.EXECUTION_TIME__MINIMUM:
				setMinimum((MeasuredValue)null);
				return;
			case MonitoringxmlPackage.EXECUTION_TIME__MAXIMUM:
				setMaximum((MeasuredValue)null);
				return;
			case MonitoringxmlPackage.EXECUTION_TIME__AVERAGE:
				setAverage((MeasuredValue)null);
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
			case MonitoringxmlPackage.EXECUTION_TIME__MONITOREDRESOURCE:
				return getMonitoredresource() != null;
			case MonitoringxmlPackage.EXECUTION_TIME__MINIMUM:
				return minimum != null;
			case MonitoringxmlPackage.EXECUTION_TIME__MAXIMUM:
				return maximum != null;
			case MonitoringxmlPackage.EXECUTION_TIME__AVERAGE:
				return average != null;
		}
		return super.eIsSet(featureID);
	}

} //ExecutionTimeImpl
