/*
-----------------------------------------------------------------------
--                CHESS Live/Batch Validator plugin                  --
--                                                                   --
--                    Copyright (C) 2011-2012                        --
--                 University of Padova, ITALY                       --
--                                                                   --
-- Author:                                                           --
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
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification;
import org.polarsys.chess.chessmlprofile.util.Constants;

/**
 * The Class EFVRT_40.
 * This class implements the following constraint (invoked by the EMF validation framework):
 * Checks that in CH_RtSpecification attribute localWCET must be >= 0
 */
public class EFVRT_40 extends AbstractModelConstraint {	

	/* (non-Javadoc)
	 * @see org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse.emf.validation.IValidationContext)
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObject = ctx.getTarget();
		Comment c = (Comment)eObject;

		IStatus success = ctx.createSuccessStatus();
		IStatus failure = ctx.createFailureStatus(
				c.getAnnotatedElements(),  			// name of element annotated by this comment {0}
				c.getNearestPackage().getName() 	// package owning this {1}
				);  

		StringParser parser = new StringParser();

		Stereotype chrtSpecStereo = c.getAppliedStereotype(Constants.CHRT_SPECIFICATION);	
		if(chrtSpecStereo == null) {
			return success;
		}

		CHRtSpecification chRtSpec = (CHRtSpecification)c.getStereotypeApplication(chrtSpecStereo);
		// 20160531 if partWithPort is null, the validation must still be performed 
//		Property partWithPort = chRtSpec.getPartWithPort();
//		if (partWithPort==null) {
//			return success;
//		}

		String localWCET = chRtSpec.getLocalWCET();

		if ((localWCET != null)&&(!localWCET.isEmpty())) {
			try {
				double localWCETVal = parser.getValueNFP(localWCET);
				if (localWCETVal >= 0) {
					return success;
				}

				String errorMsg = "Current value is "+localWCETVal;
				failure = ctx.createFailureStatus(
						c.getAnnotatedElements(),  			// name of element annotated by this comment {0}
						errorMsg 	// package owning this {1}
						);  
				return failure;

			}
			catch (Exception except) {
				String errorMsg = "Invalid localWCET";
				failure = ctx.createFailureStatus(
						c.getAnnotatedElements(),  			// name of element annotated by this comment {0}
						errorMsg 	// package owning this {1}
						);  
				return failure;
			}
		}
		String errorMsg = "Invalid localWCET";
		failure = ctx.createFailureStatus(
				c.getAnnotatedElements(),  			// name of element annotated by this comment {0}
				errorMsg 	// package owning this {1}
				);  
		return failure;
	}
}			
