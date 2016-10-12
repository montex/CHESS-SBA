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

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.uml2.uml.Model;

import org.polarsys.chess.core.extensionpoint.IAddProfile;

public class ApplyCHESSContractProfile implements IAddProfile {

	public ApplyCHESSContractProfile() {
	}

	@Override
	public void addProfile(Model owner, ResourceSet resourceSet) {
		CHESSContractProfileManager contract = CHESSContractProfileManager.loadCHESSContractProfile(resourceSet);
		if (owner != null)
			contract.applyCHESSContractProfileTo(owner, true);
	}
	
	@Override
	public void loadProfile(ResourceSet resourceSet) {
		CHESSContractProfileManager.loadCHESSContractProfile(resourceSet);
	}

}
