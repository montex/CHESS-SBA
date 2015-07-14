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
package org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TimingConstraintsFactoryImpl extends EFactoryImpl implements TimingConstraintsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TimingConstraintsFactory init() {
		try {
			TimingConstraintsFactory theTimingConstraintsFactory = (TimingConstraintsFactory)EPackage.Registry.INSTANCE.getEFactory(TimingConstraintsPackage.eNS_URI);
			if (theTimingConstraintsFactory != null) {
				return theTimingConstraintsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TimingConstraintsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimingConstraintsFactoryImpl() {
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
			case TimingConstraintsPackage.ARBITRARY_EVENT_CONSTRAINT: return createArbitraryEventConstraint();
			case TimingConstraintsPackage.PATTERN_EVENT_CONSTRAINT: return createPatternEventConstraint();
			case TimingConstraintsPackage.PERIODIC_EVENT_CONSTRAINT: return createPeriodicEventConstraint();
			case TimingConstraintsPackage.SPORADIC_EVENT_CONSTRAINT: return createSporadicEventConstraint();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArbitraryEventConstraint createArbitraryEventConstraint() {
		ArbitraryEventConstraintImpl arbitraryEventConstraint = new ArbitraryEventConstraintImpl();
		return arbitraryEventConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternEventConstraint createPatternEventConstraint() {
		PatternEventConstraintImpl patternEventConstraint = new PatternEventConstraintImpl();
		return patternEventConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PeriodicEventConstraint createPeriodicEventConstraint() {
		PeriodicEventConstraintImpl periodicEventConstraint = new PeriodicEventConstraintImpl();
		return periodicEventConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SporadicEventConstraint createSporadicEventConstraint() {
		SporadicEventConstraintImpl sporadicEventConstraint = new SporadicEventConstraintImpl();
		return sporadicEventConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimingConstraintsPackage getTimingConstraintsPackage() {
		return (TimingConstraintsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TimingConstraintsPackage getPackage() {
		return TimingConstraintsPackage.eINSTANCE;
	}

} //TimingConstraintsFactoryImpl
