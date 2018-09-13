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
package org.polarsys.chess.chessmlprofile.Safety;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Constraint;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Criticality Interface Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Allows for a given provided port of a component instance to constrains the criticality level that a given component isntance must have in order to be able to access the port.
 * In case of base Constraint, the constrained element must refer a provided port+ instance or a slot, the latter as instance of a provided port.
 * In case of base Comment, its usage is the same of the CHRTSpecification.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Safety.CriticalityInterfaceSpecification#getBase_Constraint <em>Base Constraint</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Safety.CriticalityInterfaceSpecification#getAcceptedCriticalityForClients <em>Accepted Criticality For Clients</em>}</li>
 * </ul>
 *
 * @see org.polarsys.chess.chessmlprofile.Safety.SafetyPackage#getCriticalityInterfaceSpecification()
 * @model
 * @generated
 */
public interface CriticalityInterfaceSpecification extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Constraint</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Constraint</em>' reference.
	 * @see #setBase_Constraint(Constraint)
	 * @see org.polarsys.chess.chessmlprofile.Safety.SafetyPackage#getCriticalityInterfaceSpecification_Base_Constraint()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Constraint getBase_Constraint();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Safety.CriticalityInterfaceSpecification#getBase_Constraint <em>Base Constraint</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Constraint</em>' reference.
	 * @see #getBase_Constraint()
	 * @generated
	 */
	void setBase_Constraint(Constraint value);

	/**
	 * Returns the value of the '<em><b>Accepted Criticality For Clients</b></em>' reference list.
	 * The list contents are of type {@link org.polarsys.chess.chessmlprofile.Safety.CriticalityLevel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Accepted Criticality For Clients</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Accepted Criticality For Clients</em>' reference list.
	 * @see org.polarsys.chess.chessmlprofile.Safety.SafetyPackage#getCriticalityInterfaceSpecification_AcceptedCriticalityForClients()
	 * @model ordered="false"
	 * @generated
	 */
	EList<CriticalityLevel> getAcceptedCriticalityForClients();

} // CriticalityInterfaceSpecification
