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
package org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage;
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
 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationFactory
 * @model kind="package"
 * @generated
 */
public interface FailurePropagationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "FailurePropagation";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://CHESS/Dependability/FailurePropagation";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "FailurePropagation";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FailurePropagationPackage eINSTANCE = org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FailurePropagationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FPTCImpl <em>FPTC</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FPTCImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FailurePropagationPackageImpl#getFPTC()
	 * @generated
	 */
	int FPTC = 0;

	/**
	 * The feature id for the '<em><b>Base Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FPTC__BASE_COMPONENT = DependableComponentPackage.DEPENDABLE_COMPONENT__BASE_COMPONENT;

	/**
	 * The feature id for the '<em><b>Error Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FPTC__ERROR_MODEL = DependableComponentPackage.DEPENDABLE_COMPONENT__ERROR_MODEL;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FPTC__BASE_PROPERTY = DependableComponentPackage.DEPENDABLE_COMPONENT__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FPTC__BASE_CLASS = DependableComponentPackage.DEPENDABLE_COMPONENT__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FPTC__BASE_INSTANCE_SPECIFICATION = DependableComponentPackage.DEPENDABLE_COMPONENT__BASE_INSTANCE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Fptc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FPTC__FPTC = DependableComponentPackage.DEPENDABLE_COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Comment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FPTC__BASE_COMMENT = DependableComponentPackage.DEPENDABLE_COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FPTC__BASE_CONNECTOR = DependableComponentPackage.DEPENDABLE_COMPONENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>FPTC</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FPTC_FEATURE_COUNT = DependableComponentPackage.DEPENDABLE_COMPONENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FailurePropagationAnalysisImpl <em>Analysis</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FailurePropagationAnalysisImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FailurePropagationPackageImpl#getFailurePropagationAnalysis()
	 * @generated
	 */
	int FAILURE_PROPAGATION_ANALYSIS = 1;

	/**
	 * The feature id for the '<em><b>Base Structured Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_PROPAGATION_ANALYSIS__BASE_STRUCTURED_CLASSIFIER = GQAMPackage.GA_ANALYSIS_CONTEXT__BASE_STRUCTURED_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_PROPAGATION_ANALYSIS__BASE_PACKAGE = GQAMPackage.GA_ANALYSIS_CONTEXT__BASE_PACKAGE;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_PROPAGATION_ANALYSIS__MODE = GQAMPackage.GA_ANALYSIS_CONTEXT__MODE;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_PROPAGATION_ANALYSIS__BASE_NAMED_ELEMENT = GQAMPackage.GA_ANALYSIS_CONTEXT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_PROPAGATION_ANALYSIS__CONTEXT = GQAMPackage.GA_ANALYSIS_CONTEXT__CONTEXT;

	/**
	 * The feature id for the '<em><b>Workload</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_PROPAGATION_ANALYSIS__WORKLOAD = GQAMPackage.GA_ANALYSIS_CONTEXT__WORKLOAD;

	/**
	 * The feature id for the '<em><b>Platform</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_PROPAGATION_ANALYSIS__PLATFORM = GQAMPackage.GA_ANALYSIS_CONTEXT__PLATFORM;

	/**
	 * The number of structural features of the '<em>Analysis</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_PROPAGATION_ANALYSIS_FEATURE_COUNT = GQAMPackage.GA_ANALYSIS_CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FPTCSpecificationImpl <em>FPTC Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FPTCSpecificationImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FailurePropagationPackageImpl#getFPTCSpecification()
	 * @generated
	 */
	int FPTC_SPECIFICATION = 2;

	/**
	 * The feature id for the '<em><b>Base Comment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FPTC_SPECIFICATION__BASE_COMMENT = 0;

	/**
	 * The feature id for the '<em><b>Failure</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FPTC_SPECIFICATION__FAILURE = 1;

	/**
	 * The feature id for the '<em><b>Part With Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FPTC_SPECIFICATION__PART_WITH_PORT = 2;

	/**
	 * The number of structural features of the '<em>FPTC Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FPTC_SPECIFICATION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FPTCPortSlotImpl <em>FPTC Port Slot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FPTCPortSlotImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FailurePropagationPackageImpl#getFPTCPortSlot()
	 * @generated
	 */
	int FPTC_PORT_SLOT = 3;

	/**
	 * The feature id for the '<em><b>FPTC Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FPTC_PORT_SLOT__FPTC_SPECIFICATION = 0;

	/**
	 * The feature id for the '<em><b>Base Slot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FPTC_PORT_SLOT__BASE_SLOT = 1;

	/**
	 * The feature id for the '<em><b>Failure</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FPTC_PORT_SLOT__FAILURE = 2;

	/**
	 * The number of structural features of the '<em>FPTC Port Slot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FPTC_PORT_SLOT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FI4FAImpl <em>FI4FA</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FI4FAImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FailurePropagationPackageImpl#getFI4FA()
	 * @generated
	 */
	int FI4FA = 4;

	/**
	 * The feature id for the '<em><b>Base Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FI4FA__BASE_COMPONENT = DependableComponentPackage.DEPENDABLE_COMPONENT__BASE_COMPONENT;

	/**
	 * The feature id for the '<em><b>Error Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FI4FA__ERROR_MODEL = DependableComponentPackage.DEPENDABLE_COMPONENT__ERROR_MODEL;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FI4FA__BASE_PROPERTY = DependableComponentPackage.DEPENDABLE_COMPONENT__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FI4FA__BASE_CLASS = DependableComponentPackage.DEPENDABLE_COMPONENT__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FI4FA__BASE_INSTANCE_SPECIFICATION = DependableComponentPackage.DEPENDABLE_COMPONENT__BASE_INSTANCE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Fi4fa</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FI4FA__FI4FA = DependableComponentPackage.DEPENDABLE_COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FI4FA__BASE_CONNECTOR = DependableComponentPackage.DEPENDABLE_COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>FI4FA</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FI4FA_FEATURE_COUNT = DependableComponentPackage.DEPENDABLE_COMPONENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FI4FASpecificationImpl <em>FI4FA Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FI4FASpecificationImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FailurePropagationPackageImpl#getFI4FASpecification()
	 * @generated
	 */
	int FI4FA_SPECIFICATION = 5;

	/**
	 * The feature id for the '<em><b>Base Comment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FI4FA_SPECIFICATION__BASE_COMMENT = FPTC_SPECIFICATION__BASE_COMMENT;

	/**
	 * The feature id for the '<em><b>Failure</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FI4FA_SPECIFICATION__FAILURE = FPTC_SPECIFICATION__FAILURE;

	/**
	 * The feature id for the '<em><b>Part With Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FI4FA_SPECIFICATION__PART_WITH_PORT = FPTC_SPECIFICATION__PART_WITH_PORT;

	/**
	 * The number of structural features of the '<em>FI4FA Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FI4FA_SPECIFICATION_FEATURE_COUNT = FPTC_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.ACIDAvoidableImpl <em>ACID Avoidable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.ACIDAvoidableImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FailurePropagationPackageImpl#getACIDAvoidable()
	 * @generated
	 */
	int ACID_AVOIDABLE = 6;

	/**
	 * The feature id for the '<em><b>A</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACID_AVOIDABLE__A = 0;

	/**
	 * The feature id for the '<em><b>C</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACID_AVOIDABLE__C = 1;

	/**
	 * The feature id for the '<em><b>Base Comment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACID_AVOIDABLE__BASE_COMMENT = 2;

	/**
	 * The feature id for the '<em><b>I</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACID_AVOIDABLE__I = 3;

	/**
	 * The feature id for the '<em><b>D</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACID_AVOIDABLE__D = 4;

	/**
	 * The number of structural features of the '<em>ACID Avoidable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACID_AVOIDABLE_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.ACIDMitigationImpl <em>ACID Mitigation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.ACIDMitigationImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FailurePropagationPackageImpl#getACIDMitigation()
	 * @generated
	 */
	int ACID_MITIGATION = 7;

	/**
	 * The feature id for the '<em><b>Base Comment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACID_MITIGATION__BASE_COMMENT = 0;

	/**
	 * The feature id for the '<em><b>A</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACID_MITIGATION__A = 1;

	/**
	 * The feature id for the '<em><b>C</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACID_MITIGATION__C = 2;

	/**
	 * The feature id for the '<em><b>I</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACID_MITIGATION__I = 3;

	/**
	 * The feature id for the '<em><b>D</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACID_MITIGATION__D = 4;

	/**
	 * The number of structural features of the '<em>ACID Mitigation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACID_MITIGATION_FEATURE_COUNT = 5;


	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FI4FAAnalysisImpl <em>FI4FA Analysis</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FI4FAAnalysisImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FailurePropagationPackageImpl#getFI4FAAnalysis()
	 * @generated
	 */
	int FI4FA_ANALYSIS = 8;

	/**
	 * The feature id for the '<em><b>Base Structured Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FI4FA_ANALYSIS__BASE_STRUCTURED_CLASSIFIER = GQAMPackage.GA_ANALYSIS_CONTEXT__BASE_STRUCTURED_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FI4FA_ANALYSIS__BASE_PACKAGE = GQAMPackage.GA_ANALYSIS_CONTEXT__BASE_PACKAGE;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FI4FA_ANALYSIS__MODE = GQAMPackage.GA_ANALYSIS_CONTEXT__MODE;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FI4FA_ANALYSIS__BASE_NAMED_ELEMENT = GQAMPackage.GA_ANALYSIS_CONTEXT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FI4FA_ANALYSIS__CONTEXT = GQAMPackage.GA_ANALYSIS_CONTEXT__CONTEXT;

	/**
	 * The feature id for the '<em><b>Workload</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FI4FA_ANALYSIS__WORKLOAD = GQAMPackage.GA_ANALYSIS_CONTEXT__WORKLOAD;

	/**
	 * The feature id for the '<em><b>Platform</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FI4FA_ANALYSIS__PLATFORM = GQAMPackage.GA_ANALYSIS_CONTEXT__PLATFORM;

	/**
	 * The number of structural features of the '<em>FI4FA Analysis</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FI4FA_ANALYSIS_FEATURE_COUNT = GQAMPackage.GA_ANALYSIS_CONTEXT_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FPTC <em>FPTC</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FPTC</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FPTC
	 * @generated
	 */
	EClass getFPTC();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FPTC#getFptc <em>Fptc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fptc</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FPTC#getFptc()
	 * @see #getFPTC()
	 * @generated
	 */
	EAttribute getFPTC_Fptc();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FPTC#getBase_Comment <em>Base Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Comment</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FPTC#getBase_Comment()
	 * @see #getFPTC()
	 * @generated
	 */
	EReference getFPTC_Base_Comment();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FPTC#getBase_Connector <em>Base Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Connector</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FPTC#getBase_Connector()
	 * @see #getFPTC()
	 * @generated
	 */
	EReference getFPTC_Base_Connector();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationAnalysis <em>Analysis</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Analysis</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationAnalysis
	 * @generated
	 */
	EClass getFailurePropagationAnalysis();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FPTCSpecification <em>FPTC Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FPTC Specification</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FPTCSpecification
	 * @generated
	 */
	EClass getFPTCSpecification();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FPTCSpecification#getBase_Comment <em>Base Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Comment</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FPTCSpecification#getBase_Comment()
	 * @see #getFPTCSpecification()
	 * @generated
	 */
	EReference getFPTCSpecification_Base_Comment();

	/**
	 * Returns the meta object for the attribute list '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FPTCSpecification#getFailure <em>Failure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Failure</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FPTCSpecification#getFailure()
	 * @see #getFPTCSpecification()
	 * @generated
	 */
	EAttribute getFPTCSpecification_Failure();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FPTCSpecification#getPartWithPort <em>Part With Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Part With Port</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FPTCSpecification#getPartWithPort()
	 * @see #getFPTCSpecification()
	 * @generated
	 */
	EReference getFPTCSpecification_PartWithPort();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FPTCPortSlot <em>FPTC Port Slot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FPTC Port Slot</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FPTCPortSlot
	 * @generated
	 */
	EClass getFPTCPortSlot();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FPTCPortSlot#getFPTCSpecification <em>FPTC Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>FPTC Specification</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FPTCPortSlot#getFPTCSpecification()
	 * @see #getFPTCPortSlot()
	 * @generated
	 */
	EReference getFPTCPortSlot_FPTCSpecification();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FPTCPortSlot#getBase_Slot <em>Base Slot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Slot</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FPTCPortSlot#getBase_Slot()
	 * @see #getFPTCPortSlot()
	 * @generated
	 */
	EReference getFPTCPortSlot_Base_Slot();

	/**
	 * Returns the meta object for the attribute list '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FPTCPortSlot#getFailure <em>Failure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Failure</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FPTCPortSlot#getFailure()
	 * @see #getFPTCPortSlot()
	 * @generated
	 */
	EAttribute getFPTCPortSlot_Failure();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FI4FA <em>FI4FA</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FI4FA</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FI4FA
	 * @generated
	 */
	EClass getFI4FA();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FI4FA#getFi4fa <em>Fi4fa</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fi4fa</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FI4FA#getFi4fa()
	 * @see #getFI4FA()
	 * @generated
	 */
	EAttribute getFI4FA_Fi4fa();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FI4FA#getBase_Connector <em>Base Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Connector</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FI4FA#getBase_Connector()
	 * @see #getFI4FA()
	 * @generated
	 */
	EReference getFI4FA_Base_Connector();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FI4FASpecification <em>FI4FA Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FI4FA Specification</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FI4FASpecification
	 * @generated
	 */
	EClass getFI4FASpecification();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.ACIDAvoidable <em>ACID Avoidable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ACID Avoidable</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.ACIDAvoidable
	 * @generated
	 */
	EClass getACIDAvoidable();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.ACIDAvoidable#getA <em>A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>A</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.ACIDAvoidable#getA()
	 * @see #getACIDAvoidable()
	 * @generated
	 */
	EAttribute getACIDAvoidable_A();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.ACIDAvoidable#getC <em>C</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>C</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.ACIDAvoidable#getC()
	 * @see #getACIDAvoidable()
	 * @generated
	 */
	EAttribute getACIDAvoidable_C();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.ACIDAvoidable#getBase_Comment <em>Base Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Comment</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.ACIDAvoidable#getBase_Comment()
	 * @see #getACIDAvoidable()
	 * @generated
	 */
	EReference getACIDAvoidable_Base_Comment();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.ACIDAvoidable#getI <em>I</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>I</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.ACIDAvoidable#getI()
	 * @see #getACIDAvoidable()
	 * @generated
	 */
	EAttribute getACIDAvoidable_I();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.ACIDAvoidable#getD <em>D</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>D</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.ACIDAvoidable#getD()
	 * @see #getACIDAvoidable()
	 * @generated
	 */
	EAttribute getACIDAvoidable_D();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.ACIDMitigation <em>ACID Mitigation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ACID Mitigation</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.ACIDMitigation
	 * @generated
	 */
	EClass getACIDMitigation();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.ACIDMitigation#getBase_Comment <em>Base Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Comment</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.ACIDMitigation#getBase_Comment()
	 * @see #getACIDMitigation()
	 * @generated
	 */
	EReference getACIDMitigation_Base_Comment();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.ACIDMitigation#getA <em>A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>A</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.ACIDMitigation#getA()
	 * @see #getACIDMitigation()
	 * @generated
	 */
	EAttribute getACIDMitigation_A();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.ACIDMitigation#getC <em>C</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>C</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.ACIDMitigation#getC()
	 * @see #getACIDMitigation()
	 * @generated
	 */
	EAttribute getACIDMitigation_C();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.ACIDMitigation#getI <em>I</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>I</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.ACIDMitigation#getI()
	 * @see #getACIDMitigation()
	 * @generated
	 */
	EAttribute getACIDMitigation_I();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.ACIDMitigation#getD <em>D</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>D</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.ACIDMitigation#getD()
	 * @see #getACIDMitigation()
	 * @generated
	 */
	EAttribute getACIDMitigation_D();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FI4FAAnalysis <em>FI4FA Analysis</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FI4FA Analysis</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FI4FAAnalysis
	 * @generated
	 */
	EClass getFI4FAAnalysis();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FailurePropagationFactory getFailurePropagationFactory();

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
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FPTCImpl <em>FPTC</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FPTCImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FailurePropagationPackageImpl#getFPTC()
		 * @generated
		 */
		EClass FPTC = eINSTANCE.getFPTC();

		/**
		 * The meta object literal for the '<em><b>Fptc</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FPTC__FPTC = eINSTANCE.getFPTC_Fptc();

		/**
		 * The meta object literal for the '<em><b>Base Comment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FPTC__BASE_COMMENT = eINSTANCE.getFPTC_Base_Comment();

		/**
		 * The meta object literal for the '<em><b>Base Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FPTC__BASE_CONNECTOR = eINSTANCE.getFPTC_Base_Connector();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FailurePropagationAnalysisImpl <em>Analysis</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FailurePropagationAnalysisImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FailurePropagationPackageImpl#getFailurePropagationAnalysis()
		 * @generated
		 */
		EClass FAILURE_PROPAGATION_ANALYSIS = eINSTANCE.getFailurePropagationAnalysis();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FPTCSpecificationImpl <em>FPTC Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FPTCSpecificationImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FailurePropagationPackageImpl#getFPTCSpecification()
		 * @generated
		 */
		EClass FPTC_SPECIFICATION = eINSTANCE.getFPTCSpecification();

		/**
		 * The meta object literal for the '<em><b>Base Comment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FPTC_SPECIFICATION__BASE_COMMENT = eINSTANCE.getFPTCSpecification_Base_Comment();

		/**
		 * The meta object literal for the '<em><b>Failure</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FPTC_SPECIFICATION__FAILURE = eINSTANCE.getFPTCSpecification_Failure();

		/**
		 * The meta object literal for the '<em><b>Part With Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FPTC_SPECIFICATION__PART_WITH_PORT = eINSTANCE.getFPTCSpecification_PartWithPort();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FPTCPortSlotImpl <em>FPTC Port Slot</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FPTCPortSlotImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FailurePropagationPackageImpl#getFPTCPortSlot()
		 * @generated
		 */
		EClass FPTC_PORT_SLOT = eINSTANCE.getFPTCPortSlot();

		/**
		 * The meta object literal for the '<em><b>FPTC Specification</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FPTC_PORT_SLOT__FPTC_SPECIFICATION = eINSTANCE.getFPTCPortSlot_FPTCSpecification();

		/**
		 * The meta object literal for the '<em><b>Base Slot</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FPTC_PORT_SLOT__BASE_SLOT = eINSTANCE.getFPTCPortSlot_Base_Slot();

		/**
		 * The meta object literal for the '<em><b>Failure</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FPTC_PORT_SLOT__FAILURE = eINSTANCE.getFPTCPortSlot_Failure();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FI4FAImpl <em>FI4FA</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FI4FAImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FailurePropagationPackageImpl#getFI4FA()
		 * @generated
		 */
		EClass FI4FA = eINSTANCE.getFI4FA();

		/**
		 * The meta object literal for the '<em><b>Fi4fa</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FI4FA__FI4FA = eINSTANCE.getFI4FA_Fi4fa();

		/**
		 * The meta object literal for the '<em><b>Base Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FI4FA__BASE_CONNECTOR = eINSTANCE.getFI4FA_Base_Connector();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FI4FASpecificationImpl <em>FI4FA Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FI4FASpecificationImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FailurePropagationPackageImpl#getFI4FASpecification()
		 * @generated
		 */
		EClass FI4FA_SPECIFICATION = eINSTANCE.getFI4FASpecification();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.ACIDAvoidableImpl <em>ACID Avoidable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.ACIDAvoidableImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FailurePropagationPackageImpl#getACIDAvoidable()
		 * @generated
		 */
		EClass ACID_AVOIDABLE = eINSTANCE.getACIDAvoidable();

		/**
		 * The meta object literal for the '<em><b>A</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACID_AVOIDABLE__A = eINSTANCE.getACIDAvoidable_A();

		/**
		 * The meta object literal for the '<em><b>C</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACID_AVOIDABLE__C = eINSTANCE.getACIDAvoidable_C();

		/**
		 * The meta object literal for the '<em><b>Base Comment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACID_AVOIDABLE__BASE_COMMENT = eINSTANCE.getACIDAvoidable_Base_Comment();

		/**
		 * The meta object literal for the '<em><b>I</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACID_AVOIDABLE__I = eINSTANCE.getACIDAvoidable_I();

		/**
		 * The meta object literal for the '<em><b>D</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACID_AVOIDABLE__D = eINSTANCE.getACIDAvoidable_D();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.ACIDMitigationImpl <em>ACID Mitigation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.ACIDMitigationImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FailurePropagationPackageImpl#getACIDMitigation()
		 * @generated
		 */
		EClass ACID_MITIGATION = eINSTANCE.getACIDMitigation();

		/**
		 * The meta object literal for the '<em><b>Base Comment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACID_MITIGATION__BASE_COMMENT = eINSTANCE.getACIDMitigation_Base_Comment();

		/**
		 * The meta object literal for the '<em><b>A</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACID_MITIGATION__A = eINSTANCE.getACIDMitigation_A();

		/**
		 * The meta object literal for the '<em><b>C</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACID_MITIGATION__C = eINSTANCE.getACIDMitigation_C();

		/**
		 * The meta object literal for the '<em><b>I</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACID_MITIGATION__I = eINSTANCE.getACIDMitigation_I();

		/**
		 * The meta object literal for the '<em><b>D</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACID_MITIGATION__D = eINSTANCE.getACIDMitigation_D();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FI4FAAnalysisImpl <em>FI4FA Analysis</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FI4FAAnalysisImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FailurePropagationPackageImpl#getFI4FAAnalysis()
		 * @generated
		 */
		EClass FI4FA_ANALYSIS = eINSTANCE.getFI4FAAnalysis();

	}

} //FailurePropagationPackage
