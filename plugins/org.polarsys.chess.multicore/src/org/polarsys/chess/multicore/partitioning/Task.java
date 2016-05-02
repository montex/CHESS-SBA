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



public class Task implements Comparable<Task> {
	
	private enum Definition{
		DEFINED_C_AND_T, DEFINED_U
	}

	private String id;
	private Definition definition;
	private Float c;
	private Float d;
	private Float t;
	private Float u;
	private Float offset;
	private Bin owner;
	
	public Task(String _name,
			Float _c, Float _d, Float _t, Float _offset,
			Bin _owner) {
		

		this.id = _name;
		this.c = _c;
		this.d = _d;
		this.t = _t;
		this.definition = Definition.DEFINED_C_AND_T;
		this.offset = _offset;
		this.owner = _owner;
		
	}
	
	// needed for RUN's supertasks
	public Task(String _name, Float _u){
		this.id = _name;
		this.u = _u;
		this.definition = Definition.DEFINED_U;
	}
	
//	public Task() {
//		super();
//	}
	
	public void setOwner(Bin owner) {
		this.owner = owner;
	}

	public void setT(Float t) {
		this.t = t;
	}

	public Bin getOwner() {
		return owner;
	}

	public Float getT() {
		return t;
	}

	@Override
	public String toString() {
		return new String("(name, C, D, T, offset, owner)\n" +
				"("+ id +", "+ c +", "+ d +", "+ t +", "+ offset +", "+ owner +")");
	}
	
	public Float getU(){
		if(definition == Definition.DEFINED_U)
			return u;
		else
			return c/t;
	}
		
	
	public String getId() {
		return id;
	}
	
	public void switchToDual(){
		if(definition == Definition.DEFINED_U)
			this.u = 1-u;
		else
			this.c = t-c;
	}

	@Override
	public int compareTo(Task o) {
		
		return this.getU().compareTo(o.getU());
	}


	

	

}

