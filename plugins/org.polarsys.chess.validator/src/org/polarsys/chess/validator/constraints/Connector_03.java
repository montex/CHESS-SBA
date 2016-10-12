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
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowPort;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.polarsys.chess.chessmlprofile.util.Constants;

/**
 * The Class Connector_03.
 * Check that flow ports on the ends of a connection are compatible in type
 */
public class Connector_03 extends AbstractModelConstraint {

	/* (non-Javadoc)
	 * @see org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse.emf.validation.IValidationContext)
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {

		IStatus success = ctx.createSuccessStatus();
		Connector con = (Connector) ctx.getTarget();

		String thisElement = "";
		thisElement = con.getName();
		String errorMsg = "";

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
		if (firstStereo == null) {
			return success;
		}
		FlowPort firstFlowPort = (FlowPort) firstPort.getStereotypeApplication(firstStereo);

		ConnectorEnd secondEnd = con.getEnds().get(1);
		if (!(secondEnd.getRole() instanceof Port)) {
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

		FlowPort secondFlowPort = (FlowPort) secondPort.getStereotypeApplication(secondStereo);

		//check types
		// Check that types of flowPorts at the ends of a Connector must be identical
		// Actually for SysML we should also accept the situation where the type of the destination FlowPort
		// contains the type of the source FlowPort. For this reason in case of different types we only generate a Warning
		Type firstFlowPortType = firstFlowPort.getBase_Port().getType();
		Type secondFlowPortType = secondFlowPort.getBase_Port().getType();
		//if (!(firstPort.getType().equals(secondPort.getType()))) {
		if (firstFlowPortType == null && secondFlowPortType == null) {
			return success;
		}
		try {
			if(!firstFlowPortType.equals(secondFlowPortType)) {
				errorMsg = "Different types";
				failure = ctx.createFailureStatus(
						thisElement,			  		
						errorMsg	
						); 
				return failure;
			}	
		}
		catch (Exception e){
			errorMsg = "Exception";
			failure = ctx.createFailureStatus(
					thisElement,			  		
					errorMsg	
					); 
			return failure;
		}
		return success;
	}

}
