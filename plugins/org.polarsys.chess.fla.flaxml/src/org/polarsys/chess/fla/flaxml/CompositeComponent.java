/*******************************************************************************
 *                  CHESS core plugin
 *
 *               Copyright (C) 2011-2015
 *            Mälardalen University, Sweden
 *
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License
 *  v1.0 which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
/**
 */
package org.polarsys.chess.fla.flaxml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.chess.fla.flaxml.CompositeComponent#getConnections <em>Connections</em>}</li>
 *   <li>{@link org.polarsys.chess.fla.flaxml.CompositeComponent#getComponents <em>Components</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.chess.fla.flaxml.FlaxmlPackage#getCompositeComponent()
 * @model extendedMetaData="name='compositeComponent' kind='elementOnly'"
 * @generated
 */
public interface CompositeComponent extends Component {
	/**
	 * Returns the value of the '<em><b>Connections</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connections</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connections</em>' containment reference.
	 * @see #setConnections(Connections)
	 * @see org.polarsys.chess.fla.flaxml.FlaxmlPackage#getCompositeComponent_Connections()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='connections' namespace='##targetNamespace'"
	 * @generated
	 */
	Connections getConnections();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.fla.flaxml.CompositeComponent#getConnections <em>Connections</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connections</em>' containment reference.
	 * @see #getConnections()
	 * @generated
	 */
	void setConnections(Connections value);

	/**
	 * Returns the value of the '<em><b>Components</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Components</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Components</em>' containment reference.
	 * @see #setComponents(Components)
	 * @see org.polarsys.chess.fla.flaxml.FlaxmlPackage#getCompositeComponent_Components()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='components' namespace='##targetNamespace'"
	 * @generated
	 */
	Components getComponents();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.fla.flaxml.CompositeComponent#getComponents <em>Components</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Components</em>' containment reference.
	 * @see #getComponents()
	 * @generated
	 */
	void setComponents(Components value);

} // CompositeComponent
