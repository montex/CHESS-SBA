/*
-----------------------------------------------------------------------
--          			CHESS core plugin							 --
--                                                                   --
--                    Copyright (C) 2011-2012                        --
--                 University of Padova, ITALY                       --
--                                                                   --
-- Authors: Alessandro Zovi         azovi@math.unipd.it 		     --
--			Stefano Puri											 --
--                                                                   --
-- All rights reserved. This program and the accompanying materials  --
-- are made available under the terms of the Eclipse Public License  --
-- v1.0 which accompanies this distribution, and is available at     --
-- http://www.eclipse.org/legal/epl-v10.html                         --
-----------------------------------------------------------------------
*/

package org.polarsys.chess.core.views.commands;

import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.uml.tools.model.UmlUtils;
import org.eclipse.uml2.uml.Model;
import org.polarsys.chess.core.extensionpoint.AddProfileHandler;
import org.polarsys.chess.core.profiles.CHESSProfileManager;
import org.polarsys.chess.core.profiles.MARTEProfileManager;
import org.polarsys.chess.core.profiles.SysMLProfileManager;
import org.polarsys.chess.core.util.uml.ResourceUtils;


public class CreateViewsCommand extends RecordingCommand {

	private ModelSet modelSet;
	//private DiResourceSet resourceSet;

	public CreateViewsCommand(ModelSet rs) {
		super(rs.getTransactionalEditingDomain());
		this.modelSet = rs;
	}

	/*public CreateViewsCommand(DiResourceSet rs) {
		super(rs.getTransactionalEditingDomain());
		this.resourceSet = rs;
	}*/

	@Override
	protected void doExecute() {
		Model currentModel = null;
		CHESSProfileManager chess = null;
		MARTEProfileManager marte = null;
		SysMLProfileManager sysml = null;
		if (modelSet != null) {
			currentModel = ResourceUtils.getModel(UmlUtils.getUmlModel(modelSet)
					.getResource());
			chess = new CHESSProfileManager(modelSet);
			//marte = MARTEProfileManager.loadMARTEProfile(modelSet);
			//sysml = SysMLProfileManager.loadSysMLProfile(modelSet);

		} /*else {
			currentModel = UMLUtils.getModel(resourceSet.getModelResource());
			chess = CHESSProfileManager.loadCHESSProfile(resourceSet);
			marte = MARTEProfileManager.loadMARTEProfile(resourceSet);
			sysml = SysMLProfileManager.loadSysMLProfile(resourceSet);
		}*/

		viewsToModel(currentModel, modelSet/*, chess, marte, sysml*/);
		
	}

	public static void viewsToModel(Model currentModel/*, CHESSProfileManager chess,
			MARTEProfileManager marte, SysMLProfileManager sysml*/, ModelSet mset) {
		
		CHESSProfileManager.createModel(currentModel);
		
		
		MARTEProfileManager.createModel(currentModel);
		
		
		SysMLProfileManager.createModel(currentModel);
		
		AddProfileHandler h = new AddProfileHandler();
		IExtensionRegistry reg =  Platform.getExtensionRegistry();
		h.executeAddProfile(reg, currentModel, mset);
		
	}
	

}
