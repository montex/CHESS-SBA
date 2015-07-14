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
package org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.HardwareBaselinePackage
 * @generated
 */
public interface HardwareBaselineFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	HardwareBaselineFactory eINSTANCE = org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.HardwareBaselineFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>CH Hw Processor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CH Hw Processor</em>'.
	 * @generated
	 */
	CH_HwProcessor createCH_HwProcessor();

	/**
	 * Returns a new object of class '<em>HW Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>HW Data Type</em>'.
	 * @generated
	 */
	HWDataType createHWDataType();

	/**
	 * Returns a new object of class '<em>Data Type Execution</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Type Execution</em>'.
	 * @generated
	 */
	DataTypeExecution createDataTypeExecution();

	/**
	 * Returns a new object of class '<em>Compute Complexity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compute Complexity</em>'.
	 * @generated
	 */
	ComputeComplexity createComputeComplexity();

	/**
	 * Returns a new object of class '<em>Operation Count</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operation Count</em>'.
	 * @generated
	 */
	OperationCount createOperationCount();

	/**
	 * Returns a new object of class '<em>CH Control Flow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CH Control Flow</em>'.
	 * @generated
	 */
	CHControlFlow createCHControlFlow();

	/**
	 * Returns a new object of class '<em>Float SW Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Float SW Data Type</em>'.
	 * @generated
	 */
	FloatSWDataType createFloatSWDataType();

	/**
	 * Returns a new object of class '<em>Fixed SW Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fixed SW Data Type</em>'.
	 * @generated
	 */
	FixedSWDataType createFixedSWDataType();

	/**
	 * Returns a new object of class '<em>Integer SW Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Integer SW Data Type</em>'.
	 * @generated
	 */
	IntegerSWDataType createIntegerSWDataType();

	/**
	 * Returns a new object of class '<em>Char SW Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Char SW Data Type</em>'.
	 * @generated
	 */
	CharSWDataType createCharSWDataType();

	/**
	 * Returns a new object of class '<em>Boolean SW Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean SW Data Type</em>'.
	 * @generated
	 */
	BooleanSWDataType createBooleanSWDataType();

	/**
	 * Returns a new object of class '<em>CH Hw Bus</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CH Hw Bus</em>'.
	 * @generated
	 */
	CH_HwBus createCH_HwBus();

	/**
	 * Returns a new object of class '<em>CH Hw Computing Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CH Hw Computing Resource</em>'.
	 * @generated
	 */
	CH_HwComputingResource createCH_HwComputingResource();

	/**
	 * Returns a new object of class '<em>Data Type Assign</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Type Assign</em>'.
	 * @generated
	 */
	DataTypeAssign createDataTypeAssign();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	HardwareBaselinePackage getHardwareBaselinePackage();

} //HardwareBaselineFactory
