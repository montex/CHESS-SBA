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
package org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.StateBasedDataTypesFactory
 * @model kind="package"
 * @generated
 */
public interface StateBasedDataTypesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "StateBasedDataTypes";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///CHESS/Dependability/StateBased/StateBasedDataTypes.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "CHESS.Dependability.StateBased.StateBasedDataTypes";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StateBasedDataTypesPackage eINSTANCE = org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.StateBasedDataTypesPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.DependabilityMeasureImpl <em>Dependability Measure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.DependabilityMeasureImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.StateBasedDataTypesPackageImpl#getDependabilityMeasure()
	 * @generated
	 */
	int DEPENDABILITY_MEASURE = 0;

	/**
	 * The number of structural features of the '<em>Dependability Measure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDABILITY_MEASURE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.EvaluationMethodImpl <em>Evaluation Method</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.EvaluationMethodImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.StateBasedDataTypesPackageImpl#getEvaluationMethod()
	 * @generated
	 */
	int EVALUATION_METHOD = 1;

	/**
	 * The number of structural features of the '<em>Evaluation Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_METHOD_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.EvaluationBySimulationImpl <em>Evaluation By Simulation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.EvaluationBySimulationImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.StateBasedDataTypesPackageImpl#getEvaluationBySimulation()
	 * @generated
	 */
	int EVALUATION_BY_SIMULATION = 2;

	/**
	 * The number of structural features of the '<em>Evaluation By Simulation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_BY_SIMULATION_FEATURE_COUNT = EVALUATION_METHOD_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.EvaluationAnalyticalImpl <em>Evaluation Analytical</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.EvaluationAnalyticalImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.StateBasedDataTypesPackageImpl#getEvaluationAnalytical()
	 * @generated
	 */
	int EVALUATION_ANALYTICAL = 3;

	/**
	 * The number of structural features of the '<em>Evaluation Analytical</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_ANALYTICAL_FEATURE_COUNT = EVALUATION_METHOD_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.ReliabilityImpl <em>Reliability</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.ReliabilityImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.StateBasedDataTypesPackageImpl#getReliability()
	 * @generated
	 */
	int RELIABILITY = 4;

	/**
	 * The number of structural features of the '<em>Reliability</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELIABILITY_FEATURE_COUNT = DEPENDABILITY_MEASURE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.EvaluationTypeImpl <em>Evaluation Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.EvaluationTypeImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.StateBasedDataTypesPackageImpl#getEvaluationType()
	 * @generated
	 */
	int EVALUATION_TYPE = 5;

	/**
	 * The number of structural features of the '<em>Evaluation Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_TYPE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.SteadyStateImpl <em>Steady State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.SteadyStateImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.StateBasedDataTypesPackageImpl#getSteadyState()
	 * @generated
	 */
	int STEADY_STATE = 6;

	/**
	 * The number of structural features of the '<em>Steady State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEADY_STATE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.AvailabilityImpl <em>Availability</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.AvailabilityImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.StateBasedDataTypesPackageImpl#getAvailability()
	 * @generated
	 */
	int AVAILABILITY = 7;

	/**
	 * The number of structural features of the '<em>Availability</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVAILABILITY_FEATURE_COUNT = DEPENDABILITY_MEASURE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.MTTFImpl <em>MTTF</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.MTTFImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.StateBasedDataTypesPackageImpl#getMTTF()
	 * @generated
	 */
	int MTTF = 8;

	/**
	 * The number of structural features of the '<em>MTTF</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MTTF_FEATURE_COUNT = DEPENDABILITY_MEASURE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.RedundancyKind <em>Redundancy Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.RedundancyKind
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.StateBasedDataTypesPackageImpl#getRedundancyKind()
	 * @generated
	 */
	int REDUNDANCY_KIND = 9;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.ConfidenceKind <em>Confidence Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.ConfidenceKind
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.StateBasedDataTypesPackageImpl#getConfidenceKind()
	 * @generated
	 */
	int CONFIDENCE_KIND = 10;


	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.DependabilityMeasure <em>Dependability Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dependability Measure</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.DependabilityMeasure
	 * @generated
	 */
	EClass getDependabilityMeasure();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.EvaluationMethod <em>Evaluation Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Evaluation Method</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.EvaluationMethod
	 * @generated
	 */
	EClass getEvaluationMethod();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.EvaluationBySimulation <em>Evaluation By Simulation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Evaluation By Simulation</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.EvaluationBySimulation
	 * @generated
	 */
	EClass getEvaluationBySimulation();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.EvaluationAnalytical <em>Evaluation Analytical</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Evaluation Analytical</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.EvaluationAnalytical
	 * @generated
	 */
	EClass getEvaluationAnalytical();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.Reliability <em>Reliability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reliability</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.Reliability
	 * @generated
	 */
	EClass getReliability();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.EvaluationType <em>Evaluation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Evaluation Type</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.EvaluationType
	 * @generated
	 */
	EClass getEvaluationType();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.SteadyState <em>Steady State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Steady State</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.SteadyState
	 * @generated
	 */
	EClass getSteadyState();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.Availability <em>Availability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Availability</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.Availability
	 * @generated
	 */
	EClass getAvailability();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.MTTF <em>MTTF</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MTTF</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.MTTF
	 * @generated
	 */
	EClass getMTTF();

	/**
	 * Returns the meta object for enum '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.RedundancyKind <em>Redundancy Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Redundancy Kind</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.RedundancyKind
	 * @generated
	 */
	EEnum getRedundancyKind();

	/**
	 * Returns the meta object for enum '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.ConfidenceKind <em>Confidence Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Confidence Kind</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.ConfidenceKind
	 * @generated
	 */
	EEnum getConfidenceKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	StateBasedDataTypesFactory getStateBasedDataTypesFactory();

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
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.DependabilityMeasureImpl <em>Dependability Measure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.DependabilityMeasureImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.StateBasedDataTypesPackageImpl#getDependabilityMeasure()
		 * @generated
		 */
		EClass DEPENDABILITY_MEASURE = eINSTANCE.getDependabilityMeasure();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.EvaluationMethodImpl <em>Evaluation Method</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.EvaluationMethodImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.StateBasedDataTypesPackageImpl#getEvaluationMethod()
		 * @generated
		 */
		EClass EVALUATION_METHOD = eINSTANCE.getEvaluationMethod();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.EvaluationBySimulationImpl <em>Evaluation By Simulation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.EvaluationBySimulationImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.StateBasedDataTypesPackageImpl#getEvaluationBySimulation()
		 * @generated
		 */
		EClass EVALUATION_BY_SIMULATION = eINSTANCE.getEvaluationBySimulation();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.EvaluationAnalyticalImpl <em>Evaluation Analytical</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.EvaluationAnalyticalImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.StateBasedDataTypesPackageImpl#getEvaluationAnalytical()
		 * @generated
		 */
		EClass EVALUATION_ANALYTICAL = eINSTANCE.getEvaluationAnalytical();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.ReliabilityImpl <em>Reliability</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.ReliabilityImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.StateBasedDataTypesPackageImpl#getReliability()
		 * @generated
		 */
		EClass RELIABILITY = eINSTANCE.getReliability();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.EvaluationTypeImpl <em>Evaluation Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.EvaluationTypeImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.StateBasedDataTypesPackageImpl#getEvaluationType()
		 * @generated
		 */
		EClass EVALUATION_TYPE = eINSTANCE.getEvaluationType();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.SteadyStateImpl <em>Steady State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.SteadyStateImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.StateBasedDataTypesPackageImpl#getSteadyState()
		 * @generated
		 */
		EClass STEADY_STATE = eINSTANCE.getSteadyState();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.AvailabilityImpl <em>Availability</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.AvailabilityImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.StateBasedDataTypesPackageImpl#getAvailability()
		 * @generated
		 */
		EClass AVAILABILITY = eINSTANCE.getAvailability();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.MTTFImpl <em>MTTF</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.MTTFImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.StateBasedDataTypesPackageImpl#getMTTF()
		 * @generated
		 */
		EClass MTTF = eINSTANCE.getMTTF();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.RedundancyKind <em>Redundancy Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.RedundancyKind
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.StateBasedDataTypesPackageImpl#getRedundancyKind()
		 * @generated
		 */
		EEnum REDUNDANCY_KIND = eINSTANCE.getRedundancyKind();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.ConfidenceKind <em>Confidence Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.ConfidenceKind
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.StateBasedDataTypesPackageImpl#getConfidenceKind()
		 * @generated
		 */
		EEnum CONFIDENCE_KIND = eINSTANCE.getConfidenceKind();

	}

} //StateBasedDataTypesPackage
