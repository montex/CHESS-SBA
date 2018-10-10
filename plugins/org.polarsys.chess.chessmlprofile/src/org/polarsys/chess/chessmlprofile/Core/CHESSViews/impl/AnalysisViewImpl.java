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
package org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.polarsys.chess.chessmlprofile.Core.CHESSViews.AnalysisView;
import org.polarsys.chess.chessmlprofile.Core.CHESSViews.CHESSViewsPackage;
import org.polarsys.chess.chessmlprofile.Core.CHESSViews.DependabilityAnalysisView;
import org.polarsys.chess.chessmlprofile.Core.CHESSViews.RTAnalysisView;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Analysis View</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.AnalysisViewImpl#getBase_Package <em>Base Package</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.AnalysisViewImpl#getRtanalysisview <em>Rtanalysisview</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.AnalysisViewImpl#getDepanalysisview <em>Depanalysisview</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AnalysisViewImpl extends EObjectImpl implements AnalysisView {
	/**
	 * The cached value of the '{@link #getBase_Package() <em>Base Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Package()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Package base_Package;

	/**
	 * The cached value of the '{@link #getRtanalysisview() <em>Rtanalysisview</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRtanalysisview()
	 * @generated
	 * @ordered
	 */
	protected RTAnalysisView rtanalysisview;

	/**
	 * The cached value of the '{@link #getDepanalysisview() <em>Depanalysisview</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepanalysisview()
	 * @generated
	 * @ordered
	 */
	protected DependabilityAnalysisView depanalysisview;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnalysisViewImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CHESSViewsPackage.Literals.ANALYSIS_VIEW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Package getBase_Package() {
		if (base_Package != null && base_Package.eIsProxy()) {
			InternalEObject oldBase_Package = (InternalEObject)base_Package;
			base_Package = (org.eclipse.uml2.uml.Package)eResolveProxy(oldBase_Package);
			if (base_Package != oldBase_Package) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CHESSViewsPackage.ANALYSIS_VIEW__BASE_PACKAGE, oldBase_Package, base_Package));
			}
		}
		return base_Package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Package basicGetBase_Package() {
		return base_Package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Package(org.eclipse.uml2.uml.Package newBase_Package) {
		org.eclipse.uml2.uml.Package oldBase_Package = base_Package;
		base_Package = newBase_Package;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CHESSViewsPackage.ANALYSIS_VIEW__BASE_PACKAGE, oldBase_Package, base_Package));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RTAnalysisView getRtanalysisview() {
		return rtanalysisview;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRtanalysisview(RTAnalysisView newRtanalysisview, NotificationChain msgs) {
		RTAnalysisView oldRtanalysisview = rtanalysisview;
		rtanalysisview = newRtanalysisview;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CHESSViewsPackage.ANALYSIS_VIEW__RTANALYSISVIEW, oldRtanalysisview, newRtanalysisview);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRtanalysisview(RTAnalysisView newRtanalysisview) {
		if (newRtanalysisview != rtanalysisview) {
			NotificationChain msgs = null;
			if (rtanalysisview != null)
				msgs = ((InternalEObject)rtanalysisview).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CHESSViewsPackage.ANALYSIS_VIEW__RTANALYSISVIEW, null, msgs);
			if (newRtanalysisview != null)
				msgs = ((InternalEObject)newRtanalysisview).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CHESSViewsPackage.ANALYSIS_VIEW__RTANALYSISVIEW, null, msgs);
			msgs = basicSetRtanalysisview(newRtanalysisview, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CHESSViewsPackage.ANALYSIS_VIEW__RTANALYSISVIEW, newRtanalysisview, newRtanalysisview));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependabilityAnalysisView getDepanalysisview() {
		if (depanalysisview != null && depanalysisview.eIsProxy()) {
			InternalEObject oldDepanalysisview = (InternalEObject)depanalysisview;
			depanalysisview = (DependabilityAnalysisView)eResolveProxy(oldDepanalysisview);
			if (depanalysisview != oldDepanalysisview) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CHESSViewsPackage.ANALYSIS_VIEW__DEPANALYSISVIEW, oldDepanalysisview, depanalysisview));
			}
		}
		return depanalysisview;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependabilityAnalysisView basicGetDepanalysisview() {
		return depanalysisview;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDepanalysisview(DependabilityAnalysisView newDepanalysisview) {
		DependabilityAnalysisView oldDepanalysisview = depanalysisview;
		depanalysisview = newDepanalysisview;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CHESSViewsPackage.ANALYSIS_VIEW__DEPANALYSISVIEW, oldDepanalysisview, depanalysisview));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CHESSViewsPackage.ANALYSIS_VIEW__RTANALYSISVIEW:
				return basicSetRtanalysisview(null, msgs);
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
			case CHESSViewsPackage.ANALYSIS_VIEW__BASE_PACKAGE:
				if (resolve) return getBase_Package();
				return basicGetBase_Package();
			case CHESSViewsPackage.ANALYSIS_VIEW__RTANALYSISVIEW:
				return getRtanalysisview();
			case CHESSViewsPackage.ANALYSIS_VIEW__DEPANALYSISVIEW:
				if (resolve) return getDepanalysisview();
				return basicGetDepanalysisview();
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
			case CHESSViewsPackage.ANALYSIS_VIEW__BASE_PACKAGE:
				setBase_Package((org.eclipse.uml2.uml.Package)newValue);
				return;
			case CHESSViewsPackage.ANALYSIS_VIEW__RTANALYSISVIEW:
				setRtanalysisview((RTAnalysisView)newValue);
				return;
			case CHESSViewsPackage.ANALYSIS_VIEW__DEPANALYSISVIEW:
				setDepanalysisview((DependabilityAnalysisView)newValue);
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
			case CHESSViewsPackage.ANALYSIS_VIEW__BASE_PACKAGE:
				setBase_Package((org.eclipse.uml2.uml.Package)null);
				return;
			case CHESSViewsPackage.ANALYSIS_VIEW__RTANALYSISVIEW:
				setRtanalysisview((RTAnalysisView)null);
				return;
			case CHESSViewsPackage.ANALYSIS_VIEW__DEPANALYSISVIEW:
				setDepanalysisview((DependabilityAnalysisView)null);
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
			case CHESSViewsPackage.ANALYSIS_VIEW__BASE_PACKAGE:
				return base_Package != null;
			case CHESSViewsPackage.ANALYSIS_VIEW__RTANALYSISVIEW:
				return rtanalysisview != null;
			case CHESSViewsPackage.ANALYSIS_VIEW__DEPANALYSISVIEW:
				return depanalysisview != null;
		}
		return super.eIsSet(featureID);
	}

} //AnalysisViewImpl
