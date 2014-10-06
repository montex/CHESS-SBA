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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaAnalysisContextImpl;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Assign;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.DeploymentConfAnalysisPackage;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.SchedulingAnalysis;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scheduling Analysis</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.impl.SchedulingAnalysisImpl#getMapping <em>Mapping</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.impl.SchedulingAnalysisImpl#getResultingPriorities <em>Resulting Priorities</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.impl.SchedulingAnalysisImpl#getSchedulingStrategy <em>Scheduling Strategy</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SchedulingAnalysisImpl extends GaAnalysisContextImpl implements SchedulingAnalysis {
	/**
	 * The cached value of the '{@link #getMapping() <em>Mapping</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMapping()
	 * @generated
	 * @ordered
	 */
	protected EList<Assign> mapping;

	/**
	 * The cached value of the '{@link #getResultingPriorities() <em>Resulting Priorities</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultingPriorities()
	 * @generated
	 * @ordered
	 */
	protected EList<CHRtSpecification> resultingPriorities;

	/**
	 * The cached value of the '{@link #getSchedulingStrategy() <em>Scheduling Strategy</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchedulingStrategy()
	 * @generated
	 * @ordered
	 */
	protected EList<String> schedulingStrategy;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SchedulingAnalysisImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DeploymentConfAnalysisPackage.Literals.SCHEDULING_ANALYSIS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Assign> getMapping() {
		if (mapping == null) {
			mapping = new EObjectResolvingEList<Assign>(Assign.class, this, DeploymentConfAnalysisPackage.SCHEDULING_ANALYSIS__MAPPING);
		}
		return mapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CHRtSpecification> getResultingPriorities() {
		if (resultingPriorities == null) {
			resultingPriorities = new EObjectResolvingEList<CHRtSpecification>(CHRtSpecification.class, this, DeploymentConfAnalysisPackage.SCHEDULING_ANALYSIS__RESULTING_PRIORITIES);
		}
		return resultingPriorities;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getSchedulingStrategy() {
		if (schedulingStrategy == null) {
			schedulingStrategy = new EDataTypeUniqueEList<String>(String.class, this, DeploymentConfAnalysisPackage.SCHEDULING_ANALYSIS__SCHEDULING_STRATEGY);
		}
		return schedulingStrategy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DeploymentConfAnalysisPackage.SCHEDULING_ANALYSIS__MAPPING:
				return getMapping();
			case DeploymentConfAnalysisPackage.SCHEDULING_ANALYSIS__RESULTING_PRIORITIES:
				return getResultingPriorities();
			case DeploymentConfAnalysisPackage.SCHEDULING_ANALYSIS__SCHEDULING_STRATEGY:
				return getSchedulingStrategy();
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
			case DeploymentConfAnalysisPackage.SCHEDULING_ANALYSIS__MAPPING:
				getMapping().clear();
				getMapping().addAll((Collection<? extends Assign>)newValue);
				return;
			case DeploymentConfAnalysisPackage.SCHEDULING_ANALYSIS__RESULTING_PRIORITIES:
				getResultingPriorities().clear();
				getResultingPriorities().addAll((Collection<? extends CHRtSpecification>)newValue);
				return;
			case DeploymentConfAnalysisPackage.SCHEDULING_ANALYSIS__SCHEDULING_STRATEGY:
				getSchedulingStrategy().clear();
				getSchedulingStrategy().addAll((Collection<? extends String>)newValue);
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
			case DeploymentConfAnalysisPackage.SCHEDULING_ANALYSIS__MAPPING:
				getMapping().clear();
				return;
			case DeploymentConfAnalysisPackage.SCHEDULING_ANALYSIS__RESULTING_PRIORITIES:
				getResultingPriorities().clear();
				return;
			case DeploymentConfAnalysisPackage.SCHEDULING_ANALYSIS__SCHEDULING_STRATEGY:
				getSchedulingStrategy().clear();
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
			case DeploymentConfAnalysisPackage.SCHEDULING_ANALYSIS__MAPPING:
				return mapping != null && !mapping.isEmpty();
			case DeploymentConfAnalysisPackage.SCHEDULING_ANALYSIS__RESULTING_PRIORITIES:
				return resultingPriorities != null && !resultingPriorities.isEmpty();
			case DeploymentConfAnalysisPackage.SCHEDULING_ANALYSIS__SCHEDULING_STRATEGY:
				return schedulingStrategy != null && !schedulingStrategy.isEmpty();
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
		result.append(" (schedulingStrategy: ");
		result.append(schedulingStrategy);
		result.append(')');
		return result.toString();
	}

} //SchedulingAnalysisImpl
