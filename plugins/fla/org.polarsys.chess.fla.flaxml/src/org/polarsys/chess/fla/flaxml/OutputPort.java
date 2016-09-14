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
 * A representation of the model object '<em><b>Output Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.chess.fla.flaxml.OutputPort#getOutputFailure <em>Output Failure</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.chess.fla.flaxml.FlaxmlPackage#getOutputPort()
 * @model extendedMetaData="name='outputPort' kind='elementOnly'"
 * @generated
 */
public interface OutputPort extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Output Failure</b></em>' containment reference list.
	 * The list contents are of type {@link org.polarsys.chess.fla.flaxml.Failure}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Failure</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Failure</em>' containment reference list.
	 * @see org.polarsys.chess.fla.flaxml.FlaxmlPackage#getOutputPort_OutputFailure()
	 * @model containment="true"
	 * @generated
	 */
	EList<Failure> getOutputFailure();

} // OutputPort
