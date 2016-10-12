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
package org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.polarsys.chess.chessmlprofile.ComponentModel.ComponentModelPackage;

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
 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RTComponentModelFactory
 * @model kind="package"
 * @generated
 */
public interface RTComponentModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "RTComponentModel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://CHESS/Predictability/RTComponentModel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "RTComponentModel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RTComponentModelPackage eINSTANCE = org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.RTComponentModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.CHRtPortSlotImpl <em>CH Rt Port Slot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.CHRtPortSlotImpl
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.RTComponentModelPackageImpl#getCHRtPortSlot()
	 * @generated
	 */
	int CH_RT_PORT_SLOT = 1;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.RunTimeSupportImpl <em>Run Time Support</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.RunTimeSupportImpl
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.RTComponentModelPackageImpl#getRunTimeSupport()
	 * @generated
	 */
	int RUN_TIME_SUPPORT = 2;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.CHRtSpecificationImpl <em>CH Rt Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.CHRtSpecificationImpl
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.RTComponentModelPackageImpl#getCHRtSpecification()
	 * @generated
	 */
	int CH_RT_SPECIFICATION = 0;

	/**
	 * The feature id for the '<em><b>Part With Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_RT_SPECIFICATION__PART_WITH_PORT = 0;

	/**
	 * The feature id for the '<em><b>WCET</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_RT_SPECIFICATION__WCET = 1;

	/**
	 * The feature id for the '<em><b>Local WCET</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_RT_SPECIFICATION__LOCAL_WCET = 2;

	/**
	 * The feature id for the '<em><b>Relative Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_RT_SPECIFICATION__RELATIVE_PRIORITY = 3;

	/**
	 * The feature id for the '<em><b>Ceiling</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_RT_SPECIFICATION__CEILING = 4;

	/**
	 * The feature id for the '<em><b>Memory Size Footprint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_RT_SPECIFICATION__MEMORY_SIZE_FOOTPRINT = 5;

	/**
	 * The feature id for the '<em><b>Stack Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_RT_SPECIFICATION__STACK_SIZE = 6;

	/**
	 * The feature id for the '<em><b>Heap Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_RT_SPECIFICATION__HEAP_SIZE = 7;

	/**
	 * The feature id for the '<em><b>Slot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_RT_SPECIFICATION__SLOT = 8;

	/**
	 * The feature id for the '<em><b>Base Comment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_RT_SPECIFICATION__BASE_COMMENT = 9;

	/**
	 * The feature id for the '<em><b>Occ Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_RT_SPECIFICATION__OCC_KIND = 10;

	/**
	 * The feature id for the '<em><b>Protection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_RT_SPECIFICATION__PROTECTION = 11;

	/**
	 * The feature id for the '<em><b>Rl Dl</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_RT_SPECIFICATION__RL_DL = 12;

	/**
	 * The feature id for the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_RT_SPECIFICATION__CONTEXT = 13;

	/**
	 * The feature id for the '<em><b>Resp T</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_RT_SPECIFICATION__RESP_T = 14;

	/**
	 * The feature id for the '<em><b>Block T</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_RT_SPECIFICATION__BLOCK_T = 15;

	/**
	 * The feature id for the '<em><b>Operation Req For Sporadic Occ</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_RT_SPECIFICATION__OPERATION_REQ_FOR_SPORADIC_OCC = 16;

	/**
	 * The number of structural features of the '<em>CH Rt Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_RT_SPECIFICATION_FEATURE_COUNT = 17;

	/**
	 * The feature id for the '<em><b>Base Slot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_RT_PORT_SLOT__BASE_SLOT = 0;

	/**
	 * The feature id for the '<em><b>CH Rt Specification</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_RT_PORT_SLOT__CH_RT_SPECIFICATION = 1;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_RT_PORT_SLOT__BASE_INSTANCE_SPECIFICATION = 2;

	/**
	 * The number of structural features of the '<em>CH Rt Port Slot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_RT_PORT_SLOT_FEATURE_COUNT = 3;

	/**
	 * The feature id for the '<em><b>Monitoring</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN_TIME_SUPPORT__MONITORING = 0;

	/**
	 * The feature id for the '<em><b>Verification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN_TIME_SUPPORT__VERIFICATION = 1;

	/**
	 * The feature id for the '<em><b>Base Comment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN_TIME_SUPPORT__BASE_COMMENT = 2;

	/**
	 * The number of structural features of the '<em>Run Time Support</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN_TIME_SUPPORT_FEATURE_COUNT = 3;


	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtPortSlot <em>CH Rt Port Slot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CH Rt Port Slot</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtPortSlot
	 * @generated
	 */
	EClass getCHRtPortSlot();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtPortSlot#getBase_Slot <em>Base Slot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Slot</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtPortSlot#getBase_Slot()
	 * @see #getCHRtPortSlot()
	 * @generated
	 */
	EReference getCHRtPortSlot_Base_Slot();

	/**
	 * Returns the meta object for the reference list '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtPortSlot#getCH_RtSpecification <em>CH Rt Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>CH Rt Specification</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtPortSlot#getCH_RtSpecification()
	 * @see #getCHRtPortSlot()
	 * @generated
	 */
	EReference getCHRtPortSlot_CH_RtSpecification();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtPortSlot#getBase_InstanceSpecification <em>Base Instance Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Instance Specification</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtPortSlot#getBase_InstanceSpecification()
	 * @see #getCHRtPortSlot()
	 * @generated
	 */
	EReference getCHRtPortSlot_Base_InstanceSpecification();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RunTimeSupport <em>Run Time Support</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Run Time Support</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RunTimeSupport
	 * @generated
	 */
	EClass getRunTimeSupport();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RunTimeSupport#isMonitoring <em>Monitoring</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Monitoring</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RunTimeSupport#isMonitoring()
	 * @see #getRunTimeSupport()
	 * @generated
	 */
	EAttribute getRunTimeSupport_Monitoring();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RunTimeSupport#isVerification <em>Verification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Verification</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RunTimeSupport#isVerification()
	 * @see #getRunTimeSupport()
	 * @generated
	 */
	EAttribute getRunTimeSupport_Verification();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RunTimeSupport#getBase_Comment <em>Base Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Comment</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RunTimeSupport#getBase_Comment()
	 * @see #getRunTimeSupport()
	 * @generated
	 */
	EReference getRunTimeSupport_Base_Comment();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification <em>CH Rt Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CH Rt Specification</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification
	 * @generated
	 */
	EClass getCHRtSpecification();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getPartWithPort <em>Part With Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Part With Port</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getPartWithPort()
	 * @see #getCHRtSpecification()
	 * @generated
	 */
	EReference getCHRtSpecification_PartWithPort();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getWCET <em>WCET</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>WCET</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getWCET()
	 * @see #getCHRtSpecification()
	 * @generated
	 */
	EAttribute getCHRtSpecification_WCET();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getLocalWCET <em>Local WCET</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Local WCET</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getLocalWCET()
	 * @see #getCHRtSpecification()
	 * @generated
	 */
	EAttribute getCHRtSpecification_LocalWCET();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getRelativePriority <em>Relative Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Relative Priority</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getRelativePriority()
	 * @see #getCHRtSpecification()
	 * @generated
	 */
	EAttribute getCHRtSpecification_RelativePriority();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getCeiling <em>Ceiling</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ceiling</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getCeiling()
	 * @see #getCHRtSpecification()
	 * @generated
	 */
	EAttribute getCHRtSpecification_Ceiling();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getMemorySizeFootprint <em>Memory Size Footprint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Memory Size Footprint</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getMemorySizeFootprint()
	 * @see #getCHRtSpecification()
	 * @generated
	 */
	EAttribute getCHRtSpecification_MemorySizeFootprint();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getStackSize <em>Stack Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stack Size</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getStackSize()
	 * @see #getCHRtSpecification()
	 * @generated
	 */
	EAttribute getCHRtSpecification_StackSize();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getHeapSize <em>Heap Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Heap Size</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getHeapSize()
	 * @see #getCHRtSpecification()
	 * @generated
	 */
	EAttribute getCHRtSpecification_HeapSize();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getSlot <em>Slot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Slot</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getSlot()
	 * @see #getCHRtSpecification()
	 * @generated
	 */
	EReference getCHRtSpecification_Slot();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getBase_Comment <em>Base Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Comment</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getBase_Comment()
	 * @see #getCHRtSpecification()
	 * @generated
	 */
	EReference getCHRtSpecification_Base_Comment();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getOccKind <em>Occ Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Occ Kind</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getOccKind()
	 * @see #getCHRtSpecification()
	 * @generated
	 */
	EAttribute getCHRtSpecification_OccKind();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getProtection <em>Protection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Protection</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getProtection()
	 * @see #getCHRtSpecification()
	 * @generated
	 */
	EAttribute getCHRtSpecification_Protection();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getRlDl <em>Rl Dl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rl Dl</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getRlDl()
	 * @see #getCHRtSpecification()
	 * @generated
	 */
	EAttribute getCHRtSpecification_RlDl();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Context</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getContext()
	 * @see #getCHRtSpecification()
	 * @generated
	 */
	EReference getCHRtSpecification_Context();

	/**
	 * Returns the meta object for the attribute list '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getRespT <em>Resp T</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Resp T</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getRespT()
	 * @see #getCHRtSpecification()
	 * @generated
	 */
	EAttribute getCHRtSpecification_RespT();

	/**
	 * Returns the meta object for the attribute list '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getBlockT <em>Block T</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Block T</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getBlockT()
	 * @see #getCHRtSpecification()
	 * @generated
	 */
	EAttribute getCHRtSpecification_BlockT();

	/**
	 * Returns the meta object for the reference list '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getOperationReqForSporadicOcc <em>Operation Req For Sporadic Occ</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Operation Req For Sporadic Occ</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getOperationReqForSporadicOcc()
	 * @see #getCHRtSpecification()
	 * @generated
	 */
	EReference getCHRtSpecification_OperationReqForSporadicOcc();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RTComponentModelFactory getRTComponentModelFactory();

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
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.CHRtPortSlotImpl <em>CH Rt Port Slot</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.CHRtPortSlotImpl
		 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.RTComponentModelPackageImpl#getCHRtPortSlot()
		 * @generated
		 */
		EClass CH_RT_PORT_SLOT = eINSTANCE.getCHRtPortSlot();

		/**
		 * The meta object literal for the '<em><b>Base Slot</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CH_RT_PORT_SLOT__BASE_SLOT = eINSTANCE.getCHRtPortSlot_Base_Slot();

		/**
		 * The meta object literal for the '<em><b>CH Rt Specification</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CH_RT_PORT_SLOT__CH_RT_SPECIFICATION = eINSTANCE.getCHRtPortSlot_CH_RtSpecification();

		/**
		 * The meta object literal for the '<em><b>Base Instance Specification</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CH_RT_PORT_SLOT__BASE_INSTANCE_SPECIFICATION = eINSTANCE.getCHRtPortSlot_Base_InstanceSpecification();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.RunTimeSupportImpl <em>Run Time Support</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.RunTimeSupportImpl
		 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.RTComponentModelPackageImpl#getRunTimeSupport()
		 * @generated
		 */
		EClass RUN_TIME_SUPPORT = eINSTANCE.getRunTimeSupport();

		/**
		 * The meta object literal for the '<em><b>Monitoring</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RUN_TIME_SUPPORT__MONITORING = eINSTANCE.getRunTimeSupport_Monitoring();

		/**
		 * The meta object literal for the '<em><b>Verification</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RUN_TIME_SUPPORT__VERIFICATION = eINSTANCE.getRunTimeSupport_Verification();

		/**
		 * The meta object literal for the '<em><b>Base Comment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RUN_TIME_SUPPORT__BASE_COMMENT = eINSTANCE.getRunTimeSupport_Base_Comment();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.CHRtSpecificationImpl <em>CH Rt Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.CHRtSpecificationImpl
		 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.RTComponentModelPackageImpl#getCHRtSpecification()
		 * @generated
		 */
		EClass CH_RT_SPECIFICATION = eINSTANCE.getCHRtSpecification();

		/**
		 * The meta object literal for the '<em><b>Part With Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CH_RT_SPECIFICATION__PART_WITH_PORT = eINSTANCE.getCHRtSpecification_PartWithPort();

		/**
		 * The meta object literal for the '<em><b>WCET</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CH_RT_SPECIFICATION__WCET = eINSTANCE.getCHRtSpecification_WCET();

		/**
		 * The meta object literal for the '<em><b>Local WCET</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CH_RT_SPECIFICATION__LOCAL_WCET = eINSTANCE.getCHRtSpecification_LocalWCET();

		/**
		 * The meta object literal for the '<em><b>Relative Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CH_RT_SPECIFICATION__RELATIVE_PRIORITY = eINSTANCE.getCHRtSpecification_RelativePriority();

		/**
		 * The meta object literal for the '<em><b>Ceiling</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CH_RT_SPECIFICATION__CEILING = eINSTANCE.getCHRtSpecification_Ceiling();

		/**
		 * The meta object literal for the '<em><b>Memory Size Footprint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CH_RT_SPECIFICATION__MEMORY_SIZE_FOOTPRINT = eINSTANCE.getCHRtSpecification_MemorySizeFootprint();

		/**
		 * The meta object literal for the '<em><b>Stack Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CH_RT_SPECIFICATION__STACK_SIZE = eINSTANCE.getCHRtSpecification_StackSize();

		/**
		 * The meta object literal for the '<em><b>Heap Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CH_RT_SPECIFICATION__HEAP_SIZE = eINSTANCE.getCHRtSpecification_HeapSize();

		/**
		 * The meta object literal for the '<em><b>Slot</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CH_RT_SPECIFICATION__SLOT = eINSTANCE.getCHRtSpecification_Slot();

		/**
		 * The meta object literal for the '<em><b>Base Comment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CH_RT_SPECIFICATION__BASE_COMMENT = eINSTANCE.getCHRtSpecification_Base_Comment();

		/**
		 * The meta object literal for the '<em><b>Occ Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CH_RT_SPECIFICATION__OCC_KIND = eINSTANCE.getCHRtSpecification_OccKind();

		/**
		 * The meta object literal for the '<em><b>Protection</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CH_RT_SPECIFICATION__PROTECTION = eINSTANCE.getCHRtSpecification_Protection();

		/**
		 * The meta object literal for the '<em><b>Rl Dl</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CH_RT_SPECIFICATION__RL_DL = eINSTANCE.getCHRtSpecification_RlDl();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CH_RT_SPECIFICATION__CONTEXT = eINSTANCE.getCHRtSpecification_Context();

		/**
		 * The meta object literal for the '<em><b>Resp T</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CH_RT_SPECIFICATION__RESP_T = eINSTANCE.getCHRtSpecification_RespT();

		/**
		 * The meta object literal for the '<em><b>Block T</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CH_RT_SPECIFICATION__BLOCK_T = eINSTANCE.getCHRtSpecification_BlockT();

		/**
		 * The meta object literal for the '<em><b>Operation Req For Sporadic Occ</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CH_RT_SPECIFICATION__OPERATION_REQ_FOR_SPORADIC_OCC = eINSTANCE.getCHRtSpecification_OperationReqForSporadicOcc();

	}

} //RTComponentModelPackage
