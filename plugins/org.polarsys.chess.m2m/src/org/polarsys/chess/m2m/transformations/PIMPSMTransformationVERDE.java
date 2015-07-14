/*
-----------------------------------------------------------------------
--          			CHESS M2M plugin							 --
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

package org.polarsys.chess.m2m.transformations;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.polarsys.chess.m2m.backpropagation.BackpropagationFullVERDE;

/**
 * Allows to launch the PIM to PSM transformation for schedulability analysis.
 */
public class PIMPSMTransformationVERDE extends AbstractTransformation {
	
	
	/* 
	 * @see org.polarsys.chess.m2m.transformations.AbstractTransformation#launchPIM2PSMtransformation(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.resources.IFile)
	 */
	@Override
	protected void launchPIM2PSMtransformation(IProgressMonitor monitor, IFile modelCopy)
			throws Exception {
		QVToTransformation.launchTransformation(TransUtil.QVTO_PIM2PSMVERDE, "CHESS_PIM2PSMVERDE", true, modelCopy, monitor, configProperty);
	}

	/* (non-Javadoc)
	 * @see org.polarsys.chess.m2m.transformations.AbstractTransformation#backpropagation(org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor, org.eclipse.core.resources.IFile)
	 */
	@Override
	protected void backpropagation(PapyrusMultiDiagramEditor editor, IFile modelCopy)
			throws Exception {
		BackpropagationFullVERDE.processQVTOTraceFile(editor, modelCopy);
	}
	
}

