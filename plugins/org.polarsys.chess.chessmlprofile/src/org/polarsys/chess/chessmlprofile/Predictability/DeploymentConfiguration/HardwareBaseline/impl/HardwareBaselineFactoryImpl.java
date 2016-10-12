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
package org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class HardwareBaselineFactoryImpl extends EFactoryImpl implements HardwareBaselineFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static HardwareBaselineFactory init() {
		try {
			HardwareBaselineFactory theHardwareBaselineFactory = (HardwareBaselineFactory)EPackage.Registry.INSTANCE.getEFactory(HardwareBaselinePackage.eNS_URI);
			if (theHardwareBaselineFactory != null) {
				return theHardwareBaselineFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new HardwareBaselineFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HardwareBaselineFactoryImpl() {
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
			case HardwareBaselinePackage.CH_HW_PROCESSOR: return createCH_HwProcessor();
			case HardwareBaselinePackage.CH_HW_BUS: return createCH_HwBus();
			case HardwareBaselinePackage.CH_HW_COMPUTING_RESOURCE: return createCH_HwComputingResource();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CH_HwProcessor createCH_HwProcessor() {
		CH_HwProcessorImpl cH_HwProcessor = new CH_HwProcessorImpl();
		return cH_HwProcessor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CH_HwBus createCH_HwBus() {
		CH_HwBusImpl cH_HwBus = new CH_HwBusImpl();
		return cH_HwBus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CH_HwComputingResource createCH_HwComputingResource() {
		CH_HwComputingResourceImpl cH_HwComputingResource = new CH_HwComputingResourceImpl();
		return cH_HwComputingResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HardwareBaselinePackage getHardwareBaselinePackage() {
		return (HardwareBaselinePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static HardwareBaselinePackage getPackage() {
		return HardwareBaselinePackage.eINSTANCE;
	}

} //HardwareBaselineFactoryImpl
