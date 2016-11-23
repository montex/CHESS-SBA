/**
 */
package org.polarsys.chess.contracts.profile.chesscontract;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.sysml.requirements.Requirement;
import org.eclipse.uml2.uml.Constraint;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Formal Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.FormalProperty#getBase_Constraint <em>Base Constraint</em>}</li>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.FormalProperty#getFormalize <em>Formalize</em>}</li>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.FormalProperty#getGoto <em>Goto</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage#getFormalProperty()
 * @model
 * @generated
 */
public interface FormalProperty extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Constraint</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Constraint</em>' reference.
	 * @see #setBase_Constraint(Constraint)
	 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage#getFormalProperty_Base_Constraint()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Constraint getBase_Constraint();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.contracts.profile.chesscontract.FormalProperty#getBase_Constraint <em>Base Constraint</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Constraint</em>' reference.
	 * @see #getBase_Constraint()
	 * @generated
	 */
	void setBase_Constraint(Constraint value);

	/**
	 * Returns the value of the '<em><b>Formalize</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Formalize</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Formalize</em>' reference.
	 * @see #setFormalize(Requirement)
	 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage#getFormalProperty_Formalize()
	 * @model ordered="false"
	 * @generated
	 */
	Requirement getFormalize();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.contracts.profile.chesscontract.FormalProperty#getFormalize <em>Formalize</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Formalize</em>' reference.
	 * @see #getFormalize()
	 * @generated
	 */
	void setFormalize(Requirement value);

	/**
	 * Returns the value of the '<em><b>Goto</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Goto</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Goto</em>' reference.
	 * @see #setGoto(EObject)
	 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage#getFormalProperty_Goto()
	 * @model
	 * @generated
	 */
	EObject getGoto();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.contracts.profile.chesscontract.FormalProperty#getGoto <em>Goto</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Goto</em>' reference.
	 * @see #getGoto()
	 * @generated
	 */
	void setGoto(EObject value);

} // FormalProperty
