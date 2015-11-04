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
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.ClientServerKind;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.ClientServerPort;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.polarsys.chess.chessmlprofile.util.Constants;

/**
 * The Class Connector_01.
 * Check if Interfaces provided and/or required in Ports are not compatible, or components are not at the same level
 */
public class Connector_01 extends AbstractModelConstraint {

	/* (non-Javadoc)
	 * @see org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse.emf.validation.IValidationContext)
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {
		IStatus success = ctx.createSuccessStatus();
				
		Connector con = (Connector) ctx.getTarget();
		
		String thisElement = "";
		thisElement = con.getName();
		
		String errorMsg = "";
		IStatus failure = ctx.createFailureStatus(
				thisElement,			  		
				errorMsg	
				); 
		
		try{
			//check that ports are compatible (provided-required)
			ConnectorEnd ceFir = con.getEnds().get(0);
			if(!(ceFir.getRole() instanceof Port)){
				errorMsg = "First end is not a port";
				failure = ctx.createFailureStatus(
						thisElement,			  		
						errorMsg	
						);
				return failure;
			}
			Port portFir = (Port) ceFir.getRole();
			//Stereotype sFirst = portFir.getAppliedStereotype(Constants.CLIENTSERVER_PORT);
			Stereotype clientServerPortStereo1 = portFir.getAppliedStereotype(Constants.CLIENTSERVER_PORT);
			if(clientServerPortStereo1 == null){				
				return success;
			}
			
			ClientServerPort clientServerPort1 = (ClientServerPort) portFir.getStereotypeApplication(clientServerPortStereo1);
			ClientServerKind kind1 = clientServerPort1.getKind();
			
			//String first = portFir.getValue(sFirst, Constants.CSPORT_KIND).toString();
			ConnectorEnd ceSec = con.getEnds().get(1);
			if(!(ceSec.getRole() instanceof Port)){
				errorMsg = "Second end is not a port";
				failure = ctx.createFailureStatus(
						thisElement,			  		
						errorMsg	
						);
				return failure;
			}
			Port portSec = (Port) ceSec.getRole();
			Stereotype clientServerPortStereo2 = portSec.getAppliedStereotype(Constants.CLIENTSERVER_PORT);
			if(clientServerPortStereo2 == null){
				return success;
			}
			ClientServerPort clientServerPort2 = (ClientServerPort)portSec.getStereotypeApplication(clientServerPortStereo2);
			ClientServerKind kind2 = clientServerPort2.getKind();
			
			if(kind1.equals(kind2)){
				//it's not an automatic failure if it's port delegation between parent and child
				if(ceFir.getPartWithPort() == null || ceSec.getPartWithPort() == null){
					return success;
				}
				if(ceFir.getPartWithPort() instanceof Property || ceSec.getPartWithPort() instanceof Property){
					Property prFirst = ceFir.getPartWithPort();
					Property prSec = ceSec.getPartWithPort();
					//check that the one of the properties contains the other
					if(prFirst.getType().getOwnedElements().contains(prSec) || 
							prSec.getType().getOwnedElements().contains(prFirst)){
						return success;
					}
				}
				errorMsg = "Port directions are not compatible.";
				failure = ctx.createFailureStatus(
						thisElement,			  		
						errorMsg	
						);
				return failure;
			}
			//check that the ports are owned by components at the "same level" (no parent-child)
			if (ceFir.getPartWithPort()  == null || ceSec.getPartWithPort() == null){
				return failure;
			}
			
			//check that interfaces provided/required are compatible (i.e the same interface or the provided can be a subtype of the required)
			Interface iFirst = null, iSecond = null;
			//if (first.equals(Constants.CSPORT_KIND_PROVIDED)){
			if (kind1.equals(ClientServerKind.PROVIDED)) {
				//iFirst = (Interface)((EObjectResolvingEList) portFir.getValue(clientServerPort1, "provInterface")).get(0);
				iFirst = clientServerPort1.getProvInterface().get(0);
			} else if(kind1.equals(ClientServerKind.REQUIRED)){
				//iFirst = (Interface)((EObjectResolvingEList) portFir.getValue(sFirst, "reqInterface")).get(0);
				iFirst = clientServerPort1.getReqInterface().get(0);
			}
			else if(kind1.equals(ClientServerKind.PROREQ)) {
				// this is managed by constraint FV_07
				return success;
			}
			if (kind2.equals(ClientServerKind.PROVIDED)){
				//iSecond =  (Interface)((EObjectResolvingEList) portSec.getValue(sSecond, "provInterface")).get(0);
				iSecond =  clientServerPort2.getProvInterface().get(0);
			} else if(kind2.equals(ClientServerKind.REQUIRED)){
				//iSecond =  (Interface)((EObjectResolvingEList) portSec.getValue(sSecond, "reqInterface")).get(0);
				iSecond = clientServerPort2.getReqInterface().get(0);
			}
			else if(kind2.equals(ClientServerKind.PROREQ)) {
				// this is managed by constraint FV_07
				return success;
			}
			//if they are different it's ok only if the Provided interface inherits the Required Interface
			if(!iFirst.equals(iSecond)){
				if(kind1.equals(ClientServerKind.PROVIDED)){
					if(!iFirst.allParents().contains(iSecond)){
						errorMsg = "Interface types are not compatible.";
						failure = ctx.createFailureStatus(
								thisElement,			  		
								errorMsg	
								);
						return failure;
					}
				}else if(kind2.equals(ClientServerKind.PROVIDED)){
					if(!iSecond.allParents().contains(iFirst)){
						errorMsg = "Interface types are not compatible.";
						failure = ctx.createFailureStatus(
								thisElement,			  		
								errorMsg	
								);
						return failure;
					}
				}
			}
			
			return success;
		}
		catch(IndexOutOfBoundsException e){
			errorMsg= e.toString();
			failure = ctx.createFailureStatus(
					thisElement,			  		
					errorMsg	
					);
			return failure;
		}
	}

}
