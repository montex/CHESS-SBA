/**
 */
package org.polarsys.chess.chessmlprofile.ParameterizedArchitecture;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instantiated Architecture</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.InstantiatedArchitecture#getParameterList <em>Parameter List</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.InstantiatedArchitecture#getBase_Property <em>Base Property</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.InstantiatedArchitecture#getInstantiatedRootComponent <em>Instantiated Root Component</em>}</li>
 * </ul>
 *
 * @see org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.ParameterizedArchitecturePackage#getInstantiatedArchitecture()
 * @model
 * @generated
 */
public interface InstantiatedArchitecture extends EObject {
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
	 * @see org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.ParameterizedArchitecturePackage#getInstantiatedArchitecture_ParameterList()
	 * @model dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	EList<String> getParameterList();

	/**
	 * Returns the value of the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Property</em>' reference.
	 * @see #setBase_Property(Property)
	 * @see org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.ParameterizedArchitecturePackage#getInstantiatedArchitecture_Base_Property()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Property getBase_Property();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.InstantiatedArchitecture#getBase_Property <em>Base Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Property</em>' reference.
	 * @see #getBase_Property()
	 * @generated
	 */
	void setBase_Property(Property value);

	/**
	 * Returns the value of the '<em><b>Instantiated Root Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instantiated Root Component</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instantiated Root Component</em>' reference.
	 * @see #setInstantiatedRootComponent(org.eclipse.uml2.uml.Class)
	 * @see org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.ParameterizedArchitecturePackage#getInstantiatedArchitecture_InstantiatedRootComponent()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getInstantiatedRootComponent();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.InstantiatedArchitecture#getInstantiatedRootComponent <em>Instantiated Root Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instantiated Root Component</em>' reference.
	 * @see #getInstantiatedRootComponent()
	 * @generated
	 */
	void setInstantiatedRootComponent(org.eclipse.uml2.uml.Class value);

} // InstantiatedArchitecture
