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
package org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.papyrus.MARTE.MARTEPackage;
import org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.BasicNFP_TypesPackage;
import org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.GRM_BasicTypesPackage;
import org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.MARTE_DataTypesPackage;
import org.eclipse.papyrus.MARTE_Library.MARTE_PrimitivesTypes.MARTE_PrimitivesTypesPackage;
import org.eclipse.papyrus.MARTE_Library.MeasurementUnits.MeasurementUnitsPackage;
import org.eclipse.papyrus.MARTE_Library.RS_Library.RS_LibraryPackage;
import org.eclipse.papyrus.MARTE_Library.TimeLibrary.TimeLibraryPackage;
import org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.TimeTypesLibraryPackage;
import org.eclipse.uml2.types.TypesPackage;
import org.eclipse.uml2.uml.UMLPackage;
import org.polarsys.chess.chessmlprofile.chessmlprofilePackage;
import org.polarsys.chess.chessmlprofile.ComponentModel.ComponentModelPackage;
import org.polarsys.chess.chessmlprofile.ComponentModel.impl.ComponentModelPackageImpl;
import org.polarsys.chess.chessmlprofile.Core.CorePackage;
import org.polarsys.chess.chessmlprofile.Core.CHESSViews.CHESSViewsPackage;
import org.polarsys.chess.chessmlprofile.Core.CHESSViews.impl.CHESSViewsPackageImpl;
import org.polarsys.chess.chessmlprofile.Core.impl.CorePackageImpl;
import org.polarsys.chess.chessmlprofile.Dependability.DataFlowCallGraph.DataFlowCallGraphPackage;
import org.polarsys.chess.chessmlprofile.Dependability.DataFlowCallGraph.impl.DataFlowCallGraphPackageImpl;
import org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponentPackage;
import org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.DependableComponentPackageImpl;
import org.polarsys.chess.chessmlprofile.Dependability.FMEA.FMEAPackage;
import org.polarsys.chess.chessmlprofile.Dependability.FMEA.FMEADataTypes.FMEADataTypesPackage;
import org.polarsys.chess.chessmlprofile.Dependability.FMEA.FMEADataTypes.impl.FMEADataTypesPackageImpl;
import org.polarsys.chess.chessmlprofile.Dependability.FMEA.impl.FMEAPackageImpl;
import org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationPackage;
import org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.FailurePropagationDataTypesPackage;
import org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.impl.FailurePropagationDataTypesPackageImpl;
import org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl.FailurePropagationPackageImpl;
import org.polarsys.chess.chessmlprofile.Dependability.MitigationMeans.MitigationMeansPackage;
import org.polarsys.chess.chessmlprofile.Dependability.MitigationMeans.impl.MitigationMeansPackageImpl;
import org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.FaultTolerancePackage;
import org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.impl.FaultTolerancePackageImpl;
import org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MaintenanceMonitoringPackage;
import org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.impl.MaintenanceMonitoringPackageImpl;
import org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.StateBasedAnalysisPackage;
import org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.impl.StateBasedAnalysisPackageImpl;
import org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.StateBasedComponentsPackage;
import org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.impl.StateBasedComponentsPackageImpl;
import org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.StateBasedDataTypesPackage;
import org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedDataTypes.impl.StateBasedDataTypesPackageImpl;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.CHExternalFault;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.CHInternalFault;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.DegradedState;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.DepEvent;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.DurationType;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ErrorFree;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ErrorModel;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ExternalFault;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Failure;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.FailureFree;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.FailureMode;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InputEvent;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalEvent;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalFault;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalPropagation;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.InternalThreat;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Inverted;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.NormalEvent;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.NormalInput;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.NormalOutput;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.OutputEvent;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.RampDown;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.RecoveryEvent;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.RecoveryKind;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.StuckAt;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.StuckAtFixed;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatState;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatsPropagationFactory;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatsPropagationPackage;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.UnclassifiedError;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.UnclassifiedFailure;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.DeploymentConfAnalysisPackage;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.impl.DeploymentConfAnalysisPackageImpl;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.HardwareBaselinePackage;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.impl.HardwareBaselinePackageImpl;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RTComponentModelPackage;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RTDataTypes.RTDataTypesPackage;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RTDataTypes.impl.RTDataTypesPackageImpl;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.RTComponentModelPackageImpl;
import org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingAnalysisPackage;
import org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.TimingConstraintsPackage;
import org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingConstraints.impl.TimingConstraintsPackageImpl;
import org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.impl.TimingAnalysisPackageImpl;
import org.polarsys.chess.chessmlprofile.Safety.SafetyPackage;
import org.polarsys.chess.chessmlprofile.Safety.impl.SafetyPackageImpl;
import org.polarsys.chess.chessmlprofile.SystemModel.STS.STSPackage;
import org.polarsys.chess.chessmlprofile.SystemModel.STS.impl.STSPackageImpl;
import org.polarsys.chess.chessmlprofile.impl.chessmlprofilePackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ThreatsPropagationPackageImpl extends EPackageImpl implements ThreatsPropagationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass internalFaultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass internalPropagationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass externalFaultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass normalInputEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass recoveryEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass normalOutputEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass failureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass normalEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass internalThreatEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass errorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass threatStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass errorFreeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unclassifiedErrorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass failureModeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass degradedStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass failureFreeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass chInternalFaultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass chExternalFaultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unclassifiedFailureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stuckAtEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stuckAtFixedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass invertedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rampDownEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inputEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass depEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outputEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass internalEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass errorModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum durationTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum recoveryKindEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatsPropagationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ThreatsPropagationPackageImpl() {
		super(eNS_URI, ThreatsPropagationFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ThreatsPropagationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ThreatsPropagationPackage init() {
		if (isInited) return (ThreatsPropagationPackage)EPackage.Registry.INSTANCE.getEPackage(ThreatsPropagationPackage.eNS_URI);

		// Obtain or create and register package
		ThreatsPropagationPackageImpl theThreatsPropagationPackage = (ThreatsPropagationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ThreatsPropagationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ThreatsPropagationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		MARTEPackage.eINSTANCE.eClass();
		MeasurementUnitsPackage.eINSTANCE.eClass();
		GRM_BasicTypesPackage.eINSTANCE.eClass();
		MARTE_DataTypesPackage.eINSTANCE.eClass();
		BasicNFP_TypesPackage.eINSTANCE.eClass();
		TimeTypesLibraryPackage.eINSTANCE.eClass();
		TimeLibraryPackage.eINSTANCE.eClass();
		RS_LibraryPackage.eINSTANCE.eClass();
		MARTE_PrimitivesTypesPackage.eINSTANCE.eClass();
		BasicNFP_TypesPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		chessmlprofilePackageImpl thechessmlprofilePackage = (chessmlprofilePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(chessmlprofilePackage.eNS_URI) instanceof chessmlprofilePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(chessmlprofilePackage.eNS_URI) : chessmlprofilePackage.eINSTANCE);
		CorePackageImpl theCorePackage = (CorePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) instanceof CorePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) : CorePackage.eINSTANCE);
		CHESSViewsPackageImpl theCHESSViewsPackage = (CHESSViewsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CHESSViewsPackage.eNS_URI) instanceof CHESSViewsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CHESSViewsPackage.eNS_URI) : CHESSViewsPackage.eINSTANCE);
		FailurePropagationPackageImpl theFailurePropagationPackage = (FailurePropagationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(FailurePropagationPackage.eNS_URI) instanceof FailurePropagationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(FailurePropagationPackage.eNS_URI) : FailurePropagationPackage.eINSTANCE);
		FailurePropagationDataTypesPackageImpl theFailurePropagationDataTypesPackage = (FailurePropagationDataTypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(FailurePropagationDataTypesPackage.eNS_URI) instanceof FailurePropagationDataTypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(FailurePropagationDataTypesPackage.eNS_URI) : FailurePropagationDataTypesPackage.eINSTANCE);
		DependableComponentPackageImpl theDependableComponentPackage = (DependableComponentPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DependableComponentPackage.eNS_URI) instanceof DependableComponentPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DependableComponentPackage.eNS_URI) : DependableComponentPackage.eINSTANCE);
		DataFlowCallGraphPackageImpl theDataFlowCallGraphPackage = (DataFlowCallGraphPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DataFlowCallGraphPackage.eNS_URI) instanceof DataFlowCallGraphPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DataFlowCallGraphPackage.eNS_URI) : DataFlowCallGraphPackage.eINSTANCE);
		StateBasedDataTypesPackageImpl theStateBasedDataTypesPackage = (StateBasedDataTypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StateBasedDataTypesPackage.eNS_URI) instanceof StateBasedDataTypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StateBasedDataTypesPackage.eNS_URI) : StateBasedDataTypesPackage.eINSTANCE);
		StateBasedComponentsPackageImpl theStateBasedComponentsPackage = (StateBasedComponentsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StateBasedComponentsPackage.eNS_URI) instanceof StateBasedComponentsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StateBasedComponentsPackage.eNS_URI) : StateBasedComponentsPackage.eINSTANCE);
		FaultTolerancePackageImpl theFaultTolerancePackage = (FaultTolerancePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(FaultTolerancePackage.eNS_URI) instanceof FaultTolerancePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(FaultTolerancePackage.eNS_URI) : FaultTolerancePackage.eINSTANCE);
		MaintenanceMonitoringPackageImpl theMaintenanceMonitoringPackage = (MaintenanceMonitoringPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MaintenanceMonitoringPackage.eNS_URI) instanceof MaintenanceMonitoringPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MaintenanceMonitoringPackage.eNS_URI) : MaintenanceMonitoringPackage.eINSTANCE);
		StateBasedAnalysisPackageImpl theStateBasedAnalysisPackage = (StateBasedAnalysisPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StateBasedAnalysisPackage.eNS_URI) instanceof StateBasedAnalysisPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StateBasedAnalysisPackage.eNS_URI) : StateBasedAnalysisPackage.eINSTANCE);
		FMEAPackageImpl theFMEAPackage = (FMEAPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(FMEAPackage.eNS_URI) instanceof FMEAPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(FMEAPackage.eNS_URI) : FMEAPackage.eINSTANCE);
		FMEADataTypesPackageImpl theFMEADataTypesPackage = (FMEADataTypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(FMEADataTypesPackage.eNS_URI) instanceof FMEADataTypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(FMEADataTypesPackage.eNS_URI) : FMEADataTypesPackage.eINSTANCE);
		MitigationMeansPackageImpl theMitigationMeansPackage = (MitigationMeansPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MitigationMeansPackage.eNS_URI) instanceof MitigationMeansPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MitigationMeansPackage.eNS_URI) : MitigationMeansPackage.eINSTANCE);
		TimingAnalysisPackageImpl theTimingAnalysisPackage = (TimingAnalysisPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TimingAnalysisPackage.eNS_URI) instanceof TimingAnalysisPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TimingAnalysisPackage.eNS_URI) : TimingAnalysisPackage.eINSTANCE);
		TimingConstraintsPackageImpl theTimingConstraintsPackage = (TimingConstraintsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TimingConstraintsPackage.eNS_URI) instanceof TimingConstraintsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TimingConstraintsPackage.eNS_URI) : TimingConstraintsPackage.eINSTANCE);
		HardwareBaselinePackageImpl theHardwareBaselinePackage = (HardwareBaselinePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(HardwareBaselinePackage.eNS_URI) instanceof HardwareBaselinePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(HardwareBaselinePackage.eNS_URI) : HardwareBaselinePackage.eINSTANCE);
		DeploymentConfAnalysisPackageImpl theDeploymentConfAnalysisPackage = (DeploymentConfAnalysisPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DeploymentConfAnalysisPackage.eNS_URI) instanceof DeploymentConfAnalysisPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DeploymentConfAnalysisPackage.eNS_URI) : DeploymentConfAnalysisPackage.eINSTANCE);
		RTComponentModelPackageImpl theRTComponentModelPackage = (RTComponentModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RTComponentModelPackage.eNS_URI) instanceof RTComponentModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RTComponentModelPackage.eNS_URI) : RTComponentModelPackage.eINSTANCE);
		RTDataTypesPackageImpl theRTDataTypesPackage = (RTDataTypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RTDataTypesPackage.eNS_URI) instanceof RTDataTypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RTDataTypesPackage.eNS_URI) : RTDataTypesPackage.eINSTANCE);
		ComponentModelPackageImpl theComponentModelPackage = (ComponentModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ComponentModelPackage.eNS_URI) instanceof ComponentModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ComponentModelPackage.eNS_URI) : ComponentModelPackage.eINSTANCE);
		STSPackageImpl theSTSPackage = (STSPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(STSPackage.eNS_URI) instanceof STSPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(STSPackage.eNS_URI) : STSPackage.eINSTANCE);
		SafetyPackageImpl theSafetyPackage = (SafetyPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SafetyPackage.eNS_URI) instanceof SafetyPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SafetyPackage.eNS_URI) : SafetyPackage.eINSTANCE);

		// Create package meta-data objects
		theThreatsPropagationPackage.createPackageContents();
		thechessmlprofilePackage.createPackageContents();
		theCorePackage.createPackageContents();
		theCHESSViewsPackage.createPackageContents();
		theFailurePropagationPackage.createPackageContents();
		theFailurePropagationDataTypesPackage.createPackageContents();
		theDependableComponentPackage.createPackageContents();
		theDataFlowCallGraphPackage.createPackageContents();
		theStateBasedDataTypesPackage.createPackageContents();
		theStateBasedComponentsPackage.createPackageContents();
		theFaultTolerancePackage.createPackageContents();
		theMaintenanceMonitoringPackage.createPackageContents();
		theStateBasedAnalysisPackage.createPackageContents();
		theFMEAPackage.createPackageContents();
		theFMEADataTypesPackage.createPackageContents();
		theMitigationMeansPackage.createPackageContents();
		theTimingAnalysisPackage.createPackageContents();
		theTimingConstraintsPackage.createPackageContents();
		theHardwareBaselinePackage.createPackageContents();
		theDeploymentConfAnalysisPackage.createPackageContents();
		theRTComponentModelPackage.createPackageContents();
		theRTDataTypesPackage.createPackageContents();
		theComponentModelPackage.createPackageContents();
		theSTSPackage.createPackageContents();
		theSafetyPackage.createPackageContents();

		// Initialize created meta-data
		theThreatsPropagationPackage.initializePackageContents();
		thechessmlprofilePackage.initializePackageContents();
		theCorePackage.initializePackageContents();
		theCHESSViewsPackage.initializePackageContents();
		theFailurePropagationPackage.initializePackageContents();
		theFailurePropagationDataTypesPackage.initializePackageContents();
		theDependableComponentPackage.initializePackageContents();
		theDataFlowCallGraphPackage.initializePackageContents();
		theStateBasedDataTypesPackage.initializePackageContents();
		theStateBasedComponentsPackage.initializePackageContents();
		theFaultTolerancePackage.initializePackageContents();
		theMaintenanceMonitoringPackage.initializePackageContents();
		theStateBasedAnalysisPackage.initializePackageContents();
		theFMEAPackage.initializePackageContents();
		theFMEADataTypesPackage.initializePackageContents();
		theMitigationMeansPackage.initializePackageContents();
		theTimingAnalysisPackage.initializePackageContents();
		theTimingConstraintsPackage.initializePackageContents();
		theHardwareBaselinePackage.initializePackageContents();
		theDeploymentConfAnalysisPackage.initializePackageContents();
		theRTComponentModelPackage.initializePackageContents();
		theRTDataTypesPackage.initializePackageContents();
		theComponentModelPackage.initializePackageContents();
		theSTSPackage.initializePackageContents();
		theSafetyPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theThreatsPropagationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ThreatsPropagationPackage.eNS_URI, theThreatsPropagationPackage);
		return theThreatsPropagationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInternalFault() {
		return internalFaultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInternalFault_Occurrence() {
		return (EAttribute)internalFaultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInternalPropagation() {
		return internalPropagationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExternalFault() {
		return externalFaultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExternalFault_Failure() {
		return (EReference)externalFaultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNormalInput() {
		return normalInputEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNormalInput_Recovery() {
		return (EReference)normalInputEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRecoveryEvent() {
		return recoveryEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRecoveryEvent_Kind() {
		return (EAttribute)recoveryEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNormalOutput() {
		return normalOutputEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNormalOutput_Recovery() {
		return (EReference)normalOutputEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFailure() {
		return failureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFailure_Failure() {
		return (EReference)failureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNormalEvent() {
		return normalEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInternalThreat() {
		return internalThreatEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getError() {
		return errorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getError_Type() {
		return (EAttribute)errorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getError_VanishingTime() {
		return (EAttribute)errorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThreatState() {
		return threatStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThreatState_Base_State() {
		return (EReference)threatStateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThreatState_Probability() {
		return (EAttribute)threatStateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThreatState_Unit() {
		return (EAttribute)threatStateEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getErrorFree() {
		return errorFreeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnclassifiedError() {
		return unclassifiedErrorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFailureMode() {
		return failureModeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFailureMode_AffectedPorts() {
		return (EReference)failureModeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFailureMode_Type() {
		return (EAttribute)failureModeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDegradedState() {
		return degradedStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFailureFree() {
		return failureFreeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCHInternalFault() {
		return chInternalFaultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCHInternalFault_Base_Transition() {
		return (EReference)chInternalFaultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCHInternalFault_PermanentProb() {
		return (EAttribute)chInternalFaultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCHInternalFault_TransfFunct() {
		return (EAttribute)chInternalFaultEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCHInternalFault_Property() {
		return (EReference)chInternalFaultEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCHInternalFault_ChildFailure() {
		return (EReference)chInternalFaultEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCHInternalFault_Occurrence() {
		return (EAttribute)chInternalFaultEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCHInternalFault_TransientDuration() {
		return (EAttribute)chInternalFaultEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCHExternalFault() {
		return chExternalFaultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCHExternalFault_Base_Transition() {
		return (EReference)chExternalFaultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCHExternalFault_FromPort() {
		return (EReference)chExternalFaultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCHExternalFault_PropagationCondition() {
		return (EAttribute)chExternalFaultEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCHExternalFault_Probability() {
		return (EAttribute)chExternalFaultEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCHExternalFault_Unit() {
		return (EAttribute)chExternalFaultEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCHExternalFault_Type() {
		return (EAttribute)chExternalFaultEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCHExternalFault_TransfFunct() {
		return (EAttribute)chExternalFaultEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnclassifiedFailure() {
		return unclassifiedFailureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStuckAt() {
		return stuckAtEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStuckAt_Property() {
		return (EReference)stuckAtEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStuckAt_Value() {
		return (EAttribute)stuckAtEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStuckAt_Base_State() {
		return (EReference)stuckAtEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStuckAtFixed() {
		return stuckAtFixedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStuckAtFixed_Base_State() {
		return (EReference)stuckAtFixedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStuckAtFixed_Property() {
		return (EReference)stuckAtFixedEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInverted() {
		return invertedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInverted_Base_State() {
		return (EReference)invertedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInverted_Property() {
		return (EReference)invertedEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRampDown() {
		return rampDownEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRampDown_Base_State() {
		return (EReference)rampDownEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRampDown_Property() {
		return (EReference)rampDownEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRampDown_Decr() {
		return (EAttribute)rampDownEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRampDown_EndValue() {
		return (EAttribute)rampDownEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInputEvent() {
		return inputEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInputEvent_Port() {
		return (EReference)inputEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDepEvent() {
		return depEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDepEvent_Base_Event() {
		return (EReference)depEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDepEvent_Base_State() {
		return (EReference)depEventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutputEvent() {
		return outputEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutputEvent_Port() {
		return (EReference)outputEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInternalEvent() {
		return internalEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInternalEvent_Delay() {
		return (EAttribute)internalEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInternalEvent_Probability() {
		return (EAttribute)internalEventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getErrorModel() {
		return errorModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getErrorModel_Base_StateMachine() {
		return (EReference)errorModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDurationType() {
		return durationTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRecoveryKind() {
		return recoveryKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThreatsPropagationFactory getThreatsPropagationFactory() {
		return (ThreatsPropagationFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		unclassifiedFailureEClass = createEClass(UNCLASSIFIED_FAILURE);

		threatStateEClass = createEClass(THREAT_STATE);
		createEReference(threatStateEClass, THREAT_STATE__BASE_STATE);
		createEAttribute(threatStateEClass, THREAT_STATE__PROBABILITY);
		createEAttribute(threatStateEClass, THREAT_STATE__UNIT);

		failureModeEClass = createEClass(FAILURE_MODE);
		createEReference(failureModeEClass, FAILURE_MODE__AFFECTED_PORTS);
		createEAttribute(failureModeEClass, FAILURE_MODE__TYPE);

		degradedStateEClass = createEClass(DEGRADED_STATE);

		unclassifiedErrorEClass = createEClass(UNCLASSIFIED_ERROR);

		failureFreeEClass = createEClass(FAILURE_FREE);

		chInternalFaultEClass = createEClass(CH_INTERNAL_FAULT);
		createEReference(chInternalFaultEClass, CH_INTERNAL_FAULT__BASE_TRANSITION);
		createEAttribute(chInternalFaultEClass, CH_INTERNAL_FAULT__PERMANENT_PROB);
		createEAttribute(chInternalFaultEClass, CH_INTERNAL_FAULT__TRANSF_FUNCT);
		createEReference(chInternalFaultEClass, CH_INTERNAL_FAULT__PROPERTY);
		createEReference(chInternalFaultEClass, CH_INTERNAL_FAULT__CHILD_FAILURE);
		createEAttribute(chInternalFaultEClass, CH_INTERNAL_FAULT__OCCURRENCE);
		createEAttribute(chInternalFaultEClass, CH_INTERNAL_FAULT__TRANSIENT_DURATION);

		chExternalFaultEClass = createEClass(CH_EXTERNAL_FAULT);
		createEReference(chExternalFaultEClass, CH_EXTERNAL_FAULT__BASE_TRANSITION);
		createEReference(chExternalFaultEClass, CH_EXTERNAL_FAULT__FROM_PORT);
		createEAttribute(chExternalFaultEClass, CH_EXTERNAL_FAULT__PROPAGATION_CONDITION);
		createEAttribute(chExternalFaultEClass, CH_EXTERNAL_FAULT__PROBABILITY);
		createEAttribute(chExternalFaultEClass, CH_EXTERNAL_FAULT__UNIT);
		createEAttribute(chExternalFaultEClass, CH_EXTERNAL_FAULT__TYPE);
		createEAttribute(chExternalFaultEClass, CH_EXTERNAL_FAULT__TRANSF_FUNCT);

		errorEClass = createEClass(ERROR);
		createEAttribute(errorEClass, ERROR__TYPE);
		createEAttribute(errorEClass, ERROR__VANISHING_TIME);

		errorFreeEClass = createEClass(ERROR_FREE);

		stuckAtEClass = createEClass(STUCK_AT);
		createEReference(stuckAtEClass, STUCK_AT__PROPERTY);
		createEAttribute(stuckAtEClass, STUCK_AT__VALUE);
		createEReference(stuckAtEClass, STUCK_AT__BASE_STATE);

		stuckAtFixedEClass = createEClass(STUCK_AT_FIXED);
		createEReference(stuckAtFixedEClass, STUCK_AT_FIXED__BASE_STATE);
		createEReference(stuckAtFixedEClass, STUCK_AT_FIXED__PROPERTY);

		invertedEClass = createEClass(INVERTED);
		createEReference(invertedEClass, INVERTED__BASE_STATE);
		createEReference(invertedEClass, INVERTED__PROPERTY);

		rampDownEClass = createEClass(RAMP_DOWN);
		createEReference(rampDownEClass, RAMP_DOWN__BASE_STATE);
		createEReference(rampDownEClass, RAMP_DOWN__PROPERTY);
		createEAttribute(rampDownEClass, RAMP_DOWN__DECR);
		createEAttribute(rampDownEClass, RAMP_DOWN__END_VALUE);

		inputEventEClass = createEClass(INPUT_EVENT);
		createEReference(inputEventEClass, INPUT_EVENT__PORT);

		depEventEClass = createEClass(DEP_EVENT);
		createEReference(depEventEClass, DEP_EVENT__BASE_EVENT);
		createEReference(depEventEClass, DEP_EVENT__BASE_STATE);

		outputEventEClass = createEClass(OUTPUT_EVENT);
		createEReference(outputEventEClass, OUTPUT_EVENT__PORT);

		internalEventEClass = createEClass(INTERNAL_EVENT);
		createEAttribute(internalEventEClass, INTERNAL_EVENT__DELAY);
		createEAttribute(internalEventEClass, INTERNAL_EVENT__PROBABILITY);

		externalFaultEClass = createEClass(EXTERNAL_FAULT);
		createEReference(externalFaultEClass, EXTERNAL_FAULT__FAILURE);

		normalInputEClass = createEClass(NORMAL_INPUT);
		createEReference(normalInputEClass, NORMAL_INPUT__RECOVERY);

		recoveryEventEClass = createEClass(RECOVERY_EVENT);
		createEAttribute(recoveryEventEClass, RECOVERY_EVENT__KIND);

		normalOutputEClass = createEClass(NORMAL_OUTPUT);
		createEReference(normalOutputEClass, NORMAL_OUTPUT__RECOVERY);

		failureEClass = createEClass(FAILURE);
		createEReference(failureEClass, FAILURE__FAILURE);

		normalEventEClass = createEClass(NORMAL_EVENT);

		internalThreatEClass = createEClass(INTERNAL_THREAT);

		internalFaultEClass = createEClass(INTERNAL_FAULT);
		createEAttribute(internalFaultEClass, INTERNAL_FAULT__OCCURRENCE);

		internalPropagationEClass = createEClass(INTERNAL_PROPAGATION);

		errorModelEClass = createEClass(ERROR_MODEL);
		createEReference(errorModelEClass, ERROR_MODEL__BASE_STATE_MACHINE);

		// Create enums
		durationTypeEEnum = createEEnum(DURATION_TYPE);
		recoveryKindEEnum = createEEnum(RECOVERY_KIND);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		UMLPackage theUMLPackage = (UMLPackage)EPackage.Registry.INSTANCE.getEPackage(UMLPackage.eNS_URI);
		BasicNFP_TypesPackage theBasicNFP_TypesPackage = (BasicNFP_TypesPackage)EPackage.Registry.INSTANCE.getEPackage(BasicNFP_TypesPackage.eNS_URI);
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
		DependableComponentPackage theDependableComponentPackage = (DependableComponentPackage)EPackage.Registry.INSTANCE.getEPackage(DependableComponentPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		unclassifiedFailureEClass.getESuperTypes().add(this.getThreatState());
		failureModeEClass.getESuperTypes().add(this.getThreatState());
		degradedStateEClass.getESuperTypes().add(this.getThreatState());
		unclassifiedErrorEClass.getESuperTypes().add(this.getThreatState());
		failureFreeEClass.getESuperTypes().add(this.getThreatState());
		errorEClass.getESuperTypes().add(this.getThreatState());
		errorFreeEClass.getESuperTypes().add(this.getThreatState());
		inputEventEClass.getESuperTypes().add(this.getDepEvent());
		outputEventEClass.getESuperTypes().add(this.getDepEvent());
		internalEventEClass.getESuperTypes().add(this.getDepEvent());
		externalFaultEClass.getESuperTypes().add(this.getInputEvent());
		normalInputEClass.getESuperTypes().add(this.getInputEvent());
		recoveryEventEClass.getESuperTypes().add(this.getInternalEvent());
		normalOutputEClass.getESuperTypes().add(this.getOutputEvent());
		failureEClass.getESuperTypes().add(this.getOutputEvent());
		normalEventEClass.getESuperTypes().add(this.getInternalEvent());
		internalThreatEClass.getESuperTypes().add(this.getInternalEvent());
		internalFaultEClass.getESuperTypes().add(this.getInternalThreat());
		internalPropagationEClass.getESuperTypes().add(this.getInternalThreat());

		// Initialize classes and features; add operations and parameters
		initEClass(unclassifiedFailureEClass, UnclassifiedFailure.class, "UnclassifiedFailure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(threatStateEClass, ThreatState.class, "ThreatState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getThreatState_Base_State(), theUMLPackage.getState(), null, "base_State", null, 1, 1, ThreatState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getThreatState_Probability(), theBasicNFP_TypesPackage.getNFP_Real(), "probability", null, 1, 1, ThreatState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getThreatState_Unit(), theTypesPackage.getString(), "unit", null, 0, 1, ThreatState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(failureModeEClass, FailureMode.class, "FailureMode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFailureMode_AffectedPorts(), theUMLPackage.getPort(), null, "affectedPorts", null, 0, -1, FailureMode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFailureMode_Type(), this.getDurationType(), "type", null, 1, 1, FailureMode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(degradedStateEClass, DegradedState.class, "DegradedState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(unclassifiedErrorEClass, UnclassifiedError.class, "UnclassifiedError", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(failureFreeEClass, FailureFree.class, "FailureFree", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(chInternalFaultEClass, CHInternalFault.class, "CHInternalFault", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCHInternalFault_Base_Transition(), theUMLPackage.getTransition(), null, "base_Transition", null, 1, 1, CHInternalFault.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCHInternalFault_PermanentProb(), theBasicNFP_TypesPackage.getNFP_Real(), "permanentProb", null, 1, 1, CHInternalFault.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCHInternalFault_TransfFunct(), theTypesPackage.getString(), "transfFunct", null, 0, 1, CHInternalFault.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCHInternalFault_Property(), theUMLPackage.getProperty(), null, "property", null, 0, 1, CHInternalFault.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCHInternalFault_ChildFailure(), theUMLPackage.getState(), null, "childFailure", null, 0, 1, CHInternalFault.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCHInternalFault_Occurrence(), theTypesPackage.getString(), "occurrence", null, 0, 1, CHInternalFault.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCHInternalFault_TransientDuration(), theTypesPackage.getString(), "transientDuration", null, 0, 1, CHInternalFault.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(chExternalFaultEClass, CHExternalFault.class, "CHExternalFault", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCHExternalFault_Base_Transition(), theUMLPackage.getTransition(), null, "base_Transition", null, 1, 1, CHExternalFault.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCHExternalFault_FromPort(), theUMLPackage.getPort(), null, "fromPort", null, 1, -1, CHExternalFault.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCHExternalFault_PropagationCondition(), theTypesPackage.getString(), "propagationCondition", null, 0, 1, CHExternalFault.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCHExternalFault_Probability(), theBasicNFP_TypesPackage.getNFP_Real(), "probability", null, 1, 1, CHExternalFault.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCHExternalFault_Unit(), theTypesPackage.getString(), "unit", null, 0, 1, CHExternalFault.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCHExternalFault_Type(), this.getDurationType(), "type", null, 1, 1, CHExternalFault.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCHExternalFault_TransfFunct(), theTypesPackage.getString(), "transfFunct", null, 0, -1, CHExternalFault.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(errorEClass, org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Error.class, "Error", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getError_Type(), this.getDurationType(), "type", null, 1, 1, org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Error.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getError_VanishingTime(), theTypesPackage.getString(), "vanishingTime", null, 0, 1, org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Error.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(errorFreeEClass, ErrorFree.class, "ErrorFree", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stuckAtEClass, StuckAt.class, "StuckAt", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStuckAt_Property(), theUMLPackage.getProperty(), null, "property", null, 1, 1, StuckAt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStuckAt_Value(), theTypesPackage.getString(), "value", null, 1, 1, StuckAt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getStuckAt_Base_State(), theUMLPackage.getState(), null, "base_State", null, 1, 1, StuckAt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(stuckAtFixedEClass, StuckAtFixed.class, "StuckAtFixed", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStuckAtFixed_Base_State(), theUMLPackage.getState(), null, "base_State", null, 1, 1, StuckAtFixed.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getStuckAtFixed_Property(), theUMLPackage.getProperty(), null, "property", null, 1, 1, StuckAtFixed.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(invertedEClass, Inverted.class, "Inverted", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInverted_Base_State(), theUMLPackage.getState(), null, "base_State", null, 1, 1, Inverted.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getInverted_Property(), theUMLPackage.getProperty(), null, "property", null, 1, 1, Inverted.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(rampDownEClass, RampDown.class, "RampDown", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRampDown_Base_State(), theUMLPackage.getState(), null, "base_State", null, 1, 1, RampDown.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRampDown_Property(), theUMLPackage.getProperty(), null, "property", null, 1, 1, RampDown.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRampDown_Decr(), theTypesPackage.getString(), "decr", null, 1, 1, RampDown.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRampDown_EndValue(), theTypesPackage.getString(), "endValue", null, 1, 1, RampDown.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(inputEventEClass, InputEvent.class, "InputEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInputEvent_Port(), theUMLPackage.getProperty(), null, "port", null, 0, 1, InputEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(depEventEClass, DepEvent.class, "DepEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDepEvent_Base_Event(), theUMLPackage.getEvent(), null, "base_Event", null, 1, 1, DepEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDepEvent_Base_State(), theUMLPackage.getState(), null, "base_State", null, 1, 1, DepEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(outputEventEClass, OutputEvent.class, "OutputEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOutputEvent_Port(), theUMLPackage.getProperty(), null, "port", null, 0, 1, OutputEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(internalEventEClass, InternalEvent.class, "InternalEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInternalEvent_Delay(), theBasicNFP_TypesPackage.getNFP_Real(), "delay", null, 1, 1, InternalEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getInternalEvent_Probability(), theBasicNFP_TypesPackage.getNFP_Real(), "probability", null, 1, 1, InternalEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(externalFaultEClass, ExternalFault.class, "ExternalFault", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExternalFault_Failure(), theDependableComponentPackage.getFailureMode(), null, "failure", null, 1, 1, ExternalFault.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(normalInputEClass, NormalInput.class, "NormalInput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNormalInput_Recovery(), this.getRecoveryEvent(), null, "recovery", null, 0, 1, NormalInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(recoveryEventEClass, RecoveryEvent.class, "RecoveryEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRecoveryEvent_Kind(), this.getRecoveryKind(), "kind", null, 0, 1, RecoveryEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(normalOutputEClass, NormalOutput.class, "NormalOutput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNormalOutput_Recovery(), this.getRecoveryEvent(), null, "recovery", null, 0, 1, NormalOutput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(failureEClass, Failure.class, "Failure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFailure_Failure(), theDependableComponentPackage.getFailureMode(), null, "failure", null, 0, 1, Failure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(normalEventEClass, NormalEvent.class, "NormalEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(internalThreatEClass, InternalThreat.class, "InternalThreat", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(internalFaultEClass, InternalFault.class, "InternalFault", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInternalFault_Occurrence(), theBasicNFP_TypesPackage.getNFP_Real(), "Occurrence", null, 1, 1, InternalFault.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(internalPropagationEClass, InternalPropagation.class, "InternalPropagation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(errorModelEClass, ErrorModel.class, "ErrorModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getErrorModel_Base_StateMachine(), theUMLPackage.getStateMachine(), null, "base_StateMachine", null, 1, 1, ErrorModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(durationTypeEEnum, DurationType.class, "DurationType");
		addEEnumLiteral(durationTypeEEnum, DurationType.TRANSIENT);
		addEEnumLiteral(durationTypeEEnum, DurationType.PERMANENT);

		initEEnum(recoveryKindEEnum, RecoveryKind.class, "RecoveryKind");
		addEEnumLiteral(recoveryKindEEnum, RecoveryKind.REPAIR);
		addEEnumLiteral(recoveryKindEEnum, RecoveryKind.COMPENSATION);
		addEEnumLiteral(recoveryKindEEnum, RecoveryKind.ERROR_DETECTION);
		addEEnumLiteral(recoveryKindEEnum, RecoveryKind.RECONFIGURATION);
	}

} //ThreatsPropagationPackageImpl
