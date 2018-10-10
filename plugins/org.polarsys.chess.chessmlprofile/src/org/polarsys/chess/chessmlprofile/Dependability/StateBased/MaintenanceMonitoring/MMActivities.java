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
package org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.Activity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MM Activities</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MMActivities#getBase_Activity <em>Base Activity</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MMActivities#getWhen <em>When</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MMActivities#getDuration <em>Duration</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MMActivities#getProbSuccess <em>Prob Success</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MMActivities#getOnCompletion <em>On Completion</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MMActivities#getOnSuccessfulCompletion <em>On Successful Completion</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MMActivities#getOnFailedCompletion <em>On Failed Completion</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MMActivities#getBase_Action <em>Base Action</em>}</li>
 * </ul>
 *
 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MaintenanceMonitoringPackage#getMMActivities()
 * @model
 * @generated
 */
public interface MMActivities extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Activity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Activity</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Activity</em>' reference.
	 * @see #setBase_Activity(Activity)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MaintenanceMonitoringPackage#getMMActivities_Base_Activity()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Activity getBase_Activity();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MMActivities#getBase_Activity <em>Base Activity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Activity</em>' reference.
	 * @see #getBase_Activity()
	 * @generated
	 */
	void setBase_Activity(Activity value);

	/**
	 * Returns the value of the '<em><b>When</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>When</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>When</em>' attribute.
	 * @see #setWhen(String)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MaintenanceMonitoringPackage#getMMActivities_When()
	 * @model dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	String getWhen();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MMActivities#getWhen <em>When</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>When</em>' attribute.
	 * @see #getWhen()
	 * @generated
	 */
	void setWhen(String value);

	/**
	 * Returns the value of the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Duration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Duration</em>' attribute.
	 * @see #setDuration(String)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MaintenanceMonitoringPackage#getMMActivities_Duration()
	 * @model dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Duration" required="true" ordered="false"
	 * @generated
	 */
	String getDuration();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MMActivities#getDuration <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Duration</em>' attribute.
	 * @see #getDuration()
	 * @generated
	 */
	void setDuration(String value);

	/**
	 * Returns the value of the '<em><b>Prob Success</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prob Success</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prob Success</em>' attribute.
	 * @see #setProbSuccess(String)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MaintenanceMonitoringPackage#getMMActivities_ProbSuccess()
	 * @model dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Real" required="true" ordered="false"
	 * @generated
	 */
	String getProbSuccess();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MMActivities#getProbSuccess <em>Prob Success</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prob Success</em>' attribute.
	 * @see #getProbSuccess()
	 * @generated
	 */
	void setProbSuccess(String value);

	/**
	 * Returns the value of the '<em><b>On Completion</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.Activity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On Completion</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Completion</em>' reference list.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MaintenanceMonitoringPackage#getMMActivities_OnCompletion()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Activity> getOnCompletion();

	/**
	 * Retrieves the first {@link org.eclipse.uml2.uml.Activity} with the specified '<em><b>Name</b></em>' from the '<em><b>On Completion</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.Activity} to retrieve, or <code>null</code>.
	 * @return The first {@link org.eclipse.uml2.uml.Activity} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getOnCompletion()
	 * @generated
	 */
	Activity getOnCompletion(String name);

	/**
	 * Retrieves the first {@link org.eclipse.uml2.uml.Activity} with the specified '<em><b>Name</b></em>' from the '<em><b>On Completion</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.Activity} to retrieve, or <code>null</code>.
	 * @param ignoreCase Whether to ignore case in {@link java.lang.String} comparisons.
	 * @return The first {@link org.eclipse.uml2.uml.Activity} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getOnCompletion()
	 * @generated
	 */
	Activity getOnCompletion(String name, boolean ignoreCase);

	/**
	 * Returns the value of the '<em><b>On Successful Completion</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.Activity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On Successful Completion</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Successful Completion</em>' reference list.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MaintenanceMonitoringPackage#getMMActivities_OnSuccessfulCompletion()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Activity> getOnSuccessfulCompletion();

	/**
	 * Retrieves the first {@link org.eclipse.uml2.uml.Activity} with the specified '<em><b>Name</b></em>' from the '<em><b>On Successful Completion</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.Activity} to retrieve, or <code>null</code>.
	 * @return The first {@link org.eclipse.uml2.uml.Activity} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getOnSuccessfulCompletion()
	 * @generated
	 */
	Activity getOnSuccessfulCompletion(String name);

	/**
	 * Retrieves the first {@link org.eclipse.uml2.uml.Activity} with the specified '<em><b>Name</b></em>' from the '<em><b>On Successful Completion</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.Activity} to retrieve, or <code>null</code>.
	 * @param ignoreCase Whether to ignore case in {@link java.lang.String} comparisons.
	 * @return The first {@link org.eclipse.uml2.uml.Activity} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getOnSuccessfulCompletion()
	 * @generated
	 */
	Activity getOnSuccessfulCompletion(String name, boolean ignoreCase);

	/**
	 * Returns the value of the '<em><b>On Failed Completion</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.Activity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On Failed Completion</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Failed Completion</em>' reference list.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MaintenanceMonitoringPackage#getMMActivities_OnFailedCompletion()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Activity> getOnFailedCompletion();

	/**
	 * Retrieves the first {@link org.eclipse.uml2.uml.Activity} with the specified '<em><b>Name</b></em>' from the '<em><b>On Failed Completion</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.Activity} to retrieve, or <code>null</code>.
	 * @return The first {@link org.eclipse.uml2.uml.Activity} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getOnFailedCompletion()
	 * @generated
	 */
	Activity getOnFailedCompletion(String name);

	/**
	 * Retrieves the first {@link org.eclipse.uml2.uml.Activity} with the specified '<em><b>Name</b></em>' from the '<em><b>On Failed Completion</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.Activity} to retrieve, or <code>null</code>.
	 * @param ignoreCase Whether to ignore case in {@link java.lang.String} comparisons.
	 * @return The first {@link org.eclipse.uml2.uml.Activity} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getOnFailedCompletion()
	 * @generated
	 */
	Activity getOnFailedCompletion(String name, boolean ignoreCase);

	/**
	 * Returns the value of the '<em><b>Base Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Action</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Action</em>' reference.
	 * @see #setBase_Action(Action)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MaintenanceMonitoringPackage#getMMActivities_Base_Action()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Action getBase_Action();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MMActivities#getBase_Action <em>Base Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Action</em>' reference.
	 * @see #getBase_Action()
	 * @generated
	 */
	void setBase_Action(Action value);

} // MMActivities
