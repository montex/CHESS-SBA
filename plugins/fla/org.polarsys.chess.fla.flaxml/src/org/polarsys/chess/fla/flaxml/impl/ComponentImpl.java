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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.polarsys.chess.fla.flaxml.Component;
import org.polarsys.chess.fla.flaxml.FlaxmlPackage;
import org.polarsys.chess.fla.flaxml.InputPorts;
import org.polarsys.chess.fla.flaxml.OutputPorts;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.chess.fla.flaxml.impl.ComponentImpl#getInputPorts <em>Input Ports</em>}</li>
 *   <li>{@link org.polarsys.chess.fla.flaxml.impl.ComponentImpl#getOutputPorts <em>Output Ports</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ComponentImpl extends NamedElementImpl implements Component {
	/**
	 * The cached value of the '{@link #getInputPorts() <em>Input Ports</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputPorts()
	 * @generated
	 * @ordered
	 */
	protected InputPorts inputPorts;

	/**
	 * The cached value of the '{@link #getOutputPorts() <em>Output Ports</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputPorts()
	 * @generated
	 * @ordered
	 */
	protected OutputPorts outputPorts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FlaxmlPackage.Literals.COMPONENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputPorts getInputPorts() {
		return inputPorts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputPorts(InputPorts newInputPorts, NotificationChain msgs) {
		InputPorts oldInputPorts = inputPorts;
		inputPorts = newInputPorts;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FlaxmlPackage.COMPONENT__INPUT_PORTS, oldInputPorts, newInputPorts);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputPorts(InputPorts newInputPorts) {
		if (newInputPorts != inputPorts) {
			NotificationChain msgs = null;
			if (inputPorts != null)
				msgs = ((InternalEObject)inputPorts).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FlaxmlPackage.COMPONENT__INPUT_PORTS, null, msgs);
			if (newInputPorts != null)
				msgs = ((InternalEObject)newInputPorts).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FlaxmlPackage.COMPONENT__INPUT_PORTS, null, msgs);
			msgs = basicSetInputPorts(newInputPorts, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FlaxmlPackage.COMPONENT__INPUT_PORTS, newInputPorts, newInputPorts));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputPorts getOutputPorts() {
		return outputPorts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputPorts(OutputPorts newOutputPorts, NotificationChain msgs) {
		OutputPorts oldOutputPorts = outputPorts;
		outputPorts = newOutputPorts;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FlaxmlPackage.COMPONENT__OUTPUT_PORTS, oldOutputPorts, newOutputPorts);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputPorts(OutputPorts newOutputPorts) {
		if (newOutputPorts != outputPorts) {
			NotificationChain msgs = null;
			if (outputPorts != null)
				msgs = ((InternalEObject)outputPorts).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FlaxmlPackage.COMPONENT__OUTPUT_PORTS, null, msgs);
			if (newOutputPorts != null)
				msgs = ((InternalEObject)newOutputPorts).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FlaxmlPackage.COMPONENT__OUTPUT_PORTS, null, msgs);
			msgs = basicSetOutputPorts(newOutputPorts, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FlaxmlPackage.COMPONENT__OUTPUT_PORTS, newOutputPorts, newOutputPorts));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FlaxmlPackage.COMPONENT__INPUT_PORTS:
				return basicSetInputPorts(null, msgs);
			case FlaxmlPackage.COMPONENT__OUTPUT_PORTS:
				return basicSetOutputPorts(null, msgs);
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
			case FlaxmlPackage.COMPONENT__INPUT_PORTS:
				return getInputPorts();
			case FlaxmlPackage.COMPONENT__OUTPUT_PORTS:
				return getOutputPorts();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FlaxmlPackage.COMPONENT__INPUT_PORTS:
				setInputPorts((InputPorts)newValue);
				return;
			case FlaxmlPackage.COMPONENT__OUTPUT_PORTS:
				setOutputPorts((OutputPorts)newValue);
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
			case FlaxmlPackage.COMPONENT__INPUT_PORTS:
				setInputPorts((InputPorts)null);
				return;
			case FlaxmlPackage.COMPONENT__OUTPUT_PORTS:
				setOutputPorts((OutputPorts)null);
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
			case FlaxmlPackage.COMPONENT__INPUT_PORTS:
				return inputPorts != null;
			case FlaxmlPackage.COMPONENT__OUTPUT_PORTS:
				return outputPorts != null;
		}
		return super.eIsSet(featureID);
	}

} //ComponentImpl
