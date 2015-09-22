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
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ModelContent;
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
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CH_HwProcessor;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtPortSlot;
import org.polarsys.chess.core.util.CHESSProjectSupport;
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


// TODO: Auto-generated Javadoc
/**
 * The Class QVToUIHandlerVERDErealizes the handler for the scehdulability analysis command.
 */
public class QVToUIHandlerVERDE extends AbstractHandler {
	
	/** The active shell. */
	private Shell activeShell = null;
	
	/** The in resource. */
	private Resource inResource = null;
	
	/** The context class. */
	private Class contextClass;
	
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
	 * @param event the event resulting fro the invocation of the command
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
		
		//open a dialog to select the schedulability analysis context to be analyzed
		//first get all the classes stereotyped as SaAnalysisContext
		final List<Class> selection = new ArrayList<Class>();
		final Model model = (Model) inResource.getContents().get(0);
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
		//then open the dialog
		String contextQN = null;
		AnalysisContextSelectionDialog dialog = new AnalysisContextSelectionDialog(activeShell, selection, "Select Schedulability Context to analyze");
		if (dialog.open() == Window.OK) {
			contextQN = dialog.getContext();
			if(contextQN == null || contextQN.isEmpty()){
				return null;
			}
			for (Element elem : model.allOwnedElements()){
				if(elem.getAppliedStereotype(TransUtil.SA_ANALYSIS_CTX) != null &&
						((NamedElement) elem).getQualifiedName().equals(contextQN)){
					contextClass = (Class) elem;
				}
			}
		}else{
			return null;
		}
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
						
						
						openSchedAnalysisReport(model, result.res);
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
	 * *.
	 *
	 * @param model the model
	 * @param result the result
	 */
	public void openSchedAnalysisReport(Model model, final String result){
		
		//TODO Not the best solution 			
		if (result == null)
			return;
		//and open a simple, user-friendly report

		final List<CHRtPortSlot> specifications = new ArrayList<CHRtPortSlot>();
		final List<CH_HwProcessor> cpus = new ArrayList<CH_HwProcessor>();
		for (Element elem : model.allOwnedElements()) {
			CHRtPortSlot chrtSlot = UMLUtils.getStereotypeApplication(elem, CHRtPortSlot.class);
			//if(chrtSlot != null && UMLUtils.getStereotypeApplication(chrtSlot.getBase_Slot().getOwner(), IdentifInstance.class) != null){
			if(chrtSlot != null){	
				specifications.add(chrtSlot);
			}
			if(elem instanceof InstanceSpecification){
				CH_HwProcessor chHwProc = UMLUtils.getStereotypeApplication(elem, CH_HwProcessor.class);
				if(chHwProc != null){
					cpus.add(chHwProc);
				}
			}
		};
		
		final Display display = PlatformUI.getWorkbench().getDisplay();
		display.asyncExec(new Runnable() {
			@Override
			public void run() {
				Shell shell = new Shell(display);
				SchedResultDialog dialog = new SchedResultDialog(shell, result, specifications, cpus);
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
