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
/**
 */
package org.polarsys.chess.fla.flaxml;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.polarsys.chess.fla.flaxml.FlaxmlFactory
 * @model kind="package"
 * @generated
 */
public interface FlaxmlPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "flaxml";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.polarsys.org/chess/fla/flaxml";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "flaxml";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FlaxmlPackage eINSTANCE = org.polarsys.chess.fla.flaxml.impl.FlaxmlPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polarsys.chess.fla.flaxml.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.fla.flaxml.impl.NamedElementImpl
	 * @see org.polarsys.chess.fla.flaxml.impl.FlaxmlPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 10;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = 1;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.fla.flaxml.impl.ComponentImpl <em>Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.fla.flaxml.impl.ComponentImpl
	 * @see org.polarsys.chess.fla.flaxml.impl.FlaxmlPackageImpl#getComponent()
	 * @generated
	 */
	int COMPONENT = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__ID = NAMED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Input Ports</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__INPUT_PORTS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Output Ports</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__OUTPUT_PORTS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.fla.flaxml.impl.ComponentsImpl <em>Components</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.fla.flaxml.impl.ComponentsImpl
	 * @see org.polarsys.chess.fla.flaxml.impl.FlaxmlPackageImpl#getComponents()
	 * @generated
	 */
	int COMPONENTS = 1;

	/**
	 * The feature id for the '<em><b>Component</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENTS__COMPONENT = 0;

	/**
	 * The number of structural features of the '<em>Components</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENTS_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Components</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENTS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.fla.flaxml.impl.CompositeComponentImpl <em>Composite Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.fla.flaxml.impl.CompositeComponentImpl
	 * @see org.polarsys.chess.fla.flaxml.impl.FlaxmlPackageImpl#getCompositeComponent()
	 * @generated
	 */
	int COMPOSITE_COMPONENT = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT__ID = COMPONENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT__NAME = COMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>Input Ports</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT__INPUT_PORTS = COMPONENT__INPUT_PORTS;

	/**
	 * The feature id for the '<em><b>Output Ports</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT__OUTPUT_PORTS = COMPONENT__OUTPUT_PORTS;

	/**
	 * The feature id for the '<em><b>Connections</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT__CONNECTIONS = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Components</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT__COMPONENTS = COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Composite Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Composite Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT_OPERATION_COUNT = COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.fla.flaxml.impl.ConnectionImpl <em>Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.fla.flaxml.impl.ConnectionImpl
	 * @see org.polarsys.chess.fla.flaxml.impl.FlaxmlPackageImpl#getConnection()
	 * @generated
	 */
	int CONNECTION = 3;

	/**
	 * The feature id for the '<em><b>Source Component</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__SOURCE_COMPONENT = 0;

	/**
	 * The feature id for the '<em><b>Source Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__SOURCE_ID = 1;

	/**
	 * The feature id for the '<em><b>Target Component</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__TARGET_COMPONENT = 2;

	/**
	 * The feature id for the '<em><b>Target Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__TARGET_ID = 3;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__RULES = 4;

	/**
	 * The number of structural features of the '<em>Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.fla.flaxml.impl.ConnectionsImpl <em>Connections</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.fla.flaxml.impl.ConnectionsImpl
	 * @see org.polarsys.chess.fla.flaxml.impl.FlaxmlPackageImpl#getConnections()
	 * @generated
	 */
	int CONNECTIONS = 4;

	/**
	 * The feature id for the '<em><b>Connection</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTIONS__CONNECTION = 0;

	/**
	 * The number of structural features of the '<em>Connections</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTIONS_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Connections</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTIONS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.fla.flaxml.impl.DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.fla.flaxml.impl.DocumentRootImpl
	 * @see org.polarsys.chess.fla.flaxml.impl.FlaxmlPackageImpl#getDocumentRoot()
	 * @generated
	 */
	int DOCUMENT_ROOT = 5;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__SYSTEM = 3;

	/**
	 * The number of structural features of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.fla.flaxml.impl.FailureImpl <em>Failure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.fla.flaxml.impl.FailureImpl
	 * @see org.polarsys.chess.fla.flaxml.impl.FlaxmlPackageImpl#getFailure()
	 * @generated
	 */
	int FAILURE = 6;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE__TYPE = 0;

	/**
	 * The number of structural features of the '<em>Failure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Failure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.fla.flaxml.impl.FptcRulesImpl <em>Fptc Rules</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.fla.flaxml.impl.FptcRulesImpl
	 * @see org.polarsys.chess.fla.flaxml.impl.FlaxmlPackageImpl#getFptcRules()
	 * @generated
	 */
	int FPTC_RULES = 7;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FPTC_RULES__RULE = 0;

	/**
	 * The number of structural features of the '<em>Fptc Rules</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FPTC_RULES_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Fptc Rules</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FPTC_RULES_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.fla.flaxml.impl.InputPortImpl <em>Input Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.fla.flaxml.impl.InputPortImpl
	 * @see org.polarsys.chess.fla.flaxml.impl.FlaxmlPackageImpl#getInputPort()
	 * @generated
	 */
	int INPUT_PORT = 8;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PORT__ID = NAMED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PORT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Input Failure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PORT__INPUT_FAILURE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Input Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PORT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Input Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PORT_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.fla.flaxml.impl.InputPortsImpl <em>Input Ports</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.fla.flaxml.impl.InputPortsImpl
	 * @see org.polarsys.chess.fla.flaxml.impl.FlaxmlPackageImpl#getInputPorts()
	 * @generated
	 */
	int INPUT_PORTS = 9;

	/**
	 * The feature id for the '<em><b>Input Port</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PORTS__INPUT_PORT = 0;

	/**
	 * The number of structural features of the '<em>Input Ports</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PORTS_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Input Ports</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PORTS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.fla.flaxml.impl.OutputPortImpl <em>Output Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.fla.flaxml.impl.OutputPortImpl
	 * @see org.polarsys.chess.fla.flaxml.impl.FlaxmlPackageImpl#getOutputPort()
	 * @generated
	 */
	int OUTPUT_PORT = 11;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PORT__ID = NAMED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PORT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Output Failure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PORT__OUTPUT_FAILURE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Output Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PORT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Output Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PORT_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.fla.flaxml.impl.OutputPortsImpl <em>Output Ports</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.fla.flaxml.impl.OutputPortsImpl
	 * @see org.polarsys.chess.fla.flaxml.impl.FlaxmlPackageImpl#getOutputPorts()
	 * @generated
	 */
	int OUTPUT_PORTS = 12;

	/**
	 * The feature id for the '<em><b>Output Port</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PORTS__OUTPUT_PORT = 0;

	/**
	 * The number of structural features of the '<em>Output Ports</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PORTS_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Output Ports</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PORTS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.fla.flaxml.impl.RuleStringImpl <em>Rule String</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.fla.flaxml.impl.RuleStringImpl
	 * @see org.polarsys.chess.fla.flaxml.impl.FlaxmlPackageImpl#getRuleString()
	 * @generated
	 */
	int RULE_STRING = 13;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_STRING__PATTERN = 0;

	/**
	 * The number of structural features of the '<em>Rule String</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_STRING_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Rule String</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_STRING_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.fla.flaxml.impl.SimpleComponentImpl <em>Simple Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.fla.flaxml.impl.SimpleComponentImpl
	 * @see org.polarsys.chess.fla.flaxml.impl.FlaxmlPackageImpl#getSimpleComponent()
	 * @generated
	 */
	int SIMPLE_COMPONENT = 14;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_COMPONENT__ID = COMPONENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_COMPONENT__NAME = COMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>Input Ports</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_COMPONENT__INPUT_PORTS = COMPONENT__INPUT_PORTS;

	/**
	 * The feature id for the '<em><b>Output Ports</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_COMPONENT__OUTPUT_PORTS = COMPONENT__OUTPUT_PORTS;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_COMPONENT__RULES = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Simple Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_COMPONENT_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Simple Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_COMPONENT_OPERATION_COUNT = COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.fla.flaxml.impl.SystemImpl <em>System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.fla.flaxml.impl.SystemImpl
	 * @see org.polarsys.chess.fla.flaxml.impl.FlaxmlPackageImpl#getSystem()
	 * @generated
	 */
	int SYSTEM = 15;

	/**
	 * The feature id for the '<em><b>Component</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__COMPONENT = 0;

	/**
	 * The number of structural features of the '<em>System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.fla.flaxml.FailureType <em>Failure Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.fla.flaxml.FailureType
	 * @see org.polarsys.chess.fla.flaxml.impl.FlaxmlPackageImpl#getFailureType()
	 * @generated
	 */
	int FAILURE_TYPE = 16;

	/**
	 * The meta object id for the '<em>Failure Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.fla.flaxml.FailureType
	 * @see org.polarsys.chess.fla.flaxml.impl.FlaxmlPackageImpl#getFailureTypeObject()
	 * @generated
	 */
	int FAILURE_TYPE_OBJECT = 17;

	/**
	 * The meta object id for the '<em>Pattern Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.polarsys.chess.fla.flaxml.impl.FlaxmlPackageImpl#getPatternType()
	 * @generated
	 */
	int PATTERN_TYPE = 18;


	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.fla.flaxml.Component <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component</em>'.
	 * @see org.polarsys.chess.fla.flaxml.Component
	 * @generated
	 */
	EClass getComponent();

	/**
	 * Returns the meta object for the containment reference '{@link org.polarsys.chess.fla.flaxml.Component#getInputPorts <em>Input Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Input Ports</em>'.
	 * @see org.polarsys.chess.fla.flaxml.Component#getInputPorts()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_InputPorts();

	/**
	 * Returns the meta object for the containment reference '{@link org.polarsys.chess.fla.flaxml.Component#getOutputPorts <em>Output Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Output Ports</em>'.
	 * @see org.polarsys.chess.fla.flaxml.Component#getOutputPorts()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_OutputPorts();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.fla.flaxml.Components <em>Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Components</em>'.
	 * @see org.polarsys.chess.fla.flaxml.Components
	 * @generated
	 */
	EClass getComponents();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.chess.fla.flaxml.Components#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Component</em>'.
	 * @see org.polarsys.chess.fla.flaxml.Components#getComponent()
	 * @see #getComponents()
	 * @generated
	 */
	EReference getComponents_Component();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.fla.flaxml.CompositeComponent <em>Composite Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Component</em>'.
	 * @see org.polarsys.chess.fla.flaxml.CompositeComponent
	 * @generated
	 */
	EClass getCompositeComponent();

	/**
	 * Returns the meta object for the containment reference '{@link org.polarsys.chess.fla.flaxml.CompositeComponent#getConnections <em>Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Connections</em>'.
	 * @see org.polarsys.chess.fla.flaxml.CompositeComponent#getConnections()
	 * @see #getCompositeComponent()
	 * @generated
	 */
	EReference getCompositeComponent_Connections();

	/**
	 * Returns the meta object for the containment reference '{@link org.polarsys.chess.fla.flaxml.CompositeComponent#getComponents <em>Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Components</em>'.
	 * @see org.polarsys.chess.fla.flaxml.CompositeComponent#getComponents()
	 * @see #getCompositeComponent()
	 * @generated
	 */
	EReference getCompositeComponent_Components();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.fla.flaxml.Connection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection</em>'.
	 * @see org.polarsys.chess.fla.flaxml.Connection
	 * @generated
	 */
	EClass getConnection();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.fla.flaxml.Connection#getSourceComponent <em>Source Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Component</em>'.
	 * @see org.polarsys.chess.fla.flaxml.Connection#getSourceComponent()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_SourceComponent();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.fla.flaxml.Connection#getSourceId <em>Source Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Id</em>'.
	 * @see org.polarsys.chess.fla.flaxml.Connection#getSourceId()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_SourceId();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.fla.flaxml.Connection#getTargetComponent <em>Target Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Component</em>'.
	 * @see org.polarsys.chess.fla.flaxml.Connection#getTargetComponent()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_TargetComponent();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.fla.flaxml.Connection#getTargetId <em>Target Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Id</em>'.
	 * @see org.polarsys.chess.fla.flaxml.Connection#getTargetId()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_TargetId();

	/**
	 * Returns the meta object for the containment reference '{@link org.polarsys.chess.fla.flaxml.Connection#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rules</em>'.
	 * @see org.polarsys.chess.fla.flaxml.Connection#getRules()
	 * @see #getConnection()
	 * @generated
	 */
	EReference getConnection_Rules();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.fla.flaxml.Connections <em>Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connections</em>'.
	 * @see org.polarsys.chess.fla.flaxml.Connections
	 * @generated
	 */
	EClass getConnections();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.chess.fla.flaxml.Connections#getConnection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Connection</em>'.
	 * @see org.polarsys.chess.fla.flaxml.Connections#getConnection()
	 * @see #getConnections()
	 * @generated
	 */
	EReference getConnections_Connection();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.fla.flaxml.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see org.polarsys.chess.fla.flaxml.DocumentRoot
	 * @generated
	 */
	EClass getDocumentRoot();

	/**
	 * Returns the meta object for the attribute list '{@link org.polarsys.chess.fla.flaxml.DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.polarsys.chess.fla.flaxml.DocumentRoot#getMixed()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link org.polarsys.chess.fla.flaxml.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see org.polarsys.chess.fla.flaxml.DocumentRoot#getXMLNSPrefixMap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link org.polarsys.chess.fla.flaxml.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see org.polarsys.chess.fla.flaxml.DocumentRoot#getXSISchemaLocation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link org.polarsys.chess.fla.flaxml.DocumentRoot#getSystem <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>System</em>'.
	 * @see org.polarsys.chess.fla.flaxml.DocumentRoot#getSystem()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_System();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.fla.flaxml.Failure <em>Failure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Failure</em>'.
	 * @see org.polarsys.chess.fla.flaxml.Failure
	 * @generated
	 */
	EClass getFailure();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.fla.flaxml.Failure#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.polarsys.chess.fla.flaxml.Failure#getType()
	 * @see #getFailure()
	 * @generated
	 */
	EAttribute getFailure_Type();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.fla.flaxml.FptcRules <em>Fptc Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fptc Rules</em>'.
	 * @see org.polarsys.chess.fla.flaxml.FptcRules
	 * @generated
	 */
	EClass getFptcRules();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.chess.fla.flaxml.FptcRules#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rule</em>'.
	 * @see org.polarsys.chess.fla.flaxml.FptcRules#getRule()
	 * @see #getFptcRules()
	 * @generated
	 */
	EReference getFptcRules_Rule();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.fla.flaxml.InputPort <em>Input Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Port</em>'.
	 * @see org.polarsys.chess.fla.flaxml.InputPort
	 * @generated
	 */
	EClass getInputPort();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.chess.fla.flaxml.InputPort#getInputFailure <em>Input Failure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Input Failure</em>'.
	 * @see org.polarsys.chess.fla.flaxml.InputPort#getInputFailure()
	 * @see #getInputPort()
	 * @generated
	 */
	EReference getInputPort_InputFailure();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.fla.flaxml.InputPorts <em>Input Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Ports</em>'.
	 * @see org.polarsys.chess.fla.flaxml.InputPorts
	 * @generated
	 */
	EClass getInputPorts();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.chess.fla.flaxml.InputPorts#getInputPort <em>Input Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Input Port</em>'.
	 * @see org.polarsys.chess.fla.flaxml.InputPorts#getInputPort()
	 * @see #getInputPorts()
	 * @generated
	 */
	EReference getInputPorts_InputPort();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.fla.flaxml.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see org.polarsys.chess.fla.flaxml.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.fla.flaxml.NamedElement#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.polarsys.chess.fla.flaxml.NamedElement#getId()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.fla.flaxml.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.polarsys.chess.fla.flaxml.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.fla.flaxml.OutputPort <em>Output Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Port</em>'.
	 * @see org.polarsys.chess.fla.flaxml.OutputPort
	 * @generated
	 */
	EClass getOutputPort();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.chess.fla.flaxml.OutputPort#getOutputFailure <em>Output Failure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Output Failure</em>'.
	 * @see org.polarsys.chess.fla.flaxml.OutputPort#getOutputFailure()
	 * @see #getOutputPort()
	 * @generated
	 */
	EReference getOutputPort_OutputFailure();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.fla.flaxml.OutputPorts <em>Output Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Ports</em>'.
	 * @see org.polarsys.chess.fla.flaxml.OutputPorts
	 * @generated
	 */
	EClass getOutputPorts();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.chess.fla.flaxml.OutputPorts#getOutputPort <em>Output Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Output Port</em>'.
	 * @see org.polarsys.chess.fla.flaxml.OutputPorts#getOutputPort()
	 * @see #getOutputPorts()
	 * @generated
	 */
	EReference getOutputPorts_OutputPort();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.fla.flaxml.RuleString <em>Rule String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule String</em>'.
	 * @see org.polarsys.chess.fla.flaxml.RuleString
	 * @generated
	 */
	EClass getRuleString();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.fla.flaxml.RuleString#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pattern</em>'.
	 * @see org.polarsys.chess.fla.flaxml.RuleString#getPattern()
	 * @see #getRuleString()
	 * @generated
	 */
	EAttribute getRuleString_Pattern();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.fla.flaxml.SimpleComponent <em>Simple Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Component</em>'.
	 * @see org.polarsys.chess.fla.flaxml.SimpleComponent
	 * @generated
	 */
	EClass getSimpleComponent();

	/**
	 * Returns the meta object for the containment reference '{@link org.polarsys.chess.fla.flaxml.SimpleComponent#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rules</em>'.
	 * @see org.polarsys.chess.fla.flaxml.SimpleComponent#getRules()
	 * @see #getSimpleComponent()
	 * @generated
	 */
	EReference getSimpleComponent_Rules();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.fla.flaxml.System <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System</em>'.
	 * @see org.polarsys.chess.fla.flaxml.System
	 * @generated
	 */
	EClass getSystem();

	/**
	 * Returns the meta object for the containment reference '{@link org.polarsys.chess.fla.flaxml.System#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Component</em>'.
	 * @see org.polarsys.chess.fla.flaxml.System#getComponent()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Component();

	/**
	 * Returns the meta object for enum '{@link org.polarsys.chess.fla.flaxml.FailureType <em>Failure Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Failure Type</em>'.
	 * @see org.polarsys.chess.fla.flaxml.FailureType
	 * @generated
	 */
	EEnum getFailureType();

	/**
	 * Returns the meta object for data type '{@link org.polarsys.chess.fla.flaxml.FailureType <em>Failure Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Failure Type Object</em>'.
	 * @see org.polarsys.chess.fla.flaxml.FailureType
	 * @model instanceClass="org.polarsys.chess.fla.flaxml.FailureType"
	 *        extendedMetaData="name='failureType:Object' baseType='failureType'"
	 * @generated
	 */
	EDataType getFailureTypeObject();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Pattern Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Pattern Type</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='pattern_._type' baseType='http://www.eclipse.org/emf/2003/XMLType#string' pattern='[^>]+\\.[^>]+->[^>]+\\.[^>]+'"
	 * @generated
	 */
	EDataType getPatternType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FlaxmlFactory getFlaxmlFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.polarsys.chess.fla.flaxml.impl.ComponentImpl <em>Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.fla.flaxml.impl.ComponentImpl
		 * @see org.polarsys.chess.fla.flaxml.impl.FlaxmlPackageImpl#getComponent()
		 * @generated
		 */
		EClass COMPONENT = eINSTANCE.getComponent();

		/**
		 * The meta object literal for the '<em><b>Input Ports</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__INPUT_PORTS = eINSTANCE.getComponent_InputPorts();

		/**
		 * The meta object literal for the '<em><b>Output Ports</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__OUTPUT_PORTS = eINSTANCE.getComponent_OutputPorts();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.fla.flaxml.impl.ComponentsImpl <em>Components</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.fla.flaxml.impl.ComponentsImpl
		 * @see org.polarsys.chess.fla.flaxml.impl.FlaxmlPackageImpl#getComponents()
		 * @generated
		 */
		EClass COMPONENTS = eINSTANCE.getComponents();

		/**
		 * The meta object literal for the '<em><b>Component</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENTS__COMPONENT = eINSTANCE.getComponents_Component();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.fla.flaxml.impl.CompositeComponentImpl <em>Composite Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.fla.flaxml.impl.CompositeComponentImpl
		 * @see org.polarsys.chess.fla.flaxml.impl.FlaxmlPackageImpl#getCompositeComponent()
		 * @generated
		 */
		EClass COMPOSITE_COMPONENT = eINSTANCE.getCompositeComponent();

		/**
		 * The meta object literal for the '<em><b>Connections</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_COMPONENT__CONNECTIONS = eINSTANCE.getCompositeComponent_Connections();

		/**
		 * The meta object literal for the '<em><b>Components</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_COMPONENT__COMPONENTS = eINSTANCE.getCompositeComponent_Components();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.fla.flaxml.impl.ConnectionImpl <em>Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.fla.flaxml.impl.ConnectionImpl
		 * @see org.polarsys.chess.fla.flaxml.impl.FlaxmlPackageImpl#getConnection()
		 * @generated
		 */
		EClass CONNECTION = eINSTANCE.getConnection();

		/**
		 * The meta object literal for the '<em><b>Source Component</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__SOURCE_COMPONENT = eINSTANCE.getConnection_SourceComponent();

		/**
		 * The meta object literal for the '<em><b>Source Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__SOURCE_ID = eINSTANCE.getConnection_SourceId();

		/**
		 * The meta object literal for the '<em><b>Target Component</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__TARGET_COMPONENT = eINSTANCE.getConnection_TargetComponent();

		/**
		 * The meta object literal for the '<em><b>Target Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__TARGET_ID = eINSTANCE.getConnection_TargetId();

		/**
		 * The meta object literal for the '<em><b>Rules</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION__RULES = eINSTANCE.getConnection_Rules();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.fla.flaxml.impl.ConnectionsImpl <em>Connections</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.fla.flaxml.impl.ConnectionsImpl
		 * @see org.polarsys.chess.fla.flaxml.impl.FlaxmlPackageImpl#getConnections()
		 * @generated
		 */
		EClass CONNECTIONS = eINSTANCE.getConnections();

		/**
		 * The meta object literal for the '<em><b>Connection</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTIONS__CONNECTION = eINSTANCE.getConnections_Connection();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.fla.flaxml.impl.DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.fla.flaxml.impl.DocumentRootImpl
		 * @see org.polarsys.chess.fla.flaxml.impl.FlaxmlPackageImpl#getDocumentRoot()
		 * @generated
		 */
		EClass DOCUMENT_ROOT = eINSTANCE.getDocumentRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__MIXED = eINSTANCE.getDocumentRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getDocumentRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getDocumentRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>System</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__SYSTEM = eINSTANCE.getDocumentRoot_System();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.fla.flaxml.impl.FailureImpl <em>Failure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.fla.flaxml.impl.FailureImpl
		 * @see org.polarsys.chess.fla.flaxml.impl.FlaxmlPackageImpl#getFailure()
		 * @generated
		 */
		EClass FAILURE = eINSTANCE.getFailure();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAILURE__TYPE = eINSTANCE.getFailure_Type();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.fla.flaxml.impl.FptcRulesImpl <em>Fptc Rules</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.fla.flaxml.impl.FptcRulesImpl
		 * @see org.polarsys.chess.fla.flaxml.impl.FlaxmlPackageImpl#getFptcRules()
		 * @generated
		 */
		EClass FPTC_RULES = eINSTANCE.getFptcRules();

		/**
		 * The meta object literal for the '<em><b>Rule</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FPTC_RULES__RULE = eINSTANCE.getFptcRules_Rule();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.fla.flaxml.impl.InputPortImpl <em>Input Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.fla.flaxml.impl.InputPortImpl
		 * @see org.polarsys.chess.fla.flaxml.impl.FlaxmlPackageImpl#getInputPort()
		 * @generated
		 */
		EClass INPUT_PORT = eINSTANCE.getInputPort();

		/**
		 * The meta object literal for the '<em><b>Input Failure</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INPUT_PORT__INPUT_FAILURE = eINSTANCE.getInputPort_InputFailure();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.fla.flaxml.impl.InputPortsImpl <em>Input Ports</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.fla.flaxml.impl.InputPortsImpl
		 * @see org.polarsys.chess.fla.flaxml.impl.FlaxmlPackageImpl#getInputPorts()
		 * @generated
		 */
		EClass INPUT_PORTS = eINSTANCE.getInputPorts();

		/**
		 * The meta object literal for the '<em><b>Input Port</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INPUT_PORTS__INPUT_PORT = eINSTANCE.getInputPorts_InputPort();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.fla.flaxml.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.fla.flaxml.impl.NamedElementImpl
		 * @see org.polarsys.chess.fla.flaxml.impl.FlaxmlPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__ID = eINSTANCE.getNamedElement_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.fla.flaxml.impl.OutputPortImpl <em>Output Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.fla.flaxml.impl.OutputPortImpl
		 * @see org.polarsys.chess.fla.flaxml.impl.FlaxmlPackageImpl#getOutputPort()
		 * @generated
		 */
		EClass OUTPUT_PORT = eINSTANCE.getOutputPort();

		/**
		 * The meta object literal for the '<em><b>Output Failure</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTPUT_PORT__OUTPUT_FAILURE = eINSTANCE.getOutputPort_OutputFailure();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.fla.flaxml.impl.OutputPortsImpl <em>Output Ports</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.fla.flaxml.impl.OutputPortsImpl
		 * @see org.polarsys.chess.fla.flaxml.impl.FlaxmlPackageImpl#getOutputPorts()
		 * @generated
		 */
		EClass OUTPUT_PORTS = eINSTANCE.getOutputPorts();

		/**
		 * The meta object literal for the '<em><b>Output Port</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTPUT_PORTS__OUTPUT_PORT = eINSTANCE.getOutputPorts_OutputPort();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.fla.flaxml.impl.RuleStringImpl <em>Rule String</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.fla.flaxml.impl.RuleStringImpl
		 * @see org.polarsys.chess.fla.flaxml.impl.FlaxmlPackageImpl#getRuleString()
		 * @generated
		 */
		EClass RULE_STRING = eINSTANCE.getRuleString();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE_STRING__PATTERN = eINSTANCE.getRuleString_Pattern();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.fla.flaxml.impl.SimpleComponentImpl <em>Simple Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.fla.flaxml.impl.SimpleComponentImpl
		 * @see org.polarsys.chess.fla.flaxml.impl.FlaxmlPackageImpl#getSimpleComponent()
		 * @generated
		 */
		EClass SIMPLE_COMPONENT = eINSTANCE.getSimpleComponent();

		/**
		 * The meta object literal for the '<em><b>Rules</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_COMPONENT__RULES = eINSTANCE.getSimpleComponent_Rules();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.fla.flaxml.impl.SystemImpl <em>System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.fla.flaxml.impl.SystemImpl
		 * @see org.polarsys.chess.fla.flaxml.impl.FlaxmlPackageImpl#getSystem()
		 * @generated
		 */
		EClass SYSTEM = eINSTANCE.getSystem();

		/**
		 * The meta object literal for the '<em><b>Component</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__COMPONENT = eINSTANCE.getSystem_Component();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.fla.flaxml.FailureType <em>Failure Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.fla.flaxml.FailureType
		 * @see org.polarsys.chess.fla.flaxml.impl.FlaxmlPackageImpl#getFailureType()
		 * @generated
		 */
		EEnum FAILURE_TYPE = eINSTANCE.getFailureType();

		/**
		 * The meta object literal for the '<em>Failure Type Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.fla.flaxml.FailureType
		 * @see org.polarsys.chess.fla.flaxml.impl.FlaxmlPackageImpl#getFailureTypeObject()
		 * @generated
		 */
		EDataType FAILURE_TYPE_OBJECT = eINSTANCE.getFailureTypeObject();

		/**
		 * The meta object literal for the '<em>Pattern Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.polarsys.chess.fla.flaxml.impl.FlaxmlPackageImpl#getPatternType()
		 * @generated
		 */
		EDataType PATTERN_TYPE = eINSTANCE.getPatternType();

	}

} //FlaxmlPackage
