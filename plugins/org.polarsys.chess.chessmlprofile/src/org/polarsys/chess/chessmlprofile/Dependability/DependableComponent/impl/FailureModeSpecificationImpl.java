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
package org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Port;

import org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponentPackage;
import org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.FailureModeGroup;
import org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.FailureModeSpecification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Failure Mode Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.FailureModeSpecificationImpl#getBase_Constraint <em>Base Constraint</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.FailureModeSpecificationImpl#getBase_Port <em>Base Port</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.FailureModeSpecificationImpl#getFailureModeGroup <em>Failure Mode Group</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FailureModeSpecificationImpl extends EObjectImpl implements FailureModeSpecification {
	/**
	 * The cached value of the '{@link #getBase_Constraint() <em>Base Constraint</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Constraint()
	 * @generated
	 * @ordered
	 */
	protected Constraint base_Constraint;

	/**
	 * The cached value of the '{@link #getBase_Port() <em>Base Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Port()
	 * @generated
	 * @ordered
	 */
	protected Port base_Port;

	/**
	 * The cached value of the '{@link #getFailureModeGroup() <em>Failure Mode Group</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailureModeGroup()
	 * @generated
	 * @ordered
	 */
	protected EList<FailureModeGroup> failureModeGroup;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FailureModeSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DependableComponentPackage.Literals.FAILURE_MODE_SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Constraint getBase_Constraint() {
		if (base_Constraint != null && base_Constraint.eIsProxy()) {
			InternalEObject oldBase_Constraint = (InternalEObject)base_Constraint;
			base_Constraint = (Constraint)eResolveProxy(oldBase_Constraint);
			if (base_Constraint != oldBase_Constraint) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DependableComponentPackage.FAILURE_MODE_SPECIFICATION__BASE_CONSTRAINT, oldBase_Constraint, base_Constraint));
			}
		}
		return base_Constraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Constraint basicGetBase_Constraint() {
		return base_Constraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Constraint(Constraint newBase_Constraint) {
		Constraint oldBase_Constraint = base_Constraint;
		base_Constraint = newBase_Constraint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependableComponentPackage.FAILURE_MODE_SPECIFICATION__BASE_CONSTRAINT, oldBase_Constraint, base_Constraint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port getBase_Port() {
		if (base_Port != null && base_Port.eIsProxy()) {
			InternalEObject oldBase_Port = (InternalEObject)base_Port;
			base_Port = (Port)eResolveProxy(oldBase_Port);
			if (base_Port != oldBase_Port) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DependableComponentPackage.FAILURE_MODE_SPECIFICATION__BASE_PORT, oldBase_Port, base_Port));
			}
		}
		return base_Port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port basicGetBase_Port() {
		return base_Port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Port(Port newBase_Port) {
		Port oldBase_Port = base_Port;
		base_Port = newBase_Port;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependableComponentPackage.FAILURE_MODE_SPECIFICATION__BASE_PORT, oldBase_Port, base_Port));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FailureModeGroup> getFailureModeGroup() {
		if (failureModeGroup == null) {
			failureModeGroup = new EObjectResolvingEList<FailureModeGroup>(FailureModeGroup.class, this, DependableComponentPackage.FAILURE_MODE_SPECIFICATION__FAILURE_MODE_GROUP);
		}
		return failureModeGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DependableComponentPackage.FAILURE_MODE_SPECIFICATION__BASE_CONSTRAINT:
				if (resolve) return getBase_Constraint();
				return basicGetBase_Constraint();
			case DependableComponentPackage.FAILURE_MODE_SPECIFICATION__BASE_PORT:
				if (resolve) return getBase_Port();
				return basicGetBase_Port();
			case DependableComponentPackage.FAILURE_MODE_SPECIFICATION__FAILURE_MODE_GROUP:
				return getFailureModeGroup();
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
			case DependableComponentPackage.FAILURE_MODE_SPECIFICATION__BASE_CONSTRAINT:
				setBase_Constraint((Constraint)newValue);
				return;
			case DependableComponentPackage.FAILURE_MODE_SPECIFICATION__BASE_PORT:
				setBase_Port((Port)newValue);
				return;
			case DependableComponentPackage.FAILURE_MODE_SPECIFICATION__FAILURE_MODE_GROUP:
				getFailureModeGroup().clear();
				getFailureModeGroup().addAll((Collection<? extends FailureModeGroup>)newValue);
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
			case DependableComponentPackage.FAILURE_MODE_SPECIFICATION__BASE_CONSTRAINT:
				setBase_Constraint((Constraint)null);
				return;
			case DependableComponentPackage.FAILURE_MODE_SPECIFICATION__BASE_PORT:
				setBase_Port((Port)null);
				return;
			case DependableComponentPackage.FAILURE_MODE_SPECIFICATION__FAILURE_MODE_GROUP:
				getFailureModeGroup().clear();
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
			case DependableComponentPackage.FAILURE_MODE_SPECIFICATION__BASE_CONSTRAINT:
				return base_Constraint != null;
			case DependableComponentPackage.FAILURE_MODE_SPECIFICATION__BASE_PORT:
				return base_Port != null;
			case DependableComponentPackage.FAILURE_MODE_SPECIFICATION__FAILURE_MODE_GROUP:
				return failureModeGroup != null && !failureModeGroup.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FailureModeSpecificationImpl
