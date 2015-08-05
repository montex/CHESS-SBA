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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.polarsys.chess.chessmlprofile.SystemModel.STS.STSPackage
 * @generated
 */
public interface STSFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	STSFactory eINSTANCE = org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Human</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Human</em>'.
	 * @generated
	 */
	Human createHuman();

	/**
	 * Returns a new object of class '<em>Organization</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Organization</em>'.
	 * @generated
	 */
	Organization createOrganization();

	/**
	 * Returns a new object of class '<em>Technological</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Technological</em>'.
	 * @generated
	 */
	Technological createTechnological();

	/**
	 * Returns a new object of class '<em>Time Pressure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Time Pressure</em>'.
	 * @generated
	 */
	TimePressure createTimePressure();

	/**
	 * Returns a new object of class '<em>OU Mission Management</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OU Mission Management</em>'.
	 * @generated
	 */
	OUMissionManagement createOUMissionManagement();

	/**
	 * Returns a new object of class '<em>OU Rules Regulation Management</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OU Rules Regulation Management</em>'.
	 * @generated
	 */
	OURulesRegulationManagement createOURulesRegulationManagement();

	/**
	 * Returns a new object of class '<em>OU Climate Management</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OU Climate Management</em>'.
	 * @generated
	 */
	OUClimateManagement createOUClimateManagement();

	/**
	 * Returns a new object of class '<em>OU Oversight Management</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OU Oversight Management</em>'.
	 * @generated
	 */
	OUOversightManagement createOUOversightManagement();

	/**
	 * Returns a new object of class '<em>OU Process Management</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OU Process Management</em>'.
	 * @generated
	 */
	OUProcessManagement createOUProcessManagement();

	/**
	 * Returns a new object of class '<em>OU Resource Management</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OU Resource Management</em>'.
	 * @generated
	 */
	OUResourceManagement createOUResourceManagement();

	/**
	 * Returns a new object of class '<em>HS Attention</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>HS Attention</em>'.
	 * @generated
	 */
	HSAttention createHSAttention();

	/**
	 * Returns a new object of class '<em>Human Sensor Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Human Sensor Unit</em>'.
	 * @generated
	 */
	HumanSensorUnit createHumanSensorUnit();

	/**
	 * Returns a new object of class '<em>HS Perception</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>HS Perception</em>'.
	 * @generated
	 */
	HSPerception createHSPerception();

	/**
	 * Returns a new object of class '<em>HS Knowledge Perception</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>HS Knowledge Perception</em>'.
	 * @generated
	 */
	HSKnowledgePerception createHSKnowledgePerception();

	/**
	 * Returns a new object of class '<em>HS Sensory</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>HS Sensory</em>'.
	 * @generated
	 */
	HSSensory createHSSensory();

	/**
	 * Returns a new object of class '<em>HA Feedback</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>HA Feedback</em>'.
	 * @generated
	 */
	HAFeedback createHAFeedback();

	/**
	 * Returns a new object of class '<em>HA Intent</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>HA Intent</em>'.
	 * @generated
	 */
	HAIntent createHAIntent();

	/**
	 * Returns a new object of class '<em>HA Communication</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>HA Communication</em>'.
	 * @generated
	 */
	HACommunication createHACommunication();

	/**
	 * Returns a new object of class '<em>HA Time Management</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>HA Time Management</em>'.
	 * @generated
	 */
	HATimeManagement createHATimeManagement();

	/**
	 * Returns a new object of class '<em>HA Selection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>HA Selection</em>'.
	 * @generated
	 */
	HASelection createHASelection();

	/**
	 * Returns a new object of class '<em>HA Response</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>HA Response</em>'.
	 * @generated
	 */
	HAResponse createHAResponse();

	/**
	 * Returns a new object of class '<em>HA Knowledge Decision</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>HA Knowledge Decision</em>'.
	 * @generated
	 */
	HAKnowledgeDecision createHAKnowledgeDecision();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	STSPackage getSTSPackage();

} //STSFactory
