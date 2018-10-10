/**
 */
package org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation;

import org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.AttackType;
import org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.Threat;
import org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.ThreatType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attack</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Attack#getKind <em>Kind</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Attack#getSeverity <em>Severity</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Attack#getLikelihood <em>Likelihood</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Attack#getVulnerability <em>Vulnerability</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Attack#getThreat <em>Threat</em>}</li>
 * </ul>
 *
 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatsPropagationPackage#getAttack()
 * @model
 * @generated
 */
public interface Attack extends InternalPropagation {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.AttackType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.AttackType
	 * @see #setKind(AttackType)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatsPropagationPackage#getAttack_Kind()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	AttackType getKind();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Attack#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.AttackType
	 * @see #getKind()
	 * @generated
	 */
	void setKind(AttackType value);

	/**
	 * Returns the value of the '<em><b>Severity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Severity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Severity</em>' attribute.
	 * @see #setSeverity(String)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatsPropagationPackage#getAttack_Severity()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getSeverity();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Attack#getSeverity <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Severity</em>' attribute.
	 * @see #getSeverity()
	 * @generated
	 */
	void setSeverity(String value);

	/**
	 * Returns the value of the '<em><b>Likelihood</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Likelihood</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Likelihood</em>' attribute.
	 * @see #setLikelihood(String)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatsPropagationPackage#getAttack_Likelihood()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getLikelihood();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Attack#getLikelihood <em>Likelihood</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Likelihood</em>' attribute.
	 * @see #getLikelihood()
	 * @generated
	 */
	void setLikelihood(String value);

	/**
	 * Returns the value of the '<em><b>Vulnerability</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vulnerability</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vulnerability</em>' reference.
	 * @see #setVulnerability(Vulnerability)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatsPropagationPackage#getAttack_Vulnerability()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Vulnerability getVulnerability();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Attack#getVulnerability <em>Vulnerability</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vulnerability</em>' reference.
	 * @see #getVulnerability()
	 * @generated
	 */
	void setVulnerability(Vulnerability value);

	/**
	 * Returns the value of the '<em><b>Threat</b></em>' attribute.
	 * The literals are from the enumeration {@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.ThreatType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Threat</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Threat</em>' attribute.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.ThreatType
	 * @see #setThreat(ThreatType)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatsPropagationPackage#getAttack_Threat()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ThreatType getThreat();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Attack#getThreat <em>Threat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Threat</em>' attribute.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.ThreatType
	 * @see #getThreat()
	 * @generated
	 */
	void setThreat(ThreatType value);

} // Attack
