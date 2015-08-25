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
package org.polarsys.chess.chessmlprofile.SystemModel.STS.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.polarsys.chess.chessmlprofile.SystemModel.STS.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class STSFactoryImpl extends EFactoryImpl implements STSFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static STSFactory init() {
		try {
			STSFactory theSTSFactory = (STSFactory)EPackage.Registry.INSTANCE.getEFactory(STSPackage.eNS_URI);
			if (theSTSFactory != null) {
				return theSTSFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new STSFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public STSFactoryImpl() {
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
			case STSPackage.HUMAN: return createHuman();
			case STSPackage.ORGANIZATION: return createOrganization();
			case STSPackage.TECHNOLOGICAL: return createTechnological();
			case STSPackage.TIME_PRESSURE: return createTimePressure();
			case STSPackage.OU_MISSION_MANAGEMENT: return createOUMissionManagement();
			case STSPackage.OU_RULES_REGULATION_MANAGEMENT: return createOURulesRegulationManagement();
			case STSPackage.OU_CLIMATE_MANAGEMENT: return createOUClimateManagement();
			case STSPackage.OU_OVERSIGHT_MANAGEMENT: return createOUOversightManagement();
			case STSPackage.OU_PROCESS_MANAGEMENT: return createOUProcessManagement();
			case STSPackage.OU_RESOURCE_MANAGEMENT: return createOUResourceManagement();
			case STSPackage.HS_ATTENTION: return createHSAttention();
			case STSPackage.HUMAN_SENSOR_UNIT: return createHumanSensorUnit();
			case STSPackage.HS_PERCEPTION: return createHSPerception();
			case STSPackage.HS_KNOWLEDGE_PERCEPTION: return createHSKnowledgePerception();
			case STSPackage.HS_SENSORY: return createHSSensory();
			case STSPackage.HA_FEEDBACK: return createHAFeedback();
			case STSPackage.HA_INTENT: return createHAIntent();
			case STSPackage.HA_COMMUNICATION: return createHACommunication();
			case STSPackage.HA_TIME_MANAGEMENT: return createHATimeManagement();
			case STSPackage.HA_SELECTION: return createHASelection();
			case STSPackage.HA_RESPONSE: return createHAResponse();
			case STSPackage.HA_KNOWLEDGE_DECISION: return createHAKnowledgeDecision();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Human createHuman() {
		HumanImpl human = new HumanImpl();
		return human;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Organization createOrganization() {
		OrganizationImpl organization = new OrganizationImpl();
		return organization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Technological createTechnological() {
		TechnologicalImpl technological = new TechnologicalImpl();
		return technological;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimePressure createTimePressure() {
		TimePressureImpl timePressure = new TimePressureImpl();
		return timePressure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OUMissionManagement createOUMissionManagement() {
		OUMissionManagementImpl ouMissionManagement = new OUMissionManagementImpl();
		return ouMissionManagement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OURulesRegulationManagement createOURulesRegulationManagement() {
		OURulesRegulationManagementImpl ouRulesRegulationManagement = new OURulesRegulationManagementImpl();
		return ouRulesRegulationManagement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OUClimateManagement createOUClimateManagement() {
		OUClimateManagementImpl ouClimateManagement = new OUClimateManagementImpl();
		return ouClimateManagement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OUOversightManagement createOUOversightManagement() {
		OUOversightManagementImpl ouOversightManagement = new OUOversightManagementImpl();
		return ouOversightManagement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OUProcessManagement createOUProcessManagement() {
		OUProcessManagementImpl ouProcessManagement = new OUProcessManagementImpl();
		return ouProcessManagement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OUResourceManagement createOUResourceManagement() {
		OUResourceManagementImpl ouResourceManagement = new OUResourceManagementImpl();
		return ouResourceManagement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HSAttention createHSAttention() {
		HSAttentionImpl hsAttention = new HSAttentionImpl();
		return hsAttention;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HumanSensorUnit createHumanSensorUnit() {
		HumanSensorUnitImpl humanSensorUnit = new HumanSensorUnitImpl();
		return humanSensorUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HSPerception createHSPerception() {
		HSPerceptionImpl hsPerception = new HSPerceptionImpl();
		return hsPerception;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HSKnowledgePerception createHSKnowledgePerception() {
		HSKnowledgePerceptionImpl hsKnowledgePerception = new HSKnowledgePerceptionImpl();
		return hsKnowledgePerception;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HSSensory createHSSensory() {
		HSSensoryImpl hsSensory = new HSSensoryImpl();
		return hsSensory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HAFeedback createHAFeedback() {
		HAFeedbackImpl haFeedback = new HAFeedbackImpl();
		return haFeedback;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HAIntent createHAIntent() {
		HAIntentImpl haIntent = new HAIntentImpl();
		return haIntent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HACommunication createHACommunication() {
		HACommunicationImpl haCommunication = new HACommunicationImpl();
		return haCommunication;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HATimeManagement createHATimeManagement() {
		HATimeManagementImpl haTimeManagement = new HATimeManagementImpl();
		return haTimeManagement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HASelection createHASelection() {
		HASelectionImpl haSelection = new HASelectionImpl();
		return haSelection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HAResponse createHAResponse() {
		HAResponseImpl haResponse = new HAResponseImpl();
		return haResponse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HAKnowledgeDecision createHAKnowledgeDecision() {
		HAKnowledgeDecisionImpl haKnowledgeDecision = new HAKnowledgeDecisionImpl();
		return haKnowledgeDecision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public STSPackage getSTSPackage() {
		return (STSPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static STSPackage getPackage() {
		return STSPackage.eINSTANCE;
	}

} //STSFactoryImpl
