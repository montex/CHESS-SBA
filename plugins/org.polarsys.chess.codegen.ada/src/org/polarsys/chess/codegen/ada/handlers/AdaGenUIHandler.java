/*****************************************************************************
 * Copyright (c) 2011 - 2015 University of Padova.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Alessandro Zovi
 *
 *****************************************************************************/

package org.polarsys.chess.codegen.ada.handlers;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CH_HwProcessor;
import org.polarsys.chess.codegen.ada.transformations.Transformations;
import org.polarsys.chess.codegen.ada.util.AdaGenUtil;
import org.polarsys.chess.core.profiles.CHESSProfileManager;
import org.polarsys.chess.core.util.CHESSProjectSupport;
import org.polarsys.chess.core.util.uml.ModelError;
import org.polarsys.chess.core.util.uml.ResourceUtils;
import org.polarsys.chess.core.util.uml.UMLUtils;
import org.polarsys.chess.core.views.DiagramStatus;
import org.polarsys.chess.core.views.ViewUtils;
import org.polarsys.chess.m2m.Activator;
import org.polarsys.chess.m2m.handlers.QVToUIHandlerVERDE;
import org.polarsys.chess.m2m.transformations.PIMPSMTransformationVERDE;
import org.polarsys.chess.m2m.transformations.TransUtil;
import org.polarsys.chess.m2m.transformations.TransformationResultsData;
import org.polarsys.chess.m2m.ui.AnalysisContextSelectionDialog;
import org.polarsys.chess.service.utils.CHESSEditorUtils;
import org.concerto.multicore.model.AbstractCommand;
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
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ModelContent;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaResourcesPlatform;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaAnalysisContext;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Stereotype;

/**
 * The Class AdaGenUIHandler is the handler of the Ada code generation command (org.polarsys.chess.codegen.ada.ada.id)
 * registered through the org.eclipse.ui.commands extension point
 */
public class AdaGenUIHandler extends AbstractHandler {

	
	Resource inResource = null;
	private Class contextClass;
	private TransactionalEditingDomain transactionalEditingDomain;
	private Class analysisContextClass;
	/**
	 *  implementation of the Ada code generation command as an Eclipse Job.
	 *  Calls the internal implementation, refreshes the active project and prints messages to the CHESS console
	 *
	 * @param event the execution event
	 * @return the object (always null)
	 * @throws ExecutionException the execution exception
	 */
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final IEditorPart editor = HandlerUtil.getActiveEditor(event);
		final IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
    final Shell shell = window.getShell();
		
		if (!(CHESSEditorUtils.isCHESSProject(editor)))
			return null;

		try {
			inResource = ResourceUtils.getUMLResource(((PapyrusMultiDiagramEditor) editor).getServicesRegistry());
			ModelSet x = ((ModelSet)inResource.getResourceSet());
			transactionalEditingDomain = x.getTransactionalEditingDomain();
			
		} catch (ServiceException e) {
			MessageDialog.openError(shell, "CHESS", "Unable to load the model");
			return null;
		}

		final Model model = (Model) inResource.getContents().get(0);
		
		final DiagramStatus diagramStatus = CHESSEditorUtils.getDiagramStatus((PapyrusMultiDiagramEditor) editor);
		
		final Job job = new Job("Transforming") {
			protected IStatus run(IProgressMonitor monitor) {
				try {
					
					if (diagramStatus == null)
						return null;

					boolean oldSuperUserStatus = diagramStatus.isSuperuser();
					diagramStatus.setSuperuser(true);
					
					contextClass = null;
					try {
						contextClass = createAnalysisContext(shell, model);
						//((ModelSet)inResource.getResourceSet()).save(monitor);
						((PapyrusMultiDiagramEditor) editor).doSave(monitor);
					} catch (ModelError e1) {
						MessageDialog.openError(shell, "CHESS", "Unable to create analysis context: " + e1.getMessage());
					} finally {
						diagramStatus.setSuperuser(oldSuperUserStatus);
					}
					
					if (contextClass==null)
						return null;
					
					
					try {
						AdaGenUIHandler.this.performPIM2PSMtransformation(inResource, contextClass, editor, monitor);
						//Reopen the editor
						//CHESSEditorUtils.reopenEditor(editor, false);
					} catch (Exception e) {
						throw e;
					} finally {
						//AdaGenUtil.getActiveProject(editor).refreshLocal(IResource.DEPTH_INFINITE, monitor);

					}
					
					try {
						AdaGenUIHandler.this.execute_(editor, monitor, contextClass);
						//Reopen the editor
            //CHESSEditorUtils.reopenEditor(editor);
					} catch (Exception e) {
						throw e;
					} finally {
						AdaGenUtil.getActiveProject(editor).refreshLocal(IResource.DEPTH_INFINITE, monitor);
					}
				} catch (Exception e) {
					e.printStackTrace();
					StringWriter sw = new StringWriter();
					PrintWriter pw = new PrintWriter(sw);
				    e.printStackTrace(pw);
				    CHESSProjectSupport.printlnToCHESSConsole(sw.toString());
					
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
	
	protected void performPIM2PSMtransformation(Resource inResource, Class contextClass, IEditorPart editor, IProgressMonitor monitor) throws Exception {
		IFile inputFile = CHESSProjectSupport.resourceToFile(inResource);
		PIMPSMTransformationVERDE t = new PIMPSMTransformationVERDE();
		Map<String, String> configProps = new HashMap<String, String>();
		configProps.put("saAnalysis", contextClass.getQualifiedName());
		configProps.put("analysisType", "Schedulability");
		t.setConfigProperty(configProps);
		t.setPsmPackageName(contextClass.getName() +"_PSM");
		t.performPIM2PSMtransformation((PapyrusMultiDiagramEditor) editor, inputFile, monitor);
	}

	/**
	 * Internal implementation of the Ada code generation command.
	 * Loads the UML model and calls the code generation
	 *
	 * @param editor the active editor
	 * @param monitor the progress monitor
	 * @throws Exception if unable to load the UML model
	 */
	private void execute_(IEditorPart editor, IProgressMonitor monitor, Class contextClass) throws Exception {
		monitor.beginTask("Transforming", 4);
		if (!(editor instanceof PapyrusMultiDiagramEditor))
			return;
		PapyrusMultiDiagramEditor cEditor = (PapyrusMultiDiagramEditor) editor;
		Resource inResource = null;
		try {
			inResource = ResourceUtils.getUMLResource(cEditor.getServicesRegistry());
		} catch (ServiceException e) {
			e.printStackTrace();
			throw new Exception("Unable to load the model");
		}
			
		IFile inputFile = CHESSProjectSupport.resourceToFile(inResource);
		final String saAnalysisName = contextClass.getQualifiedName();
		final String psmPackageName = contextClass.getName() +"_PSM";
		ModelContent mc = TransUtil.loadModel(inputFile);
		final Model mi = (Model) mc.getContent().get(0);
		
		
		Transformations.performXMLGeneration(inputFile, saAnalysisName, monitor);
		
		Transformations.performCodeGeneration((PapyrusMultiDiagramEditor)editor, inputFile, monitor);
		
		return;
	}
	
	private Class createAnalysisContext(final Shell activeShell, final Model model) throws ModelError {
		Package parent = CHESSProfileManager.getViewByStereotype(model,
				CHESSProfileManager.ANALYSIS_VIEW);
		for (Package pkg : parent.getNestedPackages()) {
			Stereotype x = pkg.getAppliedStereotype("CHESS::Core::CHESSViews::RTAnalysisView");
			if(x!=null)
				parent=pkg;
		}
		
		final Package aView = parent;
		
		transactionalEditingDomain.getCommandStack().execute(new RecordingCommand(transactionalEditingDomain) {

			@Override
			public void doExecute() {
				try {
					int elements = aView.getOwnedElements().size()+1;
					analysisContextClass = aView.createOwnedClass("SaAnalysisContext"+elements, false);
					UMLUtils.applyStereotype(analysisContextClass, "MARTE::MARTE_AnalysisModel::SAM::SaAnalysisContext");
					SaAnalysisContext saAnalysisContext = UMLUtils.getStereotypeApplication(analysisContextClass, SaAnalysisContext.class);
					
					Package cmpv = CHESSProfileManager.getViewByStereotype(model,
							CHESSProfileManager.DEPLOYMENT_VIEW);

					Package resourcePlatformHW = UMLUtils.getResourcePlatformPackage(cmpv);
					GaResourcesPlatform gaHW = UMLUtils.getStereotypeApplication(resourcePlatformHW, GaResourcesPlatform.class);
					saAnalysisContext.getPlatform().add(gaHW);
					
					cmpv = CHESSProfileManager.getViewByStereotype(model,
							CHESSProfileManager.COMPONENT_VIEW);

					Package resourcePlatformSW = UMLUtils.getResourcePlatformPackage(cmpv);
					GaResourcesPlatform gaSW = UMLUtils.getStereotypeApplication(resourcePlatformSW, GaResourcesPlatform.class);
					saAnalysisContext.getPlatform().add(gaSW);

					if (!UMLUtils.checkPlatformsInContext(saAnalysisContext, model)) {
						MessageDialog.openWarning(activeShell, "CHESS", "Context must specify a SW and a HW instance platform!");
					}

				} catch (Exception e) {
					MessageDialog.openWarning(activeShell, "CHESS", "Cannot create analysis context");
				}
			}
		});
		

		return analysisContextClass;
	}
}
