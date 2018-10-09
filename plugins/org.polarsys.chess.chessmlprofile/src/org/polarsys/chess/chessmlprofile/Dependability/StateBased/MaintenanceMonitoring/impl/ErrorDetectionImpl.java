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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.uml2.uml.Property;
import org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.ErrorDetection;
import org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MaintenanceMonitoringPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Error Detection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.impl.ErrorDetectionImpl#getTargets <em>Targets</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.impl.ErrorDetectionImpl#getCorrectionProbability <em>Correction Probability</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ErrorDetectionImpl extends MMActivitiesImpl implements ErrorDetection {
	/**
	 * The cached value of the '{@link #getTargets() <em>Targets</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargets()
	 * @generated
	 * @ordered
	 */
	protected Property targets;

	/**
	 * The default value of the '{@link #getCorrectionProbability() <em>Correction Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCorrectionProbability()
	 * @generated
	 * @ordered
	 */
	protected static final String CORRECTION_PROBABILITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCorrectionProbability() <em>Correction Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCorrectionProbability()
	 * @generated
	 * @ordered
	 */
	protected String correctionProbability = CORRECTION_PROBABILITY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ErrorDetectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MaintenanceMonitoringPackage.Literals.ERROR_DETECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getTargets() {
		if (targets != null && targets.eIsProxy()) {
			InternalEObject oldTargets = (InternalEObject)targets;
			targets = (Property)eResolveProxy(oldTargets);
			if (targets != oldTargets) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MaintenanceMonitoringPackage.ERROR_DETECTION__TARGETS, oldTargets, targets));
			}
		}
		return targets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetTargets() {
		return targets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargets(Property newTargets) {
		Property oldTargets = targets;
		targets = newTargets;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MaintenanceMonitoringPackage.ERROR_DETECTION__TARGETS, oldTargets, targets));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCorrectionProbability() {
		return correctionProbability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCorrectionProbability(String newCorrectionProbability) {
		String oldCorrectionProbability = correctionProbability;
		correctionProbability = newCorrectionProbability;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MaintenanceMonitoringPackage.ERROR_DETECTION__CORRECTION_PROBABILITY, oldCorrectionProbability, correctionProbability));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MaintenanceMonitoringPackage.ERROR_DETECTION__TARGETS:
				if (resolve) return getTargets();
				return basicGetTargets();
			case MaintenanceMonitoringPackage.ERROR_DETECTION__CORRECTION_PROBABILITY:
				return getCorrectionProbability();
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
			case MaintenanceMonitoringPackage.ERROR_DETECTION__TARGETS:
				setTargets((Property)newValue);
				return;
			case MaintenanceMonitoringPackage.ERROR_DETECTION__CORRECTION_PROBABILITY:
				setCorrectionProbability((String)newValue);
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
			case MaintenanceMonitoringPackage.ERROR_DETECTION__TARGETS:
				setTargets((Property)null);
				return;
			case MaintenanceMonitoringPackage.ERROR_DETECTION__CORRECTION_PROBABILITY:
				setCorrectionProbability(CORRECTION_PROBABILITY_EDEFAULT);
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
			case MaintenanceMonitoringPackage.ERROR_DETECTION__TARGETS:
				return targets != null;
			case MaintenanceMonitoringPackage.ERROR_DETECTION__CORRECTION_PROBABILITY:
				return CORRECTION_PROBABILITY_EDEFAULT == null ? correctionProbability != null : !CORRECTION_PROBABILITY_EDEFAULT.equals(correctionProbability);
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
		result.append(" (correctionProbability: ");
		result.append(correctionProbability);
		result.append(')');
		return result.toString();
	}

} //ErrorDetectionImpl
