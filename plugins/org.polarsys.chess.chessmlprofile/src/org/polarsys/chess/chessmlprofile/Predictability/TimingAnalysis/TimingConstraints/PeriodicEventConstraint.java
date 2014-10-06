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

import org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.NfpConstraint;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Periodic Event Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.PeriodicEventConstraint#getOffset <em>Offset</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.PeriodicEventConstraint#getJitter <em>Jitter</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.PeriodicEventConstraint#getMinimumInterarrivalTime <em>Minimum Interarrival Time</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.PeriodicEventConstraint#getPeriod <em>Period</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.TimingConstraintsPackage#getPeriodicEventConstraint()
 * @model
 * @generated
 */
public interface PeriodicEventConstraint extends NfpConstraint {
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
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.TimingConstraintsPackage#getPeriodicEventConstraint_Offset()
	 * @model dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Duration" required="true" ordered="false"
	 * @generated
	 */
	String getOffset();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.PeriodicEventConstraint#getOffset <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offset</em>' attribute.
	 * @see #getOffset()
	 * @generated
	 */
	void setOffset(String value);

	/**
	 * Returns the value of the '<em><b>Jitter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Jitter</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jitter</em>' attribute.
	 * @see #setJitter(String)
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.TimingConstraintsPackage#getPeriodicEventConstraint_Jitter()
	 * @model dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Duration" required="true" ordered="false"
	 * @generated
	 */
	String getJitter();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.PeriodicEventConstraint#getJitter <em>Jitter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jitter</em>' attribute.
	 * @see #getJitter()
	 * @generated
	 */
	void setJitter(String value);

	/**
	 * Returns the value of the '<em><b>Minimum Interarrival Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Minimum Interarrival Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minimum Interarrival Time</em>' attribute.
	 * @see #setMinimumInterarrivalTime(String)
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.TimingConstraintsPackage#getPeriodicEventConstraint_MinimumInterarrivalTime()
	 * @model dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Duration" required="true" ordered="false"
	 * @generated
	 */
	String getMinimumInterarrivalTime();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.PeriodicEventConstraint#getMinimumInterarrivalTime <em>Minimum Interarrival Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimum Interarrival Time</em>' attribute.
	 * @see #getMinimumInterarrivalTime()
	 * @generated
	 */
	void setMinimumInterarrivalTime(String value);

	/**
	 * Returns the value of the '<em><b>Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Period</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Period</em>' attribute.
	 * @see #setPeriod(String)
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.TimingConstraintsPackage#getPeriodicEventConstraint_Period()
	 * @model dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Duration" required="true" ordered="false"
	 * @generated
	 */
	String getPeriod();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.PeriodicEventConstraint#getPeriod <em>Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Period</em>' attribute.
	 * @see #getPeriod()
	 * @generated
	 */
	void setPeriod(String value);

} // PeriodicEventConstraint
