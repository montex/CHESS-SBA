/**
 */
package org.polarsys.chess.patterns.profile.PatternsProfile.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.uml2.uml.NamedElement;

import org.polarsys.chess.patterns.profile.PatternsProfile.PatternRole;
import org.polarsys.chess.patterns.profile.PatternsProfile.PatternsProfilePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pattern Role</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.patterns.profile.PatternsProfile.impl.PatternRoleImpl#getBase_NamedElement <em>Base Named Element</em>}</li>
 *   <li>{@link org.polarsys.chess.patterns.profile.PatternsProfile.impl.PatternRoleImpl#getAppliedPattern <em>Applied Pattern</em>}</li>
 *   <li>{@link org.polarsys.chess.patterns.profile.PatternsProfile.impl.PatternRoleImpl#getMappedRole <em>Mapped Role</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PatternRoleImpl extends MinimalEObjectImpl.Container implements PatternRole {
	/**
	 * The cached value of the '{@link #getBase_NamedElement() <em>Base Named Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_NamedElement()
	 * @generated
	 * @ordered
	 */
	protected NamedElement base_NamedElement;

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
	 * The default value of the '{@link #getMappedRole() <em>Mapped Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappedRole()
	 * @generated
	 * @ordered
	 */
	protected static final String MAPPED_ROLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMappedRole() <em>Mapped Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappedRole()
	 * @generated
	 * @ordered
	 */
	protected String mappedRole = MAPPED_ROLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PatternRoleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PatternsProfilePackage.Literals.PATTERN_ROLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement getBase_NamedElement() {
		if (base_NamedElement != null && base_NamedElement.eIsProxy()) {
			InternalEObject oldBase_NamedElement = (InternalEObject)base_NamedElement;
			base_NamedElement = (NamedElement)eResolveProxy(oldBase_NamedElement);
			if (base_NamedElement != oldBase_NamedElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PatternsProfilePackage.PATTERN_ROLE__BASE_NAMED_ELEMENT, oldBase_NamedElement, base_NamedElement));
			}
		}
		return base_NamedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement basicGetBase_NamedElement() {
		return base_NamedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_NamedElement(NamedElement newBase_NamedElement) {
		NamedElement oldBase_NamedElement = base_NamedElement;
		base_NamedElement = newBase_NamedElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PatternsProfilePackage.PATTERN_ROLE__BASE_NAMED_ELEMENT, oldBase_NamedElement, base_NamedElement));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PatternsProfilePackage.PATTERN_ROLE__APPLIED_PATTERN, oldAppliedPattern, appliedPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMappedRole() {
		return mappedRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMappedRole(String newMappedRole) {
		String oldMappedRole = mappedRole;
		mappedRole = newMappedRole;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PatternsProfilePackage.PATTERN_ROLE__MAPPED_ROLE, oldMappedRole, mappedRole));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PatternsProfilePackage.PATTERN_ROLE__BASE_NAMED_ELEMENT:
				if (resolve) return getBase_NamedElement();
				return basicGetBase_NamedElement();
			case PatternsProfilePackage.PATTERN_ROLE__APPLIED_PATTERN:
				return getAppliedPattern();
			case PatternsProfilePackage.PATTERN_ROLE__MAPPED_ROLE:
				return getMappedRole();
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
			case PatternsProfilePackage.PATTERN_ROLE__BASE_NAMED_ELEMENT:
				setBase_NamedElement((NamedElement)newValue);
				return;
			case PatternsProfilePackage.PATTERN_ROLE__APPLIED_PATTERN:
				setAppliedPattern((String)newValue);
				return;
			case PatternsProfilePackage.PATTERN_ROLE__MAPPED_ROLE:
				setMappedRole((String)newValue);
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
			case PatternsProfilePackage.PATTERN_ROLE__BASE_NAMED_ELEMENT:
				setBase_NamedElement((NamedElement)null);
				return;
			case PatternsProfilePackage.PATTERN_ROLE__APPLIED_PATTERN:
				setAppliedPattern(APPLIED_PATTERN_EDEFAULT);
				return;
			case PatternsProfilePackage.PATTERN_ROLE__MAPPED_ROLE:
				setMappedRole(MAPPED_ROLE_EDEFAULT);
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
			case PatternsProfilePackage.PATTERN_ROLE__BASE_NAMED_ELEMENT:
				return base_NamedElement != null;
			case PatternsProfilePackage.PATTERN_ROLE__APPLIED_PATTERN:
				return APPLIED_PATTERN_EDEFAULT == null ? appliedPattern != null : !APPLIED_PATTERN_EDEFAULT.equals(appliedPattern);
			case PatternsProfilePackage.PATTERN_ROLE__MAPPED_ROLE:
				return MAPPED_ROLE_EDEFAULT == null ? mappedRole != null : !MAPPED_ROLE_EDEFAULT.equals(mappedRole);
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
		result.append(", mappedRole: ");
		result.append(mappedRole);
		result.append(')');
		return result.toString();
	}

} //PatternRoleImpl
