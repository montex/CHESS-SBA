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
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Realization;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.model.ConstraintStatus;
import org.polarsys.chess.chessmlprofile.util.Constants;

// TODO: Auto-generated Javadoc
/**
 * The Class FV_04.
 */
public class FV_04 extends AbstractModelConstraint {

	/* (non-Javadoc)
	 * @see org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse.emf.validation.IValidationContext)
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObject = ctx.getTarget();
		Component component = (Component)eObject;
		IStatus success = ctx.createSuccessStatus();

		Stereotype componentType = component.getAppliedStereotype(Constants.COMPONENT_TYPE);
		if (componentType!=null) {
			// This component is a ComponentType
			// If it realizes an interface, then it has to define at least the same operations 
			//System.err.println("---------------------------------------------\nComponent " + component.getName() + " is a ComponentType");
			for (Realization realization : component.getRealizations()) {
				if (realization instanceof InterfaceRealization) {
					// Skip realizations that are not InterfaceRealization
					//System.err.println(" -> found InterfaceRealization : " + realization.getName());
					Boolean isClient = false;
					for (NamedElement elem : realization.getClients()) {
						if (elem.equals(component)) {
							isClient = true;
						}
					}
					if (isClient) {
						// Check that the component defines the same operations as the Interface
						for (NamedElement elem : realization.getSuppliers()) {
							//System.err.println("  - supplier : " + elem.getName());
							if (elem instanceof Interface) {
								//System.err.println("   -> the supplier is an interface");
								Interface rInt = (Interface) elem;
								for (Operation op : rInt.getOwnedOperations()) {
									// For each operation, the component type must define the same
									Boolean opFound = false;
									for (Operation compOp : component.getOwnedOperations()) {
										// Compare operations
										if (compareOperations(compOp, op)) {
											opFound=true;
											break;
										}
									}
									if (!opFound) {
										// Then it is an error
										String errorMsg = "The <<ComponentType>> " + component.getName() + " does not define operation " + op.getName() + " from the interface " + rInt.getName() + " it realizes";
										IStatus failure = ctx.createFailureStatus(
												component,
												errorMsg
										);
										
										return failure;
									}

								}
							}
						}
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
