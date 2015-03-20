/**
 */
package org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Recovery Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.RecoveryEvent#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatsPropagationPackage#getRecoveryEvent()
 * @model
 * @generated
 */
public interface RecoveryEvent extends InternalEvent {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.RecoveryKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.RecoveryKind
	 * @see #setKind(RecoveryKind)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatsPropagationPackage#getRecoveryEvent_Kind()
	 * @model ordered="false"
	 * @generated
	 */
	RecoveryKind getKind();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.RecoveryEvent#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.RecoveryKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(RecoveryKind value);

} // RecoveryEvent
