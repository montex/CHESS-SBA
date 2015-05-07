/**
 */
package org.polarsys.chess.chessmlprofile.ComponentModel;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwGeneral.HwResource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hw Abstraction Component Impl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.ComponentModel.HwAbstractionComponentImpl#getHwRes <em>Hw Res</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.chess.chessmlprofile.ComponentModel.ComponentModelPackage#getHwAbstractionComponentImpl()
 * @model
 * @generated
 */
public interface HwAbstractionComponentImpl extends ComponentImplementation {
	/**
	 * Returns the value of the '<em><b>Hw Res</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hw Res</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hw Res</em>' reference.
	 * @see #setHwRes(HwResource)
	 * @see org.polarsys.chess.chessmlprofile.ComponentModel.ComponentModelPackage#getHwAbstractionComponentImpl_HwRes()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	HwResource getHwRes();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.ComponentModel.HwAbstractionComponentImpl#getHwRes <em>Hw Res</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hw Res</em>' reference.
	 * @see #getHwRes()
	 * @generated
	 */
	void setHwRes(HwResource value);

} // HwAbstractionComponentImpl
