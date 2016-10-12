/*
-----------------------------------------------------------------------
--                CHESS Live/Batch Validator plugin                  --
--                                                                   --
--                    Copyright (C) 2011-2012                        --
--                 University of Padova, ITALY                       --
--                                                                   --
-- Author: 											                 --
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
import org.eclipse.uml2.uml.BehavioralFeature;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification;
import org.polarsys.chess.chessmlprofile.util.Constants;

/**
 * The Class EFVRT_03.
 * This class implements the following constraint (invoked by the EMF validation framework):
 * Checks that in CHRtSpecification, if occKind is Periodic, then the attributes 'period' and 'relDl' must all be >= 0, 
 * unless the CHRtSpecification is related to an ARINCFunction, in which case the attribute 'period' may be empty, as it will be
 * filled in by the PIM to PSM transformation. 
 */
public class EFVRT_03 extends AbstractModelConstraint {	

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

		StringParser parser = new StringParser();

		// 20160531 if partWithPort is null, the validation must still be performed 
//		Property partWithPort = chRtSpec.getPartWithPort();
//		if (partWithPort==null) {
//			return success;
//		}

		String occValue = chRtSpec.getOccKind();
		//String wcet = chRtSpec.getWCET();
		String relDl = chRtSpec.getRlDl();

		if(occValue == null || !(occValue.contains(Constants.CHRTSPEC_OCCKIND_PERIODIC)))
			return success;

		if(relDl == null)
			return failure;

		try {
			double period = parser.getValuePattern(occValue, "period");			
			if(!(period >= 0)) {
				// Check if the Context is an ARINCFunction, in which case return success anyhow
				BehavioralFeature behavFeat = chRtSpec.getContext(); 
				if (behavFeat.getAppliedStereotype(Constants.CH_ARINCFunction)!=null) {
					// period will be filled in by the PIM to PSM transformation, so we return success
					return success;
				}
				return failure;
			}
		}
		catch (Exception except) {
			return failure;
		}

		// We do NOT check WCET here because this is done in EFVRT_40, that checks LocalWCET
//		try {
//			double wcetValue = parser.getValueNFP(wcet);

		// Commenting the check on WCET >=0 
		// there is EFVRT_40 that checks LocalWCET
		//					if(!(wcetValue >= 0))
		//						return failure;
//		}
//		catch (Exception exception) {
//			return failure;
//		}

		try {
			double relDlValue = parser.getValueNFP(relDl);
			if(!(relDlValue >= 0))
				return failure;
		}
		catch (Exception except) {
			return failure;
		}
		return success;
	}
}			
