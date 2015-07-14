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
package org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Constraint;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>FLA Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FLASpecification#getBase_Constraint <em>Base Constraint</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FLASpecification#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FLASpecification#getExpressions <em>Expressions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationPackage#getFLASpecification()
 * @model
 * @generated
 */
public interface FLASpecification extends EObject {
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
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationPackage#getFLASpecification_Base_Constraint()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Constraint getBase_Constraint();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FLASpecification#getBase_Constraint <em>Base Constraint</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Constraint</em>' reference.
	 * @see #getBase_Constraint()
	 * @generated
	 */
	void setBase_Constraint(Constraint value);

	/**
	 * Returns the value of the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Class</em>' reference.
	 * @see #setBase_Class(org.eclipse.uml2.uml.Class)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationPackage#getFLASpecification_Base_Class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FLASpecification#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

	/**
	 * Returns the value of the '<em><b>Expressions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expressions</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expressions</em>' attribute.
	 * @see #setExpressions(String)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationPackage#getFLASpecification_Expressions()
	 * @model dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_String" required="true" ordered="false"
	 * @generated
	 */
	String getExpressions();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FLASpecification#getExpressions <em>Expressions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expressions</em>' attribute.
	 * @see #getExpressions()
	 * @generated
	 */
	void setExpressions(String value);

} // FLASpecification
