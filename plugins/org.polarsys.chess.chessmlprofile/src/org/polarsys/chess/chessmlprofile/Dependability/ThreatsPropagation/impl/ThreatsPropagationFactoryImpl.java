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
package org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.*;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.CHExternalFault;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.CHInternalFault;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.DegradedState;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.DepEvent;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.DurationType;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ErrorFree;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ErrorModel;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ExternalFault;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Failure;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.FailureFree;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.FailureMode;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalEvent;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalFault;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalPropagation;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalThreat;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Inverted;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.NormalEvent;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.NormalInput;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.NormalOutput;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.RampDown;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.RecoveryEvent;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.RecoveryKind;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.StuckAt;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.StuckAtFixed;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatState;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatsPropagationFactory;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatsPropagationPackage;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.UnclassifiedError;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.UnclassifiedFailure;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ThreatsPropagationFactoryImpl extends EFactoryImpl implements ThreatsPropagationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ThreatsPropagationFactory init() {
		try {
			ThreatsPropagationFactory theThreatsPropagationFactory = (ThreatsPropagationFactory)EPackage.Registry.INSTANCE.getEFactory(ThreatsPropagationPackage.eNS_URI);
			if (theThreatsPropagationFactory != null) {
				return theThreatsPropagationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ThreatsPropagationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThreatsPropagationFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ThreatsPropagationPackage.UNCLASSIFIED_FAILURE: return createUnclassifiedFailure();
			case ThreatsPropagationPackage.THREAT_STATE: return createThreatState();
			case ThreatsPropagationPackage.FAILURE_MODE: return createFailureMode();
			case ThreatsPropagationPackage.ERROR_FREE: return createErrorFree();
			case ThreatsPropagationPackage.DEGRADED_STATE: return createDegradedState();
			case ThreatsPropagationPackage.NORMAL_STATE: return createNormalState();
			case ThreatsPropagationPackage.UNCLASSIFIED_ERROR: return createUnclassifiedError();
			case ThreatsPropagationPackage.FAILURE_FREE: return createFailureFree();
			case ThreatsPropagationPackage.CH_INTERNAL_FAULT: return createCHInternalFault();
			case ThreatsPropagationPackage.CH_EXTERNAL_FAULT: return createCHExternalFault();
			case ThreatsPropagationPackage.ERROR_STATE: return createErrorState();
			case ThreatsPropagationPackage.EXTERNAL_FAULT: return createExternalFault();
			case ThreatsPropagationPackage.INTERNAL_EVENT: return createInternalEvent();
			case ThreatsPropagationPackage.NORMAL_EVENT: return createNormalEvent();
			case ThreatsPropagationPackage.RECOVERY_EVENT: return createRecoveryEvent();
			case ThreatsPropagationPackage.INTERNAL_THREAT: return createInternalThreat();
			case ThreatsPropagationPackage.STUCK_AT: return createStuckAt();
			case ThreatsPropagationPackage.STUCK_AT_FIXED: return createStuckAtFixed();
			case ThreatsPropagationPackage.INVERTED: return createInverted();
			case ThreatsPropagationPackage.RAMP_DOWN: return createRampDown();
			case ThreatsPropagationPackage.NORMAL_INPUT: return createNormalInput();
			case ThreatsPropagationPackage.NORMAL_OUTPUT: return createNormalOutput();
			case ThreatsPropagationPackage.FAILURE: return createFailure();
			case ThreatsPropagationPackage.INTERNAL_FAULT: return createInternalFault();
			case ThreatsPropagationPackage.INTERNAL_PROPAGATION: return createInternalPropagation();
			case ThreatsPropagationPackage.ERROR_DETECTION: return createErrorDetection();
			case ThreatsPropagationPackage.ERROR_HANDLING: return createErrorHandling();
			case ThreatsPropagationPackage.FAULT_HANDLING: return createFaultHandling();
			case ThreatsPropagationPackage.ERROR_MODEL: return createErrorModel();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ThreatsPropagationPackage.DURATION_TYPE:
				return createDurationTypeFromString(eDataType, initialValue);
			case ThreatsPropagationPackage.RECOVERY_KIND:
				return createRecoveryKindFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ThreatsPropagationPackage.DURATION_TYPE:
				return convertDurationTypeToString(eDataType, instanceValue);
			case ThreatsPropagationPackage.RECOVERY_KIND:
				return convertRecoveryKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InternalFault createInternalFault() {
		InternalFaultImpl internalFault = new InternalFaultImpl();
		return internalFault;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InternalPropagation createInternalPropagation() {
		InternalPropagationImpl internalPropagation = new InternalPropagationImpl();
		return internalPropagation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ErrorDetection createErrorDetection() {
		ErrorDetectionImpl errorDetection = new ErrorDetectionImpl();
		return errorDetection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ErrorHandling createErrorHandling() {
		ErrorHandlingImpl errorHandling = new ErrorHandlingImpl();
		return errorHandling;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FaultHandling createFaultHandling() {
		FaultHandlingImpl faultHandling = new FaultHandlingImpl();
		return faultHandling;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ErrorModel createErrorModel() {
		ErrorModelImpl errorModel = new ErrorModelImpl();
		return errorModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalFault createExternalFault() {
		ExternalFaultImpl externalFault = new ExternalFaultImpl();
		return externalFault;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NormalInput createNormalInput() {
		NormalInputImpl normalInput = new NormalInputImpl();
		return normalInput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecoveryEvent createRecoveryEvent() {
		RecoveryEventImpl recoveryEvent = new RecoveryEventImpl();
		return recoveryEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NormalOutput createNormalOutput() {
		NormalOutputImpl normalOutput = new NormalOutputImpl();
		return normalOutput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Failure createFailure() {
		FailureImpl failure = new FailureImpl();
		return failure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NormalEvent createNormalEvent() {
		NormalEventImpl normalEvent = new NormalEventImpl();
		return normalEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InternalThreat createInternalThreat() {
		InternalThreatImpl internalThreat = new InternalThreatImpl();
		return internalThreat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThreatState createThreatState() {
		ThreatStateImpl threatState = new ThreatStateImpl();
		return threatState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ErrorFree createErrorFree() {
		ErrorFreeImpl errorFree = new ErrorFreeImpl();
		return errorFree;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnclassifiedError createUnclassifiedError() {
		UnclassifiedErrorImpl unclassifiedError = new UnclassifiedErrorImpl();
		return unclassifiedError;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FailureMode createFailureMode() {
		FailureModeImpl failureMode = new FailureModeImpl();
		return failureMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DegradedState createDegradedState() {
		DegradedStateImpl degradedState = new DegradedStateImpl();
		return degradedState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NormalState createNormalState() {
		NormalStateImpl normalState = new NormalStateImpl();
		return normalState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FailureFree createFailureFree() {
		FailureFreeImpl failureFree = new FailureFreeImpl();
		return failureFree;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CHInternalFault createCHInternalFault() {
		CHInternalFaultImpl chInternalFault = new CHInternalFaultImpl();
		return chInternalFault;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CHExternalFault createCHExternalFault() {
		CHExternalFaultImpl chExternalFault = new CHExternalFaultImpl();
		return chExternalFault;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ErrorState createErrorState() {
		ErrorStateImpl errorState = new ErrorStateImpl();
		return errorState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnclassifiedFailure createUnclassifiedFailure() {
		UnclassifiedFailureImpl unclassifiedFailure = new UnclassifiedFailureImpl();
		return unclassifiedFailure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StuckAt createStuckAt() {
		StuckAtImpl stuckAt = new StuckAtImpl();
		return stuckAt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StuckAtFixed createStuckAtFixed() {
		StuckAtFixedImpl stuckAtFixed = new StuckAtFixedImpl();
		return stuckAtFixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Inverted createInverted() {
		InvertedImpl inverted = new InvertedImpl();
		return inverted;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RampDown createRampDown() {
		RampDownImpl rampDown = new RampDownImpl();
		return rampDown;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InternalEvent createInternalEvent() {
		InternalEventImpl internalEvent = new InternalEventImpl();
		return internalEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DurationType createDurationTypeFromString(EDataType eDataType, String initialValue) {
		DurationType result = DurationType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDurationTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecoveryKind createRecoveryKindFromString(EDataType eDataType, String initialValue) {
		RecoveryKind result = RecoveryKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRecoveryKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThreatsPropagationPackage getThreatsPropagationPackage() {
		return (ThreatsPropagationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ThreatsPropagationPackage getPackage() {
		return ThreatsPropagationPackage.eINSTANCE;
	}

} //ThreatsPropagationFactoryImpl
