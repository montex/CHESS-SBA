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
import java.util.Collection;
import java.util.List;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.chess.fla.flamm.Port#getConnectedPorts <em>Connected Ports</em>}</li>
 *   <li>{@link org.polarsys.chess.fla.flamm.Port#getFailures <em>Failures</em>}</li>
 *   <li>{@link org.polarsys.chess.fla.flamm.Port#getNewFailures <em>New Failures</em>}</li>
 *   <li>{@link org.polarsys.chess.fla.flamm.Port#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.polarsys.chess.fla.flamm.Port#getIncomingConnections <em>Incoming Connections</em>}</li>
 *   <li>{@link org.polarsys.chess.fla.flamm.Port#getOutgoingConnections <em>Outgoing Connections</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.chess.fla.flamm.FlammPackage#getPort()
 * @model kind="class"
 * @generated
 */
public class Port extends NamedElement {
	/**
	 * The cached value of the '{@link #getConnectedPorts() <em>Connected Ports</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectedPorts()
	 * @generated
	 * @ordered
	 */
	protected EList<Port> connectedPorts;

	/**
	 * The cached value of the '{@link #getFailures() <em>Failures</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailures()
	 * @generated
	 * @ordered
	 */
	protected EList<Failure> failures;

	/**
	 * The cached value of the '{@link #getNewFailures() <em>New Failures</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewFailures()
	 * @generated
	 * @ordered
	 */
	protected EList<Failure> newFailures;

	/**
	 * The cached value of the '{@link #getOwner() <em>Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwner()
	 * @generated
	 * @ordered
	 */
	protected Component owner;

	/**
	 * The cached value of the '{@link #getIncomingConnections() <em>Incoming Connections</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomingConnections()
	 * @generated
	 * @ordered
	 */
	protected Connection incomingConnections;

	/**
	 * The cached value of the '{@link #getOutgoingConnections() <em>Outgoing Connections</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoingConnections()
	 * @generated
	 * @ordered
	 */
	protected Connection outgoingConnections;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port() {
		super();
	}

	public Port(String name, String id, Component owner) {
		super();
		setName(name);
		setId(id);
		setOwner(owner);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FlammPackage.Literals.PORT;
	}

	/**
	 * Returns the value of the '<em><b>Connected Ports</b></em>' reference list.
	 * The list contents are of type {@link org.polarsys.chess.fla.flamm.Port}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connected Ports</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connected Ports</em>' reference list.
	 * @see org.polarsys.chess.fla.flamm.FlammPackage#getPort_ConnectedPorts()
	 * @model
	 * @generated
	 */
	public List<Port> getConnectedPorts() {
		if (connectedPorts == null) {
			connectedPorts = new EObjectResolvingEList<Port>(Port.class, this, FlammPackage.PORT__CONNECTED_PORTS);
		}
		return connectedPorts;
	}

	/**
	 * Returns the value of the '<em><b>Failures</b></em>' containment reference list.
	 * The list contents are of type {@link org.polarsys.chess.fla.flamm.Failure}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Failures</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Failures</em>' containment reference list.
	 * @see org.polarsys.chess.fla.flamm.FlammPackage#getPort_Failures()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	public List<Failure> getFailures() {
		if (failures == null) {
			failures = new EObjectContainmentEList<Failure>(Failure.class, this, FlammPackage.PORT__FAILURES);
		}
		return failures;
	}

	/**
	 * Returns the value of the '<em><b>New Failures</b></em>' containment reference list.
	 * The list contents are of type {@link org.polarsys.chess.fla.flamm.Failure}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Failures</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Failures</em>' containment reference list.
	 * @see org.polarsys.chess.fla.flamm.FlammPackage#getPort_NewFailures()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	public List<Failure> getNewFailures() {
		if (newFailures == null) {
			newFailures = new EObjectContainmentEList<Failure>(Failure.class, this, FlammPackage.PORT__NEW_FAILURES);
		}
		return newFailures;
	}

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' reference.
	 * @see #setOwner(Component)
	 * @see org.polarsys.chess.fla.flamm.FlammPackage#getPort_Owner()
	 * @model required="true"
	 * @generated
	 */
	public Component getOwner() {
		if (owner != null && owner.eIsProxy()) {
			InternalEObject oldOwner = (InternalEObject)owner;
			owner = (Component)eResolveProxy(oldOwner);
			if (owner != oldOwner) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FlammPackage.PORT__OWNER, oldOwner, owner));
			}
		}
		return owner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component basicGetOwner() {
		return owner;
	}

	/**
	 * Sets the value of the '{@link org.polarsys.chess.fla.flamm.Port#getOwner <em>Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' reference.
	 * @see #getOwner()
	 * @generated
	 */
	public void setOwner(Component newOwner) {
		Component oldOwner = owner;
		owner = newOwner;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FlammPackage.PORT__OWNER, oldOwner, owner));
	}
	
	/**
	 * Returns the value of the '<em><b>Incoming Connections</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.polarsys.chess.fla.flamm.Connection#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Connections</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Connections</em>' reference.
	 * @see #setIncomingConnections(Connection)
	 * @see org.polarsys.chess.fla.flamm.FlammPackage#getPort_IncomingConnections()
	 * @see org.polarsys.chess.fla.flamm.Connection#getTo
	 * @model opposite="to" required="true"
	 * @generated
	 */
	public Connection getIncomingConnections() {
		if (incomingConnections != null && incomingConnections.eIsProxy()) {
			InternalEObject oldIncomingConnections = (InternalEObject)incomingConnections;
			incomingConnections = (Connection)eResolveProxy(oldIncomingConnections);
			if (incomingConnections != oldIncomingConnections) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FlammPackage.PORT__INCOMING_CONNECTIONS, oldIncomingConnections, incomingConnections));
			}
		}
		return incomingConnections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Connection basicGetIncomingConnections() {
		return incomingConnections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIncomingConnections(Connection newIncomingConnections, NotificationChain msgs) {
		Connection oldIncomingConnections = incomingConnections;
		incomingConnections = newIncomingConnections;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FlammPackage.PORT__INCOMING_CONNECTIONS, oldIncomingConnections, newIncomingConnections);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link org.polarsys.chess.fla.flamm.Port#getIncomingConnections <em>Incoming Connections</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Incoming Connections</em>' reference.
	 * @see #getIncomingConnections()
	 * @generated
	 */
	public void setIncomingConnections(Connection newIncomingConnections) {
		if (newIncomingConnections != incomingConnections) {
			NotificationChain msgs = null;
			if (incomingConnections != null)
				msgs = ((InternalEObject)incomingConnections).eInverseRemove(this, FlammPackage.CONNECTION__TO, Connection.class, msgs);
			if (newIncomingConnections != null)
				msgs = ((InternalEObject)newIncomingConnections).eInverseAdd(this, FlammPackage.CONNECTION__TO, Connection.class, msgs);
			msgs = basicSetIncomingConnections(newIncomingConnections, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FlammPackage.PORT__INCOMING_CONNECTIONS, newIncomingConnections, newIncomingConnections));
	}

	/**
	 * Returns the value of the '<em><b>Outgoing Connections</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.polarsys.chess.fla.flamm.Connection#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Connections</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Connections</em>' reference.
	 * @see #setOutgoingConnections(Connection)
	 * @see org.polarsys.chess.fla.flamm.FlammPackage#getPort_OutgoingConnections()
	 * @see org.polarsys.chess.fla.flamm.Connection#getFrom
	 * @model opposite="from" required="true"
	 * @generated
	 */
	public Connection getOutgoingConnections() {
		if (outgoingConnections != null && outgoingConnections.eIsProxy()) {
			InternalEObject oldOutgoingConnections = (InternalEObject)outgoingConnections;
			outgoingConnections = (Connection)eResolveProxy(oldOutgoingConnections);
			if (outgoingConnections != oldOutgoingConnections) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FlammPackage.PORT__OUTGOING_CONNECTIONS, oldOutgoingConnections, outgoingConnections));
			}
		}
		return outgoingConnections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Connection basicGetOutgoingConnections() {
		return outgoingConnections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutgoingConnections(Connection newOutgoingConnections, NotificationChain msgs) {
		Connection oldOutgoingConnections = outgoingConnections;
		outgoingConnections = newOutgoingConnections;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FlammPackage.PORT__OUTGOING_CONNECTIONS, oldOutgoingConnections, newOutgoingConnections);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link org.polarsys.chess.fla.flamm.Port#getOutgoingConnections <em>Outgoing Connections</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outgoing Connections</em>' reference.
	 * @see #getOutgoingConnections()
	 * @generated
	 */
	public void setOutgoingConnections(Connection newOutgoingConnections) {
		if (newOutgoingConnections != outgoingConnections) {
			NotificationChain msgs = null;
			if (outgoingConnections != null)
				msgs = ((InternalEObject)outgoingConnections).eInverseRemove(this, FlammPackage.CONNECTION__FROM, Connection.class, msgs);
			if (newOutgoingConnections != null)
				msgs = ((InternalEObject)newOutgoingConnections).eInverseAdd(this, FlammPackage.CONNECTION__FROM, Connection.class, msgs);
			msgs = basicSetOutgoingConnections(newOutgoingConnections, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FlammPackage.PORT__OUTGOING_CONNECTIONS, newOutgoingConnections, newOutgoingConnections));
	}

	public boolean hasNewFailures() {
		return !getNewFailures().isEmpty();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	public void propagateFailures() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * Marks all new failures as handled.
	 */
	public void clearNewFailures() {
		getFailures().addAll(getNewFailures());
		getNewFailures().clear();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void initialize() {
		this.getFailures().clear();
		this.getNewFailures().clear();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FlammPackage.PORT__INCOMING_CONNECTIONS:
				if (incomingConnections != null)
					msgs = ((InternalEObject)incomingConnections).eInverseRemove(this, FlammPackage.CONNECTION__TO, Connection.class, msgs);
				return basicSetIncomingConnections((Connection)otherEnd, msgs);
			case FlammPackage.PORT__OUTGOING_CONNECTIONS:
				if (outgoingConnections != null)
					msgs = ((InternalEObject)outgoingConnections).eInverseRemove(this, FlammPackage.CONNECTION__FROM, Connection.class, msgs);
				return basicSetOutgoingConnections((Connection)otherEnd, msgs);
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
			case FlammPackage.PORT__FAILURES:
				return ((InternalEList<?>)getFailures()).basicRemove(otherEnd, msgs);
			case FlammPackage.PORT__NEW_FAILURES:
				return ((InternalEList<?>)getNewFailures()).basicRemove(otherEnd, msgs);
			case FlammPackage.PORT__INCOMING_CONNECTIONS:
				return basicSetIncomingConnections(null, msgs);
			case FlammPackage.PORT__OUTGOING_CONNECTIONS:
				return basicSetOutgoingConnections(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * Add a new failure to this port.<br/>
	 * A copy of the failure will be created and added to handle EMF containment relationship.
	 * @param failure
	 * @return <code>true</code> if the failure was added to the set of new failures.
	 */
	public boolean addFailure(Failure failure) {
		if (Failure.doCollectionContainFailure(getFailures(), failure) || Failure.doCollectionContainFailure(getNewFailures(), failure)) {
			return false;
		}
		return getNewFailures().add(new Failure(failure));
	}
	
	/**
	 * Add a new failure to this port.<br/>
	 * A copy of the failure will be created and added to handle EMF containment relationship.
	 * @param failure
	 * @return <code>true</code> if the failure was added to the set of new failures.
	 */
	public boolean addFailure(Failure failure, Failure previousFailure) {
		if (Failure.doCollectionContainFailure(getFailures(), failure)) {
			Failure existingFailure = Failure.getFailureInCollection(getFailures(), failure);
			existingFailure.addPreviousFailure(previousFailure);
			return false;
		} else if (Failure.doCollectionContainFailure(getNewFailures(), failure)) {
			Failure existingFailure = Failure.getFailureInCollection(getNewFailures(), failure);
			existingFailure.addPreviousFailure(previousFailure);
			return false;
		}
		return getNewFailures().add(new Failure(failure, previousFailure));
	}
	
	/**
	 * Add a new failure to this port.<br/>
	 * A copy of the failure will be created and added to handle EMF containment relationship.
	 * @param failure
	 * @return <code>true</code> if the failure was added to the set of new failures.
	 */
	public boolean addFailure(Failure failure, Collection<Failure> previousFailures) {
		if (Failure.doCollectionContainFailure(getFailures(), failure)) {
			Failure existingFailure = Failure.getFailureInCollection(getFailures(), failure);
			existingFailure.addPreviousFailures(previousFailures);
			return false;
		} else if (Failure.doCollectionContainFailure(getNewFailures(), failure)) {
			Failure existingFailure = Failure.getFailureInCollection(getNewFailures(), failure);
			existingFailure.addPreviousFailures(previousFailures);
			return false;
		}
		return getNewFailures().add(new Failure(failure, previousFailures));
	}
	
	/**
	 * Add new failures to this port.<br/>
	 * All failures will be copied and added to handle EMF containment relationship.
	 * @param failure
	 * @return <code>true</code> if at least one of the failures was added to the set of new failures.
	 */
	public boolean addFailures(Collection<Failure> failures) {
		boolean hasFailureBeenAdded = false;
		for (Failure failure : failures) {
			if (this.addFailure(failure)) {
				hasFailureBeenAdded = true;
			}
		}
		return hasFailureBeenAdded;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FlammPackage.PORT__CONNECTED_PORTS:
				return getConnectedPorts();
			case FlammPackage.PORT__FAILURES:
				return getFailures();
			case FlammPackage.PORT__NEW_FAILURES:
				return getNewFailures();
			case FlammPackage.PORT__OWNER:
				if (resolve) return getOwner();
				return basicGetOwner();
			case FlammPackage.PORT__INCOMING_CONNECTIONS:
				if (resolve) return getIncomingConnections();
				return basicGetIncomingConnections();
			case FlammPackage.PORT__OUTGOING_CONNECTIONS:
				if (resolve) return getOutgoingConnections();
				return basicGetOutgoingConnections();
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
			case FlammPackage.PORT__CONNECTED_PORTS:
				getConnectedPorts().clear();
				getConnectedPorts().addAll((Collection<? extends Port>)newValue);
				return;
			case FlammPackage.PORT__FAILURES:
				getFailures().clear();
				getFailures().addAll((Collection<? extends Failure>)newValue);
				return;
			case FlammPackage.PORT__NEW_FAILURES:
				getNewFailures().clear();
				getNewFailures().addAll((Collection<? extends Failure>)newValue);
				return;
			case FlammPackage.PORT__OWNER:
				setOwner((Component)newValue);
				return;
			case FlammPackage.PORT__INCOMING_CONNECTIONS:
				setIncomingConnections((Connection)newValue);
				return;
			case FlammPackage.PORT__OUTGOING_CONNECTIONS:
				setOutgoingConnections((Connection)newValue);
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
			case FlammPackage.PORT__CONNECTED_PORTS:
				getConnectedPorts().clear();
				return;
			case FlammPackage.PORT__FAILURES:
				getFailures().clear();
				return;
			case FlammPackage.PORT__NEW_FAILURES:
				getNewFailures().clear();
				return;
			case FlammPackage.PORT__OWNER:
				setOwner((Component)null);
				return;
			case FlammPackage.PORT__INCOMING_CONNECTIONS:
				setIncomingConnections((Connection)null);
				return;
			case FlammPackage.PORT__OUTGOING_CONNECTIONS:
				setOutgoingConnections((Connection)null);
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
			case FlammPackage.PORT__CONNECTED_PORTS:
				return connectedPorts != null && !connectedPorts.isEmpty();
			case FlammPackage.PORT__FAILURES:
				return failures != null && !failures.isEmpty();
			case FlammPackage.PORT__NEW_FAILURES:
				return newFailures != null && !newFailures.isEmpty();
			case FlammPackage.PORT__OWNER:
				return owner != null;
			case FlammPackage.PORT__INCOMING_CONNECTIONS:
				return incomingConnections != null;
			case FlammPackage.PORT__OUTGOING_CONNECTIONS:
				return outgoingConnections != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case FlammPackage.PORT___PROPAGATE_FAILURES:
				propagateFailures();
				return null;
			case FlammPackage.PORT___INITIALIZE:
				initialize();
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} // Port
