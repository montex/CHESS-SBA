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
package org.polarsys.chess.chessmlprofile.SystemModel.STS;

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
 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.STSFactory
 * @model kind="package"
 * @generated
 */
public interface STSPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "STS";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://CHESS/SystemModel/STS";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "STS";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	STSPackage eINSTANCE = org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HumanImpl <em>Human</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HumanImpl
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getHuman()
	 * @generated
	 */
	int HUMAN = 0;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN__BASE_CLASS = 0;

	/**
	 * The number of structural features of the '<em>Human</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.OrganizationImpl <em>Organization</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.OrganizationImpl
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getOrganization()
	 * @generated
	 */
	int ORGANIZATION = 1;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION__BASE_CLASS = 0;

	/**
	 * The number of structural features of the '<em>Organization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.OrganizationUnitImpl <em>Organization Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.OrganizationUnitImpl
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getOrganizationUnit()
	 * @generated
	 */
	int ORGANIZATION_UNIT = 2;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_UNIT__BASE_CLASS = 0;

	/**
	 * The number of structural features of the '<em>Organization Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_UNIT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.TechnologicalImpl <em>Technological</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.TechnologicalImpl
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getTechnological()
	 * @generated
	 */
	int TECHNOLOGICAL = 3;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TECHNOLOGICAL__BASE_CLASS = 0;

	/**
	 * The number of structural features of the '<em>Technological</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TECHNOLOGICAL_FEATURE_COUNT = 1;


	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.TimePressureImpl <em>Time Pressure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.TimePressureImpl
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getTimePressure()
	 * @generated
	 */
	int TIME_PRESSURE = 4;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_PRESSURE__BASE_CLASS = ORGANIZATION_UNIT__BASE_CLASS;

	/**
	 * The number of structural features of the '<em>Time Pressure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_PRESSURE_FEATURE_COUNT = ORGANIZATION_UNIT_FEATURE_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.OUMissionManagementImpl <em>OU Mission Management</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.OUMissionManagementImpl
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getOUMissionManagement()
	 * @generated
	 */
	int OU_MISSION_MANAGEMENT = 5;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OU_MISSION_MANAGEMENT__BASE_CLASS = ORGANIZATION_UNIT__BASE_CLASS;

	/**
	 * The number of structural features of the '<em>OU Mission Management</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OU_MISSION_MANAGEMENT_FEATURE_COUNT = ORGANIZATION_UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.OURulesRegulationManagementImpl <em>OU Rules Regulation Management</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.OURulesRegulationManagementImpl
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getOURulesRegulationManagement()
	 * @generated
	 */
	int OU_RULES_REGULATION_MANAGEMENT = 6;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OU_RULES_REGULATION_MANAGEMENT__BASE_CLASS = ORGANIZATION_UNIT__BASE_CLASS;

	/**
	 * The number of structural features of the '<em>OU Rules Regulation Management</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OU_RULES_REGULATION_MANAGEMENT_FEATURE_COUNT = ORGANIZATION_UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.OUClimateManagementImpl <em>OU Climate Management</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.OUClimateManagementImpl
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getOUClimateManagement()
	 * @generated
	 */
	int OU_CLIMATE_MANAGEMENT = 7;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OU_CLIMATE_MANAGEMENT__BASE_CLASS = ORGANIZATION_UNIT__BASE_CLASS;

	/**
	 * The number of structural features of the '<em>OU Climate Management</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OU_CLIMATE_MANAGEMENT_FEATURE_COUNT = ORGANIZATION_UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.OUOversightManagementImpl <em>OU Oversight Management</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.OUOversightManagementImpl
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getOUOversightManagement()
	 * @generated
	 */
	int OU_OVERSIGHT_MANAGEMENT = 8;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OU_OVERSIGHT_MANAGEMENT__BASE_CLASS = ORGANIZATION_UNIT__BASE_CLASS;

	/**
	 * The number of structural features of the '<em>OU Oversight Management</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OU_OVERSIGHT_MANAGEMENT_FEATURE_COUNT = ORGANIZATION_UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.OUProcessManagementImpl <em>OU Process Management</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.OUProcessManagementImpl
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getOUProcessManagement()
	 * @generated
	 */
	int OU_PROCESS_MANAGEMENT = 9;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OU_PROCESS_MANAGEMENT__BASE_CLASS = ORGANIZATION_UNIT__BASE_CLASS;

	/**
	 * The number of structural features of the '<em>OU Process Management</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OU_PROCESS_MANAGEMENT_FEATURE_COUNT = ORGANIZATION_UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.OUResourceManagementImpl <em>OU Resource Management</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.OUResourceManagementImpl
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getOUResourceManagement()
	 * @generated
	 */
	int OU_RESOURCE_MANAGEMENT = 10;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OU_RESOURCE_MANAGEMENT__BASE_CLASS = ORGANIZATION_UNIT__BASE_CLASS;

	/**
	 * The number of structural features of the '<em>OU Resource Management</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OU_RESOURCE_MANAGEMENT_FEATURE_COUNT = ORGANIZATION_UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HumanSensorUnitImpl <em>Human Sensor Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HumanSensorUnitImpl
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getHumanSensorUnit()
	 * @generated
	 */
	int HUMAN_SENSOR_UNIT = 12;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_SENSOR_UNIT__BASE_CLASS = 0;

	/**
	 * The number of structural features of the '<em>Human Sensor Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_SENSOR_UNIT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HSAttentionImpl <em>HS Attention</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HSAttentionImpl
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getHSAttention()
	 * @generated
	 */
	int HS_ATTENTION = 11;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HS_ATTENTION__BASE_CLASS = HUMAN_SENSOR_UNIT__BASE_CLASS;

	/**
	 * The number of structural features of the '<em>HS Attention</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HS_ATTENTION_FEATURE_COUNT = HUMAN_SENSOR_UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HSPerceptionImpl <em>HS Perception</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HSPerceptionImpl
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getHSPerception()
	 * @generated
	 */
	int HS_PERCEPTION = 13;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HS_PERCEPTION__BASE_CLASS = HUMAN_SENSOR_UNIT__BASE_CLASS;

	/**
	 * The number of structural features of the '<em>HS Perception</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HS_PERCEPTION_FEATURE_COUNT = HUMAN_SENSOR_UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HSKnowledgePerceptionImpl <em>HS Knowledge Perception</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HSKnowledgePerceptionImpl
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getHSKnowledgePerception()
	 * @generated
	 */
	int HS_KNOWLEDGE_PERCEPTION = 14;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HS_KNOWLEDGE_PERCEPTION__BASE_CLASS = HUMAN_SENSOR_UNIT__BASE_CLASS;

	/**
	 * The number of structural features of the '<em>HS Knowledge Perception</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HS_KNOWLEDGE_PERCEPTION_FEATURE_COUNT = HUMAN_SENSOR_UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HSSensoryImpl <em>HS Sensory</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HSSensoryImpl
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getHSSensory()
	 * @generated
	 */
	int HS_SENSORY = 15;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HS_SENSORY__BASE_CLASS = HUMAN_SENSOR_UNIT__BASE_CLASS;

	/**
	 * The number of structural features of the '<em>HS Sensory</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HS_SENSORY_FEATURE_COUNT = HUMAN_SENSOR_UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HumanActuatorUnitImpl <em>Human Actuator Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HumanActuatorUnitImpl
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getHumanActuatorUnit()
	 * @generated
	 */
	int HUMAN_ACTUATOR_UNIT = 17;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_ACTUATOR_UNIT__BASE_CLASS = 0;

	/**
	 * The number of structural features of the '<em>Human Actuator Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_ACTUATOR_UNIT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HAFeedbackImpl <em>HA Feedback</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HAFeedbackImpl
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getHAFeedback()
	 * @generated
	 */
	int HA_FEEDBACK = 16;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HA_FEEDBACK__BASE_CLASS = HUMAN_ACTUATOR_UNIT__BASE_CLASS;

	/**
	 * The number of structural features of the '<em>HA Feedback</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HA_FEEDBACK_FEATURE_COUNT = HUMAN_ACTUATOR_UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HAIntentImpl <em>HA Intent</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HAIntentImpl
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getHAIntent()
	 * @generated
	 */
	int HA_INTENT = 18;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HA_INTENT__BASE_CLASS = HUMAN_ACTUATOR_UNIT__BASE_CLASS;

	/**
	 * The number of structural features of the '<em>HA Intent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HA_INTENT_FEATURE_COUNT = HUMAN_ACTUATOR_UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HACommunicationImpl <em>HA Communication</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HACommunicationImpl
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getHACommunication()
	 * @generated
	 */
	int HA_COMMUNICATION = 19;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HA_COMMUNICATION__BASE_CLASS = HUMAN_ACTUATOR_UNIT__BASE_CLASS;

	/**
	 * The number of structural features of the '<em>HA Communication</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HA_COMMUNICATION_FEATURE_COUNT = HUMAN_ACTUATOR_UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HATimeManagementImpl <em>HA Time Management</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HATimeManagementImpl
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getHATimeManagement()
	 * @generated
	 */
	int HA_TIME_MANAGEMENT = 20;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HA_TIME_MANAGEMENT__BASE_CLASS = HUMAN_ACTUATOR_UNIT__BASE_CLASS;

	/**
	 * The number of structural features of the '<em>HA Time Management</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HA_TIME_MANAGEMENT_FEATURE_COUNT = HUMAN_ACTUATOR_UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HASelectionImpl <em>HA Selection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HASelectionImpl
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getHASelection()
	 * @generated
	 */
	int HA_SELECTION = 21;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HA_SELECTION__BASE_CLASS = HUMAN_ACTUATOR_UNIT__BASE_CLASS;

	/**
	 * The number of structural features of the '<em>HA Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HA_SELECTION_FEATURE_COUNT = HUMAN_ACTUATOR_UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HAResponseImpl <em>HA Response</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HAResponseImpl
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getHAResponse()
	 * @generated
	 */
	int HA_RESPONSE = 22;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HA_RESPONSE__BASE_CLASS = HUMAN_ACTUATOR_UNIT__BASE_CLASS;

	/**
	 * The number of structural features of the '<em>HA Response</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HA_RESPONSE_FEATURE_COUNT = HUMAN_ACTUATOR_UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HAKnowledgeDecisionImpl <em>HA Knowledge Decision</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HAKnowledgeDecisionImpl
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getHAKnowledgeDecision()
	 * @generated
	 */
	int HA_KNOWLEDGE_DECISION = 23;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HA_KNOWLEDGE_DECISION__BASE_CLASS = HUMAN_ACTUATOR_UNIT__BASE_CLASS;

	/**
	 * The number of structural features of the '<em>HA Knowledge Decision</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HA_KNOWLEDGE_DECISION_FEATURE_COUNT = HUMAN_ACTUATOR_UNIT_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.Human <em>Human</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Human</em>'.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.Human
	 * @generated
	 */
	EClass getHuman();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.Human#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.Human#getBase_Class()
	 * @see #getHuman()
	 * @generated
	 */
	EReference getHuman_Base_Class();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.Organization <em>Organization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Organization</em>'.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.Organization
	 * @generated
	 */
	EClass getOrganization();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.Organization#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.Organization#getBase_Class()
	 * @see #getOrganization()
	 * @generated
	 */
	EReference getOrganization_Base_Class();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.OrganizationUnit <em>Organization Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Organization Unit</em>'.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.OrganizationUnit
	 * @generated
	 */
	EClass getOrganizationUnit();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.OrganizationUnit#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.OrganizationUnit#getBase_Class()
	 * @see #getOrganizationUnit()
	 * @generated
	 */
	EReference getOrganizationUnit_Base_Class();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.Technological <em>Technological</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Technological</em>'.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.Technological
	 * @generated
	 */
	EClass getTechnological();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.Technological#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.Technological#getBase_Class()
	 * @see #getTechnological()
	 * @generated
	 */
	EReference getTechnological_Base_Class();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.TimePressure <em>Time Pressure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Time Pressure</em>'.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.TimePressure
	 * @generated
	 */
	EClass getTimePressure();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.OUMissionManagement <em>OU Mission Management</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OU Mission Management</em>'.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.OUMissionManagement
	 * @generated
	 */
	EClass getOUMissionManagement();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.OURulesRegulationManagement <em>OU Rules Regulation Management</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OU Rules Regulation Management</em>'.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.OURulesRegulationManagement
	 * @generated
	 */
	EClass getOURulesRegulationManagement();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.OUClimateManagement <em>OU Climate Management</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OU Climate Management</em>'.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.OUClimateManagement
	 * @generated
	 */
	EClass getOUClimateManagement();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.OUOversightManagement <em>OU Oversight Management</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OU Oversight Management</em>'.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.OUOversightManagement
	 * @generated
	 */
	EClass getOUOversightManagement();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.OUProcessManagement <em>OU Process Management</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OU Process Management</em>'.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.OUProcessManagement
	 * @generated
	 */
	EClass getOUProcessManagement();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.OUResourceManagement <em>OU Resource Management</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OU Resource Management</em>'.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.OUResourceManagement
	 * @generated
	 */
	EClass getOUResourceManagement();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.HSAttention <em>HS Attention</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>HS Attention</em>'.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.HSAttention
	 * @generated
	 */
	EClass getHSAttention();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.HumanSensorUnit <em>Human Sensor Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Human Sensor Unit</em>'.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.HumanSensorUnit
	 * @generated
	 */
	EClass getHumanSensorUnit();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.HumanSensorUnit#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.HumanSensorUnit#getBase_Class()
	 * @see #getHumanSensorUnit()
	 * @generated
	 */
	EReference getHumanSensorUnit_Base_Class();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.HSPerception <em>HS Perception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>HS Perception</em>'.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.HSPerception
	 * @generated
	 */
	EClass getHSPerception();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.HSKnowledgePerception <em>HS Knowledge Perception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>HS Knowledge Perception</em>'.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.HSKnowledgePerception
	 * @generated
	 */
	EClass getHSKnowledgePerception();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.HSSensory <em>HS Sensory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>HS Sensory</em>'.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.HSSensory
	 * @generated
	 */
	EClass getHSSensory();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.HAFeedback <em>HA Feedback</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>HA Feedback</em>'.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.HAFeedback
	 * @generated
	 */
	EClass getHAFeedback();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.HumanActuatorUnit <em>Human Actuator Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Human Actuator Unit</em>'.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.HumanActuatorUnit
	 * @generated
	 */
	EClass getHumanActuatorUnit();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.HumanActuatorUnit#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.HumanActuatorUnit#getBase_Class()
	 * @see #getHumanActuatorUnit()
	 * @generated
	 */
	EReference getHumanActuatorUnit_Base_Class();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.HAIntent <em>HA Intent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>HA Intent</em>'.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.HAIntent
	 * @generated
	 */
	EClass getHAIntent();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.HACommunication <em>HA Communication</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>HA Communication</em>'.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.HACommunication
	 * @generated
	 */
	EClass getHACommunication();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.HATimeManagement <em>HA Time Management</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>HA Time Management</em>'.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.HATimeManagement
	 * @generated
	 */
	EClass getHATimeManagement();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.HASelection <em>HA Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>HA Selection</em>'.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.HASelection
	 * @generated
	 */
	EClass getHASelection();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.HAResponse <em>HA Response</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>HA Response</em>'.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.HAResponse
	 * @generated
	 */
	EClass getHAResponse();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.HAKnowledgeDecision <em>HA Knowledge Decision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>HA Knowledge Decision</em>'.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.HAKnowledgeDecision
	 * @generated
	 */
	EClass getHAKnowledgeDecision();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	STSFactory getSTSFactory();

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
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HumanImpl <em>Human</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HumanImpl
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getHuman()
		 * @generated
		 */
		EClass HUMAN = eINSTANCE.getHuman();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HUMAN__BASE_CLASS = eINSTANCE.getHuman_Base_Class();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.OrganizationImpl <em>Organization</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.OrganizationImpl
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getOrganization()
		 * @generated
		 */
		EClass ORGANIZATION = eINSTANCE.getOrganization();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ORGANIZATION__BASE_CLASS = eINSTANCE.getOrganization_Base_Class();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.OrganizationUnitImpl <em>Organization Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.OrganizationUnitImpl
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getOrganizationUnit()
		 * @generated
		 */
		EClass ORGANIZATION_UNIT = eINSTANCE.getOrganizationUnit();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ORGANIZATION_UNIT__BASE_CLASS = eINSTANCE.getOrganizationUnit_Base_Class();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.TechnologicalImpl <em>Technological</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.TechnologicalImpl
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getTechnological()
		 * @generated
		 */
		EClass TECHNOLOGICAL = eINSTANCE.getTechnological();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TECHNOLOGICAL__BASE_CLASS = eINSTANCE.getTechnological_Base_Class();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.TimePressureImpl <em>Time Pressure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.TimePressureImpl
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getTimePressure()
		 * @generated
		 */
		EClass TIME_PRESSURE = eINSTANCE.getTimePressure();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.OUMissionManagementImpl <em>OU Mission Management</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.OUMissionManagementImpl
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getOUMissionManagement()
		 * @generated
		 */
		EClass OU_MISSION_MANAGEMENT = eINSTANCE.getOUMissionManagement();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.OURulesRegulationManagementImpl <em>OU Rules Regulation Management</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.OURulesRegulationManagementImpl
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getOURulesRegulationManagement()
		 * @generated
		 */
		EClass OU_RULES_REGULATION_MANAGEMENT = eINSTANCE.getOURulesRegulationManagement();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.OUClimateManagementImpl <em>OU Climate Management</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.OUClimateManagementImpl
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getOUClimateManagement()
		 * @generated
		 */
		EClass OU_CLIMATE_MANAGEMENT = eINSTANCE.getOUClimateManagement();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.OUOversightManagementImpl <em>OU Oversight Management</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.OUOversightManagementImpl
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getOUOversightManagement()
		 * @generated
		 */
		EClass OU_OVERSIGHT_MANAGEMENT = eINSTANCE.getOUOversightManagement();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.OUProcessManagementImpl <em>OU Process Management</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.OUProcessManagementImpl
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getOUProcessManagement()
		 * @generated
		 */
		EClass OU_PROCESS_MANAGEMENT = eINSTANCE.getOUProcessManagement();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.OUResourceManagementImpl <em>OU Resource Management</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.OUResourceManagementImpl
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getOUResourceManagement()
		 * @generated
		 */
		EClass OU_RESOURCE_MANAGEMENT = eINSTANCE.getOUResourceManagement();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HSAttentionImpl <em>HS Attention</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HSAttentionImpl
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getHSAttention()
		 * @generated
		 */
		EClass HS_ATTENTION = eINSTANCE.getHSAttention();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HumanSensorUnitImpl <em>Human Sensor Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HumanSensorUnitImpl
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getHumanSensorUnit()
		 * @generated
		 */
		EClass HUMAN_SENSOR_UNIT = eINSTANCE.getHumanSensorUnit();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HUMAN_SENSOR_UNIT__BASE_CLASS = eINSTANCE.getHumanSensorUnit_Base_Class();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HSPerceptionImpl <em>HS Perception</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HSPerceptionImpl
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getHSPerception()
		 * @generated
		 */
		EClass HS_PERCEPTION = eINSTANCE.getHSPerception();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HSKnowledgePerceptionImpl <em>HS Knowledge Perception</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HSKnowledgePerceptionImpl
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getHSKnowledgePerception()
		 * @generated
		 */
		EClass HS_KNOWLEDGE_PERCEPTION = eINSTANCE.getHSKnowledgePerception();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HSSensoryImpl <em>HS Sensory</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HSSensoryImpl
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getHSSensory()
		 * @generated
		 */
		EClass HS_SENSORY = eINSTANCE.getHSSensory();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HAFeedbackImpl <em>HA Feedback</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HAFeedbackImpl
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getHAFeedback()
		 * @generated
		 */
		EClass HA_FEEDBACK = eINSTANCE.getHAFeedback();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HumanActuatorUnitImpl <em>Human Actuator Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HumanActuatorUnitImpl
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getHumanActuatorUnit()
		 * @generated
		 */
		EClass HUMAN_ACTUATOR_UNIT = eINSTANCE.getHumanActuatorUnit();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HUMAN_ACTUATOR_UNIT__BASE_CLASS = eINSTANCE.getHumanActuatorUnit_Base_Class();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HAIntentImpl <em>HA Intent</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HAIntentImpl
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getHAIntent()
		 * @generated
		 */
		EClass HA_INTENT = eINSTANCE.getHAIntent();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HACommunicationImpl <em>HA Communication</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HACommunicationImpl
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getHACommunication()
		 * @generated
		 */
		EClass HA_COMMUNICATION = eINSTANCE.getHACommunication();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HATimeManagementImpl <em>HA Time Management</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HATimeManagementImpl
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getHATimeManagement()
		 * @generated
		 */
		EClass HA_TIME_MANAGEMENT = eINSTANCE.getHATimeManagement();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HASelectionImpl <em>HA Selection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HASelectionImpl
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getHASelection()
		 * @generated
		 */
		EClass HA_SELECTION = eINSTANCE.getHASelection();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HAResponseImpl <em>HA Response</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HAResponseImpl
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getHAResponse()
		 * @generated
		 */
		EClass HA_RESPONSE = eINSTANCE.getHAResponse();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HAKnowledgeDecisionImpl <em>HA Knowledge Decision</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.HAKnowledgeDecisionImpl
		 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl#getHAKnowledgeDecision()
		 * @generated
		 */
		EClass HA_KNOWLEDGE_DECISION = eINSTANCE.getHAKnowledgeDecision();

	}

} //STSPackage
