package org.polarsys.chess.m2m.transformations;

import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ModelContent;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.polarsys.chess.core.util.CHESSProjectSupport;
import org.polarsys.chess.core.views.ViewUtils;
import org.polarsys.chess.m2m.AcceleoMarte2mastProxy;
import org.polarsys.chess.m2m.QVToTransformation;
import org.polarsys.chess.m2m.TransUtil;
import org.polarsys.chess.m2m.TransformationResultsData;

public abstract class AbstractTransformation {

	private String folder = TransUtil.TRANSFORMATIONS_DIR;
	private IFolder transDir;
	protected Map<String, String> configProperty;
	private String saAnalysisName;
	private String psmPackageName;

	public AbstractTransformation() {
		super();
	}

	public String getFolder (){
		return folder;
	}
	
	public void setFolder (String newFolder){
		this.folder = newFolder;
	}
	
	public Map<String, String> getConfigProperty() {
		return configProperty;
	}
	
	public void setConfigProperty(Map<String, String> configProperty) {
		this.configProperty = configProperty;
	}

	public String getPsmPackageName() {
		return psmPackageName;
	}

	public void setPsmPackageName(String psmPackageName) {
		this.psmPackageName = psmPackageName;
	}

	protected IFile s1(IFile modelFile) throws Exception {
		transDir = modelFile.getProject().getFolder(folder);

		// Delete the working dir if it exists
		CHESSProjectSupport.deleteFolder(transDir);

		CHESSProjectSupport.createFolder(transDir);
		// Work on a copy of the model
		IFile modelCopy = CHESSProjectSupport.copyFile(modelFile, folder,
				modelFile.getName());
		// Remove the content of the PSMPackage and Backpropagation results
		//use saAnalysisName to get the correct PSM to be removed
		TransUtil.purgeModel(modelCopy, saAnalysisName);
		return modelCopy;
	}

	public TransformationResultsData performTransformation(
			final PapyrusMultiDiagramEditor editor, IFile modelFile, IProgressMonitor monitor)
			throws Exception {
		
		saAnalysisName = configProperty.get("saAnalysis");
		// Tidy up directories
		IFile modelCopy = s1(modelFile);
		//Execute the various steps of the transformations
		
		// Remove the package with the multi instances, if any
		QVToTransformation.launchRemoveMultiInstance(modelCopy, monitor);
		
		QVToTransformation.launchBuildMultiInstance(modelCopy, monitor);
		build1(monitor, modelCopy);

		String result = build2(monitor, modelCopy, editor);

		// Replace the input model file with the transformed model
		CHESSProjectSupport.fileReplace(modelCopy, modelFile);
		return new TransformationResultsData(result, modelFile);
//		return new TransformationResultsData("TODO", modelFile);
		// Finally delete the working dir
		// CHESSProjectSupport.deleteFolder((IFolder) transDir);
	}

	abstract protected void build1(IProgressMonitor monitor, IFile modelCopy)
			throws Exception;
	
	abstract protected void backpropagation(PapyrusMultiDiagramEditor editor, IFile modelCopy)
			throws Exception;
	

	@SuppressWarnings("restriction")
	protected String build2(IProgressMonitor monitor, IFile modelCopy,
			PapyrusMultiDiagramEditor editor) throws Exception {
		try {
			//pass the correct psmPackage to the Marte2Mast transformation
			//i.e a package whose name contains saAnalysisName (unqualified) in the PSMView
			ModelContent inModel = TransUtil.loadModel(modelCopy);
			Model model = (Model) inModel.getContent().get(0);
			Package psmView = ViewUtils.getCHESSPSMPackage(model);
//			System.out.println("+++++" + psmPackageName);
			Package psmPackage = psmView.getNestedPackage(psmPackageName);
			if(psmPackage == null){
				//log error?
				return null;
			}
			String result = AcceleoMarte2mastProxy.runMarte2Mast(modelCopy,
						transDir, monitor, psmPackage);
			backpropagation(editor, modelCopy);
			return result;
		} catch (Exception e) {

		}
		return null;
	}
}