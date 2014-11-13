package org.polarsys.chess.m2m.transformations;

import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.polarsys.chess.core.util.CHESSProjectSupport;
import org.polarsys.chess.m2m.AcceleoMarte2mastProxy;
import org.polarsys.chess.m2m.QVToTransformation;
import org.polarsys.chess.m2m.TransUtil;
import org.polarsys.chess.m2m.TransformationResultsData;

public abstract class AbstractTransformation {

	private String folder = TransUtil.TRANSFORMATIONS_DIR;
	private IFolder transDir;
	protected Map<String, String> configProperty;
	private String saAnalysisName;

	public AbstractTransformation() {
		super();
	}

	public void setFolder (String newFolder){
		this.folder = newFolder;
	}
	
	public Map<String, String>  getConfigProperty() {
		return configProperty;
	}
	
	public void setConfigProperty(Map<String, String> configProperty) {
		this.configProperty = configProperty;
	}

	protected IFile s1(IFile model) throws Exception {
		transDir = model.getProject().getFolder(folder);

		// Delete the working dir if it exists
		CHESSProjectSupport.deleteFolder(transDir);

		CHESSProjectSupport.createFolder(transDir);
		// Work on a copy of the model
		IFile modelCopy = CHESSProjectSupport.copyFile(model, folder,
				model.getName());
		// Remove the content of the RtAnalysisPackage and Backpropagation
		// results
		TransUtil.purgeModel(modelCopy, saAnalysisName);
		return modelCopy;
	}

	public TransformationResultsData performTransformation(
			final PapyrusMultiDiagramEditor editor, IFile model, IProgressMonitor monitor)
			throws Exception {
		saAnalysisName = configProperty.get("saAnalysis");
		// Tidy up directories

		IFile modelCopy = s1(model);
		//Execute the various steps of the transformations
		QVToTransformation.launchBuildMultiInstance(modelCopy, monitor);
		build1(monitor, modelCopy);

		String result = build2(monitor, modelCopy, editor);

		// Remove the package with the multi instances
		QVToTransformation.launchRemoveMultiInstance(modelCopy, monitor);

		// Replace the input model file with the transformed model
		CHESSProjectSupport.fileReplace(modelCopy, model);
		return new TransformationResultsData(result, model);
		// Finally delete the working dir
		// CHESSProjectSupport.deleteFolder((IFolder) transDir);
	}

	abstract protected void build1(IProgressMonitor monitor, IFile modelCopy)
			throws Exception;
	
	abstract protected void backpropagation(PapyrusMultiDiagramEditor editor, IFile modelCopy)
			throws Exception;
	

	protected String build2(IProgressMonitor monitor, IFile modelCopy,
			PapyrusMultiDiagramEditor editor) throws Exception {
		try {
			String result = AcceleoMarte2mastProxy.runMarte2Mast(modelCopy,
					transDir, monitor);
			backpropagation(editor, modelCopy);
			return result;
		} catch (Exception e) {

		}
		return null;
	}
}