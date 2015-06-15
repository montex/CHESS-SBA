/*****************************************************************************
 * Copyright (c) 2011, 2015 University of Padova, Intecs
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *
 *****************************************************************************/
package org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DependableComponentFactoryImpl extends EFactoryImpl implements DependableComponentFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DependableComponentFactory init() {
		try {
			DependableComponentFactory theDependableComponentFactory = (DependableComponentFactory)EPackage.Registry.INSTANCE.getEFactory(DependableComponentPackage.eNS_URI);
			if (theDependableComponentFactory != null) {
				return theDependableComponentFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DependableComponentFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependableComponentFactoryImpl() {
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
			case DependableComponentPackage.PROPAGATION: return createPropagation();
			case DependableComponentPackage.FAILURE_MODE_GROUP: return createFailureModeGroup();
			case DependableComponentPackage.FAILURE_MODE: return createFailureMode();
			case DependableComponentPackage.FAILURE_MODE_SPECIFICATION: return createFailureModeSpecification();
			case DependableComponentPackage.DEPENDABLE_COMPONENT: return createDependableComponent();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Propagation createPropagation() {
		PropagationImpl propagation = new PropagationImpl();
		return propagation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FailureModeGroup createFailureModeGroup() {
		FailureModeGroupImpl failureModeGroup = new FailureModeGroupImpl();
		return failureModeGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FailureMode createFailureMode() {
		FailureModeImpl failureMode = new FailureModeImpl();
		return failureMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FailureModeSpecification createFailureModeSpecification() {
		FailureModeSpecificationImpl failureModeSpecification = new FailureModeSpecificationImpl();
		return failureModeSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependableComponent createDependableComponent() {
		DependableComponentImpl dependableComponent = new DependableComponentImpl();
		return dependableComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependableComponentPackage getDependableComponentPackage() {
		return (DependableComponentPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DependableComponentPackage getPackage() {
		return DependableComponentPackage.eINSTANCE;
	}

} //DependableComponentFactoryImpl