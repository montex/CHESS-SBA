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


/**
 * Abstract class for model to model transformation in CHESS
 */
public abstract class AbstractTransformation {

	/** The Constant DEBUG. */
	private static final boolean DEBUG = false;
	
	/** The name of the folder where transformation temporary files are stored. */
	private String folder = TransUtil.TRANSFORMATIONS_DIR;
	
	/** The folder where transformation temporary files are stored. */
	private IFolder transDir;
	
	/** The config property. */
	protected Map<String, String> configProperty;
	
	/** The sa analysis name. */
	private String saAnalysisName;
	
	/** The psm package name. */
	private String psmPackageName;

	/**
	 * Instantiates a new abstract transformation.
	 */
	public AbstractTransformation() {
		super();
	}

	/**
	 * Gets the folder.
	 *
	 * @return the folder
	 */
	public String getFolder (){
		return folder;
	}
	
	/**
	 * Sets the folder.
	 *
	 * @param newFolder the new folder
	 */
	public void setFolder (String newFolder){
		this.folder = newFolder;
	}
	
	/**
	 * Gets the config property.
	 *
	 * @return the config property
	 */
	public Map<String, String> getConfigProperty() {
		return configProperty;
	}
	
	/**
	 * Sets the config property.
	 *
	 * @param configProperty the config property
	 */
	public void setConfigProperty(Map<String, String> configProperty) {
		this.configProperty = configProperty;
	}

	/**
	 * Gets the PSM package name.
	 *
	 * @return the PSM package name
	 */
	public String getPsmPackageName() {
		return psmPackageName;
	}

	/**
	 * Sets the PSM package name.
	 *
	 * @param psmPackageName the new PSM package name
	 */
	public void setPsmPackageName(String psmPackageName) {
		this.psmPackageName = psmPackageName;
	}

	/**
	 * Implement the first steps of the model transformation:
	 * -Make a copy of the given model
	 * -Remove the content of the PSMPackage and back-propagation results in the copied model
	 *
	 * @param modelFile the model file
	 * @return the file with the model to be used for the transformation
	 * @throws Exception the exception
	 * 
	 * @see #performTransformation(PapyrusMultiDiagramEditor, IFile, IProgressMonitor)
	 * */
	protected IFile prepareModel(IFile modelFile) throws Exception {
		transDir = modelFile.getProject().getFolder(folder);

		// Delete the working dir if it exists
		CHESSProjectSupport.deleteFolder(transDir);

		CHESSProjectSupport.createFolder(transDir);
		// Work on a copy of the model
		IFile modelCopy = CHESSProjectSupport.copyFile(modelFile, folder,
				modelFile.getName());
		// Remove the content of the PSMPackage and Backpropagation results
		//use saAnalysisName to get the correct PSM to be removed
		Model m = TransUtil.purgeModel(modelCopy, saAnalysisName);
		
		m.eResource().save(null);
		return modelCopy;
	}

	/**
	 * Execute the various steps of the transformations PIM->PSM->MAST, then runs MAST and execute back propagation of analysis result 
	 * The transformations are executed on a copy of the current model; if the process completes successfully then the transformed model 
	 * becomes the current one.
	 *
	 * @param editor the editor
	 * @param modelFile the model file
	 * @param monitor the monitor
	 * @return the string resulting from the MAST transformation and the transformed model
	 * @throws Exception the exception
	 * 
	 * @see {@link #prepareModel(IFile)}
	 * @see {@link org.polarsys.chess.m2m.transformations.QVToTransformation#launchRemoveMultiInstance(IFile, IProgressMonitor)}
	 * @see {@link org.polarsys.chess.m2m.transformations.QVToTransformation#launchCeilingAssignment(IFile, IProgressMonitor)}
	 * @see {@link org.polarsys.chess.m2m.transformations.QVToTransformation#launchBuildMultiInstance(IFile, IProgressMonitor)}
	 * @see {@link #launchPIM2PSMtransformation(IProgressMonitor, IFile)}
	 * @see {@link #launchMarte2MastTrasformation(IProgressMonitor, IFile, PapyrusMultiDiagramEditor)}
	 * 
	 */
	public TransformationResultsData performTimingAnalysisWithMAST(
			final PapyrusMultiDiagramEditor editor, IFile modelFile, IProgressMonitor monitor)
			throws Exception {
		
		saAnalysisName = configProperty.get("saAnalysis");
		// Tidy up directories
		IFile modelCopy = prepareModel(modelFile);
		//Execute the various steps of the transformations
		
		// Remove the package with the multi-instances, if any
		//TO COMMENT FOR DEBUG
		if(!DEBUG){
			QVToTransformation.launchRemoveMultiInstance(modelCopy, monitor);
		}
		
		QVToTransformation.launchCeilingAssignment(modelCopy, monitor);
		
		QVToTransformation.launchBuildMultiInstance(modelCopy, monitor);

		launchPIM2PSMtransformation(monitor, modelCopy);

		String result = launchMarte2MastTrasformation(monitor, modelCopy, editor);

		// Replace the input model file with the transformed model
		CHESSProjectSupport.fileReplace(modelCopy, modelFile);
		return new TransformationResultsData(result, modelFile);
		
		// Finally delete the working dir
		// CHESSProjectSupport.deleteFolder((IFolder) transDir);
	}

	/**
	 * Launches the PIM to PSM transformation.
	 *
	 * @param monitor the monitor
	 * @param modelCopy the model copy
	 * @throws Exception the exception
	 */
	abstract protected void launchPIM2PSMtransformation(IProgressMonitor monitor, IFile modelCopy)
			throws Exception;
	
	/**
	 * Executes the back-propagation of the analysis results, from the PSM to the PIM
	 *
	 * @param editor the editor
	 * @param modelCopy the model where back propagation has to be performed
	 * @throws Exception the exception
	 */
	abstract protected void backpropagation(PapyrusMultiDiagramEditor editor, IFile modelCopy)
			throws Exception;
	

	/**
	 * Runs the MARTE to MAST model transformation, executes MAST analysis and then invokes the back propagation 
	 * of the analysis results.
	 * Requires the it.unipd.chess.m2m.marte2mast plugin installed.
	 *
	 * @param monitor the monitor
	 * @param modelCopy the model owning the psmPackage package to be transformed to MAST
	 * @param editor the current editor
	 * @return the string resulting from the invocation of MAST, or null if the psmPackage is not found
	 * @throws Exception in case the it.unipd.chess.m2m.marte2mast plugin is not found
	 * @see #backpropagation(PapyrusMultiDiagramEditor, IFile)
	 */
	@SuppressWarnings("restriction")
	protected String launchMarte2MastTrasformation(IProgressMonitor monitor, IFile modelCopy,
			PapyrusMultiDiagramEditor editor) throws Exception {
		try {
			//pass the correct psmPackage to the Marte2Mast transformation
			//i.e a package whose name contains saAnalysisName (unqualified) in the PSMView
			ModelContent inModel = TransUtil.loadModel(modelCopy);
			Model model = (Model) inModel.getContent().get(0);
			Package psmView = ViewUtils.getCHESSPSMPackage(model);
			Package psmPackage = psmView.getNestedPackage(psmPackageName);
			if(psmPackage == null){
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