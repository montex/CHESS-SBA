/*******************************************************************************
 *  * Copyright (c) 2015 University of Padova, Intecs
 *  *
 *  *    
 *  * All rights reserved. This program and the accompanying materials
 *  * are made available under the terms of the Eclipse Public License v1.0
 *  * which accompanies this distribution, and is available at
 *  * http://www.eclipse.org/legal/epl-v10.html
 *  *
 *******************************************************************************/
/**
 */
package org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Type;

import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.CHExternalFault;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.DurationType;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatsPropagationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CH External Fault</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.CHExternalFaultImpl#getBase_Transition <em>Base Transition</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.CHExternalFaultImpl#getFromPort <em>From Port</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.CHExternalFaultImpl#getPropagationCondition <em>Propagation Condition</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.CHExternalFaultImpl#getProbability <em>Probability</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.CHExternalFaultImpl#getUnit <em>Unit</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.CHExternalFaultImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.CHExternalFaultImpl#getTransfFunct <em>Transf Funct</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CHExternalFaultImpl extends EObjectImpl implements CHExternalFault {
	/**
	 * The cached value of the '{@link #getBase_Transition() <em>Base Transition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Transition()
	 * @generated
	 * @ordered
	 */
	protected Transition base_Transition;

	/**
	 * The cached value of the '{@link #getFromPort() <em>From Port</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromPort()
	 * @generated
	 * @ordered
	 */
	protected EList<Port> fromPort;

	/**
	 * The default value of the '{@link #getPropagationCondition() <em>Propagation Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropagationCondition()
	 * @generated
	 * @ordered
	 */
	protected static final String PROPAGATION_CONDITION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPropagationCondition() <em>Propagation Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropagationCondition()
	 * @generated
	 * @ordered
	 */
	protected String propagationCondition = PROPAGATION_CONDITION_EDEFAULT;

	/**
	 * The default value of the '{@link #getProbability() <em>Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProbability()
	 * @generated
	 * @ordered
	 */
	protected static final String PROBABILITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProbability() <em>Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProbability()
	 * @generated
	 * @ordered
	 */
	protected String probability = PROBABILITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getUnit() <em>Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnit()
	 * @generated
	 * @ordered
	 */
	protected static final String UNIT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUnit() <em>Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnit()
	 * @generated
	 * @ordered
	 */
	protected String unit = UNIT_EDEFAULT;

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
	 * The cached value of the '{@link #getTransfFunct() <em>Transf Funct</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransfFunct()
	 * @generated
	 * @ordered
	 */
	protected EList<String> transfFunct;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CHExternalFaultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ThreatsPropagationPackage.Literals.CH_EXTERNAL_FAULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transition getBase_Transition() {
		if (base_Transition != null && base_Transition.eIsProxy()) {
			InternalEObject oldBase_Transition = (InternalEObject)base_Transition;
			base_Transition = (Transition)eResolveProxy(oldBase_Transition);
			if (base_Transition != oldBase_Transition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ThreatsPropagationPackage.CH_EXTERNAL_FAULT__BASE_TRANSITION, oldBase_Transition, base_Transition));
			}
		}
		return base_Transition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transition basicGetBase_Transition() {
		return base_Transition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Transition(Transition newBase_Transition) {
		Transition oldBase_Transition = base_Transition;
		base_Transition = newBase_Transition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ThreatsPropagationPackage.CH_EXTERNAL_FAULT__BASE_TRANSITION, oldBase_Transition, base_Transition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Port> getFromPort() {
		if (fromPort == null) {
			fromPort = new EObjectResolvingEList<Port>(Port.class, this, ThreatsPropagationPackage.CH_EXTERNAL_FAULT__FROM_PORT);
		}
		return fromPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port getFromPort(String name, Type type) {
		return getFromPort(name, type, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port getFromPort(String name, Type type, boolean ignoreCase) {
		fromPortLoop: for (Port fromPort : getFromPort()) {
			if (name != null && !(ignoreCase ? name.equalsIgnoreCase(fromPort.getName()) : name.equals(fromPort.getName())))
				continue fromPortLoop;
			if (type != null && !type.equals(fromPort.getType()))
				continue fromPortLoop;
			return fromPort;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPropagationCondition() {
		return propagationCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropagationCondition(String newPropagationCondition) {
		String oldPropagationCondition = propagationCondition;
		propagationCondition = newPropagationCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ThreatsPropagationPackage.CH_EXTERNAL_FAULT__PROPAGATION_CONDITION, oldPropagationCondition, propagationCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProbability() {
		return probability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProbability(String newProbability) {
		String oldProbability = probability;
		probability = newProbability;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ThreatsPropagationPackage.CH_EXTERNAL_FAULT__PROBABILITY, oldProbability, probability));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnit(String newUnit) {
		String oldUnit = unit;
		unit = newUnit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ThreatsPropagationPackage.CH_EXTERNAL_FAULT__UNIT, oldUnit, unit));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ThreatsPropagationPackage.CH_EXTERNAL_FAULT__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getTransfFunct() {
		if (transfFunct == null) {
			transfFunct = new EDataTypeUniqueEList<String>(String.class, this, ThreatsPropagationPackage.CH_EXTERNAL_FAULT__TRANSF_FUNCT);
		}
		return transfFunct;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ThreatsPropagationPackage.CH_EXTERNAL_FAULT__BASE_TRANSITION:
				if (resolve) return getBase_Transition();
				return basicGetBase_Transition();
			case ThreatsPropagationPackage.CH_EXTERNAL_FAULT__FROM_PORT:
				return getFromPort();
			case ThreatsPropagationPackage.CH_EXTERNAL_FAULT__PROPAGATION_CONDITION:
				return getPropagationCondition();
			case ThreatsPropagationPackage.CH_EXTERNAL_FAULT__PROBABILITY:
				return getProbability();
			case ThreatsPropagationPackage.CH_EXTERNAL_FAULT__UNIT:
				return getUnit();
			case ThreatsPropagationPackage.CH_EXTERNAL_FAULT__TYPE:
				return getType();
			case ThreatsPropagationPackage.CH_EXTERNAL_FAULT__TRANSF_FUNCT:
				return getTransfFunct();
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
			case ThreatsPropagationPackage.CH_EXTERNAL_FAULT__BASE_TRANSITION:
				setBase_Transition((Transition)newValue);
				return;
			case ThreatsPropagationPackage.CH_EXTERNAL_FAULT__FROM_PORT:
				getFromPort().clear();
				getFromPort().addAll((Collection<? extends Port>)newValue);
				return;
			case ThreatsPropagationPackage.CH_EXTERNAL_FAULT__PROPAGATION_CONDITION:
				setPropagationCondition((String)newValue);
				return;
			case ThreatsPropagationPackage.CH_EXTERNAL_FAULT__PROBABILITY:
				setProbability((String)newValue);
				return;
			case ThreatsPropagationPackage.CH_EXTERNAL_FAULT__UNIT:
				setUnit((String)newValue);
				return;
			case ThreatsPropagationPackage.CH_EXTERNAL_FAULT__TYPE:
				setType((DurationType)newValue);
				return;
			case ThreatsPropagationPackage.CH_EXTERNAL_FAULT__TRANSF_FUNCT:
				getTransfFunct().clear();
				getTransfFunct().addAll((Collection<? extends String>)newValue);
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
			case ThreatsPropagationPackage.CH_EXTERNAL_FAULT__BASE_TRANSITION:
				setBase_Transition((Transition)null);
				return;
			case ThreatsPropagationPackage.CH_EXTERNAL_FAULT__FROM_PORT:
				getFromPort().clear();
				return;
			case ThreatsPropagationPackage.CH_EXTERNAL_FAULT__PROPAGATION_CONDITION:
				setPropagationCondition(PROPAGATION_CONDITION_EDEFAULT);
				return;
			case ThreatsPropagationPackage.CH_EXTERNAL_FAULT__PROBABILITY:
				setProbability(PROBABILITY_EDEFAULT);
				return;
			case ThreatsPropagationPackage.CH_EXTERNAL_FAULT__UNIT:
				setUnit(UNIT_EDEFAULT);
				return;
			case ThreatsPropagationPackage.CH_EXTERNAL_FAULT__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case ThreatsPropagationPackage.CH_EXTERNAL_FAULT__TRANSF_FUNCT:
				getTransfFunct().clear();
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
			case ThreatsPropagationPackage.CH_EXTERNAL_FAULT__BASE_TRANSITION:
				return base_Transition != null;
			case ThreatsPropagationPackage.CH_EXTERNAL_FAULT__FROM_PORT:
				return fromPort != null && !fromPort.isEmpty();
			case ThreatsPropagationPackage.CH_EXTERNAL_FAULT__PROPAGATION_CONDITION:
				return PROPAGATION_CONDITION_EDEFAULT == null ? propagationCondition != null : !PROPAGATION_CONDITION_EDEFAULT.equals(propagationCondition);
			case ThreatsPropagationPackage.CH_EXTERNAL_FAULT__PROBABILITY:
				return PROBABILITY_EDEFAULT == null ? probability != null : !PROBABILITY_EDEFAULT.equals(probability);
			case ThreatsPropagationPackage.CH_EXTERNAL_FAULT__UNIT:
				return UNIT_EDEFAULT == null ? unit != null : !UNIT_EDEFAULT.equals(unit);
			case ThreatsPropagationPackage.CH_EXTERNAL_FAULT__TYPE:
				return type != TYPE_EDEFAULT;
			case ThreatsPropagationPackage.CH_EXTERNAL_FAULT__TRANSF_FUNCT:
				return transfFunct != null && !transfFunct.isEmpty();
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
		result.append(" (propagationCondition: ");
		result.append(propagationCondition);
		result.append(", probability: ");
		result.append(probability);
		result.append(", unit: ");
		result.append(unit);
		result.append(", type: ");
		result.append(type);
		result.append(", transfFunct: ");
		result.append(transfFunct);
		result.append(')');
		return result.toString();
	}

} //CHExternalFaultImpl
