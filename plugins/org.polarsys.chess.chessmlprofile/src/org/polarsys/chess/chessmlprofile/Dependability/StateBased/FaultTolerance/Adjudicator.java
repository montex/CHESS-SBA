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
package org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Component;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Adjudicator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.Adjudicator#getBase_Component <em>Base Component</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.Adjudicator#getCoverage <em>Coverage</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.FaultTolerancePackage#getAdjudicator()
 * @model
 * @generated
 */
public interface Adjudicator extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Component</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Component</em>' reference.
	 * @see #setBase_Component(Component)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.FaultTolerancePackage#getAdjudicator_Base_Component()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Component getBase_Component();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.Adjudicator#getBase_Component <em>Base Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Component</em>' reference.
	 * @see #getBase_Component()
	 * @generated
	 */
	void setBase_Component(Component value);

	/**
	 * Returns the value of the '<em><b>Coverage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Coverage</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Coverage</em>' attribute.
	 * @see #setCoverage(String)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.FaultTolerancePackage#getAdjudicator_Coverage()
	 * @model dataType="org.eclipse.papyrus.MARTE_Library.MARTE_PrimitivesTypes.Real" required="true" ordered="false"
	 * @generated
	 */
	String getCoverage();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.Adjudicator#getCoverage <em>Coverage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Coverage</em>' attribute.
	 * @see #getCoverage()
	 * @generated
	 */
	void setCoverage(String value);

} // Adjudicator
