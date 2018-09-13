/*******************************************************************************
 *  * Copyright (c) 2015 University of Padova, Intecs
 *  *
 *  *    
 *  * All rights reserved. This program and the accompanying materials
 *  * are made available under the terms of the Eclipse Public License v1.0
 *  * which accompanies this distribution, and is available at
 *  * http://www.eclipse.org/legal/epl-v10.html
 *  *
 *******************************************************************************/
/**
 */
package org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.DependableComponentImpl;

import org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.StateBasedComponentsPackage;
import org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.StochasticFailureBehaviour;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stochastic Failure Behaviour</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.impl.StochasticFailureBehaviourImpl#getFailureDistribution <em>Failure Distribution</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.impl.StochasticFailureBehaviourImpl#getRepairDistribution <em>Repair Distribution</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.impl.StochasticFailureBehaviourImpl#getModes <em>Modes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StochasticFailureBehaviourImpl extends DependableComponentImpl implements StochasticFailureBehaviour {
	/**
	 * The default value of the '{@link #getFailureDistribution() <em>Failure Distribution</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailureDistribution()
	 * @generated
	 * @ordered
	 */
	protected static final String FAILURE_DISTRIBUTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFailureDistribution() <em>Failure Distribution</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailureDistribution()
	 * @generated
	 * @ordered
	 */
	protected String failureDistribution = FAILURE_DISTRIBUTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getRepairDistribution() <em>Repair Distribution</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepairDistribution()
	 * @generated
	 * @ordered
	 */
	protected static final String REPAIR_DISTRIBUTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRepairDistribution() <em>Repair Distribution</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepairDistribution()
	 * @generated
	 * @ordered
	 */
	protected String repairDistribution = REPAIR_DISTRIBUTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getModes() <em>Modes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModes()
	 * @generated
	 * @ordered
	 */
	protected static final String MODES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModes() <em>Modes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModes()
	 * @generated
	 * @ordered
	 */
	protected String modes = MODES_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StochasticFailureBehaviourImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StateBasedComponentsPackage.Literals.STOCHASTIC_FAILURE_BEHAVIOUR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFailureDistribution() {
		return failureDistribution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFailureDistribution(String newFailureDistribution) {
		String oldFailureDistribution = failureDistribution;
		failureDistribution = newFailureDistribution;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StateBasedComponentsPackage.STOCHASTIC_FAILURE_BEHAVIOUR__FAILURE_DISTRIBUTION, oldFailureDistribution, failureDistribution));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRepairDistribution() {
		return repairDistribution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepairDistribution(String newRepairDistribution) {
		String oldRepairDistribution = repairDistribution;
		repairDistribution = newRepairDistribution;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StateBasedComponentsPackage.STOCHASTIC_FAILURE_BEHAVIOUR__REPAIR_DISTRIBUTION, oldRepairDistribution, repairDistribution));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getModes() {
		return modes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModes(String newModes) {
		String oldModes = modes;
		modes = newModes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StateBasedComponentsPackage.STOCHASTIC_FAILURE_BEHAVIOUR__MODES, oldModes, modes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StateBasedComponentsPackage.STOCHASTIC_FAILURE_BEHAVIOUR__FAILURE_DISTRIBUTION:
				return getFailureDistribution();
			case StateBasedComponentsPackage.STOCHASTIC_FAILURE_BEHAVIOUR__REPAIR_DISTRIBUTION:
				return getRepairDistribution();
			case StateBasedComponentsPackage.STOCHASTIC_FAILURE_BEHAVIOUR__MODES:
				return getModes();
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
			case StateBasedComponentsPackage.STOCHASTIC_FAILURE_BEHAVIOUR__FAILURE_DISTRIBUTION:
				setFailureDistribution((String)newValue);
				return;
			case StateBasedComponentsPackage.STOCHASTIC_FAILURE_BEHAVIOUR__REPAIR_DISTRIBUTION:
				setRepairDistribution((String)newValue);
				return;
			case StateBasedComponentsPackage.STOCHASTIC_FAILURE_BEHAVIOUR__MODES:
				setModes((String)newValue);
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
			case StateBasedComponentsPackage.STOCHASTIC_FAILURE_BEHAVIOUR__FAILURE_DISTRIBUTION:
				setFailureDistribution(FAILURE_DISTRIBUTION_EDEFAULT);
				return;
			case StateBasedComponentsPackage.STOCHASTIC_FAILURE_BEHAVIOUR__REPAIR_DISTRIBUTION:
				setRepairDistribution(REPAIR_DISTRIBUTION_EDEFAULT);
				return;
			case StateBasedComponentsPackage.STOCHASTIC_FAILURE_BEHAVIOUR__MODES:
				setModes(MODES_EDEFAULT);
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
			case StateBasedComponentsPackage.STOCHASTIC_FAILURE_BEHAVIOUR__FAILURE_DISTRIBUTION:
				return FAILURE_DISTRIBUTION_EDEFAULT == null ? failureDistribution != null : !FAILURE_DISTRIBUTION_EDEFAULT.equals(failureDistribution);
			case StateBasedComponentsPackage.STOCHASTIC_FAILURE_BEHAVIOUR__REPAIR_DISTRIBUTION:
				return REPAIR_DISTRIBUTION_EDEFAULT == null ? repairDistribution != null : !REPAIR_DISTRIBUTION_EDEFAULT.equals(repairDistribution);
			case StateBasedComponentsPackage.STOCHASTIC_FAILURE_BEHAVIOUR__MODES:
				return MODES_EDEFAULT == null ? modes != null : !MODES_EDEFAULT.equals(modes);
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
		result.append(" (failureDistribution: ");
		result.append(failureDistribution);
		result.append(", repairDistribution: ");
		result.append(repairDistribution);
		result.append(", modes: ");
		result.append(modes);
		result.append(')');
		return result.toString();
	}

} //StochasticFailureBehaviourImpl
