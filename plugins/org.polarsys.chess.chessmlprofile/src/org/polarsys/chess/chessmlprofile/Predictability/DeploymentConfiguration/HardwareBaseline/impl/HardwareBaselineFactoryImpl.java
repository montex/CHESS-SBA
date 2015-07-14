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
			case HardwareBaselinePackage.HW_DATA_TYPE: return createHWDataType();
			case HardwareBaselinePackage.DATA_TYPE_EXECUTION: return createDataTypeExecution();
			case HardwareBaselinePackage.COMPUTE_COMPLEXITY: return createComputeComplexity();
			case HardwareBaselinePackage.OPERATION_COUNT: return createOperationCount();
			case HardwareBaselinePackage.CH_CONTROL_FLOW: return createCHControlFlow();
			case HardwareBaselinePackage.FLOAT_SW_DATA_TYPE: return createFloatSWDataType();
			case HardwareBaselinePackage.FIXED_SW_DATA_TYPE: return createFixedSWDataType();
			case HardwareBaselinePackage.INTEGER_SW_DATA_TYPE: return createIntegerSWDataType();
			case HardwareBaselinePackage.CHAR_SW_DATA_TYPE: return createCharSWDataType();
			case HardwareBaselinePackage.BOOLEAN_SW_DATA_TYPE: return createBooleanSWDataType();
			case HardwareBaselinePackage.CH_HW_BUS: return createCH_HwBus();
			case HardwareBaselinePackage.CH_HW_COMPUTING_RESOURCE: return createCH_HwComputingResource();
			case HardwareBaselinePackage.DATA_TYPE_ASSIGN: return createDataTypeAssign();
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
			case HardwareBaselinePackage.BASIC_OPERATION:
				return createBasicOperationFromString(eDataType, initialValue);
			case HardwareBaselinePackage.BASIC_DATA_TYPE:
				return createBasicDataTypeFromString(eDataType, initialValue);
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
			case HardwareBaselinePackage.BASIC_OPERATION:
				return convertBasicOperationToString(eDataType, instanceValue);
			case HardwareBaselinePackage.BASIC_DATA_TYPE:
				return convertBasicDataTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
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
	public HWDataType createHWDataType() {
		HWDataTypeImpl hwDataType = new HWDataTypeImpl();
		return hwDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataTypeExecution createDataTypeExecution() {
		DataTypeExecutionImpl dataTypeExecution = new DataTypeExecutionImpl();
		return dataTypeExecution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputeComplexity createComputeComplexity() {
		ComputeComplexityImpl computeComplexity = new ComputeComplexityImpl();
		return computeComplexity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationCount createOperationCount() {
		OperationCountImpl operationCount = new OperationCountImpl();
		return operationCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CHControlFlow createCHControlFlow() {
		CHControlFlowImpl chControlFlow = new CHControlFlowImpl();
		return chControlFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FloatSWDataType createFloatSWDataType() {
		FloatSWDataTypeImpl floatSWDataType = new FloatSWDataTypeImpl();
		return floatSWDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FixedSWDataType createFixedSWDataType() {
		FixedSWDataTypeImpl fixedSWDataType = new FixedSWDataTypeImpl();
		return fixedSWDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerSWDataType createIntegerSWDataType() {
		IntegerSWDataTypeImpl integerSWDataType = new IntegerSWDataTypeImpl();
		return integerSWDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CharSWDataType createCharSWDataType() {
		CharSWDataTypeImpl charSWDataType = new CharSWDataTypeImpl();
		return charSWDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanSWDataType createBooleanSWDataType() {
		BooleanSWDataTypeImpl booleanSWDataType = new BooleanSWDataTypeImpl();
		return booleanSWDataType;
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
	public DataTypeAssign createDataTypeAssign() {
		DataTypeAssignImpl dataTypeAssign = new DataTypeAssignImpl();
		return dataTypeAssign;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicOperation createBasicOperationFromString(EDataType eDataType, String initialValue) {
		BasicOperation result = BasicOperation.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBasicOperationToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicDataType createBasicDataTypeFromString(EDataType eDataType, String initialValue) {
		BasicDataType result = BasicDataType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBasicDataTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
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
