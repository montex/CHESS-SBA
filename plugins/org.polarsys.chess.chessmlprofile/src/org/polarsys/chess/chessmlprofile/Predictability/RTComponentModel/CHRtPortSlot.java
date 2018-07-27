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
package org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Slot;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CH Rt Port Slot</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * To be renamed with CHRtFeature, as extension of the MARTE RtFeature
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtPortSlot#getBase_Slot <em>Base Slot</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtPortSlot#getCH_RtSpecification <em>CH Rt Specification</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtPortSlot#getBase_InstanceSpecification <em>Base Instance Specification</em>}</li>
 * </ul>
 *
 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RTComponentModelPackage#getCHRtPortSlot()
 * @model
 * @generated
 */
public interface CHRtPortSlot extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Slot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Slot</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Slot</em>' reference.
	 * @see #setBase_Slot(Slot)
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RTComponentModelPackage#getCHRtPortSlot_Base_Slot()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Slot getBase_Slot();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtPortSlot#getBase_Slot <em>Base Slot</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Slot</em>' reference.
	 * @see #getBase_Slot()
	 * @generated
	 */
	void setBase_Slot(Slot value);

	/**
	 * Returns the value of the '<em><b>CH Rt Specification</b></em>' reference list.
	 * The list contents are of type {@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>CH Rt Specification</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CH Rt Specification</em>' reference list.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RTComponentModelPackage#getCHRtPortSlot_CH_RtSpecification()
	 * @model ordered="false"
	 * @generated
	 */
	EList<CHRtSpecification> getCH_RtSpecification();

	/**
	 * Returns the value of the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Instance Specification</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Instance Specification</em>' reference.
	 * @see #setBase_InstanceSpecification(InstanceSpecification)
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RTComponentModelPackage#getCHRtPortSlot_Base_InstanceSpecification()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	InstanceSpecification getBase_InstanceSpecification();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtPortSlot#getBase_InstanceSpecification <em>Base Instance Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Instance Specification</em>' reference.
	 * @see #getBase_InstanceSpecification()
	 * @generated
	 */
	void setBase_InstanceSpecification(InstanceSpecification value);

} // CHRtPortSlot
