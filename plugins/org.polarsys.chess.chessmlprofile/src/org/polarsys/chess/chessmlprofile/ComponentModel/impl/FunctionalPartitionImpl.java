/*****************************************************************************
 * Copyright (c) 2011, 2015 University of Padova, Intecs
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *
 *****************************************************************************/
package org.polarsys.chess.chessmlprofile.ComponentModel.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.uml2.uml.Component;

import org.polarsys.chess.chessmlprofile.ComponentModel.ComponentModelPackage;
import org.polarsys.chess.chessmlprofile.ComponentModel.FunctionalPartition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Functional Partition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.ComponentModel.impl.FunctionalPartitionImpl#getUtilization <em>Utilization</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.ComponentModel.impl.FunctionalPartitionImpl#getBase_Component <em>Base Component</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.ComponentModel.impl.FunctionalPartitionImpl#getMAF <em>MAF</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.ComponentModel.impl.FunctionalPartitionImpl#getMIF <em>MIF</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.ComponentModel.impl.FunctionalPartitionImpl#getSchedulingTable <em>Scheduling Table</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionalPartitionImpl extends EObjectImpl implements FunctionalPartition {
	/**
	 * The default value of the '{@link #getUtilization() <em>Utilization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUtilization()
	 * @generated
	 * @ordered
	 */
	protected static final String UTILIZATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUtilization() <em>Utilization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUtilization()
	 * @generated
	 * @ordered
	 */
	protected String utilization = UTILIZATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBase_Component() <em>Base Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Component()
	 * @generated
	 * @ordered
	 */
	protected Component base_Component;

	/**
	 * The default value of the '{@link #getMAF() <em>MAF</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMAF()
	 * @generated
	 * @ordered
	 */
	protected static final String MAF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMAF() <em>MAF</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMAF()
	 * @generated
	 * @ordered
	 */
	protected String maf = MAF_EDEFAULT;

	/**
	 * The default value of the '{@link #getMIF() <em>MIF</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMIF()
	 * @generated
	 * @ordered
	 */
	protected static final String MIF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMIF() <em>MIF</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMIF()
	 * @generated
	 * @ordered
	 */
	protected String mif = MIF_EDEFAULT;

	/**
	 * The default value of the '{@link #getSchedulingTable() <em>Scheduling Table</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchedulingTable()
	 * @generated
	 * @ordered
	 */
	protected static final String SCHEDULING_TABLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSchedulingTable() <em>Scheduling Table</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchedulingTable()
	 * @generated
	 * @ordered
	 */
	protected String schedulingTable = SCHEDULING_TABLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionalPartitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentModelPackage.Literals.FUNCTIONAL_PARTITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUtilization() {
		return utilization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUtilization(String newUtilization) {
		String oldUtilization = utilization;
		utilization = newUtilization;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentModelPackage.FUNCTIONAL_PARTITION__UTILIZATION, oldUtilization, utilization));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component getBase_Component() {
		if (base_Component != null && base_Component.eIsProxy()) {
			InternalEObject oldBase_Component = (InternalEObject)base_Component;
			base_Component = (Component)eResolveProxy(oldBase_Component);
			if (base_Component != oldBase_Component) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ComponentModelPackage.FUNCTIONAL_PARTITION__BASE_COMPONENT, oldBase_Component, base_Component));
			}
		}
		return base_Component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component basicGetBase_Component() {
		return base_Component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Component(Component newBase_Component) {
		Component oldBase_Component = base_Component;
		base_Component = newBase_Component;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentModelPackage.FUNCTIONAL_PARTITION__BASE_COMPONENT, oldBase_Component, base_Component));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMAF() {
		return maf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMAF(String newMAF) {
		String oldMAF = maf;
		maf = newMAF;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentModelPackage.FUNCTIONAL_PARTITION__MAF, oldMAF, maf));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMIF() {
		return mif;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMIF(String newMIF) {
		String oldMIF = mif;
		mif = newMIF;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentModelPackage.FUNCTIONAL_PARTITION__MIF, oldMIF, mif));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSchedulingTable() {
		return schedulingTable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSchedulingTable(String newSchedulingTable) {
		String oldSchedulingTable = schedulingTable;
		schedulingTable = newSchedulingTable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentModelPackage.FUNCTIONAL_PARTITION__SCHEDULING_TABLE, oldSchedulingTable, schedulingTable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComponentModelPackage.FUNCTIONAL_PARTITION__UTILIZATION:
				return getUtilization();
			case ComponentModelPackage.FUNCTIONAL_PARTITION__BASE_COMPONENT:
				if (resolve) return getBase_Component();
				return basicGetBase_Component();
			case ComponentModelPackage.FUNCTIONAL_PARTITION__MAF:
				return getMAF();
			case ComponentModelPackage.FUNCTIONAL_PARTITION__MIF:
				return getMIF();
			case ComponentModelPackage.FUNCTIONAL_PARTITION__SCHEDULING_TABLE:
				return getSchedulingTable();
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
			case ComponentModelPackage.FUNCTIONAL_PARTITION__UTILIZATION:
				setUtilization((String)newValue);
				return;
			case ComponentModelPackage.FUNCTIONAL_PARTITION__BASE_COMPONENT:
				setBase_Component((Component)newValue);
				return;
			case ComponentModelPackage.FUNCTIONAL_PARTITION__MAF:
				setMAF((String)newValue);
				return;
			case ComponentModelPackage.FUNCTIONAL_PARTITION__MIF:
				setMIF((String)newValue);
				return;
			case ComponentModelPackage.FUNCTIONAL_PARTITION__SCHEDULING_TABLE:
				setSchedulingTable((String)newValue);
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
			case ComponentModelPackage.FUNCTIONAL_PARTITION__UTILIZATION:
				setUtilization(UTILIZATION_EDEFAULT);
				return;
			case ComponentModelPackage.FUNCTIONAL_PARTITION__BASE_COMPONENT:
				setBase_Component((Component)null);
				return;
			case ComponentModelPackage.FUNCTIONAL_PARTITION__MAF:
				setMAF(MAF_EDEFAULT);
				return;
			case ComponentModelPackage.FUNCTIONAL_PARTITION__MIF:
				setMIF(MIF_EDEFAULT);
				return;
			case ComponentModelPackage.FUNCTIONAL_PARTITION__SCHEDULING_TABLE:
				setSchedulingTable(SCHEDULING_TABLE_EDEFAULT);
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
			case ComponentModelPackage.FUNCTIONAL_PARTITION__UTILIZATION:
				return UTILIZATION_EDEFAULT == null ? utilization != null : !UTILIZATION_EDEFAULT.equals(utilization);
			case ComponentModelPackage.FUNCTIONAL_PARTITION__BASE_COMPONENT:
				return base_Component != null;
			case ComponentModelPackage.FUNCTIONAL_PARTITION__MAF:
				return MAF_EDEFAULT == null ? maf != null : !MAF_EDEFAULT.equals(maf);
			case ComponentModelPackage.FUNCTIONAL_PARTITION__MIF:
				return MIF_EDEFAULT == null ? mif != null : !MIF_EDEFAULT.equals(mif);
			case ComponentModelPackage.FUNCTIONAL_PARTITION__SCHEDULING_TABLE:
				return SCHEDULING_TABLE_EDEFAULT == null ? schedulingTable != null : !SCHEDULING_TABLE_EDEFAULT.equals(schedulingTable);
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
		result.append(" (utilization: ");
		result.append(utilization);
		result.append(", MAF: ");
		result.append(maf);
		result.append(", MIF: ");
		result.append(mif);
		result.append(", SchedulingTable: ");
		result.append(schedulingTable);
		result.append(')');
		return result.toString();
	}

} //FunctionalPartitionImpl
