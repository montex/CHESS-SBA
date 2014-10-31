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
-- This program is free software; you can redistribute it and/or     --
-- modify it under the terms of the GNU General Public License       --
-- version 2 as published by the Free Software Foundation.           --
--                                                                   --
-- This program is distributed in the hope that it will be useful,   --
-- but WITHOUT ANY WARRANTY; without even the implied warranty of    --
-- MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU --
-- General Public License for more details.                          --
--                                                                   --
-- You should have received a copy of the GNU General Public         --
-- License along with this program; if not, write to the             --
-- Free Software Foundation, Inc., 59 Temple Place - Suite 330,      --
-- Boston, MA 02111-1307, USA.                                       --
--                                                                   --
-----------------------------------------------------------------------
*/

package org.polarsys.chess.m2m;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CH_HwProcessor;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtPortSlot;
import org.polarsys.chess.core.util.CHESSProjectSupport;
import org.polarsys.chess.core.util.uml.ResourceUtils;
import org.polarsys.chess.core.util.uml.UMLUtils;
import org.polarsys.chess.core.views.ViewUtils;
import org.polarsys.chess.m2m.transformations.PIMPSMTransformationEnd2End;
import org.polarsys.chess.service.utils.CHESSEditorUtils;
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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ModelContent;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaWorkloadBehavior;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaAnalysisContext;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaEndtoEndFlow;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Assign;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Stereotype;

@SuppressWarnings("restriction")
public class QVToUIHandlerEnd2End extends AbstractHandler {

	private static final String SAANALYSISCONTEXT = "MARTE::MARTE_AnalysisModel::SAM::SaAnalysisContext";
	private static final String SAENDTOENDFLOW = "MARTE::MARTE_AnalysisModel::SAM::SaEndtoEndFlow";
	private Shell activeShell = null;
	private Resource inResource = null;
	private Class contextClass;
	private String deadline;
	private String scenario;
	private String saAnalysisName;
	private String saE2EFlowName;
	private SaEndtoEndFlow saE2EFlow;
	private SaAnalysisContext saAnalysisCtx;
	private String psmPackageName;
	
	private IProject getActiveProject(IEditorPart editor) {
		IFileEditorInput input = (IFileEditorInput) editor.getEditorInput();
		IFile file = input.getFile();
		return file.getProject();
	}

	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final IEditorPart editor = HandlerUtil.getActiveEditor(event);
		if (!(CHESSEditorUtils.isCHESSProject(editor)))
			return null;

		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		activeShell = window.getShell();

		try {
			inResource = ResourceUtils.getUMLResource(((PapyrusMultiDiagramEditor) editor).getServicesRegistry());
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		//open a dialog to select the end-to-end analysis context to be analyzed
		//first get all the classes stereotyped as SaAnalysisContext
		final List<Class> selection = new ArrayList<Class>();
		final Model model = (Model) inResource.getContents().get(0);
		EList<Element> elemList = model.allOwnedElements();
		for (Element elem : elemList) {
			//we're looking for a class stereotyped <<saAnalysisContext>> and NOT in PSM
			if(elem instanceof Class && elem.getAppliedStereotype(SAANALYSISCONTEXT) != null
					&& !ViewUtils.isPSMView(ViewUtils.getView(elem))){
				//as additional constraint, at least one workload is specified
				SaAnalysisContext saAnalysisCtx = (SaAnalysisContext) elem.getStereotypeApplication
						(elem.getAppliedStereotype(SAANALYSISCONTEXT));		
				if(saAnalysisCtx.getWorkload().size() > 0){
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
		AnalysisContextSelectionDialog dialog = new AnalysisContextSelectionDialog(activeShell, selection, "Select End-To-End Context to analyze");
		if (dialog.open() == Window.OK) {
			contextQN = dialog.getContext();
			if(contextQN == null || contextQN.isEmpty()){
				return null;
			}
			for (Element elem : model.allOwnedElements()){
				if(elem.getAppliedStereotype(SAANALYSISCONTEXT) != null &&
						((NamedElement) elem).getQualifiedName().equals(contextQN)){
					contextClass = (Class) elem;
				}
			}
		}else{
			return null;
		}
		//System.out.println("!!!!!!!!!!!!" + contextClass.getQualifiedName());
		saAnalysisName = contextClass.getQualifiedName();
		psmPackageName = contextClass.getName() +"_PSM";
		Stereotype stereo = contextClass.getAppliedStereotype(SAANALYSISCONTEXT);
		saAnalysisCtx = (SaAnalysisContext) contextClass.getStereotypeApplication(stereo);		
		
		EList<GaWorkloadBehavior> workloadList = saAnalysisCtx.getWorkload();
		//assume there's only one workload
		if(workloadList.size() != 1){
			return null;
		}
		GaWorkloadBehavior workload = workloadList.get(0);
		NamedElement nelem = workload.getBase_NamedElement();
		if (!(nelem instanceof Activity)){
			return null;
		}
		Activity workloadActivity = (Activity) nelem;
		saE2EFlowName = workloadActivity.getQualifiedName();
		//check that the activity is also a SaEndToEndFlow (assumption)
		stereo = workloadActivity.getApplicableStereotype(SAENDTOENDFLOW);
		saE2EFlow = (SaEndtoEndFlow) workloadActivity.getStereotypeApplication(stereo);
		//deadline is to be passed to the QVTO transformation
		deadline = saE2EFlow.getEnd2EndD().get(0); //note: in MARTE this relationship is [0..1] not [0..*] as in Papyrus
		//assume the activity has exactly one callbehaviour node
		CallBehaviorAction callbehaviour = null;
		EList<ActivityNode> nodes = workloadActivity.getNodes();
		for (ActivityNode activityNode : nodes) {
			if(activityNode instanceof CallBehaviorAction){
				callbehaviour = (CallBehaviorAction)activityNode;
			}
		}
		//System.out.println("***********" + callbehaviour.getName());
		if (!(callbehaviour.getBehavior() instanceof Interaction)){
			return null;
		}
		//scenario is to be passed to the QVTO transformation
		final Interaction interaction = ((Interaction) callbehaviour.getBehavior());
		scenario = interaction .getQualifiedName();
		
		final Job job = new Job("Transforming") {
			protected IStatus run(IProgressMonitor monitor) {
				try {
					
					//IWorkbenchPage page =  editor.getEditorSite().getPage();
					TransformationResultsData result =null;
					try {
						//CHESSProjectSupport.installMAST();
						result = QVToUIHandlerEnd2End.this.execute_(editor, monitor);
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
						
						openE2EAnalysisReport(model, saAnalysisName, interaction);
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
	
	/***
	 * 
	 * @param editor
	 * @param monitor
	 * @param scenario 
	 * @param deadline 
	 * @return the string resulting from the MAST execution (i.e. the system is/not schedulable
	 * @throws Exception
	 */
	public TransformationResultsData execute_(IEditorPart editor, IProgressMonitor monitor) throws Exception {
		monitor.beginTask("Transforming", 4);
		if (!(CHESSEditorUtils.isCHESSProject(editor)))
			return null;
		
//		IProject project = getActiveProject(editor);
//		ModelSet resourceSet = getEditorResourceSet(editor);
			
		IFile inputFile = CHESSProjectSupport.resourceToFile(inResource);
		
		//finally call the transformation
		PIMPSMTransformationEnd2End t = new PIMPSMTransformationEnd2End();
		t.setFolder(TransUtil.TRANSFORMATIONS_DIR_E2E);
		Map<String, String> configProps = new HashMap<String, String>();
		configProps.put("deadline", deadline);
		configProps.put("scenario", scenario);
		configProps.put("saAnalysis",saAnalysisName);
		configProps.put("saE2EFlow", saE2EFlowName);
		configProps.put("analysisType", "EndToEnd");
		t.setConfigProperty(configProps);
		t.setPsmPackageName(psmPackageName);
		TransformationResultsData result = t.performTransformation((PapyrusMultiDiagramEditor) editor, inputFile, monitor);
				
		return result;
	}
	
	/***
	 * 
	 * @param model
	 * @param saAnalysis
	 * @param saE2EFlow
	 * @param interaction 
	 */
	public void openE2EAnalysisReport(final Model model, String saAnalysisName, Interaction interaction){
		//get all the e2e analysis result info from the model and open a simple, user-friendly report
		SaAnalysisContext saAnCtx = null;
		SaEndtoEndFlow saflow = null;
		Package anView = (Package) ViewUtils.getCHESSRtAnalysisPackage(model);
		for (Element elem : anView.allOwnedElements()) {
			if(elem instanceof Class && ((Class)elem).getQualifiedName().equals(saAnalysisName)){
				saAnCtx = UMLUtils.getStereotypeApplication(elem, SaAnalysisContext.class);
				if(saAnCtx.getWorkload().size() > 0){
					saflow = UMLUtils.getStereotypeApplication(saAnCtx.getWorkload().get(0).getBase_NamedElement(), SaEndtoEndFlow.class);
				}
			}
		}
		
		EList<Message> messages = interaction.getMessages();
		final List<Operation> e2eOperations = new ArrayList<Operation>();
		for (Message msg : messages) {
			Operation op = (Operation) msg.getSignature();
			if (op.eIsProxy()){
				op = (Operation) EcoreUtil.resolve(op, model.eResource().getResourceSet());
			}
			e2eOperations.add(op);
		}
		final List<CH_HwProcessor> cpus = new ArrayList<CH_HwProcessor>();
		final List<CHRtPortSlot> specifications = new ArrayList<CHRtPortSlot>();
		final List<Assign> assigns = new ArrayList<Assign>();
		for (Element elem : model.allOwnedElements()) {
			CHRtPortSlot chrtSlot = UMLUtils.getStereotypeApplication(elem, CHRtPortSlot.class);
			if(chrtSlot != null){
				specifications.add(chrtSlot);
			}
			if(elem instanceof InstanceSpecification){
				CH_HwProcessor chHwProc = UMLUtils.getStereotypeApplication(elem, CH_HwProcessor.class);
				if(chHwProc != null){
					cpus.add(chHwProc);
				}
			}
			
			Assign assign = UMLUtils.getStereotypeApplication(elem, Assign.class);
			if(assign != null){
				assigns.add(assign);
			}
		};	
		launchDialog(model, cpus, saAnCtx, saflow, e2eOperations, assigns, specifications);
	}
	
	private static void launchDialog(final Model model, final List<CH_HwProcessor> cpus, final SaAnalysisContext saAnCtx, final SaEndtoEndFlow saflow, final List<Operation> e2eOperations, final List<Assign> assigns, final List<CHRtPortSlot> specifications){
		final Display display = PlatformUI.getWorkbench().getDisplay();
		display.asyncExec(new Runnable() {
			@Override
			public void run() {
				Shell shell = new Shell(display);
				End2EndResultDialog e2eDialog = new End2EndResultDialog(shell, model);
				e2eDialog.setCpus(cpus);
				e2eDialog.setSpecifications(specifications);
				e2eDialog.setSaAnalysisCtx(saAnCtx);
				e2eDialog.setSaE2EFlow(saflow);
				e2eDialog.setMessages(e2eOperations);
				e2eDialog.setAssigns(assigns);
				if (e2eDialog.open() == Window.OK) {
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
