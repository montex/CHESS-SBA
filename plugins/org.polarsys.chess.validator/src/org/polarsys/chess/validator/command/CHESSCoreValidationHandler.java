/*******************************************************************************
 * Copyright (c) 2015 Intecs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Stefano Puri, stefano.puri@intecs.it
 *******************************************************************************/
package org.polarsys.chess.validator.command;

import org.eclipse.emf.common.command.Command;
import org.eclipse.papyrus.infra.services.validation.handler.AbstractCommandHandler;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;


public class CHESSCoreValidationHandler extends AbstractCommandHandler {

	@Override
	protected Command getCommand() {
		String label = "Validate core constraints for the CHESS model";
		return new GMFtoEMFCommandWrapper(new ChessGenericValidateCommand(label, org.polarsys.chess.validator.Activator.PLUGIN_ID, getSelectedElement()));
	}

}
