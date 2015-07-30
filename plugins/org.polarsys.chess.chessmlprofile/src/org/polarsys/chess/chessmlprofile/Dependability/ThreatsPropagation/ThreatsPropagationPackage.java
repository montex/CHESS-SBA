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
	int INTERNAL_FAULT = 25;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.InternalPropagationImpl <em>Internal Propagation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.InternalPropagationImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getInternalPropagation()
	 * @generated
	 */
	int INTERNAL_PROPAGATION = 26;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ExternalFaultImpl <em>External Fault</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ExternalFaultImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getExternalFault()
	 * @generated
	 */
	int EXTERNAL_FAULT = 18;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.NormalInputImpl <em>Normal Input</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.NormalInputImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getNormalInput()
	 * @generated
	 */
	int NORMAL_INPUT = 19;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.RecoveryEventImpl <em>Recovery Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.RecoveryEventImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getRecoveryEvent()
	 * @generated
	 */
	int RECOVERY_EVENT = 20;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.NormalOutputImpl <em>Normal Output</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.NormalOutputImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getNormalOutput()
	 * @generated
	 */
	int NORMAL_OUTPUT = 21;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.FailureImpl <em>Failure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.FailureImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getFailure()
	 * @generated
	 */
	int FAILURE = 22;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.NormalEventImpl <em>Normal Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.NormalEventImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getNormalEvent()
	 * @generated
	 */
	int NORMAL_EVENT = 23;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.InternalThreatImpl <em>Internal Threat</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.InternalThreatImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getInternalThreat()
	 * @generated
	 */
	int INTERNAL_THREAT = 24;

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
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ErrorImpl <em>Error</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ErrorImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getError()
	 * @generated
	 */
	int ERROR = 8;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ErrorFreeImpl <em>Error Free</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ErrorFreeImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getErrorFree()
	 * @generated
	 */
	int ERROR_FREE = 9;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.UnclassifiedErrorImpl <em>Unclassified Error</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.UnclassifiedErrorImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getUnclassifiedError()
	 * @generated
	 */
	int UNCLASSIFIED_ERROR = 4;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.FailureModeImpl <em>Failure Mode</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.FailureModeImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getFailureMode()
	 * @generated
	 */
	int FAILURE_MODE = 2;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.DegradedStateImpl <em>Degraded State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.DegradedStateImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getDegradedState()
	 * @generated
	 */
	int DEGRADED_STATE = 3;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.FailureFreeImpl <em>Failure Free</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.FailureFreeImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getFailureFree()
	 * @generated
	 */
	int FAILURE_FREE = 5;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.CHInternalFaultImpl <em>CH Internal Fault</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.CHInternalFaultImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getCHInternalFault()
	 * @generated
	 */
	int CH_INTERNAL_FAULT = 6;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.CHExternalFaultImpl <em>CH External Fault</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.CHExternalFaultImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getCHExternalFault()
	 * @generated
	 */
	int CH_EXTERNAL_FAULT = 7;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.UnclassifiedFailureImpl <em>Unclassified Failure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.UnclassifiedFailureImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getUnclassifiedFailure()
	 * @generated
	 */
	int UNCLASSIFIED_FAILURE = 0;

	/**
	 * The feature id for the '<em><b>Base State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNCLASSIFIED_FAILURE__BASE_STATE = THREAT_STATE__BASE_STATE;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNCLASSIFIED_FAILURE__PROBABILITY = THREAT_STATE__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNCLASSIFIED_FAILURE__UNIT = THREAT_STATE__UNIT;

	/**
	 * The number of structural features of the '<em>Unclassified Failure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNCLASSIFIED_FAILURE_FEATURE_COUNT = THREAT_STATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_MODE__BASE_STATE = THREAT_STATE__BASE_STATE;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_MODE__PROBABILITY = THREAT_STATE__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_MODE__UNIT = THREAT_STATE__UNIT;

	/**
	 * The feature id for the '<em><b>Affected Ports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_MODE__AFFECTED_PORTS = THREAT_STATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_MODE__TYPE = THREAT_STATE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Failure Mode</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_MODE_FEATURE_COUNT = THREAT_STATE_FEATURE_COUNT + 2;

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
	int UNCLASSIFIED_ERROR__BASE_STATE = THREAT_STATE__BASE_STATE;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNCLASSIFIED_ERROR__PROBABILITY = THREAT_STATE__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNCLASSIFIED_ERROR__UNIT = THREAT_STATE__UNIT;

	/**
	 * The number of structural features of the '<em>Unclassified Error</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNCLASSIFIED_ERROR_FEATURE_COUNT = THREAT_STATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_FREE__BASE_STATE = THREAT_STATE__BASE_STATE;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_FREE__PROBABILITY = THREAT_STATE__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_FREE__UNIT = THREAT_STATE__UNIT;

	/**
	 * The number of structural features of the '<em>Failure Free</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_FREE_FEATURE_COUNT = THREAT_STATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Transition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_INTERNAL_FAULT__BASE_TRANSITION = 0;

	/**
	 * The feature id for the '<em><b>Permanent Prob</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_INTERNAL_FAULT__PERMANENT_PROB = 1;

	/**
	 * The feature id for the '<em><b>Transf Funct</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_INTERNAL_FAULT__TRANSF_FUNCT = 2;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_INTERNAL_FAULT__PROPERTY = 3;

	/**
	 * The feature id for the '<em><b>Child Failure</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_INTERNAL_FAULT__CHILD_FAILURE = 4;

	/**
	 * The feature id for the '<em><b>Occurrence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_INTERNAL_FAULT__OCCURRENCE = 5;

	/**
	 * The feature id for the '<em><b>Transient Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_INTERNAL_FAULT__TRANSIENT_DURATION = 6;

	/**
	 * The number of structural features of the '<em>CH Internal Fault</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_INTERNAL_FAULT_FEATURE_COUNT = 7;

	/**
	 * The feature id for the '<em><b>Base Transition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_EXTERNAL_FAULT__BASE_TRANSITION = 0;

	/**
	 * The feature id for the '<em><b>From Port</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_EXTERNAL_FAULT__FROM_PORT = 1;

	/**
	 * The feature id for the '<em><b>Propagation Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_EXTERNAL_FAULT__PROPAGATION_CONDITION = 2;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_EXTERNAL_FAULT__PROBABILITY = 3;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_EXTERNAL_FAULT__UNIT = 4;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_EXTERNAL_FAULT__TYPE = 5;

	/**
	 * The feature id for the '<em><b>Transf Funct</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_EXTERNAL_FAULT__TRANSF_FUNCT = 6;

	/**
	 * The number of structural features of the '<em>CH External Fault</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_EXTERNAL_FAULT_FEATURE_COUNT = 7;

	/**
	 * The feature id for the '<em><b>Base State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR__BASE_STATE = THREAT_STATE__BASE_STATE;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR__PROBABILITY = THREAT_STATE__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR__UNIT = THREAT_STATE__UNIT;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR__TYPE = THREAT_STATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Vanishing Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR__VANISHING_TIME = THREAT_STATE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Error</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_FEATURE_COUNT = THREAT_STATE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Base State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_FREE__BASE_STATE = THREAT_STATE__BASE_STATE;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_FREE__PROBABILITY = THREAT_STATE__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_FREE__UNIT = THREAT_STATE__UNIT;

	/**
	 * The number of structural features of the '<em>Error Free</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_FREE_FEATURE_COUNT = THREAT_STATE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.StuckAtImpl <em>Stuck At</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.StuckAtImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getStuckAt()
	 * @generated
	 */
	int STUCK_AT = 10;

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
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.StuckAtFixedImpl <em>Stuck At Fixed</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.StuckAtFixedImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getStuckAtFixed()
	 * @generated
	 */
	int STUCK_AT_FIXED = 11;

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
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.InvertedImpl <em>Inverted</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.InvertedImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getInverted()
	 * @generated
	 */
	int INVERTED = 12;

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
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.RampDownImpl <em>Ramp Down</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.RampDownImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getRampDown()
	 * @generated
	 */
	int RAMP_DOWN = 13;

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
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.DepEventImpl <em>Dep Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.DepEventImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getDepEvent()
	 * @generated
	 */
	int DEP_EVENT = 15;

	/**
	 * The feature id for the '<em><b>Base Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEP_EVENT__BASE_EVENT = 0;

	/**
	 * The feature id for the '<em><b>Base State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEP_EVENT__BASE_STATE = 1;

	/**
	 * The number of structural features of the '<em>Dep Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEP_EVENT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.InputEventImpl <em>Input Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.InputEventImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getInputEvent()
	 * @generated
	 */
	int INPUT_EVENT = 14;

	/**
	 * The feature id for the '<em><b>Base Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_EVENT__BASE_EVENT = DEP_EVENT__BASE_EVENT;

	/**
	 * The feature id for the '<em><b>Base State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_EVENT__BASE_STATE = DEP_EVENT__BASE_STATE;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_EVENT__PORT = DEP_EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Input Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_EVENT_FEATURE_COUNT = DEP_EVENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.OutputEventImpl <em>Output Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.OutputEventImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getOutputEvent()
	 * @generated
	 */
	int OUTPUT_EVENT = 16;

	/**
	 * The feature id for the '<em><b>Base Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_EVENT__BASE_EVENT = DEP_EVENT__BASE_EVENT;

	/**
	 * The feature id for the '<em><b>Base State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_EVENT__BASE_STATE = DEP_EVENT__BASE_STATE;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_EVENT__PORT = DEP_EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Output Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_EVENT_FEATURE_COUNT = DEP_EVENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.InternalEventImpl <em>Internal Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.InternalEventImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getInternalEvent()
	 * @generated
	 */
	int INTERNAL_EVENT = 17;

	/**
	 * The feature id for the '<em><b>Base Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_EVENT__BASE_EVENT = DEP_EVENT__BASE_EVENT;

	/**
	 * The feature id for the '<em><b>Base State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_EVENT__BASE_STATE = DEP_EVENT__BASE_STATE;

	/**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_EVENT__DELAY = DEP_EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_EVENT__PROBABILITY = DEP_EVENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Internal Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_EVENT_FEATURE_COUNT = DEP_EVENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Base Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_FAULT__BASE_EVENT = INPUT_EVENT__BASE_EVENT;

	/**
	 * The feature id for the '<em><b>Base State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_FAULT__BASE_STATE = INPUT_EVENT__BASE_STATE;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_FAULT__PORT = INPUT_EVENT__PORT;

	/**
	 * The feature id for the '<em><b>Failure</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_FAULT__FAILURE = INPUT_EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>External Fault</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_FAULT_FEATURE_COUNT = INPUT_EVENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_INPUT__BASE_EVENT = INPUT_EVENT__BASE_EVENT;

	/**
	 * The feature id for the '<em><b>Base State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_INPUT__BASE_STATE = INPUT_EVENT__BASE_STATE;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_INPUT__PORT = INPUT_EVENT__PORT;

	/**
	 * The feature id for the '<em><b>Recovery</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_INPUT__RECOVERY = INPUT_EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Normal Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_INPUT_FEATURE_COUNT = INPUT_EVENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOVERY_EVENT__BASE_EVENT = INTERNAL_EVENT__BASE_EVENT;

	/**
	 * The feature id for the '<em><b>Base State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOVERY_EVENT__BASE_STATE = INTERNAL_EVENT__BASE_STATE;

	/**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOVERY_EVENT__DELAY = INTERNAL_EVENT__DELAY;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOVERY_EVENT__PROBABILITY = INTERNAL_EVENT__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOVERY_EVENT__KIND = INTERNAL_EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Recovery Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOVERY_EVENT_FEATURE_COUNT = INTERNAL_EVENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_OUTPUT__BASE_EVENT = OUTPUT_EVENT__BASE_EVENT;

	/**
	 * The feature id for the '<em><b>Base State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_OUTPUT__BASE_STATE = OUTPUT_EVENT__BASE_STATE;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_OUTPUT__PORT = OUTPUT_EVENT__PORT;

	/**
	 * The feature id for the '<em><b>Recovery</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_OUTPUT__RECOVERY = OUTPUT_EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Normal Output</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_OUTPUT_FEATURE_COUNT = OUTPUT_EVENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE__BASE_EVENT = OUTPUT_EVENT__BASE_EVENT;

	/**
	 * The feature id for the '<em><b>Base State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE__BASE_STATE = OUTPUT_EVENT__BASE_STATE;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE__PORT = OUTPUT_EVENT__PORT;

	/**
	 * The feature id for the '<em><b>Failure</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE__FAILURE = OUTPUT_EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Failure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_FEATURE_COUNT = OUTPUT_EVENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_EVENT__BASE_EVENT = INTERNAL_EVENT__BASE_EVENT;

	/**
	 * The feature id for the '<em><b>Base State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_EVENT__BASE_STATE = INTERNAL_EVENT__BASE_STATE;

	/**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_EVENT__DELAY = INTERNAL_EVENT__DELAY;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_EVENT__PROBABILITY = INTERNAL_EVENT__PROBABILITY;

	/**
	 * The number of structural features of the '<em>Normal Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_EVENT_FEATURE_COUNT = INTERNAL_EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_THREAT__BASE_EVENT = INTERNAL_EVENT__BASE_EVENT;

	/**
	 * The feature id for the '<em><b>Base State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_THREAT__BASE_STATE = INTERNAL_EVENT__BASE_STATE;

	/**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_THREAT__DELAY = INTERNAL_EVENT__DELAY;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_THREAT__PROBABILITY = INTERNAL_EVENT__PROBABILITY;

	/**
	 * The number of structural features of the '<em>Internal Threat</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_THREAT_FEATURE_COUNT = INTERNAL_EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_FAULT__BASE_EVENT = INTERNAL_THREAT__BASE_EVENT;

	/**
	 * The feature id for the '<em><b>Base State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_FAULT__BASE_STATE = INTERNAL_THREAT__BASE_STATE;

	/**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_FAULT__DELAY = INTERNAL_THREAT__DELAY;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_FAULT__PROBABILITY = INTERNAL_THREAT__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Occurrence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_FAULT__OCCURRENCE = INTERNAL_THREAT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Internal Fault</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_FAULT_FEATURE_COUNT = INTERNAL_THREAT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_PROPAGATION__BASE_EVENT = INTERNAL_THREAT__BASE_EVENT;

	/**
	 * The feature id for the '<em><b>Base State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_PROPAGATION__BASE_STATE = INTERNAL_THREAT__BASE_STATE;

	/**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_PROPAGATION__DELAY = INTERNAL_THREAT__DELAY;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_PROPAGATION__PROBABILITY = INTERNAL_THREAT__PROBABILITY;

	/**
	 * The number of structural features of the '<em>Internal Propagation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_PROPAGATION_FEATURE_COUNT = INTERNAL_THREAT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ErrorModelImpl <em>Error Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ErrorModelImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getErrorModel()
	 * @generated
	 */
	int ERROR_MODEL = 27;

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
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.DurationType <em>Duration Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.DurationType
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getDurationType()
	 * @generated
	 */
	int DURATION_TYPE = 28;


	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.RecoveryKind <em>Recovery Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.RecoveryKind
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getRecoveryKind()
	 * @generated
	 */
	int RECOVERY_KIND = 29;


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
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalPropagation <em>Internal Propagation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Internal Propagation</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalPropagation
	 * @generated
	 */
	EClass getInternalPropagation();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ExternalFault <em>External Fault</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>External Fault</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ExternalFault
	 * @generated
	 */
	EClass getExternalFault();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ExternalFault#getFailure <em>Failure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Failure</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ExternalFault#getFailure()
	 * @see #getExternalFault()
	 * @generated
	 */
	EReference getExternalFault_Failure();

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
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.NormalInput#getRecovery <em>Recovery</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Recovery</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.NormalInput#getRecovery()
	 * @see #getNormalInput()
	 * @generated
	 */
	EReference getNormalInput_Recovery();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.RecoveryEvent <em>Recovery Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Recovery Event</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.RecoveryEvent
	 * @generated
	 */
	EClass getRecoveryEvent();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.RecoveryEvent#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.RecoveryEvent#getKind()
	 * @see #getRecoveryEvent()
	 * @generated
	 */
	EAttribute getRecoveryEvent_Kind();

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
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.NormalOutput#getRecovery <em>Recovery</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Recovery</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.NormalOutput#getRecovery()
	 * @see #getNormalOutput()
	 * @generated
	 */
	EReference getNormalOutput_Recovery();

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
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Failure#getFailure <em>Failure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Failure</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Failure#getFailure()
	 * @see #getFailure()
	 * @generated
	 */
	EReference getFailure_Failure();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.NormalEvent <em>Normal Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Normal Event</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.NormalEvent
	 * @generated
	 */
	EClass getNormalEvent();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalThreat <em>Internal Threat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Internal Threat</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalThreat
	 * @generated
	 */
	EClass getInternalThreat();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Error <em>Error</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Error</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Error
	 * @generated
	 */
	EClass getError();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Error#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Error#getType()
	 * @see #getError()
	 * @generated
	 */
	EAttribute getError_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Error#getVanishingTime <em>Vanishing Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vanishing Time</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Error#getVanishingTime()
	 * @see #getError()
	 * @generated
	 */
	EAttribute getError_VanishingTime();

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
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ErrorFree <em>Error Free</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Error Free</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ErrorFree
	 * @generated
	 */
	EClass getErrorFree();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.UnclassifiedError <em>Unclassified Error</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unclassified Error</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.UnclassifiedError
	 * @generated
	 */
	EClass getUnclassifiedError();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.FailureMode <em>Failure Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Failure Mode</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.FailureMode
	 * @generated
	 */
	EClass getFailureMode();

	/**
	 * Returns the meta object for the reference list '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.FailureMode#getAffectedPorts <em>Affected Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Affected Ports</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.FailureMode#getAffectedPorts()
	 * @see #getFailureMode()
	 * @generated
	 */
	EReference getFailureMode_AffectedPorts();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.FailureMode#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.FailureMode#getType()
	 * @see #getFailureMode()
	 * @generated
	 */
	EAttribute getFailureMode_Type();

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
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.FailureFree <em>Failure Free</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Failure Free</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.FailureFree
	 * @generated
	 */
	EClass getFailureFree();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.CHInternalFault <em>CH Internal Fault</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CH Internal Fault</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.CHInternalFault
	 * @generated
	 */
	EClass getCHInternalFault();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.CHInternalFault#getBase_Transition <em>Base Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Transition</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.CHInternalFault#getBase_Transition()
	 * @see #getCHInternalFault()
	 * @generated
	 */
	EReference getCHInternalFault_Base_Transition();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.CHInternalFault#getPermanentProb <em>Permanent Prob</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Permanent Prob</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.CHInternalFault#getPermanentProb()
	 * @see #getCHInternalFault()
	 * @generated
	 */
	EAttribute getCHInternalFault_PermanentProb();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.CHInternalFault#getTransfFunct <em>Transf Funct</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transf Funct</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.CHInternalFault#getTransfFunct()
	 * @see #getCHInternalFault()
	 * @generated
	 */
	EAttribute getCHInternalFault_TransfFunct();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.CHInternalFault#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Property</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.CHInternalFault#getProperty()
	 * @see #getCHInternalFault()
	 * @generated
	 */
	EReference getCHInternalFault_Property();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.CHInternalFault#getChildFailure <em>Child Failure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Child Failure</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.CHInternalFault#getChildFailure()
	 * @see #getCHInternalFault()
	 * @generated
	 */
	EReference getCHInternalFault_ChildFailure();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.CHInternalFault#getOccurrence <em>Occurrence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Occurrence</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.CHInternalFault#getOccurrence()
	 * @see #getCHInternalFault()
	 * @generated
	 */
	EAttribute getCHInternalFault_Occurrence();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.CHInternalFault#getTransientDuration <em>Transient Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transient Duration</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.CHInternalFault#getTransientDuration()
	 * @see #getCHInternalFault()
	 * @generated
	 */
	EAttribute getCHInternalFault_TransientDuration();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.CHExternalFault <em>CH External Fault</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CH External Fault</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.CHExternalFault
	 * @generated
	 */
	EClass getCHExternalFault();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.CHExternalFault#getBase_Transition <em>Base Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Transition</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.CHExternalFault#getBase_Transition()
	 * @see #getCHExternalFault()
	 * @generated
	 */
	EReference getCHExternalFault_Base_Transition();

	/**
	 * Returns the meta object for the reference list '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.CHExternalFault#getFromPort <em>From Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>From Port</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.CHExternalFault#getFromPort()
	 * @see #getCHExternalFault()
	 * @generated
	 */
	EReference getCHExternalFault_FromPort();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.CHExternalFault#getPropagationCondition <em>Propagation Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Propagation Condition</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.CHExternalFault#getPropagationCondition()
	 * @see #getCHExternalFault()
	 * @generated
	 */
	EAttribute getCHExternalFault_PropagationCondition();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.CHExternalFault#getProbability <em>Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Probability</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.CHExternalFault#getProbability()
	 * @see #getCHExternalFault()
	 * @generated
	 */
	EAttribute getCHExternalFault_Probability();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.CHExternalFault#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unit</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.CHExternalFault#getUnit()
	 * @see #getCHExternalFault()
	 * @generated
	 */
	EAttribute getCHExternalFault_Unit();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.CHExternalFault#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.CHExternalFault#getType()
	 * @see #getCHExternalFault()
	 * @generated
	 */
	EAttribute getCHExternalFault_Type();

	/**
	 * Returns the meta object for the attribute list '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.CHExternalFault#getTransfFunct <em>Transf Funct</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Transf Funct</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.CHExternalFault#getTransfFunct()
	 * @see #getCHExternalFault()
	 * @generated
	 */
	EAttribute getCHExternalFault_TransfFunct();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.UnclassifiedFailure <em>Unclassified Failure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unclassified Failure</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.UnclassifiedFailure
	 * @generated
	 */
	EClass getUnclassifiedFailure();

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
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InputEvent <em>Input Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Event</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InputEvent
	 * @generated
	 */
	EClass getInputEvent();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InputEvent#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Port</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InputEvent#getPort()
	 * @see #getInputEvent()
	 * @generated
	 */
	EReference getInputEvent_Port();

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
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.DepEvent#getBase_Event <em>Base Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Event</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.DepEvent#getBase_Event()
	 * @see #getDepEvent()
	 * @generated
	 */
	EReference getDepEvent_Base_Event();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.DepEvent#getBase_State <em>Base State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base State</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.DepEvent#getBase_State()
	 * @see #getDepEvent()
	 * @generated
	 */
	EReference getDepEvent_Base_State();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.OutputEvent <em>Output Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Event</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.OutputEvent
	 * @generated
	 */
	EClass getOutputEvent();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.OutputEvent#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Port</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.OutputEvent#getPort()
	 * @see #getOutputEvent()
	 * @generated
	 */
	EReference getOutputEvent_Port();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalEvent <em>Internal Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Internal Event</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalEvent
	 * @generated
	 */
	EClass getInternalEvent();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalEvent#getDelay <em>Delay</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Delay</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalEvent#getDelay()
	 * @see #getInternalEvent()
	 * @generated
	 */
	EAttribute getInternalEvent_Delay();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalEvent#getProbability <em>Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Probability</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalEvent#getProbability()
	 * @see #getInternalEvent()
	 * @generated
	 */
	EAttribute getInternalEvent_Probability();

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
	 * Returns the meta object for enum '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.DurationType <em>Duration Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Duration Type</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.DurationType
	 * @generated
	 */
	EEnum getDurationType();

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
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.InternalPropagationImpl <em>Internal Propagation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.InternalPropagationImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getInternalPropagation()
		 * @generated
		 */
		EClass INTERNAL_PROPAGATION = eINSTANCE.getInternalPropagation();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ExternalFaultImpl <em>External Fault</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ExternalFaultImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getExternalFault()
		 * @generated
		 */
		EClass EXTERNAL_FAULT = eINSTANCE.getExternalFault();

		/**
		 * The meta object literal for the '<em><b>Failure</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTERNAL_FAULT__FAILURE = eINSTANCE.getExternalFault_Failure();

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
		 * The meta object literal for the '<em><b>Recovery</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NORMAL_INPUT__RECOVERY = eINSTANCE.getNormalInput_Recovery();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.RecoveryEventImpl <em>Recovery Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.RecoveryEventImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getRecoveryEvent()
		 * @generated
		 */
		EClass RECOVERY_EVENT = eINSTANCE.getRecoveryEvent();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECOVERY_EVENT__KIND = eINSTANCE.getRecoveryEvent_Kind();

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
		 * The meta object literal for the '<em><b>Recovery</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NORMAL_OUTPUT__RECOVERY = eINSTANCE.getNormalOutput_Recovery();

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
		 * The meta object literal for the '<em><b>Failure</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAILURE__FAILURE = eINSTANCE.getFailure_Failure();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.NormalEventImpl <em>Normal Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.NormalEventImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getNormalEvent()
		 * @generated
		 */
		EClass NORMAL_EVENT = eINSTANCE.getNormalEvent();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.InternalThreatImpl <em>Internal Threat</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.InternalThreatImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getInternalThreat()
		 * @generated
		 */
		EClass INTERNAL_THREAT = eINSTANCE.getInternalThreat();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ErrorImpl <em>Error</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ErrorImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getError()
		 * @generated
		 */
		EClass ERROR = eINSTANCE.getError();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ERROR__TYPE = eINSTANCE.getError_Type();

		/**
		 * The meta object literal for the '<em><b>Vanishing Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ERROR__VANISHING_TIME = eINSTANCE.getError_VanishingTime();

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
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ErrorFreeImpl <em>Error Free</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ErrorFreeImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getErrorFree()
		 * @generated
		 */
		EClass ERROR_FREE = eINSTANCE.getErrorFree();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.UnclassifiedErrorImpl <em>Unclassified Error</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.UnclassifiedErrorImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getUnclassifiedError()
		 * @generated
		 */
		EClass UNCLASSIFIED_ERROR = eINSTANCE.getUnclassifiedError();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.FailureModeImpl <em>Failure Mode</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.FailureModeImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getFailureMode()
		 * @generated
		 */
		EClass FAILURE_MODE = eINSTANCE.getFailureMode();

		/**
		 * The meta object literal for the '<em><b>Affected Ports</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAILURE_MODE__AFFECTED_PORTS = eINSTANCE.getFailureMode_AffectedPorts();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAILURE_MODE__TYPE = eINSTANCE.getFailureMode_Type();

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
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.FailureFreeImpl <em>Failure Free</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.FailureFreeImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getFailureFree()
		 * @generated
		 */
		EClass FAILURE_FREE = eINSTANCE.getFailureFree();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.CHInternalFaultImpl <em>CH Internal Fault</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.CHInternalFaultImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getCHInternalFault()
		 * @generated
		 */
		EClass CH_INTERNAL_FAULT = eINSTANCE.getCHInternalFault();

		/**
		 * The meta object literal for the '<em><b>Base Transition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CH_INTERNAL_FAULT__BASE_TRANSITION = eINSTANCE.getCHInternalFault_Base_Transition();

		/**
		 * The meta object literal for the '<em><b>Permanent Prob</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CH_INTERNAL_FAULT__PERMANENT_PROB = eINSTANCE.getCHInternalFault_PermanentProb();

		/**
		 * The meta object literal for the '<em><b>Transf Funct</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CH_INTERNAL_FAULT__TRANSF_FUNCT = eINSTANCE.getCHInternalFault_TransfFunct();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CH_INTERNAL_FAULT__PROPERTY = eINSTANCE.getCHInternalFault_Property();

		/**
		 * The meta object literal for the '<em><b>Child Failure</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CH_INTERNAL_FAULT__CHILD_FAILURE = eINSTANCE.getCHInternalFault_ChildFailure();

		/**
		 * The meta object literal for the '<em><b>Occurrence</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CH_INTERNAL_FAULT__OCCURRENCE = eINSTANCE.getCHInternalFault_Occurrence();

		/**
		 * The meta object literal for the '<em><b>Transient Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CH_INTERNAL_FAULT__TRANSIENT_DURATION = eINSTANCE.getCHInternalFault_TransientDuration();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.CHExternalFaultImpl <em>CH External Fault</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.CHExternalFaultImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getCHExternalFault()
		 * @generated
		 */
		EClass CH_EXTERNAL_FAULT = eINSTANCE.getCHExternalFault();

		/**
		 * The meta object literal for the '<em><b>Base Transition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CH_EXTERNAL_FAULT__BASE_TRANSITION = eINSTANCE.getCHExternalFault_Base_Transition();

		/**
		 * The meta object literal for the '<em><b>From Port</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CH_EXTERNAL_FAULT__FROM_PORT = eINSTANCE.getCHExternalFault_FromPort();

		/**
		 * The meta object literal for the '<em><b>Propagation Condition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CH_EXTERNAL_FAULT__PROPAGATION_CONDITION = eINSTANCE.getCHExternalFault_PropagationCondition();

		/**
		 * The meta object literal for the '<em><b>Probability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CH_EXTERNAL_FAULT__PROBABILITY = eINSTANCE.getCHExternalFault_Probability();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CH_EXTERNAL_FAULT__UNIT = eINSTANCE.getCHExternalFault_Unit();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CH_EXTERNAL_FAULT__TYPE = eINSTANCE.getCHExternalFault_Type();

		/**
		 * The meta object literal for the '<em><b>Transf Funct</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CH_EXTERNAL_FAULT__TRANSF_FUNCT = eINSTANCE.getCHExternalFault_TransfFunct();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.UnclassifiedFailureImpl <em>Unclassified Failure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.UnclassifiedFailureImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getUnclassifiedFailure()
		 * @generated
		 */
		EClass UNCLASSIFIED_FAILURE = eINSTANCE.getUnclassifiedFailure();

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
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.InputEventImpl <em>Input Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.InputEventImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getInputEvent()
		 * @generated
		 */
		EClass INPUT_EVENT = eINSTANCE.getInputEvent();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INPUT_EVENT__PORT = eINSTANCE.getInputEvent_Port();

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
		 * The meta object literal for the '<em><b>Base Event</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEP_EVENT__BASE_EVENT = eINSTANCE.getDepEvent_Base_Event();

		/**
		 * The meta object literal for the '<em><b>Base State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEP_EVENT__BASE_STATE = eINSTANCE.getDepEvent_Base_State();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.OutputEventImpl <em>Output Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.OutputEventImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getOutputEvent()
		 * @generated
		 */
		EClass OUTPUT_EVENT = eINSTANCE.getOutputEvent();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTPUT_EVENT__PORT = eINSTANCE.getOutputEvent_Port();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.InternalEventImpl <em>Internal Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.InternalEventImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getInternalEvent()
		 * @generated
		 */
		EClass INTERNAL_EVENT = eINSTANCE.getInternalEvent();

		/**
		 * The meta object literal for the '<em><b>Delay</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERNAL_EVENT__DELAY = eINSTANCE.getInternalEvent_Delay();

		/**
		 * The meta object literal for the '<em><b>Probability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERNAL_EVENT__PROBABILITY = eINSTANCE.getInternalEvent_Probability();

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
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.DurationType <em>Duration Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.DurationType
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getDurationType()
		 * @generated
		 */
		EEnum DURATION_TYPE = eINSTANCE.getDurationType();

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
