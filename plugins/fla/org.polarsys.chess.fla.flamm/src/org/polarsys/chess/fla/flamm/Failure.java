/*******************************************************************************
 *                  CHESS core plugin
 *
 *               Copyright (C) 2011-2015
 *            Mälardalen University, Sweden
 *
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License
 *  v1.0 which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.polarsys.chess.fla.flamm;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.polarsys.chess.fla.flamm.FailureTypes.FailureType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Failure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.chess.fla.flamm.Failure#getType <em>Type</em>}</li>
 *   <li>{@link org.polarsys.chess.fla.flamm.Failure#getId <em>Id</em>}</li>
 *   <li>{@link org.polarsys.chess.fla.flamm.Failure#getAcidAvoidable <em>Acid Avoidable</em>}</li>
 *   <li>{@link org.polarsys.chess.fla.flamm.Failure#getAcidMitigation <em>Acid Mitigation</em>}</li>
 *   <li>{@link org.polarsys.chess.fla.flamm.Failure#getPreviousFailures <em>Previous Failures</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.chess.fla.flamm.FlammPackage#getFailure()
 * @model kind="class"
 * @generated
 */
public class Failure extends MinimalEObjectImpl.Container implements EObject {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final FailureType TYPE_EDEFAULT = FailureType.NO_FAILURE;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected FailureType type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	public static Failure createNoFailure() {
		return new Failure(FailureType.NO_FAILURE, FailureType.NO_FAILURE.getLiteral());
	}
	
	public static Failure createWildcard() {
		return new Failure(FailureType.WILDCARD, FailureType.WILDCARD.getLiteral());
	}
	
	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAcidAvoidable() <em>Acid Avoidable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAcidAvoidable()
	 * @generated
	 * @ordered
	 */
	protected ACIDavoidable acidAvoidable;

	/**
	 * The cached value of the '{@link #getAcidMitigation() <em>Acid Mitigation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAcidMitigation()
	 * @generated
	 * @ordered
	 */
	protected ACIDmitigation acidMitigation;

	/**
	 * The cached value of the '{@link #getPreviousFailures() <em>Previous Failures</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreviousFailures()
	 * @generated
	 * @ordered
	 */
	protected EList<Failure> previousFailures;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Failure() {
		super();
	}

	public Failure(FailureType type, String id) {
		super();
		this.type = type;
		this.id = id;
	}
	
	
	/**
	 * Copy-constructor
	 * @param oldFailure existing Failure to copy
	 */
	public Failure(Failure oldFailure) {
		super();
		this.type = oldFailure.type;
		this.id = oldFailure.id;
	}

	/**
	 * Copy-constructor
	 * @param oldFailure existing Failure to copy
	 */
	public Failure(Failure oldFailure, Failure previousFailure) {
		super();
		this.type = oldFailure.type;
		this.id = oldFailure.id;
		this.addPreviousFailure(previousFailure);
	}

	/**
	 * Copy-constructor
	 * @param oldFailure existing Failure to copy
	 */
	public Failure(Failure oldFailure, Collection<Failure> previousFailures) {
		super();
		this.type = oldFailure.type;
		this.id = oldFailure.id;
		this.addPreviousFailures(previousFailures);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FlammPackage.Literals.FAILURE;
	}

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.polarsys.chess.fla.flamm.FailureTypes.FailureType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.polarsys.chess.fla.flamm.FailureTypes.FailureType
	 * @see #setType(FailureType)
	 * @see org.polarsys.chess.fla.flamm.FlammPackage#getFailure_Type()
	 * @model required="true"
	 * @generated
	 */
	public FailureType getType() {
		return type;
	}

	/**
	 * Sets the value of the '{@link org.polarsys.chess.fla.flamm.Failure#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.polarsys.chess.fla.flamm.FailureTypes.FailureType
	 * @see #getType()
	 * @generated
	 */
	public void setType(FailureType newType) {
		FailureType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FlammPackage.FAILURE__TYPE, oldType, type));
	}

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.polarsys.chess.fla.flamm.FlammPackage#getFailure_Id()
	 * @model
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the value of the '{@link org.polarsys.chess.fla.flamm.Failure#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FlammPackage.FAILURE__ID, oldId, id));
	}

	/**
	 * Returns the value of the '<em><b>Acid Avoidable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Acid Avoidable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Acid Avoidable</em>' containment reference.
	 * @see #setAcidAvoidable(ACIDavoidable)
	 * @see org.polarsys.chess.fla.flamm.FlammPackage#getFailure_AcidAvoidable()
	 * @model containment="true"
	 * @generated
	 */
	public ACIDavoidable getAcidAvoidable() {
		return acidAvoidable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAcidAvoidable(ACIDavoidable newAcidAvoidable, NotificationChain msgs) {
		ACIDavoidable oldAcidAvoidable = acidAvoidable;
		acidAvoidable = newAcidAvoidable;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FlammPackage.FAILURE__ACID_AVOIDABLE, oldAcidAvoidable, newAcidAvoidable);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link org.polarsys.chess.fla.flamm.Failure#getAcidAvoidable <em>Acid Avoidable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Acid Avoidable</em>' containment reference.
	 * @see #getAcidAvoidable()
	 * @generated
	 */
	public void setAcidAvoidable(ACIDavoidable newAcidAvoidable) {
		if (newAcidAvoidable != acidAvoidable) {
			NotificationChain msgs = null;
			if (acidAvoidable != null)
				msgs = ((InternalEObject)acidAvoidable).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FlammPackage.FAILURE__ACID_AVOIDABLE, null, msgs);
			if (newAcidAvoidable != null)
				msgs = ((InternalEObject)newAcidAvoidable).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FlammPackage.FAILURE__ACID_AVOIDABLE, null, msgs);
			msgs = basicSetAcidAvoidable(newAcidAvoidable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FlammPackage.FAILURE__ACID_AVOIDABLE, newAcidAvoidable, newAcidAvoidable));
	}

	/**
	 * Returns the value of the '<em><b>Acid Mitigation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Acid Mitigation</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Acid Mitigation</em>' containment reference.
	 * @see #setAcidMitigation(ACIDmitigation)
	 * @see org.polarsys.chess.fla.flamm.FlammPackage#getFailure_AcidMitigation()
	 * @model containment="true"
	 * @generated
	 */
	public ACIDmitigation getAcidMitigation() {
		return acidMitigation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAcidMitigation(ACIDmitigation newAcidMitigation, NotificationChain msgs) {
		ACIDmitigation oldAcidMitigation = acidMitigation;
		acidMitigation = newAcidMitigation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FlammPackage.FAILURE__ACID_MITIGATION, oldAcidMitigation, newAcidMitigation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link org.polarsys.chess.fla.flamm.Failure#getAcidMitigation <em>Acid Mitigation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Acid Mitigation</em>' containment reference.
	 * @see #getAcidMitigation()
	 * @generated
	 */
	public void setAcidMitigation(ACIDmitigation newAcidMitigation) {
		if (newAcidMitigation != acidMitigation) {
			NotificationChain msgs = null;
			if (acidMitigation != null)
				msgs = ((InternalEObject)acidMitigation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FlammPackage.FAILURE__ACID_MITIGATION, null, msgs);
			if (newAcidMitigation != null)
				msgs = ((InternalEObject)newAcidMitigation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FlammPackage.FAILURE__ACID_MITIGATION, null, msgs);
			msgs = basicSetAcidMitigation(newAcidMitigation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FlammPackage.FAILURE__ACID_MITIGATION, newAcidMitigation, newAcidMitigation));
	}
	
	/**
	 * Returns the value of the '<em><b>Previous Failures</b></em>' reference list.
	 * The list contents are of type {@link org.polarsys.chess.fla.flamm.Failure}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Previous Failures</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Previous Failures</em>' reference list.
	 * @see org.polarsys.chess.fla.flamm.FlammPackage#getFailure_PreviousFailures()
	 * @model
	 * @generated
	 */
	public List<Failure> getPreviousFailures() {
		if (previousFailures == null) {
			previousFailures = new EObjectResolvingEList<Failure>(Failure.class, this, FlammPackage.FAILURE__PREVIOUS_FAILURES);
		}
		return previousFailures;
	}
	
	public void addPreviousFailure(Failure previousFailure) {
		if (!getPreviousFailures().contains(previousFailure)) {
			getPreviousFailures().add(previousFailure);
		}
	}

	public void addPreviousFailures(Collection<Failure> previousFailures) {
		for (Failure failure : previousFailures) {
			addPreviousFailure(failure);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FlammPackage.FAILURE__ACID_AVOIDABLE:
				return basicSetAcidAvoidable(null, msgs);
			case FlammPackage.FAILURE__ACID_MITIGATION:
				return basicSetAcidMitigation(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	public boolean isSameFailure(Failure other) {
		if (this == other)
			return true;
		if (other == null)
			return false;
		if (type != other.type)
			return false;
		if (id == null)
			return false;
		if (!id.equals(other.id))
			return false;
		return true;
	}

	public static boolean doCollectionContainFailure(Collection<Failure> collection, Failure failure) {
		for (Failure listFailure : collection) {
			if (listFailure.getId().equals(failure.getId())) {
				return true;
			}
		}
		return false;
	}

	public static Failure getFailureInCollection(Collection<Failure> collection, Failure failure) {
		for (Failure listFailure : collection) {
			if (listFailure.getId().equals(failure.getId())) {
				return listFailure;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FlammPackage.FAILURE__TYPE:
				return getType();
			case FlammPackage.FAILURE__ID:
				return getId();
			case FlammPackage.FAILURE__ACID_AVOIDABLE:
				return getAcidAvoidable();
			case FlammPackage.FAILURE__ACID_MITIGATION:
				return getAcidMitigation();
			case FlammPackage.FAILURE__PREVIOUS_FAILURES:
				return getPreviousFailures();
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
			case FlammPackage.FAILURE__TYPE:
				setType((FailureType)newValue);
				return;
			case FlammPackage.FAILURE__ID:
				setId((String)newValue);
				return;
			case FlammPackage.FAILURE__ACID_AVOIDABLE:
				setAcidAvoidable((ACIDavoidable)newValue);
				return;
			case FlammPackage.FAILURE__ACID_MITIGATION:
				setAcidMitigation((ACIDmitigation)newValue);
				return;
			case FlammPackage.FAILURE__PREVIOUS_FAILURES:
				getPreviousFailures().clear();
				getPreviousFailures().addAll((Collection<? extends Failure>)newValue);
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
			case FlammPackage.FAILURE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case FlammPackage.FAILURE__ID:
				setId(ID_EDEFAULT);
				return;
			case FlammPackage.FAILURE__ACID_AVOIDABLE:
				setAcidAvoidable((ACIDavoidable)null);
				return;
			case FlammPackage.FAILURE__ACID_MITIGATION:
				setAcidMitigation((ACIDmitigation)null);
				return;
			case FlammPackage.FAILURE__PREVIOUS_FAILURES:
				getPreviousFailures().clear();
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
			case FlammPackage.FAILURE__TYPE:
				return type != TYPE_EDEFAULT;
			case FlammPackage.FAILURE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case FlammPackage.FAILURE__ACID_AVOIDABLE:
				return acidAvoidable != null;
			case FlammPackage.FAILURE__ACID_MITIGATION:
				return acidMitigation != null;
			case FlammPackage.FAILURE__PREVIOUS_FAILURES:
				return previousFailures != null && !previousFailures.isEmpty();
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
		result.append(", id: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

} // Failure
