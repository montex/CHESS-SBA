/*******************************************************************************
 *                  CHESS core plugin
 *
 *               Copyright (C) 2011-2015
 *            Mälardalen University, Sweden
 *
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License
 *  v1.0 which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.polarsys.chess.fla.flamm;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.polarsys.chess.fla.flamm.FailureTypes.FailureTypesPackage;

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
 * @see org.polarsys.chess.fla.flamm.FlammFactory
 * @model kind="package"
 * @generated
 */
public class FlammPackage extends EPackageImpl {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNAME = "flamm";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNS_URI = "http://www.polarsys.org/chess/fla/flamm";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNS_PREFIX = "flamm";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final FlammPackage eINSTANCE = org.polarsys.chess.fla.flamm.FlammPackage.init();

	/**
	 * The meta object id for the '{@link org.polarsys.chess.fla.flamm.NamedElement <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.fla.flamm.NamedElement
	 * @see org.polarsys.chess.fla.flamm.FlammPackage#getNamedElement()
	 * @generated
	 */
	public static final int NAMED_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int NAMED_ELEMENT__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int NAMED_ELEMENT__NAME = 1;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int NAMED_ELEMENT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int NAMED_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.fla.flamm.FlaBehaviour <em>Fla Behaviour</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.fla.flamm.FlaBehaviour
	 * @see org.polarsys.chess.fla.flamm.FlammPackage#getFlaBehaviour()
	 * @generated
	 */
	public static final int FLA_BEHAVIOUR = 1;

	/**
	 * The number of structural features of the '<em>Fla Behaviour</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FLA_BEHAVIOUR_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Propagate Failures</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FLA_BEHAVIOUR___PROPAGATE_FAILURES = 0;

	/**
	 * The operation id for the '<em>Initialize</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FLA_BEHAVIOUR___INITIALIZE__BOOLEAN = 1;

	/**
	 * The number of operations of the '<em>Fla Behaviour</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FLA_BEHAVIOUR_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.fla.flamm.Component <em>Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.fla.flamm.Component
	 * @see org.polarsys.chess.fla.flamm.FlammPackage#getComponent()
	 * @generated
	 */
	public static final int COMPONENT = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int COMPONENT__ID = NAMED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int COMPONENT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Input Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int COMPONENT__INPUT_PORTS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Output Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int COMPONENT__OUTPUT_PORTS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int COMPONENT__PARENT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int COMPONENT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Propagate Failures</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int COMPONENT___PROPAGATE_FAILURES = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Initialize</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int COMPONENT___INITIALIZE__BOOLEAN = NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int COMPONENT_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.fla.flamm.CompositeComponent <em>Composite Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.fla.flamm.CompositeComponent
	 * @see org.polarsys.chess.fla.flamm.FlammPackage#getCompositeComponent()
	 * @generated
	 */
	public static final int COMPOSITE_COMPONENT = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int COMPOSITE_COMPONENT__ID = COMPONENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int COMPOSITE_COMPONENT__NAME = COMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>Input Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int COMPOSITE_COMPONENT__INPUT_PORTS = COMPONENT__INPUT_PORTS;

	/**
	 * The feature id for the '<em><b>Output Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int COMPOSITE_COMPONENT__OUTPUT_PORTS = COMPONENT__OUTPUT_PORTS;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int COMPOSITE_COMPONENT__PARENT = COMPONENT__PARENT;

	/**
	 * The feature id for the '<em><b>Components</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int COMPOSITE_COMPONENT__COMPONENTS = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Connections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int COMPOSITE_COMPONENT__CONNECTIONS = COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Composite Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int COMPOSITE_COMPONENT_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Propagate Failures</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int COMPOSITE_COMPONENT___PROPAGATE_FAILURES = COMPONENT___PROPAGATE_FAILURES;

	/**
	 * The operation id for the '<em>Initialize</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int COMPOSITE_COMPONENT___INITIALIZE__BOOLEAN = COMPONENT___INITIALIZE__BOOLEAN;

	/**
	 * The number of operations of the '<em>Composite Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int COMPOSITE_COMPONENT_OPERATION_COUNT = COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.fla.flamm.Port <em>Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.fla.flamm.Port
	 * @see org.polarsys.chess.fla.flamm.FlammPackage#getPort()
	 * @generated
	 */
	public static final int PORT = 5;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.fla.flamm.Connection <em>Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.fla.flamm.Connection
	 * @see org.polarsys.chess.fla.flamm.FlammPackage#getConnection()
	 * @generated
	 */
	public static final int CONNECTION = 6;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.fla.flamm.Rule <em>Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.fla.flamm.Rule
	 * @see org.polarsys.chess.fla.flamm.FlammPackage#getRule()
	 * @generated
	 */
	public static final int RULE = 7;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.fla.flamm.SimpleComponent <em>Simple Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.fla.flamm.SimpleComponent
	 * @see org.polarsys.chess.fla.flamm.FlammPackage#getSimpleComponent()
	 * @generated
	 */
	public static final int SIMPLE_COMPONENT = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SIMPLE_COMPONENT__ID = COMPONENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SIMPLE_COMPONENT__NAME = COMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>Input Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SIMPLE_COMPONENT__INPUT_PORTS = COMPONENT__INPUT_PORTS;

	/**
	 * The feature id for the '<em><b>Output Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SIMPLE_COMPONENT__OUTPUT_PORTS = COMPONENT__OUTPUT_PORTS;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SIMPLE_COMPONENT__PARENT = COMPONENT__PARENT;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SIMPLE_COMPONENT__RULES = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Simple Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SIMPLE_COMPONENT_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Propagate Failures</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SIMPLE_COMPONENT___PROPAGATE_FAILURES = COMPONENT___PROPAGATE_FAILURES;

	/**
	 * The operation id for the '<em>Initialize</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SIMPLE_COMPONENT___INITIALIZE__BOOLEAN = COMPONENT___INITIALIZE__BOOLEAN;

	/**
	 * The number of operations of the '<em>Simple Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SIMPLE_COMPONENT_OPERATION_COUNT = COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PORT__ID = NAMED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PORT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Connected Ports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PORT__CONNECTED_PORTS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Failures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PORT__FAILURES = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>New Failures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PORT__NEW_FAILURES = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PORT__OWNER = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Incoming Connections</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PORT__INCOMING_CONNECTIONS = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Outgoing Connections</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PORT__OUTGOING_CONNECTIONS = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PORT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The operation id for the '<em>Propagate Failures</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PORT___PROPAGATE_FAILURES = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Initialize</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PORT___INITIALIZE = NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PORT_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONNECTION__FROM = FLA_BEHAVIOUR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONNECTION__TO = FLA_BEHAVIOUR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONNECTION__RULES = FLA_BEHAVIOUR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONNECTION_FEATURE_COUNT = FLA_BEHAVIOUR_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Propagate Failures</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONNECTION___PROPAGATE_FAILURES = FLA_BEHAVIOUR___PROPAGATE_FAILURES;

	/**
	 * The operation id for the '<em>Initialize</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONNECTION___INITIALIZE__BOOLEAN = FLA_BEHAVIOUR___INITIALIZE__BOOLEAN;

	/**
	 * The number of operations of the '<em>Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONNECTION_OPERATION_COUNT = FLA_BEHAVIOUR_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Input Expression</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RULE__INPUT_EXPRESSION = 0;

	/**
	 * The feature id for the '<em><b>Output Expression</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RULE__OUTPUT_EXPRESSION = 1;

	/**
	 * The feature id for the '<em><b>Specificity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RULE__SPECIFICITY = 2;

	/**
	 * The number of structural features of the '<em>Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RULE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RULE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.fla.flamm.Expression <em>Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.fla.flamm.Expression
	 * @see org.polarsys.chess.fla.flamm.FlammPackage#getExpression()
	 * @generated
	 */
	public static final int EXPRESSION = 8;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int EXPRESSION__PORT = 0;

	/**
	 * The feature id for the '<em><b>Failures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int EXPRESSION__FAILURES = 1;

	/**
	 * The number of structural features of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int EXPRESSION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int EXPRESSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.fla.flamm.Failure <em>Failure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.fla.flamm.Failure
	 * @see org.polarsys.chess.fla.flamm.FlammPackage#getFailure()
	 * @generated
	 */
	public static final int FAILURE = 9;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FAILURE__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FAILURE__ID = 1;

	/**
	 * The feature id for the '<em><b>Acid Avoidable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FAILURE__ACID_AVOIDABLE = 2;

	/**
	 * The feature id for the '<em><b>Acid Mitigation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FAILURE__ACID_MITIGATION = 3;

	/**
	 * The feature id for the '<em><b>Previous Failures</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FAILURE__PREVIOUS_FAILURES = 4;

	/**
	 * The feature id for the '<em><b>Specialization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FAILURE__SPECIALIZATION = 5;

	/**
	 * The feature id for the '<em><b>Vulnerability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FAILURE__VULNERABILITY = 6;

	/**
	 * The feature id for the '<em><b>Attack</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FAILURE__ATTACK = 7;

	/**
	 * The number of structural features of the '<em>Failure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FAILURE_FEATURE_COUNT = 8;

	/**
	 * The number of operations of the '<em>Failure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FAILURE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.fla.flamm.ACIDavoidable <em>ACI Davoidable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.fla.flamm.ACIDavoidable
	 * @see org.polarsys.chess.fla.flamm.FlammPackage#getACIDavoidable()
	 * @generated
	 */
	public static final int ACI_DAVOIDABLE = 10;

	/**
	 * The feature id for the '<em><b>A</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ACI_DAVOIDABLE__A = 0;

	/**
	 * The feature id for the '<em><b>C</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ACI_DAVOIDABLE__C = 1;

	/**
	 * The feature id for the '<em><b>I</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ACI_DAVOIDABLE__I = 2;

	/**
	 * The feature id for the '<em><b>D</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ACI_DAVOIDABLE__D = 3;

	/**
	 * The number of structural features of the '<em>ACI Davoidable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ACI_DAVOIDABLE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>ACI Davoidable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ACI_DAVOIDABLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.fla.flamm.ACIDmitigation <em>ACI Dmitigation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.fla.flamm.ACIDmitigation
	 * @see org.polarsys.chess.fla.flamm.FlammPackage#getACIDmitigation()
	 * @generated
	 */
	public static final int ACI_DMITIGATION = 11;

	/**
	 * The feature id for the '<em><b>A</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ACI_DMITIGATION__A = 0;

	/**
	 * The feature id for the '<em><b>C</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ACI_DMITIGATION__C = 1;

	/**
	 * The feature id for the '<em><b>I</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ACI_DMITIGATION__I = 2;

	/**
	 * The feature id for the '<em><b>D</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ACI_DMITIGATION__D = 3;

	/**
	 * The number of structural features of the '<em>ACI Dmitigation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ACI_DMITIGATION_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>ACI Dmitigation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ACI_DMITIGATION_OPERATION_COUNT = 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeComponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flaBehaviourEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass portEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ruleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleComponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass failureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aciDavoidableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aciDmitigationEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.polarsys.chess.fla.flamm.FlammPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private FlammPackage() {
		super(eNS_URI, FlammFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link FlammPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static FlammPackage init() {
		if (isInited) return (FlammPackage)EPackage.Registry.INSTANCE.getEPackage(FlammPackage.eNS_URI);

		// Obtain or create and register package
		FlammPackage theFlammPackage = (FlammPackage)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof FlammPackage ? EPackage.Registry.INSTANCE.get(eNS_URI) : new FlammPackage());

		isInited = true;

		// Obtain or create and register interdependencies
		FailureTypesPackage theFailureTypesPackage = (FailureTypesPackage)(EPackage.Registry.INSTANCE.getEPackage(FailureTypesPackage.eNS_URI) instanceof FailureTypesPackage ? EPackage.Registry.INSTANCE.getEPackage(FailureTypesPackage.eNS_URI) : FailureTypesPackage.eINSTANCE);

		// Create package meta-data objects
		theFlammPackage.createPackageContents();
		theFailureTypesPackage.createPackageContents();

		// Initialize created meta-data
		theFlammPackage.initializePackageContents();
		theFailureTypesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theFlammPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(FlammPackage.eNS_URI, theFlammPackage);
		return theFlammPackage;
	}


	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.fla.flamm.Component <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component</em>'.
	 * @see org.polarsys.chess.fla.flamm.Component
	 * @generated
	 */
	public EClass getComponent() {
		return componentEClass;
	}

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.chess.fla.flamm.Component#getInputPorts <em>Input Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Input Ports</em>'.
	 * @see org.polarsys.chess.fla.flamm.Component#getInputPorts()
	 * @see #getComponent()
	 * @generated
	 */
	public EReference getComponent_InputPorts() {
		return (EReference)componentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.chess.fla.flamm.Component#getOutputPorts <em>Output Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Output Ports</em>'.
	 * @see org.polarsys.chess.fla.flamm.Component#getOutputPorts()
	 * @see #getComponent()
	 * @generated
	 */
	public EReference getComponent_OutputPorts() {
		return (EReference)componentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the container reference '{@link org.polarsys.chess.fla.flamm.Component#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see org.polarsys.chess.fla.flamm.Component#getParent()
	 * @see #getComponent()
	 * @generated
	 */
	public EReference getComponent_Parent() {
		return (EReference)componentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.fla.flamm.CompositeComponent <em>Composite Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Component</em>'.
	 * @see org.polarsys.chess.fla.flamm.CompositeComponent
	 * @generated
	 */
	public EClass getCompositeComponent() {
		return compositeComponentEClass;
	}

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.chess.fla.flamm.CompositeComponent#getComponents <em>Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Components</em>'.
	 * @see org.polarsys.chess.fla.flamm.CompositeComponent#getComponents()
	 * @see #getCompositeComponent()
	 * @generated
	 */
	public EReference getCompositeComponent_Components() {
		return (EReference)compositeComponentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.chess.fla.flamm.CompositeComponent#getConnections <em>Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Connections</em>'.
	 * @see org.polarsys.chess.fla.flamm.CompositeComponent#getConnections()
	 * @see #getCompositeComponent()
	 * @generated
	 */
	public EReference getCompositeComponent_Connections() {
		return (EReference)compositeComponentEClass.getEStructuralFeatures().get(1);
	}


	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.fla.flamm.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see org.polarsys.chess.fla.flamm.NamedElement
	 * @generated
	 */
	public EClass getNamedElement() {
		return namedElementEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.fla.flamm.NamedElement#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.polarsys.chess.fla.flamm.NamedElement#getId()
	 * @see #getNamedElement()
	 * @generated
	 */
	public EAttribute getNamedElement_Id() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.fla.flamm.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.polarsys.chess.fla.flamm.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	public EAttribute getNamedElement_Name() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.fla.flamm.FlaBehaviour <em>Fla Behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fla Behaviour</em>'.
	 * @see org.polarsys.chess.fla.flamm.FlaBehaviour
	 * @generated
	 */
	public EClass getFlaBehaviour() {
		return flaBehaviourEClass;
	}


	/**
	 * Returns the meta object for the '{@link org.polarsys.chess.fla.flamm.FlaBehaviour#propagateFailures() <em>Propagate Failures</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Propagate Failures</em>' operation.
	 * @see org.polarsys.chess.fla.flamm.FlaBehaviour#propagateFailures()
	 * @generated
	 */
	public EOperation getFlaBehaviour__PropagateFailures() {
		return flaBehaviourEClass.getEOperations().get(0);
	}


	/**
	 * Returns the meta object for the '{@link org.polarsys.chess.fla.flamm.FlaBehaviour#initialize(boolean) <em>Initialize</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Initialize</em>' operation.
	 * @see org.polarsys.chess.fla.flamm.FlaBehaviour#initialize(boolean)
	 * @generated
	 */
	public EOperation getFlaBehaviour__Initialize__boolean() {
		return flaBehaviourEClass.getEOperations().get(1);
	}


	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.fla.flamm.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port</em>'.
	 * @see org.polarsys.chess.fla.flamm.Port
	 * @generated
	 */
	public EClass getPort() {
		return portEClass;
	}

	/**
	 * Returns the meta object for the reference list '{@link org.polarsys.chess.fla.flamm.Port#getConnectedPorts <em>Connected Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Connected Ports</em>'.
	 * @see org.polarsys.chess.fla.flamm.Port#getConnectedPorts()
	 * @see #getPort()
	 * @generated
	 */
	public EReference getPort_ConnectedPorts() {
		return (EReference)portEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.chess.fla.flamm.Port#getFailures <em>Failures</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Failures</em>'.
	 * @see org.polarsys.chess.fla.flamm.Port#getFailures()
	 * @see #getPort()
	 * @generated
	 */
	public EReference getPort_Failures() {
		return (EReference)portEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.chess.fla.flamm.Port#getNewFailures <em>New Failures</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>New Failures</em>'.
	 * @see org.polarsys.chess.fla.flamm.Port#getNewFailures()
	 * @see #getPort()
	 * @generated
	 */
	public EReference getPort_NewFailures() {
		return (EReference)portEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.fla.flamm.Port#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Owner</em>'.
	 * @see org.polarsys.chess.fla.flamm.Port#getOwner()
	 * @see #getPort()
	 * @generated
	 */
	public EReference getPort_Owner() {
		return (EReference)portEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.fla.flamm.Port#getIncomingConnections <em>Incoming Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Incoming Connections</em>'.
	 * @see org.polarsys.chess.fla.flamm.Port#getIncomingConnections()
	 * @see #getPort()
	 * @generated
	 */
	public EReference getPort_IncomingConnections() {
		return (EReference)portEClass.getEStructuralFeatures().get(4);
	}


	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.fla.flamm.Port#getOutgoingConnections <em>Outgoing Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Outgoing Connections</em>'.
	 * @see org.polarsys.chess.fla.flamm.Port#getOutgoingConnections()
	 * @see #getPort()
	 * @generated
	 */
	public EReference getPort_OutgoingConnections() {
		return (EReference)portEClass.getEStructuralFeatures().get(5);
	}


	/**
	 * Returns the meta object for the '{@link org.polarsys.chess.fla.flamm.Port#propagateFailures() <em>Propagate Failures</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Propagate Failures</em>' operation.
	 * @see org.polarsys.chess.fla.flamm.Port#propagateFailures()
	 * @generated
	 */
	public EOperation getPort__PropagateFailures() {
		return portEClass.getEOperations().get(0);
	}


	/**
	 * Returns the meta object for the '{@link org.polarsys.chess.fla.flamm.Port#initialize() <em>Initialize</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Initialize</em>' operation.
	 * @see org.polarsys.chess.fla.flamm.Port#initialize()
	 * @generated
	 */
	public EOperation getPort__Initialize() {
		return portEClass.getEOperations().get(1);
	}


	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.fla.flamm.Connection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection</em>'.
	 * @see org.polarsys.chess.fla.flamm.Connection
	 * @generated
	 */
	public EClass getConnection() {
		return connectionEClass;
	}


	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.fla.flamm.Connection#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From</em>'.
	 * @see org.polarsys.chess.fla.flamm.Connection#getFrom()
	 * @see #getConnection()
	 * @generated
	 */
	public EReference getConnection_From() {
		return (EReference)connectionEClass.getEStructuralFeatures().get(0);
	}


	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.fla.flamm.Connection#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To</em>'.
	 * @see org.polarsys.chess.fla.flamm.Connection#getTo()
	 * @see #getConnection()
	 * @generated
	 */
	public EReference getConnection_To() {
		return (EReference)connectionEClass.getEStructuralFeatures().get(1);
	}


	/**
	 * Returns the meta object for the reference list '{@link org.polarsys.chess.fla.flamm.Connection#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Rules</em>'.
	 * @see org.polarsys.chess.fla.flamm.Connection#getRules()
	 * @see #getConnection()
	 * @generated
	 */
	public EReference getConnection_Rules() {
		return (EReference)connectionEClass.getEStructuralFeatures().get(2);
	}


	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.fla.flamm.Rule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule</em>'.
	 * @see org.polarsys.chess.fla.flamm.Rule
	 * @generated
	 */
	public EClass getRule() {
		return ruleEClass;
	}

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.chess.fla.flamm.Rule#getInputExpression <em>Input Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Input Expression</em>'.
	 * @see org.polarsys.chess.fla.flamm.Rule#getInputExpression()
	 * @see #getRule()
	 * @generated
	 */
	public EReference getRule_InputExpression() {
		return (EReference)ruleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.chess.fla.flamm.Rule#getOutputExpression <em>Output Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Output Expression</em>'.
	 * @see org.polarsys.chess.fla.flamm.Rule#getOutputExpression()
	 * @see #getRule()
	 * @generated
	 */
	public EReference getRule_OutputExpression() {
		return (EReference)ruleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.fla.flamm.Rule#getSpecificity <em>Specificity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Specificity</em>'.
	 * @see org.polarsys.chess.fla.flamm.Rule#getSpecificity()
	 * @see #getRule()
	 * @generated
	 */
	public EAttribute getRule_Specificity() {
		return (EAttribute)ruleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.fla.flamm.SimpleComponent <em>Simple Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Component</em>'.
	 * @see org.polarsys.chess.fla.flamm.SimpleComponent
	 * @generated
	 */
	public EClass getSimpleComponent() {
		return simpleComponentEClass;
	}

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.chess.fla.flamm.SimpleComponent#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rules</em>'.
	 * @see org.polarsys.chess.fla.flamm.SimpleComponent#getRules()
	 * @see #getSimpleComponent()
	 * @generated
	 */
	public EReference getSimpleComponent_Rules() {
		return (EReference)simpleComponentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.fla.flamm.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression</em>'.
	 * @see org.polarsys.chess.fla.flamm.Expression
	 * @generated
	 */
	public EClass getExpression() {
		return expressionEClass;
	}

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.fla.flamm.Expression#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Port</em>'.
	 * @see org.polarsys.chess.fla.flamm.Expression#getPort()
	 * @see #getExpression()
	 * @generated
	 */
	public EReference getExpression_Port() {
		return (EReference)expressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.chess.fla.flamm.Expression#getFailures <em>Failures</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Failures</em>'.
	 * @see org.polarsys.chess.fla.flamm.Expression#getFailures()
	 * @see #getExpression()
	 * @generated
	 */
	public EReference getExpression_Failures() {
		return (EReference)expressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.fla.flamm.Failure <em>Failure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Failure</em>'.
	 * @see org.polarsys.chess.fla.flamm.Failure
	 * @generated
	 */
	public EClass getFailure() {
		return failureEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.fla.flamm.Failure#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.polarsys.chess.fla.flamm.Failure#getType()
	 * @see #getFailure()
	 * @generated
	 */
	public EAttribute getFailure_Type() {
		return (EAttribute)failureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.fla.flamm.Failure#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.polarsys.chess.fla.flamm.Failure#getId()
	 * @see #getFailure()
	 * @generated
	 */
	public EAttribute getFailure_Id() {
		return (EAttribute)failureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the containment reference '{@link org.polarsys.chess.fla.flamm.Failure#getAcidAvoidable <em>Acid Avoidable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Acid Avoidable</em>'.
	 * @see org.polarsys.chess.fla.flamm.Failure#getAcidAvoidable()
	 * @see #getFailure()
	 * @generated
	 */
	public EReference getFailure_AcidAvoidable() {
		return (EReference)failureEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for the containment reference '{@link org.polarsys.chess.fla.flamm.Failure#getAcidMitigation <em>Acid Mitigation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Acid Mitigation</em>'.
	 * @see org.polarsys.chess.fla.flamm.Failure#getAcidMitigation()
	 * @see #getFailure()
	 * @generated
	 */
	public EReference getFailure_AcidMitigation() {
		return (EReference)failureEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * Returns the meta object for the reference list '{@link org.polarsys.chess.fla.flamm.Failure#getPreviousFailures <em>Previous Failures</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Previous Failures</em>'.
	 * @see org.polarsys.chess.fla.flamm.Failure#getPreviousFailures()
	 * @see #getFailure()
	 * @generated
	 */
	public EReference getFailure_PreviousFailures() {
		return (EReference)failureEClass.getEStructuralFeatures().get(4);
	}


	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.fla.flamm.Failure#getSpecialization <em>Specialization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Specialization</em>'.
	 * @see org.polarsys.chess.fla.flamm.Failure#getSpecialization()
	 * @see #getFailure()
	 * @generated
	 */
	public EAttribute getFailure_Specialization() {
		return (EAttribute)failureEClass.getEStructuralFeatures().get(5);
	}


	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.fla.flamm.Failure#getVulnerability <em>Vulnerability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vulnerability</em>'.
	 * @see org.polarsys.chess.fla.flamm.Failure#getVulnerability()
	 * @see #getFailure()
	 * @generated
	 */
	public EAttribute getFailure_Vulnerability() {
		return (EAttribute)failureEClass.getEStructuralFeatures().get(6);
	}


	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.fla.flamm.Failure#getAttack <em>Attack</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attack</em>'.
	 * @see org.polarsys.chess.fla.flamm.Failure#getAttack()
	 * @see #getFailure()
	 * @generated
	 */
	public EAttribute getFailure_Attack() {
		return (EAttribute)failureEClass.getEStructuralFeatures().get(7);
	}


	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.fla.flamm.ACIDavoidable <em>ACI Davoidable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ACI Davoidable</em>'.
	 * @see org.polarsys.chess.fla.flamm.ACIDavoidable
	 * @generated
	 */
	public EClass getACIDavoidable() {
		return aciDavoidableEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.fla.flamm.ACIDavoidable#getA <em>A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>A</em>'.
	 * @see org.polarsys.chess.fla.flamm.ACIDavoidable#getA()
	 * @see #getACIDavoidable()
	 * @generated
	 */
	public EAttribute getACIDavoidable_A() {
		return (EAttribute)aciDavoidableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.fla.flamm.ACIDavoidable#getC <em>C</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>C</em>'.
	 * @see org.polarsys.chess.fla.flamm.ACIDavoidable#getC()
	 * @see #getACIDavoidable()
	 * @generated
	 */
	public EAttribute getACIDavoidable_C() {
		return (EAttribute)aciDavoidableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.fla.flamm.ACIDavoidable#getI <em>I</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>I</em>'.
	 * @see org.polarsys.chess.fla.flamm.ACIDavoidable#getI()
	 * @see #getACIDavoidable()
	 * @generated
	 */
	public EAttribute getACIDavoidable_I() {
		return (EAttribute)aciDavoidableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.fla.flamm.ACIDavoidable#getD <em>D</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>D</em>'.
	 * @see org.polarsys.chess.fla.flamm.ACIDavoidable#getD()
	 * @see #getACIDavoidable()
	 * @generated
	 */
	public EAttribute getACIDavoidable_D() {
		return (EAttribute)aciDavoidableEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.fla.flamm.ACIDmitigation <em>ACI Dmitigation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ACI Dmitigation</em>'.
	 * @see org.polarsys.chess.fla.flamm.ACIDmitigation
	 * @generated
	 */
	public EClass getACIDmitigation() {
		return aciDmitigationEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.fla.flamm.ACIDmitigation#getA <em>A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>A</em>'.
	 * @see org.polarsys.chess.fla.flamm.ACIDmitigation#getA()
	 * @see #getACIDmitigation()
	 * @generated
	 */
	public EAttribute getACIDmitigation_A() {
		return (EAttribute)aciDmitigationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.fla.flamm.ACIDmitigation#getC <em>C</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>C</em>'.
	 * @see org.polarsys.chess.fla.flamm.ACIDmitigation#getC()
	 * @see #getACIDmitigation()
	 * @generated
	 */
	public EAttribute getACIDmitigation_C() {
		return (EAttribute)aciDmitigationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.fla.flamm.ACIDmitigation#getI <em>I</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>I</em>'.
	 * @see org.polarsys.chess.fla.flamm.ACIDmitigation#getI()
	 * @see #getACIDmitigation()
	 * @generated
	 */
	public EAttribute getACIDmitigation_I() {
		return (EAttribute)aciDmitigationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.fla.flamm.ACIDmitigation#getD <em>D</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>D</em>'.
	 * @see org.polarsys.chess.fla.flamm.ACIDmitigation#getD()
	 * @see #getACIDmitigation()
	 * @generated
	 */
	public EAttribute getACIDmitigation_D() {
		return (EAttribute)aciDmitigationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	public FlammFactory getFlammFactory() {
		return (FlammFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		namedElementEClass = createEClass(NAMED_ELEMENT);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__ID);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);

		flaBehaviourEClass = createEClass(FLA_BEHAVIOUR);
		createEOperation(flaBehaviourEClass, FLA_BEHAVIOUR___PROPAGATE_FAILURES);
		createEOperation(flaBehaviourEClass, FLA_BEHAVIOUR___INITIALIZE__BOOLEAN);

		componentEClass = createEClass(COMPONENT);
		createEReference(componentEClass, COMPONENT__INPUT_PORTS);
		createEReference(componentEClass, COMPONENT__OUTPUT_PORTS);
		createEReference(componentEClass, COMPONENT__PARENT);

		compositeComponentEClass = createEClass(COMPOSITE_COMPONENT);
		createEReference(compositeComponentEClass, COMPOSITE_COMPONENT__COMPONENTS);
		createEReference(compositeComponentEClass, COMPOSITE_COMPONENT__CONNECTIONS);

		simpleComponentEClass = createEClass(SIMPLE_COMPONENT);
		createEReference(simpleComponentEClass, SIMPLE_COMPONENT__RULES);

		portEClass = createEClass(PORT);
		createEReference(portEClass, PORT__CONNECTED_PORTS);
		createEReference(portEClass, PORT__FAILURES);
		createEReference(portEClass, PORT__NEW_FAILURES);
		createEReference(portEClass, PORT__OWNER);
		createEReference(portEClass, PORT__INCOMING_CONNECTIONS);
		createEReference(portEClass, PORT__OUTGOING_CONNECTIONS);
		createEOperation(portEClass, PORT___PROPAGATE_FAILURES);
		createEOperation(portEClass, PORT___INITIALIZE);

		connectionEClass = createEClass(CONNECTION);
		createEReference(connectionEClass, CONNECTION__FROM);
		createEReference(connectionEClass, CONNECTION__TO);
		createEReference(connectionEClass, CONNECTION__RULES);

		ruleEClass = createEClass(RULE);
		createEReference(ruleEClass, RULE__INPUT_EXPRESSION);
		createEReference(ruleEClass, RULE__OUTPUT_EXPRESSION);
		createEAttribute(ruleEClass, RULE__SPECIFICITY);

		expressionEClass = createEClass(EXPRESSION);
		createEReference(expressionEClass, EXPRESSION__PORT);
		createEReference(expressionEClass, EXPRESSION__FAILURES);

		failureEClass = createEClass(FAILURE);
		createEAttribute(failureEClass, FAILURE__TYPE);
		createEAttribute(failureEClass, FAILURE__ID);
		createEReference(failureEClass, FAILURE__ACID_AVOIDABLE);
		createEReference(failureEClass, FAILURE__ACID_MITIGATION);
		createEReference(failureEClass, FAILURE__PREVIOUS_FAILURES);
		createEAttribute(failureEClass, FAILURE__SPECIALIZATION);
		createEAttribute(failureEClass, FAILURE__VULNERABILITY);
		createEAttribute(failureEClass, FAILURE__ATTACK);

		aciDavoidableEClass = createEClass(ACI_DAVOIDABLE);
		createEAttribute(aciDavoidableEClass, ACI_DAVOIDABLE__A);
		createEAttribute(aciDavoidableEClass, ACI_DAVOIDABLE__C);
		createEAttribute(aciDavoidableEClass, ACI_DAVOIDABLE__I);
		createEAttribute(aciDavoidableEClass, ACI_DAVOIDABLE__D);

		aciDmitigationEClass = createEClass(ACI_DMITIGATION);
		createEAttribute(aciDmitigationEClass, ACI_DMITIGATION__A);
		createEAttribute(aciDmitigationEClass, ACI_DMITIGATION__C);
		createEAttribute(aciDmitigationEClass, ACI_DMITIGATION__I);
		createEAttribute(aciDmitigationEClass, ACI_DMITIGATION__D);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		FailureTypesPackage theFailureTypesPackage = (FailureTypesPackage)EPackage.Registry.INSTANCE.getEPackage(FailureTypesPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theFailureTypesPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		componentEClass.getESuperTypes().add(this.getNamedElement());
		componentEClass.getESuperTypes().add(this.getFlaBehaviour());
		compositeComponentEClass.getESuperTypes().add(this.getComponent());
		simpleComponentEClass.getESuperTypes().add(this.getComponent());
		portEClass.getESuperTypes().add(this.getNamedElement());
		connectionEClass.getESuperTypes().add(this.getFlaBehaviour());

		// Initialize classes, features, and operations; add parameters
		initEClass(namedElementEClass, NamedElement.class, "NamedElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElement_Id(), ecorePackage.getEString(), "id", null, 1, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(flaBehaviourEClass, FlaBehaviour.class, "FlaBehaviour", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getFlaBehaviour__PropagateFailures(), null, "propagateFailures", 0, 1, IS_UNIQUE, IS_ORDERED);

		EOperation op = initEOperation(getFlaBehaviour__Initialize__boolean(), null, "initialize", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "initNoFailure", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(componentEClass, Component.class, "Component", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponent_InputPorts(), this.getPort(), null, "inputPorts", null, 0, -1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponent_OutputPorts(), this.getPort(), null, "outputPorts", null, 0, -1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponent_Parent(), this.getCompositeComponent(), this.getCompositeComponent_Components(), "parent", null, 0, 1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compositeComponentEClass, CompositeComponent.class, "CompositeComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeComponent_Components(), this.getComponent(), this.getComponent_Parent(), "components", null, 0, -1, CompositeComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompositeComponent_Connections(), this.getConnection(), null, "connections", null, 0, -1, CompositeComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(simpleComponentEClass, SimpleComponent.class, "SimpleComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSimpleComponent_Rules(), this.getRule(), null, "rules", null, 0, -1, SimpleComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(portEClass, Port.class, "Port", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPort_ConnectedPorts(), this.getPort(), null, "connectedPorts", null, 0, -1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPort_Failures(), this.getFailure(), null, "failures", null, 0, -1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPort_NewFailures(), this.getFailure(), null, "newFailures", null, 0, -1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPort_Owner(), this.getComponent(), null, "owner", null, 1, 1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPort_IncomingConnections(), this.getConnection(), this.getConnection_To(), "incomingConnections", null, 1, 1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPort_OutgoingConnections(), this.getConnection(), this.getConnection_From(), "outgoingConnections", null, 1, 1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getPort__PropagateFailures(), null, "propagateFailures", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getPort__Initialize(), null, "initialize", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(connectionEClass, Connection.class, "Connection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConnection_From(), this.getPort(), this.getPort_OutgoingConnections(), "from", null, 1, 1, Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnection_To(), this.getPort(), this.getPort_IncomingConnections(), "to", null, 1, 1, Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnection_Rules(), this.getRule(), null, "rules", null, 0, -1, Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ruleEClass, Rule.class, "Rule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRule_InputExpression(), this.getExpression(), null, "inputExpression", null, 0, -1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRule_OutputExpression(), this.getExpression(), null, "outputExpression", null, 0, -1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRule_Specificity(), ecorePackage.getEInt(), "specificity", "-1", 1, 1, Rule.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(expressionEClass, Expression.class, "Expression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExpression_Port(), this.getPort(), null, "port", null, 1, 1, Expression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExpression_Failures(), this.getFailure(), null, "failures", null, 0, -1, Expression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(failureEClass, Failure.class, "Failure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFailure_Type(), theFailureTypesPackage.getFailureType(), "type", null, 1, 1, Failure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFailure_Id(), ecorePackage.getEString(), "id", null, 0, 1, Failure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFailure_AcidAvoidable(), this.getACIDavoidable(), null, "acidAvoidable", null, 0, 1, Failure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFailure_AcidMitigation(), this.getACIDmitigation(), null, "acidMitigation", null, 0, 1, Failure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFailure_PreviousFailures(), this.getFailure(), null, "previousFailures", null, 0, -1, Failure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFailure_Specialization(), ecorePackage.getEString(), "specialization", null, 0, 1, Failure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFailure_Vulnerability(), ecorePackage.getEString(), "vulnerability", null, 0, 1, Failure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFailure_Attack(), ecorePackage.getEString(), "attack", null, 0, 1, Failure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(aciDavoidableEClass, ACIDavoidable.class, "ACIDavoidable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getACIDavoidable_A(), theFailureTypesPackage.getA_avoidable(), "a", null, 0, 1, ACIDavoidable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getACIDavoidable_C(), theFailureTypesPackage.getC_avoidable(), "c", null, 0, 1, ACIDavoidable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getACIDavoidable_I(), theFailureTypesPackage.getI_avoidable(), "i", null, 0, 1, ACIDavoidable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getACIDavoidable_D(), theFailureTypesPackage.getD_avoidable(), "d", null, 0, 1, ACIDavoidable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(aciDmitigationEClass, ACIDmitigation.class, "ACIDmitigation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getACIDmitigation_A(), theFailureTypesPackage.getA_mitigation(), "a", null, 0, 1, ACIDmitigation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getACIDmitigation_C(), theFailureTypesPackage.getC_mitigation(), "c", null, 0, 1, ACIDmitigation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getACIDmitigation_I(), theFailureTypesPackage.getI_mitigation(), "i", null, 0, 1, ACIDmitigation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getACIDmitigation_D(), theFailureTypesPackage.getD_mitigation(), "d", null, 0, 1, ACIDmitigation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

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
	public interface Literals {
		/**
		 * The meta object literal for the '{@link org.polarsys.chess.fla.flamm.Component <em>Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.fla.flamm.Component
		 * @see org.polarsys.chess.fla.flamm.FlammPackage#getComponent()
		 * @generated
		 */
		public static final EClass COMPONENT = eINSTANCE.getComponent();

		/**
		 * The meta object literal for the '<em><b>Input Ports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference COMPONENT__INPUT_PORTS = eINSTANCE.getComponent_InputPorts();

		/**
		 * The meta object literal for the '<em><b>Output Ports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference COMPONENT__OUTPUT_PORTS = eINSTANCE.getComponent_OutputPorts();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference COMPONENT__PARENT = eINSTANCE.getComponent_Parent();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.fla.flamm.CompositeComponent <em>Composite Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.fla.flamm.CompositeComponent
		 * @see org.polarsys.chess.fla.flamm.FlammPackage#getCompositeComponent()
		 * @generated
		 */
		public static final EClass COMPOSITE_COMPONENT = eINSTANCE.getCompositeComponent();

		/**
		 * The meta object literal for the '<em><b>Components</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference COMPOSITE_COMPONENT__COMPONENTS = eINSTANCE.getCompositeComponent_Components();

		/**
		 * The meta object literal for the '<em><b>Connections</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference COMPOSITE_COMPONENT__CONNECTIONS = eINSTANCE.getCompositeComponent_Connections();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.fla.flamm.NamedElement <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.fla.flamm.NamedElement
		 * @see org.polarsys.chess.fla.flamm.FlammPackage#getNamedElement()
		 * @generated
		 */
		public static final EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute NAMED_ELEMENT__ID = eINSTANCE.getNamedElement_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.fla.flamm.FlaBehaviour <em>Fla Behaviour</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.fla.flamm.FlaBehaviour
		 * @see org.polarsys.chess.fla.flamm.FlammPackage#getFlaBehaviour()
		 * @generated
		 */
		public static final EClass FLA_BEHAVIOUR = eINSTANCE.getFlaBehaviour();

		/**
		 * The meta object literal for the '<em><b>Propagate Failures</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EOperation FLA_BEHAVIOUR___PROPAGATE_FAILURES = eINSTANCE.getFlaBehaviour__PropagateFailures();

		/**
		 * The meta object literal for the '<em><b>Initialize</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EOperation FLA_BEHAVIOUR___INITIALIZE__BOOLEAN = eINSTANCE.getFlaBehaviour__Initialize__boolean();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.fla.flamm.Port <em>Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.fla.flamm.Port
		 * @see org.polarsys.chess.fla.flamm.FlammPackage#getPort()
		 * @generated
		 */
		public static final EClass PORT = eINSTANCE.getPort();

		/**
		 * The meta object literal for the '<em><b>Connected Ports</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference PORT__CONNECTED_PORTS = eINSTANCE.getPort_ConnectedPorts();

		/**
		 * The meta object literal for the '<em><b>Failures</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference PORT__FAILURES = eINSTANCE.getPort_Failures();

		/**
		 * The meta object literal for the '<em><b>New Failures</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference PORT__NEW_FAILURES = eINSTANCE.getPort_NewFailures();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference PORT__OWNER = eINSTANCE.getPort_Owner();

		/**
		 * The meta object literal for the '<em><b>Incoming Connections</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference PORT__INCOMING_CONNECTIONS = eINSTANCE.getPort_IncomingConnections();

		/**
		 * The meta object literal for the '<em><b>Outgoing Connections</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference PORT__OUTGOING_CONNECTIONS = eINSTANCE.getPort_OutgoingConnections();

		/**
		 * The meta object literal for the '<em><b>Propagate Failures</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EOperation PORT___PROPAGATE_FAILURES = eINSTANCE.getPort__PropagateFailures();

		/**
		 * The meta object literal for the '<em><b>Initialize</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EOperation PORT___INITIALIZE = eINSTANCE.getPort__Initialize();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.fla.flamm.Connection <em>Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.fla.flamm.Connection
		 * @see org.polarsys.chess.fla.flamm.FlammPackage#getConnection()
		 * @generated
		 */
		public static final EClass CONNECTION = eINSTANCE.getConnection();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference CONNECTION__FROM = eINSTANCE.getConnection_From();

		/**
		 * The meta object literal for the '<em><b>To</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference CONNECTION__TO = eINSTANCE.getConnection_To();

		/**
		 * The meta object literal for the '<em><b>Rules</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference CONNECTION__RULES = eINSTANCE.getConnection_Rules();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.fla.flamm.Rule <em>Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.fla.flamm.Rule
		 * @see org.polarsys.chess.fla.flamm.FlammPackage#getRule()
		 * @generated
		 */
		public static final EClass RULE = eINSTANCE.getRule();

		/**
		 * The meta object literal for the '<em><b>Input Expression</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference RULE__INPUT_EXPRESSION = eINSTANCE.getRule_InputExpression();

		/**
		 * The meta object literal for the '<em><b>Output Expression</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference RULE__OUTPUT_EXPRESSION = eINSTANCE.getRule_OutputExpression();

		/**
		 * The meta object literal for the '<em><b>Specificity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute RULE__SPECIFICITY = eINSTANCE.getRule_Specificity();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.fla.flamm.SimpleComponent <em>Simple Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.fla.flamm.SimpleComponent
		 * @see org.polarsys.chess.fla.flamm.FlammPackage#getSimpleComponent()
		 * @generated
		 */
		public static final EClass SIMPLE_COMPONENT = eINSTANCE.getSimpleComponent();

		/**
		 * The meta object literal for the '<em><b>Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference SIMPLE_COMPONENT__RULES = eINSTANCE.getSimpleComponent_Rules();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.fla.flamm.Expression <em>Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.fla.flamm.Expression
		 * @see org.polarsys.chess.fla.flamm.FlammPackage#getExpression()
		 * @generated
		 */
		public static final EClass EXPRESSION = eINSTANCE.getExpression();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference EXPRESSION__PORT = eINSTANCE.getExpression_Port();

		/**
		 * The meta object literal for the '<em><b>Failures</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference EXPRESSION__FAILURES = eINSTANCE.getExpression_Failures();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.fla.flamm.Failure <em>Failure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.fla.flamm.Failure
		 * @see org.polarsys.chess.fla.flamm.FlammPackage#getFailure()
		 * @generated
		 */
		public static final EClass FAILURE = eINSTANCE.getFailure();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute FAILURE__TYPE = eINSTANCE.getFailure_Type();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute FAILURE__ID = eINSTANCE.getFailure_Id();

		/**
		 * The meta object literal for the '<em><b>Acid Avoidable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference FAILURE__ACID_AVOIDABLE = eINSTANCE.getFailure_AcidAvoidable();

		/**
		 * The meta object literal for the '<em><b>Acid Mitigation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference FAILURE__ACID_MITIGATION = eINSTANCE.getFailure_AcidMitigation();

		/**
		 * The meta object literal for the '<em><b>Previous Failures</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference FAILURE__PREVIOUS_FAILURES = eINSTANCE.getFailure_PreviousFailures();

		/**
		 * The meta object literal for the '<em><b>Specialization</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute FAILURE__SPECIALIZATION = eINSTANCE.getFailure_Specialization();

		/**
		 * The meta object literal for the '<em><b>Vulnerability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute FAILURE__VULNERABILITY = eINSTANCE.getFailure_Vulnerability();

		/**
		 * The meta object literal for the '<em><b>Attack</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute FAILURE__ATTACK = eINSTANCE.getFailure_Attack();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.fla.flamm.ACIDavoidable <em>ACI Davoidable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.fla.flamm.ACIDavoidable
		 * @see org.polarsys.chess.fla.flamm.FlammPackage#getACIDavoidable()
		 * @generated
		 */
		public static final EClass ACI_DAVOIDABLE = eINSTANCE.getACIDavoidable();

		/**
		 * The meta object literal for the '<em><b>A</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute ACI_DAVOIDABLE__A = eINSTANCE.getACIDavoidable_A();

		/**
		 * The meta object literal for the '<em><b>C</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute ACI_DAVOIDABLE__C = eINSTANCE.getACIDavoidable_C();

		/**
		 * The meta object literal for the '<em><b>I</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute ACI_DAVOIDABLE__I = eINSTANCE.getACIDavoidable_I();

		/**
		 * The meta object literal for the '<em><b>D</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute ACI_DAVOIDABLE__D = eINSTANCE.getACIDavoidable_D();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.fla.flamm.ACIDmitigation <em>ACI Dmitigation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.fla.flamm.ACIDmitigation
		 * @see org.polarsys.chess.fla.flamm.FlammPackage#getACIDmitigation()
		 * @generated
		 */
		public static final EClass ACI_DMITIGATION = eINSTANCE.getACIDmitigation();

		/**
		 * The meta object literal for the '<em><b>A</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute ACI_DMITIGATION__A = eINSTANCE.getACIDmitigation_A();

		/**
		 * The meta object literal for the '<em><b>C</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute ACI_DMITIGATION__C = eINSTANCE.getACIDmitigation_C();

		/**
		 * The meta object literal for the '<em><b>I</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute ACI_DMITIGATION__I = eINSTANCE.getACIDmitigation_I();

		/**
		 * The meta object literal for the '<em><b>D</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute ACI_DMITIGATION__D = eINSTANCE.getACIDmitigation_D();

	}

} //FlammPackage
