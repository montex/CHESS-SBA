/*
-----------------------------------------------------------------------
--                CHESS Live/Batch Validator plugin                  --
--                                                                   --
--                    Copyright (C) 2011-2012                        --
--                 University of Padova, ITALY                       --
--                                                                   --
-- Author: Nicholas Pacini         									 --
--                                                                   --
-- All rights reserved. This program and the accompanying materials  --
-- are made available under the terms of the Eclipse Public License  --
-- v1.0 which accompanies this distribution, and is available at     --
-- http://www.eclipse.org/legal/epl-v10.html                         --
-----------------------------------------------------------------------
*/
package org.polarsys.chess.validator.constraints;


import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

// TODO: Auto-generated Javadoc
/**
 * The Class Connector_01.
 */
public class Connector_01 extends AbstractModelConstraint {

	/** The Constant CSPORT. */
	private static final String CSPORT = "MARTE::MARTE_DesignModel::GCM::ClientServerPort";

	/* (non-Javadoc)
	 * @see org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse.emf.validation.IValidationContext)
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {
		IStatus success = ctx.createSuccessStatus();
		IStatus failure = ctx.createFailureStatus();
		
		Connector con = (Connector) ctx.getTarget();
		try{
			//check that ports are compatible (provided-required)
			ConnectorEnd ceFir = con.getEnds().get(0);
			if(!(ceFir.getRole() instanceof Port)){
				return failure;
			}
			Port portFir = (Port) ceFir.getRole();
			Stereotype sFirst = portFir.getAppliedStereotype(CSPORT);
			if(sFirst == null){
				return success;
			}
			String first = portFir.getValue(sFirst, "kind").toString();
			ConnectorEnd ceSec = con.getEnds().get(1);
			if(!(ceSec.getRole() instanceof Port)){
				return failure;
			}
			Port portSec = (Port) ceSec.getRole();
			Stereotype sSecond = portSec.getAppliedStereotype(CSPORT);
			if(sSecond == null){
				return success;
			}
			String second = portSec.getValue(sSecond, "kind").toString();
			if(first.equals(second)){
				//it's not an automatic failure if it's port delegation between parent and child
				if(ceFir.getPartWithPort() == null || ceSec.getPartWithPort() == null){
					return success;
				}
				if(ceFir.getPartWithPort() instanceof Property || ceSec.getPartWithPort() instanceof Property){
					Property prFirst = ceFir.getPartWithPort();
					Property prSec = ceSec.getPartWithPort();
					//check that the one of the properties contains the other
					if(prFirst.getType().getOwnedElements().contains(prSec) || prSec.getType().getOwnedElements().contains(prFirst)){
						return success;
					}
				}
				
				return failure;
			}
			//check that the ports are owned by components at the "same level" (no parent-child)
			if (ceFir.getPartWithPort()  == null || ceSec.getPartWithPort() == null){
				return failure;
			}
			
			//check that interfaces provided/required are compatible (i.e the same interface or the provided can be a subtype of the required)
			Interface iFirst = null, iSecond = null;
			if (first.equals("provided")){
				iFirst = (Interface)((EObjectResolvingEList) portFir.getValue(sFirst, "provInterface")).get(0);
			} else if(first.equals("required")){
				iFirst = (Interface)((EObjectResolvingEList) portFir.getValue(sFirst, "reqInterface")).get(0);
			}
			if (second.equals("provided")){
				iSecond =  (Interface)((EObjectResolvingEList) portSec.getValue(sSecond, "provInterface")).get(0);
			} else if(second.equals("required")){
				iSecond =  (Interface)((EObjectResolvingEList) portSec.getValue(sSecond, "reqInterface")).get(0);
			}
			//if they are different it's ok only if the Provided interface inherits the Required Interface
			if(!iFirst.equals(iSecond)){
				if(first.equals("provided")){
					if(!iFirst.allParents().contains(iSecond)){
						return failure;
					}
				}else if(second.equals("provided")){
					if(!iSecond.allParents().contains(iFirst)){
						return failure;
					}
				}
			}
			
			return success;
		}catch(IndexOutOfBoundsException e){
			return failure;
		}
	}

}
