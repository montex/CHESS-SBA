/**
 */
package org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Component;
import org.polarsys.chess.chessmlprofile.ComponentModel.ComponentImplementation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ARINC Component Impl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.ARINCComponentImpl#getBase_Component <em>Base Component</em>}</li>
 * </ul>
 *
 * @see org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.ARINCComponentModelPackage#getARINCComponentImpl()
 * @model
 * @generated
 */
public interface ARINCComponentImpl extends EObject {

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
	 * @see org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.ARINCComponentModelPackage#getARINCComponentImpl_Base_Component()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Component getBase_Component();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.ARINCComponentImpl#getBase_Component <em>Base Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Component</em>' reference.
	 * @see #getBase_Component()
	 * @generated
	 */
	void setBase_Component(Component value);
} // ARINCComponentImpl
