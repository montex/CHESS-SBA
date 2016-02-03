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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.CallConcurrencyKind;
import org.eclipse.uml2.uml.BehavioralFeature;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification;
import org.polarsys.chess.chessmlprofile.util.Constants;

/**
 * The Class EFVRT_02.
 * This class implements the following constraint (invoked by the EMF validation framework):
 * Checks that the attribute 'occKind' of a CHRtSpecification that is related to an ARINCFunction must not be empty. 
 * if it is Empty, then IMA Generate Partition Schedule must be called! 
 */
public class EFVRT_02_1 extends AbstractModelConstraint {

	/* (non-Javadoc)
	 * @see org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse.emf.validation.IValidationContext)
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObject = ctx.getTarget();
		Comment c = (Comment)eObject;

		IStatus success = ctx.createSuccessStatus();
		String errorMsg = null;


		//		IStatus failure = ctx.createFailureStatus(
		//				c.getAnnotatedElements(),  			// name of element annotated by this comment {0}
		//				c.getNearestPackage().getName()   	// package owning this {1}
		//				);

		Stereotype chrtSpecStereo = c.getAppliedStereotype(Constants.CHRT_SPECIFICATION);	
		if(chrtSpecStereo == null) {
			return success;
		}

		CHRtSpecification chRtSpec = (CHRtSpecification)c.getStereotypeApplication(chrtSpecStereo);
		String occValue = chRtSpec.getOccKind();
		CallConcurrencyKind protection = chRtSpec.getProtection();

		if (protection.equals(CallConcurrencyKind.SEQUENTIAL)) {
			if (occValue!=null) {
				if(!(occValue.toLowerCase().startsWith(Constants.CHRTSPEC_OCCKIND_PERIODIC)  || 
						occValue.toLowerCase().startsWith(Constants.CHRTSPEC_OCCKIND_SPORADIC) 
						|| occValue.toLowerCase().startsWith(Constants.CHRTSPEC_OCCKIND_BURST))) {
					// if it is an ARINC function then the occurrency kind can be like:
					// (phase=(value=0.0, unit=s))
					BehavioralFeature behavFeat = chRtSpec.getContext(); 
					if (behavFeat.getAppliedStereotype(Constants.CH_ARINCFunction)!=null)  {
						if (occValue.isEmpty()) {
							// Empty occKind for ARINCFunction. Warning: IMA generate partition schedule has not been launched to							
							errorMsg = "Empty occKind for ARINCFunction. IMA Generate Partition Schedule must be called!";

							if (errorMsg != null){
								IStatus failure = ctx.createFailureStatus(
										c.getAnnotatedElements(),  
										errorMsg
										);
								return failure;
							}																				
						}
					}
				}				
			}
		}
		return success;
	}			
}
