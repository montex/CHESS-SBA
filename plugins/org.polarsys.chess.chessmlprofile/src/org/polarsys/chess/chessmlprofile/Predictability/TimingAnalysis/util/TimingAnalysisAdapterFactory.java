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
package org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaAnalysisContext;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaLatencyObs;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaTimedObs;
import org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.Variables.ExpressionContext;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.Configuration;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.NfpConstraint;
import org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingAnalysisPackage
 * @generated
 */
public class TimingAnalysisAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static TimingAnalysisPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimingAnalysisAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = TimingAnalysisPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TimingAnalysisSwitch<Adapter> modelSwitch =
		new TimingAnalysisSwitch<Adapter>() {
			@Override
			public Adapter caseSimulationBasedTimingAnalysis(SimulationBasedTimingAnalysis object) {
				return createSimulationBasedTimingAnalysisAdapter();
			}
			@Override
			public Adapter caseAgeTimingConstraint(AgeTimingConstraint object) {
				return createAgeTimingConstraintAdapter();
			}
			@Override
			public Adapter caseReactionConstraint(ReactionConstraint object) {
				return createReactionConstraintAdapter();
			}
			@Override
			public Adapter caseOutputSynchronizationConstraint(OutputSynchronizationConstraint object) {
				return createOutputSynchronizationConstraintAdapter();
			}
			@Override
			public Adapter caseInputSynchronizationConstraint(InputSynchronizationConstraint object) {
				return createInputSynchronizationConstraintAdapter();
			}
			@Override
			public Adapter caseConfiguration(Configuration object) {
				return createConfigurationAdapter();
			}
			@Override
			public Adapter caseExpressionContext(ExpressionContext object) {
				return createExpressionContextAdapter();
			}
			@Override
			public Adapter caseGaAnalysisContext(GaAnalysisContext object) {
				return createGaAnalysisContextAdapter();
			}
			@Override
			public Adapter caseNfpConstraint(NfpConstraint object) {
				return createNfpConstraintAdapter();
			}
			@Override
			public Adapter caseGaTimedObs(GaTimedObs object) {
				return createGaTimedObsAdapter();
			}
			@Override
			public Adapter caseGaLatencyObs(GaLatencyObs object) {
				return createGaLatencyObsAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.SimulationBasedTimingAnalysis <em>Simulation Based Timing Analysis</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.SimulationBasedTimingAnalysis
	 * @generated
	 */
	public Adapter createSimulationBasedTimingAnalysisAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.AgeTimingConstraint <em>Age Timing Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.AgeTimingConstraint
	 * @generated
	 */
	public Adapter createAgeTimingConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.ReactionConstraint <em>Reaction Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.ReactionConstraint
	 * @generated
	 */
	public Adapter createReactionConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.OutputSynchronizationConstraint <em>Output Synchronization Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.OutputSynchronizationConstraint
	 * @generated
	 */
	public Adapter createOutputSynchronizationConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.InputSynchronizationConstraint <em>Input Synchronization Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.InputSynchronizationConstraint
	 * @generated
	 */
	public Adapter createInputSynchronizationConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.Configuration
	 * @generated
	 */
	public Adapter createConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.Variables.ExpressionContext <em>Expression Context</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.Variables.ExpressionContext
	 * @generated
	 */
	public Adapter createExpressionContextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaAnalysisContext <em>Ga Analysis Context</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaAnalysisContext
	 * @generated
	 */
	public Adapter createGaAnalysisContextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.NfpConstraint <em>Nfp Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.NfpConstraint
	 * @generated
	 */
	public Adapter createNfpConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaTimedObs <em>Ga Timed Obs</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaTimedObs
	 * @generated
	 */
	public Adapter createGaTimedObsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaLatencyObs <em>Ga Latency Obs</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaLatencyObs
	 * @generated
	 */
	public Adapter createGaLatencyObsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //TimingAnalysisAdapterFactory
