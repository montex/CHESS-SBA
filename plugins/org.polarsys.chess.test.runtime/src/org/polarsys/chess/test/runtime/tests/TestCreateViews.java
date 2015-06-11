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
package org.polarsys.chess.test.runtime.tests;

import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Stereotype;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.polarsys.chess.chessmlprofile.Core.CHESS;
import org.polarsys.chess.chessmlprofile.Core.CHESSViews.AnalysisView;
import org.polarsys.chess.chessmlprofile.Core.CHESSViews.ComponentView;
import org.polarsys.chess.chessmlprofile.Core.CHESSViews.DependabilityAnalysisView;
import org.polarsys.chess.chessmlprofile.Core.CHESSViews.DeploymentView;
import org.polarsys.chess.chessmlprofile.Core.CHESSViews.PSMView;
import org.polarsys.chess.chessmlprofile.Core.CHESSViews.RTAnalysisView;
import org.polarsys.chess.chessmlprofile.Core.CHESSViews.RequirementView;
import org.polarsys.chess.chessmlprofile.Core.CHESSViews.SystemView;
import org.polarsys.chess.core.profiles.CHESSProfileManager;
import org.polarsys.chess.test.runtime.util.TestUtil;

public class TestCreateViews {
	
	private Model model;
	
	@Before
	public void loadModel(){
		model = TestUtil.loadTestModel("CHESSTestModels", "TestCreateViewsModel.uml");
	}

	@Test
	public void testcreateViews() {
		
		CHESSProfileManager.createViews(model);
		
		//check that the CHESS stereotype properties are set
		Stereotype chessStereotype = model.getAppliedStereotype("CHESS::Core::CHESS");
		CHESS chess = (CHESS) model.getStereotypeApplication(chessStereotype);
		
		AnalysisView analysisView = chess.getAnalysisView();
		ComponentView componentView = chess.getComponentView();
		DeploymentView deploymentView = chess.getDeploymentView();
		PSMView psmView = chess.getPsmView();
		RequirementView requirementView = chess.getRequirementView();
		SystemView systemView = chess.getSystemView();
		
		Assert.assertNotNull(analysisView);
		Assert.assertNotNull(componentView);
		Assert.assertNotNull(deploymentView);
		Assert.assertNotNull(psmView);
		Assert.assertNotNull(requirementView);
		Assert.assertNotNull(systemView);
		
		DependabilityAnalysisView depView = analysisView.getDepanalysisview();
		RTAnalysisView rtView = analysisView.getRtanalysisview();
		Assert.assertNotNull(depView);
		Assert.assertNotNull(rtView);
		
		//check that the views exists as packages and that they are owned by the model
		Package analysisViewPkg = analysisView.getBase_Package();
		Package componentViewPkg = componentView.getBase_Package();
		Package deploymentViewPkg = deploymentView.getBase_Package();
		Package psmViewPkg = psmView.getBase_Package();
		Package requirementViewPkg = requirementView.getBase_Package();
		Package systemViewPkg = systemView.getBase_Package();
		Package depViewPkg = depView.getBase_Package();
		Package rtViewPkg =  rtView.getBase_Package();
		Assert.assertNotNull(model.getNestedPackage(analysisViewPkg.getName()));
		Assert.assertNotNull(model.getNestedPackage(componentViewPkg.getName()));
		Assert.assertNotNull(model.getNestedPackage(deploymentViewPkg.getName()));
		Assert.assertNotNull(model.getNestedPackage(psmViewPkg.getName()));
		Assert.assertNotNull(model.getNestedPackage(requirementViewPkg.getName()));
		Assert.assertNotNull(model.getNestedPackage(systemViewPkg.getName()));
		Assert.assertNotNull(analysisViewPkg.getNestedPackage(depViewPkg.getName()));
		Assert.assertNotNull(analysisViewPkg.getNestedPackage(rtViewPkg.getName()));
		
		//check that each view package has the right profiles applied on it
		Assert.assertNotNull(componentViewPkg.getAppliedProfile("CHESS::ComponentModel"));
		Assert.assertNotNull(componentViewPkg.getAppliedProfile("CHESS::Predictability::RTComponentModel"));
		Assert.assertNotNull(componentViewPkg.getAppliedProfile("CHESS::Dependability::StateBased::StateBasedComponents"));
		Assert.assertNotNull(componentViewPkg.getAppliedProfile("CHESS::Dependability::StateBased::FaultTolerance"));
		Assert.assertNotNull(componentViewPkg.getAppliedProfile("CHESS::Dependability::StateBased::MaintenanceMonitoring"));
		Assert.assertNotNull(componentViewPkg.getAppliedProfile("CHESS::Dependability::FailurePropagation"));
		Assert.assertNotNull(componentViewPkg.getAppliedProfile("CHESS::Dependability::ThreatsPropagation"));
		Assert.assertNotNull(componentViewPkg.getAppliedProfile("CHESS::Dependability::DependableComponent"));
		Assert.assertNotNull(componentViewPkg.getAppliedProfile("CHESS::Dependability::MitigationMeans"));
		
		Assert.assertNotNull(deploymentViewPkg.getAppliedProfile("CHESS::Predictability::DeploymentConfiguration::HardwareBaseline"));
		Assert.assertNotNull(deploymentViewPkg.getAppliedProfile("CHESS::Predictability::RTComponentModel"));
		Assert.assertNotNull(deploymentViewPkg.getAppliedProfile("CHESS::Dependability::StateBased::StateBasedComponents"));
		Assert.assertNotNull(deploymentViewPkg.getAppliedProfile("CHESS::Dependability::StateBased::FaultTolerance"));
		Assert.assertNotNull(deploymentViewPkg.getAppliedProfile("CHESS::Dependability::StateBased::MaintenanceMonitoring"));
		Assert.assertNotNull(deploymentViewPkg.getAppliedProfile("CHESS::Dependability::FailurePropagation"));
		Assert.assertNotNull(deploymentViewPkg.getAppliedProfile("CHESS::Dependability::ThreatsPropagation"));
		Assert.assertNotNull(deploymentViewPkg.getAppliedProfile("CHESS::Dependability::DependableComponent"));
		Assert.assertNotNull(deploymentViewPkg.getAppliedProfile("CHESS::Dependability::FMEA"));
		
		Assert.assertNotNull(psmViewPkg.getAppliedProfile("CHESS::Predictability::DeploymentConfiguration::DeploymentConfAnalysis"));
		Assert.assertNotNull(psmViewPkg.getAppliedProfile("CHESS::Predictability::TimingAnalysis"));
		
		Assert.assertNotNull(systemViewPkg.getAppliedProfile("CHESS::Dependability::StateBased::StateBasedComponents"));
		Assert.assertNotNull(systemViewPkg.getAppliedProfile("CHESS::Dependability::StateBased::FaultTolerance"));
		Assert.assertNotNull(systemViewPkg.getAppliedProfile("CHESS::Dependability::StateBased::MaintenanceMonitoring"));
		Assert.assertNotNull(systemViewPkg.getAppliedProfile("CHESS::Dependability::FailurePropagation"));
		Assert.assertNotNull(systemViewPkg.getAppliedProfile("CHESS::Dependability::ThreatsPropagation"));
		Assert.assertNotNull(systemViewPkg.getAppliedProfile("CHESS::Dependability::DependableComponent"));
		Assert.assertNotNull(systemViewPkg.getAppliedProfile("CHESS::Dependability::MitigationMeans"));
		Assert.assertNotNull(systemViewPkg.getAppliedProfile("CHESS::SystemModel::STS"));
		
		Assert.assertNotNull(depViewPkg.getAppliedProfile("CHESS::Dependability::StateBased::StateBasedAnalysis"));
		Assert.assertNotNull(depViewPkg.getAppliedProfile("CHESS::Dependability::FailurePropagation"));
		Assert.assertNotNull(depViewPkg.getAppliedProfile("CHESS::Dependability::FMEA"));
	}
}
