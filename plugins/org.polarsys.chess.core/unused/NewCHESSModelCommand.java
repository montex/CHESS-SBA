/*
-----------------------------------------------------------------------
--          			CHESS core plugin							 --
--                                                                   --
--                    Copyright (C) 2011-2012                        --
--                 University of Padova, ITALY                       --
--                                                                   --
-- Author: Alessandro Zovi         azovi@math.unipd.it 		         --
--                                                                   --
-- All rights reserved. This program and the accompanying materials  --
-- are made available under the terms of the Eclipse Public License  --
-- v1.0 which accompanies this distribution, and is available at     --
-- http://www.eclipse.org/legal/epl-v10.html                         --
-----------------------------------------------------------------------
*/

package it.unipd.chess.util.commands;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.papyrus.infra.core.utils.DiResourceSet;


public class NewCHESSModelCommand extends RecordingCommand {
	private final DiResourceSet myDiResourceSet;

	private final IFile myFile;

	/**
	 * Instantiates a new new papyrus model command.
	 *
	 * @param diResourceSet the di resource set
	 * @param newFile the new file
	 */
	public NewCHESSModelCommand(DiResourceSet diResourceSet, IFile newFile) {
		super(diResourceSet.getTransactionalEditingDomain());
		myDiResourceSet = diResourceSet;
		myFile = newFile;
	}

	@Override
	protected void doExecute() {
		myDiResourceSet.createsModels(myFile);
	}


}
