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
package org.polarsys.chess.fla.flamm;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fla Behaviour</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.polarsys.chess.fla.flamm.FlammPackage#getFlaBehaviour()
 * @model kind="class" interface="true" abstract="true"
 * @generated
 */
public interface FlaBehaviour extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void propagateFailures();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model initNoFailureRequired="true"
	 * @generated
	 */
	void initialize(boolean initNoFailure);

} // FlaBehaviour
