/*****************************************************************************
 * Copyright (c) 2011 - 2014 University of Padova, Intecs
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *
 *****************************************************************************/
package org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.uml2.uml.Activity;
import org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.FailureDetection;
import org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MaintenanceMonitoringPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Failure Detection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.impl.FailureDetectionImpl#getOnDetection <em>On Detection</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FailureDetectionImpl extends MMActivitiesImpl implements FailureDetection {
	/**
	 * The cached value of the '{@link #getOnDetection() <em>On Detection</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnDetection()
	 * @generated
	 * @ordered
	 */
	protected EList<Activity> onDetection;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FailureDetectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MaintenanceMonitoringPackage.Literals.FAILURE_DETECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Activity> getOnDetection() {
		if (onDetection == null) {
			onDetection = new EObjectResolvingEList<Activity>(Activity.class, this, MaintenanceMonitoringPackage.FAILURE_DETECTION__ON_DETECTION);
		}
		return onDetection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Activity getOnDetection(String name) {
		return getOnDetection(name, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Activity getOnDetection(String name, boolean ignoreCase) {
		onDetectionLoop: for (Activity onDetection : getOnDetection()) {
			if (name != null && !(ignoreCase ? name.equalsIgnoreCase(onDetection.getName()) : name.equals(onDetection.getName())))
				continue onDetectionLoop;
			return onDetection;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MaintenanceMonitoringPackage.FAILURE_DETECTION__ON_DETECTION:
				return getOnDetection();
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
			case MaintenanceMonitoringPackage.FAILURE_DETECTION__ON_DETECTION:
				getOnDetection().clear();
				getOnDetection().addAll((Collection<? extends Activity>)newValue);
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
			case MaintenanceMonitoringPackage.FAILURE_DETECTION__ON_DETECTION:
				getOnDetection().clear();
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
			case MaintenanceMonitoringPackage.FAILURE_DETECTION__ON_DETECTION:
				return onDetection != null && !onDetection.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FailureDetectionImpl
