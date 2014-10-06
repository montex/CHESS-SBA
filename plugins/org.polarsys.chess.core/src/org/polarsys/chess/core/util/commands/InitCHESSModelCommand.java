package org.polarsys.chess.core.util.commands;

import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.uml.tools.model.UmlUtils;
import org.eclipse.uml2.uml.Model;
import org.polarsys.chess.core.extensionpoint.AddProfileHandler;
import org.polarsys.chess.core.views.commands.CreateViewsCommand;

public class InitCHESSModelCommand extends RecordingCommand {

	private ModelSet modelSet;

	public InitCHESSModelCommand(TransactionalEditingDomain editingDomain, ModelSet modelSet) {
			super(editingDomain);
			this.modelSet = modelSet;
	}
	
	@Override
	protected void doExecute() {
		//CHESSProfileManager chess = new CHESSProfileManager(modelSet);
		//MARTEProfileManager marte = MARTEProfileManager.loadMARTEProfile(modelSet);
		//SysMLProfileManager sysml = SysMLProfileManager.loadSysMLProfile(modelSet);
		
		EObject  owner = getRootElement(UmlUtils.getUmlResource(modelSet));
		CreateViewsCommand.viewsToModel((Model)owner, modelSet/*, chess, marte, sysml*/);	
		
		//let external plugins to add additional profiles
		AddProfileHandler h = new AddProfileHandler();
		IExtensionRegistry reg =  Platform.getExtensionRegistry();
		h.executeAddProfile(reg, (Model)owner, modelSet);
		
	}
	
	protected EObject getRootElement(Resource modelResource) {
		EObject rootElement = null;
		if(modelResource != null && modelResource.getContents() != null && modelResource.getContents().size() > 0) {
			Object root = modelResource.getContents().get(0);
			if(root instanceof EObject) {
				rootElement = (EObject)root;
			}
		}
		return rootElement;
	}

}
