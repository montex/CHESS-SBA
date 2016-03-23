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
	 * The feature id for the '<em><b>Utilization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_PROCESSOR__UTILIZATION = HwComputingPackage.HW_PROCESSOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CH Hw Processor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_HW_PROCESSOR_FEATURE_COUNT = HwComputingPackage.HW_PROCESSOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.CH_HwBusImpl <em>CH Hw Bus</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.CH_HwBusImpl
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.HardwareBaselinePackageImpl#getCH_HwBus()
	 * @generated
	 */
	int CH_HW_BUS = 1;

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
	int CH_HW_COMPUTING_RESOURCE = 2;

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
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CH_HwProcessor <em>CH Hw Processor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CH Hw Processor</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CH_HwProcessor
	 * @generated
	 */
	EClass getCH_HwProcessor();

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
		 * The meta object literal for the '<em><b>Utilization</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CH_HW_PROCESSOR__UTILIZATION = eINSTANCE.getCH_HwProcessor_Utilization();

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

	}

} //HardwareBaselinePackage
