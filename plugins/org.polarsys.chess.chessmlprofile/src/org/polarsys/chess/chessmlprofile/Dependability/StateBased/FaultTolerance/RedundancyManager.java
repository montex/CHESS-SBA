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
import org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.RedundancyKind;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Redundancy Manager</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.RedundancyManager#getBase_Component <em>Base Component</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.RedundancyManager#getScheme <em>Scheme</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.FaultTolerancePackage#getRedundancyManager()
 * @model
 * @generated
 */
public interface RedundancyManager extends EObject {
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
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.FaultTolerancePackage#getRedundancyManager_Base_Component()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Component getBase_Component();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.RedundancyManager#getBase_Component <em>Base Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Component</em>' reference.
	 * @see #getBase_Component()
	 * @generated
	 */
	void setBase_Component(Component value);

	/**
	 * Returns the value of the '<em><b>Scheme</b></em>' attribute.
	 * The literals are from the enumeration {@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.RedundancyKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scheme</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scheme</em>' attribute.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.RedundancyKind
	 * @see #setScheme(RedundancyKind)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.FaultTolerancePackage#getRedundancyManager_Scheme()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	RedundancyKind getScheme();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.RedundancyManager#getScheme <em>Scheme</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scheme</em>' attribute.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.RedundancyKind
	 * @see #getScheme()
	 * @generated
	 */
	void setScheme(RedundancyKind value);

} // RedundancyManager
