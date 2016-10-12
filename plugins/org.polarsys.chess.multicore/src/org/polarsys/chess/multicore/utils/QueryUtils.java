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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.crypto.spec.OAEPParameterSpec;

import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.CallConcurrencyKind;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwDevice.HwDevice;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Assign;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.NfpConstraint;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;
import org.polarsys.chess.chessmlprofile.ComponentModel.ComponentImplementation;
import org.polarsys.chess.chessmlprofile.ComponentModel.FunctionalPartition;
import org.polarsys.chess.chessmlprofile.Core.CHESS;
import org.polarsys.chess.chessmlprofile.Core.CHGaResourcePlatform;
import org.polarsys.chess.chessmlprofile.Core.FunctionalPartitions;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CH_HwProcessor;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtPortSlot;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification;
import org.polarsys.chess.chessmlprofile.util.Constants;
import org.polarsys.chess.core.profiles.CHESSProfileManager;
import org.polarsys.chess.core.util.uml.ModelError;
import org.polarsys.chess.core.util.uml.UMLUtils;
import org.polarsys.chess.multicore.model.CHCore;
import org.polarsys.chess.multicore.model.CHTask;
import org.polarsys.chess.validator.constraints.StringParser;

public class QueryUtils {
	public static class OccKindInfo {

		public double value;
		public String type;
		public String unit;

	}

	private static final String MARTE_ASSIGN = "MARTE::MARTE_Foundations::Alloc::Assign";
	private static final String MARTE_NFPCONSTRAINT = "MARTE::MARTE_Foundations::NFPs::NfpConstraint";

	public static final int COMPONENT_TO_PARTITION = 0;
	public static final int PARTITION_TO_CORE = 1;
	public static final int COMPONENT_TO_CORE = 2;
	public static final int TASK_TO_CORE = 3;

	public static CHESS getCHESS(Model umlModel) {
		return UMLUtils.getStereotypeApplication(umlModel, CHESS.class);
	}

	public static CommandStack getCommandStack(Model umlModel) {
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(umlModel);
		return editingDomain.getCommandStack();
	}

	/**
	 * returns the component which owns the assigns from components to partitions
	 * 
	 * @param umlModel
	 * @return
	 * @throws ModelError
	 * @deprecated PartitionsComponent stereotype is deprecated
	 */
	public static Component getPartitionsComponent(Model umlModel) throws ModelError {
		// assumption: assigns are stored in the root SW system i.e. the one
		// stereotyped with CHGaResourcePlatform

		CHESS chess = getCHESS(umlModel);
		Package componentViewP = chess.getComponentView().getBase_Package();

		for (Element el : componentViewP.allOwnedElements()) {
			if (el instanceof Component) {
				Component c = (Component) el;
				// LB 20150707 Next line to be reviewed based on considerations about
				// partitions' component
				boolean b = c.getName().equalsIgnoreCase("Partitions");
				b = b || UMLUtils.getStereotypeApplication(el, FunctionalPartitions.class) != null;
				if (b)
					return c;
			}
		}

		throw new ModelError("Partitions component not found.");
	}

	
	/**
	 * Given a Partition returns the list of Components that are assigned to it
	 * @param partition
	 * @param assignments
	 * @return
	 */
	public static LinkedHashSet<Object> getComponentsAssigned2Partition(InstanceSpecification partition, EList<Assign> assignments) {
		LinkedHashSet<Object> result = new LinkedHashSet<Object>();

		for (Assign theAssignment : assignments) {
			if (theAssignment != null) {
				try {
					if (theAssignment.getTo().contains((Object) partition) && (elementIsComponentInstance(theAssignment.getFrom().get(0)))) {
						result.add(theAssignment.getFrom().get(0));
					}
				} catch (Exception e) {
					// do nothing
				}
			}
		}
		return result;
	}

	/**
	 * Deletes all the associations of the given type
	 * @param parent
	 * @param associationType (PARTITION_TO_CORE | COMPONENT_TO_CORE | TASK_TO_CORE | COMPONENT_TO_PARTITION
	 */
	public static void deleteAssociations(Component parent, int associationType) {
		for (Object el : parent.getOwnedComments().toArray()) {
			if (el instanceof Comment) {
				Comment assignComment = (Comment) el;

				Assign assign = UMLUtils.getStereotypeApplication(assignComment, Assign.class);
				// Only delete one kind of associations
				try {
					if ((assign != null && associationType == PARTITION_TO_CORE && (elementIsPartitionInstance(assign.getFrom().get(0))))
							|| (assign != null && associationType == COMPONENT_TO_CORE && (elementIsComponentInstance(assign.getFrom().get(0))) && (elementIsProcessorInstance(assign.getTo().get(0))))
							|| (assign != null && associationType == TASK_TO_CORE && (elementIsSlotInstance(assign.getFrom().get(0))) && (elementIsProcessorInstance(assign.getTo().get(0))))
							|| (assign != null && associationType == COMPONENT_TO_PARTITION && (elementIsComponentInstance(assign.getFrom().get(0))) && (elementIsPartitionInstance(assign.getTo().get(0))))) {
						if (assign != null && assign.getImpliedConstraint().size() > 0) {
							for (Object c : assign.getImpliedConstraint().toArray()) {
								if (c instanceof NfpConstraint) {
									NfpConstraint n = (NfpConstraint) c;
									n.getBase_Constraint().destroy();
								}
							}
						}
						assignComment.destroy();
					}
				} catch (Exception e) {
					// 20160225 Always delete assignments where one end is null!
					assignComment.destroy();
				}
			}
		}

		// for (Object el : parent.getOwnedRules().toArray()) {
		// if (el instanceof Constraint) {
		// Constraint assignComment = (Constraint) el;
		// assignComment.destroy();
		// }
		// }
	}

	/**
	 * Returns the CHTask associated to the given element (if this is a CHRTPortSlot)
	 * @param element
	 * @return task that corresponds to the input slot, if any
	 */
	public static CHTask getTaskFromSlot(Element element) {
		if (!(element instanceof Slot)) {
			return null;
		}
		Slot slot = (Slot) element;
		CHRtPortSlot chSlot = UMLUtils.getStereotypeApplication(slot, CHRtPortSlot.class);
		if (chSlot == null) {
			return null;
		}
		EList<CHRtSpecification> chSpecs = chSlot.getCH_RtSpecification();
		for (CHRtSpecification chRtSpecification : chSpecs) {
			String occKind = chRtSpecification.getOccKind();
			if (occKind != null && isOccKindSporadicOrPeriodic(occKind)) {
				return new CHTask(chSlot, chRtSpecification);
			}
		}
		return null;
	}

	/**
	 * Returns all the CHTasks associated to the given element (if this is a CHRTPortSlot)
	 * @param element
	 * @return task that corresponds to the input slot, if any
	 */
	private static EList<CHTask> getAllTasksFromSlot(Element element) {
		EList<CHTask> chTaskList = new BasicEList<CHTask>();
		if (!(element instanceof Slot)) {
			return chTaskList;
		}
		Slot slot = (Slot) element;
		CHRtPortSlot chSlot = UMLUtils.getStereotypeApplication(slot, CHRtPortSlot.class);
		if (chSlot == null) {
			return chTaskList;
		}
		EList<CHRtSpecification> chSpecs = chSlot.getCH_RtSpecification();
		for (CHRtSpecification chRtSpecification : chSpecs) {
			String occKind = chRtSpecification.getOccKind();
			if (occKind != null && isOccKindSporadicOrPeriodic(occKind)) {
				chTaskList.add(new CHTask(chSlot, chRtSpecification));
				// return new CHTask(chSlot, chRtSpecification);
			}
		}
		return chTaskList;
	}

	public static boolean elementIsSlotInstance(Element element) {
		return element instanceof Slot;
	}

	/**
	 * Given a component, create all the Component to Partition Assignments
	 * 
	 * @param parent
	 * @param result
	 */
	public static void buildComponent2PartitionAssignment(Component parent, Map<InstanceSpecification, LinkedHashSet<Object>> result) {
		System.out.println(parent.getQualifiedName());

		for (InstanceSpecification partitionInst : result.keySet()) {
			System.out.println(partitionInst.getName());
			for (Object o : result.get(partitionInst)) {
				if (o instanceof InstanceSpecification) {
					InstanceSpecification componentInst = (InstanceSpecification) o;
					System.out.println(componentInst.getName());

					Comment c = parent.createOwnedComment();
					UMLUtils.applyStereotype(c, MARTE_ASSIGN);
					Assign assign = UMLUtils.getStereotypeApplication(c, Assign.class);
					assign.getFrom().add(componentInst);
					assign.getTo().add(partitionInst);
				}
			}
		}
	}

	/**
	 * 
	 * @param coreNumber
	 * @return
	 */
	public static String buildCoreName(int coreNumber) {
		/* coreNumber starts from 0 */
		return "core" + coreNumber;
	}

	/**
	 * Create all the Partition to Core Assignments
	 * 
	 * @param parent
	 * @param result
	 */
	public static void buildPartition2CoreAssignments(Component parent, Map<CHCore, LinkedHashSet<Object>> result) {
		for (CHCore core : result.keySet()) {
			for (Object o : result.get(core)) {
				if (o instanceof InstanceSpecification) {
					InstanceSpecification partitionInst = (InstanceSpecification) o;
					Comment c = parent.createOwnedComment();
					UMLUtils.applyStereotype(c, MARTE_ASSIGN);
					Assign assign = UMLUtils.getStereotypeApplication(c, Assign.class);
					assign.getFrom().add(partitionInst);
					assign.getTo().add(core.getProcessorInstance());

					Constraint n = parent.createOwnedRule(core.getName());
					UMLUtils.applyStereotype(n, MARTE_NFPCONSTRAINT);
					NfpConstraint rule = UMLUtils.getStereotypeApplication(n, NfpConstraint.class);

					ValueSpecification valueSpec = n.createSpecification("core", null, UMLPackage.Literals.LITERAL_STRING);
					LiteralString value = (LiteralString) valueSpec;
					value.setValue(core.getName());
					assign.getImpliedConstraint().add(rule);
				}
			}
		}
	}

	/**
	 * Returns the first CHGaResourcePlatform that is found inside the given package
	 * @param cmpv
	 * @return
	 */
	public static Package getOneResourcePlatformPackage(Package cmpv) {
		/* breath-first search */
		final LinkedList<Package> breadthFirstList = new LinkedList<Package>();
		breadthFirstList.addFirst(cmpv);
		while (!breadthFirstList.isEmpty()) {
			final Package candidate = breadthFirstList.poll();

			CHGaResourcePlatform a = UMLUtils.getStereotypeApplication(candidate, CHGaResourcePlatform.class);

			if (a != null)
				return candidate;

			for (final Package p : candidate.getNestedPackages()) {
				breadthFirstList.addLast(p);
			}
		}
		return null;
	}

	/**
	 * @deprecated This method returns only one platform package. In the newer
	 *             version of CHESS there can be multiple platform packages.
	 *             Replace with getResourcePlatformPackages
	 */
	@Deprecated
	public static Package getResourcePlatformPackage(Package cmpv) {
		/* breath-first search */
		final LinkedList<Package> breadthFirstList = new LinkedList<Package>();
		breadthFirstList.addFirst(cmpv);
		while (!breadthFirstList.isEmpty()) {
			final Package candidate = breadthFirstList.poll();

			CHGaResourcePlatform a = UMLUtils.getStereotypeApplication(candidate, CHGaResourcePlatform.class);

			if (a != null)
				return candidate;

			for (final Package p : candidate.getNestedPackages()) {
				breadthFirstList.addLast(p);
			}
		}
		return null;
	}

	/**
	 * Returns the list of CHGaResourcePlatforms found inside the view with the given name in the given model
	 * @param umlModel
	 * @param viewName
	 * @return
	 * @throws ModelError
	 */
	public static EList<Package> getResourcePlatformPackages(Model umlModel, String viewName) throws ModelError {

		Package pack = CHESSProfileManager.getViewByStereotype((Model) umlModel, viewName);

		if (pack == null)
			throw new ModelError(viewName + " not found.");
		// Package cmpv
		/* breath-first search */

		EList<Package> result = new BasicEList<Package>();

		final LinkedList<Package> breadthFirstList = new LinkedList<Package>();
		breadthFirstList.addFirst(pack);
		while (!breadthFirstList.isEmpty()) {
			final Package candidate = breadthFirstList.poll();

			CHGaResourcePlatform a = UMLUtils.getStereotypeApplication(candidate, CHGaResourcePlatform.class);

			if (a != null)
				result.add(candidate);
			// return candidate;

			for (final Package p : candidate.getNestedPackages()) {
				breadthFirstList.addLast(p);
			}
		}
		return result;
		// return null;
	}

	/**
	 * Returns the list of CHGaResourcePlatforms found inside the given Package
	 * @param cmpv is the given package
	 * @return
	 */
	public static List<Package> getResourcePlatformPackages(Package cmpv) {
		List<Package> candidates = new ArrayList<Package>();
		/* breath-first search */
		final LinkedList<Package> breadthFirstList = new LinkedList<Package>();
		breadthFirstList.addFirst(cmpv);
		while (!breadthFirstList.isEmpty()) {
			final Package candidate = breadthFirstList.poll();

			CHGaResourcePlatform a = UMLUtils.getStereotypeApplication(candidate, CHGaResourcePlatform.class);

			if (a != null)
				candidates.add(candidate);

			for (final Package p : candidate.getNestedPackages()) {
				breadthFirstList.addLast(p);
			}
		}
		return candidates;
	}

	/**
	 * Returns a Component that is stereotyped as CHGaResourcePlatform inside the view with the given name 
	 * in the given model
	 * @param umlModel
	 * @param viewName
	 * @return
	 * @throws ModelError
	 */
	public static Component getResourcePlatformComponent(Model umlModel, String viewName) throws ModelError {
		Package parent = CHESSProfileManager.getViewByStereotype(umlModel, viewName);

		if (parent == null)
			throw new ModelError(viewName + " not found.");

		/* breath-first search */
		final LinkedList<Element> breadthFirstList = new LinkedList<Element>();

		breadthFirstList.addAll(parent.getOwnedElements());
		while (!breadthFirstList.isEmpty()) {
			final Element t = breadthFirstList.poll();

			if (t instanceof Component) {
				Component candidate = (Component) t;
				CHGaResourcePlatform a = UMLUtils.getStereotypeApplication(candidate, CHGaResourcePlatform.class);
				if (a != null)
					return candidate;
			}
			for (final Element e : t.getOwnedElements()) {
				breadthFirstList.addLast(e);
			}
		}

		throw new ModelError("CHGaResourcePlatform not found in " + viewName + " view.");
	}

	/**
	 * Returns true if the given InstanceSpecification is a functional Partition, false otherwise
	 * @param e
	 * @return
	 */
	public static boolean isPartitionInstance(InstanceSpecification e) {
		for (Classifier c : e.getClassifiers()) {

			if (UMLUtils.getStereotypeApplication(c, FunctionalPartition.class) != null)
				return true;

		}
		return false;
	}

	/**
	 * Returns true if the given InstanceSpecification is a ComponentImplementation, false otherwise
	 * @param e
	 * @return
	 */
	public static boolean isComponentInstance(InstanceSpecification e) {
		for (Classifier c : e.getClassifiers()) {
			if (UMLUtils.getStereotypeApplication(c, ComponentImplementation.class) != null)
				return true;
		}
		return false;
	}

	public static boolean isGuarded(CHRtSpecification spec) {
		return spec.getProtection().getName().equals(CallConcurrencyKind.GUARDED.getName());
	}

	public static boolean isOccKindSporadicOrPeriodic(String occKind) {
		if (occKind == null)
			return false;
		return isOccKindSporadic(occKind) || isOccKindPeriodic(occKind);
	}

	public static boolean isOccKindSporadic(String occKind) {
		String t = occKind.toLowerCase();
		return t.matches(".*sporadic.*");
	}

	public static boolean isOccKindPeriodic(String occKind) {
		String t = occKind.toLowerCase();
		return t.matches(".*periodic.*");
	}

	/**
	 * Returns the OccKindInfo that correspomnds to the input string
	 * @param occKind the String with the occurrency kind information
	 * @return OccKindInfo
	 */
	public static OccKindInfo getOccKindInfo(String occKind) {
		StringParser sp = new StringParser();
		OccKindInfo info = new OccKindInfo();
		if (isOccKindSporadic(occKind)) {
			info.value = sp.getValuePattern(occKind, "minInterarrival");
			info.type = "sporadic";
			info.unit = sp.getUnitPattern(occKind, "minInterarrival");
		} else if (occKind.toLowerCase().matches(".*periodic.*")) {
			info.value = sp.getValuePattern(occKind, "period");
			info.unit = sp.getUnitPattern(occKind, "period");
			info.type = "periodic";
		} else {
			return null;
		}

		return info;
	}

	/**
	 * Returns a map with the Component to Partition assignments
	 * @param umlModel
	 * @param parent
	 * @return
	 * @throws ModelError
	 */
	public static Map<InstanceSpecification, Set<CHRtSpecification>> buildPartitionComponentMap(Model umlModel, Package parent) throws ModelError {
		Map<InstanceSpecification, Set<CHRtSpecification>> map = new HashMap<InstanceSpecification, Set<CHRtSpecification>>();

		EList<Assign> assignmentList = UMLUtils.getComponent2PartitionAssignments(umlModel, CHESSProfileManager.COMPONENT_VIEW);
		if (!assignmentList.isEmpty()) {
			for (Assign assign : assignmentList) {
				if (assign == null)
					continue;
				for (Element i : assign.getFrom()) {
					if (i instanceof InstanceSpecification) {
						InstanceSpecification ii = (InstanceSpecification) i;
						processComponentInstance(map, assign, ii);
					}
				}

			}
		}

		return map;
	}

	/**
	 * Returns a map with the Partition to Core assignments
	 * @param umlModel
	 * @return
	 * @throws ModelError
	 */
	public static Map<String, Set<InstanceSpecification>> buildPartitionCoreMap(Model umlModel) throws ModelError {
		Map<String, Set<InstanceSpecification>> map = new HashMap<String, Set<InstanceSpecification>>();

		EList<Assign> assignmentList = UMLUtils.getPartition2CoreAssignments(umlModel, CHESSProfileManager.DEPLOYMENT_VIEW);
		if (!assignmentList.isEmpty()) {
			for (Assign assign : assignmentList) {

				for (Element i : assign.getFrom()) {
					if (i instanceof InstanceSpecification) {
						processPartitionInstance(map, assign);
					}
				}

			}
		}
		return map;
	}

	// public static Map<InstanceSpecification, Set<CHRtSpecification>>
	// buildPartitionComponentMap(Component parent) {
	// Map<InstanceSpecification, Set<CHRtSpecification>> map = new
	// HashMap<InstanceSpecification, Set<CHRtSpecification>>();
	// for (Comment el : parent.getOwnedComments()) {
	//
	// Comment assignComment = (Comment) el;
	// Assign assign = UMLUtils.getStereotypeApplication(assignComment,
	// Assign.class);
	// if (assign == null)
	// continue;
	// for (Element i : assign.getFrom()) {
	// if (i instanceof InstanceSpecification) {
	// InstanceSpecification ii = (InstanceSpecification) i;
	// processComponentInstance(map, assign, ii);
	// }
	// }
	//
	// }
	// return map;
	// }

	/**
	 * 
	 * @param map
	 * @param assign
	 */
	private static void processPartitionInstance(Map<String, Set<InstanceSpecification>> map, Assign assign) {

		try {
			if (assign.getImpliedConstraint().size() > 0) {
				for (Object c : assign.getImpliedConstraint().toArray()) {
					if (c instanceof NfpConstraint) {
						ValueSpecification x = ((NfpConstraint) c).getBase_Constraint().getSpecification();
						if (x instanceof LiteralString) {
							LiteralString s = (LiteralString) x;
							String coreName = ((NamedElement) assign.getTo().get(0)).getName() + s.getValue();
							InstanceSpecification part = (InstanceSpecification) assign.getFrom().get(0);

							Set<InstanceSpecification> value = map.get(coreName);
							if (value == null)
								value = new HashSet<InstanceSpecification>();
							value.add(part);
							map.put(coreName, value);
						}
					}

				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @param map
	 * @param to
	 * @param chSpecs
	 */
	private static void processComponentInstance(Map<InstanceSpecification, Set<CHRtSpecification>> map, Assign assign, InstanceSpecification instanceSpec) {

		for (Element element : instanceSpec.getOwnedElements()) {
			if (element instanceof Slot) {
				Slot slot = (Slot) element;
				CHRtPortSlot chSlot = UMLUtils.getStereotypeApplication(slot, CHRtPortSlot.class);
				if (chSlot != null) {
					EList<CHRtSpecification> chSpecs = chSlot.getCH_RtSpecification();

					addToMap(map, assign.getTo(), chSpecs);
				}
			}
		}
	}

	/* add only periodic or sporadic components */
	private static void addToMap(Map<InstanceSpecification, Set<CHRtSpecification>> map, EList<Element> to, EList<CHRtSpecification> chSpecs) {
		for (Element partition : to) {
			if (partition instanceof InstanceSpecification) {
				InstanceSpecification p = (InstanceSpecification) partition;
				for (CHRtSpecification chRtSpecification : chSpecs) {
					String occKind = chRtSpecification.getOccKind();
					if (occKind != null) {
						if (isOccKindSporadicOrPeriodic(occKind)) {
							addToMap(map, p, chRtSpecification);
						}
					}
				}
			}
		}
	}

	
	/**
	 * 
	 * @param map
	 * @param p
	 * @param chRtSpecification
	 */
	private static void addToMap(Map<InstanceSpecification, Set<CHRtSpecification>> map, InstanceSpecification p, CHRtSpecification chRtSpecification) {
		Set<CHRtSpecification> value = map.get(p);
		if (value == null)
			value = new HashSet<CHRtSpecification>();
		value.add(chRtSpecification);
		map.put(p, value);

	}

	
	/**
	 * Returns true if the given InstanceSpecification is sterotyped as CH_HwProcessor
	 * @param e
	 * @return
	 */
	public static boolean isProcessorInstance(InstanceSpecification e) {
		for (Classifier c : e.getClassifiers()) {
			if (UMLUtils.getStereotypeApplication(c, CH_HwProcessor.class) != null)
				return true;
		}
		return false;
	}

	/**
	 * check if an instance specification is an instance of a MARTE Device
	 * 
	 * @param e
	 * @return true if the input is an instance of a MARTE Device, false
	 *         otherwise.
	 */
	public static boolean isDeviceInstance(InstanceSpecification instSpec) {
		Classifier classifier = instSpec.getClassifiers().get(0);
		EList<Stereotype> stereotypeList = classifier.getAppliedStereotypes();
		for (Stereotype theStereo : stereotypeList) {
			EObject object = classifier.getStereotypeApplication(theStereo);
			if (object instanceof HwDevice) {
				return true;
			}
		}

		return false;
	}

	/**
	 * 
	 * @param umlModel
	 * @return
	 */
	public static CH_HwProcessor getOneProcessor(Model umlModel) {
		Package depv = CHESSProfileManager.getViewByStereotype((Model) umlModel, CHESSProfileManager.DEPLOYMENT_VIEW);
		depv = QueryUtils.getOneResourcePlatformPackage(depv);
		if (depv != null) {
			EList<Element> all = depv.allOwnedElements();
			for (Element element : all) {
				if (element instanceof InstanceSpecification) {
					InstanceSpecification e = (InstanceSpecification) element;
					if (e.getQualifiedName() != null && QueryUtils.isProcessorInstance(e)) {
						CH_HwProcessor t = UMLUtils.getStereotypeApplication(e, CH_HwProcessor.class);
						return t;
					}
				}
			}
		}
		return null;
	}

	/**
	 * 
	 * @param umlModel
	 * @return
	 * @throws ModelError
	 */
	public static EList<CH_HwProcessor> getAllProcessorInstances(Model umlModel) throws ModelError {
		EList<CH_HwProcessor> processors = new BasicEList<CH_HwProcessor>();
		Package depv = CHESSProfileManager.getViewByStereotype((Model) umlModel, CHESSProfileManager.DEPLOYMENT_VIEW);

		if (depv == null)
			throw new ModelError("Deployment view not found.");

		List<Package> platformPackages = QueryUtils.getResourcePlatformPackages(depv);

		if (platformPackages.isEmpty())
			throw new ModelError("CHGaResourcePlatform not found in Deployment view.");

		for (Package pp : platformPackages) {
			EList<Element> all = pp.allOwnedElements();
			for (Element element : all) {
				if (element instanceof InstanceSpecification) {
					InstanceSpecification e = (InstanceSpecification) element;
					if (e.getQualifiedName() != null && QueryUtils.isProcessorInstance(e)) {
						CH_HwProcessor t = UMLUtils.getStereotypeApplication(e, CH_HwProcessor.class);
						processors.add(t);
					}
				}
			}
		}

		if (processors.size() == 0)
			throw new ModelError("Processors not found.");

		return processors;
	}

	/**
	 * 
	 * @param thePackage
	 * @return
	 * @throws ModelError
	 */
	public static EList<CH_HwProcessor> getAllProcessorInstancesInPackage(Package thePackage) throws ModelError {
		EList<CH_HwProcessor> processors = new BasicEList<CH_HwProcessor>();

		EList<Element> all = thePackage.allOwnedElements();
		for (Element element : all) {
			if (element instanceof InstanceSpecification) {
				InstanceSpecification e = (InstanceSpecification) element;
				if (e.getQualifiedName() != null && QueryUtils.isProcessorInstance(e)) {
					CH_HwProcessor t = UMLUtils.getStereotypeApplication(e, CH_HwProcessor.class);
					processors.add(t);
				}
			}
		}
		if (processors.size() == 0)
			throw new ModelError("Processors not found.");

		return processors;
	}

	
	/**
	 * 
	 * @param processors
	 * @return
	 */
	public static EList<CH_HwProcessor> filterMultiCoreProcessors(EList<CH_HwProcessor> processors) {
		EList<CH_HwProcessor> candidates = new BasicEList<CH_HwProcessor>();
		for (CH_HwProcessor processor : processors) {
			if (getCores(processor).size() > 1)
				candidates.add(processor);
		}
		return candidates;

	}

	
	/**
	 * 
	 * @param processor
	 * @return
	 */
	public static EList<CHCore> getCores(CH_HwProcessor processor) {
		InstanceSpecification processorBaseInst = processor.getBase_InstanceSpecification();
		Component processorComponent = (Component) processorBaseInst.getClassifiers().get(0);

		Stereotype chHwProcessorStereo = processorComponent.getAppliedStereotype(Constants.CH_HWPROCESSOR);
		CH_HwProcessor chHwProc = (CH_HwProcessor) processorComponent.getStereotypeApplication(chHwProcessorStereo);

		String coreNumber = null;
		coreNumber = chHwProc.getNbCores();
		int icoreNumber = 1;
		try {
			icoreNumber = Integer.parseInt(coreNumber);
		} catch (Exception e) {
			icoreNumber = 1;
		}
		EList<CHCore> cores = new BasicEList<CHCore>();
		for (int i = 0; i < icoreNumber; i++) {
			cores.add(new CHCore(processor, QueryUtils.buildCoreName(i)));
		}
		return cores;
	}

	
	/**
	 * 
	 * @param umlModel
	 * @return
	 * @throws ModelError
	 */
	public static EList<InstanceSpecification> getAllPartitionInstances(Model umlModel) throws ModelError {

		Package cmpv = CHESSProfileManager.getViewByStereotype(umlModel, CHESSProfileManager.COMPONENT_VIEW);

		if (cmpv == null)
			throw new ModelError("Component view not found.");

		cmpv = QueryUtils.getOneResourcePlatformPackage(cmpv);

		if (cmpv == null)
			throw new ModelError("CHGaResourcePlatform not found in Component View.");

		EList<Element> all = cmpv.allOwnedElements();
		EList<InstanceSpecification> partitions = new BasicEList<InstanceSpecification>();
		for (Element element : all) {
			if (!(element instanceof InstanceSpecification))
				continue;

			InstanceSpecification is = (InstanceSpecification) element;

			if (!(is.getQualifiedName() != null && QueryUtils.isPartitionInstance(is)))
				continue;
			partitions.add(is);
		}

		if (partitions.size() == 0)
			throw new ModelError("Partition Instances not found.");

		return partitions;
	}

	
	/**
	 * 
	 * @param umlModel
	 * @return
	 * @throws ModelError
	 */
	public static EList<InstanceSpecification> getAllComponentInstances(Model umlModel) throws ModelError {

		Package cmpv = CHESSProfileManager.getViewByStereotype(umlModel, CHESSProfileManager.COMPONENT_VIEW);

		if (cmpv == null)
			throw new ModelError("Component view not found.");

		cmpv = QueryUtils.getOneResourcePlatformPackage(cmpv);

		if (cmpv == null)
			throw new ModelError("CHGaResourcePlatform not found in Component View.");

		EList<Element> all = cmpv.allOwnedElements();
		EList<InstanceSpecification> components = new BasicEList<InstanceSpecification>();
		for (Element element : all) {
			if (!(element instanceof InstanceSpecification))
				continue;

			InstanceSpecification is = (InstanceSpecification) element;

			if (!(is.getQualifiedName() != null && QueryUtils.isComponentInstance(is)))
				continue;
			components.add(is);

		}
		if (components.size() == 0)
			throw new ModelError("Component Instances not found.");

		return components;
	}

	
	/**
	 * 
	 * @param umlModel
	 * @return
	 * @throws ModelError
	 */
	public static EList<CHTask> getAllTaskInstances(Model umlModel) throws ModelError {

		EList<CHTask> tasks = new BasicEList<CHTask>();

		EList<InstanceSpecification> x = getAllComponentInstances(umlModel);
		for (InstanceSpecification instanceSpecification : x) {
			for (Element element1 : instanceSpecification.getOwnedElements()) {

				if (!(element1 instanceof Slot))
					continue;

				Slot slot = (Slot) element1;
				CHRtPortSlot chSlot = UMLUtils.getStereotypeApplication(slot, CHRtPortSlot.class);
				if (chSlot == null)
					continue;

				EList<CHRtSpecification> chSpecs = chSlot.getCH_RtSpecification();

				for (CHRtSpecification chRtSpecification : chSpecs) {
					tasks.add(new CHTask(chSlot, chRtSpecification));
				}
			}
		}
		if (tasks.size() == 0)
			throw new ModelError("Tasks Instances not found.");

		return tasks;
	}

	public static void deleteTask2CoreAssociations(Component hwSystem) {
		deleteAssociations(hwSystem, TASK_TO_CORE);
	}

	public static void deleteComponent2CoreAssociations(Component hwSystem) {
		deleteAssociations(hwSystem, COMPONENT_TO_CORE);
	}

	public static void deletePartition2CoreAssociations(Component hwSystem) {
		deleteAssociations(hwSystem, PARTITION_TO_CORE);
	}

	
	/**
	 * 
	 * @param hwSystem
	 * @param result
	 */
	public static void buildInstance2CoreAssignments(Component hwSystem, Map<CHCore, LinkedHashSet<Object>> result) {

		for (CHCore core : result.keySet()) {
			for (Object o : result.get(core)) {
				if (o instanceof InstanceSpecification) {
					InstanceSpecification componentInst = (InstanceSpecification) o;
					Comment c = hwSystem.createOwnedComment();
					UMLUtils.applyStereotype(c, MARTE_ASSIGN);
					Assign assign = UMLUtils.getStereotypeApplication(c, Assign.class);
					assign.getFrom().add(componentInst);
					assign.getTo().add(core.getProcessorInstance());

					Constraint n = hwSystem.createOwnedRule(core.getName());
					UMLUtils.applyStereotype(n, MARTE_NFPCONSTRAINT);
					NfpConstraint rule = UMLUtils.getStereotypeApplication(n, NfpConstraint.class);

					ValueSpecification valueSpec = n.createSpecification("core", null, UMLPackage.Literals.LITERAL_STRING);
					LiteralString value = (LiteralString) valueSpec;
					value.setValue(core.getName());
					assign.getImpliedConstraint().add(rule);
				}
			}
		}
	}

	
	/**
	 * 
	 * @param instances
	 * @return
	 */
	public static Set<CHRtSpecification> getCHRTSpecFromInstances(EList<InstanceSpecification> instances) {

		Set<CHRtSpecification> result = new HashSet<CHRtSpecification>();

		for (InstanceSpecification is : instances) {
			for (Element el : is.getOwnedElements()) {
				if (!(el instanceof Slot))
					continue;

				Slot slot = (Slot) el;
				CHRtPortSlot chSlot = UMLUtils.getStereotypeApplication(slot, CHRtPortSlot.class);
				if (chSlot == null)
					continue;

				EList<CHRtSpecification> chSpecs = chSlot.getCH_RtSpecification();
				for (CHRtSpecification chRtSpecification : chSpecs) {
					String occKind = chRtSpecification.getOccKind();
					if (occKind != null && isOccKindSporadicOrPeriodic(occKind)) {
						result.add(chRtSpecification);
					}
				}
			}
		}

		return result;
	}

	/**
	 * 
	 * @param instances
	 * @return
	 */
	public static Map<CHRtSpecification, Slot> getCHTasks(EList<InstanceSpecification> instances) {

		Map<CHRtSpecification, Slot> result = new HashMap<CHRtSpecification, Slot>();

		for (InstanceSpecification is : instances) {
			for (Element el : is.getOwnedElements()) {

				if (!(el instanceof Slot))
					continue;

				Slot slot = (Slot) el;
				CHRtPortSlot chSlot = UMLUtils.getStereotypeApplication(slot, CHRtPortSlot.class);
				if (chSlot == null)
					continue;

				EList<CHRtSpecification> chSpecs = chSlot.getCH_RtSpecification();
				for (CHRtSpecification chRtSpecification : chSpecs) {
					String occKind = chRtSpecification.getOccKind();
					if (occKind != null) {
						if (isOccKindSporadicOrPeriodic(occKind)) {
							result.put(chRtSpecification, slot);
						}
					}
				}
			}
		}

		return result;
	}

	
	/**
	 * 
	 * @param instances
	 * @return
	 */
	public static EList<CHTask> getCHTasksList(EList<InstanceSpecification> instances) {

		EList<CHTask> result = new BasicEList<CHTask>();

		for (InstanceSpecification is : instances) {
			for (Element el : is.getOwnedElements()) {

				if (!(el instanceof Slot))
					continue;

				Slot slot = (Slot) el;
				CHRtPortSlot chSlot = UMLUtils.getStereotypeApplication(slot, CHRtPortSlot.class);
				if (chSlot == null)
					continue;

				EList<CHRtSpecification> chSpecs = chSlot.getCH_RtSpecification();
				for (CHRtSpecification chRtSpecification : chSpecs) {
					String occKind = chRtSpecification.getOccKind();
					if (occKind != null && isOccKindSporadicOrPeriodic(occKind)) {
						result.add(new CHTask(chSlot, chRtSpecification));
					}
				}
			}
		}

		return result;
	}

	public static void buildTask2CoreAssignments(Component hwSystem, InstanceSpecification processor, Map<String, LinkedHashSet<CHRtSpecification>> coresToCHRtSpec,
			Map<CHRtSpecification, InstanceSpecification> mapCHRtSpecToInstances) {
		// TODO Auto-generated method stub

	}

	/*
	 * foreach deferred op get its slot in the instance package get its activity
	 * diagram if any collect the called operations get the corresponding
	 * component and so its specification
	 * 
	 * this is useful to calculate the WCET of the task generated from the
	 * deferred op
	 */
	public static HashMap<CHTask, EList<CHTask>> getOperationChain(Model umlModel, EList<CHTask> chtasks) throws ModelError {
		Package instPkg = InstanceQuery.getInstanceSpecPackage(umlModel);
		if (instPkg == null) {
			throw new ModelError("Instance package not in the model: use the create instance command to create this package");
		}
		HashMap<CHTask, EList<CHTask>> map = new HashMap<CHTask, EList<CHTask>>();
		for (CHTask dOp : chtasks) {
			System.out.println(dOp.getCHRtSpecification().getContext().getName());
			EList<CHTask> list = new BasicEList<CHTask>();
			CHRtPortSlot chRtPortSlot = InstanceQuery.getCHRtPortSlot(instPkg, dOp.getCHRtSpecification());
			slot2EndToEndWorkFlow(instPkg, chRtPortSlot, dOp.getCHRtSpecification(), list);
			map.put(dOp, list);
		}
		return map;
	}

	public static HashMap<CHRtSpecification, EList<CHTask>> getOperationChain2(Model umlModel, Set<CHRtSpecification> chtasks) throws ModelError {
		Package instPkg = InstanceQuery.getInstanceSpecPackage(umlModel);
		if (instPkg == null) {
			throw new ModelError("Instance package not in the model: use the create instance command to create this package");
		}
		HashMap<CHRtSpecification, EList<CHTask>> map = new HashMap<CHRtSpecification, EList<CHTask>>();
		for (CHRtSpecification dOp : chtasks) {
			System.out.println(dOp.getContext().getName());
			EList<CHTask> list = new BasicEList<CHTask>();
			CHRtPortSlot chRtPortSlot = InstanceQuery.getCHRtPortSlot(instPkg, dOp);
			slot2EndToEndWorkFlow(instPkg, chRtPortSlot, dOp, list);
			map.put(dOp, list);
		}
		return map;
	}

	
	/**
	 * 
	 * @param instPkg
	 * @param currentChSlot
	 * @param dOp
	 * @param list
	 * @throws ModelError
	 */
	private static void slot2EndToEndWorkFlow(Package instPkg, CHRtPortSlot currentChSlot, CHRtSpecification dOp, EList<CHTask> list) throws ModelError {

		InstanceSpecification owningInstance = currentChSlot.getBase_Slot().getOwningInstance();
		Activity method = InstanceQuery.getMethod(dOp);
		if (method == null)
			return;// TODO throw exception?
		for (ActivityNode node : method.getNodes()) {
			if (node instanceof CallOperationAction) {
				CallOperationAction callOp = (CallOperationAction) node;
				EList<Slot> riSlot = InstanceQuery.getSlotFromPort(callOp, owningInstance);
				for (Slot slot : riSlot) {
					Slot usedPiSlot = InstanceQuery.getOppositeSlot(slot);
					CHRtSpecification usedCH = InstanceQuery.getCHFromSlot(usedPiSlot, callOp.getOperation());
					CHRtPortSlot ch = UMLUtils.getStereotypeApplication(usedPiSlot, CHRtPortSlot.class);
					if (!InstanceQuery.isDeferred(usedCH)) {
						list.add(new CHTask(ch, usedCH));
						slot2EndToEndWorkFlow(instPkg, ch, usedCH, list);
					}
					//
					// Operation operation = callOp.getOperation();//=>use to match the
					// context of the chrtspec
					// Port riPort = callOp.getOnPort();//=>get link and then pi then
					// chrtspec
					// Port piPort = getOppositePort(riPort);
					// getCHRtCommentsfromPort(piPort, operation);
				}

			}
		}
	}

	
	/**
	 * 
	 * @param wcetSpec
	 * @param theUnit
	 * @return
	 */
	private static int wcetUnit(String wcetSpec, String theUnit) {
		int ret = -1;
		if (wcetSpec == null)
			return ret;

		StringParser sp = new StringParser();
		double value = sp.getValueNFP(wcetSpec);
		String unit = sp.getUnitNFP(wcetSpec);

		if (value == -1)
			return ret;

		int intValue = unitConversion(value, unit, theUnit);
		return intValue;
	}

	
	/**
	 * 
	 * @param value
	 * @param fromUnit
	 * @param toUnit
	 * @return
	 */
	public static float unitConversionFloat(double value, String fromUnit, String toUnit) {
		int toFactor = 1000000;

		if (toUnit.equalsIgnoreCase("s")) {
			toFactor = 1000000000;
		} else if (toUnit.equalsIgnoreCase("ms")) {
			toFactor = 1000000;
		} else if (toUnit.equalsIgnoreCase("us")) {
			toFactor = 1000;
		} else if (toUnit.equalsIgnoreCase("ns")) {
			toFactor = 1;
		}

		int fromFactor = 1000000;

		if (fromUnit.equalsIgnoreCase("s")) {
			fromFactor = 1000000000;
		} else if (fromUnit.equalsIgnoreCase("ms")) {
			fromFactor = 1000000;
		} else if (fromUnit.equalsIgnoreCase("us")) {
			fromFactor = 1000;
		} else if (fromUnit.equalsIgnoreCase("ns")) {
			fromFactor = 1;
		}

		float ratio = (float) fromFactor / toFactor;
		float intValue = (float) (value * ratio);
		return intValue;
	}

	
	/**
	 * 
	 * @param wcetSpec
	 * @param theUnit
	 * @return
	 */
	private static float wcetUnitFloat(String wcetSpec, String theUnit) {
		int ret = -1;
		if (wcetSpec == null)
			return ret;

		StringParser sp = new StringParser();
		double value = sp.getValueNFP(wcetSpec);
		String unit = sp.getUnitNFP(wcetSpec);

		if (value == -1)
			return ret;

		return unitConversionFloat(value, unit, theUnit);
	}

	
	/**
	 * 
	 * @param value
	 * @param fromUnit
	 * @param toUnit
	 * @return
	 */
	public static int unitConversion(double value, String fromUnit, String toUnit) {
		int toFactor = 1000000;

		if (toUnit.equalsIgnoreCase("s")) {
			toFactor = 1000000000;
		} else if (toUnit.equalsIgnoreCase("ms")) {
			toFactor = 1000000;
		} else if (toUnit.equalsIgnoreCase("us")) {
			toFactor = 1000;
		} else if (toUnit.equalsIgnoreCase("ns")) {
			toFactor = 1;
		}

		int fromFactor = 1000000;

		if (fromUnit.equalsIgnoreCase("s")) {
			fromFactor = 1000000000;
		} else if (fromUnit.equalsIgnoreCase("ms")) {
			fromFactor = 1000000;
		} else if (fromUnit.equalsIgnoreCase("us")) {
			fromFactor = 1000;
		} else if (fromUnit.equalsIgnoreCase("ns")) {
			fromFactor = 1;
		}

		double ratio = (double) fromFactor / toFactor;
		int intValue = (int) Math.round(value * ratio);
		return intValue;
	}

	
	/**
	 * 
	 * @param chRtSpecification
	 * @param unitOfMeasure
	 * @return
	 * @throws ModelError
	 */
	public static float getWCETunitFloat(CHRtSpecification chRtSpecification, String unitOfMeasure) throws ModelError {

		StringParser sp = new StringParser();
		String wcet = chRtSpecification.getLocalWCET();
		float intValue = wcetUnitFloat(wcet, unitOfMeasure);

		if (intValue != -1)
			return intValue;

		wcet = chRtSpecification.getWCET();

		intValue = wcetUnit(wcet, unitOfMeasure);
		if (intValue != -1)
			return intValue;

		throw new ModelError("WCET for %s is not set correctly", chRtSpecification.getContext().getName());
	}

	
	/**
	 * 
	 * @param chRtSpecification
	 * @param unitOfMeasure
	 * @return
	 * @throws ModelError
	 */
	public static int getWCETunit(CHRtSpecification chRtSpecification, String unitOfMeasure) throws ModelError {

		StringParser sp = new StringParser();
		String wcet = chRtSpecification.getLocalWCET();
		int intValue = wcetUnit(wcet, unitOfMeasure);

		if (intValue != -1)
			return intValue;

		wcet = chRtSpecification.getWCET();

		intValue = wcetUnit(wcet, unitOfMeasure);
		if (intValue != -1)
			return intValue;

		throw new ModelError("WCET for %s is not set correctly", chRtSpecification.getContext().getName());
	}

	// TODO a similar method is implemented in the m2m plugin (Java4QVTutils.java)
	public static double getWCET(CHRtSpecification chRtSpecification) throws ModelError {
		StringParser sp = new StringParser();
		double x = -1;
		String wcet = chRtSpecification.getLocalWCET();
		if (wcet != null) {
			x = sp.getValueNFP(wcet);
		}
		if (x != -1)
			return x;

		wcet = chRtSpecification.getWCET();

		if (wcet != null) {
			x = sp.getValueNFP(wcet);
		}
		if (x != -1)
			return x;

		throw new ModelError("WCET for %s is not set correctly", chRtSpecification.getContext().getName());
	}

	/**
	 * Check if Instance Specification in input is assigned to a Partition
	 * 
	 * @param i
	 * @param assignments
	 * @return
	 */
	public static boolean isAssigned2Partition(InstanceSpecification i, EList<Assign> assignments) {
		for (Assign theAssignment : assignments) {
			if (theAssignment != null) {
				try {
					if (theAssignment.getFrom().contains((Object) i) && (elementIsPartitionInstance(theAssignment.getTo().get(0)))) {
						return true;
					}
				} catch (Exception e) {
					continue;
				}
			}
		}
		return false;
	}

	/**
	 * Check if this Partition is assigned to a CPU
	 * 
	 * @param i
	 * @param assignments
	 * @return
	 */
	public static boolean isAssigned2Processor(InstanceSpecification i, EList<Assign> assignments) {
		for (Assign theAssignment : assignments) {
			if (theAssignment != null) {
				try {
					if (theAssignment.getFrom().contains((Object) i) && elementIsProcessorInstance(theAssignment.getTo().get(0))) {
						return true;
					}
				} catch (Exception e) {
					continue;
				}
			}
		}
		return false;
	}

	/**
	 * Check if this Partition is assigned to a CPU
	 * 
	 * @param i
	 * @param assignments
	 * @return
	 */
	public static boolean isAssigned2Core(InstanceSpecification i, Package pack, EList<Assign> assignments) {
		String packQN = pack.getQualifiedName();
		String assignedTargetQN = "";
		String assignedTargetElementName = "";

		for (Assign theAssignment : assignments) {
			if (theAssignment != null) {
				try {
					EList<Element> assignmentSource = theAssignment.getFrom();
					Element assignmentTarget = theAssignment.getTo().get(0);
					assignedTargetQN = ((NamedElement) assignmentTarget).getQualifiedName();
					assignedTargetElementName = ((NamedElement) assignmentTarget).getLabel();
					if (assignmentSource.contains((Object) i) && elementIsProcessorInstance(assignmentTarget)) {
						if (!theAssignment.getImpliedConstraint().isEmpty() && theAssignment.getImpliedConstraint().get(0) != null) {
							if ((packQN + "::" + assignedTargetElementName).equals(assignedTargetQN)) {
								return true;
							}
						} else {
							// Check if it is a single-core
							InstanceSpecification instSpecProc = (InstanceSpecification) assignmentTarget;
							if (processorInstanceIsSingleCore(instSpecProc)) {
								if ((packQN + "::" + assignedTargetElementName).equals(assignedTargetQN)) {
									return true;
								}
							}
						}
					}
				} catch (Exception e) {
					continue;
				}
			}
		}
		return false;
	}

	/**
	 * Check if this Partition is assigned to a CPU
	 * 
	 * @param i
	 * @param assignments
	 * @return
	 */
	public static boolean isAssigned2Core(InstanceSpecification i, EList<Assign> assignments) {
		for (Assign theAssignment : assignments) {
			if (theAssignment != null) {
				try {
					if (theAssignment.getFrom().contains((Object) i) && elementIsProcessorInstance(theAssignment.getTo().get(0))) {
						if (!theAssignment.getImpliedConstraint().isEmpty() && theAssignment.getImpliedConstraint().get(0) != null) {
							return true;
						} else {
							// Check if it is a single-core
							Element elem = theAssignment.getTo().get(0);
							InstanceSpecification instSpecProc = (InstanceSpecification) elem;
							if (processorInstanceIsSingleCore(instSpecProc)) {
								return true;
							}
						}
					}
				} catch (Exception e) {
					continue;
				}
			}
		}
		return false;
	}

	// /**
	// * Check if this Partition is assigned to a CPU
	// * @param i
	// * @param assignments
	// * @return
	// */
	// public static boolean isAssigned2Core(InstanceSpecification i,
	// EList<Assign> assignments) {
	// for (Assign theAssignment : assignments) {
	// if (theAssignment != null) {
	// if (theAssignment.getFrom().contains((Object)i) &&
	// elementIsProcessorInstance(theAssignment.getTo().get(0)) &&
	// !theAssignment.getImpliedConstraint().isEmpty()&&
	// theAssignment.getImpliedConstraint().get(0)!=null ) {
	// return true;
	// }
	// }
	// }
	// return false;
	// }

	/**
	 * Returns TRUE if the given Task is assigned to a Core in the Deployment
	 * identified by the given package
	 * 
	 * @param task
	 * @param pack
	 * @param assignments
	 * @return
	 */
	public static boolean isTaskAssigned2Core(CHTask task, Package pack, EList<Assign> assignments) {
		String taskName = task.getCHRtSpecification().getContext().getName();
		String packQN = pack.getQualifiedName();
		String assignedTargetQN = "";
		String assignedTargetElementName = "";

		for (Assign theAssignment : assignments) {
			if (theAssignment != null) {
				try {
					Element assignmentSource = theAssignment.getFrom().get(0);
					Element assignmentTarget = theAssignment.getTo().get(0);
					assignedTargetQN = ((NamedElement) assignmentTarget).getQualifiedName();
					assignedTargetElementName = ((NamedElement) assignmentTarget).getLabel();
					if ((packQN + "::" + assignedTargetElementName).equals(assignedTargetQN) && QueryUtils.elementIsSlotInstance(assignmentSource) && theAssignment.getImpliedConstraint() != null
							&& !theAssignment.getImpliedConstraint().isEmpty()) {
						String theTaskValue = getTaskNameFromImpliedNfpConstraint(theAssignment);
						if (theTaskValue != null && theTaskValue.length() > 0) {
							if (theTaskValue.equals(taskName)) {
								return true;
							}
						}
					}
				} catch (Exception e) {
					continue;
				}
			}
		}
		return false;
	}

	/**
	 * Returns true if the given task is assigned to a core, false otherwise
	 * @param t
	 * @param assignments
	 * @return true if the given task is assigned to a core
	 */
	public static boolean isTaskAssigned2Core(CHTask t, EList<Assign> assignments) {
		for (Assign theAssignment : assignments) {
			if (theAssignment != null) {
				Element assignmentSource = theAssignment.getFrom().get(0);
				if (QueryUtils.elementIsSlotInstance(assignmentSource)) {
					CHTask theTask = getTaskFromSlot(assignmentSource);
					if ((theTask != null && theTask.equals(t)) && elementIsProcessorInstance(theAssignment.getTo().get(0))) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * Given the Core (and related processor) get the list of partitions that are
	 * assigned to it
	 * 
	 * @param core
	 * @param assignments
	 * @return
	 */
	public static LinkedHashSet<Object> getPartitionsAssigned2Core(CHCore core, EList<Assign> assignments) {
		LinkedHashSet<Object> result = new LinkedHashSet<Object>();
		InstanceSpecification processorInstance = core.getProcessorInstance();
		String theCoreName = core.getName();
		String theCoreValue = null;
		for (Assign theAssignment : assignments) {
			if (theAssignment != null) {
				try {
					Element assignmentSource = theAssignment.getFrom().get(0);
					// Only look at assignments where:
					// ASSIGNMENT_SOURCE is a Partition
					// ASSIGNMENT_TARGET is the Processor that owns the core
					if (!QueryUtils.elementIsPartitionInstance(assignmentSource) || (!theAssignment.getTo().contains((Object) processorInstance))) {
						continue;
					}
					// found an assignment for the processor that owns the core:
					// let's look into it so see if it is related to the core we are
					// analyzing
					if (theAssignment.getImpliedConstraint() != null && !theAssignment.getImpliedConstraint().isEmpty()) {
						theCoreValue = getCoreNameFromImpliedNfpConstraint(theAssignment);
						if (theCoreValue.equals(theCoreName)) {
							// if target of assignment is a partition
							result.add(assignmentSource);
						}
					} else {
						if (processorInstanceIsSingleCore(processorInstance)) {
							// If no core is specified in the Implied Constraint and the
							// Processor has only 1 Core
							result.add(assignmentSource);
						}
					}
				} catch (Exception e) {
					continue;
				}

			}
		}
		return result;
	}

	
	/**
	 * Returns the name of the Core to which the given assignment is related
	 * @param theAssignment
	 * @return the name of the Core to which theAssignment is related
	 */
	public static String getCoreNameFromImpliedNfpConstraint(Assign theAssignment) {
		String coreName = null;
		try {
			NfpConstraint theImpliedNfpConstraint = theAssignment.getImpliedConstraint().get(0);
			Constraint cnstr = theImpliedNfpConstraint.getBase_Constraint();
			ValueSpecification valueSpec = cnstr.getSpecification();
			LiteralString value = (LiteralString) valueSpec;
			coreName = value.getValue();
		} catch (Exception e) {
			System.out.println("Error in getCoreNameFromImpliedNfpConstraint");
		}
		return coreName;
	}

	
	/**
	 * 
	 * @param theAssignment
	 * @return
	 */
	private static String getTaskNameFromImpliedNfpConstraint(Assign theAssignment) {
		String taskName = null;
		try {
			// the first one is the core, the second one is the task
			NfpConstraint theImpliedNfpConstraint = theAssignment.getImpliedConstraint().get(1);
			Constraint cnstr = theImpliedNfpConstraint.getBase_Constraint();
			ValueSpecification valueSpec = cnstr.getSpecification();
			LiteralString value = (LiteralString) valueSpec;
			taskName = value.getValue();
		} catch (Exception e) {
			System.out.println("Error in getTaskNameFromImpliedNfpConstraint");
		}
		return taskName;
	}

	/**
	 * Returns true if the given element is a partition instance, false otherwise
	 * @param element
	 * @return true if the element is a partition instance, false otherwise
	 */
	public static boolean elementIsPartitionInstance(Element element) {
		if (!(element instanceof InstanceSpecification)) {
			return false;
		}
		InstanceSpecification is = (InstanceSpecification) element;
		if (is.getQualifiedName() != null && QueryUtils.isPartitionInstance(is)) {
			return true;
		}
		return false;
	}

	/**
	 * Returns true if the given element is a component instance, false otherwise
	 * @param element
	 * @return true if the element is a component instance, false otherwise
	 */
	public static boolean elementIsComponentInstance(Element element) {
		if (!(element instanceof InstanceSpecification)) {
			return false;
		}
		InstanceSpecification is = (InstanceSpecification) element;
		if (is.getQualifiedName() != null && QueryUtils.isComponentInstance(is)) {
			return true;
		}
		return false;
	}

	/**
	 * Returns true if the given element is a processor instance, false otherwise
	 * @param element
	 * @return true if the element is a processor instance, false otherwise
	 */
	public static boolean elementIsProcessorInstance(Element element) {
		if (!(element instanceof InstanceSpecification)) {
			return false;
		}
		InstanceSpecification is = (InstanceSpecification) element;
		if (is.getQualifiedName() != null && QueryUtils.isProcessorInstance(is)) {
			return true;
		}
		return false;
	}

	/**
	 * Given the Core (and related processor) get the list of components that are
	 * assigned to it
	 * 
	 * @param core
	 * @param assignments
	 * @return
	 */
	public static LinkedHashSet<Object> getComponentsAssigned2Core(CHCore core, EList<Assign> assignments) {
		LinkedHashSet<Object> result = new LinkedHashSet<Object>();
		InstanceSpecification processorInstance = core.getProcessorInstance();
		String theCoreName = core.getName();
		String theCoreValue = null;

		for (Assign theAssignment : assignments) {
			if (theAssignment != null) {
				try {
					// Only look at assignments where:
					// ASSIGNMENT_SOURCE is a Component
					// ASSIGNMENT_TARGET is the Processor that owns the core
					Element assignmentSource = theAssignment.getFrom().get(0);
					if (!QueryUtils.elementIsComponentInstance(assignmentSource) || !theAssignment.getTo().contains((Object) processorInstance)) {
						continue;
					}

					// found an assignment for the processor that owns the core:
					// let's look into it so see if it is related to the core we are
					// analyzing
					if (theAssignment.getImpliedConstraint() != null && !theAssignment.getImpliedConstraint().isEmpty()) {
						theCoreValue = getCoreNameFromImpliedNfpConstraint(theAssignment);
						if (theCoreValue.equals(theCoreName)) {
							result.add(assignmentSource);
						}
					} else {
						if (processorInstanceIsSingleCore(processorInstance)) {
							// If no core is specified in the Implied Constraint and the
							// Processor has only 1 Core
							result.add(assignmentSource);
						}
					}
				} catch (Exception e) {
					continue;
				}

			}
		}
		return result;
	}

	/**
	 * Given the Core (and related processor) get the list of tasks that are
	 * assigned to it
	 * 
	 * @param core
	 * @param assignments
	 * @return
	 */
	public static LinkedHashSet<Object> getTasksAssigned2Core(CHCore core, Package pack, EList<Assign> assignments) {
		String packQN = pack.getQualifiedName();
		LinkedHashSet<Object> result = new LinkedHashSet<Object>();
		InstanceSpecification processorInstance = core.getProcessorInstance();
		String theCoreName = core.getName();
		String theCoreValue = null;
		String theTaskValue = null;

		for (Assign theAssignment : assignments) {
			if (theAssignment != null) {
				try {
					if (theAssignment.getTo().contains((Object) processorInstance)) {
						// found an assignment for the processor that owns the core:
						// let's look into it so see if it is related to the core we are
						// analyzing
						Element assignmentSource = theAssignment.getFrom().get(0);
						Element assignmentTarget = theAssignment.getTo().get(0);
						String assignedTargetQN = ((NamedElement) assignmentTarget).getQualifiedName();
						String assignedTargetElementName = ((NamedElement) assignmentTarget).getLabel();
						EList<CHTask> chTaskList = new BasicEList<CHTask>();

						if ((packQN + "::" + assignedTargetElementName).equals(assignedTargetQN) && theAssignment.getImpliedConstraint() != null && !theAssignment.getImpliedConstraint().isEmpty()) {
							theCoreValue = getCoreNameFromImpliedNfpConstraint(theAssignment);
							theTaskValue = getTaskNameFromImpliedNfpConstraint(theAssignment);

							if (theCoreValue.equals(theCoreName)) {
								if (QueryUtils.elementIsSlotInstance(assignmentSource)) {
									chTaskList = getAllTasksFromSlot(assignmentSource);
									for (CHTask theChTask : chTaskList) {
										String theTaskName = theChTask.getCHRtSpecification().getContext().getName();
										if (theChTask != null && theTaskName.equals(theTaskValue)) {
											result.add(theChTask);
										}
									}
								}
							} else {
								// If no core is specified in the Implied Constraint and the
								// Processor has only 1 Core
								if (processorInstanceIsSingleCore(processorInstance) && QueryUtils.elementIsSlotInstance(assignmentSource)) {
									chTaskList = getAllTasksFromSlot(assignmentSource);
									for (CHTask theChTask : chTaskList) {
										String theTaskName = theChTask.getCHRtSpecification().getContext().getName();
										if (theChTask != null && theTaskName.equals(theTaskValue)) {
											result.add(theChTask);
										}
									}
								}
							}
						}
					}
				} catch (Exception e) {
					continue;
				}
			}
		}
		return result;
	}

	
	/**
	 * Returns the list of Component to Core assignments in the given view in the given model
	 * @param umlModel
	 * @param viewName
	 * @return
	 * @throws ModelError
	 */
	public static EList<Assign> getComponent2CoreAssignments(Model umlModel, String viewName) throws ModelError {
		// LB 20150708 we now look for assignments in the CHGA resource platform
		// component
		// Package cmpv = CHESSProfileManager.getViewByStereotype(umlModel,
		// viewName);
		// cmpv = QueryUtils.getResourcePlatformPackage(cmpv);

		Component rpc = QueryUtils.getResourcePlatformComponent(umlModel, viewName);
		EList<Element> all = rpc.allOwnedElements();
		EList<Assign> assignments = new BasicEList<Assign>();
		Stereotype stereo = null;
		for (Element element : all) {
			if ((element.getAppliedStereotype(MARTE_ASSIGN) != null)) {
				stereo = element.getAppliedStereotype(MARTE_ASSIGN);
				EObject eobj = element.getStereotypeApplication(stereo);
				Assign a = (Assign) eobj;
				Element assignmentSource = a.getFrom().get(0);
				Element assignmentTarget = a.getTo().get(0);
				// SOURCE must be a Component
				// TARGET must be a Processor
				if (elementIsProcessorInstance(assignmentTarget)) {
					if (elementIsComponentInstance(assignmentSource)) {
						InstanceSpecification componentInst = (InstanceSpecification) assignmentSource;
						if (isComponentInstance(componentInst)) {
							assignments.add(a);
						}
					}
				}
			}
		}
		return assignments;
	}

	
	/**
	 * Returns the list of Component to Partition assignments in the given view in the given model
	 * @param umlModel
	 * @param viewName
	 * @return
	 * @throws ModelError
	 */
	public static EList<Assign> getComponent2PartitionAssignments(Model umlModel, String viewName) throws ModelError {
		// LB 20150708 we now look for assignments in the CHGA resource platform
		// component
		// Package cmpv = CHESSProfileManager.getViewByStereotype(umlModel,
		// viewName);
		// cmpv = QueryUtils.getResourcePlatformPackage(cmpv);

		Component rpc = QueryUtils.getResourcePlatformComponent(umlModel, viewName);
		EList<Element> all = rpc.allOwnedElements();
		EList<Assign> assignments = new BasicEList<Assign>();
		Stereotype stereo = null;
		for (Element element : all) {
			if ((element.getAppliedStereotype(MARTE_ASSIGN) != null)) {
				stereo = element.getAppliedStereotype(MARTE_ASSIGN);
				EObject eobj = element.getStereotypeApplication(stereo);
				Assign a = (Assign) eobj;
				Element assignmentSource = a.getFrom().get(0);
				Element assignmentTarget = a.getTo().get(0);
				// SOURCE must be a Component
				// TARGET must be a Partition
				if (elementIsPartitionInstance(assignmentTarget)) {
					if (elementIsComponentInstance(assignmentSource)) {
						InstanceSpecification componentInst = (InstanceSpecification) assignmentSource;
						if (isComponentInstance(componentInst)) {
							assignments.add(a);
						}
					}
				}
			}
		}
		return assignments;
	}

	
	/**
	 * Returns the list of Partition to Core assignments in the given view in the given model
	 * @param umlModel
	 * @param viewName
	 * @return
	 * @throws ModelError
	 */
	public static EList<Assign> getPartition2CoreAssignments(Model umlModel, String viewName) throws ModelError {
		// LB 20150708 we now look for assignments in the CHGA resource platform
		// component
		// Package cmpv = CHESSProfileManager.getViewByStereotype(umlModel,
		// viewName);
		// cmpv = QueryUtils.getResourcePlatformPackage(cmpv);

		Component rpc = QueryUtils.getResourcePlatformComponent(umlModel, viewName);
		EList<Element> all = rpc.allOwnedElements();
		EList<Assign> assignments = new BasicEList<Assign>();
		Stereotype stereo = null;
		for (Element element : all) {
			if ((element.getAppliedStereotype(MARTE_ASSIGN) != null)) {
				stereo = element.getAppliedStereotype(MARTE_ASSIGN);
				EObject eobj = element.getStereotypeApplication(stereo);
				Assign a = (Assign) eobj;
				Element assignmentSource = a.getFrom().get(0);
				Element assignmentTarget = a.getTo().get(0);
				// SOURCE must be a Partition
				// TARGET must be a Processor
				if (elementIsPartitionInstance(assignmentSource) && elementIsProcessorInstance(assignmentTarget)) {
					assignments.add(a);
				}
			}
		}
		return assignments;
	}

	/**
	 * Returns the list of Task to Core assignments in the given view in the given model
	 * @param umlModel
	 * @param viewName
	 * @return
	 * @throws ModelError
	 */
	public static EList<Assign> getTask2CoreAssignments(Model umlModel, String viewName) throws ModelError {
		// LB 20150708 we now look for assignments in the CHGA resource platform
		// component
		// Package cmpv = CHESSProfileManager.getViewByStereotype(umlModel,
		// viewName);
		// cmpv = QueryUtils.getResourcePlatformPackage(cmpv);

		Component rpc = QueryUtils.getResourcePlatformComponent(umlModel, viewName);
		EList<Element> all = rpc.allOwnedElements();
		EList<Assign> assignments = new BasicEList<Assign>();
		Stereotype stereo = null;
		for (Element element : all) {
			if ((element.getAppliedStereotype(MARTE_ASSIGN) != null)) {
				stereo = element.getAppliedStereotype(MARTE_ASSIGN);
				EObject eobj = element.getStereotypeApplication(stereo);
				Assign a = (Assign) eobj;
				Element assignmentSource = a.getFrom().get(0);
				Element assignmentTarget = a.getTo().get(0);
				// SOURCE must be a Task
				// TARGET must be a Processor
				if (elementIsSlotInstance(assignmentSource) && elementIsProcessorInstance(assignmentTarget)) {
					assignments.add(a);
				}
			}
		}
		return assignments;
	}

	/**
	 * Returns true is the input Instance Processor has only 1 CORE
	 * 
	 * @param processorInstance
	 * @return
	 */
	public static boolean processorInstanceIsSingleCore(InstanceSpecification processorInstance) {
		Classifier processorClass = processorInstance.getClassifiers().get(0);
		CH_HwProcessor processorType = UMLUtils.getStereotypeApplication(processorClass, CH_HwProcessor.class);
		String coreNumber = null;
		coreNumber = processorType.getNbCores();
		int icoreNumber = 1;
		try {
			icoreNumber = Integer.parseInt(coreNumber);
		} catch (Exception e) {
			icoreNumber = 1;
		}
		if (icoreNumber == 1) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the Package (in the Deployment View) that owns the input system
	 * 
	 * @param theSystem
	 * @return
	 * @throws ModelError
	 */
	public static Package getOwnerCHGaResourcePlatformPackage(Model umlModel, InstanceSpecification theSystem) throws ModelError {
		EList<Package> packList = QueryUtils.getResourcePlatformPackages(umlModel, Constants.DEPLOYMENT_VIEW_NAME);
		for (Package pack : packList) {
			EList<Element> packElems = pack.allOwnedElements();
			for (Element elem : packElems) {
				if (elem instanceof InstanceSpecification) {
					if (((InstanceSpecification) elem).equals(theSystem)) {
						return pack;
					}
				}
			}
		}
		return null;
	}

}
