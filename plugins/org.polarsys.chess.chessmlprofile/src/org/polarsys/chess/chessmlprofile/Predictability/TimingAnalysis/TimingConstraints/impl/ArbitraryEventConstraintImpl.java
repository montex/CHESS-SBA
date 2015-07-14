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
package org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.impl.NfpConstraintImpl;
import org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.ArbitraryEventConstraint;
import org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.TimingConstraintsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Arbitrary Event Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.impl.ArbitraryEventConstraintImpl#getOffset <em>Offset</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.impl.ArbitraryEventConstraintImpl#getMaximumInterarrivalTime <em>Maximum Interarrival Time</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.impl.ArbitraryEventConstraintImpl#getMinimumInterarrivalTime <em>Minimum Interarrival Time</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ArbitraryEventConstraintImpl extends NfpConstraintImpl implements ArbitraryEventConstraint {
	/**
	 * The default value of the '{@link #getOffset() <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffset()
	 * @generated
	 * @ordered
	 */
	protected static final String OFFSET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOffset() <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffset()
	 * @generated
	 * @ordered
	 */
	protected String offset = OFFSET_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMaximumInterarrivalTime() <em>Maximum Interarrival Time</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumInterarrivalTime()
	 * @generated
	 * @ordered
	 */
	protected EList<String> maximumInterarrivalTime;

	/**
	 * The cached value of the '{@link #getMinimumInterarrivalTime() <em>Minimum Interarrival Time</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimumInterarrivalTime()
	 * @generated
	 * @ordered
	 */
	protected EList<String> minimumInterarrivalTime;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArbitraryEventConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TimingConstraintsPackage.Literals.ARBITRARY_EVENT_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOffset() {
		return offset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOffset(String newOffset) {
		String oldOffset = offset;
		offset = newOffset;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimingConstraintsPackage.ARBITRARY_EVENT_CONSTRAINT__OFFSET, oldOffset, offset));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getMaximumInterarrivalTime() {
		if (maximumInterarrivalTime == null) {
			maximumInterarrivalTime = new EDataTypeUniqueEList<String>(String.class, this, TimingConstraintsPackage.ARBITRARY_EVENT_CONSTRAINT__MAXIMUM_INTERARRIVAL_TIME);
		}
		return maximumInterarrivalTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getMinimumInterarrivalTime() {
		if (minimumInterarrivalTime == null) {
			minimumInterarrivalTime = new EDataTypeUniqueEList<String>(String.class, this, TimingConstraintsPackage.ARBITRARY_EVENT_CONSTRAINT__MINIMUM_INTERARRIVAL_TIME);
		}
		return minimumInterarrivalTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TimingConstraintsPackage.ARBITRARY_EVENT_CONSTRAINT__OFFSET:
				return getOffset();
			case TimingConstraintsPackage.ARBITRARY_EVENT_CONSTRAINT__MAXIMUM_INTERARRIVAL_TIME:
				return getMaximumInterarrivalTime();
			case TimingConstraintsPackage.ARBITRARY_EVENT_CONSTRAINT__MINIMUM_INTERARRIVAL_TIME:
				return getMinimumInterarrivalTime();
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
			case TimingConstraintsPackage.ARBITRARY_EVENT_CONSTRAINT__OFFSET:
				setOffset((String)newValue);
				return;
			case TimingConstraintsPackage.ARBITRARY_EVENT_CONSTRAINT__MAXIMUM_INTERARRIVAL_TIME:
				getMaximumInterarrivalTime().clear();
				getMaximumInterarrivalTime().addAll((Collection<? extends String>)newValue);
				return;
			case TimingConstraintsPackage.ARBITRARY_EVENT_CONSTRAINT__MINIMUM_INTERARRIVAL_TIME:
				getMinimumInterarrivalTime().clear();
				getMinimumInterarrivalTime().addAll((Collection<? extends String>)newValue);
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
			case TimingConstraintsPackage.ARBITRARY_EVENT_CONSTRAINT__OFFSET:
				setOffset(OFFSET_EDEFAULT);
				return;
			case TimingConstraintsPackage.ARBITRARY_EVENT_CONSTRAINT__MAXIMUM_INTERARRIVAL_TIME:
				getMaximumInterarrivalTime().clear();
				return;
			case TimingConstraintsPackage.ARBITRARY_EVENT_CONSTRAINT__MINIMUM_INTERARRIVAL_TIME:
				getMinimumInterarrivalTime().clear();
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
			case TimingConstraintsPackage.ARBITRARY_EVENT_CONSTRAINT__OFFSET:
				return OFFSET_EDEFAULT == null ? offset != null : !OFFSET_EDEFAULT.equals(offset);
			case TimingConstraintsPackage.ARBITRARY_EVENT_CONSTRAINT__MAXIMUM_INTERARRIVAL_TIME:
				return maximumInterarrivalTime != null && !maximumInterarrivalTime.isEmpty();
			case TimingConstraintsPackage.ARBITRARY_EVENT_CONSTRAINT__MINIMUM_INTERARRIVAL_TIME:
				return minimumInterarrivalTime != null && !minimumInterarrivalTime.isEmpty();
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
		result.append(" (offset: ");
		result.append(offset);
		result.append(", maximumInterarrivalTime: ");
		result.append(maximumInterarrivalTime);
		result.append(", minimumInterarrivalTime: ");
		result.append(minimumInterarrivalTime);
		result.append(')');
		return result.toString();
	}

} //ArbitraryEventConstraintImpl
