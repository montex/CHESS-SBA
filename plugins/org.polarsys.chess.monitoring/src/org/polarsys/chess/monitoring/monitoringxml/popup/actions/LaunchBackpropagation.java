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

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
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
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;
import org.eclipse.m2m.qvt.oml.util.StringBufferLog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.osgi.framework.Bundle;
import org.polarsys.chess.monitoring.monitoringxml.MonitoringxmlPackage;
import org.polarsys.chess.monitoring.monitoringxml.popup.actions.LaunchBackpropagation;
import org.polarsys.chess.monitoring.monitoringxml.util.MonitoringxmlResourceFactoryImpl;

public class LaunchBackpropagation implements IObjectActionDelegate {

	private Shell shell;
	private IFile xmlFile;
	private IFile chessFile;
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
	public LaunchBackpropagation() {
		super();
	}

	public LaunchBackpropagation(final Shell inShell, final IFile inXMLFile, final IFile inCHESSFile, final IWorkspaceRoot inRoot) {
		this.shell = inShell;
		this.xmlFile = inXMLFile;
		this.chessFile = inCHESSFile;
		this.root = inRoot;
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
//		this.part = targetPart;
		this.shell = targetPart.getSite().getShell();
		ISelectionService service = targetPart.getSite().getWorkbenchWindow().getSelectionService();
		this.xmlFile = (IFile)((IStructuredSelection)service.getSelection()).getFirstElement();
		this.root = ResourcesPlugin.getWorkspace().getRoot();	
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {

		if (!xmlFile.getLocation().getFileExtension().equals("xml")) {
			MessageDialog.openError(shell, "The selected file is not XML file. To perform monitoring Analysis and Backpropagation please select the XML file created during the code generation phase. " ,"Monitoring Analysis and Backpropagation has failed");
		}
		
		try {
			chessFile = handleBrowseFile("Monitoring backpropagation from XML", "Please choose the target model");
			this.backpropagateMonitoringMeasures(xmlFile, chessFile);
			MessageDialog.openInformation(shell,"Monitoring backpropagation","The backpropagation has been successfully executed.");
		} catch(Exception exMB){
			if(!exMB.getMessage().isEmpty())
				MessageDialog.openError(shell,"Monitoring backpropagation", exMB.getMessage());	
			else MessageDialog.openError(shell,"Monitoring backpropagation", "The backpropagation has not been successfully executed.");
		};
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
	}

	public void backpropagateMonitoringMeasures(final IFile xmlMonFile, final IFile chessModFile) {
		
		try{
			ProgressMonitorDialog progDialog = new ProgressMonitorDialog(shell);
			progDialog.run(true, true, new IRunnableWithProgress(){ 
		    public void run(IProgressMonitor monitor) {
		 
		        monitor.beginTask("Backpropagating monitored values to the CHESS model ...", 100); 
		        // execute the task ... 
		        if (monitor.isCanceled())
					throw new OperationCanceledException();
		        
		    
		        IPath chessModelPath = chessModFile.getLocation();
		
				//QVTo from MXML to CHESS
				URI transformationURI0 = URI.createURI("platform:/plugin/org.polarsys.chess.monitoring/transforms/MonitoringXML2Chess.qvto");
				// create executor for the given transformation
				TransformationExecutor executor0 = new TransformationExecutor(transformationURI0);
				// define the transformation input (XML model)
				XML_MODEL_PATH = xmlMonFile.getLocation().toString();
				URI xmlURI = URI.createFileURI(XML_MODEL_PATH);
				ExecutionContextImpl context0 = new ExecutionContextImpl();
			    Resource inXMLResource = readMonitoringXML(xmlURI);
				EList<EObject> xmlObj = inXMLResource.getContents();
				XML_MODEL_RESOURCE = inXMLResource;

				// create the input extent with its initial contents for the XML
				ResourceSet resourceSet = new ResourceSetImpl();
				ModelExtent xmlMM = new BasicModelExtent(xmlObj);		

				// define the transformation input/output (Chess model)
				UML_MODEL_PATH = chessModelPath.toString();
				URI chessURI = URI.createFileURI(UML_MODEL_PATH);
				//ExecutionContextImpl context0 = new ExecutionContextImpl();
				Resource inChessResource = resourceSet.getResource(chessURI, true);		
				EList<EObject> chessObj = inChessResource.getContents();
				
				UML_MODEL_RESOURCE = inChessResource;

				// create the input extent with its initial contents for the Chess model
				ModelExtent chessMM = new BasicModelExtent(chessObj);		

				// setup the execution environment details -> 
				// configuration properties, logger, monitor object etc.
				StringBufferLog log = new StringBufferLog(); 
				context0.setLog(log);
				//context0.setConfigProperty("propertyName", true);
				
				// run the transformation assigned to the executor with the given 
				// input and output and execution context -> ChangeTheWorld(in, out)
				// Remark: variable arguments count is supported
				ExecutionDiagnostic result0 = executor0.execute(context0, xmlMM, chessMM);

				// check the result for success
				System.out.println(result0.getSeverity()+" "+result0.getCode()+" "+result0.getMessage());
				if(result0.getSeverity() == Diagnostic.OK) {
					System.out.println("OK!!");
					System.out.println(log.getContents());
					try{
						inXMLResource.save(Collections.emptyMap());
					}catch(Exception ex){ 
						System.out.println(ex.getMessage());
					}
					try{
						inChessResource.save(Collections.emptyMap());
					}catch(Exception ex){ 
						System.out.println(ex.getMessage());
					}
				}else{
					System.out.print("ERROR!!");
					throw new OperationCanceledException(result0.getMessage());
				}
	
				if(monitor.isCanceled())
					throw new OperationCanceledException();
				
        monitor.worked(100);
        monitor.done(); 
        
        }});
			chessFile.getProject().refreshLocal(IResource.DEPTH_INFINITE, null);
	}catch(Exception ex){//throw new OperationCanceledException("Operation aborted by the user.");};}
		throw new OperationCanceledException(ex.getMessage());
	}
//
	}

	protected Resource readMonitoringXML(URI uri) {
		// Initialize the model
	    MonitoringxmlPackage.eINSTANCE.eClass();
	    
	    // Register the resource factory for the .xml extension
	    Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
	    Map<String, Object> m = reg.getExtensionToFactoryMap();
	    m.put("xml", new MonitoringxmlResourceFactoryImpl());

	    // Obtain a new resource set
	    ResourceSet resSet = new ResourceSetImpl();

	    // Get the resource
	    Resource resource = resSet.getResource(uri, true);
	    return resource;
	}
	
	public IPath getAbsoluteWorkflowPath(String relPath, String bundlename) {
		Bundle bundle = Platform.getBundle(bundlename);
		URL fileLocation = null;
		try {
			fileLocation = FileLocator.toFileURL(bundle.getEntry(relPath));

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		IPath p = new Path(new File(fileLocation.getFile()).getAbsolutePath());
		return p;

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
				extensions = new String[] { "uml" };
				try {
					ret = isUMLResource((IResource) element, extensions);
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
			MessageDialog.openError(shell,"Monitoring backpropagation", "The analysis has not been successfully executed. Please select a valid target model.");
			return null;
		}

		return null;
	}
	
	private static boolean isUMLResource(IResource resource, String[] extensions)
			throws CoreException {
		if (resource instanceof IContainer) {
			if (((IContainer) resource).isAccessible()) {
				IResource[] members = ((IContainer) resource).members();
				for (IResource member : members) {
					if (isUMLResource(member, extensions)) {
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
