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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.impl.NfpConstraintImpl;
import org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.PeriodicEventConstraint;
import org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.TimingConstraintsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Periodic Event Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.impl.PeriodicEventConstraintImpl#getOffset <em>Offset</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.impl.PeriodicEventConstraintImpl#getJitter <em>Jitter</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.impl.PeriodicEventConstraintImpl#getMinimumInterarrivalTime <em>Minimum Interarrival Time</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.impl.PeriodicEventConstraintImpl#getPeriod <em>Period</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PeriodicEventConstraintImpl extends NfpConstraintImpl implements PeriodicEventConstraint {
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
	 * The default value of the '{@link #getJitter() <em>Jitter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJitter()
	 * @generated
	 * @ordered
	 */
	protected static final String JITTER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getJitter() <em>Jitter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJitter()
	 * @generated
	 * @ordered
	 */
	protected String jitter = JITTER_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinimumInterarrivalTime() <em>Minimum Interarrival Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimumInterarrivalTime()
	 * @generated
	 * @ordered
	 */
	protected static final String MINIMUM_INTERARRIVAL_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMinimumInterarrivalTime() <em>Minimum Interarrival Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimumInterarrivalTime()
	 * @generated
	 * @ordered
	 */
	protected String minimumInterarrivalTime = MINIMUM_INTERARRIVAL_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPeriod() <em>Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPeriod()
	 * @generated
	 * @ordered
	 */
	protected static final String PERIOD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPeriod() <em>Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPeriod()
	 * @generated
	 * @ordered
	 */
	protected String period = PERIOD_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PeriodicEventConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TimingConstraintsPackage.Literals.PERIODIC_EVENT_CONSTRAINT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, TimingConstraintsPackage.PERIODIC_EVENT_CONSTRAINT__OFFSET, oldOffset, offset));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getJitter() {
		return jitter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJitter(String newJitter) {
		String oldJitter = jitter;
		jitter = newJitter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimingConstraintsPackage.PERIODIC_EVENT_CONSTRAINT__JITTER, oldJitter, jitter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMinimumInterarrivalTime() {
		return minimumInterarrivalTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimumInterarrivalTime(String newMinimumInterarrivalTime) {
		String oldMinimumInterarrivalTime = minimumInterarrivalTime;
		minimumInterarrivalTime = newMinimumInterarrivalTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimingConstraintsPackage.PERIODIC_EVENT_CONSTRAINT__MINIMUM_INTERARRIVAL_TIME, oldMinimumInterarrivalTime, minimumInterarrivalTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPeriod() {
		return period;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPeriod(String newPeriod) {
		String oldPeriod = period;
		period = newPeriod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimingConstraintsPackage.PERIODIC_EVENT_CONSTRAINT__PERIOD, oldPeriod, period));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TimingConstraintsPackage.PERIODIC_EVENT_CONSTRAINT__OFFSET:
				return getOffset();
			case TimingConstraintsPackage.PERIODIC_EVENT_CONSTRAINT__JITTER:
				return getJitter();
			case TimingConstraintsPackage.PERIODIC_EVENT_CONSTRAINT__MINIMUM_INTERARRIVAL_TIME:
				return getMinimumInterarrivalTime();
			case TimingConstraintsPackage.PERIODIC_EVENT_CONSTRAINT__PERIOD:
				return getPeriod();
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
			case TimingConstraintsPackage.PERIODIC_EVENT_CONSTRAINT__OFFSET:
				setOffset((String)newValue);
				return;
			case TimingConstraintsPackage.PERIODIC_EVENT_CONSTRAINT__JITTER:
				setJitter((String)newValue);
				return;
			case TimingConstraintsPackage.PERIODIC_EVENT_CONSTRAINT__MINIMUM_INTERARRIVAL_TIME:
				setMinimumInterarrivalTime((String)newValue);
				return;
			case TimingConstraintsPackage.PERIODIC_EVENT_CONSTRAINT__PERIOD:
				setPeriod((String)newValue);
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
			case TimingConstraintsPackage.PERIODIC_EVENT_CONSTRAINT__OFFSET:
				setOffset(OFFSET_EDEFAULT);
				return;
			case TimingConstraintsPackage.PERIODIC_EVENT_CONSTRAINT__JITTER:
				setJitter(JITTER_EDEFAULT);
				return;
			case TimingConstraintsPackage.PERIODIC_EVENT_CONSTRAINT__MINIMUM_INTERARRIVAL_TIME:
				setMinimumInterarrivalTime(MINIMUM_INTERARRIVAL_TIME_EDEFAULT);
				return;
			case TimingConstraintsPackage.PERIODIC_EVENT_CONSTRAINT__PERIOD:
				setPeriod(PERIOD_EDEFAULT);
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
			case TimingConstraintsPackage.PERIODIC_EVENT_CONSTRAINT__OFFSET:
				return OFFSET_EDEFAULT == null ? offset != null : !OFFSET_EDEFAULT.equals(offset);
			case TimingConstraintsPackage.PERIODIC_EVENT_CONSTRAINT__JITTER:
				return JITTER_EDEFAULT == null ? jitter != null : !JITTER_EDEFAULT.equals(jitter);
			case TimingConstraintsPackage.PERIODIC_EVENT_CONSTRAINT__MINIMUM_INTERARRIVAL_TIME:
				return MINIMUM_INTERARRIVAL_TIME_EDEFAULT == null ? minimumInterarrivalTime != null : !MINIMUM_INTERARRIVAL_TIME_EDEFAULT.equals(minimumInterarrivalTime);
			case TimingConstraintsPackage.PERIODIC_EVENT_CONSTRAINT__PERIOD:
				return PERIOD_EDEFAULT == null ? period != null : !PERIOD_EDEFAULT.equals(period);
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
		result.append(", jitter: ");
		result.append(jitter);
		result.append(", minimumInterarrivalTime: ");
		result.append(minimumInterarrivalTime);
		result.append(", period: ");
		result.append(period);
		result.append(')');
		return result.toString();
	}

} //PeriodicEventConstraintImpl
