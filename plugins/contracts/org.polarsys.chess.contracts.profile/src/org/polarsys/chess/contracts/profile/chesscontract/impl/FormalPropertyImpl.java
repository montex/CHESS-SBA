/**
 */
package org.polarsys.chess.contracts.profile.chesscontract.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.sysml.requirements.Requirement;
import org.eclipse.uml2.uml.Constraint;

import org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage;
import org.polarsys.chess.contracts.profile.chesscontract.FormalProperty;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Formal Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.impl.FormalPropertyImpl#getBase_Constraint <em>Base Constraint</em>}</li>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.impl.FormalPropertyImpl#getFormalize <em>Formalize</em>}</li>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.impl.FormalPropertyImpl#getGoto <em>Goto</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FormalPropertyImpl extends MinimalEObjectImpl.Container implements FormalProperty {
	/**
	 * The cached value of the '{@link #getBase_Constraint() <em>Base Constraint</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Constraint()
	 * @generated
	 * @ordered
	 */
	protected Constraint base_Constraint;

	/**
	 * The cached value of the '{@link #getFormalize() <em>Formalize</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormalize()
	 * @generated
	 * @ordered
	 */
	protected Requirement formalize;

	/**
	 * The cached value of the '{@link #getGoto() <em>Goto</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGoto()
	 * @generated
	 * @ordered
	 */
	protected EObject goto_;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FormalPropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CHESSContractPackage.Literals.FORMAL_PROPERTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Constraint getBase_Constraint() {
		if (base_Constraint != null && base_Constraint.eIsProxy()) {
			InternalEObject oldBase_Constraint = (InternalEObject)base_Constraint;
			base_Constraint = (Constraint)eResolveProxy(oldBase_Constraint);
			if (base_Constraint != oldBase_Constraint) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CHESSContractPackage.FORMAL_PROPERTY__BASE_CONSTRAINT, oldBase_Constraint, base_Constraint));
			}
		}
		return base_Constraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Constraint basicGetBase_Constraint() {
		return base_Constraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Constraint(Constraint newBase_Constraint) {
		Constraint oldBase_Constraint = base_Constraint;
		base_Constraint = newBase_Constraint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CHESSContractPackage.FORMAL_PROPERTY__BASE_CONSTRAINT, oldBase_Constraint, base_Constraint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Requirement getFormalize() {
		if (formalize != null && formalize.eIsProxy()) {
			InternalEObject oldFormalize = (InternalEObject)formalize;
			formalize = (Requirement)eResolveProxy(oldFormalize);
			if (formalize != oldFormalize) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CHESSContractPackage.FORMAL_PROPERTY__FORMALIZE, oldFormalize, formalize));
			}
		}
		return formalize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Requirement basicGetFormalize() {
		return formalize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFormalize(Requirement newFormalize) {
		Requirement oldFormalize = formalize;
		formalize = newFormalize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CHESSContractPackage.FORMAL_PROPERTY__FORMALIZE, oldFormalize, formalize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getGoto() {
		if (goto_ != null && goto_.eIsProxy()) {
			InternalEObject oldGoto = (InternalEObject)goto_;
			goto_ = eResolveProxy(oldGoto);
			if (goto_ != oldGoto) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CHESSContractPackage.FORMAL_PROPERTY__GOTO, oldGoto, goto_));
			}
		}
		return goto_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetGoto() {
		return goto_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGoto(EObject newGoto) {
		EObject oldGoto = goto_;
		goto_ = newGoto;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CHESSContractPackage.FORMAL_PROPERTY__GOTO, oldGoto, goto_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CHESSContractPackage.FORMAL_PROPERTY__BASE_CONSTRAINT:
				if (resolve) return getBase_Constraint();
				return basicGetBase_Constraint();
			case CHESSContractPackage.FORMAL_PROPERTY__FORMALIZE:
				if (resolve) return getFormalize();
				return basicGetFormalize();
			case CHESSContractPackage.FORMAL_PROPERTY__GOTO:
				if (resolve) return getGoto();
				return basicGetGoto();
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
			case CHESSContractPackage.FORMAL_PROPERTY__BASE_CONSTRAINT:
				setBase_Constraint((Constraint)newValue);
				return;
			case CHESSContractPackage.FORMAL_PROPERTY__FORMALIZE:
				setFormalize((Requirement)newValue);
				return;
			case CHESSContractPackage.FORMAL_PROPERTY__GOTO:
				setGoto((EObject)newValue);
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
			case CHESSContractPackage.FORMAL_PROPERTY__BASE_CONSTRAINT:
				setBase_Constraint((Constraint)null);
				return;
			case CHESSContractPackage.FORMAL_PROPERTY__FORMALIZE:
				setFormalize((Requirement)null);
				return;
			case CHESSContractPackage.FORMAL_PROPERTY__GOTO:
				setGoto((EObject)null);
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
			case CHESSContractPackage.FORMAL_PROPERTY__BASE_CONSTRAINT:
				return base_Constraint != null;
			case CHESSContractPackage.FORMAL_PROPERTY__FORMALIZE:
				return formalize != null;
			case CHESSContractPackage.FORMAL_PROPERTY__GOTO:
				return goto_ != null;
		}
		return super.eIsSet(featureID);
	}

} //FormalPropertyImpl
