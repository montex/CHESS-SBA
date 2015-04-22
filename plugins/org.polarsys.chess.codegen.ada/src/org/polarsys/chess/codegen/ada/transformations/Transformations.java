/*****************************************************************************
 * Copyright (c) 2011 - 2015 University of Padova.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Alessandro Zovi
 *
 *****************************************************************************/

package org.polarsys.chess.codegen.ada.transformations;

import org.polarsys.chess.codegen.ada.Activator;
import org.polarsys.chess.core.util.CHESSProjectSupport;
import org.polarsys.chess.m2m.TransUtil;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ModelContent;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.uml2.uml.Model;

@SuppressWarnings("restriction")
public class Transformations {
	
	
	public static void performCodeGeneration(final PapyrusMultiDiagramEditor editor, IFile model, IProgressMonitor monitor) throws Exception {

		ModelContent mc = TransUtil.loadModel(model);
		final Model mi = (Model) mc.getContent().get(0);
		
//		TransactionalEditingDomain editingDomain = editor.getServicesRegistry().getService(ModelSet.class).getTransactionalEditingDomain();		
//		final InternalValidator v = new InternalValidator(mi, editingDomain);	
//		int res = InternalValidator.GUI.validate(editor, v, mi);
//		if (res != 0)
//			return;

		String codeGenDir = TransUtil.CODEGEN_DIR + "_" + mi.getName();
//		IFolder transDir = model.getProject().getFolder(TransUtil.PIM_PSM_DIR);
		IFolder srcDir = model.getProject().getFolder(codeGenDir);
		
		CHESSProjectSupport.bundleToProjectCopy(org.polarsys.chess.codegen.ada.Activator.PLUGIN_ID, org.polarsys.chess.codegen.ada.Activator.getDefault(), "src-lib", model.getProject(), codeGenDir, false);
		// Delete the working dir if it exists
//		CHESSProjectSupport.deleteFolder(transDir);
		
//  		CHESSProjectSupport.createFolder(transDir);
  		
  		CHESSProjectSupport.createFolder(model.getProject().getFolder(codeGenDir + "/obj"));
  	    // Work on a copy of the model
//		IFile modelCopy = CHESSProjectSupport.copyFile(model, TransUtil.PIM_PSM_DIR, model.getName());
		
		// Remove the content of the RtAnalysisPackage
//		TransUtil.purgeModel(modelCopy);
		
		//TODO enable the transformation when it works
		// Execute the various steps of the transformations
		//QVToTransformation.launchPIM2PSM(modelCopy, monitor);
		
//		QVToTransformation.launchCeilingAssignment(modelCopy, monitor);
		
		// Replace the input model file with the transformed model
		//CHESSProjectSupport.fileReplace(modelCopy, model);
		
		AcceleoCodeGen.runCodegen(model/*Copy*/, srcDir, monitor);
		
		// Finally delete the working dir
//		CHESSProjectSupport.deleteFolder(transDir);
	}
}