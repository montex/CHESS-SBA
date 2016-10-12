/*
-----------------------------------------------------------------------
--                    CHESS monitoring plugin                        --
--                                                                   --
--                    Copyright (C) 2015-2016                        --
--                 University of Padova, ITALY                       --
--                                                                   --
-- Author: Alessandro Zovi azovi@math.unipd.it                       --
--                                                                   --
-- All rights reserved. This program and the accompanying materials  --
-- are made available under the terms of the Eclipse Public License  --
-- v1.0 which accompanies this distribution, and is available at     --
-- http://www.eclipse.org/legal/epl-v10.html                         --
-----------------------------------------------------------------------
  */ 
package org.polarsys.chess.monitoring.monitoringxml.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.polarsys.chess.monitoring.monitoringxml.AnalysisContext;
import org.polarsys.chess.monitoring.monitoringxml.BlockingTime;
import org.polarsys.chess.monitoring.monitoringxml.ExecutionTime;
import org.polarsys.chess.monitoring.monitoringxml.MeasuredValue;
import org.polarsys.chess.monitoring.monitoringxml.Monitoring;
import org.polarsys.chess.monitoring.monitoringxml.MonitoringxmlFactory;
import org.polarsys.chess.monitoring.monitoringxml.MonitoringxmlPackage;
import org.polarsys.chess.monitoring.monitoringxml.Period;
import org.polarsys.chess.monitoring.monitoringxml.Resource;
import org.polarsys.chess.monitoring.monitoringxml.ResponseTime;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MonitoringxmlFactoryImpl extends EFactoryImpl implements MonitoringxmlFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MonitoringxmlFactory init() {
		try {
			MonitoringxmlFactory theMonitoringxmlFactory = (MonitoringxmlFactory)EPackage.Registry.INSTANCE.getEFactory(MonitoringxmlPackage.eNS_URI);
			if (theMonitoringxmlFactory != null) {
				return theMonitoringxmlFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MonitoringxmlFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MonitoringxmlFactoryImpl() {
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
			case MonitoringxmlPackage.MONITORING: return createMonitoring();
			case MonitoringxmlPackage.THREAD: return createThread();
			case MonitoringxmlPackage.RESOURCE: return createResource();
			case MonitoringxmlPackage.PERIOD: return createPeriod();
			case MonitoringxmlPackage.EXECUTION_TIME: return createExecutionTime();
			case MonitoringxmlPackage.BLOCKING_TIME: return createBlockingTime();
			case MonitoringxmlPackage.RESPONSE_TIME: return createResponseTime();
			case MonitoringxmlPackage.ANALYSIS_CONTEXT: return createAnalysisContext();
			case MonitoringxmlPackage.MEASURED_VALUE: return createMeasuredValue();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Monitoring createMonitoring() {
		MonitoringImpl monitoring = new MonitoringImpl();
		return monitoring;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.polarsys.chess.monitoring.monitoringxml.Thread createThread() {
		ThreadImpl thread = new ThreadImpl();
		return thread;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource createResource() {
		ResourceImpl resource = new ResourceImpl();
		return resource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Period createPeriod() {
		PeriodImpl period = new PeriodImpl();
		return period;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionTime createExecutionTime() {
		ExecutionTimeImpl executionTime = new ExecutionTimeImpl();
		return executionTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlockingTime createBlockingTime() {
		BlockingTimeImpl blockingTime = new BlockingTimeImpl();
		return blockingTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResponseTime createResponseTime() {
		ResponseTimeImpl responseTime = new ResponseTimeImpl();
		return responseTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnalysisContext createAnalysisContext() {
		AnalysisContextImpl analysisContext = new AnalysisContextImpl();
		return analysisContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeasuredValue createMeasuredValue() {
		MeasuredValueImpl measuredValue = new MeasuredValueImpl();
		return measuredValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MonitoringxmlPackage getMonitoringxmlPackage() {
		return (MonitoringxmlPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MonitoringxmlPackage getPackage() {
		return MonitoringxmlPackage.eINSTANCE;
	}

} //MonitoringxmlFactoryImpl
