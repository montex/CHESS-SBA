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
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RUNReduction implements BinPacker {
	
	//private final boolean DECREASING_ORDERING = true;
	int level = -1;

	@Override
	public Map<Bin, List<Task>> pack(List<Bin> bins, List<Task> tasks) {
		
		level++;
		Map<Bin, List<Task>> toReturn = new Hashtable<Bin, List<Task>> ();
		
		
		if(tasks.size()==1){
			//toReturn.put(new Bin(new Integer(tasks.get(0).getId())), tasks);
			Bin theBin = new Bin(0);
			theBin.setLevel(level);
			toReturn.put(theBin, tasks);
			return toReturn;
		}
		
		for(Task task : tasks)
			task.switchToDual();
		
//		Object[] allTasks = tasks.toArray();
//		for(int taskIndex = 0; taskIndex < allTasks.length; taskIndex++)
//			((Task)allTasks[taskIndex]).switchToDual();
		
		Map<Bin, List<Task>> result =
				BinPackerFactory.getBinPacker(org.polarsys.chess.multicore.partitioning.Heuristic.WORST_FIT).pack(new ArrayList<Bin>(), tasks);
		Set<Bin> keys = result.keySet();
		ArrayList<Task> supertasks = new ArrayList<Task>();
		for(Bin bin : keys){
			bin.setLevel(level);
			toReturn.put(bin, result.get(bin));
			supertasks.add(new Task(bin.getId().toString(), bin.getCapacity()));
		}
		
		toReturn.putAll(pack(null, supertasks));// recursive call on the level above
		return toReturn;
		
		
		
		
		
		//return toReturn;
	}

}
