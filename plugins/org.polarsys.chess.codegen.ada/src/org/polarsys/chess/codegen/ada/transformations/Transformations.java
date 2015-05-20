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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ModelContent;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.uml2.uml.Model;
import org.polarsys.chess.core.util.CHESSProjectSupport;
import org.polarsys.chess.m2m.TransUtil;

/**
 * The Class Transformations.
 */
@SuppressWarnings("restriction")
public class Transformations {
	
	
	/**
	 * Load the model, sets up the environment and performs the Ada code generation.
	 *
	 * @param editor the editor
	 * @param model the model
	 * @param monitor the monitor
	 * @throws Exception the exception
	 */
	public static void performCodeGeneration(final PapyrusMultiDiagramEditor editor, IFile model, IProgressMonitor monitor) throws Exception {

		ModelContent mc = TransUtil.loadModel(model);
		final Model mi = (Model) mc.getContent().get(0);
		
		String codeGenDir = TransUtil.CODEGEN_DIR + "_" + mi.getName();

		IFolder srcDir = model.getProject().getFolder(codeGenDir);
		
		CHESSProjectSupport.bundleToProjectCopy(org.polarsys.chess.codegen.ada.Activator.PLUGIN_ID, org.polarsys.chess.codegen.ada.Activator.getDefault(), "src-lib", model.getProject(), codeGenDir, false);
  		
  		CHESSProjectSupport.createFolder(model.getProject().getFolder(codeGenDir + "/obj"));

		AcceleoCodeGen.runCodegen(model/*Copy*/, srcDir, monitor);
		

	}
}