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
package org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaAnalysisContext;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Assign;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scheduling Analysis</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.SchedulingAnalysis#getMapping <em>Mapping</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.SchedulingAnalysis#getResultingPriorities <em>Resulting Priorities</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.SchedulingAnalysis#getSchedulingStrategy <em>Scheduling Strategy</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.DeploymentConfAnalysisPackage#getSchedulingAnalysis()
 * @model
 * @generated
 */
public interface SchedulingAnalysis extends GaAnalysisContext {
	/**
	 * Returns the value of the '<em><b>Mapping</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Assign}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping</em>' reference list.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.DeploymentConfAnalysisPackage#getSchedulingAnalysis_Mapping()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Assign> getMapping();

	/**
	 * Returns the value of the '<em><b>Resulting Priorities</b></em>' reference list.
	 * The list contents are of type {@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resulting Priorities</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resulting Priorities</em>' reference list.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.DeploymentConfAnalysisPackage#getSchedulingAnalysis_ResultingPriorities()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<CHRtSpecification> getResultingPriorities();

	/**
	 * Returns the value of the '<em><b>Scheduling Strategy</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scheduling Strategy</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scheduling Strategy</em>' attribute list.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.DeploymentConfAnalysisPackage#getSchedulingAnalysis_SchedulingStrategy()
	 * @model dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	EList<String> getSchedulingStrategy();

} // SchedulingAnalysis
