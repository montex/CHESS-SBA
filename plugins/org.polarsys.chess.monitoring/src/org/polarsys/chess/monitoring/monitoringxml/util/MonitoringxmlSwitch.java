/*******************************************************************************
 *                  CHESS monitoring plugin
 *
 *               Copyright (C) 2015-2016
 *            Mälardalen University, Sweden
 *
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License
 *  v1.0 which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.polarsys.chess.monitoring.monitoringxml.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
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
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.polarsys.chess.monitoring.monitoringxml.MonitoringxmlPackage
 * @generated
 */
public class MonitoringxmlSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MonitoringxmlPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MonitoringxmlSwitch() {
		if (modelPackage == null) {
			modelPackage = MonitoringxmlPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case MonitoringxmlPackage.MONITORING: {
				Monitoring monitoring = (Monitoring)theEObject;
				T result = caseMonitoring(monitoring);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MonitoringxmlPackage.THREAD: {
				org.polarsys.chess.monitoring.monitoringxml.Thread thread = (org.polarsys.chess.monitoring.monitoringxml.Thread)theEObject;
				T result = caseThread(thread);
				if (result == null) result = caseMonitoredResource(thread);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MonitoringxmlPackage.RESOURCE: {
				Resource resource = (Resource)theEObject;
				T result = caseResource(resource);
				if (result == null) result = caseMonitoredResource(resource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MonitoringxmlPackage.PERIOD: {
				Period period = (Period)theEObject;
				T result = casePeriod(period);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MonitoringxmlPackage.MONITORED_RESOURCE: {
				MonitoredResource monitoredResource = (MonitoredResource)theEObject;
				T result = caseMonitoredResource(monitoredResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MonitoringxmlPackage.EXECUTION_TIME: {
				ExecutionTime executionTime = (ExecutionTime)theEObject;
				T result = caseExecutionTime(executionTime);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MonitoringxmlPackage.BLOCKING_TIME: {
				BlockingTime blockingTime = (BlockingTime)theEObject;
				T result = caseBlockingTime(blockingTime);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MonitoringxmlPackage.RESPONSE_TIME: {
				ResponseTime responseTime = (ResponseTime)theEObject;
				T result = caseResponseTime(responseTime);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MonitoringxmlPackage.ANALYSIS_CONTEXT: {
				AnalysisContext analysisContext = (AnalysisContext)theEObject;
				T result = caseAnalysisContext(analysisContext);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MonitoringxmlPackage.MEASURED_VALUE: {
				MeasuredValue measuredValue = (MeasuredValue)theEObject;
				T result = caseMeasuredValue(measuredValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Monitoring</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Monitoring</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMonitoring(Monitoring object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Thread</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Thread</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThread(org.polarsys.chess.monitoring.monitoringxml.Thread object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResource(Resource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Period</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Period</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePeriod(Period object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Monitored Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Monitored Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMonitoredResource(MonitoredResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Execution Time</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Execution Time</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExecutionTime(ExecutionTime object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Blocking Time</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Blocking Time</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlockingTime(BlockingTime object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Response Time</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Response Time</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResponseTime(ResponseTime object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Analysis Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Analysis Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnalysisContext(AnalysisContext object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Measured Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Measured Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMeasuredValue(MeasuredValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //MonitoringxmlSwitch
