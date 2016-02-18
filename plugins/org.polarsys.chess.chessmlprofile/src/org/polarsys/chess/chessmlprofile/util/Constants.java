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
package org.polarsys.chess.chessmlprofile.util;

import org.eclipse.uml2.uml.Stereotype;

public class Constants {

	// Components stereotypes
	public static final String COMPONENT_TYPE = "CHESS::ComponentModel::ComponentType";
	public static final String COMPONENT_IMPLEMENTATION = "CHESS::ComponentModel::ComponentImplementation";
	public static final String COMPONENT_INSTANCE = "CHESS::ComponentModel::ComponentInstance";
	
	// MARTE Ports stereotypes
	public static final String CLIENTSERVER_PORT = "MARTE::MARTE_DesignModel::GCM::ClientServerPort";
	public static final String CSPORT_SPEC_KIND = "specificationKind";
	public static final String CSPORT_SPEC_KIND_INTERFACEBASED = "interfaceBased";
	public static final String CSPORT_KIND = "kind";
	public static final String CSPORT_KIND_PROREQ = "proreq";
	public static final String CSPORT_KIND_REQUIRED = "required";
	public static final String CSPORT_KIND_PROVIDED = "provided";

	public static final String FLOW_PORT = "MARTE::MARTE_DesignModel::GCM::FlowPort";
	public static final String FLOW_PORT_DIRECTION = "direction";
	public static final String FLOW_PORT_DIRECTION_INOUT = "inout";
	public static final String FLOW_PORT_DIRECTION_IN = "in";
	public static final String FLOW_PORT_DIRECTION_OUT = "out";
	
	// MARTE Assign stereotype
	public static final String ASSIGN = "MARTE::MARTE_Foundations::Alloc::Assign";
	public static final String ASSIGN_FROM = "from"; 
	public static final String ASSIGN_TO = "to";
	
	// MARTE Hardware stereotypes
	//public static final String HW_COMPUTING_RESOURCE = "MARTE::MARTE_DesignModel::HRM::HwLogical::HwComputing::HwComputingResource";
	public static final String HW_BUS = "MARTE::MARTE_DesignModel::HRM::HwLogical::HwCommunication::HwBus";
	public static final String HW_BUS_PACKETT = "packetT";
	public static final String HW_BUS_SPEEDFACTOR = "speedFactor";
	public static final String HW_BUS_BLOCKT = "blockT";
	
	// MARTE GQAM stereotypes
	public static final String GA_RESOURCES_PLATFORM = "MARTE::MARTE_AnalysisModel::GQAM::GaResourcesPlatform";
	
	//CHESS CHRtSpecification stereotype 
	public static final String CHRT_SPECIFICATION = "CHESS::Predictability::RTComponentModel::CHRtSpecification";
	public static final String CHRTSPEC_CONTEXT = "context";
	public static final String CHRTSPEC_PARTWITHPORT = "partWithPort";
	public static final String CHRTSPEC_WCET = "WCET";
	public static final String CHRTSPEC_LOCALWCET = "localWCET";
	public static final String CHRTSPEC_OCCKIND = "occKind";
	public static final String CHRTSPEC_OCCKIND_PERIODIC = "periodic";
	public static final String CHRTSPEC_OCCKIND_SPORADIC = "sporadic";
	public static final String CHRTSPEC_OCCKIND_BURST = "burst";
	public static final String CHRTSPEC_OCCKIND_SPORADIC_MININTERARRIVAL = "minInterarrival";
	public static final String CHRTSPEC_OCCKIND_PERIODIC_PHASE = "phase";
	public static final String CH_HWPROCESSOR = "CHESS::Predictability::DeploymentConfiguration::HardwareBaseline::CH_HwProcessor";
	public static final String CHHWPROCESSOR_NB_CORES = "nbCores";

	
	// CHESS views
	public static final String DEPENDABILITY_ANALYSIS_VIEW = "CHESS::Core::CHESSViews::DependabilityAnalysisView";
	public static final String COMPONENT_VIEW = "CHESS::Core::CHESSViews::ComponentView";
	// Added REQUIREMENT_VIEW, SYSTEM_VIEW (20140207)
	public static final String REQUIREMENT_VIEW = "CHESS::Core::CHESSViews::RequirementView";
	public static final String SYSTEM_VIEW = "CHESS::Core::CHESSViews::SystemView";
	
	// StateBased Analysis
	public static final String STATEBASED_ANALYSIS = "CHESS::Dependability::StateBased::StateBasedAnalysis::StateBasedAnalysis";
	public static final String STATEBASED_ANALYSIS_MEASURE = "measure";
	public static final String STATEBASED_ANALYSIS_TARGETDEPCOMP = "targetDepComponent";
	public static final String STATEBASED_ANALYSIS_TARGETFAILUREMODE = "targetFailureMode";
	public static final String STATEBASED_ANALYSIS_PLATFORM = "platform";
	
	// Propagation
	public static final String PROPAGATION = "CHESS::Dependability::DependableComponent::Propagation";
	public static final String PROPAGATION_PROB = "prob";
	public static final String PROPAGATION_PROP_DELAY = "propDelay";
	
	// CHESS ResourcePlatform
	public static final String CHGARESOURCEPLATFORM = "CHESS::Core::CHGaResourcePlatform";
	
	// STATEFULL(LESS)HARD(SOFT)WARE
	public static final String STATEFULHARDWARE = "CHESS::Dependability::StateBased::StateBasedComponents::StatefulHardware";
	public static final String STATELESSHARDWARE = "CHESS::Dependability::StateBased::StateBasedComponents::StatelessHardware";
	public static final String STATEFULSOFTWARE = "CHESS::Dependability::StateBased::StateBasedComponents::StatefulSoftware";
	public static final String STATELESSSOFTWARE = "CHESS::Dependability::StateBased::StateBasedComponents::StatelessSoftware";
	
	public static final String STATEWARE_PROBPERMFAULT = "probPermFault";
	public static final String STATEWARE_ERROR_LATENCY = "errorLatency";
	public static final String STATEWARE_FAULT_OCC = "faultOcc";
	public static final String STATEWARE_REPAIR_DELAY = "repairDelay";
	
	// DpendableComponent
	public static final String DEPENDABLE_COMPONENT = "CHESS::Dependability::DependableComponent::DependableComponent";
	public static final String DEPENDABLE_COMPONENT_ERROR_MODEL = "errorModel";
	
	// ErrorModel
	public static final String ERROR_MODEL = "CHESS::Dependability::ThreatsPropagation::ErrorModel";
	
	// Automotive profile
	public static final String SAFETYREQUIREMENT = "AutomotiveProfile::SafetyRequirement";
	public static final String SAFETYGOAL = "AutomotiveProfile::SafetyGoal";
	public static final String INDEPENDENCY = "AutomotiveProfile::Independency";
	public static final String DECOMPOSITION = "AutomotiveProfile::Decomposition";
	public static final String AUTOMOTIVEBLOCK = "AutomotiveProfile::AutomotiveBlock";
	public static final String AUTOMOTIVEREQUIREMENT = "AutomotiveProfile::AutomotiveRequirement";
	
	// SYSML 
	public static final String BLOCK = "SysML::Blocks::Block";
	public static final String REQUIREMENT = "SysML::Requirements::Requirement";
	public static final String DERIVEREQT = "SysML::Requirements::DeriveReqt"; 
	public static final String SATISFY = "SysML::Requirements::Satisfy";
	
	
	//CHESS CriticalityInterfaceSpecification stereotype 
	public static final String CH_CRITICALITYINTERFACESPECIFICATION = "CHESS::Safety::CriticalityInterfaceSpecification";
	public static final String CH_CRITICALITYINTERFACESPECIFICATION_ACCEPTEDCRITICALITYFORCLIENTS = "acceptedCriticalityForClients";
	public static final String CH_CRITICALITYINTERFACESPECIFICATION_BASE_CONSTRAINT = "base_constraint";
	
	//CHESS CriticalitySpecification stereotype 
	public static final String CH_CRITICALITYSPECITICATION = "CHESS::Safety::CriticalitySpecification";
	public static final String CH_CRITICALITYSPECITICATION_CRITICALITYLEVEL = "criticalityLevel";
	
	//MARTE NfpConstraint  
	public static final String MARTE_NFPS = "MARTE::MARTE_Foundations::NFPs::NfpConstraint";
	public static final String MARTE_NFPS_KIND ="kind";
	public static final String MARTE_NFPS_MODE = "mode";
	
	// MARTE MemoryPartition
	public static final String MARTE_MEMORYPARTITION ="MARTE::MARTE_DesignModel::SRM::SW_Concurrency::MemoryPartition";
	
	
	// CHESS Views
	public static final String DEPLOYMENT_VIEW_NAME = "DeploymentView";
	public static final String COMPONENT_VIEW_NAME = "ComponentView";
	public static final String ANALYSIS_VIEW_NAME = "AnalysisView";
	
	// CHESS CHRtPortSlot stereotype
	public static final String CH_CHRtPortSlot = "CHESS::Predictability::RTComponentModel::CHRtPortSlot";
	public static final String CH_CHRtPortSlot_CHRTSPECIFICATION = "cH_RtSpecification";
	
	// CHESS Functional Partitions stereotype
	public static final String CH_FunctionalPartition="CHESS::ComponentModel::FunctionalPartition";
	
	// MARTE GQAM stereotypes
	public static final String MARTE_SaAnalysisContext = "MARTE::MARTE_AnalysisModel::SAM::SaAnalysisContext";
	public static final String MARTE_ALLOCATE = "MARTE::MARTE_Foundations::Alloc::Allocate";
	public static final String MARTE_SaStep = "MARTE::MARTE_AnalysisModel::SAM::SaStep";
	public static final String MARTE_EndtoEndFlow = "MARTE::MARTE_AnalysisModel::SAM::SaEndtoEndFlow";
	public static final String MARTE_SaExecHost = "MARTE::MARTE_AnalysisModel::SAM::SaExecHost";
	
	// CHESS IdentifInstance
	public static final String CH_IDENTIFINSTANCE = "CHESS::Core::IdentifInstance";
	
	
	public static final String CH_HW_BUS = "CHESS::Predictability::DeploymentConfiguration::HardwareBaseline::CH_HwBus";
	
	
	// MARTE
	public static final String GAWORKLOADEVENT = "MARTE::MARTE_AnalysisModel::GQAM::GaWorkloadEvent";
	public static final String GAWORKLOADBEHAVIOR = "MARTE::MARTE_AnalysisModel::GQAM::GaWorkloadBehavior";
	
	public static final String CH_PsmPackage = "CHESS::Core::PSMPackage";
	
	// from TabbedPropertiesUtils
	public static final String GALATENCYOBS = "MARTE::MARTE_AnalysisModel::GQAM::GaLatencyObs";
	
	// For IMA Avionics
	public static final String CH_ARINCFunction = "CHESS::Predictability::ARINCComponentModel::ARINCFunction";
	public static final String CH_ARINCProcess = "CHESS::Predictability::ARINCComponentModel::ARINCProcess";
	public static final String CH_ARINCComponentImpl = "CHESS::Predictability::ARINCComponentModel::ARINCComponentImpl";

	
}
