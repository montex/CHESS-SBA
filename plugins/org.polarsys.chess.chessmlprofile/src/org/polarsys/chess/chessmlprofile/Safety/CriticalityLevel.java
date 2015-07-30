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
 * A representation of the model object '<em><b>Criticality Level</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Safety.CriticalityLevel#getBase_Constraint <em>Base Constraint</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Safety.CriticalityLevel#getIsHigherThan <em>Is Higher Than</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Safety.CriticalityLevel#getMapsTo <em>Maps To</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.chess.chessmlprofile.Safety.SafetyPackage#getCriticalityLevel()
 * @model
 * @generated
 */
public interface CriticalityLevel extends EObject {
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
	 * @see org.polarsys.chess.chessmlprofile.Safety.SafetyPackage#getCriticalityLevel_Base_Constraint()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Constraint getBase_Constraint();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Safety.CriticalityLevel#getBase_Constraint <em>Base Constraint</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Constraint</em>' reference.
	 * @see #getBase_Constraint()
	 * @generated
	 */
	void setBase_Constraint(Constraint value);

	/**
	 * Returns the value of the '<em><b>Is Higher Than</b></em>' reference list.
	 * The list contents are of type {@link org.polarsys.chess.chessmlprofile.Safety.CriticalityLevel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Higher Than</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Higher Than</em>' reference list.
	 * @see org.polarsys.chess.chessmlprofile.Safety.SafetyPackage#getCriticalityLevel_IsHigherThan()
	 * @model ordered="false"
	 * @generated
	 */
	EList<CriticalityLevel> getIsHigherThan();

	/**
	 * Returns the value of the '<em><b>Maps To</b></em>' reference list.
	 * The list contents are of type {@link org.polarsys.chess.chessmlprofile.Safety.CriticalityLevel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maps To</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maps To</em>' reference list.
	 * @see org.polarsys.chess.chessmlprofile.Safety.SafetyPackage#getCriticalityLevel_MapsTo()
	 * @model ordered="false"
	 * @generated
	 */
	EList<CriticalityLevel> getMapsTo();

} // CriticalityLevel
