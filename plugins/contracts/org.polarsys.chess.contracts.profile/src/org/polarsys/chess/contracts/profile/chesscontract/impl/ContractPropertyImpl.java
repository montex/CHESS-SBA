/**
 */
package org.polarsys.chess.contracts.profile.chesscontract.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.papyrus.sysml.constraints.internal.impl.ConstraintPropertyImpl;

import org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage;
import org.polarsys.chess.contracts.profile.chesscontract.ContractProperty;
import org.polarsys.chess.contracts.profile.chesscontract.ContractRefinement;

import org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ContractTypes;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Contract Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.impl.ContractPropertyImpl#getRefinedBy <em>Refined By</em>}</li>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.impl.ContractPropertyImpl#getContractType <em>Contract Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContractPropertyImpl extends ConstraintPropertyImpl implements ContractProperty {
	/**
	 * The cached value of the '{@link #getRefinedBy() <em>Refined By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefinedBy()
	 * @generated
	 * @ordered
	 */
	protected EList<ContractRefinement> refinedBy;

	/**
	 * The default value of the '{@link #getContractType() <em>Contract Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContractType()
	 * @generated
	 * @ordered
	 */
	protected static final ContractTypes CONTRACT_TYPE_EDEFAULT = ContractTypes.STRONG;

	/**
	 * The cached value of the '{@link #getContractType() <em>Contract Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContractType()
	 * @generated
	 * @ordered
	 */
	protected ContractTypes contractType = CONTRACT_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContractPropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CHESSContractPackage.Literals.CONTRACT_PROPERTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ContractRefinement> getRefinedBy() {
		if (refinedBy == null) {
			refinedBy = new EObjectResolvingEList<ContractRefinement>(ContractRefinement.class, this, CHESSContractPackage.CONTRACT_PROPERTY__REFINED_BY);
		}
		return refinedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContractTypes getContractType() {
		return contractType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContractType(ContractTypes newContractType) {
		ContractTypes oldContractType = contractType;
		contractType = newContractType == null ? CONTRACT_TYPE_EDEFAULT : newContractType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CHESSContractPackage.CONTRACT_PROPERTY__CONTRACT_TYPE, oldContractType, contractType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CHESSContractPackage.CONTRACT_PROPERTY__REFINED_BY:
				return getRefinedBy();
			case CHESSContractPackage.CONTRACT_PROPERTY__CONTRACT_TYPE:
				return getContractType();
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
			case CHESSContractPackage.CONTRACT_PROPERTY__REFINED_BY:
				getRefinedBy().clear();
				getRefinedBy().addAll((Collection<? extends ContractRefinement>)newValue);
				return;
			case CHESSContractPackage.CONTRACT_PROPERTY__CONTRACT_TYPE:
				setContractType((ContractTypes)newValue);
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
			case CHESSContractPackage.CONTRACT_PROPERTY__REFINED_BY:
				getRefinedBy().clear();
				return;
			case CHESSContractPackage.CONTRACT_PROPERTY__CONTRACT_TYPE:
				setContractType(CONTRACT_TYPE_EDEFAULT);
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
			case CHESSContractPackage.CONTRACT_PROPERTY__REFINED_BY:
				return refinedBy != null && !refinedBy.isEmpty();
			case CHESSContractPackage.CONTRACT_PROPERTY__CONTRACT_TYPE:
				return contractType != CONTRACT_TYPE_EDEFAULT;
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
		result.append(" (ContractType: ");
		result.append(contractType);
		result.append(')');
		return result.toString();
	}

} //ContractPropertyImpl
