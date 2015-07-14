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
package org.polarsys.chess.chessmlprofile.Dependability.DataFlowCallGraph.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.polarsys.chess.chessmlprofile.Dependability.DataFlowCallGraph.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DataFlowCallGraphFactoryImpl extends EFactoryImpl implements DataFlowCallGraphFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DataFlowCallGraphFactory init() {
		try {
			DataFlowCallGraphFactory theDataFlowCallGraphFactory = (DataFlowCallGraphFactory)EPackage.Registry.INSTANCE.getEFactory(DataFlowCallGraphPackage.eNS_URI);
			if (theDataFlowCallGraphFactory != null) {
				return theDataFlowCallGraphFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DataFlowCallGraphFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataFlowCallGraphFactoryImpl() {
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
			case DataFlowCallGraphPackage.DATA_FLOW_CALL_GRAPH_ANALYSIS: return createDataFlowCallGraphAnalysis();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataFlowCallGraphAnalysis createDataFlowCallGraphAnalysis() {
		DataFlowCallGraphAnalysisImpl dataFlowCallGraphAnalysis = new DataFlowCallGraphAnalysisImpl();
		return dataFlowCallGraphAnalysis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataFlowCallGraphPackage getDataFlowCallGraphPackage() {
		return (DataFlowCallGraphPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DataFlowCallGraphPackage getPackage() {
		return DataFlowCallGraphPackage.eINSTANCE;
	}

} //DataFlowCallGraphFactoryImpl
