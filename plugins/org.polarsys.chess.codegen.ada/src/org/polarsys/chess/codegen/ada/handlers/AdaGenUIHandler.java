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

import org.polarsys.chess.codegen.ada.transformations.Transformations;
import org.polarsys.chess.codegen.ada.util.AdaGenUtil;
import org.polarsys.chess.core.util.CHESSProjectSupport;
import org.polarsys.chess.core.util.uml.ResourceUtils;
import org.polarsys.chess.m2m.Activator;
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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * The Class AdaGenUIHandler is the handler of the Ada code generation command (org.polarsys.chess.codegen.ada.ada.id)
 * registered through the org.eclipse.ui.commands extension point
 */
public class AdaGenUIHandler extends AbstractHandler {

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
		
		final Job job = new Job("Transforming") {
			protected IStatus run(IProgressMonitor monitor) {
				try {
					try {
						AdaGenUIHandler.this.execute_(editor, monitor);
						//Reopen the editor
//						CHESSEditorUtils.reopenEditor(editor);
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
	
	/**
	 * Internal implementation of the Ada code generation command.
	 * Loads the UML model and calls the code generation
	 *
	 * @param editor the active editor
	 * @param monitor the progress monitor
	 * @throws Exception if unable to load the UML model
	 */
	private void execute_(IEditorPart editor, IProgressMonitor monitor) throws Exception {
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
		Transformations.performCodeGeneration((PapyrusMultiDiagramEditor)editor, inputFile, monitor);
		
		//CHESSProjectSupport.fileReplace(newFile, inputFile);
		return;
	}
}