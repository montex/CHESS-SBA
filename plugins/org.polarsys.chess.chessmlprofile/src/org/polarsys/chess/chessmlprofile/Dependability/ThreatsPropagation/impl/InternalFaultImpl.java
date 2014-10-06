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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.Transition;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalFault;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatsPropagationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Internal Fault</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.InternalFaultImpl#getBase_Transition <em>Base Transition</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.InternalFaultImpl#getPermanentProb <em>Permanent Prob</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.InternalFaultImpl#getTransfFunct <em>Transf Funct</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.InternalFaultImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.InternalFaultImpl#getChildFailure <em>Child Failure</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.InternalFaultImpl#getOccurrence <em>Occurrence</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.InternalFaultImpl#getTransientDuration <em>Transient Duration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InternalFaultImpl extends EObjectImpl implements InternalFault {
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
	 * The default value of the '{@link #getPermanentProb() <em>Permanent Prob</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPermanentProb()
	 * @generated
	 * @ordered
	 */
	protected static final String PERMANENT_PROB_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPermanentProb() <em>Permanent Prob</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPermanentProb()
	 * @generated
	 * @ordered
	 */
	protected String permanentProb = PERMANENT_PROB_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransfFunct() <em>Transf Funct</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransfFunct()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSF_FUNCT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransfFunct() <em>Transf Funct</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransfFunct()
	 * @generated
	 * @ordered
	 */
	protected String transfFunct = TRANSF_FUNCT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getProperty() <em>Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperty()
	 * @generated
	 * @ordered
	 */
	protected Property property;

	/**
	 * The cached value of the '{@link #getChildFailure() <em>Child Failure</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildFailure()
	 * @generated
	 * @ordered
	 */
	protected State childFailure;

	/**
	 * The default value of the '{@link #getOccurrence() <em>Occurrence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOccurrence()
	 * @generated
	 * @ordered
	 */
	protected static final String OCCURRENCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOccurrence() <em>Occurrence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOccurrence()
	 * @generated
	 * @ordered
	 */
	protected String occurrence = OCCURRENCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransientDuration() <em>Transient Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransientDuration()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSIENT_DURATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransientDuration() <em>Transient Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransientDuration()
	 * @generated
	 * @ordered
	 */
	protected String transientDuration = TRANSIENT_DURATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InternalFaultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ThreatsPropagationPackage.Literals.INTERNAL_FAULT;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ThreatsPropagationPackage.INTERNAL_FAULT__BASE_TRANSITION, oldBase_Transition, base_Transition));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ThreatsPropagationPackage.INTERNAL_FAULT__BASE_TRANSITION, oldBase_Transition, base_Transition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPermanentProb() {
		return permanentProb;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPermanentProb(String newPermanentProb) {
		String oldPermanentProb = permanentProb;
		permanentProb = newPermanentProb;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ThreatsPropagationPackage.INTERNAL_FAULT__PERMANENT_PROB, oldPermanentProb, permanentProb));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransfFunct() {
		return transfFunct;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransfFunct(String newTransfFunct) {
		String oldTransfFunct = transfFunct;
		transfFunct = newTransfFunct;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ThreatsPropagationPackage.INTERNAL_FAULT__TRANSF_FUNCT, oldTransfFunct, transfFunct));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getProperty() {
		if (property != null && property.eIsProxy()) {
			InternalEObject oldProperty = (InternalEObject)property;
			property = (Property)eResolveProxy(oldProperty);
			if (property != oldProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ThreatsPropagationPackage.INTERNAL_FAULT__PROPERTY, oldProperty, property));
			}
		}
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetProperty() {
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProperty(Property newProperty) {
		Property oldProperty = property;
		property = newProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ThreatsPropagationPackage.INTERNAL_FAULT__PROPERTY, oldProperty, property));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getChildFailure() {
		if (childFailure != null && childFailure.eIsProxy()) {
			InternalEObject oldChildFailure = (InternalEObject)childFailure;
			childFailure = (State)eResolveProxy(oldChildFailure);
			if (childFailure != oldChildFailure) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ThreatsPropagationPackage.INTERNAL_FAULT__CHILD_FAILURE, oldChildFailure, childFailure));
			}
		}
		return childFailure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetChildFailure() {
		return childFailure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChildFailure(State newChildFailure) {
		State oldChildFailure = childFailure;
		childFailure = newChildFailure;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ThreatsPropagationPackage.INTERNAL_FAULT__CHILD_FAILURE, oldChildFailure, childFailure));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOccurrence() {
		return occurrence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOccurrence(String newOccurrence) {
		String oldOccurrence = occurrence;
		occurrence = newOccurrence;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ThreatsPropagationPackage.INTERNAL_FAULT__OCCURRENCE, oldOccurrence, occurrence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransientDuration() {
		return transientDuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransientDuration(String newTransientDuration) {
		String oldTransientDuration = transientDuration;
		transientDuration = newTransientDuration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ThreatsPropagationPackage.INTERNAL_FAULT__TRANSIENT_DURATION, oldTransientDuration, transientDuration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ThreatsPropagationPackage.INTERNAL_FAULT__BASE_TRANSITION:
				if (resolve) return getBase_Transition();
				return basicGetBase_Transition();
			case ThreatsPropagationPackage.INTERNAL_FAULT__PERMANENT_PROB:
				return getPermanentProb();
			case ThreatsPropagationPackage.INTERNAL_FAULT__TRANSF_FUNCT:
				return getTransfFunct();
			case ThreatsPropagationPackage.INTERNAL_FAULT__PROPERTY:
				if (resolve) return getProperty();
				return basicGetProperty();
			case ThreatsPropagationPackage.INTERNAL_FAULT__CHILD_FAILURE:
				if (resolve) return getChildFailure();
				return basicGetChildFailure();
			case ThreatsPropagationPackage.INTERNAL_FAULT__OCCURRENCE:
				return getOccurrence();
			case ThreatsPropagationPackage.INTERNAL_FAULT__TRANSIENT_DURATION:
				return getTransientDuration();
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
			case ThreatsPropagationPackage.INTERNAL_FAULT__BASE_TRANSITION:
				setBase_Transition((Transition)newValue);
				return;
			case ThreatsPropagationPackage.INTERNAL_FAULT__PERMANENT_PROB:
				setPermanentProb((String)newValue);
				return;
			case ThreatsPropagationPackage.INTERNAL_FAULT__TRANSF_FUNCT:
				setTransfFunct((String)newValue);
				return;
			case ThreatsPropagationPackage.INTERNAL_FAULT__PROPERTY:
				setProperty((Property)newValue);
				return;
			case ThreatsPropagationPackage.INTERNAL_FAULT__CHILD_FAILURE:
				setChildFailure((State)newValue);
				return;
			case ThreatsPropagationPackage.INTERNAL_FAULT__OCCURRENCE:
				setOccurrence((String)newValue);
				return;
			case ThreatsPropagationPackage.INTERNAL_FAULT__TRANSIENT_DURATION:
				setTransientDuration((String)newValue);
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
			case ThreatsPropagationPackage.INTERNAL_FAULT__BASE_TRANSITION:
				setBase_Transition((Transition)null);
				return;
			case ThreatsPropagationPackage.INTERNAL_FAULT__PERMANENT_PROB:
				setPermanentProb(PERMANENT_PROB_EDEFAULT);
				return;
			case ThreatsPropagationPackage.INTERNAL_FAULT__TRANSF_FUNCT:
				setTransfFunct(TRANSF_FUNCT_EDEFAULT);
				return;
			case ThreatsPropagationPackage.INTERNAL_FAULT__PROPERTY:
				setProperty((Property)null);
				return;
			case ThreatsPropagationPackage.INTERNAL_FAULT__CHILD_FAILURE:
				setChildFailure((State)null);
				return;
			case ThreatsPropagationPackage.INTERNAL_FAULT__OCCURRENCE:
				setOccurrence(OCCURRENCE_EDEFAULT);
				return;
			case ThreatsPropagationPackage.INTERNAL_FAULT__TRANSIENT_DURATION:
				setTransientDuration(TRANSIENT_DURATION_EDEFAULT);
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
			case ThreatsPropagationPackage.INTERNAL_FAULT__BASE_TRANSITION:
				return base_Transition != null;
			case ThreatsPropagationPackage.INTERNAL_FAULT__PERMANENT_PROB:
				return PERMANENT_PROB_EDEFAULT == null ? permanentProb != null : !PERMANENT_PROB_EDEFAULT.equals(permanentProb);
			case ThreatsPropagationPackage.INTERNAL_FAULT__TRANSF_FUNCT:
				return TRANSF_FUNCT_EDEFAULT == null ? transfFunct != null : !TRANSF_FUNCT_EDEFAULT.equals(transfFunct);
			case ThreatsPropagationPackage.INTERNAL_FAULT__PROPERTY:
				return property != null;
			case ThreatsPropagationPackage.INTERNAL_FAULT__CHILD_FAILURE:
				return childFailure != null;
			case ThreatsPropagationPackage.INTERNAL_FAULT__OCCURRENCE:
				return OCCURRENCE_EDEFAULT == null ? occurrence != null : !OCCURRENCE_EDEFAULT.equals(occurrence);
			case ThreatsPropagationPackage.INTERNAL_FAULT__TRANSIENT_DURATION:
				return TRANSIENT_DURATION_EDEFAULT == null ? transientDuration != null : !TRANSIENT_DURATION_EDEFAULT.equals(transientDuration);
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
		result.append(" (permanentProb: ");
		result.append(permanentProb);
		result.append(", transfFunct: ");
		result.append(transfFunct);
		result.append(", occurrence: ");
		result.append(occurrence);
		result.append(", transientDuration: ");
		result.append(transientDuration);
		result.append(')');
		return result.toString();
	}

} //InternalFaultImpl
