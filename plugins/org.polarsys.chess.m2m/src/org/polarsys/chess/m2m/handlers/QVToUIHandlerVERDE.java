/*
-----------------------------------------------------------------------
--          			CHESS M2M plugin							 --
--                                                                   --
--                    Copyright (C) 2011-2012                        --
--                 University of Padova, ITALY                       --
--                                                                   --
-- Authors: -Alessandro Zovi         azovi@math.unipd.it 
--          -Intecs
--                                                                   --
-- All rights reserved. This program and the accompanying materials  --
-- are made available under the terms of the Eclipse Public License  --
-- v1.0 which accompanies this distribution, and is available at     --
-- http://www.eclipse.org/legal/epl-v10.html                         --
-----------------------------------------------------------------------
 */

package org.polarsys.chess.m2m.handlers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ModelContent;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaResourcesPlatform;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaAnalysisContext;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Stereotype;
import org.polarsys.chess.chessmlprofile.Core.CHGaResourcePlatform;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CH_HwProcessor;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtPortSlot;
import org.polarsys.chess.chessmlprofile.util.Constants;
import org.polarsys.chess.core.util.AnalysisResultData;
import org.polarsys.chess.core.util.CHESSProjectSupport;
import org.polarsys.chess.core.util.HWAnalysisResultData;
import org.polarsys.chess.core.util.uml.ModelError;
import org.polarsys.chess.core.util.uml.ResourceUtils;
import org.polarsys.chess.core.util.uml.UMLUtils;
import org.polarsys.chess.core.views.ViewUtils;
import org.polarsys.chess.m2m.Activator;
import org.polarsys.chess.m2m.transformations.PIMPSMTransformationVERDE;
import org.polarsys.chess.m2m.transformations.TransUtil;
import org.polarsys.chess.m2m.transformations.TransformationResultsData;
import org.polarsys.chess.m2m.ui.AnalysisContextSelectionDialog;
import org.polarsys.chess.m2m.ui.SchedResultDialog;
import org.polarsys.chess.service.utils.CHESSEditorUtils;
import org.polarsys.chess.validator.command.ChessGenericValidateCommand;


// TODO: Auto-generated Javadoc
/**
 * The Class QVToUIHandlerVERDErealizes the handler for the scehdulability analysis command.
 * @since 0.9
 */
public class QVToUIHandlerVERDE extends AbstractHandler {

	/** The active shell. */
	private Shell activeShell = null;

	/** The in resource. */
	private Resource inResource = null;

	/** The context class. */
	//	private Class contextClass;

	/** The sa analysis name. */
	private String saAnalysisName;

	/** The psm package name. */
	private String psmPackageName;

	/**
	 * Gets the active project.
	 *
	 * @param editor the editor
	 * @return the active project
	 */
	private IProject getActiveProject(IEditorPart editor) {
		IFileEditorInput input = (IFileEditorInput) editor.getEditorInput();
		IFile file = input.getFile();
		return file.getProject(); 
	}

	/**
	 * Executes the schedulability analysis and shows the results.
	 * The analysis context to be analyzed is asked to the user through a dedicated dialog.
	 *
	 * @param event the event resulting from the invocation of the command
	 * @return null 
	 * @throws ExecutionException the execution exception
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * @see org.polarsys.chess.m2m.ui.AnalysisContextSelectionDialog
	 */
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final IEditorPart editor = HandlerUtil.getActiveEditor(event);


		if (!(CHESSEditorUtils.isCHESSProject(editor)))
			return null;

		try {
			inResource = ResourceUtils.getUMLResource(((PapyrusMultiDiagramEditor) editor).getServicesRegistry());
		} catch (ServiceException e) {
			e.printStackTrace();
			MessageDialog.openError(activeShell, "CHESS", "Unable to load the model");
		}
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		activeShell = window.getShell();

		// run CHESS Validate Core Constraints to validate the model before running analysis
		String label = "Validate model for CHESS Core Constraints";
		final Model model = (Model) inResource.getContents().get(0);		

		ChessGenericValidateCommand chessValidateCommand = new ChessGenericValidateCommand(label, 
				org.polarsys.chess.validator.Activator.PLUGIN_ID, model);	

		boolean go = false;
		if(chessValidateCommand != null) {
			try {
				chessValidateCommand.executeCommand(null, null);
			}
			catch (ExecutionException exception) {
				return null;
			}
			if (chessValidateCommand.getMarkers()) {
				org.eclipse.emf.common.util.Diagnostic diagnostic = chessValidateCommand.getDiagnostic();
				List<org.eclipse.emf.common.util.Diagnostic> diagList = diagnostic.getChildren();
				Boolean validationErrors = false;
				for (org.eclipse.emf.common.util.Diagnostic theDiag : diagList) {
					if (theDiag.getSource().equals(Constants.CHESS_VALIDATOR_PLUGIN) &&
							theDiag.getSeverity()>org.eclipse.emf.common.util.Diagnostic.WARNING) {
						validationErrors = true;
						break;						
					}
				}
				if (validationErrors) {
					go = MessageDialog.openQuestion(activeShell, "Validation Problems", "Errors found while validating the Model. Schedulability Analysis won't be performed correctly. Do you still want to continue?");
					if (!go) {
						return null;
					}
				}
			}
		} 
		else {
			MessageDialog.openError(activeShell, "Schedulability Analysis", "Problems while perfoming model validation before analysis");						
		}
		// end of model validation

		//open a dialog to select the schedulability analysis context to be analyzed
		//first get all the classes stereotyped as SaAnalysisContext
		final List<Class> selection = new ArrayList<Class>();		
		EList<Element> elemList = model.allOwnedElements();
		for (Element elem : elemList) {
			//we're looking for a class stereotyped <<saAnalysisContext>> and NOT in PSM
			if(elem instanceof Class && elem.getAppliedStereotype(TransUtil.SA_ANALYSIS_CTX) != null 
					&& !ViewUtils.isPSMView(ViewUtils.getView(elem))){
				//as additional constraint, no workload is specified
				SaAnalysisContext saAnalysisCtx = (SaAnalysisContext) elem.getStereotypeApplication
						(elem.getAppliedStereotype(TransUtil.SA_ANALYSIS_CTX));		
				if(saAnalysisCtx.getWorkload().size() == 0){
					selection.add((Class) elem);
				}
			}
		}
		if(selection.size() == 0){
			MessageDialog.openWarning(activeShell, "CHESS", "no suitable analysis contexts in the model");
			return null;
		}
		final List<CH_HwProcessor> chHwProcList = new ArrayList<CH_HwProcessor>();
		//then open the dialog
		String contextQN = null;
		AnalysisContextSelectionDialog dialog = new AnalysisContextSelectionDialog(activeShell, selection, "Select Schedulability Context to analyze");
		if (dialog.open() == Window.OK) {

		}else{
			return null;
		}
		contextQN = dialog.getContext();
		if(contextQN == null || contextQN.isEmpty()){
			return null;
		}

		Class contextClassTmp = null;
		for (Element elem : model.allOwnedElements()) {
			Stereotype saAnalysisContextStereo = elem.getAppliedStereotype(TransUtil.SA_ANALYSIS_CTX);
			if(saAnalysisContextStereo != null &&
					((NamedElement) elem).getQualifiedName().equals(contextQN)){
				contextClassTmp = (Class) elem;

				SaAnalysisContext saAnalysisContext = (SaAnalysisContext) elem.getStereotypeApplication(saAnalysisContextStereo);
				List<CH_HwProcessor> tmpList = getPlatformChHwProcessors(saAnalysisContext, model);
				chHwProcList.addAll(tmpList);

				// Check that the Context Platform contains two CHGaResourcePlatform instances, one in ComponentView, one in DeploymentView
				// and that at least on CH_HwPlatform is specified in the Context
				if (chHwProcList.isEmpty() || !UMLUtils.checkPlatformsInContext(saAnalysisContext, model)) {
					MessageDialog.openWarning(activeShell, "CHESS", "Context must specify a SW and a HW instance platform!");
					return null;
				}

				try {
					// Check that at least one Partition or Task is allocated on a Core of a ChHwProcessor specified in the Context
					if(!UMLUtils.checkAllocationToCores(chHwProcList, model)) {
						MessageDialog.openWarning(activeShell, "CHESS", "No partition or task allocated to Core!");
						return null;
					}
				} catch (ModelError e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		final Class contextClass = contextClassTmp;
		saAnalysisName = contextClass.getQualifiedName();
		psmPackageName = contextClass.getName() +"_PSM";

		final Job job = new Job("Transforming") {
			protected IStatus run(IProgressMonitor monitor) {
				try {

					TransformationResultsData result =null;
					try {
						//CHESSProjectSupport.installMAST();
						result = QVToUIHandlerVERDE.this.executeTimingAnalysis(editor, monitor);
						//Reopen the editor
						CHESSEditorUtils.reopenEditor(editor, false);
					} catch (Exception e) {
						throw e;
					} finally {
						getActiveProject(editor).refreshLocal(IResource.DEPTH_INFINITE, monitor);

					}

					//open sched analysis result

					try {
						//can active editor be different from just reopened CHESS ones? it should be not the case given that it has been just reopened
						//inResource = ResourceUtils.getUMLResource(((CHESSEditor) editor).getServicesRegistry());
						//Model model = (Model) inResource.getContents().get(0);

						ModelContent inModel = TransUtil.loadModel(result.umlFile);
						Model model = (Model) inModel.getContent().get(0);

						openSchedAnalysisReport(model, result.res, chHwProcList, contextClass);
					} catch (Exception e) {
						e.printStackTrace();
						throw new Exception("Unable to load the model and so open the schedAnalysisReport");
					}


				} catch (Exception e) {
					e.printStackTrace();
					return new Status(Status.ERROR, Activator.PLUGIN_ID, 1,
							"Error in transformation "+ e.getMessage(), null);
				}
				if (monitor.isCanceled())
					return Status.CANCEL_STATUS;
				return Status.OK_STATUS;
			}
		};
		job.addJobChangeListener(new JobChangeAdapter() {
			public void done(IJobChangeEvent event) {
				if (event.getResult().isOK())
					CHESSProjectSupport.printlnToCHESSConsole("Job completed successfully");
				else
					CHESSProjectSupport.printlnToCHESSConsole("Job did not complete successfully");
			}
		});
		job.setUser(true);
		job.setPriority(Job.SHORT);
		job.schedule();
		return null;
	}

	/**
	 * Returns the list of CH_HwProcessors in this analysisContext
	 * @param saAnalysisContext
	 * @param model
	 * @return
	 */
	public static List<CH_HwProcessor> getPlatformChHwProcessors(
			SaAnalysisContext saAnalysisContext,
			Model model) {
		CH_HwProcessor chHwProcessor = null;
		List<CH_HwProcessor> chHwProcessorList = new ArrayList<CH_HwProcessor>();

		EList<GaResourcesPlatform> platformList = saAnalysisContext.getPlatform();
		for (GaResourcesPlatform theGaResPlatform : platformList) {
			if (theGaResPlatform instanceof CHGaResourcePlatform) {
				CHGaResourcePlatform chGaResPlat = (CHGaResourcePlatform)theGaResPlatform;
				org.eclipse.uml2.uml.Package thePackage = ViewUtils.getView(chGaResPlat.getBase_Package());

				if (ViewUtils.getCHESSDeploymentPackage(model)	== thePackage) {
					EList<Element> allElems = (chGaResPlat.getBase_Package().allOwnedElements());
					for (Element theElement : allElems) {
						if (theElement instanceof InstanceSpecification) {
							InstanceSpecification e = (InstanceSpecification) theElement;
							if (e.getQualifiedName() != null
									&& UMLUtils.isProcessorInstance(e)) {
								chHwProcessor = UMLUtils.getStereotypeApplication(e, CH_HwProcessor.class);	
								chHwProcessorList.add(chHwProcessor);
							}
						}
					}			
				}
			}
		}
		return chHwProcessorList;
	}

	/**
	 * Collects all the needed information and invokes the PIMPSMTransformationVERDE.performTimingAnalysisWithMAST method
	 *
	 * @param editor the editor
	 * @param monitor the monitor
	 * @return the string resulting from the MAST execution (i.e. the system is/not schedulable) and the modified model
	 * @throws Exception the exception
	 * @see org.polarsys.chess.m2m.transformations.PIMPSMTransformationVERDE#performTimingAnalysisWithMAST(PapyrusMultiDiagramEditor, IFile, IProgressMonitor)
	 */
	public TransformationResultsData executeTimingAnalysis(IEditorPart editor, IProgressMonitor monitor) throws Exception {
		monitor.beginTask("Transforming", 4);

		IFile inputFile = CHESSProjectSupport.resourceToFile(inResource);
		PIMPSMTransformationVERDE t = new PIMPSMTransformationVERDE();
		Map<String, String> configProps = new HashMap<String, String>();
		configProps.put("saAnalysis", saAnalysisName);
		configProps.put("analysisType", "Schedulability");
		t.setConfigProperty(configProps);
		t.setPsmPackageName(psmPackageName);
		final TransformationResultsData result = t.performTimingAnalysisWithMAST((PapyrusMultiDiagramEditor) editor, inputFile, monitor);

		//CHESSProjectSupport.fileReplace(newFile, inputFile);
		return result;
	}


	/**
	 * Open a simple, user-friendly report to display the analysis results
	 *
	 * @param model the model
	 * @param result the result
	 */
	public void openSchedAnalysisReport(Model model, final String result, 
			final List<CH_HwProcessor> cpus, 
			Class saAnalysisContextClass){

		if (result == null)
			return;

		if (saAnalysisContextClass == null) {
			return;
		}

		if(saAnalysisContextClass.eIsProxy()){
			saAnalysisContextClass = (Class) EcoreUtil.resolve(saAnalysisContextClass, model);
		}

		final List<HWAnalysisResultData> hwResults = UMLUtils.getHWAnalysisResults(saAnalysisContextClass);
		final List<AnalysisResultData> analysisResData = UMLUtils.getAnalysisResults(saAnalysisContextClass);
		//and open a simple, user-friendly report
		//	final List<CHRtPortSlot> specifications = new ArrayList<CHRtPortSlot>();
		//	for (Element elem : model.allOwnedElements()) {
		//		CHRtPortSlot chrtSlot = UMLUtils.getStereotypeApplication(elem, CHRtPortSlot.class);
		//		//if(chrtSlot != null && UMLUtils.getStereotypeApplication(chrtSlot.getBase_Slot().getOwner(), IdentifInstance.class) != null){
		//		if(chrtSlot != null){	
		//			specifications.add(chrtSlot);
		//		}
		//	};

		final Display display = PlatformUI.getWorkbench().getDisplay();
		display.asyncExec(new Runnable() {
			@Override
			public void run() {
				Shell shell = new Shell(display);

				//SchedResultDialog dialog = new SchedResultDialog(shell, result, specifications, cpus, hwResults);
				SchedResultDialog dialog = new SchedResultDialog(shell, result, analysisResData, hwResults);
				if (dialog.open() == Window.OK) {
					System.out.println("OK");
				}
			}
		});
	}

	//	@SuppressWarnings("unused")
	//	private ModelSet getEditorResourceSet(IEditorPart editor)
	//			throws Exception {
	//		ModelSet resourceSet = null;
	//		try {
	//			resourceSet = (ModelSet)((ServicesRegistry)editor.getAdapter(ServicesRegistry.class)).getService(ModelSet.class);
	//		} catch (ServiceException e) {
	//			e.printStackTrace();
	//			throw new Exception("Unable to get the service registry");
	//		}
	//		return resourceSet;
	//	}
}
