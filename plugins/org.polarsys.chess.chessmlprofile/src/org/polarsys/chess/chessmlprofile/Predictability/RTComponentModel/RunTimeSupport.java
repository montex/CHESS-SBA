/**
 */
package org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Comment;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Run Time Support</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RunTimeSupport#isMonitoring <em>Monitoring</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RunTimeSupport#isVerification <em>Verification</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RunTimeSupport#getBase_Comment <em>Base Comment</em>}</li>
 * </ul>
 *
 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RTComponentModelPackage#getRunTimeSupport()
 * @model
 * @generated
 */
public interface RunTimeSupport extends EObject {
	/**
	 * Returns the value of the '<em><b>Monitoring</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Monitoring</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Monitoring</em>' attribute.
	 * @see #setMonitoring(boolean)
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RTComponentModelPackage#getRunTimeSupport_Monitoring()
	 * @model dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isMonitoring();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RunTimeSupport#isMonitoring <em>Monitoring</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Monitoring</em>' attribute.
	 * @see #isMonitoring()
	 * @generated
	 */
	void setMonitoring(boolean value);

	/**
	 * Returns the value of the '<em><b>Verification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Verification</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Verification</em>' attribute.
	 * @see #setVerification(boolean)
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RTComponentModelPackage#getRunTimeSupport_Verification()
	 * @model dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isVerification();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RunTimeSupport#isVerification <em>Verification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Verification</em>' attribute.
	 * @see #isVerification()
	 * @generated
	 */
	void setVerification(boolean value);

	/**
	 * Returns the value of the '<em><b>Base Comment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Comment</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Comment</em>' reference.
	 * @see #setBase_Comment(Comment)
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RTComponentModelPackage#getRunTimeSupport_Base_Comment()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Comment getBase_Comment();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RunTimeSupport#getBase_Comment <em>Base Comment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Comment</em>' reference.
	 * @see #getBase_Comment()
	 * @generated
	 */
	void setBase_Comment(Comment value);

} // RunTimeSupport
