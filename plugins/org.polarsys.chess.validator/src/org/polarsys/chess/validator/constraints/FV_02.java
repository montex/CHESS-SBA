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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.polarsys.chess.chessmlprofile.util.Constants;

// TODO: Auto-generated Javadoc
/**
 * The Class FV_02.
 */
public class FV_02 extends AbstractModelConstraint {

	/* (non-Javadoc)
	 * @see org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse.emf.validation.IValidationContext)
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObject = ctx.getTarget();
		Component component = (Component)eObject;
		IStatus success = ctx.createSuccessStatus();
		IStatus failure = ctx.createFailureStatus(
				component,
				component.getName()
		);

		Stereotype componentType = component.getAppliedStereotype(Constants.COMPONENT_TYPE);
		if (componentType!=null) {
			//System.err.println("Component " + component.getName() + " is a ComponentType");
			// It must provide an interface
			if (component.getProvideds().size()==0) {
				//String errorMsg = "The ComponentType " + component.getName() + " does not provide an Interface";
				return failure;		
			}
		}
		return success;
		
	}
}			
