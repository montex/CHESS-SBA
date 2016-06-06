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
  ------------------------------------------------------------------------------*/package org.polarsys.chess.multicore.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CH_HwProcessor;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification;
import org.polarsys.chess.core.profiles.CHESSProfileManager;
import org.polarsys.chess.core.util.uml.ModelError;
import org.polarsys.chess.core.util.uml.UMLUtils;
import org.polarsys.chess.multicore.dialogs.SystemSelectionDialog;
import org.polarsys.chess.multicore.model.AbstractCommand;
import org.polarsys.chess.multicore.model.CHCore;
import org.polarsys.chess.multicore.model.CHTask;
import org.polarsys.chess.multicore.model.SupertaskInfo;
import org.polarsys.chess.multicore.partitioning.Bin;
import org.polarsys.chess.multicore.partitioning.BinPackerFactory;
import org.polarsys.chess.multicore.partitioning.RUNReduction;
import org.polarsys.chess.multicore.partitioning.Task;
import org.polarsys.chess.multicore.utils.GeneratorUtils;
import org.polarsys.chess.multicore.utils.QueryUtils;
import org.polarsys.chess.multicore.utils.QueryUtils.OccKindInfo;
import org.polarsys.chess.validator.constraints.StringParser;

public class GenerateTask2CoreAssignmentsCommand extends AbstractCommand {
	private HashMap<CHTask, EList<CHTask>> operationList;

	private Map<CHCore, LinkedHashSet<Object>> core2chtask;

	private EList<InstanceSpecification> processors;

	private EList<CHCore> cores = new BasicEList<CHCore>();

	private Set<CHTask> assignedOperations = new HashSet<CHTask>();

	private Map<Package, EList<InstanceSpecification>> processorsMap = new HashMap<Package, EList<InstanceSpecification>>();
	private Map<InstanceSpecification, EList<CHCore>> coresMap = new HashMap<InstanceSpecification, EList<CHCore>>();
	private static Component hwSystem;
	private EList<InstanceSpecification> hwSystemsList = new BasicEList<InstanceSpecification>();

	private boolean useRUN;

	private List<SupertaskInfo> supertaskInfoList;

	private HashMap<SupertaskInfo, LinkedHashSet<Object>> core2supertask;

	/**
	 * Open selector to choose HW system where assign tasks
	 * 
	 * @param umlModel
	 * @param hwSystemsList
	 * @return
	 */
	private static InstanceSpecification openSystemSelector(Model umlModel, EList<InstanceSpecification> hwSystemsList) {

		// First of all show selector to select HwSystem
		List<InstanceSpecification> systemSelection = new ArrayList<InstanceSpecification>();
		for (InstanceSpecification syst : hwSystemsList) {
			systemSelection.add(syst);
		}

		Shell activeShell = Display.getDefault().getActiveShell();
		SystemSelectionDialog systemDialog = new SystemSelectionDialog(activeShell, systemSelection, "Select System where to assign tasks");
		if (systemDialog.open() == Window.OK) {
			String selectedSystemQN = systemDialog.getSystemName();
			EList<Element> allElems = umlModel.allOwnedElements();
			for (Element elem : allElems) {
				InstanceSpecification theSystem;
				if (elem instanceof InstanceSpecification) {
					theSystem = (InstanceSpecification) elem;
					if (theSystem.getQualifiedName() != null && theSystem.getQualifiedName().equals(selectedSystemQN)) {
						Classifier classif = theSystem.getClassifiers().get(0);
						hwSystem = (Component) classif;
						return theSystem;
					}
				}
			}
		}
		return null;
	}

	@Override
	public void execute() throws ModelError {
		queryContent(umlModel);

		int howMany = hwSystemsList.size();

		InstanceSpecification theSystem = null;
		if (howMany > 1) {
			theSystem = openSystemSelector(umlModel, hwSystemsList);
		} else {
			theSystem = hwSystemsList.get(0);
		}

		if (theSystem != null) {
			Package pack = QueryUtils.getOwnerCHGaResourcePlatformPackage(umlModel, theSystem);

			EList<InstanceSpecification> processorList = processorsMap.get(pack);

			cores = new BasicEList<CHCore>();
			if (processorList != null) {
				for (InstanceSpecification proc : processorList) {
					EList<CHCore> coreList = coresMap.get(proc);
					for (CHCore core : coreList) {
						cores.add(core);
					}
				}
			}

			executeTask2CoreCalculator(false);

			// printContent();
			if (core2chtask != null) {
				updateModel();
			}
		}
	}

	protected void executeTask2CoreCalculator(boolean forceUseOfRUN) throws ModelError {

		List<Bin> allBins = new ArrayList<Bin>();
		List<Task> allTasks = new ArrayList<Task>();
		System.out.format("We have %d cores\n", cores.size());
		// init bins
		for (int i = 0; i < cores.size(); i++)
			allBins.add(new Bin(i));

		for (CHTask chRtSpecification : operationList.keySet()) {

			String occKind = chRtSpecification.getCHRtSpecification().getOccKind();
			OccKindInfo info = QueryUtils.getOccKindInfo(occKind);

			double c_ = QueryUtils.getWCET(chRtSpecification.getCHRtSpecification());
			/* add the wcet for each operation relative to this chrtspec */
			for (CHTask spec : operationList.get(chRtSpecification)) {
				double c_1 = QueryUtils.getWCET(spec.getCHRtSpecification());
				c_ += c_1;
			}
			StringParser sp = new StringParser();
			double d_ = sp.getValueNFP(chRtSpecification.getCHRtSpecification().getRlDl());
			double t_ = info.value;

			// d_ = xxx.remove(0);
			// t_ = d_;

			String name = getTaskID(chRtSpecification.getCHRtSpecification());

			float c = (float) c_;// exec time
			float d = (float) d_;// deadline
			float t = (float) t_;// period
			float o = 0;// TODO insert offset in stereotype

			double u_ = c / t;
			float u = (float) u_;

			System.out.println("Task " + name + " -> " + c + " " + d + " " + t + " -> " + u);
			allTasks.add(new Task(name, new Float(c), new Float(d), new Float(t), new Float(o), null));

		}

		Map<Bin, List<Task>> firstPack = BinPackerFactory.getBinPacker(org.polarsys.chess.multicore.partitioning.Heuristic.WORST_FIT).pack(allBins, allTasks);
		Map<Bin, List<Task>> reductionTree = new Hashtable<Bin, List<Task>>(firstPack);

		useRUN = reductionTree.size() > allBins.size();
		if (forceUseOfRUN)
			useRUN = true;

		if (useRUN) {
			System.out.println("Starting RUN packing");
			allTasks = new ArrayList<Task>();
			for (Bin bin : reductionTree.keySet())
				allTasks.add(new Task(bin.getId().toString(), bin.getCapacity()));
			reductionTree = new RUNReduction().pack(null, allTasks);
			for (java.util.Map.Entry<Bin, List<Task>> row : reductionTree.entrySet()) {
				System.out.print("LEVEL " + row.getKey().getLevel() + "-" + row.getKey().getId() + "(U=" + row.getKey().getCapacity() + ") -> {");
				for (Task t : row.getValue())
					System.out.print(" " + t.getId() + ",");
				System.out.println("}");
			}
			buildRUNAssociations(firstPack, reductionTree);
		} else
			// Build model results
			buildAssociations(firstPack);
	}

	private void buildRUNAssociations(Map<Bin, List<Task>> firstPack, Map<Bin, List<Task>> reductionTree) throws ModelError {
		// add chtasks which represent real tasks to the core map and add the
		// related operation chain to the same core
		// TODO solve the following problem: the related operations may be shared
		// between tasks which can be assigned to different cores!

		core2supertask = new HashMap<SupertaskInfo, LinkedHashSet<Object>>();

		Object[] firstPackSorted = firstPack.entrySet().toArray();
		Arrays.sort(firstPackSorted, new Comparator<Object>() {

			@Override
			public int compare(Object o1, Object o2) {
				if (((Entry<Bin, List<Task>>) o1).getKey().getId() > ((Entry<Bin, List<Task>>) o2).getKey().getId())
					return 1;
				else if (((Entry<Bin, List<Task>>) o1).getKey().getId() < ((Entry<Bin, List<Task>>) o2).getKey().getId())
					return -1;
				else
					return 0;
			}
		});

		Object[] allBins = reductionTree.keySet().toArray();
		Arrays.sort(allBins, new Comparator<Object>() {

			@Override
			public int compare(Object o1, Object o2) {
				if (((Bin) o1).getLevel() > ((Bin) o2).getLevel())
					return -1;
				else if (((Bin) o1).getLevel() < ((Bin) o2).getLevel())
					return 1;
				else
					return 0;
			}
		});

		// DEPTH-FIRST print
		// root level

		CH_HwProcessor procInstance = QueryUtils.getAllProcessorInstances(umlModel).get(0);

		int maxLevel = ((Bin) allBins[0]).getLevel();
		System.out.println("-- Primary Schedulers\n");
		System.out.println("Scheduler (");
		System.out.println("	Type	=> Primary_Scheduler,");
		System.out.println("	Name	=> Scheduler_1,");
		System.out.println("	Policy	=> ( Type => RUN ),");
		System.out.println("	Host	=> Multicore_1 );");// TODO: depends on CHRT
		// specification
		System.out.println("\n-- Primary Scheduling Servers and Secondary Schedulers\n");
		int indexSupertask = 0;
		// all levels of the tree in the interval (root,0]
		supertaskInfoList = new ArrayList<SupertaskInfo>();
		for (int i = 1; (i < allBins.length) && (((Bin) allBins[i]).getLevel() >= 0); i++) {
			createSupertaskInfo(procInstance, indexSupertask, ((Bin) allBins[i]).getCapacity());

			assignedOperations = new HashSet<CHTask>();
			// first pack: print leaf nodes
			if (((Bin) allBins[i]).getLevel() == 0) {
				List<Task> tasks = reductionTree.get(((Bin) allBins[i]));
				LinkedHashSet<Object> list = new LinkedHashSet<Object>();
				for (Task task : tasks) {
					List<Task> leaves = ((Entry<Bin, List<Task>>) firstPackSorted[new Integer(task.getId())]).getValue();
					for (Task leaf : leaves) {
						System.out.println("Scheduling_Server (");
						System.out.println("	Type				=> Regular,");
						System.out.println("	Name 				=> " + leaf.getId() + ",");
						System.out.println("	Server_Sched_Parameters		=> (");
						System.out.println("		Type			=> EDF_policy,");
						System.out.println("		Deadline		=> " + leaf.getT() + ",");
						System.out.println("                Preassigned             => No),");
						System.out.println("	Scheduler			=> SecondaryScheduler_" + indexSupertask + ");");
						System.out.println();

						CHTask owningTask = getCHRTFromTask(leaf);
						list.add(owningTask);
						addRelatedOperations(owningTask, list);

					}

				}
				core2supertask.put(supertaskInfoList.get(indexSupertask), list);
			}
			indexSupertask++;
		}
	}

	private void createSupertaskInfo(CH_HwProcessor ch_HwProcessor, int indexSupertask, Float capacity) {
		SupertaskInfo si = new SupertaskInfo(ch_HwProcessor.getBase_InstanceSpecification(), "SuperTask_" + indexSupertask, capacity);
		supertaskInfoList.add(si);
		System.out.println("--*************** BRANCH ***************");
		System.out.println("Scheduling_Server (");
		System.out.println("	Type				=> Regular,");
		System.out.println("	Name				=> SuperTask_" + indexSupertask + ",");
		System.out.println("	Server_Sched_parameters		=> ( Type => RUN_Supertask,");
		System.out.println("					     Utilization => " + capacity + " ),"); // FIXME:
		// utilization
		// is
		// not
		// expressed
		// as U
		// in
		// Geoffrey's
		// example
		System.out.println("	Scheduler			=> Scheduler_1 );");
		System.out.println();
		System.out.println("Scheduler (");
		System.out.println("	Type	=> Secondary_Scheduler,");
		System.out.println("	Name	=> SecondaryScheduler_" + indexSupertask + ",");
		System.out.println("	Policy	=> ( 	Type	=> EDF,");
		System.out.println("			Worst_Context_Switch	=> 20 ),");// FIXME: based on
		// Compagnin paper
		// at ECRTS2014
		System.out.println("	Server	=> SuperTask_" + indexSupertask + " );");
		System.out.println();
	}

	public void buildAssociations(Map<Bin, List<Task>> firstPack) {
		// add chtasks which represent real tasks to the core map and add the
		// related operation chain to the same core
		// TODO solve the following problem: the related operations may be shared
		// between tasks which can be assigned to different cores!

		core2chtask = new HashMap<CHCore, LinkedHashSet<Object>>();
		int coreIndex = 0;
		for (Bin core : firstPack.keySet()) {
			assignedOperations = new HashSet<CHTask>();
			LinkedHashSet<Object> list = new LinkedHashSet<Object>();
			for (Task task : firstPack.get(core)) {
				CHTask owningTask = getCHRTFromTask(task);
				list.add(owningTask);
				addRelatedOperations(owningTask, list);
			}
			core2chtask.put(cores.get(coreIndex++), list);
		}
	}

	// the related operations of a task are assigned to the same core of the task,
	// TODO for now every operation shared by multiple tasks is assigned to the
	// same core of the first task that was processed
	private void addRelatedOperations(CHTask owningTask, LinkedHashSet<Object> list) {
		for (CHTask operation : operationList.get(owningTask)) {
			if (!assignedOperations.contains(operation)) {
				list.add(operation);
				assignedOperations.add(operation);
			}
		}
	}

	private String getTaskID(CHRtSpecification chRtSpecification) {
		return chRtSpecification.getContext().getName() + UMLUtils.getElementID(chRtSpecification.getContext());
	}

	private CHTask getCHRTFromTask(Task task) {
		for (CHTask chtask : operationList.keySet()) {
			if (getTaskID(chtask.getCHRtSpecification()).equals(task.getId()))
				return chtask;
		}
		return null;
	}

	private void printContent() {
		System.out.println("Tasks:");
		for (CHTask chtask : operationList.keySet()) {
			System.out.println(chtask);
		}
	}

	protected void updateModel() {
		boolean b1 = core2chtask != null && !core2chtask.isEmpty();
		boolean b2 = core2supertask != null && !core2supertask.isEmpty();

		if (b1 || b2) {

			TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(umlModel);
			editingDomain.getCommandStack().execute(new Com(editingDomain));
		}
	}

	protected void queryContent(Model owner) throws ModelError {
		EList<CH_HwProcessor> x = QueryUtils.getAllProcessorInstances(umlModel);
		x = QueryUtils.filterMultiCoreProcessors(x);
		if (x.size() > 1)
			throw new ModelError("Assignment generation works only on single processor systems");

		// Look for Packages stereotyped as CHGAResourcePlatform in the Deployment
		// View
		EList<Package> packages = QueryUtils.getResourcePlatformPackages(umlModel, CHESSProfileManager.DEPLOYMENT_VIEW);

		if (packages.size() == 0) {
			ModelError me = new ModelError("Error in model: no Package stereotyped as CHGAResourcePlatform in the Deployment View!");
			throw me;
		}
		hwSystemsList = new BasicEList<InstanceSpecification>();

		for (Package pack : packages) {
			EList<InstanceSpecification> processors = new BasicEList<InstanceSpecification>();
			for (CH_HwProcessor ch_processor : QueryUtils.getAllProcessorInstancesInPackage(pack)) {
				InstanceSpecification instSpec = ch_processor.getBase_InstanceSpecification();
				processors.add(instSpec);
				EList<CHCore> theCores = QueryUtils.getCores(ch_processor);
				coresMap.put(instSpec, theCores);
				cores.addAll(theCores);
			}
			InstanceSpecification theSystem = UMLUtils.getRootInstanceInPackage(pack);
			hwSystemsList.add(theSystem);
			processorsMap.put(pack, processors);
		}

		if (hwSystemsList.isEmpty()) {
			ModelError me = new ModelError("Error in model: no System in the Deployment View!");
			throw me;
		}

		EList<InstanceSpecification> instances = UMLUtils.getAllComponentInstances(umlModel, true);
		EList<CHTask> chtasks = QueryUtils.getCHTasksList(instances);

		operationList = QueryUtils.getOperationChain(umlModel, chtasks);

	}

	class Com extends RecordingCommand {

		public Com(TransactionalEditingDomain domain) {
			super(domain);
		}

		@Override
		protected void doExecute() {
			try {
				QueryUtils.deleteTask2CoreAssociations(hwSystem);
				if (!useRUN)
					GeneratorUtils.buildTask2CoreAssociations(hwSystem, core2chtask);
				else
					GeneratorUtils.buildTask2SuperTaskAssociations(hwSystem, core2supertask, supertaskInfoList);

			} catch (Exception e) {
				throw new OperationCanceledException(e.getMessage());
			}
		}
	}

}