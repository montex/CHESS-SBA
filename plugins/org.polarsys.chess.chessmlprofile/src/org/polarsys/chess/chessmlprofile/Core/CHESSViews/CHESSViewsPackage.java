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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.CHESSViewsFactory
 * @model kind="package"
 * @generated
 */
public interface CHESSViewsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "CHESSViews";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://CHESS/Core/Views";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "CHESSViews";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CHESSViewsPackage eINSTANCE = org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.CHESSViewsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.ExtraFunctionalViewImpl <em>Extra Functional View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.ExtraFunctionalViewImpl
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.CHESSViewsPackageImpl#getExtraFunctionalView()
	 * @generated
	 */
	int EXTRA_FUNCTIONAL_VIEW = 0;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRA_FUNCTIONAL_VIEW__BASE_PACKAGE = 0;

	/**
	 * The feature id for the '<em><b>Timingdataflowview</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRA_FUNCTIONAL_VIEW__TIMINGDATAFLOWVIEW = 1;

	/**
	 * The number of structural features of the '<em>Extra Functional View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRA_FUNCTIONAL_VIEW_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.TimingDataFlowViewImpl <em>Timing Data Flow View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.TimingDataFlowViewImpl
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.CHESSViewsPackageImpl#getTimingDataFlowView()
	 * @generated
	 */
	int TIMING_DATA_FLOW_VIEW = 1;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMING_DATA_FLOW_VIEW__BASE_PACKAGE = 0;

	/**
	 * The number of structural features of the '<em>Timing Data Flow View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMING_DATA_FLOW_VIEW_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.RTAnalysisViewImpl <em>RT Analysis View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.RTAnalysisViewImpl
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.CHESSViewsPackageImpl#getRTAnalysisView()
	 * @generated
	 */
	int RT_ANALYSIS_VIEW = 2;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_ANALYSIS_VIEW__BASE_PACKAGE = 0;

	/**
	 * The number of structural features of the '<em>RT Analysis View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_ANALYSIS_VIEW_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.DeploymentViewImpl <em>Deployment View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.DeploymentViewImpl
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.CHESSViewsPackageImpl#getDeploymentView()
	 * @generated
	 */
	int DEPLOYMENT_VIEW = 3;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_VIEW__BASE_PACKAGE = 0;

	/**
	 * The feature id for the '<em><b>Assign List</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_VIEW__ASSIGN_LIST = 1;

	/**
	 * The number of structural features of the '<em>Deployment View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_VIEW_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.RequirementViewImpl <em>Requirement View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.RequirementViewImpl
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.CHESSViewsPackageImpl#getRequirementView()
	 * @generated
	 */
	int REQUIREMENT_VIEW = 4;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_VIEW__BASE_PACKAGE = 0;

	/**
	 * The number of structural features of the '<em>Requirement View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_VIEW_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.ComponentViewImpl <em>Component View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.ComponentViewImpl
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.CHESSViewsPackageImpl#getComponentView()
	 * @generated
	 */
	int COMPONENT_VIEW = 5;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_VIEW__BASE_PACKAGE = 0;

	/**
	 * The number of structural features of the '<em>Component View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_VIEW_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.DependabilityAnalysisViewImpl <em>Dependability Analysis View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.DependabilityAnalysisViewImpl
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.CHESSViewsPackageImpl#getDependabilityAnalysisView()
	 * @generated
	 */
	int DEPENDABILITY_ANALYSIS_VIEW = 6;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDABILITY_ANALYSIS_VIEW__BASE_PACKAGE = 0;

	/**
	 * The number of structural features of the '<em>Dependability Analysis View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDABILITY_ANALYSIS_VIEW_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.SystemViewImpl <em>System View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.SystemViewImpl
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.CHESSViewsPackageImpl#getSystemView()
	 * @generated
	 */
	int SYSTEM_VIEW = 7;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_VIEW__BASE_PACKAGE = 0;

	/**
	 * The number of structural features of the '<em>System View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_VIEW_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.PSMViewImpl <em>PSM View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.PSMViewImpl
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.CHESSViewsPackageImpl#getPSMView()
	 * @generated
	 */
	int PSM_VIEW = 8;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSM_VIEW__BASE_PACKAGE = 0;

	/**
	 * The number of structural features of the '<em>PSM View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSM_VIEW_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.AnalysisViewImpl <em>Analysis View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.AnalysisViewImpl
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.CHESSViewsPackageImpl#getAnalysisView()
	 * @generated
	 */
	int ANALYSIS_VIEW = 9;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_VIEW__BASE_PACKAGE = 0;

	/**
	 * The feature id for the '<em><b>Rtanalysisview</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_VIEW__RTANALYSISVIEW = 1;

	/**
	 * The feature id for the '<em><b>Depanalysisview</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_VIEW__DEPANALYSISVIEW = 2;

	/**
	 * The number of structural features of the '<em>Analysis View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_VIEW_FEATURE_COUNT = 3;


	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.ExtraFunctionalView <em>Extra Functional View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extra Functional View</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.ExtraFunctionalView
	 * @generated
	 */
	EClass getExtraFunctionalView();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.ExtraFunctionalView#getBase_Package <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.ExtraFunctionalView#getBase_Package()
	 * @see #getExtraFunctionalView()
	 * @generated
	 */
	EReference getExtraFunctionalView_Base_Package();

	/**
	 * Returns the meta object for the containment reference '{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.ExtraFunctionalView#getTimingdataflowview <em>Timingdataflowview</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Timingdataflowview</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.ExtraFunctionalView#getTimingdataflowview()
	 * @see #getExtraFunctionalView()
	 * @generated
	 */
	EReference getExtraFunctionalView_Timingdataflowview();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.TimingDataFlowView <em>Timing Data Flow View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Timing Data Flow View</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.TimingDataFlowView
	 * @generated
	 */
	EClass getTimingDataFlowView();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.TimingDataFlowView#getBase_Package <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.TimingDataFlowView#getBase_Package()
	 * @see #getTimingDataFlowView()
	 * @generated
	 */
	EReference getTimingDataFlowView_Base_Package();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.RTAnalysisView <em>RT Analysis View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>RT Analysis View</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.RTAnalysisView
	 * @generated
	 */
	EClass getRTAnalysisView();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.RTAnalysisView#getBase_Package <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.RTAnalysisView#getBase_Package()
	 * @see #getRTAnalysisView()
	 * @generated
	 */
	EReference getRTAnalysisView_Base_Package();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.DeploymentView <em>Deployment View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deployment View</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.DeploymentView
	 * @generated
	 */
	EClass getDeploymentView();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.DeploymentView#getBase_Package <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.DeploymentView#getBase_Package()
	 * @see #getDeploymentView()
	 * @generated
	 */
	EReference getDeploymentView_Base_Package();

	/**
	 * Returns the meta object for the reference list '{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.DeploymentView#getAssignList <em>Assign List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Assign List</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.DeploymentView#getAssignList()
	 * @see #getDeploymentView()
	 * @generated
	 */
	EReference getDeploymentView_AssignList();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.RequirementView <em>Requirement View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Requirement View</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.RequirementView
	 * @generated
	 */
	EClass getRequirementView();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.RequirementView#getBase_Package <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.RequirementView#getBase_Package()
	 * @see #getRequirementView()
	 * @generated
	 */
	EReference getRequirementView_Base_Package();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.ComponentView <em>Component View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component View</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.ComponentView
	 * @generated
	 */
	EClass getComponentView();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.ComponentView#getBase_Package <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.ComponentView#getBase_Package()
	 * @see #getComponentView()
	 * @generated
	 */
	EReference getComponentView_Base_Package();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.DependabilityAnalysisView <em>Dependability Analysis View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dependability Analysis View</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.DependabilityAnalysisView
	 * @generated
	 */
	EClass getDependabilityAnalysisView();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.DependabilityAnalysisView#getBase_Package <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.DependabilityAnalysisView#getBase_Package()
	 * @see #getDependabilityAnalysisView()
	 * @generated
	 */
	EReference getDependabilityAnalysisView_Base_Package();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.SystemView <em>System View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System View</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.SystemView
	 * @generated
	 */
	EClass getSystemView();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.SystemView#getBase_Package <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.SystemView#getBase_Package()
	 * @see #getSystemView()
	 * @generated
	 */
	EReference getSystemView_Base_Package();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.PSMView <em>PSM View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PSM View</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.PSMView
	 * @generated
	 */
	EClass getPSMView();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.PSMView#getBase_Package <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.PSMView#getBase_Package()
	 * @see #getPSMView()
	 * @generated
	 */
	EReference getPSMView_Base_Package();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.AnalysisView <em>Analysis View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Analysis View</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.AnalysisView
	 * @generated
	 */
	EClass getAnalysisView();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.AnalysisView#getBase_Package <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.AnalysisView#getBase_Package()
	 * @see #getAnalysisView()
	 * @generated
	 */
	EReference getAnalysisView_Base_Package();

	/**
	 * Returns the meta object for the containment reference '{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.AnalysisView#getRtanalysisview <em>Rtanalysisview</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rtanalysisview</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.AnalysisView#getRtanalysisview()
	 * @see #getAnalysisView()
	 * @generated
	 */
	EReference getAnalysisView_Rtanalysisview();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.AnalysisView#getDepanalysisview <em>Depanalysisview</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Depanalysisview</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.AnalysisView#getDepanalysisview()
	 * @see #getAnalysisView()
	 * @generated
	 */
	EReference getAnalysisView_Depanalysisview();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CHESSViewsFactory getCHESSViewsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.ExtraFunctionalViewImpl <em>Extra Functional View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.ExtraFunctionalViewImpl
		 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.CHESSViewsPackageImpl#getExtraFunctionalView()
		 * @generated
		 */
		EClass EXTRA_FUNCTIONAL_VIEW = eINSTANCE.getExtraFunctionalView();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTRA_FUNCTIONAL_VIEW__BASE_PACKAGE = eINSTANCE.getExtraFunctionalView_Base_Package();

		/**
		 * The meta object literal for the '<em><b>Timingdataflowview</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTRA_FUNCTIONAL_VIEW__TIMINGDATAFLOWVIEW = eINSTANCE.getExtraFunctionalView_Timingdataflowview();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.TimingDataFlowViewImpl <em>Timing Data Flow View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.TimingDataFlowViewImpl
		 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.CHESSViewsPackageImpl#getTimingDataFlowView()
		 * @generated
		 */
		EClass TIMING_DATA_FLOW_VIEW = eINSTANCE.getTimingDataFlowView();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIMING_DATA_FLOW_VIEW__BASE_PACKAGE = eINSTANCE.getTimingDataFlowView_Base_Package();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.RTAnalysisViewImpl <em>RT Analysis View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.RTAnalysisViewImpl
		 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.CHESSViewsPackageImpl#getRTAnalysisView()
		 * @generated
		 */
		EClass RT_ANALYSIS_VIEW = eINSTANCE.getRTAnalysisView();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RT_ANALYSIS_VIEW__BASE_PACKAGE = eINSTANCE.getRTAnalysisView_Base_Package();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.DeploymentViewImpl <em>Deployment View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.DeploymentViewImpl
		 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.CHESSViewsPackageImpl#getDeploymentView()
		 * @generated
		 */
		EClass DEPLOYMENT_VIEW = eINSTANCE.getDeploymentView();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOYMENT_VIEW__BASE_PACKAGE = eINSTANCE.getDeploymentView_Base_Package();

		/**
		 * The meta object literal for the '<em><b>Assign List</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOYMENT_VIEW__ASSIGN_LIST = eINSTANCE.getDeploymentView_AssignList();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.RequirementViewImpl <em>Requirement View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.RequirementViewImpl
		 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.CHESSViewsPackageImpl#getRequirementView()
		 * @generated
		 */
		EClass REQUIREMENT_VIEW = eINSTANCE.getRequirementView();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENT_VIEW__BASE_PACKAGE = eINSTANCE.getRequirementView_Base_Package();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.ComponentViewImpl <em>Component View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.ComponentViewImpl
		 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.CHESSViewsPackageImpl#getComponentView()
		 * @generated
		 */
		EClass COMPONENT_VIEW = eINSTANCE.getComponentView();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_VIEW__BASE_PACKAGE = eINSTANCE.getComponentView_Base_Package();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.DependabilityAnalysisViewImpl <em>Dependability Analysis View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.DependabilityAnalysisViewImpl
		 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.CHESSViewsPackageImpl#getDependabilityAnalysisView()
		 * @generated
		 */
		EClass DEPENDABILITY_ANALYSIS_VIEW = eINSTANCE.getDependabilityAnalysisView();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDABILITY_ANALYSIS_VIEW__BASE_PACKAGE = eINSTANCE.getDependabilityAnalysisView_Base_Package();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.SystemViewImpl <em>System View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.SystemViewImpl
		 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.CHESSViewsPackageImpl#getSystemView()
		 * @generated
		 */
		EClass SYSTEM_VIEW = eINSTANCE.getSystemView();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_VIEW__BASE_PACKAGE = eINSTANCE.getSystemView_Base_Package();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.PSMViewImpl <em>PSM View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.PSMViewImpl
		 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.CHESSViewsPackageImpl#getPSMView()
		 * @generated
		 */
		EClass PSM_VIEW = eINSTANCE.getPSMView();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PSM_VIEW__BASE_PACKAGE = eINSTANCE.getPSMView_Base_Package();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.AnalysisViewImpl <em>Analysis View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.AnalysisViewImpl
		 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.CHESSViewsPackageImpl#getAnalysisView()
		 * @generated
		 */
		EClass ANALYSIS_VIEW = eINSTANCE.getAnalysisView();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANALYSIS_VIEW__BASE_PACKAGE = eINSTANCE.getAnalysisView_Base_Package();

		/**
		 * The meta object literal for the '<em><b>Rtanalysisview</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANALYSIS_VIEW__RTANALYSISVIEW = eINSTANCE.getAnalysisView_Rtanalysisview();

		/**
		 * The meta object literal for the '<em><b>Depanalysisview</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANALYSIS_VIEW__DEPANALYSISVIEW = eINSTANCE.getAnalysisView_Depanalysisview();

	}

} //CHESSViewsPackage
