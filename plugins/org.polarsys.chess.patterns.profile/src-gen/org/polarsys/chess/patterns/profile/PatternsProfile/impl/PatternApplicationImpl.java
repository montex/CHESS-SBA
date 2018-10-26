/**
 */
package org.polarsys.chess.patterns.profile.PatternsProfile.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.uml2.uml.CollaborationUse;

import org.polarsys.chess.patterns.profile.PatternsProfile.PatternApplication;
import org.polarsys.chess.patterns.profile.PatternsProfile.PatternsProfilePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pattern Application</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.patterns.profile.PatternsProfile.impl.PatternApplicationImpl#getAppliedPattern <em>Applied Pattern</em>}</li>
 *   <li>{@link org.polarsys.chess.patterns.profile.PatternsProfile.impl.PatternApplicationImpl#getBase_CollaborationUse <em>Base Collaboration Use</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PatternApplicationImpl extends MinimalEObjectImpl.Container implements PatternApplication {
	/**
	 * The default value of the '{@link #getAppliedPattern() <em>Applied Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAppliedPattern()
	 * @generated
	 * @ordered
	 */
	protected static final String APPLIED_PATTERN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAppliedPattern() <em>Applied Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAppliedPattern()
	 * @generated
	 * @ordered
	 */
	protected String appliedPattern = APPLIED_PATTERN_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBase_CollaborationUse() <em>Base Collaboration Use</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_CollaborationUse()
	 * @generated
	 * @ordered
	 */
	protected CollaborationUse base_CollaborationUse;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PatternApplicationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PatternsProfilePackage.Literals.PATTERN_APPLICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAppliedPattern() {
		return appliedPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAppliedPattern(String newAppliedPattern) {
		String oldAppliedPattern = appliedPattern;
		appliedPattern = newAppliedPattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PatternsProfilePackage.PATTERN_APPLICATION__APPLIED_PATTERN, oldAppliedPattern, appliedPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollaborationUse getBase_CollaborationUse() {
		if (base_CollaborationUse != null && base_CollaborationUse.eIsProxy()) {
			InternalEObject oldBase_CollaborationUse = (InternalEObject)base_CollaborationUse;
			base_CollaborationUse = (CollaborationUse)eResolveProxy(oldBase_CollaborationUse);
			if (base_CollaborationUse != oldBase_CollaborationUse) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PatternsProfilePackage.PATTERN_APPLICATION__BASE_COLLABORATION_USE, oldBase_CollaborationUse, base_CollaborationUse));
			}
		}
		return base_CollaborationUse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollaborationUse basicGetBase_CollaborationUse() {
		return base_CollaborationUse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_CollaborationUse(CollaborationUse newBase_CollaborationUse) {
		CollaborationUse oldBase_CollaborationUse = base_CollaborationUse;
		base_CollaborationUse = newBase_CollaborationUse;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PatternsProfilePackage.PATTERN_APPLICATION__BASE_COLLABORATION_USE, oldBase_CollaborationUse, base_CollaborationUse));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PatternsProfilePackage.PATTERN_APPLICATION__APPLIED_PATTERN:
				return getAppliedPattern();
			case PatternsProfilePackage.PATTERN_APPLICATION__BASE_COLLABORATION_USE:
				if (resolve) return getBase_CollaborationUse();
				return basicGetBase_CollaborationUse();
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
			case PatternsProfilePackage.PATTERN_APPLICATION__APPLIED_PATTERN:
				setAppliedPattern((String)newValue);
				return;
			case PatternsProfilePackage.PATTERN_APPLICATION__BASE_COLLABORATION_USE:
				setBase_CollaborationUse((CollaborationUse)newValue);
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
			case PatternsProfilePackage.PATTERN_APPLICATION__APPLIED_PATTERN:
				setAppliedPattern(APPLIED_PATTERN_EDEFAULT);
				return;
			case PatternsProfilePackage.PATTERN_APPLICATION__BASE_COLLABORATION_USE:
				setBase_CollaborationUse((CollaborationUse)null);
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
			case PatternsProfilePackage.PATTERN_APPLICATION__APPLIED_PATTERN:
				return APPLIED_PATTERN_EDEFAULT == null ? appliedPattern != null : !APPLIED_PATTERN_EDEFAULT.equals(appliedPattern);
			case PatternsProfilePackage.PATTERN_APPLICATION__BASE_COLLABORATION_USE:
				return base_CollaborationUse != null;
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
		result.append(" (appliedPattern: ");
		result.append(appliedPattern);
		result.append(')');
		return result.toString();
	}

} //PatternApplicationImpl
