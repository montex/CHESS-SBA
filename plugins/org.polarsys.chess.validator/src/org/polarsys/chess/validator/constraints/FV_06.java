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
import java.util.Iterator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Realization;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.model.ConstraintStatus;
import org.polarsys.chess.chessmlprofile.util.Constants;

public class FV_06 extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObject = ctx.getTarget();
		Component component = (Component)eObject;
		IStatus success = ctx.createSuccessStatus();

		Stereotype componentType = component.getAppliedStereotype(Constants.COMPONENT_TYPE);
		
		// Look for ComponentType and ComponentImplementation
		if ( component.getAppliedStereotype(Constants.COMPONENT_TYPE)!=null ||
			 (component.getAppliedStereotype(Constants.COMPONENT_IMPLEMENTATION)!=null) ) {
		
		
			//System.err.println("Component " + component.getName());
			for (Property prop : component.getAllAttributes()) {
				if (prop instanceof Port) {
					//System.err.println(" found port : " + prop.getName());
					Stereotype clientServerPort = prop.getAppliedStereotype(Constants.CLIENTSERVER_PORT);
					Stereotype flowPort = prop.getAppliedStereotype(Constants.FLOW_PORT);
					
					
					// Check constraints 5 and 6
					if (clientServerPort!=null) {
						// check specificationKind (constraint 5)
						String specKind = prop.getValue(clientServerPort, Constants.CSPORT_SPEC_KIND).toString();
						//System.err.println("  ClientServerPort's specificationKind is " + specKind);
						if (specKind!=(Constants.CSPORT_SPEC_KIND_INTERFACEBASED)) {
							String errorMsg="The value of ClientServerPort stereotype's attribute " + Constants.CSPORT_SPEC_KIND + " must be set to " + Constants.CSPORT_SPEC_KIND_INTERFACEBASED;
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
