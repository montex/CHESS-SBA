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
package org.polarsys.chess.chessmlprofile.Core.CHESSViews;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Analysis View</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.AnalysisView#getBase_Package <em>Base Package</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.AnalysisView#getRtanalysisview <em>Rtanalysisview</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.AnalysisView#getDepanalysisview <em>Depanalysisview</em>}</li>
 * </ul>
 *
 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.CHESSViewsPackage#getAnalysisView()
 * @model
 * @generated
 */
public interface AnalysisView extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Package</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Package</em>' reference.
	 * @see #setBase_Package(org.eclipse.uml2.uml.Package)
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.CHESSViewsPackage#getAnalysisView_Base_Package()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Package getBase_Package();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.AnalysisView#getBase_Package <em>Base Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Package</em>' reference.
	 * @see #getBase_Package()
	 * @generated
	 */
	void setBase_Package(org.eclipse.uml2.uml.Package value);

	/**
	 * Returns the value of the '<em><b>Rtanalysisview</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rtanalysisview</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rtanalysisview</em>' containment reference.
	 * @see #setRtanalysisview(RTAnalysisView)
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.CHESSViewsPackage#getAnalysisView_Rtanalysisview()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	RTAnalysisView getRtanalysisview();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.AnalysisView#getRtanalysisview <em>Rtanalysisview</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rtanalysisview</em>' containment reference.
	 * @see #getRtanalysisview()
	 * @generated
	 */
	void setRtanalysisview(RTAnalysisView value);

	/**
	 * Returns the value of the '<em><b>Depanalysisview</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Depanalysisview</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depanalysisview</em>' reference.
	 * @see #setDepanalysisview(DependabilityAnalysisView)
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.CHESSViewsPackage#getAnalysisView_Depanalysisview()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	DependabilityAnalysisView getDepanalysisview();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.AnalysisView#getDepanalysisview <em>Depanalysisview</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Depanalysisview</em>' reference.
	 * @see #getDepanalysisview()
	 * @generated
	 */
	void setDepanalysisview(DependabilityAnalysisView value);

} // AnalysisView
