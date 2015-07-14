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
package org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Type;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.DurationType;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.FailureMode;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatsPropagationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Failure Mode</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.FailureModeImpl#getAffectedPorts <em>Affected Ports</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.FailureModeImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FailureModeImpl extends ThreatStateImpl implements FailureMode {
	/**
	 * The cached value of the '{@link #getAffectedPorts() <em>Affected Ports</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAffectedPorts()
	 * @generated
	 * @ordered
	 */
	protected EList<Port> affectedPorts;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final DurationType TYPE_EDEFAULT = DurationType.TRANSIENT;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected DurationType type = TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FailureModeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ThreatsPropagationPackage.Literals.FAILURE_MODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Port> getAffectedPorts() {
		if (affectedPorts == null) {
			affectedPorts = new EObjectResolvingEList<Port>(Port.class, this, ThreatsPropagationPackage.FAILURE_MODE__AFFECTED_PORTS);
		}
		return affectedPorts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port getAffectedPorts(String name, Type type) {
		return getAffectedPorts(name, type, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port getAffectedPorts(String name, Type type, boolean ignoreCase) {
		affectedPortsLoop: for (Port affectedPorts : getAffectedPorts()) {
			if (name != null && !(ignoreCase ? name.equalsIgnoreCase(affectedPorts.getName()) : name.equals(affectedPorts.getName())))
				continue affectedPortsLoop;
			if (type != null && !type.equals(affectedPorts.getType()))
				continue affectedPortsLoop;
			return affectedPorts;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DurationType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(DurationType newType) {
		DurationType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ThreatsPropagationPackage.FAILURE_MODE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ThreatsPropagationPackage.FAILURE_MODE__AFFECTED_PORTS:
				return getAffectedPorts();
			case ThreatsPropagationPackage.FAILURE_MODE__TYPE:
				return getType();
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
			case ThreatsPropagationPackage.FAILURE_MODE__AFFECTED_PORTS:
				getAffectedPorts().clear();
				getAffectedPorts().addAll((Collection<? extends Port>)newValue);
				return;
			case ThreatsPropagationPackage.FAILURE_MODE__TYPE:
				setType((DurationType)newValue);
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
			case ThreatsPropagationPackage.FAILURE_MODE__AFFECTED_PORTS:
				getAffectedPorts().clear();
				return;
			case ThreatsPropagationPackage.FAILURE_MODE__TYPE:
				setType(TYPE_EDEFAULT);
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
			case ThreatsPropagationPackage.FAILURE_MODE__AFFECTED_PORTS:
				return affectedPorts != null && !affectedPorts.isEmpty();
			case ThreatsPropagationPackage.FAILURE_MODE__TYPE:
				return type != TYPE_EDEFAULT;
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
		result.append(" (type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //FailureModeImpl
