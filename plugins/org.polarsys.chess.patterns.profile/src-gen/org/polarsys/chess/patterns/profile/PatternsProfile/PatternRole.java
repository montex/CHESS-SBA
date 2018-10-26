/**
 */
package org.polarsys.chess.patterns.profile.PatternsProfile;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pattern Role</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.patterns.profile.PatternsProfile.PatternRole#getBase_NamedElement <em>Base Named Element</em>}</li>
 *   <li>{@link org.polarsys.chess.patterns.profile.PatternsProfile.PatternRole#getAppliedPattern <em>Applied Pattern</em>}</li>
 *   <li>{@link org.polarsys.chess.patterns.profile.PatternsProfile.PatternRole#getMappedRole <em>Mapped Role</em>}</li>
 * </ul>
 *
 * @see org.polarsys.chess.patterns.profile.PatternsProfile.PatternsProfilePackage#getPatternRole()
 * @model
 * @generated
 */
public interface PatternRole extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Named Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Named Element</em>' reference.
	 * @see #setBase_NamedElement(NamedElement)
	 * @see org.polarsys.chess.patterns.profile.PatternsProfile.PatternsProfilePackage#getPatternRole_Base_NamedElement()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	NamedElement getBase_NamedElement();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.patterns.profile.PatternsProfile.PatternRole#getBase_NamedElement <em>Base Named Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Named Element</em>' reference.
	 * @see #getBase_NamedElement()
	 * @generated
	 */
	void setBase_NamedElement(NamedElement value);

	/**
	 * Returns the value of the '<em><b>Applied Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Applied Pattern</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Applied Pattern</em>' attribute.
	 * @see #setAppliedPattern(String)
	 * @see org.polarsys.chess.patterns.profile.PatternsProfile.PatternsProfilePackage#getPatternRole_AppliedPattern()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getAppliedPattern();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.patterns.profile.PatternsProfile.PatternRole#getAppliedPattern <em>Applied Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Applied Pattern</em>' attribute.
	 * @see #getAppliedPattern()
	 * @generated
	 */
	void setAppliedPattern(String value);

	/**
	 * Returns the value of the '<em><b>Mapped Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapped Role</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapped Role</em>' attribute.
	 * @see #setMappedRole(String)
	 * @see org.polarsys.chess.patterns.profile.PatternsProfile.PatternsProfilePackage#getPatternRole_MappedRole()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getMappedRole();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.patterns.profile.PatternsProfile.PatternRole#getMappedRole <em>Mapped Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapped Role</em>' attribute.
	 * @see #getMappedRole()
	 * @generated
	 */
	void setMappedRole(String value);

} // PatternRole
