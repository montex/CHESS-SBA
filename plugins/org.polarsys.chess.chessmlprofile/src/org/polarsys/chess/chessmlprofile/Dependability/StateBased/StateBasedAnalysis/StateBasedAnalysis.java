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
package org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaAnalysisContext;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.FailureMode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Based Analysis</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.StateBasedAnalysis#getMeasure <em>Measure</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.StateBasedAnalysis#getMeasureEvaluationResult <em>Measure Evaluation Result</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.StateBasedAnalysis#getEvalMethod <em>Eval Method</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.StateBasedAnalysis#getTargetFailureMode <em>Target Failure Mode</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.StateBasedAnalysis#getTargetDepComponent <em>Target Dep Component</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.StateBasedAnalysisPackage#getStateBasedAnalysis()
 * @model
 * @generated
 */
public interface StateBasedAnalysis extends GaAnalysisContext {
	/**
	 * Returns the value of the '<em><b>Measure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Measure</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Measure</em>' attribute.
	 * @see #setMeasure(String)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.StateBasedAnalysisPackage#getStateBasedAnalysis_Measure()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getMeasure();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.StateBasedAnalysis#getMeasure <em>Measure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Measure</em>' attribute.
	 * @see #getMeasure()
	 * @generated
	 */
	void setMeasure(String value);

	/**
	 * Returns the value of the '<em><b>Measure Evaluation Result</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Measure Evaluation Result</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Measure Evaluation Result</em>' attribute.
	 * @see #setMeasureEvaluationResult(String)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.StateBasedAnalysisPackage#getStateBasedAnalysis_MeasureEvaluationResult()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getMeasureEvaluationResult();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.StateBasedAnalysis#getMeasureEvaluationResult <em>Measure Evaluation Result</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Measure Evaluation Result</em>' attribute.
	 * @see #getMeasureEvaluationResult()
	 * @generated
	 */
	void setMeasureEvaluationResult(String value);

	/**
	 * Returns the value of the '<em><b>Eval Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Eval Method</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Eval Method</em>' attribute.
	 * @see #setEvalMethod(String)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.StateBasedAnalysisPackage#getStateBasedAnalysis_EvalMethod()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getEvalMethod();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.StateBasedAnalysis#getEvalMethod <em>Eval Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Eval Method</em>' attribute.
	 * @see #getEvalMethod()
	 * @generated
	 */
	void setEvalMethod(String value);

	/**
	 * Returns the value of the '<em><b>Target Failure Mode</b></em>' reference list.
	 * The list contents are of type {@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.FailureMode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Failure Mode</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Failure Mode</em>' reference list.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.StateBasedAnalysisPackage#getStateBasedAnalysis_TargetFailureMode()
	 * @model ordered="false"
	 * @generated
	 */
	EList<FailureMode> getTargetFailureMode();

	/**
	 * Returns the value of the '<em><b>Target Dep Component</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.InstanceSpecification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Dep Component</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Dep Component</em>' reference list.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.StateBasedAnalysisPackage#getStateBasedAnalysis_TargetDepComponent()
	 * @model ordered="false"
	 * @generated
	 */
	EList<InstanceSpecification> getTargetDepComponent();

	/**
	 * Retrieves the first {@link org.eclipse.uml2.uml.InstanceSpecification} with the specified '<em><b>Name</b></em>' from the '<em><b>Target Dep Component</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.InstanceSpecification} to retrieve, or <code>null</code>.
	 * @return The first {@link org.eclipse.uml2.uml.InstanceSpecification} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getTargetDepComponent()
	 * @generated
	 */
	InstanceSpecification getTargetDepComponent(String name);

	/**
	 * Retrieves the first {@link org.eclipse.uml2.uml.InstanceSpecification} with the specified '<em><b>Name</b></em>' from the '<em><b>Target Dep Component</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.InstanceSpecification} to retrieve, or <code>null</code>.
	 * @param ignoreCase Whether to ignore case in {@link java.lang.String} comparisons.
	 * @param eClass The Ecore class of the {@link org.eclipse.uml2.uml.InstanceSpecification} to retrieve, or <code>null</code>.
	 * @return The first {@link org.eclipse.uml2.uml.InstanceSpecification} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getTargetDepComponent()
	 * @generated
	 */
	InstanceSpecification getTargetDepComponent(String name, boolean ignoreCase, EClass eClass);

} // StateBasedAnalysis
