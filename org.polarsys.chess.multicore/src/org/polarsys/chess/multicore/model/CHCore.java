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

import org.eclipse.uml2.uml.InstanceSpecification;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CH_HwProcessor;


/**
 * 
 * @author Alessandro Zovi
 * 
 * CHCore represents the tuple <processor, core>. 
 */
public final class CHCore {

	private CH_HwProcessor processor;
	private String name;

	public CHCore(CH_HwProcessor processor, String coreName) {
		
		if (processor.getBase_InstanceSpecification() == null)
			throw new RuntimeException("Core can be instanced only by an InstanceSpecification!");
		
		this.processor = processor;
		this.name = coreName;
	}

	
	public CH_HwProcessor getProcessor() {
		return processor;
	}
	
	public String getName() {
		return name;
	}
	
	public String getQualifiedName() {
		
		StringBuilder sb = new StringBuilder();
		return sb.append(processor.getBase_InstanceSpecification().getName()).append('_').append(name).toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof CHCore)) return false;
		if(obj == this) return true;
		
		CHCore that = (CHCore) obj;
		return processor.getBase_InstanceSpecification().getName().equals(that.processor.getBase_InstanceSpecification().getName()) && name.equals(that.name);
	}
	
	@Override
	public String toString() {
		return getQualifiedName();
	}
	
	@Override
	public int hashCode() {
		 return Arrays.hashCode(new Object[] {
				 processor.getBase_InstanceSpecification().getName().hashCode(),
		         name.hashCode(),
		    });
	}


	public InstanceSpecification getProcessorInstance() {
		return processor.getBase_InstanceSpecification();
	}
}
