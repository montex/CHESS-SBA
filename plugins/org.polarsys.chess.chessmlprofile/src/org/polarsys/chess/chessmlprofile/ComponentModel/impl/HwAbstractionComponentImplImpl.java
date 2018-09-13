/**
 */
package org.polarsys.chess.chessmlprofile.ComponentModel.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwGeneral.HwResource;

import org.eclipse.uml2.uml.Component;
import org.polarsys.chess.chessmlprofile.ComponentModel.ComponentModelPackage;
import org.polarsys.chess.chessmlprofile.ComponentModel.HwAbstractionComponentImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hw Abstraction Component Impl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.ComponentModel.impl.HwAbstractionComponentImplImpl#getHwRes <em>Hw Res</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.ComponentModel.impl.HwAbstractionComponentImplImpl#getBase_Component <em>Base Component</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HwAbstractionComponentImplImpl extends EObjectImpl implements HwAbstractionComponentImpl {
	/**
	 * The cached value of the '{@link #getHwRes() <em>Hw Res</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHwRes()
	 * @generated
	 * @ordered
	 */
	protected HwResource hwRes;

	/**
	 * The cached value of the '{@link #getBase_Component() <em>Base Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Component()
	 * @generated
	 * @ordered
	 */
	protected Component base_Component;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HwAbstractionComponentImplImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentModelPackage.Literals.HW_ABSTRACTION_COMPONENT_IMPL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HwResource getHwRes() {
		if (hwRes != null && hwRes.eIsProxy()) {
			InternalEObject oldHwRes = (InternalEObject)hwRes;
			hwRes = (HwResource)eResolveProxy(oldHwRes);
			if (hwRes != oldHwRes) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ComponentModelPackage.HW_ABSTRACTION_COMPONENT_IMPL__HW_RES, oldHwRes, hwRes));
			}
		}
		return hwRes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HwResource basicGetHwRes() {
		return hwRes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHwRes(HwResource newHwRes) {
		HwResource oldHwRes = hwRes;
		hwRes = newHwRes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentModelPackage.HW_ABSTRACTION_COMPONENT_IMPL__HW_RES, oldHwRes, hwRes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component getBase_Component() {
		if (base_Component != null && base_Component.eIsProxy()) {
			InternalEObject oldBase_Component = (InternalEObject)base_Component;
			base_Component = (Component)eResolveProxy(oldBase_Component);
			if (base_Component != oldBase_Component) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ComponentModelPackage.HW_ABSTRACTION_COMPONENT_IMPL__BASE_COMPONENT, oldBase_Component, base_Component));
			}
		}
		return base_Component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component basicGetBase_Component() {
		return base_Component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Component(Component newBase_Component) {
		Component oldBase_Component = base_Component;
		base_Component = newBase_Component;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentModelPackage.HW_ABSTRACTION_COMPONENT_IMPL__BASE_COMPONENT, oldBase_Component, base_Component));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComponentModelPackage.HW_ABSTRACTION_COMPONENT_IMPL__HW_RES:
				if (resolve) return getHwRes();
				return basicGetHwRes();
			case ComponentModelPackage.HW_ABSTRACTION_COMPONENT_IMPL__BASE_COMPONENT:
				if (resolve) return getBase_Component();
				return basicGetBase_Component();
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
			case ComponentModelPackage.HW_ABSTRACTION_COMPONENT_IMPL__HW_RES:
				setHwRes((HwResource)newValue);
				return;
			case ComponentModelPackage.HW_ABSTRACTION_COMPONENT_IMPL__BASE_COMPONENT:
				setBase_Component((Component)newValue);
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
			case ComponentModelPackage.HW_ABSTRACTION_COMPONENT_IMPL__HW_RES:
				setHwRes((HwResource)null);
				return;
			case ComponentModelPackage.HW_ABSTRACTION_COMPONENT_IMPL__BASE_COMPONENT:
				setBase_Component((Component)null);
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
			case ComponentModelPackage.HW_ABSTRACTION_COMPONENT_IMPL__HW_RES:
				return hwRes != null;
			case ComponentModelPackage.HW_ABSTRACTION_COMPONENT_IMPL__BASE_COMPONENT:
				return base_Component != null;
		}
		return super.eIsSet(featureID);
	}

} //HwAbstractionComponentImplImpl
