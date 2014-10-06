package org.polarsys.chess.m2m.transformations;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.polarsys.chess.m2m.QVToTransformation;
import org.polarsys.chess.m2m.TransUtil;
import org.polarsys.chess.m2m.backpropagation.BackpropagationFullVERDE;

public class PIMPSMTransformationEnd2End extends AbstractTransformation {

	@Override
	protected void build1(IProgressMonitor monitor, IFile modelCopy)
			throws Exception {
		QVToTransformation.launchTransformation(TransUtil.QVTO_PIM2PSMVERDE, "CHESS_PIM2PSMEND2END",true, modelCopy, monitor, configProperty);
	}

	@Override
	protected void backpropagation(PapyrusMultiDiagramEditor editor,
			IFile modelCopy) throws Exception {
		BackpropagationFullVERDE.processQVTOTraceFile(editor, modelCopy);
	}

}
