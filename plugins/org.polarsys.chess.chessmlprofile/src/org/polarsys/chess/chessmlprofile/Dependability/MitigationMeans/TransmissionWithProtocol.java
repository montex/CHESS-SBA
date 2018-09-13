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
package org.polarsys.chess.chessmlprofile.Dependability.MitigationMeans;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Connector;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transmission With Protocol</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.MitigationMeans.TransmissionWithProtocol#getBase_Connector <em>Base Connector</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.MitigationMeans.TransmissionWithProtocol#getCRC <em>CRC</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.MitigationMeans.TransmissionWithProtocol#isUseSeqID <em>Use Seq ID</em>}</li>
 * </ul>
 *
 * @see org.polarsys.chess.chessmlprofile.Dependability.MitigationMeans.MitigationMeansPackage#getTransmissionWithProtocol()
 * @model
 * @generated
 */
public interface TransmissionWithProtocol extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Connector</em>' reference.
	 * @see #setBase_Connector(Connector)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.MitigationMeans.MitigationMeansPackage#getTransmissionWithProtocol_Base_Connector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Connector getBase_Connector();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.MitigationMeans.TransmissionWithProtocol#getBase_Connector <em>Base Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Connector</em>' reference.
	 * @see #getBase_Connector()
	 * @generated
	 */
	void setBase_Connector(Connector value);

	/**
	 * Returns the value of the '<em><b>CRC</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>CRC</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CRC</em>' attribute.
	 * @see #setCRC(String)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.MitigationMeans.MitigationMeansPackage#getTransmissionWithProtocol_CRC()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getCRC();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.MitigationMeans.TransmissionWithProtocol#getCRC <em>CRC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CRC</em>' attribute.
	 * @see #getCRC()
	 * @generated
	 */
	void setCRC(String value);

	/**
	 * Returns the value of the '<em><b>Use Seq ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Seq ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Seq ID</em>' attribute.
	 * @see #setUseSeqID(boolean)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.MitigationMeans.MitigationMeansPackage#getTransmissionWithProtocol_UseSeqID()
	 * @model dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isUseSeqID();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.MitigationMeans.TransmissionWithProtocol#isUseSeqID <em>Use Seq ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use Seq ID</em>' attribute.
	 * @see #isUseSeqID()
	 * @generated
	 */
	void setUseSeqID(boolean value);

} // TransmissionWithProtocol
