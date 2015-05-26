package org.polarsys.chess.validator.constraints;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Port;
import org.polarsys.chess.core.util.uml.UMLUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class FlowPorts_03.
 */
public class FlowPorts_03 extends AbstractModelConstraint {

	/* (non-Javadoc)
	 * @see org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse.emf.validation.IValidationContext)
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {
		IStatus success = ctx.createSuccessStatus();
		IStatus failure = ctx.createFailureStatus();

		Port port = (Port) ctx.getTarget();
		if(port.getAppliedStereotype(FlowPorts_01.FLOWPORT) == null){
			return success;
		}
		
		Element owner = port.getOwner();
		if(!UMLUtils.isComponentType(owner)){
			return success;
		}
		
		/* if it is a flow port of a component type, each of its mapped parameters should have the direction consistent. ie:
		 * port direction IN -> param direction IN or INOUT (param of PROVIDED operation)
		 * port direction OUT -> param direction OUT or INOUT (param of PROVIDED operation)
		 * port direction IN -> param direction OUT or INOUT (param of REQUIRED operation)
		 * port direction OUT -> param direction IN or INOUT (param of REQUIRED operation)
		 * port direction INOUT -> param direction IN or OUT orINOUT (param of REQUIRED or PROVIDED operation)
		 * note: creating a mapping will avoid this issue, but changing the direction of the port
		 * or of another parameter at a different time is possible and may result in an erratic situation
		 */	
		Component comp = (Component) owner;
		String portDirection = port.getValue(port.getAppliedStereotype(FlowPorts_01.FLOWPORT), "direction").toString();
		EList<Dependency> dependencies = port.getClientDependencies();
		for (Dependency dep : dependencies) {
			if (dep instanceof Abstraction && dep.getAppliedStereotype(FlowPorts_01.ALLOCATE) != null){
				EList<NamedElement> suppList = dep.getSuppliers();
				for (NamedElement nElem : suppList) {
					if(nElem instanceof Parameter){
						Parameter param = (Parameter) nElem;
						String paramDirection =	param.getDirection().toString();
						Operation op = param.getOperation();
						if(provided(op, comp)){
							if((portDirection.equals("in") && paramDirection.equals("out")) ||
							   (portDirection.equals("out") && paramDirection.equals("in"))){
								return failure;
							}
						}else{
							if((portDirection.equals("in") && paramDirection.equals("in")) ||
							   (portDirection.equals("out") && paramDirection.equals("out"))){
								return failure;	
							}
						}
					}
				}
			}
		}
		
		return null;
	}

	/**
	 * Provided.
	 *
	 * @param op the op
	 * @param comp the comp
	 * @return true, if successful
	 */
	private boolean provided(Operation op, Component comp) {
		boolean provided = false;
		for (Operation operation : comp.getAllOperations()) {
			if(operation.getName().equals(op.getName())){
				provided = true;
				break;
			}
		}
		return provided;
	}

}
