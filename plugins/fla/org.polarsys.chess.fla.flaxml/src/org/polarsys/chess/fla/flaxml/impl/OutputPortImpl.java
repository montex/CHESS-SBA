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
package org.polarsys.chess.fla.flaxml.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polarsys.chess.fla.flaxml.Failure;
import org.polarsys.chess.fla.flaxml.FlaxmlPackage;
import org.polarsys.chess.fla.flaxml.OutputPort;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Output Port</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.chess.fla.flaxml.impl.OutputPortImpl#getOutputFailure <em>Output Failure</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OutputPortImpl extends NamedElementImpl implements OutputPort {
	/**
	 * The cached value of the '{@link #getOutputFailure() <em>Output Failure</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputFailure()
	 * @generated
	 * @ordered
	 */
	protected EList<Failure> outputFailure;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OutputPortImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FlaxmlPackage.Literals.OUTPUT_PORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Failure> getOutputFailure() {
		if (outputFailure == null) {
			outputFailure = new EObjectContainmentEList<Failure>(Failure.class, this, FlaxmlPackage.OUTPUT_PORT__OUTPUT_FAILURE);
		}
		return outputFailure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FlaxmlPackage.OUTPUT_PORT__OUTPUT_FAILURE:
				return ((InternalEList<?>)getOutputFailure()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FlaxmlPackage.OUTPUT_PORT__OUTPUT_FAILURE:
				return getOutputFailure();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FlaxmlPackage.OUTPUT_PORT__OUTPUT_FAILURE:
				getOutputFailure().clear();
				getOutputFailure().addAll((Collection<? extends Failure>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case FlaxmlPackage.OUTPUT_PORT__OUTPUT_FAILURE:
				getOutputFailure().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case FlaxmlPackage.OUTPUT_PORT__OUTPUT_FAILURE:
				return outputFailure != null && !outputFailure.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //OutputPortImpl
