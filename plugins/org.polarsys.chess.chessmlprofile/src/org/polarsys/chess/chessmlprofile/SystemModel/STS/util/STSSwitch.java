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
package org.polarsys.chess.chessmlprofile.SystemModel.STS.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.polarsys.chess.chessmlprofile.SystemModel.STS.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.STSPackage
 * @generated
 */
public class STSSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static STSPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public STSSwitch() {
		if (modelPackage == null) {
			modelPackage = STSPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case STSPackage.HUMAN: {
				Human human = (Human)theEObject;
				T result = caseHuman(human);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case STSPackage.ORGANIZATION: {
				Organization organization = (Organization)theEObject;
				T result = caseOrganization(organization);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case STSPackage.ORGANIZATION_UNIT: {
				OrganizationUnit organizationUnit = (OrganizationUnit)theEObject;
				T result = caseOrganizationUnit(organizationUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case STSPackage.TECHNOLOGICAL: {
				Technological technological = (Technological)theEObject;
				T result = caseTechnological(technological);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case STSPackage.TIME_PRESSURE: {
				TimePressure timePressure = (TimePressure)theEObject;
				T result = caseTimePressure(timePressure);
				if (result == null) result = caseOrganizationUnit(timePressure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case STSPackage.OU_MISSION_MANAGEMENT: {
				OUMissionManagement ouMissionManagement = (OUMissionManagement)theEObject;
				T result = caseOUMissionManagement(ouMissionManagement);
				if (result == null) result = caseOrganizationUnit(ouMissionManagement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case STSPackage.OU_RULES_REGULATION_MANAGEMENT: {
				OURulesRegulationManagement ouRulesRegulationManagement = (OURulesRegulationManagement)theEObject;
				T result = caseOURulesRegulationManagement(ouRulesRegulationManagement);
				if (result == null) result = caseOrganizationUnit(ouRulesRegulationManagement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case STSPackage.OU_CLIMATE_MANAGEMENT: {
				OUClimateManagement ouClimateManagement = (OUClimateManagement)theEObject;
				T result = caseOUClimateManagement(ouClimateManagement);
				if (result == null) result = caseOrganizationUnit(ouClimateManagement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case STSPackage.OU_OVERSIGHT_MANAGEMENT: {
				OUOversightManagement ouOversightManagement = (OUOversightManagement)theEObject;
				T result = caseOUOversightManagement(ouOversightManagement);
				if (result == null) result = caseOrganizationUnit(ouOversightManagement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case STSPackage.OU_PROCESS_MANAGEMENT: {
				OUProcessManagement ouProcessManagement = (OUProcessManagement)theEObject;
				T result = caseOUProcessManagement(ouProcessManagement);
				if (result == null) result = caseOrganizationUnit(ouProcessManagement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case STSPackage.OU_RESOURCE_MANAGEMENT: {
				OUResourceManagement ouResourceManagement = (OUResourceManagement)theEObject;
				T result = caseOUResourceManagement(ouResourceManagement);
				if (result == null) result = caseOrganizationUnit(ouResourceManagement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case STSPackage.HS_ATTENTION: {
				HSAttention hsAttention = (HSAttention)theEObject;
				T result = caseHSAttention(hsAttention);
				if (result == null) result = caseHumanSensorUnit(hsAttention);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case STSPackage.HUMAN_SENSOR_UNIT: {
				HumanSensorUnit humanSensorUnit = (HumanSensorUnit)theEObject;
				T result = caseHumanSensorUnit(humanSensorUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case STSPackage.HS_PERCEPTION: {
				HSPerception hsPerception = (HSPerception)theEObject;
				T result = caseHSPerception(hsPerception);
				if (result == null) result = caseHumanSensorUnit(hsPerception);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case STSPackage.HS_KNOWLEDGE_PERCEPTION: {
				HSKnowledgePerception hsKnowledgePerception = (HSKnowledgePerception)theEObject;
				T result = caseHSKnowledgePerception(hsKnowledgePerception);
				if (result == null) result = caseHumanSensorUnit(hsKnowledgePerception);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case STSPackage.HS_SENSORY: {
				HSSensory hsSensory = (HSSensory)theEObject;
				T result = caseHSSensory(hsSensory);
				if (result == null) result = caseHumanSensorUnit(hsSensory);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case STSPackage.HA_FEEDBACK: {
				HAFeedback haFeedback = (HAFeedback)theEObject;
				T result = caseHAFeedback(haFeedback);
				if (result == null) result = caseHumanActuatorUnit(haFeedback);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case STSPackage.HUMAN_ACTUATOR_UNIT: {
				HumanActuatorUnit humanActuatorUnit = (HumanActuatorUnit)theEObject;
				T result = caseHumanActuatorUnit(humanActuatorUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case STSPackage.HA_INTENT: {
				HAIntent haIntent = (HAIntent)theEObject;
				T result = caseHAIntent(haIntent);
				if (result == null) result = caseHumanActuatorUnit(haIntent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case STSPackage.HA_COMMUNICATION: {
				HACommunication haCommunication = (HACommunication)theEObject;
				T result = caseHACommunication(haCommunication);
				if (result == null) result = caseHumanActuatorUnit(haCommunication);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case STSPackage.HA_TIME_MANAGEMENT: {
				HATimeManagement haTimeManagement = (HATimeManagement)theEObject;
				T result = caseHATimeManagement(haTimeManagement);
				if (result == null) result = caseHumanActuatorUnit(haTimeManagement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case STSPackage.HA_SELECTION: {
				HASelection haSelection = (HASelection)theEObject;
				T result = caseHASelection(haSelection);
				if (result == null) result = caseHumanActuatorUnit(haSelection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case STSPackage.HA_RESPONSE: {
				HAResponse haResponse = (HAResponse)theEObject;
				T result = caseHAResponse(haResponse);
				if (result == null) result = caseHumanActuatorUnit(haResponse);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case STSPackage.HA_KNOWLEDGE_DECISION: {
				HAKnowledgeDecision haKnowledgeDecision = (HAKnowledgeDecision)theEObject;
				T result = caseHAKnowledgeDecision(haKnowledgeDecision);
				if (result == null) result = caseHumanActuatorUnit(haKnowledgeDecision);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Human</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Human</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHuman(Human object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Organization</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Organization</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrganization(Organization object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Organization Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Organization Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrganizationUnit(OrganizationUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Technological</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Technological</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTechnological(Technological object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Time Pressure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Time Pressure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTimePressure(TimePressure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OU Mission Management</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OU Mission Management</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOUMissionManagement(OUMissionManagement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OU Rules Regulation Management</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OU Rules Regulation Management</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOURulesRegulationManagement(OURulesRegulationManagement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OU Climate Management</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OU Climate Management</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOUClimateManagement(OUClimateManagement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OU Oversight Management</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OU Oversight Management</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOUOversightManagement(OUOversightManagement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OU Process Management</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OU Process Management</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOUProcessManagement(OUProcessManagement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OU Resource Management</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OU Resource Management</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOUResourceManagement(OUResourceManagement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>HS Attention</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>HS Attention</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHSAttention(HSAttention object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Human Sensor Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Human Sensor Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHumanSensorUnit(HumanSensorUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>HS Perception</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>HS Perception</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHSPerception(HSPerception object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>HS Knowledge Perception</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>HS Knowledge Perception</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHSKnowledgePerception(HSKnowledgePerception object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>HS Sensory</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>HS Sensory</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHSSensory(HSSensory object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>HA Feedback</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>HA Feedback</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHAFeedback(HAFeedback object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Human Actuator Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Human Actuator Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHumanActuatorUnit(HumanActuatorUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>HA Intent</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>HA Intent</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHAIntent(HAIntent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>HA Communication</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>HA Communication</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHACommunication(HACommunication object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>HA Time Management</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>HA Time Management</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHATimeManagement(HATimeManagement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>HA Selection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>HA Selection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHASelection(HASelection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>HA Response</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>HA Response</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHAResponse(HAResponse object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>HA Knowledge Decision</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>HA Knowledge Decision</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHAKnowledgeDecision(HAKnowledgeDecision object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //STSSwitch
