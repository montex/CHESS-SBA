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
package org.polarsys.chess.chessmlprofile.Core;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaAnalysisContext;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PSM Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Core.PSMPackage#getBase_Package <em>Base Package</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Core.PSMPackage#getAnalysisContext <em>Analysis Context</em>}</li>
 * </ul>
 *
 * @see org.polarsys.chess.chessmlprofile.Core.CorePackage#getPSMPackage()
 * @model
 * @generated
 */
public interface PSMPackage extends EObject {
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
	 * @see org.polarsys.chess.chessmlprofile.Core.CorePackage#getPSMPackage_Base_Package()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Package getBase_Package();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Core.PSMPackage#getBase_Package <em>Base Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Package</em>' reference.
	 * @see #getBase_Package()
	 * @generated
	 */
	void setBase_Package(org.eclipse.uml2.uml.Package value);

	/**
	 * Returns the value of the '<em><b>Analysis Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Analysis Context</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Analysis Context</em>' reference.
	 * @see #setAnalysisContext(SaAnalysisContext)
	 * @see org.polarsys.chess.chessmlprofile.Core.CorePackage#getPSMPackage_AnalysisContext()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	SaAnalysisContext getAnalysisContext();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Core.PSMPackage#getAnalysisContext <em>Analysis Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Analysis Context</em>' reference.
	 * @see #getAnalysisContext()
	 * @generated
	 */
	void setAnalysisContext(SaAnalysisContext value);

} // PSMPackage
