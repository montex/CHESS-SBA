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
import org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.Threat;
import org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.ThreatType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Threat</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.ThreatImpl#getFailuremode <em>Failuremode</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.ThreatImpl#getBase_Port <em>Base Port</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.ThreatImpl#getBase_Slot <em>Base Slot</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.ThreatImpl#getKind <em>Kind</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ThreatImpl extends EObjectImpl implements Threat {
	/**
	 * The cached value of the '{@link #getFailuremode() <em>Failuremode</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailuremode()
	 * @generated
	 * @ordered
	 */
	protected EList<FailureMode> failuremode;

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
	 * The cached value of the '{@link #getBase_Slot() <em>Base Slot</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Slot()
	 * @generated
	 * @ordered
	 */
	protected Slot base_Slot;

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final ThreatType KIND_EDEFAULT = ThreatType.UNAUTHORIZED_ACCESS_OF_SERVICE;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected ThreatType kind = KIND_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ThreatImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DependableComponentPackage.Literals.THREAT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FailureMode> getFailuremode() {
		if (failuremode == null) {
			failuremode = new EObjectResolvingEList<FailureMode>(FailureMode.class, this, DependableComponentPackage.THREAT__FAILUREMODE);
		}
		return failuremode;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DependableComponentPackage.THREAT__BASE_PORT, oldBase_Port, base_Port));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DependableComponentPackage.THREAT__BASE_PORT, oldBase_Port, base_Port));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DependableComponentPackage.THREAT__BASE_SLOT, oldBase_Slot, base_Slot));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DependableComponentPackage.THREAT__BASE_SLOT, oldBase_Slot, base_Slot));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThreatType getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(ThreatType newKind) {
		ThreatType oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependableComponentPackage.THREAT__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DependableComponentPackage.THREAT__FAILUREMODE:
				return getFailuremode();
			case DependableComponentPackage.THREAT__BASE_PORT:
				if (resolve) return getBase_Port();
				return basicGetBase_Port();
			case DependableComponentPackage.THREAT__BASE_SLOT:
				if (resolve) return getBase_Slot();
				return basicGetBase_Slot();
			case DependableComponentPackage.THREAT__KIND:
				return getKind();
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
			case DependableComponentPackage.THREAT__FAILUREMODE:
				getFailuremode().clear();
				getFailuremode().addAll((Collection<? extends FailureMode>)newValue);
				return;
			case DependableComponentPackage.THREAT__BASE_PORT:
				setBase_Port((Port)newValue);
				return;
			case DependableComponentPackage.THREAT__BASE_SLOT:
				setBase_Slot((Slot)newValue);
				return;
			case DependableComponentPackage.THREAT__KIND:
				setKind((ThreatType)newValue);
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
			case DependableComponentPackage.THREAT__FAILUREMODE:
				getFailuremode().clear();
				return;
			case DependableComponentPackage.THREAT__BASE_PORT:
				setBase_Port((Port)null);
				return;
			case DependableComponentPackage.THREAT__BASE_SLOT:
				setBase_Slot((Slot)null);
				return;
			case DependableComponentPackage.THREAT__KIND:
				setKind(KIND_EDEFAULT);
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
			case DependableComponentPackage.THREAT__FAILUREMODE:
				return failuremode != null && !failuremode.isEmpty();
			case DependableComponentPackage.THREAT__BASE_PORT:
				return base_Port != null;
			case DependableComponentPackage.THREAT__BASE_SLOT:
				return base_Slot != null;
			case DependableComponentPackage.THREAT__KIND:
				return kind != KIND_EDEFAULT;
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
		result.append(" (kind: ");
		result.append(kind);
		result.append(')');
		return result.toString();
	}

} //ThreatImpl
