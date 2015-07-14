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

import org.eclipse.uml2.uml.ControlFlow;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CH Control Flow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CHControlFlow#getBase_ControlFlow <em>Base Control Flow</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CHControlFlow#getRep <em>Rep</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CHControlFlow#getProb <em>Prob</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CHControlFlow#getOrder <em>Order</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CHControlFlow#getCompComplex <em>Comp Complex</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.HardwareBaselinePackage#getCHControlFlow()
 * @model
 * @generated
 */
public interface CHControlFlow extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Control Flow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Control Flow</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Control Flow</em>' reference.
	 * @see #setBase_ControlFlow(ControlFlow)
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.HardwareBaselinePackage#getCHControlFlow_Base_ControlFlow()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ControlFlow getBase_ControlFlow();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CHControlFlow#getBase_ControlFlow <em>Base Control Flow</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Control Flow</em>' reference.
	 * @see #getBase_ControlFlow()
	 * @generated
	 */
	void setBase_ControlFlow(ControlFlow value);

	/**
	 * Returns the value of the '<em><b>Rep</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rep</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rep</em>' attribute.
	 * @see #setRep(String)
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.HardwareBaselinePackage#getCHControlFlow_Rep()
	 * @model dataType="org.eclipse.papyrus.MARTE_Library.MARTE_PrimitivesTypes.Real" ordered="false"
	 * @generated
	 */
	String getRep();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CHControlFlow#getRep <em>Rep</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rep</em>' attribute.
	 * @see #getRep()
	 * @generated
	 */
	void setRep(String value);

	/**
	 * Returns the value of the '<em><b>Prob</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prob</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prob</em>' attribute.
	 * @see #setProb(String)
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.HardwareBaselinePackage#getCHControlFlow_Prob()
	 * @model dataType="org.eclipse.papyrus.MARTE_Library.MARTE_PrimitivesTypes.Real" ordered="false"
	 * @generated
	 */
	String getProb();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CHControlFlow#getProb <em>Prob</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prob</em>' attribute.
	 * @see #getProb()
	 * @generated
	 */
	void setProb(String value);

	/**
	 * Returns the value of the '<em><b>Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Order</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Order</em>' attribute.
	 * @see #setOrder(String)
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.HardwareBaselinePackage#getCHControlFlow_Order()
	 * @model dataType="org.eclipse.papyrus.MARTE_Library.MARTE_PrimitivesTypes.Real" ordered="false"
	 * @generated
	 */
	String getOrder();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CHControlFlow#getOrder <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Order</em>' attribute.
	 * @see #getOrder()
	 * @generated
	 */
	void setOrder(String value);

	/**
	 * Returns the value of the '<em><b>Comp Complex</b></em>' reference list.
	 * The list contents are of type {@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.ComputeComplexity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comp Complex</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comp Complex</em>' reference list.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.HardwareBaselinePackage#getCHControlFlow_CompComplex()
	 * @model ordered="false"
	 * @generated
	 */
	EList<ComputeComplexity> getCompComplex();

} // CHControlFlow
