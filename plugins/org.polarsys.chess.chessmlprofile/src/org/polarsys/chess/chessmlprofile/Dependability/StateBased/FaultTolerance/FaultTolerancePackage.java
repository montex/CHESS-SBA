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
package org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance;

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
 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.FaultToleranceFactory
 * @model kind="package"
 * @generated
 */
public interface FaultTolerancePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "FaultTolerance";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://CHESS/Dependability/StateBased/FaultTolerance";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "FaultTolerance";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FaultTolerancePackage eINSTANCE = org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.impl.FaultTolerancePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.impl.FaultTolerantImpl <em>Fault Tolerant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.impl.FaultTolerantImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.impl.FaultTolerancePackageImpl#getFaultTolerant()
	 * @generated
	 */
	int FAULT_TOLERANT = 0;

	/**
	 * The feature id for the '<em><b>Base Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULT_TOLERANT__BASE_COMPONENT = 0;

	/**
	 * The feature id for the '<em><b>Scheme</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULT_TOLERANT__SCHEME = 1;

	/**
	 * The feature id for the '<em><b>Scheme Attrs</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULT_TOLERANT__SCHEME_ATTRS = 2;

	/**
	 * The number of structural features of the '<em>Fault Tolerant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULT_TOLERANT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.impl.RedundancyManagerImpl <em>Redundancy Manager</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.impl.RedundancyManagerImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.impl.FaultTolerancePackageImpl#getRedundancyManager()
	 * @generated
	 */
	int REDUNDANCY_MANAGER = 1;

	/**
	 * The feature id for the '<em><b>Base Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDUNDANCY_MANAGER__BASE_COMPONENT = 0;

	/**
	 * The feature id for the '<em><b>Scheme</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDUNDANCY_MANAGER__SCHEME = 1;

	/**
	 * The number of structural features of the '<em>Redundancy Manager</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDUNDANCY_MANAGER_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.impl.VariantImpl <em>Variant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.impl.VariantImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.impl.FaultTolerancePackageImpl#getVariant()
	 * @generated
	 */
	int VARIANT = 2;

	/**
	 * The feature id for the '<em><b>Base Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT__BASE_COMPONENT = 0;

	/**
	 * The number of structural features of the '<em>Variant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.impl.AdjudicatorImpl <em>Adjudicator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.impl.AdjudicatorImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.impl.FaultTolerancePackageImpl#getAdjudicator()
	 * @generated
	 */
	int ADJUDICATOR = 3;

	/**
	 * The feature id for the '<em><b>Base Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADJUDICATOR__BASE_COMPONENT = 0;

	/**
	 * The feature id for the '<em><b>Coverage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADJUDICATOR__COVERAGE = 1;

	/**
	 * The number of structural features of the '<em>Adjudicator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADJUDICATOR_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.FaultTolerant <em>Fault Tolerant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fault Tolerant</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.FaultTolerant
	 * @generated
	 */
	EClass getFaultTolerant();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.FaultTolerant#getBase_Component <em>Base Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Component</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.FaultTolerant#getBase_Component()
	 * @see #getFaultTolerant()
	 * @generated
	 */
	EReference getFaultTolerant_Base_Component();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.FaultTolerant#getScheme <em>Scheme</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scheme</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.FaultTolerant#getScheme()
	 * @see #getFaultTolerant()
	 * @generated
	 */
	EAttribute getFaultTolerant_Scheme();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.FaultTolerant#getSchemeAttrs <em>Scheme Attrs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Scheme Attrs</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.FaultTolerant#getSchemeAttrs()
	 * @see #getFaultTolerant()
	 * @generated
	 */
	EReference getFaultTolerant_SchemeAttrs();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.RedundancyManager <em>Redundancy Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Redundancy Manager</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.RedundancyManager
	 * @generated
	 */
	EClass getRedundancyManager();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.RedundancyManager#getBase_Component <em>Base Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Component</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.RedundancyManager#getBase_Component()
	 * @see #getRedundancyManager()
	 * @generated
	 */
	EReference getRedundancyManager_Base_Component();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.RedundancyManager#getScheme <em>Scheme</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scheme</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.RedundancyManager#getScheme()
	 * @see #getRedundancyManager()
	 * @generated
	 */
	EAttribute getRedundancyManager_Scheme();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.Variant <em>Variant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variant</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.Variant
	 * @generated
	 */
	EClass getVariant();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.Variant#getBase_Component <em>Base Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Component</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.Variant#getBase_Component()
	 * @see #getVariant()
	 * @generated
	 */
	EReference getVariant_Base_Component();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.Adjudicator <em>Adjudicator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Adjudicator</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.Adjudicator
	 * @generated
	 */
	EClass getAdjudicator();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.Adjudicator#getBase_Component <em>Base Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Component</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.Adjudicator#getBase_Component()
	 * @see #getAdjudicator()
	 * @generated
	 */
	EReference getAdjudicator_Base_Component();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.Adjudicator#getCoverage <em>Coverage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Coverage</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.Adjudicator#getCoverage()
	 * @see #getAdjudicator()
	 * @generated
	 */
	EAttribute getAdjudicator_Coverage();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FaultToleranceFactory getFaultToleranceFactory();

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
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.impl.FaultTolerantImpl <em>Fault Tolerant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.impl.FaultTolerantImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.impl.FaultTolerancePackageImpl#getFaultTolerant()
		 * @generated
		 */
		EClass FAULT_TOLERANT = eINSTANCE.getFaultTolerant();

		/**
		 * The meta object literal for the '<em><b>Base Component</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAULT_TOLERANT__BASE_COMPONENT = eINSTANCE.getFaultTolerant_Base_Component();

		/**
		 * The meta object literal for the '<em><b>Scheme</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAULT_TOLERANT__SCHEME = eINSTANCE.getFaultTolerant_Scheme();

		/**
		 * The meta object literal for the '<em><b>Scheme Attrs</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAULT_TOLERANT__SCHEME_ATTRS = eINSTANCE.getFaultTolerant_SchemeAttrs();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.impl.RedundancyManagerImpl <em>Redundancy Manager</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.impl.RedundancyManagerImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.impl.FaultTolerancePackageImpl#getRedundancyManager()
		 * @generated
		 */
		EClass REDUNDANCY_MANAGER = eINSTANCE.getRedundancyManager();

		/**
		 * The meta object literal for the '<em><b>Base Component</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REDUNDANCY_MANAGER__BASE_COMPONENT = eINSTANCE.getRedundancyManager_Base_Component();

		/**
		 * The meta object literal for the '<em><b>Scheme</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REDUNDANCY_MANAGER__SCHEME = eINSTANCE.getRedundancyManager_Scheme();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.impl.VariantImpl <em>Variant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.impl.VariantImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.impl.FaultTolerancePackageImpl#getVariant()
		 * @generated
		 */
		EClass VARIANT = eINSTANCE.getVariant();

		/**
		 * The meta object literal for the '<em><b>Base Component</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIANT__BASE_COMPONENT = eINSTANCE.getVariant_Base_Component();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.impl.AdjudicatorImpl <em>Adjudicator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.impl.AdjudicatorImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.impl.FaultTolerancePackageImpl#getAdjudicator()
		 * @generated
		 */
		EClass ADJUDICATOR = eINSTANCE.getAdjudicator();

		/**
		 * The meta object literal for the '<em><b>Base Component</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADJUDICATOR__BASE_COMPONENT = eINSTANCE.getAdjudicator_Base_Component();

		/**
		 * The meta object literal for the '<em><b>Coverage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADJUDICATOR__COVERAGE = eINSTANCE.getAdjudicator_Coverage();

	}

} //FaultTolerancePackage
