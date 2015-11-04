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
 * The Class DV_04.
 * This class implements the following constraint (invoked by the EMF validation framework):
 * If the attribute 'speedFactor' of stereotype <<HwBus>> is null, default (value=1.0) will be used
 * If the attribute 'blockT' of stereotype <<HwBus>> is null, default (worst=0.0,unit=ms) will be used
 * If the attribute 'speedFactor' of stereotype <<CH_HwProcessor>> is null, default (value=1.0) will be used
 */
public class DV_04 extends AbstractModelConstraint {

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

			// Check speedFactor
			String speedFactor = chHwBus.getSpeedFactor();
			if (speedFactor==null || speedFactor.length()==0) {
				errorMsg="The attribute 'speedFactor' of stereotype CH_HwBus is null, default (value=1.0) will be used.";						
			}

			// Check blockT
			EList<String> blockT = chHwBus.getBlockT();
			if (blockT==null || blockT.size()==0) {
				errorMsg +=" The attribute 'blockT' of stereotype CH_HwBus is null, default (worst=0.0,unit=ms) will be used.";					
			}			
		}

		if (!(elem instanceof Connector)) {
			// Then it can be a HwComputingResource
			Stereotype hwProcessorStereo = elem.getAppliedStereotype(Constants.CH_HWPROCESSOR);
			if (hwProcessorStereo!=null) {
				CH_HwProcessor chHwProcessor = (CH_HwProcessor) elem.getStereotypeApplication(hwProcessorStereo);
				String speedFactor = chHwProcessor.getSpeedFactor();
				if (speedFactor==null || speedFactor.length()==0) {
					errorMsg="The attribute 'speedFactor' of stereotype CH_HwProcessor is null, default (value=1.0) will be used";							
				}
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
