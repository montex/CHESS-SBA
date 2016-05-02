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
package monitoringxml.util;

import monitoringxml.AnalysisContext;
import monitoringxml.BlockingTime;
import monitoringxml.ExecutionTime;
import monitoringxml.MonitoredResource;
import monitoringxml.Monitoring;
import monitoringxml.MonitoringPackage;
import monitoringxml.Period;
import monitoringxml.Resource;
import monitoringxml.ResponseTime;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see monitoringxml.MonitoringPackage
 * @generated
 */
public class MonitoringAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MonitoringPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MonitoringAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = MonitoringPackage.eINSTANCE;
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
	protected MonitoringSwitch<Adapter> modelSwitch =
		new MonitoringSwitch<Adapter>() {
			@Override
			public Adapter caseMonitoring(Monitoring object) {
				return createMonitoringAdapter();
			}
			@Override
			public Adapter caseThread(monitoringxml.Thread object) {
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
	 * Creates a new adapter for an object of class '{@link monitoringxml.Monitoring <em>Monitoring</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see monitoringxml.Monitoring
	 * @generated
	 */
	public Adapter createMonitoringAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link monitoringxml.Thread <em>Thread</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see monitoringxml.Thread
	 * @generated
	 */
	public Adapter createThreadAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link monitoringxml.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see monitoringxml.Resource
	 * @generated
	 */
	public Adapter createResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link monitoringxml.Period <em>Period</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see monitoringxml.Period
	 * @generated
	 */
	public Adapter createPeriodAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link monitoringxml.MonitoredResource <em>Monitored Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see monitoringxml.MonitoredResource
	 * @generated
	 */
	public Adapter createMonitoredResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link monitoringxml.ExecutionTime <em>Execution Time</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see monitoringxml.ExecutionTime
	 * @generated
	 */
	public Adapter createExecutionTimeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link monitoringxml.BlockingTime <em>Blocking Time</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see monitoringxml.BlockingTime
	 * @generated
	 */
	public Adapter createBlockingTimeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link monitoringxml.ResponseTime <em>Response Time</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see monitoringxml.ResponseTime
	 * @generated
	 */
	public Adapter createResponseTimeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link monitoringxml.AnalysisContext <em>Analysis Context</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see monitoringxml.AnalysisContext
	 * @generated
	 */
	public Adapter createAnalysisContextAdapter() {
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

} //MonitoringAdapterFactory
