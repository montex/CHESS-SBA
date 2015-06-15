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

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.polarsys.chess.chessmlprofile.util.Constants;

// TODO: Auto-generated Javadoc
/**
 * The Class DV_02.
 */
public class DV_02 extends AbstractModelConstraint {

	/* (non-Javadoc)
	 * @see org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse.emf.validation.IValidationContext)
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObject = ctx.getTarget();
		Comment comment = (Comment)eObject;
		IStatus success = ctx.createSuccessStatus();
		String errorMsg = null;

		Stereotype assign = comment.getAppliedStereotype(Constants.ASSIGN);
		
		if (assign!=null) {
			List<Element> from = (List<Element>) comment.getValue(assign, Constants.ASSIGN_FROM);
			if (from==null) {
				errorMsg = "The attribute 'from' of stereotype Assign must be valued with exactly one Element";
				
			}
			else {
				if (from.size()!=1) {
					errorMsg = "The attribute 'from' of stereotype Assign must be valued with exactly one Element";
										
				}
				else {
					// This Element must be an instance specification of a ComponentImplementation
					Element fromElem = from.iterator().next();
					if (fromElem instanceof InstanceSpecification) {
						// Then it must be stereotyped with ComponentImplementation
						if (((InstanceSpecification) fromElem).getClassifiers().size()==1) {
							// Otherwise, an error is raised elsewhere
							Classifier clazz = ((InstanceSpecification) fromElem).getClassifiers().iterator().next();
							
							if (clazz.getAppliedStereotype(Constants.COMPONENT_IMPLEMENTATION)==null) {
								errorMsg = "The value of the attribute 'from' in stereotype Assign must be an instance of a ComponentImplementation";
								
							}
						}
					}
					else {
						errorMsg ="The value of the attribute 'from' in stereotype Assign must be an InstanceSpecification";
						
					}
				}
			}
			List<Element> to = (List<Element>) comment.getValue(assign, Constants.ASSIGN_TO);
			if (to==null) {
				errorMsg = "The attribute 'to' of stereotype Assign must be valued with exactly one Element";
				
			}
			else {
				if (to.size()!=1) {
					errorMsg = "The attribute 'to' of stereotype Assign must be valued with exactly one Element";
					
				}
				else {
					// This Element must be an instance specification of a ComponentImplementation
					Element toElem = to.iterator().next();
					if (toElem instanceof InstanceSpecification) {
						// Then it must be stereotyped with ComponentImplementation
						if (((InstanceSpecification) toElem).getClassifiers().size()==1) {
							// Otherwise, an error is raised elsewhere
							if ((((InstanceSpecification) toElem).getClassifiers().iterator().next().getAppliedStereotype(Constants.CH_HWPROCESSOR)==null)) {
								errorMsg = "The value of the attribute 'to' in stereotype Assign must be an instance of a CH_HwProcessor";
								
							}
						}
					}
					else {
						errorMsg ="The value of the attribute 'to' in stereotype Assign must be an InstanceSpecification";
						
					}
				}
			}
			
		}
	
		if (errorMsg != null){
			IStatus failure = ctx.createFailureStatus(
					comment,
					errorMsg
			);
			return failure;
		}
		
		return success;
		
	}
	
}			
