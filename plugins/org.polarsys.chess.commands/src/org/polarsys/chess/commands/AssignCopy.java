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


/**
 * The Class AssignCopy, used to store temporary information about MARTE Assign entity.
 */
public class AssignCopy {
	
	/** The Constant ASSIGN. */
	private static final String ASSIGN = "MARTE::MARTE_Foundations::Alloc::Assign";
	
	/** The tmp. */
	private static EList<Element> tmp;
	
	/** The from. */
	private List<String> from;
	
	/** The to. */
	private List<String>  to;

	/**
	 * Copy the content of the MARTE Assign to AssignCopy entities
	 *
	 * @param list the list of MARTE Assign Comment
	 * @return the array list
	 */
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
	
	/**
	 * Instantiates a new assign copy.
	 */
	public AssignCopy() {
	}

	/**
	 * Sets the from.
	 *
	 * @param from the new from
	 */
	public void setFrom(List<String> from) {
		this.from = from;
	}

	/**
	 * Gets the from.
	 *
	 * @return the from
	 */
	public List<String> getFrom() {
		return from;
	}

	/**
	 * Sets the to.
	 *
	 * @param to the new to
	 */
	public void setTo(List<String> to) {
		this.to = to;
	}

	/**
	 * Gets the to.
	 *
	 * @return the to
	 */
	public List<String> getTo() {
		return to;
	}

}
