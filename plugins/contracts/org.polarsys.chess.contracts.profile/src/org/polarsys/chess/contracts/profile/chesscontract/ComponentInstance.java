/**
 */
package org.polarsys.chess.contracts.profile.chesscontract;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>Component Instance</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * allows to specify information for a component instance:
 * -the weak contracts which hold
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.ComponentInstance#getBase_Property <em>Base Property</em>}</li>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.ComponentInstance#getWeakGuarantees <em>Weak Guarantees</em>}</li>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.ComponentInstance#getBase_InstanceSpecification <em>Base Instance Specification</em>}</li>
 * </ul>
 *
 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage#getComponentInstance()
 * @model
 * @generated
 */
public interface ComponentInstance extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Property</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Base Property</em>' reference.
	 * @see #setBase_Property(Property)
	 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage#getComponentInstance_Base_Property()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Property getBase_Property();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.contracts.profile.chesscontract.ComponentInstance#getBase_Property <em>Base Property</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Base Property</em>' reference.
	 * @see #getBase_Property()
	 * @generated
	 */
	void setBase_Property(Property value);

	/**
	 * Returns the value of the '<em><b>Weak Guarantees</b></em>' reference list.
	 * The list contents are of type {@link org.polarsys.chess.contracts.profile.chesscontract.ContractProperty}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Weak Guarantees</em>' reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weak Guarantees</em>' reference list.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage#getComponentInstance_WeakGuarantees()
	 * @model ordered="false"
	 * @generated
	 */
	EList<ContractProperty> getWeakGuarantees();

	/**
	 * Returns the value of the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Instance Specification</em>' reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Instance Specification</em>' reference.
	 * @see #setBase_InstanceSpecification(InstanceSpecification)
	 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage#getComponentInstance_Base_InstanceSpecification()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	InstanceSpecification getBase_InstanceSpecification();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.contracts.profile.chesscontract.ComponentInstance#getBase_InstanceSpecification <em>Base Instance Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Instance Specification</em>' reference.
	 * @see #getBase_InstanceSpecification()
	 * @generated
	 */
	void setBase_InstanceSpecification(InstanceSpecification value);

} // ComponentInstance
