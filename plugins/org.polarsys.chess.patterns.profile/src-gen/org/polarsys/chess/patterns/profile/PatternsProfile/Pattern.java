/**
 */
package org.polarsys.chess.patterns.profile.PatternsProfile;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Collaboration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.patterns.profile.PatternsProfile.Pattern#getBase_Collaboration <em>Base Collaboration</em>}</li>
 *   <li>{@link org.polarsys.chess.patterns.profile.PatternsProfile.Pattern#getPatternName <em>Pattern Name</em>}</li>
 *   <li>{@link org.polarsys.chess.patterns.profile.PatternsProfile.Pattern#getOtherNames <em>Other Names</em>}</li>
 *   <li>{@link org.polarsys.chess.patterns.profile.PatternsProfile.Pattern#getIntent <em>Intent</em>}</li>
 *   <li>{@link org.polarsys.chess.patterns.profile.PatternsProfile.Pattern#getProblem <em>Problem</em>}</li>
 *   <li>{@link org.polarsys.chess.patterns.profile.PatternsProfile.Pattern#getSolution <em>Solution</em>}</li>
 *   <li>{@link org.polarsys.chess.patterns.profile.PatternsProfile.Pattern#getConsequences <em>Consequences</em>}</li>
 *   <li>{@link org.polarsys.chess.patterns.profile.PatternsProfile.Pattern#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link org.polarsys.chess.patterns.profile.PatternsProfile.Pattern#getPatternAssumptions <em>Pattern Assumptions</em>}</li>
 *   <li>{@link org.polarsys.chess.patterns.profile.PatternsProfile.Pattern#getPatternGuarantees <em>Pattern Guarantees</em>}</li>
 *   <li>{@link org.polarsys.chess.patterns.profile.PatternsProfile.Pattern#getPreview <em>Preview</em>}</li>
 * </ul>
 *
 * @see org.polarsys.chess.patterns.profile.PatternsProfile.PatternsProfilePackage#getPattern()
 * @model
 * @generated
 */
public interface Pattern extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Collaboration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Collaboration</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Collaboration</em>' reference.
	 * @see #setBase_Collaboration(Collaboration)
	 * @see org.polarsys.chess.patterns.profile.PatternsProfile.PatternsProfilePackage#getPattern_Base_Collaboration()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Collaboration getBase_Collaboration();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.patterns.profile.PatternsProfile.Pattern#getBase_Collaboration <em>Base Collaboration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Collaboration</em>' reference.
	 * @see #getBase_Collaboration()
	 * @generated
	 */
	void setBase_Collaboration(Collaboration value);

	/**
	 * Returns the value of the '<em><b>Pattern Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern Name</em>' attribute.
	 * @see #setPatternName(String)
	 * @see org.polarsys.chess.patterns.profile.PatternsProfile.PatternsProfilePackage#getPattern_PatternName()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getPatternName();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.patterns.profile.PatternsProfile.Pattern#getPatternName <em>Pattern Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pattern Name</em>' attribute.
	 * @see #getPatternName()
	 * @generated
	 */
	void setPatternName(String value);

	/**
	 * Returns the value of the '<em><b>Other Names</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Other Names</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Other Names</em>' attribute list.
	 * @see org.polarsys.chess.patterns.profile.PatternsProfile.PatternsProfilePackage#getPattern_OtherNames()
	 * @model dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	EList<String> getOtherNames();

	/**
	 * Returns the value of the '<em><b>Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Intent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intent</em>' attribute.
	 * @see #setIntent(String)
	 * @see org.polarsys.chess.patterns.profile.PatternsProfile.PatternsProfilePackage#getPattern_Intent()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getIntent();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.patterns.profile.PatternsProfile.Pattern#getIntent <em>Intent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Intent</em>' attribute.
	 * @see #getIntent()
	 * @generated
	 */
	void setIntent(String value);

	/**
	 * Returns the value of the '<em><b>Problem</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Problem</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Problem</em>' attribute.
	 * @see #setProblem(String)
	 * @see org.polarsys.chess.patterns.profile.PatternsProfile.PatternsProfilePackage#getPattern_Problem()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getProblem();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.patterns.profile.PatternsProfile.Pattern#getProblem <em>Problem</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Problem</em>' attribute.
	 * @see #getProblem()
	 * @generated
	 */
	void setProblem(String value);

	/**
	 * Returns the value of the '<em><b>Solution</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Solution</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Solution</em>' attribute.
	 * @see #setSolution(String)
	 * @see org.polarsys.chess.patterns.profile.PatternsProfile.PatternsProfilePackage#getPattern_Solution()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getSolution();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.patterns.profile.PatternsProfile.Pattern#getSolution <em>Solution</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Solution</em>' attribute.
	 * @see #getSolution()
	 * @generated
	 */
	void setSolution(String value);

	/**
	 * Returns the value of the '<em><b>Consequences</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Consequences</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Consequences</em>' attribute list.
	 * @see org.polarsys.chess.patterns.profile.PatternsProfile.PatternsProfilePackage#getPattern_Consequences()
	 * @model dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	EList<String> getConsequences();

	/**
	 * Returns the value of the '<em><b>Implementation</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implementation</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implementation</em>' attribute list.
	 * @see org.polarsys.chess.patterns.profile.PatternsProfile.PatternsProfilePackage#getPattern_Implementation()
	 * @model dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	EList<String> getImplementation();

	/**
	 * Returns the value of the '<em><b>Pattern Assumptions</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern Assumptions</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern Assumptions</em>' attribute list.
	 * @see org.polarsys.chess.patterns.profile.PatternsProfile.PatternsProfilePackage#getPattern_PatternAssumptions()
	 * @model dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	EList<String> getPatternAssumptions();

	/**
	 * Returns the value of the '<em><b>Pattern Guarantees</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern Guarantees</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern Guarantees</em>' attribute list.
	 * @see org.polarsys.chess.patterns.profile.PatternsProfile.PatternsProfilePackage#getPattern_PatternGuarantees()
	 * @model dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	EList<String> getPatternGuarantees();

	/**
	 * Returns the value of the '<em><b>Preview</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Preview</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Preview</em>' attribute.
	 * @see #setPreview(String)
	 * @see org.polarsys.chess.patterns.profile.PatternsProfile.PatternsProfilePackage#getPattern_Preview()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getPreview();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.patterns.profile.PatternsProfile.Pattern#getPreview <em>Preview</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Preview</em>' attribute.
	 * @see #getPreview()
	 * @generated
	 */
	void setPreview(String value);

} // Pattern
