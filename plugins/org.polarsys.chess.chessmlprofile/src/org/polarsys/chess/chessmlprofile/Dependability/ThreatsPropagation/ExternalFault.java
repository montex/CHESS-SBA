/*****************************************************************************
 * Copyright (c) 2011, 2015 University of Padova, Intecs
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *
 *****************************************************************************/
package org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Type;
import org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.FailureMode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>External Fault</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * to be deleted?
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ExternalFault#getFailure <em>Failure</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatsPropagationPackage#getExternalFault()
 * @model
 * @generated
 */
public interface ExternalFault extends DepEvent {
	/**
	 * Returns the value of the '<em><b>Failure</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Failure</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Failure</em>' reference.
	 * @see #setFailure(FailureMode)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatsPropagationPackage#getExternalFault_Failure()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	FailureMode getFailure();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ExternalFault#getFailure <em>Failure</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Failure</em>' reference.
	 * @see #getFailure()
	 * @generated
	 */
	void setFailure(FailureMode value);

} // ExternalFault
