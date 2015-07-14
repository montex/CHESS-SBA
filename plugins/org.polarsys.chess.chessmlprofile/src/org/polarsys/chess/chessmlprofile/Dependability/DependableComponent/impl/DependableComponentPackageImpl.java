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
package org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
import org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponent;
import org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponentFactory;
import org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponentPackage;
import org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.FailureMode;
import org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.FailureModeGroup;
import org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.FailureModeSpecification;
import org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.Propagation;
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
public class DependableComponentPackageImpl extends EPackageImpl implements DependableComponentPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propagationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass failureModeGroupEClass = null;

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
	private EClass failureModeSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dependableComponentEClass = null;

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
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponentPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DependableComponentPackageImpl() {
		super(eNS_URI, DependableComponentFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link DependableComponentPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DependableComponentPackage init() {
		if (isInited) return (DependableComponentPackage)EPackage.Registry.INSTANCE.getEPackage(DependableComponentPackage.eNS_URI);

		// Obtain or create and register package
		DependableComponentPackageImpl theDependableComponentPackage = (DependableComponentPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DependableComponentPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DependableComponentPackageImpl());

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
		theDependableComponentPackage.createPackageContents();
		thechessmlprofilePackage.createPackageContents();
		theCorePackage.createPackageContents();
		theCHESSViewsPackage.createPackageContents();
		theFailurePropagationPackage.createPackageContents();
		theFailurePropagationDataTypesPackage.createPackageContents();
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
		theDependableComponentPackage.initializePackageContents();
		thechessmlprofilePackage.initializePackageContents();
		theCorePackage.initializePackageContents();
		theCHESSViewsPackage.initializePackageContents();
		theFailurePropagationPackage.initializePackageContents();
		theFailurePropagationDataTypesPackage.initializePackageContents();
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
		theDependableComponentPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DependableComponentPackage.eNS_URI, theDependableComponentPackage);
		return theDependableComponentPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropagation() {
		return propagationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropagation_Prob() {
		return (EAttribute)propagationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropagation_PropDelay() {
		return (EAttribute)propagationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropagation_Base_Abstraction() {
		return (EReference)propagationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropagation_Base_Comment() {
		return (EReference)propagationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropagation_Base_Connector() {
		return (EReference)propagationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropagation_Base_InstanceSpecification() {
		return (EReference)propagationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropagation_TransfFunct() {
		return (EAttribute)propagationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropagation_Base_Transition() {
		return (EReference)propagationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropagation_Weight() {
		return (EAttribute)propagationEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFailureModeGroup() {
		return failureModeGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFailureModeGroup_Base_Class() {
		return (EReference)failureModeGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFailureModeGroup_FailureMode() {
		return (EReference)failureModeGroupEClass.getEStructuralFeatures().get(1);
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
	public EReference getFailureMode_Base_Class() {
		return (EReference)failureModeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFailureMode_Description() {
		return (EAttribute)failureModeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFailureMode_Severity() {
		return (EAttribute)failureModeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFailureMode_Exposure() {
		return (EAttribute)failureModeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFailureMode_Controllability() {
		return (EAttribute)failureModeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFailureMode_Permanent() {
		return (EAttribute)failureModeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFailureModeSpecification() {
		return failureModeSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFailureModeSpecification_Base_Constraint() {
		return (EReference)failureModeSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFailureModeSpecification_Base_Port() {
		return (EReference)failureModeSpecificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFailureModeSpecification_FailureModeGroup() {
		return (EReference)failureModeSpecificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDependableComponent() {
		return dependableComponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependableComponent_Base_Component() {
		return (EReference)dependableComponentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependableComponent_ErrorModel() {
		return (EReference)dependableComponentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependableComponent_Base_Property() {
		return (EReference)dependableComponentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependableComponent_Base_InstanceSpecification() {
		return (EReference)dependableComponentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependableComponentFactory getDependableComponentFactory() {
		return (DependableComponentFactory)getEFactoryInstance();
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
		propagationEClass = createEClass(PROPAGATION);
		createEAttribute(propagationEClass, PROPAGATION__PROB);
		createEAttribute(propagationEClass, PROPAGATION__PROP_DELAY);
		createEReference(propagationEClass, PROPAGATION__BASE_ABSTRACTION);
		createEReference(propagationEClass, PROPAGATION__BASE_COMMENT);
		createEReference(propagationEClass, PROPAGATION__BASE_CONNECTOR);
		createEReference(propagationEClass, PROPAGATION__BASE_INSTANCE_SPECIFICATION);
		createEAttribute(propagationEClass, PROPAGATION__TRANSF_FUNCT);
		createEReference(propagationEClass, PROPAGATION__BASE_TRANSITION);
		createEAttribute(propagationEClass, PROPAGATION__WEIGHT);

		failureModeGroupEClass = createEClass(FAILURE_MODE_GROUP);
		createEReference(failureModeGroupEClass, FAILURE_MODE_GROUP__BASE_CLASS);
		createEReference(failureModeGroupEClass, FAILURE_MODE_GROUP__FAILURE_MODE);

		failureModeEClass = createEClass(FAILURE_MODE);
		createEReference(failureModeEClass, FAILURE_MODE__BASE_CLASS);
		createEAttribute(failureModeEClass, FAILURE_MODE__DESCRIPTION);
		createEAttribute(failureModeEClass, FAILURE_MODE__SEVERITY);
		createEAttribute(failureModeEClass, FAILURE_MODE__EXPOSURE);
		createEAttribute(failureModeEClass, FAILURE_MODE__CONTROLLABILITY);
		createEAttribute(failureModeEClass, FAILURE_MODE__PERMANENT);

		failureModeSpecificationEClass = createEClass(FAILURE_MODE_SPECIFICATION);
		createEReference(failureModeSpecificationEClass, FAILURE_MODE_SPECIFICATION__BASE_CONSTRAINT);
		createEReference(failureModeSpecificationEClass, FAILURE_MODE_SPECIFICATION__BASE_PORT);
		createEReference(failureModeSpecificationEClass, FAILURE_MODE_SPECIFICATION__FAILURE_MODE_GROUP);

		dependableComponentEClass = createEClass(DEPENDABLE_COMPONENT);
		createEReference(dependableComponentEClass, DEPENDABLE_COMPONENT__BASE_COMPONENT);
		createEReference(dependableComponentEClass, DEPENDABLE_COMPONENT__ERROR_MODEL);
		createEReference(dependableComponentEClass, DEPENDABLE_COMPONENT__BASE_PROPERTY);
		createEReference(dependableComponentEClass, DEPENDABLE_COMPONENT__BASE_INSTANCE_SPECIFICATION);
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
		BasicNFP_TypesPackage theBasicNFP_TypesPackage = (BasicNFP_TypesPackage)EPackage.Registry.INSTANCE.getEPackage(BasicNFP_TypesPackage.eNS_URI);
		UMLPackage theUMLPackage = (UMLPackage)EPackage.Registry.INSTANCE.getEPackage(UMLPackage.eNS_URI);
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
		ThreatsPropagationPackage theThreatsPropagationPackage = (ThreatsPropagationPackage)EPackage.Registry.INSTANCE.getEPackage(ThreatsPropagationPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(propagationEClass, Propagation.class, "Propagation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPropagation_Prob(), theBasicNFP_TypesPackage.getNFP_Real(), "prob", null, 1, 1, Propagation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPropagation_PropDelay(), theBasicNFP_TypesPackage.getNFP_Duration(), "propDelay", null, 1, 1, Propagation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPropagation_Base_Abstraction(), theUMLPackage.getAbstraction(), null, "base_Abstraction", null, 1, 1, Propagation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPropagation_Base_Comment(), theUMLPackage.getComment(), null, "base_Comment", null, 1, 1, Propagation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPropagation_Base_Connector(), theUMLPackage.getConnector(), null, "base_Connector", null, 1, 1, Propagation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPropagation_Base_InstanceSpecification(), theUMLPackage.getInstanceSpecification(), null, "base_InstanceSpecification", null, 1, 1, Propagation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPropagation_TransfFunct(), theTypesPackage.getString(), "transfFunct", null, 0, -1, Propagation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPropagation_Base_Transition(), theUMLPackage.getTransition(), null, "base_Transition", null, 1, 1, Propagation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPropagation_Weight(), theBasicNFP_TypesPackage.getNFP_Real(), "weight", null, 0, 1, Propagation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(failureModeGroupEClass, FailureModeGroup.class, "FailureModeGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFailureModeGroup_Base_Class(), theUMLPackage.getClass_(), null, "base_Class", null, 1, 1, FailureModeGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFailureModeGroup_FailureMode(), this.getFailureMode(), null, "failureMode", null, 1, -1, FailureModeGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(failureModeEClass, FailureMode.class, "FailureMode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFailureMode_Base_Class(), theUMLPackage.getClass_(), null, "base_Class", null, 1, 1, FailureMode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFailureMode_Description(), theTypesPackage.getString(), "description", null, 0, 1, FailureMode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFailureMode_Severity(), theTypesPackage.getString(), "severity", null, 0, 1, FailureMode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFailureMode_Exposure(), theTypesPackage.getString(), "exposure", null, 0, 1, FailureMode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFailureMode_Controllability(), theTypesPackage.getString(), "controllability", null, 0, 1, FailureMode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFailureMode_Permanent(), theTypesPackage.getBoolean(), "permanent", null, 0, 1, FailureMode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(failureModeSpecificationEClass, FailureModeSpecification.class, "FailureModeSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFailureModeSpecification_Base_Constraint(), theUMLPackage.getConstraint(), null, "base_Constraint", null, 1, 1, FailureModeSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFailureModeSpecification_Base_Port(), theUMLPackage.getPort(), null, "base_Port", null, 1, 1, FailureModeSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFailureModeSpecification_FailureModeGroup(), this.getFailureModeGroup(), null, "failureModeGroup", null, 1, -1, FailureModeSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(dependableComponentEClass, DependableComponent.class, "DependableComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDependableComponent_Base_Component(), theUMLPackage.getComponent(), null, "base_Component", null, 1, 1, DependableComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDependableComponent_ErrorModel(), theThreatsPropagationPackage.getErrorModel(), null, "errorModel", null, 0, -1, DependableComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDependableComponent_Base_Property(), theUMLPackage.getProperty(), null, "base_Property", null, 1, 1, DependableComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDependableComponent_Base_InstanceSpecification(), theUMLPackage.getInstanceSpecification(), null, "base_InstanceSpecification", null, 1, 1, DependableComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
	}

} //DependableComponentPackageImpl
