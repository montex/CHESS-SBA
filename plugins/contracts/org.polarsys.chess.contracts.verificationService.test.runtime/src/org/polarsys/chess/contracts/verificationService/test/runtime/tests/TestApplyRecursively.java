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

import org.eclipse.uml2.uml.Model;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;
import org.polarsys.chess.core.profiles.CHESSProfileManager;

public class TestApplyRecursively {

	EntityUtil entityUtil = EntityUtil.getInstance();
	private Model model;
	
	@Before
	public void loadModel(){
		model = entityUtil.loadModel("CHESSTestModels", "TestApplyRecursivelyModel.uml");
	}

	@Test
	public void testApplyRecursively() {

		CHESSProfileManager.applyRecursively(model);
		Assert.assertTrue(model.getAppliedProfile("CHESS") != null);
		Assert.assertTrue(model.getAppliedProfile("CHESS::Core") != null);
		Assert.assertTrue(model.getAppliedProfile("CHESS::Core::CHESSViews") != null);
		
		Assert.assertTrue(model.getAppliedProfile("CHESS::Dependability::FailurePropagation") != null);
		//Assert.assertTrue(model.getAppliedProfile("CHESS::Dependability::DataFlowCallGraph") != null);
		Assert.assertTrue(model.getAppliedProfile("CHESS::Dependability::StateBased") != null);
		Assert.assertTrue(model.getAppliedProfile("CHESS::Dependability::StateBased::StateBasedComponents") != null);
		Assert.assertTrue(model.getAppliedProfile("CHESS::Dependability::StateBased::FaultTolerance") != null);
		Assert.assertTrue(model.getAppliedProfile("CHESS::Dependability::StateBased::MaintenanceMonitoring") != null);
		Assert.assertTrue(model.getAppliedProfile("CHESS::Dependability::StateBased::StateBasedAnalysis") != null);
		//Assert.assertTrue(model.getAppliedProfile("CHESS::Dependability::FMEA") != null);
		Assert.assertTrue(model.getAppliedProfile("CHESS::Dependability::DependableComponent") != null);
		Assert.assertTrue(model.getAppliedProfile("CHESS::Dependability::ThreatsPropagation") != null);
		Assert.assertTrue(model.getAppliedProfile("CHESS::Dependability::MitigationMeans") != null);
		
		//Assert.assertTrue(model.getAppliedProfile("CHESS::Predictability::TimingAnalysis") != null);
		//Assert.assertTrue(model.getAppliedProfile("CHESS::Predictability::TimingAnalysis::TimingConstraints") != null);
		Assert.assertTrue(model.getAppliedProfile("CHESS::Predictability::DeploymentConfiguration") != null);
		Assert.assertTrue(model.getAppliedProfile("CHESS::Predictability::DeploymentConfiguration::HardwareBaseline") != null);
		//Assert.assertTrue(model.getAppliedProfile("CHESS::Predictability::DeploymentConfiguration::DeploymentConfAnalysis") != null);
		Assert.assertTrue(model.getAppliedProfile("CHESS::Predictability::RTComponentModel") != null);
		
		Assert.assertTrue(model.getAppliedProfile("CHESS::ComponentModel") != null);
		
		Assert.assertTrue(model.getAppliedProfile("CHESS::SystemModel::STS") != null);
		
		Assert.assertTrue(model.getAppliedProfile("CHESS::Safety") != null);

	}

}
