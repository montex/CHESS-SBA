/*
-----------------------------------------------------------------------
--                    CHESS monitoring plugin                        --
--                                                                   --
--                    Copyright (C) 2015-2016                        --
--                 Malardalen University, Sweden                       --
--                                                                   --                      --
--                                                                   --
-- All rights reserved. This program and the accompanying materials  --
-- are made available under the terms of the Eclipse Public License  --
-- v1.0 which accompanies this distribution, and is available at     --
-- http://www.eclipse.org/legal/epl-v10.html                         --
-----------------------------------------------------------------------
  */ 

package org.polarsys.chess.monitoring.monitoringxml.popup.actions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.polarsys.chess.monitoring.traceanalyser.TraceAnalyser;

public class LaunchTraceAnalysis implements IObjectActionDelegate {

	private Shell shell;
	private IFile traceFile;
	private IFile inXMLFile;
	private String outXMLFileName;
	private IWorkspaceRoot root;
//	private IWorkbenchPart part;
//	private ISelection selection;

	private static String XML_MODEL_PATH;
	private static Resource XML_MODEL_RESOURCE;
	private static String UML_MODEL_PATH;
	private static Resource UML_MODEL_RESOURCE;

	/**
	 * Constructor for Action1.
	 */
	public LaunchTraceAnalysis() {
		super();
	}

	public LaunchTraceAnalysis(final Shell inShell, final IFile inTraceFile, final IWorkspaceRoot inRoot) {
		this.shell = inShell;
		this.traceFile = inTraceFile;
		this.root = inRoot;
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
//		this.part = targetPart;
		this.shell = targetPart.getSite().getShell();
		ISelectionService service = targetPart.getSite().getWorkbenchWindow().getSelectionService();
		this.traceFile = (IFile)((IStructuredSelection)service.getSelection()).getFirstElement();
		this.root = ResourcesPlugin.getWorkspace().getRoot();	
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
//		IPath path = xmlFile.getLocation();

//		ResourceSet resourceSet = new ResourceSetImpl();
//		URI xmlURI = URI.createFileURI(path.toString());
//		Resource inXMLResource = resourceSet.getResource(xmlURI, true);		

		if (!traceFile.getLocation().getFileExtension().equals("txt")) {
			MessageDialog.openError(shell, "The selected file is not a TXT file. To perform monitoring Analysis please select the TXT file containing execution traces. " ,"Monitoring Analysis has failed");
		}
		
		//final LaunchTraceAnalysis mab = new LaunchTraceAnalysis(shell, traceFile, root);
		try {
			this.inXMLFile = handleBrowseFile("Monitoring trace analysis", "Please choose the input XML list of threads");
			this.outXMLFileName = inXMLFile.getName();
			TraceAnalyser ta = new TraceAnalyser(shell, inXMLFile, outXMLFileName, traceFile);
			ta.doTraceAnalysis();
			MessageDialog.openInformation(shell,"Monitoring trace analysis","The analysis has been successfully executed.");
		} catch(Exception exMA){
			System.out.println(exMA.getMessage());
			if(!exMA.getMessage().isEmpty())
				MessageDialog.openError(shell,"Monitoring analysis", exMA.getMessage());	
			else MessageDialog.openError(shell,"Monitoring analysis", "The analysis has not been successfully executed.");
		};
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
	}

	/**
	 * Sets the specified resource as modified and saves it.
	 * @param resource Resource to be marked as dirty and saved.
	 */
	public void saveResource(XtextResource resource, URI uri)
	{	
		// Set the modified flag.
		resource.setModified(true);
		try {
			// Save the resource.
			Map<Object, Object> saveOptions = new HashMap<Object, Object>();
			saveOptions.put(XtextResource.OPTION_RESOLVE_ALL , Boolean.TRUE);
			resource.setURI(uri);
			resource.save(null);//saveOptions);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private IFile handleBrowseFile(String title, String message) {

		ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(new Shell(), new WorkbenchLabelProvider(), new BaseWorkbenchContentProvider());

		dialog.setTitle(title);
		dialog.setMessage(message);
		dialog.setAllowMultiple(false);
		dialog.addFilter(new ViewerFilter() {
			@Override
			public boolean select(Viewer viewer, Object parentElement,
					Object element) {
				boolean ret = false;
				String[] extensions = null;
				extensions = new String[] { "xml" };
				try {
					ret = isXMLResource((IResource) element, extensions);
				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return ret;
			}
		});
		dialog.setInput(root);
		dialog.open();

		if(dialog.getReturnCode() == ElementTreeSelectionDialog.CANCEL){
			return null;
		}

		Object results = dialog.getFirstResult();

		if ((results != null) && (results instanceof IFile)) {
			IFile currentFile = (IFile)results;	
			return currentFile;
		}
		else if ((results != null) && ((results instanceof IFolder) || (results instanceof IProject))) {
			MessageDialog.openError(shell,"Monitoring backpropagation", "The analysis has not been successfully executed. Please select a valid source XML.");
			return null;
		}

		return null;
	}
	
	private static boolean isXMLResource(IResource resource, String[] extensions)
			throws CoreException {
		if (resource instanceof IContainer) {
			if (((IContainer) resource).isAccessible()) {
				IResource[] members = ((IContainer) resource).members();
				for (IResource member : members) {
					if (isXMLResource(member, extensions)) {
						return true;
					}
				}
			}
		} else if (resource instanceof IFile) {
			IFile currentFile = (IFile) resource;
			if (extensions == null) {
				return true;
			} else if (currentFile.getFileExtension() != null) {
				for (int i = 0; i < extensions.length; i++) {
					String extension = extensions[i];
					if (currentFile.getFileExtension().toUpperCase().equals(
							extension.toUpperCase())) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static String getXMLPath(){
		return XML_MODEL_PATH;
	}
	
	public static Resource getXMLResource(){
		return XML_MODEL_RESOURCE;
	}

	public static String getModelPath(){
		return UML_MODEL_PATH;
	}
	
	public static Resource getModelResource(){
		return UML_MODEL_RESOURCE;
	}
}
