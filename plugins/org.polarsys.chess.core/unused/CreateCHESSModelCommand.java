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

import it.unipd.chess.extensionpoint.AddProfileHandler;
import it.unipd.chess.profiles.CHESSProfileManager;
import it.unipd.chess.profiles.MARTEProfileManager;
import it.unipd.chess.profiles.SysMLProfileManager;
import it.unipd.chess.views.commands.CreateViewsCommand;

import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.uml.diagram.common.commands.CreateUMLModelCommand;
import org.eclipse.uml2.uml.Model;

@Deprecated
public class CreateCHESSModelCommand extends CreateUMLModelCommand {

	ModelSet resourceSet;
	
	public CreateCHESSModelCommand(ModelSet resourceSet) {
		this.resourceSet = resourceSet;
	}
	
	@Override
	protected void initializeModel(EObject owner) {
		super.initializeModel(owner);
		
		CHESSProfileManager chess = CHESSProfileManager.loadCHESSProfile(resourceSet);
		MARTEProfileManager marte = MARTEProfileManager.loadMARTEProfile(resourceSet);
		SysMLProfileManager sysml = SysMLProfileManager.loadSysMLProfile(resourceSet);
		CreateViewsCommand.viewsToModel((Model)owner, chess, marte, sysml);
		
		AddProfileHandler h = new AddProfileHandler();
		IExtensionRegistry reg =  Platform.getExtensionRegistry();
		h.executeAddProfile(reg, (Model)owner, resourceSet);
	}
}
