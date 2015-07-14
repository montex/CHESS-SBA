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
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.ComputeComplexity;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.HardwareBaselinePackage;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.OperationCount;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.SWDataType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Compute Complexity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.ComputeComplexityImpl#getSwDataType <em>Sw Data Type</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.ComputeComplexityImpl#getOpCount <em>Op Count</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.ComputeComplexityImpl#getBase_Class <em>Base Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComputeComplexityImpl extends EObjectImpl implements ComputeComplexity {
	/**
	 * The cached value of the '{@link #getSwDataType() <em>Sw Data Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSwDataType()
	 * @generated
	 * @ordered
	 */
	protected SWDataType swDataType;

	/**
	 * The cached value of the '{@link #getOpCount() <em>Op Count</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOpCount()
	 * @generated
	 * @ordered
	 */
	protected EList<OperationCount> opCount;

	/**
	 * The cached value of the '{@link #getBase_Class() <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Class()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Class base_Class;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComputeComplexityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HardwareBaselinePackage.Literals.COMPUTE_COMPLEXITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SWDataType getSwDataType() {
		if (swDataType != null && swDataType.eIsProxy()) {
			InternalEObject oldSwDataType = (InternalEObject)swDataType;
			swDataType = (SWDataType)eResolveProxy(oldSwDataType);
			if (swDataType != oldSwDataType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, HardwareBaselinePackage.COMPUTE_COMPLEXITY__SW_DATA_TYPE, oldSwDataType, swDataType));
			}
		}
		return swDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SWDataType basicGetSwDataType() {
		return swDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSwDataType(SWDataType newSwDataType) {
		SWDataType oldSwDataType = swDataType;
		swDataType = newSwDataType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HardwareBaselinePackage.COMPUTE_COMPLEXITY__SW_DATA_TYPE, oldSwDataType, swDataType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OperationCount> getOpCount() {
		if (opCount == null) {
			opCount = new EObjectResolvingEList<OperationCount>(OperationCount.class, this, HardwareBaselinePackage.COMPUTE_COMPLEXITY__OP_COUNT);
		}
		return opCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class getBase_Class() {
		if (base_Class != null && base_Class.eIsProxy()) {
			InternalEObject oldBase_Class = (InternalEObject)base_Class;
			base_Class = (org.eclipse.uml2.uml.Class)eResolveProxy(oldBase_Class);
			if (base_Class != oldBase_Class) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, HardwareBaselinePackage.COMPUTE_COMPLEXITY__BASE_CLASS, oldBase_Class, base_Class));
			}
		}
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class basicGetBase_Class() {
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Class(org.eclipse.uml2.uml.Class newBase_Class) {
		org.eclipse.uml2.uml.Class oldBase_Class = base_Class;
		base_Class = newBase_Class;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HardwareBaselinePackage.COMPUTE_COMPLEXITY__BASE_CLASS, oldBase_Class, base_Class));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case HardwareBaselinePackage.COMPUTE_COMPLEXITY__SW_DATA_TYPE:
				if (resolve) return getSwDataType();
				return basicGetSwDataType();
			case HardwareBaselinePackage.COMPUTE_COMPLEXITY__OP_COUNT:
				return getOpCount();
			case HardwareBaselinePackage.COMPUTE_COMPLEXITY__BASE_CLASS:
				if (resolve) return getBase_Class();
				return basicGetBase_Class();
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
			case HardwareBaselinePackage.COMPUTE_COMPLEXITY__SW_DATA_TYPE:
				setSwDataType((SWDataType)newValue);
				return;
			case HardwareBaselinePackage.COMPUTE_COMPLEXITY__OP_COUNT:
				getOpCount().clear();
				getOpCount().addAll((Collection<? extends OperationCount>)newValue);
				return;
			case HardwareBaselinePackage.COMPUTE_COMPLEXITY__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)newValue);
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
			case HardwareBaselinePackage.COMPUTE_COMPLEXITY__SW_DATA_TYPE:
				setSwDataType((SWDataType)null);
				return;
			case HardwareBaselinePackage.COMPUTE_COMPLEXITY__OP_COUNT:
				getOpCount().clear();
				return;
			case HardwareBaselinePackage.COMPUTE_COMPLEXITY__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)null);
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
			case HardwareBaselinePackage.COMPUTE_COMPLEXITY__SW_DATA_TYPE:
				return swDataType != null;
			case HardwareBaselinePackage.COMPUTE_COMPLEXITY__OP_COUNT:
				return opCount != null && !opCount.isEmpty();
			case HardwareBaselinePackage.COMPUTE_COMPLEXITY__BASE_CLASS:
				return base_Class != null;
		}
		return super.eIsSet(featureID);
	}

} //ComputeComplexityImpl
