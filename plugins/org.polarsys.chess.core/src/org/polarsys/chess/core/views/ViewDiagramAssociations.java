/*
-----------------------------------------------------------------------
--          			CHESS core plugin							 --
--                                                                   --
--                    Copyright (C) 2011-2012                        --
--                 University of Padova, ITALY                       --
--                                                                   --
-- Author: Alessandro Zovi         azovi@math.unipd.it 		         --
--                                                                   --
-- All rights reserved. This program and the accompanying materials  --
-- are made available under the terms of the Eclipse Public License  --
-- v1.0 which accompanies this distribution, and is available at     --
-- http://www.eclipse.org/legal/epl-v10.html                         --
-----------------------------------------------------------------------
*/

package org.polarsys.chess.core.views;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.polarsys.chess.core.profiles.CHESSProfileManager;

public class ViewDiagramAssociations {

	private static Set<String> UMLDiagrams = new HashSet<String>();
	private static Set<String> SYSMLDiagrams = new HashSet<String>();

	public static HashMap<String, HashSet<String>> viewDiagramsAssociation = new HashMap<String, HashSet<String>>();

	public static String ANYDIAGRAM = "*";
	
	public static String classDiagram = "PapyrusUMLClassDiagram";
	public static String compositeDiagram = "CompositeStructure";
	public static String activityDiagram = "PapyrusUMLActivityDiagram";
	public static String communicationDiagram = "PapyrusUMLCommunicationDiagram";
	
	
	public static String profileDiagram = "PapyrusUMLProfileDiagram";
	public static String sequenceDiagram = "PapyrusUMLSequenceDiagram";
	public static String stateMachineDiagram = "PapyrusUMLStateMachineDiagram";
	
	public static String useCaseDiagram = "UseCase";
	
	public static String blockDiagram = "BlockDefinition";
	public static String internalBlockDiagram = "InternalBlock";
	public static String parametricDiagram = "Parametric";
	public static String requirementDiagram = "RequirementDiagram";
	
	public static HashMap<String, String> papyrusNames2Standard = new HashMap<String, String>(12);
	
	
	static {
		papyrusNames2Standard.put(classDiagram, "Class");
		papyrusNames2Standard.put(compositeDiagram, "Composite");
		papyrusNames2Standard.put(activityDiagram, "Activity");
		papyrusNames2Standard.put(communicationDiagram, "Communication");
		papyrusNames2Standard.put(profileDiagram, "Profile");
		papyrusNames2Standard.put(sequenceDiagram, "Sequence");
		papyrusNames2Standard.put(stateMachineDiagram, "StateMachine");
		papyrusNames2Standard.put(useCaseDiagram, "UseCase");
		papyrusNames2Standard.put(blockDiagram, "Block");
		papyrusNames2Standard.put(internalBlockDiagram, "InternalBlock");
		papyrusNames2Standard.put(parametricDiagram, "Parametric");
		papyrusNames2Standard.put(requirementDiagram, "Requirement");
		
		UMLDiagrams.add(activityDiagram);
		UMLDiagrams.add(communicationDiagram);
		UMLDiagrams.add("Package");//???
		UMLDiagrams.add(profileDiagram);
		UMLDiagrams.add(sequenceDiagram);
		UMLDiagrams.add(stateMachineDiagram);
		UMLDiagrams.add(classDiagram);
		UMLDiagrams.add(compositeDiagram);
		UMLDiagrams.add(useCaseDiagram);

		SYSMLDiagrams.add(blockDiagram);
		SYSMLDiagrams.add(internalBlockDiagram);
		SYSMLDiagrams.add(parametricDiagram);
		SYSMLDiagrams.add(requirementDiagram);

		// Diagrams allowed in Functional view , now Component View
		HashSet<String> componentViewDiagrams = new HashSet<String>();
		componentViewDiagrams.add(classDiagram);
		componentViewDiagrams.add(compositeDiagram);
		componentViewDiagrams.add(stateMachineDiagram);
		componentViewDiagrams.add(activityDiagram);
		componentViewDiagrams.add(sequenceDiagram);
		
		//TODO DEBUG
		//componentViewDiagrams.add(communicationDiagram);
		
		viewDiagramsAssociation.put(CHESSProfileManager.COMPONENT_VIEW,
				componentViewDiagrams);

		// Diagrams allowed in Extra-functional view
//		viewDiagramsAssociation.put(CHESSProfileManager.EXTRAFUNCTIONAL_VIEW,
//				new HashSet<String>());

		// Diagrams allowed in Requirement view
		HashSet<String> requirementDiagrams = new HashSet<String>();
		requirementDiagrams.add(requirementDiagram);
		viewDiagramsAssociation.put(CHESSProfileManager.REQUIREMENT_VIEW,
				requirementDiagrams);

		// Diagrams allowed in Deployment view
		HashSet<String> deploymentDiagrams = new HashSet<String>();
		deploymentDiagrams.add(classDiagram);
		deploymentDiagrams.add(compositeDiagram);
		deploymentDiagrams.add(stateMachineDiagram);
		viewDiagramsAssociation.put(CHESSProfileManager.DEPLOYMENT_VIEW,
				deploymentDiagrams);
		
		//diagrams for DepAnalysisView to be defined
		HashSet<String> analysisDiagrams = new HashSet<String>();
		analysisDiagrams.add("PapyrusUMLActivityDiagram");
		analysisDiagrams.add("PapyrusUMLClassDiagram");
		viewDiagramsAssociation.put(CHESSProfileManager.ANALYSIS_VIEW,
				analysisDiagrams);
		

		// TODO diagrams for RtAnalysisView to be defined
		HashSet<String> rtAnalysisDiagrams = new HashSet<String>();
		rtAnalysisDiagrams.add("PapyrusUMLActivityDiagram");
		// rtAnalysisDiagrams.add("PapyrusUMLCommunicationDiagram");
		rtAnalysisDiagrams.add("Package");
		// rtAnalysisDiagrams.add("PapyrusUMLProfileDiagram");
		rtAnalysisDiagrams.add("PapyrusUMLSequenceDiagram");
		rtAnalysisDiagrams.add("PapyrusUMLStateMachineDiagram");
		rtAnalysisDiagrams.add("PapyrusUMLClassDiagram");
		rtAnalysisDiagrams.add("CompositeStructure");
		rtAnalysisDiagrams.add("UseCase");
		viewDiagramsAssociation.put(CHESSProfileManager.RT_ANALYSIS_VIEW,
				rtAnalysisDiagrams);

		// TODO diagrams for DepAnalysisView to be defined
		HashSet<String> depAnalysisDiagrams = new HashSet<String>();
		depAnalysisDiagrams.add("PapyrusUMLActivityDiagram");
		// depAnalysisDiagrams("PapyrusUMLCommunicationDiagram");
		depAnalysisDiagrams.add("Package");
		// depAnalysisDiagrams("PapyrusUMLProfileDiagram");
		depAnalysisDiagrams.add("PapyrusUMLSequenceDiagram");
		depAnalysisDiagrams.add("PapyrusUMLStateMachineDiagram");
		depAnalysisDiagrams.add("PapyrusUMLClassDiagram");
		//depAnalysisDiagrams.add("classDiagramKind");
		depAnalysisDiagrams.add("CompositeStructure");
		depAnalysisDiagrams.add("UseCase");
		viewDiagramsAssociation.put(
				CHESSProfileManager.DEPENDABILITY_ANALYSIS_VIEW,
				depAnalysisDiagrams);

		// TODO diagrams for TimingDataFlowView to be defined
		HashSet<String> timingDataFlowDiagrams = new HashSet<String>();
		timingDataFlowDiagrams.addAll(UMLDiagrams);
		viewDiagramsAssociation.put(CHESSProfileManager.TIMING_DATAFLOW_VIEW,
				timingDataFlowDiagrams);
		
		//SystemView
		HashSet<String> systemDiagrams = new HashSet<String>();
		systemDiagrams.add(blockDiagram);
		systemDiagrams.add(internalBlockDiagram);
		systemDiagrams.add(stateMachineDiagram);
		systemDiagrams.add("CompositeStructure");
		viewDiagramsAssociation.put(CHESSProfileManager.SYSTEM_VIEW,
				systemDiagrams);
	}
}