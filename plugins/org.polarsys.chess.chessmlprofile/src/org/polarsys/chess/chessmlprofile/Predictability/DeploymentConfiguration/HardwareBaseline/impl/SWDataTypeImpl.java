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
package org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.uml2.uml.DataType;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.HardwareBaselinePackage;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.SWDataType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SW Data Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.SWDataTypeImpl#getBase_DataType <em>Base Data Type</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.SWDataTypeImpl#getBitSize <em>Bit Size</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SWDataTypeImpl extends EObjectImpl implements SWDataType {
	/**
	 * The cached value of the '{@link #getBase_DataType() <em>Base Data Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_DataType()
	 * @generated
	 * @ordered
	 */
	protected DataType base_DataType;

	/**
	 * The default value of the '{@link #getBitSize() <em>Bit Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBitSize()
	 * @generated
	 * @ordered
	 */
	protected static final int BIT_SIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getBitSize() <em>Bit Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBitSize()
	 * @generated
	 * @ordered
	 */
	protected int bitSize = BIT_SIZE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SWDataTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HardwareBaselinePackage.Literals.SW_DATA_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType getBase_DataType() {
		if (base_DataType != null && base_DataType.eIsProxy()) {
			InternalEObject oldBase_DataType = (InternalEObject)base_DataType;
			base_DataType = (DataType)eResolveProxy(oldBase_DataType);
			if (base_DataType != oldBase_DataType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, HardwareBaselinePackage.SW_DATA_TYPE__BASE_DATA_TYPE, oldBase_DataType, base_DataType));
			}
		}
		return base_DataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType basicGetBase_DataType() {
		return base_DataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_DataType(DataType newBase_DataType) {
		DataType oldBase_DataType = base_DataType;
		base_DataType = newBase_DataType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HardwareBaselinePackage.SW_DATA_TYPE__BASE_DATA_TYPE, oldBase_DataType, base_DataType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getBitSize() {
		return bitSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBitSize(int newBitSize) {
		int oldBitSize = bitSize;
		bitSize = newBitSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HardwareBaselinePackage.SW_DATA_TYPE__BIT_SIZE, oldBitSize, bitSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case HardwareBaselinePackage.SW_DATA_TYPE__BASE_DATA_TYPE:
				if (resolve) return getBase_DataType();
				return basicGetBase_DataType();
			case HardwareBaselinePackage.SW_DATA_TYPE__BIT_SIZE:
				return getBitSize();
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
			case HardwareBaselinePackage.SW_DATA_TYPE__BASE_DATA_TYPE:
				setBase_DataType((DataType)newValue);
				return;
			case HardwareBaselinePackage.SW_DATA_TYPE__BIT_SIZE:
				setBitSize((Integer)newValue);
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
			case HardwareBaselinePackage.SW_DATA_TYPE__BASE_DATA_TYPE:
				setBase_DataType((DataType)null);
				return;
			case HardwareBaselinePackage.SW_DATA_TYPE__BIT_SIZE:
				setBitSize(BIT_SIZE_EDEFAULT);
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
			case HardwareBaselinePackage.SW_DATA_TYPE__BASE_DATA_TYPE:
				return base_DataType != null;
			case HardwareBaselinePackage.SW_DATA_TYPE__BIT_SIZE:
				return bitSize != BIT_SIZE_EDEFAULT;
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
		result.append(" (bitSize: ");
		result.append(bitSize);
		result.append(')');
		return result.toString();
	}

} //SWDataTypeImpl
