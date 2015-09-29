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
import org.polarsys.chess.core.util.uml.UMLUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class DV_02.
 * DV_02 checks that the attribute “from” and “to” of stereotype Assign must be valued with exactly 
 * one value on each end and with the correct types: 
 * the value of the attribute 'from' in stereotype Assign must be an instance (InstanceSpecification) 
 * of a ComponentImplementation or of a Functional Partition or a <<CHRtPortSlot>> Slot. 
 * The value of the attribute 'to' in stereotype Assign must be an instance 
 * (InstanceSpecification) of a CH_HwProcessor or a Functional Partition.
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
				errorMsg = "The attribute 'from' of stereotype Assign must be valued with exactly one Element. Currently none.";				
			}
			else {
				if (from.size()!=1) {
					errorMsg = "The attribute 'from' of stereotype Assign must be valued with exactly one Element. Currently "+from.size();										
				}
				else {
					// This Element must be an instance specification of a ComponentImplementation
					Element fromElem = from.iterator().next();
					
					if (!UMLUtils.elementIsComponentInstance(fromElem) && 
							!UMLUtils.elementIsPartitionInstance(fromElem)&&
							!(UMLUtils.elementIsCHRtPortSlot(fromElem))) {
						errorMsg = "The value of the attribute 'from' in stereotype Assign must be an instance of a ComponentImplementation or of a Functional Partition or a CHRtPortSlot";
					}					
				}
			}
			List<Element> to = (List<Element>) comment.getValue(assign, Constants.ASSIGN_TO);
			if (to==null) {
				errorMsg = "The attribute 'to' of stereotype Assign must be valued with exactly one Element. Currently none.";
				
			}
			else {
				if (to.size()!=1) {
					errorMsg = "The attribute 'to' of stereotype Assign must be valued with exactly one Element. Currently "+to.size();
					
				}
				else {
					// This Element must be an instance specification of a ComponentImplementation
					// OR a Functional Partition (20150917 LB modified for Concerto ToDo #36 managing functional partitions
					Element toElem = to.iterator().next();
					if (!UMLUtils.elementIsProcessorInstance(toElem) && 
							!UMLUtils.elementIsPartitionInstance(toElem)) {
						errorMsg = "The value of the attribute 'to' in stereotype Assign must be an instance of a CH_HwProcessor or of a Functional Partition";
					}										
				}
			}			
		}
	
		if (errorMsg != null){
			IStatus failure = ctx.createFailureStatus(
					comment.getAnnotatedElements(),
					errorMsg
			);
			return failure;
		}
		
		return success;
		
	}
	
}			
