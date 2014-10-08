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
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.DependableComponentImpl <em>Dependable Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.DependableComponentImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.DependableComponentPackageImpl#getDependableComponent()
	 * @generated
	 */
	int DEPENDABLE_COMPONENT = 1;

	/**
	 * The feature id for the '<em><b>Base Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDABLE_COMPONENT__BASE_COMPONENT = 0;

	/**
	 * The feature id for the '<em><b>Error Model</b></em>' reference.
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
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDABLE_COMPONENT__BASE_CLASS = 3;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDABLE_COMPONENT__BASE_INSTANCE_SPECIFICATION = 4;

	/**
	 * The number of structural features of the '<em>Dependable Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDABLE_COMPONENT_FEATURE_COUNT = 5;


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
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponent#getErrorModel <em>Error Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Error Model</em>'.
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
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponent#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponent#getBase_Class()
	 * @see #getDependableComponent()
	 * @generated
	 */
	EReference getDependableComponent_Base_Class();

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
		 * The meta object literal for the '<em><b>Error Model</b></em>' reference feature.
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
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDABLE_COMPONENT__BASE_CLASS = eINSTANCE.getDependableComponent_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Base Instance Specification</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDABLE_COMPONENT__BASE_INSTANCE_SPECIFICATION = eINSTANCE.getDependableComponent_Base_InstanceSpecification();

	}

} //DependableComponentPackage
