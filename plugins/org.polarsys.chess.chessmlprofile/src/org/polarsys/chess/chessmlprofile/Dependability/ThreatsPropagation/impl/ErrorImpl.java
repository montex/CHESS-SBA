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
package org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.DurationType;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatsPropagationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Error</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ErrorImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ErrorImpl#getVanishingTime <em>Vanishing Time</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ErrorImpl extends ThreatStateImpl implements org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Error {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final DurationType TYPE_EDEFAULT = DurationType.TRANSIENT;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected DurationType type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getVanishingTime() <em>Vanishing Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVanishingTime()
	 * @generated
	 * @ordered
	 */
	protected static final String VANISHING_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVanishingTime() <em>Vanishing Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVanishingTime()
	 * @generated
	 * @ordered
	 */
	protected String vanishingTime = VANISHING_TIME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ErrorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ThreatsPropagationPackage.Literals.ERROR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DurationType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(DurationType newType) {
		DurationType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ThreatsPropagationPackage.ERROR__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVanishingTime() {
		return vanishingTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVanishingTime(String newVanishingTime) {
		String oldVanishingTime = vanishingTime;
		vanishingTime = newVanishingTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ThreatsPropagationPackage.ERROR__VANISHING_TIME, oldVanishingTime, vanishingTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ThreatsPropagationPackage.ERROR__TYPE:
				return getType();
			case ThreatsPropagationPackage.ERROR__VANISHING_TIME:
				return getVanishingTime();
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
			case ThreatsPropagationPackage.ERROR__TYPE:
				setType((DurationType)newValue);
				return;
			case ThreatsPropagationPackage.ERROR__VANISHING_TIME:
				setVanishingTime((String)newValue);
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
			case ThreatsPropagationPackage.ERROR__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case ThreatsPropagationPackage.ERROR__VANISHING_TIME:
				setVanishingTime(VANISHING_TIME_EDEFAULT);
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
			case ThreatsPropagationPackage.ERROR__TYPE:
				return type != TYPE_EDEFAULT;
			case ThreatsPropagationPackage.ERROR__VANISHING_TIME:
				return VANISHING_TIME_EDEFAULT == null ? vanishingTime != null : !VANISHING_TIME_EDEFAULT.equals(vanishingTime);
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
		result.append(" (type: ");
		result.append(type);
		result.append(", vanishingTime: ");
		result.append(vanishingTime);
		result.append(')');
		return result.toString();
	}

} //ErrorImpl
