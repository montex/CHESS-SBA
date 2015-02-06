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
package org.polarsys.chess.chessmlprofile.Core;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage;

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
 * @see org.polarsys.chess.chessmlprofile.Core.CoreFactory
 * @model kind="package"
 * @generated
 */
public interface CorePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "Core";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://CHESS/Core";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "Core";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CorePackage eINSTANCE = org.polarsys.chess.chessmlprofile.Core.impl.CorePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Core.impl.CHESSImpl <em>CHESS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Core.impl.CHESSImpl
	 * @see org.polarsys.chess.chessmlprofile.Core.impl.CorePackageImpl#getCHESS()
	 * @generated
	 */
	int CHESS = 0;

	/**
	 * The feature id for the '<em><b>Base Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHESS__BASE_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Analysis View</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHESS__ANALYSIS_VIEW = 1;

	/**
	 * The feature id for the '<em><b>Deployment View</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHESS__DEPLOYMENT_VIEW = 2;

	/**
	 * The feature id for the '<em><b>Requirement View</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHESS__REQUIREMENT_VIEW = 3;

	/**
	 * The feature id for the '<em><b>Component View</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHESS__COMPONENT_VIEW = 4;

	/**
	 * The feature id for the '<em><b>System View</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHESS__SYSTEM_VIEW = 5;

	/**
	 * The feature id for the '<em><b>Psm View</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHESS__PSM_VIEW = 6;

	/**
	 * The number of structural features of the '<em>CHESS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHESS_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Core.impl.CHGaResourcePlatformImpl <em>CH Ga Resource Platform</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Core.impl.CHGaResourcePlatformImpl
	 * @see org.polarsys.chess.chessmlprofile.Core.impl.CorePackageImpl#getCHGaResourcePlatform()
	 * @generated
	 */
	int CH_GA_RESOURCE_PLATFORM = 1;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_GA_RESOURCE_PLATFORM__RESOURCES = GQAMPackage.GA_RESOURCES_PLATFORM__RESOURCES;

	/**
	 * The feature id for the '<em><b>Base Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_GA_RESOURCE_PLATFORM__BASE_CLASSIFIER = GQAMPackage.GA_RESOURCES_PLATFORM__BASE_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_GA_RESOURCE_PLATFORM__BASE_INSTANCE_SPECIFICATION = GQAMPackage.GA_RESOURCES_PLATFORM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_GA_RESOURCE_PLATFORM__BASE_PACKAGE = GQAMPackage.GA_RESOURCES_PLATFORM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>CH Ga Resource Platform</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CH_GA_RESOURCE_PLATFORM_FEATURE_COUNT = GQAMPackage.GA_RESOURCES_PLATFORM_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Core.impl.IdentifInstanceImpl <em>Identif Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Core.impl.IdentifInstanceImpl
	 * @see org.polarsys.chess.chessmlprofile.Core.impl.CorePackageImpl#getIdentifInstance()
	 * @generated
	 */
	int IDENTIF_INSTANCE = 2;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIF_INSTANCE__BASE_INSTANCE_SPECIFICATION = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIF_INSTANCE__ID = 1;

	/**
	 * The feature id for the '<em><b>Source Instance Spec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIF_INSTANCE__SOURCE_INSTANCE_SPEC = 2;

	/**
	 * The number of structural features of the '<em>Identif Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIF_INSTANCE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Core.impl.IdentifSlotImpl <em>Identif Slot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Core.impl.IdentifSlotImpl
	 * @see org.polarsys.chess.chessmlprofile.Core.impl.CorePackageImpl#getIdentifSlot()
	 * @generated
	 */
	int IDENTIF_SLOT = 3;

	/**
	 * The feature id for the '<em><b>Base Slot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIF_SLOT__BASE_SLOT = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIF_SLOT__ID = 1;

	/**
	 * The number of structural features of the '<em>Identif Slot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIF_SLOT_FEATURE_COUNT = 2;


	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Core.impl.MultiInstanceImpl <em>Multi Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Core.impl.MultiInstanceImpl
	 * @see org.polarsys.chess.chessmlprofile.Core.impl.CorePackageImpl#getMultiInstance()
	 * @generated
	 */
	int MULTI_INSTANCE = 4;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_INSTANCE__BASE_INSTANCE_SPECIFICATION = 0;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_INSTANCE__UPPER_BOUND = 1;

	/**
	 * The number of structural features of the '<em>Multi Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_INSTANCE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Core.impl.MultiSlotImpl <em>Multi Slot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Core.impl.MultiSlotImpl
	 * @see org.polarsys.chess.chessmlprofile.Core.impl.CorePackageImpl#getMultiSlot()
	 * @generated
	 */
	int MULTI_SLOT = 5;

	/**
	 * The feature id for the '<em><b>Base Slot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_SLOT__BASE_SLOT = 0;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_SLOT__UPPER_BOUND = 1;

	/**
	 * The number of structural features of the '<em>Multi Slot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_SLOT_FEATURE_COUNT = 2;


	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Core.impl.PSMPackageImpl <em>PSM Package</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Core.impl.PSMPackageImpl
	 * @see org.polarsys.chess.chessmlprofile.Core.impl.CorePackageImpl#getPSMPackage()
	 * @generated
	 */
	int PSM_PACKAGE = 6;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSM_PACKAGE__BASE_PACKAGE = 0;

	/**
	 * The feature id for the '<em><b>Analysis Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSM_PACKAGE__ANALYSIS_CONTEXT = 1;

	/**
	 * The number of structural features of the '<em>PSM Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSM_PACKAGE_FEATURE_COUNT = 2;


	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Core.impl.FunctionalPartitionsImpl <em>Functional Partitions</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Core.impl.FunctionalPartitionsImpl
	 * @see org.polarsys.chess.chessmlprofile.Core.impl.CorePackageImpl#getFunctionalPartitions()
	 * @generated
	 */
	int FUNCTIONAL_PARTITIONS = 7;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_PARTITIONS__BASE_PACKAGE = 0;

	/**
	 * The feature id for the '<em><b>Base Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_PARTITIONS__BASE_COMPONENT = 1;

	/**
	 * The number of structural features of the '<em>Functional Partitions</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_PARTITIONS_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Core.CHESS <em>CHESS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CHESS</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESS
	 * @generated
	 */
	EClass getCHESS();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Core.CHESS#getBase_Model <em>Base Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Model</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESS#getBase_Model()
	 * @see #getCHESS()
	 * @generated
	 */
	EReference getCHESS_Base_Model();

	/**
	 * Returns the meta object for the containment reference '{@link org.polarsys.chess.chessmlprofile.Core.CHESS#getAnalysisView <em>Analysis View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Analysis View</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESS#getAnalysisView()
	 * @see #getCHESS()
	 * @generated
	 */
	EReference getCHESS_AnalysisView();

	/**
	 * Returns the meta object for the containment reference '{@link org.polarsys.chess.chessmlprofile.Core.CHESS#getDeploymentView <em>Deployment View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Deployment View</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESS#getDeploymentView()
	 * @see #getCHESS()
	 * @generated
	 */
	EReference getCHESS_DeploymentView();

	/**
	 * Returns the meta object for the containment reference '{@link org.polarsys.chess.chessmlprofile.Core.CHESS#getRequirementView <em>Requirement View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Requirement View</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESS#getRequirementView()
	 * @see #getCHESS()
	 * @generated
	 */
	EReference getCHESS_RequirementView();

	/**
	 * Returns the meta object for the containment reference '{@link org.polarsys.chess.chessmlprofile.Core.CHESS#getComponentView <em>Component View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Component View</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESS#getComponentView()
	 * @see #getCHESS()
	 * @generated
	 */
	EReference getCHESS_ComponentView();

	/**
	 * Returns the meta object for the containment reference '{@link org.polarsys.chess.chessmlprofile.Core.CHESS#getSystemView <em>System View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>System View</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESS#getSystemView()
	 * @see #getCHESS()
	 * @generated
	 */
	EReference getCHESS_SystemView();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Core.CHESS#getPsmView <em>Psm View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Psm View</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESS#getPsmView()
	 * @see #getCHESS()
	 * @generated
	 */
	EReference getCHESS_PsmView();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Core.CHGaResourcePlatform <em>CH Ga Resource Platform</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CH Ga Resource Platform</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.CHGaResourcePlatform
	 * @generated
	 */
	EClass getCHGaResourcePlatform();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Core.CHGaResourcePlatform#getBase_InstanceSpecification <em>Base Instance Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Instance Specification</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.CHGaResourcePlatform#getBase_InstanceSpecification()
	 * @see #getCHGaResourcePlatform()
	 * @generated
	 */
	EReference getCHGaResourcePlatform_Base_InstanceSpecification();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Core.CHGaResourcePlatform#getBase_Package <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.CHGaResourcePlatform#getBase_Package()
	 * @see #getCHGaResourcePlatform()
	 * @generated
	 */
	EReference getCHGaResourcePlatform_Base_Package();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Core.IdentifInstance <em>Identif Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identif Instance</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.IdentifInstance
	 * @generated
	 */
	EClass getIdentifInstance();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Core.IdentifInstance#getBase_InstanceSpecification <em>Base Instance Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Instance Specification</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.IdentifInstance#getBase_InstanceSpecification()
	 * @see #getIdentifInstance()
	 * @generated
	 */
	EReference getIdentifInstance_Base_InstanceSpecification();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Core.IdentifInstance#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.IdentifInstance#getId()
	 * @see #getIdentifInstance()
	 * @generated
	 */
	EAttribute getIdentifInstance_Id();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Core.IdentifInstance#getSourceInstanceSpec <em>Source Instance Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Instance Spec</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.IdentifInstance#getSourceInstanceSpec()
	 * @see #getIdentifInstance()
	 * @generated
	 */
	EReference getIdentifInstance_SourceInstanceSpec();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Core.IdentifSlot <em>Identif Slot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identif Slot</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.IdentifSlot
	 * @generated
	 */
	EClass getIdentifSlot();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Core.IdentifSlot#getBase_Slot <em>Base Slot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Slot</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.IdentifSlot#getBase_Slot()
	 * @see #getIdentifSlot()
	 * @generated
	 */
	EReference getIdentifSlot_Base_Slot();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Core.IdentifSlot#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.IdentifSlot#getId()
	 * @see #getIdentifSlot()
	 * @generated
	 */
	EAttribute getIdentifSlot_Id();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Core.MultiInstance <em>Multi Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multi Instance</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.MultiInstance
	 * @generated
	 */
	EClass getMultiInstance();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Core.MultiInstance#getBase_InstanceSpecification <em>Base Instance Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Instance Specification</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.MultiInstance#getBase_InstanceSpecification()
	 * @see #getMultiInstance()
	 * @generated
	 */
	EReference getMultiInstance_Base_InstanceSpecification();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Core.MultiInstance#getUpperBound <em>Upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper Bound</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.MultiInstance#getUpperBound()
	 * @see #getMultiInstance()
	 * @generated
	 */
	EAttribute getMultiInstance_UpperBound();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Core.MultiSlot <em>Multi Slot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multi Slot</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.MultiSlot
	 * @generated
	 */
	EClass getMultiSlot();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Core.MultiSlot#getBase_Slot <em>Base Slot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Slot</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.MultiSlot#getBase_Slot()
	 * @see #getMultiSlot()
	 * @generated
	 */
	EReference getMultiSlot_Base_Slot();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Core.MultiSlot#getUpperBound <em>Upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper Bound</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.MultiSlot#getUpperBound()
	 * @see #getMultiSlot()
	 * @generated
	 */
	EAttribute getMultiSlot_UpperBound();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Core.PSMPackage <em>PSM Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PSM Package</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.PSMPackage
	 * @generated
	 */
	EClass getPSMPackage();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Core.PSMPackage#getBase_Package <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.PSMPackage#getBase_Package()
	 * @see #getPSMPackage()
	 * @generated
	 */
	EReference getPSMPackage_Base_Package();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Core.PSMPackage#getAnalysisContext <em>Analysis Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Analysis Context</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.PSMPackage#getAnalysisContext()
	 * @see #getPSMPackage()
	 * @generated
	 */
	EReference getPSMPackage_AnalysisContext();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Core.FunctionalPartitions <em>Functional Partitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Functional Partitions</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.FunctionalPartitions
	 * @generated
	 */
	EClass getFunctionalPartitions();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Core.FunctionalPartitions#getBase_Package <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.FunctionalPartitions#getBase_Package()
	 * @see #getFunctionalPartitions()
	 * @generated
	 */
	EReference getFunctionalPartitions_Base_Package();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Core.FunctionalPartitions#getBase_Component <em>Base Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Component</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Core.FunctionalPartitions#getBase_Component()
	 * @see #getFunctionalPartitions()
	 * @generated
	 */
	EReference getFunctionalPartitions_Base_Component();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CoreFactory getCoreFactory();

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
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Core.impl.CHESSImpl <em>CHESS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Core.impl.CHESSImpl
		 * @see org.polarsys.chess.chessmlprofile.Core.impl.CorePackageImpl#getCHESS()
		 * @generated
		 */
		EClass CHESS = eINSTANCE.getCHESS();

		/**
		 * The meta object literal for the '<em><b>Base Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHESS__BASE_MODEL = eINSTANCE.getCHESS_Base_Model();

		/**
		 * The meta object literal for the '<em><b>Analysis View</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHESS__ANALYSIS_VIEW = eINSTANCE.getCHESS_AnalysisView();

		/**
		 * The meta object literal for the '<em><b>Deployment View</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHESS__DEPLOYMENT_VIEW = eINSTANCE.getCHESS_DeploymentView();

		/**
		 * The meta object literal for the '<em><b>Requirement View</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHESS__REQUIREMENT_VIEW = eINSTANCE.getCHESS_RequirementView();

		/**
		 * The meta object literal for the '<em><b>Component View</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHESS__COMPONENT_VIEW = eINSTANCE.getCHESS_ComponentView();

		/**
		 * The meta object literal for the '<em><b>System View</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHESS__SYSTEM_VIEW = eINSTANCE.getCHESS_SystemView();

		/**
		 * The meta object literal for the '<em><b>Psm View</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHESS__PSM_VIEW = eINSTANCE.getCHESS_PsmView();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Core.impl.CHGaResourcePlatformImpl <em>CH Ga Resource Platform</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Core.impl.CHGaResourcePlatformImpl
		 * @see org.polarsys.chess.chessmlprofile.Core.impl.CorePackageImpl#getCHGaResourcePlatform()
		 * @generated
		 */
		EClass CH_GA_RESOURCE_PLATFORM = eINSTANCE.getCHGaResourcePlatform();

		/**
		 * The meta object literal for the '<em><b>Base Instance Specification</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CH_GA_RESOURCE_PLATFORM__BASE_INSTANCE_SPECIFICATION = eINSTANCE.getCHGaResourcePlatform_Base_InstanceSpecification();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CH_GA_RESOURCE_PLATFORM__BASE_PACKAGE = eINSTANCE.getCHGaResourcePlatform_Base_Package();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Core.impl.IdentifInstanceImpl <em>Identif Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Core.impl.IdentifInstanceImpl
		 * @see org.polarsys.chess.chessmlprofile.Core.impl.CorePackageImpl#getIdentifInstance()
		 * @generated
		 */
		EClass IDENTIF_INSTANCE = eINSTANCE.getIdentifInstance();

		/**
		 * The meta object literal for the '<em><b>Base Instance Specification</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IDENTIF_INSTANCE__BASE_INSTANCE_SPECIFICATION = eINSTANCE.getIdentifInstance_Base_InstanceSpecification();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IDENTIF_INSTANCE__ID = eINSTANCE.getIdentifInstance_Id();

		/**
		 * The meta object literal for the '<em><b>Source Instance Spec</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IDENTIF_INSTANCE__SOURCE_INSTANCE_SPEC = eINSTANCE.getIdentifInstance_SourceInstanceSpec();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Core.impl.IdentifSlotImpl <em>Identif Slot</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Core.impl.IdentifSlotImpl
		 * @see org.polarsys.chess.chessmlprofile.Core.impl.CorePackageImpl#getIdentifSlot()
		 * @generated
		 */
		EClass IDENTIF_SLOT = eINSTANCE.getIdentifSlot();

		/**
		 * The meta object literal for the '<em><b>Base Slot</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IDENTIF_SLOT__BASE_SLOT = eINSTANCE.getIdentifSlot_Base_Slot();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IDENTIF_SLOT__ID = eINSTANCE.getIdentifSlot_Id();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Core.impl.MultiInstanceImpl <em>Multi Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Core.impl.MultiInstanceImpl
		 * @see org.polarsys.chess.chessmlprofile.Core.impl.CorePackageImpl#getMultiInstance()
		 * @generated
		 */
		EClass MULTI_INSTANCE = eINSTANCE.getMultiInstance();

		/**
		 * The meta object literal for the '<em><b>Base Instance Specification</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTI_INSTANCE__BASE_INSTANCE_SPECIFICATION = eINSTANCE.getMultiInstance_Base_InstanceSpecification();

		/**
		 * The meta object literal for the '<em><b>Upper Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTI_INSTANCE__UPPER_BOUND = eINSTANCE.getMultiInstance_UpperBound();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Core.impl.MultiSlotImpl <em>Multi Slot</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Core.impl.MultiSlotImpl
		 * @see org.polarsys.chess.chessmlprofile.Core.impl.CorePackageImpl#getMultiSlot()
		 * @generated
		 */
		EClass MULTI_SLOT = eINSTANCE.getMultiSlot();

		/**
		 * The meta object literal for the '<em><b>Base Slot</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTI_SLOT__BASE_SLOT = eINSTANCE.getMultiSlot_Base_Slot();

		/**
		 * The meta object literal for the '<em><b>Upper Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTI_SLOT__UPPER_BOUND = eINSTANCE.getMultiSlot_UpperBound();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Core.impl.PSMPackageImpl <em>PSM Package</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Core.impl.PSMPackageImpl
		 * @see org.polarsys.chess.chessmlprofile.Core.impl.CorePackageImpl#getPSMPackage()
		 * @generated
		 */
		EClass PSM_PACKAGE = eINSTANCE.getPSMPackage();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PSM_PACKAGE__BASE_PACKAGE = eINSTANCE.getPSMPackage_Base_Package();

		/**
		 * The meta object literal for the '<em><b>Analysis Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PSM_PACKAGE__ANALYSIS_CONTEXT = eINSTANCE.getPSMPackage_AnalysisContext();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Core.impl.FunctionalPartitionsImpl <em>Functional Partitions</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Core.impl.FunctionalPartitionsImpl
		 * @see org.polarsys.chess.chessmlprofile.Core.impl.CorePackageImpl#getFunctionalPartitions()
		 * @generated
		 */
		EClass FUNCTIONAL_PARTITIONS = eINSTANCE.getFunctionalPartitions();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTIONAL_PARTITIONS__BASE_PACKAGE = eINSTANCE.getFunctionalPartitions_Base_Package();

		/**
		 * The meta object literal for the '<em><b>Base Component</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTIONAL_PARTITIONS__BASE_COMPONENT = eINSTANCE.getFunctionalPartitions_Base_Component();

	}

} //CorePackage
