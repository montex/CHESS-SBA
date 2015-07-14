/*****************************************************************************
 * Copyright (c) 2011 - 2014 University of Padova, Intecs
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

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.State;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Threat State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatState#getBase_State <em>Base State</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatState#getProbability <em>Probability</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatState#getUnit <em>Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatsPropagationPackage#getThreatState()
 * @model
 * @generated
 */
public interface ThreatState extends EObject {
	/**
	 * Returns the value of the '<em><b>Base State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base State</em>' reference.
	 * @see #setBase_State(State)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatsPropagationPackage#getThreatState_Base_State()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	State getBase_State();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatState#getBase_State <em>Base State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base State</em>' reference.
	 * @see #getBase_State()
	 * @generated
	 */
	void setBase_State(State value);

	/**
	 * Returns the value of the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Probability</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Probability</em>' attribute.
	 * @see #setProbability(String)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatsPropagationPackage#getThreatState_Probability()
	 * @model dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Real" required="true" ordered="false"
	 * @generated
	 */
	String getProbability();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatState#getProbability <em>Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Probability</em>' attribute.
	 * @see #getProbability()
	 * @generated
	 */
	void setProbability(String value);

	/**
	 * Returns the value of the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit</em>' attribute.
	 * @see #setUnit(String)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatsPropagationPackage#getThreatState_Unit()
	 * @model dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	String getUnit();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatState#getUnit <em>Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit</em>' attribute.
	 * @see #getUnit()
	 * @generated
	 */
	void setUnit(String value);

} // ThreatState
