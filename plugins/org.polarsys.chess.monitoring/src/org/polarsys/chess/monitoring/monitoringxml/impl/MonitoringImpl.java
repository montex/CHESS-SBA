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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polarsys.chess.monitoring.monitoringxml.AnalysisContext;
import org.polarsys.chess.monitoring.monitoringxml.Monitoring;
import org.polarsys.chess.monitoring.monitoringxml.MonitoringxmlPackage;
import org.polarsys.chess.monitoring.monitoringxml.Resource;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Monitoring</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.chess.monitoring.monitoringxml.impl.MonitoringImpl#getThreadNames <em>Thread Names</em>}</li>
 *   <li>{@link org.polarsys.chess.monitoring.monitoringxml.impl.MonitoringImpl#getSharedResources <em>Shared Resources</em>}</li>
 *   <li>{@link org.polarsys.chess.monitoring.monitoringxml.impl.MonitoringImpl#getAnalysisContext <em>Analysis Context</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MonitoringImpl extends MinimalEObjectImpl.Container implements Monitoring {
	/**
	 * The cached value of the '{@link #getThreadNames() <em>Thread Names</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThreadNames()
	 * @generated
	 * @ordered
	 */
	protected EList<org.polarsys.chess.monitoring.monitoringxml.Thread> threadNames;

	/**
	 * The cached value of the '{@link #getSharedResources() <em>Shared Resources</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSharedResources()
	 * @generated
	 * @ordered
	 */
	protected EList<Resource> sharedResources;

	/**
	 * The cached value of the '{@link #getAnalysisContext() <em>Analysis Context</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnalysisContext()
	 * @generated
	 * @ordered
	 */
	protected AnalysisContext analysisContext;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MonitoringImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MonitoringxmlPackage.Literals.MONITORING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<org.polarsys.chess.monitoring.monitoringxml.Thread> getThreadNames() {
		if (threadNames == null) {
			threadNames = new EObjectContainmentEList<org.polarsys.chess.monitoring.monitoringxml.Thread>(org.polarsys.chess.monitoring.monitoringxml.Thread.class, this, MonitoringxmlPackage.MONITORING__THREAD_NAMES);
		}
		return threadNames;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Resource> getSharedResources() {
		if (sharedResources == null) {
			sharedResources = new EObjectContainmentEList<Resource>(Resource.class, this, MonitoringxmlPackage.MONITORING__SHARED_RESOURCES);
		}
		return sharedResources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnalysisContext getAnalysisContext() {
		return analysisContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAnalysisContext(AnalysisContext newAnalysisContext, NotificationChain msgs) {
		AnalysisContext oldAnalysisContext = analysisContext;
		analysisContext = newAnalysisContext;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MonitoringxmlPackage.MONITORING__ANALYSIS_CONTEXT, oldAnalysisContext, newAnalysisContext);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnalysisContext(AnalysisContext newAnalysisContext) {
		if (newAnalysisContext != analysisContext) {
			NotificationChain msgs = null;
			if (analysisContext != null)
				msgs = ((InternalEObject)analysisContext).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MonitoringxmlPackage.MONITORING__ANALYSIS_CONTEXT, null, msgs);
			if (newAnalysisContext != null)
				msgs = ((InternalEObject)newAnalysisContext).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MonitoringxmlPackage.MONITORING__ANALYSIS_CONTEXT, null, msgs);
			msgs = basicSetAnalysisContext(newAnalysisContext, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MonitoringxmlPackage.MONITORING__ANALYSIS_CONTEXT, newAnalysisContext, newAnalysisContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MonitoringxmlPackage.MONITORING__THREAD_NAMES:
				return ((InternalEList<?>)getThreadNames()).basicRemove(otherEnd, msgs);
			case MonitoringxmlPackage.MONITORING__SHARED_RESOURCES:
				return ((InternalEList<?>)getSharedResources()).basicRemove(otherEnd, msgs);
			case MonitoringxmlPackage.MONITORING__ANALYSIS_CONTEXT:
				return basicSetAnalysisContext(null, msgs);
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
			case MonitoringxmlPackage.MONITORING__THREAD_NAMES:
				return getThreadNames();
			case MonitoringxmlPackage.MONITORING__SHARED_RESOURCES:
				return getSharedResources();
			case MonitoringxmlPackage.MONITORING__ANALYSIS_CONTEXT:
				return getAnalysisContext();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MonitoringxmlPackage.MONITORING__THREAD_NAMES:
				getThreadNames().clear();
				getThreadNames().addAll((Collection<? extends org.polarsys.chess.monitoring.monitoringxml.Thread>)newValue);
				return;
			case MonitoringxmlPackage.MONITORING__SHARED_RESOURCES:
				getSharedResources().clear();
				getSharedResources().addAll((Collection<? extends Resource>)newValue);
				return;
			case MonitoringxmlPackage.MONITORING__ANALYSIS_CONTEXT:
				setAnalysisContext((AnalysisContext)newValue);
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
			case MonitoringxmlPackage.MONITORING__THREAD_NAMES:
				getThreadNames().clear();
				return;
			case MonitoringxmlPackage.MONITORING__SHARED_RESOURCES:
				getSharedResources().clear();
				return;
			case MonitoringxmlPackage.MONITORING__ANALYSIS_CONTEXT:
				setAnalysisContext((AnalysisContext)null);
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
			case MonitoringxmlPackage.MONITORING__THREAD_NAMES:
				return threadNames != null && !threadNames.isEmpty();
			case MonitoringxmlPackage.MONITORING__SHARED_RESOURCES:
				return sharedResources != null && !sharedResources.isEmpty();
			case MonitoringxmlPackage.MONITORING__ANALYSIS_CONTEXT:
				return analysisContext != null;
		}
		return super.eIsSet(featureID);
	}

} //MonitoringImpl
