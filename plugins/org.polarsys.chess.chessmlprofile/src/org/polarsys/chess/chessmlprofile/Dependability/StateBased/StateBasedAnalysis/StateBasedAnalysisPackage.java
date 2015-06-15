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
package org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.StateBasedAnalysisFactory
 * @model kind="package"
 * @generated
 */
public interface StateBasedAnalysisPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "StateBasedAnalysis";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://CHESS/Dependability/StateBased/StateBasedAnalysis";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "StateBasedAnalysis";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StateBasedAnalysisPackage eINSTANCE = org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.impl.StateBasedAnalysisPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.impl.StateBasedAnalysisImpl <em>State Based Analysis</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.impl.StateBasedAnalysisImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.impl.StateBasedAnalysisPackageImpl#getStateBasedAnalysis()
	 * @generated
	 */
	int STATE_BASED_ANALYSIS = 0;

	/**
	 * The feature id for the '<em><b>Base Structured Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_BASED_ANALYSIS__BASE_STRUCTURED_CLASSIFIER = GQAMPackage.GA_ANALYSIS_CONTEXT__BASE_STRUCTURED_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_BASED_ANALYSIS__BASE_PACKAGE = GQAMPackage.GA_ANALYSIS_CONTEXT__BASE_PACKAGE;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_BASED_ANALYSIS__MODE = GQAMPackage.GA_ANALYSIS_CONTEXT__MODE;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_BASED_ANALYSIS__BASE_NAMED_ELEMENT = GQAMPackage.GA_ANALYSIS_CONTEXT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_BASED_ANALYSIS__CONTEXT = GQAMPackage.GA_ANALYSIS_CONTEXT__CONTEXT;

	/**
	 * The feature id for the '<em><b>Workload</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_BASED_ANALYSIS__WORKLOAD = GQAMPackage.GA_ANALYSIS_CONTEXT__WORKLOAD;

	/**
	 * The feature id for the '<em><b>Platform</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_BASED_ANALYSIS__PLATFORM = GQAMPackage.GA_ANALYSIS_CONTEXT__PLATFORM;

	/**
	 * The feature id for the '<em><b>Measure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_BASED_ANALYSIS__MEASURE = GQAMPackage.GA_ANALYSIS_CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Measure Evaluation Result</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_BASED_ANALYSIS__MEASURE_EVALUATION_RESULT = GQAMPackage.GA_ANALYSIS_CONTEXT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Eval Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_BASED_ANALYSIS__EVAL_METHOD = GQAMPackage.GA_ANALYSIS_CONTEXT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Target Failure Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_BASED_ANALYSIS__TARGET_FAILURE_MODE = GQAMPackage.GA_ANALYSIS_CONTEXT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Target Dep Component</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_BASED_ANALYSIS__TARGET_DEP_COMPONENT = GQAMPackage.GA_ANALYSIS_CONTEXT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>State Based Analysis</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_BASED_ANALYSIS_FEATURE_COUNT = GQAMPackage.GA_ANALYSIS_CONTEXT_FEATURE_COUNT + 5;


	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.StateBasedAnalysis <em>State Based Analysis</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Based Analysis</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.StateBasedAnalysis
	 * @generated
	 */
	EClass getStateBasedAnalysis();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.StateBasedAnalysis#getMeasure <em>Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Measure</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.StateBasedAnalysis#getMeasure()
	 * @see #getStateBasedAnalysis()
	 * @generated
	 */
	EAttribute getStateBasedAnalysis_Measure();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.StateBasedAnalysis#getMeasureEvaluationResult <em>Measure Evaluation Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Measure Evaluation Result</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.StateBasedAnalysis#getMeasureEvaluationResult()
	 * @see #getStateBasedAnalysis()
	 * @generated
	 */
	EAttribute getStateBasedAnalysis_MeasureEvaluationResult();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.StateBasedAnalysis#getEvalMethod <em>Eval Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Eval Method</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.StateBasedAnalysis#getEvalMethod()
	 * @see #getStateBasedAnalysis()
	 * @generated
	 */
	EAttribute getStateBasedAnalysis_EvalMethod();

	/**
	 * Returns the meta object for the reference list '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.StateBasedAnalysis#getTargetFailureMode <em>Target Failure Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Target Failure Mode</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.StateBasedAnalysis#getTargetFailureMode()
	 * @see #getStateBasedAnalysis()
	 * @generated
	 */
	EReference getStateBasedAnalysis_TargetFailureMode();

	/**
	 * Returns the meta object for the reference list '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.StateBasedAnalysis#getTargetDepComponent <em>Target Dep Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Target Dep Component</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.StateBasedAnalysis#getTargetDepComponent()
	 * @see #getStateBasedAnalysis()
	 * @generated
	 */
	EReference getStateBasedAnalysis_TargetDepComponent();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	StateBasedAnalysisFactory getStateBasedAnalysisFactory();

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
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.impl.StateBasedAnalysisImpl <em>State Based Analysis</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.impl.StateBasedAnalysisImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.impl.StateBasedAnalysisPackageImpl#getStateBasedAnalysis()
		 * @generated
		 */
		EClass STATE_BASED_ANALYSIS = eINSTANCE.getStateBasedAnalysis();

		/**
		 * The meta object literal for the '<em><b>Measure</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE_BASED_ANALYSIS__MEASURE = eINSTANCE.getStateBasedAnalysis_Measure();

		/**
		 * The meta object literal for the '<em><b>Measure Evaluation Result</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE_BASED_ANALYSIS__MEASURE_EVALUATION_RESULT = eINSTANCE.getStateBasedAnalysis_MeasureEvaluationResult();

		/**
		 * The meta object literal for the '<em><b>Eval Method</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE_BASED_ANALYSIS__EVAL_METHOD = eINSTANCE.getStateBasedAnalysis_EvalMethod();

		/**
		 * The meta object literal for the '<em><b>Target Failure Mode</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_BASED_ANALYSIS__TARGET_FAILURE_MODE = eINSTANCE.getStateBasedAnalysis_TargetFailureMode();

		/**
		 * The meta object literal for the '<em><b>Target Dep Component</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_BASED_ANALYSIS__TARGET_DEP_COMPONENT = eINSTANCE.getStateBasedAnalysis_TargetDepComponent();

	}

} //StateBasedAnalysisPackage