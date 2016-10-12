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
package org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MaintenanceMonitoringFactoryImpl extends EFactoryImpl implements MaintenanceMonitoringFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MaintenanceMonitoringFactory init() {
		try {
			MaintenanceMonitoringFactory theMaintenanceMonitoringFactory = (MaintenanceMonitoringFactory)EPackage.Registry.INSTANCE.getEFactory(MaintenanceMonitoringPackage.eNS_URI);
			if (theMaintenanceMonitoringFactory != null) {
				return theMaintenanceMonitoringFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MaintenanceMonitoringFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MaintenanceMonitoringFactoryImpl() {
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
			case MaintenanceMonitoringPackage.MM_ACTIVITIES: return createMMActivities();
			case MaintenanceMonitoringPackage.REPAIR: return createRepair();
			case MaintenanceMonitoringPackage.REPLACE: return createReplace();
			case MaintenanceMonitoringPackage.ERROR_DETECTION: return createErrorDetection();
			case MaintenanceMonitoringPackage.FAILURE_DETECTION: return createFailureDetection();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MMActivities createMMActivities() {
		MMActivitiesImpl mmActivities = new MMActivitiesImpl();
		return mmActivities;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Repair createRepair() {
		RepairImpl repair = new RepairImpl();
		return repair;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Replace createReplace() {
		ReplaceImpl replace = new ReplaceImpl();
		return replace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ErrorDetection createErrorDetection() {
		ErrorDetectionImpl errorDetection = new ErrorDetectionImpl();
		return errorDetection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FailureDetection createFailureDetection() {
		FailureDetectionImpl failureDetection = new FailureDetectionImpl();
		return failureDetection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MaintenanceMonitoringPackage getMaintenanceMonitoringPackage() {
		return (MaintenanceMonitoringPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MaintenanceMonitoringPackage getPackage() {
		return MaintenanceMonitoringPackage.eINSTANCE;
	}

} //MaintenanceMonitoringFactoryImpl
