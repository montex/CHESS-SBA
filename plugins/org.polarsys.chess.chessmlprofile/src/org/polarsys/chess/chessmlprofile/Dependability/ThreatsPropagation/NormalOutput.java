/*******************************************************************************
 *  * Copyright (c) 2015 University of Padova, Intecs
 *  *
 *  *    
 *  * All rights reserved. This program and the accompanying materials
 *  * are made available under the terms of the Eclipse Public License v1.0
 *  * which accompanies this distribution, and is available at
 *  * http://www.eclipse.org/legal/epl-v10.html
 *  *
 *******************************************************************************/
/**
 */
package org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Normal Output</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.NormalOutput#getRecovery <em>Recovery</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatsPropagationPackage#getNormalOutput()
 * @model
 * @generated
 */
public interface NormalOutput extends DepEvent {
	/**
	 * Returns the value of the '<em><b>Recovery</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Recovery</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Recovery</em>' reference.
	 * @see #setRecovery(RecoveryEvent)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatsPropagationPackage#getNormalOutput_Recovery()
	 * @model ordered="false"
	 * @generated
	 */
	RecoveryEvent getRecovery();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.NormalOutput#getRecovery <em>Recovery</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Recovery</em>' reference.
	 * @see #getRecovery()
	 * @generated
	 */
	void setRecovery(RecoveryEvent value);

} // NormalOutput
