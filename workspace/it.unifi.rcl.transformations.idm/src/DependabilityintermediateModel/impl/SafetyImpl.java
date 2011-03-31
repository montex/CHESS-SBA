/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package DependabilityintermediateModel.impl;

import DependabilityintermediateModel.DependabilityintermediateModelPackage;
import DependabilityintermediateModel.FailureConsequences;
import DependabilityintermediateModel.Safety;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Safety</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link DependabilityintermediateModel.impl.SafetyImpl#getHazardousLevel <em>Hazardous Level</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SafetyImpl extends DependabilityMeasureImpl implements Safety {
	/**
	 * The default value of the '{@link #getHazardousLevel() <em>Hazardous Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHazardousLevel()
	 * @generated
	 * @ordered
	 */
	protected static final FailureConsequences HAZARDOUS_LEVEL_EDEFAULT = FailureConsequences.INSIGNIFICANT;

	/**
	 * The cached value of the '{@link #getHazardousLevel() <em>Hazardous Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHazardousLevel()
	 * @generated
	 * @ordered
	 */
	protected FailureConsequences hazardousLevel = HAZARDOUS_LEVEL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SafetyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DependabilityintermediateModelPackage.Literals.SAFETY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FailureConsequences getHazardousLevel() {
		return hazardousLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHazardousLevel(FailureConsequences newHazardousLevel) {
		FailureConsequences oldHazardousLevel = hazardousLevel;
		hazardousLevel = newHazardousLevel == null ? HAZARDOUS_LEVEL_EDEFAULT : newHazardousLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependabilityintermediateModelPackage.SAFETY__HAZARDOUS_LEVEL, oldHazardousLevel, hazardousLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DependabilityintermediateModelPackage.SAFETY__HAZARDOUS_LEVEL:
				return getHazardousLevel();
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
			case DependabilityintermediateModelPackage.SAFETY__HAZARDOUS_LEVEL:
				setHazardousLevel((FailureConsequences)newValue);
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
			case DependabilityintermediateModelPackage.SAFETY__HAZARDOUS_LEVEL:
				setHazardousLevel(HAZARDOUS_LEVEL_EDEFAULT);
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
			case DependabilityintermediateModelPackage.SAFETY__HAZARDOUS_LEVEL:
				return hazardousLevel != HAZARDOUS_LEVEL_EDEFAULT;
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
		result.append(" (hazardousLevel: ");
		result.append(hazardousLevel);
		result.append(')');
		return result.toString();
	}

} //SafetyImpl
