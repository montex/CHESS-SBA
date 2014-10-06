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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage;

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
 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.DeploymentConfAnalysisFactory
 * @model kind="package"
 * @generated
 */
public interface DeploymentConfAnalysisPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "DeploymentConfAnalysis";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://CHESS/Predictability/DeploymentConfiguration/DeploymentConfAnalysis";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "DeploymentConfAnalysis";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DeploymentConfAnalysisPackage eINSTANCE = org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.impl.DeploymentConfAnalysisPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.impl.MappingConfigurationAnalysisImpl <em>Mapping Configuration Analysis</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.impl.MappingConfigurationAnalysisImpl
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.impl.DeploymentConfAnalysisPackageImpl#getMappingConfigurationAnalysis()
	 * @generated
	 */
	int MAPPING_CONFIGURATION_ANALYSIS = 0;

	/**
	 * The feature id for the '<em><b>Base Structured Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CONFIGURATION_ANALYSIS__BASE_STRUCTURED_CLASSIFIER = GQAMPackage.GA_ANALYSIS_CONTEXT__BASE_STRUCTURED_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CONFIGURATION_ANALYSIS__BASE_PACKAGE = GQAMPackage.GA_ANALYSIS_CONTEXT__BASE_PACKAGE;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CONFIGURATION_ANALYSIS__MODE = GQAMPackage.GA_ANALYSIS_CONTEXT__MODE;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CONFIGURATION_ANALYSIS__BASE_NAMED_ELEMENT = GQAMPackage.GA_ANALYSIS_CONTEXT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CONFIGURATION_ANALYSIS__CONTEXT = GQAMPackage.GA_ANALYSIS_CONTEXT__CONTEXT;

	/**
	 * The feature id for the '<em><b>Workload</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CONFIGURATION_ANALYSIS__WORKLOAD = GQAMPackage.GA_ANALYSIS_CONTEXT__WORKLOAD;

	/**
	 * The feature id for the '<em><b>Platform</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CONFIGURATION_ANALYSIS__PLATFORM = GQAMPackage.GA_ANALYSIS_CONTEXT__PLATFORM;

	/**
	 * The feature id for the '<em><b>Prohibited Allocations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CONFIGURATION_ANALYSIS__PROHIBITED_ALLOCATIONS = GQAMPackage.GA_ANALYSIS_CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Fixed Allocations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CONFIGURATION_ANALYSIS__FIXED_ALLOCATIONS = GQAMPackage.GA_ANALYSIS_CONTEXT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Bottom Up Analysis</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CONFIGURATION_ANALYSIS__BOTTOM_UP_ANALYSIS = GQAMPackage.GA_ANALYSIS_CONTEXT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Resulting Mapping</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CONFIGURATION_ANALYSIS__RESULTING_MAPPING = GQAMPackage.GA_ANALYSIS_CONTEXT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Mapping Configuration Analysis</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CONFIGURATION_ANALYSIS_FEATURE_COUNT = GQAMPackage.GA_ANALYSIS_CONTEXT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.impl.SchedulingAnalysisImpl <em>Scheduling Analysis</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.impl.SchedulingAnalysisImpl
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.impl.DeploymentConfAnalysisPackageImpl#getSchedulingAnalysis()
	 * @generated
	 */
	int SCHEDULING_ANALYSIS = 1;

	/**
	 * The feature id for the '<em><b>Base Structured Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_ANALYSIS__BASE_STRUCTURED_CLASSIFIER = GQAMPackage.GA_ANALYSIS_CONTEXT__BASE_STRUCTURED_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_ANALYSIS__BASE_PACKAGE = GQAMPackage.GA_ANALYSIS_CONTEXT__BASE_PACKAGE;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_ANALYSIS__MODE = GQAMPackage.GA_ANALYSIS_CONTEXT__MODE;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_ANALYSIS__BASE_NAMED_ELEMENT = GQAMPackage.GA_ANALYSIS_CONTEXT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_ANALYSIS__CONTEXT = GQAMPackage.GA_ANALYSIS_CONTEXT__CONTEXT;

	/**
	 * The feature id for the '<em><b>Workload</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_ANALYSIS__WORKLOAD = GQAMPackage.GA_ANALYSIS_CONTEXT__WORKLOAD;

	/**
	 * The feature id for the '<em><b>Platform</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_ANALYSIS__PLATFORM = GQAMPackage.GA_ANALYSIS_CONTEXT__PLATFORM;

	/**
	 * The feature id for the '<em><b>Mapping</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_ANALYSIS__MAPPING = GQAMPackage.GA_ANALYSIS_CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Resulting Priorities</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_ANALYSIS__RESULTING_PRIORITIES = GQAMPackage.GA_ANALYSIS_CONTEXT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Scheduling Strategy</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_ANALYSIS__SCHEDULING_STRATEGY = GQAMPackage.GA_ANALYSIS_CONTEXT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Scheduling Analysis</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_ANALYSIS_FEATURE_COUNT = GQAMPackage.GA_ANALYSIS_CONTEXT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.impl.BusConfigurationAnalysisImpl <em>Bus Configuration Analysis</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.impl.BusConfigurationAnalysisImpl
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.impl.DeploymentConfAnalysisPackageImpl#getBusConfigurationAnalysis()
	 * @generated
	 */
	int BUS_CONFIGURATION_ANALYSIS = 2;

	/**
	 * The feature id for the '<em><b>Base Structured Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_CONFIGURATION_ANALYSIS__BASE_STRUCTURED_CLASSIFIER = GQAMPackage.GA_ANALYSIS_CONTEXT__BASE_STRUCTURED_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_CONFIGURATION_ANALYSIS__BASE_PACKAGE = GQAMPackage.GA_ANALYSIS_CONTEXT__BASE_PACKAGE;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_CONFIGURATION_ANALYSIS__MODE = GQAMPackage.GA_ANALYSIS_CONTEXT__MODE;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_CONFIGURATION_ANALYSIS__BASE_NAMED_ELEMENT = GQAMPackage.GA_ANALYSIS_CONTEXT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_CONFIGURATION_ANALYSIS__CONTEXT = GQAMPackage.GA_ANALYSIS_CONTEXT__CONTEXT;

	/**
	 * The feature id for the '<em><b>Workload</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_CONFIGURATION_ANALYSIS__WORKLOAD = GQAMPackage.GA_ANALYSIS_CONTEXT__WORKLOAD;

	/**
	 * The feature id for the '<em><b>Platform</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_CONFIGURATION_ANALYSIS__PLATFORM = GQAMPackage.GA_ANALYSIS_CONTEXT__PLATFORM;

	/**
	 * The feature id for the '<em><b>Resulting Bus Config</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_CONFIGURATION_ANALYSIS__RESULTING_BUS_CONFIG = GQAMPackage.GA_ANALYSIS_CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Resulting Comm Latencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_CONFIGURATION_ANALYSIS__RESULTING_COMM_LATENCIES = GQAMPackage.GA_ANALYSIS_CONTEXT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Input Fibex</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_CONFIGURATION_ANALYSIS__INPUT_FIBEX = GQAMPackage.GA_ANALYSIS_CONTEXT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Hw Bus Platform</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_CONFIGURATION_ANALYSIS__HW_BUS_PLATFORM = GQAMPackage.GA_ANALYSIS_CONTEXT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Bus Configuration Analysis</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_CONFIGURATION_ANALYSIS_FEATURE_COUNT = GQAMPackage.GA_ANALYSIS_CONTEXT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.OptimizationGoal <em>Optimization Goal</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.OptimizationGoal
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.impl.DeploymentConfAnalysisPackageImpl#getOptimizationGoal()
	 * @generated
	 */
	int OPTIMIZATION_GOAL = 3;


	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.MappingConfigurationAnalysis <em>Mapping Configuration Analysis</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Configuration Analysis</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.MappingConfigurationAnalysis
	 * @generated
	 */
	EClass getMappingConfigurationAnalysis();

	/**
	 * Returns the meta object for the reference list '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.MappingConfigurationAnalysis#getProhibitedAllocations <em>Prohibited Allocations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Prohibited Allocations</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.MappingConfigurationAnalysis#getProhibitedAllocations()
	 * @see #getMappingConfigurationAnalysis()
	 * @generated
	 */
	EReference getMappingConfigurationAnalysis_ProhibitedAllocations();

	/**
	 * Returns the meta object for the reference list '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.MappingConfigurationAnalysis#getFixedAllocations <em>Fixed Allocations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Fixed Allocations</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.MappingConfigurationAnalysis#getFixedAllocations()
	 * @see #getMappingConfigurationAnalysis()
	 * @generated
	 */
	EReference getMappingConfigurationAnalysis_FixedAllocations();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.MappingConfigurationAnalysis#isBottomUpAnalysis <em>Bottom Up Analysis</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bottom Up Analysis</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.MappingConfigurationAnalysis#isBottomUpAnalysis()
	 * @see #getMappingConfigurationAnalysis()
	 * @generated
	 */
	EAttribute getMappingConfigurationAnalysis_BottomUpAnalysis();

	/**
	 * Returns the meta object for the reference list '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.MappingConfigurationAnalysis#getResultingMapping <em>Resulting Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Resulting Mapping</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.MappingConfigurationAnalysis#getResultingMapping()
	 * @see #getMappingConfigurationAnalysis()
	 * @generated
	 */
	EReference getMappingConfigurationAnalysis_ResultingMapping();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.SchedulingAnalysis <em>Scheduling Analysis</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scheduling Analysis</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.SchedulingAnalysis
	 * @generated
	 */
	EClass getSchedulingAnalysis();

	/**
	 * Returns the meta object for the reference list '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.SchedulingAnalysis#getMapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Mapping</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.SchedulingAnalysis#getMapping()
	 * @see #getSchedulingAnalysis()
	 * @generated
	 */
	EReference getSchedulingAnalysis_Mapping();

	/**
	 * Returns the meta object for the reference list '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.SchedulingAnalysis#getResultingPriorities <em>Resulting Priorities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Resulting Priorities</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.SchedulingAnalysis#getResultingPriorities()
	 * @see #getSchedulingAnalysis()
	 * @generated
	 */
	EReference getSchedulingAnalysis_ResultingPriorities();

	/**
	 * Returns the meta object for the attribute list '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.SchedulingAnalysis#getSchedulingStrategy <em>Scheduling Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Scheduling Strategy</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.SchedulingAnalysis#getSchedulingStrategy()
	 * @see #getSchedulingAnalysis()
	 * @generated
	 */
	EAttribute getSchedulingAnalysis_SchedulingStrategy();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.BusConfigurationAnalysis <em>Bus Configuration Analysis</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bus Configuration Analysis</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.BusConfigurationAnalysis
	 * @generated
	 */
	EClass getBusConfigurationAnalysis();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.BusConfigurationAnalysis#getResultingBusConfig <em>Resulting Bus Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resulting Bus Config</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.BusConfigurationAnalysis#getResultingBusConfig()
	 * @see #getBusConfigurationAnalysis()
	 * @generated
	 */
	EReference getBusConfigurationAnalysis_ResultingBusConfig();

	/**
	 * Returns the meta object for the reference list '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.BusConfigurationAnalysis#getResultingCommLatencies <em>Resulting Comm Latencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Resulting Comm Latencies</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.BusConfigurationAnalysis#getResultingCommLatencies()
	 * @see #getBusConfigurationAnalysis()
	 * @generated
	 */
	EReference getBusConfigurationAnalysis_ResultingCommLatencies();

	/**
	 * Returns the meta object for the reference list '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.BusConfigurationAnalysis#getInputFibex <em>Input Fibex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Input Fibex</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.BusConfigurationAnalysis#getInputFibex()
	 * @see #getBusConfigurationAnalysis()
	 * @generated
	 */
	EReference getBusConfigurationAnalysis_InputFibex();

	/**
	 * Returns the meta object for the reference list '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.BusConfigurationAnalysis#getHwBusPlatform <em>Hw Bus Platform</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Hw Bus Platform</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.BusConfigurationAnalysis#getHwBusPlatform()
	 * @see #getBusConfigurationAnalysis()
	 * @generated
	 */
	EReference getBusConfigurationAnalysis_HwBusPlatform();

	/**
	 * Returns the meta object for enum '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.OptimizationGoal <em>Optimization Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Optimization Goal</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.OptimizationGoal
	 * @generated
	 */
	EEnum getOptimizationGoal();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DeploymentConfAnalysisFactory getDeploymentConfAnalysisFactory();

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
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.impl.MappingConfigurationAnalysisImpl <em>Mapping Configuration Analysis</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.impl.MappingConfigurationAnalysisImpl
		 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.impl.DeploymentConfAnalysisPackageImpl#getMappingConfigurationAnalysis()
		 * @generated
		 */
		EClass MAPPING_CONFIGURATION_ANALYSIS = eINSTANCE.getMappingConfigurationAnalysis();

		/**
		 * The meta object literal for the '<em><b>Prohibited Allocations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_CONFIGURATION_ANALYSIS__PROHIBITED_ALLOCATIONS = eINSTANCE.getMappingConfigurationAnalysis_ProhibitedAllocations();

		/**
		 * The meta object literal for the '<em><b>Fixed Allocations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_CONFIGURATION_ANALYSIS__FIXED_ALLOCATIONS = eINSTANCE.getMappingConfigurationAnalysis_FixedAllocations();

		/**
		 * The meta object literal for the '<em><b>Bottom Up Analysis</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_CONFIGURATION_ANALYSIS__BOTTOM_UP_ANALYSIS = eINSTANCE.getMappingConfigurationAnalysis_BottomUpAnalysis();

		/**
		 * The meta object literal for the '<em><b>Resulting Mapping</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_CONFIGURATION_ANALYSIS__RESULTING_MAPPING = eINSTANCE.getMappingConfigurationAnalysis_ResultingMapping();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.impl.SchedulingAnalysisImpl <em>Scheduling Analysis</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.impl.SchedulingAnalysisImpl
		 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.impl.DeploymentConfAnalysisPackageImpl#getSchedulingAnalysis()
		 * @generated
		 */
		EClass SCHEDULING_ANALYSIS = eINSTANCE.getSchedulingAnalysis();

		/**
		 * The meta object literal for the '<em><b>Mapping</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULING_ANALYSIS__MAPPING = eINSTANCE.getSchedulingAnalysis_Mapping();

		/**
		 * The meta object literal for the '<em><b>Resulting Priorities</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULING_ANALYSIS__RESULTING_PRIORITIES = eINSTANCE.getSchedulingAnalysis_ResultingPriorities();

		/**
		 * The meta object literal for the '<em><b>Scheduling Strategy</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEDULING_ANALYSIS__SCHEDULING_STRATEGY = eINSTANCE.getSchedulingAnalysis_SchedulingStrategy();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.impl.BusConfigurationAnalysisImpl <em>Bus Configuration Analysis</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.impl.BusConfigurationAnalysisImpl
		 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.impl.DeploymentConfAnalysisPackageImpl#getBusConfigurationAnalysis()
		 * @generated
		 */
		EClass BUS_CONFIGURATION_ANALYSIS = eINSTANCE.getBusConfigurationAnalysis();

		/**
		 * The meta object literal for the '<em><b>Resulting Bus Config</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUS_CONFIGURATION_ANALYSIS__RESULTING_BUS_CONFIG = eINSTANCE.getBusConfigurationAnalysis_ResultingBusConfig();

		/**
		 * The meta object literal for the '<em><b>Resulting Comm Latencies</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUS_CONFIGURATION_ANALYSIS__RESULTING_COMM_LATENCIES = eINSTANCE.getBusConfigurationAnalysis_ResultingCommLatencies();

		/**
		 * The meta object literal for the '<em><b>Input Fibex</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUS_CONFIGURATION_ANALYSIS__INPUT_FIBEX = eINSTANCE.getBusConfigurationAnalysis_InputFibex();

		/**
		 * The meta object literal for the '<em><b>Hw Bus Platform</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUS_CONFIGURATION_ANALYSIS__HW_BUS_PLATFORM = eINSTANCE.getBusConfigurationAnalysis_HwBusPlatform();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.OptimizationGoal <em>Optimization Goal</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.OptimizationGoal
		 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.impl.DeploymentConfAnalysisPackageImpl#getOptimizationGoal()
		 * @generated
		 */
		EEnum OPTIMIZATION_GOAL = eINSTANCE.getOptimizationGoal();

	}

} //DeploymentConfAnalysisPackage
