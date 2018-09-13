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
package org.polarsys.chess.chessmlprofile.ComponentModel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.uml2.uml.Component;
import org.polarsys.chess.chessmlprofile.ComponentModel.ComponentImplementation;
import org.polarsys.chess.chessmlprofile.ComponentModel.ComponentModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component Implementation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.ComponentModel.impl.ComponentImplementationImpl#getBase_Component <em>Base Component</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.ComponentModel.impl.ComponentImplementationImpl#getLanguage <em>Language</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.ComponentModel.impl.ComponentImplementationImpl#getOS <em>OS</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.ComponentModel.impl.ComponentImplementationImpl#getSourceCodeLocation <em>Source Code Location</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComponentImplementationImpl extends EObjectImpl implements ComponentImplementation {
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
	 * The default value of the '{@link #getLanguage() <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final String LANGUAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLanguage() <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
	protected String language = LANGUAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getOS() <em>OS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOS()
	 * @generated
	 * @ordered
	 */
	protected static final String OS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOS() <em>OS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOS()
	 * @generated
	 * @ordered
	 */
	protected String os = OS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSourceCodeLocation() <em>Source Code Location</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceCodeLocation()
	 * @generated
	 * @ordered
	 */
	protected EList<String> sourceCodeLocation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentImplementationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentModelPackage.Literals.COMPONENT_IMPLEMENTATION;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ComponentModelPackage.COMPONENT_IMPLEMENTATION__BASE_COMPONENT, oldBase_Component, base_Component));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentModelPackage.COMPONENT_IMPLEMENTATION__BASE_COMPONENT, oldBase_Component, base_Component));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLanguage(String newLanguage) {
		String oldLanguage = language;
		language = newLanguage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentModelPackage.COMPONENT_IMPLEMENTATION__LANGUAGE, oldLanguage, language));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOS() {
		return os;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOS(String newOS) {
		String oldOS = os;
		os = newOS;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentModelPackage.COMPONENT_IMPLEMENTATION__OS, oldOS, os));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getSourceCodeLocation() {
		if (sourceCodeLocation == null) {
			sourceCodeLocation = new EDataTypeUniqueEList<String>(String.class, this, ComponentModelPackage.COMPONENT_IMPLEMENTATION__SOURCE_CODE_LOCATION);
		}
		return sourceCodeLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComponentModelPackage.COMPONENT_IMPLEMENTATION__BASE_COMPONENT:
				if (resolve) return getBase_Component();
				return basicGetBase_Component();
			case ComponentModelPackage.COMPONENT_IMPLEMENTATION__LANGUAGE:
				return getLanguage();
			case ComponentModelPackage.COMPONENT_IMPLEMENTATION__OS:
				return getOS();
			case ComponentModelPackage.COMPONENT_IMPLEMENTATION__SOURCE_CODE_LOCATION:
				return getSourceCodeLocation();
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
			case ComponentModelPackage.COMPONENT_IMPLEMENTATION__BASE_COMPONENT:
				setBase_Component((Component)newValue);
				return;
			case ComponentModelPackage.COMPONENT_IMPLEMENTATION__LANGUAGE:
				setLanguage((String)newValue);
				return;
			case ComponentModelPackage.COMPONENT_IMPLEMENTATION__OS:
				setOS((String)newValue);
				return;
			case ComponentModelPackage.COMPONENT_IMPLEMENTATION__SOURCE_CODE_LOCATION:
				getSourceCodeLocation().clear();
				getSourceCodeLocation().addAll((Collection<? extends String>)newValue);
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
			case ComponentModelPackage.COMPONENT_IMPLEMENTATION__BASE_COMPONENT:
				setBase_Component((Component)null);
				return;
			case ComponentModelPackage.COMPONENT_IMPLEMENTATION__LANGUAGE:
				setLanguage(LANGUAGE_EDEFAULT);
				return;
			case ComponentModelPackage.COMPONENT_IMPLEMENTATION__OS:
				setOS(OS_EDEFAULT);
				return;
			case ComponentModelPackage.COMPONENT_IMPLEMENTATION__SOURCE_CODE_LOCATION:
				getSourceCodeLocation().clear();
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
			case ComponentModelPackage.COMPONENT_IMPLEMENTATION__BASE_COMPONENT:
				return base_Component != null;
			case ComponentModelPackage.COMPONENT_IMPLEMENTATION__LANGUAGE:
				return LANGUAGE_EDEFAULT == null ? language != null : !LANGUAGE_EDEFAULT.equals(language);
			case ComponentModelPackage.COMPONENT_IMPLEMENTATION__OS:
				return OS_EDEFAULT == null ? os != null : !OS_EDEFAULT.equals(os);
			case ComponentModelPackage.COMPONENT_IMPLEMENTATION__SOURCE_CODE_LOCATION:
				return sourceCodeLocation != null && !sourceCodeLocation.isEmpty();
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
		result.append(" (language: ");
		result.append(language);
		result.append(", OS: ");
		result.append(os);
		result.append(", sourceCodeLocation: ");
		result.append(sourceCodeLocation);
		result.append(')');
		return result.toString();
	}

} //ComponentImplementationImpl
