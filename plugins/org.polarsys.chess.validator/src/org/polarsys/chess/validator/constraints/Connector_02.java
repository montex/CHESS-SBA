/*
-----------------------------------------------------------------------
--                CHESS Live/Batch Validator plugin                  --
--                                                                   --
--                    Copyright (C) 2011-2012                        --
--                 University of Padova, ITALY                       --
--                                                                   --
-- Author: Nicholas Pacini         									 --
--                                                                   --
-- All rights reserved. This program and the accompanying materials  --
-- are made available under the terms of the Eclipse Public License  --
-- v1.0 which accompanies this distribution, and is available at     --
-- http://www.eclipse.org/legal/epl-v10.html                         --
-----------------------------------------------------------------------
*/

package org.polarsys.chess.validator.constraints;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowDirectionKind;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowPort;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.polarsys.chess.chessmlprofile.util.Constants;

/**
 * The Class Connector_02.
 * Check that flow ports on the ends of a connection have compatible directions 
 */
public class Connector_02 extends AbstractModelConstraint {

	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse.emf.validation.IValidationContext)
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {		
		
		Connector con = (Connector) ctx.getTarget();
		
		String thisElement = "";
		thisElement = con.getName();
		//System.out.println("... Connector: "+thisElement);
		
		String errorMsg = "";
		
		IStatus success = ctx.createSuccessStatus();
		IStatus failure = ctx.createFailureStatus(
				thisElement,			  		
				errorMsg	
				); 
		
		ConnectorEnd firstEnd = con.getEnds().get(0);
		if(!(firstEnd.getRole() instanceof Port)){
			errorMsg = "First end is not instance of Port";
			failure = ctx.createFailureStatus(
					thisElement,			  		
					errorMsg	
					); 
			return failure;
		}
		
		Port firstPort = (Port) firstEnd.getRole();
		Stereotype firstStereo = firstPort.getAppliedStereotype(Constants.FLOW_PORT);
		if(firstStereo == null){
			return success;
		}
		FlowPort firstFlowPort = (FlowPort) firstPort.getStereotypeApplication(firstStereo);

		ConnectorEnd secondEnd = con.getEnds().get(1);
		if(!(secondEnd.getRole() instanceof Port)){
			errorMsg = "Second end is not instance of Port";
			failure = ctx.createFailureStatus(
					thisElement,			  		
					errorMsg	
					); 
			return failure;
		}
		
		Port secondPort = (Port) secondEnd.getRole();
		Stereotype secondStereo = secondPort.getAppliedStereotype(Constants.FLOW_PORT);
		if(secondStereo == null){
			return success;
		}	
		FlowPort secondFlowPort = (FlowPort)secondPort.getStereotypeApplication(secondStereo);
		
		//check directions:
		//out -> in; in -> out; inout -> whatever
		//String firstDir = firstPort.getValue(firstStereo, Constants.FLOW_PORT_DIRECTION).toString();
		FlowDirectionKind firstDir= firstFlowPort.getDirection();
		FlowDirectionKind secondDir = secondFlowPort.getDirection();
		//String secondDir = secondPort.getValue(secondStereo, Constants.FLOW_PORT_DIRECTION).toString();
		
		if(!firstDir.equals(FlowDirectionKind.INOUT) && !(secondDir.equals(FlowDirectionKind.INOUT)) && 
				firstDir.equals(secondDir)) {
			//it's not an automatic failure if it's port delegation between parent and child
			if(firstEnd.getPartWithPort() == null || secondEnd.getPartWithPort() == null){
				return success;
			}
			if(firstEnd.getPartWithPort() instanceof Property || secondEnd.getPartWithPort() instanceof Property){
				Property prFirst = firstEnd.getPartWithPort();
				Property prSec = secondEnd.getPartWithPort();
				//check that the one of the properties contains the other
				if(prFirst.getType().getOwnedElements().contains(prSec) || 
						prSec.getType().getOwnedElements().contains(prFirst)){
					return success;
				}
			}
			failure = ctx.createFailureStatus(
					thisElement,			  		
					errorMsg	
					); 
			return failure;
		}		
		
		return success;
	}

}
