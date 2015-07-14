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
package org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwGeneral.HwResource;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwBus;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwCommunicationResource;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwMedia;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwComputingResource;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwProcessor;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.CommunicationMedia;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ComputingResource;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ProcessingResource;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Resource;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.HardwareBaselinePackage
 * @generated
 */
public class HardwareBaselineSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static HardwareBaselinePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HardwareBaselineSwitch() {
		if (modelPackage == null) {
			modelPackage = HardwareBaselinePackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case HardwareBaselinePackage.CH_HW_PROCESSOR: {
				CH_HwProcessor cH_HwProcessor = (CH_HwProcessor)theEObject;
				T result = caseCH_HwProcessor(cH_HwProcessor);
				if (result == null) result = caseHwProcessor(cH_HwProcessor);
				if (result == null) result = caseHwComputingResource(cH_HwProcessor);
				if (result == null) result = caseHwResource(cH_HwProcessor);
				if (result == null) result = caseComputingResource(cH_HwProcessor);
				if (result == null) result = caseProcessingResource(cH_HwProcessor);
				if (result == null) result = caseResource(cH_HwProcessor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HardwareBaselinePackage.HW_DATA_TYPE: {
				HWDataType hwDataType = (HWDataType)theEObject;
				T result = caseHWDataType(hwDataType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HardwareBaselinePackage.DATA_TYPE_EXECUTION: {
				DataTypeExecution dataTypeExecution = (DataTypeExecution)theEObject;
				T result = caseDataTypeExecution(dataTypeExecution);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HardwareBaselinePackage.COMPUTE_COMPLEXITY: {
				ComputeComplexity computeComplexity = (ComputeComplexity)theEObject;
				T result = caseComputeComplexity(computeComplexity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HardwareBaselinePackage.SW_DATA_TYPE: {
				SWDataType swDataType = (SWDataType)theEObject;
				T result = caseSWDataType(swDataType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HardwareBaselinePackage.OPERATION_COUNT: {
				OperationCount operationCount = (OperationCount)theEObject;
				T result = caseOperationCount(operationCount);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HardwareBaselinePackage.CH_CONTROL_FLOW: {
				CHControlFlow chControlFlow = (CHControlFlow)theEObject;
				T result = caseCHControlFlow(chControlFlow);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HardwareBaselinePackage.FLOAT_SW_DATA_TYPE: {
				FloatSWDataType floatSWDataType = (FloatSWDataType)theEObject;
				T result = caseFloatSWDataType(floatSWDataType);
				if (result == null) result = caseSWDataType(floatSWDataType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HardwareBaselinePackage.FIXED_SW_DATA_TYPE: {
				FixedSWDataType fixedSWDataType = (FixedSWDataType)theEObject;
				T result = caseFixedSWDataType(fixedSWDataType);
				if (result == null) result = caseSWDataType(fixedSWDataType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HardwareBaselinePackage.INTEGER_SW_DATA_TYPE: {
				IntegerSWDataType integerSWDataType = (IntegerSWDataType)theEObject;
				T result = caseIntegerSWDataType(integerSWDataType);
				if (result == null) result = caseSWDataType(integerSWDataType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HardwareBaselinePackage.CHAR_SW_DATA_TYPE: {
				CharSWDataType charSWDataType = (CharSWDataType)theEObject;
				T result = caseCharSWDataType(charSWDataType);
				if (result == null) result = caseSWDataType(charSWDataType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HardwareBaselinePackage.BOOLEAN_SW_DATA_TYPE: {
				BooleanSWDataType booleanSWDataType = (BooleanSWDataType)theEObject;
				T result = caseBooleanSWDataType(booleanSWDataType);
				if (result == null) result = caseSWDataType(booleanSWDataType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HardwareBaselinePackage.CH_HW_BUS: {
				CH_HwBus cH_HwBus = (CH_HwBus)theEObject;
				T result = caseCH_HwBus(cH_HwBus);
				if (result == null) result = caseHwBus(cH_HwBus);
				if (result == null) result = caseHwMedia(cH_HwBus);
				if (result == null) result = caseCommunicationMedia(cH_HwBus);
				if (result == null) result = caseHwCommunicationResource(cH_HwBus);
				if (result == null) result = caseProcessingResource(cH_HwBus);
				if (result == null) result = caseHwResource(cH_HwBus);
				if (result == null) result = caseResource(cH_HwBus);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HardwareBaselinePackage.CH_HW_COMPUTING_RESOURCE: {
				CH_HwComputingResource cH_HwComputingResource = (CH_HwComputingResource)theEObject;
				T result = caseCH_HwComputingResource(cH_HwComputingResource);
				if (result == null) result = caseHwComputingResource(cH_HwComputingResource);
				if (result == null) result = caseHwResource(cH_HwComputingResource);
				if (result == null) result = caseComputingResource(cH_HwComputingResource);
				if (result == null) result = caseProcessingResource(cH_HwComputingResource);
				if (result == null) result = caseResource(cH_HwComputingResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HardwareBaselinePackage.DATA_TYPE_ASSIGN: {
				DataTypeAssign dataTypeAssign = (DataTypeAssign)theEObject;
				T result = caseDataTypeAssign(dataTypeAssign);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CH Hw Processor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CH Hw Processor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCH_HwProcessor(CH_HwProcessor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>HW Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>HW Data Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHWDataType(HWDataType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Type Execution</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Type Execution</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataTypeExecution(DataTypeExecution object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compute Complexity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compute Complexity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComputeComplexity(ComputeComplexity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SW Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SW Data Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSWDataType(SWDataType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Count</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Count</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperationCount(OperationCount object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CH Control Flow</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CH Control Flow</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCHControlFlow(CHControlFlow object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Float SW Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Float SW Data Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFloatSWDataType(FloatSWDataType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fixed SW Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fixed SW Data Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFixedSWDataType(FixedSWDataType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer SW Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer SW Data Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntegerSWDataType(IntegerSWDataType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Char SW Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Char SW Data Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCharSWDataType(CharSWDataType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean SW Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean SW Data Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanSWDataType(BooleanSWDataType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CH Hw Bus</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CH Hw Bus</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCH_HwBus(CH_HwBus object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CH Hw Computing Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CH Hw Computing Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCH_HwComputingResource(CH_HwComputingResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Type Assign</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Type Assign</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataTypeAssign(DataTypeAssign object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResource(Resource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hw Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hw Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHwResource(HwResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Processing Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Processing Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessingResource(ProcessingResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Computing Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Computing Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComputingResource(ComputingResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHwComputingResource(HwComputingResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hw Processor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hw Processor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHwProcessor(HwProcessor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Communication Media</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Communication Media</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommunicationMedia(CommunicationMedia object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHwCommunicationResource(HwCommunicationResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hw Media</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hw Media</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHwMedia(HwMedia object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hw Bus</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hw Bus</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHwBus(HwBus object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //HardwareBaselineSwitch
