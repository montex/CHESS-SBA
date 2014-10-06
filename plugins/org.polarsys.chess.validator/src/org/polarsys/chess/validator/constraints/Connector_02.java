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

public class Connector_02 extends AbstractModelConstraint {

	private static final String FLOWPORT = "MARTE::MARTE_DesignModel::GCM::FlowPort";
	
	@Override
	public IStatus validate(IValidationContext ctx) {

		IStatus success = ctx.createSuccessStatus();
		IStatus failure = ctx.createFailureStatus();
		
		Connector con = (Connector) ctx.getTarget();
		
		ConnectorEnd firstEnd = con.getEnds().get(0);
		if(!(firstEnd.getRole() instanceof Port)){
			return failure;
		}
		
		Port firstPort = (Port) firstEnd.getRole();
		Stereotype firstStereo = firstPort.getAppliedStereotype(FLOWPORT);
		if(firstStereo == null){
			return success;
		}

		ConnectorEnd secondEnd = con.getEnds().get(1);
		if(!(secondEnd.getRole() instanceof Port)){
			return failure;
		}
		
		Port secondPort = (Port) secondEnd.getRole();
		Stereotype secondStereo = secondPort.getAppliedStereotype(FLOWPORT);
		if(secondStereo == null){
			return success;
		}		
		
		//check types
		if(!(firstPort.getType().equals(secondPort.getType()))){
			return failure;
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
			return failure;
		}
		
		//check mappings??? (maybe not needed)
//		EList<Dependency> firstDepList = firstPort.getClientDependencies();
//		EList<Dependency> secondDepList = secondPort.getClientDependencies();
		
		
		return success;
	}

}
