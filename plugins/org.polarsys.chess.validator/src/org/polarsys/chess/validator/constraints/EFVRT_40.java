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

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.polarsys.chess.core.views.ViewUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class EFVRT_40.
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
				c.getAnnotatedElements(),  // name of element annotated by this comment {0}
				c.getNearestPackage().getName()// package owning this {1}
		);  

		// view control:
		boolean rightView = false;
		Package ownerP = c.getNearestPackage();
		if(ViewUtils.isExtraFunctionalView(ownerP))
			rightView = true;
		else {
			List<Package> pkg = c.getNearestPackage().allOwningPackages();
			for(Package it : pkg) {
				if(ViewUtils.isExtraFunctionalView(it))
					rightView = true;
			}
		}
		
		if(rightView) {
		
			StringParser parser = new StringParser();
			Stereotype s = c.getAppliedStereotype("CHESS-ML::Predictability::RTComponentModel::CH_RtSpecification");	

			if(s == null)
				return success;
			else {

				if(c.getValue(s, "partWithPort") == null)
					return success;
				else {
					
					String localWCET = (String) c.getValue(s, "localWCET");
					if(localWCET != null) { 
						double localWCETVal = parser.getValueNFP(localWCET);
						if(!(localWCETVal > 0))
							return failure;
					}
				}
			}
			return success;
		}
		return success;
	}
}			