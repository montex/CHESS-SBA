/*****************************************************************************
 * Copyright (c) 2011, 2015 University of Padova, Intecs
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

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.uml2.uml.Slot;
import org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FPTCPortSlot;
import org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FPTCSpecification;
import org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.FailureType;
import org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>FPTC Port Slot</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FPTCPortSlotImpl#getFPTCSpecification <em>FPTC Specification</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FPTCPortSlotImpl#getBase_Slot <em>Base Slot</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FPTCPortSlotImpl#getFailure <em>Failure</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FPTCPortSlotImpl extends EObjectImpl implements FPTCPortSlot {
	/**
	 * The cached value of the '{@link #getFPTCSpecification() <em>FPTC Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFPTCSpecification()
	 * @generated
	 * @ordered
	 */
	protected FPTCSpecification fptcSpecification;

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
	 * The cached value of the '{@link #getFailure() <em>Failure</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailure()
	 * @generated
	 * @ordered
	 */
	protected EList<FailureType> failure;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FPTCPortSlotImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FailurePropagationPackage.Literals.FPTC_PORT_SLOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FPTCSpecification getFPTCSpecification() {
		if (fptcSpecification != null && fptcSpecification.eIsProxy()) {
			InternalEObject oldFPTCSpecification = (InternalEObject)fptcSpecification;
			fptcSpecification = (FPTCSpecification)eResolveProxy(oldFPTCSpecification);
			if (fptcSpecification != oldFPTCSpecification) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FailurePropagationPackage.FPTC_PORT_SLOT__FPTC_SPECIFICATION, oldFPTCSpecification, fptcSpecification));
			}
		}
		return fptcSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FPTCSpecification basicGetFPTCSpecification() {
		return fptcSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFPTCSpecification(FPTCSpecification newFPTCSpecification) {
		FPTCSpecification oldFPTCSpecification = fptcSpecification;
		fptcSpecification = newFPTCSpecification;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FailurePropagationPackage.FPTC_PORT_SLOT__FPTC_SPECIFICATION, oldFPTCSpecification, fptcSpecification));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FailurePropagationPackage.FPTC_PORT_SLOT__BASE_SLOT, oldBase_Slot, base_Slot));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FailurePropagationPackage.FPTC_PORT_SLOT__BASE_SLOT, oldBase_Slot, base_Slot));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FailureType> getFailure() {
		if (failure == null) {
			failure = new EDataTypeUniqueEList<FailureType>(FailureType.class, this, FailurePropagationPackage.FPTC_PORT_SLOT__FAILURE);
		}
		return failure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FailurePropagationPackage.FPTC_PORT_SLOT__FPTC_SPECIFICATION:
				if (resolve) return getFPTCSpecification();
				return basicGetFPTCSpecification();
			case FailurePropagationPackage.FPTC_PORT_SLOT__BASE_SLOT:
				if (resolve) return getBase_Slot();
				return basicGetBase_Slot();
			case FailurePropagationPackage.FPTC_PORT_SLOT__FAILURE:
				return getFailure();
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
			case FailurePropagationPackage.FPTC_PORT_SLOT__FPTC_SPECIFICATION:
				setFPTCSpecification((FPTCSpecification)newValue);
				return;
			case FailurePropagationPackage.FPTC_PORT_SLOT__BASE_SLOT:
				setBase_Slot((Slot)newValue);
				return;
			case FailurePropagationPackage.FPTC_PORT_SLOT__FAILURE:
				getFailure().clear();
				getFailure().addAll((Collection<? extends FailureType>)newValue);
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
			case FailurePropagationPackage.FPTC_PORT_SLOT__FPTC_SPECIFICATION:
				setFPTCSpecification((FPTCSpecification)null);
				return;
			case FailurePropagationPackage.FPTC_PORT_SLOT__BASE_SLOT:
				setBase_Slot((Slot)null);
				return;
			case FailurePropagationPackage.FPTC_PORT_SLOT__FAILURE:
				getFailure().clear();
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
			case FailurePropagationPackage.FPTC_PORT_SLOT__FPTC_SPECIFICATION:
				return fptcSpecification != null;
			case FailurePropagationPackage.FPTC_PORT_SLOT__BASE_SLOT:
				return base_Slot != null;
			case FailurePropagationPackage.FPTC_PORT_SLOT__FAILURE:
				return failure != null && !failure.isEmpty();
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
		result.append(" (failure: ");
		result.append(failure);
		result.append(')');
		return result.toString();
	}

} //FPTCPortSlotImpl
