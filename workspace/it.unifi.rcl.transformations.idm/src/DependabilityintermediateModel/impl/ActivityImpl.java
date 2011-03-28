/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package DependabilityintermediateModel.impl;

import DependabilityintermediateModel.Activity;
import DependabilityintermediateModel.Component;
import DependabilityintermediateModel.DependabilityintermediateModelPackage;
import DependabilityintermediateModel.Distribution;
import DependabilityintermediateModel.SchedulingEvent;
import DependabilityintermediateModel.Sistema;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Activity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link DependabilityintermediateModel.impl.ActivityImpl#getDuration <em>Duration</em>}</li>
 *   <li>{@link DependabilityintermediateModel.impl.ActivityImpl#getWhen <em>When</em>}</li>
 *   <li>{@link DependabilityintermediateModel.impl.ActivityImpl#getComponent <em>Component</em>}</li>
 *   <li>{@link DependabilityintermediateModel.impl.ActivityImpl#getSistema <em>Sistema</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ActivityImpl extends NamedElementImpl implements Activity {
	/**
	 * The cached value of the '{@link #getDuration() <em>Duration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDuration()
	 * @generated
	 * @ordered
	 */
	protected Distribution duration;

	/**
	 * The cached value of the '{@link #getWhen() <em>When</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWhen()
	 * @generated
	 * @ordered
	 */
	protected SchedulingEvent when;

	/**
	 * The cached value of the '{@link #getComponent() <em>Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponent()
	 * @generated
	 * @ordered
	 */
	protected Component component;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActivityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DependabilityintermediateModelPackage.Literals.ACTIVITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Distribution getDuration() {
		return duration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDuration(Distribution newDuration, NotificationChain msgs) {
		Distribution oldDuration = duration;
		duration = newDuration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DependabilityintermediateModelPackage.ACTIVITY__DURATION, oldDuration, newDuration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDuration(Distribution newDuration) {
		if (newDuration != duration) {
			NotificationChain msgs = null;
			if (duration != null)
				msgs = ((InternalEObject)duration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DependabilityintermediateModelPackage.ACTIVITY__DURATION, null, msgs);
			if (newDuration != null)
				msgs = ((InternalEObject)newDuration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DependabilityintermediateModelPackage.ACTIVITY__DURATION, null, msgs);
			msgs = basicSetDuration(newDuration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependabilityintermediateModelPackage.ACTIVITY__DURATION, newDuration, newDuration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulingEvent getWhen() {
		return when;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWhen(SchedulingEvent newWhen, NotificationChain msgs) {
		SchedulingEvent oldWhen = when;
		when = newWhen;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DependabilityintermediateModelPackage.ACTIVITY__WHEN, oldWhen, newWhen);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWhen(SchedulingEvent newWhen) {
		if (newWhen != when) {
			NotificationChain msgs = null;
			if (when != null)
				msgs = ((InternalEObject)when).eInverseRemove(this, DependabilityintermediateModelPackage.SCHEDULING_EVENT__ACTIVITY, SchedulingEvent.class, msgs);
			if (newWhen != null)
				msgs = ((InternalEObject)newWhen).eInverseAdd(this, DependabilityintermediateModelPackage.SCHEDULING_EVENT__ACTIVITY, SchedulingEvent.class, msgs);
			msgs = basicSetWhen(newWhen, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependabilityintermediateModelPackage.ACTIVITY__WHEN, newWhen, newWhen));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component getComponent() {
		if (component != null && component.eIsProxy()) {
			InternalEObject oldComponent = (InternalEObject)component;
			component = (Component)eResolveProxy(oldComponent);
			if (component != oldComponent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DependabilityintermediateModelPackage.ACTIVITY__COMPONENT, oldComponent, component));
			}
		}
		return component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component basicGetComponent() {
		return component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponent(Component newComponent) {
		Component oldComponent = component;
		component = newComponent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependabilityintermediateModelPackage.ACTIVITY__COMPONENT, oldComponent, component));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sistema getSistema() {
		if (eContainerFeatureID() != DependabilityintermediateModelPackage.ACTIVITY__SISTEMA) return null;
		return (Sistema)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSistema(Sistema newSistema, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSistema, DependabilityintermediateModelPackage.ACTIVITY__SISTEMA, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSistema(Sistema newSistema) {
		if (newSistema != eInternalContainer() || (eContainerFeatureID() != DependabilityintermediateModelPackage.ACTIVITY__SISTEMA && newSistema != null)) {
			if (EcoreUtil.isAncestor(this, newSistema))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSistema != null)
				msgs = ((InternalEObject)newSistema).eInverseAdd(this, DependabilityintermediateModelPackage.SISTEMA__ACTIVITIES, Sistema.class, msgs);
			msgs = basicSetSistema(newSistema, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependabilityintermediateModelPackage.ACTIVITY__SISTEMA, newSistema, newSistema));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DependabilityintermediateModelPackage.ACTIVITY__WHEN:
				if (when != null)
					msgs = ((InternalEObject)when).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DependabilityintermediateModelPackage.ACTIVITY__WHEN, null, msgs);
				return basicSetWhen((SchedulingEvent)otherEnd, msgs);
			case DependabilityintermediateModelPackage.ACTIVITY__SISTEMA:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSistema((Sistema)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DependabilityintermediateModelPackage.ACTIVITY__DURATION:
				return basicSetDuration(null, msgs);
			case DependabilityintermediateModelPackage.ACTIVITY__WHEN:
				return basicSetWhen(null, msgs);
			case DependabilityintermediateModelPackage.ACTIVITY__SISTEMA:
				return basicSetSistema(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case DependabilityintermediateModelPackage.ACTIVITY__SISTEMA:
				return eInternalContainer().eInverseRemove(this, DependabilityintermediateModelPackage.SISTEMA__ACTIVITIES, Sistema.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DependabilityintermediateModelPackage.ACTIVITY__DURATION:
				return getDuration();
			case DependabilityintermediateModelPackage.ACTIVITY__WHEN:
				return getWhen();
			case DependabilityintermediateModelPackage.ACTIVITY__COMPONENT:
				if (resolve) return getComponent();
				return basicGetComponent();
			case DependabilityintermediateModelPackage.ACTIVITY__SISTEMA:
				return getSistema();
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
			case DependabilityintermediateModelPackage.ACTIVITY__DURATION:
				setDuration((Distribution)newValue);
				return;
			case DependabilityintermediateModelPackage.ACTIVITY__WHEN:
				setWhen((SchedulingEvent)newValue);
				return;
			case DependabilityintermediateModelPackage.ACTIVITY__COMPONENT:
				setComponent((Component)newValue);
				return;
			case DependabilityintermediateModelPackage.ACTIVITY__SISTEMA:
				setSistema((Sistema)newValue);
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
			case DependabilityintermediateModelPackage.ACTIVITY__DURATION:
				setDuration((Distribution)null);
				return;
			case DependabilityintermediateModelPackage.ACTIVITY__WHEN:
				setWhen((SchedulingEvent)null);
				return;
			case DependabilityintermediateModelPackage.ACTIVITY__COMPONENT:
				setComponent((Component)null);
				return;
			case DependabilityintermediateModelPackage.ACTIVITY__SISTEMA:
				setSistema((Sistema)null);
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
			case DependabilityintermediateModelPackage.ACTIVITY__DURATION:
				return duration != null;
			case DependabilityintermediateModelPackage.ACTIVITY__WHEN:
				return when != null;
			case DependabilityintermediateModelPackage.ACTIVITY__COMPONENT:
				return component != null;
			case DependabilityintermediateModelPackage.ACTIVITY__SISTEMA:
				return getSistema() != null;
		}
		return super.eIsSet(featureID);
	}

} //ActivityImpl
