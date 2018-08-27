/**
 */
package org.polarsys.chess.contracts.profile.chesscontract.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.uml2.uml.Abstraction;

import org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage;
import org.polarsys.chess.contracts.profile.chesscontract.Formalize;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Formalize</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.impl.FormalizeImpl#getBase_Abstraction <em>Base Abstraction</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FormalizeImpl extends MinimalEObjectImpl.Container implements Formalize {
	/**
	 * The cached value of the '{@link #getBase_Abstraction() <em>Base
	 * Abstraction</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getBase_Abstraction()
	 * @generated
	 * @ordered
	 */
	protected Abstraction base_Abstraction;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected FormalizeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CHESSContractPackage.Literals.FORMALIZE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Abstraction getBase_Abstraction() {
		if (base_Abstraction != null && base_Abstraction.eIsProxy()) {
			InternalEObject oldBase_Abstraction = (InternalEObject)base_Abstraction;
			base_Abstraction = (Abstraction)eResolveProxy(oldBase_Abstraction);
			if (base_Abstraction != oldBase_Abstraction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CHESSContractPackage.FORMALIZE__BASE_ABSTRACTION, oldBase_Abstraction, base_Abstraction));
			}
		}
		return base_Abstraction;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Abstraction basicGetBase_Abstraction() {
		return base_Abstraction;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Abstraction(Abstraction newBase_Abstraction) {
		Abstraction oldBase_Abstraction = base_Abstraction;
		base_Abstraction = newBase_Abstraction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CHESSContractPackage.FORMALIZE__BASE_ABSTRACTION, oldBase_Abstraction, base_Abstraction));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CHESSContractPackage.FORMALIZE__BASE_ABSTRACTION:
				if (resolve) return getBase_Abstraction();
				return basicGetBase_Abstraction();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CHESSContractPackage.FORMALIZE__BASE_ABSTRACTION:
				setBase_Abstraction((Abstraction)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CHESSContractPackage.FORMALIZE__BASE_ABSTRACTION:
				setBase_Abstraction((Abstraction)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CHESSContractPackage.FORMALIZE__BASE_ABSTRACTION:
				return base_Abstraction != null;
		}
		return super.eIsSet(featureID);
	}

} // FormalizeImpl
