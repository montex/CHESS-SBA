/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package DependabilityintermediateModel.impl;

import DependabilityintermediateModel.Component;
import DependabilityintermediateModel.DependabilityintermediateModelPackage;
import DependabilityintermediateModel.Distribution;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Error</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link DependabilityintermediateModel.impl.ErrorImpl#getVanishingTime <em>Vanishing Time</em>}</li>
 *   <li>{@link DependabilityintermediateModel.impl.ErrorImpl#getComponent <em>Component</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ErrorImpl extends ThreatImpl implements DependabilityintermediateModel.Error {
	/**
	 * The cached value of the '{@link #getVanishingTime() <em>Vanishing Time</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVanishingTime()
	 * @generated
	 * @ordered
	 */
	protected Distribution vanishingTime;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ErrorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DependabilityintermediateModelPackage.Literals.ERROR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Distribution getVanishingTime() {
		return vanishingTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVanishingTime(Distribution newVanishingTime, NotificationChain msgs) {
		Distribution oldVanishingTime = vanishingTime;
		vanishingTime = newVanishingTime;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DependabilityintermediateModelPackage.ERROR__VANISHING_TIME, oldVanishingTime, newVanishingTime);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVanishingTime(Distribution newVanishingTime) {
		if (newVanishingTime != vanishingTime) {
			NotificationChain msgs = null;
			if (vanishingTime != null)
				msgs = ((InternalEObject)vanishingTime).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DependabilityintermediateModelPackage.ERROR__VANISHING_TIME, null, msgs);
			if (newVanishingTime != null)
				msgs = ((InternalEObject)newVanishingTime).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DependabilityintermediateModelPackage.ERROR__VANISHING_TIME, null, msgs);
			msgs = basicSetVanishingTime(newVanishingTime, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependabilityintermediateModelPackage.ERROR__VANISHING_TIME, newVanishingTime, newVanishingTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component getComponent() {
		if (eContainerFeatureID() != DependabilityintermediateModelPackage.ERROR__COMPONENT) return null;
		return (Component)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetComponent(Component newComponent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newComponent, DependabilityintermediateModelPackage.ERROR__COMPONENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponent(Component newComponent) {
		if (newComponent != eInternalContainer() || (eContainerFeatureID() != DependabilityintermediateModelPackage.ERROR__COMPONENT && newComponent != null)) {
			if (EcoreUtil.isAncestor(this, newComponent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newComponent != null)
				msgs = ((InternalEObject)newComponent).eInverseAdd(this, DependabilityintermediateModelPackage.COMPONENT__ERRORS, Component.class, msgs);
			msgs = basicSetComponent(newComponent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependabilityintermediateModelPackage.ERROR__COMPONENT, newComponent, newComponent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DependabilityintermediateModelPackage.ERROR__COMPONENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetComponent((Component)otherEnd, msgs);
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
			case DependabilityintermediateModelPackage.ERROR__VANISHING_TIME:
				return basicSetVanishingTime(null, msgs);
			case DependabilityintermediateModelPackage.ERROR__COMPONENT:
				return basicSetComponent(null, msgs);
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
			case DependabilityintermediateModelPackage.ERROR__COMPONENT:
				return eInternalContainer().eInverseRemove(this, DependabilityintermediateModelPackage.COMPONENT__ERRORS, Component.class, msgs);
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
			case DependabilityintermediateModelPackage.ERROR__VANISHING_TIME:
				return getVanishingTime();
			case DependabilityintermediateModelPackage.ERROR__COMPONENT:
				return getComponent();
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
			case DependabilityintermediateModelPackage.ERROR__VANISHING_TIME:
				setVanishingTime((Distribution)newValue);
				return;
			case DependabilityintermediateModelPackage.ERROR__COMPONENT:
				setComponent((Component)newValue);
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
			case DependabilityintermediateModelPackage.ERROR__VANISHING_TIME:
				setVanishingTime((Distribution)null);
				return;
			case DependabilityintermediateModelPackage.ERROR__COMPONENT:
				setComponent((Component)null);
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
			case DependabilityintermediateModelPackage.ERROR__VANISHING_TIME:
				return vanishingTime != null;
			case DependabilityintermediateModelPackage.ERROR__COMPONENT:
				return getComponent() != null;
		}
		return super.eIsSet(featureID);
	}

} //ErrorImpl
