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
package org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StateBasedDataTypesFactoryImpl extends EFactoryImpl implements StateBasedDataTypesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static StateBasedDataTypesFactory init() {
		try {
			StateBasedDataTypesFactory theStateBasedDataTypesFactory = (StateBasedDataTypesFactory)EPackage.Registry.INSTANCE.getEFactory(StateBasedDataTypesPackage.eNS_URI);
			if (theStateBasedDataTypesFactory != null) {
				return theStateBasedDataTypesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new StateBasedDataTypesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateBasedDataTypesFactoryImpl() {
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
			case StateBasedDataTypesPackage.DEPENDABILITY_MEASURE: return createDependabilityMeasure();
			case StateBasedDataTypesPackage.EVALUATION_METHOD: return createEvaluationMethod();
			case StateBasedDataTypesPackage.EVALUATION_BY_SIMULATION: return createEvaluationBySimulation();
			case StateBasedDataTypesPackage.EVALUATION_ANALYTICAL: return createEvaluationAnalytical();
			case StateBasedDataTypesPackage.RELIABILITY: return createReliability();
			case StateBasedDataTypesPackage.EVALUATION_TYPE: return createEvaluationType();
			case StateBasedDataTypesPackage.STEADY_STATE: return createSteadyState();
			case StateBasedDataTypesPackage.AVAILABILITY: return createAvailability();
			case StateBasedDataTypesPackage.MTTF: return createMTTF();
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
			case StateBasedDataTypesPackage.REDUNDANCY_KIND:
				return createRedundancyKindFromString(eDataType, initialValue);
			case StateBasedDataTypesPackage.CONFIDENCE_KIND:
				return createConfidenceKindFromString(eDataType, initialValue);
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
			case StateBasedDataTypesPackage.REDUNDANCY_KIND:
				return convertRedundancyKindToString(eDataType, instanceValue);
			case StateBasedDataTypesPackage.CONFIDENCE_KIND:
				return convertConfidenceKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependabilityMeasure createDependabilityMeasure() {
		DependabilityMeasureImpl dependabilityMeasure = new DependabilityMeasureImpl();
		return dependabilityMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EvaluationMethod createEvaluationMethod() {
		EvaluationMethodImpl evaluationMethod = new EvaluationMethodImpl();
		return evaluationMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EvaluationBySimulation createEvaluationBySimulation() {
		EvaluationBySimulationImpl evaluationBySimulation = new EvaluationBySimulationImpl();
		return evaluationBySimulation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EvaluationAnalytical createEvaluationAnalytical() {
		EvaluationAnalyticalImpl evaluationAnalytical = new EvaluationAnalyticalImpl();
		return evaluationAnalytical;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reliability createReliability() {
		ReliabilityImpl reliability = new ReliabilityImpl();
		return reliability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EvaluationType createEvaluationType() {
		EvaluationTypeImpl evaluationType = new EvaluationTypeImpl();
		return evaluationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SteadyState createSteadyState() {
		SteadyStateImpl steadyState = new SteadyStateImpl();
		return steadyState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Availability createAvailability() {
		AvailabilityImpl availability = new AvailabilityImpl();
		return availability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MTTF createMTTF() {
		MTTFImpl mttf = new MTTFImpl();
		return mttf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RedundancyKind createRedundancyKindFromString(EDataType eDataType, String initialValue) {
		RedundancyKind result = RedundancyKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRedundancyKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfidenceKind createConfidenceKindFromString(EDataType eDataType, String initialValue) {
		ConfidenceKind result = ConfidenceKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertConfidenceKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateBasedDataTypesPackage getStateBasedDataTypesPackage() {
		return (StateBasedDataTypesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static StateBasedDataTypesPackage getPackage() {
		return StateBasedDataTypesPackage.eINSTANCE;
	}

} //StateBasedDataTypesFactoryImpl
