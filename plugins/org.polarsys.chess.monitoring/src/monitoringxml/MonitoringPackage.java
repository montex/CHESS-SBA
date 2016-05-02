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
package monitoringxml;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see monitoringxml.MonitoringFactory
 * @model kind="package"
 * @generated
 */
public interface MonitoringPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "monitoringxml";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.mdh.se/concerto/monitoring/xml/monitoringxml";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "monitoringxml";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MonitoringPackage eINSTANCE = monitoringxml.impl.MonitoringPackageImpl.init();

	/**
	 * The meta object id for the '{@link monitoringxml.impl.MonitoringImpl <em>Monitoring</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see monitoringxml.impl.MonitoringImpl
	 * @see monitoringxml.impl.MonitoringPackageImpl#getMonitoring()
	 * @generated
	 */
	int MONITORING = 0;

	/**
	 * The feature id for the '<em><b>Thread Names</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITORING__THREAD_NAMES = 0;

	/**
	 * The feature id for the '<em><b>Shared Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITORING__SHARED_RESOURCES = 1;

	/**
	 * The feature id for the '<em><b>Analysis Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITORING__ANALYSIS_CONTEXT = 2;

	/**
	 * The number of structural features of the '<em>Monitoring</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITORING_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Monitoring</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITORING_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link monitoringxml.impl.MonitoredResourceImpl <em>Monitored Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see monitoringxml.impl.MonitoredResourceImpl
	 * @see monitoringxml.impl.MonitoringPackageImpl#getMonitoredResource()
	 * @generated
	 */
	int MONITORED_RESOURCE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITORED_RESOURCE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Period</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITORED_RESOURCE__PERIOD = 1;

	/**
	 * The feature id for the '<em><b>Executiontime</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITORED_RESOURCE__EXECUTIONTIME = 2;

	/**
	 * The feature id for the '<em><b>Blockingtime</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITORED_RESOURCE__BLOCKINGTIME = 3;

	/**
	 * The feature id for the '<em><b>Responsetime</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITORED_RESOURCE__RESPONSETIME = 4;

	/**
	 * The number of structural features of the '<em>Monitored Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITORED_RESOURCE_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Monitored Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITORED_RESOURCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link monitoringxml.impl.ThreadImpl <em>Thread</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see monitoringxml.impl.ThreadImpl
	 * @see monitoringxml.impl.MonitoringPackageImpl#getThread()
	 * @generated
	 */
	int THREAD = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAD__NAME = MONITORED_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Period</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAD__PERIOD = MONITORED_RESOURCE__PERIOD;

	/**
	 * The feature id for the '<em><b>Executiontime</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAD__EXECUTIONTIME = MONITORED_RESOURCE__EXECUTIONTIME;

	/**
	 * The feature id for the '<em><b>Blockingtime</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAD__BLOCKINGTIME = MONITORED_RESOURCE__BLOCKINGTIME;

	/**
	 * The feature id for the '<em><b>Responsetime</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAD__RESPONSETIME = MONITORED_RESOURCE__RESPONSETIME;

	/**
	 * The number of structural features of the '<em>Thread</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAD_FEATURE_COUNT = MONITORED_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Thread</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAD_OPERATION_COUNT = MONITORED_RESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link monitoringxml.impl.ResourceImpl <em>Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see monitoringxml.impl.ResourceImpl
	 * @see monitoringxml.impl.MonitoringPackageImpl#getResource()
	 * @generated
	 */
	int RESOURCE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__NAME = MONITORED_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Period</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__PERIOD = MONITORED_RESOURCE__PERIOD;

	/**
	 * The feature id for the '<em><b>Executiontime</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__EXECUTIONTIME = MONITORED_RESOURCE__EXECUTIONTIME;

	/**
	 * The feature id for the '<em><b>Blockingtime</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__BLOCKINGTIME = MONITORED_RESOURCE__BLOCKINGTIME;

	/**
	 * The feature id for the '<em><b>Responsetime</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__RESPONSETIME = MONITORED_RESOURCE__RESPONSETIME;

	/**
	 * The number of structural features of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_FEATURE_COUNT = MONITORED_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_OPERATION_COUNT = MONITORED_RESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link monitoringxml.impl.PeriodImpl <em>Period</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see monitoringxml.impl.PeriodImpl
	 * @see monitoringxml.impl.MonitoringPackageImpl#getPeriod()
	 * @generated
	 */
	int PERIOD = 3;

	/**
	 * The feature id for the '<em><b>Minimum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIOD__MINIMUM = 0;

	/**
	 * The feature id for the '<em><b>Maximum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIOD__MAXIMUM = 1;

	/**
	 * The feature id for the '<em><b>Jitter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIOD__JITTER = 2;

	/**
	 * The feature id for the '<em><b>Monitoredresource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIOD__MONITOREDRESOURCE = 3;

	/**
	 * The number of structural features of the '<em>Period</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIOD_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Period</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIOD_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link monitoringxml.impl.ExecutionTimeImpl <em>Execution Time</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see monitoringxml.impl.ExecutionTimeImpl
	 * @see monitoringxml.impl.MonitoringPackageImpl#getExecutionTime()
	 * @generated
	 */
	int EXECUTION_TIME = 5;

	/**
	 * The feature id for the '<em><b>Minimum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_TIME__MINIMUM = 0;

	/**
	 * The feature id for the '<em><b>Maximum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_TIME__MAXIMUM = 1;

	/**
	 * The feature id for the '<em><b>Monitoredresource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_TIME__MONITOREDRESOURCE = 2;

	/**
	 * The number of structural features of the '<em>Execution Time</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_TIME_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Execution Time</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_TIME_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link monitoringxml.impl.BlockingTimeImpl <em>Blocking Time</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see monitoringxml.impl.BlockingTimeImpl
	 * @see monitoringxml.impl.MonitoringPackageImpl#getBlockingTime()
	 * @generated
	 */
	int BLOCKING_TIME = 6;

	/**
	 * The feature id for the '<em><b>Maximum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCKING_TIME__MAXIMUM = 0;

	/**
	 * The feature id for the '<em><b>Monitoredresource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCKING_TIME__MONITOREDRESOURCE = 1;

	/**
	 * The number of structural features of the '<em>Blocking Time</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCKING_TIME_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Blocking Time</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCKING_TIME_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link monitoringxml.impl.ResponseTimeImpl <em>Response Time</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see monitoringxml.impl.ResponseTimeImpl
	 * @see monitoringxml.impl.MonitoringPackageImpl#getResponseTime()
	 * @generated
	 */
	int RESPONSE_TIME = 7;

	/**
	 * The feature id for the '<em><b>Maximum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE_TIME__MAXIMUM = 0;

	/**
	 * The feature id for the '<em><b>Jitter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE_TIME__JITTER = 1;

	/**
	 * The feature id for the '<em><b>Monitoredresource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE_TIME__MONITOREDRESOURCE = 2;

	/**
	 * The number of structural features of the '<em>Response Time</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE_TIME_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Response Time</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE_TIME_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link monitoringxml.impl.AnalysisContextImpl <em>Analysis Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see monitoringxml.impl.AnalysisContextImpl
	 * @see monitoringxml.impl.MonitoringPackageImpl#getAnalysisContext()
	 * @generated
	 */
	int ANALYSIS_CONTEXT = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_CONTEXT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Analysis Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_CONTEXT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Analysis Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_CONTEXT_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link monitoringxml.Monitoring <em>Monitoring</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Monitoring</em>'.
	 * @see monitoringxml.Monitoring
	 * @generated
	 */
	EClass getMonitoring();

	/**
	 * Returns the meta object for the containment reference list '{@link monitoringxml.Monitoring#getThreadNames <em>Thread Names</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Thread Names</em>'.
	 * @see monitoringxml.Monitoring#getThreadNames()
	 * @see #getMonitoring()
	 * @generated
	 */
	EReference getMonitoring_ThreadNames();

	/**
	 * Returns the meta object for the containment reference list '{@link monitoringxml.Monitoring#getSharedResources <em>Shared Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Shared Resources</em>'.
	 * @see monitoringxml.Monitoring#getSharedResources()
	 * @see #getMonitoring()
	 * @generated
	 */
	EReference getMonitoring_SharedResources();

	/**
	 * Returns the meta object for the containment reference '{@link monitoringxml.Monitoring#getAnalysisContext <em>Analysis Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Analysis Context</em>'.
	 * @see monitoringxml.Monitoring#getAnalysisContext()
	 * @see #getMonitoring()
	 * @generated
	 */
	EReference getMonitoring_AnalysisContext();

	/**
	 * Returns the meta object for class '{@link monitoringxml.Thread <em>Thread</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Thread</em>'.
	 * @see monitoringxml.Thread
	 * @generated
	 */
	EClass getThread();

	/**
	 * Returns the meta object for class '{@link monitoringxml.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource</em>'.
	 * @see monitoringxml.Resource
	 * @generated
	 */
	EClass getResource();

	/**
	 * Returns the meta object for class '{@link monitoringxml.Period <em>Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Period</em>'.
	 * @see monitoringxml.Period
	 * @generated
	 */
	EClass getPeriod();

	/**
	 * Returns the meta object for the attribute '{@link monitoringxml.Period#getMinimum <em>Minimum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minimum</em>'.
	 * @see monitoringxml.Period#getMinimum()
	 * @see #getPeriod()
	 * @generated
	 */
	EAttribute getPeriod_Minimum();

	/**
	 * Returns the meta object for the attribute '{@link monitoringxml.Period#getMaximum <em>Maximum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum</em>'.
	 * @see monitoringxml.Period#getMaximum()
	 * @see #getPeriod()
	 * @generated
	 */
	EAttribute getPeriod_Maximum();

	/**
	 * Returns the meta object for the attribute '{@link monitoringxml.Period#getJitter <em>Jitter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Jitter</em>'.
	 * @see monitoringxml.Period#getJitter()
	 * @see #getPeriod()
	 * @generated
	 */
	EAttribute getPeriod_Jitter();

	/**
	 * Returns the meta object for the reference '{@link monitoringxml.Period#getMonitoredresource <em>Monitoredresource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Monitoredresource</em>'.
	 * @see monitoringxml.Period#getMonitoredresource()
	 * @see #getPeriod()
	 * @generated
	 */
	EReference getPeriod_Monitoredresource();

	/**
	 * Returns the meta object for class '{@link monitoringxml.MonitoredResource <em>Monitored Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Monitored Resource</em>'.
	 * @see monitoringxml.MonitoredResource
	 * @generated
	 */
	EClass getMonitoredResource();

	/**
	 * Returns the meta object for the attribute '{@link monitoringxml.MonitoredResource#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see monitoringxml.MonitoredResource#getName()
	 * @see #getMonitoredResource()
	 * @generated
	 */
	EAttribute getMonitoredResource_Name();

	/**
	 * Returns the meta object for the reference '{@link monitoringxml.MonitoredResource#getPeriod <em>Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Period</em>'.
	 * @see monitoringxml.MonitoredResource#getPeriod()
	 * @see #getMonitoredResource()
	 * @generated
	 */
	EReference getMonitoredResource_Period();

	/**
	 * Returns the meta object for the reference '{@link monitoringxml.MonitoredResource#getExecutiontime <em>Executiontime</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Executiontime</em>'.
	 * @see monitoringxml.MonitoredResource#getExecutiontime()
	 * @see #getMonitoredResource()
	 * @generated
	 */
	EReference getMonitoredResource_Executiontime();

	/**
	 * Returns the meta object for the reference '{@link monitoringxml.MonitoredResource#getBlockingtime <em>Blockingtime</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Blockingtime</em>'.
	 * @see monitoringxml.MonitoredResource#getBlockingtime()
	 * @see #getMonitoredResource()
	 * @generated
	 */
	EReference getMonitoredResource_Blockingtime();

	/**
	 * Returns the meta object for the reference '{@link monitoringxml.MonitoredResource#getResponsetime <em>Responsetime</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Responsetime</em>'.
	 * @see monitoringxml.MonitoredResource#getResponsetime()
	 * @see #getMonitoredResource()
	 * @generated
	 */
	EReference getMonitoredResource_Responsetime();

	/**
	 * Returns the meta object for class '{@link monitoringxml.ExecutionTime <em>Execution Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execution Time</em>'.
	 * @see monitoringxml.ExecutionTime
	 * @generated
	 */
	EClass getExecutionTime();

	/**
	 * Returns the meta object for the attribute '{@link monitoringxml.ExecutionTime#getMinimum <em>Minimum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minimum</em>'.
	 * @see monitoringxml.ExecutionTime#getMinimum()
	 * @see #getExecutionTime()
	 * @generated
	 */
	EAttribute getExecutionTime_Minimum();

	/**
	 * Returns the meta object for the attribute '{@link monitoringxml.ExecutionTime#getMaximum <em>Maximum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum</em>'.
	 * @see monitoringxml.ExecutionTime#getMaximum()
	 * @see #getExecutionTime()
	 * @generated
	 */
	EAttribute getExecutionTime_Maximum();

	/**
	 * Returns the meta object for the reference '{@link monitoringxml.ExecutionTime#getMonitoredresource <em>Monitoredresource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Monitoredresource</em>'.
	 * @see monitoringxml.ExecutionTime#getMonitoredresource()
	 * @see #getExecutionTime()
	 * @generated
	 */
	EReference getExecutionTime_Monitoredresource();

	/**
	 * Returns the meta object for class '{@link monitoringxml.BlockingTime <em>Blocking Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Blocking Time</em>'.
	 * @see monitoringxml.BlockingTime
	 * @generated
	 */
	EClass getBlockingTime();

	/**
	 * Returns the meta object for the attribute '{@link monitoringxml.BlockingTime#getMaximum <em>Maximum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum</em>'.
	 * @see monitoringxml.BlockingTime#getMaximum()
	 * @see #getBlockingTime()
	 * @generated
	 */
	EAttribute getBlockingTime_Maximum();

	/**
	 * Returns the meta object for the reference '{@link monitoringxml.BlockingTime#getMonitoredresource <em>Monitoredresource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Monitoredresource</em>'.
	 * @see monitoringxml.BlockingTime#getMonitoredresource()
	 * @see #getBlockingTime()
	 * @generated
	 */
	EReference getBlockingTime_Monitoredresource();

	/**
	 * Returns the meta object for class '{@link monitoringxml.ResponseTime <em>Response Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Response Time</em>'.
	 * @see monitoringxml.ResponseTime
	 * @generated
	 */
	EClass getResponseTime();

	/**
	 * Returns the meta object for the attribute '{@link monitoringxml.ResponseTime#getMaximum <em>Maximum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum</em>'.
	 * @see monitoringxml.ResponseTime#getMaximum()
	 * @see #getResponseTime()
	 * @generated
	 */
	EAttribute getResponseTime_Maximum();

	/**
	 * Returns the meta object for the attribute '{@link monitoringxml.ResponseTime#getJitter <em>Jitter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Jitter</em>'.
	 * @see monitoringxml.ResponseTime#getJitter()
	 * @see #getResponseTime()
	 * @generated
	 */
	EAttribute getResponseTime_Jitter();

	/**
	 * Returns the meta object for the reference '{@link monitoringxml.ResponseTime#getMonitoredresource <em>Monitoredresource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Monitoredresource</em>'.
	 * @see monitoringxml.ResponseTime#getMonitoredresource()
	 * @see #getResponseTime()
	 * @generated
	 */
	EReference getResponseTime_Monitoredresource();

	/**
	 * Returns the meta object for class '{@link monitoringxml.AnalysisContext <em>Analysis Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Analysis Context</em>'.
	 * @see monitoringxml.AnalysisContext
	 * @generated
	 */
	EClass getAnalysisContext();

	/**
	 * Returns the meta object for the attribute '{@link monitoringxml.AnalysisContext#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see monitoringxml.AnalysisContext#getName()
	 * @see #getAnalysisContext()
	 * @generated
	 */
	EAttribute getAnalysisContext_Name();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MonitoringFactory getMonitoringFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link monitoringxml.impl.MonitoringImpl <em>Monitoring</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see monitoringxml.impl.MonitoringImpl
		 * @see monitoringxml.impl.MonitoringPackageImpl#getMonitoring()
		 * @generated
		 */
		EClass MONITORING = eINSTANCE.getMonitoring();

		/**
		 * The meta object literal for the '<em><b>Thread Names</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MONITORING__THREAD_NAMES = eINSTANCE.getMonitoring_ThreadNames();

		/**
		 * The meta object literal for the '<em><b>Shared Resources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MONITORING__SHARED_RESOURCES = eINSTANCE.getMonitoring_SharedResources();

		/**
		 * The meta object literal for the '<em><b>Analysis Context</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MONITORING__ANALYSIS_CONTEXT = eINSTANCE.getMonitoring_AnalysisContext();

		/**
		 * The meta object literal for the '{@link monitoringxml.impl.ThreadImpl <em>Thread</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see monitoringxml.impl.ThreadImpl
		 * @see monitoringxml.impl.MonitoringPackageImpl#getThread()
		 * @generated
		 */
		EClass THREAD = eINSTANCE.getThread();

		/**
		 * The meta object literal for the '{@link monitoringxml.impl.ResourceImpl <em>Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see monitoringxml.impl.ResourceImpl
		 * @see monitoringxml.impl.MonitoringPackageImpl#getResource()
		 * @generated
		 */
		EClass RESOURCE = eINSTANCE.getResource();

		/**
		 * The meta object literal for the '{@link monitoringxml.impl.PeriodImpl <em>Period</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see monitoringxml.impl.PeriodImpl
		 * @see monitoringxml.impl.MonitoringPackageImpl#getPeriod()
		 * @generated
		 */
		EClass PERIOD = eINSTANCE.getPeriod();

		/**
		 * The meta object literal for the '<em><b>Minimum</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERIOD__MINIMUM = eINSTANCE.getPeriod_Minimum();

		/**
		 * The meta object literal for the '<em><b>Maximum</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERIOD__MAXIMUM = eINSTANCE.getPeriod_Maximum();

		/**
		 * The meta object literal for the '<em><b>Jitter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERIOD__JITTER = eINSTANCE.getPeriod_Jitter();

		/**
		 * The meta object literal for the '<em><b>Monitoredresource</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERIOD__MONITOREDRESOURCE = eINSTANCE.getPeriod_Monitoredresource();

		/**
		 * The meta object literal for the '{@link monitoringxml.impl.MonitoredResourceImpl <em>Monitored Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see monitoringxml.impl.MonitoredResourceImpl
		 * @see monitoringxml.impl.MonitoringPackageImpl#getMonitoredResource()
		 * @generated
		 */
		EClass MONITORED_RESOURCE = eINSTANCE.getMonitoredResource();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MONITORED_RESOURCE__NAME = eINSTANCE.getMonitoredResource_Name();

		/**
		 * The meta object literal for the '<em><b>Period</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MONITORED_RESOURCE__PERIOD = eINSTANCE.getMonitoredResource_Period();

		/**
		 * The meta object literal for the '<em><b>Executiontime</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MONITORED_RESOURCE__EXECUTIONTIME = eINSTANCE.getMonitoredResource_Executiontime();

		/**
		 * The meta object literal for the '<em><b>Blockingtime</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MONITORED_RESOURCE__BLOCKINGTIME = eINSTANCE.getMonitoredResource_Blockingtime();

		/**
		 * The meta object literal for the '<em><b>Responsetime</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MONITORED_RESOURCE__RESPONSETIME = eINSTANCE.getMonitoredResource_Responsetime();

		/**
		 * The meta object literal for the '{@link monitoringxml.impl.ExecutionTimeImpl <em>Execution Time</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see monitoringxml.impl.ExecutionTimeImpl
		 * @see monitoringxml.impl.MonitoringPackageImpl#getExecutionTime()
		 * @generated
		 */
		EClass EXECUTION_TIME = eINSTANCE.getExecutionTime();

		/**
		 * The meta object literal for the '<em><b>Minimum</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXECUTION_TIME__MINIMUM = eINSTANCE.getExecutionTime_Minimum();

		/**
		 * The meta object literal for the '<em><b>Maximum</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXECUTION_TIME__MAXIMUM = eINSTANCE.getExecutionTime_Maximum();

		/**
		 * The meta object literal for the '<em><b>Monitoredresource</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_TIME__MONITOREDRESOURCE = eINSTANCE.getExecutionTime_Monitoredresource();

		/**
		 * The meta object literal for the '{@link monitoringxml.impl.BlockingTimeImpl <em>Blocking Time</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see monitoringxml.impl.BlockingTimeImpl
		 * @see monitoringxml.impl.MonitoringPackageImpl#getBlockingTime()
		 * @generated
		 */
		EClass BLOCKING_TIME = eINSTANCE.getBlockingTime();

		/**
		 * The meta object literal for the '<em><b>Maximum</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BLOCKING_TIME__MAXIMUM = eINSTANCE.getBlockingTime_Maximum();

		/**
		 * The meta object literal for the '<em><b>Monitoredresource</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCKING_TIME__MONITOREDRESOURCE = eINSTANCE.getBlockingTime_Monitoredresource();

		/**
		 * The meta object literal for the '{@link monitoringxml.impl.ResponseTimeImpl <em>Response Time</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see monitoringxml.impl.ResponseTimeImpl
		 * @see monitoringxml.impl.MonitoringPackageImpl#getResponseTime()
		 * @generated
		 */
		EClass RESPONSE_TIME = eINSTANCE.getResponseTime();

		/**
		 * The meta object literal for the '<em><b>Maximum</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESPONSE_TIME__MAXIMUM = eINSTANCE.getResponseTime_Maximum();

		/**
		 * The meta object literal for the '<em><b>Jitter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESPONSE_TIME__JITTER = eINSTANCE.getResponseTime_Jitter();

		/**
		 * The meta object literal for the '<em><b>Monitoredresource</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESPONSE_TIME__MONITOREDRESOURCE = eINSTANCE.getResponseTime_Monitoredresource();

		/**
		 * The meta object literal for the '{@link monitoringxml.impl.AnalysisContextImpl <em>Analysis Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see monitoringxml.impl.AnalysisContextImpl
		 * @see monitoringxml.impl.MonitoringPackageImpl#getAnalysisContext()
		 * @generated
		 */
		EClass ANALYSIS_CONTEXT = eINSTANCE.getAnalysisContext();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANALYSIS_CONTEXT__NAME = eINSTANCE.getAnalysisContext_Name();

	}

} //MonitoringPackage
