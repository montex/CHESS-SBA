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
package org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FaultToleranceFactoryImpl extends EFactoryImpl implements FaultToleranceFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FaultToleranceFactory init() {
		try {
			FaultToleranceFactory theFaultToleranceFactory = (FaultToleranceFactory)EPackage.Registry.INSTANCE.getEFactory(FaultTolerancePackage.eNS_URI);
			if (theFaultToleranceFactory != null) {
				return theFaultToleranceFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new FaultToleranceFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FaultToleranceFactoryImpl() {
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
			case FaultTolerancePackage.FAULT_TOLERANT: return createFaultTolerant();
			case FaultTolerancePackage.REDUNDANCY_MANAGER: return createRedundancyManager();
			case FaultTolerancePackage.VARIANT: return createVariant();
			case FaultTolerancePackage.ADJUDICATOR: return createAdjudicator();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FaultTolerant createFaultTolerant() {
		FaultTolerantImpl faultTolerant = new FaultTolerantImpl();
		return faultTolerant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RedundancyManager createRedundancyManager() {
		RedundancyManagerImpl redundancyManager = new RedundancyManagerImpl();
		return redundancyManager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variant createVariant() {
		VariantImpl variant = new VariantImpl();
		return variant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adjudicator createAdjudicator() {
		AdjudicatorImpl adjudicator = new AdjudicatorImpl();
		return adjudicator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FaultTolerancePackage getFaultTolerancePackage() {
		return (FaultTolerancePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static FaultTolerancePackage getPackage() {
		return FaultTolerancePackage.eINSTANCE;
	}

} //FaultToleranceFactoryImpl
