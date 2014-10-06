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
package org.polarsys.chess.chessmlprofile.Dependability.FMEA;

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
 * @see org.polarsys.chess.chessmlprofile.Dependability.FMEA.FMEAFactory
 * @model kind="package"
 * @generated
 */
public interface FMEAPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "FMEA";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://CHESS.Dependability/schemas/FMEA/_wfALMFrLEeCvGuvlF-wh1g/9";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "FMEA";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FMEAPackage eINSTANCE = org.polarsys.chess.chessmlprofile.Dependability.FMEA.impl.FMEAPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.FMEA.impl.FIBEXImpl <em>FIBEX</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FMEA.impl.FIBEXImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FMEA.impl.FMEAPackageImpl#getFIBEX()
	 * @generated
	 */
	int FIBEX = 0;

	/**
	 * The feature id for the '<em><b>Base Comment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIBEX__BASE_COMMENT = 0;

	/**
	 * The feature id for the '<em><b>Config</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIBEX__CONFIG = 1;

	/**
	 * The number of structural features of the '<em>FIBEX</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIBEX_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.FMEA.impl.FMEAAnalysisImpl <em>Analysis</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FMEA.impl.FMEAAnalysisImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FMEA.impl.FMEAPackageImpl#getFMEAAnalysis()
	 * @generated
	 */
	int FMEA_ANALYSIS = 1;

	/**
	 * The feature id for the '<em><b>Base Structured Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMEA_ANALYSIS__BASE_STRUCTURED_CLASSIFIER = GQAMPackage.GA_ANALYSIS_CONTEXT__BASE_STRUCTURED_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMEA_ANALYSIS__BASE_PACKAGE = GQAMPackage.GA_ANALYSIS_CONTEXT__BASE_PACKAGE;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMEA_ANALYSIS__MODE = GQAMPackage.GA_ANALYSIS_CONTEXT__MODE;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMEA_ANALYSIS__BASE_NAMED_ELEMENT = GQAMPackage.GA_ANALYSIS_CONTEXT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMEA_ANALYSIS__CONTEXT = GQAMPackage.GA_ANALYSIS_CONTEXT__CONTEXT;

	/**
	 * The feature id for the '<em><b>Workload</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMEA_ANALYSIS__WORKLOAD = GQAMPackage.GA_ANALYSIS_CONTEXT__WORKLOAD;

	/**
	 * The feature id for the '<em><b>Platform</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMEA_ANALYSIS__PLATFORM = GQAMPackage.GA_ANALYSIS_CONTEXT__PLATFORM;

	/**
	 * The feature id for the '<em><b>Error Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMEA_ANALYSIS__ERROR_TYPE = GQAMPackage.GA_ANALYSIS_CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Simulation Runs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMEA_ANALYSIS__SIMULATION_RUNS = GQAMPackage.GA_ANALYSIS_CONTEXT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Analysis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMEA_ANALYSIS__ANALYSIS_TYPE = GQAMPackage.GA_ANALYSIS_CONTEXT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Analysis</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMEA_ANALYSIS_FEATURE_COUNT = GQAMPackage.GA_ANALYSIS_CONTEXT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.FMEA.impl.ErrorModelAssignImpl <em>Error Model Assign</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FMEA.impl.ErrorModelAssignImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FMEA.impl.FMEAPackageImpl#getErrorModelAssign()
	 * @generated
	 */
	int ERROR_MODEL_ASSIGN = 2;

	/**
	 * The feature id for the '<em><b>Base Comment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_MODEL_ASSIGN__BASE_COMMENT = 0;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_MODEL_ASSIGN__FROM = 1;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_MODEL_ASSIGN__TO = 2;

	/**
	 * The number of structural features of the '<em>Error Model Assign</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_MODEL_ASSIGN_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.FMEA.FMEAAnalysisType <em>Analysis Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FMEA.FMEAAnalysisType
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FMEA.impl.FMEAPackageImpl#getFMEAAnalysisType()
	 * @generated
	 */
	int FMEA_ANALYSIS_TYPE = 3;


	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.FMEA.FIBEX <em>FIBEX</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FIBEX</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FMEA.FIBEX
	 * @generated
	 */
	EClass getFIBEX();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.FMEA.FIBEX#getBase_Comment <em>Base Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Comment</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FMEA.FIBEX#getBase_Comment()
	 * @see #getFIBEX()
	 * @generated
	 */
	EReference getFIBEX_Base_Comment();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.FMEA.FIBEX#getConfig <em>Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Config</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FMEA.FIBEX#getConfig()
	 * @see #getFIBEX()
	 * @generated
	 */
	EAttribute getFIBEX_Config();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.FMEA.FMEAAnalysis <em>Analysis</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Analysis</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FMEA.FMEAAnalysis
	 * @generated
	 */
	EClass getFMEAAnalysis();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.FMEA.FMEAAnalysis#getErrorType <em>Error Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Error Type</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FMEA.FMEAAnalysis#getErrorType()
	 * @see #getFMEAAnalysis()
	 * @generated
	 */
	EReference getFMEAAnalysis_ErrorType();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.FMEA.FMEAAnalysis#getSimulationRuns <em>Simulation Runs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Simulation Runs</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FMEA.FMEAAnalysis#getSimulationRuns()
	 * @see #getFMEAAnalysis()
	 * @generated
	 */
	EAttribute getFMEAAnalysis_SimulationRuns();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.FMEA.FMEAAnalysis#getAnalysisType <em>Analysis Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Analysis Type</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FMEA.FMEAAnalysis#getAnalysisType()
	 * @see #getFMEAAnalysis()
	 * @generated
	 */
	EAttribute getFMEAAnalysis_AnalysisType();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.FMEA.ErrorModelAssign <em>Error Model Assign</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Error Model Assign</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FMEA.ErrorModelAssign
	 * @generated
	 */
	EClass getErrorModelAssign();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.FMEA.ErrorModelAssign#getBase_Comment <em>Base Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Comment</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FMEA.ErrorModelAssign#getBase_Comment()
	 * @see #getErrorModelAssign()
	 * @generated
	 */
	EReference getErrorModelAssign_Base_Comment();

	/**
	 * Returns the meta object for the reference list '{@link org.polarsys.chess.chessmlprofile.Dependability.FMEA.ErrorModelAssign#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>From</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FMEA.ErrorModelAssign#getFrom()
	 * @see #getErrorModelAssign()
	 * @generated
	 */
	EReference getErrorModelAssign_From();

	/**
	 * Returns the meta object for the reference list '{@link org.polarsys.chess.chessmlprofile.Dependability.FMEA.ErrorModelAssign#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>To</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FMEA.ErrorModelAssign#getTo()
	 * @see #getErrorModelAssign()
	 * @generated
	 */
	EReference getErrorModelAssign_To();

	/**
	 * Returns the meta object for enum '{@link org.polarsys.chess.chessmlprofile.Dependability.FMEA.FMEAAnalysisType <em>Analysis Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Analysis Type</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FMEA.FMEAAnalysisType
	 * @generated
	 */
	EEnum getFMEAAnalysisType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FMEAFactory getFMEAFactory();

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
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.FMEA.impl.FIBEXImpl <em>FIBEX</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.FMEA.impl.FIBEXImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.FMEA.impl.FMEAPackageImpl#getFIBEX()
		 * @generated
		 */
		EClass FIBEX = eINSTANCE.getFIBEX();

		/**
		 * The meta object literal for the '<em><b>Base Comment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FIBEX__BASE_COMMENT = eINSTANCE.getFIBEX_Base_Comment();

		/**
		 * The meta object literal for the '<em><b>Config</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIBEX__CONFIG = eINSTANCE.getFIBEX_Config();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.FMEA.impl.FMEAAnalysisImpl <em>Analysis</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.FMEA.impl.FMEAAnalysisImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.FMEA.impl.FMEAPackageImpl#getFMEAAnalysis()
		 * @generated
		 */
		EClass FMEA_ANALYSIS = eINSTANCE.getFMEAAnalysis();

		/**
		 * The meta object literal for the '<em><b>Error Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FMEA_ANALYSIS__ERROR_TYPE = eINSTANCE.getFMEAAnalysis_ErrorType();

		/**
		 * The meta object literal for the '<em><b>Simulation Runs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMEA_ANALYSIS__SIMULATION_RUNS = eINSTANCE.getFMEAAnalysis_SimulationRuns();

		/**
		 * The meta object literal for the '<em><b>Analysis Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMEA_ANALYSIS__ANALYSIS_TYPE = eINSTANCE.getFMEAAnalysis_AnalysisType();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.FMEA.impl.ErrorModelAssignImpl <em>Error Model Assign</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.FMEA.impl.ErrorModelAssignImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.FMEA.impl.FMEAPackageImpl#getErrorModelAssign()
		 * @generated
		 */
		EClass ERROR_MODEL_ASSIGN = eINSTANCE.getErrorModelAssign();

		/**
		 * The meta object literal for the '<em><b>Base Comment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR_MODEL_ASSIGN__BASE_COMMENT = eINSTANCE.getErrorModelAssign_Base_Comment();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR_MODEL_ASSIGN__FROM = eINSTANCE.getErrorModelAssign_From();

		/**
		 * The meta object literal for the '<em><b>To</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR_MODEL_ASSIGN__TO = eINSTANCE.getErrorModelAssign_To();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.FMEA.FMEAAnalysisType <em>Analysis Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.FMEA.FMEAAnalysisType
		 * @see org.polarsys.chess.chessmlprofile.Dependability.FMEA.impl.FMEAPackageImpl#getFMEAAnalysisType()
		 * @generated
		 */
		EEnum FMEA_ANALYSIS_TYPE = eINSTANCE.getFMEAAnalysisType();

	}

} //FMEAPackage
