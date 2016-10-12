/*******************************************************************************
 *
 * Copyright (c) 2013, 2015 Intecs SpA 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Nicholas Pacini nicholas.pacini@intecs.it 
 * Stefano Puri stefano.puri@intecs.it
 * Laura Baracchi  laura.baracchi@intecs.it  
 * Initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.polarsys.chess.contracts.validation;

import org.eclipse.emf.common.command.Command;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.services.validation.handler.AbstractCommandHandler;
import org.polarsys.chess.contracts.validation.command.CHESSContractValidateCommand;

public class CHESSContractValidationHandler extends AbstractCommandHandler {

	private CHESSContractValidateCommand foreverValidateCommand;
	
	@Override
	public Command getCommand() {
		String label = "Validate model for NuSMV3-OCRA analysis tool";
		foreverValidateCommand = new CHESSContractValidateCommand(label, Activator.PLUGIN_ID, getSelectedElement());
		return new GMFtoEMFCommandWrapper(foreverValidateCommand);
	}

}
