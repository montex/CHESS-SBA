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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.polarsys.chess.chessmlprofile.util.Constants;

// TODO: Auto-generated Javadoc
/**
 * The Class DV_03.
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

		
			Stereotype hwBus = elem.getAppliedStereotype(Constants.HW_BUS);
			if (hwBus!=null) {
				// HwBus.PacketT cannot be null
				Object packetT =elem.getValue(hwBus, Constants.HW_BUS_PACKETT);
				//System.err.println(obj.getValue(hwBus, Constants.HW_BUS_PACKETT));
				if (  packetT == null) {
					errorMsg = "The attribute " + Constants.HW_BUS_PACKETT +" of stereotype HwBus must be set";
					
				} else {
					if ( packetT.toString().length()==0) {
						errorMsg = "The attribute " + Constants.HW_BUS_PACKETT +" of stereotype HwBus must be set";
						
					}
					//System.err.println("packetT:" + packetT.toString());
				}
				// Warning if HwBus.SpeedFactor is null
				Object speedFactor = elem.getValue(hwBus, Constants.HW_BUS_SPEEDFACTOR);
				if (speedFactor==null) {
					errorMsg="The attribute 'speedFactor' of stereotype HwBus is null, default (value=1.0) will be used";
					
				}
				else {
					if (speedFactor.toString().length()==0) {
						errorMsg="The attribute 'speedFactor' of stereotype HwBus is null, default (value=1.0) will be used";
						
					}
					//System.err.println("speedFactor:" + speedFactor.toString());
				}
				// Warning if HwBus.BlockT is null
				Object blockT = elem.getValue(hwBus, Constants.HW_BUS_BLOCKT);
				if (blockT==null) {
					errorMsg="The attribute 'blockT' of stereotype HwBus is null, default (worst=0.0,unit=ms) will be used";
					
				}
				else {
					if (blockT.toString().length()==0) {
						errorMsg="The attribute 'speedFactor' of stereotype HwBus is null, default (worst=0.0,unit=ms) will be used";
						
					}
					
				}			
			}
			
			if (!(elem instanceof Connector)) {
				// Then it can be a HwComputingResource
				Stereotype hwProcessor = elem.getAppliedStereotype(Constants.CH_HWPROCESSOR);
				if (hwProcessor!=null) {
					//System.err.println("Object " + obj + " is a HwComputingResource");
					Object speedFactor = elem.getValue(hwProcessor, Constants.HW_BUS_SPEEDFACTOR);
					if (speedFactor==null) {
						errorMsg="The attribute 'speedFactor' of stereotype CH_HwProcessor is null, default (value=1.0) will be used";
						
					}
					else {
						if (speedFactor.toString().length()==0) {
							errorMsg="The attribute 'speedFactor' of stereotype CH_HwProcessor is null, default (value=1.0) will be used";
							
						}
						//System.err.println("speedFactor:" + speedFactor.toString());
					}
				
				}
			}
	
		if (errorMsg != null){
			IStatus failure = ctx.createFailureStatus(
					elem,	errorMsg
			);
			return failure;
		}
		
		return success;
		
	}
	
}			
