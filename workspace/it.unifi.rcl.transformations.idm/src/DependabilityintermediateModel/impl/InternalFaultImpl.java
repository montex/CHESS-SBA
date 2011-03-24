/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package DependabilityintermediateModel.impl;

import DependabilityintermediateModel.DependabilityintermediateModelPackage;
import DependabilityintermediateModel.Distribution;
import DependabilityintermediateModel.InternalFault;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Internal Fault</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link DependabilityintermediateModel.impl.InternalFaultImpl#getOccurrence <em>Occurrence</em>}</li>
 *   <li>{@link DependabilityintermediateModel.impl.InternalFaultImpl#getPermanentProbability <em>Permanent Probability</em>}</li>
 *   <li>{@link DependabilityintermediateModel.impl.InternalFaultImpl#getTransientDuration <em>Transient Duration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InternalFaultImpl extends FaultImpl implements InternalFault {
	/**
	 * The cached value of the '{@link #getOccurrence() <em>Occurrence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOccurrence()
	 * @generated
	 * @ordered
	 */
	protected Distribution occurrence;

	/**
	 * The default value of the '{@link #getPermanentProbability() <em>Permanent Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPermanentProbability()
	 * @generated
	 * @ordered
	 */
	protected static final double PERMANENT_PROBABILITY_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getPermanentProbability() <em>Permanent Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPermanentProbability()
	 * @generated
	 * @ordered
	 */
	protected double permanentProbability = PERMANENT_PROBABILITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTransientDuration() <em>Transient Duration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransientDuration()
	 * @generated
	 * @ordered
	 */
	protected Distribution transientDuration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InternalFaultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DependabilityintermediateModelPackage.Literals.INTERNAL_FAULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Distribution getOccurrence() {
		return occurrence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOccurrence(Distribution newOccurrence, NotificationChain msgs) {
		Distribution oldOccurrence = occurrence;
		occurrence = newOccurrence;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DependabilityintermediateModelPackage.INTERNAL_FAULT__OCCURRENCE, oldOccurrence, newOccurrence);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOccurrence(Distribution newOccurrence) {
		if (newOccurrence != occurrence) {
			NotificationChain msgs = null;
			if (occurrence != null)
				msgs = ((InternalEObject)occurrence).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DependabilityintermediateModelPackage.INTERNAL_FAULT__OCCURRENCE, null, msgs);
			if (newOccurrence != null)
				msgs = ((InternalEObject)newOccurrence).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DependabilityintermediateModelPackage.INTERNAL_FAULT__OCCURRENCE, null, msgs);
			msgs = basicSetOccurrence(newOccurrence, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependabilityintermediateModelPackage.INTERNAL_FAULT__OCCURRENCE, newOccurrence, newOccurrence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getPermanentProbability() {
		return permanentProbability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPermanentProbability(double newPermanentProbability) {
		double oldPermanentProbability = permanentProbability;
		permanentProbability = newPermanentProbability;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependabilityintermediateModelPackage.INTERNAL_FAULT__PERMANENT_PROBABILITY, oldPermanentProbability, permanentProbability));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Distribution getTransientDuration() {
		return transientDuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTransientDuration(Distribution newTransientDuration, NotificationChain msgs) {
		Distribution oldTransientDuration = transientDuration;
		transientDuration = newTransientDuration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DependabilityintermediateModelPackage.INTERNAL_FAULT__TRANSIENT_DURATION, oldTransientDuration, newTransientDuration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransientDuration(Distribution newTransientDuration) {
		if (newTransientDuration != transientDuration) {
			NotificationChain msgs = null;
			if (transientDuration != null)
				msgs = ((InternalEObject)transientDuration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DependabilityintermediateModelPackage.INTERNAL_FAULT__TRANSIENT_DURATION, null, msgs);
			if (newTransientDuration != null)
				msgs = ((InternalEObject)newTransientDuration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DependabilityintermediateModelPackage.INTERNAL_FAULT__TRANSIENT_DURATION, null, msgs);
			msgs = basicSetTransientDuration(newTransientDuration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependabilityintermediateModelPackage.INTERNAL_FAULT__TRANSIENT_DURATION, newTransientDuration, newTransientDuration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DependabilityintermediateModelPackage.INTERNAL_FAULT__OCCURRENCE:
				return basicSetOccurrence(null, msgs);
			case DependabilityintermediateModelPackage.INTERNAL_FAULT__TRANSIENT_DURATION:
				return basicSetTransientDuration(null, msgs);
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
			case DependabilityintermediateModelPackage.INTERNAL_FAULT__OCCURRENCE:
				return getOccurrence();
			case DependabilityintermediateModelPackage.INTERNAL_FAULT__PERMANENT_PROBABILITY:
				return getPermanentProbability();
			case DependabilityintermediateModelPackage.INTERNAL_FAULT__TRANSIENT_DURATION:
				return getTransientDuration();
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
			case DependabilityintermediateModelPackage.INTERNAL_FAULT__OCCURRENCE:
				setOccurrence((Distribution)newValue);
				return;
			case DependabilityintermediateModelPackage.INTERNAL_FAULT__PERMANENT_PROBABILITY:
				setPermanentProbability((Double)newValue);
				return;
			case DependabilityintermediateModelPackage.INTERNAL_FAULT__TRANSIENT_DURATION:
				setTransientDuration((Distribution)newValue);
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
			case DependabilityintermediateModelPackage.INTERNAL_FAULT__OCCURRENCE:
				setOccurrence((Distribution)null);
				return;
			case DependabilityintermediateModelPackage.INTERNAL_FAULT__PERMANENT_PROBABILITY:
				setPermanentProbability(PERMANENT_PROBABILITY_EDEFAULT);
				return;
			case DependabilityintermediateModelPackage.INTERNAL_FAULT__TRANSIENT_DURATION:
				setTransientDuration((Distribution)null);
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
			case DependabilityintermediateModelPackage.INTERNAL_FAULT__OCCURRENCE:
				return occurrence != null;
			case DependabilityintermediateModelPackage.INTERNAL_FAULT__PERMANENT_PROBABILITY:
				return permanentProbability != PERMANENT_PROBABILITY_EDEFAULT;
			case DependabilityintermediateModelPackage.INTERNAL_FAULT__TRANSIENT_DURATION:
				return transientDuration != null;
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
		result.append(" (PermanentProbability: ");
		result.append(permanentProbability);
		result.append(')');
		return result.toString();
	}

} //InternalFaultImpl
