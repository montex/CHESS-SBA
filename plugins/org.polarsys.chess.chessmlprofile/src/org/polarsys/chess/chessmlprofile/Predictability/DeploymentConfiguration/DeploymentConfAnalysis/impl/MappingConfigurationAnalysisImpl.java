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
package org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaAnalysisContextImpl;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Assign;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.DeploymentConfAnalysisPackage;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.MappingConfigurationAnalysis;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Configuration Analysis</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.impl.MappingConfigurationAnalysisImpl#getProhibitedAllocations <em>Prohibited Allocations</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.impl.MappingConfigurationAnalysisImpl#getFixedAllocations <em>Fixed Allocations</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.impl.MappingConfigurationAnalysisImpl#isBottomUpAnalysis <em>Bottom Up Analysis</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.impl.MappingConfigurationAnalysisImpl#getResultingMapping <em>Resulting Mapping</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingConfigurationAnalysisImpl extends GaAnalysisContextImpl implements MappingConfigurationAnalysis {
	/**
	 * The cached value of the '{@link #getProhibitedAllocations() <em>Prohibited Allocations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProhibitedAllocations()
	 * @generated
	 * @ordered
	 */
	protected EList<Assign> prohibitedAllocations;

	/**
	 * The cached value of the '{@link #getFixedAllocations() <em>Fixed Allocations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFixedAllocations()
	 * @generated
	 * @ordered
	 */
	protected EList<Assign> fixedAllocations;

	/**
	 * The default value of the '{@link #isBottomUpAnalysis() <em>Bottom Up Analysis</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBottomUpAnalysis()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BOTTOM_UP_ANALYSIS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isBottomUpAnalysis() <em>Bottom Up Analysis</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBottomUpAnalysis()
	 * @generated
	 * @ordered
	 */
	protected boolean bottomUpAnalysis = BOTTOM_UP_ANALYSIS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getResultingMapping() <em>Resulting Mapping</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultingMapping()
	 * @generated
	 * @ordered
	 */
	protected EList<Assign> resultingMapping;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingConfigurationAnalysisImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DeploymentConfAnalysisPackage.Literals.MAPPING_CONFIGURATION_ANALYSIS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Assign> getProhibitedAllocations() {
		if (prohibitedAllocations == null) {
			prohibitedAllocations = new EObjectResolvingEList<Assign>(Assign.class, this, DeploymentConfAnalysisPackage.MAPPING_CONFIGURATION_ANALYSIS__PROHIBITED_ALLOCATIONS);
		}
		return prohibitedAllocations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Assign> getFixedAllocations() {
		if (fixedAllocations == null) {
			fixedAllocations = new EObjectResolvingEList<Assign>(Assign.class, this, DeploymentConfAnalysisPackage.MAPPING_CONFIGURATION_ANALYSIS__FIXED_ALLOCATIONS);
		}
		return fixedAllocations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBottomUpAnalysis() {
		return bottomUpAnalysis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBottomUpAnalysis(boolean newBottomUpAnalysis) {
		boolean oldBottomUpAnalysis = bottomUpAnalysis;
		bottomUpAnalysis = newBottomUpAnalysis;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeploymentConfAnalysisPackage.MAPPING_CONFIGURATION_ANALYSIS__BOTTOM_UP_ANALYSIS, oldBottomUpAnalysis, bottomUpAnalysis));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Assign> getResultingMapping() {
		if (resultingMapping == null) {
			resultingMapping = new EObjectResolvingEList<Assign>(Assign.class, this, DeploymentConfAnalysisPackage.MAPPING_CONFIGURATION_ANALYSIS__RESULTING_MAPPING);
		}
		return resultingMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DeploymentConfAnalysisPackage.MAPPING_CONFIGURATION_ANALYSIS__PROHIBITED_ALLOCATIONS:
				return getProhibitedAllocations();
			case DeploymentConfAnalysisPackage.MAPPING_CONFIGURATION_ANALYSIS__FIXED_ALLOCATIONS:
				return getFixedAllocations();
			case DeploymentConfAnalysisPackage.MAPPING_CONFIGURATION_ANALYSIS__BOTTOM_UP_ANALYSIS:
				return isBottomUpAnalysis();
			case DeploymentConfAnalysisPackage.MAPPING_CONFIGURATION_ANALYSIS__RESULTING_MAPPING:
				return getResultingMapping();
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
			case DeploymentConfAnalysisPackage.MAPPING_CONFIGURATION_ANALYSIS__PROHIBITED_ALLOCATIONS:
				getProhibitedAllocations().clear();
				getProhibitedAllocations().addAll((Collection<? extends Assign>)newValue);
				return;
			case DeploymentConfAnalysisPackage.MAPPING_CONFIGURATION_ANALYSIS__FIXED_ALLOCATIONS:
				getFixedAllocations().clear();
				getFixedAllocations().addAll((Collection<? extends Assign>)newValue);
				return;
			case DeploymentConfAnalysisPackage.MAPPING_CONFIGURATION_ANALYSIS__BOTTOM_UP_ANALYSIS:
				setBottomUpAnalysis((Boolean)newValue);
				return;
			case DeploymentConfAnalysisPackage.MAPPING_CONFIGURATION_ANALYSIS__RESULTING_MAPPING:
				getResultingMapping().clear();
				getResultingMapping().addAll((Collection<? extends Assign>)newValue);
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
			case DeploymentConfAnalysisPackage.MAPPING_CONFIGURATION_ANALYSIS__PROHIBITED_ALLOCATIONS:
				getProhibitedAllocations().clear();
				return;
			case DeploymentConfAnalysisPackage.MAPPING_CONFIGURATION_ANALYSIS__FIXED_ALLOCATIONS:
				getFixedAllocations().clear();
				return;
			case DeploymentConfAnalysisPackage.MAPPING_CONFIGURATION_ANALYSIS__BOTTOM_UP_ANALYSIS:
				setBottomUpAnalysis(BOTTOM_UP_ANALYSIS_EDEFAULT);
				return;
			case DeploymentConfAnalysisPackage.MAPPING_CONFIGURATION_ANALYSIS__RESULTING_MAPPING:
				getResultingMapping().clear();
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
			case DeploymentConfAnalysisPackage.MAPPING_CONFIGURATION_ANALYSIS__PROHIBITED_ALLOCATIONS:
				return prohibitedAllocations != null && !prohibitedAllocations.isEmpty();
			case DeploymentConfAnalysisPackage.MAPPING_CONFIGURATION_ANALYSIS__FIXED_ALLOCATIONS:
				return fixedAllocations != null && !fixedAllocations.isEmpty();
			case DeploymentConfAnalysisPackage.MAPPING_CONFIGURATION_ANALYSIS__BOTTOM_UP_ANALYSIS:
				return bottomUpAnalysis != BOTTOM_UP_ANALYSIS_EDEFAULT;
			case DeploymentConfAnalysisPackage.MAPPING_CONFIGURATION_ANALYSIS__RESULTING_MAPPING:
				return resultingMapping != null && !resultingMapping.isEmpty();
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
		result.append(" (bottomUpAnalysis: ");
		result.append(bottomUpAnalysis);
		result.append(')');
		return result.toString();
	}

} //MappingConfigurationAnalysisImpl
