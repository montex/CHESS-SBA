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

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Assign;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.polarsys.chess.chessmlprofile.Core.CHESS;
import org.polarsys.chess.chessmlprofile.Core.Domain;
import org.polarsys.chess.chessmlprofile.util.Constants;
import org.polarsys.chess.core.profiles.CHESSProfileManager;
import org.polarsys.chess.core.util.uml.ModelError;
import org.polarsys.chess.core.util.uml.UMLUtils;

/**
 * The Class DV_06.
 * This class implements the following constraint (invoked by the EMF validation framework):
 * A Functional Partition that has no ComponentImplementation instance deployed on it 
 * should be allocated on exactly one Core. (only WARNING)
 * 20160315 LB Modified for addressing multiple deployments and addressing different needs for Avionic Domain models
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

		Domain theDomain = Domain.CROSS_DOMAIN;
		// Look into the CHESS Model to find if the Domain is Avionics: 
		// only in this case Partitions should be taken into account
		if (umlModel.getAppliedStereotype(Constants.CHESS_MODEL_STEREOTYPE) != null) {
			Stereotype chessModelStereo = umlModel.getAppliedStereotype(Constants.CHESS_MODEL_STEREOTYPE);
			CHESS chessModel = (CHESS) umlModel.getStereotypeApplication(chessModelStereo);
			theDomain = chessModel.getDomain();
		}	

		// Perform this validation only for Models in the AVIONICS Domain 
		if (!theDomain.equals(Domain.AVIONICS)) {
			return success;
		}

		EList<Assign> compViewAssignments = new BasicEList<Assign>();
		EList<Assign> deplViewAssignments = new BasicEList<Assign>();
		try {
			deplViewAssignments = UMLUtils.getAssignments(umlModel, Constants.DEPLOYMENT_VIEW_NAME);	
			compViewAssignments = UMLUtils.getComponentAssignments(umlModel, Constants.COMPONENT_VIEW_NAME);
		} catch (ModelError modelError) {
			modelError.printStackTrace();
		}		

		if (UMLUtils.hasComponentAssigned(instSpec,compViewAssignments)) {
			// This case is checked by DV_05
			return success;
		}

		// Read the deployments from the Model
		Package deplv = CHESSProfileManager.getViewByStereotype(umlModel,
				CHESSProfileManager.DEPLOYMENT_VIEW);					
		Set<Element> theDeployments = new HashSet<Element>();
		EList<Package> packList = UMLUtils.getAllResourcePlatformPackage(deplv);					
		for (Package pack: packList) {
			Element theEl = (Element)pack;
			theDeployments.add(theEl);
		}

		boolean newErrMess = true;
		for (Element theDeployment: theDeployments) {
			String deploymentName = "";
			if (theDeployment instanceof NamedElement) {
				NamedElement namedEl = (NamedElement)theDeployment;
				deploymentName = namedEl.getName();
			}

			int howManyProcessorUnits = UMLUtils.isAssigned2HowManyProcessingUnits(instSpec, theDeployment,deplViewAssignments);
			if (howManyProcessorUnits == 1) {
				return success;
			}
			if (howManyProcessorUnits != 1) {
				if (newErrMess) {	
					newErrMess = false;
					errorMsg = "The Partition instance " + instSpec.getName() +" should be deployed on a processing unit - Currently ";
				}

				errorMsg += howManyProcessorUnits +" for "+deploymentName+". But no component is allocated on it.";
			}
		}
		if (errorMsg != null){
			IStatus failure = ctx.createFailureStatus(
					instSpec,errorMsg
					);
			return failure;
		}

		return success;
	}				
}
