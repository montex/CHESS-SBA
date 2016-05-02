/*------------------------------------------------------------------------------
  -
  - Copyright (c) 2015-2016 University of Padova, ITALY -  Intecs SpA 
  - All rights reserved. This program and the accompanying materials
  - are made available under the terms of the Eclipse Public License v1.0
  - which accompanies this distribution, and is available at
  - http://www.eclipse.org/legal/epl-v10.html
  -
  - Contributors:
  -
  - Alessandro Zovi azovi@math.unipd.it
  - Stefano Puri stefano.puri@intecs.it
  - Laura Baracchi laura.baracchi@intecs.it
  - Nicholas Pacini nicholas.pacini@intecs.it  
  -
  - Initial API and implementation and/or initial documentation
  ------------------------------------------------------------------------------*/package org.polarsys.chess.multicore.utils;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaExecHost;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Assign;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.NfpConstraint;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;
import org.polarsys.chess.core.util.uml.UMLUtils;
import org.polarsys.chess.multicore.model.CHCore;
import org.polarsys.chess.multicore.model.CHTask;
import org.polarsys.chess.multicore.model.SupertaskInfo;

public class GeneratorUtils {

	private static final String MARTE_ASSIGN = "MARTE::MARTE_Foundations::Alloc::Assign";
	private static final String MARTE_NFPCONSTRAINT = "MARTE::MARTE_Foundations::NFPs::NfpConstraint";

	/*
	 * public static void buildTask2CoreAssociations(Component hwSystem,
	 * EList<InstanceSpecification> processors, Map<CHCore, Set<CHTask>>
	 * coresToCHTask) { for (CHCore core : coresToCHTask.keySet()) { for (CHTask o
	 * : coresToCHTask.get(core)) {
	 * 
	 * Comment c = hwSystem.createOwnedComment(); UMLUtils.applyStereotype(c,
	 * MARTE_ASSIGN); Assign assign = UMLUtils.getStereotypeApplication(c,
	 * Assign.class);
	 * 
	 * assign.getFrom().add(o.getSlot().getBase_Slot());
	 * assign.getTo().add(core.getProcessorInstance());
	 * 
	 * Constraint n = hwSystem.createOwnedRule(core.getName());
	 * UMLUtils.applyStereotype(n, MARTE_NFPCONSTRAINT); NfpConstraint rule =
	 * UMLUtils.getStereotypeApplication(n, NfpConstraint.class);
	 * 
	 * ValueSpecification valueSpec = n.createSpecification("core", null,
	 * UMLPackage.Literals.LITERAL_STRING); LiteralString value = (LiteralString)
	 * valueSpec; value.setValue(core.getName());
	 * assign.getImpliedConstraint().add(rule);
	 * 
	 * } } }
	 */

	public static void buildTask2SuperTaskAssociations(Component hwSystem, HashMap<SupertaskInfo, LinkedHashSet<Object>> core2supertask, List<SupertaskInfo> supertaskInfoList) {

		writeSupertaskinfo(supertaskInfoList);

		for (SupertaskInfo supertask : core2supertask.keySet()) {
			for (Object o : core2supertask.get(supertask)) {
				if (!(o instanceof CHTask))
					continue;

				CHTask t = (CHTask) o;
				Comment c = hwSystem.createOwnedComment();
				UMLUtils.applyStereotype(c, MARTE_ASSIGN);
				Assign assign = UMLUtils.getStereotypeApplication(c, Assign.class);
				assign.getFrom().add(t.getSlot().getBase_Slot());
				assign.getTo().add(supertask.getProcessorInstance());

				{
					Constraint n = hwSystem.createOwnedRule(supertask.getName());
					UMLUtils.applyStereotype(n, MARTE_NFPCONSTRAINT);
					NfpConstraint rule = UMLUtils.getStereotypeApplication(n, NfpConstraint.class);

					ValueSpecification valueSpec = n.createSpecification("supertask", null, UMLPackage.Literals.LITERAL_STRING);
					LiteralString value = (LiteralString) valueSpec;
					value.setValue(supertask.getName());
					assign.getImpliedConstraint().add(rule);
				}

				{
					String context = t.getCHRtSpecification().getContext().getName();
					Constraint n = hwSystem.createOwnedRule(context);
					UMLUtils.applyStereotype(n, MARTE_NFPCONSTRAINT);
					NfpConstraint rule = UMLUtils.getStereotypeApplication(n, NfpConstraint.class);

					ValueSpecification valueSpec = n.createSpecification("context", null, UMLPackage.Literals.LITERAL_STRING);
					LiteralString value = (LiteralString) valueSpec;
					value.setValue(context);
					assign.getImpliedConstraint().add(rule);
				}

			}
		}
	}

	public static void eraseProcessorInfo(InstanceSpecification processorInstance) {
		for (Classifier classifier : processorInstance.getClassifiers()) {
			GaExecHost proc = UMLUtils.getStereotypeApplication(classifier, GaExecHost.class);
			if (proc != null) {
				proc.setOtherSchedPolicy("");
			}
		}
	}

	public static InstanceSpecification writeSupertaskinfo(List<SupertaskInfo> supertaskInfoList) {
		// save supertask info into the processor GaExecHost stereotype in
		// otherSchedPolicy
		SupertaskInfo s = (SupertaskInfo) supertaskInfoList.get(0);
		InstanceSpecification processorInstance = s.getProcessorInstance();
		for (Classifier classifier : processorInstance.getClassifiers()) {
			GaExecHost proc = UMLUtils.getStereotypeApplication(classifier, GaExecHost.class);
			if (proc != null) {

				StringBuilder sb = new StringBuilder();
				for (SupertaskInfo supertaskInfo : supertaskInfoList) {
					sb.append(String.format("[%s=%s],", supertaskInfo.getName(), supertaskInfo.getCapacity()));
				}
				// remove last comma
				sb.setLength(sb.length() - 1);

				String schedPolicy = String.format("RUN(%s)", sb.toString());
				proc.setOtherSchedPolicy(schedPolicy);
			}
		}
		return processorInstance;
	}

	public static void buildTask2CoreAssociations(Component hwSystem, Map<CHCore, LinkedHashSet<Object>> result) {

		for (CHCore core : result.keySet()) {
			for (Object o : result.get(core)) {
				if (!(o instanceof CHTask))
					continue;

				CHTask t = (CHTask) o;
				Comment c = hwSystem.createOwnedComment();
				UMLUtils.applyStereotype(c, MARTE_ASSIGN);
				Assign assign = UMLUtils.getStereotypeApplication(c, Assign.class);
				assign.getFrom().add(t.getSlot().getBase_Slot());
				assign.getTo().add(core.getProcessorInstance());

				eraseProcessorInfo(core.getProcessorInstance());

				{
					Constraint n = hwSystem.createOwnedRule(core.getName());
					UMLUtils.applyStereotype(n, MARTE_NFPCONSTRAINT);
					NfpConstraint rule = UMLUtils.getStereotypeApplication(n, NfpConstraint.class);

					ValueSpecification valueSpec = n.createSpecification("core", null, UMLPackage.Literals.LITERAL_STRING);
					LiteralString value = (LiteralString) valueSpec;
					value.setValue(core.getName());
					assign.getImpliedConstraint().add(rule);
				}

				{
					String context = t.getCHRtSpecification().getContext().getName();
					Constraint n = hwSystem.createOwnedRule(context);
					UMLUtils.applyStereotype(n, MARTE_NFPCONSTRAINT);
					NfpConstraint rule = UMLUtils.getStereotypeApplication(n, NfpConstraint.class);

					ValueSpecification valueSpec = n.createSpecification("context", null, UMLPackage.Literals.LITERAL_STRING);
					LiteralString value = (LiteralString) valueSpec;
					value.setValue(context);
					assign.getImpliedConstraint().add(rule);
				}

			}
		}
	}

}
