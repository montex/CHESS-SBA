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
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.ClientServerPort;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.GCMPackage;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.HLAMPackage;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HRMPackage;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SW_ConcurrencyPackage;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SW_InteractionPackage;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AllocPackage;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.CoreElementsPackage;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.NFPsPackage;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;
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
		
	}

	/**
	 * Applies the MARTE profile to the model.
	 * 
	 * @param model  the model
	 */
	public static void applyTo(Model model) {
		ResourceSet rs = model.eResource().getResourceSet();
		Profile MARTEProfile = (Profile) rs
				.getResource(URI.createURI(MARTE_PATH), true).getContents()
				.get(0);
		PackageUtil.applyProfile(model, MARTEProfile, true);
	}
	
	/**
	 * Applies HRM and nested profiles to the given element.
	 *  
	 * @param element
	 */
	public static void applyHRMProfileTo(Package element) {
		Profile MARTE_HRMProfile =  UMLResourcesUtil.getProfile(HRMPackage.eINSTANCE, element);
		PackageUtil.applyProfile(element, MARTE_HRMProfile, true);
	}
	
	/**
	 * Applied the GCM profile to the given element.
	 * 
	 * @param element
	 */
	public static void applyGCMProfileTo(Package element) {
		Profile MARTE_gcmProfile =  UMLResourcesUtil.getProfile(GCMPackage.eINSTANCE, element);
		PackageUtil.applyProfile(element, MARTE_gcmProfile, false);
	}
	
	/**
	 * Applied the SAM profile to the given element.
	 * 
	 * @param element
	 */
	public static void applySAMProfileTo(Package element) {
		Profile MARTE_SAMProfile =  UMLResourcesUtil.getProfile(SAMPackage.eINSTANCE, element);
		PackageUtil.applyProfile(element, MARTE_SAMProfile, false);
	}
	
	/**
	 * Applied the SAM profile to the given element.
	 * 
	 * @param element
	 */
	public static void applyHLAMProfileTo(Package element) {
		Profile MARTE_HLAMProfile =  UMLResourcesUtil.getProfile(HLAMPackage.eINSTANCE, element);
		PackageUtil.applyProfile(element, MARTE_HLAMProfile, false);
	}
	
	/**
	 * Applied the SAM profile to the given element.
	 * 
	 * @param element
	 */
	public static void applyAllocProfileTo(Package element) {
		Profile MARTE_Alloc =  UMLResourcesUtil.getProfile(AllocPackage.eINSTANCE, element);
		PackageUtil.applyProfile(element, MARTE_Alloc, false);
	}
	
	/**
	 * Applied the SAM profile to the given element.
	 * 
	 * @param element
	 */
	public static void applyGQAMProfileTo(Package element) {
		Profile MARTE_GQAM =  UMLResourcesUtil.getProfile(GQAMPackage.eINSTANCE, element);
		PackageUtil.applyProfile(element, MARTE_GQAM, false);
	}
	
	/**
	 * Applied the SAM profile to the given element.
	 * 
	 * @param element
	 */
	public static void applyNFPsProfileTo(Package element) {
		Profile MARTE_NFPs =  UMLResourcesUtil.getProfile(NFPsPackage.eINSTANCE, element);
		PackageUtil.applyProfile(element, MARTE_NFPs, false);
	}
	
	/**
	 * Applied the SAM profile to the given element.
	 * 
	 * @param element
	 */
	public static void applyVSLProfileTo(Package element) {
		Profile MARTE_VSL =  UMLResourcesUtil.getProfile(VSLPackage.eINSTANCE, element);
		PackageUtil.applyProfile(element, MARTE_VSL, false);
	}
	
	/**
	 * Applied the SAM profile to the given element.
	 * 
	 * @param element
	 */
	public static void applyDataTypeProfileTo(Package element) {
		Profile MARTE_VSL_DATATYPES =  UMLResourcesUtil.getProfile(DataTypesPackage.eINSTANCE, element);
		PackageUtil.applyProfile(element, MARTE_VSL_DATATYPES, false);
	}
	
	/**
	 * Applied the SAM profile to the given element.
	 * 
	 * @param element
	 */
	public static void applySwConcurrencyProfileTo(Package element) {
		Profile MARTE_SW_CONCURRENCY =  UMLResourcesUtil.getProfile(SW_ConcurrencyPackage.eINSTANCE, element);
		PackageUtil.applyProfile(element, MARTE_SW_CONCURRENCY, false);
	}
	
	/**
	 * Applied the SwInteraction profile to the given element.
	 * 
	 * @param element
	 */
	public static void applySwInteractionProfileTo(Package element) {
		Profile MARTE_SW_INTERACTION =  UMLResourcesUtil.getProfile(SW_InteractionPackage.eINSTANCE, element);
		PackageUtil.applyProfile(element, MARTE_SW_INTERACTION, false);
	}
	
	/**
	 * Applied the Core profile to the given element.
	 * 
	 * @param element
	 */
	public static void applyCoreElementProfileTo(Package element) {
		Profile MARTE_CORE_ELEMENT =  UMLResourcesUtil.getProfile(CoreElementsPackage.eINSTANCE, element);
		PackageUtil.applyProfile(element, MARTE_CORE_ELEMENT, false);
	}
	
	/**
	 * Applied the NFP profile to the given element.
	 * 
	 * @param element
	 */
	public static void applyNFPProfileTo(Package element) {
		Profile NFPs =  UMLResourcesUtil.getProfile(NFPsPackage.eINSTANCE, element);
		PackageUtil.applyProfile(element, NFPs, false);
	}
	
	/**
	 * Applied the GRM and nested profiles to the given element.
	 * 
	 * @param element
	 */
	public static void applyGRMProfileTo(Package element) {
		Profile MARTE_GRMProfile =  UMLResourcesUtil.getProfile(GRMPackage.eINSTANCE, element);
		PackageUtil.applyProfile(element, MARTE_GRMProfile, true);
	}

	/**
	 * Applies the stereotype referenced by its name to the given element.
	 * 
	 * @param stereoName  the name (not the qualified name)
	 * @param element  the element
	 */
	public static void applyStereotypeTo(String stereoName, Element element) {
		if (stereoName.equalsIgnoreCase("Allocate")) {
			
			//UMLUtils.applyStereotype(element, "MARTE::MARTE_Foundations::Alloc::Allocated");
			UMLUtils.applyStereotype(element, "MARTE::MARTE_Foundations::Alloc::Allocate");
		}
		
		if (stereoName.equalsIgnoreCase("ClientServerPort")) {
			
			UMLUtils.applyStereotype(element, "MARTE::MARTE_DesignModel::GCM::ClientServerPort");

		}
		
		if (stereoName.equalsIgnoreCase("FlowPort")) {
			
			UMLUtils.applyStereotype(element, "MARTE::MARTE_DesignModel::GCM::FlowPort");
		}
		
		// else if ...
	}
	
	/**
	 * Return the {@link ClientServerPort} stereotype of the given element.
	 * 
	 * @param element  the element
	 * @return  the stereotype applied
	 */
	public static Stereotype getClientServerPort(Element element)
	{

		return UMLUtils.getStereotype(element, "MARTE::MARTE_DesignModel::GCM::ClientServerPort");
		
	}

	/**
	 * Initialize the model with the needed profiles.
	 * 
	 * @param currentModel  the model
	 */
	public static void createModel(Model currentModel) {
		applyGCMProfileTo(currentModel.getNestedPackage(currentModel.getName() + CHESSProfileManager.COMPONENT_VIEW));
		applyAllocProfileTo(currentModel.getNestedPackage(currentModel.getName() + CHESSProfileManager.COMPONENT_VIEW));
		
		Package deploViewPack = currentModel.getNestedPackage(currentModel.getName() + CHESSProfileManager.DEPLOYMENT_VIEW);
		applyHRMProfileTo(deploViewPack);
		applyAllocProfileTo(deploViewPack);
		applySwConcurrencyProfileTo(deploViewPack);
		applyGCMProfileTo(deploViewPack);
		applyGQAMProfileTo(deploViewPack);
		applyNFPProfileTo(currentModel);
		
		applySAMProfileTo(currentModel.getNestedPackage(currentModel.getName() + CHESSProfileManager.ANALYSIS_VIEW).getNestedPackage(currentModel.getName() + CHESSProfileManager.RT_ANALYSIS_VIEW));
		applyGQAMProfileTo(currentModel.getNestedPackage(currentModel.getName() + CHESSProfileManager.ANALYSIS_VIEW).getNestedPackage(currentModel.getName() + CHESSProfileManager.RT_ANALYSIS_VIEW));
		
		applySAMProfileTo(currentModel.getNestedPackage(currentModel.getName() + CHESSProfileManager.PSM_VIEW));
		applySwConcurrencyProfileTo(currentModel.getNestedPackage(currentModel.getName() + CHESSProfileManager.PSM_VIEW));
		applySwInteractionProfileTo(currentModel.getNestedPackage(currentModel.getName() + CHESSProfileManager.PSM_VIEW));
		
		applyCoreElementProfileTo(currentModel);
		
		applyDataTypeProfileTo(currentModel);
		
		applyGRMProfileTo(currentModel.getNestedPackage(currentModel.getName() + CHESSProfileManager.COMPONENT_VIEW));
		applyGRMProfileTo(deploViewPack);
		applyGRMProfileTo(currentModel.getNestedPackage(currentModel.getName() + CHESSProfileManager.SYSTEM_VIEW));
		
	}
	
	
	
}