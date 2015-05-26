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
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.polarsys.chess.chessmlprofile.util.Constants;


// TODO: Auto-generated Javadoc
/**
 * The Class FV_07.
 */
public class FV_07 extends AbstractModelConstraint {

	/* (non-Javadoc)
	 * @see org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse.emf.validation.IValidationContext)
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObject = ctx.getTarget();
		Component component = (Component)eObject;
		IStatus success = ctx.createSuccessStatus();
		
		// Look for ComponentType and ComponentImplementation
		if ( component.getAppliedStereotype(Constants.COMPONENT_TYPE)!=null ||
			 (component.getAppliedStereotype(Constants.COMPONENT_IMPLEMENTATION)!=null) ) {
		
			
			//System.err.println("Component " + component.getName());
			for (Property prop : component.getAllAttributes()) {
				if (prop instanceof Port) {
					//System.err.println(" found port : " + prop.getName());
					Stereotype clientServerPort = prop.getAppliedStereotype(Constants.CLIENTSERVER_PORT);
					Stereotype flowPort = prop.getAppliedStereotype(Constants.FLOW_PORT);

					if (clientServerPort!=null) {

						// check kind (constraint 6)
						String kind = prop.getValue(clientServerPort, Constants.CSPORT_KIND).toString();
						//System.err.println("  ClientServerPort's kind is " + kind);
						if (kind==(Constants.CSPORT_KIND_PROREQ)) {
							String errorMsg="ClientServerPorts with kind " + Constants.CSPORT_KIND_PROREQ + " are not allowed in ComponentTypes and ComponentImplementations";
							IStatus failure = ctx.createFailureStatus(
									component,
									errorMsg
							);
							return failure;
						}
					}
				}
				
			}
		}

			
		return success;
		
	}
	

}			
