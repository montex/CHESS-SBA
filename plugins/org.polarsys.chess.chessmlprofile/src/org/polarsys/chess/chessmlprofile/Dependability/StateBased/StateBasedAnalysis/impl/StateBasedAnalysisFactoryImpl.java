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
package org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StateBasedAnalysisFactoryImpl extends EFactoryImpl implements StateBasedAnalysisFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static StateBasedAnalysisFactory init() {
		try {
			StateBasedAnalysisFactory theStateBasedAnalysisFactory = (StateBasedAnalysisFactory)EPackage.Registry.INSTANCE.getEFactory(StateBasedAnalysisPackage.eNS_URI);
			if (theStateBasedAnalysisFactory != null) {
				return theStateBasedAnalysisFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new StateBasedAnalysisFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateBasedAnalysisFactoryImpl() {
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
			case StateBasedAnalysisPackage.STATE_BASED_ANALYSIS: return createStateBasedAnalysis();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateBasedAnalysis createStateBasedAnalysis() {
		StateBasedAnalysisImpl stateBasedAnalysis = new StateBasedAnalysisImpl();
		return stateBasedAnalysis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateBasedAnalysisPackage getStateBasedAnalysisPackage() {
		return (StateBasedAnalysisPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static StateBasedAnalysisPackage getPackage() {
		return StateBasedAnalysisPackage.eINSTANCE;
	}

} //StateBasedAnalysisFactoryImpl
