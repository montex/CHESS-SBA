package org.polarsys.chess.multicore.partitioning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Factory for bin packing algorithms.
 * @author andrea
 *
 */
public class BinPackerFactory {
	
public static BinPacker getBinPacker(Heuristic heuristic){
		
		BinPacker packer;
		switch(heuristic){
		case WORST_FIT:
			packer = new WorstFitBinPacker();
			break;
		default:
			packer = new WorstFitBinPacker();
			break;
		}
		return packer;
	}
	
	
	public static void main(String[] args){
		
		int nr_bins = 2;
		List<Bin> allBins = new ArrayList<Bin>();
		List<Task> allTasks = new ArrayList<Task>();
		

//		allTasks.add(new Task("Task1", 20.0f, 100.0f, 100.0f, 0.0f, null));
////		allTasks.add(new Task("Task2", 15.0f, 100.0f, 100.0f, 0.0f, null));
////		allTasks.add(new Task("Task22", 15.0f, 100.0f, 100.0f, 0.0f, null));
//		allTasks.add(new Task("Task11", 25.0f, 100.0f, 100.0f, 0.0f, null));
//		allTasks.add(new Task("Task3", 85.0f, 100.0f, 100.0f, 0.0f, null));
//		allTasks.add(new Task("Task4", 80.0f, 100.0f, 100.0f, 0.0f, null));
		
		// 3 levels in the reduction tree
		allTasks.add(new Task("Task1", 60.0f, 100.0f, 100.0f, 0.0f, null));
		allTasks.add(new Task("Task2", 60.0f, 100.0f, 100.0f, 0.0f, null));
		allTasks.add(new Task("Task3", 30.0f, 100.0f, 100.0f, 0.0f, null));
		allTasks.add(new Task("Task4", 30.0f, 100.0f, 100.0f, 0.0f, null));
		allTasks.add(new Task("Task5", 60.0f, 100.0f, 100.0f, 0.0f, null));
		allTasks.add(new Task("Task6", 30.0f, 100.0f, 100.0f, 0.0f, null));
		allTasks.add(new Task("Task7", 30.0f, 100.0f, 100.0f, 0.0f, null));
		allTasks.add(new Task("Task8", 30.0f, 100.0f, 100.0f, 0.0f, null));
		allTasks.add(new Task("Task9", 60.0f, 100.0f, 100.0f, 0.0f, null));
		
		Map<Bin, List<Task>> firstPacking = BinPackerFactory.getBinPacker(Heuristic.WORST_FIT).pack(allBins, allTasks);
		for(java.util.Map.Entry<Bin, List<Task>> row : firstPacking.entrySet()){
			System.out.print("LEVEL "+row.getKey().getLevel()+"-"+row.getKey().getId()+"(U="+row.getKey().getCapacity()+") -> {");
			for(Task t : row.getValue()) System.out.print(" "+t.getId()+",");
			System.out.println("}");
		}
		if(firstPacking.size() > allBins.size()){
			System.out.println("Starting RUN packing");
			allTasks = new ArrayList<Task>();
			for(Bin bin : firstPacking.keySet())
				allTasks.add(new Task(bin.getId().toString(), bin.getCapacity()));
			Map<Bin, List<Task>> reductionTree = new RUNReduction().pack(null, allTasks);
			for(java.util.Map.Entry<Bin, List<Task>> row : reductionTree.entrySet()){
				System.out.print("LEVEL "+row.getKey().getLevel()+"-"+row.getKey().getId()+"(U="+row.getKey().getCapacity()+") -> {");
				for(Task t : row.getValue()) System.out.print(" "+t.getId()+",");
				System.out.println("}");
			}
			printMASTinput(firstPacking, reductionTree);
		}
	}
	
	private static void printMASTinput(Map<Bin, List<Task>> firstPack, Map<Bin, List<Task>> reductionTree){
		Object[] firstPackSorted = firstPack.entrySet().toArray();
		Arrays.sort(firstPackSorted, new Comparator<Object>() {

			@Override
			public int compare(Object o1, Object o2) {
				if(((Entry<Bin, List<Task>>)o1).getKey().getId()>((Entry<Bin, List<Task>>)o2).getKey().getId())
					return 1;
				else if (((Entry<Bin, List<Task>>)o1).getKey().getId()<((Entry<Bin, List<Task>>)o2).getKey().getId())
					return -1;
				else
					return 0;
		}});
		
//		for(int i=0; i<firstPackSorted.length; i++)
//			System.out.println(((Entry<Bin, List<Task>>)firstPackSorted[i]).getKey().getId());
		
		Object[] allBins = reductionTree.keySet().toArray();
		Arrays.sort(allBins, new Comparator<Object>() {

				@Override
				public int compare(Object o1, Object o2) {
					if(((Bin)o1).getLevel()>((Bin)o2).getLevel())
						return -1;
					else if (((Bin)o1).getLevel()<((Bin)o2).getLevel())
						return 1;
					else
						return 0;
			}});
		
		// DEPTH-FIRST print
		// root level
		int maxLevel = ((Bin)allBins[0]).getLevel();
		System.out.println("-- Primary Schedulers\n");
		System.out.println("Scheduler (");
		System.out.println("	Type	=> Primary_Scheduler,");
		System.out.println("	Name	=> Scheduler_1,");
		System.out.println("	Policy	=> ( Type => RUN ),");
		System.out.println("	Host	=> Multicore_1 );");//TODO: depends on CHRT specification
		System.out.println("\n-- Primary Scheduling Servers and Secondary Schedulers\n");
		int indexSupertask =0;
		// all levels of the tree in the interval (root,0]
		for(int i=1; (i<allBins.length)&&(((Bin)allBins[i]).getLevel()>=0); i++){
			System.out.println("--*************** BRANCH ***************");
			System.out.println("Scheduling_Server (");
			System.out.println("	Type				=> Regular,");
			System.out.println("	Name				=> SuperTask_"+indexSupertask+",");
			System.out.println("	Server_Sched_parameters		=> ( Type => RUN_Supertask,");
			System.out.println("					     Utilization => "+((Bin)allBins[i]).getCapacity()+" ),"); //FIXME: utilization is not expressed as U in Geoffrey's example
			System.out.println("	Scheduler			=> Scheduler_1 );");
			System.out.println();
			System.out.println("Scheduler (");
			System.out.println("	Type	=> Secondary_Scheduler,");
			System.out.println("	Name	=> SecondaryScheduler_"+indexSupertask+",");
			System.out.println("	Policy	=> ( 	Type	=> EDF,");
			System.out.println("			Worst_Context_Switch	=> 20 ),");//FIXME: based on Compagnin paper at ECRTS2014
			System.out.println("	Server	=> SuperTask_"+indexSupertask+" );");
			System.out.println();
			// first pack: print leaf nodes
			if(((Bin)allBins[i]).getLevel()==0){
				List<Task> tasks = reductionTree.get(((Bin)allBins[i]));
				for(Task task : tasks){
					List<Task> leaves = ((Entry<Bin, List<Task>>)firstPackSorted[new Integer(task.getId())]).getValue();
					for(Task leaf : leaves){
						System.out.println("Scheduling_Server (");
						System.out.println("	Type				=> Regular,");
						System.out.println("	Name 				=> "+leaf.getId()+",");
						System.out.println("	Server_Sched_Parameters		=> (");
						System.out.println("		Type			=> EDF_policy,");
						System.out.println("		Deadline		=> "+leaf.getT()+",");
						System.out.println("                Preassigned             => No),");
						System.out.println("	Scheduler			=> SecondaryScheduler_"+indexSupertask+");");
						System.out.println();
					}
				}
			}
			indexSupertask++;
		}		
	}

}
