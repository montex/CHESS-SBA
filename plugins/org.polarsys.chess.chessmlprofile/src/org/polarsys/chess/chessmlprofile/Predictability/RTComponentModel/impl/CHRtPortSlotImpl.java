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
package org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.uml2.uml.Slot;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtPortSlot;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RTComponentModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CH Rt Port Slot</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.CHRtPortSlotImpl#getBase_Slot <em>Base Slot</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.CHRtPortSlotImpl#getCH_RtSpecification <em>CH Rt Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CHRtPortSlotImpl extends EObjectImpl implements CHRtPortSlot {
	/**
	 * The cached value of the '{@link #getBase_Slot() <em>Base Slot</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Slot()
	 * @generated
	 * @ordered
	 */
	protected Slot base_Slot;

	/**
	 * The cached value of the '{@link #getCH_RtSpecification() <em>CH Rt Specification</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCH_RtSpecification()
	 * @generated
	 * @ordered
	 */
	protected EList<CHRtSpecification> cH_RtSpecification;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CHRtPortSlotImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RTComponentModelPackage.Literals.CH_RT_PORT_SLOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Slot getBase_Slot() {
		if (base_Slot != null && base_Slot.eIsProxy()) {
			InternalEObject oldBase_Slot = (InternalEObject)base_Slot;
			base_Slot = (Slot)eResolveProxy(oldBase_Slot);
			if (base_Slot != oldBase_Slot) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RTComponentModelPackage.CH_RT_PORT_SLOT__BASE_SLOT, oldBase_Slot, base_Slot));
			}
		}
		return base_Slot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Slot basicGetBase_Slot() {
		return base_Slot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Slot(Slot newBase_Slot) {
		Slot oldBase_Slot = base_Slot;
		base_Slot = newBase_Slot;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RTComponentModelPackage.CH_RT_PORT_SLOT__BASE_SLOT, oldBase_Slot, base_Slot));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CHRtSpecification> getCH_RtSpecification() {
		if (cH_RtSpecification == null) {
			cH_RtSpecification = new EObjectResolvingEList<CHRtSpecification>(CHRtSpecification.class, this, RTComponentModelPackage.CH_RT_PORT_SLOT__CH_RT_SPECIFICATION);
		}
		return cH_RtSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RTComponentModelPackage.CH_RT_PORT_SLOT__BASE_SLOT:
				if (resolve) return getBase_Slot();
				return basicGetBase_Slot();
			case RTComponentModelPackage.CH_RT_PORT_SLOT__CH_RT_SPECIFICATION:
				return getCH_RtSpecification();
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
			case RTComponentModelPackage.CH_RT_PORT_SLOT__BASE_SLOT:
				setBase_Slot((Slot)newValue);
				return;
			case RTComponentModelPackage.CH_RT_PORT_SLOT__CH_RT_SPECIFICATION:
				getCH_RtSpecification().clear();
				getCH_RtSpecification().addAll((Collection<? extends CHRtSpecification>)newValue);
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
			case RTComponentModelPackage.CH_RT_PORT_SLOT__BASE_SLOT:
				setBase_Slot((Slot)null);
				return;
			case RTComponentModelPackage.CH_RT_PORT_SLOT__CH_RT_SPECIFICATION:
				getCH_RtSpecification().clear();
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
			case RTComponentModelPackage.CH_RT_PORT_SLOT__BASE_SLOT:
				return base_Slot != null;
			case RTComponentModelPackage.CH_RT_PORT_SLOT__CH_RT_SPECIFICATION:
				return cH_RtSpecification != null && !cH_RtSpecification.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CHRtPortSlotImpl
