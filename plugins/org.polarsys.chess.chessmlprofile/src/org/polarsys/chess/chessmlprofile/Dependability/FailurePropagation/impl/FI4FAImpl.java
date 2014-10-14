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
package org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.DependableComponentImpl;
import org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FI4FA;
import org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>FI4FA</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FI4FAImpl#getFi4fa <em>Fi4fa</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FI4FAImpl extends DependableComponentImpl implements FI4FA {
	/**
	 * The default value of the '{@link #getFi4fa() <em>Fi4fa</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFi4fa()
	 * @generated
	 * @ordered
	 */
	protected static final String FI4FA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFi4fa() <em>Fi4fa</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFi4fa()
	 * @generated
	 * @ordered
	 */
	protected String fi4fa = FI4FA_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FI4FAImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FailurePropagationPackage.Literals.FI4FA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFi4fa() {
		return fi4fa;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFi4fa(String newFi4fa) {
		String oldFi4fa = fi4fa;
		fi4fa = newFi4fa;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FailurePropagationPackage.FI4FA__FI4FA, oldFi4fa, fi4fa));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FailurePropagationPackage.FI4FA__FI4FA:
				return getFi4fa();
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
			case FailurePropagationPackage.FI4FA__FI4FA:
				setFi4fa((String)newValue);
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
			case FailurePropagationPackage.FI4FA__FI4FA:
				setFi4fa(FI4FA_EDEFAULT);
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
			case FailurePropagationPackage.FI4FA__FI4FA:
				return FI4FA_EDEFAULT == null ? fi4fa != null : !FI4FA_EDEFAULT.equals(fi4fa);
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
		result.append(" (fi4fa: ");
		result.append(fi4fa);
		result.append(')');
		return result.toString();
	}

} //FI4FAImpl
