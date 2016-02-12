/*******************************************************************************
 *  * Copyright (c) 2015 University of Padova, Intecs
 *  *
 *  *    
 *  * All rights reserved. This program and the accompanying materials
 *  * are made available under the terms of the Eclipse Public License v1.0
 *  * which accompanies this distribution, and is available at
 *  * http://www.eclipse.org/legal/epl-v10.html
 *  *
 *******************************************************************************/
package org.polarsys.chess.m2m.blackbox;

import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation.Kind;
import org.eclipse.m2m.qvt.oml.util.IContext;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityFinalNode;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.InitialNode;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.OpaqueAction;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtPortSlot;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification;
import org.polarsys.chess.chessmlprofile.util.Constants;
import org.polarsys.chess.core.util.uml.ModelError;
import org.polarsys.chess.core.util.uml.UMLUtils;


/**
 * Utility class for QVT-o transformation
 */
public class Java4QVTutils {
	
	/**
	 * Creates the activity initial node.
	 *
	 * @param context the QVT context
	 * @param act the parent Activity
	 * @return the created initial node
	 */
	@Operation(kind = Kind.HELPER, contextual = true, withExecutionContext = true)
	public  static InitialNode createInitialNode(IContext context, Activity act) {
	
		InitialNode tempNode = UMLFactory.eINSTANCE.createInitialNode();
		InitialNode initNode = (InitialNode) act.createOwnedNode("InitialNode1", tempNode.eClass());
		return initNode;
		

	}// end createInitialNode
	
	/**
	 * Creates the activity final node.
	 *
	 * @param context the QVT context
	 * @param act the parent Activity
	 * @return the created activity final node
	 */
	@Operation(kind = Kind.HELPER, contextual = true, withExecutionContext = true)
	public  static ActivityFinalNode createFinalNode(IContext context, Activity act) {
	
		ActivityFinalNode tempNode = UMLFactory.eINSTANCE.createActivityFinalNode();
		ActivityFinalNode finalNode = (ActivityFinalNode) act.createOwnedNode("ActivityFinalNode1", tempNode.eClass());
		return finalNode;
		

	}// end createFinalNode
	
	/**
	 * Creates the opaque action.
	 *
	 * @param context the QVT context
	 * @param act the parent Activity
	 * @param name the name of the opaque action to be created
	 * @return the created opaque action
	 */
	@Operation(kind = Kind.HELPER, contextual = true, withExecutionContext = true)
	public  static OpaqueAction createOpaqueAction(IContext context, Activity act, String name) {
	
		OpaqueAction tempNode = UMLFactory.eINSTANCE.createOpaqueAction();
		OpaqueAction op = (OpaqueAction) act.createOwnedNode(name, tempNode.eClass());
		return op;
		

	}// end createOpaqueAction
	
	/**
	 * Gets the root instance.
	 *
	 * @param context the context
	 * @param self the self
	 * @return the context from constraint
	 */
	@Operation(kind = Kind.HELPER, contextual = true, withExecutionContext = true)
	public  static InstanceSpecification getRootInstanceInPackage(IContext context, Package self) {
		return UMLUtils.getRootInstanceInPackage(self);
	}
	
	/**
	 * Updates the occKind property for the CHRtSpecification decorating an ARINCFunction.
	 * An ARINFFunction derives its period from the owning ARINCProcess.
	 *
	 * @param context the context
	 * @param self the InstanceSpecification instance of ARINCComponentImpl
	 * @param comment The Comment with the CHRTSpecification decorating the ARINCFunction
	 * @return 
	 * @throws ModelError 
	 */
	@Operation(kind = Kind.HELPER, contextual = true, withExecutionContext = true)
	public static void getUpdatedArincFunChrtSpec(IContext context, 
			InstanceSpecification self,	Comment comment)  {
		
		CHRtSpecification chrtspec = (CHRtSpecification) comment.getStereotypeApplication(
				comment.getAppliedStereotype(Constants.CHRT_SPECIFICATION)
				);
		
		try {
			UMLUtils.getUpdatedArincFunChrtSpec(self, chrtspec);
		} catch (ModelError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
}
