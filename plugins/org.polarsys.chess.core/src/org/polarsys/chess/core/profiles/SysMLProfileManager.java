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
 */

public class SysMLProfileManager {
	
	public static void applyRequirementProfileTo(Package element) {
		Profile SYSML_requirementProfile =  UMLResourcesUtil.getProfile(RequirementsPackage.eINSTANCE, element);
		PackageUtil.applyProfile(element, SYSML_requirementProfile, true);
	}

	public static void applyBlockProfileTo(Package element, boolean withSubProfiles) {
		Profile SYSML_blockProfile =  UMLResourcesUtil.getProfile(BlocksPackage.eINSTANCE, element);
		PackageUtil.applyProfile(element, SYSML_blockProfile, withSubProfiles);
	}

	public static void applySysMLProfileTo(Package element, boolean withSubProfiles) {
		
		/**
		 * the following is for avoid issues when creating new models
		 */

		ResourceSet rs = element.eResource().getResourceSet();
		Profile sysml = (Profile) PackageUtil.loadPackage(
				URI.createURI(SysmlResource.SYSML_PROFILE_URI), rs);
		if (sysml != null) {
			PackageUtil.applyProfile(element, sysml, true);
		}

	}

	public static Stereotype applySatisfyStereotype(Abstraction abs) {

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