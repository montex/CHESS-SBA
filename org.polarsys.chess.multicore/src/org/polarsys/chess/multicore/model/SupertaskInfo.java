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
  ------------------------------------------------------------------------------*/package org.polarsys.chess.multicore.model;

import org.eclipse.uml2.uml.InstanceSpecification;

public class SupertaskInfo {

	private String name;
	private int capacity;
	private InstanceSpecification processorInstance;

	public SupertaskInfo(InstanceSpecification processorInstance, String name, float capacity) {
		super();
		this.setName(name);
		this.setCapacity(capacity);
		this.setProcessorInstance(processorInstance);
	}

	public float getCapacity() {
		return capacity;
	}

	/**
	 * Convert capacity from a float to a int value representing the percentage of
	 * utilization of the processor
	 * @param capacity
	 */
	public void setCapacity(float capacity) {
		this.capacity = Math.round(capacity*100);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public InstanceSpecification getProcessorInstance() {
		return processorInstance;
	}

	public void setProcessorInstance(InstanceSpecification processorInstance) {
		this.processorInstance = processorInstance;
	}

}