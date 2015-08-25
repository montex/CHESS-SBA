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
package org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents;

import org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponent;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stateless Software</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * obsolete, see SimpleStochasticBehaviour
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.StatelessSoftware#getFaultOcc <em>Fault Occ</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.StateBasedComponentsPackage#getStatelessSoftware()
 * @model
 * @generated
 */
public interface StatelessSoftware extends DependableComponent {
	/**
	 * Returns the value of the '<em><b>Fault Occ</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault Occ</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault Occ</em>' attribute.
	 * @see #setFaultOcc(String)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.StateBasedComponentsPackage#getStatelessSoftware_FaultOcc()
	 * @model dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Frequency" ordered="false"
	 * @generated
	 */
	String getFaultOcc();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.StatelessSoftware#getFaultOcc <em>Fault Occ</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault Occ</em>' attribute.
	 * @see #getFaultOcc()
	 * @generated
	 */
	void setFaultOcc(String value);

} // StatelessSoftware
