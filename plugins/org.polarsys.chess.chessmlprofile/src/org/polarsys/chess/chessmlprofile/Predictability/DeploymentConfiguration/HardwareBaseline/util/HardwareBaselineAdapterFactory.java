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
package org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwGeneral.HwResource;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwBus;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwCommunicationResource;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwMedia;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwComputingResource;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwProcessor;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.CommunicationMedia;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ComputingResource;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ProcessingResource;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Resource;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.HardwareBaselinePackage
 * @generated
 */
public class HardwareBaselineAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static HardwareBaselinePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HardwareBaselineAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = HardwareBaselinePackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HardwareBaselineSwitch<Adapter> modelSwitch =
		new HardwareBaselineSwitch<Adapter>() {
			@Override
			public Adapter caseCH_HwProcessor(CH_HwProcessor object) {
				return createCH_HwProcessorAdapter();
			}
			@Override
			public Adapter caseHWDataType(HWDataType object) {
				return createHWDataTypeAdapter();
			}
			@Override
			public Adapter caseDataTypeExecution(DataTypeExecution object) {
				return createDataTypeExecutionAdapter();
			}
			@Override
			public Adapter caseComputeComplexity(ComputeComplexity object) {
				return createComputeComplexityAdapter();
			}
			@Override
			public Adapter caseSWDataType(SWDataType object) {
				return createSWDataTypeAdapter();
			}
			@Override
			public Adapter caseOperationCount(OperationCount object) {
				return createOperationCountAdapter();
			}
			@Override
			public Adapter caseCHControlFlow(CHControlFlow object) {
				return createCHControlFlowAdapter();
			}
			@Override
			public Adapter caseFloatSWDataType(FloatSWDataType object) {
				return createFloatSWDataTypeAdapter();
			}
			@Override
			public Adapter caseFixedSWDataType(FixedSWDataType object) {
				return createFixedSWDataTypeAdapter();
			}
			@Override
			public Adapter caseIntegerSWDataType(IntegerSWDataType object) {
				return createIntegerSWDataTypeAdapter();
			}
			@Override
			public Adapter caseCharSWDataType(CharSWDataType object) {
				return createCharSWDataTypeAdapter();
			}
			@Override
			public Adapter caseBooleanSWDataType(BooleanSWDataType object) {
				return createBooleanSWDataTypeAdapter();
			}
			@Override
			public Adapter caseCH_HwBus(CH_HwBus object) {
				return createCH_HwBusAdapter();
			}
			@Override
			public Adapter caseCH_HwComputingResource(CH_HwComputingResource object) {
				return createCH_HwComputingResourceAdapter();
			}
			@Override
			public Adapter caseDataTypeAssign(DataTypeAssign object) {
				return createDataTypeAssignAdapter();
			}
			@Override
			public Adapter caseResource(Resource object) {
				return createResourceAdapter();
			}
			@Override
			public Adapter caseHwResource(HwResource object) {
				return createHwResourceAdapter();
			}
			@Override
			public Adapter caseProcessingResource(ProcessingResource object) {
				return createProcessingResourceAdapter();
			}
			@Override
			public Adapter caseComputingResource(ComputingResource object) {
				return createComputingResourceAdapter();
			}
			@Override
			public Adapter caseHwComputingResource(HwComputingResource object) {
				return createHwComputingResourceAdapter();
			}
			@Override
			public Adapter caseHwProcessor(HwProcessor object) {
				return createHwProcessorAdapter();
			}
			@Override
			public Adapter caseCommunicationMedia(CommunicationMedia object) {
				return createCommunicationMediaAdapter();
			}
			@Override
			public Adapter caseHwCommunicationResource(HwCommunicationResource object) {
				return createHwCommunicationResourceAdapter();
			}
			@Override
			public Adapter caseHwMedia(HwMedia object) {
				return createHwMediaAdapter();
			}
			@Override
			public Adapter caseHwBus(HwBus object) {
				return createHwBusAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CH_HwProcessor <em>CH Hw Processor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CH_HwProcessor
	 * @generated
	 */
	public Adapter createCH_HwProcessorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.HWDataType <em>HW Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.HWDataType
	 * @generated
	 */
	public Adapter createHWDataTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.DataTypeExecution <em>Data Type Execution</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.DataTypeExecution
	 * @generated
	 */
	public Adapter createDataTypeExecutionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.ComputeComplexity <em>Compute Complexity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.ComputeComplexity
	 * @generated
	 */
	public Adapter createComputeComplexityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.SWDataType <em>SW Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.SWDataType
	 * @generated
	 */
	public Adapter createSWDataTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.OperationCount <em>Operation Count</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.OperationCount
	 * @generated
	 */
	public Adapter createOperationCountAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CHControlFlow <em>CH Control Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CHControlFlow
	 * @generated
	 */
	public Adapter createCHControlFlowAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.FloatSWDataType <em>Float SW Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.FloatSWDataType
	 * @generated
	 */
	public Adapter createFloatSWDataTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.FixedSWDataType <em>Fixed SW Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.FixedSWDataType
	 * @generated
	 */
	public Adapter createFixedSWDataTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.IntegerSWDataType <em>Integer SW Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.IntegerSWDataType
	 * @generated
	 */
	public Adapter createIntegerSWDataTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CharSWDataType <em>Char SW Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CharSWDataType
	 * @generated
	 */
	public Adapter createCharSWDataTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.BooleanSWDataType <em>Boolean SW Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.BooleanSWDataType
	 * @generated
	 */
	public Adapter createBooleanSWDataTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CH_HwBus <em>CH Hw Bus</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CH_HwBus
	 * @generated
	 */
	public Adapter createCH_HwBusAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CH_HwComputingResource <em>CH Hw Computing Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CH_HwComputingResource
	 * @generated
	 */
	public Adapter createCH_HwComputingResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.DataTypeAssign <em>Data Type Assign</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.DataTypeAssign
	 * @generated
	 */
	public Adapter createDataTypeAssignAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Resource
	 * @generated
	 */
	public Adapter createResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwGeneral.HwResource <em>Hw Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwGeneral.HwResource
	 * @generated
	 */
	public Adapter createHwResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ProcessingResource <em>Processing Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ProcessingResource
	 * @generated
	 */
	public Adapter createProcessingResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ComputingResource <em>Computing Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ComputingResource
	 * @generated
	 */
	public Adapter createComputingResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwComputingResource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwComputingResource
	 * @generated
	 */
	public Adapter createHwComputingResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwProcessor <em>Hw Processor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwProcessor
	 * @generated
	 */
	public Adapter createHwProcessorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.CommunicationMedia <em>Communication Media</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.CommunicationMedia
	 * @generated
	 */
	public Adapter createCommunicationMediaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwCommunicationResource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwCommunicationResource
	 * @generated
	 */
	public Adapter createHwCommunicationResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwMedia <em>Hw Media</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwMedia
	 * @generated
	 */
	public Adapter createHwMediaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwBus <em>Hw Bus</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwBus
	 * @generated
	 */
	public Adapter createHwBusAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //HardwareBaselineAdapterFactory
