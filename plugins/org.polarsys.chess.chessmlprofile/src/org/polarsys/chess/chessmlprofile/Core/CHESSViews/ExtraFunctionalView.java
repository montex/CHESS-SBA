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
 * A representation of the model object '<em><b>Extra Functional View</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.ExtraFunctionalView#getBase_Package <em>Base Package</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.ExtraFunctionalView#getTimingdataflowview <em>Timingdataflowview</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.CHESSViewsPackage#getExtraFunctionalView()
 * @model
 * @generated
 */
public interface ExtraFunctionalView extends EObject {
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
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.CHESSViewsPackage#getExtraFunctionalView_Base_Package()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Package getBase_Package();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.ExtraFunctionalView#getBase_Package <em>Base Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Package</em>' reference.
	 * @see #getBase_Package()
	 * @generated
	 */
	void setBase_Package(org.eclipse.uml2.uml.Package value);

	/**
	 * Returns the value of the '<em><b>Timingdataflowview</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Timingdataflowview</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timingdataflowview</em>' containment reference.
	 * @see #setTimingdataflowview(TimingDataFlowView)
	 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.CHESSViewsPackage#getExtraFunctionalView_Timingdataflowview()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	TimingDataFlowView getTimingdataflowview();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.ExtraFunctionalView#getTimingdataflowview <em>Timingdataflowview</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timingdataflowview</em>' containment reference.
	 * @see #getTimingdataflowview()
	 * @generated
	 */
	void setTimingdataflowview(TimingDataFlowView value);

} // ExtraFunctionalView
