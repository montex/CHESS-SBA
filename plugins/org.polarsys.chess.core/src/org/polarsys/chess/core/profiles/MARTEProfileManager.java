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

import java.util.HashSet;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SAMPackage;
import org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.VSLPackage;
import org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.DataTypesPackage;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.GCMPackage;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.HLAMPackage;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HRMPackage;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SW_ConcurrencyPackage;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AllocPackage;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatsPropagationPackage;
import org.polarsys.chess.core.util.uml.UMLUtils;

/**
 * This class wraps the MARTE profile resource and is used for loading the profile and 
 * applying its stereotypes.
 * 
 * @author Alessandro Zovi
 *
 */

public class MARTEProfileManager {	
	public static final String MARTE = "MARTE";
	public static final String NFPs = "NFPs";
	public static final String Time = "Time";
	public static final String GRM = "GRM";
	public static final String Alloc = "Alloc";
	public static final String CoreElements = "CoreElements";
	public static final String HLAM = "HLAM";
	public static final String HRM = "HRM";
	public static final String HwLogical = "HwLogical";
	public static final String HwComputing = "HwComputing";
	public static final String HwCommunication = "HwCommunication";
	public static final String HwTiming = "HwTiming";
	public static final String HwDevice = "HwDevice";
	public static final String HwStorage = "HwStorage";
	public static final String HwMemory = "HwMemory";
	public static final String HwStorageManager = "HwStorageManager";
	public static final String HwPhysical = "HwPhysical";
	public static final String HwLayout = "HwLayout";
	public static final String HwPower = "HwPower";
	public static final String HwGeneral = "HwGeneral";
	public static final String SRM = "SRM";
	public static final String SW_ResourceCore = "SW_ResourceCore";
	public static final String SW_Concurrency = "SW_Concurrency";
	public static final String SW_Brokering = "SW_Brokering";
	public static final String SW_Interaction = "SW_Interaction";
	public static final String GCM = "GCM";
	public static final String GQAM = "GQAM";
	public static final String SAM = "SAM";
	public static final String PAM = "PAM";
	public static final String RSM = "RSM";
	public static final String VSL = "VSL";
	public static final String DataTypes = "DataTypes";
	public static final String Variables = "Variables";

	public static final String MARTE_PATH = "pathmap://Papyrus_PROFILES/MARTE.profile.uml";

	/*private static Profile MARTEProfile;
	private static Profile MARTE_gcmProfile;
	private static Profile MARTE_HRMProfile;
	private static Profile MARTE_SAMProfile;
	private static Profile MARTE_HLAMProfile;
	private static Profile MARTE_Alloc;
	private static Profile MARTE_GQAM;
	private static Profile MARTE_VSL;
	private static Profile MARTE_VSL_DATATYPES;
	private static Profile MARTE_SW_CONCURRENCY;*/

	//private static MARTEProfileManager instance;
	public static HashSet<String> PREDEFINED_PROFILES = new HashSet<String>();
	static {
		MARTEProfileManager.PREDEFINED_PROFILES.add(MARTEProfileManager.MARTE);
		MARTEProfileManager.PREDEFINED_PROFILES.add(MARTEProfileManager.NFPs);
		MARTEProfileManager.PREDEFINED_PROFILES.add(MARTEProfileManager.Time);
		MARTEProfileManager.PREDEFINED_PROFILES.add(MARTEProfileManager.GRM);
		MARTEProfileManager.PREDEFINED_PROFILES.add(MARTEProfileManager.Alloc);
		MARTEProfileManager.PREDEFINED_PROFILES.add(MARTEProfileManager.CoreElements);
		MARTEProfileManager.PREDEFINED_PROFILES.add(MARTEProfileManager.HLAM);
		MARTEProfileManager.PREDEFINED_PROFILES.add(MARTEProfileManager.HRM);
		MARTEProfileManager.PREDEFINED_PROFILES.add(MARTEProfileManager.HwLogical);
		MARTEProfileManager.PREDEFINED_PROFILES.add(MARTEProfileManager.HwComputing);
		MARTEProfileManager.PREDEFINED_PROFILES.add(MARTEProfileManager.HwCommunication);
		MARTEProfileManager.PREDEFINED_PROFILES.add(MARTEProfileManager.HwTiming);
		MARTEProfileManager.PREDEFINED_PROFILES.add(MARTEProfileManager.HwDevice);
		MARTEProfileManager.PREDEFINED_PROFILES.add(MARTEProfileManager.HwStorage);
		MARTEProfileManager.PREDEFINED_PROFILES.add(MARTEProfileManager.HwMemory);
		MARTEProfileManager.PREDEFINED_PROFILES.add(MARTEProfileManager.HwStorageManager);
		MARTEProfileManager.PREDEFINED_PROFILES.add(MARTEProfileManager.HwPhysical);
		MARTEProfileManager.PREDEFINED_PROFILES.add(MARTEProfileManager.HwLayout);
		MARTEProfileManager.PREDEFINED_PROFILES.add(MARTEProfileManager.HwPower);
		MARTEProfileManager.PREDEFINED_PROFILES.add(MARTEProfileManager.HwGeneral);
		MARTEProfileManager.PREDEFINED_PROFILES.add(MARTEProfileManager.SRM);
		MARTEProfileManager.PREDEFINED_PROFILES.add(MARTEProfileManager.SW_ResourceCore);
		MARTEProfileManager.PREDEFINED_PROFILES.add(MARTEProfileManager.SW_Concurrency);
		MARTEProfileManager.PREDEFINED_PROFILES.add(MARTEProfileManager.SW_Brokering);
		MARTEProfileManager.PREDEFINED_PROFILES.add(MARTEProfileManager.SW_Interaction);
		MARTEProfileManager.PREDEFINED_PROFILES.add(MARTEProfileManager.GCM);
		MARTEProfileManager.PREDEFINED_PROFILES.add(MARTEProfileManager.GQAM);
		MARTEProfileManager.PREDEFINED_PROFILES.add(MARTEProfileManager.SAM);
		MARTEProfileManager.PREDEFINED_PROFILES.add(MARTEProfileManager.PAM);
		MARTEProfileManager.PREDEFINED_PROFILES.add(MARTEProfileManager.RSM);
		MARTEProfileManager.PREDEFINED_PROFILES.add(MARTEProfileManager.VSL);
		MARTEProfileManager.PREDEFINED_PROFILES.add(MARTEProfileManager.DataTypes);
		MARTEProfileManager.PREDEFINED_PROFILES.add(MARTEProfileManager.Variables);
	}

	
	public static void loadMARTEProfile(ResourceSet rs) {
		
//		//TODO this method should be refactored	in two, one for the singletone pattern and the other for the loading of the profile...
//		if (instance == null){
//			instance = new MARTEProfileManager();
//		}
		
		/*MARTEProfile = (Profile) rs
				.getResource(URI.createURI(MARTE_PATH), true).getContents()
				.get(0);
		MARTE_gcmProfile = (Profile) MARTEProfile.getNestedPackage(
				"MARTE_DesignModel").getNestedPackage("GCM");
		Object obj = MARTE_gcmProfile.getEAnnotations();
		System.out.println(obj);
		
		MARTE_HRMProfile = (Profile) MARTEProfile.getNestedPackage(
		"MARTE_DesignModel").getNestedPackage("HRM");
		
		MARTE_SAMProfile = (Profile) MARTEProfile.getNestedPackage(
		"MARTE_AnalysisModel").getNestedPackage("SAM");
		
		MARTE_HLAMProfile = (Profile) MARTEProfile.getNestedPackage(
		"MARTE_DesignModel").getNestedPackage("HLAM");
		
		MARTE_Alloc = (Profile) MARTEProfile.getNestedPackage(
		"MARTE_Foundations").getNestedPackage("Alloc");
		
		MARTE_GQAM = (Profile) MARTEProfile.getNestedPackage(
				"MARTE_AnalysisModel").getNestedPackage("GQAM");
		
		MARTE_VSL = (Profile) MARTEProfile.getNestedPackage(
				"MARTE_Annexes").getNestedPackage("VSL");
		
		MARTE_VSL_DATATYPES = (Profile) MARTEProfile.getNestedPackage(
				"MARTE_Annexes").getNestedPackage("VSL").getNestedPackage("DataTypes");		
		
		MARTE_SW_CONCURRENCY = (Profile) MARTEProfile.getNestedPackage(
				"MARTE_DesignModel").getNestedPackage("SRM").getNestedPackage("SW_Concurrency");
		*/
		
//		return instance;
	}

	/*public Profile getCHESSProfile() {
		return MARTEProfile;
	}*/

	public static void applyTo(Model model) {
		ResourceSet rs = model.eResource().getResourceSet();
		Profile MARTEProfile = (Profile) rs
				.getResource(URI.createURI(MARTE_PATH), true).getContents()
				.get(0);
		PackageUtil.applyProfile(model, MARTEProfile, true);
	}
	
	/**
	 * applies HRM and nested profiles
	 * @param element
	 */
	public static void applyHRMProfileTo(Package element) {
		Profile MARTE_HRMProfile =  UMLResourcesUtil.getProfile(HRMPackage.eINSTANCE, element);
		PackageUtil.applyProfile(element, MARTE_HRMProfile, true);
	}
	
	public static void applyGCMProfileTo(Package element) {
		Profile MARTE_gcmProfile =  UMLResourcesUtil.getProfile(GCMPackage.eINSTANCE, element);
		PackageUtil.applyProfile(element, MARTE_gcmProfile, false);
	}
	
	public static void applySAMProfileTo(Package element) {
		Profile MARTE_SAMProfile =  UMLResourcesUtil.getProfile(SAMPackage.eINSTANCE, element);
		PackageUtil.applyProfile(element, MARTE_SAMProfile, false);
	}
	
	public static void applyHLAMProfileTo(Package element) {
		Profile MARTE_HLAMProfile =  UMLResourcesUtil.getProfile(HLAMPackage.eINSTANCE, element);
		PackageUtil.applyProfile(element, MARTE_HLAMProfile, false);
	}
	
	public static void applyAllocProfileTo(Package element) {
		Profile MARTE_Alloc =  UMLResourcesUtil.getProfile(AllocPackage.eINSTANCE, element);
		PackageUtil.applyProfile(element, MARTE_Alloc, false);
	}
	
	public static void applyGQAMProfileTo(Package element) {
		Profile MARTE_GQAM =  UMLResourcesUtil.getProfile(GQAMPackage.eINSTANCE, element);
		PackageUtil.applyProfile(element, MARTE_GQAM, false);
	}
	
	public static void applyVSLProfileTo(Package element) {
		Profile MARTE_VSL =  UMLResourcesUtil.getProfile(VSLPackage.eINSTANCE, element);
		PackageUtil.applyProfile(element, MARTE_VSL, false);
	}
	
	public static void applyDataTypeProfileTo(Package element) {
		Profile MARTE_VSL_DATATYPES =  UMLResourcesUtil.getProfile(DataTypesPackage.eINSTANCE, element);
		PackageUtil.applyProfile(element, MARTE_VSL_DATATYPES, false);
	}
	
	public static void applySwConcurrencyProfieTo(Package element) {
		Profile MARTE_SW_CONCURRENCY =  UMLResourcesUtil.getProfile(SW_ConcurrencyPackage.eINSTANCE, element);
		PackageUtil.applyProfile(element, MARTE_SW_CONCURRENCY, false);
	}

	public static void applyStereotypeTo(String stereoName, Element element) {
		if (stereoName.equalsIgnoreCase("Allocate")) {
			/*if(MARTE_Alloc == null){
				if(MARTEProfile == null){ 
					ResourceSet rs = element.eResource().getResourceSet();
					MARTEProfile = (Profile) rs.getResource(URI.createURI(MARTE_PATH), true).getContents().get(0);
				}
				MARTE_Alloc = (Profile) MARTEProfile.getNestedPackage("MARTE_Foundations").getNestedPackage("Alloc");
			}
			Stereotype str = ((Profile) MARTE_Alloc).getOwnedStereotype("Allocate");
			element.applyStereotype(str);*/
			UMLUtils.applyStereotype(element, "MARTE::MARTE_Foundations::Alloc::Allocated");
		}
		
		if (stereoName.equalsIgnoreCase("ClientServerPort")) {
			/*if(MARTE_gcmProfile == null){
				if(MARTEProfile == null){ 
					ResourceSet rs = element.eResource().getResourceSet();
					MARTEProfile = (Profile) rs.getResource(URI.createURI(MARTE_PATH), true).getContents().get(0);
				}
				MARTE_gcmProfile = (Profile) MARTEProfile.getNestedPackage("MARTE_DesignModel").getNestedPackage("GCM");
			}
			Stereotype str = ((Profile) MARTE_gcmProfile).getOwnedStereotype("ClientServerPort");
			element.applyStereotype(str);*/
			UMLUtils.applyStereotype(element, "MARTE::MARTE_DesignModel::GCM::ClientServerPort");
			
			
		}
		
		if (stereoName.equalsIgnoreCase("FlowPort")) {
			/*if(MARTE_gcmProfile == null){
				if(MARTEProfile == null){ 
					ResourceSet rs = element.eResource().getResourceSet();
					MARTEProfile = (Profile) rs.getResource(URI.createURI(MARTE_PATH), true).getContents().get(0);
				}
				MARTE_gcmProfile = (Profile) MARTEProfile.getNestedPackage("MARTE_DesignModel").getNestedPackage("GCM");
			}
			Stereotype str = ((Profile) MARTE_gcmProfile).getOwnedStereotype("FlowPort");			
			element.applyStereotype(str);*/
			
			UMLUtils.applyStereotype(element, "MARTE::MARTE_DesignModel::GCM::FlowPort");
		}
		
		// else if ...
	}
	
	public static Stereotype getClientServerPort(Element element)
	{
		/*Stereotype str = ((Profile) MARTEProfile.getNestedPackage("MARTE_DesignModel").getNestedPackage("GCM")).getOwnedStereotype("ClientServerPort");
		return str;*/
		return UMLUtils.getStereotype(element, "MARTE::MARTE_DesignModel::GCM::ClientServerPort");
		
	}

	public static void createModel(Model currentModel) {
		applyGCMProfileTo(currentModel.getNestedPackage(currentModel.getName() + CHESSProfileManager.COMPONENT_VIEW));
		
		//marte.applyHLAMProfileTo(currentModel.getNestedPackage(currentModel.getName() + CHESSProfileManager.COMPONENT_VIEW));
		
		applyHRMProfileTo(currentModel.getNestedPackage(currentModel.getName() + CHESSProfileManager.DEPLOYMENT_VIEW));
		applyAllocProfileTo(currentModel.getNestedPackage(currentModel.getName() + CHESSProfileManager.DEPLOYMENT_VIEW));
		applySwConcurrencyProfieTo(currentModel.getNestedPackage(currentModel.getName() + CHESSProfileManager.DEPLOYMENT_VIEW));
		
		
		//bug #11482 
		applyAllocProfileTo(currentModel.getNestedPackage(currentModel.getName() + CHESSProfileManager.COMPONENT_VIEW));
		
		applySAMProfileTo(currentModel.getNestedPackage(currentModel.getName() + CHESSProfileManager.ANALYSIS_VIEW).getNestedPackage(currentModel.getName() + CHESSProfileManager.RT_ANALYSIS_VIEW));
		
		applyGCMProfileTo(currentModel.getNestedPackage(currentModel.getName() + CHESSProfileManager.DEPLOYMENT_VIEW));
		
		//for GaExecHost and GaCommHost
		applyGQAMProfileTo(currentModel.getNestedPackage(currentModel.getName() + CHESSProfileManager.DEPLOYMENT_VIEW));
		
		applyDataTypeProfileTo(currentModel);
	}
	
	
	
}