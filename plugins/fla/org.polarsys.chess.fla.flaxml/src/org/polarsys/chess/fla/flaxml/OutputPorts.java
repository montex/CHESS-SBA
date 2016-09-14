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
 * A representation of the model object '<em><b>Output Ports</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.chess.fla.flaxml.OutputPorts#getOutputPort <em>Output Port</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.chess.fla.flaxml.FlaxmlPackage#getOutputPorts()
 * @model extendedMetaData="name='outputPorts' kind='elementOnly'"
 * @generated
 */
public interface OutputPorts extends EObject {
	/**
	 * Returns the value of the '<em><b>Output Port</b></em>' containment reference list.
	 * The list contents are of type {@link org.polarsys.chess.fla.flaxml.OutputPort}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Port</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Port</em>' containment reference list.
	 * @see org.polarsys.chess.fla.flaxml.FlaxmlPackage#getOutputPorts_OutputPort()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='outputPort' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<OutputPort> getOutputPort();

} // OutputPorts
