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
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.CallConcurrencyKind;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.polarsys.chess.core.views.ViewUtils;

public class EFVRT_02 extends AbstractModelConstraint {

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
		if(ViewUtils.isComponentView(ownerP))
			rightView = true;
		else {
			List<Package> pkg = c.getNearestPackage().allOwningPackages();
			for(Package it : pkg) {
				if(ViewUtils.isComponentView(it))
					rightView = true;
			}
		}

		if(rightView) {
			Stereotype s = c.getAppliedStereotype("CHESS::Predictability::RTComponentModel::CHRtSpecification");	
			if(s == null) 
				return success;
			else {
				String occValue = (String) c.getValue(s, "occKind");
				String protection = ((CallConcurrencyKind) c.getValue(s, "protection")).getLiteral();
				
				if (protection.compareToIgnoreCase("sequential")==0){
				
					if(occValue == null)
						return failure;
					else {
						if(occValue.toLowerCase().startsWith("periodic")  || occValue.toLowerCase().startsWith("sporadic") 
								|| occValue.toLowerCase().startsWith("burst"))
							return success;
						else
							return failure;
					}
			}
			}
		}
		return success;
	}
}			
