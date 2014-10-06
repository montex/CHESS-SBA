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
package org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StateBasedComponentsFactoryImpl extends EFactoryImpl implements StateBasedComponentsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static StateBasedComponentsFactory init() {
		try {
			StateBasedComponentsFactory theStateBasedComponentsFactory = (StateBasedComponentsFactory)EPackage.Registry.INSTANCE.getEFactory(StateBasedComponentsPackage.eNS_URI);
			if (theStateBasedComponentsFactory != null) {
				return theStateBasedComponentsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new StateBasedComponentsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateBasedComponentsFactoryImpl() {
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
			case StateBasedComponentsPackage.STATEFUL_HARDWARE: return createStatefulHardware();
			case StateBasedComponentsPackage.STATEFUL_SOFTWARE: return createStatefulSoftware();
			case StateBasedComponentsPackage.STATELESS_HARDWARE: return createStatelessHardware();
			case StateBasedComponentsPackage.STATELESS_SOFTWARE: return createStatelessSoftware();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatefulHardware createStatefulHardware() {
		StatefulHardwareImpl statefulHardware = new StatefulHardwareImpl();
		return statefulHardware;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatefulSoftware createStatefulSoftware() {
		StatefulSoftwareImpl statefulSoftware = new StatefulSoftwareImpl();
		return statefulSoftware;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatelessHardware createStatelessHardware() {
		StatelessHardwareImpl statelessHardware = new StatelessHardwareImpl();
		return statelessHardware;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatelessSoftware createStatelessSoftware() {
		StatelessSoftwareImpl statelessSoftware = new StatelessSoftwareImpl();
		return statelessSoftware;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateBasedComponentsPackage getStateBasedComponentsPackage() {
		return (StateBasedComponentsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static StateBasedComponentsPackage getPackage() {
		return StateBasedComponentsPackage.eINSTANCE;
	}

} //StateBasedComponentsFactoryImpl