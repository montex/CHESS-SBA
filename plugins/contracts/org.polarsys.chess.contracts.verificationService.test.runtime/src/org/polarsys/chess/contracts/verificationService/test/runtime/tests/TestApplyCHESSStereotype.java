/*******************************************************************************
 * Copyright (c) 2015 Intecs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Nicholas Pacini
 *******************************************************************************/
package org.polarsys.chess.contracts.verificationService.test.runtime.tests;

import org.eclipse.uml2.uml.Element;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;
import org.polarsys.chess.core.profiles.CHESSProfileManager;

public class TestApplyCHESSStereotype {

	EntityUtil entityUtil = EntityUtil.getInstance();
	private Element model;

	@Before
	public void loadModel(){
		model = entityUtil.loadModel("CHESSTestModels", "TestApplyCHESSStereotypeModel.uml");
	}
	
	
	@Test
	public void testApplyCHESSStereotype() {
		
		CHESSProfileManager.applyCHESSStereotype(model);		
		Assert.assertTrue(model.getAppliedStereotype("CHESS::Core::CHESS") != null);
	}

}
