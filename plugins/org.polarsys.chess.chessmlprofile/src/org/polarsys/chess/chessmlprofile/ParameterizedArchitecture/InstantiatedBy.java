/**
 */
package org.polarsys.chess.chessmlprofile.ParameterizedArchitecture;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Dependency;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instantiated By</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.InstantiatedBy#getParameterList <em>Parameter List</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.InstantiatedBy#getBase_Dependency <em>Base Dependency</em>}</li>
 * </ul>
 *
 * @see org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.ParameterizedArchitecturePackage#getInstantiatedBy()
 * @model
 * @generated
 */
public interface InstantiatedBy extends EObject {
	/**
	 * Returns the value of the '<em><b>Parameter List</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter List</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter List</em>' attribute list.
	 * @see org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.ParameterizedArchitecturePackage#getInstantiatedBy_ParameterList()
	 * @model dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	EList<String> getParameterList();

	/**
	 * Returns the value of the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Dependency</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Dependency</em>' reference.
	 * @see #setBase_Dependency(Dependency)
	 * @see org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.ParameterizedArchitecturePackage#getInstantiatedBy_Base_Dependency()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Dependency getBase_Dependency();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.InstantiatedBy#getBase_Dependency <em>Base Dependency</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Dependency</em>' reference.
	 * @see #getBase_Dependency()
	 * @generated
	 */
	void setBase_Dependency(Dependency value);

} // InstantiatedBy
