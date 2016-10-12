/*****************************************************************************
 * Copyright (c) 2011, 2015 University of Padova, Intecs
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *
 *****************************************************************************/
package org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
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
 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatsPropagationFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='ThreatsPopagation'"
 * @generated
 */
public interface ThreatsPropagationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ThreatsPropagation";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://CHESS/Dependability/ThreatsPropagation";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ThreatsPropagation";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ThreatsPropagationPackage eINSTANCE = org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.InternalFaultImpl <em>Internal Fault</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.InternalFaultImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getInternalFault()
	 * @generated
	 */
	int INTERNAL_FAULT = 12;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.InternalPropagationImpl <em>Internal Propagation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.InternalPropagationImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getInternalPropagation()
	 * @generated
	 */
	int INTERNAL_PROPAGATION = 13;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.NormalInputImpl <em>Normal Input</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.NormalInputImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getNormalInput()
	 * @generated
	 */
	int NORMAL_INPUT = 8;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.NormalOutputImpl <em>Normal Output</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.NormalOutputImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getNormalOutput()
	 * @generated
	 */
	int NORMAL_OUTPUT = 10;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.FailureImpl <em>Failure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.FailureImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getFailure()
	 * @generated
	 */
	int FAILURE = 11;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatStateImpl <em>Threat State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatStateImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getThreatState()
	 * @generated
	 */
	int THREAT_STATE = 1;

	/**
	 * The feature id for the '<em><b>Base State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_STATE__BASE_STATE = 0;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_STATE__PROBABILITY = 1;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_STATE__UNIT = 2;

	/**
	 * The number of structural features of the '<em>Threat State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_STATE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.DegradedStateImpl <em>Degraded State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.DegradedStateImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getDegradedState()
	 * @generated
	 */
	int DEGRADED_STATE = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.NormalStateImpl <em>Normal State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.NormalStateImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getNormalState()
	 * @generated
	 */
	int NORMAL_STATE = 2;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ErrorStateImpl <em>Error State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ErrorStateImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getErrorState()
	 * @generated
	 */
	int ERROR_STATE = 3;

	/**
	 * The feature id for the '<em><b>Base State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEGRADED_STATE__BASE_STATE = THREAT_STATE__BASE_STATE;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEGRADED_STATE__PROBABILITY = THREAT_STATE__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEGRADED_STATE__UNIT = THREAT_STATE__UNIT;

	/**
	 * The number of structural features of the '<em>Degraded State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEGRADED_STATE_FEATURE_COUNT = THREAT_STATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_STATE__BASE_STATE = 0;

	/**
	 * The number of structural features of the '<em>Normal State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_STATE_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Base State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_STATE__BASE_STATE = THREAT_STATE__BASE_STATE;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_STATE__PROBABILITY = THREAT_STATE__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_STATE__UNIT = THREAT_STATE__UNIT;

	/**
	 * The number of structural features of the '<em>Error State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_STATE_FEATURE_COUNT = THREAT_STATE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.StuckAtImpl <em>Stuck At</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.StuckAtImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getStuckAt()
	 * @generated
	 */
	int STUCK_AT = 4;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.StuckAtFixedImpl <em>Stuck At Fixed</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.StuckAtFixedImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getStuckAtFixed()
	 * @generated
	 */
	int STUCK_AT_FIXED = 5;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.InvertedImpl <em>Inverted</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.InvertedImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getInverted()
	 * @generated
	 */
	int INVERTED = 6;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.RampDownImpl <em>Ramp Down</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.RampDownImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getRampDown()
	 * @generated
	 */
	int RAMP_DOWN = 7;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.DepEventImpl <em>Dep Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.DepEventImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getDepEvent()
	 * @generated
	 */
	int DEP_EVENT = 9;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STUCK_AT__PROPERTY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STUCK_AT__VALUE = 1;

	/**
	 * The feature id for the '<em><b>Base State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STUCK_AT__BASE_STATE = 2;

	/**
	 * The number of structural features of the '<em>Stuck At</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STUCK_AT_FEATURE_COUNT = 3;

	/**
	 * The feature id for the '<em><b>Base State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STUCK_AT_FIXED__BASE_STATE = 0;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STUCK_AT_FIXED__PROPERTY = 1;

	/**
	 * The number of structural features of the '<em>Stuck At Fixed</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STUCK_AT_FIXED_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Base State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVERTED__BASE_STATE = 0;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVERTED__PROPERTY = 1;

	/**
	 * The number of structural features of the '<em>Inverted</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVERTED_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Base State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAMP_DOWN__BASE_STATE = 0;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAMP_DOWN__PROPERTY = 1;

	/**
	 * The feature id for the '<em><b>Decr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAMP_DOWN__DECR = 2;

	/**
	 * The feature id for the '<em><b>End Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAMP_DOWN__END_VALUE = 3;

	/**
	 * The number of structural features of the '<em>Ramp Down</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAMP_DOWN_FEATURE_COUNT = 4;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEP_EVENT__PORT = 0;

	/**
	 * The feature id for the '<em><b>Base Transition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEP_EVENT__BASE_TRANSITION = 1;

	/**
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEP_EVENT__WEIGHT = 2;

	/**
	 * The number of structural features of the '<em>Dep Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEP_EVENT_FEATURE_COUNT = 3;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_INPUT__PORT = DEP_EVENT__PORT;

	/**
	 * The feature id for the '<em><b>Base Transition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_INPUT__BASE_TRANSITION = DEP_EVENT__BASE_TRANSITION;

	/**
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_INPUT__WEIGHT = DEP_EVENT__WEIGHT;

	/**
	 * The number of structural features of the '<em>Normal Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_INPUT_FEATURE_COUNT = DEP_EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_OUTPUT__PORT = DEP_EVENT__PORT;

	/**
	 * The feature id for the '<em><b>Base Transition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_OUTPUT__BASE_TRANSITION = DEP_EVENT__BASE_TRANSITION;

	/**
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_OUTPUT__WEIGHT = DEP_EVENT__WEIGHT;

	/**
	 * The number of structural features of the '<em>Normal Output</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_OUTPUT_FEATURE_COUNT = DEP_EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Transition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE__BASE_TRANSITION = 0;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE__MODE = 1;

	/**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE__DELAY = 2;

	/**
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE__WEIGHT = 3;

	/**
	 * The number of structural features of the '<em>Failure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_FEATURE_COUNT = 4;

	/**
	 * The feature id for the '<em><b>Occurrence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_FAULT__OCCURRENCE = 0;

	/**
	 * The feature id for the '<em><b>Base Transition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_FAULT__BASE_TRANSITION = 1;

	/**
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_FAULT__WEIGHT = 2;

	/**
	 * The number of structural features of the '<em>Internal Fault</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_FAULT_FEATURE_COUNT = 3;

	/**
	 * The feature id for the '<em><b>Base Transition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_PROPAGATION__BASE_TRANSITION = 0;

	/**
	 * The feature id for the '<em><b>External Faults</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_PROPAGATION__EXTERNAL_FAULTS = 1;

	/**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_PROPAGATION__DELAY = 2;

	/**
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_PROPAGATION__WEIGHT = 3;

	/**
	 * The number of structural features of the '<em>Internal Propagation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_PROPAGATION_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ErrorDetectionImpl <em>Error Detection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ErrorDetectionImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getErrorDetection()
	 * @generated
	 */
	int ERROR_DETECTION = 14;

	/**
	 * The feature id for the '<em><b>Base Transition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_DETECTION__BASE_TRANSITION = 0;

	/**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_DETECTION__DELAY = 1;

	/**
	 * The feature id for the '<em><b>Success Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_DETECTION__SUCCESS_PROBABILITY = 2;

	/**
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_DETECTION__WEIGHT = 3;

	/**
	 * The number of structural features of the '<em>Error Detection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_DETECTION_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ErrorHandlingImpl <em>Error Handling</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ErrorHandlingImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getErrorHandling()
	 * @generated
	 */
	int ERROR_HANDLING = 15;

	/**
	 * The feature id for the '<em><b>Base Transition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_HANDLING__BASE_TRANSITION = 0;

	/**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_HANDLING__DELAY = 1;

	/**
	 * The feature id for the '<em><b>Success Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_HANDLING__SUCCESS_PROBABILITY = 2;

	/**
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_HANDLING__WEIGHT = 3;

	/**
	 * The number of structural features of the '<em>Error Handling</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_HANDLING_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.FaultHandlingImpl <em>Fault Handling</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.FaultHandlingImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getFaultHandling()
	 * @generated
	 */
	int FAULT_HANDLING = 16;

	/**
	 * The feature id for the '<em><b>Base Transition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULT_HANDLING__BASE_TRANSITION = 0;

	/**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULT_HANDLING__DELAY = 1;

	/**
	 * The feature id for the '<em><b>Success Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULT_HANDLING__SUCCESS_PROBABILITY = 2;

	/**
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULT_HANDLING__WEIGHT = 3;

	/**
	 * The number of structural features of the '<em>Fault Handling</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULT_HANDLING_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ErrorModelImpl <em>Error Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ErrorModelImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getErrorModel()
	 * @generated
	 */
	int ERROR_MODEL = 17;

	/**
	 * The feature id for the '<em><b>Base State Machine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_MODEL__BASE_STATE_MACHINE = 0;

	/**
	 * The number of structural features of the '<em>Error Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_MODEL_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.RecoveryKind <em>Recovery Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.RecoveryKind
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getRecoveryKind()
	 * @generated
	 */
	int RECOVERY_KIND = 18;


	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalFault <em>Internal Fault</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Internal Fault</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalFault
	 * @generated
	 */
	EClass getInternalFault();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalFault#getOccurrence <em>Occurrence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Occurrence</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalFault#getOccurrence()
	 * @see #getInternalFault()
	 * @generated
	 */
	EAttribute getInternalFault_Occurrence();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalFault#getBase_Transition <em>Base Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Transition</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalFault#getBase_Transition()
	 * @see #getInternalFault()
	 * @generated
	 */
	EReference getInternalFault_Base_Transition();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalFault#getWeight <em>Weight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Weight</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalFault#getWeight()
	 * @see #getInternalFault()
	 * @generated
	 */
	EAttribute getInternalFault_Weight();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalPropagation <em>Internal Propagation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Internal Propagation</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalPropagation
	 * @generated
	 */
	EClass getInternalPropagation();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalPropagation#getBase_Transition <em>Base Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Transition</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalPropagation#getBase_Transition()
	 * @see #getInternalPropagation()
	 * @generated
	 */
	EReference getInternalPropagation_Base_Transition();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalPropagation#getExternalFaults <em>External Faults</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>External Faults</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalPropagation#getExternalFaults()
	 * @see #getInternalPropagation()
	 * @generated
	 */
	EAttribute getInternalPropagation_ExternalFaults();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalPropagation#getDelay <em>Delay</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Delay</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalPropagation#getDelay()
	 * @see #getInternalPropagation()
	 * @generated
	 */
	EAttribute getInternalPropagation_Delay();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalPropagation#getWeight <em>Weight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Weight</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalPropagation#getWeight()
	 * @see #getInternalPropagation()
	 * @generated
	 */
	EAttribute getInternalPropagation_Weight();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ErrorDetection <em>Error Detection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Error Detection</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ErrorDetection
	 * @generated
	 */
	EClass getErrorDetection();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ErrorDetection#getBase_Transition <em>Base Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Transition</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ErrorDetection#getBase_Transition()
	 * @see #getErrorDetection()
	 * @generated
	 */
	EReference getErrorDetection_Base_Transition();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ErrorDetection#getDelay <em>Delay</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Delay</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ErrorDetection#getDelay()
	 * @see #getErrorDetection()
	 * @generated
	 */
	EAttribute getErrorDetection_Delay();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ErrorDetection#getSuccessProbability <em>Success Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Success Probability</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ErrorDetection#getSuccessProbability()
	 * @see #getErrorDetection()
	 * @generated
	 */
	EAttribute getErrorDetection_SuccessProbability();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ErrorDetection#getWeight <em>Weight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Weight</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ErrorDetection#getWeight()
	 * @see #getErrorDetection()
	 * @generated
	 */
	EAttribute getErrorDetection_Weight();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ErrorHandling <em>Error Handling</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Error Handling</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ErrorHandling
	 * @generated
	 */
	EClass getErrorHandling();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ErrorHandling#getBase_Transition <em>Base Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Transition</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ErrorHandling#getBase_Transition()
	 * @see #getErrorHandling()
	 * @generated
	 */
	EReference getErrorHandling_Base_Transition();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ErrorHandling#getDelay <em>Delay</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Delay</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ErrorHandling#getDelay()
	 * @see #getErrorHandling()
	 * @generated
	 */
	EAttribute getErrorHandling_Delay();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ErrorHandling#getSuccessProbability <em>Success Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Success Probability</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ErrorHandling#getSuccessProbability()
	 * @see #getErrorHandling()
	 * @generated
	 */
	EAttribute getErrorHandling_SuccessProbability();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ErrorHandling#getWeight <em>Weight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Weight</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ErrorHandling#getWeight()
	 * @see #getErrorHandling()
	 * @generated
	 */
	EAttribute getErrorHandling_Weight();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.FaultHandling <em>Fault Handling</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fault Handling</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.FaultHandling
	 * @generated
	 */
	EClass getFaultHandling();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.FaultHandling#getBase_Transition <em>Base Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Transition</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.FaultHandling#getBase_Transition()
	 * @see #getFaultHandling()
	 * @generated
	 */
	EReference getFaultHandling_Base_Transition();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.FaultHandling#getDelay <em>Delay</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Delay</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.FaultHandling#getDelay()
	 * @see #getFaultHandling()
	 * @generated
	 */
	EAttribute getFaultHandling_Delay();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.FaultHandling#getSuccessProbability <em>Success Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Success Probability</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.FaultHandling#getSuccessProbability()
	 * @see #getFaultHandling()
	 * @generated
	 */
	EAttribute getFaultHandling_SuccessProbability();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.FaultHandling#getWeight <em>Weight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Weight</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.FaultHandling#getWeight()
	 * @see #getFaultHandling()
	 * @generated
	 */
	EAttribute getFaultHandling_Weight();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ErrorModel <em>Error Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Error Model</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ErrorModel
	 * @generated
	 */
	EClass getErrorModel();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ErrorModel#getBase_StateMachine <em>Base State Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base State Machine</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ErrorModel#getBase_StateMachine()
	 * @see #getErrorModel()
	 * @generated
	 */
	EReference getErrorModel_Base_StateMachine();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.NormalInput <em>Normal Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Normal Input</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.NormalInput
	 * @generated
	 */
	EClass getNormalInput();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.NormalOutput <em>Normal Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Normal Output</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.NormalOutput
	 * @generated
	 */
	EClass getNormalOutput();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Failure <em>Failure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Failure</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Failure
	 * @generated
	 */
	EClass getFailure();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Failure#getBase_Transition <em>Base Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Transition</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Failure#getBase_Transition()
	 * @see #getFailure()
	 * @generated
	 */
	EReference getFailure_Base_Transition();

	/**
	 * Returns the meta object for the attribute list '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Failure#getMode <em>Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mode</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Failure#getMode()
	 * @see #getFailure()
	 * @generated
	 */
	EAttribute getFailure_Mode();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Failure#getDelay <em>Delay</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Delay</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Failure#getDelay()
	 * @see #getFailure()
	 * @generated
	 */
	EAttribute getFailure_Delay();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Failure#getWeight <em>Weight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Weight</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Failure#getWeight()
	 * @see #getFailure()
	 * @generated
	 */
	EAttribute getFailure_Weight();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatState <em>Threat State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Threat State</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatState
	 * @generated
	 */
	EClass getThreatState();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatState#getBase_State <em>Base State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base State</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatState#getBase_State()
	 * @see #getThreatState()
	 * @generated
	 */
	EReference getThreatState_Base_State();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatState#getProbability <em>Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Probability</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatState#getProbability()
	 * @see #getThreatState()
	 * @generated
	 */
	EAttribute getThreatState_Probability();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatState#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unit</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatState#getUnit()
	 * @see #getThreatState()
	 * @generated
	 */
	EAttribute getThreatState_Unit();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.DegradedState <em>Degraded State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Degraded State</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.DegradedState
	 * @generated
	 */
	EClass getDegradedState();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.NormalState <em>Normal State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Normal State</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.NormalState
	 * @generated
	 */
	EClass getNormalState();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.NormalState#getBase_State <em>Base State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base State</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.NormalState#getBase_State()
	 * @see #getNormalState()
	 * @generated
	 */
	EReference getNormalState_Base_State();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ErrorState <em>Error State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Error State</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ErrorState
	 * @generated
	 */
	EClass getErrorState();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.StuckAt <em>Stuck At</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stuck At</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.StuckAt
	 * @generated
	 */
	EClass getStuckAt();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.StuckAt#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Property</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.StuckAt#getProperty()
	 * @see #getStuckAt()
	 * @generated
	 */
	EReference getStuckAt_Property();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.StuckAt#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.StuckAt#getValue()
	 * @see #getStuckAt()
	 * @generated
	 */
	EAttribute getStuckAt_Value();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.StuckAt#getBase_State <em>Base State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base State</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.StuckAt#getBase_State()
	 * @see #getStuckAt()
	 * @generated
	 */
	EReference getStuckAt_Base_State();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.StuckAtFixed <em>Stuck At Fixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stuck At Fixed</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.StuckAtFixed
	 * @generated
	 */
	EClass getStuckAtFixed();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.StuckAtFixed#getBase_State <em>Base State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base State</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.StuckAtFixed#getBase_State()
	 * @see #getStuckAtFixed()
	 * @generated
	 */
	EReference getStuckAtFixed_Base_State();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.StuckAtFixed#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Property</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.StuckAtFixed#getProperty()
	 * @see #getStuckAtFixed()
	 * @generated
	 */
	EReference getStuckAtFixed_Property();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Inverted <em>Inverted</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inverted</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Inverted
	 * @generated
	 */
	EClass getInverted();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Inverted#getBase_State <em>Base State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base State</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Inverted#getBase_State()
	 * @see #getInverted()
	 * @generated
	 */
	EReference getInverted_Base_State();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Inverted#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Property</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Inverted#getProperty()
	 * @see #getInverted()
	 * @generated
	 */
	EReference getInverted_Property();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.RampDown <em>Ramp Down</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ramp Down</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.RampDown
	 * @generated
	 */
	EClass getRampDown();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.RampDown#getBase_State <em>Base State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base State</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.RampDown#getBase_State()
	 * @see #getRampDown()
	 * @generated
	 */
	EReference getRampDown_Base_State();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.RampDown#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Property</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.RampDown#getProperty()
	 * @see #getRampDown()
	 * @generated
	 */
	EReference getRampDown_Property();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.RampDown#getDecr <em>Decr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Decr</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.RampDown#getDecr()
	 * @see #getRampDown()
	 * @generated
	 */
	EAttribute getRampDown_Decr();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.RampDown#getEndValue <em>End Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Value</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.RampDown#getEndValue()
	 * @see #getRampDown()
	 * @generated
	 */
	EAttribute getRampDown_EndValue();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.DepEvent <em>Dep Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dep Event</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.DepEvent
	 * @generated
	 */
	EClass getDepEvent();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.DepEvent#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Port</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.DepEvent#getPort()
	 * @see #getDepEvent()
	 * @generated
	 */
	EReference getDepEvent_Port();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.DepEvent#getBase_Transition <em>Base Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Transition</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.DepEvent#getBase_Transition()
	 * @see #getDepEvent()
	 * @generated
	 */
	EReference getDepEvent_Base_Transition();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.DepEvent#getWeight <em>Weight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Weight</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.DepEvent#getWeight()
	 * @see #getDepEvent()
	 * @generated
	 */
	EAttribute getDepEvent_Weight();

	/**
	 * Returns the meta object for enum '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.RecoveryKind <em>Recovery Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Recovery Kind</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.RecoveryKind
	 * @generated
	 */
	EEnum getRecoveryKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ThreatsPropagationFactory getThreatsPropagationFactory();

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
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.InternalFaultImpl <em>Internal Fault</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.InternalFaultImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getInternalFault()
		 * @generated
		 */
		EClass INTERNAL_FAULT = eINSTANCE.getInternalFault();

		/**
		 * The meta object literal for the '<em><b>Occurrence</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERNAL_FAULT__OCCURRENCE = eINSTANCE.getInternalFault_Occurrence();

		/**
		 * The meta object literal for the '<em><b>Base Transition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERNAL_FAULT__BASE_TRANSITION = eINSTANCE.getInternalFault_Base_Transition();

		/**
		 * The meta object literal for the '<em><b>Weight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERNAL_FAULT__WEIGHT = eINSTANCE.getInternalFault_Weight();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.InternalPropagationImpl <em>Internal Propagation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.InternalPropagationImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getInternalPropagation()
		 * @generated
		 */
		EClass INTERNAL_PROPAGATION = eINSTANCE.getInternalPropagation();

		/**
		 * The meta object literal for the '<em><b>Base Transition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERNAL_PROPAGATION__BASE_TRANSITION = eINSTANCE.getInternalPropagation_Base_Transition();

		/**
		 * The meta object literal for the '<em><b>External Faults</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERNAL_PROPAGATION__EXTERNAL_FAULTS = eINSTANCE.getInternalPropagation_ExternalFaults();

		/**
		 * The meta object literal for the '<em><b>Delay</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERNAL_PROPAGATION__DELAY = eINSTANCE.getInternalPropagation_Delay();

		/**
		 * The meta object literal for the '<em><b>Weight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERNAL_PROPAGATION__WEIGHT = eINSTANCE.getInternalPropagation_Weight();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ErrorDetectionImpl <em>Error Detection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ErrorDetectionImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getErrorDetection()
		 * @generated
		 */
		EClass ERROR_DETECTION = eINSTANCE.getErrorDetection();

		/**
		 * The meta object literal for the '<em><b>Base Transition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR_DETECTION__BASE_TRANSITION = eINSTANCE.getErrorDetection_Base_Transition();

		/**
		 * The meta object literal for the '<em><b>Delay</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ERROR_DETECTION__DELAY = eINSTANCE.getErrorDetection_Delay();

		/**
		 * The meta object literal for the '<em><b>Success Probability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ERROR_DETECTION__SUCCESS_PROBABILITY = eINSTANCE.getErrorDetection_SuccessProbability();

		/**
		 * The meta object literal for the '<em><b>Weight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ERROR_DETECTION__WEIGHT = eINSTANCE.getErrorDetection_Weight();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ErrorHandlingImpl <em>Error Handling</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ErrorHandlingImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getErrorHandling()
		 * @generated
		 */
		EClass ERROR_HANDLING = eINSTANCE.getErrorHandling();

		/**
		 * The meta object literal for the '<em><b>Base Transition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR_HANDLING__BASE_TRANSITION = eINSTANCE.getErrorHandling_Base_Transition();

		/**
		 * The meta object literal for the '<em><b>Delay</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ERROR_HANDLING__DELAY = eINSTANCE.getErrorHandling_Delay();

		/**
		 * The meta object literal for the '<em><b>Success Probability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ERROR_HANDLING__SUCCESS_PROBABILITY = eINSTANCE.getErrorHandling_SuccessProbability();

		/**
		 * The meta object literal for the '<em><b>Weight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ERROR_HANDLING__WEIGHT = eINSTANCE.getErrorHandling_Weight();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.FaultHandlingImpl <em>Fault Handling</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.FaultHandlingImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getFaultHandling()
		 * @generated
		 */
		EClass FAULT_HANDLING = eINSTANCE.getFaultHandling();

		/**
		 * The meta object literal for the '<em><b>Base Transition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAULT_HANDLING__BASE_TRANSITION = eINSTANCE.getFaultHandling_Base_Transition();

		/**
		 * The meta object literal for the '<em><b>Delay</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAULT_HANDLING__DELAY = eINSTANCE.getFaultHandling_Delay();

		/**
		 * The meta object literal for the '<em><b>Success Probability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAULT_HANDLING__SUCCESS_PROBABILITY = eINSTANCE.getFaultHandling_SuccessProbability();

		/**
		 * The meta object literal for the '<em><b>Weight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAULT_HANDLING__WEIGHT = eINSTANCE.getFaultHandling_Weight();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ErrorModelImpl <em>Error Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ErrorModelImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getErrorModel()
		 * @generated
		 */
		EClass ERROR_MODEL = eINSTANCE.getErrorModel();

		/**
		 * The meta object literal for the '<em><b>Base State Machine</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR_MODEL__BASE_STATE_MACHINE = eINSTANCE.getErrorModel_Base_StateMachine();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.NormalInputImpl <em>Normal Input</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.NormalInputImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getNormalInput()
		 * @generated
		 */
		EClass NORMAL_INPUT = eINSTANCE.getNormalInput();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.NormalOutputImpl <em>Normal Output</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.NormalOutputImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getNormalOutput()
		 * @generated
		 */
		EClass NORMAL_OUTPUT = eINSTANCE.getNormalOutput();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.FailureImpl <em>Failure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.FailureImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getFailure()
		 * @generated
		 */
		EClass FAILURE = eINSTANCE.getFailure();

		/**
		 * The meta object literal for the '<em><b>Base Transition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAILURE__BASE_TRANSITION = eINSTANCE.getFailure_Base_Transition();

		/**
		 * The meta object literal for the '<em><b>Mode</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAILURE__MODE = eINSTANCE.getFailure_Mode();

		/**
		 * The meta object literal for the '<em><b>Delay</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAILURE__DELAY = eINSTANCE.getFailure_Delay();

		/**
		 * The meta object literal for the '<em><b>Weight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAILURE__WEIGHT = eINSTANCE.getFailure_Weight();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatStateImpl <em>Threat State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatStateImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getThreatState()
		 * @generated
		 */
		EClass THREAT_STATE = eINSTANCE.getThreatState();

		/**
		 * The meta object literal for the '<em><b>Base State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THREAT_STATE__BASE_STATE = eINSTANCE.getThreatState_Base_State();

		/**
		 * The meta object literal for the '<em><b>Probability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THREAT_STATE__PROBABILITY = eINSTANCE.getThreatState_Probability();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THREAT_STATE__UNIT = eINSTANCE.getThreatState_Unit();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.DegradedStateImpl <em>Degraded State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.DegradedStateImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getDegradedState()
		 * @generated
		 */
		EClass DEGRADED_STATE = eINSTANCE.getDegradedState();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.NormalStateImpl <em>Normal State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.NormalStateImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getNormalState()
		 * @generated
		 */
		EClass NORMAL_STATE = eINSTANCE.getNormalState();

		/**
		 * The meta object literal for the '<em><b>Base State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NORMAL_STATE__BASE_STATE = eINSTANCE.getNormalState_Base_State();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ErrorStateImpl <em>Error State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ErrorStateImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getErrorState()
		 * @generated
		 */
		EClass ERROR_STATE = eINSTANCE.getErrorState();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.StuckAtImpl <em>Stuck At</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.StuckAtImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getStuckAt()
		 * @generated
		 */
		EClass STUCK_AT = eINSTANCE.getStuckAt();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STUCK_AT__PROPERTY = eINSTANCE.getStuckAt_Property();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STUCK_AT__VALUE = eINSTANCE.getStuckAt_Value();

		/**
		 * The meta object literal for the '<em><b>Base State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STUCK_AT__BASE_STATE = eINSTANCE.getStuckAt_Base_State();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.StuckAtFixedImpl <em>Stuck At Fixed</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.StuckAtFixedImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getStuckAtFixed()
		 * @generated
		 */
		EClass STUCK_AT_FIXED = eINSTANCE.getStuckAtFixed();

		/**
		 * The meta object literal for the '<em><b>Base State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STUCK_AT_FIXED__BASE_STATE = eINSTANCE.getStuckAtFixed_Base_State();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STUCK_AT_FIXED__PROPERTY = eINSTANCE.getStuckAtFixed_Property();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.InvertedImpl <em>Inverted</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.InvertedImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getInverted()
		 * @generated
		 */
		EClass INVERTED = eINSTANCE.getInverted();

		/**
		 * The meta object literal for the '<em><b>Base State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INVERTED__BASE_STATE = eINSTANCE.getInverted_Base_State();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INVERTED__PROPERTY = eINSTANCE.getInverted_Property();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.RampDownImpl <em>Ramp Down</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.RampDownImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getRampDown()
		 * @generated
		 */
		EClass RAMP_DOWN = eINSTANCE.getRampDown();

		/**
		 * The meta object literal for the '<em><b>Base State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RAMP_DOWN__BASE_STATE = eINSTANCE.getRampDown_Base_State();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RAMP_DOWN__PROPERTY = eINSTANCE.getRampDown_Property();

		/**
		 * The meta object literal for the '<em><b>Decr</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RAMP_DOWN__DECR = eINSTANCE.getRampDown_Decr();

		/**
		 * The meta object literal for the '<em><b>End Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RAMP_DOWN__END_VALUE = eINSTANCE.getRampDown_EndValue();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.DepEventImpl <em>Dep Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.DepEventImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getDepEvent()
		 * @generated
		 */
		EClass DEP_EVENT = eINSTANCE.getDepEvent();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEP_EVENT__PORT = eINSTANCE.getDepEvent_Port();

		/**
		 * The meta object literal for the '<em><b>Base Transition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEP_EVENT__BASE_TRANSITION = eINSTANCE.getDepEvent_Base_Transition();

		/**
		 * The meta object literal for the '<em><b>Weight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEP_EVENT__WEIGHT = eINSTANCE.getDepEvent_Weight();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.RecoveryKind <em>Recovery Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.RecoveryKind
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getRecoveryKind()
		 * @generated
		 */
		EEnum RECOVERY_KIND = eINSTANCE.getRecoveryKind();

	}

} //ThreatsPropagationPackage
