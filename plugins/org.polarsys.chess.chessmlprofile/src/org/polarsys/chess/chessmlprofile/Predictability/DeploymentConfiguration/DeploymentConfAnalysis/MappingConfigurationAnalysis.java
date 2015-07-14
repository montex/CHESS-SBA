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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Configuration Analysis</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.MappingConfigurationAnalysis#getProhibitedAllocations <em>Prohibited Allocations</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.MappingConfigurationAnalysis#getFixedAllocations <em>Fixed Allocations</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.MappingConfigurationAnalysis#isBottomUpAnalysis <em>Bottom Up Analysis</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.MappingConfigurationAnalysis#getResultingMapping <em>Resulting Mapping</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.DeploymentConfAnalysisPackage#getMappingConfigurationAnalysis()
 * @model
 * @generated
 */
public interface MappingConfigurationAnalysis extends GaAnalysisContext {
	/**
	 * Returns the value of the '<em><b>Prohibited Allocations</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Assign}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prohibited Allocations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prohibited Allocations</em>' reference list.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.DeploymentConfAnalysisPackage#getMappingConfigurationAnalysis_ProhibitedAllocations()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Assign> getProhibitedAllocations();

	/**
	 * Returns the value of the '<em><b>Fixed Allocations</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Assign}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fixed Allocations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fixed Allocations</em>' reference list.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.DeploymentConfAnalysisPackage#getMappingConfigurationAnalysis_FixedAllocations()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Assign> getFixedAllocations();

	/**
	 * Returns the value of the '<em><b>Bottom Up Analysis</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bottom Up Analysis</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bottom Up Analysis</em>' attribute.
	 * @see #setBottomUpAnalysis(boolean)
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.DeploymentConfAnalysisPackage#getMappingConfigurationAnalysis_BottomUpAnalysis()
	 * @model dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isBottomUpAnalysis();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.MappingConfigurationAnalysis#isBottomUpAnalysis <em>Bottom Up Analysis</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bottom Up Analysis</em>' attribute.
	 * @see #isBottomUpAnalysis()
	 * @generated
	 */
	void setBottomUpAnalysis(boolean value);

	/**
	 * Returns the value of the '<em><b>Resulting Mapping</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Assign}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resulting Mapping</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resulting Mapping</em>' reference list.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.DeploymentConfAnalysisPackage#getMappingConfigurationAnalysis_ResultingMapping()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<Assign> getResultingMapping();

} // MappingConfigurationAnalysis
