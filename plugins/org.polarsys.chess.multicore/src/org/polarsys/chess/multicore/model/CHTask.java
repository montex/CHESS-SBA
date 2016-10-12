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

import java.util.Arrays;

import org.eclipse.uml2.uml.BehavioralFeature;
import org.eclipse.uml2.uml.Parameter;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtPortSlot;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification;
import org.polarsys.chess.multicore.utils.QueryUtils;


/**
 * 
 * @author Alessandro Zovi
 *
 * CHTask represents the instance of a component operation.
 * The operation can also be seen as a task, a shared resource or a simple procedure call.
 */

public final class CHTask {
	private CHRtPortSlot slot;
	private CHRtSpecification spec;

	public CHTask(CHRtPortSlot slot, CHRtSpecification spec) {
		this.slot = slot;
		this.spec = spec;
	}
	
	public CHRtPortSlot getSlot() {
		return slot;
	}
	
	public CHRtSpecification getCHRtSpecification() {
		return spec;
	}
	
	@Override
	public String toString() {
		//TODO it should take into consideration the multiplicity of the instances in Inst_full package
		return slot.getBase_Slot().getOwningInstance().getName() + "_" 
				+ slot.getBase_Slot().getDefiningFeature().getName() 
				+ "_" + spec.getContext().getName() + "(" +getType()+")";
	}
	
	public String getName() {
		//TODO it should take into consideration the multiplicity of the instances in Inst_full package
		return slot.getBase_Slot().getOwningInstance().getName() + "_" 
				+ slot.getBase_Slot().getDefiningFeature().getName() 
				+ "_" + getOpName(spec.getContext())+"_task";
	}
	
	private String getOpName(BehavioralFeature op){
		StringBuilder sb = new StringBuilder(op.getName());
		for (Parameter par : op.getOwnedParameters()) {
			sb.append('_').append(par.getType().getName());
		}
		return sb.toString();
	}
	
	public String getType(){
		String type = "simple_operation";
		if(QueryUtils.isOccKindSporadicOrPeriodic(spec.getOccKind())){
			type = "task";
		} else if (QueryUtils.isGuarded(spec)){
			type = "shared_resource";
		}
		return type;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof CHTask)) return false;
		if(obj == this) return true;
		
		CHTask that = (CHTask) obj;
		return toString().equals(that.toString());
	}
	
	@Override
	public int hashCode() {
		 return Arrays.hashCode(new Object[] {
				 slot.getBase_Slot().getOwningInstance().getName(),
				 slot.getBase_Slot().getDefiningFeature().getName(),
				 spec.getContext().getName()
		    });
	}
}
