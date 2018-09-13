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
package org.polarsys.chess.chessmlprofile.Dependability.MitigationMeans.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.uml2.uml.Connector;
import org.polarsys.chess.chessmlprofile.Dependability.MitigationMeans.MitigationMeansPackage;
import org.polarsys.chess.chessmlprofile.Dependability.MitigationMeans.TransmissionWithProtocol;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transmission With Protocol</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.MitigationMeans.impl.TransmissionWithProtocolImpl#getBase_Connector <em>Base Connector</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.MitigationMeans.impl.TransmissionWithProtocolImpl#getCRC <em>CRC</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.MitigationMeans.impl.TransmissionWithProtocolImpl#isUseSeqID <em>Use Seq ID</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransmissionWithProtocolImpl extends EObjectImpl implements TransmissionWithProtocol {
	/**
	 * The cached value of the '{@link #getBase_Connector() <em>Base Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Connector()
	 * @generated
	 * @ordered
	 */
	protected Connector base_Connector;

	/**
	 * The default value of the '{@link #getCRC() <em>CRC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCRC()
	 * @generated
	 * @ordered
	 */
	protected static final String CRC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCRC() <em>CRC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCRC()
	 * @generated
	 * @ordered
	 */
	protected String crc = CRC_EDEFAULT;

	/**
	 * The default value of the '{@link #isUseSeqID() <em>Use Seq ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUseSeqID()
	 * @generated
	 * @ordered
	 */
	protected static final boolean USE_SEQ_ID_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUseSeqID() <em>Use Seq ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUseSeqID()
	 * @generated
	 * @ordered
	 */
	protected boolean useSeqID = USE_SEQ_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransmissionWithProtocolImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MitigationMeansPackage.Literals.TRANSMISSION_WITH_PROTOCOL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Connector getBase_Connector() {
		if (base_Connector != null && base_Connector.eIsProxy()) {
			InternalEObject oldBase_Connector = (InternalEObject)base_Connector;
			base_Connector = (Connector)eResolveProxy(oldBase_Connector);
			if (base_Connector != oldBase_Connector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MitigationMeansPackage.TRANSMISSION_WITH_PROTOCOL__BASE_CONNECTOR, oldBase_Connector, base_Connector));
			}
		}
		return base_Connector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Connector basicGetBase_Connector() {
		return base_Connector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Connector(Connector newBase_Connector) {
		Connector oldBase_Connector = base_Connector;
		base_Connector = newBase_Connector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MitigationMeansPackage.TRANSMISSION_WITH_PROTOCOL__BASE_CONNECTOR, oldBase_Connector, base_Connector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCRC() {
		return crc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCRC(String newCRC) {
		String oldCRC = crc;
		crc = newCRC;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MitigationMeansPackage.TRANSMISSION_WITH_PROTOCOL__CRC, oldCRC, crc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUseSeqID() {
		return useSeqID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUseSeqID(boolean newUseSeqID) {
		boolean oldUseSeqID = useSeqID;
		useSeqID = newUseSeqID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MitigationMeansPackage.TRANSMISSION_WITH_PROTOCOL__USE_SEQ_ID, oldUseSeqID, useSeqID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MitigationMeansPackage.TRANSMISSION_WITH_PROTOCOL__BASE_CONNECTOR:
				if (resolve) return getBase_Connector();
				return basicGetBase_Connector();
			case MitigationMeansPackage.TRANSMISSION_WITH_PROTOCOL__CRC:
				return getCRC();
			case MitigationMeansPackage.TRANSMISSION_WITH_PROTOCOL__USE_SEQ_ID:
				return isUseSeqID();
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
			case MitigationMeansPackage.TRANSMISSION_WITH_PROTOCOL__BASE_CONNECTOR:
				setBase_Connector((Connector)newValue);
				return;
			case MitigationMeansPackage.TRANSMISSION_WITH_PROTOCOL__CRC:
				setCRC((String)newValue);
				return;
			case MitigationMeansPackage.TRANSMISSION_WITH_PROTOCOL__USE_SEQ_ID:
				setUseSeqID((Boolean)newValue);
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
			case MitigationMeansPackage.TRANSMISSION_WITH_PROTOCOL__BASE_CONNECTOR:
				setBase_Connector((Connector)null);
				return;
			case MitigationMeansPackage.TRANSMISSION_WITH_PROTOCOL__CRC:
				setCRC(CRC_EDEFAULT);
				return;
			case MitigationMeansPackage.TRANSMISSION_WITH_PROTOCOL__USE_SEQ_ID:
				setUseSeqID(USE_SEQ_ID_EDEFAULT);
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
			case MitigationMeansPackage.TRANSMISSION_WITH_PROTOCOL__BASE_CONNECTOR:
				return base_Connector != null;
			case MitigationMeansPackage.TRANSMISSION_WITH_PROTOCOL__CRC:
				return CRC_EDEFAULT == null ? crc != null : !CRC_EDEFAULT.equals(crc);
			case MitigationMeansPackage.TRANSMISSION_WITH_PROTOCOL__USE_SEQ_ID:
				return useSeqID != USE_SEQ_ID_EDEFAULT;
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
		result.append(" (CRC: ");
		result.append(crc);
		result.append(", UseSeqID: ");
		result.append(useSeqID);
		result.append(')');
		return result.toString();
	}

} //TransmissionWithProtocolImpl
