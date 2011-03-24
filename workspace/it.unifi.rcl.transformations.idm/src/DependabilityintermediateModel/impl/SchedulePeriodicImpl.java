/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package DependabilityintermediateModel.impl;

import DependabilityintermediateModel.DependabilityintermediateModelPackage;
import DependabilityintermediateModel.Distribution;
import DependabilityintermediateModel.SchedulePeriodic;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Schedule Periodic</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link DependabilityintermediateModel.impl.SchedulePeriodicImpl#getBefore <em>Before</em>}</li>
 *   <li>{@link DependabilityintermediateModel.impl.SchedulePeriodicImpl#getAfter <em>After</em>}</li>
 *   <li>{@link DependabilityintermediateModel.impl.SchedulePeriodicImpl#getDistribution <em>Distribution</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SchedulePeriodicImpl extends SchedulingEventImpl implements SchedulePeriodic {
	/**
	 * The default value of the '{@link #getBefore() <em>Before</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBefore()
	 * @generated
	 * @ordered
	 */
	protected static final double BEFORE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getBefore() <em>Before</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBefore()
	 * @generated
	 * @ordered
	 */
	protected double before = BEFORE_EDEFAULT;

	/**
	 * The default value of the '{@link #getAfter() <em>After</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAfter()
	 * @generated
	 * @ordered
	 */
	protected static final double AFTER_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getAfter() <em>After</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAfter()
	 * @generated
	 * @ordered
	 */
	protected double after = AFTER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDistribution() <em>Distribution</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDistribution()
	 * @generated
	 * @ordered
	 */
	protected Distribution distribution;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SchedulePeriodicImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DependabilityintermediateModelPackage.Literals.SCHEDULE_PERIODIC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getBefore() {
		return before;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBefore(double newBefore) {
		double oldBefore = before;
		before = newBefore;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependabilityintermediateModelPackage.SCHEDULE_PERIODIC__BEFORE, oldBefore, before));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getAfter() {
		return after;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAfter(double newAfter) {
		double oldAfter = after;
		after = newAfter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependabilityintermediateModelPackage.SCHEDULE_PERIODIC__AFTER, oldAfter, after));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Distribution getDistribution() {
		return distribution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDistribution(Distribution newDistribution, NotificationChain msgs) {
		Distribution oldDistribution = distribution;
		distribution = newDistribution;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DependabilityintermediateModelPackage.SCHEDULE_PERIODIC__DISTRIBUTION, oldDistribution, newDistribution);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDistribution(Distribution newDistribution) {
		if (newDistribution != distribution) {
			NotificationChain msgs = null;
			if (distribution != null)
				msgs = ((InternalEObject)distribution).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DependabilityintermediateModelPackage.SCHEDULE_PERIODIC__DISTRIBUTION, null, msgs);
			if (newDistribution != null)
				msgs = ((InternalEObject)newDistribution).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DependabilityintermediateModelPackage.SCHEDULE_PERIODIC__DISTRIBUTION, null, msgs);
			msgs = basicSetDistribution(newDistribution, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependabilityintermediateModelPackage.SCHEDULE_PERIODIC__DISTRIBUTION, newDistribution, newDistribution));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DependabilityintermediateModelPackage.SCHEDULE_PERIODIC__DISTRIBUTION:
				return basicSetDistribution(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DependabilityintermediateModelPackage.SCHEDULE_PERIODIC__BEFORE:
				return getBefore();
			case DependabilityintermediateModelPackage.SCHEDULE_PERIODIC__AFTER:
				return getAfter();
			case DependabilityintermediateModelPackage.SCHEDULE_PERIODIC__DISTRIBUTION:
				return getDistribution();
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
			case DependabilityintermediateModelPackage.SCHEDULE_PERIODIC__BEFORE:
				setBefore((Double)newValue);
				return;
			case DependabilityintermediateModelPackage.SCHEDULE_PERIODIC__AFTER:
				setAfter((Double)newValue);
				return;
			case DependabilityintermediateModelPackage.SCHEDULE_PERIODIC__DISTRIBUTION:
				setDistribution((Distribution)newValue);
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
			case DependabilityintermediateModelPackage.SCHEDULE_PERIODIC__BEFORE:
				setBefore(BEFORE_EDEFAULT);
				return;
			case DependabilityintermediateModelPackage.SCHEDULE_PERIODIC__AFTER:
				setAfter(AFTER_EDEFAULT);
				return;
			case DependabilityintermediateModelPackage.SCHEDULE_PERIODIC__DISTRIBUTION:
				setDistribution((Distribution)null);
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
			case DependabilityintermediateModelPackage.SCHEDULE_PERIODIC__BEFORE:
				return before != BEFORE_EDEFAULT;
			case DependabilityintermediateModelPackage.SCHEDULE_PERIODIC__AFTER:
				return after != AFTER_EDEFAULT;
			case DependabilityintermediateModelPackage.SCHEDULE_PERIODIC__DISTRIBUTION:
				return distribution != null;
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
		result.append(" (Before: ");
		result.append(before);
		result.append(", After: ");
		result.append(after);
		result.append(')');
		return result.toString();
	}

} //SchedulePeriodicImpl
