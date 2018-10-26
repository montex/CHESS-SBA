/**
 */
package org.polarsys.chess.patterns.profile.PatternsProfile;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.CollaborationUse;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pattern Application</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.patterns.profile.PatternsProfile.PatternApplication#getAppliedPattern <em>Applied Pattern</em>}</li>
 *   <li>{@link org.polarsys.chess.patterns.profile.PatternsProfile.PatternApplication#getBase_CollaborationUse <em>Base Collaboration Use</em>}</li>
 * </ul>
 *
 * @see org.polarsys.chess.patterns.profile.PatternsProfile.PatternsProfilePackage#getPatternApplication()
 * @model
 * @generated
 */
public interface PatternApplication extends EObject {
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
	 * @see org.polarsys.chess.patterns.profile.PatternsProfile.PatternsProfilePackage#getPatternApplication_AppliedPattern()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getAppliedPattern();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.patterns.profile.PatternsProfile.PatternApplication#getAppliedPattern <em>Applied Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Applied Pattern</em>' attribute.
	 * @see #getAppliedPattern()
	 * @generated
	 */
	void setAppliedPattern(String value);

	/**
	 * Returns the value of the '<em><b>Base Collaboration Use</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Collaboration Use</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Collaboration Use</em>' reference.
	 * @see #setBase_CollaborationUse(CollaborationUse)
	 * @see org.polarsys.chess.patterns.profile.PatternsProfile.PatternsProfilePackage#getPatternApplication_Base_CollaborationUse()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	CollaborationUse getBase_CollaborationUse();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.patterns.profile.PatternsProfile.PatternApplication#getBase_CollaborationUse <em>Base Collaboration Use</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Collaboration Use</em>' reference.
	 * @see #getBase_CollaborationUse()
	 * @generated
	 */
	void setBase_CollaborationUse(CollaborationUse value);

} // PatternApplication
