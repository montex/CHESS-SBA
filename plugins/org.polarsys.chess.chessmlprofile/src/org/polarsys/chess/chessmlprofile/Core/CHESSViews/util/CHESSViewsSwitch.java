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
package org.polarsys.chess.chessmlprofile.Core.CHESSViews.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.polarsys.chess.chessmlprofile.Core.CHESSViews.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.polarsys.chess.chessmlprofile.Core.CHESSViews.CHESSViewsPackage
 * @generated
 */
public class CHESSViewsSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CHESSViewsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CHESSViewsSwitch() {
		if (modelPackage == null) {
			modelPackage = CHESSViewsPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case CHESSViewsPackage.EXTRA_FUNCTIONAL_VIEW: {
				ExtraFunctionalView extraFunctionalView = (ExtraFunctionalView)theEObject;
				T result = caseExtraFunctionalView(extraFunctionalView);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CHESSViewsPackage.TIMING_DATA_FLOW_VIEW: {
				TimingDataFlowView timingDataFlowView = (TimingDataFlowView)theEObject;
				T result = caseTimingDataFlowView(timingDataFlowView);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CHESSViewsPackage.RT_ANALYSIS_VIEW: {
				RTAnalysisView rtAnalysisView = (RTAnalysisView)theEObject;
				T result = caseRTAnalysisView(rtAnalysisView);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CHESSViewsPackage.DEPLOYMENT_VIEW: {
				DeploymentView deploymentView = (DeploymentView)theEObject;
				T result = caseDeploymentView(deploymentView);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CHESSViewsPackage.REQUIREMENT_VIEW: {
				RequirementView requirementView = (RequirementView)theEObject;
				T result = caseRequirementView(requirementView);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CHESSViewsPackage.COMPONENT_VIEW: {
				ComponentView componentView = (ComponentView)theEObject;
				T result = caseComponentView(componentView);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CHESSViewsPackage.DEPENDABILITY_ANALYSIS_VIEW: {
				DependabilityAnalysisView dependabilityAnalysisView = (DependabilityAnalysisView)theEObject;
				T result = caseDependabilityAnalysisView(dependabilityAnalysisView);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CHESSViewsPackage.SYSTEM_VIEW: {
				SystemView systemView = (SystemView)theEObject;
				T result = caseSystemView(systemView);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CHESSViewsPackage.PSM_VIEW: {
				PSMView psmView = (PSMView)theEObject;
				T result = casePSMView(psmView);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CHESSViewsPackage.ANALYSIS_VIEW: {
				AnalysisView analysisView = (AnalysisView)theEObject;
				T result = caseAnalysisView(analysisView);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extra Functional View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extra Functional View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtraFunctionalView(ExtraFunctionalView object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Timing Data Flow View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Timing Data Flow View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTimingDataFlowView(TimingDataFlowView object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>RT Analysis View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>RT Analysis View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRTAnalysisView(RTAnalysisView object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deployment View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deployment View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeploymentView(DeploymentView object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Requirement View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Requirement View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRequirementView(RequirementView object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentView(ComponentView object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dependability Analysis View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dependability Analysis View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDependabilityAnalysisView(DependabilityAnalysisView object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>System View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>System View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSystemView(SystemView object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PSM View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PSM View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePSMView(PSMView object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Analysis View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Analysis View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnalysisView(AnalysisView object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //CHESSViewsSwitch
