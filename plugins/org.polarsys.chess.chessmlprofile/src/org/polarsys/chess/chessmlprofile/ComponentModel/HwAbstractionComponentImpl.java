/**
 */
package org.polarsys.chess.chessmlprofile.ComponentModel;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwGeneral.HwResource;
import org.eclipse.uml2.uml.Component;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hw Abstraction Component Impl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * represents a SW interface for a given HW component; to hide hardware properties from higher software layers
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.ComponentModel.HwAbstractionComponentImpl#getHwRes <em>Hw Res</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.ComponentModel.HwAbstractionComponentImpl#getBase_Component <em>Base Component</em>}</li>
 * </ul>
 *
 * @see org.polarsys.chess.chessmlprofile.ComponentModel.ComponentModelPackage#getHwAbstractionComponentImpl()
 * @model
 * @generated
 */
public interface HwAbstractionComponentImpl extends EObject {
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

	/**
	 * Returns the value of the '<em><b>Base Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Component</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Component</em>' reference.
	 * @see #setBase_Component(Component)
	 * @see org.polarsys.chess.chessmlprofile.ComponentModel.ComponentModelPackage#getHwAbstractionComponentImpl_Base_Component()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Component getBase_Component();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.ComponentModel.HwAbstractionComponentImpl#getBase_Component <em>Base Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Component</em>' reference.
	 * @see #getBase_Component()
	 * @generated
	 */
	void setBase_Component(Component value);

} // HwAbstractionComponentImpl
