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
package org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.DurationType;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ErrorFree;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ErrorModel;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ExternalFault;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.FailureFree;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.FailureMode;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalFault;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Inverted;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.RampDown;
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
			case ThreatsPropagationPackage.INTERNAL_FAULT: return createInternalFault();
			case ThreatsPropagationPackage.EXTERNAL_FAULT: return createExternalFault();
			case ThreatsPropagationPackage.ERROR: return createError();
			case ThreatsPropagationPackage.THREAT_STATE: return createThreatState();
			case ThreatsPropagationPackage.ERROR_FREE: return createErrorFree();
			case ThreatsPropagationPackage.UNCLASSIFIED_ERROR: return createUnclassifiedError();
			case ThreatsPropagationPackage.FAILURE_MODE: return createFailureMode();
			case ThreatsPropagationPackage.FAILURE_FREE: return createFailureFree();
			case ThreatsPropagationPackage.UNCLASSIFIED_FAILURE: return createUnclassifiedFailure();
			case ThreatsPropagationPackage.STUCK_AT: return createStuckAt();
			case ThreatsPropagationPackage.STUCK_AT_FIXED: return createStuckAtFixed();
			case ThreatsPropagationPackage.INVERTED: return createInverted();
			case ThreatsPropagationPackage.RAMP_DOWN: return createRampDown();
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
	public ExternalFault createExternalFault() {
		ExternalFaultImpl externalFault = new ExternalFaultImpl();
		return externalFault;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Error createError() {
		ErrorImpl error = new ErrorImpl();
		return error;
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
	public FailureFree createFailureFree() {
		FailureFreeImpl failureFree = new FailureFreeImpl();
		return failureFree;
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
	public ErrorModel createErrorModel() {
		ErrorModelImpl errorModel = new ErrorModelImpl();
		return errorModel;
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
