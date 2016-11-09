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

package org.polarsys.chess.contracts.validation.constraints;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.model.ConstraintStatus;
import org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.BoundedSubtype;
import org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.CollectionType;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.TypedElement;
import org.polarsys.chess.contracts.integration.ToolIntegration;
import org.polarsys.chess.contracts.profile.chesscontract.ComponentInstance;
import org.polarsys.chess.contracts.profile.chesscontract.ContractProperty;
import org.polarsys.chess.contracts.profile.chesscontract.ContractRefinement;
import org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ContractTypes;

public class OCRAConstraints extends AbstractModelConstraint {

	
	private static final String BLOCK = "SysML::Blocks::Block";
	private static final String FLOWPORT = "SysML::PortAndFlows::FlowPort";
	private static final String FLOWPORTMARTE = "MARTE::MARTE_DesignModel::GCM::FlowPort";
	private static final String SYSVIEW = "CHESS::Core::CHESSViews::SystemView";
	private static final String COMPVIEW = "CHESS::Core::CHESSViews::ComponentView";
	private static final String FORMPROP = "CHESSContract::FormalProperty";
//	private static final String DELEGATION = "CHESSContract::DelegationConstraint";
	private static final String SYSTEM = "CHESSContract::System";
	private static final String SUBSYSTEM = "CHESSContract::SubSystem";
	private static final String CONTRACTPROP = "CHESSContract::ContractProperty";
	private static final String COMPINST = "CHESSContract::ComponentInstance";
	public static final String BOUNDEDSUBTYPE = "MARTE::MARTE_Annexes::VSL::DataTypes::BoundedSubtype";
	public static final String COLLECTIONTYPE = "MARTE::MARTE_Annexes::VSL::DataTypes::CollectionType";

	@Override
	public IStatus validate(IValidationContext ctx) {
		System.out.println("Checking model for NuSMV3 analysis tool");

		IStatus success = ctx.createSuccessStatus();
		IStatus failure = ctx.createFailureStatus();
		// This invariant may raise multiple errors
		Collection<ConstraintStatus> allResults = new ArrayList<ConstraintStatus>();

		// Retrieve the model and the SystemView package
		Model model = (Model) ctx.getTarget();
		Package sysView = null;
		Package compView = null;
		for (Package pkg : model.getNestedPackages()) {
			if(pkg.getAppliedStereotype(SYSVIEW) != null){
				sysView = pkg;
			}
			if(pkg.getAppliedStereotype(COMPVIEW) != null){
				compView = pkg;
			}
		} 
//		if(sysView == null){
//			//return failure;
//		} 
		//else:
		// Browse through the model and get all blocks, ports, properties and associations
		List<Class> allBlocks = new ArrayList<Class>();
		List<Port> allFlowPorts = new ArrayList<Port>();
		List<Property> allProperties = new ArrayList<Property>();
		List<Association> allAssociations = new ArrayList<Association>();
		List<Connector> allConnectors = new ArrayList<Connector>();
		List<Constraint> allFormalProps = new ArrayList<Constraint>();
		List<Property> allContractProperties = new ArrayList<Property>();
		List<Parameter> allParameters = new ArrayList<Parameter>();
		
		if (sysView != null)
		
			for (Element elem : sysView.allOwnedElements()) {
				if (elem.getAppliedStereotype(BLOCK) != null || elem.getAppliedStereotype(SUBSYSTEM) != null ||
						elem.getAppliedStereotype(SYSTEM) != null) {
					allBlocks.add((Class) elem);
				}
				if (elem instanceof Property){
					if (elem.getAppliedStereotype(FLOWPORT) != null || elem.getAppliedStereotype(FLOWPORTMARTE) != null){
						allFlowPorts.add((Port) elem);
					}else if(elem.getAppliedStereotype(CONTRACTPROP) != null){
						allContractProperties.add((Property) elem);
					}else if(!(elem instanceof Port)){
						allProperties.add((Property) elem);
					}
				}
				if (elem instanceof Association){
					allAssociations.add((Association) elem);
				}
				if (elem instanceof Connector){
					allConnectors.add((Connector) elem);
				}
				if (elem instanceof Constraint && elem.getAppliedStereotype(FORMPROP) != null){
					allFormalProps.add((Constraint)elem);
				}
				if (elem instanceof Parameter){
					if (((Parameter) elem).getOperation()!= null)
						allParameters.add((Parameter) elem);
				}
			}
		
		if (compView != null)
			for (Element elem : compView.allOwnedElements()) {
				if (elem instanceof Constraint && elem.getAppliedStereotype(FORMPROP) != null){
					allFormalProps.add((Constraint)elem);
				}
				
				if (elem instanceof Property){
					if (elem.getAppliedStereotype(CONTRACTPROP) != null){
						allContractProperties.add((Property) elem);
					}else if(!(elem instanceof Port) && !(elem.getOwner() instanceof DataType)){
						allProperties.add((Property) elem);
					}
				}
				if (elem instanceof Parameter){
					if (((Parameter) elem).getOperation()!= null)
					allParameters.add((Parameter) elem);
				}
			}
		
		if (sysView == null){
			//we are not in a CHESS model, se we have to consider the entire Model for checking
			for (Element elem : model.allOwnedElements()) {
				if (elem.getAppliedStereotype(BLOCK) != null || elem.getAppliedStereotype(SUBSYSTEM) != null ||
						elem.getAppliedStereotype(SYSTEM) != null) {
					allBlocks.add((Class) elem);
				}
				if (elem instanceof Property){
					if (elem.getAppliedStereotype(FLOWPORT) != null || elem.getAppliedStereotype(FLOWPORTMARTE) != null){
						allFlowPorts.add((Port) elem);
					}else if(elem.getAppliedStereotype(CONTRACTPROP) != null){
						allContractProperties.add((Property) elem);
					}else if(!(elem instanceof Port) && !(elem.getOwner() instanceof DataType)){
						allProperties.add((Property) elem);
					}
				}
				if (elem instanceof Association){
					allAssociations.add((Association) elem);
				}
				if (elem instanceof Connector){
					allConnectors.add((Connector) elem);
				}
				if (elem instanceof Constraint && elem.getAppliedStereotype(FORMPROP) != null){
					allFormalProps.add((Constraint)elem);
				}
				if (elem instanceof Parameter){
					if (((Parameter) elem).getOperation()!= null)
						allParameters.add((Parameter) elem);
				}
				
			}
		}
		
		allResults.addAll(checkConstraintForeverAnalysis(allBlocks, allFlowPorts, allProperties, allAssociations, allConnectors, allFormalProps, allContractProperties, allParameters,ctx));
		
		if (allResults.size()>0) {
			//size of all results > 0, create multistatus
			return ConstraintStatus.createMultiStatus(ctx, allResults);
		} else {
			//no errors, return success
			return success;
		}
	}

	private Collection<? extends ConstraintStatus> checkConstraintForeverAnalysis(List<Class> allBlocks, List<Port> allFlowPorts, List<Property> allProperties, List<Association> allAssociations, List<Connector> allConnectors, List<Constraint> allFormalProps, List<Property> allContractProperties, List<Parameter> allParameters,IValidationContext ctx) {
		
		Collection<ConstraintStatus> results = new ArrayList<ConstraintStatus>();
		String errorMsg;
		/**
		 * Here we check that for each block, their names contain only allowed characters
		 * we also check that each block has attributes with unique names
		 */
		for (Class block : allBlocks) {

			if(!checkName(block)){
				errorMsg = "The Block named " + block.getName() +" contains unallowed character(s)";
				results.add(createConstraintStatus(block, errorMsg, ctx));
			}
			if(hasAmbiguousAttributes(block)){
				errorMsg = "There are 2 or more attributes with the same name in Block: " + block.getName();
				results.add(createConstraintStatus(block, errorMsg, ctx));
			}
						
		}
		
		/**
		 * Here we check that all the FlowPorts of the model are typed 
		 * and that their names contain only allowed characters
		 * and that no unsupported types are used
		 */
		for (Port flowport : allFlowPorts) {
			if(flowport.getType() == null){
				errorMsg = "The FlowPort " + flowport.getName() +" should be typed";
				results.add(createConstraintStatus(flowport, errorMsg, ctx));
			}
			if(!checkName(flowport)){
				errorMsg = "The FlowPort named " + flowport.getName() +" contains unallowed character(s)";
				results.add(createConstraintStatus(flowport, errorMsg, ctx));
			}
			if (!hasValidType(flowport)){
				errorMsg = "The property named " + flowport.getName() + " refer to an unallowed type";
				results.add(createConstraintStatus(flowport, errorMsg, ctx));
			}
		}
		
		/**
		 * Here we check that for each Property (part) its name contain only allowed characters
		 * Here we check that no unsupported types are used
		 */
		for (Property prop : allProperties) {
			if(!checkName(prop)){
				errorMsg = "The property named " + prop.getName() +" in block " + ((NamedElement) prop.getOwner()).getName() + " contains unallowed character(s)";
				results.add(createConstraintStatus(prop, errorMsg, ctx));
			}
			if (!(prop.getType().getAppliedStereotype(BLOCK) != null) && !(prop.getType() instanceof Component)){
				if (!hasValidType(prop)){
					errorMsg = "The property named " + prop.getName() +" in entity " + ((NamedElement) prop.getOwner()).getName() + " refer to an unallowed type";
					results.add(createConstraintStatus(prop, errorMsg, ctx));
				}
			}
		}
		
		/**
		 * Here we check that the contract properties are correctly refined wrt weak/strong 
		 * contracts in component instances
		 **/
		for (Property contrProp : allContractProperties) {
			if(!checkContractPropertyRefinement(contrProp)){
				errorMsg = "Contract Refinement for " +  contrProp.getName() + " is not correct (check weak guarantees)";
				results.add(createConstraintStatus(contrProp, errorMsg, ctx));
			}
		}
		
		/**
		 * Here we check that all the associations are directed
		 * (the association should have exactly one ownedEnd)
		 */
		for (Association assoc : allAssociations) {
			if(assoc.getOwnedEnds().size() != 1){
				errorMsg = "The association between " + assoc.getMemberEnds().get(0).getName() +" and " +
						assoc.getMemberEnds().get(1).getName() + " is not directed";
				results.add(createConstraintStatus(assoc, errorMsg, ctx));
			}
		}
		
		/**
		 * Here we check that no unsupported types are used
		 */
		for (Parameter param : allParameters) {
			if (!hasValidType(param)){
				errorMsg = "The Parameter named " + param.getName() +" in entity " + ((NamedElement) param.getOwner()).getName() + " refer to an unallowed type";
				results.add(createConstraintStatus(param, errorMsg, ctx));
			}
		}

		/**
		 * Here we check that ports are correctly connected
		 * i.e the type and the direction of the ports are compatible
		 * (the direction depends on whether the connectors is a port delegation or not
		 */
		Port firstPort, secondPort;
		Stereotype firstStereo, secondStereo;
		ConnectorEnd firstEnd, secondEnd;

		for (Connector conn : allConnectors){

			firstEnd = conn.getEnds().get(0);
			secondEnd = conn.getEnds().get(1);
			if(firstEnd.getRole() instanceof Port && secondEnd.getRole() instanceof Port){
				firstPort = (Port) firstEnd.getRole();
				firstStereo = firstPort.getAppliedStereotype(FLOWPORT);
				if(firstStereo == null){
					firstStereo = firstPort.getAppliedStereotype(FLOWPORTMARTE);
				}
				secondPort = (Port) secondEnd.getRole();
				secondStereo = secondPort.getAppliedStereotype(FLOWPORT);
				if(secondStereo == null){
					secondStereo = firstPort.getAppliedStereotype(FLOWPORTMARTE);
				}

				//check types
				if(firstPort.getType() != null && secondPort.getType() != null){
					if(!(firstPort.getType().getName().equals(secondPort.getType().getName()))){
						errorMsg = "This connector must connect ports of the same type";
						results.add(createConstraintStatus(conn, errorMsg, ctx));
					}
				}
				//check directions:
				//delegation: in -> in; out -> out
				//connection: in -> out; out -> in
				if(firstStereo != null && secondStereo != null){
					String firstDir = firstPort.getValue(firstStereo, "direction").toString();
					String secondDir = secondPort.getValue(secondStereo, "direction").toString();
					Property prFirst = firstEnd.getPartWithPort();
					Property prSec = secondEnd.getPartWithPort();
					//check that the one of the properties contains the other (delegation)
					if(prFirst == null ^ prSec == null){
						if(!firstDir.equals(secondDir)){
							errorMsg = "Connector " + conn.getQualifiedName() + " is delegating ports with incompatible direction";
							results.add(createConstraintStatus(conn, errorMsg, ctx));
						}
					}else{ //is connection
						if(firstDir.equals(secondDir)){
							errorMsg = "Connector " + conn.getQualifiedName() + " is connecting ports with incompatible direction";
							results.add(createConstraintStatus(conn, errorMsg, ctx));
						}
					}
				}
			}
		}		
		
		/**
		 * Here we check that each FormalProperty passes the syntax check provided by NuSMV3-OCRA
		 */
		//issues with ocra 1.3.0 under Windows
		ToolIntegration checker = new ToolIntegration(null);
		
		for (Constraint formalProp : allFormalProps) {
			if(!checker.checkFormalProperty(formalProp)){
				errorMsg = "The formal property " + formalProp.getName() + " is not correct. Please check its syntax";
				results.add(createConstraintStatus(formalProp, errorMsg, ctx));
			}
		}
	
		return results;
	}


	private boolean checkContractPropertyRefinement(Property prop) {
		ContractProperty contrProp = (ContractProperty) prop.getStereotypeApplication(prop.getAppliedStereotype(CONTRACTPROP));
		EList<ContractRefinement> contrRefList = contrProp.getRefinedBy();
		if(contrRefList.size() == 0){
			return true;
		}
		for (ContractRefinement contrRef : contrRefList) {
			ContractProperty cp = contrRef.getContract();
			ContractTypes ctype = cp.getContractType();
			if (ctype == ContractTypes.WEAK) {
				Property p = contrRef.getInstance();
				Stereotype stereo = p.getAppliedStereotype(COMPINST);
				if(stereo != null){
					ComponentInstance compInst = (ComponentInstance) p.getStereotypeApplication(stereo);
					if(!compInst.getWeakGuarantees().contains(cp)){
						return false;
					}
				}
			}
		}
		return true;
	}

	//used to check whether the block has attributes with ambiguous names (i.e. not unique)
	private boolean hasAmbiguousAttributes(Class block) {
		
		EList<Property> attributes = block.getAllAttributes();
		Set<String> names = new HashSet<String>();
		for (Property prop : attributes) {
			names.add(prop.getName());
		}
		if(names.size() != attributes.size()){
			return true;
		}
		return false;
	}
	

	//used to check whether the name of elem contains only allowed characters or not
	private boolean checkName(NamedElement elem) {
		
		if(elem.getName().contains(" ")){
			return false;
		}
		
		return true;
		
//		if(elem.getName().matches("[!A-Za-z0-9]*")){ //probably too strict: check NuMSV3
//			return true;
//		}
//		return false;
	}
	
	
	
	private boolean hasValidType(TypedElement typed){
		Type type = typed.getType();
		if (type == null)
			return false;
		
		String typeName = type.getName();
		if (typeName.compareToIgnoreCase("integer")==0||typeName.compareToIgnoreCase("boolean")==0||
				typeName.compareTo("real")==0||typeName.compareToIgnoreCase("continuous")==0||
				typeName.compareTo("event")==0)
			return true;
		if (type instanceof Signal)
			return true;
		if(type instanceof Enumeration)
			return true;
		Stereotype boundedste = type.getAppliedStereotype(BOUNDEDSUBTYPE);
		//check for ranges
		if (boundedste != null){
			//only range of integers are supported by Ocra 
			BoundedSubtype subtype = (BoundedSubtype) type.getStereotypeApplication(boundedste);
			if (subtype.getBaseType().getName().compareToIgnoreCase("integer")==0){
				return true;
			}
		}
		Stereotype collectiontypeStereo = type.getAppliedStereotype(COLLECTIONTYPE);
		if (collectiontypeStereo != null){
			CollectionType collType = (CollectionType) type.getStereotypeApplication(collectiontypeStereo);
			Property collProp = collType.getCollectionAttrib();		
			if (collProp == null)
				return false;
			if (!hasValidType(collProp))
					return false;
			return true;
		}
			
		return false;
	}

	//utility method to create a constraint status in case of error
	private ConstraintStatus createConstraintStatus(EObject object, String errorMsg, IValidationContext ctx) {
		
		Collection<EObject> resultLocus = new ArrayList<EObject>();
		resultLocus.add(object);
		return ConstraintStatus.createStatus(ctx, object, resultLocus, IStatus.ERROR,3, errorMsg, (Object[]) null);

	}

}
