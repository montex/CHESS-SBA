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

import org.polarsys.chess.chessmlprofile.Safety.CriticalityLevel;
import org.polarsys.chess.chessmlprofile.Safety.SafetyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Criticality Level</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Safety.impl.CriticalityLevelImpl#getBase_Constraint <em>Base Constraint</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Safety.impl.CriticalityLevelImpl#getIsHigherThan <em>Is Higher Than</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Safety.impl.CriticalityLevelImpl#getMapsTo <em>Maps To</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CriticalityLevelImpl extends EObjectImpl implements CriticalityLevel {
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
	 * The cached value of the '{@link #getIsHigherThan() <em>Is Higher Than</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsHigherThan()
	 * @generated
	 * @ordered
	 */
	protected EList<CriticalityLevel> isHigherThan;

	/**
	 * The cached value of the '{@link #getMapsTo() <em>Maps To</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMapsTo()
	 * @generated
	 * @ordered
	 */
	protected EList<CriticalityLevel> mapsTo;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CriticalityLevelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SafetyPackage.Literals.CRITICALITY_LEVEL;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SafetyPackage.CRITICALITY_LEVEL__BASE_CONSTRAINT, oldBase_Constraint, base_Constraint));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SafetyPackage.CRITICALITY_LEVEL__BASE_CONSTRAINT, oldBase_Constraint, base_Constraint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CriticalityLevel> getIsHigherThan() {
		if (isHigherThan == null) {
			isHigherThan = new EObjectResolvingEList<CriticalityLevel>(CriticalityLevel.class, this, SafetyPackage.CRITICALITY_LEVEL__IS_HIGHER_THAN);
		}
		return isHigherThan;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CriticalityLevel> getMapsTo() {
		if (mapsTo == null) {
			mapsTo = new EObjectResolvingEList<CriticalityLevel>(CriticalityLevel.class, this, SafetyPackage.CRITICALITY_LEVEL__MAPS_TO);
		}
		return mapsTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SafetyPackage.CRITICALITY_LEVEL__BASE_CONSTRAINT:
				if (resolve) return getBase_Constraint();
				return basicGetBase_Constraint();
			case SafetyPackage.CRITICALITY_LEVEL__IS_HIGHER_THAN:
				return getIsHigherThan();
			case SafetyPackage.CRITICALITY_LEVEL__MAPS_TO:
				return getMapsTo();
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
			case SafetyPackage.CRITICALITY_LEVEL__BASE_CONSTRAINT:
				setBase_Constraint((Constraint)newValue);
				return;
			case SafetyPackage.CRITICALITY_LEVEL__IS_HIGHER_THAN:
				getIsHigherThan().clear();
				getIsHigherThan().addAll((Collection<? extends CriticalityLevel>)newValue);
				return;
			case SafetyPackage.CRITICALITY_LEVEL__MAPS_TO:
				getMapsTo().clear();
				getMapsTo().addAll((Collection<? extends CriticalityLevel>)newValue);
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
			case SafetyPackage.CRITICALITY_LEVEL__BASE_CONSTRAINT:
				setBase_Constraint((Constraint)null);
				return;
			case SafetyPackage.CRITICALITY_LEVEL__IS_HIGHER_THAN:
				getIsHigherThan().clear();
				return;
			case SafetyPackage.CRITICALITY_LEVEL__MAPS_TO:
				getMapsTo().clear();
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
			case SafetyPackage.CRITICALITY_LEVEL__BASE_CONSTRAINT:
				return base_Constraint != null;
			case SafetyPackage.CRITICALITY_LEVEL__IS_HIGHER_THAN:
				return isHigherThan != null && !isHigherThan.isEmpty();
			case SafetyPackage.CRITICALITY_LEVEL__MAPS_TO:
				return mapsTo != null && !mapsTo.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CriticalityLevelImpl
