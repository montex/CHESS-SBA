/*
-----------------------------------------------------------------------
--                CHESS Live/Batch Validator plugin                  --
--                                                                   --
--                                                                   --
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
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CH_HwBus;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CH_HwProcessor;
import org.polarsys.chess.chessmlprofile.util.Constants;

/**
 * The Class DV_03.
 * This class implements the following constraint (invoked by the EMF validation framework):
 * the attributes 'PacketT', 'speedFactor', 'blockT' of stereotype CH_HwBus must be set
 * the attribute 'speedFactor' of stereotype CH_HwProcessor must be set
 */
public class DV_03 extends AbstractModelConstraint {

	/* (non-Javadoc)
	 * @see org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse.emf.validation.IValidationContext)
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObject = ctx.getTarget();
		Element elem = (Element)eObject;
		IStatus success = ctx.createSuccessStatus();
		String errorMsg = null;

		Stereotype chHwBusStereo = elem.getAppliedStereotype(Constants.CH_HW_BUS);
		if (chHwBusStereo != null){
			CH_HwBus chHwBus = (CH_HwBus) elem.getStereotypeApplication(chHwBusStereo);
		
			// HwBus.PacketT cannot be null
			EList<String> packetT = chHwBus.getPacketT();
			if (packetT == null ||packetT.size()==0) {
				errorMsg = "The attribute 'packetT' of stereotype CH_HwBus must be set";
			}	
		}

		if (errorMsg != null){
			IStatus failure = ctx.createFailureStatus(
					elem,	
					errorMsg
					);
			return failure;
		}

		return success;

	}

}			
