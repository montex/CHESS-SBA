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
  ------------------------------------------------------------------------------*/package org.polarsys.chess.multicore.partitioning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class WorstFitBinPacker implements BinPacker {
	
	private final boolean DECREASING_ORDERING = true; 

//	@Override
//	public Map<Bin, List<Task>> pack(List<Bin> bins, List<Task> tasks) {		
//		
//		Map<Bin, List<Task>> toReturn = new Hashtable<Bin, List<Task>> ();
//		// init output
//		for(Bin bin : bins)
//			toReturn.put(bin, new ArrayList<Task>());
//		
//		
//		if(tasks.size() <= bins.size()){ // trivial packing
//			int i =0;
//			for(Task task : tasks){
//				Bin bin = bins.get(i);
//				ArrayList<Task> theList = new ArrayList<Task>();
//				theList.add(task);
//				bin.setCapacity(bin.getCapacity()+task.computeU());
//				toReturn.put(bin, theList);
//				i++;
//			}
//		} else {// nominal case
//			
//			// sort the tasks by increasing/decreasing utilisation
//			Object[] allTasks = tasks.toArray();
//			//Arrays.sort(allTasks);
//			Arrays.sort(allTasks, new Comparator<Object>() {
//
//				@Override
//				public int compare(Object o1, Object o2) {
//					if(DECREASING_ORDERING)
//						return -(((Task)o1).computeU()).compareTo(((Task)o2).computeU());
//					else
//						return (((Task)o1).computeU()).compareTo(((Task)o2).computeU());
//				}
//			});
//			
//			int indexEmptiestBin = 0;
//			float emptiestCapacity = 0.0f;
//			Object[] allBins = bins.toArray();
//			
//			
//			for(int taskIndex = 0; taskIndex < allTasks.length; taskIndex++){
//				
//				Task task = (Task)allTasks[taskIndex];
//				boolean found = false;
//				
//				Bin bin = (Bin)allBins[indexEmptiestBin];
//				// try with emptiest bin
//				if(bin.getCapacity() + task.computeU() <= bin.getSize())
//					found = true;
//				else { //try with other bins 
//					for(int indexCurrentBin = 0; indexCurrentBin < allBins.length; indexCurrentBin++){
//						if (indexCurrentBin == indexEmptiestBin) // already visited
//							continue;
//						bin =(Bin)allBins[indexCurrentBin];
//						if(bin.getCapacity() + task.computeU() <= bin.getSize()){
//							found = true;
//							break;
//						}
//					}
//				}
//				
//				if(!found)
//					System.out.println("PACKING FAILED");
//				else {
//					task.setOwner(bin);
//					bin.setCapacity(bin.getCapacity()+task.computeU());
//					// store to output
//					List<Task> theTasks = toReturn.get(bin);
//					theTasks.add(task);
//					toReturn.put(bin, theTasks);
//					found = true;
//					// update info on emptiest bin
//					emptiestCapacity = Float.MAX_VALUE;
//					for(int binIndex = 0; binIndex < allBins.length; binIndex++){
//						float currentCapacity = ((Bin)allBins[binIndex]).getCapacity();
//						if(currentCapacity < emptiestCapacity){
//							emptiestCapacity = currentCapacity;
//							indexEmptiestBin = binIndex;
//						}
//					}
//				}
//			}
//			
//		}
//		return toReturn;
//	}

	@Override
	public Map<Bin, List<Task>> pack(List<Bin> bins, List<Task> tasks) {		
		
		Map<Bin, List<Task>> toReturn = new Hashtable<Bin, List<Task>> ();
		
		// init output
//		for(Bin bin : bins)
//			toReturn.put(bin, new ArrayList<Task>());
		
		
		if(tasks.size() <= bins.size()){ // trivial packing
			int i =0;
			for(Task task : tasks){
				Bin bin = bins.get(i);
				ArrayList<Task> theList = new ArrayList<Task>();
				theList.add(task);
				bin.setCapacity(bin.getCapacity()+task.getU());
				toReturn.put(bin, theList);
				i++;
			}
		} else {// nominal case
			
			// sort the tasks by increasing/decreasing utilization
			Object[] allTasks = tasks.toArray();
			//Arrays.sort(allTasks);
			Arrays.sort(allTasks, new Comparator<Object>() {

				@Override
				public int compare(Object o1, Object o2) {
					if(DECREASING_ORDERING)
						return -(((Task)o1).getU()).compareTo(((Task)o2).getU());
					else
						return (((Task)o1).getU()).compareTo(((Task)o2).getU());
				}
			});
			
			int indexEmptiestBin = 0;
			float emptiestCapacity = 0.0f;
			Object[] allBins = {new Bin(indexEmptiestBin)}; // ensure there is at least 1 bin even in case an empty list has been passed (this is the case during RUN reduction)
			int indexLastBin = 0;
			if(bins.size() > 0){
				allBins = bins.toArray();
				indexLastBin = bins.size()-1;
			}
				
			
			
			for(int taskIndex = 0; taskIndex < allTasks.length; taskIndex++){
				
				Task task = (Task)allTasks[taskIndex];
				Bin bin = (Bin)allBins[indexEmptiestBin];
				// try with emptiest bin
				if(bin.getCapacity() + task.getU() <= bin.getSize()){
					task.setOwner(bin);
					bin.setCapacity(bin.getCapacity()+task.getU());
					// store to output
					List<Task> theTasks = toReturn.get(bin);
					if(theTasks == null) // needed because we don't initialize toReturn at the beginning, to provide input/output of variable size
						theTasks = new ArrayList<Task>();
					theTasks.add(task);
					toReturn.put(bin, theTasks);
				}
				else {
					//System.out.println("PARTITIONING FAILED, OPENING NEW BIN");
					// open new bin
					Bin newBin = new Bin(new Integer(++indexLastBin));
					task.setOwner(newBin);
					newBin.setCapacity(newBin.getCapacity()+task.getU());
					ArrayList<Task> theList = new ArrayList<Task>();
					theList.add(task);
					toReturn.put(newBin, theList);
					
					// add bin to the common array 
					Object[] tmpBinArray = Arrays.copyOf(allBins, allBins.length + 1);
					assert(tmpBinArray.length -1 == indexLastBin);
					tmpBinArray[indexLastBin] = newBin;
					allBins = tmpBinArray;
				}
				
				// update info on emptiest bin
				emptiestCapacity = Float.MAX_VALUE;
				for(int binIndex = 0; binIndex < allBins.length; binIndex++){
					float currentCapacity = ((Bin)allBins[binIndex]).getCapacity();
					if(currentCapacity < emptiestCapacity){
						emptiestCapacity = currentCapacity;
						indexEmptiestBin = binIndex;
					}
				}
			}
			
		}
		return toReturn;
	}
}
