package org.polarsys.chess.m2m.transformations;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.polarsys.chess.m2m.backpropagation.BackpropagationFullVERDE;

/**
 * Allows to launch the PIM to PSM transformation for end-to-end reponse time analysis.
 */
public class PIMPSMTransformationEnd2End extends AbstractTransformation {

	/* (non-Javadoc)
	 * @see org.polarsys.chess.m2m.transformations.AbstractTransformation#launchPIM2PSMtransformation(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.resources.IFile)
	 */
	@Override
	protected void launchPIM2PSMtransformation(IProgressMonitor monitor, IFile modelCopy)
			throws Exception {
		QVToTransformation.launchTransformation(TransUtil.QVTO_PIM2PSMVERDE, "CHESS_PIM2PSMEND2END",true, modelCopy, monitor, configProperty);
	}

	/* (non-Javadoc)
	 * @see org.polarsys.chess.m2m.transformations.AbstractTransformation#backpropagation(org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor, org.eclipse.core.resources.IFile)
	 */
	@Override
	protected void backpropagation(PapyrusMultiDiagramEditor editor,
			IFile modelCopy) throws Exception {
		BackpropagationFullVERDE.processQVTOTraceFile(editor, modelCopy);
	}

}
