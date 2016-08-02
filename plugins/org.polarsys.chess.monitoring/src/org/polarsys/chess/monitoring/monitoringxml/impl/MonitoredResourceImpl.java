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
import org.polarsys.chess.monitoring.monitoringxml.BlockingTime;
import org.polarsys.chess.monitoring.monitoringxml.ExecutionTime;
import org.polarsys.chess.monitoring.monitoringxml.MonitoredResource;
import org.polarsys.chess.monitoring.monitoringxml.MonitoringxmlPackage;
import org.polarsys.chess.monitoring.monitoringxml.Period;
import org.polarsys.chess.monitoring.monitoringxml.ResponseTime;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Monitored Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.chess.monitoring.monitoringxml.impl.MonitoredResourceImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.polarsys.chess.monitoring.monitoringxml.impl.MonitoredResourceImpl#getPeriod <em>Period</em>}</li>
 *   <li>{@link org.polarsys.chess.monitoring.monitoringxml.impl.MonitoredResourceImpl#getExecutiontime <em>Executiontime</em>}</li>
 *   <li>{@link org.polarsys.chess.monitoring.monitoringxml.impl.MonitoredResourceImpl#getBlockingtime <em>Blockingtime</em>}</li>
 *   <li>{@link org.polarsys.chess.monitoring.monitoringxml.impl.MonitoredResourceImpl#getResponsetime <em>Responsetime</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class MonitoredResourceImpl extends MinimalEObjectImpl.Container implements MonitoredResource {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPeriod() <em>Period</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPeriod()
	 * @generated
	 * @ordered
	 */
	protected Period period;

	/**
	 * The cached value of the '{@link #getExecutiontime() <em>Executiontime</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutiontime()
	 * @generated
	 * @ordered
	 */
	protected ExecutionTime executiontime;

	/**
	 * The cached value of the '{@link #getBlockingtime() <em>Blockingtime</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlockingtime()
	 * @generated
	 * @ordered
	 */
	protected BlockingTime blockingtime;

	/**
	 * The cached value of the '{@link #getResponsetime() <em>Responsetime</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResponsetime()
	 * @generated
	 * @ordered
	 */
	protected ResponseTime responsetime;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MonitoredResourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MonitoringxmlPackage.Literals.MONITORED_RESOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MonitoringxmlPackage.MONITORED_RESOURCE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Period getPeriod() {
		return period;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPeriod(Period newPeriod, NotificationChain msgs) {
		Period oldPeriod = period;
		period = newPeriod;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MonitoringxmlPackage.MONITORED_RESOURCE__PERIOD, oldPeriod, newPeriod);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPeriod(Period newPeriod) {
		if (newPeriod != period) {
			NotificationChain msgs = null;
			if (period != null)
				msgs = ((InternalEObject)period).eInverseRemove(this, MonitoringxmlPackage.PERIOD__MONITOREDRESOURCE, Period.class, msgs);
			if (newPeriod != null)
				msgs = ((InternalEObject)newPeriod).eInverseAdd(this, MonitoringxmlPackage.PERIOD__MONITOREDRESOURCE, Period.class, msgs);
			msgs = basicSetPeriod(newPeriod, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MonitoringxmlPackage.MONITORED_RESOURCE__PERIOD, newPeriod, newPeriod));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionTime getExecutiontime() {
		return executiontime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExecutiontime(ExecutionTime newExecutiontime, NotificationChain msgs) {
		ExecutionTime oldExecutiontime = executiontime;
		executiontime = newExecutiontime;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MonitoringxmlPackage.MONITORED_RESOURCE__EXECUTIONTIME, oldExecutiontime, newExecutiontime);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExecutiontime(ExecutionTime newExecutiontime) {
		if (newExecutiontime != executiontime) {
			NotificationChain msgs = null;
			if (executiontime != null)
				msgs = ((InternalEObject)executiontime).eInverseRemove(this, MonitoringxmlPackage.EXECUTION_TIME__MONITOREDRESOURCE, ExecutionTime.class, msgs);
			if (newExecutiontime != null)
				msgs = ((InternalEObject)newExecutiontime).eInverseAdd(this, MonitoringxmlPackage.EXECUTION_TIME__MONITOREDRESOURCE, ExecutionTime.class, msgs);
			msgs = basicSetExecutiontime(newExecutiontime, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MonitoringxmlPackage.MONITORED_RESOURCE__EXECUTIONTIME, newExecutiontime, newExecutiontime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlockingTime getBlockingtime() {
		return blockingtime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBlockingtime(BlockingTime newBlockingtime, NotificationChain msgs) {
		BlockingTime oldBlockingtime = blockingtime;
		blockingtime = newBlockingtime;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MonitoringxmlPackage.MONITORED_RESOURCE__BLOCKINGTIME, oldBlockingtime, newBlockingtime);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBlockingtime(BlockingTime newBlockingtime) {
		if (newBlockingtime != blockingtime) {
			NotificationChain msgs = null;
			if (blockingtime != null)
				msgs = ((InternalEObject)blockingtime).eInverseRemove(this, MonitoringxmlPackage.BLOCKING_TIME__MONITOREDRESOURCE, BlockingTime.class, msgs);
			if (newBlockingtime != null)
				msgs = ((InternalEObject)newBlockingtime).eInverseAdd(this, MonitoringxmlPackage.BLOCKING_TIME__MONITOREDRESOURCE, BlockingTime.class, msgs);
			msgs = basicSetBlockingtime(newBlockingtime, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MonitoringxmlPackage.MONITORED_RESOURCE__BLOCKINGTIME, newBlockingtime, newBlockingtime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResponseTime getResponsetime() {
		return responsetime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResponsetime(ResponseTime newResponsetime, NotificationChain msgs) {
		ResponseTime oldResponsetime = responsetime;
		responsetime = newResponsetime;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MonitoringxmlPackage.MONITORED_RESOURCE__RESPONSETIME, oldResponsetime, newResponsetime);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResponsetime(ResponseTime newResponsetime) {
		if (newResponsetime != responsetime) {
			NotificationChain msgs = null;
			if (responsetime != null)
				msgs = ((InternalEObject)responsetime).eInverseRemove(this, MonitoringxmlPackage.RESPONSE_TIME__MONITOREDRESOURCE, ResponseTime.class, msgs);
			if (newResponsetime != null)
				msgs = ((InternalEObject)newResponsetime).eInverseAdd(this, MonitoringxmlPackage.RESPONSE_TIME__MONITOREDRESOURCE, ResponseTime.class, msgs);
			msgs = basicSetResponsetime(newResponsetime, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MonitoringxmlPackage.MONITORED_RESOURCE__RESPONSETIME, newResponsetime, newResponsetime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MonitoringxmlPackage.MONITORED_RESOURCE__PERIOD:
				if (period != null)
					msgs = ((InternalEObject)period).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MonitoringxmlPackage.MONITORED_RESOURCE__PERIOD, null, msgs);
				return basicSetPeriod((Period)otherEnd, msgs);
			case MonitoringxmlPackage.MONITORED_RESOURCE__EXECUTIONTIME:
				if (executiontime != null)
					msgs = ((InternalEObject)executiontime).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MonitoringxmlPackage.MONITORED_RESOURCE__EXECUTIONTIME, null, msgs);
				return basicSetExecutiontime((ExecutionTime)otherEnd, msgs);
			case MonitoringxmlPackage.MONITORED_RESOURCE__BLOCKINGTIME:
				if (blockingtime != null)
					msgs = ((InternalEObject)blockingtime).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MonitoringxmlPackage.MONITORED_RESOURCE__BLOCKINGTIME, null, msgs);
				return basicSetBlockingtime((BlockingTime)otherEnd, msgs);
			case MonitoringxmlPackage.MONITORED_RESOURCE__RESPONSETIME:
				if (responsetime != null)
					msgs = ((InternalEObject)responsetime).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MonitoringxmlPackage.MONITORED_RESOURCE__RESPONSETIME, null, msgs);
				return basicSetResponsetime((ResponseTime)otherEnd, msgs);
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
			case MonitoringxmlPackage.MONITORED_RESOURCE__PERIOD:
				return basicSetPeriod(null, msgs);
			case MonitoringxmlPackage.MONITORED_RESOURCE__EXECUTIONTIME:
				return basicSetExecutiontime(null, msgs);
			case MonitoringxmlPackage.MONITORED_RESOURCE__BLOCKINGTIME:
				return basicSetBlockingtime(null, msgs);
			case MonitoringxmlPackage.MONITORED_RESOURCE__RESPONSETIME:
				return basicSetResponsetime(null, msgs);
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
			case MonitoringxmlPackage.MONITORED_RESOURCE__NAME:
				return getName();
			case MonitoringxmlPackage.MONITORED_RESOURCE__PERIOD:
				return getPeriod();
			case MonitoringxmlPackage.MONITORED_RESOURCE__EXECUTIONTIME:
				return getExecutiontime();
			case MonitoringxmlPackage.MONITORED_RESOURCE__BLOCKINGTIME:
				return getBlockingtime();
			case MonitoringxmlPackage.MONITORED_RESOURCE__RESPONSETIME:
				return getResponsetime();
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
			case MonitoringxmlPackage.MONITORED_RESOURCE__NAME:
				setName((String)newValue);
				return;
			case MonitoringxmlPackage.MONITORED_RESOURCE__PERIOD:
				setPeriod((Period)newValue);
				return;
			case MonitoringxmlPackage.MONITORED_RESOURCE__EXECUTIONTIME:
				setExecutiontime((ExecutionTime)newValue);
				return;
			case MonitoringxmlPackage.MONITORED_RESOURCE__BLOCKINGTIME:
				setBlockingtime((BlockingTime)newValue);
				return;
			case MonitoringxmlPackage.MONITORED_RESOURCE__RESPONSETIME:
				setResponsetime((ResponseTime)newValue);
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
			case MonitoringxmlPackage.MONITORED_RESOURCE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MonitoringxmlPackage.MONITORED_RESOURCE__PERIOD:
				setPeriod((Period)null);
				return;
			case MonitoringxmlPackage.MONITORED_RESOURCE__EXECUTIONTIME:
				setExecutiontime((ExecutionTime)null);
				return;
			case MonitoringxmlPackage.MONITORED_RESOURCE__BLOCKINGTIME:
				setBlockingtime((BlockingTime)null);
				return;
			case MonitoringxmlPackage.MONITORED_RESOURCE__RESPONSETIME:
				setResponsetime((ResponseTime)null);
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
			case MonitoringxmlPackage.MONITORED_RESOURCE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case MonitoringxmlPackage.MONITORED_RESOURCE__PERIOD:
				return period != null;
			case MonitoringxmlPackage.MONITORED_RESOURCE__EXECUTIONTIME:
				return executiontime != null;
			case MonitoringxmlPackage.MONITORED_RESOURCE__BLOCKINGTIME:
				return blockingtime != null;
			case MonitoringxmlPackage.MONITORED_RESOURCE__RESPONSETIME:
				return responsetime != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //MonitoredResourceImpl
