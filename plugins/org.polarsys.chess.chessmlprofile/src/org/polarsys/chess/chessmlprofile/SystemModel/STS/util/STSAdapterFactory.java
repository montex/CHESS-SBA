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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.polarsys.chess.chessmlprofile.SystemModel.STS.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.STSPackage
 * @generated
 */
public class STSAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static STSPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public STSAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = STSPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected STSSwitch<Adapter> modelSwitch =
		new STSSwitch<Adapter>() {
			@Override
			public Adapter caseHuman(Human object) {
				return createHumanAdapter();
			}
			@Override
			public Adapter caseOrganization(Organization object) {
				return createOrganizationAdapter();
			}
			@Override
			public Adapter caseOrganizationUnit(OrganizationUnit object) {
				return createOrganizationUnitAdapter();
			}
			@Override
			public Adapter caseTechnological(Technological object) {
				return createTechnologicalAdapter();
			}
			@Override
			public Adapter caseTimePressure(TimePressure object) {
				return createTimePressureAdapter();
			}
			@Override
			public Adapter caseOUMissionManagement(OUMissionManagement object) {
				return createOUMissionManagementAdapter();
			}
			@Override
			public Adapter caseOURulesRegulationManagement(OURulesRegulationManagement object) {
				return createOURulesRegulationManagementAdapter();
			}
			@Override
			public Adapter caseOUClimateManagement(OUClimateManagement object) {
				return createOUClimateManagementAdapter();
			}
			@Override
			public Adapter caseOUOversightManagement(OUOversightManagement object) {
				return createOUOversightManagementAdapter();
			}
			@Override
			public Adapter caseOUProcessManagement(OUProcessManagement object) {
				return createOUProcessManagementAdapter();
			}
			@Override
			public Adapter caseOUResourceManagement(OUResourceManagement object) {
				return createOUResourceManagementAdapter();
			}
			@Override
			public Adapter caseHSAttention(HSAttention object) {
				return createHSAttentionAdapter();
			}
			@Override
			public Adapter caseHumanSensorUnit(HumanSensorUnit object) {
				return createHumanSensorUnitAdapter();
			}
			@Override
			public Adapter caseHSPerception(HSPerception object) {
				return createHSPerceptionAdapter();
			}
			@Override
			public Adapter caseHSKnowledgePerception(HSKnowledgePerception object) {
				return createHSKnowledgePerceptionAdapter();
			}
			@Override
			public Adapter caseHSSensory(HSSensory object) {
				return createHSSensoryAdapter();
			}
			@Override
			public Adapter caseHAFeedback(HAFeedback object) {
				return createHAFeedbackAdapter();
			}
			@Override
			public Adapter caseHumanActuatorUnit(HumanActuatorUnit object) {
				return createHumanActuatorUnitAdapter();
			}
			@Override
			public Adapter caseHAIntent(HAIntent object) {
				return createHAIntentAdapter();
			}
			@Override
			public Adapter caseHACommunication(HACommunication object) {
				return createHACommunicationAdapter();
			}
			@Override
			public Adapter caseHATimeManagement(HATimeManagement object) {
				return createHATimeManagementAdapter();
			}
			@Override
			public Adapter caseHASelection(HASelection object) {
				return createHASelectionAdapter();
			}
			@Override
			public Adapter caseHAResponse(HAResponse object) {
				return createHAResponseAdapter();
			}
			@Override
			public Adapter caseHAKnowledgeDecision(HAKnowledgeDecision object) {
				return createHAKnowledgeDecisionAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.Human <em>Human</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.Human
	 * @generated
	 */
	public Adapter createHumanAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.Organization <em>Organization</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.Organization
	 * @generated
	 */
	public Adapter createOrganizationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.OrganizationUnit <em>Organization Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.OrganizationUnit
	 * @generated
	 */
	public Adapter createOrganizationUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.Technological <em>Technological</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.Technological
	 * @generated
	 */
	public Adapter createTechnologicalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.TimePressure <em>Time Pressure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.TimePressure
	 * @generated
	 */
	public Adapter createTimePressureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.OUMissionManagement <em>OU Mission Management</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.OUMissionManagement
	 * @generated
	 */
	public Adapter createOUMissionManagementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.OURulesRegulationManagement <em>OU Rules Regulation Management</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.OURulesRegulationManagement
	 * @generated
	 */
	public Adapter createOURulesRegulationManagementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.OUClimateManagement <em>OU Climate Management</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.OUClimateManagement
	 * @generated
	 */
	public Adapter createOUClimateManagementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.OUOversightManagement <em>OU Oversight Management</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.OUOversightManagement
	 * @generated
	 */
	public Adapter createOUOversightManagementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.OUProcessManagement <em>OU Process Management</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.OUProcessManagement
	 * @generated
	 */
	public Adapter createOUProcessManagementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.OUResourceManagement <em>OU Resource Management</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.OUResourceManagement
	 * @generated
	 */
	public Adapter createOUResourceManagementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.HSAttention <em>HS Attention</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.HSAttention
	 * @generated
	 */
	public Adapter createHSAttentionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.HumanSensorUnit <em>Human Sensor Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.HumanSensorUnit
	 * @generated
	 */
	public Adapter createHumanSensorUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.HSPerception <em>HS Perception</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.HSPerception
	 * @generated
	 */
	public Adapter createHSPerceptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.HSKnowledgePerception <em>HS Knowledge Perception</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.HSKnowledgePerception
	 * @generated
	 */
	public Adapter createHSKnowledgePerceptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.HSSensory <em>HS Sensory</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.HSSensory
	 * @generated
	 */
	public Adapter createHSSensoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.HAFeedback <em>HA Feedback</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.HAFeedback
	 * @generated
	 */
	public Adapter createHAFeedbackAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.HumanActuatorUnit <em>Human Actuator Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.HumanActuatorUnit
	 * @generated
	 */
	public Adapter createHumanActuatorUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.HAIntent <em>HA Intent</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.HAIntent
	 * @generated
	 */
	public Adapter createHAIntentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.HACommunication <em>HA Communication</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.HACommunication
	 * @generated
	 */
	public Adapter createHACommunicationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.HATimeManagement <em>HA Time Management</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.HATimeManagement
	 * @generated
	 */
	public Adapter createHATimeManagementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.HASelection <em>HA Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.HASelection
	 * @generated
	 */
	public Adapter createHASelectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.HAResponse <em>HA Response</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.HAResponse
	 * @generated
	 */
	public Adapter createHAResponseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.SystemModel.STS.HAKnowledgeDecision <em>HA Knowledge Decision</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.HAKnowledgeDecision
	 * @generated
	 */
	public Adapter createHAKnowledgeDecisionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //STSAdapterFactory
