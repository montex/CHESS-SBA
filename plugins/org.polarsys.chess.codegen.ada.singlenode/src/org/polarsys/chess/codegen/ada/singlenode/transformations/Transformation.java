/*****************************************************************************
 * Copyright (c) 2011 - 2014 University of Padova.
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

package org.polarsys.chess.codegen.ada.singlenode.transformations;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ModelContent;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.uml2.uml.Model;
import org.polarsys.chess.core.util.CHESSProjectSupport;
import org.polarsys.chess.m2m.TransUtil;

@SuppressWarnings("restriction")
public class Transformation {
	
	
	public static void performCodeGeneration(final PapyrusMultiDiagramEditor editor, IFile model, IProgressMonitor monitor) throws Exception {

		ModelContent mc = TransUtil.loadModel(model);
		final Model mi = (Model) mc.getContent().get(0);
		
		checkTransformationConditions(mi);

		String codeGenDir = TransUtil.CODEGEN_DIR + "_singlenode_" + mi.getName();

		IFolder srcDir = model.getProject().getFolder(codeGenDir);
		
		CHESSProjectSupport.bundleToProjectCopy(org.polarsys.chess.codegen.ada.singlenode.Activator.PLUGIN_ID, org.polarsys.chess.codegen.ada.singlenode.Activator.getDefault(), "src-lib", model.getProject(), codeGenDir, false);

  		CHESSProjectSupport.createFolder(model.getProject().getFolder(codeGenDir + "/obj"));

		AcceleoCodeGen.runCodegen(model/*Copy*/, srcDir, monitor);
	}

	private static void checkTransformationConditions(Model model)  throws Exception  {
		TransformationConditions.check(model);
	}
}