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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Comment;
import org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.A_mitigation;
import org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.C_mitigation;
import org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.D_mitigation;
import org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.I_mitigation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ACID Mitigation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.ACIDMitigation#getBase_Comment <em>Base Comment</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.ACIDMitigation#getA <em>A</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.ACIDMitigation#getC <em>C</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.ACIDMitigation#getI <em>I</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.ACIDMitigation#getD <em>D</em>}</li>
 * </ul>
 *
 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationPackage#getACIDMitigation()
 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='ACIDMitigation '"
 * @generated
 */
public interface ACIDMitigation extends EObject {
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
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationPackage#getACIDMitigation_Base_Comment()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Comment getBase_Comment();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.ACIDMitigation#getBase_Comment <em>Base Comment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Comment</em>' reference.
	 * @see #getBase_Comment()
	 * @generated
	 */
	void setBase_Comment(Comment value);

	/**
	 * Returns the value of the '<em><b>A</b></em>' attribute.
	 * The literals are from the enumeration {@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.A_mitigation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>A</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>A</em>' attribute.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.A_mitigation
	 * @see #setA(A_mitigation)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationPackage#getACIDMitigation_A()
	 * @model ordered="false"
	 * @generated
	 */
	A_mitigation getA();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.ACIDMitigation#getA <em>A</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>A</em>' attribute.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.A_mitigation
	 * @see #getA()
	 * @generated
	 */
	void setA(A_mitigation value);

	/**
	 * Returns the value of the '<em><b>C</b></em>' attribute.
	 * The literals are from the enumeration {@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.C_mitigation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>C</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>C</em>' attribute.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.C_mitigation
	 * @see #setC(C_mitigation)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationPackage#getACIDMitigation_C()
	 * @model ordered="false"
	 * @generated
	 */
	C_mitigation getC();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.ACIDMitigation#getC <em>C</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>C</em>' attribute.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.C_mitigation
	 * @see #getC()
	 * @generated
	 */
	void setC(C_mitigation value);

	/**
	 * Returns the value of the '<em><b>I</b></em>' attribute.
	 * The literals are from the enumeration {@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.I_mitigation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>I</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>I</em>' attribute.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.I_mitigation
	 * @see #setI(I_mitigation)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationPackage#getACIDMitigation_I()
	 * @model ordered="false"
	 * @generated
	 */
	I_mitigation getI();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.ACIDMitigation#getI <em>I</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>I</em>' attribute.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.I_mitigation
	 * @see #getI()
	 * @generated
	 */
	void setI(I_mitigation value);

	/**
	 * Returns the value of the '<em><b>D</b></em>' attribute.
	 * The literals are from the enumeration {@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.D_mitigation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>D</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>D</em>' attribute.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.D_mitigation
	 * @see #setD(D_mitigation)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationPackage#getACIDMitigation_D()
	 * @model ordered="false"
	 * @generated
	 */
	D_mitigation getD();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.ACIDMitigation#getD <em>D</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>D</em>' attribute.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.D_mitigation
	 * @see #getD()
	 * @generated
	 */
	void setD(D_mitigation value);

} // ACIDMitigation
