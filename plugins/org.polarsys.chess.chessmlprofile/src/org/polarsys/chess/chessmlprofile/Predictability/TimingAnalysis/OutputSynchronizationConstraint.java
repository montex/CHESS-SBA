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
package org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis;

import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaLatencyObs;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Output Synchronization Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.OutputSynchronizationConstraint#getWidth <em>Width</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingAnalysisPackage#getOutputSynchronizationConstraint()
 * @model
 * @generated
 */
public interface OutputSynchronizationConstraint extends GaLatencyObs {
	/**
	 * Returns the value of the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Width</em>' attribute.
	 * @see #setWidth(String)
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingAnalysisPackage#getOutputSynchronizationConstraint_Width()
	 * @model dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Duration" required="true" ordered="false"
	 * @generated
	 */
	String getWidth();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.OutputSynchronizationConstraint#getWidth <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Width</em>' attribute.
	 * @see #getWidth()
	 * @generated
	 */
	void setWidth(String value);

} // OutputSynchronizationConstraint
