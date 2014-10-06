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
package org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RTDataTypes.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RTDataTypes.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RTDataTypesFactoryImpl extends EFactoryImpl implements RTDataTypesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RTDataTypesFactory init() {
		try {
			RTDataTypesFactory theRTDataTypesFactory = (RTDataTypesFactory)EPackage.Registry.INSTANCE.getEFactory(RTDataTypesPackage.eNS_URI);
			if (theRTDataTypesFactory != null) {
				return theRTDataTypesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new RTDataTypesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RTDataTypesFactoryImpl() {
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
			case RTDataTypesPackage.CH_SPORADIC_PATTERN: return createCH_SporadicPattern();
			case RTDataTypesPackage.CH_PERIODIC_PATTERN: return createCH_PeriodicPattern();
			case RTDataTypesPackage.CH_BURST_PATTERN: return createCH_BurstPattern();
			case RTDataTypesPackage.TA_PATTERN: return createTA_Pattern();
			case RTDataTypesPackage.TA_ARBITRARY_PATTERN: return createTA_ArbitraryPattern();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CH_SporadicPattern createCH_SporadicPattern() {
		CH_SporadicPatternImpl cH_SporadicPattern = new CH_SporadicPatternImpl();
		return cH_SporadicPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CH_PeriodicPattern createCH_PeriodicPattern() {
		CH_PeriodicPatternImpl cH_PeriodicPattern = new CH_PeriodicPatternImpl();
		return cH_PeriodicPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CH_BurstPattern createCH_BurstPattern() {
		CH_BurstPatternImpl cH_BurstPattern = new CH_BurstPatternImpl();
		return cH_BurstPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TA_Pattern createTA_Pattern() {
		TA_PatternImpl tA_Pattern = new TA_PatternImpl();
		return tA_Pattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TA_ArbitraryPattern createTA_ArbitraryPattern() {
		TA_ArbitraryPatternImpl tA_ArbitraryPattern = new TA_ArbitraryPatternImpl();
		return tA_ArbitraryPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RTDataTypesPackage getRTDataTypesPackage() {
		return (RTDataTypesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static RTDataTypesPackage getPackage() {
		return RTDataTypesPackage.eINSTANCE;
	}

} //RTDataTypesFactoryImpl
