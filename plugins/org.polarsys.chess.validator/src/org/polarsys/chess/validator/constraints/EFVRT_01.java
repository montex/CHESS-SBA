/*
-----------------------------------------------------------------------
--                CHESS Live/Batch Validator plugin                  --
--                                                                   --
--                    Copyright (C) 2011-2015                        --
--                 University of Padova, ITALY                       --  
--                        Intecs, Italy   											 --
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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.BehavioralFeature;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtPortSlot;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification;
import org.polarsys.chess.chessmlprofile.util.Constants;


/**
 * The Class EFVRT_01.
 * This class implements the following constraint (invoked by the EMF validation framework):
 * the attribute 'context' of CHRtSpecification must be set to an operation of the component (e.g. not of the interface).
 */
public class EFVRT_01 extends AbstractModelConstraint {

	/* (non-Javadoc)
	 * @see org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse.emf.validation.IValidationContext)
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObject = ctx.getTarget();
		Comment c = (Comment)eObject;
		IStatus success = ctx.createSuccessStatus();
		String errorMsg = null;

		Stereotype chrtSpecStereo = c.getAppliedStereotype(Constants.CHRT_SPECIFICATION);	
		if(chrtSpecStereo == null) {
			return success;
		}

		CHRtSpecification chRtSpec = (CHRtSpecification)c.getStereotypeApplication(chrtSpecStereo);

		// look who this CHRtSpec is associated to: if it is a CHRtPortSlot then continue looking into it
		Model model = c.getModel();
		EList<Element> allElems = model.allOwnedElements();
		boolean isAssociatedToChrtPortSlot = false; 

		for (Element elem: allElems) {
			if (elem.getAppliedStereotype(Constants.CH_CHRtPortSlot) != null) {
				//System.out.println("CHRT PORT SLOT found for "+instSpec.getName());
				Stereotype chrtPortSlotStereo = elem.getAppliedStereotype(Constants.CH_CHRtPortSlot);
				CHRtPortSlot chRtPortSlot = (CHRtPortSlot) elem.getStereotypeApplication(chrtPortSlotStereo);
				EList<CHRtSpecification> chRtSpecs = chRtPortSlot.getCH_RtSpecification();
				for (CHRtSpecification chRtSpecOfChrtPortSlot : chRtSpecs) {
					if(chRtSpecOfChrtPortSlot.equals(chRtSpec)) {
						// I have found that the CHRtSpecification I am examining is associated to a CHRT Port Slot
						isAssociatedToChrtPortSlot = true;
						BehavioralFeature theContext = chRtSpec.getContext();
						String operationName ="";
						try {
							Element operationOwner = theContext.getOwner();
							operationName = theContext.getName();
							if (operationOwner.getAppliedStereotype(Constants.COMPONENT_IMPLEMENTATION)==null) {
								//errorMsg=c.getBody()+" is not defined on the component implementation!";									
								IStatus failure = ctx.createFailureStatus(											
										c.getAnnotatedElements(),									
										operationName									
										);
								return failure;
							}
							else {
								return success;		
							}
						}
						catch (Exception except) {
							IStatus failure = ctx.createFailureStatus(											
									c.getAnnotatedElements(),									
									operationName									
									);
							return failure;
						}
					}
				}
			}
		} // end of for allElems 
		if (!isAssociatedToChrtPortSlot) {
			return success;
		}
		return success;
	}
}




