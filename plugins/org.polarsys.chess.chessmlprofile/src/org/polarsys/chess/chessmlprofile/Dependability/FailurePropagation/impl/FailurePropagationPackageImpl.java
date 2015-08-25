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
package org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.papyrus.MARTE.MARTEPackage;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage;
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
import org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.ACIDAvoidable;
import org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.ACIDMitigation;
import org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FI4FAAnalysis;
import org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FI4FASpecification;
import org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FLABehavior;
import org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FPTCPortSlot;
import org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FPTCSpecification;
import org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationAnalysis;
import org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationFactory;
import org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationPackage;
import org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.FailurePropagationDataTypesPackage;
import org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.impl.FailurePropagationDataTypesPackageImpl;
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
public class FailurePropagationPackageImpl extends EPackageImpl implements FailurePropagationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fptcEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flaBehaviorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass failurePropagationAnalysisEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fptcSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fptcPortSlotEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fi4FAEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fi4FASpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass acidAvoidableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass acidMitigationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fi4FAAnalysisEClass = null;

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
	 * @see org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private FailurePropagationPackageImpl() {
		super(eNS_URI, FailurePropagationFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link FailurePropagationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static FailurePropagationPackage init() {
		if (isInited) return (FailurePropagationPackage)EPackage.Registry.INSTANCE.getEPackage(FailurePropagationPackage.eNS_URI);

		// Obtain or create and register package
		FailurePropagationPackageImpl theFailurePropagationPackage = (FailurePropagationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof FailurePropagationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new FailurePropagationPackageImpl());

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
		DeploymentConfAnalysisPackageImpl theDeploymentConfAnalysisPackage = (DeploymentConfAnalysisPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DeploymentConfAnalysisPackage.eNS_URI) instanceof DeploymentConfAnalysisPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DeploymentConfAnalysisPackage.eNS_URI) : DeploymentConfAnalysisPackage.eINSTANCE);
		RTComponentModelPackageImpl theRTComponentModelPackage = (RTComponentModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RTComponentModelPackage.eNS_URI) instanceof RTComponentModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RTComponentModelPackage.eNS_URI) : RTComponentModelPackage.eINSTANCE);
		RTDataTypesPackageImpl theRTDataTypesPackage = (RTDataTypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RTDataTypesPackage.eNS_URI) instanceof RTDataTypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RTDataTypesPackage.eNS_URI) : RTDataTypesPackage.eINSTANCE);
		ComponentModelPackageImpl theComponentModelPackage = (ComponentModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ComponentModelPackage.eNS_URI) instanceof ComponentModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ComponentModelPackage.eNS_URI) : ComponentModelPackage.eINSTANCE);
		STSPackageImpl theSTSPackage = (STSPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(STSPackage.eNS_URI) instanceof STSPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(STSPackage.eNS_URI) : STSPackage.eINSTANCE);
		SafetyPackageImpl theSafetyPackage = (SafetyPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SafetyPackage.eNS_URI) instanceof SafetyPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SafetyPackage.eNS_URI) : SafetyPackage.eINSTANCE);

		// Create package meta-data objects
		theFailurePropagationPackage.createPackageContents();
		thechessmlprofilePackage.createPackageContents();
		theCorePackage.createPackageContents();
		theCHESSViewsPackage.createPackageContents();
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
		theDeploymentConfAnalysisPackage.createPackageContents();
		theRTComponentModelPackage.createPackageContents();
		theRTDataTypesPackage.createPackageContents();
		theComponentModelPackage.createPackageContents();
		theSTSPackage.createPackageContents();
		theSafetyPackage.createPackageContents();

		// Initialize created meta-data
		theFailurePropagationPackage.initializePackageContents();
		thechessmlprofilePackage.initializePackageContents();
		theCorePackage.initializePackageContents();
		theCHESSViewsPackage.initializePackageContents();
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
		theDeploymentConfAnalysisPackage.initializePackageContents();
		theRTComponentModelPackage.initializePackageContents();
		theRTDataTypesPackage.initializePackageContents();
		theComponentModelPackage.initializePackageContents();
		theSTSPackage.initializePackageContents();
		theSafetyPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theFailurePropagationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(FailurePropagationPackage.eNS_URI, theFailurePropagationPackage);
		return theFailurePropagationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFPTC() {
		return fptcEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFPTC_Fptc() {
		return (EAttribute)fptcEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFPTC_Base_Comment() {
		return (EReference)fptcEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFPTC_Base_Connector() {
		return (EReference)fptcEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFLABehavior() {
		return flaBehaviorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFLABehavior_Base_Constraint() {
		return (EReference)flaBehaviorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFLABehavior_Base_Class() {
		return (EReference)flaBehaviorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFLABehavior_Fptc() {
		return (EAttribute)flaBehaviorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFLABehavior_Base_InstanceSpecification() {
		return (EReference)flaBehaviorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFLABehavior_Base_Property() {
		return (EReference)flaBehaviorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFLABehavior_Base_Connector() {
		return (EReference)flaBehaviorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFailurePropagationAnalysis() {
		return failurePropagationAnalysisEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFPTCSpecification() {
		return fptcSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFPTCSpecification_Base_Comment() {
		return (EReference)fptcSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFPTCSpecification_Failure() {
		return (EAttribute)fptcSpecificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFPTCSpecification_PartWithPort() {
		return (EReference)fptcSpecificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFPTCSpecification_FailureMode() {
		return (EReference)fptcSpecificationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFPTCPortSlot() {
		return fptcPortSlotEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFPTCPortSlot_FPTCSpecification() {
		return (EReference)fptcPortSlotEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFPTCPortSlot_Base_Slot() {
		return (EReference)fptcPortSlotEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFPTCPortSlot_Failure() {
		return (EAttribute)fptcPortSlotEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFI4FA() {
		return fi4FAEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFI4FA_Fi4fa() {
		return (EAttribute)fi4FAEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFI4FA_Base_Connector() {
		return (EReference)fi4FAEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFI4FASpecification() {
		return fi4FASpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getACIDAvoidable() {
		return acidAvoidableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getACIDAvoidable_A() {
		return (EAttribute)acidAvoidableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getACIDAvoidable_C() {
		return (EAttribute)acidAvoidableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getACIDAvoidable_Base_Comment() {
		return (EReference)acidAvoidableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getACIDAvoidable_I() {
		return (EAttribute)acidAvoidableEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getACIDAvoidable_D() {
		return (EAttribute)acidAvoidableEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getACIDMitigation() {
		return acidMitigationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getACIDMitigation_Base_Comment() {
		return (EReference)acidMitigationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getACIDMitigation_A() {
		return (EAttribute)acidMitigationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getACIDMitigation_C() {
		return (EAttribute)acidMitigationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getACIDMitigation_I() {
		return (EAttribute)acidMitigationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getACIDMitigation_D() {
		return (EAttribute)acidMitigationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFI4FAAnalysis() {
		return fi4FAAnalysisEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FailurePropagationFactory getFailurePropagationFactory() {
		return (FailurePropagationFactory)getEFactoryInstance();
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
		fptcSpecificationEClass = createEClass(FPTC_SPECIFICATION);
		createEReference(fptcSpecificationEClass, FPTC_SPECIFICATION__BASE_COMMENT);
		createEAttribute(fptcSpecificationEClass, FPTC_SPECIFICATION__FAILURE);
		createEReference(fptcSpecificationEClass, FPTC_SPECIFICATION__PART_WITH_PORT);
		createEReference(fptcSpecificationEClass, FPTC_SPECIFICATION__FAILURE_MODE);

		fptcPortSlotEClass = createEClass(FPTC_PORT_SLOT);
		createEReference(fptcPortSlotEClass, FPTC_PORT_SLOT__FPTC_SPECIFICATION);
		createEReference(fptcPortSlotEClass, FPTC_PORT_SLOT__BASE_SLOT);
		createEAttribute(fptcPortSlotEClass, FPTC_PORT_SLOT__FAILURE);

		fptcEClass = createEClass(FPTC);
		createEAttribute(fptcEClass, FPTC__FPTC);
		createEReference(fptcEClass, FPTC__BASE_COMMENT);
		createEReference(fptcEClass, FPTC__BASE_CONNECTOR);

		flaBehaviorEClass = createEClass(FLA_BEHAVIOR);
		createEReference(flaBehaviorEClass, FLA_BEHAVIOR__BASE_CONSTRAINT);
		createEReference(flaBehaviorEClass, FLA_BEHAVIOR__BASE_CLASS);
		createEAttribute(flaBehaviorEClass, FLA_BEHAVIOR__FPTC);
		createEReference(flaBehaviorEClass, FLA_BEHAVIOR__BASE_INSTANCE_SPECIFICATION);
		createEReference(flaBehaviorEClass, FLA_BEHAVIOR__BASE_PROPERTY);
		createEReference(flaBehaviorEClass, FLA_BEHAVIOR__BASE_CONNECTOR);

		failurePropagationAnalysisEClass = createEClass(FAILURE_PROPAGATION_ANALYSIS);

		fi4FAEClass = createEClass(FI4FA);
		createEAttribute(fi4FAEClass, FI4FA__FI4FA);
		createEReference(fi4FAEClass, FI4FA__BASE_CONNECTOR);

		fi4FASpecificationEClass = createEClass(FI4FA_SPECIFICATION);

		acidAvoidableEClass = createEClass(ACID_AVOIDABLE);
		createEAttribute(acidAvoidableEClass, ACID_AVOIDABLE__A);
		createEAttribute(acidAvoidableEClass, ACID_AVOIDABLE__C);
		createEReference(acidAvoidableEClass, ACID_AVOIDABLE__BASE_COMMENT);
		createEAttribute(acidAvoidableEClass, ACID_AVOIDABLE__I);
		createEAttribute(acidAvoidableEClass, ACID_AVOIDABLE__D);

		acidMitigationEClass = createEClass(ACID_MITIGATION);
		createEReference(acidMitigationEClass, ACID_MITIGATION__BASE_COMMENT);
		createEAttribute(acidMitigationEClass, ACID_MITIGATION__A);
		createEAttribute(acidMitigationEClass, ACID_MITIGATION__C);
		createEAttribute(acidMitigationEClass, ACID_MITIGATION__I);
		createEAttribute(acidMitigationEClass, ACID_MITIGATION__D);

		fi4FAAnalysisEClass = createEClass(FI4FA_ANALYSIS);
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
		FailurePropagationDataTypesPackage theFailurePropagationDataTypesPackage = (FailurePropagationDataTypesPackage)EPackage.Registry.INSTANCE.getEPackage(FailurePropagationDataTypesPackage.eNS_URI);
		UMLPackage theUMLPackage = (UMLPackage)EPackage.Registry.INSTANCE.getEPackage(UMLPackage.eNS_URI);
		DependableComponentPackage theDependableComponentPackage = (DependableComponentPackage)EPackage.Registry.INSTANCE.getEPackage(DependableComponentPackage.eNS_URI);
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
		BasicNFP_TypesPackage theBasicNFP_TypesPackage = (BasicNFP_TypesPackage)EPackage.Registry.INSTANCE.getEPackage(BasicNFP_TypesPackage.eNS_URI);
		GQAMPackage theGQAMPackage = (GQAMPackage)EPackage.Registry.INSTANCE.getEPackage(GQAMPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theFailurePropagationDataTypesPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		fptcEClass.getESuperTypes().add(theDependableComponentPackage.getDependableComponent());
		failurePropagationAnalysisEClass.getESuperTypes().add(theGQAMPackage.getGaAnalysisContext());
		fi4FAEClass.getESuperTypes().add(theDependableComponentPackage.getDependableComponent());
		fi4FASpecificationEClass.getESuperTypes().add(this.getFPTCSpecification());
		fi4FAAnalysisEClass.getESuperTypes().add(theGQAMPackage.getGaAnalysisContext());

		// Initialize classes and features; add operations and parameters
		initEClass(fptcSpecificationEClass, FPTCSpecification.class, "FPTCSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFPTCSpecification_Base_Comment(), theUMLPackage.getComment(), null, "base_Comment", null, 1, 1, FPTCSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFPTCSpecification_Failure(), theFailurePropagationDataTypesPackage.getFailureType(), "failure", null, 0, -1, FPTCSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFPTCSpecification_PartWithPort(), theUMLPackage.getProperty(), null, "partWithPort", null, 1, 1, FPTCSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFPTCSpecification_FailureMode(), theDependableComponentPackage.getFailureMode(), null, "failureMode", null, 0, -1, FPTCSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(fptcPortSlotEClass, FPTCPortSlot.class, "FPTCPortSlot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFPTCPortSlot_FPTCSpecification(), this.getFPTCSpecification(), null, "FPTCSpecification", null, 1, 1, FPTCPortSlot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFPTCPortSlot_Base_Slot(), theUMLPackage.getSlot(), null, "base_Slot", null, 1, 1, FPTCPortSlot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFPTCPortSlot_Failure(), theFailurePropagationDataTypesPackage.getFailureType(), "failure", null, 0, -1, FPTCPortSlot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(fptcEClass, org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FPTC.class, "FPTC", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFPTC_Fptc(), theTypesPackage.getString(), "fptc", null, 1, 1, org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FPTC.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFPTC_Base_Comment(), theUMLPackage.getComment(), null, "base_Comment", null, 1, 1, org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FPTC.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFPTC_Base_Connector(), theUMLPackage.getConnector(), null, "base_Connector", null, 1, 1, org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FPTC.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(flaBehaviorEClass, FLABehavior.class, "FLABehavior", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFLABehavior_Base_Constraint(), theUMLPackage.getConstraint(), null, "base_Constraint", null, 1, 1, FLABehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFLABehavior_Base_Class(), theUMLPackage.getClass_(), null, "base_Class", null, 1, 1, FLABehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFLABehavior_Fptc(), theBasicNFP_TypesPackage.getNFP_String(), "fptc", null, 1, 1, FLABehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFLABehavior_Base_InstanceSpecification(), theUMLPackage.getInstanceSpecification(), null, "base_InstanceSpecification", null, 1, 1, FLABehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFLABehavior_Base_Property(), theUMLPackage.getProperty(), null, "base_Property", null, 1, 1, FLABehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFLABehavior_Base_Connector(), theUMLPackage.getConnector(), null, "base_Connector", null, 1, 1, FLABehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(failurePropagationAnalysisEClass, FailurePropagationAnalysis.class, "FailurePropagationAnalysis", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(fi4FAEClass, org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FI4FA.class, "FI4FA", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFI4FA_Fi4fa(), theTypesPackage.getString(), "fi4fa", null, 1, 1, org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FI4FA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFI4FA_Base_Connector(), theUMLPackage.getConnector(), null, "base_Connector", null, 1, 1, org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FI4FA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(fi4FASpecificationEClass, FI4FASpecification.class, "FI4FASpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(acidAvoidableEClass, ACIDAvoidable.class, "ACIDAvoidable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getACIDAvoidable_A(), theFailurePropagationDataTypesPackage.getA_avoidable(), "a", null, 0, 1, ACIDAvoidable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getACIDAvoidable_C(), theFailurePropagationDataTypesPackage.getC_avoidable(), "c", null, 0, 1, ACIDAvoidable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getACIDAvoidable_Base_Comment(), theUMLPackage.getComment(), null, "base_Comment", null, 1, 1, ACIDAvoidable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getACIDAvoidable_I(), theFailurePropagationDataTypesPackage.getI_avoidable(), "i", null, 0, 1, ACIDAvoidable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getACIDAvoidable_D(), theFailurePropagationDataTypesPackage.getD_avoidable(), "d", null, 0, 1, ACIDAvoidable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(acidMitigationEClass, ACIDMitigation.class, "ACIDMitigation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getACIDMitigation_Base_Comment(), theUMLPackage.getComment(), null, "base_Comment", null, 1, 1, ACIDMitigation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getACIDMitigation_A(), theFailurePropagationDataTypesPackage.getA_mitigation(), "a", null, 0, 1, ACIDMitigation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getACIDMitigation_C(), theFailurePropagationDataTypesPackage.getC_mitigation(), "c", null, 0, 1, ACIDMitigation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getACIDMitigation_I(), theFailurePropagationDataTypesPackage.getI_mitigation(), "i", null, 0, 1, ACIDMitigation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getACIDMitigation_D(), theFailurePropagationDataTypesPackage.getD_mitigation(), "d", null, 0, 1, ACIDMitigation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(fi4FAAnalysisEClass, FI4FAAnalysis.class, "FI4FAAnalysis", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create annotations
		// http://www.eclipse.org/uml2/2.0.0/UML
		createUMLAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/uml2/2.0.0/UML</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createUMLAnnotations() {
		String source = "http://www.eclipse.org/uml2/2.0.0/UML";	
		addAnnotation
		  (acidMitigationEClass, 
		   source, 
		   new String[] {
			 "originalName", "ACIDMitigation "
		   });
	}

} //FailurePropagationPackageImpl
