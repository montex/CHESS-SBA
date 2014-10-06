package org.polarsys.chess.m2m.blackbox;

import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation.Kind;
import org.eclipse.m2m.qvt.oml.util.IContext;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityFinalNode;
import org.eclipse.uml2.uml.InitialNode;
import org.eclipse.uml2.uml.OpaqueAction;
import org.eclipse.uml2.uml.UMLFactory;

public class Java4QVTutils {
	/**
	 * 
	 */
	@Operation(kind = Kind.HELPER, contextual = true, withExecutionContext = true)
	public  static InitialNode createInitialNode(IContext context, Activity act) {
	
		InitialNode tempNode = UMLFactory.eINSTANCE.createInitialNode();
		InitialNode initNode = (InitialNode) act.createOwnedNode("InitialNode1", tempNode.eClass());
		return initNode;
		

	}// end createInitialNode
	
	/**
	 * 
	 */
	@Operation(kind = Kind.HELPER, contextual = true, withExecutionContext = true)
	public  static ActivityFinalNode createFinalNode(IContext context, Activity act) {
	
		ActivityFinalNode tempNode = UMLFactory.eINSTANCE.createActivityFinalNode();
		ActivityFinalNode finalNode = (ActivityFinalNode) act.createOwnedNode("ActivityFinalNode1", tempNode.eClass());
		return finalNode;
		

	}// end createFinalNode
	
	/**
	 * 
	 */
	@Operation(kind = Kind.HELPER, contextual = true, withExecutionContext = true)
	public  static OpaqueAction createOpaqueAction(IContext context, Activity act, String name) {
	
		OpaqueAction tempNode = UMLFactory.eINSTANCE.createOpaqueAction();
		OpaqueAction op = (OpaqueAction) act.createOwnedNode(name, tempNode.eClass());
		return op;
		

	}// end createOpaqueAction
	
}
