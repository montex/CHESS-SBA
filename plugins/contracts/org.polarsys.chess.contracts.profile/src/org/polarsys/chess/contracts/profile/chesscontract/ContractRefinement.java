/**
 */
package org.polarsys.chess.contracts.profile.chesscontract;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Contract
 * Refinement</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * to specify contract refinement for a given contract instance. 
 * Instance and instanceSpec attribute are mutually exclusive
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.ContractRefinement#getBase_DataType <em>Base Data Type</em>}</li>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.ContractRefinement#getInstance <em>Instance</em>}</li>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.ContractRefinement#getContract <em>Contract</em>}</li>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.ContractRefinement#getInstanceSpec <em>Instance Spec</em>}</li>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.ContractRefinement#getUpperIndexOfInstance <em>Upper Index Of Instance</em>}</li>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.ContractRefinement#getLowerIndexOfInstance <em>Lower Index Of Instance</em>}</li>
 * </ul>
 *
 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage#getContractRefinement()
 * @model
 * @generated
 */
public interface ContractRefinement extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Data Type</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Data Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Base Data Type</em>' reference.
	 * @see #setBase_DataType(DataType)
	 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage#getContractRefinement_Base_DataType()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	DataType getBase_DataType();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.contracts.profile.chesscontract.ContractRefinement#getBase_DataType <em>Base Data Type</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Base Data Type</em>' reference.
	 * @see #getBase_DataType()
	 * @generated
	 */
	void setBase_DataType(DataType value);

	/**
	 * Returns the value of the '<em><b>Instance</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instance</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Instance</em>' reference.
	 * @see #setInstance(Property)
	 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage#getContractRefinement_Instance()
	 * @model ordered="false"
	 * @generated
	 */
	Property getInstance();

	/**
	 * Sets the value of the
	 * '{@link org.polarsys.chess.contracts.profile.chesscontract.ContractRefinement#getInstance
	 * <em>Instance</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Instance</em>' reference.
	 * @see #getInstance()
	 * @generated
	 */
	void setInstance(Property value);

	/**
	 * Returns the value of the '<em><b>Contract</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contract</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Contract</em>' reference.
	 * @see #setContract(ContractProperty)
	 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage#getContractRefinement_Contract()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ContractProperty getContract();

	/**
	 * Sets the value of the
	 * '{@link org.polarsys.chess.contracts.profile.chesscontract.ContractRefinement#getContract
	 * <em>Contract</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Contract</em>' reference.
	 * @see #getContract()
	 * @generated
	 */
	void setContract(ContractProperty value);

	/**
	 * Returns the value of the '<em><b>Instance Spec</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instance Spec</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Instance Spec</em>' reference.
	 * @see #setInstanceSpec(InstanceSpecification)
	 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage#getContractRefinement_InstanceSpec()
	 * @model ordered="false"
	 * @generated
	 */
	InstanceSpecification getInstanceSpec();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.contracts.profile.chesscontract.ContractRefinement#getInstanceSpec <em>Instance Spec</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Instance Spec</em>' reference.
	 * @see #getInstanceSpec()
	 * @generated
	 */
	void setInstanceSpec(InstanceSpecification value);

	/**
	 * Returns the value of the '<em><b>Upper Index Of Instance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upper Index Of Instance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper Index Of Instance</em>' attribute.
	 * @see #setUpperIndexOfInstance(String)
	 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage#getContractRefinement_UpperIndexOfInstance()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getUpperIndexOfInstance();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.contracts.profile.chesscontract.ContractRefinement#getUpperIndexOfInstance <em>Upper Index Of Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper Index Of Instance</em>' attribute.
	 * @see #getUpperIndexOfInstance()
	 * @generated
	 */
	void setUpperIndexOfInstance(String value);

	/**
	 * Returns the value of the '<em><b>Lower Index Of Instance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower Index Of Instance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower Index Of Instance</em>' attribute.
	 * @see #setLowerIndexOfInstance(String)
	 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage#getContractRefinement_LowerIndexOfInstance()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getLowerIndexOfInstance();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.contracts.profile.chesscontract.ContractRefinement#getLowerIndexOfInstance <em>Lower Index Of Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower Index Of Instance</em>' attribute.
	 * @see #getLowerIndexOfInstance()
	 * @generated
	 */
	void setLowerIndexOfInstance(String value);

} // ContractRefinement
