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
 * The Class EFVRT_20.
 * This class implements the following constraint (invoked by the EMF validation framework):
 * In CH_RtSpecification if occKind=SporadicPattern, then minInterarrival, WCET and relDl attributes must all be >= 0
 */
public class EFVRT_20 extends AbstractModelConstraint {	

	/* (non-Javadoc)
	 * @see org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse.emf.validation.IValidationContext)
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObject = ctx.getTarget();
		Comment c = (Comment)eObject;

		IStatus success = ctx.createSuccessStatus();
		IStatus failure = ctx.createFailureStatus(
				c.getAnnotatedElements(),  // name of element annotated by this comment {0}
				c.getNearestPackage().getName()// package owning this {1}
				);  


		Stereotype chrtSpecStereo = c.getAppliedStereotype(Constants.CHRT_SPECIFICATION);	
		if(chrtSpecStereo == null) {
			return success;
		}

		CHRtSpecification chRtSpec = (CHRtSpecification)c.getStereotypeApplication(chrtSpecStereo);
		// 20160531 if partWithPort is null, the validation must still be performed 
//		Property partWithPort = chRtSpec.getPartWithPort();
//		if (partWithPort == null) {
//			return success;
//		}

		StringParser parser = new StringParser();

		String occValue = chRtSpec.getOccKind();
		//String wcet = chRtSpec.getLocalWCET();
		// We do NOT check WCET here because this is done in EFVRT_40, that checks LocalWCET
		String relDl = chRtSpec.getRlDl();

		if(occValue == null || !(occValue.contains(Constants.CHRTSPEC_OCCKIND_SPORADIC))) {
			return success;
		}

		//if(wcet == null || relDl == null)
		if(relDl == null)
			return failure;
		else {
			double minIntarr = parser.getValuePattern(occValue, Constants.CHRTSPEC_OCCKIND_SPORADIC_MININTERARRIVAL);
			if(!(minIntarr >= 0)) 
				return failure;	
			else {
//				double wcetVal = parser.getValueNFP(wcet);
//				if(!(wcetVal >= 0))
//					return failure;
//				else {
					double relDlVal = parser.getValueNFP(relDl);
					if(!(relDlVal >= 0))
						return failure;
//				}
			}
		}

		return success;
	}
}			
