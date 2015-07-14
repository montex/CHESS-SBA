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
import org.polarsys.chess.chessmlprofile.Core.CHESSViews.CHESSViewsPackage;
import org.polarsys.chess.chessmlprofile.Core.CHESSViews.ExtraFunctionalView;
import org.polarsys.chess.chessmlprofile.Core.CHESSViews.TimingDataFlowView;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extra Functional View</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.ExtraFunctionalViewImpl#getBase_Package <em>Base Package</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.ExtraFunctionalViewImpl#getTimingdataflowview <em>Timingdataflowview</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExtraFunctionalViewImpl extends EObjectImpl implements ExtraFunctionalView {
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
	 * The cached value of the '{@link #getTimingdataflowview() <em>Timingdataflowview</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimingdataflowview()
	 * @generated
	 * @ordered
	 */
	protected TimingDataFlowView timingdataflowview;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtraFunctionalViewImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CHESSViewsPackage.Literals.EXTRA_FUNCTIONAL_VIEW;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CHESSViewsPackage.EXTRA_FUNCTIONAL_VIEW__BASE_PACKAGE, oldBase_Package, base_Package));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CHESSViewsPackage.EXTRA_FUNCTIONAL_VIEW__BASE_PACKAGE, oldBase_Package, base_Package));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimingDataFlowView getTimingdataflowview() {
		return timingdataflowview;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTimingdataflowview(TimingDataFlowView newTimingdataflowview, NotificationChain msgs) {
		TimingDataFlowView oldTimingdataflowview = timingdataflowview;
		timingdataflowview = newTimingdataflowview;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CHESSViewsPackage.EXTRA_FUNCTIONAL_VIEW__TIMINGDATAFLOWVIEW, oldTimingdataflowview, newTimingdataflowview);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimingdataflowview(TimingDataFlowView newTimingdataflowview) {
		if (newTimingdataflowview != timingdataflowview) {
			NotificationChain msgs = null;
			if (timingdataflowview != null)
				msgs = ((InternalEObject)timingdataflowview).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CHESSViewsPackage.EXTRA_FUNCTIONAL_VIEW__TIMINGDATAFLOWVIEW, null, msgs);
			if (newTimingdataflowview != null)
				msgs = ((InternalEObject)newTimingdataflowview).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CHESSViewsPackage.EXTRA_FUNCTIONAL_VIEW__TIMINGDATAFLOWVIEW, null, msgs);
			msgs = basicSetTimingdataflowview(newTimingdataflowview, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CHESSViewsPackage.EXTRA_FUNCTIONAL_VIEW__TIMINGDATAFLOWVIEW, newTimingdataflowview, newTimingdataflowview));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CHESSViewsPackage.EXTRA_FUNCTIONAL_VIEW__TIMINGDATAFLOWVIEW:
				return basicSetTimingdataflowview(null, msgs);
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
			case CHESSViewsPackage.EXTRA_FUNCTIONAL_VIEW__BASE_PACKAGE:
				if (resolve) return getBase_Package();
				return basicGetBase_Package();
			case CHESSViewsPackage.EXTRA_FUNCTIONAL_VIEW__TIMINGDATAFLOWVIEW:
				return getTimingdataflowview();
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
			case CHESSViewsPackage.EXTRA_FUNCTIONAL_VIEW__BASE_PACKAGE:
				setBase_Package((org.eclipse.uml2.uml.Package)newValue);
				return;
			case CHESSViewsPackage.EXTRA_FUNCTIONAL_VIEW__TIMINGDATAFLOWVIEW:
				setTimingdataflowview((TimingDataFlowView)newValue);
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
			case CHESSViewsPackage.EXTRA_FUNCTIONAL_VIEW__BASE_PACKAGE:
				setBase_Package((org.eclipse.uml2.uml.Package)null);
				return;
			case CHESSViewsPackage.EXTRA_FUNCTIONAL_VIEW__TIMINGDATAFLOWVIEW:
				setTimingdataflowview((TimingDataFlowView)null);
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
			case CHESSViewsPackage.EXTRA_FUNCTIONAL_VIEW__BASE_PACKAGE:
				return base_Package != null;
			case CHESSViewsPackage.EXTRA_FUNCTIONAL_VIEW__TIMINGDATAFLOWVIEW:
				return timingdataflowview != null;
		}
		return super.eIsSet(featureID);
	}

} //ExtraFunctionalViewImpl
