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
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.polarsys.chess.fla.flaxml.Connection;
import org.polarsys.chess.fla.flaxml.FlaxmlPackage;
import org.polarsys.chess.fla.flaxml.FptcRules;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.chess.fla.flaxml.impl.ConnectionImpl#getSourceComponent <em>Source Component</em>}</li>
 *   <li>{@link org.polarsys.chess.fla.flaxml.impl.ConnectionImpl#getSourceId <em>Source Id</em>}</li>
 *   <li>{@link org.polarsys.chess.fla.flaxml.impl.ConnectionImpl#getTargetComponent <em>Target Component</em>}</li>
 *   <li>{@link org.polarsys.chess.fla.flaxml.impl.ConnectionImpl#getTargetId <em>Target Id</em>}</li>
 *   <li>{@link org.polarsys.chess.fla.flaxml.impl.ConnectionImpl#getRules <em>Rules</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConnectionImpl extends MinimalEObjectImpl.Container implements Connection {
	/**
	 * The default value of the '{@link #getSourceComponent() <em>Source Component</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceComponent()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_COMPONENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourceComponent() <em>Source Component</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceComponent()
	 * @generated
	 * @ordered
	 */
	protected String sourceComponent = SOURCE_COMPONENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getSourceId() <em>Source Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceId()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourceId() <em>Source Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceId()
	 * @generated
	 * @ordered
	 */
	protected String sourceId = SOURCE_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetComponent() <em>Target Component</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetComponent()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_COMPONENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetComponent() <em>Target Component</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetComponent()
	 * @generated
	 * @ordered
	 */
	protected String targetComponent = TARGET_COMPONENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetId() <em>Target Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetId()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetId() <em>Target Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetId()
	 * @generated
	 * @ordered
	 */
	protected String targetId = TARGET_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRules() <em>Rules</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRules()
	 * @generated
	 * @ordered
	 */
	protected FptcRules rules;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FlaxmlPackage.Literals.CONNECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSourceComponent() {
		return sourceComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceComponent(String newSourceComponent) {
		String oldSourceComponent = sourceComponent;
		sourceComponent = newSourceComponent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FlaxmlPackage.CONNECTION__SOURCE_COMPONENT, oldSourceComponent, sourceComponent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSourceId() {
		return sourceId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceId(String newSourceId) {
		String oldSourceId = sourceId;
		sourceId = newSourceId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FlaxmlPackage.CONNECTION__SOURCE_ID, oldSourceId, sourceId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetComponent() {
		return targetComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetComponent(String newTargetComponent) {
		String oldTargetComponent = targetComponent;
		targetComponent = newTargetComponent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FlaxmlPackage.CONNECTION__TARGET_COMPONENT, oldTargetComponent, targetComponent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetId() {
		return targetId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetId(String newTargetId) {
		String oldTargetId = targetId;
		targetId = newTargetId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FlaxmlPackage.CONNECTION__TARGET_ID, oldTargetId, targetId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FptcRules getRules() {
		return rules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRules(FptcRules newRules, NotificationChain msgs) {
		FptcRules oldRules = rules;
		rules = newRules;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FlaxmlPackage.CONNECTION__RULES, oldRules, newRules);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRules(FptcRules newRules) {
		if (newRules != rules) {
			NotificationChain msgs = null;
			if (rules != null)
				msgs = ((InternalEObject)rules).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FlaxmlPackage.CONNECTION__RULES, null, msgs);
			if (newRules != null)
				msgs = ((InternalEObject)newRules).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FlaxmlPackage.CONNECTION__RULES, null, msgs);
			msgs = basicSetRules(newRules, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FlaxmlPackage.CONNECTION__RULES, newRules, newRules));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FlaxmlPackage.CONNECTION__RULES:
				return basicSetRules(null, msgs);
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
			case FlaxmlPackage.CONNECTION__SOURCE_COMPONENT:
				return getSourceComponent();
			case FlaxmlPackage.CONNECTION__SOURCE_ID:
				return getSourceId();
			case FlaxmlPackage.CONNECTION__TARGET_COMPONENT:
				return getTargetComponent();
			case FlaxmlPackage.CONNECTION__TARGET_ID:
				return getTargetId();
			case FlaxmlPackage.CONNECTION__RULES:
				return getRules();
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
			case FlaxmlPackage.CONNECTION__SOURCE_COMPONENT:
				setSourceComponent((String)newValue);
				return;
			case FlaxmlPackage.CONNECTION__SOURCE_ID:
				setSourceId((String)newValue);
				return;
			case FlaxmlPackage.CONNECTION__TARGET_COMPONENT:
				setTargetComponent((String)newValue);
				return;
			case FlaxmlPackage.CONNECTION__TARGET_ID:
				setTargetId((String)newValue);
				return;
			case FlaxmlPackage.CONNECTION__RULES:
				setRules((FptcRules)newValue);
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
			case FlaxmlPackage.CONNECTION__SOURCE_COMPONENT:
				setSourceComponent(SOURCE_COMPONENT_EDEFAULT);
				return;
			case FlaxmlPackage.CONNECTION__SOURCE_ID:
				setSourceId(SOURCE_ID_EDEFAULT);
				return;
			case FlaxmlPackage.CONNECTION__TARGET_COMPONENT:
				setTargetComponent(TARGET_COMPONENT_EDEFAULT);
				return;
			case FlaxmlPackage.CONNECTION__TARGET_ID:
				setTargetId(TARGET_ID_EDEFAULT);
				return;
			case FlaxmlPackage.CONNECTION__RULES:
				setRules((FptcRules)null);
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
			case FlaxmlPackage.CONNECTION__SOURCE_COMPONENT:
				return SOURCE_COMPONENT_EDEFAULT == null ? sourceComponent != null : !SOURCE_COMPONENT_EDEFAULT.equals(sourceComponent);
			case FlaxmlPackage.CONNECTION__SOURCE_ID:
				return SOURCE_ID_EDEFAULT == null ? sourceId != null : !SOURCE_ID_EDEFAULT.equals(sourceId);
			case FlaxmlPackage.CONNECTION__TARGET_COMPONENT:
				return TARGET_COMPONENT_EDEFAULT == null ? targetComponent != null : !TARGET_COMPONENT_EDEFAULT.equals(targetComponent);
			case FlaxmlPackage.CONNECTION__TARGET_ID:
				return TARGET_ID_EDEFAULT == null ? targetId != null : !TARGET_ID_EDEFAULT.equals(targetId);
			case FlaxmlPackage.CONNECTION__RULES:
				return rules != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (sourceComponent: ");
		result.append(sourceComponent);
		result.append(", sourceId: ");
		result.append(sourceId);
		result.append(", targetComponent: ");
		result.append(targetComponent);
		result.append(", targetId: ");
		result.append(targetId);
		result.append(')');
		return result.toString();
	}

} //ConnectionImpl
