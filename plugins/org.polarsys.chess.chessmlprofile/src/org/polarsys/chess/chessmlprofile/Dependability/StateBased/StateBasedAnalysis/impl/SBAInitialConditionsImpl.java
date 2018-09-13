/**
 */
package org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.uml2.uml.InstanceSpecification;

import org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.SBAInitialConditions;
import org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.StateBasedAnalysisPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SBA Initial Conditions</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.impl.SBAInitialConditionsImpl#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.impl.SBAInitialConditionsImpl#getTargetInstance <em>Target Instance</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.impl.SBAInitialConditionsImpl#getSetup <em>Setup</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SBAInitialConditionsImpl extends EObjectImpl implements SBAInitialConditions {
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
	 * The cached value of the '{@link #getTargetInstance() <em>Target Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetInstance()
	 * @generated
	 * @ordered
	 */
	protected InstanceSpecification targetInstance;

	/**
	 * The default value of the '{@link #getSetup() <em>Setup</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSetup()
	 * @generated
	 * @ordered
	 */
	protected static final String SETUP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSetup() <em>Setup</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSetup()
	 * @generated
	 * @ordered
	 */
	protected String setup = SETUP_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SBAInitialConditionsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StateBasedAnalysisPackage.Literals.SBA_INITIAL_CONDITIONS;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StateBasedAnalysisPackage.SBA_INITIAL_CONDITIONS__BASE_CLASS, oldBase_Class, base_Class));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StateBasedAnalysisPackage.SBA_INITIAL_CONDITIONS__BASE_CLASS, oldBase_Class, base_Class));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceSpecification getTargetInstance() {
		if (targetInstance != null && targetInstance.eIsProxy()) {
			InternalEObject oldTargetInstance = (InternalEObject)targetInstance;
			targetInstance = (InstanceSpecification)eResolveProxy(oldTargetInstance);
			if (targetInstance != oldTargetInstance) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StateBasedAnalysisPackage.SBA_INITIAL_CONDITIONS__TARGET_INSTANCE, oldTargetInstance, targetInstance));
			}
		}
		return targetInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceSpecification basicGetTargetInstance() {
		return targetInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetInstance(InstanceSpecification newTargetInstance) {
		InstanceSpecification oldTargetInstance = targetInstance;
		targetInstance = newTargetInstance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StateBasedAnalysisPackage.SBA_INITIAL_CONDITIONS__TARGET_INSTANCE, oldTargetInstance, targetInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSetup() {
		return setup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSetup(String newSetup) {
		String oldSetup = setup;
		setup = newSetup;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StateBasedAnalysisPackage.SBA_INITIAL_CONDITIONS__SETUP, oldSetup, setup));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StateBasedAnalysisPackage.SBA_INITIAL_CONDITIONS__BASE_CLASS:
				if (resolve) return getBase_Class();
				return basicGetBase_Class();
			case StateBasedAnalysisPackage.SBA_INITIAL_CONDITIONS__TARGET_INSTANCE:
				if (resolve) return getTargetInstance();
				return basicGetTargetInstance();
			case StateBasedAnalysisPackage.SBA_INITIAL_CONDITIONS__SETUP:
				return getSetup();
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
			case StateBasedAnalysisPackage.SBA_INITIAL_CONDITIONS__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)newValue);
				return;
			case StateBasedAnalysisPackage.SBA_INITIAL_CONDITIONS__TARGET_INSTANCE:
				setTargetInstance((InstanceSpecification)newValue);
				return;
			case StateBasedAnalysisPackage.SBA_INITIAL_CONDITIONS__SETUP:
				setSetup((String)newValue);
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
			case StateBasedAnalysisPackage.SBA_INITIAL_CONDITIONS__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)null);
				return;
			case StateBasedAnalysisPackage.SBA_INITIAL_CONDITIONS__TARGET_INSTANCE:
				setTargetInstance((InstanceSpecification)null);
				return;
			case StateBasedAnalysisPackage.SBA_INITIAL_CONDITIONS__SETUP:
				setSetup(SETUP_EDEFAULT);
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
			case StateBasedAnalysisPackage.SBA_INITIAL_CONDITIONS__BASE_CLASS:
				return base_Class != null;
			case StateBasedAnalysisPackage.SBA_INITIAL_CONDITIONS__TARGET_INSTANCE:
				return targetInstance != null;
			case StateBasedAnalysisPackage.SBA_INITIAL_CONDITIONS__SETUP:
				return SETUP_EDEFAULT == null ? setup != null : !SETUP_EDEFAULT.equals(setup);
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
		result.append(" (setup: ");
		result.append(setup);
		result.append(')');
		return result.toString();
	}

} //SBAInitialConditionsImpl
