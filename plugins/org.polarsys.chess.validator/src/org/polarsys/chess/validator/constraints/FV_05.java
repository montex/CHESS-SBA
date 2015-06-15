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

// TODO: Auto-generated Javadoc
/**
 * The Class FV_05.
 */
public class FV_05 extends AbstractModelConstraint {

	/* (non-Javadoc)
	 * @see org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse.emf.validation.IValidationContext)
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObject = ctx.getTarget();
		Component component = (Component)eObject;
		IStatus success = ctx.createSuccessStatus();

		Stereotype componentType = component.getAppliedStereotype(Constants.COMPONENT_TYPE);
		
		// Look for ComponentType and ComponentImplementation
		if ( component.getAppliedStereotype(Constants.COMPONENT_TYPE)!=null ||
			 (component.getAppliedStereotype(Constants.COMPONENT_IMPLEMENTATION)!=null) ) {
		
		// All ports owned by component must be stereotyped with ClientServerPort or FlowPort
		
			for (Property prop : component.getAllAttributes()) {
				if (prop instanceof Port) {
					//System.err.println(" found port : " + prop.getName());
					Stereotype clientServerPort = prop.getAppliedStereotype(Constants.CLIENTSERVER_PORT);
					Stereotype flowPort = prop.getAppliedStereotype(Constants.FLOW_PORT);
					if ( (clientServerPort==null) &&	(flowPort==null) ) {
						String errorMsg="The Port " + prop.getName() + " must be stereotyped by either <<ClientServerPort>> or <<FlowPort>>";
						//System.err.println(errorMsg);
						IStatus failure = ctx.createFailureStatus(
								component,
								errorMsg
						);
						return failure;
					}

				}
				
			}
		}
		

		return success;
		
	}
	
}			
