/*****************************************************************************
 * Copyright (c) 2011, 2015 University of Padova, Intecs
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *
 *****************************************************************************/
package org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Property;
import org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponent;
import org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponentPackage;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ErrorModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dependable Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.DependableComponentImpl#getBase_Component <em>Base Component</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.DependableComponentImpl#getErrorModel <em>Error Model</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.DependableComponentImpl#getBase_Property <em>Base Property</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.DependableComponentImpl#getBase_InstanceSpecification <em>Base Instance Specification</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DependableComponentImpl extends EObjectImpl implements DependableComponent {
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
	 * The cached value of the '{@link #getErrorModel() <em>Error Model</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrorModel()
	 * @generated
	 * @ordered
	 */
	protected EList<ErrorModel> errorModel;

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
	 * The cached value of the '{@link #getBase_InstanceSpecification() <em>Base Instance Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_InstanceSpecification()
	 * @generated
	 * @ordered
	 */
	protected InstanceSpecification base_InstanceSpecification;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DependableComponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DependableComponentPackage.Literals.DEPENDABLE_COMPONENT;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DependableComponentPackage.DEPENDABLE_COMPONENT__BASE_COMPONENT, oldBase_Component, base_Component));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DependableComponentPackage.DEPENDABLE_COMPONENT__BASE_COMPONENT, oldBase_Component, base_Component));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ErrorModel> getErrorModel() {
		if (errorModel == null) {
			errorModel = new EObjectResolvingEList<ErrorModel>(ErrorModel.class, this, DependableComponentPackage.DEPENDABLE_COMPONENT__ERROR_MODEL);
		}
		return errorModel;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DependableComponentPackage.DEPENDABLE_COMPONENT__BASE_PROPERTY, oldBase_Property, base_Property));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DependableComponentPackage.DEPENDABLE_COMPONENT__BASE_PROPERTY, oldBase_Property, base_Property));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceSpecification getBase_InstanceSpecification() {
		if (base_InstanceSpecification != null && base_InstanceSpecification.eIsProxy()) {
			InternalEObject oldBase_InstanceSpecification = (InternalEObject)base_InstanceSpecification;
			base_InstanceSpecification = (InstanceSpecification)eResolveProxy(oldBase_InstanceSpecification);
			if (base_InstanceSpecification != oldBase_InstanceSpecification) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DependableComponentPackage.DEPENDABLE_COMPONENT__BASE_INSTANCE_SPECIFICATION, oldBase_InstanceSpecification, base_InstanceSpecification));
			}
		}
		return base_InstanceSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceSpecification basicGetBase_InstanceSpecification() {
		return base_InstanceSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_InstanceSpecification(InstanceSpecification newBase_InstanceSpecification) {
		InstanceSpecification oldBase_InstanceSpecification = base_InstanceSpecification;
		base_InstanceSpecification = newBase_InstanceSpecification;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependableComponentPackage.DEPENDABLE_COMPONENT__BASE_INSTANCE_SPECIFICATION, oldBase_InstanceSpecification, base_InstanceSpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DependableComponentPackage.DEPENDABLE_COMPONENT__BASE_COMPONENT:
				if (resolve) return getBase_Component();
				return basicGetBase_Component();
			case DependableComponentPackage.DEPENDABLE_COMPONENT__ERROR_MODEL:
				return getErrorModel();
			case DependableComponentPackage.DEPENDABLE_COMPONENT__BASE_PROPERTY:
				if (resolve) return getBase_Property();
				return basicGetBase_Property();
			case DependableComponentPackage.DEPENDABLE_COMPONENT__BASE_INSTANCE_SPECIFICATION:
				if (resolve) return getBase_InstanceSpecification();
				return basicGetBase_InstanceSpecification();
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
			case DependableComponentPackage.DEPENDABLE_COMPONENT__BASE_COMPONENT:
				setBase_Component((Component)newValue);
				return;
			case DependableComponentPackage.DEPENDABLE_COMPONENT__ERROR_MODEL:
				getErrorModel().clear();
				getErrorModel().addAll((Collection<? extends ErrorModel>)newValue);
				return;
			case DependableComponentPackage.DEPENDABLE_COMPONENT__BASE_PROPERTY:
				setBase_Property((Property)newValue);
				return;
			case DependableComponentPackage.DEPENDABLE_COMPONENT__BASE_INSTANCE_SPECIFICATION:
				setBase_InstanceSpecification((InstanceSpecification)newValue);
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
			case DependableComponentPackage.DEPENDABLE_COMPONENT__BASE_COMPONENT:
				setBase_Component((Component)null);
				return;
			case DependableComponentPackage.DEPENDABLE_COMPONENT__ERROR_MODEL:
				getErrorModel().clear();
				return;
			case DependableComponentPackage.DEPENDABLE_COMPONENT__BASE_PROPERTY:
				setBase_Property((Property)null);
				return;
			case DependableComponentPackage.DEPENDABLE_COMPONENT__BASE_INSTANCE_SPECIFICATION:
				setBase_InstanceSpecification((InstanceSpecification)null);
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
			case DependableComponentPackage.DEPENDABLE_COMPONENT__BASE_COMPONENT:
				return base_Component != null;
			case DependableComponentPackage.DEPENDABLE_COMPONENT__ERROR_MODEL:
				return errorModel != null && !errorModel.isEmpty();
			case DependableComponentPackage.DEPENDABLE_COMPONENT__BASE_PROPERTY:
				return base_Property != null;
			case DependableComponentPackage.DEPENDABLE_COMPONENT__BASE_INSTANCE_SPECIFICATION:
				return base_InstanceSpecification != null;
		}
		return super.eIsSet(featureID);
	}

} //DependableComponentImpl
