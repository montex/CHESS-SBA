/*
-----------------------------------------------------------------------
--                CHESS Live/Batch Validator plugin                  --
--                                                                   --
--                    Copyright (C) 2011-2012                        --
--                 University of Padova, ITALY                       --
--                                                                   --
-- 							                 --
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
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Type;
import org.polarsys.chess.chessmlprofile.util.Constants;
import org.polarsys.chess.core.util.uml.UMLUtils;

/**
 * The Class FlowPorts_02.
 * This class implements the following constraint (invoked by the EMF validation framework):
 * The FlowPort should be mapped to parameters of the same type
 */
public class FlowPorts_02 extends AbstractModelConstraint {

	/* (non-Javadoc)
	 * @see org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse.emf.validation.IValidationContext)
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {
		IStatus success = ctx.createSuccessStatus();
		IStatus failure = ctx.createFailureStatus();

		Port port = (Port) ctx.getTarget();
		if(port.getAppliedStereotype(Constants.FLOW_PORT) == null){
			return success;
		}
		
		Element owner = port.getOwner();
		if(!UMLUtils.isComponentType(owner)){
			return success;
		}

		/* if it is a flow port of a component type, each of its mapped parameters should have the same type as the port
		 * 
		 * note: creating a mapping will avoid this issue, but changing the type of the port
		 * or of another parameter at a different time is possible and will result in an erratic situation		
		 */
		Type portType = port.getType();
		EList<Dependency> dependencies = port.getClientDependencies();
		for (Dependency dep : dependencies) {
			if (dep instanceof Abstraction && dep.getAppliedStereotype(Constants.MARTE_ALLOCATE) != null){
				EList<NamedElement> suppList = dep.getSuppliers();
				for (NamedElement nElem : suppList) {
					if(nElem instanceof Parameter){
						Parameter param = (Parameter) nElem;
						if(param.getType() != portType){
							return failure;
						}
					}
				}
			}
		}
		return success;
	}

}
