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
package org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DeploymentConfAnalysisFactoryImpl extends EFactoryImpl implements DeploymentConfAnalysisFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DeploymentConfAnalysisFactory init() {
		try {
			DeploymentConfAnalysisFactory theDeploymentConfAnalysisFactory = (DeploymentConfAnalysisFactory)EPackage.Registry.INSTANCE.getEFactory(DeploymentConfAnalysisPackage.eNS_URI);
			if (theDeploymentConfAnalysisFactory != null) {
				return theDeploymentConfAnalysisFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DeploymentConfAnalysisFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeploymentConfAnalysisFactoryImpl() {
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
			case DeploymentConfAnalysisPackage.MAPPING_CONFIGURATION_ANALYSIS: return createMappingConfigurationAnalysis();
			case DeploymentConfAnalysisPackage.SCHEDULING_ANALYSIS: return createSchedulingAnalysis();
			case DeploymentConfAnalysisPackage.BUS_CONFIGURATION_ANALYSIS: return createBusConfigurationAnalysis();
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
			case DeploymentConfAnalysisPackage.OPTIMIZATION_GOAL:
				return createOptimizationGoalFromString(eDataType, initialValue);
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
			case DeploymentConfAnalysisPackage.OPTIMIZATION_GOAL:
				return convertOptimizationGoalToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingConfigurationAnalysis createMappingConfigurationAnalysis() {
		MappingConfigurationAnalysisImpl mappingConfigurationAnalysis = new MappingConfigurationAnalysisImpl();
		return mappingConfigurationAnalysis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulingAnalysis createSchedulingAnalysis() {
		SchedulingAnalysisImpl schedulingAnalysis = new SchedulingAnalysisImpl();
		return schedulingAnalysis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusConfigurationAnalysis createBusConfigurationAnalysis() {
		BusConfigurationAnalysisImpl busConfigurationAnalysis = new BusConfigurationAnalysisImpl();
		return busConfigurationAnalysis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OptimizationGoal createOptimizationGoalFromString(EDataType eDataType, String initialValue) {
		OptimizationGoal result = OptimizationGoal.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOptimizationGoalToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeploymentConfAnalysisPackage getDeploymentConfAnalysisPackage() {
		return (DeploymentConfAnalysisPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DeploymentConfAnalysisPackage getPackage() {
		return DeploymentConfAnalysisPackage.eINSTANCE;
	}

} //DeploymentConfAnalysisFactoryImpl
