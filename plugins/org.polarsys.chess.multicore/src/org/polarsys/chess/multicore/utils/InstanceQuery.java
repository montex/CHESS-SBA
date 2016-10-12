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
  ------------------------------------------------------------------------------*/package org.polarsys.chess.multicore.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.BehavioralFeature;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Slot;
import org.polarsys.chess.chessmlprofile.Core.IdentifSlot;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtPortSlot;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification;
import org.polarsys.chess.core.profiles.CHESSProfileManager;
import org.polarsys.chess.core.util.uml.ModelError;
import org.polarsys.chess.core.util.uml.UMLUtils;

public class InstanceQuery {

	public static Package getInstanceSpecPackage(Model umlModel){
		Package cmpv = CHESSProfileManager.getViewByStereotype(
				(Model) umlModel, CHESSProfileManager.COMPONENT_VIEW);
		cmpv = QueryUtils.getOneResourcePlatformPackage(cmpv);
		return cmpv;
	}

	
	

	
	
	static boolean isDeferred(CHRtSpecification usedCH) {
		String occKind = usedCH.getOccKind();
		return occKind!=null;
	}

	static CHRtSpecification getCHFromSlot(Slot usedPiSlot,
			Operation operation) {
		if(usedPiSlot == null){
			return null;
		}
		CHRtPortSlot ch = UMLUtils.getStereotypeApplication(usedPiSlot, CHRtPortSlot.class);
		if(ch==null)
			return null;
		
		for (CHRtSpecification i : ch.getCH_RtSpecification()) {
			if (i.getContext().equals(operation)) {
				return i;
			}
			if(UMLUtils.areOperationsEqual((Operation) i.getContext(), operation, null)){
				return i;
			}
		}
		assert false;
		return null;
	}
	
	
	private static EList<InstanceSpecification> getRiPiLinks(Slot slot){
		EList<InstanceSpecification> riPiLinks = new BasicEList<InstanceSpecification>();
		EList<Element> allOwnedElements = slot.getOwner().getOwner().allOwnedElements();
		for (Element e : allOwnedElements) {
			if (e instanceof InstanceSpecification) {
				InstanceSpecification f = (InstanceSpecification) e;
				boolean b = f.getClassifiers().size() == 0;
				if(b){
					riPiLinks.add(f);
				}
			}
		} 
		return riPiLinks;
	}

	/*identical of getCorrespondingSLot of QVTO transformation*/
	static Slot getOppositeSlot(Slot slot) throws ModelError {
		EList<InstanceSpecification> riPiLinks = getRiPiLinks(slot);
		
		for (InstanceSpecification l : riPiLinks) {
			EList<InstanceValue> ends = getEnds(l);
			
			if(ends.size()!=2) throw new ModelError("A connector must have exactly 2 ends");
			
			for (int i = 0; i < 2; i++) {
				//1st step: i=0 j=1
				//2nd step: i=1 j=0
				int j = (i+1)%2;
				InstanceValue first = ends.get(i);
				boolean b = first.getInstance().equals(slot.getOwningInstance());
				b = b && ((Slot)first.getOwner()).getDefiningFeature().equals(slot.getDefiningFeature());
				
				if(b){
					InstanceValue instanceValue = ends.get(j);
					InstanceSpecification instance = instanceValue.getInstance();
					
					Element owner = instanceValue.getOwner();
					if (owner instanceof Slot) {
						Slot sOwner = (Slot) owner;
						
						for (Slot s : instance.getSlots()) {
							 
							if(s.getDefiningFeature().equals(sOwner.getDefiningFeature()))
								return s;
							
						}
					}
					
				}
			}

			/*checkingIV = ends.get(1);
			b = checkingIV.getInstance().equals(slot.getOwningInstance());
			b = b && ((Slot)checkingIV.getOwner()).getDefiningFeature().equals(slot.getDefiningFeature());
			
			if(b){
				InstanceSpecification instance = ends.get(0).getInstance();
				for (Slot s : instance.getSlots()) {
					if(s.getDefiningFeature().equals(((Slot)s.getOwner()).getDefiningFeature()))
						return s;
				}
			}*/
		}
		
		return null;
	}


	private static EList<InstanceValue> getEnds(InstanceSpecification l) {
		EList<InstanceValue> ends = new BasicEList<InstanceValue>();

		for (Element element : l.allOwnedElements()) {
			if (element instanceof InstanceValue) {
				InstanceValue iv = (InstanceValue) element;
				 ends.add(iv);
				 
			}
		}
		return ends;
	}

	static EList<Slot> getSlotFromPort(CallOperationAction callOp,
			InstanceSpecification owningInstance) {
		BehavioralFeature specification = callOp.getActivity().getSpecification();
		Operation op = (Operation)specification;
		Constraint c = null;
		for (Constraint rule : op.getClass_().getOwnedRules()) {
			for (Element cE :rule.getConstrainedElements()) {
				if (cE instanceof CallOperationAction) {
					CallOperationAction cCE = (CallOperationAction) cE;
					if(cCE.equals(callOp))
						c = rule;
						break;
				}
			}
		}
		EList<Slot> result = new BasicEList<Slot>();
		if(c==null){
			for (Slot slot : owningInstance.getSlots()) {
				if(slot.getDefiningFeature().equals(callOp.getOnPort())){
					result.add(slot);
				}
			}
		} else {
			result = portToSlotsByRule(owningInstance, callOp.getOnPort(), c);
		}
		return result;
	}
	
	

	static CHRtPortSlot getCHRtPortSlot(Package instPkg, CHRtSpecification dOp) throws ModelError {
		for (Element e : instPkg.allOwnedElements()) {
			if(!(e instanceof Slot))
				continue;
			CHRtPortSlot pSlot = UMLUtils.getStereotypeApplication(e, CHRtPortSlot.class);
			if(pSlot==null)
				continue;
			for (CHRtSpecification chSPec : pSlot.getCH_RtSpecification()) {
				if(chSPec.equals(dOp)){
					return pSlot;
				}
			}
		}
		throw new ModelError("Slot for %s does not exist in the instance package", dOp.getContext().getName());
	}

	private static void getCHRtCommentsfromPort(Port piPort, Operation operation) {
		
		EList<Comment> ownedComments = piPort.getOwner().getOwner().getOwnedComments();
		for (Comment comment : ownedComments) {
			CHRtSpecification stereotypeApplication = UMLUtils.getStereotypeApplication(comment, CHRtSpecification.class);
			if(stereotypeApplication !=null){
				Operation context = (Operation) stereotypeApplication.getContext();
				UMLUtils.isOperationEquals(context, operation);
			}
		}
	}

	private static Port getOppositePort(Port riPort) {
		EList<ConnectorEnd> ends = riPort.getEnds();
		assert(ends.size()==1);
		for (ConnectorEnd end : ends) {
			Connector connector = (Connector)end.getOwner();
			ConnectorEnd oppositeEnd = getOppositeEnd(connector, end);
			Port oppositePort = (Port)oppositeEnd.getRole();
			return oppositePort;
		}
		return null;
	}

	private static ConnectorEnd getOppositeEnd(Connector connector, ConnectorEnd currentEnd) {
		EList<ConnectorEnd> array = connector.getEnds();
		assert(array.size()==2);
		
		for (ConnectorEnd end : array) {
			if(!end.equals(currentEnd))
				return (ConnectorEnd) end;
		}
		
		return null;
	}

	static Activity getMethod(CHRtSpecification dOp) {
		try {
			return (Activity) dOp.getContext().getMethods().get(0);
		} catch (Exception e) {
		}
		return null;
	}
	
	

	
	private static EList<Slot> portToSlotsByRule(InstanceSpecification self, Port onPort, Constraint rule) {
		EList<Slot> list = new BasicEList<Slot>();
		
		String values[] = rule.getSpecification().stringValue().trim().split(" ");
		ArrayList<int[]> boundsList = new ArrayList<int[]>();
		for (String value : values) {
			boundsList.add(VSLUtils.getBounds(value));
		}
		
		for (Slot slot : self.getSlots()) {
			IdentifSlot id = UMLUtils.getStereotypeApplication(slot, IdentifSlot.class);
			
			if (id != null && slot.getDefiningFeature() == onPort && VSLUtils.isInBounds(id.getId(), boundsList)) {
				list.add(slot);
			}
			else if (slot.getDefiningFeature() == onPort) {
				list.add(slot);
			}
		}
		
		return list;
	}

}
