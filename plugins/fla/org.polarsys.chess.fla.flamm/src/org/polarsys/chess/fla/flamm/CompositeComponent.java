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

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polarsys.chess.fla.flamm.analysis.FlaSystem;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.chess.fla.flamm.CompositeComponent#getComponents <em>Components</em>}</li>
 *   <li>{@link org.polarsys.chess.fla.flamm.CompositeComponent#getConnections <em>Connections</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.chess.fla.flamm.FlammPackage#getCompositeComponent()
 * @model kind="class"
 * @generated
 */
public class CompositeComponent extends Component {
	/**
	 * The cached value of the '{@link #getComponents() <em>Components</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponents()
	 * @generated
	 * @ordered
	 */
	protected EList<Component> components;

	/**
	 * The cached value of the '{@link #getConnections() <em>Connections</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnections()
	 * @generated
	 * @ordered
	 */
	protected EList<Connection> connections;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeComponent() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FlammPackage.Literals.COMPOSITE_COMPONENT;
	}

	/**
	 * Returns the value of the '<em><b>Components</b></em>' containment reference list.
	 * The list contents are of type {@link org.polarsys.chess.fla.flamm.Component}.
	 * It is bidirectional and its opposite is '{@link org.polarsys.chess.fla.flamm.Component#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Components</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Components</em>' containment reference list.
	 * @see org.polarsys.chess.fla.flamm.FlammPackage#getCompositeComponent_Components()
	 * @see org.polarsys.chess.fla.flamm.Component#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	public List<Component> getComponents() {
		if (components == null) {
			components = new EObjectContainmentWithInverseEList<Component>(Component.class, this, FlammPackage.COMPOSITE_COMPONENT__COMPONENTS, FlammPackage.COMPONENT__PARENT);
		}
		return components;
	}
	
	/**
	 * Returns the value of the '<em><b>Connections</b></em>' containment reference list.
	 * The list contents are of type {@link org.polarsys.chess.fla.flamm.Connection}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connections</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connections</em>' containment reference list.
	 * @see org.polarsys.chess.fla.flamm.FlammPackage#getCompositeComponent_Connections()
	 * @model containment="true"
	 * @generated
	 */
	public List<Connection> getConnections() {
		if (connections == null) {
			connections = new EObjectContainmentEList<Connection>(Connection.class, this, FlammPackage.COMPOSITE_COMPONENT__CONNECTIONS);
		}
		return connections;
	}

	@Override
	public void propagateFailures() {
		for (Port port : getInputPorts()) {
			if (port.hasNewFailures()) {
				propagateInputFailures(port);
			}
		}
		for (Port port : getOutputPorts()) {
			if (port.hasNewFailures()) {
				propagateOutputFailures(port);
			}
		}
	}
	
	private void propagateInputFailures(Port port) {
		for (Port connectedPort : port.getConnectedPorts()) {
			if (getComponents().contains(connectedPort.getOwner()) || getOutputPorts().contains(connectedPort)) {
				propagateNewFailures(port, connectedPort);
			}
		}
		port.clearNewFailures();
	}
	
	protected void propagateOutputFailures(Port port) {
		for (Port connectedPort : port.getConnectedPorts()) {
			if (!getComponents().contains(connectedPort.getOwner())) {
				propagateNewFailures(port, connectedPort);
			}
		}
		port.clearNewFailures();
	}
	
	public void propagateNewFailures(Port source, Port target) {
		for (Failure failure : source.getNewFailures()) {
			if (target.addFailure(failure, failure)) {
				FlaSystem.addUpdatedComponent(target.getOwner());
			}
		}
	}
	
	@Override
	public void initialize(boolean initNoFailure) {
		super.initialize(initNoFailure);
		for (Component subComponent : getComponents()) {
			subComponent.initialize(initNoFailure);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FlammPackage.COMPOSITE_COMPONENT__COMPONENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getComponents()).basicAdd(otherEnd, msgs);
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
			case FlammPackage.COMPOSITE_COMPONENT__COMPONENTS:
				return ((InternalEList<?>)getComponents()).basicRemove(otherEnd, msgs);
			case FlammPackage.COMPOSITE_COMPONENT__CONNECTIONS:
				return ((InternalEList<?>)getConnections()).basicRemove(otherEnd, msgs);
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
			case FlammPackage.COMPOSITE_COMPONENT__COMPONENTS:
				return getComponents();
			case FlammPackage.COMPOSITE_COMPONENT__CONNECTIONS:
				return getConnections();
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
			case FlammPackage.COMPOSITE_COMPONENT__COMPONENTS:
				getComponents().clear();
				getComponents().addAll((Collection<? extends Component>)newValue);
				return;
			case FlammPackage.COMPOSITE_COMPONENT__CONNECTIONS:
				getConnections().clear();
				getConnections().addAll((Collection<? extends Connection>)newValue);
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
			case FlammPackage.COMPOSITE_COMPONENT__COMPONENTS:
				getComponents().clear();
				return;
			case FlammPackage.COMPOSITE_COMPONENT__CONNECTIONS:
				getConnections().clear();
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
			case FlammPackage.COMPOSITE_COMPONENT__COMPONENTS:
				return components != null && !components.isEmpty();
			case FlammPackage.COMPOSITE_COMPONENT__CONNECTIONS:
				return connections != null && !connections.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // CompositeComponent
