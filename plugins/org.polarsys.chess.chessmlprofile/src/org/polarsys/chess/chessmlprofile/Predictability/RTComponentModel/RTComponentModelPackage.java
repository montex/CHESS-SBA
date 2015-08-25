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
	int CH_RT_PORT_SLOT = 0;

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
	 * The number of structural features of the '<em>CH Rt Port Slot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_RT_PORT_SLOT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.ARINCComponentImplImpl <em>ARINC Component Impl</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.ARINCComponentImplImpl
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.RTComponentModelPackageImpl#getARINCComponentImpl()
	 * @generated
	 */
	int ARINC_COMPONENT_IMPL = 1;

	/**
	 * The feature id for the '<em><b>Base Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARINC_COMPONENT_IMPL__BASE_COMPONENT = ComponentModelPackage.COMPONENT_IMPLEMENTATION__BASE_COMPONENT;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARINC_COMPONENT_IMPL__LANGUAGE = ComponentModelPackage.COMPONENT_IMPLEMENTATION__LANGUAGE;

	/**
	 * The feature id for the '<em><b>OS</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARINC_COMPONENT_IMPL__OS = ComponentModelPackage.COMPONENT_IMPLEMENTATION__OS;

	/**
	 * The feature id for the '<em><b>Source Code Location</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARINC_COMPONENT_IMPL__SOURCE_CODE_LOCATION = ComponentModelPackage.COMPONENT_IMPLEMENTATION__SOURCE_CODE_LOCATION;

	/**
	 * The number of structural features of the '<em>ARINC Component Impl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARINC_COMPONENT_IMPL_FEATURE_COUNT = ComponentModelPackage.COMPONENT_IMPLEMENTATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.ARINCProcessImpl <em>ARINC Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.ARINCProcessImpl
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.RTComponentModelPackageImpl#getARINCProcess()
	 * @generated
	 */
	int ARINC_PROCESS = 2;

	/**
	 * The feature id for the '<em><b>Base Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARINC_PROCESS__BASE_OPERATION = 0;

	/**
	 * The feature id for the '<em><b>Base Comment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARINC_PROCESS__BASE_COMMENT = 1;

	/**
	 * The feature id for the '<em><b>Operations Groups</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARINC_PROCESS__OPERATIONS_GROUPS = 2;

	/**
	 * The number of structural features of the '<em>ARINC Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARINC_PROCESS_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.ARINCFunctionImpl <em>ARINC Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.ARINCFunctionImpl
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.RTComponentModelPackageImpl#getARINCFunction()
	 * @generated
	 */
	int ARINC_FUNCTION = 3;

	/**
	 * The feature id for the '<em><b>Base Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARINC_FUNCTION__BASE_OPERATION = 0;

	/**
	 * The feature id for the '<em><b>Base Comment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARINC_FUNCTION__BASE_COMMENT = 1;

	/**
	 * The feature id for the '<em><b>Followed By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARINC_FUNCTION__FOLLOWED_BY = 2;

	/**
	 * The feature id for the '<em><b>Preceded By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARINC_FUNCTION__PRECEDED_BY = 3;

	/**
	 * The feature id for the '<em><b>Rate Divider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARINC_FUNCTION__RATE_DIVIDER = 4;

	/**
	 * The number of structural features of the '<em>ARINC Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARINC_FUNCTION_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.CHRtSpecificationImpl <em>CH Rt Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.CHRtSpecificationImpl
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.RTComponentModelPackageImpl#getCHRtSpecification()
	 * @generated
	 */
	int CH_RT_SPECIFICATION = 4;

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
	 * The number of structural features of the '<em>CH Rt Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_RT_SPECIFICATION_FEATURE_COUNT = 16;


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
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.ARINCComponentImpl <em>ARINC Component Impl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ARINC Component Impl</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.ARINCComponentImpl
	 * @generated
	 */
	EClass getARINCComponentImpl();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.ARINCProcess <em>ARINC Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ARINC Process</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.ARINCProcess
	 * @generated
	 */
	EClass getARINCProcess();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.ARINCProcess#getBase_Operation <em>Base Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Operation</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.ARINCProcess#getBase_Operation()
	 * @see #getARINCProcess()
	 * @generated
	 */
	EReference getARINCProcess_Base_Operation();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.ARINCProcess#getBase_Comment <em>Base Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Comment</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.ARINCProcess#getBase_Comment()
	 * @see #getARINCProcess()
	 * @generated
	 */
	EReference getARINCProcess_Base_Comment();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.ARINCProcess#getOperationsGroups <em>Operations Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operations Groups</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.ARINCProcess#getOperationsGroups()
	 * @see #getARINCProcess()
	 * @generated
	 */
	EAttribute getARINCProcess_OperationsGroups();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.ARINCFunction <em>ARINC Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ARINC Function</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.ARINCFunction
	 * @generated
	 */
	EClass getARINCFunction();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.ARINCFunction#getBase_Operation <em>Base Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Operation</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.ARINCFunction#getBase_Operation()
	 * @see #getARINCFunction()
	 * @generated
	 */
	EReference getARINCFunction_Base_Operation();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.ARINCFunction#getBase_Comment <em>Base Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Comment</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.ARINCFunction#getBase_Comment()
	 * @see #getARINCFunction()
	 * @generated
	 */
	EReference getARINCFunction_Base_Comment();

	/**
	 * Returns the meta object for the reference list '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.ARINCFunction#getFollowedBy <em>Followed By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Followed By</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.ARINCFunction#getFollowedBy()
	 * @see #getARINCFunction()
	 * @generated
	 */
	EReference getARINCFunction_FollowedBy();

	/**
	 * Returns the meta object for the reference list '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.ARINCFunction#getPrecededBy <em>Preceded By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Preceded By</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.ARINCFunction#getPrecededBy()
	 * @see #getARINCFunction()
	 * @generated
	 */
	EReference getARINCFunction_PrecededBy();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.ARINCFunction#getRateDivider <em>Rate Divider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rate Divider</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.ARINCFunction#getRateDivider()
	 * @see #getARINCFunction()
	 * @generated
	 */
	EAttribute getARINCFunction_RateDivider();

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
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.ARINCComponentImplImpl <em>ARINC Component Impl</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.ARINCComponentImplImpl
		 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.RTComponentModelPackageImpl#getARINCComponentImpl()
		 * @generated
		 */
		EClass ARINC_COMPONENT_IMPL = eINSTANCE.getARINCComponentImpl();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.ARINCProcessImpl <em>ARINC Process</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.ARINCProcessImpl
		 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.RTComponentModelPackageImpl#getARINCProcess()
		 * @generated
		 */
		EClass ARINC_PROCESS = eINSTANCE.getARINCProcess();

		/**
		 * The meta object literal for the '<em><b>Base Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARINC_PROCESS__BASE_OPERATION = eINSTANCE.getARINCProcess_Base_Operation();

		/**
		 * The meta object literal for the '<em><b>Base Comment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARINC_PROCESS__BASE_COMMENT = eINSTANCE.getARINCProcess_Base_Comment();

		/**
		 * The meta object literal for the '<em><b>Operations Groups</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARINC_PROCESS__OPERATIONS_GROUPS = eINSTANCE.getARINCProcess_OperationsGroups();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.ARINCFunctionImpl <em>ARINC Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.ARINCFunctionImpl
		 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.RTComponentModelPackageImpl#getARINCFunction()
		 * @generated
		 */
		EClass ARINC_FUNCTION = eINSTANCE.getARINCFunction();

		/**
		 * The meta object literal for the '<em><b>Base Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARINC_FUNCTION__BASE_OPERATION = eINSTANCE.getARINCFunction_Base_Operation();

		/**
		 * The meta object literal for the '<em><b>Base Comment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARINC_FUNCTION__BASE_COMMENT = eINSTANCE.getARINCFunction_Base_Comment();

		/**
		 * The meta object literal for the '<em><b>Followed By</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARINC_FUNCTION__FOLLOWED_BY = eINSTANCE.getARINCFunction_FollowedBy();

		/**
		 * The meta object literal for the '<em><b>Preceded By</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARINC_FUNCTION__PRECEDED_BY = eINSTANCE.getARINCFunction_PrecededBy();

		/**
		 * The meta object literal for the '<em><b>Rate Divider</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARINC_FUNCTION__RATE_DIVIDER = eINSTANCE.getARINCFunction_RateDivider();

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

	}

} //RTComponentModelPackage
