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
package org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.Activity;
import org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MMActivities;
import org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MaintenanceMonitoringPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MM Activities</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.impl.MMActivitiesImpl#getBase_Activity <em>Base Activity</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.impl.MMActivitiesImpl#getWhen <em>When</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.impl.MMActivitiesImpl#getDuration <em>Duration</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.impl.MMActivitiesImpl#getProbSuccess <em>Prob Success</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.impl.MMActivitiesImpl#getOnCompletion <em>On Completion</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.impl.MMActivitiesImpl#getOnSuccessfulCompletion <em>On Successful Completion</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.impl.MMActivitiesImpl#getOnFailedCompletion <em>On Failed Completion</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.impl.MMActivitiesImpl#getBase_Action <em>Base Action</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MMActivitiesImpl extends EObjectImpl implements MMActivities {
	/**
	 * The cached value of the '{@link #getBase_Activity() <em>Base Activity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Activity()
	 * @generated
	 * @ordered
	 */
	protected Activity base_Activity;

	/**
	 * The default value of the '{@link #getWhen() <em>When</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWhen()
	 * @generated
	 * @ordered
	 */
	protected static final String WHEN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWhen() <em>When</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWhen()
	 * @generated
	 * @ordered
	 */
	protected String when = WHEN_EDEFAULT;

	/**
	 * The default value of the '{@link #getDuration() <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDuration()
	 * @generated
	 * @ordered
	 */
	protected static final String DURATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDuration() <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDuration()
	 * @generated
	 * @ordered
	 */
	protected String duration = DURATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getProbSuccess() <em>Prob Success</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProbSuccess()
	 * @generated
	 * @ordered
	 */
	protected static final String PROB_SUCCESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProbSuccess() <em>Prob Success</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProbSuccess()
	 * @generated
	 * @ordered
	 */
	protected String probSuccess = PROB_SUCCESS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOnCompletion() <em>On Completion</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnCompletion()
	 * @generated
	 * @ordered
	 */
	protected EList<Activity> onCompletion;

	/**
	 * The cached value of the '{@link #getOnSuccessfulCompletion() <em>On Successful Completion</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnSuccessfulCompletion()
	 * @generated
	 * @ordered
	 */
	protected EList<Activity> onSuccessfulCompletion;

	/**
	 * The cached value of the '{@link #getOnFailedCompletion() <em>On Failed Completion</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnFailedCompletion()
	 * @generated
	 * @ordered
	 */
	protected EList<Activity> onFailedCompletion;

	/**
	 * The cached value of the '{@link #getBase_Action() <em>Base Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Action()
	 * @generated
	 * @ordered
	 */
	protected Action base_Action;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MMActivitiesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MaintenanceMonitoringPackage.Literals.MM_ACTIVITIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Activity getBase_Activity() {
		if (base_Activity != null && base_Activity.eIsProxy()) {
			InternalEObject oldBase_Activity = (InternalEObject)base_Activity;
			base_Activity = (Activity)eResolveProxy(oldBase_Activity);
			if (base_Activity != oldBase_Activity) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MaintenanceMonitoringPackage.MM_ACTIVITIES__BASE_ACTIVITY, oldBase_Activity, base_Activity));
			}
		}
		return base_Activity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Activity basicGetBase_Activity() {
		return base_Activity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Activity(Activity newBase_Activity) {
		Activity oldBase_Activity = base_Activity;
		base_Activity = newBase_Activity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MaintenanceMonitoringPackage.MM_ACTIVITIES__BASE_ACTIVITY, oldBase_Activity, base_Activity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWhen() {
		return when;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWhen(String newWhen) {
		String oldWhen = when;
		when = newWhen;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MaintenanceMonitoringPackage.MM_ACTIVITIES__WHEN, oldWhen, when));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDuration() {
		return duration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDuration(String newDuration) {
		String oldDuration = duration;
		duration = newDuration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MaintenanceMonitoringPackage.MM_ACTIVITIES__DURATION, oldDuration, duration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProbSuccess() {
		return probSuccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProbSuccess(String newProbSuccess) {
		String oldProbSuccess = probSuccess;
		probSuccess = newProbSuccess;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MaintenanceMonitoringPackage.MM_ACTIVITIES__PROB_SUCCESS, oldProbSuccess, probSuccess));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Activity> getOnCompletion() {
		if (onCompletion == null) {
			onCompletion = new EObjectResolvingEList<Activity>(Activity.class, this, MaintenanceMonitoringPackage.MM_ACTIVITIES__ON_COMPLETION);
		}
		return onCompletion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Activity getOnCompletion(String name) {
		return getOnCompletion(name, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Activity getOnCompletion(String name, boolean ignoreCase) {
		onCompletionLoop: for (Activity onCompletion : getOnCompletion()) {
			if (name != null && !(ignoreCase ? name.equalsIgnoreCase(onCompletion.getName()) : name.equals(onCompletion.getName())))
				continue onCompletionLoop;
			return onCompletion;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Activity> getOnSuccessfulCompletion() {
		if (onSuccessfulCompletion == null) {
			onSuccessfulCompletion = new EObjectResolvingEList<Activity>(Activity.class, this, MaintenanceMonitoringPackage.MM_ACTIVITIES__ON_SUCCESSFUL_COMPLETION);
		}
		return onSuccessfulCompletion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Activity getOnSuccessfulCompletion(String name) {
		return getOnSuccessfulCompletion(name, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Activity getOnSuccessfulCompletion(String name, boolean ignoreCase) {
		onSuccessfulCompletionLoop: for (Activity onSuccessfulCompletion : getOnSuccessfulCompletion()) {
			if (name != null && !(ignoreCase ? name.equalsIgnoreCase(onSuccessfulCompletion.getName()) : name.equals(onSuccessfulCompletion.getName())))
				continue onSuccessfulCompletionLoop;
			return onSuccessfulCompletion;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Activity> getOnFailedCompletion() {
		if (onFailedCompletion == null) {
			onFailedCompletion = new EObjectResolvingEList<Activity>(Activity.class, this, MaintenanceMonitoringPackage.MM_ACTIVITIES__ON_FAILED_COMPLETION);
		}
		return onFailedCompletion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Activity getOnFailedCompletion(String name) {
		return getOnFailedCompletion(name, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Activity getOnFailedCompletion(String name, boolean ignoreCase) {
		onFailedCompletionLoop: for (Activity onFailedCompletion : getOnFailedCompletion()) {
			if (name != null && !(ignoreCase ? name.equalsIgnoreCase(onFailedCompletion.getName()) : name.equals(onFailedCompletion.getName())))
				continue onFailedCompletionLoop;
			return onFailedCompletion;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action getBase_Action() {
		if (base_Action != null && base_Action.eIsProxy()) {
			InternalEObject oldBase_Action = (InternalEObject)base_Action;
			base_Action = (Action)eResolveProxy(oldBase_Action);
			if (base_Action != oldBase_Action) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MaintenanceMonitoringPackage.MM_ACTIVITIES__BASE_ACTION, oldBase_Action, base_Action));
			}
		}
		return base_Action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action basicGetBase_Action() {
		return base_Action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Action(Action newBase_Action) {
		Action oldBase_Action = base_Action;
		base_Action = newBase_Action;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MaintenanceMonitoringPackage.MM_ACTIVITIES__BASE_ACTION, oldBase_Action, base_Action));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MaintenanceMonitoringPackage.MM_ACTIVITIES__BASE_ACTIVITY:
				if (resolve) return getBase_Activity();
				return basicGetBase_Activity();
			case MaintenanceMonitoringPackage.MM_ACTIVITIES__WHEN:
				return getWhen();
			case MaintenanceMonitoringPackage.MM_ACTIVITIES__DURATION:
				return getDuration();
			case MaintenanceMonitoringPackage.MM_ACTIVITIES__PROB_SUCCESS:
				return getProbSuccess();
			case MaintenanceMonitoringPackage.MM_ACTIVITIES__ON_COMPLETION:
				return getOnCompletion();
			case MaintenanceMonitoringPackage.MM_ACTIVITIES__ON_SUCCESSFUL_COMPLETION:
				return getOnSuccessfulCompletion();
			case MaintenanceMonitoringPackage.MM_ACTIVITIES__ON_FAILED_COMPLETION:
				return getOnFailedCompletion();
			case MaintenanceMonitoringPackage.MM_ACTIVITIES__BASE_ACTION:
				if (resolve) return getBase_Action();
				return basicGetBase_Action();
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
			case MaintenanceMonitoringPackage.MM_ACTIVITIES__BASE_ACTIVITY:
				setBase_Activity((Activity)newValue);
				return;
			case MaintenanceMonitoringPackage.MM_ACTIVITIES__WHEN:
				setWhen((String)newValue);
				return;
			case MaintenanceMonitoringPackage.MM_ACTIVITIES__DURATION:
				setDuration((String)newValue);
				return;
			case MaintenanceMonitoringPackage.MM_ACTIVITIES__PROB_SUCCESS:
				setProbSuccess((String)newValue);
				return;
			case MaintenanceMonitoringPackage.MM_ACTIVITIES__ON_COMPLETION:
				getOnCompletion().clear();
				getOnCompletion().addAll((Collection<? extends Activity>)newValue);
				return;
			case MaintenanceMonitoringPackage.MM_ACTIVITIES__ON_SUCCESSFUL_COMPLETION:
				getOnSuccessfulCompletion().clear();
				getOnSuccessfulCompletion().addAll((Collection<? extends Activity>)newValue);
				return;
			case MaintenanceMonitoringPackage.MM_ACTIVITIES__ON_FAILED_COMPLETION:
				getOnFailedCompletion().clear();
				getOnFailedCompletion().addAll((Collection<? extends Activity>)newValue);
				return;
			case MaintenanceMonitoringPackage.MM_ACTIVITIES__BASE_ACTION:
				setBase_Action((Action)newValue);
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
			case MaintenanceMonitoringPackage.MM_ACTIVITIES__BASE_ACTIVITY:
				setBase_Activity((Activity)null);
				return;
			case MaintenanceMonitoringPackage.MM_ACTIVITIES__WHEN:
				setWhen(WHEN_EDEFAULT);
				return;
			case MaintenanceMonitoringPackage.MM_ACTIVITIES__DURATION:
				setDuration(DURATION_EDEFAULT);
				return;
			case MaintenanceMonitoringPackage.MM_ACTIVITIES__PROB_SUCCESS:
				setProbSuccess(PROB_SUCCESS_EDEFAULT);
				return;
			case MaintenanceMonitoringPackage.MM_ACTIVITIES__ON_COMPLETION:
				getOnCompletion().clear();
				return;
			case MaintenanceMonitoringPackage.MM_ACTIVITIES__ON_SUCCESSFUL_COMPLETION:
				getOnSuccessfulCompletion().clear();
				return;
			case MaintenanceMonitoringPackage.MM_ACTIVITIES__ON_FAILED_COMPLETION:
				getOnFailedCompletion().clear();
				return;
			case MaintenanceMonitoringPackage.MM_ACTIVITIES__BASE_ACTION:
				setBase_Action((Action)null);
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
			case MaintenanceMonitoringPackage.MM_ACTIVITIES__BASE_ACTIVITY:
				return base_Activity != null;
			case MaintenanceMonitoringPackage.MM_ACTIVITIES__WHEN:
				return WHEN_EDEFAULT == null ? when != null : !WHEN_EDEFAULT.equals(when);
			case MaintenanceMonitoringPackage.MM_ACTIVITIES__DURATION:
				return DURATION_EDEFAULT == null ? duration != null : !DURATION_EDEFAULT.equals(duration);
			case MaintenanceMonitoringPackage.MM_ACTIVITIES__PROB_SUCCESS:
				return PROB_SUCCESS_EDEFAULT == null ? probSuccess != null : !PROB_SUCCESS_EDEFAULT.equals(probSuccess);
			case MaintenanceMonitoringPackage.MM_ACTIVITIES__ON_COMPLETION:
				return onCompletion != null && !onCompletion.isEmpty();
			case MaintenanceMonitoringPackage.MM_ACTIVITIES__ON_SUCCESSFUL_COMPLETION:
				return onSuccessfulCompletion != null && !onSuccessfulCompletion.isEmpty();
			case MaintenanceMonitoringPackage.MM_ACTIVITIES__ON_FAILED_COMPLETION:
				return onFailedCompletion != null && !onFailedCompletion.isEmpty();
			case MaintenanceMonitoringPackage.MM_ACTIVITIES__BASE_ACTION:
				return base_Action != null;
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
		result.append(" (when: ");
		result.append(when);
		result.append(", duration: ");
		result.append(duration);
		result.append(", probSuccess: ");
		result.append(probSuccess);
		result.append(')');
		return result.toString();
	}

} //MMActivitiesImpl
