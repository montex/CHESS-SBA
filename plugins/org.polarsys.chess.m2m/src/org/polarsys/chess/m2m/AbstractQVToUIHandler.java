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
import org.polarsys.chess.core.util.CHESSProjectSupport;
import org.polarsys.chess.core.util.uml.ResourceUtils;
import org.polarsys.chess.service.utils.CHESSEditorUtils;

public abstract class AbstractQVToUIHandler extends AbstractHandler {


	protected IEditorPart editor;

	private IProject getActiveProject(IEditorPart editor) {
		IFileEditorInput input = (IFileEditorInput) editor.getEditorInput();
		IFile file = input.getFile();
		return file.getProject();
	}

	public Object execute(final ExecutionEvent event) throws ExecutionException {
		editor = HandlerUtil.getActiveEditor(event);
		
		final Job job = new Job("Transforming") {
			protected IStatus run(IProgressMonitor monitor) {
				try {
					preOperations();
					String result = "";
					try {
						//CHESSProjectSupport.installMAST();
						AbstractQVToUIHandler.this.execute_(editor, monitor);
						//Reopen the editor
						CHESSEditorUtils.reopenEditor(editor, true);
					} catch (Exception e) {
						throw e;
					} finally {
						getActiveProject(editor).refreshLocal(IResource.DEPTH_INFINITE, monitor);
					}
							
					postOperations(result);
					
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
	
	protected void postOperations(String result) throws Exception {
	}

	protected void preOperations() {
	}

	public String execute_(IEditorPart editorPart, IProgressMonitor monitor) throws Exception {
		monitor.beginTask("Transforming", 4);
		
		if (!(CHESSEditorUtils.isCHESSProject(editorPart)))
			return null;
		
		PapyrusMultiDiagramEditor editor = (PapyrusMultiDiagramEditor)editorPart;
		
		Resource inResource = null;
		try {
			inResource = ResourceUtils.getUMLResource(editor.getServicesRegistry());
		} catch (ServiceException e) {
			throw new Exception("Unable to load the model");
		}
		
		IFile inputFile = CHESSProjectSupport.resourceToFile(inResource);
		String result = performPIMPSMTransformation(editor, inputFile, monitor);
		
		//CHESSProjectSupport.fileReplace(newFile, inputFile);
		return result;
	}
	
	public abstract String performPIMPSMTransformation(PapyrusMultiDiagramEditor editor, IFile modelFile, IProgressMonitor monitor) throws Exception;
	/*{
		Transformations.performPIMPSMTransformation((CHESSEditor)editor, inputFile, monitor);
		
	}*/
}
