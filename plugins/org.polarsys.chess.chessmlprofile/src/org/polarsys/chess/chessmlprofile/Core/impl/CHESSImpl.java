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
package org.polarsys.chess.chessmlprofile.Core.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.uml2.uml.Model;
import org.polarsys.chess.chessmlprofile.Core.CHESS;
import org.polarsys.chess.chessmlprofile.Core.CorePackage;
import org.polarsys.chess.chessmlprofile.Core.Domain;
import org.polarsys.chess.chessmlprofile.Core.CHESSViews.AnalysisView;
import org.polarsys.chess.chessmlprofile.Core.CHESSViews.ComponentView;
import org.polarsys.chess.chessmlprofile.Core.CHESSViews.DeploymentView;
import org.polarsys.chess.chessmlprofile.Core.CHESSViews.PSMView;
import org.polarsys.chess.chessmlprofile.Core.CHESSViews.RequirementView;
import org.polarsys.chess.chessmlprofile.Core.CHESSViews.SystemView;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CHESS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Core.impl.CHESSImpl#getBase_Model <em>Base Model</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Core.impl.CHESSImpl#getAnalysisView <em>Analysis View</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Core.impl.CHESSImpl#getDeploymentView <em>Deployment View</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Core.impl.CHESSImpl#getRequirementView <em>Requirement View</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Core.impl.CHESSImpl#getComponentView <em>Component View</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Core.impl.CHESSImpl#getSystemView <em>System View</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Core.impl.CHESSImpl#getPsmView <em>Psm View</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Core.impl.CHESSImpl#getDomain <em>Domain</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CHESSImpl extends EObjectImpl implements CHESS {
	/**
	 * The cached value of the '{@link #getBase_Model() <em>Base Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Model()
	 * @generated
	 * @ordered
	 */
	protected Model base_Model;

	/**
	 * The cached value of the '{@link #getAnalysisView() <em>Analysis View</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnalysisView()
	 * @generated
	 * @ordered
	 */
	protected AnalysisView analysisView;

	/**
	 * The cached value of the '{@link #getDeploymentView() <em>Deployment View</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeploymentView()
	 * @generated
	 * @ordered
	 */
	protected DeploymentView deploymentView;

	/**
	 * The cached value of the '{@link #getRequirementView() <em>Requirement View</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirementView()
	 * @generated
	 * @ordered
	 */
	protected RequirementView requirementView;

	/**
	 * The cached value of the '{@link #getComponentView() <em>Component View</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentView()
	 * @generated
	 * @ordered
	 */
	protected ComponentView componentView;

	/**
	 * The cached value of the '{@link #getSystemView() <em>System View</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemView()
	 * @generated
	 * @ordered
	 */
	protected SystemView systemView;

	/**
	 * The cached value of the '{@link #getPsmView() <em>Psm View</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPsmView()
	 * @generated
	 * @ordered
	 */
	protected PSMView psmView;

	/**
	 * The default value of the '{@link #getDomain() <em>Domain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomain()
	 * @generated
	 * @ordered
	 */
	protected static final Domain DOMAIN_EDEFAULT = Domain.CROSS_DOMAIN;

	/**
	 * The cached value of the '{@link #getDomain() <em>Domain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomain()
	 * @generated
	 * @ordered
	 */
	protected Domain domain = DOMAIN_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CHESSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.CHESS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model getBase_Model() {
		if (base_Model != null && base_Model.eIsProxy()) {
			InternalEObject oldBase_Model = (InternalEObject)base_Model;
			base_Model = (Model)eResolveProxy(oldBase_Model);
			if (base_Model != oldBase_Model) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.CHESS__BASE_MODEL, oldBase_Model, base_Model));
			}
		}
		return base_Model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model basicGetBase_Model() {
		return base_Model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Model(Model newBase_Model) {
		Model oldBase_Model = base_Model;
		base_Model = newBase_Model;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.CHESS__BASE_MODEL, oldBase_Model, base_Model));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnalysisView getAnalysisView() {
		return analysisView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAnalysisView(AnalysisView newAnalysisView, NotificationChain msgs) {
		AnalysisView oldAnalysisView = analysisView;
		analysisView = newAnalysisView;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CorePackage.CHESS__ANALYSIS_VIEW, oldAnalysisView, newAnalysisView);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnalysisView(AnalysisView newAnalysisView) {
		if (newAnalysisView != analysisView) {
			NotificationChain msgs = null;
			if (analysisView != null)
				msgs = ((InternalEObject)analysisView).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CorePackage.CHESS__ANALYSIS_VIEW, null, msgs);
			if (newAnalysisView != null)
				msgs = ((InternalEObject)newAnalysisView).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CorePackage.CHESS__ANALYSIS_VIEW, null, msgs);
			msgs = basicSetAnalysisView(newAnalysisView, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.CHESS__ANALYSIS_VIEW, newAnalysisView, newAnalysisView));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeploymentView getDeploymentView() {
		return deploymentView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeploymentView(DeploymentView newDeploymentView, NotificationChain msgs) {
		DeploymentView oldDeploymentView = deploymentView;
		deploymentView = newDeploymentView;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CorePackage.CHESS__DEPLOYMENT_VIEW, oldDeploymentView, newDeploymentView);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeploymentView(DeploymentView newDeploymentView) {
		if (newDeploymentView != deploymentView) {
			NotificationChain msgs = null;
			if (deploymentView != null)
				msgs = ((InternalEObject)deploymentView).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CorePackage.CHESS__DEPLOYMENT_VIEW, null, msgs);
			if (newDeploymentView != null)
				msgs = ((InternalEObject)newDeploymentView).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CorePackage.CHESS__DEPLOYMENT_VIEW, null, msgs);
			msgs = basicSetDeploymentView(newDeploymentView, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.CHESS__DEPLOYMENT_VIEW, newDeploymentView, newDeploymentView));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementView getRequirementView() {
		return requirementView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRequirementView(RequirementView newRequirementView, NotificationChain msgs) {
		RequirementView oldRequirementView = requirementView;
		requirementView = newRequirementView;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CorePackage.CHESS__REQUIREMENT_VIEW, oldRequirementView, newRequirementView);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequirementView(RequirementView newRequirementView) {
		if (newRequirementView != requirementView) {
			NotificationChain msgs = null;
			if (requirementView != null)
				msgs = ((InternalEObject)requirementView).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CorePackage.CHESS__REQUIREMENT_VIEW, null, msgs);
			if (newRequirementView != null)
				msgs = ((InternalEObject)newRequirementView).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CorePackage.CHESS__REQUIREMENT_VIEW, null, msgs);
			msgs = basicSetRequirementView(newRequirementView, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.CHESS__REQUIREMENT_VIEW, newRequirementView, newRequirementView));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentView getComponentView() {
		return componentView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetComponentView(ComponentView newComponentView, NotificationChain msgs) {
		ComponentView oldComponentView = componentView;
		componentView = newComponentView;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CorePackage.CHESS__COMPONENT_VIEW, oldComponentView, newComponentView);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponentView(ComponentView newComponentView) {
		if (newComponentView != componentView) {
			NotificationChain msgs = null;
			if (componentView != null)
				msgs = ((InternalEObject)componentView).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CorePackage.CHESS__COMPONENT_VIEW, null, msgs);
			if (newComponentView != null)
				msgs = ((InternalEObject)newComponentView).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CorePackage.CHESS__COMPONENT_VIEW, null, msgs);
			msgs = basicSetComponentView(newComponentView, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.CHESS__COMPONENT_VIEW, newComponentView, newComponentView));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemView getSystemView() {
		return systemView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSystemView(SystemView newSystemView, NotificationChain msgs) {
		SystemView oldSystemView = systemView;
		systemView = newSystemView;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CorePackage.CHESS__SYSTEM_VIEW, oldSystemView, newSystemView);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSystemView(SystemView newSystemView) {
		if (newSystemView != systemView) {
			NotificationChain msgs = null;
			if (systemView != null)
				msgs = ((InternalEObject)systemView).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CorePackage.CHESS__SYSTEM_VIEW, null, msgs);
			if (newSystemView != null)
				msgs = ((InternalEObject)newSystemView).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CorePackage.CHESS__SYSTEM_VIEW, null, msgs);
			msgs = basicSetSystemView(newSystemView, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.CHESS__SYSTEM_VIEW, newSystemView, newSystemView));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PSMView getPsmView() {
		if (psmView != null && psmView.eIsProxy()) {
			InternalEObject oldPsmView = (InternalEObject)psmView;
			psmView = (PSMView)eResolveProxy(oldPsmView);
			if (psmView != oldPsmView) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.CHESS__PSM_VIEW, oldPsmView, psmView));
			}
		}
		return psmView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PSMView basicGetPsmView() {
		return psmView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPsmView(PSMView newPsmView) {
		PSMView oldPsmView = psmView;
		psmView = newPsmView;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.CHESS__PSM_VIEW, oldPsmView, psmView));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Domain getDomain() {
		return domain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomain(Domain newDomain) {
		Domain oldDomain = domain;
		domain = newDomain == null ? DOMAIN_EDEFAULT : newDomain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.CHESS__DOMAIN, oldDomain, domain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.CHESS__ANALYSIS_VIEW:
				return basicSetAnalysisView(null, msgs);
			case CorePackage.CHESS__DEPLOYMENT_VIEW:
				return basicSetDeploymentView(null, msgs);
			case CorePackage.CHESS__REQUIREMENT_VIEW:
				return basicSetRequirementView(null, msgs);
			case CorePackage.CHESS__COMPONENT_VIEW:
				return basicSetComponentView(null, msgs);
			case CorePackage.CHESS__SYSTEM_VIEW:
				return basicSetSystemView(null, msgs);
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
			case CorePackage.CHESS__BASE_MODEL:
				if (resolve) return getBase_Model();
				return basicGetBase_Model();
			case CorePackage.CHESS__ANALYSIS_VIEW:
				return getAnalysisView();
			case CorePackage.CHESS__DEPLOYMENT_VIEW:
				return getDeploymentView();
			case CorePackage.CHESS__REQUIREMENT_VIEW:
				return getRequirementView();
			case CorePackage.CHESS__COMPONENT_VIEW:
				return getComponentView();
			case CorePackage.CHESS__SYSTEM_VIEW:
				return getSystemView();
			case CorePackage.CHESS__PSM_VIEW:
				if (resolve) return getPsmView();
				return basicGetPsmView();
			case CorePackage.CHESS__DOMAIN:
				return getDomain();
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
			case CorePackage.CHESS__BASE_MODEL:
				setBase_Model((Model)newValue);
				return;
			case CorePackage.CHESS__ANALYSIS_VIEW:
				setAnalysisView((AnalysisView)newValue);
				return;
			case CorePackage.CHESS__DEPLOYMENT_VIEW:
				setDeploymentView((DeploymentView)newValue);
				return;
			case CorePackage.CHESS__REQUIREMENT_VIEW:
				setRequirementView((RequirementView)newValue);
				return;
			case CorePackage.CHESS__COMPONENT_VIEW:
				setComponentView((ComponentView)newValue);
				return;
			case CorePackage.CHESS__SYSTEM_VIEW:
				setSystemView((SystemView)newValue);
				return;
			case CorePackage.CHESS__PSM_VIEW:
				setPsmView((PSMView)newValue);
				return;
			case CorePackage.CHESS__DOMAIN:
				setDomain((Domain)newValue);
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
			case CorePackage.CHESS__BASE_MODEL:
				setBase_Model((Model)null);
				return;
			case CorePackage.CHESS__ANALYSIS_VIEW:
				setAnalysisView((AnalysisView)null);
				return;
			case CorePackage.CHESS__DEPLOYMENT_VIEW:
				setDeploymentView((DeploymentView)null);
				return;
			case CorePackage.CHESS__REQUIREMENT_VIEW:
				setRequirementView((RequirementView)null);
				return;
			case CorePackage.CHESS__COMPONENT_VIEW:
				setComponentView((ComponentView)null);
				return;
			case CorePackage.CHESS__SYSTEM_VIEW:
				setSystemView((SystemView)null);
				return;
			case CorePackage.CHESS__PSM_VIEW:
				setPsmView((PSMView)null);
				return;
			case CorePackage.CHESS__DOMAIN:
				setDomain(DOMAIN_EDEFAULT);
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
			case CorePackage.CHESS__BASE_MODEL:
				return base_Model != null;
			case CorePackage.CHESS__ANALYSIS_VIEW:
				return analysisView != null;
			case CorePackage.CHESS__DEPLOYMENT_VIEW:
				return deploymentView != null;
			case CorePackage.CHESS__REQUIREMENT_VIEW:
				return requirementView != null;
			case CorePackage.CHESS__COMPONENT_VIEW:
				return componentView != null;
			case CorePackage.CHESS__SYSTEM_VIEW:
				return systemView != null;
			case CorePackage.CHESS__PSM_VIEW:
				return psmView != null;
			case CorePackage.CHESS__DOMAIN:
				return domain != DOMAIN_EDEFAULT;
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
		result.append(" (domain: ");
		result.append(domain);
		result.append(')');
		return result.toString();
	}

} //CHESSImpl
