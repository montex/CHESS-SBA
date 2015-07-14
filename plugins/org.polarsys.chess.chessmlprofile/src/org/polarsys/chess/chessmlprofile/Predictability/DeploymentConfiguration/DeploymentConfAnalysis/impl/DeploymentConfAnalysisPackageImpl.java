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
package org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.papyrus.MARTE.MARTEPackage;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SAMPackage;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwCommunicationPackage;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AllocPackage;
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
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatsPropagationPackage;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.ThreatsPropagationPackageImpl;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.BusConfigurationAnalysis;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.DeploymentConfAnalysisFactory;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.DeploymentConfAnalysisPackage;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.MappingConfigurationAnalysis;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.OptimizationGoal;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.SchedulingAnalysis;
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
public class DeploymentConfAnalysisPackageImpl extends EPackageImpl implements DeploymentConfAnalysisPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingConfigurationAnalysisEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass schedulingAnalysisEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass busConfigurationAnalysisEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum optimizationGoalEEnum = null;

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
	 * @see org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.DeploymentConfAnalysisPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DeploymentConfAnalysisPackageImpl() {
		super(eNS_URI, DeploymentConfAnalysisFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link DeploymentConfAnalysisPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DeploymentConfAnalysisPackage init() {
		if (isInited) return (DeploymentConfAnalysisPackage)EPackage.Registry.INSTANCE.getEPackage(DeploymentConfAnalysisPackage.eNS_URI);

		// Obtain or create and register package
		DeploymentConfAnalysisPackageImpl theDeploymentConfAnalysisPackage = (DeploymentConfAnalysisPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DeploymentConfAnalysisPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DeploymentConfAnalysisPackageImpl());

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
		ThreatsPropagationPackageImpl theThreatsPropagationPackage = (ThreatsPropagationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ThreatsPropagationPackage.eNS_URI) instanceof ThreatsPropagationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ThreatsPropagationPackage.eNS_URI) : ThreatsPropagationPackage.eINSTANCE);
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
		RTComponentModelPackageImpl theRTComponentModelPackage = (RTComponentModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RTComponentModelPackage.eNS_URI) instanceof RTComponentModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RTComponentModelPackage.eNS_URI) : RTComponentModelPackage.eINSTANCE);
		RTDataTypesPackageImpl theRTDataTypesPackage = (RTDataTypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RTDataTypesPackage.eNS_URI) instanceof RTDataTypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RTDataTypesPackage.eNS_URI) : RTDataTypesPackage.eINSTANCE);
		ComponentModelPackageImpl theComponentModelPackage = (ComponentModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ComponentModelPackage.eNS_URI) instanceof ComponentModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ComponentModelPackage.eNS_URI) : ComponentModelPackage.eINSTANCE);
		STSPackageImpl theSTSPackage = (STSPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(STSPackage.eNS_URI) instanceof STSPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(STSPackage.eNS_URI) : STSPackage.eINSTANCE);
		SafetyPackageImpl theSafetyPackage = (SafetyPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SafetyPackage.eNS_URI) instanceof SafetyPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SafetyPackage.eNS_URI) : SafetyPackage.eINSTANCE);

		// Create package meta-data objects
		theDeploymentConfAnalysisPackage.createPackageContents();
		thechessmlprofilePackage.createPackageContents();
		theCorePackage.createPackageContents();
		theCHESSViewsPackage.createPackageContents();
		theFailurePropagationPackage.createPackageContents();
		theFailurePropagationDataTypesPackage.createPackageContents();
		theDependableComponentPackage.createPackageContents();
		theThreatsPropagationPackage.createPackageContents();
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
		theRTComponentModelPackage.createPackageContents();
		theRTDataTypesPackage.createPackageContents();
		theComponentModelPackage.createPackageContents();
		theSTSPackage.createPackageContents();
		theSafetyPackage.createPackageContents();

		// Initialize created meta-data
		theDeploymentConfAnalysisPackage.initializePackageContents();
		thechessmlprofilePackage.initializePackageContents();
		theCorePackage.initializePackageContents();
		theCHESSViewsPackage.initializePackageContents();
		theFailurePropagationPackage.initializePackageContents();
		theFailurePropagationDataTypesPackage.initializePackageContents();
		theDependableComponentPackage.initializePackageContents();
		theThreatsPropagationPackage.initializePackageContents();
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
		theRTComponentModelPackage.initializePackageContents();
		theRTDataTypesPackage.initializePackageContents();
		theComponentModelPackage.initializePackageContents();
		theSTSPackage.initializePackageContents();
		theSafetyPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDeploymentConfAnalysisPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DeploymentConfAnalysisPackage.eNS_URI, theDeploymentConfAnalysisPackage);
		return theDeploymentConfAnalysisPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingConfigurationAnalysis() {
		return mappingConfigurationAnalysisEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingConfigurationAnalysis_ProhibitedAllocations() {
		return (EReference)mappingConfigurationAnalysisEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingConfigurationAnalysis_FixedAllocations() {
		return (EReference)mappingConfigurationAnalysisEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappingConfigurationAnalysis_BottomUpAnalysis() {
		return (EAttribute)mappingConfigurationAnalysisEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingConfigurationAnalysis_ResultingMapping() {
		return (EReference)mappingConfigurationAnalysisEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSchedulingAnalysis() {
		return schedulingAnalysisEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSchedulingAnalysis_Mapping() {
		return (EReference)schedulingAnalysisEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSchedulingAnalysis_ResultingPriorities() {
		return (EReference)schedulingAnalysisEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSchedulingAnalysis_SchedulingStrategy() {
		return (EAttribute)schedulingAnalysisEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBusConfigurationAnalysis() {
		return busConfigurationAnalysisEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBusConfigurationAnalysis_ResultingBusConfig() {
		return (EReference)busConfigurationAnalysisEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBusConfigurationAnalysis_ResultingCommLatencies() {
		return (EReference)busConfigurationAnalysisEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBusConfigurationAnalysis_InputFibex() {
		return (EReference)busConfigurationAnalysisEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBusConfigurationAnalysis_HwBusPlatform() {
		return (EReference)busConfigurationAnalysisEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getOptimizationGoal() {
		return optimizationGoalEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeploymentConfAnalysisFactory getDeploymentConfAnalysisFactory() {
		return (DeploymentConfAnalysisFactory)getEFactoryInstance();
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
		mappingConfigurationAnalysisEClass = createEClass(MAPPING_CONFIGURATION_ANALYSIS);
		createEReference(mappingConfigurationAnalysisEClass, MAPPING_CONFIGURATION_ANALYSIS__PROHIBITED_ALLOCATIONS);
		createEReference(mappingConfigurationAnalysisEClass, MAPPING_CONFIGURATION_ANALYSIS__FIXED_ALLOCATIONS);
		createEAttribute(mappingConfigurationAnalysisEClass, MAPPING_CONFIGURATION_ANALYSIS__BOTTOM_UP_ANALYSIS);
		createEReference(mappingConfigurationAnalysisEClass, MAPPING_CONFIGURATION_ANALYSIS__RESULTING_MAPPING);

		schedulingAnalysisEClass = createEClass(SCHEDULING_ANALYSIS);
		createEReference(schedulingAnalysisEClass, SCHEDULING_ANALYSIS__MAPPING);
		createEReference(schedulingAnalysisEClass, SCHEDULING_ANALYSIS__RESULTING_PRIORITIES);
		createEAttribute(schedulingAnalysisEClass, SCHEDULING_ANALYSIS__SCHEDULING_STRATEGY);

		busConfigurationAnalysisEClass = createEClass(BUS_CONFIGURATION_ANALYSIS);
		createEReference(busConfigurationAnalysisEClass, BUS_CONFIGURATION_ANALYSIS__RESULTING_BUS_CONFIG);
		createEReference(busConfigurationAnalysisEClass, BUS_CONFIGURATION_ANALYSIS__RESULTING_COMM_LATENCIES);
		createEReference(busConfigurationAnalysisEClass, BUS_CONFIGURATION_ANALYSIS__INPUT_FIBEX);
		createEReference(busConfigurationAnalysisEClass, BUS_CONFIGURATION_ANALYSIS__HW_BUS_PLATFORM);

		// Create enums
		optimizationGoalEEnum = createEEnum(OPTIMIZATION_GOAL);
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
		GQAMPackage theGQAMPackage = (GQAMPackage)EPackage.Registry.INSTANCE.getEPackage(GQAMPackage.eNS_URI);
		AllocPackage theAllocPackage = (AllocPackage)EPackage.Registry.INSTANCE.getEPackage(AllocPackage.eNS_URI);
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
		RTComponentModelPackage theRTComponentModelPackage = (RTComponentModelPackage)EPackage.Registry.INSTANCE.getEPackage(RTComponentModelPackage.eNS_URI);
		FMEAPackage theFMEAPackage = (FMEAPackage)EPackage.Registry.INSTANCE.getEPackage(FMEAPackage.eNS_URI);
		SAMPackage theSAMPackage = (SAMPackage)EPackage.Registry.INSTANCE.getEPackage(SAMPackage.eNS_URI);
		HwCommunicationPackage theHwCommunicationPackage = (HwCommunicationPackage)EPackage.Registry.INSTANCE.getEPackage(HwCommunicationPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		mappingConfigurationAnalysisEClass.getESuperTypes().add(theGQAMPackage.getGaAnalysisContext());
		schedulingAnalysisEClass.getESuperTypes().add(theGQAMPackage.getGaAnalysisContext());
		busConfigurationAnalysisEClass.getESuperTypes().add(theGQAMPackage.getGaAnalysisContext());

		// Initialize classes and features; add operations and parameters
		initEClass(mappingConfigurationAnalysisEClass, MappingConfigurationAnalysis.class, "MappingConfigurationAnalysis", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingConfigurationAnalysis_ProhibitedAllocations(), theAllocPackage.getAssign(), null, "prohibitedAllocations", null, 0, -1, MappingConfigurationAnalysis.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMappingConfigurationAnalysis_FixedAllocations(), theAllocPackage.getAssign(), null, "fixedAllocations", null, 0, -1, MappingConfigurationAnalysis.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMappingConfigurationAnalysis_BottomUpAnalysis(), theTypesPackage.getBoolean(), "bottomUpAnalysis", null, 1, 1, MappingConfigurationAnalysis.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMappingConfigurationAnalysis_ResultingMapping(), theAllocPackage.getAssign(), null, "resultingMapping", null, 1, -1, MappingConfigurationAnalysis.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(schedulingAnalysisEClass, SchedulingAnalysis.class, "SchedulingAnalysis", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSchedulingAnalysis_Mapping(), theAllocPackage.getAssign(), null, "mapping", null, 0, -1, SchedulingAnalysis.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSchedulingAnalysis_ResultingPriorities(), theRTComponentModelPackage.getCHRtSpecification(), null, "resultingPriorities", null, 1, -1, SchedulingAnalysis.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getSchedulingAnalysis_SchedulingStrategy(), theTypesPackage.getString(), "schedulingStrategy", null, 0, -1, SchedulingAnalysis.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(busConfigurationAnalysisEClass, BusConfigurationAnalysis.class, "BusConfigurationAnalysis", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBusConfigurationAnalysis_ResultingBusConfig(), theFMEAPackage.getFIBEX(), null, "resultingBusConfig", null, 1, 1, BusConfigurationAnalysis.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getBusConfigurationAnalysis_ResultingCommLatencies(), theSAMPackage.getSaStep(), null, "resultingCommLatencies", null, 0, -1, BusConfigurationAnalysis.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getBusConfigurationAnalysis_InputFibex(), theFMEAPackage.getFIBEX(), null, "inputFibex", null, 0, -1, BusConfigurationAnalysis.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getBusConfigurationAnalysis_HwBusPlatform(), theHwCommunicationPackage.getHwBus(), null, "hwBusPlatform", null, 0, -1, BusConfigurationAnalysis.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(optimizationGoalEEnum, OptimizationGoal.class, "OptimizationGoal");
		addEEnumLiteral(optimizationGoalEEnum, OptimizationGoal.AVERAGE);
		addEEnumLiteral(optimizationGoalEEnum, OptimizationGoal.MAX_HIGH_PERF_USAGE);
	}

} //DeploymentConfAnalysisPackageImpl
