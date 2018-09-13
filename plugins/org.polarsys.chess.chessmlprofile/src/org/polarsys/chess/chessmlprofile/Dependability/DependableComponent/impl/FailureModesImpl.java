/**
 */
package org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Slot;

import org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponentPackage;
import org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.FailureMode;
import org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.FailureModes;

import org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FPTCSpecification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Failure Modes</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.FailureModesImpl#getBase_Slot <em>Base Slot</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.FailureModesImpl#getBase_Port <em>Base Port</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.FailureModesImpl#getFailureMode <em>Failure Mode</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.FailureModesImpl#getFPTCSpecification <em>FPTC Specification</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FailureModesImpl extends EObjectImpl implements FailureModes {
	/**
	 * The cached value of the '{@link #getBase_Slot() <em>Base Slot</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Slot()
	 * @generated
	 * @ordered
	 */
	protected Slot base_Slot;

	/**
	 * The cached value of the '{@link #getBase_Port() <em>Base Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Port()
	 * @generated
	 * @ordered
	 */
	protected Port base_Port;

	/**
	 * The cached value of the '{@link #getFailureMode() <em>Failure Mode</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailureMode()
	 * @generated
	 * @ordered
	 */
	protected EList<FailureMode> failureMode;

	/**
	 * The cached value of the '{@link #getFPTCSpecification() <em>FPTC Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFPTCSpecification()
	 * @generated
	 * @ordered
	 */
	protected FPTCSpecification fptcSpecification;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FailureModesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DependableComponentPackage.Literals.FAILURE_MODES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Slot getBase_Slot() {
		if (base_Slot != null && base_Slot.eIsProxy()) {
			InternalEObject oldBase_Slot = (InternalEObject)base_Slot;
			base_Slot = (Slot)eResolveProxy(oldBase_Slot);
			if (base_Slot != oldBase_Slot) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DependableComponentPackage.FAILURE_MODES__BASE_SLOT, oldBase_Slot, base_Slot));
			}
		}
		return base_Slot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Slot basicGetBase_Slot() {
		return base_Slot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Slot(Slot newBase_Slot) {
		Slot oldBase_Slot = base_Slot;
		base_Slot = newBase_Slot;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependableComponentPackage.FAILURE_MODES__BASE_SLOT, oldBase_Slot, base_Slot));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port getBase_Port() {
		if (base_Port != null && base_Port.eIsProxy()) {
			InternalEObject oldBase_Port = (InternalEObject)base_Port;
			base_Port = (Port)eResolveProxy(oldBase_Port);
			if (base_Port != oldBase_Port) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DependableComponentPackage.FAILURE_MODES__BASE_PORT, oldBase_Port, base_Port));
			}
		}
		return base_Port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port basicGetBase_Port() {
		return base_Port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Port(Port newBase_Port) {
		Port oldBase_Port = base_Port;
		base_Port = newBase_Port;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependableComponentPackage.FAILURE_MODES__BASE_PORT, oldBase_Port, base_Port));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FailureMode> getFailureMode() {
		if (failureMode == null) {
			failureMode = new EObjectResolvingEList<FailureMode>(FailureMode.class, this, DependableComponentPackage.FAILURE_MODES__FAILURE_MODE);
		}
		return failureMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FPTCSpecification getFPTCSpecification() {
		if (fptcSpecification != null && fptcSpecification.eIsProxy()) {
			InternalEObject oldFPTCSpecification = (InternalEObject)fptcSpecification;
			fptcSpecification = (FPTCSpecification)eResolveProxy(oldFPTCSpecification);
			if (fptcSpecification != oldFPTCSpecification) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DependableComponentPackage.FAILURE_MODES__FPTC_SPECIFICATION, oldFPTCSpecification, fptcSpecification));
			}
		}
		return fptcSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FPTCSpecification basicGetFPTCSpecification() {
		return fptcSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFPTCSpecification(FPTCSpecification newFPTCSpecification) {
		FPTCSpecification oldFPTCSpecification = fptcSpecification;
		fptcSpecification = newFPTCSpecification;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependableComponentPackage.FAILURE_MODES__FPTC_SPECIFICATION, oldFPTCSpecification, fptcSpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DependableComponentPackage.FAILURE_MODES__BASE_SLOT:
				if (resolve) return getBase_Slot();
				return basicGetBase_Slot();
			case DependableComponentPackage.FAILURE_MODES__BASE_PORT:
				if (resolve) return getBase_Port();
				return basicGetBase_Port();
			case DependableComponentPackage.FAILURE_MODES__FAILURE_MODE:
				return getFailureMode();
			case DependableComponentPackage.FAILURE_MODES__FPTC_SPECIFICATION:
				if (resolve) return getFPTCSpecification();
				return basicGetFPTCSpecification();
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
			case DependableComponentPackage.FAILURE_MODES__BASE_SLOT:
				setBase_Slot((Slot)newValue);
				return;
			case DependableComponentPackage.FAILURE_MODES__BASE_PORT:
				setBase_Port((Port)newValue);
				return;
			case DependableComponentPackage.FAILURE_MODES__FAILURE_MODE:
				getFailureMode().clear();
				getFailureMode().addAll((Collection<? extends FailureMode>)newValue);
				return;
			case DependableComponentPackage.FAILURE_MODES__FPTC_SPECIFICATION:
				setFPTCSpecification((FPTCSpecification)newValue);
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
			case DependableComponentPackage.FAILURE_MODES__BASE_SLOT:
				setBase_Slot((Slot)null);
				return;
			case DependableComponentPackage.FAILURE_MODES__BASE_PORT:
				setBase_Port((Port)null);
				return;
			case DependableComponentPackage.FAILURE_MODES__FAILURE_MODE:
				getFailureMode().clear();
				return;
			case DependableComponentPackage.FAILURE_MODES__FPTC_SPECIFICATION:
				setFPTCSpecification((FPTCSpecification)null);
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
			case DependableComponentPackage.FAILURE_MODES__BASE_SLOT:
				return base_Slot != null;
			case DependableComponentPackage.FAILURE_MODES__BASE_PORT:
				return base_Port != null;
			case DependableComponentPackage.FAILURE_MODES__FAILURE_MODE:
				return failureMode != null && !failureMode.isEmpty();
			case DependableComponentPackage.FAILURE_MODES__FPTC_SPECIFICATION:
				return fptcSpecification != null;
		}
		return super.eIsSet(featureID);
	}

} //FailureModesImpl
