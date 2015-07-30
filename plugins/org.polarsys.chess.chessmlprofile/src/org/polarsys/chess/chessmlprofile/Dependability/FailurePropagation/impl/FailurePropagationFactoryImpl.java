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
package org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FailurePropagationFactoryImpl extends EFactoryImpl implements FailurePropagationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FailurePropagationFactory init() {
		try {
			FailurePropagationFactory theFailurePropagationFactory = (FailurePropagationFactory)EPackage.Registry.INSTANCE.getEFactory(FailurePropagationPackage.eNS_URI);
			if (theFailurePropagationFactory != null) {
				return theFailurePropagationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new FailurePropagationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FailurePropagationFactoryImpl() {
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
			case FailurePropagationPackage.FPTC: return createFPTC();
			case FailurePropagationPackage.FAILURE_PROPAGATION_ANALYSIS: return createFailurePropagationAnalysis();
			case FailurePropagationPackage.FPTC_SPECIFICATION: return createFPTCSpecification();
			case FailurePropagationPackage.FPTC_PORT_SLOT: return createFPTCPortSlot();
			case FailurePropagationPackage.FI4FA: return createFI4FA();
			case FailurePropagationPackage.FI4FA_SPECIFICATION: return createFI4FASpecification();
			case FailurePropagationPackage.ACID_AVOIDABLE: return createACIDAvoidable();
			case FailurePropagationPackage.ACID_MITIGATION: return createACIDMitigation();
			case FailurePropagationPackage.FI4FA_ANALYSIS: return createFI4FAAnalysis();
			case FailurePropagationPackage.FLA_SPECIFICATION: return createFLASpecification();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FPTC createFPTC() {
		FPTCImpl fptc = new FPTCImpl();
		return fptc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FailurePropagationAnalysis createFailurePropagationAnalysis() {
		FailurePropagationAnalysisImpl failurePropagationAnalysis = new FailurePropagationAnalysisImpl();
		return failurePropagationAnalysis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FPTCSpecification createFPTCSpecification() {
		FPTCSpecificationImpl fptcSpecification = new FPTCSpecificationImpl();
		return fptcSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FPTCPortSlot createFPTCPortSlot() {
		FPTCPortSlotImpl fptcPortSlot = new FPTCPortSlotImpl();
		return fptcPortSlot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FI4FA createFI4FA() {
		FI4FAImpl fi4FA = new FI4FAImpl();
		return fi4FA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FI4FASpecification createFI4FASpecification() {
		FI4FASpecificationImpl fi4FASpecification = new FI4FASpecificationImpl();
		return fi4FASpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ACIDAvoidable createACIDAvoidable() {
		ACIDAvoidableImpl acidAvoidable = new ACIDAvoidableImpl();
		return acidAvoidable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ACIDMitigation createACIDMitigation() {
		ACIDMitigationImpl acidMitigation = new ACIDMitigationImpl();
		return acidMitigation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FI4FAAnalysis createFI4FAAnalysis() {
		FI4FAAnalysisImpl fi4FAAnalysis = new FI4FAAnalysisImpl();
		return fi4FAAnalysis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FLASpecification createFLASpecification() {
		FLASpecificationImpl flaSpecification = new FLASpecificationImpl();
		return flaSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FailurePropagationPackage getFailurePropagationPackage() {
		return (FailurePropagationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static FailurePropagationPackage getPackage() {
		return FailurePropagationPackage.eINSTANCE;
	}

} //FailurePropagationFactoryImpl
