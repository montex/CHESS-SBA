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
package org.polarsys.chess.chessmlprofile.Core.CHESSViews;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.CHESSViewsPackage
 * @generated
 */
public interface CHESSViewsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CHESSViewsFactory eINSTANCE = org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.CHESSViewsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Extra Functional View</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extra Functional View</em>'.
	 * @generated
	 */
	ExtraFunctionalView createExtraFunctionalView();

	/**
	 * Returns a new object of class '<em>Timing Data Flow View</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Timing Data Flow View</em>'.
	 * @generated
	 */
	TimingDataFlowView createTimingDataFlowView();

	/**
	 * Returns a new object of class '<em>RT Analysis View</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>RT Analysis View</em>'.
	 * @generated
	 */
	RTAnalysisView createRTAnalysisView();

	/**
	 * Returns a new object of class '<em>Deployment View</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Deployment View</em>'.
	 * @generated
	 */
	DeploymentView createDeploymentView();

	/**
	 * Returns a new object of class '<em>Requirement View</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Requirement View</em>'.
	 * @generated
	 */
	RequirementView createRequirementView();

	/**
	 * Returns a new object of class '<em>Component View</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Component View</em>'.
	 * @generated
	 */
	ComponentView createComponentView();

	/**
	 * Returns a new object of class '<em>Dependability Analysis View</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dependability Analysis View</em>'.
	 * @generated
	 */
	DependabilityAnalysisView createDependabilityAnalysisView();

	/**
	 * Returns a new object of class '<em>System View</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>System View</em>'.
	 * @generated
	 */
	SystemView createSystemView();

	/**
	 * Returns a new object of class '<em>PSM View</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PSM View</em>'.
	 * @generated
	 */
	PSMView createPSMView();

	/**
	 * Returns a new object of class '<em>Analysis View</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Analysis View</em>'.
	 * @generated
	 */
	AnalysisView createAnalysisView();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CHESSViewsPackage getCHESSViewsPackage();

} //CHESSViewsFactory
