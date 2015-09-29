package org.polarsys.chess.validator.constraints;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.polarsys.chess.chessmlprofile.util.Constants;

/**
 * The Class Connector_02.
 * Check that flow ports on the ends of a connection have compatible directions 
 */
public class Connector_02 extends AbstractModelConstraint {

	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse.emf.validation.IValidationContext)
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {		
		
		Connector con = (Connector) ctx.getTarget();
		
		String thisElement = con.getName();
		//System.out.println("... Connector: "+thisElement);
		
		String errorMsg = "";
		
		IStatus success = ctx.createSuccessStatus();
		IStatus failure = ctx.createFailureStatus(
				thisElement,			  		
				errorMsg	
				); 
		
		ConnectorEnd firstEnd = con.getEnds().get(0);
		if(!(firstEnd.getRole() instanceof Port)){
			failure = ctx.createFailureStatus(
					thisElement,			  		
					errorMsg	
					); 
			return failure;
		}
		
		Port firstPort = (Port) firstEnd.getRole();
		Stereotype firstStereo = firstPort.getAppliedStereotype(Constants.FLOW_PORT);
		if(firstStereo == null){
			return success;
		}

		ConnectorEnd secondEnd = con.getEnds().get(1);
		if(!(secondEnd.getRole() instanceof Port)){
			failure = ctx.createFailureStatus(
					thisElement,			  		
					errorMsg	
					); 
			return failure;
		}
		
		Port secondPort = (Port) secondEnd.getRole();
		Stereotype secondStereo = secondPort.getAppliedStereotype(Constants.FLOW_PORT);
		if(secondStereo == null){
			return success;
		}		
		
		//check directions:
		//out -> in; in -> out; inout -> whatever
		String firstDir = firstPort.getValue(firstStereo, "direction").toString();
		String secondDir = secondPort.getValue(secondStereo, "direction").toString();
		
		if(!firstDir.equals("inout") && !(secondDir.equals("inout")) && firstDir.equals(secondDir)){
			//it's not an automatic failure if it's port delegation between parent and child
			if(firstEnd.getPartWithPort() == null || secondEnd.getPartWithPort() == null){
				return success;
			}
			if(firstEnd.getPartWithPort() instanceof Property || secondEnd.getPartWithPort() instanceof Property){
				Property prFirst = firstEnd.getPartWithPort();
				Property prSec = secondEnd.getPartWithPort();
				//check that the one of the properties contains the other
				if(prFirst.getType().getOwnedElements().contains(prSec) || prSec.getType().getOwnedElements().contains(prFirst)){
					return success;
				}
			}
			failure = ctx.createFailureStatus(
					thisElement,			  		
					errorMsg	
					); 
			return failure;
		}		
		
		return success;
	}

}
