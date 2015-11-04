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
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.ClientServerKind;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.ClientServerPort;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.polarsys.chess.chessmlprofile.util.Constants;
import org.polarsys.chess.core.util.uml.UMLUtils;

/**
 * The Class FV_07.
 * This class implements the following constraint (invoked by the EMF validation framework):
 * ClientServerPorts with kind PROREQ are not allowed in ComponentTypes and ComponentImplementations
 */
public class FV_07 extends AbstractModelConstraint {

	/* (non-Javadoc)
	 * @see org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse.emf.validation.IValidationContext)
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {
		IStatus success = ctx.createSuccessStatus();

		Port port = (Port) ctx.getTarget();

		Element owner = port.getOwner();
		if(!UMLUtils.isComponentType(owner) && !UMLUtils.isComponentImplementation(owner)){
			return success;
		}
		// The owner of the Port is either a ComponentType or a ComponentImplementation

		Stereotype clientServerPortStereo = port.getAppliedStereotype(Constants.CLIENTSERVER_PORT);
		//Stereotype flowPortStereo = prop.getAppliedStereotype(Constants.FLOW_PORT);

		if (clientServerPortStereo!=null) {
			ClientServerPort clientServerPort = (ClientServerPort) port.getStereotypeApplication(clientServerPortStereo);						
			ClientServerKind clientServerKind = clientServerPort.getKind();
			if (clientServerKind.equals(ClientServerKind.PROREQ)) {	
				String portName = "";
				portName = port.getName();
				String errorMsg="ClientServerPort "+portName+" with kind " + ClientServerKind.PROREQ.getLiteral() + " are not allowed in ComponentTypes and ComponentImplementations";
				IStatus failure = ctx.createFailureStatus(
						port,
						errorMsg
						);
				return failure;
			}
		}			
		return success;
	}
}			
