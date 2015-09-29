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
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Assign;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.polarsys.chess.chessmlprofile.util.Constants;
import org.polarsys.chess.core.util.uml.ModelError;
import org.polarsys.chess.core.util.uml.UMLUtils;

/**
 * The Class DV_06.
 * DV_06 checks that a Functional Partition that has no ComponentImplementation instance deployed on it 
 * is allocated on exactly one Core.
 */
public class DV_06 extends AbstractModelConstraint {

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
		
		// Only look at Partitions
		if (! UMLUtils.isPartitionInstance(instSpec)) 
			return success;

		Model umlModel = instSpec.getModel();

		EList<Assign> compViewAssignments = new BasicEList<Assign>();
		EList<Assign> deplViewAssignments = new BasicEList<Assign>();
		try {
			deplViewAssignments = UMLUtils.getAssignments(umlModel, Constants.DEPLOYMENT_VIEW_NAME);	
			compViewAssignments = UMLUtils.getComponentAssignments(umlModel, Constants.COMPONENT_VIEW_NAME);
		} catch (ModelError e1) {
			e1.printStackTrace();
		}		
		
		if (UMLUtils.hasComponentAssigned(instSpec,compViewAssignments)) {
			// This case is checked by DV_05
			return success;
		}
		int howManyProcessorUnits = UMLUtils.isAssigned2HowManyProcessingUnits(instSpec, deplViewAssignments);
		if (howManyProcessorUnits == 1) {
			return success;
		}
			
		errorMsg = "The Partition instance " + instSpec.getName() +" should be deployed on a processing unit (Currently " + howManyProcessorUnits +"). But no component is allocated on it.";
		

		if (errorMsg != null){
			IStatus failure = ctx.createFailureStatus(
					instSpec,errorMsg
					);
			return failure;
		}
		
		return success;
		

	}				
}
