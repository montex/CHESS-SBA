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
/**
 */
package org.polarsys.chess.chessmlprofile.ComponentModel;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Component;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Functional Partition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.ComponentModel.FunctionalPartition#getUtilization <em>Utilization</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.ComponentModel.FunctionalPartition#getBase_Component <em>Base Component</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.ComponentModel.FunctionalPartition#getMAF <em>MAF</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.ComponentModel.FunctionalPartition#getMIF <em>MIF</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.ComponentModel.FunctionalPartition#getSchedulingTable <em>Scheduling Table</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.chess.chessmlprofile.ComponentModel.ComponentModelPackage#getFunctionalPartition()
 * @model
 * @generated
 */
public interface FunctionalPartition extends EObject {
	/**
	 * Returns the value of the '<em><b>Utilization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Utilization</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Utilization</em>' attribute.
	 * @see #setUtilization(String)
	 * @see org.polarsys.chess.chessmlprofile.ComponentModel.ComponentModelPackage#getFunctionalPartition_Utilization()
	 * @model dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Real" ordered="false"
	 * @generated
	 */
	String getUtilization();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.ComponentModel.FunctionalPartition#getUtilization <em>Utilization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Utilization</em>' attribute.
	 * @see #getUtilization()
	 * @generated
	 */
	void setUtilization(String value);

	/**
	 * Returns the value of the '<em><b>Base Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Component</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Component</em>' reference.
	 * @see #setBase_Component(Component)
	 * @see org.polarsys.chess.chessmlprofile.ComponentModel.ComponentModelPackage#getFunctionalPartition_Base_Component()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Component getBase_Component();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.ComponentModel.FunctionalPartition#getBase_Component <em>Base Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Component</em>' reference.
	 * @see #getBase_Component()
	 * @generated
	 */
	void setBase_Component(Component value);

	/**
	 * Returns the value of the '<em><b>MAF</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>MAF</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>MAF</em>' attribute.
	 * @see #setMAF(String)
	 * @see org.polarsys.chess.chessmlprofile.ComponentModel.ComponentModelPackage#getFunctionalPartition_MAF()
	 * @model dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Integer" required="true" ordered="false"
	 * @generated
	 */
	String getMAF();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.ComponentModel.FunctionalPartition#getMAF <em>MAF</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MAF</em>' attribute.
	 * @see #getMAF()
	 * @generated
	 */
	void setMAF(String value);

	/**
	 * Returns the value of the '<em><b>MIF</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>MIF</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>MIF</em>' attribute.
	 * @see #setMIF(String)
	 * @see org.polarsys.chess.chessmlprofile.ComponentModel.ComponentModelPackage#getFunctionalPartition_MIF()
	 * @model dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Integer" required="true" ordered="false"
	 * @generated
	 */
	String getMIF();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.ComponentModel.FunctionalPartition#getMIF <em>MIF</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MIF</em>' attribute.
	 * @see #getMIF()
	 * @generated
	 */
	void setMIF(String value);

	/**
	 * Returns the value of the '<em><b>Scheduling Table</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scheduling Table</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scheduling Table</em>' attribute.
	 * @see #setSchedulingTable(String)
	 * @see org.polarsys.chess.chessmlprofile.ComponentModel.ComponentModelPackage#getFunctionalPartition_SchedulingTable()
	 * @model dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_String" required="true" ordered="false"
	 * @generated
	 */
	String getSchedulingTable();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.ComponentModel.FunctionalPartition#getSchedulingTable <em>Scheduling Table</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scheduling Table</em>' attribute.
	 * @see #getSchedulingTable()
	 * @generated
	 */
	void setSchedulingTable(String value);

} // FunctionalPartition
