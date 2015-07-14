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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.uml2.uml.DataType;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.DataTypeExecution;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.HWDataType;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.HardwareBaselinePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>HW Data Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.HWDataTypeImpl#getBase_DataType <em>Base Data Type</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.HWDataTypeImpl#getBitLength <em>Bit Length</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.HWDataTypeImpl#isSigned <em>Signed</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.HWDataTypeImpl#isFixedPoint <em>Fixed Point</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.HWDataTypeImpl#isFloat <em>Float</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.HWDataTypeImpl#getExecution <em>Execution</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HWDataTypeImpl extends EObjectImpl implements HWDataType {
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
	 * The default value of the '{@link #getBitLength() <em>Bit Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBitLength()
	 * @generated
	 * @ordered
	 */
	protected static final int BIT_LENGTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getBitLength() <em>Bit Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBitLength()
	 * @generated
	 * @ordered
	 */
	protected int bitLength = BIT_LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #isSigned() <em>Signed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSigned()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SIGNED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSigned() <em>Signed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSigned()
	 * @generated
	 * @ordered
	 */
	protected boolean signed = SIGNED_EDEFAULT;

	/**
	 * The default value of the '{@link #isFixedPoint() <em>Fixed Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFixedPoint()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FIXED_POINT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFixedPoint() <em>Fixed Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFixedPoint()
	 * @generated
	 * @ordered
	 */
	protected boolean fixedPoint = FIXED_POINT_EDEFAULT;

	/**
	 * The default value of the '{@link #isFloat() <em>Float</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFloat()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FLOAT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFloat() <em>Float</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFloat()
	 * @generated
	 * @ordered
	 */
	protected boolean float_ = FLOAT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getExecution() <em>Execution</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecution()
	 * @generated
	 * @ordered
	 */
	protected EList<DataTypeExecution> execution;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HWDataTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HardwareBaselinePackage.Literals.HW_DATA_TYPE;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, HardwareBaselinePackage.HW_DATA_TYPE__BASE_DATA_TYPE, oldBase_DataType, base_DataType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, HardwareBaselinePackage.HW_DATA_TYPE__BASE_DATA_TYPE, oldBase_DataType, base_DataType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getBitLength() {
		return bitLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBitLength(int newBitLength) {
		int oldBitLength = bitLength;
		bitLength = newBitLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HardwareBaselinePackage.HW_DATA_TYPE__BIT_LENGTH, oldBitLength, bitLength));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSigned() {
		return signed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSigned(boolean newSigned) {
		boolean oldSigned = signed;
		signed = newSigned;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HardwareBaselinePackage.HW_DATA_TYPE__SIGNED, oldSigned, signed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFixedPoint() {
		return fixedPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFixedPoint(boolean newFixedPoint) {
		boolean oldFixedPoint = fixedPoint;
		fixedPoint = newFixedPoint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HardwareBaselinePackage.HW_DATA_TYPE__FIXED_POINT, oldFixedPoint, fixedPoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFloat() {
		return float_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFloat(boolean newFloat) {
		boolean oldFloat = float_;
		float_ = newFloat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HardwareBaselinePackage.HW_DATA_TYPE__FLOAT, oldFloat, float_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataTypeExecution> getExecution() {
		if (execution == null) {
			execution = new EObjectResolvingEList<DataTypeExecution>(DataTypeExecution.class, this, HardwareBaselinePackage.HW_DATA_TYPE__EXECUTION);
		}
		return execution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case HardwareBaselinePackage.HW_DATA_TYPE__BASE_DATA_TYPE:
				if (resolve) return getBase_DataType();
				return basicGetBase_DataType();
			case HardwareBaselinePackage.HW_DATA_TYPE__BIT_LENGTH:
				return getBitLength();
			case HardwareBaselinePackage.HW_DATA_TYPE__SIGNED:
				return isSigned();
			case HardwareBaselinePackage.HW_DATA_TYPE__FIXED_POINT:
				return isFixedPoint();
			case HardwareBaselinePackage.HW_DATA_TYPE__FLOAT:
				return isFloat();
			case HardwareBaselinePackage.HW_DATA_TYPE__EXECUTION:
				return getExecution();
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
			case HardwareBaselinePackage.HW_DATA_TYPE__BASE_DATA_TYPE:
				setBase_DataType((DataType)newValue);
				return;
			case HardwareBaselinePackage.HW_DATA_TYPE__BIT_LENGTH:
				setBitLength((Integer)newValue);
				return;
			case HardwareBaselinePackage.HW_DATA_TYPE__SIGNED:
				setSigned((Boolean)newValue);
				return;
			case HardwareBaselinePackage.HW_DATA_TYPE__FIXED_POINT:
				setFixedPoint((Boolean)newValue);
				return;
			case HardwareBaselinePackage.HW_DATA_TYPE__FLOAT:
				setFloat((Boolean)newValue);
				return;
			case HardwareBaselinePackage.HW_DATA_TYPE__EXECUTION:
				getExecution().clear();
				getExecution().addAll((Collection<? extends DataTypeExecution>)newValue);
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
			case HardwareBaselinePackage.HW_DATA_TYPE__BASE_DATA_TYPE:
				setBase_DataType((DataType)null);
				return;
			case HardwareBaselinePackage.HW_DATA_TYPE__BIT_LENGTH:
				setBitLength(BIT_LENGTH_EDEFAULT);
				return;
			case HardwareBaselinePackage.HW_DATA_TYPE__SIGNED:
				setSigned(SIGNED_EDEFAULT);
				return;
			case HardwareBaselinePackage.HW_DATA_TYPE__FIXED_POINT:
				setFixedPoint(FIXED_POINT_EDEFAULT);
				return;
			case HardwareBaselinePackage.HW_DATA_TYPE__FLOAT:
				setFloat(FLOAT_EDEFAULT);
				return;
			case HardwareBaselinePackage.HW_DATA_TYPE__EXECUTION:
				getExecution().clear();
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
			case HardwareBaselinePackage.HW_DATA_TYPE__BASE_DATA_TYPE:
				return base_DataType != null;
			case HardwareBaselinePackage.HW_DATA_TYPE__BIT_LENGTH:
				return bitLength != BIT_LENGTH_EDEFAULT;
			case HardwareBaselinePackage.HW_DATA_TYPE__SIGNED:
				return signed != SIGNED_EDEFAULT;
			case HardwareBaselinePackage.HW_DATA_TYPE__FIXED_POINT:
				return fixedPoint != FIXED_POINT_EDEFAULT;
			case HardwareBaselinePackage.HW_DATA_TYPE__FLOAT:
				return float_ != FLOAT_EDEFAULT;
			case HardwareBaselinePackage.HW_DATA_TYPE__EXECUTION:
				return execution != null && !execution.isEmpty();
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
		result.append(" (bitLength: ");
		result.append(bitLength);
		result.append(", signed: ");
		result.append(signed);
		result.append(", fixedPoint: ");
		result.append(fixedPoint);
		result.append(", float: ");
		result.append(float_);
		result.append(')');
		return result.toString();
	}

} //HWDataTypeImpl
