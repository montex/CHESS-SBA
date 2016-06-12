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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.chess.fla.flaxml.Connection#getSourceComponent <em>Source Component</em>}</li>
 *   <li>{@link org.polarsys.chess.fla.flaxml.Connection#getSourceId <em>Source Id</em>}</li>
 *   <li>{@link org.polarsys.chess.fla.flaxml.Connection#getTargetComponent <em>Target Component</em>}</li>
 *   <li>{@link org.polarsys.chess.fla.flaxml.Connection#getTargetId <em>Target Id</em>}</li>
 *   <li>{@link org.polarsys.chess.fla.flaxml.Connection#getRules <em>Rules</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.chess.fla.flaxml.FlaxmlPackage#getConnection()
 * @model extendedMetaData="name='connection' kind='empty'"
 * @generated
 */
public interface Connection extends EObject {
	/**
	 * Returns the value of the '<em><b>Source Component</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Component</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Component</em>' attribute.
	 * @see #setSourceComponent(String)
	 * @see org.polarsys.chess.fla.flaxml.FlaxmlPackage#getConnection_SourceComponent()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='sourceComponent'"
	 * @generated
	 */
	String getSourceComponent();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.fla.flaxml.Connection#getSourceComponent <em>Source Component</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Component</em>' attribute.
	 * @see #getSourceComponent()
	 * @generated
	 */
	void setSourceComponent(String value);

	/**
	 * Returns the value of the '<em><b>Source Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Id</em>' attribute.
	 * @see #setSourceId(String)
	 * @see org.polarsys.chess.fla.flaxml.FlaxmlPackage#getConnection_SourceId()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='sourceId'"
	 * @generated
	 */
	String getSourceId();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.fla.flaxml.Connection#getSourceId <em>Source Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Id</em>' attribute.
	 * @see #getSourceId()
	 * @generated
	 */
	void setSourceId(String value);

	/**
	 * Returns the value of the '<em><b>Target Component</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Component</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Component</em>' attribute.
	 * @see #setTargetComponent(String)
	 * @see org.polarsys.chess.fla.flaxml.FlaxmlPackage#getConnection_TargetComponent()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='targetComponent'"
	 * @generated
	 */
	String getTargetComponent();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.fla.flaxml.Connection#getTargetComponent <em>Target Component</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Component</em>' attribute.
	 * @see #getTargetComponent()
	 * @generated
	 */
	void setTargetComponent(String value);

	/**
	 * Returns the value of the '<em><b>Target Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Id</em>' attribute.
	 * @see #setTargetId(String)
	 * @see org.polarsys.chess.fla.flaxml.FlaxmlPackage#getConnection_TargetId()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='targetId'"
	 * @generated
	 */
	String getTargetId();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.fla.flaxml.Connection#getTargetId <em>Target Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Id</em>' attribute.
	 * @see #getTargetId()
	 * @generated
	 */
	void setTargetId(String value);

	/**
	 * Returns the value of the '<em><b>Rules</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rules</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rules</em>' containment reference.
	 * @see #setRules(FptcRules)
	 * @see org.polarsys.chess.fla.flaxml.FlaxmlPackage#getConnection_Rules()
	 * @model containment="true"
	 * @generated
	 */
	FptcRules getRules();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.fla.flaxml.Connection#getRules <em>Rules</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rules</em>' containment reference.
	 * @see #getRules()
	 * @generated
	 */
	void setRules(FptcRules value);

} // Connection
