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
package org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints;

import org.eclipse.emf.common.util.EList;

import org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.NfpConstraint;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Arbitrary Event Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.ArbitraryEventConstraint#getOffset <em>Offset</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.ArbitraryEventConstraint#getMaximumInterarrivalTime <em>Maximum Interarrival Time</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.ArbitraryEventConstraint#getMinimumInterarrivalTime <em>Minimum Interarrival Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.TimingConstraintsPackage#getArbitraryEventConstraint()
 * @model
 * @generated
 */
public interface ArbitraryEventConstraint extends NfpConstraint {
	/**
	 * Returns the value of the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Offset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offset</em>' attribute.
	 * @see #setOffset(String)
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.TimingConstraintsPackage#getArbitraryEventConstraint_Offset()
	 * @model dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Duration" required="true" ordered="false"
	 * @generated
	 */
	String getOffset();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.ArbitraryEventConstraint#getOffset <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offset</em>' attribute.
	 * @see #getOffset()
	 * @generated
	 */
	void setOffset(String value);

	/**
	 * Returns the value of the '<em><b>Maximum Interarrival Time</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maximum Interarrival Time</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maximum Interarrival Time</em>' attribute list.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.TimingConstraintsPackage#getArbitraryEventConstraint_MaximumInterarrivalTime()
	 * @model dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Duration" ordered="false"
	 * @generated
	 */
	EList<String> getMaximumInterarrivalTime();

	/**
	 * Returns the value of the '<em><b>Minimum Interarrival Time</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Minimum Interarrival Time</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minimum Interarrival Time</em>' attribute list.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.TimingConstraintsPackage#getArbitraryEventConstraint_MinimumInterarrivalTime()
	 * @model dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Duration" ordered="false"
	 * @generated
	 */
	EList<String> getMinimumInterarrivalTime();

} // ArbitraryEventConstraint
