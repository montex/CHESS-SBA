package org.polarsys.chess.core.transformationExecutor;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.uml2.uml.Package;

public interface ITransformationExecutor {
	public String execute(IFile modelFile, IFolder transformationDirectory,
			IProgressMonitor monitor, Package psmPackage) throws Exception;
}
