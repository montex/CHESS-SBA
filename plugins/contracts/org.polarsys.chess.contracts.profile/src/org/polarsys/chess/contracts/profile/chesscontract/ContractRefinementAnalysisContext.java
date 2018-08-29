/**
 */
package org.polarsys.chess.contracts.profile.chesscontract;

import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaAnalysisContext;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Contract
 * Refinement Analysis Context</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * I am not able to generate the static definition of the profile having this stereotype extending the MARTE GaANalysisContext, I obtaind some errors in the genmodel related to the MARTE URI... for the moment, as temporary solution, I define it as extension of Class.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.ContractRefinementAnalysisContext#isCheckAllWeakContracts <em>Check All Weak Contracts</em>}</li>
 * </ul>
 *
 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage#getContractRefinementAnalysisContext()
 * @model
 * @generated
 */
public interface ContractRefinementAnalysisContext extends GaAnalysisContext {
	/**
	 * Returns the value of the '<em><b>Check All Weak Contracts</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Check All Weak Contracts</em>' attribute isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Check All Weak Contracts</em>' attribute.
	 * @see #setCheckAllWeakContracts(boolean)
	 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage#getContractRefinementAnalysisContext_CheckAllWeakContracts()
	 * @model default="false" dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isCheckAllWeakContracts();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.contracts.profile.chesscontract.ContractRefinementAnalysisContext#isCheckAllWeakContracts <em>Check All Weak Contracts</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Check All Weak Contracts</em>' attribute.
	 * @see #isCheckAllWeakContracts()
	 * @generated
	 */
	void setCheckAllWeakContracts(boolean value);

} // ContractRefinementAnalysisContext
