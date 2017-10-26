/*******************************************************************************
 *
 * Copyright (c) 2013, 2015 Intecs SpA 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Nicholas Pacini nicholas.pacini@intecs.it 
 * Stefano Puri stefano.puri@intecs.it
 * Laura Baracchi  laura.baracchi@intecs.it  
 * Initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.polarsys.chess.contracts.chessextension.managers;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.polarsys.chess.core.util.uml.ProfileUtils;

/**
 * This class wraps the CHESSContract profile resource and is used for loading the profile and 
 * applying its stereotypes.
 * 
 * @author Stefano Puri
 *
 */

public class CHESSContractProfileManager {	
	
	public static final String CHESSContractProfilePathmap = "pathmap://CHESSContract/CHESSContract.profile.uml";

	private static Profile chessContractProfile;

	private static CHESSContractProfileManager instance;

	private CHESSContractProfileManager() {
	}

	public static CHESSContractProfileManager loadCHESSContractProfile(ResourceSet rs) {
				
		if (instance == null){
			instance = new CHESSContractProfileManager();
		}
		chessContractProfile = (Profile)PackageUtil.loadPackage(URI.createURI(CHESSContractProfilePathmap), rs);
		System.out.println("CHESSContract: loaded profile "+chessContractProfile);
		return instance;
	}

	public Profile getCHESSContractProfile() {
		return chessContractProfile;
	}

	public void applyTo(Model model) {
		ProfileUtils.applyProfileRecursively(chessContractProfile, model);
	
	}
	
	
	
	public void applyCHESSContractProfileTo(Package element, boolean withSubProfiles){
		PackageUtil.applyProfile(element, chessContractProfile, withSubProfiles);
	}
	
	public static Stereotype getContractRefinement() {
		Stereotype str = chessContractProfile.getOwnedStereotype("ContractRefinement");
		return str;
	}
	
	public static Stereotype getFormalProperty(ResourceSet res) {
		loadCHESSContractProfile(res);
		Stereotype str = chessContractProfile.getOwnedStereotype("FormalProperty");
		return str;
	}
	
	public static Stereotype getFormalProperty() {
		Stereotype str = chessContractProfile.getOwnedStereotype("FormalProperty");
		return str;
	}
	
}