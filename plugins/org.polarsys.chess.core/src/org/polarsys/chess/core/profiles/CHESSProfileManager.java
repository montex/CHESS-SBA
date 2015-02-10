/*
-----------------------------------------------------------------------
--          			CHESS core plugin							 --
--                                                                   --
--                    Copyright (C) 2011-2012                        --
--                 University of Padova, ITALY                       --
--                                                                   --
-- Author: Alessandro Zovi         azovi@math.unipd.it               --
--                                                                   --
-- All rights reserved. This program and the accompanying materials  --
-- are made available under the terms of the Eclipse Public License  --
-- v1.0 which accompanies this distribution, and is available at     --
-- http://www.eclipse.org/legal/epl-v10.html                         --
-----------------------------------------------------------------------
 */

package org.polarsys.chess.core.profiles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;
import org.polarsys.chess.chessmlprofile.ComponentModel.ComponentModelPackage;
import org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponentPackage;
import org.polarsys.chess.chessmlprofile.Dependability.FMEA.FMEAPackage;
import org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationPackage;
import org.polarsys.chess.chessmlprofile.Dependability.MitigationMeans.MitigationMeansPackage;
import org.polarsys.chess.chessmlprofile.Dependability.StateBased.FaultTolerance.FaultTolerancePackage;
import org.polarsys.chess.chessmlprofile.Dependability.StateBased.MaintenanceMonitoring.MaintenanceMonitoringPackage;
import org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedAnalysis.StateBasedAnalysisPackage;
import org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.StateBasedComponentsPackage;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatsPropagationPackage;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.DeploymentConfAnalysis.DeploymentConfAnalysisPackage;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.HardwareBaselinePackage;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RTComponentModelPackage;
import org.polarsys.chess.chessmlprofile.Predictability.TimingAnalysis.TimingAnalysisPackage;
import org.polarsys.chess.chessmlprofile.SystemModel.STS.STSPackage;
import org.polarsys.chess.core.extensionpoint.AddProfileHandler;
import org.polarsys.chess.core.util.uml.UMLUtils;

/**
 * This class wraps the CHESS profile resource and is used for loading the
 * profile and applying its stereotypes.
 * 
 * @author Alessandro Zovi
 * 
 */

public class CHESSProfileManager {

	public static final String COMPONENT_VIEW = "ComponentView";
	public static final String EXTRAFUNCTIONAL_VIEW = "ExtraFunctionalView";
	public static final String DEPLOYMENT_VIEW = "DeploymentView";
	public static final String ANALYSIS_VIEW = "AnalysisView";
	public static final String DEPENDABILITY_ANALYSIS_VIEW = "DependabilityAnalysisView";
	public static final String RT_ANALYSIS_VIEW = "RTAnalysisView";
	public static final String PSM_VIEW = "PSMView";
	public static final String TIMING_DATAFLOW_VIEW = "TimingDataFlowView";
	public static final String REQUIREMENT_VIEW = "RequirementView";
	public static final String DEPENDABILITY_VIEW = "DependabilityView";
	public static final String SYSTEM_VIEW = "SystemView";

	public static final String RAILWAY_VIEW = "RailwayView";

	public static final String NULL_VIEW = "NullView";

	// TODO temporary, created for TIMING_DATAFLOW_VIEW
	public static final ArrayList<String> UNUSED_VIEWS = new ArrayList<String>();
	static {
		UNUSED_VIEWS.add(TIMING_DATAFLOW_VIEW);
	}

	// views that may be simultaneously active on top of a view
	// They are virtual views
	public static final ArrayList<String> CONCURRENT_VIEWS = new ArrayList<String>();
	static {
		CONCURRENT_VIEWS.add(EXTRAFUNCTIONAL_VIEW);
		CONCURRENT_VIEWS.add(DEPENDABILITY_VIEW);
		CONCURRENT_VIEWS.add(RAILWAY_VIEW);
	}

	// views that are inside other views
	// They are concrete views like root views.
	public static final ArrayList<String> SUBVIEWS = new ArrayList<String>();
	static {
		SUBVIEWS.add(RT_ANALYSIS_VIEW);
		SUBVIEWS.add(DEPENDABILITY_ANALYSIS_VIEW);
	}

	public static final ArrayList<String> CONCURRENT_VIEWS_COMPONENT = new ArrayList<String>();
	static {
		CONCURRENT_VIEWS_COMPONENT.add(EXTRAFUNCTIONAL_VIEW);
		CONCURRENT_VIEWS_COMPONENT.add(RAILWAY_VIEW);
	}

	public static final ArrayList<String> CONCURRENT_VIEWS_DEPLOYMENT = new ArrayList<String>();
	static {
		CONCURRENT_VIEWS_DEPLOYMENT.add(DEPENDABILITY_VIEW);
	}

	public static final HashMap<String, ArrayList<String>> CONCURRENT_VIEWS_ASSOCIATION = new HashMap<String, ArrayList<String>>();
	static {
		CONCURRENT_VIEWS_ASSOCIATION.put(COMPONENT_VIEW,
				CONCURRENT_VIEWS_COMPONENT);
		CONCURRENT_VIEWS_ASSOCIATION.put(DEPLOYMENT_VIEW,
				CONCURRENT_VIEWS_DEPLOYMENT);
	}

	public static final String CHESS_PROFILE = "CHESS-ML";
	public static final String CORE_PROFILE = "Core";
	public static final String VIEWS_PROFILE = "CHESSViews";

	public static final String COMPONENTMODEL_PROFILE = "ComponentModel";

	public static final String CHESS_STRT = "CHESS";

	public static HashSet<String> CHESS_VIEWS_LIST = new HashSet<String>();

	public static HashSet<String> ROOT_VIEWS = new HashSet<String>();

	public static ArrayList<String> PREDEFINED_PROFILES = new ArrayList<String>();

	public static final String CHESSML_PATH = "pathmap://CHESSML_PROFILE/CHESS.profile.uml";

	public static Stereotype applyCH_HwBusStereotype(Element element) {
		/*
		 * Stereotype str = ((Profile)
		 * CHESSProfile.getNestedPackage("Predictability"
		 * ).getNestedPackage("DeploymentConfiguration"
		 * ).getNestedPackage("HardwareBaseline"))
		 * .getOwnedStereotype("CH_HwBus"); element.applyStereotype(str);
		 */
		return UMLUtils.applyStereotype(element,
				"CHESS::Predictability::DeploymentConfiguration::HardwareBaseline::CH_HwBus");
	}

	public static Stereotype applyCHGaResourcePlatformStereotype(Package pack) {
		// Stereotype str = ((Profile)
		// CHESSProfile.getNestedPackage("Core")).getOwnedStereotype("CHGaResourcePlatform");
		return UMLUtils.applyStereotype(pack, "CHESS::Core::CHGaResourcePlatform");
	}

	public static Stereotype applyChRTPortSlotStereotype(Slot element) {
		/*
		 * Stereotype str = ((Profile)
		 * CHESSProfile.getNestedPackage("Predictability"
		 * ).getNestedPackage("RTComponentModel"))
		 * .getOwnedStereotype("CHRtPortSlot");
		 */
		return UMLUtils.applyStereotype(element,
				"CHESS::Predictability::RTComponentModel::CHRtPortSlot");
	}

	public static Stereotype applyFPTCPortSlotStereotype(Slot element) {
		// Stereotype str = ((Profile)
		// CHESSProfile.getNestedPackage("Dependability").getNestedPackage("FailurePropagation")).getOwnedStereotype("FPTCPortSlot");
		return UMLUtils.applyStereotype(element,
				"CHESS::Dependability::FailurePropagation::FPTCPortSlot");
	}

	public static Stereotype applyMultiInstanceStereotype(
			InstanceSpecification element) {
		// Stereotype str = ((Profile)
		// CHESSProfile.getNestedPackage("Core")).getOwnedStereotype("MultiInstance");
		return UMLUtils.applyStereotype(element, "CHESS::Core::MultiInstance");
	}

	public static Stereotype applyMultiSlotStereotype(Slot element) {
		// Stereotype str = ((Profile)
		// CHESSProfile.getNestedPackage("Core")).getOwnedStereotype("MultiSlot");
		return UMLUtils.applyStereotype(element, "CHESS::Core::MultSlot");
	}

	public static Stereotype applyPropagationStereotype(
			InstanceSpecification element) {
		/*
		 * Stereotype str = ((Profile)
		 * CHESSProfile.getNestedPackage("Dependability"
		 * ).getNestedPackage("DependableComponent"))
		 * .getOwnedStereotype("Propagation");
		 */
		return UMLUtils.applyStereotype(element,
				"CHESS::Dependability::DependableComponent::Propagation");
	}

	public static Stereotype getCH_HWBus(Element element) {
		return UMLUtils.getStereotype(element,
				"CHESS::Predictability::DeploymentConfiguration::HardwareBaseline::CH_HwBus");
	}

	public static Stereotype getCH_HWComputingResource(Element element) {
		return UMLUtils.getStereotype(
				element,
				"CHESS::Predictability::DeploymentConfiguration::HardwareBaseline::CH_HwComputingResource");
		// Stereotype str = ((Profile)
		// CHESSProfile.getNestedPackage("Predictability").getNestedPackage("DeploymentConfiguration")
		// .getNestedPackage("HardwareBaseline"))
		// .getOwnedStereotype("CH_HwComputingResource");
		// return str;
	}

	public static Stereotype getCH_HWProcessor(Element element) {
		return UMLUtils.getStereotype(
				element,
				"CHESS::Predictability::DeploymentConfiguration::HardwareBaseline::CH_HwProcessor");
		// Stereotype str = ((Profile)
		// CHESSProfile.getNestedPackage("Predictability").getNestedPackage("DeploymentConfiguration")
		// .getNestedPackage("HardwareBaseline"))
		// .getOwnedStereotype("CH_HwProcessor");
		// return str;
	}

	public static Stereotype getCHRTSpecification(Element element) {
		/*
		 * Stereotype str = ((Profile)
		 * CHESSProfile.getNestedPackage("Predictability"
		 * ).getNestedPackage("RTComponentModel")) -
		 * .getOwnedStereotype("CHRtSpecification"); return str;
		 */
		return UMLUtils.getStereotype(element,
				"CHESS::Predictability::RTComponentModel::CHRtSpecification");
	}

	public static Stereotype getFI4FASpecification(Element element) {
		/*
		 * Stereotype str = ((Profile)
		 * CHESSProfile.getNestedPackage("Dependability"
		 * ).getNestedPackage("FailurePropagation"))
		 * .getOwnedStereotype("FI4FASpecification");
		 */
		Stereotype str = UMLUtils.getStereotype(element,
				"CHESS::Dependability::FailurePropagation::FPTCSpecification");

		return str;
	}

	public static Stereotype getFPTCSpecification(Element element) {
		/*
		 * Stereotype str = ((Profile)
		 * CHESSProfile.getNestedPackage("Dependability"
		 * ).getNestedPackage("FailurePropagation"))
		 * .getOwnedStereotype("FPTCSpecification"); return str;
		 */
		return UMLUtils.getStereotype(element,
				"CHESS::Dependability::FailurePropagation::FPTCSpecification");

	}

	public static synchronized void initializeProfileList(Profile CHESSProfile) {
		if (!ARE_PROFILES_LOADED) {

			List<Profile> pp = PackageUtil.getSubProfiles(CHESSProfile);
			for (Profile profile : pp) {
				PREDEFINED_PROFILES.add(profile.getName());
			}
			ARE_PROFILES_LOADED = true;
		}

	}

	public static synchronized void initializeViewList(Profile viewsProfile) {
		if (!ARE_VIEWS_LOADED) {
			for (Stereotype str : viewsProfile.getOwnedStereotypes()) {
				CHESS_VIEWS_LIST.add(str.getName());
			}
			// Add virtual views
			for (String v : CONCURRENT_VIEWS) {
				CHESS_VIEWS_LIST.add(v);
			}
			CHESS_VIEWS_LIST.add(NULL_VIEW);

			for (String v : CHESS_VIEWS_LIST) {
				if (!(v.equals(NULL_VIEW) || CONCURRENT_VIEWS.contains(v)
						|| SUBVIEWS.contains(v) || UNUSED_VIEWS.contains(v)))
					ROOT_VIEWS.add(v);
			}
			ARE_VIEWS_LOADED = true;
		}

	}
	

	public static boolean ARE_VIEWS_LOADED = false;

	private static boolean ARE_PROFILES_LOADED;

	public CHESSProfileManager(ResourceSet rs) {
		//this.resourceSet = rs;
		loadCHESSProfile(rs);
	}

	public static Stereotype applyCH_HwComputingResourceStereotype(
			Element element) {
		
		return UMLUtils.applyStereotype(
				element,
				"CHESS::Predictability::DeploymentConfiguration::HardwareBaseline::CH_HwComputingResource");
	}

	public static Stereotype applyCH_HwProcessorStereotype(Element element) {
		
		return UMLUtils.applyStereotype(
				element,
				"CHESS::Predictability::DeploymentConfiguration::HardwareBaseline::CH_HwProcessor");
	}

	public static Stereotype applyCHESSStereotype(Element element) {
		/*
		 * Stereotype str = coreProfile.getOwnedStereotype(CHESS_STRT);
		 * element.applyStereotype(str); return str;
		 */
		return UMLUtils.applyStereotype(element, "CHESS::Core::CHESS");
	}

	/**
	 * applies CHESS, VIEWS and CORE profile to the given CHESS Model
	 * 
	 * @param model
	 */
	public static void applyRecursively(Model model) {
		
		ResourceSet rs = model.eResource().getResourceSet();
		Profile CHESSProfile = (Profile) PackageUtil.loadPackage(
				URI.createURI(CHESSML_PATH), rs);
		PackageUtil.applyProfile(model, CHESSProfile, true);

	}

	public static Stereotype applyViewStereotype(String viewName, Element element) {
		return UMLUtils.applyStereotype(element, "CHESS::Core::CHESSViews::"+viewName);
		/*Stereotype str = viewsProfile.getOwnedStereotype(stereotypeName);
		element.applyStereotype(str);
		return str;*/
	}
	
	public static Stereotype getViewStereotype(Element element, String viewName){
		return UMLUtils.getStereotype(element,"CHESS::Core::CHESSViews::"+viewName);
	}
	
	
	@Deprecated
	/*
	 * Not safe to retrieve views based on the model name
	 * */
	public static String viewName(Model model, String name){
		return model.getName() + name;
	} 

	public static void createViews(Model model) {

		Stereotype chessStereotype = model
				.getAppliedStereotype("CHESS::Core::CHESS");
		Package newpkg = null;
		String view = "";
		try {
			Profile deploymentConfiguration_AnalysisProfile = UMLResourcesUtil.getProfile(DeploymentConfAnalysisPackage.eINSTANCE, model);
			Profile stateBasedComponentProfile =  UMLResourcesUtil.getProfile(StateBasedComponentsPackage.eINSTANCE, model);
			Profile stateBased_FaultToleranceProfile =  UMLResourcesUtil.getProfile(FaultTolerancePackage.eINSTANCE, model);
			Profile stateBased_MaintainanceMonitoringProfile =  UMLResourcesUtil.getProfile(MaintenanceMonitoringPackage.eINSTANCE, model);
			Profile failurePropProfile =  UMLResourcesUtil.getProfile(FailurePropagationPackage.eINSTANCE, model);
			
			Profile threatsPropagationProfile =  UMLResourcesUtil.getProfile(ThreatsPropagationPackage.eINSTANCE, model);
			Profile dependableComponentProfile =  UMLResourcesUtil.getProfile(DependableComponentPackage.eINSTANCE, model);
			Profile mitigationProfile =  UMLResourcesUtil.getProfile(MitigationMeansPackage.eINSTANCE, model);
			Profile componentModelProfile =  UMLResourcesUtil.getProfile(ComponentModelPackage.eINSTANCE, model);
			Profile RTComponentModelProfile =  UMLResourcesUtil.getProfile(RTComponentModelPackage.eINSTANCE, model);
			Profile deploymentConfiguration_HardwareBaselineProfile =  UMLResourcesUtil.getProfile(HardwareBaselinePackage.eINSTANCE, model);
			Profile FMEAProfile =  UMLResourcesUtil.getProfile(FMEAPackage.eINSTANCE, model);
			
			Profile stateBased_AnalysisProfile =  UMLResourcesUtil.getProfile(StateBasedAnalysisPackage.eINSTANCE, model);
			Profile timingProfile =  UMLResourcesUtil.getProfile(TimingAnalysisPackage.eINSTANCE, model);
			
			Profile STSProfile =  UMLResourcesUtil.getProfile(STSPackage.eINSTANCE, model);
						
			view = REQUIREMENT_VIEW;
			newpkg = model.createNestedPackage(viewName(model, view));
			Stereotype viewStrt = applyViewStereotype(view, newpkg);
			model.setValue(chessStereotype, "requirementView",
					newpkg.getStereotypeApplication(viewStrt));

			view = SYSTEM_VIEW;
			newpkg = model.createNestedPackage(viewName(model, view));
			viewStrt = applyViewStereotype(view, newpkg);
			model.setValue(chessStereotype, "systemView",
					newpkg.getStereotypeApplication(viewStrt));
			newpkg.applyProfile(stateBasedComponentProfile);
			newpkg.applyProfile(stateBased_FaultToleranceProfile);
			newpkg.applyProfile(stateBased_MaintainanceMonitoringProfile);
			newpkg.applyProfile(failurePropProfile);
			newpkg.applyProfile(threatsPropagationProfile);
			newpkg.applyProfile(dependableComponentProfile);
			newpkg.applyProfile(mitigationProfile);
			newpkg.applyProfile(STSProfile);

			view = COMPONENT_VIEW;
			newpkg = model.createNestedPackage(viewName(model, view));
			viewStrt = applyViewStereotype(view, newpkg);
			model.setValue(chessStereotype, "componentView",
					newpkg.getStereotypeApplication(viewStrt));
			// apply profiles
			newpkg.applyProfile(componentModelProfile);
			newpkg.applyProfile(RTComponentModelProfile);
			newpkg.applyProfile(stateBasedComponentProfile);
			newpkg.applyProfile(stateBased_FaultToleranceProfile);
			newpkg.applyProfile(stateBased_MaintainanceMonitoringProfile);
			newpkg.applyProfile(failurePropProfile);
			newpkg.applyProfile(threatsPropagationProfile);
			newpkg.applyProfile(dependableComponentProfile);
			newpkg.applyProfile(mitigationProfile);

			view = DEPLOYMENT_VIEW;
			newpkg = model.createNestedPackage(viewName(model, view));
			viewStrt = applyViewStereotype(view, newpkg);
			model.setValue(chessStereotype, "deploymentView",
					newpkg.getStereotypeApplication(viewStrt));
			// apply profile
			newpkg.applyProfile(deploymentConfiguration_HardwareBaselineProfile);
			newpkg.applyProfile(RTComponentModelProfile);
			newpkg.applyProfile(stateBasedComponentProfile);
			newpkg.applyProfile(stateBased_FaultToleranceProfile);
			newpkg.applyProfile(stateBased_MaintainanceMonitoringProfile);
			newpkg.applyProfile(failurePropProfile);
			newpkg.applyProfile(threatsPropagationProfile);
			newpkg.applyProfile(dependableComponentProfile);
			newpkg.applyProfile(FMEAProfile);

			view = ANALYSIS_VIEW;
			newpkg = model.createNestedPackage(viewName(model, view));
			viewStrt = applyViewStereotype(view, newpkg);
			model.setValue(chessStereotype, "analysisView",
					newpkg.getStereotypeApplication(viewStrt));
			// create inner views
			// DependabilityAnalysisView
			Stereotype innerView = getViewStereotype(newpkg, DEPENDABILITY_ANALYSIS_VIEW);
			Package innerpkg = newpkg.createNestedPackage(model.getName()
					+ innerView.getName());
			// apply profile
			innerpkg.applyProfile(stateBased_AnalysisProfile);
			innerpkg.applyProfile(failurePropProfile);
			innerpkg.applyProfile(FMEAProfile);
			applyViewStereotype(DEPENDABILITY_ANALYSIS_VIEW, innerpkg);
			newpkg.setValue(viewStrt, "depanalysisview",
					innerpkg.getStereotypeApplication(innerView));
			// RealTimeAnalysis
			innerView = getViewStereotype(newpkg, RT_ANALYSIS_VIEW);
			Package innerpkgRT = newpkg.createNestedPackage(model.getName()
					+ innerView.getName());
			applyViewStereotype(RT_ANALYSIS_VIEW, innerpkgRT);
			newpkg.setValue(viewStrt, "rtanalysisview",
					innerpkgRT.getStereotypeApplication(innerView));
			
			view = PSM_VIEW;
			newpkg = model.createNestedPackage(viewName(model, view));
			viewStrt = applyViewStereotype(view, newpkg);
			model.setValue(chessStereotype, "psmView",
					newpkg.getStereotypeApplication(viewStrt));
			// apply profile
			newpkg.applyProfile(deploymentConfiguration_AnalysisProfile);
			newpkg.applyProfile(timingProfile);

		} catch (Exception e) {
			System.out.println("stereotype application error: " + view
					+ e.getMessage());
		}

	}

	
	public static Stereotype getComponentImplementation(Element element) {
		return UMLUtils.getStereotype(element, "CHESS::ComponentModel::ComponentImplementation");
		/*Stereotype str = ((Profile) CHESSProfile
				.getNestedPackage("ComponentModel"))
				.getOwnedStereotype("ComponentImplementation");
		return str;*/
	}

	public static Stereotype getComponentType(Element element) {
		return UMLUtils.getStereotype(element, "CHESS::ComponentModel::ComponentType");
		/*Stereotype str = ((Profile) CHESSProfile
				.getNestedPackage("ComponentModel"))
				.getOwnedStereotype("ComponentType");
		return str;*/
	}

	public static void loadExternalProfiles(ResourceSet rs) {
		//loadCHESSViewsList(rs);
		//MARTEProfileManager marte = MARTEProfileManager.loadMARTEProfile(rs);
		//SysMLProfileManager sysml = SysMLProfileManager.loadSysMLProfile(rs);
		AddProfileHandler h = new AddProfileHandler();
		IExtensionRegistry reg = Platform.getExtensionRegistry();
		h.executeLoadProfile(reg, rs);
	}

	public static void loadCHESSProfile(ResourceSet rs) {
		// if (instance == null) {
		loadCHESSViewsList(rs);
		// instance = new CHESSProfileManager();
		// }
	}

	public static void loadCHESSViewsList(ResourceSet rs) {
		// if (instance == null) {
		Profile CHESSProfile = (Profile) PackageUtil.loadPackage(
				URI.createURI(CHESSML_PATH), rs);

		Profile coreProfile = (Profile) CHESSProfile.getNestedPackage(CORE_PROFILE);
		Profile viewsProfile = (Profile) coreProfile.getNestedPackage(VIEWS_PROFILE);
		//buildProfiles(CHESSProfile);

		initializeProfileList(CHESSProfile);
		initializeViewList(viewsProfile);

		// }
	}

	private <T extends EObject> void setViewValue(Model model,
			Stereotype chessStereotype, Package newpkg, Class<T> viewClass) {
		// EObject stereoClass = newpkg.getStereotypeApplication(viewStrt);
		EObject c = UMLUtils.getStereotypeApplication(newpkg, viewClass);
		Property ef = null;
		for (Property f : chessStereotype.getAllAttributes()) {
			if (f.getName().equalsIgnoreCase(c.eClass().getName())) {
				ef = f;
				break;
			}
		}
		if (ef != null) {
			model.setValue(chessStereotype, ef.getName(), c);
		}
	}

	public static void createModel(Model currentModel) {
		applyRecursively(currentModel);
		applyCHESSStereotype(currentModel);		
		createViews(currentModel);
	}
	
	@Deprecated
	public static Package getView(Model model, String view){
		return model.getNestedPackage(viewName(model, view));
	}
	
	public static Package getViewByStereotype(Model model, String view){
		EList<Package> packages = model.getNestedPackages();
		for (Package package_ : packages) {
			Stereotype x = package_.getAppliedStereotype("CHESS::Core::CHESSViews::"+view);
			
			if(x!=null)
				return package_;
		}
		return null;
	}

}