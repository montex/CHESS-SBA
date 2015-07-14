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
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.BasicOperation;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.DataTypeExecution;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.HardwareBaselinePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Type Execution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.DataTypeExecutionImpl#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.DataTypeExecutionImpl#getOperation <em>Operation</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.DataTypeExecutionImpl#getExecutionCycles <em>Execution Cycles</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataTypeExecutionImpl extends EObjectImpl implements DataTypeExecution {
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
	 * The default value of the '{@link #getOperation() <em>Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperation()
	 * @generated
	 * @ordered
	 */
	protected static final BasicOperation OPERATION_EDEFAULT = BasicOperation.ADD;

	/**
	 * The cached value of the '{@link #getOperation() <em>Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperation()
	 * @generated
	 * @ordered
	 */
	protected BasicOperation operation = OPERATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getExecutionCycles() <em>Execution Cycles</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutionCycles()
	 * @generated
	 * @ordered
	 */
	protected static final int EXECUTION_CYCLES_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getExecutionCycles() <em>Execution Cycles</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutionCycles()
	 * @generated
	 * @ordered
	 */
	protected int executionCycles = EXECUTION_CYCLES_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataTypeExecutionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HardwareBaselinePackage.Literals.DATA_TYPE_EXECUTION;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, HardwareBaselinePackage.DATA_TYPE_EXECUTION__BASE_CLASS, oldBase_Class, base_Class));
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
			eNotify(new ENotificationImpl(this, Notification.SET, HardwareBaselinePackage.DATA_TYPE_EXECUTION__BASE_CLASS, oldBase_Class, base_Class));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicOperation getOperation() {
		return operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperation(BasicOperation newOperation) {
		BasicOperation oldOperation = operation;
		operation = newOperation == null ? OPERATION_EDEFAULT : newOperation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HardwareBaselinePackage.DATA_TYPE_EXECUTION__OPERATION, oldOperation, operation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getExecutionCycles() {
		return executionCycles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExecutionCycles(int newExecutionCycles) {
		int oldExecutionCycles = executionCycles;
		executionCycles = newExecutionCycles;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HardwareBaselinePackage.DATA_TYPE_EXECUTION__EXECUTION_CYCLES, oldExecutionCycles, executionCycles));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case HardwareBaselinePackage.DATA_TYPE_EXECUTION__BASE_CLASS:
				if (resolve) return getBase_Class();
				return basicGetBase_Class();
			case HardwareBaselinePackage.DATA_TYPE_EXECUTION__OPERATION:
				return getOperation();
			case HardwareBaselinePackage.DATA_TYPE_EXECUTION__EXECUTION_CYCLES:
				return getExecutionCycles();
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
			case HardwareBaselinePackage.DATA_TYPE_EXECUTION__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)newValue);
				return;
			case HardwareBaselinePackage.DATA_TYPE_EXECUTION__OPERATION:
				setOperation((BasicOperation)newValue);
				return;
			case HardwareBaselinePackage.DATA_TYPE_EXECUTION__EXECUTION_CYCLES:
				setExecutionCycles((Integer)newValue);
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
			case HardwareBaselinePackage.DATA_TYPE_EXECUTION__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)null);
				return;
			case HardwareBaselinePackage.DATA_TYPE_EXECUTION__OPERATION:
				setOperation(OPERATION_EDEFAULT);
				return;
			case HardwareBaselinePackage.DATA_TYPE_EXECUTION__EXECUTION_CYCLES:
				setExecutionCycles(EXECUTION_CYCLES_EDEFAULT);
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
			case HardwareBaselinePackage.DATA_TYPE_EXECUTION__BASE_CLASS:
				return base_Class != null;
			case HardwareBaselinePackage.DATA_TYPE_EXECUTION__OPERATION:
				return operation != OPERATION_EDEFAULT;
			case HardwareBaselinePackage.DATA_TYPE_EXECUTION__EXECUTION_CYCLES:
				return executionCycles != EXECUTION_CYCLES_EDEFAULT;
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
		result.append(" (operation: ");
		result.append(operation);
		result.append(", executionCycles: ");
		result.append(executionCycles);
		result.append(')');
		return result.toString();
	}

} //DataTypeExecutionImpl
