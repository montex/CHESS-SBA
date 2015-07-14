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
package org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring;

import org.eclipse.emf.ecore.EAttribute;
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
 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MaintenanceMonitoringFactory
 * @model kind="package"
 * @generated
 */
public interface MaintenanceMonitoringPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "MaintenanceMonitoring";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://CHESS/Dependability/StateBased/MaintenanceMonitoring";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "MaintenanceMonitoring";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MaintenanceMonitoringPackage eINSTANCE = org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.impl.MaintenanceMonitoringPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.impl.MMActivitiesImpl <em>MM Activities</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.impl.MMActivitiesImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.impl.MaintenanceMonitoringPackageImpl#getMMActivities()
	 * @generated
	 */
	int MM_ACTIVITIES = 0;

	/**
	 * The feature id for the '<em><b>Base Activity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MM_ACTIVITIES__BASE_ACTIVITY = 0;

	/**
	 * The feature id for the '<em><b>When</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MM_ACTIVITIES__WHEN = 1;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MM_ACTIVITIES__DURATION = 2;

	/**
	 * The feature id for the '<em><b>Prob Success</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MM_ACTIVITIES__PROB_SUCCESS = 3;

	/**
	 * The feature id for the '<em><b>On Completion</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MM_ACTIVITIES__ON_COMPLETION = 4;

	/**
	 * The feature id for the '<em><b>On Successful Completion</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MM_ACTIVITIES__ON_SUCCESSFUL_COMPLETION = 5;

	/**
	 * The feature id for the '<em><b>On Failed Completion</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MM_ACTIVITIES__ON_FAILED_COMPLETION = 6;

	/**
	 * The feature id for the '<em><b>Base Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MM_ACTIVITIES__BASE_ACTION = 7;

	/**
	 * The number of structural features of the '<em>MM Activities</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MM_ACTIVITIES_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.impl.RepairImpl <em>Repair</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.impl.RepairImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.impl.MaintenanceMonitoringPackageImpl#getRepair()
	 * @generated
	 */
	int REPAIR = 1;

	/**
	 * The feature id for the '<em><b>Base Activity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPAIR__BASE_ACTIVITY = MM_ACTIVITIES__BASE_ACTIVITY;

	/**
	 * The feature id for the '<em><b>When</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPAIR__WHEN = MM_ACTIVITIES__WHEN;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPAIR__DURATION = MM_ACTIVITIES__DURATION;

	/**
	 * The feature id for the '<em><b>Prob Success</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPAIR__PROB_SUCCESS = MM_ACTIVITIES__PROB_SUCCESS;

	/**
	 * The feature id for the '<em><b>On Completion</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPAIR__ON_COMPLETION = MM_ACTIVITIES__ON_COMPLETION;

	/**
	 * The feature id for the '<em><b>On Successful Completion</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPAIR__ON_SUCCESSFUL_COMPLETION = MM_ACTIVITIES__ON_SUCCESSFUL_COMPLETION;

	/**
	 * The feature id for the '<em><b>On Failed Completion</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPAIR__ON_FAILED_COMPLETION = MM_ACTIVITIES__ON_FAILED_COMPLETION;

	/**
	 * The feature id for the '<em><b>Base Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPAIR__BASE_ACTION = MM_ACTIVITIES__BASE_ACTION;

	/**
	 * The feature id for the '<em><b>Targets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPAIR__TARGETS = MM_ACTIVITIES_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Repair</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPAIR_FEATURE_COUNT = MM_ACTIVITIES_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.impl.ReplaceImpl <em>Replace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.impl.ReplaceImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.impl.MaintenanceMonitoringPackageImpl#getReplace()
	 * @generated
	 */
	int REPLACE = 2;

	/**
	 * The feature id for the '<em><b>Base Activity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE__BASE_ACTIVITY = MM_ACTIVITIES__BASE_ACTIVITY;

	/**
	 * The feature id for the '<em><b>When</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE__WHEN = MM_ACTIVITIES__WHEN;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE__DURATION = MM_ACTIVITIES__DURATION;

	/**
	 * The feature id for the '<em><b>Prob Success</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE__PROB_SUCCESS = MM_ACTIVITIES__PROB_SUCCESS;

	/**
	 * The feature id for the '<em><b>On Completion</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE__ON_COMPLETION = MM_ACTIVITIES__ON_COMPLETION;

	/**
	 * The feature id for the '<em><b>On Successful Completion</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE__ON_SUCCESSFUL_COMPLETION = MM_ACTIVITIES__ON_SUCCESSFUL_COMPLETION;

	/**
	 * The feature id for the '<em><b>On Failed Completion</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE__ON_FAILED_COMPLETION = MM_ACTIVITIES__ON_FAILED_COMPLETION;

	/**
	 * The feature id for the '<em><b>Base Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE__BASE_ACTION = MM_ACTIVITIES__BASE_ACTION;

	/**
	 * The feature id for the '<em><b>Targets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE__TARGETS = MM_ACTIVITIES_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Replacement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE__REPLACEMENT = MM_ACTIVITIES_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Replace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE_FEATURE_COUNT = MM_ACTIVITIES_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.impl.ErrorDetectionImpl <em>Error Detection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.impl.ErrorDetectionImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.impl.MaintenanceMonitoringPackageImpl#getErrorDetection()
	 * @generated
	 */
	int ERROR_DETECTION = 3;

	/**
	 * The feature id for the '<em><b>Base Activity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_DETECTION__BASE_ACTIVITY = MM_ACTIVITIES__BASE_ACTIVITY;

	/**
	 * The feature id for the '<em><b>When</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_DETECTION__WHEN = MM_ACTIVITIES__WHEN;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_DETECTION__DURATION = MM_ACTIVITIES__DURATION;

	/**
	 * The feature id for the '<em><b>Prob Success</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_DETECTION__PROB_SUCCESS = MM_ACTIVITIES__PROB_SUCCESS;

	/**
	 * The feature id for the '<em><b>On Completion</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_DETECTION__ON_COMPLETION = MM_ACTIVITIES__ON_COMPLETION;

	/**
	 * The feature id for the '<em><b>On Successful Completion</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_DETECTION__ON_SUCCESSFUL_COMPLETION = MM_ACTIVITIES__ON_SUCCESSFUL_COMPLETION;

	/**
	 * The feature id for the '<em><b>On Failed Completion</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_DETECTION__ON_FAILED_COMPLETION = MM_ACTIVITIES__ON_FAILED_COMPLETION;

	/**
	 * The feature id for the '<em><b>Base Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_DETECTION__BASE_ACTION = MM_ACTIVITIES__BASE_ACTION;

	/**
	 * The feature id for the '<em><b>Targets</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_DETECTION__TARGETS = MM_ACTIVITIES_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Correction Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_DETECTION__CORRECTION_PROBABILITY = MM_ACTIVITIES_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Controlled Failure</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_DETECTION__CONTROLLED_FAILURE = MM_ACTIVITIES_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Error Detection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_DETECTION_FEATURE_COUNT = MM_ACTIVITIES_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.impl.FailureDetectionImpl <em>Failure Detection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.impl.FailureDetectionImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.impl.MaintenanceMonitoringPackageImpl#getFailureDetection()
	 * @generated
	 */
	int FAILURE_DETECTION = 4;

	/**
	 * The feature id for the '<em><b>Base Activity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_DETECTION__BASE_ACTIVITY = MM_ACTIVITIES__BASE_ACTIVITY;

	/**
	 * The feature id for the '<em><b>When</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_DETECTION__WHEN = MM_ACTIVITIES__WHEN;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_DETECTION__DURATION = MM_ACTIVITIES__DURATION;

	/**
	 * The feature id for the '<em><b>Prob Success</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_DETECTION__PROB_SUCCESS = MM_ACTIVITIES__PROB_SUCCESS;

	/**
	 * The feature id for the '<em><b>On Completion</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_DETECTION__ON_COMPLETION = MM_ACTIVITIES__ON_COMPLETION;

	/**
	 * The feature id for the '<em><b>On Successful Completion</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_DETECTION__ON_SUCCESSFUL_COMPLETION = MM_ACTIVITIES__ON_SUCCESSFUL_COMPLETION;

	/**
	 * The feature id for the '<em><b>On Failed Completion</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_DETECTION__ON_FAILED_COMPLETION = MM_ACTIVITIES__ON_FAILED_COMPLETION;

	/**
	 * The feature id for the '<em><b>Base Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_DETECTION__BASE_ACTION = MM_ACTIVITIES__BASE_ACTION;

	/**
	 * The feature id for the '<em><b>On Detection</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_DETECTION__ON_DETECTION = MM_ACTIVITIES_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Failure Detection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_DETECTION_FEATURE_COUNT = MM_ACTIVITIES_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MMActivities <em>MM Activities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MM Activities</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MMActivities
	 * @generated
	 */
	EClass getMMActivities();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MMActivities#getBase_Activity <em>Base Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Activity</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MMActivities#getBase_Activity()
	 * @see #getMMActivities()
	 * @generated
	 */
	EReference getMMActivities_Base_Activity();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MMActivities#getWhen <em>When</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>When</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MMActivities#getWhen()
	 * @see #getMMActivities()
	 * @generated
	 */
	EAttribute getMMActivities_When();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MMActivities#getDuration <em>Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Duration</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MMActivities#getDuration()
	 * @see #getMMActivities()
	 * @generated
	 */
	EAttribute getMMActivities_Duration();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MMActivities#getProbSuccess <em>Prob Success</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prob Success</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MMActivities#getProbSuccess()
	 * @see #getMMActivities()
	 * @generated
	 */
	EAttribute getMMActivities_ProbSuccess();

	/**
	 * Returns the meta object for the reference list '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MMActivities#getOnCompletion <em>On Completion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>On Completion</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MMActivities#getOnCompletion()
	 * @see #getMMActivities()
	 * @generated
	 */
	EReference getMMActivities_OnCompletion();

	/**
	 * Returns the meta object for the reference list '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MMActivities#getOnSuccessfulCompletion <em>On Successful Completion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>On Successful Completion</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MMActivities#getOnSuccessfulCompletion()
	 * @see #getMMActivities()
	 * @generated
	 */
	EReference getMMActivities_OnSuccessfulCompletion();

	/**
	 * Returns the meta object for the reference list '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MMActivities#getOnFailedCompletion <em>On Failed Completion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>On Failed Completion</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MMActivities#getOnFailedCompletion()
	 * @see #getMMActivities()
	 * @generated
	 */
	EReference getMMActivities_OnFailedCompletion();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MMActivities#getBase_Action <em>Base Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Action</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MMActivities#getBase_Action()
	 * @see #getMMActivities()
	 * @generated
	 */
	EReference getMMActivities_Base_Action();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.Repair <em>Repair</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Repair</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.Repair
	 * @generated
	 */
	EClass getRepair();

	/**
	 * Returns the meta object for the reference list '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.Repair#getTargets <em>Targets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Targets</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.Repair#getTargets()
	 * @see #getRepair()
	 * @generated
	 */
	EReference getRepair_Targets();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.Replace <em>Replace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Replace</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.Replace
	 * @generated
	 */
	EClass getReplace();

	/**
	 * Returns the meta object for the reference list '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.Replace#getTargets <em>Targets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Targets</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.Replace#getTargets()
	 * @see #getReplace()
	 * @generated
	 */
	EReference getReplace_Targets();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.Replace#getReplacement <em>Replacement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Replacement</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.Replace#getReplacement()
	 * @see #getReplace()
	 * @generated
	 */
	EReference getReplace_Replacement();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.ErrorDetection <em>Error Detection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Error Detection</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.ErrorDetection
	 * @generated
	 */
	EClass getErrorDetection();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.ErrorDetection#getTargets <em>Targets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Targets</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.ErrorDetection#getTargets()
	 * @see #getErrorDetection()
	 * @generated
	 */
	EReference getErrorDetection_Targets();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.ErrorDetection#getCorrectionProbability <em>Correction Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Correction Probability</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.ErrorDetection#getCorrectionProbability()
	 * @see #getErrorDetection()
	 * @generated
	 */
	EAttribute getErrorDetection_CorrectionProbability();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.ErrorDetection#getControlledFailure <em>Controlled Failure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Controlled Failure</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.ErrorDetection#getControlledFailure()
	 * @see #getErrorDetection()
	 * @generated
	 */
	EReference getErrorDetection_ControlledFailure();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.FailureDetection <em>Failure Detection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Failure Detection</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.FailureDetection
	 * @generated
	 */
	EClass getFailureDetection();

	/**
	 * Returns the meta object for the reference list '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.FailureDetection#getOnDetection <em>On Detection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>On Detection</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.FailureDetection#getOnDetection()
	 * @see #getFailureDetection()
	 * @generated
	 */
	EReference getFailureDetection_OnDetection();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MaintenanceMonitoringFactory getMaintenanceMonitoringFactory();

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
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.impl.MMActivitiesImpl <em>MM Activities</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.impl.MMActivitiesImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.impl.MaintenanceMonitoringPackageImpl#getMMActivities()
		 * @generated
		 */
		EClass MM_ACTIVITIES = eINSTANCE.getMMActivities();

		/**
		 * The meta object literal for the '<em><b>Base Activity</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MM_ACTIVITIES__BASE_ACTIVITY = eINSTANCE.getMMActivities_Base_Activity();

		/**
		 * The meta object literal for the '<em><b>When</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MM_ACTIVITIES__WHEN = eINSTANCE.getMMActivities_When();

		/**
		 * The meta object literal for the '<em><b>Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MM_ACTIVITIES__DURATION = eINSTANCE.getMMActivities_Duration();

		/**
		 * The meta object literal for the '<em><b>Prob Success</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MM_ACTIVITIES__PROB_SUCCESS = eINSTANCE.getMMActivities_ProbSuccess();

		/**
		 * The meta object literal for the '<em><b>On Completion</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MM_ACTIVITIES__ON_COMPLETION = eINSTANCE.getMMActivities_OnCompletion();

		/**
		 * The meta object literal for the '<em><b>On Successful Completion</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MM_ACTIVITIES__ON_SUCCESSFUL_COMPLETION = eINSTANCE.getMMActivities_OnSuccessfulCompletion();

		/**
		 * The meta object literal for the '<em><b>On Failed Completion</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MM_ACTIVITIES__ON_FAILED_COMPLETION = eINSTANCE.getMMActivities_OnFailedCompletion();

		/**
		 * The meta object literal for the '<em><b>Base Action</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MM_ACTIVITIES__BASE_ACTION = eINSTANCE.getMMActivities_Base_Action();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.impl.RepairImpl <em>Repair</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.impl.RepairImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.impl.MaintenanceMonitoringPackageImpl#getRepair()
		 * @generated
		 */
		EClass REPAIR = eINSTANCE.getRepair();

		/**
		 * The meta object literal for the '<em><b>Targets</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPAIR__TARGETS = eINSTANCE.getRepair_Targets();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.impl.ReplaceImpl <em>Replace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.impl.ReplaceImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.impl.MaintenanceMonitoringPackageImpl#getReplace()
		 * @generated
		 */
		EClass REPLACE = eINSTANCE.getReplace();

		/**
		 * The meta object literal for the '<em><b>Targets</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPLACE__TARGETS = eINSTANCE.getReplace_Targets();

		/**
		 * The meta object literal for the '<em><b>Replacement</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPLACE__REPLACEMENT = eINSTANCE.getReplace_Replacement();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.impl.ErrorDetectionImpl <em>Error Detection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.impl.ErrorDetectionImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.impl.MaintenanceMonitoringPackageImpl#getErrorDetection()
		 * @generated
		 */
		EClass ERROR_DETECTION = eINSTANCE.getErrorDetection();

		/**
		 * The meta object literal for the '<em><b>Targets</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR_DETECTION__TARGETS = eINSTANCE.getErrorDetection_Targets();

		/**
		 * The meta object literal for the '<em><b>Correction Probability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ERROR_DETECTION__CORRECTION_PROBABILITY = eINSTANCE.getErrorDetection_CorrectionProbability();

		/**
		 * The meta object literal for the '<em><b>Controlled Failure</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR_DETECTION__CONTROLLED_FAILURE = eINSTANCE.getErrorDetection_ControlledFailure();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.impl.FailureDetectionImpl <em>Failure Detection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.impl.FailureDetectionImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.impl.MaintenanceMonitoringPackageImpl#getFailureDetection()
		 * @generated
		 */
		EClass FAILURE_DETECTION = eINSTANCE.getFailureDetection();

		/**
		 * The meta object literal for the '<em><b>On Detection</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAILURE_DETECTION__ON_DETECTION = eINSTANCE.getFailureDetection_OnDetection();

	}

} //MaintenanceMonitoringPackage
