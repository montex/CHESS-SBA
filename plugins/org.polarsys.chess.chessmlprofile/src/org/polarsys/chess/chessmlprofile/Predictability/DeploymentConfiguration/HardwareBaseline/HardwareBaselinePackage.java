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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwCommunicationPackage;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwComputingPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.HardwareBaselineFactory
 * @model kind="package"
 * @generated
 */
public interface HardwareBaselinePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "HardwareBaseline";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://CHESS/Predictability/DeploymentConfiguration/HardwareBaseline";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "HardwareBaseline";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	HardwareBaselinePackage eINSTANCE = org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.HardwareBaselinePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.CH_HwProcessorImpl <em>CH Hw Processor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.CH_HwProcessorImpl
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.HardwareBaselinePackageImpl#getCH_HwProcessor()
	 * @generated
	 */
	int CH_HW_PROCESSOR = 0;

	/**
	 * The feature id for the '<em><b>Res Mult</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_PROCESSOR__RES_MULT = HwComputingPackage.HW_PROCESSOR__RES_MULT;

	/**
	 * The feature id for the '<em><b>Is Protected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_PROCESSOR__IS_PROTECTED = HwComputingPackage.HW_PROCESSOR__IS_PROTECTED;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_PROCESSOR__IS_ACTIVE = HwComputingPackage.HW_PROCESSOR__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_PROCESSOR__BASE_PROPERTY = HwComputingPackage.HW_PROCESSOR__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_PROCESSOR__BASE_INSTANCE_SPECIFICATION = HwComputingPackage.HW_PROCESSOR__BASE_INSTANCE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Base Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_PROCESSOR__BASE_CLASSIFIER = HwComputingPackage.HW_PROCESSOR__BASE_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Lifeline</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_PROCESSOR__BASE_LIFELINE = HwComputingPackage.HW_PROCESSOR__BASE_LIFELINE;

	/**
	 * The feature id for the '<em><b>Base Connectable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_PROCESSOR__BASE_CONNECTABLE_ELEMENT = HwComputingPackage.HW_PROCESSOR__BASE_CONNECTABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_PROCESSOR__DESCRIPTION = HwComputingPackage.HW_PROCESSOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>PHW Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_PROCESSOR__PHW_SERVICES = HwComputingPackage.HW_PROCESSOR__PHW_SERVICES;

	/**
	 * The feature id for the '<em><b>RHW Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_PROCESSOR__RHW_SERVICES = HwComputingPackage.HW_PROCESSOR__RHW_SERVICES;

	/**
	 * The feature id for the '<em><b>Owned HW</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_PROCESSOR__OWNED_HW = HwComputingPackage.HW_PROCESSOR__OWNED_HW;

	/**
	 * The feature id for the '<em><b>End Points</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_PROCESSOR__END_POINTS = HwComputingPackage.HW_PROCESSOR__END_POINTS;

	/**
	 * The feature id for the '<em><b>Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_PROCESSOR__FREQUENCY = HwComputingPackage.HW_PROCESSOR__FREQUENCY;

	/**
	 * The feature id for the '<em><b>Speed Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_PROCESSOR__SPEED_FACTOR = HwComputingPackage.HW_PROCESSOR__SPEED_FACTOR;

	/**
	 * The feature id for the '<em><b>Main Scheduler</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_PROCESSOR__MAIN_SCHEDULER = HwComputingPackage.HW_PROCESSOR__MAIN_SCHEDULER;

	/**
	 * The feature id for the '<em><b>Op Frequencies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_PROCESSOR__OP_FREQUENCIES = HwComputingPackage.HW_PROCESSOR__OP_FREQUENCIES;

	/**
	 * The feature id for the '<em><b>Architecture</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_PROCESSOR__ARCHITECTURE = HwComputingPackage.HW_PROCESSOR__ARCHITECTURE;

	/**
	 * The feature id for the '<em><b>Mips</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_PROCESSOR__MIPS = HwComputingPackage.HW_PROCESSOR__MIPS;

	/**
	 * The feature id for the '<em><b>Ipc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_PROCESSOR__IPC = HwComputingPackage.HW_PROCESSOR__IPC;

	/**
	 * The feature id for the '<em><b>Nb Cores</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_PROCESSOR__NB_CORES = HwComputingPackage.HW_PROCESSOR__NB_CORES;

	/**
	 * The feature id for the '<em><b>Nb Pipelines</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_PROCESSOR__NB_PIPELINES = HwComputingPackage.HW_PROCESSOR__NB_PIPELINES;

	/**
	 * The feature id for the '<em><b>Nb Stages</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_PROCESSOR__NB_STAGES = HwComputingPackage.HW_PROCESSOR__NB_STAGES;

	/**
	 * The feature id for the '<em><b>Nb AL Us</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_PROCESSOR__NB_AL_US = HwComputingPackage.HW_PROCESSOR__NB_AL_US;

	/**
	 * The feature id for the '<em><b>Nb FP Us</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_PROCESSOR__NB_FP_US = HwComputingPackage.HW_PROCESSOR__NB_FP_US;

	/**
	 * The feature id for the '<em><b>Owned IS As</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_PROCESSOR__OWNED_IS_AS = HwComputingPackage.HW_PROCESSOR__OWNED_IS_AS;

	/**
	 * The feature id for the '<em><b>Predictors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_PROCESSOR__PREDICTORS = HwComputingPackage.HW_PROCESSOR__PREDICTORS;

	/**
	 * The feature id for the '<em><b>Caches</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_PROCESSOR__CACHES = HwComputingPackage.HW_PROCESSOR__CACHES;

	/**
	 * The feature id for the '<em><b>Owned MM Us</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_PROCESSOR__OWNED_MM_US = HwComputingPackage.HW_PROCESSOR__OWNED_MM_US;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_PROCESSOR__DATA_TYPE = HwComputingPackage.HW_PROCESSOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Utilization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_PROCESSOR__UTILIZATION = HwComputingPackage.HW_PROCESSOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>CH Hw Processor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_PROCESSOR_FEATURE_COUNT = HwComputingPackage.HW_PROCESSOR_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.HWDataTypeImpl <em>HW Data Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.HWDataTypeImpl
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.HardwareBaselinePackageImpl#getHWDataType()
	 * @generated
	 */
	int HW_DATA_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_DATA_TYPE__BASE_DATA_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Bit Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_DATA_TYPE__BIT_LENGTH = 1;

	/**
	 * The feature id for the '<em><b>Signed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_DATA_TYPE__SIGNED = 2;

	/**
	 * The feature id for the '<em><b>Fixed Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_DATA_TYPE__FIXED_POINT = 3;

	/**
	 * The feature id for the '<em><b>Float</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_DATA_TYPE__FLOAT = 4;

	/**
	 * The feature id for the '<em><b>Execution</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_DATA_TYPE__EXECUTION = 5;

	/**
	 * The number of structural features of the '<em>HW Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_DATA_TYPE_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.DataTypeExecutionImpl <em>Data Type Execution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.DataTypeExecutionImpl
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.HardwareBaselinePackageImpl#getDataTypeExecution()
	 * @generated
	 */
	int DATA_TYPE_EXECUTION = 2;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_EXECUTION__BASE_CLASS = 0;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_EXECUTION__OPERATION = 1;

	/**
	 * The feature id for the '<em><b>Execution Cycles</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_EXECUTION__EXECUTION_CYCLES = 2;

	/**
	 * The number of structural features of the '<em>Data Type Execution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_EXECUTION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.ComputeComplexityImpl <em>Compute Complexity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.ComputeComplexityImpl
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.HardwareBaselinePackageImpl#getComputeComplexity()
	 * @generated
	 */
	int COMPUTE_COMPLEXITY = 3;

	/**
	 * The feature id for the '<em><b>Sw Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_COMPLEXITY__SW_DATA_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Op Count</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_COMPLEXITY__OP_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_COMPLEXITY__BASE_CLASS = 2;

	/**
	 * The number of structural features of the '<em>Compute Complexity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_COMPLEXITY_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.SWDataTypeImpl <em>SW Data Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.SWDataTypeImpl
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.HardwareBaselinePackageImpl#getSWDataType()
	 * @generated
	 */
	int SW_DATA_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_DATA_TYPE__BASE_DATA_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Bit Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_DATA_TYPE__BIT_SIZE = 1;

	/**
	 * The number of structural features of the '<em>SW Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_DATA_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.OperationCountImpl <em>Operation Count</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.OperationCountImpl
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.HardwareBaselinePackageImpl#getOperationCount()
	 * @generated
	 */
	int OPERATION_COUNT = 5;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_COUNT__OPERATION = 0;

	/**
	 * The feature id for the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_COUNT__COUNT = 1;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_COUNT__BASE_CLASS = 2;

	/**
	 * The number of structural features of the '<em>Operation Count</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_COUNT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.CHControlFlowImpl <em>CH Control Flow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.CHControlFlowImpl
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.HardwareBaselinePackageImpl#getCHControlFlow()
	 * @generated
	 */
	int CH_CONTROL_FLOW = 6;

	/**
	 * The feature id for the '<em><b>Base Control Flow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_CONTROL_FLOW__BASE_CONTROL_FLOW = 0;

	/**
	 * The feature id for the '<em><b>Rep</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_CONTROL_FLOW__REP = 1;

	/**
	 * The feature id for the '<em><b>Prob</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_CONTROL_FLOW__PROB = 2;

	/**
	 * The feature id for the '<em><b>Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_CONTROL_FLOW__ORDER = 3;

	/**
	 * The feature id for the '<em><b>Comp Complex</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_CONTROL_FLOW__COMP_COMPLEX = 4;

	/**
	 * The number of structural features of the '<em>CH Control Flow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_CONTROL_FLOW_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.FloatSWDataTypeImpl <em>Float SW Data Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.FloatSWDataTypeImpl
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.HardwareBaselinePackageImpl#getFloatSWDataType()
	 * @generated
	 */
	int FLOAT_SW_DATA_TYPE = 7;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOAT_SW_DATA_TYPE__BASE_DATA_TYPE = SW_DATA_TYPE__BASE_DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Bit Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOAT_SW_DATA_TYPE__BIT_SIZE = SW_DATA_TYPE__BIT_SIZE;

	/**
	 * The feature id for the '<em><b>Signed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOAT_SW_DATA_TYPE__SIGNED = SW_DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Float SW Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOAT_SW_DATA_TYPE_FEATURE_COUNT = SW_DATA_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.FixedSWDataTypeImpl <em>Fixed SW Data Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.FixedSWDataTypeImpl
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.HardwareBaselinePackageImpl#getFixedSWDataType()
	 * @generated
	 */
	int FIXED_SW_DATA_TYPE = 8;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_SW_DATA_TYPE__BASE_DATA_TYPE = SW_DATA_TYPE__BASE_DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Bit Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_SW_DATA_TYPE__BIT_SIZE = SW_DATA_TYPE__BIT_SIZE;

	/**
	 * The feature id for the '<em><b>Signed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_SW_DATA_TYPE__SIGNED = SW_DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Fixed SW Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_SW_DATA_TYPE_FEATURE_COUNT = SW_DATA_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.IntegerSWDataTypeImpl <em>Integer SW Data Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.IntegerSWDataTypeImpl
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.HardwareBaselinePackageImpl#getIntegerSWDataType()
	 * @generated
	 */
	int INTEGER_SW_DATA_TYPE = 9;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_SW_DATA_TYPE__BASE_DATA_TYPE = SW_DATA_TYPE__BASE_DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Bit Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_SW_DATA_TYPE__BIT_SIZE = SW_DATA_TYPE__BIT_SIZE;

	/**
	 * The feature id for the '<em><b>Signed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_SW_DATA_TYPE__SIGNED = SW_DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Integer SW Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_SW_DATA_TYPE_FEATURE_COUNT = SW_DATA_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.CharSWDataTypeImpl <em>Char SW Data Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.CharSWDataTypeImpl
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.HardwareBaselinePackageImpl#getCharSWDataType()
	 * @generated
	 */
	int CHAR_SW_DATA_TYPE = 10;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHAR_SW_DATA_TYPE__BASE_DATA_TYPE = SW_DATA_TYPE__BASE_DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Bit Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHAR_SW_DATA_TYPE__BIT_SIZE = SW_DATA_TYPE__BIT_SIZE;

	/**
	 * The feature id for the '<em><b>Signed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHAR_SW_DATA_TYPE__SIGNED = SW_DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Char SW Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHAR_SW_DATA_TYPE_FEATURE_COUNT = SW_DATA_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.BooleanSWDataTypeImpl <em>Boolean SW Data Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.BooleanSWDataTypeImpl
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.HardwareBaselinePackageImpl#getBooleanSWDataType()
	 * @generated
	 */
	int BOOLEAN_SW_DATA_TYPE = 11;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_SW_DATA_TYPE__BASE_DATA_TYPE = SW_DATA_TYPE__BASE_DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Bit Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_SW_DATA_TYPE__BIT_SIZE = SW_DATA_TYPE__BIT_SIZE;

	/**
	 * The number of structural features of the '<em>Boolean SW Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_SW_DATA_TYPE_FEATURE_COUNT = SW_DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.CH_HwBusImpl <em>CH Hw Bus</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.CH_HwBusImpl
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.HardwareBaselinePackageImpl#getCH_HwBus()
	 * @generated
	 */
	int CH_HW_BUS = 12;

	/**
	 * The feature id for the '<em><b>Res Mult</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_BUS__RES_MULT = HwCommunicationPackage.HW_BUS__RES_MULT;

	/**
	 * The feature id for the '<em><b>Is Protected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_BUS__IS_PROTECTED = HwCommunicationPackage.HW_BUS__IS_PROTECTED;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_BUS__IS_ACTIVE = HwCommunicationPackage.HW_BUS__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_BUS__BASE_PROPERTY = HwCommunicationPackage.HW_BUS__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_BUS__BASE_INSTANCE_SPECIFICATION = HwCommunicationPackage.HW_BUS__BASE_INSTANCE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Base Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_BUS__BASE_CLASSIFIER = HwCommunicationPackage.HW_BUS__BASE_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Lifeline</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_BUS__BASE_LIFELINE = HwCommunicationPackage.HW_BUS__BASE_LIFELINE;

	/**
	 * The feature id for the '<em><b>Base Connectable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_BUS__BASE_CONNECTABLE_ELEMENT = HwCommunicationPackage.HW_BUS__BASE_CONNECTABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Speed Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_BUS__SPEED_FACTOR = HwCommunicationPackage.HW_BUS__SPEED_FACTOR;

	/**
	 * The feature id for the '<em><b>Main Scheduler</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_BUS__MAIN_SCHEDULER = HwCommunicationPackage.HW_BUS__MAIN_SCHEDULER;

	/**
	 * The feature id for the '<em><b>Element Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_BUS__ELEMENT_SIZE = HwCommunicationPackage.HW_BUS__ELEMENT_SIZE;

	/**
	 * The feature id for the '<em><b>Base Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_BUS__BASE_CONNECTOR = HwCommunicationPackage.HW_BUS__BASE_CONNECTOR;

	/**
	 * The feature id for the '<em><b>Transm Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_BUS__TRANSM_MODE = HwCommunicationPackage.HW_BUS__TRANSM_MODE;

	/**
	 * The feature id for the '<em><b>Block T</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_BUS__BLOCK_T = HwCommunicationPackage.HW_BUS__BLOCK_T;

	/**
	 * The feature id for the '<em><b>Packet T</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_BUS__PACKET_T = HwCommunicationPackage.HW_BUS__PACKET_T;

	/**
	 * The feature id for the '<em><b>Capacity</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_BUS__CAPACITY = HwCommunicationPackage.HW_BUS__CAPACITY;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_BUS__DESCRIPTION = HwCommunicationPackage.HW_BUS__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>PHW Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_BUS__PHW_SERVICES = HwCommunicationPackage.HW_BUS__PHW_SERVICES;

	/**
	 * The feature id for the '<em><b>RHW Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_BUS__RHW_SERVICES = HwCommunicationPackage.HW_BUS__RHW_SERVICES;

	/**
	 * The feature id for the '<em><b>Owned HW</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_BUS__OWNED_HW = HwCommunicationPackage.HW_BUS__OWNED_HW;

	/**
	 * The feature id for the '<em><b>End Points</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_BUS__END_POINTS = HwCommunicationPackage.HW_BUS__END_POINTS;

	/**
	 * The feature id for the '<em><b>Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_BUS__FREQUENCY = HwCommunicationPackage.HW_BUS__FREQUENCY;

	/**
	 * The feature id for the '<em><b>Band Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_BUS__BAND_WIDTH = HwCommunicationPackage.HW_BUS__BAND_WIDTH;

	/**
	 * The feature id for the '<em><b>Arbiters</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_BUS__ARBITERS = HwCommunicationPackage.HW_BUS__ARBITERS;

	/**
	 * The feature id for the '<em><b>Adress Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_BUS__ADRESS_WIDTH = HwCommunicationPackage.HW_BUS__ADRESS_WIDTH;

	/**
	 * The feature id for the '<em><b>Word Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_BUS__WORD_WIDTH = HwCommunicationPackage.HW_BUS__WORD_WIDTH;

	/**
	 * The feature id for the '<em><b>Is Synchronous</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_BUS__IS_SYNCHRONOUS = HwCommunicationPackage.HW_BUS__IS_SYNCHRONOUS;

	/**
	 * The feature id for the '<em><b>Is Serial</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_BUS__IS_SERIAL = HwCommunicationPackage.HW_BUS__IS_SERIAL;

	/**
	 * The feature id for the '<em><b>Utilization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_BUS__UTILIZATION = HwCommunicationPackage.HW_BUS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CH Hw Bus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_BUS_FEATURE_COUNT = HwCommunicationPackage.HW_BUS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.CH_HwComputingResourceImpl <em>CH Hw Computing Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.CH_HwComputingResourceImpl
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.HardwareBaselinePackageImpl#getCH_HwComputingResource()
	 * @generated
	 */
	int CH_HW_COMPUTING_RESOURCE = 13;

	/**
	 * The feature id for the '<em><b>Res Mult</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_COMPUTING_RESOURCE__RES_MULT = HwComputingPackage.HW_COMPUTING_RESOURCE__RES_MULT;

	/**
	 * The feature id for the '<em><b>Is Protected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_COMPUTING_RESOURCE__IS_PROTECTED = HwComputingPackage.HW_COMPUTING_RESOURCE__IS_PROTECTED;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_COMPUTING_RESOURCE__IS_ACTIVE = HwComputingPackage.HW_COMPUTING_RESOURCE__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_COMPUTING_RESOURCE__BASE_PROPERTY = HwComputingPackage.HW_COMPUTING_RESOURCE__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_COMPUTING_RESOURCE__BASE_INSTANCE_SPECIFICATION = HwComputingPackage.HW_COMPUTING_RESOURCE__BASE_INSTANCE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Base Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_COMPUTING_RESOURCE__BASE_CLASSIFIER = HwComputingPackage.HW_COMPUTING_RESOURCE__BASE_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Lifeline</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_COMPUTING_RESOURCE__BASE_LIFELINE = HwComputingPackage.HW_COMPUTING_RESOURCE__BASE_LIFELINE;

	/**
	 * The feature id for the '<em><b>Base Connectable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_COMPUTING_RESOURCE__BASE_CONNECTABLE_ELEMENT = HwComputingPackage.HW_COMPUTING_RESOURCE__BASE_CONNECTABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_COMPUTING_RESOURCE__DESCRIPTION = HwComputingPackage.HW_COMPUTING_RESOURCE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>PHW Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_COMPUTING_RESOURCE__PHW_SERVICES = HwComputingPackage.HW_COMPUTING_RESOURCE__PHW_SERVICES;

	/**
	 * The feature id for the '<em><b>RHW Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_COMPUTING_RESOURCE__RHW_SERVICES = HwComputingPackage.HW_COMPUTING_RESOURCE__RHW_SERVICES;

	/**
	 * The feature id for the '<em><b>Owned HW</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_COMPUTING_RESOURCE__OWNED_HW = HwComputingPackage.HW_COMPUTING_RESOURCE__OWNED_HW;

	/**
	 * The feature id for the '<em><b>End Points</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_COMPUTING_RESOURCE__END_POINTS = HwComputingPackage.HW_COMPUTING_RESOURCE__END_POINTS;

	/**
	 * The feature id for the '<em><b>Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_COMPUTING_RESOURCE__FREQUENCY = HwComputingPackage.HW_COMPUTING_RESOURCE__FREQUENCY;

	/**
	 * The feature id for the '<em><b>Speed Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_COMPUTING_RESOURCE__SPEED_FACTOR = HwComputingPackage.HW_COMPUTING_RESOURCE__SPEED_FACTOR;

	/**
	 * The feature id for the '<em><b>Main Scheduler</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_COMPUTING_RESOURCE__MAIN_SCHEDULER = HwComputingPackage.HW_COMPUTING_RESOURCE__MAIN_SCHEDULER;

	/**
	 * The feature id for the '<em><b>Op Frequencies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_COMPUTING_RESOURCE__OP_FREQUENCIES = HwComputingPackage.HW_COMPUTING_RESOURCE__OP_FREQUENCIES;

	/**
	 * The feature id for the '<em><b>Utilization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_COMPUTING_RESOURCE__UTILIZATION = HwComputingPackage.HW_COMPUTING_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CH Hw Computing Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_COMPUTING_RESOURCE_FEATURE_COUNT = HwComputingPackage.HW_COMPUTING_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.DataTypeAssignImpl <em>Data Type Assign</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.DataTypeAssignImpl
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.HardwareBaselinePackageImpl#getDataTypeAssign()
	 * @generated
	 */
	int DATA_TYPE_ASSIGN = 14;

	/**
	 * The feature id for the '<em><b>Base Comment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_ASSIGN__BASE_COMMENT = 0;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_ASSIGN__FROM = 1;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_ASSIGN__TO = 2;

	/**
	 * The number of structural features of the '<em>Data Type Assign</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_ASSIGN_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.BasicOperation <em>Basic Operation</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.BasicOperation
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.HardwareBaselinePackageImpl#getBasicOperation()
	 * @generated
	 */
	int BASIC_OPERATION = 15;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.BasicDataType <em>Basic Data Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.BasicDataType
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.HardwareBaselinePackageImpl#getBasicDataType()
	 * @generated
	 */
	int BASIC_DATA_TYPE = 16;


	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CH_HwProcessor <em>CH Hw Processor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CH Hw Processor</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CH_HwProcessor
	 * @generated
	 */
	EClass getCH_HwProcessor();

	/**
	 * Returns the meta object for the reference list '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CH_HwProcessor#getDataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Data Type</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CH_HwProcessor#getDataType()
	 * @see #getCH_HwProcessor()
	 * @generated
	 */
	EReference getCH_HwProcessor_DataType();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CH_HwProcessor#getUtilization <em>Utilization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Utilization</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CH_HwProcessor#getUtilization()
	 * @see #getCH_HwProcessor()
	 * @generated
	 */
	EAttribute getCH_HwProcessor_Utilization();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.HWDataType <em>HW Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>HW Data Type</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.HWDataType
	 * @generated
	 */
	EClass getHWDataType();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.HWDataType#getBase_DataType <em>Base Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Data Type</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.HWDataType#getBase_DataType()
	 * @see #getHWDataType()
	 * @generated
	 */
	EReference getHWDataType_Base_DataType();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.HWDataType#getBitLength <em>Bit Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bit Length</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.HWDataType#getBitLength()
	 * @see #getHWDataType()
	 * @generated
	 */
	EAttribute getHWDataType_BitLength();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.HWDataType#isSigned <em>Signed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Signed</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.HWDataType#isSigned()
	 * @see #getHWDataType()
	 * @generated
	 */
	EAttribute getHWDataType_Signed();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.HWDataType#isFixedPoint <em>Fixed Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fixed Point</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.HWDataType#isFixedPoint()
	 * @see #getHWDataType()
	 * @generated
	 */
	EAttribute getHWDataType_FixedPoint();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.HWDataType#isFloat <em>Float</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Float</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.HWDataType#isFloat()
	 * @see #getHWDataType()
	 * @generated
	 */
	EAttribute getHWDataType_Float();

	/**
	 * Returns the meta object for the reference list '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.HWDataType#getExecution <em>Execution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Execution</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.HWDataType#getExecution()
	 * @see #getHWDataType()
	 * @generated
	 */
	EReference getHWDataType_Execution();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.DataTypeExecution <em>Data Type Execution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type Execution</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.DataTypeExecution
	 * @generated
	 */
	EClass getDataTypeExecution();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.DataTypeExecution#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.DataTypeExecution#getBase_Class()
	 * @see #getDataTypeExecution()
	 * @generated
	 */
	EReference getDataTypeExecution_Base_Class();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.DataTypeExecution#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operation</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.DataTypeExecution#getOperation()
	 * @see #getDataTypeExecution()
	 * @generated
	 */
	EAttribute getDataTypeExecution_Operation();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.DataTypeExecution#getExecutionCycles <em>Execution Cycles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Execution Cycles</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.DataTypeExecution#getExecutionCycles()
	 * @see #getDataTypeExecution()
	 * @generated
	 */
	EAttribute getDataTypeExecution_ExecutionCycles();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.ComputeComplexity <em>Compute Complexity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compute Complexity</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.ComputeComplexity
	 * @generated
	 */
	EClass getComputeComplexity();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.ComputeComplexity#getSwDataType <em>Sw Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sw Data Type</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.ComputeComplexity#getSwDataType()
	 * @see #getComputeComplexity()
	 * @generated
	 */
	EReference getComputeComplexity_SwDataType();

	/**
	 * Returns the meta object for the reference list '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.ComputeComplexity#getOpCount <em>Op Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Op Count</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.ComputeComplexity#getOpCount()
	 * @see #getComputeComplexity()
	 * @generated
	 */
	EReference getComputeComplexity_OpCount();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.ComputeComplexity#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.ComputeComplexity#getBase_Class()
	 * @see #getComputeComplexity()
	 * @generated
	 */
	EReference getComputeComplexity_Base_Class();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.SWDataType <em>SW Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SW Data Type</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.SWDataType
	 * @generated
	 */
	EClass getSWDataType();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.SWDataType#getBase_DataType <em>Base Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Data Type</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.SWDataType#getBase_DataType()
	 * @see #getSWDataType()
	 * @generated
	 */
	EReference getSWDataType_Base_DataType();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.SWDataType#getBitSize <em>Bit Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bit Size</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.SWDataType#getBitSize()
	 * @see #getSWDataType()
	 * @generated
	 */
	EAttribute getSWDataType_BitSize();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.OperationCount <em>Operation Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Count</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.OperationCount
	 * @generated
	 */
	EClass getOperationCount();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.OperationCount#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operation</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.OperationCount#getOperation()
	 * @see #getOperationCount()
	 * @generated
	 */
	EAttribute getOperationCount_Operation();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.OperationCount#getCount <em>Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Count</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.OperationCount#getCount()
	 * @see #getOperationCount()
	 * @generated
	 */
	EAttribute getOperationCount_Count();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.OperationCount#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.OperationCount#getBase_Class()
	 * @see #getOperationCount()
	 * @generated
	 */
	EReference getOperationCount_Base_Class();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CHControlFlow <em>CH Control Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CH Control Flow</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CHControlFlow
	 * @generated
	 */
	EClass getCHControlFlow();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CHControlFlow#getBase_ControlFlow <em>Base Control Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Control Flow</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CHControlFlow#getBase_ControlFlow()
	 * @see #getCHControlFlow()
	 * @generated
	 */
	EReference getCHControlFlow_Base_ControlFlow();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CHControlFlow#getRep <em>Rep</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rep</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CHControlFlow#getRep()
	 * @see #getCHControlFlow()
	 * @generated
	 */
	EAttribute getCHControlFlow_Rep();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CHControlFlow#getProb <em>Prob</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prob</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CHControlFlow#getProb()
	 * @see #getCHControlFlow()
	 * @generated
	 */
	EAttribute getCHControlFlow_Prob();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CHControlFlow#getOrder <em>Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Order</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CHControlFlow#getOrder()
	 * @see #getCHControlFlow()
	 * @generated
	 */
	EAttribute getCHControlFlow_Order();

	/**
	 * Returns the meta object for the reference list '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CHControlFlow#getCompComplex <em>Comp Complex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Comp Complex</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CHControlFlow#getCompComplex()
	 * @see #getCHControlFlow()
	 * @generated
	 */
	EReference getCHControlFlow_CompComplex();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.FloatSWDataType <em>Float SW Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Float SW Data Type</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.FloatSWDataType
	 * @generated
	 */
	EClass getFloatSWDataType();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.FloatSWDataType#isSigned <em>Signed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Signed</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.FloatSWDataType#isSigned()
	 * @see #getFloatSWDataType()
	 * @generated
	 */
	EAttribute getFloatSWDataType_Signed();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.FixedSWDataType <em>Fixed SW Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fixed SW Data Type</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.FixedSWDataType
	 * @generated
	 */
	EClass getFixedSWDataType();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.FixedSWDataType#isSigned <em>Signed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Signed</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.FixedSWDataType#isSigned()
	 * @see #getFixedSWDataType()
	 * @generated
	 */
	EAttribute getFixedSWDataType_Signed();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.IntegerSWDataType <em>Integer SW Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer SW Data Type</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.IntegerSWDataType
	 * @generated
	 */
	EClass getIntegerSWDataType();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.IntegerSWDataType#isSigned <em>Signed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Signed</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.IntegerSWDataType#isSigned()
	 * @see #getIntegerSWDataType()
	 * @generated
	 */
	EAttribute getIntegerSWDataType_Signed();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CharSWDataType <em>Char SW Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Char SW Data Type</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CharSWDataType
	 * @generated
	 */
	EClass getCharSWDataType();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CharSWDataType#isSigned <em>Signed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Signed</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CharSWDataType#isSigned()
	 * @see #getCharSWDataType()
	 * @generated
	 */
	EAttribute getCharSWDataType_Signed();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.BooleanSWDataType <em>Boolean SW Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean SW Data Type</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.BooleanSWDataType
	 * @generated
	 */
	EClass getBooleanSWDataType();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CH_HwBus <em>CH Hw Bus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CH Hw Bus</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CH_HwBus
	 * @generated
	 */
	EClass getCH_HwBus();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CH_HwBus#getUtilization <em>Utilization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Utilization</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CH_HwBus#getUtilization()
	 * @see #getCH_HwBus()
	 * @generated
	 */
	EAttribute getCH_HwBus_Utilization();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CH_HwComputingResource <em>CH Hw Computing Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CH Hw Computing Resource</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CH_HwComputingResource
	 * @generated
	 */
	EClass getCH_HwComputingResource();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CH_HwComputingResource#getUtilization <em>Utilization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Utilization</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CH_HwComputingResource#getUtilization()
	 * @see #getCH_HwComputingResource()
	 * @generated
	 */
	EAttribute getCH_HwComputingResource_Utilization();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.DataTypeAssign <em>Data Type Assign</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type Assign</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.DataTypeAssign
	 * @generated
	 */
	EClass getDataTypeAssign();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.DataTypeAssign#getBase_Comment <em>Base Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Comment</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.DataTypeAssign#getBase_Comment()
	 * @see #getDataTypeAssign()
	 * @generated
	 */
	EReference getDataTypeAssign_Base_Comment();

	/**
	 * Returns the meta object for the reference list '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.DataTypeAssign#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>From</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.DataTypeAssign#getFrom()
	 * @see #getDataTypeAssign()
	 * @generated
	 */
	EReference getDataTypeAssign_From();

	/**
	 * Returns the meta object for the reference list '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.DataTypeAssign#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>To</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.DataTypeAssign#getTo()
	 * @see #getDataTypeAssign()
	 * @generated
	 */
	EReference getDataTypeAssign_To();

	/**
	 * Returns the meta object for enum '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.BasicOperation <em>Basic Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Basic Operation</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.BasicOperation
	 * @generated
	 */
	EEnum getBasicOperation();

	/**
	 * Returns the meta object for enum '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.BasicDataType <em>Basic Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Basic Data Type</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.BasicDataType
	 * @generated
	 */
	EEnum getBasicDataType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	HardwareBaselineFactory getHardwareBaselineFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.CH_HwProcessorImpl <em>CH Hw Processor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.CH_HwProcessorImpl
		 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.HardwareBaselinePackageImpl#getCH_HwProcessor()
		 * @generated
		 */
		EClass CH_HW_PROCESSOR = eINSTANCE.getCH_HwProcessor();

		/**
		 * The meta object literal for the '<em><b>Data Type</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CH_HW_PROCESSOR__DATA_TYPE = eINSTANCE.getCH_HwProcessor_DataType();

		/**
		 * The meta object literal for the '<em><b>Utilization</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CH_HW_PROCESSOR__UTILIZATION = eINSTANCE.getCH_HwProcessor_Utilization();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.HWDataTypeImpl <em>HW Data Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.HWDataTypeImpl
		 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.HardwareBaselinePackageImpl#getHWDataType()
		 * @generated
		 */
		EClass HW_DATA_TYPE = eINSTANCE.getHWDataType();

		/**
		 * The meta object literal for the '<em><b>Base Data Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HW_DATA_TYPE__BASE_DATA_TYPE = eINSTANCE.getHWDataType_Base_DataType();

		/**
		 * The meta object literal for the '<em><b>Bit Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HW_DATA_TYPE__BIT_LENGTH = eINSTANCE.getHWDataType_BitLength();

		/**
		 * The meta object literal for the '<em><b>Signed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HW_DATA_TYPE__SIGNED = eINSTANCE.getHWDataType_Signed();

		/**
		 * The meta object literal for the '<em><b>Fixed Point</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HW_DATA_TYPE__FIXED_POINT = eINSTANCE.getHWDataType_FixedPoint();

		/**
		 * The meta object literal for the '<em><b>Float</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HW_DATA_TYPE__FLOAT = eINSTANCE.getHWDataType_Float();

		/**
		 * The meta object literal for the '<em><b>Execution</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HW_DATA_TYPE__EXECUTION = eINSTANCE.getHWDataType_Execution();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.DataTypeExecutionImpl <em>Data Type Execution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.DataTypeExecutionImpl
		 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.HardwareBaselinePackageImpl#getDataTypeExecution()
		 * @generated
		 */
		EClass DATA_TYPE_EXECUTION = eINSTANCE.getDataTypeExecution();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_TYPE_EXECUTION__BASE_CLASS = eINSTANCE.getDataTypeExecution_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_TYPE_EXECUTION__OPERATION = eINSTANCE.getDataTypeExecution_Operation();

		/**
		 * The meta object literal for the '<em><b>Execution Cycles</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_TYPE_EXECUTION__EXECUTION_CYCLES = eINSTANCE.getDataTypeExecution_ExecutionCycles();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.ComputeComplexityImpl <em>Compute Complexity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.ComputeComplexityImpl
		 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.HardwareBaselinePackageImpl#getComputeComplexity()
		 * @generated
		 */
		EClass COMPUTE_COMPLEXITY = eINSTANCE.getComputeComplexity();

		/**
		 * The meta object literal for the '<em><b>Sw Data Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTE_COMPLEXITY__SW_DATA_TYPE = eINSTANCE.getComputeComplexity_SwDataType();

		/**
		 * The meta object literal for the '<em><b>Op Count</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTE_COMPLEXITY__OP_COUNT = eINSTANCE.getComputeComplexity_OpCount();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTE_COMPLEXITY__BASE_CLASS = eINSTANCE.getComputeComplexity_Base_Class();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.SWDataTypeImpl <em>SW Data Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.SWDataTypeImpl
		 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.HardwareBaselinePackageImpl#getSWDataType()
		 * @generated
		 */
		EClass SW_DATA_TYPE = eINSTANCE.getSWDataType();

		/**
		 * The meta object literal for the '<em><b>Base Data Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SW_DATA_TYPE__BASE_DATA_TYPE = eINSTANCE.getSWDataType_Base_DataType();

		/**
		 * The meta object literal for the '<em><b>Bit Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SW_DATA_TYPE__BIT_SIZE = eINSTANCE.getSWDataType_BitSize();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.OperationCountImpl <em>Operation Count</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.OperationCountImpl
		 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.HardwareBaselinePackageImpl#getOperationCount()
		 * @generated
		 */
		EClass OPERATION_COUNT = eINSTANCE.getOperationCount();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION_COUNT__OPERATION = eINSTANCE.getOperationCount_Operation();

		/**
		 * The meta object literal for the '<em><b>Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION_COUNT__COUNT = eINSTANCE.getOperationCount_Count();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_COUNT__BASE_CLASS = eINSTANCE.getOperationCount_Base_Class();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.CHControlFlowImpl <em>CH Control Flow</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.CHControlFlowImpl
		 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.HardwareBaselinePackageImpl#getCHControlFlow()
		 * @generated
		 */
		EClass CH_CONTROL_FLOW = eINSTANCE.getCHControlFlow();

		/**
		 * The meta object literal for the '<em><b>Base Control Flow</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CH_CONTROL_FLOW__BASE_CONTROL_FLOW = eINSTANCE.getCHControlFlow_Base_ControlFlow();

		/**
		 * The meta object literal for the '<em><b>Rep</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CH_CONTROL_FLOW__REP = eINSTANCE.getCHControlFlow_Rep();

		/**
		 * The meta object literal for the '<em><b>Prob</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CH_CONTROL_FLOW__PROB = eINSTANCE.getCHControlFlow_Prob();

		/**
		 * The meta object literal for the '<em><b>Order</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CH_CONTROL_FLOW__ORDER = eINSTANCE.getCHControlFlow_Order();

		/**
		 * The meta object literal for the '<em><b>Comp Complex</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CH_CONTROL_FLOW__COMP_COMPLEX = eINSTANCE.getCHControlFlow_CompComplex();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.FloatSWDataTypeImpl <em>Float SW Data Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.FloatSWDataTypeImpl
		 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.HardwareBaselinePackageImpl#getFloatSWDataType()
		 * @generated
		 */
		EClass FLOAT_SW_DATA_TYPE = eINSTANCE.getFloatSWDataType();

		/**
		 * The meta object literal for the '<em><b>Signed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FLOAT_SW_DATA_TYPE__SIGNED = eINSTANCE.getFloatSWDataType_Signed();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.FixedSWDataTypeImpl <em>Fixed SW Data Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.FixedSWDataTypeImpl
		 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.HardwareBaselinePackageImpl#getFixedSWDataType()
		 * @generated
		 */
		EClass FIXED_SW_DATA_TYPE = eINSTANCE.getFixedSWDataType();

		/**
		 * The meta object literal for the '<em><b>Signed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIXED_SW_DATA_TYPE__SIGNED = eINSTANCE.getFixedSWDataType_Signed();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.IntegerSWDataTypeImpl <em>Integer SW Data Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.IntegerSWDataTypeImpl
		 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.HardwareBaselinePackageImpl#getIntegerSWDataType()
		 * @generated
		 */
		EClass INTEGER_SW_DATA_TYPE = eINSTANCE.getIntegerSWDataType();

		/**
		 * The meta object literal for the '<em><b>Signed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_SW_DATA_TYPE__SIGNED = eINSTANCE.getIntegerSWDataType_Signed();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.CharSWDataTypeImpl <em>Char SW Data Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.CharSWDataTypeImpl
		 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.HardwareBaselinePackageImpl#getCharSWDataType()
		 * @generated
		 */
		EClass CHAR_SW_DATA_TYPE = eINSTANCE.getCharSWDataType();

		/**
		 * The meta object literal for the '<em><b>Signed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHAR_SW_DATA_TYPE__SIGNED = eINSTANCE.getCharSWDataType_Signed();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.BooleanSWDataTypeImpl <em>Boolean SW Data Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.BooleanSWDataTypeImpl
		 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.HardwareBaselinePackageImpl#getBooleanSWDataType()
		 * @generated
		 */
		EClass BOOLEAN_SW_DATA_TYPE = eINSTANCE.getBooleanSWDataType();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.CH_HwBusImpl <em>CH Hw Bus</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.CH_HwBusImpl
		 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.HardwareBaselinePackageImpl#getCH_HwBus()
		 * @generated
		 */
		EClass CH_HW_BUS = eINSTANCE.getCH_HwBus();

		/**
		 * The meta object literal for the '<em><b>Utilization</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CH_HW_BUS__UTILIZATION = eINSTANCE.getCH_HwBus_Utilization();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.CH_HwComputingResourceImpl <em>CH Hw Computing Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.CH_HwComputingResourceImpl
		 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.HardwareBaselinePackageImpl#getCH_HwComputingResource()
		 * @generated
		 */
		EClass CH_HW_COMPUTING_RESOURCE = eINSTANCE.getCH_HwComputingResource();

		/**
		 * The meta object literal for the '<em><b>Utilization</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CH_HW_COMPUTING_RESOURCE__UTILIZATION = eINSTANCE.getCH_HwComputingResource_Utilization();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.DataTypeAssignImpl <em>Data Type Assign</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.DataTypeAssignImpl
		 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.HardwareBaselinePackageImpl#getDataTypeAssign()
		 * @generated
		 */
		EClass DATA_TYPE_ASSIGN = eINSTANCE.getDataTypeAssign();

		/**
		 * The meta object literal for the '<em><b>Base Comment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_TYPE_ASSIGN__BASE_COMMENT = eINSTANCE.getDataTypeAssign_Base_Comment();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_TYPE_ASSIGN__FROM = eINSTANCE.getDataTypeAssign_From();

		/**
		 * The meta object literal for the '<em><b>To</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_TYPE_ASSIGN__TO = eINSTANCE.getDataTypeAssign_To();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.BasicOperation <em>Basic Operation</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.BasicOperation
		 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.HardwareBaselinePackageImpl#getBasicOperation()
		 * @generated
		 */
		EEnum BASIC_OPERATION = eINSTANCE.getBasicOperation();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.BasicDataType <em>Basic Data Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.BasicDataType
		 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.HardwareBaselinePackageImpl#getBasicDataType()
		 * @generated
		 */
		EEnum BASIC_DATA_TYPE = eINSTANCE.getBasicDataType();

	}

} //HardwareBaselinePackage
