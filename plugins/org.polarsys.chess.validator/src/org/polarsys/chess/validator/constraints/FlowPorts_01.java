package org.polarsys.chess.validator.constraints;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Port;
import org.polarsys.chess.core.util.uml.UMLUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class FlowPorts_01.
 */
public class FlowPorts_01 extends AbstractModelConstraint {

	/** The Constant FLOWPORT. */
	public static final String FLOWPORT = "MARTE::MARTE_DesignModel::GCM::FlowPort";
	
	/** The Constant ALLOCATE. */
	public static final String ALLOCATE = "MARTE::MARTE_Foundations::Alloc::Allocate";
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse.emf.validation.IValidationContext)
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {

		IStatus success = ctx.createSuccessStatus();
		IStatus failure = ctx.createFailureStatus();
			
		Port port = (Port) ctx.getTarget();
		if(port.getAppliedStereotype(FLOWPORT) == null){
			return success;
		}
		
		Element owner = port.getOwner();
		if(!UMLUtils.isComponentType(owner)){
			return success;
		}
		
		/* if it is a flow port of a component type it must have at least a mapping to a parameter 
		 * (the validity of such mapping is checked through other constraints)
		 */

		EList<Dependency> dependencies = port.getClientDependencies();
		for (Dependency dep : dependencies) {
			if (dep instanceof Abstraction && dep.getAppliedStereotype(ALLOCATE) != null){
				return success;
			}
		}
		return failure;
	}

}
