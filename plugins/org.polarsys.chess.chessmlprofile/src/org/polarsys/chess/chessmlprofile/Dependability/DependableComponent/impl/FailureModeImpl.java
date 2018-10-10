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
package org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponentPackage;
import org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.FailureMode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Failure Mode</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.FailureModeImpl#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.FailureModeImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.FailureModeImpl#getSeverity <em>Severity</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.FailureModeImpl#getExposure <em>Exposure</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.FailureModeImpl#getControllability <em>Controllability</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.FailureModeImpl#getLikelihood <em>Likelihood</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FailureModeImpl extends EObjectImpl implements FailureMode {
	/**
	 * The cached value of the '{@link #getBase_Class() <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Class()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Class base_Class;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getSeverity() <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeverity()
	 * @generated
	 * @ordered
	 */
	protected static final String SEVERITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSeverity() <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeverity()
	 * @generated
	 * @ordered
	 */
	protected String severity = SEVERITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getExposure() <em>Exposure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExposure()
	 * @generated
	 * @ordered
	 */
	protected static final String EXPOSURE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExposure() <em>Exposure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExposure()
	 * @generated
	 * @ordered
	 */
	protected String exposure = EXPOSURE_EDEFAULT;

	/**
	 * The default value of the '{@link #getControllability() <em>Controllability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControllability()
	 * @generated
	 * @ordered
	 */
	protected static final String CONTROLLABILITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getControllability() <em>Controllability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControllability()
	 * @generated
	 * @ordered
	 */
	protected String controllability = CONTROLLABILITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getLikelihood() <em>Likelihood</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLikelihood()
	 * @generated
	 * @ordered
	 */
	protected static final String LIKELIHOOD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLikelihood() <em>Likelihood</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLikelihood()
	 * @generated
	 * @ordered
	 */
	protected String likelihood = LIKELIHOOD_EDEFAULT;

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
		return DependableComponentPackage.Literals.FAILURE_MODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class getBase_Class() {
		if (base_Class != null && base_Class.eIsProxy()) {
			InternalEObject oldBase_Class = (InternalEObject)base_Class;
			base_Class = (org.eclipse.uml2.uml.Class)eResolveProxy(oldBase_Class);
			if (base_Class != oldBase_Class) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DependableComponentPackage.FAILURE_MODE__BASE_CLASS, oldBase_Class, base_Class));
			}
		}
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class basicGetBase_Class() {
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Class(org.eclipse.uml2.uml.Class newBase_Class) {
		org.eclipse.uml2.uml.Class oldBase_Class = base_Class;
		base_Class = newBase_Class;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependableComponentPackage.FAILURE_MODE__BASE_CLASS, oldBase_Class, base_Class));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependableComponentPackage.FAILURE_MODE__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSeverity() {
		return severity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSeverity(String newSeverity) {
		String oldSeverity = severity;
		severity = newSeverity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependableComponentPackage.FAILURE_MODE__SEVERITY, oldSeverity, severity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExposure() {
		return exposure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExposure(String newExposure) {
		String oldExposure = exposure;
		exposure = newExposure;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependableComponentPackage.FAILURE_MODE__EXPOSURE, oldExposure, exposure));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getControllability() {
		return controllability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setControllability(String newControllability) {
		String oldControllability = controllability;
		controllability = newControllability;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependableComponentPackage.FAILURE_MODE__CONTROLLABILITY, oldControllability, controllability));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLikelihood() {
		return likelihood;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLikelihood(String newLikelihood) {
		String oldLikelihood = likelihood;
		likelihood = newLikelihood;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependableComponentPackage.FAILURE_MODE__LIKELIHOOD, oldLikelihood, likelihood));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DependableComponentPackage.FAILURE_MODE__BASE_CLASS:
				if (resolve) return getBase_Class();
				return basicGetBase_Class();
			case DependableComponentPackage.FAILURE_MODE__DESCRIPTION:
				return getDescription();
			case DependableComponentPackage.FAILURE_MODE__SEVERITY:
				return getSeverity();
			case DependableComponentPackage.FAILURE_MODE__EXPOSURE:
				return getExposure();
			case DependableComponentPackage.FAILURE_MODE__CONTROLLABILITY:
				return getControllability();
			case DependableComponentPackage.FAILURE_MODE__LIKELIHOOD:
				return getLikelihood();
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
			case DependableComponentPackage.FAILURE_MODE__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)newValue);
				return;
			case DependableComponentPackage.FAILURE_MODE__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case DependableComponentPackage.FAILURE_MODE__SEVERITY:
				setSeverity((String)newValue);
				return;
			case DependableComponentPackage.FAILURE_MODE__EXPOSURE:
				setExposure((String)newValue);
				return;
			case DependableComponentPackage.FAILURE_MODE__CONTROLLABILITY:
				setControllability((String)newValue);
				return;
			case DependableComponentPackage.FAILURE_MODE__LIKELIHOOD:
				setLikelihood((String)newValue);
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
			case DependableComponentPackage.FAILURE_MODE__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)null);
				return;
			case DependableComponentPackage.FAILURE_MODE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case DependableComponentPackage.FAILURE_MODE__SEVERITY:
				setSeverity(SEVERITY_EDEFAULT);
				return;
			case DependableComponentPackage.FAILURE_MODE__EXPOSURE:
				setExposure(EXPOSURE_EDEFAULT);
				return;
			case DependableComponentPackage.FAILURE_MODE__CONTROLLABILITY:
				setControllability(CONTROLLABILITY_EDEFAULT);
				return;
			case DependableComponentPackage.FAILURE_MODE__LIKELIHOOD:
				setLikelihood(LIKELIHOOD_EDEFAULT);
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
			case DependableComponentPackage.FAILURE_MODE__BASE_CLASS:
				return base_Class != null;
			case DependableComponentPackage.FAILURE_MODE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case DependableComponentPackage.FAILURE_MODE__SEVERITY:
				return SEVERITY_EDEFAULT == null ? severity != null : !SEVERITY_EDEFAULT.equals(severity);
			case DependableComponentPackage.FAILURE_MODE__EXPOSURE:
				return EXPOSURE_EDEFAULT == null ? exposure != null : !EXPOSURE_EDEFAULT.equals(exposure);
			case DependableComponentPackage.FAILURE_MODE__CONTROLLABILITY:
				return CONTROLLABILITY_EDEFAULT == null ? controllability != null : !CONTROLLABILITY_EDEFAULT.equals(controllability);
			case DependableComponentPackage.FAILURE_MODE__LIKELIHOOD:
				return LIKELIHOOD_EDEFAULT == null ? likelihood != null : !LIKELIHOOD_EDEFAULT.equals(likelihood);
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
		result.append(" (description: ");
		result.append(description);
		result.append(", severity: ");
		result.append(severity);
		result.append(", exposure: ");
		result.append(exposure);
		result.append(", controllability: ");
		result.append(controllability);
		result.append(", likelihood: ");
		result.append(likelihood);
		result.append(')');
		return result.toString();
	}

} //FailureModeImpl
