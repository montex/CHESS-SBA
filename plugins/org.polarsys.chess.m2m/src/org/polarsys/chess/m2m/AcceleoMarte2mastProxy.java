package org.polarsys.chess.m2m;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IProgressMonitor;
import org.polarsys.chess.core.transformationExecutor.ITransformationExecutor;
import org.polarsys.chess.core.transformationExecutor.TransformationExecutorManager;

public class AcceleoMarte2mastProxy {

	public static String runMarte2Mast(IFile modelCopy, IFolder transDir,
			IProgressMonitor monitor) throws Exception {
		ITransformationExecutor e = TransformationExecutorManager.instance().getExecutor("MARTE2MAST");
		if (e == null)
			throw new Exception ("MARTE2MAST plugin not found.");
		return e.execute(modelCopy, transDir, monitor);
	}

}
