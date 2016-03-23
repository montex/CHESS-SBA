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
package org.polarsys.chess.chessmlprofile.ComponentModel;

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
 * @see org.polarsys.chess.chessmlprofile.ComponentModel.ComponentModelFactory
 * @model kind="package"
 * @generated
 */
public interface ComponentModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ComponentModel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://CHESS/ComponentModel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ComponentModel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ComponentModelPackage eINSTANCE = org.polarsys.chess.chessmlprofile.ComponentModel.impl.ComponentModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.ComponentModel.impl.ComponentTypeImpl <em>Component Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.ComponentModel.impl.ComponentTypeImpl
	 * @see org.polarsys.chess.chessmlprofile.ComponentModel.impl.ComponentModelPackageImpl#getComponentType()
	 * @generated
	 */
	int COMPONENT_TYPE = 2;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.ComponentModel.impl.ComponentImplementationImpl <em>Component Implementation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.ComponentModel.impl.ComponentImplementationImpl
	 * @see org.polarsys.chess.chessmlprofile.ComponentModel.impl.ComponentModelPackageImpl#getComponentImplementation()
	 * @generated
	 */
	int COMPONENT_IMPLEMENTATION = 3;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.ComponentModel.impl.FunctionalPartitionImpl <em>Functional Partition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.ComponentModel.impl.FunctionalPartitionImpl
	 * @see org.polarsys.chess.chessmlprofile.ComponentModel.impl.ComponentModelPackageImpl#getFunctionalPartition()
	 * @generated
	 */
	int FUNCTIONAL_PARTITION = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.ComponentModel.impl.HwAbstractionComponentImplImpl <em>Hw Abstraction Component Impl</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.ComponentModel.impl.HwAbstractionComponentImplImpl
	 * @see org.polarsys.chess.chessmlprofile.ComponentModel.impl.ComponentModelPackageImpl#getHwAbstractionComponentImpl()
	 * @generated
	 */
	int HW_ABSTRACTION_COMPONENT_IMPL = 1;

	/**
	 * The feature id for the '<em><b>Utilization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_PARTITION__UTILIZATION = 0;

	/**
	 * The feature id for the '<em><b>Base Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_PARTITION__BASE_COMPONENT = 1;

	/**
	 * The feature id for the '<em><b>MAF</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_PARTITION__MAF = 2;

	/**
	 * The feature id for the '<em><b>MIF</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_PARTITION__MIF = 3;

	/**
	 * The feature id for the '<em><b>Scheduling Table</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_PARTITION__SCHEDULING_TABLE = 4;

	/**
	 * The number of structural features of the '<em>Functional Partition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_PARTITION_FEATURE_COUNT = 5;

	/**
	 * The feature id for the '<em><b>Hw Res</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_ABSTRACTION_COMPONENT_IMPL__HW_RES = 0;

	/**
	 * The feature id for the '<em><b>Base Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_ABSTRACTION_COMPONENT_IMPL__BASE_COMPONENT = 1;

	/**
	 * The number of structural features of the '<em>Hw Abstraction Component Impl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_ABSTRACTION_COMPONENT_IMPL_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Base Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE__BASE_COMPONENT = 0;

	/**
	 * The number of structural features of the '<em>Component Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Base Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_IMPLEMENTATION__BASE_COMPONENT = 0;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_IMPLEMENTATION__LANGUAGE = 1;

	/**
	 * The feature id for the '<em><b>OS</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_IMPLEMENTATION__OS = 2;

	/**
	 * The feature id for the '<em><b>Source Code Location</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_IMPLEMENTATION__SOURCE_CODE_LOCATION = 3;

	/**
	 * The number of structural features of the '<em>Component Implementation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_IMPLEMENTATION_FEATURE_COUNT = 4;


	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.ComponentModel.ComponentType <em>Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Type</em>'.
	 * @see org.polarsys.chess.chessmlprofile.ComponentModel.ComponentType
	 * @generated
	 */
	EClass getComponentType();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.ComponentModel.ComponentType#getBase_Component <em>Base Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Component</em>'.
	 * @see org.polarsys.chess.chessmlprofile.ComponentModel.ComponentType#getBase_Component()
	 * @see #getComponentType()
	 * @generated
	 */
	EReference getComponentType_Base_Component();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.ComponentModel.ComponentImplementation <em>Component Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Implementation</em>'.
	 * @see org.polarsys.chess.chessmlprofile.ComponentModel.ComponentImplementation
	 * @generated
	 */
	EClass getComponentImplementation();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.ComponentModel.ComponentImplementation#getBase_Component <em>Base Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Component</em>'.
	 * @see org.polarsys.chess.chessmlprofile.ComponentModel.ComponentImplementation#getBase_Component()
	 * @see #getComponentImplementation()
	 * @generated
	 */
	EReference getComponentImplementation_Base_Component();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.ComponentModel.ComponentImplementation#getLanguage <em>Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Language</em>'.
	 * @see org.polarsys.chess.chessmlprofile.ComponentModel.ComponentImplementation#getLanguage()
	 * @see #getComponentImplementation()
	 * @generated
	 */
	EAttribute getComponentImplementation_Language();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.ComponentModel.ComponentImplementation#getOS <em>OS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>OS</em>'.
	 * @see org.polarsys.chess.chessmlprofile.ComponentModel.ComponentImplementation#getOS()
	 * @see #getComponentImplementation()
	 * @generated
	 */
	EAttribute getComponentImplementation_OS();

	/**
	 * Returns the meta object for the attribute list '{@link org.polarsys.chess.chessmlprofile.ComponentModel.ComponentImplementation#getSourceCodeLocation <em>Source Code Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Source Code Location</em>'.
	 * @see org.polarsys.chess.chessmlprofile.ComponentModel.ComponentImplementation#getSourceCodeLocation()
	 * @see #getComponentImplementation()
	 * @generated
	 */
	EAttribute getComponentImplementation_SourceCodeLocation();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.ComponentModel.FunctionalPartition <em>Functional Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Functional Partition</em>'.
	 * @see org.polarsys.chess.chessmlprofile.ComponentModel.FunctionalPartition
	 * @generated
	 */
	EClass getFunctionalPartition();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.ComponentModel.FunctionalPartition#getUtilization <em>Utilization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Utilization</em>'.
	 * @see org.polarsys.chess.chessmlprofile.ComponentModel.FunctionalPartition#getUtilization()
	 * @see #getFunctionalPartition()
	 * @generated
	 */
	EAttribute getFunctionalPartition_Utilization();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.ComponentModel.FunctionalPartition#getBase_Component <em>Base Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Component</em>'.
	 * @see org.polarsys.chess.chessmlprofile.ComponentModel.FunctionalPartition#getBase_Component()
	 * @see #getFunctionalPartition()
	 * @generated
	 */
	EReference getFunctionalPartition_Base_Component();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.ComponentModel.FunctionalPartition#getMAF <em>MAF</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>MAF</em>'.
	 * @see org.polarsys.chess.chessmlprofile.ComponentModel.FunctionalPartition#getMAF()
	 * @see #getFunctionalPartition()
	 * @generated
	 */
	EAttribute getFunctionalPartition_MAF();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.ComponentModel.FunctionalPartition#getMIF <em>MIF</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>MIF</em>'.
	 * @see org.polarsys.chess.chessmlprofile.ComponentModel.FunctionalPartition#getMIF()
	 * @see #getFunctionalPartition()
	 * @generated
	 */
	EAttribute getFunctionalPartition_MIF();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.ComponentModel.FunctionalPartition#getSchedulingTable <em>Scheduling Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scheduling Table</em>'.
	 * @see org.polarsys.chess.chessmlprofile.ComponentModel.FunctionalPartition#getSchedulingTable()
	 * @see #getFunctionalPartition()
	 * @generated
	 */
	EAttribute getFunctionalPartition_SchedulingTable();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.ComponentModel.HwAbstractionComponentImpl <em>Hw Abstraction Component Impl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hw Abstraction Component Impl</em>'.
	 * @see org.polarsys.chess.chessmlprofile.ComponentModel.HwAbstractionComponentImpl
	 * @generated
	 */
	EClass getHwAbstractionComponentImpl();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.ComponentModel.HwAbstractionComponentImpl#getHwRes <em>Hw Res</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Hw Res</em>'.
	 * @see org.polarsys.chess.chessmlprofile.ComponentModel.HwAbstractionComponentImpl#getHwRes()
	 * @see #getHwAbstractionComponentImpl()
	 * @generated
	 */
	EReference getHwAbstractionComponentImpl_HwRes();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.ComponentModel.HwAbstractionComponentImpl#getBase_Component <em>Base Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Component</em>'.
	 * @see org.polarsys.chess.chessmlprofile.ComponentModel.HwAbstractionComponentImpl#getBase_Component()
	 * @see #getHwAbstractionComponentImpl()
	 * @generated
	 */
	EReference getHwAbstractionComponentImpl_Base_Component();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ComponentModelFactory getComponentModelFactory();

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
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.ComponentModel.impl.ComponentTypeImpl <em>Component Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.ComponentModel.impl.ComponentTypeImpl
		 * @see org.polarsys.chess.chessmlprofile.ComponentModel.impl.ComponentModelPackageImpl#getComponentType()
		 * @generated
		 */
		EClass COMPONENT_TYPE = eINSTANCE.getComponentType();

		/**
		 * The meta object literal for the '<em><b>Base Component</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_TYPE__BASE_COMPONENT = eINSTANCE.getComponentType_Base_Component();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.ComponentModel.impl.ComponentImplementationImpl <em>Component Implementation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.ComponentModel.impl.ComponentImplementationImpl
		 * @see org.polarsys.chess.chessmlprofile.ComponentModel.impl.ComponentModelPackageImpl#getComponentImplementation()
		 * @generated
		 */
		EClass COMPONENT_IMPLEMENTATION = eINSTANCE.getComponentImplementation();

		/**
		 * The meta object literal for the '<em><b>Base Component</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_IMPLEMENTATION__BASE_COMPONENT = eINSTANCE.getComponentImplementation_Base_Component();

		/**
		 * The meta object literal for the '<em><b>Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_IMPLEMENTATION__LANGUAGE = eINSTANCE.getComponentImplementation_Language();

		/**
		 * The meta object literal for the '<em><b>OS</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_IMPLEMENTATION__OS = eINSTANCE.getComponentImplementation_OS();

		/**
		 * The meta object literal for the '<em><b>Source Code Location</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_IMPLEMENTATION__SOURCE_CODE_LOCATION = eINSTANCE.getComponentImplementation_SourceCodeLocation();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.ComponentModel.impl.FunctionalPartitionImpl <em>Functional Partition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.ComponentModel.impl.FunctionalPartitionImpl
		 * @see org.polarsys.chess.chessmlprofile.ComponentModel.impl.ComponentModelPackageImpl#getFunctionalPartition()
		 * @generated
		 */
		EClass FUNCTIONAL_PARTITION = eINSTANCE.getFunctionalPartition();

		/**
		 * The meta object literal for the '<em><b>Utilization</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTIONAL_PARTITION__UTILIZATION = eINSTANCE.getFunctionalPartition_Utilization();

		/**
		 * The meta object literal for the '<em><b>Base Component</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTIONAL_PARTITION__BASE_COMPONENT = eINSTANCE.getFunctionalPartition_Base_Component();

		/**
		 * The meta object literal for the '<em><b>MAF</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTIONAL_PARTITION__MAF = eINSTANCE.getFunctionalPartition_MAF();

		/**
		 * The meta object literal for the '<em><b>MIF</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTIONAL_PARTITION__MIF = eINSTANCE.getFunctionalPartition_MIF();

		/**
		 * The meta object literal for the '<em><b>Scheduling Table</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTIONAL_PARTITION__SCHEDULING_TABLE = eINSTANCE.getFunctionalPartition_SchedulingTable();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.ComponentModel.impl.HwAbstractionComponentImplImpl <em>Hw Abstraction Component Impl</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.ComponentModel.impl.HwAbstractionComponentImplImpl
		 * @see org.polarsys.chess.chessmlprofile.ComponentModel.impl.ComponentModelPackageImpl#getHwAbstractionComponentImpl()
		 * @generated
		 */
		EClass HW_ABSTRACTION_COMPONENT_IMPL = eINSTANCE.getHwAbstractionComponentImpl();

		/**
		 * The meta object literal for the '<em><b>Hw Res</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HW_ABSTRACTION_COMPONENT_IMPL__HW_RES = eINSTANCE.getHwAbstractionComponentImpl_HwRes();

		/**
		 * The meta object literal for the '<em><b>Base Component</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HW_ABSTRACTION_COMPONENT_IMPL__BASE_COMPONENT = eINSTANCE.getHwAbstractionComponentImpl_Base_Component();

	}

} //ComponentModelPackage
