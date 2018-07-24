/**
 */
package org.polarsys.chess.contracts.profile.chesscontract;

import org.eclipse.papyrus.sysml.requirements.Requirement;

import org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqMaturities;
import org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqPriorities;
import org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqRisks;
import org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqStatuses;
import org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqTypes;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>CHESS
 * Requirement</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.CHESSRequirement#getAuthor <em>Author</em>}</li>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.CHESSRequirement#getStatus <em>Status</em>}</li>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.CHESSRequirement#getType <em>Type</em>}</li>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.CHESSRequirement#getPriority <em>Priority</em>}</li>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.CHESSRequirement#getPerformance <em>Performance</em>}</li>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.CHESSRequirement#getTolerance <em>Tolerance</em>}</li>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.CHESSRequirement#getSeverity <em>Severity</em>}</li>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.CHESSRequirement#getMaturity <em>Maturity</em>}</li>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.CHESSRequirement#getRisk <em>Risk</em>}</li>
 * </ul>
 *
 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage#getCHESSRequirement()
 * @model
 * @generated
 */
public interface CHESSRequirement extends Requirement {
	/**
	 * Returns the value of the '<em><b>Author</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Author</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Author</em>' attribute.
	 * @see #setAuthor(String)
	 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage#getCHESSRequirement_Author()
	 * @model dataType="org.eclipse.uml2.types.String" required="true"
	 *        ordered="false"
	 * @generated
	 */
	String getAuthor();

	/**
	 * Sets the value of the
	 * '{@link org.polarsys.chess.contracts.profile.chesscontract.CHESSRequirement#getAuthor
	 * <em>Author</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Author</em>' attribute.
	 * @see #getAuthor()
	 * @generated
	 */
	void setAuthor(String value);

	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 * The literals are from the enumeration {@link org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqStatuses}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqStatuses
	 * @see #setStatus(ReqStatuses)
	 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage#getCHESSRequirement_Status()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ReqStatuses getStatus();

	/**
	 * Sets the value of the
	 * '{@link org.polarsys.chess.contracts.profile.chesscontract.CHESSRequirement#getStatus
	 * <em>Status</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Status</em>' attribute.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqStatuses
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(ReqStatuses value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqTypes}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqTypes
	 * @see #setType(ReqTypes)
	 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage#getCHESSRequirement_Type()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ReqTypes getType();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.contracts.profile.chesscontract.CHESSRequirement#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqTypes
	 * @see #getType()
	 * @generated
	 */
	void setType(ReqTypes value);

	/**
	 * Returns the value of the '<em><b>Priority</b></em>' attribute.
	 * The literals are from the enumeration {@link org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqPriorities}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' attribute.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqPriorities
	 * @see #setPriority(ReqPriorities)
	 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage#getCHESSRequirement_Priority()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ReqPriorities getPriority();

	/**
	 * Sets the value of the
	 * '{@link org.polarsys.chess.contracts.profile.chesscontract.CHESSRequirement#getPriority
	 * <em>Priority</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Priority</em>' attribute.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqPriorities
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(ReqPriorities value);

	/**
	 * Returns the value of the '<em><b>Performance</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Performance</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Performance</em>' attribute.
	 * @see #setPerformance(String)
	 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage#getCHESSRequirement_Performance()
	 * @model dataType="org.eclipse.uml2.types.String" required="true"
	 *        ordered="false" annotation="http://www.eclipse.org/uml2/2.0.0/UML
	 *        originalName='Performance '"
	 * @generated
	 */
	String getPerformance();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.contracts.profile.chesscontract.CHESSRequirement#getPerformance <em>Performance</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Performance</em>' attribute.
	 * @see #getPerformance()
	 * @generated
	 */
	void setPerformance(String value);

	/**
	 * Returns the value of the '<em><b>Tolerance</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tolerance</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Tolerance</em>' attribute.
	 * @see #setTolerance(String)
	 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage#getCHESSRequirement_Tolerance()
	 * @model dataType="org.eclipse.uml2.types.String" required="true"
	 *        ordered="false"
	 * @generated
	 */
	String getTolerance();

	/**
	 * Sets the value of the
	 * '{@link org.polarsys.chess.contracts.profile.chesscontract.CHESSRequirement#getTolerance
	 * <em>Tolerance</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Tolerance</em>' attribute.
	 * @see #getTolerance()
	 * @generated
	 */
	void setTolerance(String value);

	/**
	 * Returns the value of the '<em><b>Severity</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Severity</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Severity</em>' attribute.
	 * @see #setSeverity(String)
	 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage#getCHESSRequirement_Severity()
	 * @model dataType="org.eclipse.uml2.types.String" required="true"
	 *        ordered="false"
	 * @generated
	 */
	String getSeverity();

	/**
	 * Sets the value of the
	 * '{@link org.polarsys.chess.contracts.profile.chesscontract.CHESSRequirement#getSeverity
	 * <em>Severity</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Severity</em>' attribute.
	 * @see #getSeverity()
	 * @generated
	 */
	void setSeverity(String value);

	/**
	 * Returns the value of the '<em><b>Maturity</b></em>' attribute.
	 * The literals are from the enumeration {@link org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqMaturities}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maturity</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maturity</em>' attribute.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqMaturities
	 * @see #setMaturity(ReqMaturities)
	 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage#getCHESSRequirement_Maturity()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ReqMaturities getMaturity();

	/**
	 * Sets the value of the
	 * '{@link org.polarsys.chess.contracts.profile.chesscontract.CHESSRequirement#getMaturity
	 * <em>Maturity</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Maturity</em>' attribute.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqMaturities
	 * @see #getMaturity()
	 * @generated
	 */
	void setMaturity(ReqMaturities value);

	/**
	 * Returns the value of the '<em><b>Risk</b></em>' attribute.
	 * The literals are from the enumeration {@link org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqRisks}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Risk</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Risk</em>' attribute.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqRisks
	 * @see #setRisk(ReqRisks)
	 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage#getCHESSRequirement_Risk()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ReqRisks getRisk();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.contracts.profile.chesscontract.CHESSRequirement#getRisk <em>Risk</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Risk</em>' attribute.
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqRisks
	 * @see #getRisk()
	 * @generated
	 */
	void setRisk(ReqRisks value);

} // CHESSRequirement
