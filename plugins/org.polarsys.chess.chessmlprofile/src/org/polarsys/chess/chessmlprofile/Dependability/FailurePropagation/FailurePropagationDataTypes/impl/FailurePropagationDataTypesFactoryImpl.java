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
package org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FailurePropagationDataTypesFactoryImpl extends EFactoryImpl implements FailurePropagationDataTypesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FailurePropagationDataTypesFactory init() {
		try {
			FailurePropagationDataTypesFactory theFailurePropagationDataTypesFactory = (FailurePropagationDataTypesFactory)EPackage.Registry.INSTANCE.getEFactory(FailurePropagationDataTypesPackage.eNS_URI);
			if (theFailurePropagationDataTypesFactory != null) {
				return theFailurePropagationDataTypesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new FailurePropagationDataTypesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FailurePropagationDataTypesFactoryImpl() {
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
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case FailurePropagationDataTypesPackage.DAVOIDABLE:
				return createD_avoidableFromString(eDataType, initialValue);
			case FailurePropagationDataTypesPackage.IAVOIDABLE:
				return createI_avoidableFromString(eDataType, initialValue);
			case FailurePropagationDataTypesPackage.CAVOIDABLE:
				return createC_avoidableFromString(eDataType, initialValue);
			case FailurePropagationDataTypesPackage.AAVOIDABLE:
				return createA_avoidableFromString(eDataType, initialValue);
			case FailurePropagationDataTypesPackage.AMITIGATION:
				return createA_mitigationFromString(eDataType, initialValue);
			case FailurePropagationDataTypesPackage.CMITIGATION:
				return createC_mitigationFromString(eDataType, initialValue);
			case FailurePropagationDataTypesPackage.IMITIGATION:
				return createI_mitigationFromString(eDataType, initialValue);
			case FailurePropagationDataTypesPackage.DMITIGATION:
				return createD_mitigationFromString(eDataType, initialValue);
			case FailurePropagationDataTypesPackage.FAILURE_TYPE:
				return createFailureTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case FailurePropagationDataTypesPackage.DAVOIDABLE:
				return convertD_avoidableToString(eDataType, instanceValue);
			case FailurePropagationDataTypesPackage.IAVOIDABLE:
				return convertI_avoidableToString(eDataType, instanceValue);
			case FailurePropagationDataTypesPackage.CAVOIDABLE:
				return convertC_avoidableToString(eDataType, instanceValue);
			case FailurePropagationDataTypesPackage.AAVOIDABLE:
				return convertA_avoidableToString(eDataType, instanceValue);
			case FailurePropagationDataTypesPackage.AMITIGATION:
				return convertA_mitigationToString(eDataType, instanceValue);
			case FailurePropagationDataTypesPackage.CMITIGATION:
				return convertC_mitigationToString(eDataType, instanceValue);
			case FailurePropagationDataTypesPackage.IMITIGATION:
				return convertI_mitigationToString(eDataType, instanceValue);
			case FailurePropagationDataTypesPackage.DMITIGATION:
				return convertD_mitigationToString(eDataType, instanceValue);
			case FailurePropagationDataTypesPackage.FAILURE_TYPE:
				return convertFailureTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public D_avoidable createD_avoidableFromString(EDataType eDataType, String initialValue) {
		D_avoidable result = D_avoidable.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertD_avoidableToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public I_avoidable createI_avoidableFromString(EDataType eDataType, String initialValue) {
		I_avoidable result = I_avoidable.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertI_avoidableToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public C_avoidable createC_avoidableFromString(EDataType eDataType, String initialValue) {
		C_avoidable result = C_avoidable.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertC_avoidableToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FailureType createFailureTypeFromString(EDataType eDataType, String initialValue) {
		FailureType result = FailureType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFailureTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public A_avoidable createA_avoidableFromString(EDataType eDataType, String initialValue) {
		A_avoidable result = A_avoidable.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertA_avoidableToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public A_mitigation createA_mitigationFromString(EDataType eDataType, String initialValue) {
		A_mitigation result = A_mitigation.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertA_mitigationToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public C_mitigation createC_mitigationFromString(EDataType eDataType, String initialValue) {
		C_mitigation result = C_mitigation.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertC_mitigationToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public I_mitigation createI_mitigationFromString(EDataType eDataType, String initialValue) {
		I_mitigation result = I_mitigation.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertI_mitigationToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public D_mitigation createD_mitigationFromString(EDataType eDataType, String initialValue) {
		D_mitigation result = D_mitigation.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertD_mitigationToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FailurePropagationDataTypesPackage getFailurePropagationDataTypesPackage() {
		return (FailurePropagationDataTypesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static FailurePropagationDataTypesPackage getPackage() {
		return FailurePropagationDataTypesPackage.eINSTANCE;
	}

} //FailurePropagationDataTypesFactoryImpl
