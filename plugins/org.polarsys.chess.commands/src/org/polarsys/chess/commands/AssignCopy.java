/*******************************************************************************
 * Copyright (c) 2011 -2014 Intecs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Stefano Puri, Nicholas Pacini - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.polarsys.chess.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.Stereotype;

public class AssignCopy {
	
	private static final String ASSIGN = "MARTE::MARTE_Foundations::Alloc::Assign";
	
	private static EList<Element> tmp;
	
	private List<String> from;
	private List<String>  to;

	@SuppressWarnings("unchecked")
	public static ArrayList<AssignCopy> toAssignCopyList(EList<Comment> list) {

		ArrayList<AssignCopy> aclist = new ArrayList<AssignCopy>();
		
		for (int i = 0; i < list.size(); i++){
			
			Comment comm = list.get(i);	
			Stereotype assign = comm.getAppliedStereotype(ASSIGN);
			AssignCopy ac = new AssignCopy();
			
			List<String> fromList = new ArrayList<String>();
			tmp = (EList<Element>) comm.getValue(assign, "from");
			
			for(int j = 0; j < tmp.size(); j++){
				if(tmp.get(j) instanceof InstanceSpecification){
					fromList.add(((InstanceSpecification) tmp.get(j)).getName());
				} 
				else if(tmp.get(j) instanceof Slot){
					Slot s = (Slot) tmp.get(j);
					String name = s.getOwningInstance().getQualifiedName() + "::" + s.getDefiningFeature().getName();
					fromList.add(name);
				}
			}
			ac.setFrom(fromList);
			
			List<String> toList = new ArrayList<String>();
			tmp = (EList<Element>) comm.getValue(assign, "to");
			
			for(int j = 0; j < tmp.size(); j++){
				if(tmp.get(j) instanceof InstanceSpecification){
					toList.add(((InstanceSpecification) tmp.get(j)).getName());
				}
				else if(tmp.get(j) instanceof Slot){
					Slot s = (Slot) tmp.get(j);
					String name = s.getOwningInstance().getQualifiedName() + "::" + s.getDefiningFeature().getName();
					toList.add(name);
				}
			}
			ac.setTo(toList);
			
			aclist.add(ac);
		}
		
		return aclist;
	}
	
	public AssignCopy() {
	}

	public void setFrom(List<String> from) {
		this.from = from;
	}

	public List<String> getFrom() {
		return from;
	}

	public void setTo(List<String> to) {
		this.to = to;
	}

	public List<String> getTo() {
		return to;
	}

}
