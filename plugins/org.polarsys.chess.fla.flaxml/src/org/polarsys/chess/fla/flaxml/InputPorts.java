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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input Ports</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.chess.fla.flaxml.InputPorts#getInputPort <em>Input Port</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.chess.fla.flaxml.FlaxmlPackage#getInputPorts()
 * @model extendedMetaData="name='inputPorts' kind='elementOnly'"
 * @generated
 */
public interface InputPorts extends EObject {
	/**
	 * Returns the value of the '<em><b>Input Port</b></em>' containment reference list.
	 * The list contents are of type {@link org.polarsys.chess.fla.flaxml.InputPort}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Port</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Port</em>' containment reference list.
	 * @see org.polarsys.chess.fla.flaxml.FlaxmlPackage#getInputPorts_InputPort()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='inputPort' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<InputPort> getInputPort();

} // InputPorts
