package org.polarsys.chess.m2m.transformations;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IProgressMonitor;
import org.polarsys.chess.core.transformationExecutor.ITransformationExecutor;
import org.polarsys.chess.core.transformationExecutor.TransformationExecutorManager;
import org.eclipse.uml2.uml.Package;


/**
 * This class realizes the proxy to invoke the Marte2mast transformation and MAST analysis execution
 */
public class AcceleoMarte2mastProxy {

	/**
	 * requests the MARTE to MAST transformation and MAST execution.
	 *
	 * @param model the model to give in input to the MARTE to MAST transformation
	 * @param transDir the folder owning the model
	 * @param monitor the progress monitor
	 * @param psmPackage the PSM package from wich the MAST model has to be created
	 * @return the string resulting from the MAST invocation
	 * @throws Exception the exception in case the it.unipd.chess.m2m.marte2mast plugin is not found
	 */
	public static String runMarte2Mast(IFile model, IFolder transDir,
			IProgressMonitor monitor, Package psmPackage) throws Exception {
		ITransformationExecutor e = TransformationExecutorManager.instance().getExecutor("MARTE2MAST");
		if (e == null)
			throw new Exception ("MARTE2MAST plugin not found.");
		return e.execute(model, transDir, monitor, psmPackage);
	}

}
