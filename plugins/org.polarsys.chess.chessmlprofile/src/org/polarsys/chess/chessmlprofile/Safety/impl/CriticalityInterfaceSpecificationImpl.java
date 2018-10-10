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
package org.polarsys.chess.chessmlprofile.Safety.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.uml2.uml.Constraint;

import org.polarsys.chess.chessmlprofile.Safety.CriticalityInterfaceSpecification;
import org.polarsys.chess.chessmlprofile.Safety.CriticalityLevel;
import org.polarsys.chess.chessmlprofile.Safety.SafetyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Criticality Interface Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Safety.impl.CriticalityInterfaceSpecificationImpl#getBase_Constraint <em>Base Constraint</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Safety.impl.CriticalityInterfaceSpecificationImpl#getAcceptedCriticalityForClients <em>Accepted Criticality For Clients</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CriticalityInterfaceSpecificationImpl extends EObjectImpl implements CriticalityInterfaceSpecification {
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
	 * The cached value of the '{@link #getAcceptedCriticalityForClients() <em>Accepted Criticality For Clients</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAcceptedCriticalityForClients()
	 * @generated
	 * @ordered
	 */
	protected EList<CriticalityLevel> acceptedCriticalityForClients;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CriticalityInterfaceSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SafetyPackage.Literals.CRITICALITY_INTERFACE_SPECIFICATION;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SafetyPackage.CRITICALITY_INTERFACE_SPECIFICATION__BASE_CONSTRAINT, oldBase_Constraint, base_Constraint));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SafetyPackage.CRITICALITY_INTERFACE_SPECIFICATION__BASE_CONSTRAINT, oldBase_Constraint, base_Constraint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CriticalityLevel> getAcceptedCriticalityForClients() {
		if (acceptedCriticalityForClients == null) {
			acceptedCriticalityForClients = new EObjectResolvingEList<CriticalityLevel>(CriticalityLevel.class, this, SafetyPackage.CRITICALITY_INTERFACE_SPECIFICATION__ACCEPTED_CRITICALITY_FOR_CLIENTS);
		}
		return acceptedCriticalityForClients;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SafetyPackage.CRITICALITY_INTERFACE_SPECIFICATION__BASE_CONSTRAINT:
				if (resolve) return getBase_Constraint();
				return basicGetBase_Constraint();
			case SafetyPackage.CRITICALITY_INTERFACE_SPECIFICATION__ACCEPTED_CRITICALITY_FOR_CLIENTS:
				return getAcceptedCriticalityForClients();
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
			case SafetyPackage.CRITICALITY_INTERFACE_SPECIFICATION__BASE_CONSTRAINT:
				setBase_Constraint((Constraint)newValue);
				return;
			case SafetyPackage.CRITICALITY_INTERFACE_SPECIFICATION__ACCEPTED_CRITICALITY_FOR_CLIENTS:
				getAcceptedCriticalityForClients().clear();
				getAcceptedCriticalityForClients().addAll((Collection<? extends CriticalityLevel>)newValue);
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
			case SafetyPackage.CRITICALITY_INTERFACE_SPECIFICATION__BASE_CONSTRAINT:
				setBase_Constraint((Constraint)null);
				return;
			case SafetyPackage.CRITICALITY_INTERFACE_SPECIFICATION__ACCEPTED_CRITICALITY_FOR_CLIENTS:
				getAcceptedCriticalityForClients().clear();
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
			case SafetyPackage.CRITICALITY_INTERFACE_SPECIFICATION__BASE_CONSTRAINT:
				return base_Constraint != null;
			case SafetyPackage.CRITICALITY_INTERFACE_SPECIFICATION__ACCEPTED_CRITICALITY_FOR_CLIENTS:
				return acceptedCriticalityForClients != null && !acceptedCriticalityForClients.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CriticalityInterfaceSpecificationImpl
