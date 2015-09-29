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
 * The Class DV_01.
 * DV_01 checks that the ComponentImplementation instance must be deployed on exactly 
 * one processing unit or a functional partition.
 */
public class DV_01 extends AbstractModelConstraint {

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
		
//		Collection<Comment> allAssignComment = new ArrayList<Comment>();
		
		Model umlModel = instSpec.getModel();
				
//		TreeIterator<EObject> it = instSpec.getModel().eAllContents();
//		while (it.hasNext()) {
//			EObject obj = it.next();
//			
//			if (obj instanceof Comment && (((Comment) obj).getAppliedStereotype(Constants.ASSIGN)) != null) {
//				allAssignComment.add((Comment) obj);
//			}
//		}
		

		if (instSpec.getClassifiers().size()!=0) {
			
			Classifier classifier = instSpec.getClassifiers().iterator().next();
			if (classifier instanceof Component) {
				Component comp = (Component) classifier;
				// Is the component a ComponentImplementation?
				Stereotype compImpl = comp.getAppliedStereotype(Constants.COMPONENT_IMPLEMENTATION);
				if (compImpl!=null) {
					// There should be exactly one Assign.from referencing the component
					int count=0;
					
					// LB 20150917 begin
					/* change for Concerto ToDo #36 to solve problems that may arise due to multi-core and 
					 * partitioning 
					 */
					EList<Assign> assignments = new BasicEList<Assign>();
					EList<Assign> compViewAssignments = new BasicEList<Assign>();
					try {
						// Assignments of components to processing units are in the Deployment View
						assignments = UMLUtils.getComponentAssignments(umlModel, Constants.DEPLOYMENT_VIEW_NAME);	
						// Assignments of components to functional partitions are in the Component View
						compViewAssignments = UMLUtils.getComponentAssignments(umlModel, Constants.COMPONENT_VIEW_NAME);						
						assignments.addAll(compViewAssignments);											
					} catch (ModelError e) {						
						System.out.println("ERROR in Model: "+e.getMessage());
						e.printStackTrace();
					}
					
					count = UMLUtils.isAssigned2HowManyProcessingUnitsOrPartitions(instSpec, assignments);		
					
				
//					Stereotype assignStereotype=null;
//					for (Comment comment : allAssignComment) {
//						assignStereotype = comment.getAppliedStereotype(Constants.ASSIGN);
//						if (assignStereotype!=null) {
//							//System.err.println("  - assign");
//							List<Object> from = (List<Object>) comment.getValue(assignStereotype, Constants.ASSIGN_FROM);
//							//System.err.println("  - from:" + from + "-" + instSpec);
//							//System.err.println("  - to  :" +comment.getValue(assign, Constants.ASSIGN_TO));
//							if (from.contains(instSpec)) {
//								//System.err.println("That's the one !");
//								
//								count++;
//							}
//						}
//					}
					// LB 20150917 end
					if (count!=1) {
						errorMsg = "The ComponentImplementation instance " + instSpec.getName() +" must be deployed on exactly one processing unit or functional partition. (Currently " + count +")";
						System.out.println(errorMsg);
					}
					
				}
			}
		}
	
		if (errorMsg != null){
			IStatus failure = ctx.createFailureStatus(
					instSpec,
					errorMsg
			);
			return failure;
		}
		
		return success;
		
	}
	
}			
