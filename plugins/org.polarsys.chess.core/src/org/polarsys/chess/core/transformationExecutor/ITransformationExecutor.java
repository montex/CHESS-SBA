package org.polarsys.chess.core.transformationExecutor;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IProgressMonitor;

public interface ITransformationExecutor {
	public String execute(IFile modelFile, IFolder transformationDirectory,
			IProgressMonitor monitor) throws Exception;
}
