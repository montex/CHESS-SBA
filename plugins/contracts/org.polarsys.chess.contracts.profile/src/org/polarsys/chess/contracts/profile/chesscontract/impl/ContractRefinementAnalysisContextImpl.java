/**
 */
package org.polarsys.chess.contracts.profile.chesscontract.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaAnalysisContextImpl;

import org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage;
import org.polarsys.chess.contracts.profile.chesscontract.ContractRefinementAnalysisContext;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Contract Refinement Analysis Context</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.impl.ContractRefinementAnalysisContextImpl#isCheckAllWeakContracts <em>Check All Weak Contracts</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ContractRefinementAnalysisContextImpl extends GaAnalysisContextImpl
		implements ContractRefinementAnalysisContext {
	/**
	 * The default value of the '{@link #isCheckAllWeakContracts() <em>Check All Weak Contracts</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isCheckAllWeakContracts()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CHECK_ALL_WEAK_CONTRACTS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCheckAllWeakContracts() <em>Check All Weak Contracts</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isCheckAllWeakContracts()
	 * @generated
	 * @ordered
	 */
	protected boolean checkAllWeakContracts = CHECK_ALL_WEAK_CONTRACTS_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ContractRefinementAnalysisContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CHESSContractPackage.Literals.CONTRACT_REFINEMENT_ANALYSIS_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCheckAllWeakContracts() {
		return checkAllWeakContracts;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCheckAllWeakContracts(boolean newCheckAllWeakContracts) {
		boolean oldCheckAllWeakContracts = checkAllWeakContracts;
		checkAllWeakContracts = newCheckAllWeakContracts;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CHESSContractPackage.CONTRACT_REFINEMENT_ANALYSIS_CONTEXT__CHECK_ALL_WEAK_CONTRACTS, oldCheckAllWeakContracts, checkAllWeakContracts));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CHESSContractPackage.CONTRACT_REFINEMENT_ANALYSIS_CONTEXT__CHECK_ALL_WEAK_CONTRACTS:
				return isCheckAllWeakContracts();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CHESSContractPackage.CONTRACT_REFINEMENT_ANALYSIS_CONTEXT__CHECK_ALL_WEAK_CONTRACTS:
				setCheckAllWeakContracts((Boolean)newValue);
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
			case CHESSContractPackage.CONTRACT_REFINEMENT_ANALYSIS_CONTEXT__CHECK_ALL_WEAK_CONTRACTS:
				setCheckAllWeakContracts(CHECK_ALL_WEAK_CONTRACTS_EDEFAULT);
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
			case CHESSContractPackage.CONTRACT_REFINEMENT_ANALYSIS_CONTEXT__CHECK_ALL_WEAK_CONTRACTS:
				return checkAllWeakContracts != CHECK_ALL_WEAK_CONTRACTS_EDEFAULT;
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
		result.append(" (checkAllWeakContracts: ");
		result.append(checkAllWeakContracts);
		result.append(')');
		return result.toString();
	}

} // ContractRefinementAnalysisContextImpl
