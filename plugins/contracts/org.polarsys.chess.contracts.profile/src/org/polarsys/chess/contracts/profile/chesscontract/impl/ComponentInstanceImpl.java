/**
 */
package org.polarsys.chess.contracts.profile.chesscontract.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.uml2.uml.Property;

import org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage;
import org.polarsys.chess.contracts.profile.chesscontract.ComponentInstance;
import org.polarsys.chess.contracts.profile.chesscontract.ContractProperty;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.impl.ComponentInstanceImpl#getBase_Property <em>Base Property</em>}</li>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.impl.ComponentInstanceImpl#getWeakGuarantees <em>Weak Guarantees</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentInstanceImpl extends MinimalEObjectImpl.Container implements ComponentInstance {
	/**
	 * The cached value of the '{@link #getBase_Property() <em>Base Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Property()
	 * @generated
	 * @ordered
	 */
	protected Property base_Property;

	/**
	 * The cached value of the '{@link #getWeakGuarantees() <em>Weak Guarantees</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeakGuarantees()
	 * @generated
	 * @ordered
	 */
	protected EList<ContractProperty> weakGuarantees;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CHESSContractPackage.Literals.COMPONENT_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getBase_Property() {
		if (base_Property != null && base_Property.eIsProxy()) {
			InternalEObject oldBase_Property = (InternalEObject)base_Property;
			base_Property = (Property)eResolveProxy(oldBase_Property);
			if (base_Property != oldBase_Property) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CHESSContractPackage.COMPONENT_INSTANCE__BASE_PROPERTY, oldBase_Property, base_Property));
			}
		}
		return base_Property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetBase_Property() {
		return base_Property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Property(Property newBase_Property) {
		Property oldBase_Property = base_Property;
		base_Property = newBase_Property;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CHESSContractPackage.COMPONENT_INSTANCE__BASE_PROPERTY, oldBase_Property, base_Property));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ContractProperty> getWeakGuarantees() {
		if (weakGuarantees == null) {
			weakGuarantees = new EObjectResolvingEList<ContractProperty>(ContractProperty.class, this, CHESSContractPackage.COMPONENT_INSTANCE__WEAK_GUARANTEES);
		}
		return weakGuarantees;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CHESSContractPackage.COMPONENT_INSTANCE__BASE_PROPERTY:
				if (resolve) return getBase_Property();
				return basicGetBase_Property();
			case CHESSContractPackage.COMPONENT_INSTANCE__WEAK_GUARANTEES:
				return getWeakGuarantees();
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
			case CHESSContractPackage.COMPONENT_INSTANCE__BASE_PROPERTY:
				setBase_Property((Property)newValue);
				return;
			case CHESSContractPackage.COMPONENT_INSTANCE__WEAK_GUARANTEES:
				getWeakGuarantees().clear();
				getWeakGuarantees().addAll((Collection<? extends ContractProperty>)newValue);
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
			case CHESSContractPackage.COMPONENT_INSTANCE__BASE_PROPERTY:
				setBase_Property((Property)null);
				return;
			case CHESSContractPackage.COMPONENT_INSTANCE__WEAK_GUARANTEES:
				getWeakGuarantees().clear();
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
			case CHESSContractPackage.COMPONENT_INSTANCE__BASE_PROPERTY:
				return base_Property != null;
			case CHESSContractPackage.COMPONENT_INSTANCE__WEAK_GUARANTEES:
				return weakGuarantees != null && !weakGuarantees.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ComponentInstanceImpl
