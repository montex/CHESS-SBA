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
package org.polarsys.chess.fla.flaxml.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.polarsys.chess.fla.flaxml.Components;
import org.polarsys.chess.fla.flaxml.CompositeComponent;
import org.polarsys.chess.fla.flaxml.Connection;
import org.polarsys.chess.fla.flaxml.Connections;
import org.polarsys.chess.fla.flaxml.DocumentRoot;
import org.polarsys.chess.fla.flaxml.Failure;
import org.polarsys.chess.fla.flaxml.FailureType;
import org.polarsys.chess.fla.flaxml.FlaxmlFactory;
import org.polarsys.chess.fla.flaxml.FlaxmlPackage;
import org.polarsys.chess.fla.flaxml.FptcRules;
import org.polarsys.chess.fla.flaxml.InputPort;
import org.polarsys.chess.fla.flaxml.InputPorts;
import org.polarsys.chess.fla.flaxml.NamedElement;
import org.polarsys.chess.fla.flaxml.OutputPort;
import org.polarsys.chess.fla.flaxml.OutputPorts;
import org.polarsys.chess.fla.flaxml.RuleString;
import org.polarsys.chess.fla.flaxml.SimpleComponent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FlaxmlFactoryImpl extends EFactoryImpl implements FlaxmlFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FlaxmlFactory init() {
		try {
			FlaxmlFactory theFlaxmlFactory = (FlaxmlFactory)EPackage.Registry.INSTANCE.getEFactory(FlaxmlPackage.eNS_URI);
			if (theFlaxmlFactory != null) {
				return theFlaxmlFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new FlaxmlFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlaxmlFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case FlaxmlPackage.COMPONENTS: return createComponents();
			case FlaxmlPackage.COMPOSITE_COMPONENT: return createCompositeComponent();
			case FlaxmlPackage.CONNECTION: return createConnection();
			case FlaxmlPackage.CONNECTIONS: return createConnections();
			case FlaxmlPackage.DOCUMENT_ROOT: return createDocumentRoot();
			case FlaxmlPackage.FAILURE: return createFailure();
			case FlaxmlPackage.FPTC_RULES: return createFptcRules();
			case FlaxmlPackage.INPUT_PORT: return createInputPort();
			case FlaxmlPackage.INPUT_PORTS: return createInputPorts();
			case FlaxmlPackage.NAMED_ELEMENT: return createNamedElement();
			case FlaxmlPackage.OUTPUT_PORT: return createOutputPort();
			case FlaxmlPackage.OUTPUT_PORTS: return createOutputPorts();
			case FlaxmlPackage.RULE_STRING: return createRuleString();
			case FlaxmlPackage.SIMPLE_COMPONENT: return createSimpleComponent();
			case FlaxmlPackage.SYSTEM: return createSystem();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case FlaxmlPackage.FAILURE_TYPE:
				return createFailureTypeFromString(eDataType, initialValue);
			case FlaxmlPackage.FAILURE_TYPE_OBJECT:
				return createFailureTypeObjectFromString(eDataType, initialValue);
			case FlaxmlPackage.PATTERN_TYPE:
				return createPatternTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case FlaxmlPackage.FAILURE_TYPE:
				return convertFailureTypeToString(eDataType, instanceValue);
			case FlaxmlPackage.FAILURE_TYPE_OBJECT:
				return convertFailureTypeObjectToString(eDataType, instanceValue);
			case FlaxmlPackage.PATTERN_TYPE:
				return convertPatternTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Components createComponents() {
		ComponentsImpl components = new ComponentsImpl();
		return components;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeComponent createCompositeComponent() {
		CompositeComponentImpl compositeComponent = new CompositeComponentImpl();
		return compositeComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Connection createConnection() {
		ConnectionImpl connection = new ConnectionImpl();
		return connection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Connections createConnections() {
		ConnectionsImpl connections = new ConnectionsImpl();
		return connections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocumentRoot createDocumentRoot() {
		DocumentRootImpl documentRoot = new DocumentRootImpl();
		return documentRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Failure createFailure() {
		FailureImpl failure = new FailureImpl();
		return failure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FptcRules createFptcRules() {
		FptcRulesImpl fptcRules = new FptcRulesImpl();
		return fptcRules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputPort createInputPort() {
		InputPortImpl inputPort = new InputPortImpl();
		return inputPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputPorts createInputPorts() {
		InputPortsImpl inputPorts = new InputPortsImpl();
		return inputPorts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement createNamedElement() {
		NamedElementImpl namedElement = new NamedElementImpl();
		return namedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputPort createOutputPort() {
		OutputPortImpl outputPort = new OutputPortImpl();
		return outputPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputPorts createOutputPorts() {
		OutputPortsImpl outputPorts = new OutputPortsImpl();
		return outputPorts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleString createRuleString() {
		RuleStringImpl ruleString = new RuleStringImpl();
		return ruleString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleComponent createSimpleComponent() {
		SimpleComponentImpl simpleComponent = new SimpleComponentImpl();
		return simpleComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.polarsys.chess.fla.flaxml.System createSystem() {
		SystemImpl system = new SystemImpl();
		return system;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FailureType createFailureTypeFromString(EDataType eDataType, String initialValue) {
		FailureType result = FailureType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFailureTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FailureType createFailureTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createFailureTypeFromString(FlaxmlPackage.Literals.FAILURE_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFailureTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertFailureTypeToString(FlaxmlPackage.Literals.FAILURE_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createPatternTypeFromString(EDataType eDataType, String initialValue) {
		return (String)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.STRING, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPatternTypeToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.STRING, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlaxmlPackage getFlaxmlPackage() {
		return (FlaxmlPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static FlaxmlPackage getPackage() {
		return FlaxmlPackage.eINSTANCE;
	}

} //FlaxmlFactoryImpl
