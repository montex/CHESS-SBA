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
package org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Property;
import org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.FailureType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>FPTC Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FPTCSpecification#getBase_Comment <em>Base Comment</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FPTCSpecification#getFailure <em>Failure</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FPTCSpecification#getPartWithPort <em>Part With Port</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationPackage#getFPTCSpecification()
 * @model
 * @generated
 */
public interface FPTCSpecification extends EObject {
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
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationPackage#getFPTCSpecification_Base_Comment()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Comment getBase_Comment();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FPTCSpecification#getBase_Comment <em>Base Comment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Comment</em>' reference.
	 * @see #getBase_Comment()
	 * @generated
	 */
	void setBase_Comment(Comment value);

	/**
	 * Returns the value of the '<em><b>Failure</b></em>' attribute list.
	 * The list contents are of type {@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.FailureType}.
	 * The literals are from the enumeration {@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.FailureType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Failure</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Failure</em>' attribute list.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.FailureType
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationPackage#getFPTCSpecification_Failure()
	 * @model ordered="false"
	 * @generated
	 */
	EList<FailureType> getFailure();

	/**
	 * Returns the value of the '<em><b>Part With Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part With Port</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part With Port</em>' reference.
	 * @see #setPartWithPort(Property)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationPackage#getFPTCSpecification_PartWithPort()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Property getPartWithPort();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FPTCSpecification#getPartWithPort <em>Part With Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Part With Port</em>' reference.
	 * @see #getPartWithPort()
	 * @generated
	 */
	void setPartWithPort(Property value);

} // FPTCSpecification
