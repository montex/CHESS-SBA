/*
-----------------------------------------------------------------------
--                CHESS Live/Batch Validator plugin                  --
--                                                                   --
--                    Copyright (C) 2011-2012                        --
--                 University of Padova, ITALY                       --
--                                                                   --
-- Author: Stefano Puri								                 --
--                                                                   --
-- All rights reserved. This program and the accompanying materials  --
-- are made available under the terms of the Eclipse Public License  --
-- v1.0 which accompanies this distribution, and is available at     --
-- http://www.eclipse.org/legal/epl-v10.html                         --
-----------------------------------------------------------------------
*/
package org.polarsys.chess.validator.constraints;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Realization;
import org.eclipse.uml2.uml.Relationship;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.polarsys.chess.chessmlprofile.util.Constants;

/**
 * The Class FV_03.
 * This class implements the following constraint (invoked by the EMF validation framework):
 * The ComponentImplementation must define the same operation as the ComponentType it realizes
 */
public class FV_03 extends AbstractModelConstraint {

	/* (non-Javadoc)
	 * @see org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse.emf.validation.IValidationContext)
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObject = ctx.getTarget();
		Component component = (Component)eObject;
		IStatus success = ctx.createSuccessStatus();
		
		Stereotype componentImplStereo = component.getAppliedStereotype(Constants.COMPONENT_IMPLEMENTATION);
		if (componentImplStereo!=null) {
			// This is a ComponentImplementation
			int count=0;
			Component realizedComponent = null;
			
			for (Relationship rel : component.getRelationships()) {
				// The component must realize exactly one <<ComponentType>>
				if ((rel instanceof Realization)) {
					//skip InterfaceRealizations ...
					// Browse realization's clients
					Boolean isClient=false;
					for (NamedElement elem : ((Realization) rel).getClients()) {
						if (elem.equals(component)) {
							isClient=true;
						}
					}
					if (isClient) {
						//check if it realizes a component type
						for (NamedElement elem :  ((Realization) rel).getSuppliers()) {
							Stereotype componentType = elem.getAppliedStereotype(Constants.COMPONENT_TYPE);
							if (componentType!=null) {								
								realizedComponent=(Component) elem;
								count++;
							}
						}
					}
				}
			}
			if (count!=1) {
				String componentName = "";
				componentName = component.getName();
				String errorMsg = "The componentImplementation " + componentName + " must realize exactly one <<ComponentType>> (Currently : " + count +")";
				IStatus failure = ctx.createFailureStatus(
						component,
						errorMsg
				);
				
				return failure;
			}
			else {
				// Additional constraint.
				// A ComponentImplementation has to define the same operations as the ComponentType it realizes
				for (Operation ctOp : realizedComponent.getOperations()) {
					// So for operation ctOp, the component has to define the same operation
					Boolean opFound=false;
					for (Operation op : component.getOperations()) {
						if ( compareOperations(ctOp, op) ) {
							opFound=true;
						}
					}
					if (!opFound) {
						String componentName = "";
						componentName = component.getName();
						String errorMsg = "The ComponentImplementation " + componentName + " must define the same operation " + ctOp.getName() + " as the ComponentType it realizes";
						IStatus failure = ctx.createFailureStatus(
								component,
								errorMsg
						);
						
						return failure;
					}
				}
			}
			
		}

		return success;
		
	}
	
	/**
	 * Compare operations.
	 *
	 * @param op1 the op1
	 * @param op2 the op2
	 * @return the boolean
	 */
	private Boolean compareOperations(Operation op1, Operation op2) {
		Boolean result = true;

		// Compare names
		if (!op1.getName().equals(op2.getName())) {
			result=false;
		}
		else {
			// Compare return types

			if (op1.getType() != op2.getType()) {
				result=false;
			}
			else {
				// Compare the number of parameters
				Collection<Parameter> params1 = removeReturnParameter(op1.getOwnedParameters());
				Collection<Parameter> params2 = removeReturnParameter(op2.getOwnedParameters());

				if (params1.size() != params2.size() ) {
					result=false;
				}
				else {
					Iterator<Parameter> it1 = params1.iterator();
					Iterator<Parameter> it2 = params2.iterator();
					while (it1.hasNext()) {
						Parameter p1 = it1.next();
						Parameter p2 = it2.next();
						if (p1.getType()!=p2.getType()) {
							result=false;
							break;
						}
					}
				}
			}
		}
		
		return result;
	}
	
	/**
	 * Removes the return parameter.
	 *
	 * @param ownedParameters the owned parameters
	 * @return the collection
	 */
	private Collection<Parameter> removeReturnParameter(
			EList<Parameter> ownedParameters) {
		Collection<Parameter> result = new ArrayList<Parameter>();
		for (Parameter p : ownedParameters) {
			if (!p.getDirection().equals(ParameterDirectionKind.get(ParameterDirectionKind.RETURN))) {
				result.add(p);
			}
		}
		
		return result;
	}
}			
