/**
 */
package org.polarsys.chess.contracts.profile.chesscontract;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.sysml.constraints.ConstraintBlock;

import org.eclipse.papyrus.sysml.requirements.Requirement;
import org.polarsys.chess.contracts.profile.chesscontract.DataTypes.Languages;

/**
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>Contract</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.Contract#getAssume <em>Assume</em>}</li>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.Contract#getGuarantee <em>Guarantee</em>}</li>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.Contract#getFormalize <em>Formalize</em>}</li>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.Contract#getLanguage <em>Language</em>}</li>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.Contract#getContextStatement <em>Context Statement</em>}</li>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.Contract#getArtefactStatement <em>Artefact Statement</em>}</li>
 * </ul>
 *
 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage#getContract()
 * @model
 * @generated
 */
public interface Contract extends ConstraintBlock {
	/**
	 * Returns the value of the '<em><b>Assume</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assume</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Assume</em>' reference.
	 * @see #setAssume(FormalProperty)
	 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage#getContract_Assume()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	FormalProperty getAssume();

	/**
	 * Sets the value of the
	 * '{@link org.polarsys.chess.contracts.profile.chesscontract.Contract#getAssume
	 * <em>Assume</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Assume</em>' reference.
	 * @see #getAssume()
	 * @generated
	 */
	void setAssume(FormalProperty value);

	/**
	 * Returns the value of the '<em><b>Guarantee</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Guarantee</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Guarantee</em>' reference.
	 * @see #setGuarantee(FormalProperty)
	 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage#getContract_Guarantee()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	FormalProperty getGuarantee();

	/**
	 * Sets the value of the
	 * '{@link org.polarsys.chess.contracts.profile.chesscontract.Contract#getGuarantee
	 * <em>Guarantee</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Guarantee</em>' reference.
	 * @see #getGuarantee()
	 * @generated
	 */
	void setGuarantee(FormalProperty value);

	/**
	 * Returns the value of the '<em><b>Formalize</b></em>' reference list. The
	 * list contents are of type
	 * {@link org.eclipse.papyrus.sysml.requirements.Requirement}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Formalize</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Formalize</em>' reference list.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage#getContract_Formalize()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Requirement> getFormalize();

	/**
	 * Returns the value of the '<em><b>Language</b></em>' attribute.
	 * The literals are from the enumeration {@link org.polarsys.chess.contracts.profile.chesscontract.DataTypes.Languages}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Language</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Language</em>' attribute.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.Languages
	 * @see #setLanguage(Languages)
	 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage#getContract_Language()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Languages getLanguage();

	/**
	 * Sets the value of the
	 * '{@link org.polarsys.chess.contracts.profile.chesscontract.Contract#getLanguage
	 * <em>Language</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Language</em>' attribute.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.Languages
	 * @see #getLanguage()
	 * @generated
	 */
	void setLanguage(Languages value);

	/**
	 * Returns the value of the '<em><b>Context Statement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context Statement</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context Statement</em>' attribute.
	 * @see #setContextStatement(String)
	 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage#getContract_ContextStatement()
	 * @model dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	String getContextStatement();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.contracts.profile.chesscontract.Contract#getContextStatement <em>Context Statement</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Context Statement</em>' attribute.
	 * @see #getContextStatement()
	 * @generated
	 */
	void setContextStatement(String value);

	/**
	 * Returns the value of the '<em><b>Artefact Statement</b></em>' attribute
	 * list. The list contents are of type {@link java.lang.String}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Artefact Statement</em>' attribute list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Artefact Statement</em>' attribute list.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage#getContract_ArtefactStatement()
	 * @model dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	EList<String> getArtefactStatement();

} // Contract
