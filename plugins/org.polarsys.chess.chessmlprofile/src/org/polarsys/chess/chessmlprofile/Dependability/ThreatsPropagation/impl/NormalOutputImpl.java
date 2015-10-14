/*******************************************************************************
 *  * Copyright (c) 2015 University of Padova, Intecs
 *  *
 *  *    
 *  * All rights reserved. This program and the accompanying materials
 *  * are made available under the terms of the Eclipse Public License v1.0
 *  * which accompanies this distribution, and is available at
 *  * http://www.eclipse.org/legal/epl-v10.html
 *  *
 *******************************************************************************/
/**
 */
package org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.NormalOutput;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.RecoveryEvent;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatsPropagationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Normal Output</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.NormalOutputImpl#getRecovery <em>Recovery</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NormalOutputImpl extends DepEventImpl implements NormalOutput {
	/**
	 * The cached value of the '{@link #getRecovery() <em>Recovery</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecovery()
	 * @generated
	 * @ordered
	 */
	protected RecoveryEvent recovery;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NormalOutputImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ThreatsPropagationPackage.Literals.NORMAL_OUTPUT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecoveryEvent getRecovery() {
		if (recovery != null && recovery.eIsProxy()) {
			InternalEObject oldRecovery = (InternalEObject)recovery;
			recovery = (RecoveryEvent)eResolveProxy(oldRecovery);
			if (recovery != oldRecovery) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ThreatsPropagationPackage.NORMAL_OUTPUT__RECOVERY, oldRecovery, recovery));
			}
		}
		return recovery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecoveryEvent basicGetRecovery() {
		return recovery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRecovery(RecoveryEvent newRecovery) {
		RecoveryEvent oldRecovery = recovery;
		recovery = newRecovery;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ThreatsPropagationPackage.NORMAL_OUTPUT__RECOVERY, oldRecovery, recovery));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ThreatsPropagationPackage.NORMAL_OUTPUT__RECOVERY:
				if (resolve) return getRecovery();
				return basicGetRecovery();
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
			case ThreatsPropagationPackage.NORMAL_OUTPUT__RECOVERY:
				setRecovery((RecoveryEvent)newValue);
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
			case ThreatsPropagationPackage.NORMAL_OUTPUT__RECOVERY:
				setRecovery((RecoveryEvent)null);
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
			case ThreatsPropagationPackage.NORMAL_OUTPUT__RECOVERY:
				return recovery != null;
		}
		return super.eIsSet(featureID);
	}

} //NormalOutputImpl
