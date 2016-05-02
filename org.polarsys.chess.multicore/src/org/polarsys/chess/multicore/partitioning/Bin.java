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

public class Bin {
	
	private Integer id;
	private Float size = 1.0f; // only homogeneous multiprocessing in CONCERTO
	private Float capacity = 0.0f;
	private Integer level = new Integer(-1); // needed for RUN packing, default is leaf node
	
	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getId() {
		return id;
	}

	public void setCapacity(Float capacity) {
		this.capacity = capacity;
	}

	public Float getSize() {
		return size;
	}

	public Float getCapacity() {
		return capacity;
	}

	public Bin(Integer id) {
		super();
		this.id = id;
	}

}
