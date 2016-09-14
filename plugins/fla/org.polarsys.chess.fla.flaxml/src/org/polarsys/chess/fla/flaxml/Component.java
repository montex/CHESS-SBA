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
 * A representation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.chess.fla.flaxml.Component#getInputPorts <em>Input Ports</em>}</li>
 *   <li>{@link org.polarsys.chess.fla.flaxml.Component#getOutputPorts <em>Output Ports</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.chess.fla.flaxml.FlaxmlPackage#getComponent()
 * @model abstract="true"
 *        extendedMetaData="name='component' kind='empty'"
 * @generated
 */
public interface Component extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Input Ports</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Ports</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Ports</em>' containment reference.
	 * @see #setInputPorts(InputPorts)
	 * @see org.polarsys.chess.fla.flaxml.FlaxmlPackage#getComponent_InputPorts()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='inputPorts' namespace='##targetNamespace'"
	 * @generated
	 */
	InputPorts getInputPorts();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.fla.flaxml.Component#getInputPorts <em>Input Ports</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Ports</em>' containment reference.
	 * @see #getInputPorts()
	 * @generated
	 */
	void setInputPorts(InputPorts value);

	/**
	 * Returns the value of the '<em><b>Output Ports</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Ports</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Ports</em>' containment reference.
	 * @see #setOutputPorts(OutputPorts)
	 * @see org.polarsys.chess.fla.flaxml.FlaxmlPackage#getComponent_OutputPorts()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='outputPorts' namespace='##targetNamespace'"
	 * @generated
	 */
	OutputPorts getOutputPorts();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.fla.flaxml.Component#getOutputPorts <em>Output Ports</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Ports</em>' containment reference.
	 * @see #getOutputPorts()
	 * @generated
	 */
	void setOutputPorts(OutputPorts value);

} // Component
