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
package org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.NFPsPackage;

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
 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.TimingConstraintsFactory
 * @model kind="package"
 * @generated
 */
public interface TimingConstraintsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "TimingConstraints";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://CHESS.Predictability.TimingAnaylsis/schemas/TimingConstraints/_ShUEIMe6Ed-7etIj5eTw0Q/8";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "TimingConstraints";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TimingConstraintsPackage eINSTANCE = org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.impl.TimingConstraintsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.impl.ArbitraryEventConstraintImpl <em>Arbitrary Event Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.impl.ArbitraryEventConstraintImpl
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.impl.TimingConstraintsPackageImpl#getArbitraryEventConstraint()
	 * @generated
	 */
	int ARBITRARY_EVENT_CONSTRAINT = 0;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARBITRARY_EVENT_CONSTRAINT__KIND = NFPsPackage.NFP_CONSTRAINT__KIND;

	/**
	 * The feature id for the '<em><b>Base Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARBITRARY_EVENT_CONSTRAINT__BASE_CONSTRAINT = NFPsPackage.NFP_CONSTRAINT__BASE_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARBITRARY_EVENT_CONSTRAINT__MODE = NFPsPackage.NFP_CONSTRAINT__MODE;

	/**
	 * The feature id for the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARBITRARY_EVENT_CONSTRAINT__OFFSET = NFPsPackage.NFP_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Maximum Interarrival Time</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARBITRARY_EVENT_CONSTRAINT__MAXIMUM_INTERARRIVAL_TIME = NFPsPackage.NFP_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Minimum Interarrival Time</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARBITRARY_EVENT_CONSTRAINT__MINIMUM_INTERARRIVAL_TIME = NFPsPackage.NFP_CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Arbitrary Event Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARBITRARY_EVENT_CONSTRAINT_FEATURE_COUNT = NFPsPackage.NFP_CONSTRAINT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.impl.PatternEventConstraintImpl <em>Pattern Event Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.impl.PatternEventConstraintImpl
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.impl.TimingConstraintsPackageImpl#getPatternEventConstraint()
	 * @generated
	 */
	int PATTERN_EVENT_CONSTRAINT = 1;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EVENT_CONSTRAINT__KIND = NFPsPackage.NFP_CONSTRAINT__KIND;

	/**
	 * The feature id for the '<em><b>Base Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EVENT_CONSTRAINT__BASE_CONSTRAINT = NFPsPackage.NFP_CONSTRAINT__BASE_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EVENT_CONSTRAINT__MODE = NFPsPackage.NFP_CONSTRAINT__MODE;

	/**
	 * The feature id for the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EVENT_CONSTRAINT__OFFSET = NFPsPackage.NFP_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Jitter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EVENT_CONSTRAINT__JITTER = NFPsPackage.NFP_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Minimum Interarrival Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EVENT_CONSTRAINT__MINIMUM_INTERARRIVAL_TIME = NFPsPackage.NFP_CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Occurrence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EVENT_CONSTRAINT__OCCURRENCE = NFPsPackage.NFP_CONSTRAINT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EVENT_CONSTRAINT__PERIOD = NFPsPackage.NFP_CONSTRAINT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Pattern Event Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EVENT_CONSTRAINT_FEATURE_COUNT = NFPsPackage.NFP_CONSTRAINT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.impl.PeriodicEventConstraintImpl <em>Periodic Event Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.impl.PeriodicEventConstraintImpl
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.impl.TimingConstraintsPackageImpl#getPeriodicEventConstraint()
	 * @generated
	 */
	int PERIODIC_EVENT_CONSTRAINT = 2;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIODIC_EVENT_CONSTRAINT__KIND = NFPsPackage.NFP_CONSTRAINT__KIND;

	/**
	 * The feature id for the '<em><b>Base Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIODIC_EVENT_CONSTRAINT__BASE_CONSTRAINT = NFPsPackage.NFP_CONSTRAINT__BASE_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIODIC_EVENT_CONSTRAINT__MODE = NFPsPackage.NFP_CONSTRAINT__MODE;

	/**
	 * The feature id for the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIODIC_EVENT_CONSTRAINT__OFFSET = NFPsPackage.NFP_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Jitter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIODIC_EVENT_CONSTRAINT__JITTER = NFPsPackage.NFP_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Minimum Interarrival Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIODIC_EVENT_CONSTRAINT__MINIMUM_INTERARRIVAL_TIME = NFPsPackage.NFP_CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIODIC_EVENT_CONSTRAINT__PERIOD = NFPsPackage.NFP_CONSTRAINT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Periodic Event Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIODIC_EVENT_CONSTRAINT_FEATURE_COUNT = NFPsPackage.NFP_CONSTRAINT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.impl.SporadicEventConstraintImpl <em>Sporadic Event Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.impl.SporadicEventConstraintImpl
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.impl.TimingConstraintsPackageImpl#getSporadicEventConstraint()
	 * @generated
	 */
	int SPORADIC_EVENT_CONSTRAINT = 3;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPORADIC_EVENT_CONSTRAINT__KIND = NFPsPackage.NFP_CONSTRAINT__KIND;

	/**
	 * The feature id for the '<em><b>Base Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPORADIC_EVENT_CONSTRAINT__BASE_CONSTRAINT = NFPsPackage.NFP_CONSTRAINT__BASE_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPORADIC_EVENT_CONSTRAINT__MODE = NFPsPackage.NFP_CONSTRAINT__MODE;

	/**
	 * The feature id for the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPORADIC_EVENT_CONSTRAINT__OFFSET = NFPsPackage.NFP_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Jitter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPORADIC_EVENT_CONSTRAINT__JITTER = NFPsPackage.NFP_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Maximum Interarrival Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPORADIC_EVENT_CONSTRAINT__MAXIMUM_INTERARRIVAL_TIME = NFPsPackage.NFP_CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Minimum Interarrival Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPORADIC_EVENT_CONSTRAINT__MINIMUM_INTERARRIVAL_TIME = NFPsPackage.NFP_CONSTRAINT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPORADIC_EVENT_CONSTRAINT__PERIOD = NFPsPackage.NFP_CONSTRAINT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Sporadic Event Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPORADIC_EVENT_CONSTRAINT_FEATURE_COUNT = NFPsPackage.NFP_CONSTRAINT_FEATURE_COUNT + 5;


	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.ArbitraryEventConstraint <em>Arbitrary Event Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Arbitrary Event Constraint</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.ArbitraryEventConstraint
	 * @generated
	 */
	EClass getArbitraryEventConstraint();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.ArbitraryEventConstraint#getOffset <em>Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Offset</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.ArbitraryEventConstraint#getOffset()
	 * @see #getArbitraryEventConstraint()
	 * @generated
	 */
	EAttribute getArbitraryEventConstraint_Offset();

	/**
	 * Returns the meta object for the attribute list '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.ArbitraryEventConstraint#getMaximumInterarrivalTime <em>Maximum Interarrival Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Maximum Interarrival Time</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.ArbitraryEventConstraint#getMaximumInterarrivalTime()
	 * @see #getArbitraryEventConstraint()
	 * @generated
	 */
	EAttribute getArbitraryEventConstraint_MaximumInterarrivalTime();

	/**
	 * Returns the meta object for the attribute list '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.ArbitraryEventConstraint#getMinimumInterarrivalTime <em>Minimum Interarrival Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Minimum Interarrival Time</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.ArbitraryEventConstraint#getMinimumInterarrivalTime()
	 * @see #getArbitraryEventConstraint()
	 * @generated
	 */
	EAttribute getArbitraryEventConstraint_MinimumInterarrivalTime();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.PatternEventConstraint <em>Pattern Event Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern Event Constraint</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.PatternEventConstraint
	 * @generated
	 */
	EClass getPatternEventConstraint();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.PatternEventConstraint#getOffset <em>Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Offset</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.PatternEventConstraint#getOffset()
	 * @see #getPatternEventConstraint()
	 * @generated
	 */
	EAttribute getPatternEventConstraint_Offset();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.PatternEventConstraint#getJitter <em>Jitter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Jitter</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.PatternEventConstraint#getJitter()
	 * @see #getPatternEventConstraint()
	 * @generated
	 */
	EAttribute getPatternEventConstraint_Jitter();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.PatternEventConstraint#getMinimumInterarrivalTime <em>Minimum Interarrival Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minimum Interarrival Time</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.PatternEventConstraint#getMinimumInterarrivalTime()
	 * @see #getPatternEventConstraint()
	 * @generated
	 */
	EAttribute getPatternEventConstraint_MinimumInterarrivalTime();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.PatternEventConstraint#getOccurrence <em>Occurrence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Occurrence</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.PatternEventConstraint#getOccurrence()
	 * @see #getPatternEventConstraint()
	 * @generated
	 */
	EAttribute getPatternEventConstraint_Occurrence();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.PatternEventConstraint#getPeriod <em>Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Period</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.PatternEventConstraint#getPeriod()
	 * @see #getPatternEventConstraint()
	 * @generated
	 */
	EAttribute getPatternEventConstraint_Period();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.PeriodicEventConstraint <em>Periodic Event Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Periodic Event Constraint</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.PeriodicEventConstraint
	 * @generated
	 */
	EClass getPeriodicEventConstraint();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.PeriodicEventConstraint#getOffset <em>Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Offset</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.PeriodicEventConstraint#getOffset()
	 * @see #getPeriodicEventConstraint()
	 * @generated
	 */
	EAttribute getPeriodicEventConstraint_Offset();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.PeriodicEventConstraint#getJitter <em>Jitter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Jitter</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.PeriodicEventConstraint#getJitter()
	 * @see #getPeriodicEventConstraint()
	 * @generated
	 */
	EAttribute getPeriodicEventConstraint_Jitter();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.PeriodicEventConstraint#getMinimumInterarrivalTime <em>Minimum Interarrival Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minimum Interarrival Time</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.PeriodicEventConstraint#getMinimumInterarrivalTime()
	 * @see #getPeriodicEventConstraint()
	 * @generated
	 */
	EAttribute getPeriodicEventConstraint_MinimumInterarrivalTime();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.PeriodicEventConstraint#getPeriod <em>Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Period</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.PeriodicEventConstraint#getPeriod()
	 * @see #getPeriodicEventConstraint()
	 * @generated
	 */
	EAttribute getPeriodicEventConstraint_Period();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.SporadicEventConstraint <em>Sporadic Event Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sporadic Event Constraint</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.SporadicEventConstraint
	 * @generated
	 */
	EClass getSporadicEventConstraint();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.SporadicEventConstraint#getOffset <em>Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Offset</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.SporadicEventConstraint#getOffset()
	 * @see #getSporadicEventConstraint()
	 * @generated
	 */
	EAttribute getSporadicEventConstraint_Offset();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.SporadicEventConstraint#getJitter <em>Jitter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Jitter</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.SporadicEventConstraint#getJitter()
	 * @see #getSporadicEventConstraint()
	 * @generated
	 */
	EAttribute getSporadicEventConstraint_Jitter();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.SporadicEventConstraint#getMaximumInterarrivalTime <em>Maximum Interarrival Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum Interarrival Time</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.SporadicEventConstraint#getMaximumInterarrivalTime()
	 * @see #getSporadicEventConstraint()
	 * @generated
	 */
	EAttribute getSporadicEventConstraint_MaximumInterarrivalTime();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.SporadicEventConstraint#getMinimumInterarrivalTime <em>Minimum Interarrival Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minimum Interarrival Time</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.SporadicEventConstraint#getMinimumInterarrivalTime()
	 * @see #getSporadicEventConstraint()
	 * @generated
	 */
	EAttribute getSporadicEventConstraint_MinimumInterarrivalTime();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.SporadicEventConstraint#getPeriod <em>Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Period</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.SporadicEventConstraint#getPeriod()
	 * @see #getSporadicEventConstraint()
	 * @generated
	 */
	EAttribute getSporadicEventConstraint_Period();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TimingConstraintsFactory getTimingConstraintsFactory();

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
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.impl.ArbitraryEventConstraintImpl <em>Arbitrary Event Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.impl.ArbitraryEventConstraintImpl
		 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.impl.TimingConstraintsPackageImpl#getArbitraryEventConstraint()
		 * @generated
		 */
		EClass ARBITRARY_EVENT_CONSTRAINT = eINSTANCE.getArbitraryEventConstraint();

		/**
		 * The meta object literal for the '<em><b>Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARBITRARY_EVENT_CONSTRAINT__OFFSET = eINSTANCE.getArbitraryEventConstraint_Offset();

		/**
		 * The meta object literal for the '<em><b>Maximum Interarrival Time</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARBITRARY_EVENT_CONSTRAINT__MAXIMUM_INTERARRIVAL_TIME = eINSTANCE.getArbitraryEventConstraint_MaximumInterarrivalTime();

		/**
		 * The meta object literal for the '<em><b>Minimum Interarrival Time</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARBITRARY_EVENT_CONSTRAINT__MINIMUM_INTERARRIVAL_TIME = eINSTANCE.getArbitraryEventConstraint_MinimumInterarrivalTime();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.impl.PatternEventConstraintImpl <em>Pattern Event Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.impl.PatternEventConstraintImpl
		 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.impl.TimingConstraintsPackageImpl#getPatternEventConstraint()
		 * @generated
		 */
		EClass PATTERN_EVENT_CONSTRAINT = eINSTANCE.getPatternEventConstraint();

		/**
		 * The meta object literal for the '<em><b>Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATTERN_EVENT_CONSTRAINT__OFFSET = eINSTANCE.getPatternEventConstraint_Offset();

		/**
		 * The meta object literal for the '<em><b>Jitter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATTERN_EVENT_CONSTRAINT__JITTER = eINSTANCE.getPatternEventConstraint_Jitter();

		/**
		 * The meta object literal for the '<em><b>Minimum Interarrival Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATTERN_EVENT_CONSTRAINT__MINIMUM_INTERARRIVAL_TIME = eINSTANCE.getPatternEventConstraint_MinimumInterarrivalTime();

		/**
		 * The meta object literal for the '<em><b>Occurrence</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATTERN_EVENT_CONSTRAINT__OCCURRENCE = eINSTANCE.getPatternEventConstraint_Occurrence();

		/**
		 * The meta object literal for the '<em><b>Period</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATTERN_EVENT_CONSTRAINT__PERIOD = eINSTANCE.getPatternEventConstraint_Period();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.impl.PeriodicEventConstraintImpl <em>Periodic Event Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.impl.PeriodicEventConstraintImpl
		 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.impl.TimingConstraintsPackageImpl#getPeriodicEventConstraint()
		 * @generated
		 */
		EClass PERIODIC_EVENT_CONSTRAINT = eINSTANCE.getPeriodicEventConstraint();

		/**
		 * The meta object literal for the '<em><b>Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERIODIC_EVENT_CONSTRAINT__OFFSET = eINSTANCE.getPeriodicEventConstraint_Offset();

		/**
		 * The meta object literal for the '<em><b>Jitter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERIODIC_EVENT_CONSTRAINT__JITTER = eINSTANCE.getPeriodicEventConstraint_Jitter();

		/**
		 * The meta object literal for the '<em><b>Minimum Interarrival Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERIODIC_EVENT_CONSTRAINT__MINIMUM_INTERARRIVAL_TIME = eINSTANCE.getPeriodicEventConstraint_MinimumInterarrivalTime();

		/**
		 * The meta object literal for the '<em><b>Period</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERIODIC_EVENT_CONSTRAINT__PERIOD = eINSTANCE.getPeriodicEventConstraint_Period();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.impl.SporadicEventConstraintImpl <em>Sporadic Event Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.impl.SporadicEventConstraintImpl
		 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.impl.TimingConstraintsPackageImpl#getSporadicEventConstraint()
		 * @generated
		 */
		EClass SPORADIC_EVENT_CONSTRAINT = eINSTANCE.getSporadicEventConstraint();

		/**
		 * The meta object literal for the '<em><b>Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPORADIC_EVENT_CONSTRAINT__OFFSET = eINSTANCE.getSporadicEventConstraint_Offset();

		/**
		 * The meta object literal for the '<em><b>Jitter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPORADIC_EVENT_CONSTRAINT__JITTER = eINSTANCE.getSporadicEventConstraint_Jitter();

		/**
		 * The meta object literal for the '<em><b>Maximum Interarrival Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPORADIC_EVENT_CONSTRAINT__MAXIMUM_INTERARRIVAL_TIME = eINSTANCE.getSporadicEventConstraint_MaximumInterarrivalTime();

		/**
		 * The meta object literal for the '<em><b>Minimum Interarrival Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPORADIC_EVENT_CONSTRAINT__MINIMUM_INTERARRIVAL_TIME = eINSTANCE.getSporadicEventConstraint_MinimumInterarrivalTime();

		/**
		 * The meta object literal for the '<em><b>Period</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPORADIC_EVENT_CONSTRAINT__PERIOD = eINSTANCE.getSporadicEventConstraint_Period();

	}

} //TimingConstraintsPackage
