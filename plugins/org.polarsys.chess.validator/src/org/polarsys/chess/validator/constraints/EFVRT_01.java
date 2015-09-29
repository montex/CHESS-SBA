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
import org.eclipse.uml2.uml.BehavioralFeature;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Realization;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.model.ConstraintStatus;
import org.polarsys.chess.chessmlprofile.ComponentModel.ComponentImplementation;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtPortSlot;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification;
import org.polarsys.chess.chessmlprofile.Safety.CriticalityInterfaceSpecification;
import org.polarsys.chess.chessmlprofile.util.Constants;

// TODO: Auto-generated Javadoc
/**
 * The Class EFVRT_01.
 */
public class EFVRT_01 extends AbstractModelConstraint {

	/* (non-Javadoc)
	 * @see org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse.emf.validation.IValidationContext)
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObject = ctx.getTarget();
		InstanceSpecification instSpec = (InstanceSpecification)eObject;
		IStatus success = ctx.createSuccessStatus();
		String errorMsg = null;
				
		//<<IdentifInstance>> InstanceSpecification does not need to have an allocation to HW
		if (instSpec.getAppliedStereotype("CHESS::Core::IdentifInstance")!=null)
			return success;
		
		//System.out.println("-------------NAME="+instSpec.getName());
		
		EList<Element> elements = instSpec.getOwnedElements();
		for (Element elem: elements) {
			if (elem.getAppliedStereotype(Constants.CH_CHRtPortSlot) != null) {
				System.out.println("CHRT PORT SLOT found for "+instSpec.getName());
				Stereotype chrtPortSlotStereo = elem.getAppliedStereotype(Constants.CH_CHRtPortSlot);
				CHRtPortSlot chRtPortSlot = (CHRtPortSlot) elem.getStereotypeApplication(chrtPortSlotStereo);
				EList<CHRtSpecification> chRtSpecs = chRtPortSlot.getCH_RtSpecification();
				for (CHRtSpecification chRtSpec : chRtSpecs) {
					BehavioralFeature theContext = chRtSpec.getContext();
					Element operationOwner = theContext.getOwner();
					String operationName = theContext.getName();
					if (operationOwner.getAppliedStereotype(Constants.COMPONENT_IMPLEMENTATION)==null) {
						//errorMsg="Operation "+operationName+" is not defined on the component implementation!";
						//System.err.println(errorMsg);
						IStatus failure = ctx.createFailureStatus(
								instSpec,
								operationName
						);
						return failure;
					}
				}				
			}			
		}		
		return success;		
	}
	
}			
