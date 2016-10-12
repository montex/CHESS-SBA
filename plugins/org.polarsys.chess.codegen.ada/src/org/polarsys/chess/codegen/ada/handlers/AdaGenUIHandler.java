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

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.polarsys.chess.codegen.ada.transformations.Transformations;
import org.polarsys.chess.codegen.ada.util.AdaGenUtil;
import org.polarsys.chess.core.profiles.CHESSProfileManager;
import org.polarsys.chess.core.util.CHESSProjectSupport;
import org.polarsys.chess.core.util.uml.ModelError;
import org.polarsys.chess.core.util.uml.ResourceUtils;
import org.polarsys.chess.core.util.uml.UMLUtils;
import org.polarsys.chess.core.views.DiagramStatus;
import org.polarsys.chess.m2m.Activator;
import org.polarsys.chess.m2m.transformations.PIMPSMTransformationVERDE;
import org.polarsys.chess.service.utils.CHESSEditorUtils;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaResourcesPlatform;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaAnalysisContext;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
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
		
		
		if (editor.isDirty()){
			if (!MessageDialog.openQuestion(shell, "CHESS code generation", "Model must be saved first, do you want to continue?"))
				return null;
			
		}

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
					
					SubMonitor subMonitor = SubMonitor.convert(monitor);
					subMonitor.beginTask("Transforming", 100);
					
					if (diagramStatus == null)
						return null;

					boolean oldSuperUserStatus = diagramStatus.isSuperuser();
					diagramStatus.setSuperuser(true);
					
					subMonitor.subTask("Generating AnalysisContext");
					
					contextClass = null;
					try {
						contextClass = createAnalysisContext(shell, model);
						
						((PapyrusMultiDiagramEditor) editor).doSave(subMonitor.newChild(5));
					} catch (ModelError e1) {
						MessageDialog.openError(shell, "CHESS", "Unable to create analysis context: " + e1.getMessage());
					} finally {
						diagramStatus.setSuperuser(oldSuperUserStatus);
					}
					
					if (contextClass==null)
						return null;
					IFile filecopy = null;

					subMonitor.subTask("Generating PSM");
					
					//generate the PSM
					try {
						filecopy = AdaGenUIHandler.this.performPIM2PSMtransformation(inResource, contextClass, editor, subMonitor.newChild(55));
						//Reopen the editor
						CHESSEditorUtils.reopenEditor(editor, false);
					
					} catch (Exception e) {
						e.printStackTrace();
						throw e;
						
					} finally {
											
					}
					
					subMonitor.subTask("Generating code");
					//now generate the code
					try {
						AdaGenUIHandler.this.execute_(editor, subMonitor.newChild(40), contextClass,filecopy);
						
						
					} catch (Exception e) {
						throw e;
					} finally {
						AdaGenUtil.getActiveProject(editor).refreshLocal(IResource.DEPTH_INFINITE, subMonitor.newChild(5));
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
				if (event.getResult().isOK()){
					CHESSProjectSupport.printlnToCHESSConsole("Job completed successfully");
					
				}
				else{
					CHESSProjectSupport.printlnToCHESSConsole("Job did not complete successfully");
					
				}
			}
		});

		job.setUser(true);
		job.setPriority(Job.SHORT);
		job.schedule();
		
		return null;
	}
	
	protected IFile performPIM2PSMtransformation(Resource inResource, Class contextClass, IEditorPart editor, IProgressMonitor monitor) throws Exception {
		IFile inputFile = CHESSProjectSupport.resourceToFile(inResource);
		PIMPSMTransformationVERDE t = new PIMPSMTransformationVERDE();
		Map<String, String> configProps = new HashMap<String, String>();
		configProps.put("saAnalysis", contextClass.getQualifiedName());
		configProps.put("analysisType", "Schedulability");
		t.setConfigProperty(configProps);
		t.setPsmPackageName(contextClass.getName() +"_PSM");
		return t.performPIM2PSMtransformation((PapyrusMultiDiagramEditor) editor, inputFile, monitor, true);
	}

	/**
	 * Internal implementation of the Ada code generation command.
	 * Loads the UML model and calls the code generation
	 *
	 * @param editor the active editor
	 * @param monitor the progress monitor
	 * @throws Exception if unable to load the UML model
	 */
	private void execute_(IEditorPart editor, IProgressMonitor monitor, Class contextClass, IFile inputFile) throws Exception {
		//monitor.beginTask("Transforming", 4);
		if (!(editor instanceof PapyrusMultiDiagramEditor))
			return;
			
		//inputFile = CHESSProjectSupport.resourceToFile(inResource);
		final String saAnalysisName = contextClass.getQualifiedName();
		
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
					
					DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm");
					   
					Date date = new Date(System.currentTimeMillis());

					analysisContextClass = aView.createOwnedClass("CodeGen"+dateFormat.format(date), false);
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
