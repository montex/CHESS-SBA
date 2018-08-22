/**
 */
package org.polarsys.chess.contracts.profile.chesscontract;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.sysml.requirements.Requirement;
import org.eclipse.uml2.uml.Constraint;
import org.polarsys.chess.contracts.profile.chesscontract.DataTypes.Concerns;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Formal
 * Property</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * a property to be used as assumption or guarantee of a given contract
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.FormalProperty#getBase_Constraint <em>Base Constraint</em>}</li>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.FormalProperty#getFormalize <em>Formalize</em>}</li>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.FormalProperty#getConcern <em>Concern</em>}</li>
 * </ul>
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
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Base Constraint</em>' reference.
	 * @see #getBase_Constraint()
	 * @generated
	 */
	void setBase_Constraint(Constraint value);

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
	 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage#getFormalProperty_Formalize()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Requirement> getFormalize();

	/**
	 * Returns the value of the '<em><b>Concern</b></em>' attribute.
	 * The literals are from the enumeration {@link org.polarsys.chess.contracts.profile.chesscontract.DataTypes.Concerns}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Concern</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Concern</em>' attribute.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.Concerns
	 * @see #setConcern(Concerns)
	 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage#getFormalProperty_Concern()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Concerns getConcern();

	/**
	 * Sets the value of the
	 * '{@link org.polarsys.chess.contracts.profile.chesscontract.FormalProperty#getConcern
	 * <em>Concern</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Concern</em>' attribute.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.Concerns
	 * @see #getConcern()
	 * @generated
	 */
	void setConcern(Concerns value);

} // FormalProperty
