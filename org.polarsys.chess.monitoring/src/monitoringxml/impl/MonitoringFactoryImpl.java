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
package monitoringxml.impl;

import monitoringxml.AnalysisContext;
import monitoringxml.BlockingTime;
import monitoringxml.ExecutionTime;
import monitoringxml.Monitoring;
import monitoringxml.MonitoringFactory;
import monitoringxml.MonitoringPackage;
import monitoringxml.Period;
import monitoringxml.Resource;
import monitoringxml.ResponseTime;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MonitoringFactoryImpl extends EFactoryImpl implements MonitoringFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MonitoringFactory init() {
		try {
			MonitoringFactory theMonitoringFactory = (MonitoringFactory)EPackage.Registry.INSTANCE.getEFactory(MonitoringPackage.eNS_URI);
			if (theMonitoringFactory != null) {
				return theMonitoringFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MonitoringFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MonitoringFactoryImpl() {
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
			case MonitoringPackage.MONITORING: return createMonitoring();
			case MonitoringPackage.THREAD: return createThread();
			case MonitoringPackage.RESOURCE: return createResource();
			case MonitoringPackage.PERIOD: return createPeriod();
			case MonitoringPackage.EXECUTION_TIME: return createExecutionTime();
			case MonitoringPackage.BLOCKING_TIME: return createBlockingTime();
			case MonitoringPackage.RESPONSE_TIME: return createResponseTime();
			case MonitoringPackage.ANALYSIS_CONTEXT: return createAnalysisContext();
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
	public monitoringxml.Thread createThread() {
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
	public MonitoringPackage getMonitoringPackage() {
		return (MonitoringPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MonitoringPackage getPackage() {
		return MonitoringPackage.eINSTANCE;
	}

} //MonitoringFactoryImpl
