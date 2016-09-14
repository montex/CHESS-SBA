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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.chess.fla.flaxml.InputPort#getInputFailure <em>Input Failure</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.chess.fla.flaxml.FlaxmlPackage#getInputPort()
 * @model extendedMetaData="name='inputPort' kind='elementOnly'"
 * @generated
 */
public interface InputPort extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Input Failure</b></em>' containment reference list.
	 * The list contents are of type {@link org.polarsys.chess.fla.flaxml.Failure}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Failure</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Failure</em>' containment reference list.
	 * @see org.polarsys.chess.fla.flaxml.FlaxmlPackage#getInputPort_InputFailure()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='inputFailure' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<Failure> getInputFailure();

} // InputPort
