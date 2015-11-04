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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.polarsys.chess.chessmlprofile.ComponentModel.ComponentType;
import org.polarsys.chess.chessmlprofile.util.Constants;

/**
 * The Class FV_02.
 * This class implements the following constraint (invoked by the EMF validation framework):
 * ComponentType must provide an Interface
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
		
		String componentName = "";
		componentName = component.getName();
		
		IStatus failure = ctx.createFailureStatus(
				component,
				componentName
		);

		Stereotype componentTypeStereo = component.getAppliedStereotype(Constants.COMPONENT_TYPE);
		if (componentTypeStereo==null) {
			return success;			
		}
				
		EList<Interface> componentInterfaces = component.getProvideds();
		if (componentInterfaces==null ||componentInterfaces.size()==0) {
			return failure;		
		}	
		
		return success;		
	}
}			
