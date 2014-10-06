/*
-----------------------------------------------------------------------
--          			CHESS core plugin							 --
--                                                                   --
--                    Copyright (C) 2011-2012                        --
--                 University of Padova, ITALY                       --
--                                                                   --
-- Authors: Alessandro Zovi         azovi@math.unipd.it 		     --
-- 			Stefano Puri											 --
--			Nicholas Pacini											 --
--                                                                   --
-- All rights reserved. This program and the accompanying materials  --
-- are made available under the terms of the Eclipse Public License  --
-- v1.0 which accompanies this distribution, and is available at     --
-- http://www.eclipse.org/legal/epl-v10.html                         --
-----------------------------------------------------------------------
 */

package org.polarsys.chess.core.profiles;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.sysml.blocks.BlocksPackage;
import org.eclipse.papyrus.sysml.requirements.RequirementsPackage;
import org.eclipse.papyrus.sysml.util.SysmlResource;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;
import org.polarsys.chess.core.util.uml.UMLUtils;

/**
 * This class wraps the SysML profile resource and is used for loading the
 * profile and applying its stereotypes.
 * 
 * @author Stefano Puri
 *
 */

public class SysMLProfileManager {
	/*private static Profile SYSMLProfile;
	private static Profile SYSML_requirementProfile;
	private static Profile SYSML_blockProfile;*/

	/*private static ResourceSet resSet = null;

	private static SysMLProfileManager instance;

	private SysMLProfileManager() {
	}*/

	public static SysMLProfileManager loadSysMLProfile(ResourceSet rs) {
		/*if (instance == null) {
			SYSMLProfile = (Profile) PackageUtil.loadPackage(
					URI.createURI(SysmlResource.SYSML_PROFILE_URI), rs);
			SYSML_requirementProfile = (Profile) SYSMLProfile
					.getNestedPackage("Requirements");
			SYSML_blockProfile = (Profile) SYSMLProfile
					.getNestedPackage("Blocks");
			instance = new SysMLProfileManager();
		}
		resSet = rs;
		return instance;*/
		return null;
	}

	/*public Profile getSysMLProfile() {
		return SYSMLProfile;
	}*/

	public static void applyRequirementProfileTo(Package element) {
		Profile SYSML_requirementProfile =  UMLResourcesUtil.getProfile(RequirementsPackage.eINSTANCE, element);
		PackageUtil.applyProfile(element, SYSML_requirementProfile, true);
	}

	public static void applyBlockProfileTo(Package element, boolean withSubProfiles) {
		Profile SYSML_blockProfile =  UMLResourcesUtil.getProfile(BlocksPackage.eINSTANCE, element);
		PackageUtil.applyProfile(element, SYSML_blockProfile, withSubProfiles);
	}

	public static void applySysMLProfileTo(Package element, boolean withSubProfiles) {
		System.out.println("Applying SysML profile to " + element.getName()
				+ "...");
		// PackageUtil.applyProfile(element, SYSMLProfile, withSubProfiles);

		/**
		 * the following is for solve an issue when creating new models
		 * regarding the application of profiles TODO: refactor the forever part
		 * and check for other solutions
		 */

		ResourceSet rs = element.eResource().getResourceSet();
		Profile sysml = (Profile) PackageUtil.loadPackage(
				URI.createURI(SysmlResource.SYSML_PROFILE_URI), rs);
		if (sysml != null) {
			PackageUtil.applyProfile(element, sysml, true);
		}
		/*
		 * Profile ForeverProfile =
		 * (Profile)PackageUtil.loadPackage(URI.createURI
		 * ("pathmap://FOREVER_PROFILE/ForeverProfile.profile.uml"), resSet);
		 * if(ForeverProfile != null) { PackageUtil.applyProfile(element,
		 * ForeverProfile, true); }
		 */

		System.out.println("Applying SysML profile to " + element.getName()
				+ "...DONE");
	}

	public static Stereotype applySatisfyStereotype(Abstraction abs) {
//		Stereotype str = ((Profile) SYSMLProfile
//				.getNestedPackage("Requirements"))
//				.getOwnedStereotype("Satisfy");
//		abs.applyStereotype(str);
//		return str;
		return UMLUtils.applyStereotype(abs, "SysML::Requirements::Satisfy");
	}

	public static void createModel(Model currentModel) {
		applyRequirementProfileTo(currentModel.getNestedPackage(currentModel.getName() + CHESSProfileManager.REQUIREMENT_VIEW));
		applyBlockProfileTo(currentModel.getNestedPackage(currentModel.getName() + CHESSProfileManager.REQUIREMENT_VIEW), true);
	
		applySysMLProfileTo(currentModel.getNestedPackage(currentModel.getName() + CHESSProfileManager.SYSTEM_VIEW), true);
		
		/**
		 * the following instruction applies SysML profile (no inner profiles) to the entire CHESS model and its sub-views (the latter actually not required by the methodology!!!)
		 * this enables Papyrus SysML diagrams creation under the system_view package
		 * 
		 */
		applySysMLProfileTo(currentModel, false);
	}

}