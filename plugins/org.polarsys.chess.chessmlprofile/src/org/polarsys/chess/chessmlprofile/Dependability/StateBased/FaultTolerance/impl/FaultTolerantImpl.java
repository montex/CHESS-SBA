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
package org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.FaultTolerancePackage;
import org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.FaultTolerant;
import org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.RedundancyKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fault Tolerant</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.impl.FaultTolerantImpl#getBase_Component <em>Base Component</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.impl.FaultTolerantImpl#getScheme <em>Scheme</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.impl.FaultTolerantImpl#getSchemeAttrs <em>Scheme Attrs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FaultTolerantImpl extends EObjectImpl implements FaultTolerant {
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
	 * The default value of the '{@link #getScheme() <em>Scheme</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScheme()
	 * @generated
	 * @ordered
	 */
	protected static final RedundancyKind SCHEME_EDEFAULT = RedundancyKind.TMR;

	/**
	 * The cached value of the '{@link #getScheme() <em>Scheme</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScheme()
	 * @generated
	 * @ordered
	 */
	protected RedundancyKind scheme = SCHEME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSchemeAttrs() <em>Scheme Attrs</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchemeAttrs()
	 * @generated
	 * @ordered
	 */
	protected OpaqueExpression schemeAttrs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FaultTolerantImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FaultTolerancePackage.Literals.FAULT_TOLERANT;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FaultTolerancePackage.FAULT_TOLERANT__BASE_COMPONENT, oldBase_Component, base_Component));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FaultTolerancePackage.FAULT_TOLERANT__BASE_COMPONENT, oldBase_Component, base_Component));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RedundancyKind getScheme() {
		return scheme;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScheme(RedundancyKind newScheme) {
		RedundancyKind oldScheme = scheme;
		scheme = newScheme == null ? SCHEME_EDEFAULT : newScheme;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FaultTolerancePackage.FAULT_TOLERANT__SCHEME, oldScheme, scheme));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OpaqueExpression getSchemeAttrs() {
		if (schemeAttrs != null && schemeAttrs.eIsProxy()) {
			InternalEObject oldSchemeAttrs = (InternalEObject)schemeAttrs;
			schemeAttrs = (OpaqueExpression)eResolveProxy(oldSchemeAttrs);
			if (schemeAttrs != oldSchemeAttrs) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FaultTolerancePackage.FAULT_TOLERANT__SCHEME_ATTRS, oldSchemeAttrs, schemeAttrs));
			}
		}
		return schemeAttrs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OpaqueExpression basicGetSchemeAttrs() {
		return schemeAttrs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSchemeAttrs(OpaqueExpression newSchemeAttrs) {
		OpaqueExpression oldSchemeAttrs = schemeAttrs;
		schemeAttrs = newSchemeAttrs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FaultTolerancePackage.FAULT_TOLERANT__SCHEME_ATTRS, oldSchemeAttrs, schemeAttrs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FaultTolerancePackage.FAULT_TOLERANT__BASE_COMPONENT:
				if (resolve) return getBase_Component();
				return basicGetBase_Component();
			case FaultTolerancePackage.FAULT_TOLERANT__SCHEME:
				return getScheme();
			case FaultTolerancePackage.FAULT_TOLERANT__SCHEME_ATTRS:
				if (resolve) return getSchemeAttrs();
				return basicGetSchemeAttrs();
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
			case FaultTolerancePackage.FAULT_TOLERANT__BASE_COMPONENT:
				setBase_Component((Component)newValue);
				return;
			case FaultTolerancePackage.FAULT_TOLERANT__SCHEME:
				setScheme((RedundancyKind)newValue);
				return;
			case FaultTolerancePackage.FAULT_TOLERANT__SCHEME_ATTRS:
				setSchemeAttrs((OpaqueExpression)newValue);
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
			case FaultTolerancePackage.FAULT_TOLERANT__BASE_COMPONENT:
				setBase_Component((Component)null);
				return;
			case FaultTolerancePackage.FAULT_TOLERANT__SCHEME:
				setScheme(SCHEME_EDEFAULT);
				return;
			case FaultTolerancePackage.FAULT_TOLERANT__SCHEME_ATTRS:
				setSchemeAttrs((OpaqueExpression)null);
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
			case FaultTolerancePackage.FAULT_TOLERANT__BASE_COMPONENT:
				return base_Component != null;
			case FaultTolerancePackage.FAULT_TOLERANT__SCHEME:
				return scheme != SCHEME_EDEFAULT;
			case FaultTolerancePackage.FAULT_TOLERANT__SCHEME_ATTRS:
				return schemeAttrs != null;
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
		result.append(" (scheme: ");
		result.append(scheme);
		result.append(')');
		return result.toString();
	}

} //FaultTolerantImpl
