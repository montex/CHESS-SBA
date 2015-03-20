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
package org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponentPackage;

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
 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.StateBasedComponentsFactory
 * @model kind="package"
 * @generated
 */
public interface StateBasedComponentsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "StateBasedComponents";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://CHESS/Dependability/StateBased/StateBasedComponents";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "StateBasedComponents";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StateBasedComponentsPackage eINSTANCE = org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.impl.StateBasedComponentsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.impl.StatefulHardwareImpl <em>Stateful Hardware</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.impl.StatefulHardwareImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.impl.StateBasedComponentsPackageImpl#getStatefulHardware()
	 * @generated
	 */
	int STATEFUL_HARDWARE = 0;

	/**
	 * The feature id for the '<em><b>Base Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEFUL_HARDWARE__BASE_COMPONENT = DependableComponentPackage.DEPENDABLE_COMPONENT__BASE_COMPONENT;

	/**
	 * The feature id for the '<em><b>Error Model</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEFUL_HARDWARE__ERROR_MODEL = DependableComponentPackage.DEPENDABLE_COMPONENT__ERROR_MODEL;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEFUL_HARDWARE__BASE_PROPERTY = DependableComponentPackage.DEPENDABLE_COMPONENT__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEFUL_HARDWARE__BASE_INSTANCE_SPECIFICATION = DependableComponentPackage.DEPENDABLE_COMPONENT__BASE_INSTANCE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Prob Perm Fault</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEFUL_HARDWARE__PROB_PERM_FAULT = DependableComponentPackage.DEPENDABLE_COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Error Latency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEFUL_HARDWARE__ERROR_LATENCY = DependableComponentPackage.DEPENDABLE_COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Repair Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEFUL_HARDWARE__REPAIR_DELAY = DependableComponentPackage.DEPENDABLE_COMPONENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Fault Occ</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEFUL_HARDWARE__FAULT_OCC = DependableComponentPackage.DEPENDABLE_COMPONENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Stateful Hardware</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEFUL_HARDWARE_FEATURE_COUNT = DependableComponentPackage.DEPENDABLE_COMPONENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.impl.StatefulSoftwareImpl <em>Stateful Software</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.impl.StatefulSoftwareImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.impl.StateBasedComponentsPackageImpl#getStatefulSoftware()
	 * @generated
	 */
	int STATEFUL_SOFTWARE = 1;

	/**
	 * The feature id for the '<em><b>Base Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEFUL_SOFTWARE__BASE_COMPONENT = DependableComponentPackage.DEPENDABLE_COMPONENT__BASE_COMPONENT;

	/**
	 * The feature id for the '<em><b>Error Model</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEFUL_SOFTWARE__ERROR_MODEL = DependableComponentPackage.DEPENDABLE_COMPONENT__ERROR_MODEL;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEFUL_SOFTWARE__BASE_PROPERTY = DependableComponentPackage.DEPENDABLE_COMPONENT__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEFUL_SOFTWARE__BASE_INSTANCE_SPECIFICATION = DependableComponentPackage.DEPENDABLE_COMPONENT__BASE_INSTANCE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Error Latency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEFUL_SOFTWARE__ERROR_LATENCY = DependableComponentPackage.DEPENDABLE_COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Repair Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEFUL_SOFTWARE__REPAIR_DELAY = DependableComponentPackage.DEPENDABLE_COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Fault Occ</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEFUL_SOFTWARE__FAULT_OCC = DependableComponentPackage.DEPENDABLE_COMPONENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Stateful Software</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEFUL_SOFTWARE_FEATURE_COUNT = DependableComponentPackage.DEPENDABLE_COMPONENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.impl.StatelessHardwareImpl <em>Stateless Hardware</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.impl.StatelessHardwareImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.impl.StateBasedComponentsPackageImpl#getStatelessHardware()
	 * @generated
	 */
	int STATELESS_HARDWARE = 2;

	/**
	 * The feature id for the '<em><b>Base Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATELESS_HARDWARE__BASE_COMPONENT = DependableComponentPackage.DEPENDABLE_COMPONENT__BASE_COMPONENT;

	/**
	 * The feature id for the '<em><b>Error Model</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATELESS_HARDWARE__ERROR_MODEL = DependableComponentPackage.DEPENDABLE_COMPONENT__ERROR_MODEL;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATELESS_HARDWARE__BASE_PROPERTY = DependableComponentPackage.DEPENDABLE_COMPONENT__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATELESS_HARDWARE__BASE_INSTANCE_SPECIFICATION = DependableComponentPackage.DEPENDABLE_COMPONENT__BASE_INSTANCE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Prob Perm Fault</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATELESS_HARDWARE__PROB_PERM_FAULT = DependableComponentPackage.DEPENDABLE_COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Repair Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATELESS_HARDWARE__REPAIR_DELAY = DependableComponentPackage.DEPENDABLE_COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Fault Occ</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATELESS_HARDWARE__FAULT_OCC = DependableComponentPackage.DEPENDABLE_COMPONENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Stateless Hardware</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATELESS_HARDWARE_FEATURE_COUNT = DependableComponentPackage.DEPENDABLE_COMPONENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.impl.StatelessSoftwareImpl <em>Stateless Software</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.impl.StatelessSoftwareImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.impl.StateBasedComponentsPackageImpl#getStatelessSoftware()
	 * @generated
	 */
	int STATELESS_SOFTWARE = 3;

	/**
	 * The feature id for the '<em><b>Base Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATELESS_SOFTWARE__BASE_COMPONENT = DependableComponentPackage.DEPENDABLE_COMPONENT__BASE_COMPONENT;

	/**
	 * The feature id for the '<em><b>Error Model</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATELESS_SOFTWARE__ERROR_MODEL = DependableComponentPackage.DEPENDABLE_COMPONENT__ERROR_MODEL;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATELESS_SOFTWARE__BASE_PROPERTY = DependableComponentPackage.DEPENDABLE_COMPONENT__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATELESS_SOFTWARE__BASE_INSTANCE_SPECIFICATION = DependableComponentPackage.DEPENDABLE_COMPONENT__BASE_INSTANCE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Fault Occ</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATELESS_SOFTWARE__FAULT_OCC = DependableComponentPackage.DEPENDABLE_COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Stateless Software</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATELESS_SOFTWARE_FEATURE_COUNT = DependableComponentPackage.DEPENDABLE_COMPONENT_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.impl.StochasticFailureBehaviourImpl <em>Stochastic Failure Behaviour</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.impl.StochasticFailureBehaviourImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.impl.StateBasedComponentsPackageImpl#getStochasticFailureBehaviour()
	 * @generated
	 */
	int STOCHASTIC_FAILURE_BEHAVIOUR = 4;

	/**
	 * The feature id for the '<em><b>Base Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_FAILURE_BEHAVIOUR__BASE_COMPONENT = DependableComponentPackage.DEPENDABLE_COMPONENT__BASE_COMPONENT;

	/**
	 * The feature id for the '<em><b>Error Model</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_FAILURE_BEHAVIOUR__ERROR_MODEL = DependableComponentPackage.DEPENDABLE_COMPONENT__ERROR_MODEL;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_FAILURE_BEHAVIOUR__BASE_PROPERTY = DependableComponentPackage.DEPENDABLE_COMPONENT__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_FAILURE_BEHAVIOUR__BASE_INSTANCE_SPECIFICATION = DependableComponentPackage.DEPENDABLE_COMPONENT__BASE_INSTANCE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Failure Distribution</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_FAILURE_BEHAVIOUR__FAILURE_DISTRIBUTION = DependableComponentPackage.DEPENDABLE_COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Repair Distribution</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_FAILURE_BEHAVIOUR__REPAIR_DISTRIBUTION = DependableComponentPackage.DEPENDABLE_COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Modes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_FAILURE_BEHAVIOUR__MODES = DependableComponentPackage.DEPENDABLE_COMPONENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Stochastic Failure Behaviour</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_FAILURE_BEHAVIOUR_FEATURE_COUNT = DependableComponentPackage.DEPENDABLE_COMPONENT_FEATURE_COUNT + 3;


	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.StatefulHardware <em>Stateful Hardware</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stateful Hardware</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.StatefulHardware
	 * @generated
	 */
	EClass getStatefulHardware();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.StatefulHardware#getProbPermFault <em>Prob Perm Fault</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prob Perm Fault</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.StatefulHardware#getProbPermFault()
	 * @see #getStatefulHardware()
	 * @generated
	 */
	EAttribute getStatefulHardware_ProbPermFault();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.StatefulHardware#getErrorLatency <em>Error Latency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Error Latency</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.StatefulHardware#getErrorLatency()
	 * @see #getStatefulHardware()
	 * @generated
	 */
	EAttribute getStatefulHardware_ErrorLatency();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.StatefulHardware#getRepairDelay <em>Repair Delay</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Repair Delay</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.StatefulHardware#getRepairDelay()
	 * @see #getStatefulHardware()
	 * @generated
	 */
	EAttribute getStatefulHardware_RepairDelay();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.StatefulHardware#getFaultOcc <em>Fault Occ</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fault Occ</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.StatefulHardware#getFaultOcc()
	 * @see #getStatefulHardware()
	 * @generated
	 */
	EAttribute getStatefulHardware_FaultOcc();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.StatefulSoftware <em>Stateful Software</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stateful Software</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.StatefulSoftware
	 * @generated
	 */
	EClass getStatefulSoftware();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.StatefulSoftware#getErrorLatency <em>Error Latency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Error Latency</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.StatefulSoftware#getErrorLatency()
	 * @see #getStatefulSoftware()
	 * @generated
	 */
	EAttribute getStatefulSoftware_ErrorLatency();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.StatefulSoftware#getRepairDelay <em>Repair Delay</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Repair Delay</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.StatefulSoftware#getRepairDelay()
	 * @see #getStatefulSoftware()
	 * @generated
	 */
	EAttribute getStatefulSoftware_RepairDelay();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.StatefulSoftware#getFaultOcc <em>Fault Occ</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fault Occ</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.StatefulSoftware#getFaultOcc()
	 * @see #getStatefulSoftware()
	 * @generated
	 */
	EAttribute getStatefulSoftware_FaultOcc();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.StatelessHardware <em>Stateless Hardware</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stateless Hardware</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.StatelessHardware
	 * @generated
	 */
	EClass getStatelessHardware();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.StatelessHardware#getProbPermFault <em>Prob Perm Fault</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prob Perm Fault</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.StatelessHardware#getProbPermFault()
	 * @see #getStatelessHardware()
	 * @generated
	 */
	EAttribute getStatelessHardware_ProbPermFault();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.StatelessHardware#getRepairDelay <em>Repair Delay</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Repair Delay</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.StatelessHardware#getRepairDelay()
	 * @see #getStatelessHardware()
	 * @generated
	 */
	EAttribute getStatelessHardware_RepairDelay();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.StatelessHardware#getFaultOcc <em>Fault Occ</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fault Occ</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.StatelessHardware#getFaultOcc()
	 * @see #getStatelessHardware()
	 * @generated
	 */
	EAttribute getStatelessHardware_FaultOcc();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.StatelessSoftware <em>Stateless Software</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stateless Software</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.StatelessSoftware
	 * @generated
	 */
	EClass getStatelessSoftware();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.StatelessSoftware#getFaultOcc <em>Fault Occ</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fault Occ</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.StatelessSoftware#getFaultOcc()
	 * @see #getStatelessSoftware()
	 * @generated
	 */
	EAttribute getStatelessSoftware_FaultOcc();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.StochasticFailureBehaviour <em>Stochastic Failure Behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stochastic Failure Behaviour</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.StochasticFailureBehaviour
	 * @generated
	 */
	EClass getStochasticFailureBehaviour();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.StochasticFailureBehaviour#getFailureDistribution <em>Failure Distribution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Failure Distribution</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.StochasticFailureBehaviour#getFailureDistribution()
	 * @see #getStochasticFailureBehaviour()
	 * @generated
	 */
	EAttribute getStochasticFailureBehaviour_FailureDistribution();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.StochasticFailureBehaviour#getRepairDistribution <em>Repair Distribution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Repair Distribution</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.StochasticFailureBehaviour#getRepairDistribution()
	 * @see #getStochasticFailureBehaviour()
	 * @generated
	 */
	EAttribute getStochasticFailureBehaviour_RepairDistribution();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.StochasticFailureBehaviour#getModes <em>Modes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Modes</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.StochasticFailureBehaviour#getModes()
	 * @see #getStochasticFailureBehaviour()
	 * @generated
	 */
	EAttribute getStochasticFailureBehaviour_Modes();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	StateBasedComponentsFactory getStateBasedComponentsFactory();

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
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.impl.StatefulHardwareImpl <em>Stateful Hardware</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.impl.StatefulHardwareImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.impl.StateBasedComponentsPackageImpl#getStatefulHardware()
		 * @generated
		 */
		EClass STATEFUL_HARDWARE = eINSTANCE.getStatefulHardware();

		/**
		 * The meta object literal for the '<em><b>Prob Perm Fault</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATEFUL_HARDWARE__PROB_PERM_FAULT = eINSTANCE.getStatefulHardware_ProbPermFault();

		/**
		 * The meta object literal for the '<em><b>Error Latency</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATEFUL_HARDWARE__ERROR_LATENCY = eINSTANCE.getStatefulHardware_ErrorLatency();

		/**
		 * The meta object literal for the '<em><b>Repair Delay</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATEFUL_HARDWARE__REPAIR_DELAY = eINSTANCE.getStatefulHardware_RepairDelay();

		/**
		 * The meta object literal for the '<em><b>Fault Occ</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATEFUL_HARDWARE__FAULT_OCC = eINSTANCE.getStatefulHardware_FaultOcc();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.impl.StatefulSoftwareImpl <em>Stateful Software</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.impl.StatefulSoftwareImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.impl.StateBasedComponentsPackageImpl#getStatefulSoftware()
		 * @generated
		 */
		EClass STATEFUL_SOFTWARE = eINSTANCE.getStatefulSoftware();

		/**
		 * The meta object literal for the '<em><b>Error Latency</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATEFUL_SOFTWARE__ERROR_LATENCY = eINSTANCE.getStatefulSoftware_ErrorLatency();

		/**
		 * The meta object literal for the '<em><b>Repair Delay</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATEFUL_SOFTWARE__REPAIR_DELAY = eINSTANCE.getStatefulSoftware_RepairDelay();

		/**
		 * The meta object literal for the '<em><b>Fault Occ</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATEFUL_SOFTWARE__FAULT_OCC = eINSTANCE.getStatefulSoftware_FaultOcc();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.impl.StatelessHardwareImpl <em>Stateless Hardware</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.impl.StatelessHardwareImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.impl.StateBasedComponentsPackageImpl#getStatelessHardware()
		 * @generated
		 */
		EClass STATELESS_HARDWARE = eINSTANCE.getStatelessHardware();

		/**
		 * The meta object literal for the '<em><b>Prob Perm Fault</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATELESS_HARDWARE__PROB_PERM_FAULT = eINSTANCE.getStatelessHardware_ProbPermFault();

		/**
		 * The meta object literal for the '<em><b>Repair Delay</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATELESS_HARDWARE__REPAIR_DELAY = eINSTANCE.getStatelessHardware_RepairDelay();

		/**
		 * The meta object literal for the '<em><b>Fault Occ</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATELESS_HARDWARE__FAULT_OCC = eINSTANCE.getStatelessHardware_FaultOcc();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.impl.StatelessSoftwareImpl <em>Stateless Software</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.impl.StatelessSoftwareImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.impl.StateBasedComponentsPackageImpl#getStatelessSoftware()
		 * @generated
		 */
		EClass STATELESS_SOFTWARE = eINSTANCE.getStatelessSoftware();

		/**
		 * The meta object literal for the '<em><b>Fault Occ</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATELESS_SOFTWARE__FAULT_OCC = eINSTANCE.getStatelessSoftware_FaultOcc();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.impl.StochasticFailureBehaviourImpl <em>Stochastic Failure Behaviour</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.impl.StochasticFailureBehaviourImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.impl.StateBasedComponentsPackageImpl#getStochasticFailureBehaviour()
		 * @generated
		 */
		EClass STOCHASTIC_FAILURE_BEHAVIOUR = eINSTANCE.getStochasticFailureBehaviour();

		/**
		 * The meta object literal for the '<em><b>Failure Distribution</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STOCHASTIC_FAILURE_BEHAVIOUR__FAILURE_DISTRIBUTION = eINSTANCE.getStochasticFailureBehaviour_FailureDistribution();

		/**
		 * The meta object literal for the '<em><b>Repair Distribution</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STOCHASTIC_FAILURE_BEHAVIOUR__REPAIR_DISTRIBUTION = eINSTANCE.getStochasticFailureBehaviour_RepairDistribution();

		/**
		 * The meta object literal for the '<em><b>Modes</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STOCHASTIC_FAILURE_BEHAVIOUR__MODES = eINSTANCE.getStochasticFailureBehaviour_Modes();

	}

} //StateBasedComponentsPackage
