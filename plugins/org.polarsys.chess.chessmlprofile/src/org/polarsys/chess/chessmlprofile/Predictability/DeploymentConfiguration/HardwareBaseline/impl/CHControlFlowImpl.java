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
package org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.uml2.uml.ControlFlow;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CHControlFlow;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.ComputeComplexity;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.HardwareBaselinePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CH Control Flow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.CHControlFlowImpl#getBase_ControlFlow <em>Base Control Flow</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.CHControlFlowImpl#getRep <em>Rep</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.CHControlFlowImpl#getProb <em>Prob</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.CHControlFlowImpl#getOrder <em>Order</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.CHControlFlowImpl#getCompComplex <em>Comp Complex</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CHControlFlowImpl extends EObjectImpl implements CHControlFlow {
	/**
	 * The cached value of the '{@link #getBase_ControlFlow() <em>Base Control Flow</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_ControlFlow()
	 * @generated
	 * @ordered
	 */
	protected ControlFlow base_ControlFlow;

	/**
	 * The default value of the '{@link #getRep() <em>Rep</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRep()
	 * @generated
	 * @ordered
	 */
	protected static final String REP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRep() <em>Rep</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRep()
	 * @generated
	 * @ordered
	 */
	protected String rep = REP_EDEFAULT;

	/**
	 * The default value of the '{@link #getProb() <em>Prob</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProb()
	 * @generated
	 * @ordered
	 */
	protected static final String PROB_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProb() <em>Prob</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProb()
	 * @generated
	 * @ordered
	 */
	protected String prob = PROB_EDEFAULT;

	/**
	 * The default value of the '{@link #getOrder() <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrder()
	 * @generated
	 * @ordered
	 */
	protected static final String ORDER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOrder() <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrder()
	 * @generated
	 * @ordered
	 */
	protected String order = ORDER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCompComplex() <em>Comp Complex</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompComplex()
	 * @generated
	 * @ordered
	 */
	protected EList<ComputeComplexity> compComplex;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CHControlFlowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HardwareBaselinePackage.Literals.CH_CONTROL_FLOW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControlFlow getBase_ControlFlow() {
		if (base_ControlFlow != null && base_ControlFlow.eIsProxy()) {
			InternalEObject oldBase_ControlFlow = (InternalEObject)base_ControlFlow;
			base_ControlFlow = (ControlFlow)eResolveProxy(oldBase_ControlFlow);
			if (base_ControlFlow != oldBase_ControlFlow) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, HardwareBaselinePackage.CH_CONTROL_FLOW__BASE_CONTROL_FLOW, oldBase_ControlFlow, base_ControlFlow));
			}
		}
		return base_ControlFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControlFlow basicGetBase_ControlFlow() {
		return base_ControlFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_ControlFlow(ControlFlow newBase_ControlFlow) {
		ControlFlow oldBase_ControlFlow = base_ControlFlow;
		base_ControlFlow = newBase_ControlFlow;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HardwareBaselinePackage.CH_CONTROL_FLOW__BASE_CONTROL_FLOW, oldBase_ControlFlow, base_ControlFlow));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRep() {
		return rep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRep(String newRep) {
		String oldRep = rep;
		rep = newRep;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HardwareBaselinePackage.CH_CONTROL_FLOW__REP, oldRep, rep));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProb() {
		return prob;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProb(String newProb) {
		String oldProb = prob;
		prob = newProb;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HardwareBaselinePackage.CH_CONTROL_FLOW__PROB, oldProb, prob));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOrder() {
		return order;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrder(String newOrder) {
		String oldOrder = order;
		order = newOrder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HardwareBaselinePackage.CH_CONTROL_FLOW__ORDER, oldOrder, order));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComputeComplexity> getCompComplex() {
		if (compComplex == null) {
			compComplex = new EObjectResolvingEList<ComputeComplexity>(ComputeComplexity.class, this, HardwareBaselinePackage.CH_CONTROL_FLOW__COMP_COMPLEX);
		}
		return compComplex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case HardwareBaselinePackage.CH_CONTROL_FLOW__BASE_CONTROL_FLOW:
				if (resolve) return getBase_ControlFlow();
				return basicGetBase_ControlFlow();
			case HardwareBaselinePackage.CH_CONTROL_FLOW__REP:
				return getRep();
			case HardwareBaselinePackage.CH_CONTROL_FLOW__PROB:
				return getProb();
			case HardwareBaselinePackage.CH_CONTROL_FLOW__ORDER:
				return getOrder();
			case HardwareBaselinePackage.CH_CONTROL_FLOW__COMP_COMPLEX:
				return getCompComplex();
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
			case HardwareBaselinePackage.CH_CONTROL_FLOW__BASE_CONTROL_FLOW:
				setBase_ControlFlow((ControlFlow)newValue);
				return;
			case HardwareBaselinePackage.CH_CONTROL_FLOW__REP:
				setRep((String)newValue);
				return;
			case HardwareBaselinePackage.CH_CONTROL_FLOW__PROB:
				setProb((String)newValue);
				return;
			case HardwareBaselinePackage.CH_CONTROL_FLOW__ORDER:
				setOrder((String)newValue);
				return;
			case HardwareBaselinePackage.CH_CONTROL_FLOW__COMP_COMPLEX:
				getCompComplex().clear();
				getCompComplex().addAll((Collection<? extends ComputeComplexity>)newValue);
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
			case HardwareBaselinePackage.CH_CONTROL_FLOW__BASE_CONTROL_FLOW:
				setBase_ControlFlow((ControlFlow)null);
				return;
			case HardwareBaselinePackage.CH_CONTROL_FLOW__REP:
				setRep(REP_EDEFAULT);
				return;
			case HardwareBaselinePackage.CH_CONTROL_FLOW__PROB:
				setProb(PROB_EDEFAULT);
				return;
			case HardwareBaselinePackage.CH_CONTROL_FLOW__ORDER:
				setOrder(ORDER_EDEFAULT);
				return;
			case HardwareBaselinePackage.CH_CONTROL_FLOW__COMP_COMPLEX:
				getCompComplex().clear();
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
			case HardwareBaselinePackage.CH_CONTROL_FLOW__BASE_CONTROL_FLOW:
				return base_ControlFlow != null;
			case HardwareBaselinePackage.CH_CONTROL_FLOW__REP:
				return REP_EDEFAULT == null ? rep != null : !REP_EDEFAULT.equals(rep);
			case HardwareBaselinePackage.CH_CONTROL_FLOW__PROB:
				return PROB_EDEFAULT == null ? prob != null : !PROB_EDEFAULT.equals(prob);
			case HardwareBaselinePackage.CH_CONTROL_FLOW__ORDER:
				return ORDER_EDEFAULT == null ? order != null : !ORDER_EDEFAULT.equals(order);
			case HardwareBaselinePackage.CH_CONTROL_FLOW__COMP_COMPLEX:
				return compComplex != null && !compComplex.isEmpty();
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
		result.append(" (rep: ");
		result.append(rep);
		result.append(", prob: ");
		result.append(prob);
		result.append(", order: ");
		result.append(order);
		result.append(')');
		return result.toString();
	}

} //CHControlFlowImpl
