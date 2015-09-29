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

// TODO: Auto-generated Javadoc
/**
 * The Class Connector_03.
 * Check that flow ports on the ends of a connection are compatible in type
 */
public class Connector_03 extends AbstractModelConstraint {

	/** The Constant FLOWPORT. */
	private static final String FLOWPORT = "MARTE::MARTE_DesignModel::GCM::FlowPort";
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse.emf.validation.IValidationContext)
	 */
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
		// LB 20150911 Check that types of flowPorts at the ends of a Connector must be identical
		// actually for SysML we should also accept the situation where the type of the destination FlowPort
		// contains the type of the source FlowPort. For this reason in case of different types we only generate a Warning
		System.out.println("Prima del controllo sui tipo delle FlowPort");
		if(!(firstPort.getType().equals(secondPort.getType()))){
			System.out.println("Eccomi qui");
			return failure;
		}
				
		return success;
	}

}
