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
package org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TimingAnalysisFactoryImpl extends EFactoryImpl implements TimingAnalysisFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TimingAnalysisFactory init() {
		try {
			TimingAnalysisFactory theTimingAnalysisFactory = (TimingAnalysisFactory)EPackage.Registry.INSTANCE.getEFactory(TimingAnalysisPackage.eNS_URI);
			if (theTimingAnalysisFactory != null) {
				return theTimingAnalysisFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TimingAnalysisFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimingAnalysisFactoryImpl() {
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
			case TimingAnalysisPackage.SIMULATION_BASED_TIMING_ANALYSIS: return createSimulationBasedTimingAnalysis();
			case TimingAnalysisPackage.AGE_TIMING_CONSTRAINT: return createAgeTimingConstraint();
			case TimingAnalysisPackage.REACTION_CONSTRAINT: return createReactionConstraint();
			case TimingAnalysisPackage.OUTPUT_SYNCHRONIZATION_CONSTRAINT: return createOutputSynchronizationConstraint();
			case TimingAnalysisPackage.INPUT_SYNCHRONIZATION_CONSTRAINT: return createInputSynchronizationConstraint();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimulationBasedTimingAnalysis createSimulationBasedTimingAnalysis() {
		SimulationBasedTimingAnalysisImpl simulationBasedTimingAnalysis = new SimulationBasedTimingAnalysisImpl();
		return simulationBasedTimingAnalysis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AgeTimingConstraint createAgeTimingConstraint() {
		AgeTimingConstraintImpl ageTimingConstraint = new AgeTimingConstraintImpl();
		return ageTimingConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReactionConstraint createReactionConstraint() {
		ReactionConstraintImpl reactionConstraint = new ReactionConstraintImpl();
		return reactionConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputSynchronizationConstraint createOutputSynchronizationConstraint() {
		OutputSynchronizationConstraintImpl outputSynchronizationConstraint = new OutputSynchronizationConstraintImpl();
		return outputSynchronizationConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputSynchronizationConstraint createInputSynchronizationConstraint() {
		InputSynchronizationConstraintImpl inputSynchronizationConstraint = new InputSynchronizationConstraintImpl();
		return inputSynchronizationConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimingAnalysisPackage getTimingAnalysisPackage() {
		return (TimingAnalysisPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TimingAnalysisPackage getPackage() {
		return TimingAnalysisPackage.eINSTANCE;
	}

} //TimingAnalysisFactoryImpl
