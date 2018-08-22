/**
 */
package org.polarsys.chess.contracts.profile.chesscontract.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.sysml.requirements.Requirement;
import org.eclipse.uml2.uml.Constraint;

import org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage;
import org.polarsys.chess.contracts.profile.chesscontract.DataTypes.Concerns;
import org.polarsys.chess.contracts.profile.chesscontract.FormalProperty;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Formal
 * Property</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.impl.FormalPropertyImpl#getBase_Constraint <em>Base Constraint</em>}</li>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.impl.FormalPropertyImpl#getFormalize <em>Formalize</em>}</li>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.impl.FormalPropertyImpl#getConcern <em>Concern</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FormalPropertyImpl extends MinimalEObjectImpl.Container implements FormalProperty {
	/**
	 * The cached value of the '{@link #getBase_Constraint() <em>Base
	 * Constraint</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getBase_Constraint()
	 * @generated
	 * @ordered
	 */
	protected Constraint base_Constraint;

	/**
	 * The cached value of the '{@link #getFormalize() <em>Formalize</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getFormalize()
	 * @generated
	 * @ordered
	 */
	protected EList<Requirement> formalize;

	/**
	 * The default value of the '{@link #getConcern() <em>Concern</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getConcern()
	 * @generated
	 * @ordered
	 */
	protected static final Concerns CONCERN_EDEFAULT = Concerns.UNSPECIFIED;

	/**
	 * The cached value of the '{@link #getConcern() <em>Concern</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getConcern()
	 * @generated
	 * @ordered
	 */
	protected Concerns concern = CONCERN_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected FormalPropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CHESSContractPackage.Literals.FORMAL_PROPERTY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Constraint basicGetBase_Constraint() {
		return base_Constraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Constraint(Constraint newBase_Constraint) {
		Constraint oldBase_Constraint = base_Constraint;
		base_Constraint = newBase_Constraint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CHESSContractPackage.FORMAL_PROPERTY__BASE_CONSTRAINT, oldBase_Constraint, base_Constraint));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Requirement> getFormalize() {
		if (formalize == null) {
			formalize = new EObjectResolvingEList<Requirement>(Requirement.class, this, CHESSContractPackage.FORMAL_PROPERTY__FORMALIZE);
		}
		return formalize;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Concerns getConcern() {
		return concern;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setConcern(Concerns newConcern) {
		Concerns oldConcern = concern;
		concern = newConcern == null ? CONCERN_EDEFAULT : newConcern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CHESSContractPackage.FORMAL_PROPERTY__CONCERN, oldConcern, concern));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CHESSContractPackage.FORMAL_PROPERTY__BASE_CONSTRAINT:
				if (resolve) return getBase_Constraint();
				return basicGetBase_Constraint();
			case CHESSContractPackage.FORMAL_PROPERTY__FORMALIZE:
				return getFormalize();
			case CHESSContractPackage.FORMAL_PROPERTY__CONCERN:
				return getConcern();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CHESSContractPackage.FORMAL_PROPERTY__BASE_CONSTRAINT:
				setBase_Constraint((Constraint)newValue);
				return;
			case CHESSContractPackage.FORMAL_PROPERTY__FORMALIZE:
				getFormalize().clear();
				getFormalize().addAll((Collection<? extends Requirement>)newValue);
				return;
			case CHESSContractPackage.FORMAL_PROPERTY__CONCERN:
				setConcern((Concerns)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CHESSContractPackage.FORMAL_PROPERTY__BASE_CONSTRAINT:
				setBase_Constraint((Constraint)null);
				return;
			case CHESSContractPackage.FORMAL_PROPERTY__FORMALIZE:
				getFormalize().clear();
				return;
			case CHESSContractPackage.FORMAL_PROPERTY__CONCERN:
				setConcern(CONCERN_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CHESSContractPackage.FORMAL_PROPERTY__BASE_CONSTRAINT:
				return base_Constraint != null;
			case CHESSContractPackage.FORMAL_PROPERTY__FORMALIZE:
				return formalize != null && !formalize.isEmpty();
			case CHESSContractPackage.FORMAL_PROPERTY__CONCERN:
				return concern != CONCERN_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (concern: ");
		result.append(concern);
		result.append(')');
		return result.toString();
	}

} // FormalPropertyImpl
