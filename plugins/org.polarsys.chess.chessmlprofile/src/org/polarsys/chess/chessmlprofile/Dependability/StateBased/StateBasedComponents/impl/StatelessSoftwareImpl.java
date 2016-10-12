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
package org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.DependableComponentImpl;
import org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.StateBasedComponentsPackage;
import org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.StatelessSoftware;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stateless Software</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.impl.StatelessSoftwareImpl#getFaultOcc <em>Fault Occ</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StatelessSoftwareImpl extends DependableComponentImpl implements StatelessSoftware {
	/**
	 * The default value of the '{@link #getFaultOcc() <em>Fault Occ</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultOcc()
	 * @generated
	 * @ordered
	 */
	protected static final String FAULT_OCC_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getFaultOcc() <em>Fault Occ</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultOcc()
	 * @generated
	 * @ordered
	 */
	protected String faultOcc = FAULT_OCC_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StatelessSoftwareImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StateBasedComponentsPackage.Literals.STATELESS_SOFTWARE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFaultOcc() {
		return faultOcc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFaultOcc(String newFaultOcc) {
		String oldFaultOcc = faultOcc;
		faultOcc = newFaultOcc;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StateBasedComponentsPackage.STATELESS_SOFTWARE__FAULT_OCC, oldFaultOcc, faultOcc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StateBasedComponentsPackage.STATELESS_SOFTWARE__FAULT_OCC:
				return getFaultOcc();
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
			case StateBasedComponentsPackage.STATELESS_SOFTWARE__FAULT_OCC:
				setFaultOcc((String)newValue);
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
			case StateBasedComponentsPackage.STATELESS_SOFTWARE__FAULT_OCC:
				setFaultOcc(FAULT_OCC_EDEFAULT);
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
			case StateBasedComponentsPackage.STATELESS_SOFTWARE__FAULT_OCC:
				return FAULT_OCC_EDEFAULT == null ? faultOcc != null : !FAULT_OCC_EDEFAULT.equals(faultOcc);
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
		result.append(" (faultOcc: ");
		result.append(faultOcc);
		result.append(')');
		return result.toString();
	}

} //StatelessSoftwareImpl
