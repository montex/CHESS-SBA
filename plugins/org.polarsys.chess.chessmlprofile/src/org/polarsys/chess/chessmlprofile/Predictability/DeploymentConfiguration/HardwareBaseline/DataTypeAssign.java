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
package org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Comment;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Type Assign</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.DataTypeAssign#getBase_Comment <em>Base Comment</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.DataTypeAssign#getFrom <em>From</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.DataTypeAssign#getTo <em>To</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.HardwareBaselinePackage#getDataTypeAssign()
 * @model
 * @generated
 */
public interface DataTypeAssign extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Comment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Comment</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Comment</em>' reference.
	 * @see #setBase_Comment(Comment)
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.HardwareBaselinePackage#getDataTypeAssign_Base_Comment()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Comment getBase_Comment();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.DataTypeAssign#getBase_Comment <em>Base Comment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Comment</em>' reference.
	 * @see #getBase_Comment()
	 * @generated
	 */
	void setBase_Comment(Comment value);

	/**
	 * Returns the value of the '<em><b>From</b></em>' reference list.
	 * The list contents are of type {@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.SWDataType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From</em>' reference list.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.HardwareBaselinePackage#getDataTypeAssign_From()
	 * @model ordered="false"
	 * @generated
	 */
	EList<SWDataType> getFrom();

	/**
	 * Returns the value of the '<em><b>To</b></em>' reference list.
	 * The list contents are of type {@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.HWDataType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To</em>' reference list.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.HardwareBaselinePackage#getDataTypeAssign_To()
	 * @model ordered="false"
	 * @generated
	 */
	EList<HWDataType> getTo();

} // DataTypeAssign
