/*
-----------------------------------------------------------------------
--          			CHESS M2M plugin							 --
--                                                                   --
--                    Copyright (C) 2011-2012                        --
--                 University of Padova, ITALY                       --
--                                                                   --
-- Author: Alessandro Zovi         azovi@math.unipd.it 		         --
--                                                                   --
-- All rights reserved. This program and the accompanying materials  --
-- are made available under the terms of the Eclipse Public License  --
-- v1.0 which accompanies this distribution, and is available at     --
-- http://www.eclipse.org/legal/epl-v10.html                         --
-----------------------------------------------------------------------
*/

package org.polarsys.chess.m2m;

import static org.polarsys.chess.core.util.CHESSProjectSupport.printlnToCHESSConsole;

import java.util.ArrayList;
import java.util.List;

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
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaEndtoEndFlow;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Stereotype;
import org.polarsys.chess.chessmlprofile.Core.CHESS;
import org.polarsys.chess.chessmlprofile.Core.CHGaResourcePlatform;
import org.polarsys.chess.chessmlprofile.Core.PSMPackage;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CH_HwBus;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CH_HwProcessor;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification;
import org.polarsys.chess.core.util.CHESSProjectSupport;
import org.polarsys.chess.core.util.uml.ResourceUtils;
import org.polarsys.chess.core.util.uml.UMLUtils;
import org.polarsys.chess.core.views.ViewUtils;
import org.polarsys.chess.service.utils.CHESSEditorUtils;

public class PurgePIMHandler extends AbstractHandler {

	protected IEditorPart editor;

	private IProject getActiveProject(IEditorPart editor) {
		IFileEditorInput input = (IFileEditorInput) editor.getEditorInput();
		IFile file = input.getFile();
		return file.getProject();
	}

	public Object execute(final ExecutionEvent event) throws ExecutionException {
		editor = HandlerUtil.getActiveEditor(event);
		
		final Job job = new Job("Transforming") {
			private Class contextClass;
			private Shell activeShell;
			private String saAnalysisName;
			private SaAnalysisContext saAnalysisCtx;

			protected IStatus run(IProgressMonitor monitor) {
				try {
					try {
						if (!(CHESSEditorUtils.isCHESSProject(editor)))
							return null;
						
						Resource inResource = null;
						try {
							inResource = ResourceUtils.getUMLResource(((PapyrusMultiDiagramEditor) editor).getServicesRegistry());
						} catch (ServiceException e) {
							e.printStackTrace();
							MessageDialog.openError(activeShell, "CHESS", "Unable to load the model");
						}
						IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
						activeShell = window.getShell();
							
						IFile modelFile = CHESSProjectSupport.resourceToFile(inResource);
						//ModelContent inModel = ExtendedEmfUtil.loadModel(new EclipseFile(inputFile));
						ModelContent inModel = TransUtil.loadModel(modelFile);
						Model m = (Model) inModel.getContent().get(0);
						
						//open a dialog to select the schedulability analysis context to be analyzed
						//first get all the classes stereotyped as SaAnalysisContext
						final List<Class> selection = new ArrayList<Class>();
						final Model model = (Model) inResource.getContents().get(0);
						EList<Element> elemList = model.allOwnedElements();
						for (Element elem : elemList) {
							//we're looking for a class stereotyped <<saAnalysisContext>> and NOT in PSM
							if(elem instanceof Class && elem.getAppliedStereotype(TransUtil.SA_ANALYSIS_CTX) != null 
									&& !ViewUtils.isPSMView(ViewUtils.getView(elem))){
								selection.add((Class) elem);
							}
						}
						if(selection.size() == 0){
							activeShell.getDisplay().syncExec(new Runnable() {
								@Override
								public void run() {
									MessageDialog.openWarning(activeShell, "CHESS", "no suitable analysis contexts in the model");
								}
							});
							return null;
						}
						//then open the dialog
						activeShell.getDisplay().syncExec(new Runnable() {
							@Override
							public void run() {
								String contextQN = null;
								AnalysisContextSelectionDialog dialog = new AnalysisContextSelectionDialog(activeShell, selection, "Select Schedulability Context to analyze");
								if (dialog.open() == Window.OK) {
									contextQN = dialog.getContext();
								}
								for (Element elem : model.allOwnedElements()){
									if(elem.getAppliedStereotype(TransUtil.SA_ANALYSIS_CTX) != null &&
											((NamedElement) elem).getQualifiedName().equals(contextQN)){
										contextClass = (Class) elem;
									}
								}
							}
						});
						if(contextClass == null){
							return null;
						}
						saAnalysisName = contextClass.getQualifiedName();
						saAnalysisCtx = (SaAnalysisContext) contextClass.getStereotypeApplication(contextClass.getAppliedStereotype(TransUtil.SA_ANALYSIS_CTX));
						
						//get the correct PSM package and platform...
						Package psmPackage = null;
						Package platform = ((CHGaResourcePlatform) saAnalysisCtx.getPlatform().get(0)).getBase_Package();
						CHESS chess = (CHESS) m.getStereotypeApplication(m.getAppliedStereotype("CHESS::Core::CHESS"));
						for (Package pkg : chess.getPsmView().getBase_Package().getNestedPackages()) {
							Stereotype stereo = pkg.getAppliedStereotype("CHESS::Core::PSMPackage");
							if(stereo != null){
								PSMPackage psmPkg = (PSMPackage) pkg.getStereotypeApplication(stereo);
								if(psmPkg.getAnalysisContext().getBase_NamedElement().getQualifiedName().equals(saAnalysisName)){
									psmPackage = pkg;
//									platform = ((CHGaResourcePlatform) psmPkg.getAnalysisContext().getPlatform().get(0)).getBase_Package();
								}
							}
						}		
						// Remove the content of the RtAnalysisPackage
						m = PurgePIMHandler.this.removeRtAnalysis(m, psmPackage);
						
						//remove results of the backpropagation
						m = PurgePIMHandler.this.resetStereotypeValues(m, platform);
						
						m.eResource().save(null);
						
						CHESSEditorUtils.reopenEditor(editor, false);
					} catch (Exception e) {
						throw e;
					} finally {
						getActiveProject(editor).refreshLocal(IResource.DEPTH_INFINITE, monitor);
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
		job.setPriority(Job.SHORT);
		job.schedule();
		return null;
	}

	
	private Model resetStereotypeValues(Model m, Package platform) {
		String name = platform.getName();
		name = name.substring(0, name.lastIndexOf('_'));
		Component compPlatform = null;
		for (Element el : m.allOwnedElements()) {
			if(el instanceof Component){
				if(((Component) el).getName().equals(name)){
					compPlatform = (Component) el;
				}
			}
		}
		if(compPlatform  != null){
			for (Element el : compPlatform.getOwnedComments()) {
				CHRtSpecification chrt = UMLUtils.getStereotypeApplication(el, CHRtSpecification.class);
				if (chrt != null){
					printlnToCHESSConsole("Resetting:" + el);
					chrt.getRespT().clear();
					chrt.getBlockT().clear();
				}
			}
		}
		
		//TODO: should reset only CH_HwProcessor with sw instances allocated on it
		Package pkg = ViewUtils.getCHESSDeploymentPackage(m);
		for (Element e : pkg.allOwnedElements()) {
			if (e instanceof InstanceSpecification){
				CH_HwProcessor pr = UMLUtils.getStereotypeApplication(e, CH_HwProcessor.class);
				if (pr != null){
					pr.setUtilization(null);
					printlnToCHESSConsole("Resetting:" + e);
				}
				
				CH_HwBus bu = UMLUtils.getStereotypeApplication(e, CH_HwBus.class);
				if (bu != null){
					bu.setUtilization(null);
					printlnToCHESSConsole("Resetting:" + e);
				}
			}
		}
		
		pkg = (Package) ViewUtils.getCHESSRtAnalysisPackage(m);
		for (Element e : pkg.allOwnedElements()) {
			if (e instanceof org.eclipse.uml2.uml.Class){
				
				SaAnalysisContext s = UMLUtils.getStereotypeApplication(e, SaAnalysisContext.class);
				if (s != null){
					printlnToCHESSConsole("Resetting:" + e);
					s.setIsSched("");
					if(s.getWorkload().size() > 0){
						SaEndtoEndFlow e2e = UMLUtils.getStereotypeApplication(s.getWorkload().get(0).getBase_NamedElement(), SaEndtoEndFlow.class);
						e2e.getEnd2EndT().clear();
					}
				}
			}
		}
		
		return m;
	}
	
	private Model removeRtAnalysis(Model m, Package psmPackage) {
		if(psmPackage != null){
			psmPackage.destroy();
		}
		return m;
	}
}
