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
	int INTERNAL_FAULT = 0;

	/**
	 * The feature id for the '<em><b>Base Transition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_FAULT__BASE_TRANSITION = 0;

	/**
	 * The feature id for the '<em><b>Permanent Prob</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_FAULT__PERMANENT_PROB = 1;

	/**
	 * The feature id for the '<em><b>Transf Funct</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_FAULT__TRANSF_FUNCT = 2;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_FAULT__PROPERTY = 3;

	/**
	 * The feature id for the '<em><b>Child Failure</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_FAULT__CHILD_FAILURE = 4;

	/**
	 * The feature id for the '<em><b>Occurrence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_FAULT__OCCURRENCE = 5;

	/**
	 * The feature id for the '<em><b>Transient Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_FAULT__TRANSIENT_DURATION = 6;

	/**
	 * The number of structural features of the '<em>Internal Fault</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_FAULT_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ExternalFaultImpl <em>External Fault</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ExternalFaultImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getExternalFault()
	 * @generated
	 */
	int EXTERNAL_FAULT = 1;

	/**
	 * The feature id for the '<em><b>Base Transition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_FAULT__BASE_TRANSITION = 0;

	/**
	 * The feature id for the '<em><b>From Port</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_FAULT__FROM_PORT = 1;

	/**
	 * The feature id for the '<em><b>Propagation Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_FAULT__PROPAGATION_CONDITION = 2;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_FAULT__PROBABILITY = 3;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_FAULT__UNIT = 4;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_FAULT__TYPE = 5;

	/**
	 * The feature id for the '<em><b>Transf Funct</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_FAULT__TRANSF_FUNCT = 6;

	/**
	 * The number of structural features of the '<em>External Fault</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_FAULT_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatStateImpl <em>Threat State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatStateImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getThreatState()
	 * @generated
	 */
	int THREAT_STATE = 3;

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
	int ERROR = 2;

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
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ErrorFreeImpl <em>Error Free</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ErrorFreeImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getErrorFree()
	 * @generated
	 */
	int ERROR_FREE = 4;

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
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.UnclassifiedErrorImpl <em>Unclassified Error</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.UnclassifiedErrorImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getUnclassifiedError()
	 * @generated
	 */
	int UNCLASSIFIED_ERROR = 5;

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
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.FailureModeImpl <em>Failure Mode</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.FailureModeImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getFailureMode()
	 * @generated
	 */
	int FAILURE_MODE = 6;

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
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.FailureFreeImpl <em>Failure Free</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.FailureFreeImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getFailureFree()
	 * @generated
	 */
	int FAILURE_FREE = 7;

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
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.UnclassifiedFailureImpl <em>Unclassified Failure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.UnclassifiedFailureImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getUnclassifiedFailure()
	 * @generated
	 */
	int UNCLASSIFIED_FAILURE = 8;

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
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.StuckAtImpl <em>Stuck At</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.StuckAtImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getStuckAt()
	 * @generated
	 */
	int STUCK_AT = 9;

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
	int STUCK_AT_FIXED = 10;

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
	int INVERTED = 11;

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
	int RAMP_DOWN = 12;

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
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ErrorModelImpl <em>Error Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ErrorModelImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getErrorModel()
	 * @generated
	 */
	int ERROR_MODEL = 13;

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
	int DURATION_TYPE = 14;


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
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalFault#getPermanentProb <em>Permanent Prob</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Permanent Prob</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalFault#getPermanentProb()
	 * @see #getInternalFault()
	 * @generated
	 */
	EAttribute getInternalFault_PermanentProb();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalFault#getTransfFunct <em>Transf Funct</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transf Funct</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalFault#getTransfFunct()
	 * @see #getInternalFault()
	 * @generated
	 */
	EAttribute getInternalFault_TransfFunct();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalFault#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Property</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalFault#getProperty()
	 * @see #getInternalFault()
	 * @generated
	 */
	EReference getInternalFault_Property();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalFault#getChildFailure <em>Child Failure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Child Failure</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalFault#getChildFailure()
	 * @see #getInternalFault()
	 * @generated
	 */
	EReference getInternalFault_ChildFailure();

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
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalFault#getTransientDuration <em>Transient Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transient Duration</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalFault#getTransientDuration()
	 * @see #getInternalFault()
	 * @generated
	 */
	EAttribute getInternalFault_TransientDuration();

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
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ExternalFault#getBase_Transition <em>Base Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Transition</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ExternalFault#getBase_Transition()
	 * @see #getExternalFault()
	 * @generated
	 */
	EReference getExternalFault_Base_Transition();

	/**
	 * Returns the meta object for the reference list '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ExternalFault#getFromPort <em>From Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>From Port</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ExternalFault#getFromPort()
	 * @see #getExternalFault()
	 * @generated
	 */
	EReference getExternalFault_FromPort();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ExternalFault#getPropagationCondition <em>Propagation Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Propagation Condition</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ExternalFault#getPropagationCondition()
	 * @see #getExternalFault()
	 * @generated
	 */
	EAttribute getExternalFault_PropagationCondition();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ExternalFault#getProbability <em>Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Probability</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ExternalFault#getProbability()
	 * @see #getExternalFault()
	 * @generated
	 */
	EAttribute getExternalFault_Probability();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ExternalFault#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unit</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ExternalFault#getUnit()
	 * @see #getExternalFault()
	 * @generated
	 */
	EAttribute getExternalFault_Unit();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ExternalFault#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ExternalFault#getType()
	 * @see #getExternalFault()
	 * @generated
	 */
	EAttribute getExternalFault_Type();

	/**
	 * Returns the meta object for the attribute list '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ExternalFault#getTransfFunct <em>Transf Funct</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Transf Funct</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ExternalFault#getTransfFunct()
	 * @see #getExternalFault()
	 * @generated
	 */
	EAttribute getExternalFault_TransfFunct();

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
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.FailureFree <em>Failure Free</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Failure Free</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.FailureFree
	 * @generated
	 */
	EClass getFailureFree();

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
		 * The meta object literal for the '<em><b>Base Transition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERNAL_FAULT__BASE_TRANSITION = eINSTANCE.getInternalFault_Base_Transition();

		/**
		 * The meta object literal for the '<em><b>Permanent Prob</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERNAL_FAULT__PERMANENT_PROB = eINSTANCE.getInternalFault_PermanentProb();

		/**
		 * The meta object literal for the '<em><b>Transf Funct</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERNAL_FAULT__TRANSF_FUNCT = eINSTANCE.getInternalFault_TransfFunct();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERNAL_FAULT__PROPERTY = eINSTANCE.getInternalFault_Property();

		/**
		 * The meta object literal for the '<em><b>Child Failure</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERNAL_FAULT__CHILD_FAILURE = eINSTANCE.getInternalFault_ChildFailure();

		/**
		 * The meta object literal for the '<em><b>Occurrence</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERNAL_FAULT__OCCURRENCE = eINSTANCE.getInternalFault_Occurrence();

		/**
		 * The meta object literal for the '<em><b>Transient Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERNAL_FAULT__TRANSIENT_DURATION = eINSTANCE.getInternalFault_TransientDuration();

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
		 * The meta object literal for the '<em><b>Base Transition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTERNAL_FAULT__BASE_TRANSITION = eINSTANCE.getExternalFault_Base_Transition();

		/**
		 * The meta object literal for the '<em><b>From Port</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTERNAL_FAULT__FROM_PORT = eINSTANCE.getExternalFault_FromPort();

		/**
		 * The meta object literal for the '<em><b>Propagation Condition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTERNAL_FAULT__PROPAGATION_CONDITION = eINSTANCE.getExternalFault_PropagationCondition();

		/**
		 * The meta object literal for the '<em><b>Probability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTERNAL_FAULT__PROBABILITY = eINSTANCE.getExternalFault_Probability();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTERNAL_FAULT__UNIT = eINSTANCE.getExternalFault_Unit();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTERNAL_FAULT__TYPE = eINSTANCE.getExternalFault_Type();

		/**
		 * The meta object literal for the '<em><b>Transf Funct</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTERNAL_FAULT__TRANSF_FUNCT = eINSTANCE.getExternalFault_TransfFunct();

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
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.FailureFreeImpl <em>Failure Free</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.FailureFreeImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl#getFailureFree()
		 * @generated
		 */
		EClass FAILURE_FREE = eINSTANCE.getFailureFree();

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

	}

} //ThreatsPropagationPackage
