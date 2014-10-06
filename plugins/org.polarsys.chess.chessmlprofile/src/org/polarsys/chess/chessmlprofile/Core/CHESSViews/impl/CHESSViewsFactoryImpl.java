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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.polarsys.chess.chessmlprofile.Core.CHESSViews.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CHESSViewsFactoryImpl extends EFactoryImpl implements CHESSViewsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CHESSViewsFactory init() {
		try {
			CHESSViewsFactory theCHESSViewsFactory = (CHESSViewsFactory)EPackage.Registry.INSTANCE.getEFactory(CHESSViewsPackage.eNS_URI);
			if (theCHESSViewsFactory != null) {
				return theCHESSViewsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CHESSViewsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CHESSViewsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case CHESSViewsPackage.EXTRA_FUNCTIONAL_VIEW: return createExtraFunctionalView();
			case CHESSViewsPackage.TIMING_DATA_FLOW_VIEW: return createTimingDataFlowView();
			case CHESSViewsPackage.RT_ANALYSIS_VIEW: return createRTAnalysisView();
			case CHESSViewsPackage.DEPLOYMENT_VIEW: return createDeploymentView();
			case CHESSViewsPackage.REQUIREMENT_VIEW: return createRequirementView();
			case CHESSViewsPackage.COMPONENT_VIEW: return createComponentView();
			case CHESSViewsPackage.DEPENDABILITY_ANALYSIS_VIEW: return createDependabilityAnalysisView();
			case CHESSViewsPackage.SYSTEM_VIEW: return createSystemView();
			case CHESSViewsPackage.PSM_VIEW: return createPSMView();
			case CHESSViewsPackage.ANALYSIS_VIEW: return createAnalysisView();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtraFunctionalView createExtraFunctionalView() {
		ExtraFunctionalViewImpl extraFunctionalView = new ExtraFunctionalViewImpl();
		return extraFunctionalView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimingDataFlowView createTimingDataFlowView() {
		TimingDataFlowViewImpl timingDataFlowView = new TimingDataFlowViewImpl();
		return timingDataFlowView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RTAnalysisView createRTAnalysisView() {
		RTAnalysisViewImpl rtAnalysisView = new RTAnalysisViewImpl();
		return rtAnalysisView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeploymentView createDeploymentView() {
		DeploymentViewImpl deploymentView = new DeploymentViewImpl();
		return deploymentView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementView createRequirementView() {
		RequirementViewImpl requirementView = new RequirementViewImpl();
		return requirementView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentView createComponentView() {
		ComponentViewImpl componentView = new ComponentViewImpl();
		return componentView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependabilityAnalysisView createDependabilityAnalysisView() {
		DependabilityAnalysisViewImpl dependabilityAnalysisView = new DependabilityAnalysisViewImpl();
		return dependabilityAnalysisView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemView createSystemView() {
		SystemViewImpl systemView = new SystemViewImpl();
		return systemView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PSMView createPSMView() {
		PSMViewImpl psmView = new PSMViewImpl();
		return psmView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnalysisView createAnalysisView() {
		AnalysisViewImpl analysisView = new AnalysisViewImpl();
		return analysisView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CHESSViewsPackage getCHESSViewsPackage() {
		return (CHESSViewsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CHESSViewsPackage getPackage() {
		return CHESSViewsPackage.eINSTANCE;
	}

} //CHESSViewsFactoryImpl
