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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

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
 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingAnalysisFactory
 * @model kind="package"
 * @generated
 */
public interface TimingAnalysisPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "TimingAnalysis";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://CHESS.Predictability/schemas/TimingAnaylsis/_SGMOYMe6Ed-7etIj5eTw0Q/8";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "TimingAnalysis";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TimingAnalysisPackage eINSTANCE = org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.impl.TimingAnalysisPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.impl.SimulationBasedTimingAnalysisImpl <em>Simulation Based Timing Analysis</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.impl.SimulationBasedTimingAnalysisImpl
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.impl.TimingAnalysisPackageImpl#getSimulationBasedTimingAnalysis()
	 * @generated
	 */
	int SIMULATION_BASED_TIMING_ANALYSIS = 0;

	/**
	 * The feature id for the '<em><b>Base Structured Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_BASED_TIMING_ANALYSIS__BASE_STRUCTURED_CLASSIFIER = GQAMPackage.GA_ANALYSIS_CONTEXT__BASE_STRUCTURED_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_BASED_TIMING_ANALYSIS__BASE_PACKAGE = GQAMPackage.GA_ANALYSIS_CONTEXT__BASE_PACKAGE;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_BASED_TIMING_ANALYSIS__MODE = GQAMPackage.GA_ANALYSIS_CONTEXT__MODE;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_BASED_TIMING_ANALYSIS__BASE_NAMED_ELEMENT = GQAMPackage.GA_ANALYSIS_CONTEXT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_BASED_TIMING_ANALYSIS__CONTEXT = GQAMPackage.GA_ANALYSIS_CONTEXT__CONTEXT;

	/**
	 * The feature id for the '<em><b>Workload</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_BASED_TIMING_ANALYSIS__WORKLOAD = GQAMPackage.GA_ANALYSIS_CONTEXT__WORKLOAD;

	/**
	 * The feature id for the '<em><b>Platform</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_BASED_TIMING_ANALYSIS__PLATFORM = GQAMPackage.GA_ANALYSIS_CONTEXT__PLATFORM;

	/**
	 * The number of structural features of the '<em>Simulation Based Timing Analysis</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_BASED_TIMING_ANALYSIS_FEATURE_COUNT = GQAMPackage.GA_ANALYSIS_CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.impl.AgeTimingConstraintImpl <em>Age Timing Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.impl.AgeTimingConstraintImpl
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.impl.TimingAnalysisPackageImpl#getAgeTimingConstraint()
	 * @generated
	 */
	int AGE_TIMING_CONSTRAINT = 1;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGE_TIMING_CONSTRAINT__KIND = GQAMPackage.GA_LATENCY_OBS__KIND;

	/**
	 * The feature id for the '<em><b>Base Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGE_TIMING_CONSTRAINT__BASE_CONSTRAINT = GQAMPackage.GA_LATENCY_OBS__BASE_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGE_TIMING_CONSTRAINT__MODE = GQAMPackage.GA_LATENCY_OBS__MODE;

	/**
	 * The feature id for the '<em><b>Laxity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGE_TIMING_CONSTRAINT__LAXITY = GQAMPackage.GA_LATENCY_OBS__LAXITY;

	/**
	 * The feature id for the '<em><b>Start Obs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGE_TIMING_CONSTRAINT__START_OBS = GQAMPackage.GA_LATENCY_OBS__START_OBS;

	/**
	 * The feature id for the '<em><b>End Obs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGE_TIMING_CONSTRAINT__END_OBS = GQAMPackage.GA_LATENCY_OBS__END_OBS;

	/**
	 * The feature id for the '<em><b>Latency</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGE_TIMING_CONSTRAINT__LATENCY = GQAMPackage.GA_LATENCY_OBS__LATENCY;

	/**
	 * The feature id for the '<em><b>Miss</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGE_TIMING_CONSTRAINT__MISS = GQAMPackage.GA_LATENCY_OBS__MISS;

	/**
	 * The feature id for the '<em><b>Utility</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGE_TIMING_CONSTRAINT__UTILITY = GQAMPackage.GA_LATENCY_OBS__UTILITY;

	/**
	 * The feature id for the '<em><b>Max Jitter</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGE_TIMING_CONSTRAINT__MAX_JITTER = GQAMPackage.GA_LATENCY_OBS__MAX_JITTER;

	/**
	 * The number of structural features of the '<em>Age Timing Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGE_TIMING_CONSTRAINT_FEATURE_COUNT = GQAMPackage.GA_LATENCY_OBS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.impl.ReactionConstraintImpl <em>Reaction Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.impl.ReactionConstraintImpl
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.impl.TimingAnalysisPackageImpl#getReactionConstraint()
	 * @generated
	 */
	int REACTION_CONSTRAINT = 2;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTION_CONSTRAINT__KIND = GQAMPackage.GA_LATENCY_OBS__KIND;

	/**
	 * The feature id for the '<em><b>Base Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTION_CONSTRAINT__BASE_CONSTRAINT = GQAMPackage.GA_LATENCY_OBS__BASE_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTION_CONSTRAINT__MODE = GQAMPackage.GA_LATENCY_OBS__MODE;

	/**
	 * The feature id for the '<em><b>Laxity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTION_CONSTRAINT__LAXITY = GQAMPackage.GA_LATENCY_OBS__LAXITY;

	/**
	 * The feature id for the '<em><b>Start Obs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTION_CONSTRAINT__START_OBS = GQAMPackage.GA_LATENCY_OBS__START_OBS;

	/**
	 * The feature id for the '<em><b>End Obs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTION_CONSTRAINT__END_OBS = GQAMPackage.GA_LATENCY_OBS__END_OBS;

	/**
	 * The feature id for the '<em><b>Latency</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTION_CONSTRAINT__LATENCY = GQAMPackage.GA_LATENCY_OBS__LATENCY;

	/**
	 * The feature id for the '<em><b>Miss</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTION_CONSTRAINT__MISS = GQAMPackage.GA_LATENCY_OBS__MISS;

	/**
	 * The feature id for the '<em><b>Utility</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTION_CONSTRAINT__UTILITY = GQAMPackage.GA_LATENCY_OBS__UTILITY;

	/**
	 * The feature id for the '<em><b>Max Jitter</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTION_CONSTRAINT__MAX_JITTER = GQAMPackage.GA_LATENCY_OBS__MAX_JITTER;

	/**
	 * The number of structural features of the '<em>Reaction Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTION_CONSTRAINT_FEATURE_COUNT = GQAMPackage.GA_LATENCY_OBS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.impl.OutputSynchronizationConstraintImpl <em>Output Synchronization Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.impl.OutputSynchronizationConstraintImpl
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.impl.TimingAnalysisPackageImpl#getOutputSynchronizationConstraint()
	 * @generated
	 */
	int OUTPUT_SYNCHRONIZATION_CONSTRAINT = 3;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_SYNCHRONIZATION_CONSTRAINT__KIND = GQAMPackage.GA_LATENCY_OBS__KIND;

	/**
	 * The feature id for the '<em><b>Base Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_SYNCHRONIZATION_CONSTRAINT__BASE_CONSTRAINT = GQAMPackage.GA_LATENCY_OBS__BASE_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_SYNCHRONIZATION_CONSTRAINT__MODE = GQAMPackage.GA_LATENCY_OBS__MODE;

	/**
	 * The feature id for the '<em><b>Laxity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_SYNCHRONIZATION_CONSTRAINT__LAXITY = GQAMPackage.GA_LATENCY_OBS__LAXITY;

	/**
	 * The feature id for the '<em><b>Start Obs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_SYNCHRONIZATION_CONSTRAINT__START_OBS = GQAMPackage.GA_LATENCY_OBS__START_OBS;

	/**
	 * The feature id for the '<em><b>End Obs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_SYNCHRONIZATION_CONSTRAINT__END_OBS = GQAMPackage.GA_LATENCY_OBS__END_OBS;

	/**
	 * The feature id for the '<em><b>Latency</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_SYNCHRONIZATION_CONSTRAINT__LATENCY = GQAMPackage.GA_LATENCY_OBS__LATENCY;

	/**
	 * The feature id for the '<em><b>Miss</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_SYNCHRONIZATION_CONSTRAINT__MISS = GQAMPackage.GA_LATENCY_OBS__MISS;

	/**
	 * The feature id for the '<em><b>Utility</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_SYNCHRONIZATION_CONSTRAINT__UTILITY = GQAMPackage.GA_LATENCY_OBS__UTILITY;

	/**
	 * The feature id for the '<em><b>Max Jitter</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_SYNCHRONIZATION_CONSTRAINT__MAX_JITTER = GQAMPackage.GA_LATENCY_OBS__MAX_JITTER;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_SYNCHRONIZATION_CONSTRAINT__WIDTH = GQAMPackage.GA_LATENCY_OBS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Output Synchronization Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_SYNCHRONIZATION_CONSTRAINT_FEATURE_COUNT = GQAMPackage.GA_LATENCY_OBS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.impl.InputSynchronizationConstraintImpl <em>Input Synchronization Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.impl.InputSynchronizationConstraintImpl
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.impl.TimingAnalysisPackageImpl#getInputSynchronizationConstraint()
	 * @generated
	 */
	int INPUT_SYNCHRONIZATION_CONSTRAINT = 4;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SYNCHRONIZATION_CONSTRAINT__KIND = GQAMPackage.GA_LATENCY_OBS__KIND;

	/**
	 * The feature id for the '<em><b>Base Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SYNCHRONIZATION_CONSTRAINT__BASE_CONSTRAINT = GQAMPackage.GA_LATENCY_OBS__BASE_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SYNCHRONIZATION_CONSTRAINT__MODE = GQAMPackage.GA_LATENCY_OBS__MODE;

	/**
	 * The feature id for the '<em><b>Laxity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SYNCHRONIZATION_CONSTRAINT__LAXITY = GQAMPackage.GA_LATENCY_OBS__LAXITY;

	/**
	 * The feature id for the '<em><b>Start Obs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SYNCHRONIZATION_CONSTRAINT__START_OBS = GQAMPackage.GA_LATENCY_OBS__START_OBS;

	/**
	 * The feature id for the '<em><b>End Obs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SYNCHRONIZATION_CONSTRAINT__END_OBS = GQAMPackage.GA_LATENCY_OBS__END_OBS;

	/**
	 * The feature id for the '<em><b>Latency</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SYNCHRONIZATION_CONSTRAINT__LATENCY = GQAMPackage.GA_LATENCY_OBS__LATENCY;

	/**
	 * The feature id for the '<em><b>Miss</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SYNCHRONIZATION_CONSTRAINT__MISS = GQAMPackage.GA_LATENCY_OBS__MISS;

	/**
	 * The feature id for the '<em><b>Utility</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SYNCHRONIZATION_CONSTRAINT__UTILITY = GQAMPackage.GA_LATENCY_OBS__UTILITY;

	/**
	 * The feature id for the '<em><b>Max Jitter</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SYNCHRONIZATION_CONSTRAINT__MAX_JITTER = GQAMPackage.GA_LATENCY_OBS__MAX_JITTER;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SYNCHRONIZATION_CONSTRAINT__WIDTH = GQAMPackage.GA_LATENCY_OBS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Input Synchronization Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SYNCHRONIZATION_CONSTRAINT_FEATURE_COUNT = GQAMPackage.GA_LATENCY_OBS_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.SimulationBasedTimingAnalysis <em>Simulation Based Timing Analysis</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simulation Based Timing Analysis</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.SimulationBasedTimingAnalysis
	 * @generated
	 */
	EClass getSimulationBasedTimingAnalysis();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.AgeTimingConstraint <em>Age Timing Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Age Timing Constraint</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.AgeTimingConstraint
	 * @generated
	 */
	EClass getAgeTimingConstraint();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.ReactionConstraint <em>Reaction Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reaction Constraint</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.ReactionConstraint
	 * @generated
	 */
	EClass getReactionConstraint();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.OutputSynchronizationConstraint <em>Output Synchronization Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Synchronization Constraint</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.OutputSynchronizationConstraint
	 * @generated
	 */
	EClass getOutputSynchronizationConstraint();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.OutputSynchronizationConstraint#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.OutputSynchronizationConstraint#getWidth()
	 * @see #getOutputSynchronizationConstraint()
	 * @generated
	 */
	EAttribute getOutputSynchronizationConstraint_Width();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.InputSynchronizationConstraint <em>Input Synchronization Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Synchronization Constraint</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.InputSynchronizationConstraint
	 * @generated
	 */
	EClass getInputSynchronizationConstraint();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.InputSynchronizationConstraint#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.InputSynchronizationConstraint#getWidth()
	 * @see #getInputSynchronizationConstraint()
	 * @generated
	 */
	EAttribute getInputSynchronizationConstraint_Width();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TimingAnalysisFactory getTimingAnalysisFactory();

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
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.impl.SimulationBasedTimingAnalysisImpl <em>Simulation Based Timing Analysis</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.impl.SimulationBasedTimingAnalysisImpl
		 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.impl.TimingAnalysisPackageImpl#getSimulationBasedTimingAnalysis()
		 * @generated
		 */
		EClass SIMULATION_BASED_TIMING_ANALYSIS = eINSTANCE.getSimulationBasedTimingAnalysis();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.impl.AgeTimingConstraintImpl <em>Age Timing Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.impl.AgeTimingConstraintImpl
		 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.impl.TimingAnalysisPackageImpl#getAgeTimingConstraint()
		 * @generated
		 */
		EClass AGE_TIMING_CONSTRAINT = eINSTANCE.getAgeTimingConstraint();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.impl.ReactionConstraintImpl <em>Reaction Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.impl.ReactionConstraintImpl
		 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.impl.TimingAnalysisPackageImpl#getReactionConstraint()
		 * @generated
		 */
		EClass REACTION_CONSTRAINT = eINSTANCE.getReactionConstraint();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.impl.OutputSynchronizationConstraintImpl <em>Output Synchronization Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.impl.OutputSynchronizationConstraintImpl
		 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.impl.TimingAnalysisPackageImpl#getOutputSynchronizationConstraint()
		 * @generated
		 */
		EClass OUTPUT_SYNCHRONIZATION_CONSTRAINT = eINSTANCE.getOutputSynchronizationConstraint();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OUTPUT_SYNCHRONIZATION_CONSTRAINT__WIDTH = eINSTANCE.getOutputSynchronizationConstraint_Width();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.impl.InputSynchronizationConstraintImpl <em>Input Synchronization Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.impl.InputSynchronizationConstraintImpl
		 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.impl.TimingAnalysisPackageImpl#getInputSynchronizationConstraint()
		 * @generated
		 */
		EClass INPUT_SYNCHRONIZATION_CONSTRAINT = eINSTANCE.getInputSynchronizationConstraint();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INPUT_SYNCHRONIZATION_CONSTRAINT__WIDTH = eINSTANCE.getInputSynchronizationConstraint_Width();

	}

} //TimingAnalysisPackage
