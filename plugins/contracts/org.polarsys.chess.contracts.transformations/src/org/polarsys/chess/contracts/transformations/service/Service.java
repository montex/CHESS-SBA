/*******************************************************************************
 *
 * Copyright (c) 2013, 2015 Intecs SpA 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Nicholas Pacini nicholas.pacini@intecs.it 
 * Stefano Puri stefano.puri@intecs.it
 * Laura Baracchi  laura.baracchi@intecs.it  
 * Initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.polarsys.chess.contracts.transformations.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.BoundedSubtype;
import org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.CollectionType;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.ClientServerKind;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.ClientServerPort;
import org.eclipse.papyrus.sysml.portandflows.FlowPort;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.Vertex;
import org.polarsys.chess.contracts.profile.chesscontract.Contract;
import org.polarsys.chess.contracts.profile.chesscontract.ContractProperty;
import org.polarsys.chess.contracts.profile.chesscontract.ContractRefinement;


public class Service {

	public static final String CONTRACT = "CHESSContract::Contract";
	public static final String CONTRACT_PROPERTY = "CHESSContract::ContractProperty";
	public static final String FLOWPORT = "SysML::PortAndFlows::FlowPort";
	public static final String FLOWPORTMARTE = "MARTE::MARTE_DesignModel::GCM::FlowPort";
	public static final String CSPORT = "MARTE::MARTE_DesignModel::GCM::ClientServerPort";
	public static final String BOUNDEDSUBTYPE = "MARTE::MARTE_Annexes::VSL::DataTypes::BoundedSubtype";
	public static final String COLLECTIONTYPE = "MARTE::MARTE_Annexes::VSL::DataTypes::CollectionType";

	public Set<String> getNewBlocks(Set<Property> parts) {
		
		Set<String> result = new HashSet<String>();
		
		for (Property prop : parts) {
			if((prop.getType() != null) && !(prop.getType() instanceof Signal) && !(prop.getType() instanceof PrimitiveType)){
				result.add(prop.getType().getName());
			}
		}

		return result;
	}

	public Set<String> getEmptyStringSet() {

		return new HashSet<String>();

	}
	
	public void addToGenerated(String name, Set<String> generated){
		generated.add(name);
	}
	
	public boolean isAlreadyGenerated(String name, Set<String> generated){
		return generated.contains(name);
	}
	
	public String getAssume(Class contractClass) {
		Stereotype contractStereo = contractClass.getAppliedStereotype(CONTRACT);
		Contract contract = (Contract) contractClass.getStereotypeApplication(contractStereo);		
		return contract.getAssume().getBase_Constraint().getSpecification().stringValue();		
	}
	
	public String getGuarantee(Class contractClass) {
		Stereotype contractStereo = contractClass.getAppliedStereotype(CONTRACT);
		Contract contract = (Contract) contractClass.getStereotypeApplication(contractStereo);		
		return contract.getGuarantee().getBase_Constraint().getSpecification().stringValue();		
	}
	
	public String getRefinedBy(Property prop){
		Set<String> result = new HashSet<String>();
		
		Stereotype contrPropStereo = prop.getAppliedStereotype(CONTRACT_PROPERTY);
		ContractProperty contractProp = (ContractProperty) prop.getStereotypeApplication(contrPropStereo);
		for (ContractRefinement refinedContr : contractProp.getRefinedBy()) {	
			result.add(refinedContr.getBase_DataType().getName());	
		}
		String strResult = result.toString();
		strResult = strResult.substring(1, strResult.length()-1);
		strResult = strResult.concat(";");
		return strResult ;
	}
	
	public boolean isRefined(Property prop){
		
		boolean result = true;
		Stereotype contrPropStereo = prop.getAppliedStereotype(CONTRACT_PROPERTY);
		ContractProperty contractProp = (ContractProperty) prop.getStereotypeApplication(contrPropStereo);
		if(contractProp.getRefinedBy() == null || contractProp.getRefinedBy().isEmpty()){
			result = false;
		}
		return result;	
	}
	
	public boolean checkRules(Connector conn){
			
		boolean result = false;
		
		ConnectorEnd firstEnd = conn.getEnds().get(0);
		ConnectorEnd lastEnd = conn.getEnds().get(1);
		
		Port firstPort = (Port) firstEnd.getRole();
		Port lastPort = (Port) lastEnd.getRole();
		
		String firstDir = getDirection(firstPort);
		String lastDir = getDirection(lastPort);
		
		Property firstPart = firstEnd.getPartWithPort();
		Property lastPart = lastEnd.getPartWithPort();
		
		//Rule I: (first not null, direction in) -> (last null, direction out) or (last not null, direction out)
		if(firstPart != null && firstDir.equalsIgnoreCase("in")){
			if(lastPart == null && lastDir.equalsIgnoreCase("in")){
				result = true;
			}else if (lastPart != null && lastDir.equalsIgnoreCase("out")){
				result = true;
			}
			
		}
		//Rule II: (first null, direction out) -> (last not null, direction out)
		//NOTE: rule II would also imply (in or): (last null, direction in) but it's a nonsense situation for a single mapping 
		else if(firstPart == null && firstDir.equalsIgnoreCase("out")
				&& lastPart != null && lastDir.equalsIgnoreCase("out")){
			result = true;
			
		}
		return result;
	}
	
	private String getDirection(Port port) {
		
		String result = null;
		Stereotype flowStereo = port.getAppliedStereotype(FLOWPORT);
		if(flowStereo != null){
			FlowPort flowport = (FlowPort) port.getStereotypeApplication(flowStereo);		
			result =  flowport.getDirection().toString();		
		}else{
			flowStereo = port.getAppliedStereotype(FLOWPORTMARTE);
			if(flowStereo != null){
				org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowPort flowportMarte = (org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowPort) port.getStereotypeApplication(flowStereo);		
				result =  flowportMarte.getDirection().toString();	
			}
		}
		return result;
	}

	public boolean checkConnectedPorts(Connector conn){
		
		boolean result = false;
		
		ConnectorEnd firstEnd = conn.getEnds().get(0);
		ConnectorEnd lastEnd = conn.getEnds().get(1);
		
		Port firstPort = (Port) firstEnd.getRole();
		Port lastPort = (Port) lastEnd.getRole();
		
		if((firstPort.getAppliedStereotype(FLOWPORT) != null || firstPort.getAppliedStereotype(FLOWPORTMARTE) != null) &&
				(lastPort.getAppliedStereotype(FLOWPORTMARTE) != null || lastPort.getAppliedStereotype(FLOWPORT) != null)){
			result = true;
		}
		return result;
	}
	
	public boolean checkOperationPorts(Connector conn){
		boolean result = false;
		
		ConnectorEnd firstEnd = conn.getEnds().get(0);
		ConnectorEnd lastEnd = conn.getEnds().get(1);
		
		Port firstPort = (Port) firstEnd.getRole();
		Port lastPort = (Port) lastEnd.getRole();
		
		if((firstPort.getAppliedStereotype(CSPORT) != null) && (lastPort.getAppliedStereotype(CSPORT) != null)){
			result = true;
		}
		return result;
	}
	
	public String getOperationConnections(Connector conn){
		
		String connections = "";
		
		ConnectorEnd firstEnd = conn.getEnds().get(0);
		ConnectorEnd lastEnd = conn.getEnds().get(1);
		
		Port firstPort = (Port) firstEnd.getRole();
		Port lastPort = (Port) lastEnd.getRole();
		
		Property firstProperty = firstEnd.getPartWithPort();
		Property lastProperty = lastEnd.getPartWithPort();
		
		Stereotype firstStereo = firstPort.getAppliedStereotype(CSPORT);
		ClientServerPort firstCSPort = (ClientServerPort) firstPort.getStereotypeApplication(firstStereo);
		
		Stereotype lastStereo = lastPort.getAppliedStereotype(CSPORT);
		ClientServerPort lastCSPort = (ClientServerPort) lastPort.getStereotypeApplication(lastStereo);
		
		//Provided-Required connection (same level)
		if(firstProperty != null && lastProperty != null){
			Interface provInt = null;
			boolean firstProv = false;
			if (firstCSPort.getProvInterface() != null && firstCSPort.getProvInterface().size() > 0){
				provInt = firstCSPort.getProvInterface().get(0);
				firstProv = true;
			}
			
			if (lastCSPort.getProvInterface() != null && lastCSPort.getProvInterface().size() > 0){
				provInt =  lastCSPort.getProvInterface().get(0);
			}
			
			if (provInt != null){
				if(!firstProv){
					for (Operation op : provInt.getOperations()) {
						connections += "DEFINE " + firstProperty.getName() + "." + firstPort.getName() + "_" + op.getName() + " := " + lastProperty.getName() + "." + lastPort.getName() + "_" + op.getName() + ";\n\t";
					}
				}else{
					for (Operation op : provInt.getOperations()) {
						connections += "DEFINE " + lastProperty.getName() + "." + lastPort.getName() + "_" + op.getName() + " := " + firstProperty.getName() + "." + firstPort.getName() + "_" + op.getName() + ";\n\t";
					}
				}
			}
			
		}else if((firstProperty != null && lastProperty == null) || (firstProperty == null && lastProperty != null)){
			
			//Provided-Provided delegation
			if (firstCSPort.getProvInterface() != null && firstCSPort.getProvInterface().size() > 0){
				Interface provInt = firstCSPort.getProvInterface().get(0);
				if(firstProperty == null){
					for (Operation op : provInt.getOperations()) {
						connections += "DEFINE " + firstPort.getName() + "_" + op.getName() + " := " + lastProperty.getName() + "." + lastPort.getName() + "_" + op.getName() + ";\n\t";
					}
				} else if(lastProperty == null){
					for (Operation op : provInt.getOperations()) {
						connections += "DEFINE " + lastPort.getName() + "_" + op.getName() + " := " + firstProperty.getName() + "." + firstPort.getName() + "_" + op.getName() + ";\n\t";
					}
				}
			}
			
			//Required-Required delegation
			if (firstCSPort.getReqInterface() != null && firstCSPort.getReqInterface().size() > 0){
				Interface reqInt = firstCSPort.getReqInterface().get(0);
				if(firstProperty == null){
					for (Operation op : reqInt.getOperations()) {
						connections += "DEFINE " + firstPort.getName() + "_" + op.getName() + " := " + lastProperty.getName() + "." + lastPort.getName() + "_" + op.getName() + ";\n\t";
					}
				} else if(lastProperty == null){
					for (Operation op : reqInt.getOperations()) {
						connections += "DEFINE " + lastPort.getName() + "_" + op.getName() + " := " + firstProperty.getName() + "." + firstPort.getName() + "_" + op.getName() + ";\n\t";
					}
				}
			}
		}
		return connections;
	}
	
	//it assumes that there's only one a region with a single initial state
	public String getInitCondition(StateMachine sm){
		Vertex init = null;
		OpaqueBehavior effect = null;
		
		EList<Transition> transitions = sm.getRegions().get(0).getTransitions();
		for (Transition tr : transitions) {
			if(tr.getSource() instanceof Pseudostate){
				init = tr.getTarget();
				effect = (OpaqueBehavior) tr.getEffect();
			}
		}
		if(effect != null){
			return init.getName() + " & " + effect.getBodies().get(0);
		}else{
			return init.getName();
		}
	}
	
	public Class getSystem(Set<Class> classes, String qname){
		Iterator<Class> it = classes.iterator();
		while (it.hasNext()){
			Class cl  = it.next();
			if(cl.getQualifiedName().equals(qname)){
				return cl;
			}
		}
		return null;
	}
	
	//returns the provided/required interface of a client/server port
	public Interface getInterface (Port port){
		Stereotype csStereo = port.getAppliedStereotype(CSPORT);
		ClientServerPort csPort = (ClientServerPort) port.getStereotypeApplication(csStereo);	
		if (csPort.getReqInterface() != null && csPort.getReqInterface().size() > 0){
			return csPort.getReqInterface().get(0);
		}else if (csPort.getProvInterface() != null && csPort.getProvInterface().size() > 0){
			return csPort.getProvInterface().get(0);
		}
		return null;
	}
	
	public String getParamList(Operation op){
		String paramList = "";
		for (Parameter param : op.getOwnedParameters()) {
			String direction ="";
			if (param.getDirection().equals(ParameterDirectionKind.IN_LITERAL))
					direction = "IN ";
			if (param.getDirection().equals(ParameterDirectionKind.OUT_LITERAL))
				direction = "OUT ";
			if (param.getDirection().equals(ParameterDirectionKind.IN_LITERAL)|| param.getDirection().equals(ParameterDirectionKind.OUT_LITERAL)){
				paramList += ", "+direction+param.getName() + " : " + getType(param.getType());
			}
		}
		if (paramList.compareTo("")==0)
			return paramList;
		return paramList.substring(1) ;
	}
	
	//returns the return parameter of the operation
	public String getReturn(Operation op){
		for (Parameter param : op.getOwnedParameters()) {
			if (param.getDirection().equals(ParameterDirectionKind.RETURN_LITERAL)){
				return getType(param.getType());
			}
		}
		return "void";
	}
	
	public String getOperationName (Operation op, Port port){
		
		Stereotype csStereo = port.getAppliedStereotype(CSPORT);
		ClientServerPort csPort = (ClientServerPort) port.getStereotypeApplication(csStereo);
		if (!csPort.getKind().equals(ClientServerKind.PROREQ)){
			return port.getName() + "_" + op.getName();
		}
		return null;
	}
	
	public String getType (Type type){
		if(type == null){
			return "";
		}
		if(type instanceof Signal){
			return "event";
		}
		if(type instanceof Enumeration){
			Enumeration en = (Enumeration) type;
			String enumString = "";
			Iterator<EnumerationLiteral> it = en.getOwnedLiterals().iterator();
			while (it.hasNext()) {
				EnumerationLiteral lit = (EnumerationLiteral) it.next();
				enumString = enumString + lit.getName();
				if(it.hasNext()){
					enumString = enumString + ",";
				}
			}
			return "{" + enumString + "}";
		}
		Stereotype boundedste = type.getAppliedStereotype(BOUNDEDSUBTYPE);
		//check for ranges
		if (boundedste != null){
			//only range of integers are supported by Ocra 
			BoundedSubtype subtype = (BoundedSubtype) type.getStereotypeApplication(boundedste);
			if (subtype.getBaseType().getName().compareToIgnoreCase("integer")==0){
				//return "{"+subtype.getMinValue()+", " + subtype.getMaxValue()+"}";
				// 20160413 Bug fix bounded subtype transformation corrected
				return subtype.getMinValue()+" .." + subtype.getMaxValue();
			}
		}
		Stereotype collectiontypeStereo = type.getAppliedStereotype(COLLECTIONTYPE);
		if (collectiontypeStereo != null){
			CollectionType collType = (CollectionType) type.getStereotypeApplication(collectiontypeStereo);
			Property collProp = collType.getCollectionAttrib();
			String arrayType = collProp.getType().getName().toLowerCase();
			arrayType = getType(collProp.getType());
			String mult = collProp.getLower() + ".." + collProp.getUpper();
			return "array " + mult  + " of " + arrayType; 
		}
		return type.getName();
	}
	
	
	public String getType4FTA (Type type){
		if(type instanceof Signal){
			return "event";
		}
		if(type instanceof Enumeration){
			Enumeration en = (Enumeration) type;
			String enumString = "";
			Iterator<EnumerationLiteral> it = en.getOwnedLiterals().iterator();
			while (it.hasNext()) {
				EnumerationLiteral lit = (EnumerationLiteral) it.next();
				enumString = enumString + lit.getName();
				if(it.hasNext()){
					enumString = enumString + ",";
				}
			}
			return "{" + enumString + "}";
		}
		return type.getName();
	}
	
	public String getTransitionTarget(String name, String str){
		String res = "";
		String[] splits = str.split(";");
		for (int i = 0; i < splits.length; i++) {
			if(splits[i].contains(name)){
				res = splits[i];
				res = res.substring(res.lastIndexOf("=")+1, res.length());
				res = res.trim();
			}
		}
		return res + ";";
	}
	


	public String getEffectOnProperty(StateMachine sm, String propertyName){
		String res = "" ;
		for (Element el : sm.allOwnedElements()){
			if (!(el instanceof Transition))
				continue;
			Transition tr = (Transition) el;
			Behavior beh = tr.getEffect();
			if (!(beh instanceof OpaqueBehavior))
				continue;
			OpaqueBehavior effect = (OpaqueBehavior) beh;
						
			String body = effect.getBodies().get(0);
			String[] splits = body.split("=");
			if (splits[0].compareToIgnoreCase(propertyName)==0){
				
				if (!(tr.getGuard().getSpecification() instanceof OpaqueExpression))
					continue;
				
				OpaqueExpression guard = (OpaqueExpression) tr.getGuard().getSpecification();
				
				res = res.concat(guard.getBodies().get(0)+ ":" +splits[1]+";\n");
			}
				
			
		}
		
		return res;
	}
	
	public String getModuleFormalParameter (Class block){
		
		EList<Property> props = block.getOwnedAttributes();
		String result = "";
		String temp ="";
		for (Property prop : props){
			Stereotype flowStereo = prop.getAppliedStereotype(FLOWPORT);
			if(flowStereo != null){
				FlowPort flowport = (FlowPort) prop.getStereotypeApplication(flowStereo);		
				temp =  flowport.getDirection().toString();	
				if (temp.compareToIgnoreCase("in")==0){
					if (result.compareToIgnoreCase("")==0)
						result = result.concat(prop.getName());
					else
						result = result.concat("," + prop.getName());
				}
			}else{
				Stereotype marteflowStereo = prop.getAppliedStereotype(FLOWPORTMARTE);
				if(marteflowStereo != null){
					org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowPort  marteflowport = (org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowPort ) prop.getStereotypeApplication(marteflowStereo);		
					temp =  marteflowport.getDirection().toString();	
					if (temp.compareToIgnoreCase("in")==0){
						if (result.compareToIgnoreCase("")==0)
							result = result.concat(prop.getName());
						else
							result = result.concat("," + prop.getName());
					}
				}
			}
			
		}
		return result;
	}
	
	public List<Port> getModuleFormalParameterAsPorts (Class block){
		
		List<Port> list = new Vector<Port>();
		EList<Port> props = block.getOwnedPorts();
		//String result = "";
		String temp ="";
		for (Port port : props){
			Stereotype flowStereo = port.getAppliedStereotype(FLOWPORT);
			if(flowStereo != null){
				FlowPort flowport = (FlowPort) port.getStereotypeApplication(flowStereo);		
				temp =  flowport.getDirection().toString();	
				if (temp.compareToIgnoreCase("in")==0){
					list.add(port);
				}
			}else {
				Stereotype marteflowStereo = port.getAppliedStereotype(FLOWPORTMARTE);
				if(marteflowStereo != null){
					org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowPort marteflowport = (org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowPort) port.getStereotypeApplication(marteflowStereo);		
					temp =  marteflowport.getDirection().toString();	
					if (temp.compareToIgnoreCase("in")==0){
						list.add(port);
					}
				}
			}
			
		}
		return list;
	}
	
	/**
	 * @param blockOwner : the block instantiating the module 
	 * @param prop : the module instance
	 * @return
	 */
	public String getModuleInstanceActualParameter (Class blockOwner, Property prop){
		
		if (!(prop.getType() instanceof Class)){
			return "";
		}
		Class module = (Class) prop.getType();
		
		List<Port> formalParams = this.getModuleFormalParameterAsPorts(module);
		List<String> actualParams = new Vector<String>();
		for (Port p : formalParams){
			Stereotype flowStereo = p.getAppliedStereotype(FLOWPORT);
			if(flowStereo != null){
				FlowPort flowport = (FlowPort) p.getStereotypeApplication(flowStereo);	
				String temp =  flowport.getDirection().toString();	
				if (temp.compareToIgnoreCase("in")==0){
						actualParams.add("");
				}
			} else {
				Stereotype marteflowStereo = p.getAppliedStereotype(FLOWPORTMARTE);
				if(marteflowStereo != null){
					org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowPort marteflowport = (org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowPort) p.getStereotypeApplication(marteflowStereo);	
					String temp =  marteflowport.getDirection().toString();	
					if (temp.compareToIgnoreCase("in")==0){
							actualParams.add("");
					}
				}
			}
			
		}
		Integer index = -1;
		String result = "(";
		String temp ="";
		for (Connector conn : blockOwner.getOwnedConnectors()){
			String proprIn = null;
			String portIn = null;
			boolean found = false;
			
			for (ConnectorEnd end : conn.getEnds()){
							
				if (end.getPartWithPort()!= null && end.getPartWithPort().equals(prop) && end.getRole() instanceof Port){
					Stereotype flowStereo = end.getRole().getAppliedStereotype(FLOWPORT);
					if(flowStereo != null){
						FlowPort flowport = (FlowPort) end.getRole().getStereotypeApplication(flowStereo);	
						temp =  flowport.getDirection().toString();	
						if (temp.compareToIgnoreCase("in")==0){
							found = true;
							
							index = formalParams.lastIndexOf(end.getRole());
							
						}
					}else{
						Stereotype marteflowStereo = end.getRole().getAppliedStereotype(FLOWPORTMARTE);
						if(marteflowStereo != null){
							org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowPort marteflowport = (org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowPort) end.getRole().getStereotypeApplication(marteflowStereo);	
							temp =  marteflowport.getDirection().toString();	
							if (temp.compareToIgnoreCase("in")==0){
								found = true;
								
								index = formalParams.lastIndexOf(end.getRole());
								
							}
						}
					}
				}
				else {
					if (end.getPartWithPort() != null) 
						proprIn = end.getPartWithPort().getName()+".";
					else 
						proprIn = "";
					portIn = end.getRole().getName(); 
					
					
				}
				if (found){	
					actualParams.set(index, proprIn+portIn);
					index = -1;
					
				}
			}
			
		}
		
		//check constrained ports
		for (Constraint c :  blockOwner.getOwnedRules()){
			boolean found = false;
			String constraintName = null;
			for (Element el : c.getConstrainedElements()){
				if (el.equals(prop)){
					found = true;
				}
				
				if (((Class) prop.getType()).getOwnedPorts().contains(el)){
					constraintName = c.getName();
					index = formalParams.lastIndexOf((Port) el);
					
				}
			}
			if (found && constraintName != null){
				actualParams.set(index, constraintName);
				index = -1;
				
				continue;
			}
			
		}
		
		for (String s : actualParams){
			result = result+s+",";
		}
		if (result.compareTo("(")==0)
			return "";
		return result.substring(0, result.length()-1)+")";
		
	}
	
	public String getTypeNameForProperty(Property prop){
		Type type = prop.getType();
		if (type == null)
			return "";
		Stereotype stereo = type.getAppliedStereotype(BOUNDEDSUBTYPE);
		if (stereo != null){
			BoundedSubtype subtype = (BoundedSubtype) type.getStereotypeApplication(stereo);
			return subtype.getMinValue()+".."+subtype.getMaxValue();
		}
		return this.getType(type);
	}
	
}
