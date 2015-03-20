/**
 */
package org.polarsys.chess.chessmlprofile.Safety;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Constraint;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Criticality Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Safety.CriticalitySpecification#getBase_Constraint <em>Base Constraint</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Safety.CriticalitySpecification#getCriticalityLevel <em>Criticality Level</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.chess.chessmlprofile.Safety.SafetyPackage#getCriticalitySpecification()
 * @model
 * @generated
 */
public interface CriticalitySpecification extends EObject {
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
	 * @see org.polarsys.chess.chessmlprofile.Safety.SafetyPackage#getCriticalitySpecification_Base_Constraint()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Constraint getBase_Constraint();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Safety.CriticalitySpecification#getBase_Constraint <em>Base Constraint</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Constraint</em>' reference.
	 * @see #getBase_Constraint()
	 * @generated
	 */
	void setBase_Constraint(Constraint value);

	/**
	 * Returns the value of the '<em><b>Criticality Level</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Criticality Level</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Criticality Level</em>' reference.
	 * @see #setCriticalityLevel(CriticalityLevel)
	 * @see org.polarsys.chess.chessmlprofile.Safety.SafetyPackage#getCriticalitySpecification_CriticalityLevel()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	CriticalityLevel getCriticalityLevel();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Safety.CriticalitySpecification#getCriticalityLevel <em>Criticality Level</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Criticality Level</em>' reference.
	 * @see #getCriticalityLevel()
	 * @generated
	 */
	void setCriticalityLevel(CriticalityLevel value);

} // CriticalitySpecification
