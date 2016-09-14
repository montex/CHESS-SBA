/*******************************************************************************
 *                  CHESS core plugin
 *
 *               Copyright (C) 2011-2015
 *            Mälardalen University, Sweden
 *
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License
 *  v1.0 which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
/**
 */
package org.polarsys.chess.fla.flaxml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Failure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.chess.fla.flaxml.Failure#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.chess.fla.flaxml.FlaxmlPackage#getFailure()
 * @model extendedMetaData="name='failure' kind='empty'"
 * @generated
 */
public interface Failure extends EObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.polarsys.chess.fla.flaxml.FailureType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.polarsys.chess.fla.flaxml.FailureType
	 * @see #isSetType()
	 * @see #unsetType()
	 * @see #setType(FailureType)
	 * @see org.polarsys.chess.fla.flaxml.FlaxmlPackage#getFailure_Type()
	 * @model unsettable="true" required="true"
	 *        extendedMetaData="kind='attribute' name='type'"
	 * @generated
	 */
	FailureType getType();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.fla.flaxml.Failure#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.polarsys.chess.fla.flaxml.FailureType
	 * @see #isSetType()
	 * @see #unsetType()
	 * @see #getType()
	 * @generated
	 */
	void setType(FailureType value);

	/**
	 * Unsets the value of the '{@link org.polarsys.chess.fla.flaxml.Failure#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetType()
	 * @see #getType()
	 * @see #setType(FailureType)
	 * @generated
	 */
	void unsetType();

	/**
	 * Returns whether the value of the '{@link org.polarsys.chess.fla.flaxml.Failure#getType <em>Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Type</em>' attribute is set.
	 * @see #unsetType()
	 * @see #getType()
	 * @see #setType(FailureType)
	 * @generated
	 */
	boolean isSetType();

} // Failure
