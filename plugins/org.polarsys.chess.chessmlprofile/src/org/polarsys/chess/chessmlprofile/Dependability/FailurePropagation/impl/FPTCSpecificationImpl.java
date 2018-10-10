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
package org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Property;
import org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.FailureMode;
import org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FPTCSpecification;
import org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationPackage;
import org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.FailureType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>FPTC Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FPTCSpecificationImpl#getBase_Comment <em>Base Comment</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FPTCSpecificationImpl#getFailure <em>Failure</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FPTCSpecificationImpl#getPartWithPort <em>Part With Port</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FPTCSpecificationImpl#getFailureMode <em>Failure Mode</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FPTCSpecificationImpl extends EObjectImpl implements FPTCSpecification {
	/**
	 * The cached value of the '{@link #getBase_Comment() <em>Base Comment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Comment()
	 * @generated
	 * @ordered
	 */
	protected Comment base_Comment;

	/**
	 * The cached value of the '{@link #getFailure() <em>Failure</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailure()
	 * @generated
	 * @ordered
	 */
	protected EList<FailureType> failure;

	/**
	 * The cached value of the '{@link #getPartWithPort() <em>Part With Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartWithPort()
	 * @generated
	 * @ordered
	 */
	protected Property partWithPort;

	/**
	 * The cached value of the '{@link #getFailureMode() <em>Failure Mode</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailureMode()
	 * @generated
	 * @ordered
	 */
	protected EList<FailureMode> failureMode;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FPTCSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FailurePropagationPackage.Literals.FPTC_SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Comment getBase_Comment() {
		if (base_Comment != null && base_Comment.eIsProxy()) {
			InternalEObject oldBase_Comment = (InternalEObject)base_Comment;
			base_Comment = (Comment)eResolveProxy(oldBase_Comment);
			if (base_Comment != oldBase_Comment) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FailurePropagationPackage.FPTC_SPECIFICATION__BASE_COMMENT, oldBase_Comment, base_Comment));
			}
		}
		return base_Comment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Comment basicGetBase_Comment() {
		return base_Comment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Comment(Comment newBase_Comment) {
		Comment oldBase_Comment = base_Comment;
		base_Comment = newBase_Comment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FailurePropagationPackage.FPTC_SPECIFICATION__BASE_COMMENT, oldBase_Comment, base_Comment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FailureType> getFailure() {
		if (failure == null) {
			failure = new EDataTypeUniqueEList<FailureType>(FailureType.class, this, FailurePropagationPackage.FPTC_SPECIFICATION__FAILURE);
		}
		return failure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getPartWithPort() {
		if (partWithPort != null && partWithPort.eIsProxy()) {
			InternalEObject oldPartWithPort = (InternalEObject)partWithPort;
			partWithPort = (Property)eResolveProxy(oldPartWithPort);
			if (partWithPort != oldPartWithPort) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FailurePropagationPackage.FPTC_SPECIFICATION__PART_WITH_PORT, oldPartWithPort, partWithPort));
			}
		}
		return partWithPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetPartWithPort() {
		return partWithPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPartWithPort(Property newPartWithPort) {
		Property oldPartWithPort = partWithPort;
		partWithPort = newPartWithPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FailurePropagationPackage.FPTC_SPECIFICATION__PART_WITH_PORT, oldPartWithPort, partWithPort));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FailureMode> getFailureMode() {
		if (failureMode == null) {
			failureMode = new EObjectResolvingEList<FailureMode>(FailureMode.class, this, FailurePropagationPackage.FPTC_SPECIFICATION__FAILURE_MODE);
		}
		return failureMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FailurePropagationPackage.FPTC_SPECIFICATION__BASE_COMMENT:
				if (resolve) return getBase_Comment();
				return basicGetBase_Comment();
			case FailurePropagationPackage.FPTC_SPECIFICATION__FAILURE:
				return getFailure();
			case FailurePropagationPackage.FPTC_SPECIFICATION__PART_WITH_PORT:
				if (resolve) return getPartWithPort();
				return basicGetPartWithPort();
			case FailurePropagationPackage.FPTC_SPECIFICATION__FAILURE_MODE:
				return getFailureMode();
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
			case FailurePropagationPackage.FPTC_SPECIFICATION__BASE_COMMENT:
				setBase_Comment((Comment)newValue);
				return;
			case FailurePropagationPackage.FPTC_SPECIFICATION__FAILURE:
				getFailure().clear();
				getFailure().addAll((Collection<? extends FailureType>)newValue);
				return;
			case FailurePropagationPackage.FPTC_SPECIFICATION__PART_WITH_PORT:
				setPartWithPort((Property)newValue);
				return;
			case FailurePropagationPackage.FPTC_SPECIFICATION__FAILURE_MODE:
				getFailureMode().clear();
				getFailureMode().addAll((Collection<? extends FailureMode>)newValue);
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
			case FailurePropagationPackage.FPTC_SPECIFICATION__BASE_COMMENT:
				setBase_Comment((Comment)null);
				return;
			case FailurePropagationPackage.FPTC_SPECIFICATION__FAILURE:
				getFailure().clear();
				return;
			case FailurePropagationPackage.FPTC_SPECIFICATION__PART_WITH_PORT:
				setPartWithPort((Property)null);
				return;
			case FailurePropagationPackage.FPTC_SPECIFICATION__FAILURE_MODE:
				getFailureMode().clear();
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
			case FailurePropagationPackage.FPTC_SPECIFICATION__BASE_COMMENT:
				return base_Comment != null;
			case FailurePropagationPackage.FPTC_SPECIFICATION__FAILURE:
				return failure != null && !failure.isEmpty();
			case FailurePropagationPackage.FPTC_SPECIFICATION__PART_WITH_PORT:
				return partWithPort != null;
			case FailurePropagationPackage.FPTC_SPECIFICATION__FAILURE_MODE:
				return failureMode != null && !failureMode.isEmpty();
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
		result.append(" (failure: ");
		result.append(failure);
		result.append(')');
		return result.toString();
	}

} //FPTCSpecificationImpl
