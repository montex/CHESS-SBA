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
package org.polarsys.chess.chessmlprofile.Core;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Model;
import org.polarsys.chess.chessmlprofile.Core.CHESSViews.AnalysisView;
import org.polarsys.chess.chessmlprofile.Core.CHESSViews.ComponentView;
import org.polarsys.chess.chessmlprofile.Core.CHESSViews.DeploymentView;
import org.polarsys.chess.chessmlprofile.Core.CHESSViews.RequirementView;
import org.polarsys.chess.chessmlprofile.Core.CHESSViews.SystemView;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CHESS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Core.CHESS#getBase_Model <em>Base Model</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Core.CHESS#getAnalysisView <em>Analysis View</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Core.CHESS#getDeploymentView <em>Deployment View</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Core.CHESS#getRequirementView <em>Requirement View</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Core.CHESS#getComponentView <em>Component View</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Core.CHESS#getSystemView <em>System View</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.chess.chessmlprofile.Core.CorePackage#getCHESS()
 * @model
 * @generated
 */
public interface CHESS extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Model</em>' reference.
	 * @see #setBase_Model(Model)
	 * @see org.polarsys.chess.chessmlprofile.Core.CorePackage#getCHESS_Base_Model()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Model getBase_Model();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Core.CHESS#getBase_Model <em>Base Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Model</em>' reference.
	 * @see #getBase_Model()
	 * @generated
	 */
	void setBase_Model(Model value);

	/**
	 * Returns the value of the '<em><b>Analysis View</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Analysis View</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Analysis View</em>' containment reference.
	 * @see #setAnalysisView(AnalysisView)
	 * @see org.polarsys.chess.chessmlprofile.Core.CorePackage#getCHESS_AnalysisView()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	AnalysisView getAnalysisView();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Core.CHESS#getAnalysisView <em>Analysis View</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Analysis View</em>' containment reference.
	 * @see #getAnalysisView()
	 * @generated
	 */
	void setAnalysisView(AnalysisView value);

	/**
	 * Returns the value of the '<em><b>Deployment View</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deployment View</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deployment View</em>' containment reference.
	 * @see #setDeploymentView(DeploymentView)
	 * @see org.polarsys.chess.chessmlprofile.Core.CorePackage#getCHESS_DeploymentView()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	DeploymentView getDeploymentView();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Core.CHESS#getDeploymentView <em>Deployment View</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deployment View</em>' containment reference.
	 * @see #getDeploymentView()
	 * @generated
	 */
	void setDeploymentView(DeploymentView value);

	/**
	 * Returns the value of the '<em><b>Requirement View</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requirement View</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requirement View</em>' containment reference.
	 * @see #setRequirementView(RequirementView)
	 * @see org.polarsys.chess.chessmlprofile.Core.CorePackage#getCHESS_RequirementView()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	RequirementView getRequirementView();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Core.CHESS#getRequirementView <em>Requirement View</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requirement View</em>' containment reference.
	 * @see #getRequirementView()
	 * @generated
	 */
	void setRequirementView(RequirementView value);

	/**
	 * Returns the value of the '<em><b>Component View</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component View</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component View</em>' containment reference.
	 * @see #setComponentView(ComponentView)
	 * @see org.polarsys.chess.chessmlprofile.Core.CorePackage#getCHESS_ComponentView()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	ComponentView getComponentView();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Core.CHESS#getComponentView <em>Component View</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component View</em>' containment reference.
	 * @see #getComponentView()
	 * @generated
	 */
	void setComponentView(ComponentView value);

	/**
	 * Returns the value of the '<em><b>System View</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System View</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System View</em>' containment reference.
	 * @see #setSystemView(SystemView)
	 * @see org.polarsys.chess.chessmlprofile.Core.CorePackage#getCHESS_SystemView()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	SystemView getSystemView();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Core.CHESS#getSystemView <em>System View</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System View</em>' containment reference.
	 * @see #getSystemView()
	 * @generated
	 */
	void setSystemView(SystemView value);

} // CHESS
