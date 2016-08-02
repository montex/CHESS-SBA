/*
-----------------------------------------------------------------------
--                    CHESS monitoring plugin                        --
--                                                                   --
--                    Copyright (C) 2015-2016                        --
--                 Malardalen University, Sweden                       --
--                                                                   --                      --
--                                                                   --
-- All rights reserved. This program and the accompanying materials  --
-- are made available under the terms of the Eclipse Public License  --
-- v1.0 which accompanies this distribution, and is available at     --
-- http://www.eclipse.org/legal/epl-v10.html                         --
-----------------------------------------------------------------------
  */ 
package org.polarsys.chess.monitoring.monitoringxml.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.polarsys.chess.monitoring.monitoringxml.AnalysisContext;
import org.polarsys.chess.monitoring.monitoringxml.BlockingTime;
import org.polarsys.chess.monitoring.monitoringxml.ExecutionTime;
import org.polarsys.chess.monitoring.monitoringxml.MeasuredValue;
import org.polarsys.chess.monitoring.monitoringxml.MonitoredResource;
import org.polarsys.chess.monitoring.monitoringxml.Monitoring;
import org.polarsys.chess.monitoring.monitoringxml.MonitoringxmlPackage;
import org.polarsys.chess.monitoring.monitoringxml.Period;
import org.polarsys.chess.monitoring.monitoringxml.Resource;
import org.polarsys.chess.monitoring.monitoringxml.ResponseTime;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.polarsys.chess.monitoring.monitoringxml.MonitoringxmlPackage
 * @generated
 */
public class MonitoringxmlAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MonitoringxmlPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MonitoringxmlAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = MonitoringxmlPackage.eINSTANCE;
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
	protected MonitoringxmlSwitch<Adapter> modelSwitch =
		new MonitoringxmlSwitch<Adapter>() {
			@Override
			public Adapter caseMonitoring(Monitoring object) {
				return createMonitoringAdapter();
			}
			@Override
			public Adapter caseThread(org.polarsys.chess.monitoring.monitoringxml.Thread object) {
				return createThreadAdapter();
			}
			@Override
			public Adapter caseResource(Resource object) {
				return createResourceAdapter();
			}
			@Override
			public Adapter casePeriod(Period object) {
				return createPeriodAdapter();
			}
			@Override
			public Adapter caseMonitoredResource(MonitoredResource object) {
				return createMonitoredResourceAdapter();
			}
			@Override
			public Adapter caseExecutionTime(ExecutionTime object) {
				return createExecutionTimeAdapter();
			}
			@Override
			public Adapter caseBlockingTime(BlockingTime object) {
				return createBlockingTimeAdapter();
			}
			@Override
			public Adapter caseResponseTime(ResponseTime object) {
				return createResponseTimeAdapter();
			}
			@Override
			public Adapter caseAnalysisContext(AnalysisContext object) {
				return createAnalysisContextAdapter();
			}
			@Override
			public Adapter caseMeasuredValue(MeasuredValue object) {
				return createMeasuredValueAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.monitoring.monitoringxml.Monitoring <em>Monitoring</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.monitoring.monitoringxml.Monitoring
	 * @generated
	 */
	public Adapter createMonitoringAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.monitoring.monitoringxml.Thread <em>Thread</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.monitoring.monitoringxml.Thread
	 * @generated
	 */
	public Adapter createThreadAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.monitoring.monitoringxml.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.monitoring.monitoringxml.Resource
	 * @generated
	 */
	public Adapter createResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.monitoring.monitoringxml.Period <em>Period</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.monitoring.monitoringxml.Period
	 * @generated
	 */
	public Adapter createPeriodAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.monitoring.monitoringxml.MonitoredResource <em>Monitored Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.monitoring.monitoringxml.MonitoredResource
	 * @generated
	 */
	public Adapter createMonitoredResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.monitoring.monitoringxml.ExecutionTime <em>Execution Time</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.monitoring.monitoringxml.ExecutionTime
	 * @generated
	 */
	public Adapter createExecutionTimeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.monitoring.monitoringxml.BlockingTime <em>Blocking Time</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.monitoring.monitoringxml.BlockingTime
	 * @generated
	 */
	public Adapter createBlockingTimeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.monitoring.monitoringxml.ResponseTime <em>Response Time</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.monitoring.monitoringxml.ResponseTime
	 * @generated
	 */
	public Adapter createResponseTimeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.monitoring.monitoringxml.AnalysisContext <em>Analysis Context</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.monitoring.monitoringxml.AnalysisContext
	 * @generated
	 */
	public Adapter createAnalysisContextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.monitoring.monitoringxml.MeasuredValue <em>Measured Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.monitoring.monitoringxml.MeasuredValue
	 * @generated
	 */
	public Adapter createMeasuredValueAdapter() {
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

} //MonitoringxmlAdapterFactory
