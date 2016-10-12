/**
 */
package org.polarsys.chess.contracts.profile.chesscontract;

import org.eclipse.emf.common.util.EList;

import org.eclipse.papyrus.sysml.constraints.ConstraintProperty;

import org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ContractTypes;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Contract Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.ContractProperty#getRefinedBy <em>Refined By</em>}</li>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.ContractProperty#getContractType <em>Contract Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage#getContractProperty()
 * @model
 * @generated
 */
public interface ContractProperty extends ConstraintProperty {
	/**
	 * Returns the value of the '<em><b>Refined By</b></em>' reference list.
	 * The list contents are of type {@link org.polarsys.chess.contracts.profile.chesscontract.ContractRefinement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refined By</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refined By</em>' reference list.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage#getContractProperty_RefinedBy()
	 * @model ordered="false"
	 * @generated
	 */
	EList<ContractRefinement> getRefinedBy();

	/**
	 * Returns the value of the '<em><b>Contract Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ContractTypes}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contract Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contract Type</em>' attribute.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ContractTypes
	 * @see #setContractType(ContractTypes)
	 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage#getContractProperty_ContractType()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ContractTypes getContractType();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.contracts.profile.chesscontract.ContractProperty#getContractType <em>Contract Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contract Type</em>' attribute.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ContractTypes
	 * @see #getContractType()
	 * @generated
	 */
	void setContractType(ContractTypes value);

} // ContractProperty
