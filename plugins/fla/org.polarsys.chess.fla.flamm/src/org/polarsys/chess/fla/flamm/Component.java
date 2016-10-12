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
package org.polarsys.chess.fla.flamm;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polarsys.chess.fla.flamm.analysis.FlaSystem;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.chess.fla.flamm.Component#getInputPorts <em>Input Ports</em>}</li>
 *   <li>{@link org.polarsys.chess.fla.flamm.Component#getOutputPorts <em>Output Ports</em>}</li>
 *   <li>{@link org.polarsys.chess.fla.flamm.Component#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.chess.fla.flamm.FlammPackage#getComponent()
 * @model kind="class" abstract="true"
 * @generated
 */
public abstract class Component extends NamedElement implements FlaBehaviour {
	/**
	 * The cached value of the '{@link #getInputPorts() <em>Input Ports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputPorts()
	 * @generated
	 * @ordered
	 */
	protected EList<Port> inputPorts;

	/**
	 * The cached value of the '{@link #getOutputPorts() <em>Output Ports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputPorts()
	 * @generated
	 * @ordered
	 */
	protected EList<Port> outputPorts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FlammPackage.Literals.COMPONENT;
	}

	/**
	 * Returns the value of the '<em><b>Input Ports</b></em>' containment reference list.
	 * The list contents are of type {@link org.polarsys.chess.fla.flamm.Port}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Ports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Ports</em>' containment reference list.
	 * @see org.polarsys.chess.fla.flamm.FlammPackage#getComponent_InputPorts()
	 * @model containment="true"
	 * @generated
	 */
	public List<Port> getInputPorts() {
		if (inputPorts == null) {
			inputPorts = new EObjectContainmentEList<Port>(Port.class, this, FlammPackage.COMPONENT__INPUT_PORTS);
		}
		return inputPorts;
	}

	/**
	 * Returns the value of the '<em><b>Output Ports</b></em>' containment reference list.
	 * The list contents are of type {@link org.polarsys.chess.fla.flamm.Port}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Ports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Ports</em>' containment reference list.
	 * @see org.polarsys.chess.fla.flamm.FlammPackage#getComponent_OutputPorts()
	 * @model containment="true"
	 * @generated
	 */
	public List<Port> getOutputPorts() {
		if (outputPorts == null) {
			outputPorts = new EObjectContainmentEList<Port>(Port.class, this, FlammPackage.COMPONENT__OUTPUT_PORTS);
		}
		return outputPorts;
	}

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.polarsys.chess.fla.flamm.CompositeComponent#getComponents <em>Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(CompositeComponent)
	 * @see org.polarsys.chess.fla.flamm.FlammPackage#getComponent_Parent()
	 * @see org.polarsys.chess.fla.flamm.CompositeComponent#getComponents
	 * @model opposite="components" transient="false"
	 * @generated
	 */
	public CompositeComponent getParent() {
		if (eContainerFeatureID() != FlammPackage.COMPONENT__PARENT) return null;
		return (CompositeComponent)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(CompositeComponent newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParent, FlammPackage.COMPONENT__PARENT, msgs);
		return msgs;
	}

	/**
	 * Sets the value of the '{@link org.polarsys.chess.fla.flamm.Component#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	public void setParent(CompositeComponent newParent) {
		if (newParent != eInternalContainer() || (eContainerFeatureID() != FlammPackage.COMPONENT__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, FlammPackage.COMPOSITE_COMPONENT__COMPONENTS, CompositeComponent.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FlammPackage.COMPONENT__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract void propagateFailures();

	/**
	 * <!-- begin-user-doc -->
	 * Initialize the Component, clear failures from ports etc.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void initialize(boolean initNoFailure) {
		if (this.getParent() == null) {
			for (Port port : getInputPorts()) {
				initializeRootComponentInputPort(port, initNoFailure);
			}
		} else {
			for (Port port : getInputPorts()) {
				initializePort(port, initNoFailure);
			}
		}
		for (Port port : getOutputPorts()) {
			initializePort(port, initNoFailure);
		}
		
		if (initNoFailure) {
			FlaSystem.addUpdatedComponent(this);
		}
	}
	
	protected void initializeRootComponentInputPort(Port port, boolean initNoFailure) {
		List<Failure> failures = new ArrayList<Failure>(port.getFailures());
		initializePort(port, initNoFailure);
		port.addFailures(failures);
	}

	protected void initializePort(Port port, boolean initNoFailure) {
		port.initialize();
		if (initNoFailure) {
			port.addFailure(Failure.createNoFailure());
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FlammPackage.COMPONENT__PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParent((CompositeComponent)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FlammPackage.COMPONENT__INPUT_PORTS:
				return ((InternalEList<?>)getInputPorts()).basicRemove(otherEnd, msgs);
			case FlammPackage.COMPONENT__OUTPUT_PORTS:
				return ((InternalEList<?>)getOutputPorts()).basicRemove(otherEnd, msgs);
			case FlammPackage.COMPONENT__PARENT:
				return basicSetParent(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case FlammPackage.COMPONENT__PARENT:
				return eInternalContainer().eInverseRemove(this, FlammPackage.COMPOSITE_COMPONENT__COMPONENTS, CompositeComponent.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FlammPackage.COMPONENT__INPUT_PORTS:
				return getInputPorts();
			case FlammPackage.COMPONENT__OUTPUT_PORTS:
				return getOutputPorts();
			case FlammPackage.COMPONENT__PARENT:
				return getParent();
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
			case FlammPackage.COMPONENT__INPUT_PORTS:
				getInputPorts().clear();
				getInputPorts().addAll((Collection<? extends Port>)newValue);
				return;
			case FlammPackage.COMPONENT__OUTPUT_PORTS:
				getOutputPorts().clear();
				getOutputPorts().addAll((Collection<? extends Port>)newValue);
				return;
			case FlammPackage.COMPONENT__PARENT:
				setParent((CompositeComponent)newValue);
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
			case FlammPackage.COMPONENT__INPUT_PORTS:
				getInputPorts().clear();
				return;
			case FlammPackage.COMPONENT__OUTPUT_PORTS:
				getOutputPorts().clear();
				return;
			case FlammPackage.COMPONENT__PARENT:
				setParent((CompositeComponent)null);
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
			case FlammPackage.COMPONENT__INPUT_PORTS:
				return inputPorts != null && !inputPorts.isEmpty();
			case FlammPackage.COMPONENT__OUTPUT_PORTS:
				return outputPorts != null && !outputPorts.isEmpty();
			case FlammPackage.COMPONENT__PARENT:
				return getParent() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == FlaBehaviour.class) {
			switch (baseOperationID) {
				case FlammPackage.FLA_BEHAVIOUR___PROPAGATE_FAILURES: return FlammPackage.COMPONENT___PROPAGATE_FAILURES;
				case FlammPackage.FLA_BEHAVIOUR___INITIALIZE__BOOLEAN: return FlammPackage.COMPONENT___INITIALIZE__BOOLEAN;
				default: return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case FlammPackage.COMPONENT___PROPAGATE_FAILURES:
				propagateFailures();
				return null;
			case FlammPackage.COMPONENT___INITIALIZE__BOOLEAN:
				initialize((Boolean)arguments.get(0));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} // Component
