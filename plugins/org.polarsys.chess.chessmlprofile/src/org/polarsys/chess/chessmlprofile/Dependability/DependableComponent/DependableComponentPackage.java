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
package org.polarsys.chess.chessmlprofile.Dependability.DependableComponent;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponentFactory
 * @model kind="package"
 * @generated
 */
public interface DependableComponentPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "DependableComponent";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://CHESS/Dependability/DependableComponent";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "DependableComponent";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DependableComponentPackage eINSTANCE = org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.DependableComponentPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.PropagationImpl <em>Propagation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.PropagationImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.DependableComponentPackageImpl#getPropagation()
	 * @generated
	 */
	int PROPAGATION = 0;

	/**
	 * The feature id for the '<em><b>Prob</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION__PROB = 0;

	/**
	 * The feature id for the '<em><b>Prop Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION__PROP_DELAY = 1;

	/**
	 * The feature id for the '<em><b>Base Abstraction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION__BASE_ABSTRACTION = 2;

	/**
	 * The feature id for the '<em><b>Base Comment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION__BASE_COMMENT = 3;

	/**
	 * The feature id for the '<em><b>Base Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION__BASE_CONNECTOR = 4;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION__BASE_INSTANCE_SPECIFICATION = 5;

	/**
	 * The feature id for the '<em><b>Transf Funct</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION__TRANSF_FUNCT = 6;

	/**
	 * The feature id for the '<em><b>Base Transition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION__BASE_TRANSITION = 7;

	/**
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION__WEIGHT = 8;

	/**
	 * The number of structural features of the '<em>Propagation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_FEATURE_COUNT = 9;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.FailureModeGroupImpl <em>Failure Mode Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.FailureModeGroupImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.DependableComponentPackageImpl#getFailureModeGroup()
	 * @generated
	 */
	int FAILURE_MODE_GROUP = 1;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_MODE_GROUP__BASE_CLASS = 0;

	/**
	 * The feature id for the '<em><b>Failure Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_MODE_GROUP__FAILURE_MODE = 1;

	/**
	 * The number of structural features of the '<em>Failure Mode Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_MODE_GROUP_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.FailureModeImpl <em>Failure Mode</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.FailureModeImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.DependableComponentPackageImpl#getFailureMode()
	 * @generated
	 */
	int FAILURE_MODE = 2;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_MODE__BASE_CLASS = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_MODE__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Severity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_MODE__SEVERITY = 2;

	/**
	 * The feature id for the '<em><b>Exposure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_MODE__EXPOSURE = 3;

	/**
	 * The feature id for the '<em><b>Controllability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_MODE__CONTROLLABILITY = 4;

	/**
	 * The feature id for the '<em><b>Permanent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_MODE__PERMANENT = 5;

	/**
	 * The number of structural features of the '<em>Failure Mode</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_MODE_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.FailureModeSpecificationImpl <em>Failure Mode Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.FailureModeSpecificationImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.DependableComponentPackageImpl#getFailureModeSpecification()
	 * @generated
	 */
	int FAILURE_MODE_SPECIFICATION = 3;

	/**
	 * The feature id for the '<em><b>Base Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_MODE_SPECIFICATION__BASE_CONSTRAINT = 0;

	/**
	 * The feature id for the '<em><b>Base Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_MODE_SPECIFICATION__BASE_PORT = 1;

	/**
	 * The feature id for the '<em><b>Failure Mode Group</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_MODE_SPECIFICATION__FAILURE_MODE_GROUP = 2;

	/**
	 * The number of structural features of the '<em>Failure Mode Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_MODE_SPECIFICATION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.DependableComponentImpl <em>Dependable Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.DependableComponentImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.DependableComponentPackageImpl#getDependableComponent()
	 * @generated
	 */
	int DEPENDABLE_COMPONENT = 4;

	/**
	 * The feature id for the '<em><b>Base Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDABLE_COMPONENT__BASE_COMPONENT = 0;

	/**
	 * The feature id for the '<em><b>Error Model</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDABLE_COMPONENT__ERROR_MODEL = 1;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDABLE_COMPONENT__BASE_PROPERTY = 2;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDABLE_COMPONENT__BASE_INSTANCE_SPECIFICATION = 3;

	/**
	 * The number of structural features of the '<em>Dependable Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDABLE_COMPONENT_FEATURE_COUNT = 4;


	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.Propagation <em>Propagation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Propagation</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.Propagation
	 * @generated
	 */
	EClass getPropagation();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.Propagation#getProb <em>Prob</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prob</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.Propagation#getProb()
	 * @see #getPropagation()
	 * @generated
	 */
	EAttribute getPropagation_Prob();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.Propagation#getPropDelay <em>Prop Delay</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prop Delay</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.Propagation#getPropDelay()
	 * @see #getPropagation()
	 * @generated
	 */
	EAttribute getPropagation_PropDelay();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.Propagation#getBase_Abstraction <em>Base Abstraction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Abstraction</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.Propagation#getBase_Abstraction()
	 * @see #getPropagation()
	 * @generated
	 */
	EReference getPropagation_Base_Abstraction();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.Propagation#getBase_Comment <em>Base Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Comment</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.Propagation#getBase_Comment()
	 * @see #getPropagation()
	 * @generated
	 */
	EReference getPropagation_Base_Comment();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.Propagation#getBase_Connector <em>Base Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Connector</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.Propagation#getBase_Connector()
	 * @see #getPropagation()
	 * @generated
	 */
	EReference getPropagation_Base_Connector();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.Propagation#getBase_InstanceSpecification <em>Base Instance Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Instance Specification</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.Propagation#getBase_InstanceSpecification()
	 * @see #getPropagation()
	 * @generated
	 */
	EReference getPropagation_Base_InstanceSpecification();

	/**
	 * Returns the meta object for the attribute list '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.Propagation#getTransfFunct <em>Transf Funct</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Transf Funct</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.Propagation#getTransfFunct()
	 * @see #getPropagation()
	 * @generated
	 */
	EAttribute getPropagation_TransfFunct();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.Propagation#getBase_Transition <em>Base Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Transition</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.Propagation#getBase_Transition()
	 * @see #getPropagation()
	 * @generated
	 */
	EReference getPropagation_Base_Transition();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.Propagation#getWeight <em>Weight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Weight</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.Propagation#getWeight()
	 * @see #getPropagation()
	 * @generated
	 */
	EAttribute getPropagation_Weight();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.FailureModeGroup <em>Failure Mode Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Failure Mode Group</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.FailureModeGroup
	 * @generated
	 */
	EClass getFailureModeGroup();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.FailureModeGroup#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.FailureModeGroup#getBase_Class()
	 * @see #getFailureModeGroup()
	 * @generated
	 */
	EReference getFailureModeGroup_Base_Class();

	/**
	 * Returns the meta object for the reference list '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.FailureModeGroup#getFailureMode <em>Failure Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Failure Mode</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.FailureModeGroup#getFailureMode()
	 * @see #getFailureModeGroup()
	 * @generated
	 */
	EReference getFailureModeGroup_FailureMode();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.FailureMode <em>Failure Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Failure Mode</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.FailureMode
	 * @generated
	 */
	EClass getFailureMode();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.FailureMode#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.FailureMode#getBase_Class()
	 * @see #getFailureMode()
	 * @generated
	 */
	EReference getFailureMode_Base_Class();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.FailureMode#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.FailureMode#getDescription()
	 * @see #getFailureMode()
	 * @generated
	 */
	EAttribute getFailureMode_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.FailureMode#getSeverity <em>Severity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Severity</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.FailureMode#getSeverity()
	 * @see #getFailureMode()
	 * @generated
	 */
	EAttribute getFailureMode_Severity();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.FailureMode#getExposure <em>Exposure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exposure</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.FailureMode#getExposure()
	 * @see #getFailureMode()
	 * @generated
	 */
	EAttribute getFailureMode_Exposure();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.FailureMode#getControllability <em>Controllability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Controllability</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.FailureMode#getControllability()
	 * @see #getFailureMode()
	 * @generated
	 */
	EAttribute getFailureMode_Controllability();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.FailureMode#isPermanent <em>Permanent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Permanent</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.FailureMode#isPermanent()
	 * @see #getFailureMode()
	 * @generated
	 */
	EAttribute getFailureMode_Permanent();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.FailureModeSpecification <em>Failure Mode Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Failure Mode Specification</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.FailureModeSpecification
	 * @generated
	 */
	EClass getFailureModeSpecification();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.FailureModeSpecification#getBase_Constraint <em>Base Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Constraint</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.FailureModeSpecification#getBase_Constraint()
	 * @see #getFailureModeSpecification()
	 * @generated
	 */
	EReference getFailureModeSpecification_Base_Constraint();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.FailureModeSpecification#getBase_Port <em>Base Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Port</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.FailureModeSpecification#getBase_Port()
	 * @see #getFailureModeSpecification()
	 * @generated
	 */
	EReference getFailureModeSpecification_Base_Port();

	/**
	 * Returns the meta object for the reference list '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.FailureModeSpecification#getFailureModeGroup <em>Failure Mode Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Failure Mode Group</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.FailureModeSpecification#getFailureModeGroup()
	 * @see #getFailureModeSpecification()
	 * @generated
	 */
	EReference getFailureModeSpecification_FailureModeGroup();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponent <em>Dependable Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dependable Component</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponent
	 * @generated
	 */
	EClass getDependableComponent();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponent#getBase_Component <em>Base Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Component</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponent#getBase_Component()
	 * @see #getDependableComponent()
	 * @generated
	 */
	EReference getDependableComponent_Base_Component();

	/**
	 * Returns the meta object for the reference list '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponent#getErrorModel <em>Error Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Error Model</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponent#getErrorModel()
	 * @see #getDependableComponent()
	 * @generated
	 */
	EReference getDependableComponent_ErrorModel();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponent#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponent#getBase_Property()
	 * @see #getDependableComponent()
	 * @generated
	 */
	EReference getDependableComponent_Base_Property();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponent#getBase_InstanceSpecification <em>Base Instance Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Instance Specification</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponent#getBase_InstanceSpecification()
	 * @see #getDependableComponent()
	 * @generated
	 */
	EReference getDependableComponent_Base_InstanceSpecification();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DependableComponentFactory getDependableComponentFactory();

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
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.PropagationImpl <em>Propagation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.PropagationImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.DependableComponentPackageImpl#getPropagation()
		 * @generated
		 */
		EClass PROPAGATION = eINSTANCE.getPropagation();

		/**
		 * The meta object literal for the '<em><b>Prob</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPAGATION__PROB = eINSTANCE.getPropagation_Prob();

		/**
		 * The meta object literal for the '<em><b>Prop Delay</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPAGATION__PROP_DELAY = eINSTANCE.getPropagation_PropDelay();

		/**
		 * The meta object literal for the '<em><b>Base Abstraction</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPAGATION__BASE_ABSTRACTION = eINSTANCE.getPropagation_Base_Abstraction();

		/**
		 * The meta object literal for the '<em><b>Base Comment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPAGATION__BASE_COMMENT = eINSTANCE.getPropagation_Base_Comment();

		/**
		 * The meta object literal for the '<em><b>Base Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPAGATION__BASE_CONNECTOR = eINSTANCE.getPropagation_Base_Connector();

		/**
		 * The meta object literal for the '<em><b>Base Instance Specification</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPAGATION__BASE_INSTANCE_SPECIFICATION = eINSTANCE.getPropagation_Base_InstanceSpecification();

		/**
		 * The meta object literal for the '<em><b>Transf Funct</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPAGATION__TRANSF_FUNCT = eINSTANCE.getPropagation_TransfFunct();

		/**
		 * The meta object literal for the '<em><b>Base Transition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPAGATION__BASE_TRANSITION = eINSTANCE.getPropagation_Base_Transition();

		/**
		 * The meta object literal for the '<em><b>Weight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPAGATION__WEIGHT = eINSTANCE.getPropagation_Weight();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.FailureModeGroupImpl <em>Failure Mode Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.FailureModeGroupImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.DependableComponentPackageImpl#getFailureModeGroup()
		 * @generated
		 */
		EClass FAILURE_MODE_GROUP = eINSTANCE.getFailureModeGroup();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAILURE_MODE_GROUP__BASE_CLASS = eINSTANCE.getFailureModeGroup_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Failure Mode</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAILURE_MODE_GROUP__FAILURE_MODE = eINSTANCE.getFailureModeGroup_FailureMode();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.FailureModeImpl <em>Failure Mode</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.FailureModeImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.DependableComponentPackageImpl#getFailureMode()
		 * @generated
		 */
		EClass FAILURE_MODE = eINSTANCE.getFailureMode();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAILURE_MODE__BASE_CLASS = eINSTANCE.getFailureMode_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAILURE_MODE__DESCRIPTION = eINSTANCE.getFailureMode_Description();

		/**
		 * The meta object literal for the '<em><b>Severity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAILURE_MODE__SEVERITY = eINSTANCE.getFailureMode_Severity();

		/**
		 * The meta object literal for the '<em><b>Exposure</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAILURE_MODE__EXPOSURE = eINSTANCE.getFailureMode_Exposure();

		/**
		 * The meta object literal for the '<em><b>Controllability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAILURE_MODE__CONTROLLABILITY = eINSTANCE.getFailureMode_Controllability();

		/**
		 * The meta object literal for the '<em><b>Permanent</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAILURE_MODE__PERMANENT = eINSTANCE.getFailureMode_Permanent();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.FailureModeSpecificationImpl <em>Failure Mode Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.FailureModeSpecificationImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.DependableComponentPackageImpl#getFailureModeSpecification()
		 * @generated
		 */
		EClass FAILURE_MODE_SPECIFICATION = eINSTANCE.getFailureModeSpecification();

		/**
		 * The meta object literal for the '<em><b>Base Constraint</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAILURE_MODE_SPECIFICATION__BASE_CONSTRAINT = eINSTANCE.getFailureModeSpecification_Base_Constraint();

		/**
		 * The meta object literal for the '<em><b>Base Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAILURE_MODE_SPECIFICATION__BASE_PORT = eINSTANCE.getFailureModeSpecification_Base_Port();

		/**
		 * The meta object literal for the '<em><b>Failure Mode Group</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAILURE_MODE_SPECIFICATION__FAILURE_MODE_GROUP = eINSTANCE.getFailureModeSpecification_FailureModeGroup();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.DependableComponentImpl <em>Dependable Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.DependableComponentImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.DependableComponentPackageImpl#getDependableComponent()
		 * @generated
		 */
		EClass DEPENDABLE_COMPONENT = eINSTANCE.getDependableComponent();

		/**
		 * The meta object literal for the '<em><b>Base Component</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDABLE_COMPONENT__BASE_COMPONENT = eINSTANCE.getDependableComponent_Base_Component();

		/**
		 * The meta object literal for the '<em><b>Error Model</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDABLE_COMPONENT__ERROR_MODEL = eINSTANCE.getDependableComponent_ErrorModel();

		/**
		 * The meta object literal for the '<em><b>Base Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDABLE_COMPONENT__BASE_PROPERTY = eINSTANCE.getDependableComponent_Base_Property();

		/**
		 * The meta object literal for the '<em><b>Base Instance Specification</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDABLE_COMPONENT__BASE_INSTANCE_SPECIFICATION = eINSTANCE.getDependableComponent_Base_InstanceSpecification();

	}

} //DependableComponentPackage
