/*
-----------------------------------------------------------------------
--                CHESS Live/Batch Validator plugin                  --
--                                                                   --
--                    Copyright (C) 2016                        --
--                 Intecs spa, ITALY                       --
--                                                                   --
-- Author: Laura Baracchi								                 --
--                                                                   --
-- All rights reserved. This program and the accompanying materials  --
-- are made available under the terms of the Eclipse Public License  --
-- v1.0 which accompanies this distribution, and is available at     --
-- http://www.eclipse.org/legal/epl-v10.html                         --
-----------------------------------------------------------------------
 */
package org.polarsys.chess.validator.constraints;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.ARINCProcess;
import org.polarsys.chess.chessmlprofile.util.Constants;

/**
 * The Class ArincProc_01.
 * This class implements the following constraint (invoked by the EMF validation framework):
 * The ARINCProcess must have its OperationsGroups not null and not empty
 * @since 0.10
 */
public class ArincProc_01 extends AbstractModelConstraint {

	/* (non-Javadoc)
	 * @see org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse.emf.validation.IValidationContext)
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObject = ctx.getTarget();

		Operation operation = (Operation)eObject;

		IStatus success = ctx.createSuccessStatus();

		String arincProcessName = "";
		String ownerComponentName = "";

		if (operation.getAppliedStereotype(Constants.CH_ARINCProcess) != null ) {
			if (operation.getName() != null) {
				arincProcessName = operation.getName();
			}
			Stereotype arincProcessStereo = operation.getAppliedStereotype(Constants.CH_ARINCProcess);
			ARINCProcess arincProcess = (ARINCProcess) operation.getStereotypeApplication(arincProcessStereo);
			String opGroupsString = arincProcess.getOperationsGroups();
			if (opGroupsString == null || opGroupsString.isEmpty() || opGroupsString.length() == 0) {
				// Get the name of the owner of the ARINCProcess with NULL or empty OperationsGroups 
				Element theOwner = operation.getOwner();
				if (theOwner instanceof Component) {
					if (((Component)theOwner).getName()!=null) {
						ownerComponentName = ((Component)theOwner).getName();
					}
				}
				
				String errorMsg = "The <<ARINCProcess>> [" + arincProcessName + "] in ["+ownerComponentName+"] must have OperationsGroups not empty and not NULL";
				IStatus failure = ctx.createFailureStatus(
						operation,
						errorMsg
						);
				return failure;
			}
			else {				
				return success;
			}
		}
		else {
			return success;		
		}
	}
}			
