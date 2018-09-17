/**
 */
package org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.eclipse.uml2.uml.Property;

import org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.InstantiatedArchitecture;
import org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.ParameterizedArchitecturePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Instantiated Architecture</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.impl.InstantiatedArchitectureImpl#getParameterList <em>Parameter List</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.impl.InstantiatedArchitectureImpl#getBase_Property <em>Base Property</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.impl.InstantiatedArchitectureImpl#getInstantiatedRootComponent <em>Instantiated Root Component</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InstantiatedArchitectureImpl extends EObjectImpl implements InstantiatedArchitecture {
	/**
	 * The cached value of the '{@link #getParameterList() <em>Parameter List</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterList()
	 * @generated
	 * @ordered
	 */
	protected EList<String> parameterList;

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
	 * The cached value of the '{@link #getInstantiatedRootComponent() <em>Instantiated Root Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstantiatedRootComponent()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Class instantiatedRootComponent;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstantiatedArchitectureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ParameterizedArchitecturePackage.Literals.INSTANTIATED_ARCHITECTURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getParameterList() {
		if (parameterList == null) {
			parameterList = new EDataTypeUniqueEList<String>(String.class, this, ParameterizedArchitecturePackage.INSTANTIATED_ARCHITECTURE__PARAMETER_LIST);
		}
		return parameterList;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ParameterizedArchitecturePackage.INSTANTIATED_ARCHITECTURE__BASE_PROPERTY, oldBase_Property, base_Property));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ParameterizedArchitecturePackage.INSTANTIATED_ARCHITECTURE__BASE_PROPERTY, oldBase_Property, base_Property));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class getInstantiatedRootComponent() {
		if (instantiatedRootComponent != null && instantiatedRootComponent.eIsProxy()) {
			InternalEObject oldInstantiatedRootComponent = (InternalEObject)instantiatedRootComponent;
			instantiatedRootComponent = (org.eclipse.uml2.uml.Class)eResolveProxy(oldInstantiatedRootComponent);
			if (instantiatedRootComponent != oldInstantiatedRootComponent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ParameterizedArchitecturePackage.INSTANTIATED_ARCHITECTURE__INSTANTIATED_ROOT_COMPONENT, oldInstantiatedRootComponent, instantiatedRootComponent));
			}
		}
		return instantiatedRootComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class basicGetInstantiatedRootComponent() {
		return instantiatedRootComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstantiatedRootComponent(org.eclipse.uml2.uml.Class newInstantiatedRootComponent) {
		org.eclipse.uml2.uml.Class oldInstantiatedRootComponent = instantiatedRootComponent;
		instantiatedRootComponent = newInstantiatedRootComponent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParameterizedArchitecturePackage.INSTANTIATED_ARCHITECTURE__INSTANTIATED_ROOT_COMPONENT, oldInstantiatedRootComponent, instantiatedRootComponent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ParameterizedArchitecturePackage.INSTANTIATED_ARCHITECTURE__PARAMETER_LIST:
				return getParameterList();
			case ParameterizedArchitecturePackage.INSTANTIATED_ARCHITECTURE__BASE_PROPERTY:
				if (resolve) return getBase_Property();
				return basicGetBase_Property();
			case ParameterizedArchitecturePackage.INSTANTIATED_ARCHITECTURE__INSTANTIATED_ROOT_COMPONENT:
				if (resolve) return getInstantiatedRootComponent();
				return basicGetInstantiatedRootComponent();
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
			case ParameterizedArchitecturePackage.INSTANTIATED_ARCHITECTURE__PARAMETER_LIST:
				getParameterList().clear();
				getParameterList().addAll((Collection<? extends String>)newValue);
				return;
			case ParameterizedArchitecturePackage.INSTANTIATED_ARCHITECTURE__BASE_PROPERTY:
				setBase_Property((Property)newValue);
				return;
			case ParameterizedArchitecturePackage.INSTANTIATED_ARCHITECTURE__INSTANTIATED_ROOT_COMPONENT:
				setInstantiatedRootComponent((org.eclipse.uml2.uml.Class)newValue);
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
			case ParameterizedArchitecturePackage.INSTANTIATED_ARCHITECTURE__PARAMETER_LIST:
				getParameterList().clear();
				return;
			case ParameterizedArchitecturePackage.INSTANTIATED_ARCHITECTURE__BASE_PROPERTY:
				setBase_Property((Property)null);
				return;
			case ParameterizedArchitecturePackage.INSTANTIATED_ARCHITECTURE__INSTANTIATED_ROOT_COMPONENT:
				setInstantiatedRootComponent((org.eclipse.uml2.uml.Class)null);
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
			case ParameterizedArchitecturePackage.INSTANTIATED_ARCHITECTURE__PARAMETER_LIST:
				return parameterList != null && !parameterList.isEmpty();
			case ParameterizedArchitecturePackage.INSTANTIATED_ARCHITECTURE__BASE_PROPERTY:
				return base_Property != null;
			case ParameterizedArchitecturePackage.INSTANTIATED_ARCHITECTURE__INSTANTIATED_ROOT_COMPONENT:
				return instantiatedRootComponent != null;
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
		result.append(" (ParameterList: ");
		result.append(parameterList);
		result.append(')');
		return result.toString();
	}

} //InstantiatedArchitectureImpl
